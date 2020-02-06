package com.demo.mm;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	

	@Value("${my:default value}")
	 private String smg;
	
	@Value("some  static string")
	 private String staticGreting;
	
	@Value("${my.list.values}")
	 private List<String> values;
	
	@Value("#{${dbvalue}}")
	 private Map<String,String> dbvalues;
	@Autowired
	private DbSettings dbsetting;
	
	@GetMapping("/greeting")
	 public String greeting() {
		return smg+staticGreting+values+dbvalues+dbsetting.getConnection()+dbsetting.getHost();
	}

}
