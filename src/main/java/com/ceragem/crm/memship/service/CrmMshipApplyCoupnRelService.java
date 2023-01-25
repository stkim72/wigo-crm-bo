package com.ceragem.crm.memship.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ceragem.crm.sys.service.AbstractCrmService;
import com.ceragem.crm.memship.dao.CrmMshipApplyCoupnRelDao;
import com.ceragem.crm.sys.dao.ICrmDao;

/**
 * 
 * @ClassName    CrmMshipApplyCoupnRelService
 * @author    user
 * @date    2022. 5. 12.
 * @Version    1.0
 * @description    undefined Service
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CrmMshipApplyCoupnRelService extends AbstractCrmService {
   @Autowired
   CrmMshipApplyCoupnRelDao dao;

   @Override
   public ICrmDao getDao() {
       return dao;
   }
}
