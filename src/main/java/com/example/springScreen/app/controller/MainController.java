/**
 *
 */
/**
 * @author super
 *
 */
package com.example.springScreen.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.springScreen.domain.service.TestService;

@Controller
public class MainController {

	@Autowired
	TestService testService;

	@Value("${test.value}")
	String value;

	@RequestMapping(value = { "/main" }, method = { RequestMethod.GET })
	public ModelAndView m() {

		// 生成
		ModelAndView mv = new ModelAndView();

		// テンプレートを指定
		mv.setViewName("index");

		// 返却
		return mv;
	}
	
	  @RequestMapping(value = "/company", method = RequestMethod.GET)
	  String comapny() {
	    return "contents/company";
	  }
	  
	  @RequestMapping(value = "/upload", method = RequestMethod.GET)
	  String upload() {
	    return "contents/upload";
	  }
	  
	  @RequestMapping(value = "/list", method = RequestMethod.GET)
	  String list() {
	    return "contents/list";
	  }
}