package com.potter.java.sample.structure;

public class Queue {

	Node first = null, last = null;
	
	public Node pop(){
		Node result;
		if(first == null){
			return null;
		}
		if(first.equals(last)){
			result = first;
			first = null;
			last = null;
			return result;
		}
		result = first;
		first = first.next;
		return result;
	}
	
	public void push(Node n){
		if(first == null && last == null){
			first = n;
			last = n;
			return;
		}
		last.next = n;
		last = n;
	}
	
	public Queue(){}
	
	public static void main(String[] args){
		Queue q = new Queue();
		q.push(new Node("blah1"));
		q.push(new Node("blah2"));
		q.push(new Node("blah3"));
		System.out.println(q.pop().value);
		System.out.println(q.pop().value);
		System.out.println(q.pop().value);
	}
}
