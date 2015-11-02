package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.app.spring.social.SpringSocialBootApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringSocialBootApplication.class)
@WebAppConfiguration
public class SpringSocialBootApplicationTests {

	@Autowired
	ApplicationContext context;
	
	@Test
	public void contextLoads() {
		for(String name : context.getBeanDefinitionNames()){
			System.out.println(name);
		}
	}

}
