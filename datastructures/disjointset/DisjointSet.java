package datastructures.disjointset;

public class DisjointSet{
    private int[] idArray;
    private int[] sizeOfComponent;
    private int size;
    private int numComponents;

    
    public DisjointSet(int size){
        this.idArray = new int[size];
        this.sizeOfComponent=new int[size];
        this.size=size;
        this.numComponents=size;
        for(int i=0;i<size;i++){
            idArray[i]=i;
            sizeOfComponent[i]=1;
        }
    }

    public int find(int item){
        if(item>=size){
            throw new ArrayIndexOutOfBoundsException();
        }
        if(idArray[item]==item){
            return item;
        }
        return idArray[item]=find(idArray[item]);
    }

    public boolean inside(int item1,int item2){
        if(item1>=size || item2>=size){
            return false;
        }
        return find(item1)==find(item2);
    }

    public void union(int item1,int item2){
        int parent1=find(item1);
        int parent2=find(item2);

        idArray[parent2]=parent1;

        sizeOfComponent[parent1]+=sizeOfComponent[parent2];

        numComponents--;
    }

    public int componentSize(int item){
        return sizeOfComponent[find(item)];
    }

    public int getNumComponents(){
        return this.numComponents;
    }
    
    public int getSize(){
        return this.size;
    }
    
}