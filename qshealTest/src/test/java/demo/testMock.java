package demo;


import org.testng.annotations.Test;

import java.io.IOException;
import java.util.*;
import java.util.Map;

public class testMock{

  public void testone() throws Exception {
     Runtime runtime=Runtime.getRuntime();
     runtime.exec("dxdiag");

  }

public void Maptest(){
     String sr="safsafshfihasdfhhfshjfdshj";
     char [] a=sr.toCharArray();
     Map<Character ,Integer> map=new LinkedHashMap<>();
     for (char s:a)
     {
         if(map.containsKey(s)){
             Integer h=map.get(s);
             map.put(s,h+1);
         }else {
             map.put(s,1);
         }
     }
        System.out.println(map);


}

public void MapTestOne(){
      Set<String>  name=new HashSet<>();
      name.add("一一");
      name.add("二二");
      name.add("三三");
      Set<String> classNum =new HashSet<>();
      classNum.add("one");
      classNum.add("two");
      classNum.add("three");
      Map<String,Set<String>> map1=new HashMap<>();
      map1.put("一般",name);
      map1.put("还行",classNum);
      Map<String,Set<String>> map2=new HashMap<>();
      map2.put("一般",name);
      map2.put("还行",classNum);
      List<Map<String,Set<String>>> list=new ArrayList<>();
      list.add(map1);
      list.add(map2);
    System.out.println(list);


}



 public void nine(){
//      int line=1;
//      for (int i=1; i<=line;i++){
//          System.out.print(i+"*"+line+"="+(i*line));
//      }
//        System.out.println();
//      line++;
//     for (int i=1; i<=line;i++){
//         System.out.print(i+"*"+line+"="+(i*line));
//
//     }
//        System.out.println();
//     line++;
     for(int line=1;line<=9;line++){
         for(int i=1;i<=line;i++){

             System.out.print(i+"*"+line+"="+(i*line));
         }
         System.out.println();
     }
 }
}