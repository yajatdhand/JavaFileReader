package com.nagarro.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nagarro.app.FileReaderApplication;
import com.nagarro.app.processor.FileProcessor;

@Configuration
public class AppConfig {

    @Bean
    FileProcessor fileProcessor() {
		return new FileProcessor();
	}
}
