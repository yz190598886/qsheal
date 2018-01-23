package demo;

import org.junit.Test;
import TestCase.yanglaoOrderTest;

import java.io.IOException;
import java.sql.SQLException;

public class ATest {
    @Test
    public void yuepanduan() throws IOException, SQLException {
        yanglaoOrderTest yanglaoOrderTest=new yanglaoOrderTest();
        yanglaoOrderTest.adduser();
    }
}
