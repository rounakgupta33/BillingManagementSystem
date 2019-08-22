package java.com.iris.get19.pbms.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import controller.service.dao.models.Developer;


@Repository
public interface DeveloperDao {
	public List<Developer> viewDeveloper();
	public Developer getDeveloperById(int id);
	public boolean validateDeveloper(int id,String password);
	}
