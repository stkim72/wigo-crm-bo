package com.ceragem.crm.camp.dao;

import com.ceragem.crm.sys.mapper.CrmMapper;

import java.util.List;


import com.ceragem.crm.camp.model.CrmCampBasVo;
import com.ceragem.crm.sys.dao.ICrmDao;

@CrmMapper
public interface CrmCampBasDao extends ICrmDao {

	int saveBenfit(CrmCampBasVo vo);
	int updateCampStatus(CrmCampBasVo vo);
	
	<T> List<T> getIndirectUserList(Object param);
	
	int getIndirectUserListCount(Object param);

	int insertMsg(CrmCampBasVo vo);
	int insertPush(CrmCampBasVo campBasVo);
	int selectCustGrp(CrmCampBasVo param);
	

}

