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
        
    def clear(self):
        self.head = None
        self.size = 0
    
    def getSize(self):
        return self.size
    
    def addToBack(self, data):
        toAdd = Node(data)
        if (self.head == None):
            self.head = toAdd
        else:
            current = self.head
            while (current.next != None):
                current = current.next
            current.next = toAdd
            toAdd.prev = current
        self.size = self.size + 1
    
    def addToFront(self, data):
        oldHead = self.head
        self.head = Node(data)
        self.head.next = oldHead
        if (oldHead != None):
            oldHead.prev = self.head
        self.size = self.size + 1
        
    def remove(self, data):
        toReturn = None
        if (self.head == None):
            return None
        if (data == self.head.data):
            toReturn = self.head.data
            self.head = self.head.next
            if (self.head != None):
                self.head.prev = None
        else:
            current = self.head
            while (current != None and current.data != data):
                current = current.next
            if (current != None):
                toReturn = current
                before = current.prev
                after = current.next
                before.next = after
                if (after != None):
                    after.prev = before
        self.size = self.size - 1
        return toReturn
    
    def printList(self):
        current = self.head
        index = 0
        print 'Size: ' + str(self.size)
        while (current != None):
            print str(index) + '. ' + str(current.data)
            index = index + 1
            current = current.next
            
llist = LinkedList()
llist.addToBack('Java')
llist.addToBack('C')
llist.addToFront('C++')
llist.addToFront('Assembly')
llist.addToFront('Javascript')
llist.printList()