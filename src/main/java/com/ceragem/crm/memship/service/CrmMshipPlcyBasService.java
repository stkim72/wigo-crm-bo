package com.ceragem.crm.memship.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ceragem.crm.sys.service.AbstractCrmService;
import com.ceragem.crm.memship.dao.CrmMshipPlcyBasDao;
import com.ceragem.crm.sys.dao.ICrmDao;

/**
 * 
 * @ClassName    CrmMshipPlcyBasService
 * @author    user
 * @date    2022. 4. 11.
 * @Version    1.0
 * @description    CRM멤버십정책기본 Service
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CrmMshipPlcyBasService extends AbstractCrmService {
   @Autowired
   CrmMshipPlcyBasDao dao;

   @Override
   public ICrmDao getDao() {
       return dao;
   }
}
