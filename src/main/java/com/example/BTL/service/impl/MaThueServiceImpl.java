package com.example.BTL.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.BTL.dao.MaThueDao;
import com.example.BTL.entity.MaThue;
import com.example.BTL.model.MaThueDTO;
import com.example.BTL.service.MaThueService;

@Service
@Transactional
public class MaThueServiceImpl implements MaThueService {
	
	@Autowired
	private MaThueDao maThueDao;
	
	@Override
	public List<MaThueDTO> getListMT() {
		List<MaThueDTO> liMaThueDTOs = new ArrayList<MaThueDTO>();
		List<MaThue> liMaThues = maThueDao.getListMT();
		for(MaThue m:liMaThues) {
			MaThueDTO maThueDTO = new MaThueDTO();
			maThueDTO.setId(m.getId());
			maThueDTO.setEndDate(m.getEndDate());
			maThueDTO.setStartDate(m.getStartDate());
			maThueDTO.setMaST(m.getMaST());
			
			liMaThueDTOs.add(maThueDTO);
		}
		return liMaThueDTOs;
	}

	@Override
	public void createMT(MaThueDTO m) {
		// TODO Auto-generated method stub
		MaThue maThue = new MaThue();
		maThue.setMaST(m.getMaST());
		maThue.setStartDate(m.getStartDate());
		maThue.setEndDate(m.getEndDate());
		
		maThueDao.createMT(maThue);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		MaThue maThue = maThueDao.getById(id);
		maThueDao.delete(maThue);
	}

	@Override
	public void update(MaThueDTO m) {
		// TODO Auto-generated method stub
		MaThue maThue = new MaThue();
		maThue.setMaST(m.getMaST());
		maThue.setStartDate(m.getStartDate());
		maThue.setEndDate(m.getEndDate());
		
		maThueDao.update(maThue);
	}

	@Override
	public MaThueDTO getById(int id) {
		MaThue m = maThueDao.getById(id);
		MaThueDTO maThue = new MaThueDTO();
		maThue.setId(id);
		maThue.setMaST(m.getMaST());
		maThue.setStartDate(m.getStartDate());
		maThue.setEndDate(m.getEndDate());
		
		
		return maThue;
	}

}
