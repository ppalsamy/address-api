package com.api.address.config;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//@Configuration
//@EnableWebMvc
public class WebSecurityConfig extends WebMvcConfigurerAdapter{

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
		.allowedMethods(HttpMethod.GET.toString(),
				HttpMethod.POST.toString(),
				HttpMethod.DELETE.toString(),
				HttpMethod.PUT.toString())
		.allowedMethods(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS,
				HttpHeaders.CONTENT_TYPE,
				HttpHeaders.AUTHORIZATION,
				"X-Requested-With")
		.maxAge(3600);
		
	}
	
}
