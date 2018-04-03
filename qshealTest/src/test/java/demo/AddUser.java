package demo;

import TestCase.XueyuanAdd;
import org.testng.annotations.Test;
import java.io.IOException;

public class AddUser {
    @Test
    public void one() throws IOException {
        XueyuanAdd xueyuanAdd =new XueyuanAdd();
            xueyuanAdd.addUser();
    }

}


