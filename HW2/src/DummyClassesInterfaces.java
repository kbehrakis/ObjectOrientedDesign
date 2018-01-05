// Dummy file for compiling homework 2

interface IQueue {
  IQueue enqueue(int elt);
  IQueue dequeue();
  int front();
  boolean isEmpty();
}

class Queue implements IQueue {
  Queue(){}
  public IQueue enqueue(int elt) { return this; }
  public IQueue dequeue() { return this; }
  public int front() { return 0; }
  public boolean isEmpty() {return true; }
}

interface IStack {
  IStack push(int elt);
  IStack pop();
  int top();
  boolean isEmpty();
}

class Stack implements IStack {
  Stack(){}
  public IStack push(int elt) {return this;}
  public IStack pop() {return this;}
  public int top() {return 0;}
  public boolean isEmpty() {return true; }
}

interface IPriorityQueue {
  IPriorityQueue addElt(int elt);
  IPriorityQueue remMinElt();
  int getMinElt();
  boolean isEmpty();
}

class PriorityQueue implements IPriorityQueue {
  PriorityQueue(){}
  public IPriorityQueue addElt(int elt) {return this;}
  public IPriorityQueue remMinElt() {return this;}
  public int getMinElt() {return 0;}
  public boolean isEmpty() {return true; }
}