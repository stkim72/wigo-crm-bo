package com.ceragem.crm.mem.dao;

import java.util.List;

import com.ceragem.crm.mem.model.CrmStoreBasVo;
import com.ceragem.crm.sys.dao.ICrmDao;
import com.ceragem.crm.sys.mapper.CrmMapper;

@CrmMapper
public interface CrmStoreBasDao extends ICrmDao {
	//매장 기본정보 관련
	<T> List<T> selectStoreBasList(Object param);
	int selectStoreBasListCount(Object param);
	<T> List<T> selectStoreBasSearchList(Object param);
	CrmStoreBasVo selectStoreBasInfo(Object param) throws Exception;
	//매장 기본정보 관련
	
	//매장 회원정보 관련
	<T> List<T> selectStoreCustList(Object param);
	int selectStoreCustPagingListCount(Object param);
	<T> List<T> selectStoreCustPagingList(Object param);
	int updateStoreAllCustMove(Object param);
	int updateStoreCustMove(Object param);
	//매장 회원정보 관련
}
