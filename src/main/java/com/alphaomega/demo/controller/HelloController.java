package com.alphaomega.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.alphaomega.demo.service.SerialService;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("test")
public class HelloController {

	@RequestMapping("/hello")
	public String index() {
		
		return "Hello,world!This is your Spring Boot";
	}
	
	@RequestMapping("/openComm")
	public String openComm() {
		ArrayList<String> ports = SerialService.findPort();
		return ports.get(0);
	}
}
