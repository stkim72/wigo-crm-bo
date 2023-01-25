package com.ceragem.crm.cst.dao;

import com.ceragem.crm.sys.mapper.CrmMapper;

import java.util.List;

import com.ceragem.crm.sys.dao.ICrmDao;

@CrmMapper
public interface LoyalCusDao extends ICrmDao {
	
	<T> List<T> selectBosCntrtDetail(Object param);
	
	int selectBosCntrtDetailCount(Object param);
	
	<T> List<T> selectRcmdDetail(Object param);
	
	int selectRcmdDetailCount(Object param);
}
