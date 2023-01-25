package com.ceragem.crm.cst.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ceragem.crm.sys.service.AbstractCrmService;
import com.ceragem.crm.cst.dao.CrmCustPosSaleHstDao;
import com.ceragem.crm.sys.dao.ICrmDao;

/**
 * 
 * @ClassName    CrmCustPosSaleHstService
 * @author    user
 * @date    2022. 6. 16.
 * @Version    1.0
 * @description    CRMPOS매출이력 Service
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CrmCustPosSaleHstService extends AbstractCrmService {
   @Autowired
   CrmCustPosSaleHstDao dao;

   @Override
   public ICrmDao getDao() {
       return dao;
   }
}
