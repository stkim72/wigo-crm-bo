package com.ceragem.crm.mem.dao;

import com.ceragem.crm.sys.mapper.CrmMapper;

import java.util.List;

import com.ceragem.crm.sys.dao.ICrmDao;

@CrmMapper
public interface PromotionMonitoringDao extends ICrmDao {
	<T> List<T> getIndirectUserList(Object param);
	
	int getIndirectUserListCount(Object param);
	
	int updatePromotionStatus(Object param);
}
