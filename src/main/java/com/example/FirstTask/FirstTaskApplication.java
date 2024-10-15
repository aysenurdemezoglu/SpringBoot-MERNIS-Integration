package com.example.FirstTask;

import Mernis.NAUKPSPublicSoap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@SpringBootApplication
public class FirstTaskApplication {

	public static void main(String[] args) throws Exception {

		SpringApplication.run(FirstTaskApplication.class, args);
		/*NAUKPSPublicSoap client = new NAUKPSPublicSoap();

		boolean result = client.TCKimlikNoDogrula(10883549244L, "Ayşenur", "Demezoğlu", 2002);

		System.out.println("Sonuç:" + result);*/
	}
/*	@PostMapping("/api/checkTckn")
	public VerificationResponse checkTckn(@RequestBody CheckTcknRequest request) {
		boolean verified; // Implement verification logic using token/identifier
		return new VerificationResponse(verified);
	}*/ // controllera taşı değiir tc




}
