package com.ceragem.crm.memship.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ceragem.crm.sys.service.AbstractCrmService;
import com.ceragem.crm.memship.dao.CrmCustGradeDayChngHstDao;
import com.ceragem.crm.sys.dao.ICrmDao;


/**
 * 
 * @ClassName    CrmCustGradeDayChngHstService
 * @author    user
 * @date    2022. 6. 3.
 * @Version    1.0
 * @description    CRM고객등급일일예정변경이력 Service
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CrmCustGradeDayChngHstService extends AbstractCrmService {
   @Autowired
   CrmCustGradeDayChngHstDao dao;

   @Override
   public ICrmDao getDao() {
       return dao;
   }
}
