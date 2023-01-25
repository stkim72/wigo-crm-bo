package com.ceragem.crm.memship.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ceragem.crm.sys.service.AbstractCrmService;
import com.ceragem.crm.memship.dao.CrmMshipApplyChlRelDao;
import com.ceragem.crm.memship.model.CrmMshipApplyChlRelVo;
import com.ceragem.crm.sys.dao.ICrmDao;
import com.ceragem.crm.sys.model.CrmComnCdBaseVo;

/**
 * 
 * @ClassName    CrmMshipApplyChlRelService
 * @author    user
 * @date    2022. 4. 21.
 * @Version    1.0
 * @description    CRM멤버십적용채널관계 Service
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CrmMshipApplyChlRelService extends AbstractCrmService {
   @Autowired
   CrmMshipApplyChlRelDao dao;

   @Override
   public ICrmDao getDao() {
       return dao;
   }

public List<CrmMshipApplyChlRelVo> selectChlList(Map<String, Object> param) {
	return dao.selectChlList(param);
}

public List<CrmComnCdBaseVo> selectAllChlList(Map<String, Object> param) {
	return dao.selectAllChlList(param);
}
}
