package java.com.iris.get19.pbms.controller;

import java.com.iris.get19.pbms.dao.DevAllocationDao;
import java.com.iris.get19.pbms.dao.DeveloperDao;
import java.com.iris.get19.pbms.dao.DeveloperRoleDao;
import java.com.iris.get19.pbms.dao.ProjectConfigDao;
import java.com.iris.get19.pbms.dao.ProjectDao;
import java.com.iris.get19.pbms.dao.model.DevAllocation;
import java.com.iris.get19.pbms.dao.model.Developer;
import java.com.iris.get19.pbms.dao.model.DeveloperRole;
import java.com.iris.get19.pbms.dao.model.Project;
import java.com.iris.get19.pbms.dao.model.ProjectConfig;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class AdminController {
	
	@Autowired
	ProjectDao projectDao;
	@Autowired
	DeveloperRoleDao roleDao;
	@Autowired
	DeveloperDao developerDao;
	
	
	@Autowired
	ProjectConfigDao projectConfigDao;
	
	@Autowired
	DevAllocationDao devAllocationDao;
	
	
	@RequestMapping(value = "ProjectConfig", method = RequestMethod.GET)
	public String projectConfig(ModelMap map) {
		List<Project> pList = projectDao.viewProject();
		List<DeveloperRole> rList=roleDao.viewRole();
		
		
		map.addAttribute("configObj",new ProjectConfig());
		map.addAttribute("pList", pList);
		map.addAttribute("rList", rList);
		
		return "ProjectCon";
		
		
	}
	
	@RequestMapping(value = "addProjectConfig", method = RequestMethod.GET)
	public String addProjectConfig(@ModelAttribute("configObj") ProjectConfig projectConfig) {
		try {
		boolean b=projectConfigDao.addConfiguration(projectConfig);
	
		return "HomePage";
		}
		catch(Exception e) {
		
		return "ErrorPage";
		}
		
	}
	
	@RequestMapping(value = "addDeveloperAllocation", method = RequestMethod.GET)
	public String addDeveloperAllocation(ModelMap map ) {
		//developerAllocationDao.allocateDeveloper();
		
		List<Developer> dList = developerDao.viewDeveloper();
		List<ProjectConfig> configList=projectConfigDao.getAllConfig();
	
		System.out.println("Developer's List : "+dList);
		
		
		map.addAttribute("devConfigObj",new DevAllocation());	
		
		map.addAttribute("dList", dList);
		
		
		map.addAttribute("configList", configList);
		
		
		
		
		return "DeveloperAllocation";
		
		
	}
	
	
	
	
	
	
	
	
	
}
