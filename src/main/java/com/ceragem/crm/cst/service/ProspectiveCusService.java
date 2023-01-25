package com.ceragem.crm.cst.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ceragem.crm.sys.service.AbstractCrmService;
import com.ceragem.crm.cst.dao.ProspectiveCusDao;
import com.ceragem.crm.sys.dao.ICrmDao;

/**
 * 
 * @ClassName    ProspectiveCusService
 * @author    황의겸
 * @date    2022. 5. 16.
 * @Version    1.0
 * @description    CRM 잠재고객기본 Service
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class ProspectiveCusService extends AbstractCrmService {
   @Autowired
   ProspectiveCusDao dao;

   @Override
   public ICrmDao getDao() {
       return dao;
   }
}
