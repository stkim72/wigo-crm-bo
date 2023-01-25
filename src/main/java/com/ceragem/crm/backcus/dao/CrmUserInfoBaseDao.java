package com.ceragem.crm.backcus.dao;

import java.util.List;

import com.ceragem.crm.backcus.model.CrmAsDetailVo;
import com.ceragem.crm.backcus.model.CrmCollabiDetailVo;
import com.ceragem.crm.sys.dao.ICrmDao;
import com.ceragem.crm.sys.mapper.CrmMapper;

@CrmMapper
public interface CrmUserInfoBaseDao extends ICrmDao {
	<T> T collabiSelect(Object param);

	<T> T asSelect(Object param);

	<T> List<CrmCollabiDetailVo> collabiSelectList(Object param);

	<T> List<CrmAsDetailVo> asSelectList(Object param);

	<T> List<CrmAsDetailVo> asCustSelectList(Object param);
}
