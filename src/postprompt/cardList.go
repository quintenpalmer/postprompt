package postprompt

type subCL []*Card

type CardList struct {
	cards subCL
}

func EmptyCardList() *CardList {
	cardList := new(CardList)
	cardList.cards = make(subCL,0)
	return cardList
}

func NewCardList(cardIds []int) (*CardList, error) {
	cardList := new(CardList)
	cardList.cards = make([]*Card,len(cardIds))
	for i, cardId := range cardIds {
		card, err := NewCard(cardId)
		if err != nil { return nil, err }
		cardList.cards[i] = card
	}
	return cardList, nil
}

func (cardList *CardList) push(card *Card, index int) error {
	cardList.cards = append(cardList.cards, card)
	return nil
}

func (cardList *CardList) pop(index int) (*Card, error) {
	if index == -1 { index = len(cardList.cards) - 1 }
	if index >= len(cardList.cards) {
		return nil, Newpperror("index out of range")
	}
	card := cardList.cards[index]
	cardList.cards = append(cardList.cards[:index], cardList.cards[index+1:]...)
	return card, nil
}
