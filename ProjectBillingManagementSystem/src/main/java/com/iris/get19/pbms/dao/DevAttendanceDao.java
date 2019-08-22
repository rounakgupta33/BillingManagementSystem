package controller.service.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import controller.service.dao.models.DevAttendance;




@Repository
public interface DevAttendanceDao {
	
	
	public boolean fillAttendance(DevAttendance de);
	public List<DevAttendance> viewAttendance();
	
	

}
