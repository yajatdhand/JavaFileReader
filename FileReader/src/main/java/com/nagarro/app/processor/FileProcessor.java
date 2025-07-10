package com.nagarro.app.processor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;

import com.nagarro.app.models.Nike;
import com.nagarro.app.models.ProductId;
import com.nagarro.app.models.ProductType;
import com.nagarro.app.models.Puma;
import com.nagarro.app.repository.NikeRepository;
import com.nagarro.app.repository.PumaRepository;

public class FileProcessor implements Runnable {

	@Autowired
	NikeRepository nikeRepository;

	@Autowired
	PumaRepository pumaRepository;

	private String filepath;

	public void setFilepath(String filepath) {
		this.filepath = rootPath + filepath;
	}

	private static final String rootPath = "./src/main/java/data/";
	private static final String moveDir = "src/main/java/processed/";

	public FileProcessor() {}

	@Override
	public void run() {
		processFile();
	}

	public void processFile() {
		System.out.println("FILEPATH : " + filepath);
		File file = new File(this.filepath);

		if (!file.exists()) {
			System.out.println("This file is not exists : " + filepath);
			return;
		}
		System.out.println("Start reading file : " + filepath + " at : "
				+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:s")));
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(this.filepath))) {
			String line = "";
			while ((line = bufferedReader.readLine()) != null) {
				String[] data = line.split(",");
				System.out.println(Arrays.toString(data));
				String brand = data[0];
				String color = data[1];
				int size = Integer.parseInt(data[2]);
				String type = data[3];
				double price = data.length > 4 && data[4] != null && !data[4].isEmpty() ? Double.parseDouble(data[4])
						: 0.0;

				if (brand != null && !brand.isBlank()) {
					SecureRandom random = new SecureRandom();
					long n = random.nextLong();
					ProductId id = new ProductId((int) n, brand);

					if (brand.equals("NIKE")) {
						Nike nike = new Nike(id, color, size,
								type.equals("Shirt") ? ProductType.SHIRT : ProductType.SHOES, price);
						nikeRepository.save(nike);
					} else {
						Puma puma = new Puma(id, color, size,
								type.equals("Shirt") ? ProductType.SHIRT : ProductType.SHOES);
						pumaRepository.save(puma);
					}
				}
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

        moveToProcessed(this.filepath);
	}

	public void moveToProcessed(String filepath) {
		Path source = Paths.get(filepath);
		Path destination = Paths.get(moveDir + source.getFileName());

		try {
			Files.createDirectories(destination.getParent());
			Files.move(source, destination, StandardCopyOption.REPLACE_EXISTING);
			System.out.println(filepath + " Moved at : "
					+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:s")));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
