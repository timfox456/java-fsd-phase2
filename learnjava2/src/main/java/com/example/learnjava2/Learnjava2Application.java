package com.example.learnjava2;



import java.io.File;
import java.net.HttpURLConnection;
import java.nio.file.FileSystems;
import java.nio.file.FileSystem;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.ArrayList;

public class Learnjava2Application {

	public static void main(String[] args) {

		HttpExample example = new HttpExample();
		example.doGet();
	}
}
