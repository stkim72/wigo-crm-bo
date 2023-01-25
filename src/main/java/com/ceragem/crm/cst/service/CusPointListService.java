package com.ceragem.crm.cst.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ceragem.crm.sys.service.AbstractCrmService;
import com.ceragem.crm.cst.dao.CusPointListDao;
import com.ceragem.crm.sys.dao.ICrmDao;

/**
 * 
 * @ClassName    CusPointListService
 * @author    황의겸
 * @date    2022. 4. 15.
 * @Version    1.0
 * @description    CRM포인트이력 Service
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CusPointListService extends AbstractCrmService {
   @Autowired
   CusPointListDao dao;

   @Override
   public ICrmDao getDao() {
       return dao;
   }
}
