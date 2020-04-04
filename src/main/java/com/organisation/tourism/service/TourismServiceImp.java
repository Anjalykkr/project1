package com.organisation.tourism.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.organisation.tourism.dao.TourismDAO;
import com.organisation.tourism.entity.TourPackage;
import com.organisation.tourism.entity.UserManage;

@Service
public class TourismServiceImp implements TourismService {
	
	@Autowired
	TourismDAO tourismDao;

	@Override
	@Transactional
	public List<TourPackage> getAllTourPackage() {
		return tourismDao.getAllTourPackage();
	}

	@Override
	@Transactional
	public void savePackageDetails(TourPackage tourPackage) {
		tourismDao.savePackageDetails(tourPackage);
	}

	@Override
	@Transactional
	public TourPackage getPackageDetail(int id) {
		return tourismDao.getPackageDetail(id);
	}

	@Override
	@Transactional
	public void deletePackage(int id) {
		tourismDao.deletePackage(id);
	}

	@Override
	@Transactional
	public List<UserManage> getAllUsers() {
		
		return tourismDao.getAllUsers();
	}
	@Override
	@Transactional
	public List<TourPackage> getResultList(String fromLocation, String toLocation) {
		return tourismDao.getResultList(fromLocation, toLocation);
	}

}
