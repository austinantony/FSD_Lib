package com.lib;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class App 
{
	@RequestMapping("/hello")
	public String hello(){  
        return"Hello!";  
    }  
}
