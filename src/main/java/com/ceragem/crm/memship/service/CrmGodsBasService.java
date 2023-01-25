package com.ceragem.crm.memship.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceragem.crm.common.model.EzMap;
import com.ceragem.crm.memship.dao.CrmGodsBasDao;
import com.ceragem.crm.sys.dao.ICrmDao;
import com.ceragem.crm.sys.service.AbstractCrmService;

/**
 * 
 * @ClassName    CrmGodsBasService
 * @author    user
 * @date    2022. 4. 18.
 * @Version    1.0
 * @description    CRM제품기본 Service
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CrmGodsBasService extends AbstractCrmService {
   @Autowired
   CrmGodsBasDao dao;

   @Override
   public ICrmDao getDao() {
       return dao;
   }

	public List<EzMap> getGodsLclss(EzMap map) {
		return dao.getGodsLclss(map);
	}


}
