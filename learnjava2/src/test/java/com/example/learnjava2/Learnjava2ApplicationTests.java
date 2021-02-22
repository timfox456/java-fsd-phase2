package com.example.learnjava2;


import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

class Learnjava2ApplicationTests {

    @Test
    public void TestHttpGetRequest() {
        HttpExample example = new HttpExample();
        example.doGet();


    }

    @Test
    public void TestHttpPostRequest() {
        HttpExample example = new HttpExample();
        example.doPost();
    }

}
