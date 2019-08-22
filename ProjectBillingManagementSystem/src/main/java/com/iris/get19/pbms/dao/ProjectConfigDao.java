package controller.service.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import controller.service.dao.models.ProjectConfig;


@Repository
public interface ProjectConfigDao {

		public boolean addConfiguration(ProjectConfig projectConfig);
		
		public List<ProjectConfig> getAllConfig();
}
