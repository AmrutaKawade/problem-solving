package util.tree;

public class MinHeap {
	int capacity;
	int size;
	int[] items = null;
	public MinHeap(int capacity){
		this.capacity = capacity;
		this.items = new int[capacity];
	}
	public int getLeftChildIndex(int index){
		return 2*index+1;
	}
	public int getRightChildIndex(int index){
		return 2*index+2;
	}
	public int getParentIndex(int index){
		return (index-1)/2;
	}
	public boolean hasLeftChild(int index){
		return getLeftChildIndex(index) <= size;
	}
	public boolean hasRightChild(int index){
		return getRightChildIndex(index) <= size;
	}
	public boolean hasParent(int index){
		return getParentIndex(index) >= 0; 
	}
	public void swap(int i,int j){
		int temp = items[i];
		items[i] = items[j];
		items[j] = temp;
	}
	//Returns first element
	public int peek(){
		return items[0];
	}
	//Return and remove first element
	public int poll(){
		int item = items[0];
		items[0] = items[size-1];
		heapifyDown(0);
		size--;
		return item;
	}
	//Insert elements in array
	public void add(int item){
		if(size < capacity){
			items[size] = item;
			size++;
			heapifyUp(size-1);
		}
	}
	//Remove element from array
	public void remove(int index){
		//assign min value to that item
		items[index] = Integer.MIN_VALUE;
		heapifyUp(index);
		poll();
	}
	
	public void heapifyDown(int index){
		//get index of smaller of both the childs
		if(index >= size){
			return;
		}
		if(hasLeftChild(index)){
			int smallerChildIndex = getLeftChildIndex(index);
			if(hasRightChild(index) && items[smallerChildIndex] > items[getRightChildIndex(index)]){
				smallerChildIndex = getRightChildIndex(index);
			}	
			if(items[index] > items[smallerChildIndex]){
				swap(index,smallerChildIndex);
				heapifyDown(smallerChildIndex);
			}
		}
	}
	
	public void heapifyUp(int index){
		while(hasParent(index) && items[getParentIndex(index)] > items[index]){
			swap(index,getParentIndex(index));
			index = getParentIndex(index);
		}
	}
	public void printArray()
    {
        for (int i=0; i<size; ++i)
            System.out.print(items[i]+" ");
        System.out.println();
    }
	public static void main(String[] args) {
		MinHeap h = new MinHeap(10);
		h.add(12);
		h.add(11);
		h.add(13);
		h.add(5);
		h.add(6);
		h.add(7);
		h.printArray();
	}
}
