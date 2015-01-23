#include <stdlib.h>
#include <stdio.h>
#include "list.h"

int main(){
	
	printf("Add Testing");
}

/**
 * pushFront
 * Takes in ptr to a list and data to add
 * Should add new node containing the data to the head of the list, and increment size
 */
void pushFront(LIST *list, int data)
{
	NODE *temp = (NODE *) malloc(sizeof(NODE));
	if (temp == NULL) {
		return;
	}
	temp->data = data;
	/* If the list is empty, make the head and tail that value */
	if (list->head == NULL) {
		list->head = temp;
		list->tail = temp;
	} else if (list->head == list->tail) {
		/* There is 1 element in the list */
		temp->next = list->tail;
		list->head = temp;
	} else {
		/* There are more than 1 elements in the list */
		temp->next = list->head;
		list->head = temp;
	}

	list->size++;
	
	
}

/**
 * pushFront
 * Takes in ptr to a list and data to add
 * Should add new node containing the data to the tail of the list, and increment size
 */
void pushBack(LIST *list, int data)
{
	NODE *temp = (NODE *) malloc(sizeof(NODE));
	if (temp == NULL) {
		return;
	}
	temp->data = data;
	/* 3 cases; list is empty, list has 1 element, list has more than 1 element */
	if (list->head == NULL) {
		list->head = temp;
		list->tail = temp;
	} else if (list->head == list->tail) {
		temp->next = NULL;
		list->head->next = temp;
		list->tail = temp;
	} else {
		temp->next = NULL;
		list->tail->next = temp;
		list->tail = temp;
	}
	list->size++;
}

/**
 * popFront
 * Takes in ptr to a list
 * Remove and free node at the front of the list, and decrement size
 * Return the value of that node
 * Return 0 if the size of the list is 0
 */
int popFront(LIST *list)
{
	int data = 0;
	if (list->head == NULL) {
		return 0;
	} else if (list->head == list->tail) {
		/* Case where there is 1 element in the list */
		NODE *toRemove = list->head;
		list->head = NULL;
		list->tail = NULL;
		data = toRemove->data;
		free(toRemove);
		list->size--;
		return data;
	} else {
		/* More than 1 element in the list */
		NODE *toRemove = list->head;
		list->head = list->head->next;
		data = toRemove->data;
		free(toRemove);
		list->size--;
		return data;
	}
}

/**
 * popBack
 * Takes in ptr to a list
 * Remove and free node at the back of the list, and decrement size
 * Return the value of that node
 * Return 0 if the size of the list is 0
 */
int popBack(LIST *list)
{
	int data = 0;
	if (list->head == NULL) {
		return 0;
	} else if (list->head == list->tail) {
		/*Case where there is only 1 element */
		NODE *toRemove = list->head;
		list->head = NULL;
		list->tail = NULL;
		data = toRemove->data;
		free(toRemove);
		list->size--;
		return data;
	} else {
		/* There is more than 1 element in the list */
		NODE *old = NULL;
		NODE *current = list->head;
		/* Keep traversing through the list */
		while (current != list->tail) {
			old = current;
			current = current->next;
		}
		list->tail = old;
		old->next = NULL;
		data = current->data;
		free(current);
		list->size--;
		return data;
	}
}

/**
 * get
 * Gets the value at the index
 * Return the value of that node
 * Return -1000 if the index is invalid
 */
int list_get(LIST* llist, int index)
{
	/* Start at the head of the list */
	NODE *current = llist->head;
	if (current == NULL || index < 0)
	{
		return -1000;
	}
	/* Loop through the list for however many index times */
	while (index > 0)
	{
		current = current->next;
		index--;
		/* If the index > size, return NULL */
		if (current == NULL)
		{
			return -1000;
		}
	}
	return current->data;
}

/**
 * Prints the list
 */
void printLinkedList(LIST *list) {
	NODE *current = list->head;
	while (current != NULL) {
		//printf("%d -> ", current->data);
		current = current->next;
	}
	//printf("NULL\n");	
}

