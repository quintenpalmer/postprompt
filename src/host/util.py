import logging
import logging.config

import os

logger = None
def make_logger():
	global logger
	path = os.path.join(os.environ['pyp'],'etc','pyphost_logger.conf')
	logging.config.fileConfig(path)
	logger = logging.getLogger('pypBasic')

def clear_saves():
	base_dir = os.path.join(os.environ['pyp'],'data','games')
	paths = os.listdir(base_dir)
	print paths
	for path in paths:
		if path.split('.')[1] == 'save':
			os.remove(os.path.join(base_dir,path))
	print os.listdir(base_dir)
