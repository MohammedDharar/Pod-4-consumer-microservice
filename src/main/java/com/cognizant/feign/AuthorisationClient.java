package com.cognizant.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * Authorization Service FeignClient and for Connect with it
 */
@SuppressWarnings("el-syntax")
@FeignClient(name = "authorization-service", url = "${AUTH_SERVICE:http://localhost:8084}") // server.port of authorization class
public interface AuthorisationClient {

	/**
	 * validate method of Authorization Service
	 * @param token
	 * @return
	 */
	@GetMapping("/auth/validate")
	public boolean validate(@RequestHeader(name = "Authorization") String token);
}