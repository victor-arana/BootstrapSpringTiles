package com.walmart.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.walmart.dao.StoreDAO;
import com.walmart.model.StoreDB;


@Repository("StoreDAO")
@SuppressWarnings("unchecked")
public class StoreDAOImpl implements StoreDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<StoreDB> getAllStores() {
		
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(StoreDB.class);
		
		return criteria.list();
	}

	@Override
	public List<StoreDB> getStoreByName(String name) {
		
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(StoreDB.class);
		
		criteria.add(Restrictions.eq("strName", name));
		
		return criteria.list();
	}

	@Override
	public boolean insertStore(StoreDB storeDB) {
		
		sessionFactory.getCurrentSession().beginTransaction();
		
		sessionFactory.getCurrentSession().save(storeDB);
		
		return true;
	}

	@Override
	public boolean updateStore(StoreDB storeDB) {
		
		sessionFactory.getCurrentSession().beginTransaction();
		
		sessionFactory.getCurrentSession().update(storeDB);
		
		return true;

	}

	@Override
	public boolean deleteStore(StoreDB storeDB) {

		sessionFactory.getCurrentSession().beginTransaction();
		
		sessionFactory.getCurrentSession().delete(storeDB);
		
		return true;
	}

	@Override
	public boolean deleteStoreByNumber(ArrayList<BigDecimal> strNumbers) {
		
		Query query = sessionFactory.getCurrentSession().getNamedQuery("storeDB.deleteStoreByNumber");
		
		if( strNumbers != null ){
			query.setParameterList("strNumbers", strNumbers);
			
			@SuppressWarnings("unused")
			int cont = query.executeUpdate();
			
			return true;
		}
		else{
			return false;
		}

	}

}
