//
//  main.cpp
//  LinkedList
//
//  Created by Manuel Escrig on 1/12/13.
//  Copyright (c) 2013 __MyCompanyName__. All rights reserved.
//

#include <iostream>
using namespace std;

class Node{
public:
    int data;
	Node * next;
	Node(int x){
		data = x;
		next = NULL;
    }
	Node(int x, Node * y){
		data = x; 
		next = y;
    }
};


class linkedList{
    Node *head;
public:
	linkedList(){
		head = NULL;
    }
	void addNode(int value){
		Node *p;
		if(head == NULL)
			head = new Node (value, NULL);
		else{
			p=head;
			while(p->next !=NULL)
				p=p->next;
			p->next = new Node (value, NULL);
        }
    }
	void print(){
		Node * p;
		p = head;
		while(p != NULL){
			cout << p->data << "\n";
			p = p->next;
        }
    }
        
    // 10) How do you find middle element of a linked list in single pass?
    void findMiddleElement() {   
        
        Node *middle, *current; 
        int n; 
        
        middle = head; 
        current = head; 
        n= 1; 
        
        while ((current = current->next)!=NULL) { 
            ++n; 
            if (n%2==1) middle= middle->next; 
        } 
        cout << "Midle element: "<< middle->data << endl; 
    }
    
    // 11) How do you find 3rd element from last in single pass?
    void findThirldElement() {   
      	Node * p;
		Node * temp;
        p = head;
        temp= head;
        
        int n= 0;
		while(p != NULL){
			p = p->next;
            n++;
            if (n>=4) {
                temp= temp->next;
            }
        }
        cout << "Third element from last: "<< temp->data << endl; 
    }
    
    // 12) How do you find if there is any loop in singly linked list? How do you find the start of the loop?
    bool hasLoop(){
        Node *slowNode = head;
        Node *fastNode1 = head;
        Node *fastNode2 = head;
        
        while (slowNode && (fastNode1 = fastNode2->next) !=NULL && (fastNode2 = fastNode1->next) !=NULL){
            if (slowNode == fastNode1 || slowNode == fastNode2) return true;
            slowNode = slowNode->next;
        }
        return false;
    }
    
    // 13) How do you reverse a singly linked list?
    void reverse() {        
        if(head == NULL) return;
        
        Node *prev = NULL, *current = NULL, *next = NULL;
        current = head;
        while(current != NULL){
            next = current->next;
            current->next = prev;
            prev = current;
            current = next;
        }
        // now let the head point at the last node (prev)
        head = prev;
    }
        
};


int main (int argc, const char * argv[])
{

    linkedList list;
    list.addNode(5);
    list.addNode(8);
    list.addNode(3);
    list.addNode(9);
    list.addNode(2);
    list.addNode(1);
    list.addNode(6);
    list.print();
    
    // 10) How do you find middle element of a linked list in single pass?
    list.findMiddleElement();
    
    // 11) How do you find 3rd element from last in single pass?
    list.findThirldElement();  
    
    // 12) How do you find if there is any loop in singly linked list? How do you find the start of the loop?
    if (list.hasLoop() == true)
        cout << "Loop? "<< "True" << endl;
    else 
        cout << "Loop? "<< "False" << endl;
    
    
    // 13) How do you reverse a singly linked list?
    list.reverse();
    list.print();
    
    return 0;
}
