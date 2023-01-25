package com.ceragem.crm.camp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ceragem.crm.sys.service.AbstractCrmService;
import com.ceragem.crm.camp.dao.CrmCampTgtrBasDao;
import com.ceragem.crm.sys.dao.ICrmDao;

/**
 * 
 * @ClassName    CrmCampTgtrBasService
 * @author    user
 * @date    2022. 7. 24.
 * @Version    1.0
 * @description    CRM캠페인대상자기본 Service
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CrmCampTgtrBasService extends AbstractCrmService {
   @Autowired
   CrmCampTgtrBasDao dao;

   @Override
   public ICrmDao getDao() {
       return dao;
   }
}
