package com.alphaomega.demo;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alphaomega.demo.service.SerialService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SerialTest {
	
	@Test
	public void testSerialPort() throws Exception{
		
		ArrayList<String> ports = SerialService.findPort();
	}

}
