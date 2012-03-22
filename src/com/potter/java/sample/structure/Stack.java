package com.potter.java.sample.structure;

public class Stack {
	Node top = null;
	
	public Node pop(){
		if(top == null){
			return null;
		}
		Node temp = top;
		top = top.next;
		return temp;
	}
	
	public void push(Node n){
		n.next = top;
		top = n;
	}
	
	public Stack(){}
	
	public static void main(String[] args){
		Stack s = new Stack();
		s.push(new Node("blah1"));
		s.push(new Node("blah2"));
		s.push(new Node("blah3"));
		System.out.println(s.pop().value);
		System.out.println(s.pop().value);
		System.out.println(s.pop().value);
	}
}
