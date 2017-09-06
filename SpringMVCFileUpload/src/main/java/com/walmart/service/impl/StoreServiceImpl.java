package com.walmart.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.walmart.dao.StoreDAO;
import com.walmart.model.StoreDB;
import com.walmart.service.StoreService;

@Service("StoreService")
@Transactional
public class StoreServiceImpl implements StoreService {
	
	@Autowired
	private StoreDAO storeDao;

	@Override
	public List<StoreDB> getAllStores() {
		return storeDao.getAllStores();
	}

	@Override
	public List<StoreDB> getStoreByName(String name) {
		return storeDao.getStoreByName(name);
	}

	@Override
	public boolean insertStore(StoreDB storeDB) {
		return storeDao.insertStore(storeDB);
	}

	@Override
	public boolean updateStore(StoreDB storeDB) {
		return storeDao.updateStore(storeDB);
	}

	@Override
	public boolean deleteStore(StoreDB storeDB) {
		return storeDao.deleteStore(storeDB);
	}

	@Override
	public boolean deleteStoreByNumber(ArrayList<BigDecimal> strNumber) {
		return storeDao.deleteStoreByNumber(strNumber);
	}

}
