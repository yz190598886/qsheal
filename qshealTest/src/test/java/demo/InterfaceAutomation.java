package demo;

import Method.HttpRequest;
import Method.Params;
import org.testng.annotations.Test;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InterfaceAutomation{
    int i=0;
    private static List<Params> list = new ArrayList<>();
    public void file() throws IOException {
        File file = new File("H:\\1.txt");
        BufferedReader bufferedReader =new BufferedReader(new FileReader(file));
        String txt="";
    while( (txt=bufferedReader.readLine())!=null){
        i++;
      Params params= new Params();
      String [] a=txt.split(",");
      params.setUrl(a[0]);
      params.setParameter(a[1]);
      list.add(params);
   }
  }
 @Test
    public void run() throws IOException {
        HttpRequest httpRequest=new HttpRequest();
        file();
        for (int a=0;a<i;a++){
             String CodeBack=httpRequest.login(list.get(a).getUrl(),list.get(a).getParameter());
             System.out.println(CodeBack.substring(0,3)+"-------"+CodeBack.substring(3));
         }

    }
}
