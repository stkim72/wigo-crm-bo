package com.ceragem.crm.cst.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ceragem.crm.sys.service.AbstractCrmService;
import com.ceragem.crm.cst.dao.CrmCustPatronStorBasDao;
import com.ceragem.crm.sys.dao.ICrmDao;

/**
 * 
 * @ClassName    CrmCustPatronStorBasService
 * @author    user
 * @date    2022. 5. 23.
 * @Version    1.0
 * @description    CRM고객단골매장기본 Service
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CrmCustPatronStorBasService extends AbstractCrmService {
   @Autowired
   CrmCustPatronStorBasDao dao;

   @Override
   public ICrmDao getDao() {
       return dao;
   }
}
