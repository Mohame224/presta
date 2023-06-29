package util;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import base.Loggers;

public class GetJsonFileInvalidData {
	public String[] invalid_JSON_file() throws IOException{
		FileReader fr=new FileReader(System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator
				+ "resources"  + File.separator + "invalid Data.json");
		Loggers.logger.info("reading JSON file");
		Object obj=com.google.gson.JsonParser.parseReader(fr);
		Loggers.logger.info("parse json file to json element");
		JsonObject username=(JsonObject) obj;
		Loggers.logger.info("parse json element to json object");
		JsonArray arrray=(JsonArray) username.get("data");
		Loggers.logger.info("create json array from json object");
		String arr[]=new String[arrray.size()];
		
		for (int i=0;i<arrray.size();i++) {
			JsonObject users=(JsonObject) arrray.get(i);
			Loggers.logger.info("get element numer"+String.valueOf(i));
			String user=String.valueOf(users.get("username"));
			String pass=String.valueOf( users.get("password"));
			arr[i]=user+","+pass;
			Loggers.logger.info("create the string array from json file");
		}
		fr.close();
		return arr; 
		
		
	}
}
