'''
Created on Jan 22, 2015

@author: Graham
'''

class Node:
    
    
    
    def __init__(self, data):
        '''
        Constructor
        '''
        self.next = None
        self.prev = None
        self.data = data

class LinkedList(object):
    '''
    classdocs
    '''


    def __init__(self):
        '''
        Constructor
        '''
        self.size = 0
        self.head = None
        