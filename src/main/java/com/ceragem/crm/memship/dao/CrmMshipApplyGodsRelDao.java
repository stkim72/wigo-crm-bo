package com.ceragem.crm.memship.dao;

import java.util.List;
import java.util.Map;

import com.ceragem.crm.common.model.EzMap;
import com.ceragem.crm.memship.model.CrmMshipApplyGodsRelVo;
import com.ceragem.crm.sys.dao.ICrmDao;
import com.ceragem.crm.sys.mapper.CrmMapper;

@CrmMapper
public interface CrmMshipApplyGodsRelDao extends ICrmDao {

	List<CrmMshipApplyGodsRelVo> selectGodList(Map<String, Object> param);

	List<CrmMshipApplyGodsRelVo> selectAllGodList(Map<String, Object> param);

	List<EzMap> selectAllGodListForCpn(Map<String, Object> param);

}
