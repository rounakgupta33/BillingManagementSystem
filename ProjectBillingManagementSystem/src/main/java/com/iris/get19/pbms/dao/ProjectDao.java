package controller.service.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import controller.service.dao.models.Project;


@Repository
public interface ProjectDao {
	public List<Project> viewProject();
	public Project getProjectById(int id);
}
