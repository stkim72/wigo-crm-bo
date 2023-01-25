package com.ceragem.crm.mem.dao;

import com.ceragem.crm.sys.mapper.CrmMapper;

import java.util.List;

import com.ceragem.crm.sys.dao.ICrmDao;

@CrmMapper
public interface PointUseDao extends ICrmDao {
	
	<T> List<T> getMonthPointSumList(Object param);
	<T> List<T> getMonthPointList(Object param);
	<T> List<T> getPointExtinctionList(Object param);
	int getPointExtinctionListCount(Object param);
}
