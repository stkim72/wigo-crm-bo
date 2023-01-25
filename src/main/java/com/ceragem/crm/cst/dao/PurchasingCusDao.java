package com.ceragem.crm.cst.dao;

import com.ceragem.crm.sys.mapper.CrmMapper;

import java.util.List;
import com.ceragem.crm.sys.dao.ICrmDao;

@CrmMapper
public interface PurchasingCusDao extends ICrmDao {
	
	<T> List<T> selectDetail(Object param);
	
	int selectDetailCount(Object param);
	
}
