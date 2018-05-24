package demo;

import Method.HttpRequest;
import Method.Params;
import org.testng.annotations.Test;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InterfaceAutomation{
    private static List<Params> list = new ArrayList<Params>();
    public void file() throws IOException {
        File file = new File("H:\\1.txt");
        BufferedReader bufferedReader =new BufferedReader(new FileReader(file));
        String txt=bufferedReader.readLine();
    while (txt!=null){
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
         String one= httpRequest.login(list.get(0).getUrl(),list.get(0).getParameter());
         String two=httpRequest.login(list.get(1).getUrl(),list.get(1).getParameter());

    }
}
