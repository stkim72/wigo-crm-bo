package com.ceragem.crm.sys.dao;

import com.ceragem.crm.sys.mapper.CrmMapper;

@CrmMapper
public interface CrmGrpEmpRelDao extends ICrmDao {
	void deleteGrpCd(Object param) throws Exception;
}
