package com.ceragem.crm.cst.dao;

import com.ceragem.crm.sys.mapper.CrmMapper;
import com.ceragem.crm.sys.dao.ICrmDao;

@CrmMapper
public interface CusKnownpersonListDao extends ICrmDao {
	
	int updateAcqieRelCd(Object param);
}
