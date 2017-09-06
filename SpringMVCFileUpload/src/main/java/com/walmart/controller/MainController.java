package com.walmart.controller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.walmart.model.StoreDB;
import com.walmart.service.StoreService;

@Controller
public class MainController {
	
	@Autowired
	StoreService storeService;
	
	@RequestMapping(value="/storeAdm")
	public ModelAndView storeAdmin(){
		
		return new ModelAndView("/storeAdm");
	}

	@RequestMapping(value="/getAllStores", method=RequestMethod.POST)
	@ResponseBody
	public List<StoreDB> getAllStores(HttpServletRequest req, HttpServletResponse resp){
		
		List<StoreDB> listStoreDB = storeService.getAllStores();
		
		return listStoreDB;
	}
	
	@RequestMapping(value="/insertStore", method=RequestMethod.POST)
	@ResponseBody
	public boolean insertStore(HttpServletRequest req, HttpServletResponse resp ) throws ParseException{
		
		String storeNumber = req.getParameter("storeNumber") == null ? "": req.getParameter("storeNumber");
		String strCountryCode = req.getParameter("countryCode") == null ? "" : req.getParameter("countryCode");
		String register = req.getParameter("storeName") == null ? "": req.getParameter("storeName");
		
		StoreDB storeDB = new StoreDB();
		storeDB.setStrNumber(new BigDecimal(storeNumber));
		storeDB.setStrCountryCode(strCountryCode);
		storeDB.setStrName(register);
		
		boolean bok = storeService.insertStore(storeDB);
		return bok;
	}
	
	
	@RequestMapping(value="/deleteStore", method=RequestMethod.POST)
	@ResponseBody
	public boolean deleteStore( HttpServletRequest req, HttpServletResponse resp ) throws ParseException{
		
		String checked = req.getParameter("checked") == null ? "": req.getParameter("checked");
		
		ArrayList<BigDecimal> decArray = new ArrayList<BigDecimal>();
		
		for( String s : checked.split(",") ){
			decArray.add( new BigDecimal(s) );
		}
		
		boolean bok = storeService.deleteStoreByNumber(decArray);
		
		return bok;
	}
}
