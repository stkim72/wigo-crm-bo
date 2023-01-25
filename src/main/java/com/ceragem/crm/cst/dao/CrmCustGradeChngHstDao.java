package com.ceragem.crm.cst.dao;

import com.ceragem.crm.sys.mapper.CrmMapper;
import com.ceragem.crm.cst.model.CrmCustGradeChngHstVo;
import com.ceragem.crm.sys.dao.ICrmDao;

@CrmMapper
public interface CrmCustGradeChngHstDao extends ICrmDao {

	int insertDay(CrmCustGradeChngHstVo custGradeChngHstVo);

}
