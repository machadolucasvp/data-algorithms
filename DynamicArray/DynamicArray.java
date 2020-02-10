package DynamicArray;

public class DynamicArray<T>{
    private Object[] staticArray;
    private int size;

    public DynamicArray(){
        this.staticArray = new Object[1];
        this.size=0;
    }

    public Object[] getStaticArray(){
        return this.staticArray;
    }

    @SuppressWarnings("unchecked")
    public T get(int index){
        if(size>=index+1){
            return (T)staticArray[index];
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void set(int index,T object){
        if(size>=index+1){
            staticArray[index]=object;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void add(T object){
        if(size>=staticArray.length){
            int boundarySize=2*staticArray.length;
            Object[] newArray = new Object[boundarySize];
            for(int i=0;i<staticArray.length;i++){
                newArray[i]=staticArray[i];
            }
            newArray[staticArray.length]=object;
            staticArray=newArray;
            size++;
        }else {
            staticArray[size]=object;
            size++;
        }
    }

    public int indexOf(T object){
        for(int i=0;i<size;i++){
            if(object.equals(staticArray[i])){
                return i;
            } 
        }
        return -1;
    }

    public void remove(T object){
        int index=indexOf(object);
        if(index!=-1){
            staticArray[index]=null;
            size--;
        }
    }

    public void removeAt(int index){
        if(size>=index+1){
            staticArray[index]=null;
            size--;
        }
    }

    public int length(){
        return this.size;
    }
    public boolean isEmpty(){
        return length()==0;
    }
}

class Test {
    public static void main(String[] args) {
        DynamicArray<Integer> array = new DynamicArray<Integer>();
        array.add(1);
        array.add(2);
        //array.add(3);
        //array.add(4);
        //array.add(5);
        System.out.println(array.length());
        System.out.println(array.get(0));
        System.out.println(array.getStaticArray().length);
 
    }
}