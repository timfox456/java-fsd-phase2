package com.example.learnjava2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

public class HttpExample {

    public void doGet() {
        try {
            URL url = new URL("http://www.google.com");
            HttpURLConnection conn =  (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("User-Agent", "Java Browser");
            BufferedReader rdr = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = null;
            StringBuilder sb = new StringBuilder("");
            while ((line = rdr.readLine()) != null) {
                sb.append(line);
            }
            rdr.close();
            System.out.println(sb.toString());
        }
        catch (Exception ex) {
            System.err.println(ex);
        }
    }

    public void doPost() {
        try {
            URL url = new URL("http://ptsv2.com/");
            URLConnection con = url.openConnection();
            HttpURLConnection http = (HttpURLConnection)con;
            http.setRequestMethod("POST"); // PUT is another valid option
            http.setDoOutput(true);

            String postData = new String("{\"rating\":10,\"user\":\"tim\",\"comments\":\"Awesome\"}");
            System.out.println("length = " + postData.getBytes().length);
            HttpURLConnection conn =  (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Content-Length", "" + postData.getBytes().length);
            conn.setRequestProperty("Content-Language", "en-US");
            conn.setUseCaches(false);
            conn.setDoInput(true);
            conn.setDoOutput(true);
            BufferedReader rdr = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = null;
            StringBuilder sb = new StringBuilder("");
            while ((line = rdr.readLine()) != null) {
                sb.append(line);
            }
            rdr.close();
            System.out.println(sb.toString());

        }
        catch (Exception ex) {
            System.err.println(ex);
        }
    }

}
