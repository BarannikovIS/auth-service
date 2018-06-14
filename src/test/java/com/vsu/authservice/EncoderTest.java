package com.vsu.authservice;

import com.vsu.authservice.utils.Encoder;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class EncoderTest {

	@Test
	public void shouldEncrypt() throws UnsupportedEncodingException, NoSuchAlgorithmException {

		String strForEncryption = "test";
		String encryptedValue = Encoder.code(strForEncryption);
		Assertions.assertThat(encryptedValue.length()).isEqualTo(64);
	}
}
