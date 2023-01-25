package com.ceragem.crm.cst.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ceragem.crm.sys.service.AbstractCrmService;
import com.ceragem.crm.cst.dao.CusCeraDnaListDao;
import com.ceragem.crm.sys.dao.ICrmDao;

/**
 * 
 * @ClassName    CrmCustCrckDnaHstService
 * @author    황의겸
 * @date    2022. 5. 17.
 * @Version    1.0
 * @description    CRM고객세라체크DNA이력 Service
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CusCeraDnaListService extends AbstractCrmService {
   @Autowired
   CusCeraDnaListDao dao;

   @Override
   public ICrmDao getDao() {
       return dao;
   }
}
