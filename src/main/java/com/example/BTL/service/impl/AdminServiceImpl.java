package com.example.BTL.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.BTL.dao.AdminDao;
import com.example.BTL.entity.Admin;
import com.example.BTL.model.AdminDTO;
import com.example.BTL.service.AdminService;

@Service
@Transactional
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminDao adminDao;
	
	@Override
	public void createAdmin(AdminDTO admin) {
		// TODO Auto-generated method stub
		Admin a = new Admin();
		a.setUsername(admin.getUsername());
		a.setPassword(admin.getPassword());
		
		adminDao.createAdmin(a);
		
	}

	@Override
	public void deleteAdmin(int id) {
		// TODO Auto-generated method stub
		Admin admin = adminDao.getAdminByID(id);
		if(admin!=null) {
			adminDao.deleteAdmin(admin);

		}
	}

	@Override
	public void editAdmin(AdminDTO admin) {
		// TODO Auto-generated method stub
		Admin a = new Admin();
		a.setAdminid(admin.getId());
		a.setUsername(admin.getUsername());
		a.setPassword(admin.getPassword());
		
		adminDao.editAdmin(a);
		
	}

	@Override
	public AdminDTO loginAdmin(String username) {
		// TODO Auto-generated method stub
		Admin admin = adminDao.loginAdmin(username);
		
		AdminDTO adminDTO = new AdminDTO();
		adminDTO.setId(admin.getAdminid());
		adminDTO.setUsername(admin.getUsername());
		adminDTO.setPassword(admin.getPassword());
		
		return adminDTO;
	}

	@Override
	public List<AdminDTO> getListPerson() {
		// TODO Auto-generated method stub
		List<AdminDTO> listAdminDTOs = new ArrayList<AdminDTO>();
		List<Admin> listAdmin = adminDao.getListPerson();
		for(Admin admin: listAdmin) {
			AdminDTO adminDTO = new AdminDTO();
			adminDTO.setId(admin.getAdminid());
			adminDTO.setUsername(admin.getUsername());
			adminDTO.setPassword(admin.getPassword());
			listAdminDTOs.add(adminDTO);
		}
		return listAdminDTOs;
	}

	@Override
	public AdminDTO getAdminByID(int id) {
		// TODO Auto-generated method stub
		AdminDTO adminDTO = new AdminDTO();
		Admin admin = adminDao.getAdminByID(id);
		adminDTO.setId(admin.getAdminid());
		adminDTO.setUsername(admin.getUsername());
		adminDTO.setPassword(admin.getPassword());
		return adminDTO;
	}

}
