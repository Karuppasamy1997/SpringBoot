package com.lo.demoap.ExampleApplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lo.demoap.ExampleTwo.StarterSep;

@RestController
@RequestMapping("test")
public class StarterDep {
	@Autowired
	StarterSep objgood;
	@Value("${file.path}")
	String path;
	@RequestMapping(value = "api", method = RequestMethod.GET)
	public ResponseEntity<?> testAPI(@RequestParam Map<String, String> operation) throws Exception

	{
		int output = 0;
		try {
			String op = " ";
			int c = Integer.parseInt(operation.get("a"));
			int d = Integer.parseInt(operation.get("a"));
			System.out.println(operation);
			switch (operation.get("op")) {

			case "add":
				output = objgood.add(c, d);

				break;
			case "sub":
				output = objgood.sub(c, d);
				break;
			case "mul":
				output = objgood.mul(c, d);
				break;
			case "div":
				output = objgood.div(c, d);
				break;
			}
			operation.put("Status", "Success");
			operation.put("Result", output + "");
		} catch (Exception e) {
			System.out.println("Invalid input");
			System.out.println((e.getMessage()));
			
			operation.put("Status", e.getMessage());
		}
		return new ResponseEntity<>(output, HttpStatus.OK);

	}
/*
	@RequestMapping(value = "load", method = RequestMethod.GET)
	public ResponseEntity<?> loadProperty(@RequestParam Map<String, String> requestParam) throws Exception {
		System.out.println("inside load");
		Properties prop = new Properties();	

		prop.put("Id", "101");
		prop.put("Name", "Joy");
		prop.put("Designation", "Software Developer");

		FileOutputStream out = new FileOutputStream("D:\\karuppu.properties");
		prop.store(out, "Details of Joy");
		
		try {

				File f = new File("D:\\karuppu.properties");		
			FileInputStream fin = new FileInputStream(f);
			prop.load(fin);			
			System.out.println("file readed successfully");

		} catch (Exception e) {
			System.out.println((e));		
		}
		
		return new ResponseEntity<>(prop , HttpStatus.OK);
	}*/
	 
	@RequestMapping(value = "load1", method = RequestMethod.GET)
	public ResponseEntity<?> pro(@RequestParam Map<String, String> requestParam) throws Exception {
		File config=new File(path);
		Properties propa = new Properties();	
		FileOutputStream in=new FileOutputStream(config);
		propa.setProperty("department","cse");
		propa.store(in, "write a file");
		
		return new ResponseEntity<>(propa,HttpStatus.OK);
		
}
	 
	/*@RequestMapping(value = "load2", method = RequestMethod.GET)
	public ResponseEntity<?> proa(@RequestParam Map<String, String> requestParam) throws Exception {
	
		Properties propa = new Properties();	
		FileInputStream name=new FileInputStream(path);
		propa.load(name);
		
		return new ResponseEntity<>(propa,HttpStatus.OK);
}*/
}
