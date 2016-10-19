package polyu.comp.datastructure;

import java.util.ArrayList;

/**
 * Created by huanganna on 10/13/16.
 */
public class VariableArray {

    private int[][] catalogArray;
    private int catalogSize;
    private int actualSize;

    public VariableArray(int n){
        catalogSize = calculateCatalogSize(n);
        catalogArray = new int[catalogSize][];
        actualSize = 0;

    }

    //O(1)
    public int[] calculateCoordinate(int index,int size){
        int i = index/size;
        int j = index%size;
        return new int[]{i,j};
    }

    //O(1)
    public int get(int i){
        if(i < 0 || i >= actualSize){
            System.out.println("out of range");
            return 0;
        }
        int[] coordinate = calculateCoordinate(i,catalogSize);
        return catalogArray[coordinate[0]][coordinate[1]];
    }

    //O(1)
    public boolean set(int value,int i){
        if(i < 0 || i >= actualSize){
            System.out.println("out of range");
            return false;
        }
        int[] coordinate = calculateCoordinate(i,catalogSize);
        catalogArray[coordinate[0]][coordinate[1]] = value;
        return true;
    }

    public String toString(){
        String result = "";
        for(int i=0;i<actualSize;i++){
            result = result + get(i);
            if(i!=actualSize-1)
                result+= ",";
        }
        return result;
    }

    //O(n)
    public void add(int value,int i){
        if(i<0 || i>actualSize){
            System.out.println("Out of range");
            return;
        }
        int[] coordinate;
        if(actualSize>=Math.pow(catalogSize,2)){
            //copy and expand
            int newCatalogSize = 2*catalogSize;
            int[][] temp = new int[newCatalogSize][];
            for(int j=0;j<actualSize;j++){
                coordinate = j<i? calculateCoordinate(j,newCatalogSize):calculateCoordinate(j+1,newCatalogSize);
                if(temp[coordinate[0]] == null){
                    temp[coordinate[0]] = new int[newCatalogSize];
                }
                temp[coordinate[0]][coordinate[1]] = get(j);
            }
            coordinate = calculateCoordinate(i,newCatalogSize);
            temp[coordinate[0]][coordinate[1]] = value;
            catalogArray = temp;
            catalogSize = newCatalogSize;
            actualSize ++;
        }else{
            //move
            coordinate = calculateCoordinate(actualSize, catalogSize);
            if(catalogArray[coordinate[0]] == null){
                catalogArray[coordinate[0]] = new int[catalogSize];
            }
            int j = actualSize - 1;
            actualSize++;
            while (j>=i){
                set(get(j),j+1);
                j--;
            }
            set(value,i);
        }


    }

    //O(n)
    public int delete(int i){
        if(i<0 || i>actualSize-1){
            System.out.println("Out of range");
            return -1;
        }
        int result = get(i);
        int newCatalogSize = calculateCatalogSize(actualSize - 1);
        if(newCatalogSize == catalogSize){
            int j = i+1;
            while (j<actualSize){
                set(get(j),j-1);
                j++;
            }
            int[] coordinate = calculateCoordinate(actualSize-1,catalogSize);
            if(coordinate[1] == 0)
                catalogArray[coordinate[0]] = null;
        }else{
            int[][] temp = new int[newCatalogSize][];
            for(int j=0;j<actualSize;j++){
                if(j == i)
                    continue;
                int[] coordinate =j<i?calculateCoordinate(j,newCatalogSize):calculateCoordinate(j-1,newCatalogSize);
                if(temp[coordinate[0]] == null){
                    temp[coordinate[0]] = new int[newCatalogSize];
                }
                temp[coordinate[0]][coordinate[1]] = get(j);
            }
            catalogArray = temp;
            catalogSize = newCatalogSize;
        }
        actualSize--;
        return result;
    }

    //O(1)
    public void swap(int i,int j){
        int temp = get(i);
        set(get(j), i);
        set(temp, j);
    }

    public void sort(){
        quickSort(0, actualSize - 1);
    }

    //O(nlogn)
    private void quickSort(int left, int right){
        if(left >= right)
            return;
        if(actualSize <= 1)
            return;
        int mid = (left + right)/2;
        int pivot = get(mid);
        int i = left,j = right;
        while (i<=j){
            while (get(i)<pivot)
                i++;
            while (get(j)>pivot)
                j--;
            if(i <= j){
                swap(i,j);
                i++;
                j--;
            }
        }
        quickSort(left,j);
        quickSort(i,right);

    }

    //O(n)
    public int search(int a){
        int pos = -1;
        for(int i=0;i<actualSize;i++){
            if(get(i) == a){
                pos = i;
                break;
            }
        }
        return pos;
    }

    //O(1)
    private int calculateCatalogSize(int n){
        int k = 1;
        while (Math.pow(4,k)<n)
            k++;
        return (int)Math.pow(2,k);
    }

    //test
    public static void main(String[] args) {
        VariableArray variableArray = new VariableArray(2);
        for(int i=0;i<2;i++)
            variableArray.add(1,0);
        for(int i=0;i<2;i++)
            variableArray.add(2,0);
//        for(int i=0;i<2;i++)
//            variableArray.add(3,0);
            System.out.println(variableArray);
        variableArray.sort();
        System.out.println("After sorting: " + variableArray);
        variableArray.delete(2);
        System.out.println("After deleting 2th element: " + variableArray);
        variableArray.delete(2);
        System.out.println("After deleting 2th element: " + variableArray);
        System.out.println("catalog array length: " + variableArray.catalogArray.length);
        System.out.println("1 index: "+variableArray.search(1));
    }
}
