'''
Created on Jan 28, 2015

@author: Graham
'''
import unittest
from LinkedList import LinkedList
from Dog import Dog

class Test(unittest.TestCase):

    def testAddToFront(self):
        llist = LinkedList()
        llist.addToFront(Dog('Poodle'))
        llist.addToFront(Dog('Chihuaha'))
        llist.addToFront(Dog('Golden'))
        llist.printList()
        self.assertEqual(llist.getSize(), 3)
    
    def testAddToBack(self):
        llist = LinkedList()
        llist.addToBack(Dog('Poodle'))
        llist.addToBack(Dog('Chihuaha'))
        llist.addToBack(Dog('Golden'))
        self.assertEqual(llist.getSize(), 3)
        

if __name__ == "__main__":
    #import sys;sys.argv = ['', 'Test.testName']
    unittest.main()