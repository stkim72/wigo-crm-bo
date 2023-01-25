package com.ceragem.crm.mem.dao;

import com.ceragem.crm.sys.mapper.CrmMapper;
import com.ceragem.crm.mem.model.StipulationListVo;
import com.ceragem.crm.sys.dao.ICrmDao;

@CrmMapper
public interface StipulationListDao extends ICrmDao {
	StipulationListVo getKey() throws Exception;
}