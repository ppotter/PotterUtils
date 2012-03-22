package com.potter.java.sample.structure;

public class LinkedList {

	public Node head = null;
	
	public void appendNodeToHead(Node newNode){
		if(head == null){
			head = newNode;
		}else{
			newNode.next = head.next;
			head.next = newNode;
		}
	}
	
	public void appendNodeToTail(Node newNode){
		if(head == null){
			head = newNode;
		}else{
			Node n = head;
			while(n.next != null){n = n.next;}
			n.next = newNode;
		}
	}
	
	public void deleteNode(Node removeNode){
		if(head != null){
			Node n = head;
			if(n.value.equals(removeNode.value)){
				head = n.next;
				return;
			}
			do{
				if(n.next.value.equals(removeNode.value)){
					n.next = n.next.next;
					return;
				}
				n = n.next;
			}while(n.next != null);
		}
	}
	
	public void deleteNodes(Node removeNode){
		if(head != null){
			Node n = head;
			if(n.value.equals(removeNode.value)){
				head = n.next;
			}
			do{
				if(n.next.value.equals(removeNode.value)){
					n.next = n.next.next;
				}
				n = n.next;
			}while(n.next != null);
		}
	}
	
}
