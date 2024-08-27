package groupAnagrams;

import java.util.*;

class AnagramGrouper{


    public Map<String, List<String>> getAnagramGrouper(String[] str){
        Map<String, List<String>> anagramMap = new HashMap<>();
        for(String s:str){
           char[] c = s.toCharArray();
           Arrays.sort(c);
           String sortedString = String.valueOf(c);
           List<String> list = anagramMap.getOrDefault(sortedString,new ArrayList<>());
           list.add(s);
           anagramMap.put(sortedString,list);
        }
        return anagramMap;
    }
}

class ControllerDemo{
    public void getAccess(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter no of strings:");
        int n = sc.nextInt();
        sc.nextLine();
        String[] str = new String[n];
        for(int i =0; i<n; i++){
            str[i] = sc.nextLine();
        }
        Map<String,List<String>> anagramGRPList = new AnagramGrouper().getAnagramGrouper(str);

        for(Map.Entry<String,List<String>> entry: anagramGRPList.entrySet()){
            System.out.println(entry.getKey()+" = "+entry.getValue());
        }

    }
}

public class AnagramDemoMain {
    public static void main(String[] args) {
        new ControllerDemo().getAccess();
    }
}
