package com.ceragem.crm.mem.dao;

import com.ceragem.crm.sys.mapper.CrmMapper;

import java.util.List;

import com.ceragem.crm.sys.dao.ICrmDao;

@CrmMapper
public interface PartnerHomeDao extends ICrmDao {
	
	<T> List<T> getExecvdempList(Object param);
	
	<T> List<T> getAllExecvdempList(Object param);
	
	int getExecvdempListCount(Object param);
	
	int insertExecvdemp(Object param);
	
	int deleteExecvdemp(Object param);
}
