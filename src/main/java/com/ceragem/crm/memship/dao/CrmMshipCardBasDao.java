package com.ceragem.crm.memship.dao;

import com.ceragem.crm.memship.model.CrmCardPblsHstVo;
import com.ceragem.crm.sys.dao.ICrmDao;
import com.ceragem.crm.sys.mapper.CrmMapper;

@CrmMapper
public interface CrmMshipCardBasDao extends ICrmDao {

	long pubCard(CrmCardPblsHstVo vo);

}
