package com.ceragem.crm.cst.dao;

import com.ceragem.crm.sys.mapper.CrmMapper;
import com.ceragem.crm.cst.model.ExpectCusVo;
import com.ceragem.crm.sys.dao.ICrmDao;

@CrmMapper
public interface ExpectCusDao extends ICrmDao {
	
	ExpectCusVo selectReceiveInfo(Object param) throws Exception;
}
