package com.ceragem.crm.cst.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ceragem.crm.sys.service.AbstractCrmService;
import com.ceragem.crm.cst.dao.CrmCustInfoPtuseAgreeHstDao;
import com.ceragem.crm.sys.dao.ICrmDao;

/**
 * 
 * @ClassName    CrmCustInfoPtuseAgreeHstService
 * @author    user
 * @date    2022. 4. 29.
 * @Version    1.0
 * @description    CRM고객정보활용동의이력 Service
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CrmCustInfoPtuseAgreeHstService extends AbstractCrmService {
   @Autowired
   CrmCustInfoPtuseAgreeHstDao dao;

   @Override
   public ICrmDao getDao() {
       return dao;
   }
}
