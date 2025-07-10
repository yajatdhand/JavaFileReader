package com.nagarro.app;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nagarro.app.models.Nike;
import com.nagarro.app.models.Puma;
import com.nagarro.app.repository.NikeRepository;
import com.nagarro.app.repository.PumaRepository;

@SpringBootApplication
public class FileReaderApplication {

	@Autowired
	private NikeRepository nikeRepository;

	@Autowired
	private PumaRepository pumaRepository;

	public static void main(String[] args) {
		SpringApplication.run(FileReaderApplication.class, args);

		FileReaderApplication app = new FileReaderApplication();
		app.run();
	}

	public void run() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Are you searching something? (yes/no)");
			String nextSearch = sc.nextLine();

			if (nextSearch.equalsIgnoreCase("no")) {
				System.out.println("Bye... !!!");
				break;
			}

			// Search logic
			System.out.println("Please Enter brand for search : ");
			String brand = sc.nextLine();

			System.out.println("Please Enter color for search : ");
			String color = sc.nextLine();

			System.out.println("Please Enter size for search : ");
			int size = sc.nextInt();

			if (!brand.isBlank()) {
				System.out.println("Filter products : ");
				if (brand.equalsIgnoreCase("NIKE")) {
					showNikeData(nikeRepository.filterData(brand, color, size, color));
				} else {
					showPumaData(pumaRepository.filterData(brand, color, size, color));
				}
			}
		}
	}

	private void showNikeData(List<Nike> filterData) {
		filterData.stream().forEach(nike -> System.out.println(nike));
	}

	private void showPumaData(List<Puma> filterData) {
		filterData.stream().forEach(puma -> System.out.println(puma));
	}
}
