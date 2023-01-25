package com.ceragem.crm.memship.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceragem.crm.common.model.EzMap;
import com.ceragem.crm.memship.dao.CrmMshipApplyGodsRelDao;
import com.ceragem.crm.memship.model.CrmMshipApplyGodsRelVo;
import com.ceragem.crm.sys.dao.ICrmDao;
import com.ceragem.crm.sys.service.AbstractCrmService;

/**
 * 
 * @ClassName CrmMshipApplyGodsRelService
 * @author user
 * @date 2022. 4. 15.
 * @Version 1.0
 * @description CRM멤버십적용제품관계 Service
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CrmMshipApplyGodsRelService extends AbstractCrmService {
	@Autowired
	CrmMshipApplyGodsRelDao dao;

	@Override
	public ICrmDao getDao() {
		return dao;
	}

	public List<CrmMshipApplyGodsRelVo> selectGodList(Map<String, Object> param) {
		return dao.selectGodList(param);
	}

	public List<CrmMshipApplyGodsRelVo> selectAllGodList(Map<String, Object> param) {
		return dao.selectAllGodList(param);
	}

	public List<EzMap> selectAllGodListForCpn(Map<String, Object> param) {
		return dao.selectAllGodListForCpn(param);
	}
}
