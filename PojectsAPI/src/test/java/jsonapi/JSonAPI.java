package jsonapi;

import static org.junit.Assert.*;

import org.junit.Test;

import gherkin.deps.com.google.gson.Gson;

import java.util.*;


public class JSonAPI {

	@Test
	public void testCreateJson() {
		Map<String, String> data = new HashMap<>();
		data.put("id",  "01");
		data.put("project", "P01");
		
		Gson gson = new Gson();
		String jsonString = gson.toJson(data);    
	
		//System.out.println(jsonString);
		assertEquals("{\"project\":\"P01\",\"id\":\"01\"}", jsonString);
	}

}
