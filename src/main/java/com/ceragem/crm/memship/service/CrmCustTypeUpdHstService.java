package com.ceragem.crm.memship.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ceragem.crm.sys.service.AbstractCrmService;
import com.ceragem.crm.memship.dao.CrmCustTypeUpdHstDao;
import com.ceragem.crm.sys.dao.ICrmDao;

/**
 * 
 * @ClassName    CrmCustTypeUpdHstService
 * @author    user
 * @date    2022. 7. 3.
 * @Version    1.0
 * @description    고객유형업데이트이력 Service
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CrmCustTypeUpdHstService extends AbstractCrmService {
   @Autowired
   CrmCustTypeUpdHstDao dao;

   @Override
   public ICrmDao getDao() {
       return dao;
   }
}
