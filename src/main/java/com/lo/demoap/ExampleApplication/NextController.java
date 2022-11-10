package com.lo.demoap.ExampleApplication;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("loadhtml")
public class NextController {
	@RequestMapping(value = "htmlstart", method = RequestMethod.GET)
	public ResponseEntity<?> loadPro(@RequestParam Map<String, String> input) throws Exception {
		System.out.println("inside load");
			
		String name = input.get("Name");
		String password = input.get("Pass");
		String mailid = input.get("mail");
		String user = "karuppu";
		String pass = "123";
		String mail = "karuppu@2";
		if (user.equals(name) && pass.equals(password)) {
			 
			input.put("status", "LoginSuccess");
		} else {
			
			input.put("status", "LoginFailed");
		
		
		}

		return new ResponseEntity<>(input, HttpStatus.OK);

}
}
