package com.example.springScreen.app.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springScreen.domain.service.CacheService;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
public class ApiController {
	
	@Autowired
	CacheService cacheService;
	
	@GetMapping("/cacheTest")
	public Object cacheTest() {
		log.info("cacheTestメソッドきた1");
		Map<String,String> map = cacheService.getCacheValue();
		return map;
	}
	
	@GetMapping("/cacheTestUpdate")
	public Object cacheTestUpdate() {
		log.info("cacheTestUpdateメソッドきた1");
		Map<String,String> map = cacheService.setCacheValue();
		return map;
	}
	
	@GetMapping("/cacheTest2")
	public Object cacheTest2() {
		log.info("cacheTestメソッドきた1");
		Map<String,String> map = cacheService.getCacheValue2();
		return map;
	}

	@GetMapping("/test1")
	public String test1() {
		log.info("確認メソッドきた1");
		return "comeTest1";
	}

	@GetMapping("/test2")
	public String test2() {
		log.info("確認メソッドきた2");
		return "comeTest2";
	}

	@GetMapping("/test3")
	public Map<String, String> test3() {
		log.info("確認メソッドきた3");
		Map<String, String> map = new HashMap<String, String>();
		map.put("result", "test3Ok");
		map.put("value", "createValue");
		return map;
	}

	@PostMapping("/test4")
	public Map<String, Object> test4(@RequestBody User user) {
		log.info("確認メソッドきた4");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", "test4Ok");
		map.put("value", "createValue");
		user.setName(user.getName() + "update");
		map.put("user", user);
		return map;
	}

	@Data
	private static class User {
		private String name;
		private int age;
	}
}
