interface IHeap {
// adds given element to the heap without removing other elements
  IHeap addElt(int e);
  // removes one occurrence of the smallest element from the heap
  IHeap remMinElt();
  // returns the size of the heap
  int size();
}