package com.ceragem.crm.camp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ceragem.crm.sys.service.AbstractCrmService;
import com.ceragem.crm.camp.dao.CrmCampBdgetHstDao;
import com.ceragem.crm.sys.dao.ICrmDao;

/**
 * 
 * @ClassName    CrmCampBdgetHstService
 * @author    user
 * @date    2022. 6. 22.
 * @Version    1.0
 * @description    undefined Service
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CrmCampBdgetHstService extends AbstractCrmService {
   @Autowired
   CrmCampBdgetHstDao dao;

   @Override
   public ICrmDao getDao() {
       return dao;
   }
}
