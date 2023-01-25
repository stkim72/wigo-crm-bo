package com.ceragem.crm.memship.dao;

import com.ceragem.crm.sys.mapper.CrmMapper;

import java.util.List;
import java.util.Map;

import com.ceragem.crm.common.model.EzMap;
import com.ceragem.crm.memship.model.CrmGodsBasVo;
import com.ceragem.crm.memship.model.CrmStorBasVo;
import com.ceragem.crm.sys.dao.ICrmDao;

@CrmMapper
public interface CrmGodsBasDao extends ICrmDao {

	List<CrmStorBasVo> selectGodList(Map<String, Object> param);

	List<CrmGodsBasVo> selectAllGodList(Map<String, Object> param);

	List<EzMap> getGodsLclss(EzMap map);

}
