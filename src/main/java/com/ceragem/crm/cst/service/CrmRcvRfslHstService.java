package com.ceragem.crm.cst.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ceragem.crm.sys.service.AbstractCrmService;
import com.ceragem.crm.cst.dao.CrmRcvRfslHstDao;
import com.ceragem.crm.sys.dao.ICrmDao;

/**
 * 
 * @ClassName    CrmRcvRfslHstService
 * @author    user
 * @date    2022. 4. 29.
 * @Version    1.0
 * @description    CRM수신거부이력 Service
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CrmRcvRfslHstService extends AbstractCrmService {
   @Autowired
   CrmRcvRfslHstDao dao;

   @Override
   public ICrmDao getDao() {
       return dao;
   }
}
