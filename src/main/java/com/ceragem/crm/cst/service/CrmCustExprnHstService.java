package com.ceragem.crm.cst.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ceragem.crm.sys.service.AbstractCrmService;
import com.ceragem.crm.cst.dao.CrmCustExprnHstDao;
import com.ceragem.crm.sys.dao.ICrmDao;

/**
 * 
 * @ClassName    CrmCustExprnHstService
 * @author    user
 * @date    2022. 6. 17.
 * @Version    1.0
 * @description    CRM고객체험이력 Service
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CrmCustExprnHstService extends AbstractCrmService {
   @Autowired
   CrmCustExprnHstDao dao;

   @Override
   public ICrmDao getDao() {
       return dao;
   }
}
