package com.ceragem.crm.cst.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ceragem.crm.sys.service.AbstractCrmService;
import com.ceragem.crm.cst.dao.CusCeraCkListDao;
import com.ceragem.crm.sys.dao.ICrmDao;

/**
 * 
 * @ClassName    CrmCustCrckHstService
 * @author    황의겸
 * @date    2022. 5. 2.
 * @Version    1.0
 * @description    CRM고객세라체크이력 Service
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CusCeraCkListService extends AbstractCrmService {
   @Autowired
   CusCeraCkListDao dao;

   @Override
   public ICrmDao getDao() {
       return dao;
   }
}
