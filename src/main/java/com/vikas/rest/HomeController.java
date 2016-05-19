package com.vikas.rest;

import com.vikas.rest.RestDTO;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	/**
	 * REST API.
	 */
	@RequestMapping(value = "/restApi", method = RequestMethod.GET)
	public @ResponseBody RestDTO restApi(String type, long sn, long systemId) {
	
		//http://localhost:8080/rest/restApi?type=Cdot&sn=123456&systemId=890
		
		logger.info("Inside restApi method");
		
		RestDTO rest = new RestDTO("restApi method");
		rest.setType(type);
		rest.setSn(sn);
		rest.setSystemId(systemId);
		rest.setArray(type, sn, systemId);
		
		return rest;
	}
	
	
}
