package demo;

import TestCase.XueyuanAdd;
import org.testng.annotations.Test;
import java.io.IOException;

public class AddUser {
    @Test
    public void one() throws IOException {
        XueyuanAdd xueyuanAdd =new XueyuanAdd();
            for (int i=0;i<20;i++)
            {
                xueyuanAdd.addUser();
            }
    }

}


