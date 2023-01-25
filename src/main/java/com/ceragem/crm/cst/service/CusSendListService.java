package com.ceragem.crm.cst.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ceragem.crm.sys.service.AbstractCrmService;
import com.ceragem.crm.cst.dao.CusSendListDao;
import com.ceragem.crm.sys.dao.ICrmDao;

/**
 * 
 * @ClassName    CusSendListService
 * @author    황의겸
 * @date    2022. 4. 22.
 * @Version    1.0
 * @description    CRM발송이력 Service
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CusSendListService extends AbstractCrmService {
   @Autowired
   CusSendListDao dao;

   @Override
   public ICrmDao getDao() {
       return dao;
   }
}
