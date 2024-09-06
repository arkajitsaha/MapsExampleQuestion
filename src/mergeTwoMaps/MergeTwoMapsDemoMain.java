package mergeTwoMaps;


import java.util.HashMap;
import java.util.Map;

class MergeMap{
    public void getMergedMap(Map<String,Integer> map1,Map<String,Integer>map2){

        for(Map.Entry<String,Integer> iterateMap: map2.entrySet()){
            map1.put(iterateMap.getKey(),map1.getOrDefault(iterateMap.getKey(),0)+iterateMap.getValue());
        }

        System.out.println("the merged map:");
        for(Map.Entry<String,Integer> printMap: map1.entrySet()){
            System.out.println(printMap.getKey()+" = "+printMap.getValue());
        }

    }
}

class AccessController{
    public void getAccess(){
        Map<String,Integer> map1 = new HashMap<>();
        map1.put("a",1);
        map1.put("b",4);
        map1.put("c",7);
        Map<String,Integer> map2 = new HashMap<>();
        map2.put("c",8);
        map2.put("d",10);
        map2.put("e",0);
        new MergeMap().getMergedMap(map1,map2);
    }
}
public class MergeTwoMapsDemoMain {
    public static void main(String[] args) {
        new AccessController().getAccess();
    }
}
