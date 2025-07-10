package com.nagarro.app;

import org.springframework.beans.factory.annotation.Autowired;

import com.nagarro.app.models.Nike;
import com.nagarro.app.models.ProductId;
import com.nagarro.app.models.ProductType;
import com.nagarro.app.models.Puma;
import com.nagarro.app.repository.NikeRepository;
import com.nagarro.app.repository.PumaRepository;

public class ClassA {
	
	@Autowired
	NikeRepository nikeRepository;
	
	@Autowired
	PumaRepository pumaRepository;
	
	public void saveData() {
		ProductId nikeProductId = new ProductId();
		nikeProductId.setBrand("Nike");
		
		ProductId pumaProductId = new ProductId();
		pumaProductId.setBrand("Puma");
		
		Nike nike = new Nike(nikeProductId, "Red", 28, ProductType.SHIRT, 22.50);
		nikeRepository.save(nike);
		
		Puma puma = new Puma(pumaProductId, "Blue", 28, ProductType.SHIRT);
		pumaRepository.save(puma);
	}

}
