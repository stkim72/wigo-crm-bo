package com.ceragem.crm.memship.dao;

import com.ceragem.crm.sys.mapper.CrmMapper;
import com.ceragem.crm.sys.model.CrmComnCdBaseVo;

import java.util.List;
import java.util.Map;

import com.ceragem.crm.memship.model.CrmMshipApplyChlRelVo;
import com.ceragem.crm.sys.dao.ICrmDao;

@CrmMapper
public interface CrmMshipApplyChlRelDao extends ICrmDao {


	List<CrmMshipApplyChlRelVo> selectChlList(Map<String, Object> param);

	List<CrmComnCdBaseVo> selectAllChlList(Map<String, Object> param);

}
