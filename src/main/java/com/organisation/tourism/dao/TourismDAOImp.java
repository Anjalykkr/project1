package com.organisation.tourism.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.organisation.tourism.entity.TourPackage;
import com.organisation.tourism.entity.UserManage;

@Repository
public class TourismDAOImp implements TourismDAO {
	
	@Autowired
	private SessionFactory factory;

	@Override
	public List<TourPackage> getAllTourPackage() {
		Session sn=factory.getCurrentSession();
		Query<TourPackage> query=sn.createQuery("from TourPackage",TourPackage.class);
		List<TourPackage> listOfPackages=query.getResultList();
		return listOfPackages;
	}

	@Override
	public void savePackageDetails(TourPackage tourPackage) {
		Session sn=factory.getCurrentSession();
		sn.saveOrUpdate(tourPackage);

	}

	@Override
	public TourPackage getPackageDetail(int id) {
		Session sn=factory.getCurrentSession();
		TourPackage tourPackage=sn.get(TourPackage.class, id);
		return tourPackage;
	}

	@Override
	public void deletePackage(int id) {
		Session sn=factory.getCurrentSession();
		Query<TourPackage> query=sn.createQuery("delete from TourPackage where id= :theId");
		query.setParameter("theId", id);
		query.executeUpdate();
	}

	@Override
	public List<UserManage> getAllUsers() {
		Session sn=factory.getCurrentSession();
		Query<UserManage> query=sn.createQuery("from UserManage",UserManage.class);
		List<UserManage> listOfUsers=query.getResultList();
		return listOfUsers;
	}
	@Override
	public List<TourPackage> getResultList(String fromLocation, String toLocation) {
		Session sn = factory.getCurrentSession();
		Query<TourPackage> query = sn.createQuery("from TourPackage where from_location = :fromLocation and to_location = :toLocation", TourPackage.class);
		query.setParameter("fromLocation", fromLocation);
		query.setParameter("toLocation", toLocation);
		List<TourPackage> resultList = query.getResultList();
		return resultList;
	}

}
