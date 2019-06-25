package com.petit;



import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.petit.controller.SampleController;

@RunWith(SpringRunner.class)
//@SpringBootTest    // @SpringBootTest 는 사용하지 않습니다.
@WebMvcTest(SampleController.class)
public class SampleControllerTests {

	@Autowired
	MockMvc mock;
	
	@Test
	public void testHello() throws Exception{
		
		mock.perform(get("/hello")).andExpect(content().string("Hello World"));
		
		MvcResult result = mock.perform(get("/hello"))
				.andExpect(status().isOk())
				.andExpect(content().string("Hello World")).andReturn();
		
		System.out.println(result.getResponse().getContentAsString());
	}
}
