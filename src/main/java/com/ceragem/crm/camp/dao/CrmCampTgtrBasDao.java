package com.ceragem.crm.camp.dao;

import com.ceragem.crm.camp.model.CrmCampTgtGrpBasVo;
import com.ceragem.crm.sys.dao.ICrmDao;
import com.ceragem.crm.sys.mapper.CrmMapper;

@CrmMapper
public interface CrmCampTgtrBasDao extends ICrmDao {

	int grpCusSave(CrmCampTgtGrpBasVo vo);

}
