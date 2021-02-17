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
	
}
