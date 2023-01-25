package com.ceragem.crm.mem.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ceragem.crm.common.model.EzMap;
import com.ceragem.crm.common.model.EzPaginationInfo;
import com.ceragem.crm.common.util.Utilities;
import com.ceragem.crm.mem.model.CrmStoreBasVo;
import com.ceragem.crm.mem.service.CrmStoreBasService;

/**
 * @Author 주재민
 * @date 2022.04.07
 * @description
 * 
 * CRM 고객그룹기본 Controller
 */

@Controller
@RequestMapping(value = { "storeBas", "{menuCd}/storeBas" })
public class CrmStoreBasController{

	@Autowired
	CrmStoreBasService service;

	@GetMapping(value = { "", "index" })
	public String home(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm.type3") + "mem/MB058";
	}
	
	@GetMapping(value = { "popStoreSearchInfo" })
	public String popStoreSearchInfo(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm.blank") + "mem/MB071";
	}
	
	@GetMapping(value = { "popStoreCustMove" })
	public String popStoreCustMove(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm.blank") + "mem/MB062";
	}
	
	//매장 기본정보 관련
	@PostMapping(value = { "getStoreBasList" })
	public @ResponseBody Object getStoreBasList(@RequestBody EzMap param) throws Exception {
		EzPaginationInfo page = param.getPaginationInfo();
		List<EzMap> list = service.getStoreBasList(param);
		page.setTotalRecordCount(service.getStoreBasListCount(param));
		return Utilities.getGridData(list,page);
	}
	
	@PostMapping(value = { "getStoreBasSearchList" })
	public @ResponseBody Object getStoreBasSearchList(@RequestBody EzMap param) throws Exception {
		EzPaginationInfo page = param.getPaginationInfo();
		List<EzMap> list = service.getStoreBasSearchList(param);
		page.setTotalRecordCount(list.size());
		return Utilities.getGridData(list,page);
	}
	
	@PostMapping(value = { "getStoreBasInfo" })
	public @ResponseBody Object getStoreBasInfo(@RequestBody EzMap param) throws Exception {
		CrmStoreBasVo info = service.getStoreBasInfo(param);
		return info;
	}
	//매장 기본정보 관련
	
	//매장 회원정보 관련
	@PostMapping(value = { "getStoreCustList" })
	public @ResponseBody Object getStoreCustList(@RequestBody EzMap param) throws Exception {
		EzPaginationInfo page = param.getPaginationInfo();
		List<EzMap> list = service.getStoreCustList(param);
		page.setTotalRecordCount(list.size());
		return Utilities.getGridData(list,page);
	}
	
	@PostMapping(value = { "getStoreCustPagingList" })
	public @ResponseBody Object getStoreCustPagingList(@RequestBody EzMap param) throws Exception {
		EzPaginationInfo page = param.getPaginationInfo();
		List<EzMap> list = service.getStoreCustPagingList(param);
		page.setTotalRecordCount(service.getStoreCustPagingListCount(param));
		return Utilities.getGridData(list,page);
	}
	
	@PostMapping(value = { "updStoreCustMove" })
	public @ResponseBody Object updStoreCustMove(@RequestBody EzMap param) throws Exception {
		return service.updateStoreCustMove(param);
	}
	//매장 회원정보 관련
}
