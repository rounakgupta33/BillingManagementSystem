package java.com.iris.get19.pbms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import controller.service.dao.impl.DeveloperDao;
import controller.service.dao.models.Developer;


@Controller
public class LoginController {
	@Autowired
	DeveloperDao developerDao;
	
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String getHomePage() {
		return "HomePage";
	}
	
	  @RequestMapping(value="Login",method=RequestMethod.GET)
	 
	public String getLoginPage(ModelMap map) {
		Developer d = new Developer();
		map.addAttribute("dObj", d);
		
		return "LoginPage";
	}
	
	@RequestMapping(value="validate",method=RequestMethod.POST)
	public String ValidatePage(@ModelAttribute("dObj") Developer dObj, ModelMap map) {
		
		System.out.print("Im in validate");
		int id=dObj.getId();
		
		boolean b=developerDao.validateDeveloper(id, dObj.getPassword());
		if(b)
		{
			System.out.println("-----------------------------------------");
			Developer d=developerDao.getDeveloperById(dObj.getId());
			if(d.getApplicationRole().equals("Admin"))
			{
				return "Admin";
			}
			else if(d.getApplicationRole().equals("Data_Entry"))
				return "DataEntry";
			else
				return "Developer";
		}
	
	
		return "LoginPage";
	}
	
}
