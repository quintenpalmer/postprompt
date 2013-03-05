from django.db import models

# Create your models here.
class Games(models.Model):
	game_id = models.IntegerField(primary_key=True,unique=True)
	game_xml = models.CharField(max_length=10000)

class Starting_Cards(models.Model):
	card_name = models.ForeignKey('Card_Names')

class Card_Names(models.Model):
	card_name = models.CharField(max_length=64)
	card_effect = models.CharField(max_length=64)

class Cards(models.Model):
	card_name = models.ForeignKey('Card_Names')
	uid = models.IntegerField()

class Decks(models.Model):
	uid = models.IntegerField()
	deck_id = models.IntegerField()
	card_ids = models.CharField(max_length=400)

	class Meta:
		unique_together = ('uid','deck_id')
