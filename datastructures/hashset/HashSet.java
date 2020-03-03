package datastructures.hashset;

@SuppressWarnings("unchecked")
public class HashSet<Key,Value>{
    private Bucket<Key,Value>[] buckets;
    private int capacity,size;

    private class Bucket<K,V>{
        private Bucket<K,V> next;
        private K key;
        private V data;
        public Bucket(V data){
            this.data=data;
        }
    }
    
    public HashSet(){
        this.size=0;
        this.capacity=0;
    }

    public HashSet(int capacity){
        this.buckets= (Bucket<Key,Value>[]) new Bucket[capacity];
        this.capacity=capacity;
    }

    private int mapIndex(int hashcode){
        return (hashcode % 0x7FFFFFFF) % capacity;
    }

    public boolean insert(Key key,Value value){
        if(key==null){
            throw new IllegalArgumentException("Can't insert null key");
        }
        int index = mapIndex(key.hashCode());
        Bucket<Key,Value> currentBucket = buckets[index];
        while(currentBucket!=null){
            if(currentBucket.key.equals(key)){
                return false;
            }
            currentBucket=currentBucket.next;
        }
        Bucket<Key,Value> bucket =(Bucket<Key,Value>) new Bucket(value);
        bucket.key=key;
        bucket.next=buckets[index];
        buckets[index]=bucket;
        size++;
        return true;
    }

    public boolean contains(Key key){
        int index = mapIndex(key.hashCode());
        Bucket<Key,Value> currentBucket = buckets[index];
        while(currentBucket!=null){
            if(currentBucket.key.equals(key)){
                return true;
            }
            currentBucket=currentBucket.next;
        }
        return false;
    }

}