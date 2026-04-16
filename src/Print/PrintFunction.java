package Print;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public class PrintFunction {
    public static void printArrayMethod(int[] arr){
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void printHashMapMethod(HashMap<Integer,Integer> map){
        for (Map.Entry<Integer,Integer> entry:map.entrySet()){
            System.out.print(entry.getKey()+" "+ entry.getValue()+", ");
        }
    }
}
