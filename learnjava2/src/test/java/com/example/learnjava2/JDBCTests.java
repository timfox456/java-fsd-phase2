package com.example.learnjava2;

import com.example.learnjava2.jdbc.JDBCExample;
import org.junit.jupiter.api.Test;

public class JDBCTests {

    @Test
    public void TestConnection()
    {
        JDBCExample example = new JDBCExample();
        example.TestConnection();
    }
}
