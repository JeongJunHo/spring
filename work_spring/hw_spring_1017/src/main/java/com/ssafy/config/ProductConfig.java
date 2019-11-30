package com.ssafy.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages= {"com.ssafy.model.repository","com.ssafy.model.service"})
public class ProductConfig {
}
