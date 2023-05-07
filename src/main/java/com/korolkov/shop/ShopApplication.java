package com.korolkov.shop;

import jakarta.annotation.PostConstruct;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.nio.charset.StandardCharsets;

@SpringBootApplication
public class ShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopApplication.class, args);
	}

	private final TestRepo testRepo;
	private final TestRepo2 testRepo2;

	public ShopApplication(TestRepo testRepo, TestRepo2 testRepo2) {
		this.testRepo = testRepo;
		this.testRepo2 = testRepo2;
	}

	@PostConstruct
	public void test(){
		Test1 test1 = testRepo.findById(1L)
				.orElseThrow();
		Test2 test2 = testRepo2.findById(1L)
				.orElseThrow();
		byte[] data1 = test1.getData();
		byte[] data2 = test2.getData();
		byte[] result = ArrayUtils.addAll(data1, data2);

		try (
				FileOutputStream fos = new FileOutputStream("C:\\Users\\Maxim\\Desktop\\test\\test.txt")
		) {
//			IOUtils.copy(data1, data2);
			fos.write(result , 0 , result.length);
			Writer writer = new OutputStreamWriter(fos, StandardCharsets.UTF_8);


		}  catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
