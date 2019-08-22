package controller.service.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import controller.service.dao.models.DeveloperRole;




@Repository(value="roleDao")
@Transactional
public class DeveloperRoleDaoImpl implements DeveloperRoleDao{
	@Autowired
	SessionFactory sf;
	public List<DeveloperRole> viewRole() {
		try{
			Session session=sf.getCurrentSession();
			Query q=session.createQuery("from DeveloperRole");
			 return q.getResultList();
			
			}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	
	

}
