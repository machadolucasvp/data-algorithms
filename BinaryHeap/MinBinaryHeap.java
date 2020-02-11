package BinaryHeap;

import java.util.ArrayList;

public class MinBinaryHeap {
    private ArrayList<Integer> array = new ArrayList<Integer>();

    private int getLeftChildIndex(int parentIndex){
        return 2*parentIndex+1;
    }

    private int getRightChildIndex(int parentIndex){
        return 2*parentIndex+2;
    }

    private int getParentIndex(int childIndex){
        return (childIndex-1)/2;
    }

    private boolean hasParent(int index){
        return index>0;
    }

    private boolean hasLeftChild(int index){
        return getLeftChildIndex(index)<array.size();
    }

    private boolean hasRightChild(int index){
        return getRightChildIndex(index)<array.size();
    }

    private void swap(int indexOne,int indexTwo){
        Integer dataOne = array.get(indexOne);
        array.set(indexOne, array.get(indexTwo));
        array.set(indexTwo, dataOne);
    }

    public int peek(){
        if(array.size()!=0){
            return array.get(0);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public int poll(){
        if(array.size()!=0){
            Integer firstData = array.get(0);
            array.set(0,array.get(array.size()-1));
            array.remove(array.size()-1);
            bubbleDown();
            return firstData;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void add(int newData){
        array.add(newData);
        bubbleUp();
    }

    public void bubbleDown(){
        int index = 0;
        while(hasLeftChild(index)){
            int smallerChildIndex=getLeftChildIndex(index);
            if(hasRightChild(index) && array.get(getRightChildIndex(index)) < array.get(getLeftChildIndex(index))){
                smallerChildIndex=getRightChildIndex(index);
            }
            if(array.get(index)<array.get(smallerChildIndex)){
                break;
            } else {
                swap(index,smallerChildIndex);
            }
            index=smallerChildIndex;
        }

    }

    public void bubbleUp(){
        int index = array.size()-1;
        while(hasParent(index) &&
         array.get(getParentIndex(index)) > array.get(index)){

             swap(getParentIndex(index),index);
             index--;

        }

    }
    
}