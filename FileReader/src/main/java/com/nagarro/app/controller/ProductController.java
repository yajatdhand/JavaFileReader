package com.nagarro.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.app.processor.FileProcessor;

@RestController
@RequestMapping("/app")
@EnableScheduling
public class ProductController {

	@Autowired
	FileProcessor nikeFileProcessor;

	@Autowired
	FileProcessor pumaFileProcessor;
	
	@Scheduled(fixedRate = 30000)
	public void processNikeFile() {
		nikeFileProcessor.setFilepath("Nike.csv");
		nikeFileProcessor.run();
	}

	@Scheduled(fixedRate = 30000)
	public void processPumaFile() {
		pumaFileProcessor.setFilepath("Puma.csv");
		pumaFileProcessor.run();
	}

}
