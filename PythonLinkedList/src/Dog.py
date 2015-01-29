'''
Created on Jan 28, 2015

@author: Graham
'''

class Dog(object):
    '''
    classdocs
    '''


    def __init__(self, name):
        '''
        Constructor
        '''
        self.name = name
    
    def __str__(self):
        return self.name
    
    def __eq__(self, other):
        return isinstance(other, Dog) and other.name == self.name