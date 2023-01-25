package com.ceragem.crm.cst.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ceragem.crm.sys.service.AbstractCrmService;
import com.ceragem.crm.cst.dao.CusCardListDao;
import com.ceragem.crm.sys.dao.ICrmDao;

/**
 * 
 * @ClassName    CusCardListService
 * @author    황의겸
 * @date    2022. 4. 21.
 * @Version    1.0
 * @description    CRM카드발행이력 Service
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CusCardListService extends AbstractCrmService {
   @Autowired
   CusCardListDao dao;

   @Override
   public ICrmDao getDao() {
       return dao;
   }
}
