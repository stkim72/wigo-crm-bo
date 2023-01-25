package com.ceragem.crm.memship.dao;

import com.ceragem.crm.memship.model.CrmAdvncmtHstVo;
import com.ceragem.crm.sys.dao.ICrmDao;
import com.ceragem.crm.sys.mapper.CrmMapper;

@CrmMapper
public interface CrmAdvncmtHstDao extends ICrmDao {

	int saveAdvncmtHst(CrmAdvncmtHstVo vo);

}
