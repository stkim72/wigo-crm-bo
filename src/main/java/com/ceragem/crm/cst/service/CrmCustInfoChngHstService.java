package com.ceragem.crm.cst.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ceragem.crm.sys.service.AbstractCrmService;
import com.ceragem.crm.cst.dao.CrmCustInfoChngHstDao;
import com.ceragem.crm.sys.dao.ICrmDao;

/**
 * 
 * @ClassName    CrmCustInfoChngHstService
 * @author    user
 * @date    2022. 5. 18.
 * @Version    1.0
 * @description    CRM고객정보변경이력 Service
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CrmCustInfoChngHstService extends AbstractCrmService {
   @Autowired
   CrmCustInfoChngHstDao dao;

   @Override
   public ICrmDao getDao() {
       return dao;
   }
}
