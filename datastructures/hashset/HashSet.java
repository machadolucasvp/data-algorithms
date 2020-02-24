package datastructures;

public class HashSet<E,T>{
    private Bucket[] buckets;
    private int size;

    private class Bucket{
        private Bucket next;
        private E key;
        private T data;
        public Bucket(T data){
            this.data=data;
        }
    }
    
    public HashSet(){
        this.size=0;
    }

    public HashSet(int capacity){
        this.buckets= new Bucket[capacity];
    }

    private mapIndex(int hashcode){
        return (hashCode % 0x7FFFFFFF) % capacity;
    }

    public boolean insert(E key,T data){
        if(key==null){
            throw new IllegalArgumentException("Can't insert null key");
        }
        int index = mapIndex(key.hashCode());
        Bucket currentBucket = buckets[index];
        while(currentBucket!=null){
            if(currentBucket.key.equals(key)){
                return false;
            }
            currentBucket=currentBucket.next;
        }
        Bucket bucket = new Bucket(data);
        bucket.key=key;
        bucket.next=buckets[index];
        buckets[index]=bucket;
        size++;
        return true;
    }

    public boolean contains(E key){
        int index = mapIndex(key.hashCode());
        Bucket currentBucket = buckets[index];
        while(currentBucket!=null){
            if(currentBucket.key.equals(key)){
                return true;
            }
            currentBucket=currentBucket.next;
        }
        return false;
    }

}