package com.ceragem.crm.memship.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceragem.crm.memship.dao.CrmStorBasDao;
import com.ceragem.crm.memship.model.CrmStorBasVo;
import com.ceragem.crm.sys.dao.ICrmDao;
import com.ceragem.crm.sys.service.AbstractCrmService;

/**
 * 
 * @ClassName    CrmStorBasService
 * @author    user
 * @date    2022. 4. 21.
 * @Version    1.0
 * @description    CRM매장기본 Service
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CrmStorBasService extends AbstractCrmService {
	
   @Autowired
   CrmStorBasDao dao;

   @Override
   public ICrmDao getDao() {
       return dao;
   }


    public List<CrmStorBasVo>  getTreeList(Map<String, Object> param) {
		return dao.selectTreeList(param);
	}


	public List<CrmStorBasVo> getStoreList(Map<String, Object> param) {
		return dao.selectStoreList(param);
	}



}
