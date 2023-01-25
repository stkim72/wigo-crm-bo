package com.ceragem.crm.mem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ceragem.crm.common.model.EzMap;
import com.ceragem.crm.mem.dao.CrmStoreBasDao;
import com.ceragem.crm.mem.model.CrmStoreBasVo;
import com.ceragem.crm.sys.dao.ICrmDao;
import com.ceragem.crm.sys.service.AbstractCrmService;

//@Slf4j
@Service
public class CrmStoreBasService extends AbstractCrmService {
	@Autowired
	CrmStoreBasDao dao;
	
	@Value("${spring.nas.path}")
	String nasPath;

	@Override
	public ICrmDao getDao() {
		return dao;
	}
	
	//매장 기본정보 관련
	public <T> List<T> getStoreBasList(Object param)  throws Exception{
		return dao.selectStoreBasList(param);
	}
	
	public int getStoreBasListCount(Object param) throws Exception {
		return dao.selectStoreBasListCount(param);
	}
	
	public <T> List<T> getStoreBasSearchList(Object param)  throws Exception{
		return dao.selectStoreBasSearchList(param);
	}
	
	public CrmStoreBasVo getStoreBasInfo(Object param)  throws Exception{
		return dao.selectStoreBasInfo(param);
	}
	//매장 기본정보 관련
	
	//매장 회원정보 관련
	public <T> List<T> getStoreCustList(Object param)  throws Exception{
		List<T> list = dao.selectStoreCustList(param);
		
		return list;
	}
	
	public int getStoreCustPagingListCount(Object param) throws Exception {
		return dao.selectStoreCustPagingListCount(param);
	}
	
	public <T> List<T> getStoreCustPagingList(Object param)  throws Exception{
		List<T> list = dao.selectStoreCustPagingList(param);
		
		return list;
	}
	
	public int updateStoreCustMove(EzMap param) throws Exception {
		int resultVal = 0;
		String isAll = param.getString("isAll");
		if(isAll.equals("Y")) {
			resultVal = dao.updateStoreAllCustMove(param);
		}else {
			resultVal = dao.updateStoreCustMove(param);
		}
		
		return resultVal;
	}
	//매장 회원정보 관련
}
