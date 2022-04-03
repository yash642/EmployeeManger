package com.cg.tasktracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.tasktracker.dao.AdminRepository;
import com.cg.tasktracker.entity.AdminEntity;
import com.cg.tasktracker.model.LoginModel;

@Service
public class AdminService{

	@Autowired
	AdminRepository adminDao;
	
	public boolean adminlogin=false;
	
	public void adminLogout() {      //admin has loggedOut
		this.adminlogin=false;
	}
	
	public AdminEntity adminSignup(AdminEntity adminModel) {
		if(adminDao.existsByEmail(adminModel.getEmail())) {
			return null;
		}
		adminDao.save(adminModel);
		
		return adminModel;
		
	}

	public AdminEntity adminLogin(LoginModel credentials) {
		
		if (adminDao.findByEmail("ishapawar181@gmail.com") == null) {
			if (credentials.getPassword().equals("isha")) {
				AdminEntity adm = new AdminEntity();
				adm.setAdminId("CG800");
				adm.setEmail("ishapawar181@gmail.com");
				adm.setName("Isha Pawar");
				adm.setRole("ADMIN");
				adm.setPassword("isha");
				adminDao.save(adm);
			}
		}
		AdminEntity emp = adminDao.findByEmail(credentials.getEmail());
		if(emp.getPassword().equals(credentials.getPassword())) {
			this.adminlogin=true;  //admin has loggedIn
			return emp;
		}
		return null;
	}
}
