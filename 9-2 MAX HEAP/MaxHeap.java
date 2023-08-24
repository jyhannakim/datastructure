//import java.util.ArrayList;

public class MaxHeap {
    int[] elements;
    int n; // 현재 삽입된 원소의 수
    
    public MaxHeap(int size) {
        this.elements = new int[size+1];
        this.n = 0;
    }
    
    public boolean isFull() {
        if(n == elements.length -1) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isEmpty() {
        if(n > 0) {
            return false;
        } else {
            return true;
        }
    }
    
    public int size() {
        // 저장한 원소의 개수
        return this.n;
    }
    
    public int capacity() {
        // 저장할 수 있는 원소의 개수
        return this.elements.length - 1;
    }
    
    public boolean insert(int data) {
        if( this.isFull() ) {
            return false; 
        }                
        this.n++;
        int i = this.n;
        while(i > 1 && data > this.elements[i/2]) {
            this.elements[i] = this.elements[i/2];
            i = i/2;
        }
        this.elements[i] = data;
        
        return true;
    }
    
    public int remove() {
        if( this.isEmpty() ) {
            throw new RuntimeException("데이터가 없습니다.");
        }
        // 구현하기
        int item = this.elements[1]; // save the root element
        int temp = this.elements[this.n]; // save the last element
        this.n--;

    int parentIdx = 1;
    int childIdx = 2; 

    while(childIdx <= this.n) {
        // find the larger child of the current parent
        if(childIdx < this.n && this.elements[childIdx] < this.elements[childIdx+1]) {
            childIdx++;
        }

        if(temp >= this.elements[childIdx]) {
            break;
        }

        // move the parent to the next lower level
        this.elements[parentIdx] = this.elements[childIdx];
        parentIdx = childIdx;
        childIdx *= 2;
    }
    this.elements[parentIdx] = temp;
    return item;
    }
    
    public void preOrder(int i) { //VLR
        if (i > n) {
            return;
        }
        System.out.print(elements[i] + " ");
        preOrder(2 * i);       // left child
        preOrder(2 * i + 1);   // right child
    }
    
    public void inOrder(int i) { //LVR
        // IN-ORDER 출력 구현하기
        // 한 줄(행)에 출력한다.
        // 값과 값은 공백으로 구분한다.
        if (i > n) {
            return;
        }
        inOrder(2 * i);       // left child
        System.out.print(elements[i] + " ");
        inOrder(2 * i + 1);   // right child
    }
    
    public void postOrder(int i) { //LRV
        // POST-ORDER 출력 구현하기
        // 한 줄(행)에 출력한다.
        // 값과 값은 공백으로 구분한다.
        if (i > n) {
            return;
        }
        postOrder(2 * i);       // left child
        postOrder(2 * i + 1);   // right child
        System.out.print(elements[i] + " ");
    }
}