package com.ceragem.crm.memship.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceragem.crm.memship.dao.CrmMshipApplyStorRelDao;
import com.ceragem.crm.sys.dao.ICrmDao;
import com.ceragem.crm.sys.service.AbstractCrmService;

/**
 * 
 * @ClassName    CrmMshipApplyStorRelService
 * @author    user
 * @date    2022. 4. 21.
 * @Version    1.0
 * @description    CRM멤버십적용매장관계 Service
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CrmMshipApplyStorRelService extends AbstractCrmService {
   @Autowired
   CrmMshipApplyStorRelDao dao;

   @Override
   public ICrmDao getDao() {
       return dao;
   }


}
