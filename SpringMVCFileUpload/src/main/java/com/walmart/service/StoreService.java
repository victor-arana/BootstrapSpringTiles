package com.walmart.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.walmart.model.StoreDB;

public interface StoreService {
	
	public List<StoreDB> getAllStores();
	
	public List<StoreDB> getStoreByName(String name);
	
	public boolean insertStore(StoreDB storeDB);
	
	public boolean updateStore(StoreDB storeDB);
	
	public boolean deleteStore(StoreDB storeDB);
	
	public boolean deleteStoreByNumber(ArrayList<BigDecimal> strNumber);

}
