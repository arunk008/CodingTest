package com.apple.codingtest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.apple.codingtest.Controller.FlagpickerServiceController;

@SpringBootTest
class CodingtestApplicationTests {
	
	
	
	@Autowired
	private FlagpickerServiceController controller; 

	@Test
	void contextLoads()throws Exception {
		Assertions.assertNotNull(controller);
	}
	

}
