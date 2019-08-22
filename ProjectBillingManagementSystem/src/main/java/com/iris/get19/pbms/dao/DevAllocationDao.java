package java.com.iris.get19.pbms.dao;

import java.com.iris.get19.pbms.dao.model.DevAllocation;

import org.springframework.stereotype.Repository;




@Repository
public interface DevAllocationDao  {
	
	public boolean allocateDeveloper(DevAllocation da);

}
