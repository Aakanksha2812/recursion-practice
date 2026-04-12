package Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayListPractice {
    //remove duplicate element
    void removeDuplicate(ArrayList<Integer> list) {
        int i = 1;
        while (i < list.size()) {
            while (i < list.size() && list.get(i) == list.get(i - 1)) {
                list.remove(i );
            }
            i++;
        }
        for (int e : list) {
            System.out.print(e + " ");
        }
    }
    void reverseList(ArrayList<Integer> list){
        int i=0,j=list.size()-1;
        while (i<j){
            int temp=list.get(i);
            list.set(i,list.get(j));
            list.set(j,temp);
            i++;
            j--;
        }
        for (int e : list) {
            System.out.print(e + " ");
        }
    }
    void frequencyOfElement(ArrayList<Integer> list){
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int e:list){
            map.put(e,map.getOrDefault(e,0)+1);
        }
        for (Map.Entry<Integer,Integer> entry: map.entrySet()){
            System.out.print(entry.getKey()+" : "+entry.getValue()+" , ");
        }
    }

    public static void main(String[] args) {
        ArrayListPractice p = new ArrayListPractice();
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 2, 2, 3, 4, 4));
        p.removeDuplicate(list);
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3,  4));
        System.out.println();
        p.reverseList(list1);
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(1, 2, 2, 2, 3, 4, 4));
        System.out.println();
        p.frequencyOfElement(list2);
    }
}
