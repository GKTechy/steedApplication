package com.app.steedApplication.Configuration;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "main")
public class MainController {
	
	@RequestMapping(value = "/showpage/{page}", method = RequestMethod.GET)
	public String showPage(@PathVariable String page){
		return page;
	}
	
	/*@RequestMapping(value = "admin/showpage/{page}", method = RequestMethod.GET)
	public String showPageadmin(@PathVariable String page){
		return "admin/"+page;
	}*/
	
}
