package com.organisation.tourism.service;

import java.util.List;

import com.organisation.tourism.entity.TourPackage;
import com.organisation.tourism.entity.UserManage;

public interface TourismService {
	public List<TourPackage> getAllTourPackage();
	public void savePackageDetails(TourPackage tourPackage);
	public TourPackage getPackageDetail(int id);
	public void deletePackage(int id);
	public List<UserManage> getAllUsers();
	public List<TourPackage> getResultList(String fromLocation, String toLocation);


}
