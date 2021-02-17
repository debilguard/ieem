package com.api.sipain;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController 
public class apiController {

	
	@GetMapping("/api")
	public String Get()
	{	
		return "Get method working";
	}
	
	@GetMapping("/v2")
	public String v2()
	{	
		return "Version 2 service";
	}
	
	@GetMapping("/v3")
	public String v3()
	{	
		return "Version 3 service";
	}
	
}