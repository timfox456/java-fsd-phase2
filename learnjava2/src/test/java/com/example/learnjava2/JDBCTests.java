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


    @Test
    public void TestSelect()
    {
        JDBCExample example = new JDBCExample();
        example.TestSelect();
    }

    @Test
    public void TestCreate()
    {
        JDBCExample example = new JDBCExample();
        example.TestCreate();
    }
}
