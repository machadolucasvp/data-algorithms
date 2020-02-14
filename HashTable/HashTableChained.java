package HashTable;

import java.util.LinkedList;

public class HashTableChained<T, E> {

    private LinkedList<Entry<T,E>>[] table;

    private static final int DEFAULT_CAP = 10;
    private static final double DEFAULT_MAX_LOADFACTOR = 0.65;

    private double maxLoadFactor;
    private int capacity,size=0;

    public HashTableChained(int capacity,double maxLoadFactor){
        this.capacity=Math.max(capacity,this.DEFAULT_CAP);
        if(maxLoadFactor>1 || maxLoadFactor <0){
            throw new IllegalArgumentException("Maximum Load Factor needs be in (0,1] interval");
        } else {
            this.maxLoadFactor=maxLoadFactor;
        }
    }
    public HashTableChained(){
        this.capacity=DEFAULT_CAP;
        this.maxLoadFactor=DEFAULT_MAX_LOADFACTOR;
    }

    private class Entry<T,E>{
        int hash;
        T key;
        E value;
        public Entry(T key,E value){
            this.key=key;
            this.value=value;
            this.hash=key.hashCode();
        }
        public boolean equals(Entry<T,E> object){
            if(hash!=object.hash){
                return false;
            }else{
                return key.equals(object.key);
            }
        }
        public String toString(){
            return key+": "+value;
        }
    }

    private int mapIndex(int hashCode){
        return (hashCode % 0x7FFFFFFF) % capacity;
    }

    public E insert(T key,E value){
        if(key==null){
            throw new IllegalArgumentException("Can't insert null key");
        }
        //Can slow down here, depends in hash implementation of T type.
        Entry<T,E> newEntry = new Entry<T,E>(key,value);

        int index =mapIndex(newEntry.hash);
        LinkedList<Entry<T,E>> tableEntry = table[index]; 
        if (tableEntry==null){
            table[index]=new LinkedList<Entry<T,E>>();
            table[index].add(newEntry);
            size++;
            return null;
        } else{ // Collisions!
            Entry<T,E> existentEntry = seekEntry(index,newEntry.key);
            if(existentEntry==null){
                table[index].add(existentEntry);
                return null;
            }else{
                E oldObject = existentEntry.value;
                existentEntry.value=newEntry.value;
                return oldObject;
            }     
        }
    
    }

    public Entry<T,E> seekEntry(int index,T key){
        if(key==null){
            return null;
        }
        LinkedList<Entry<T,E>> chain = table[index];
        if(chain==null){
            return null;
        }
        //Linear search O(n) in worst case.
        for(Entry<T,E> entry : chain){
            if(entry.key.equals(key)){
                return entry;
            }
        }
        return null;
    }

    public E get(T key){
        if(key==null){
            throw new IllegalArgumentException("Can't search for a null key");
        }
        Entry<T,E> entry = seekEntry(mapIndex(key.hashCode()), key);
        if(entry!=null){
            return entry.value;
        } else{
            return null;
        }
    }

    public E remove(T key){
        if(key==null){
            throw new IllegalArgumentException("Null key, such object doesn't exists");
        }
        return removeWithIndex(mapIndex(key.hashCode()), key);
    }

    public E removeWithIndex(int index,T key){
        Entry<T,E> entry = seekEntry(index, key);
        if(entry==null){
            return null;
        }else{
            LinkedList<Entry<T, E>> chain = table[index];
            chain.remove(entry);
            size--;
            return entry.value;
        }
    }

}