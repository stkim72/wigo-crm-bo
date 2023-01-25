package com.ceragem.crm.camp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ceragem.crm.sys.service.AbstractCrmService;
import com.ceragem.crm.camp.dao.CrmCampDspHstDao;
import com.ceragem.crm.sys.dao.ICrmDao;

/**
 * 
 * @ClassName    CrmCampDspHstService
 * @author    user
 * @date    2022. 6. 24.
 * @Version    1.0
 * @description    CRM캠페인발송이력 Service
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CrmCampDspHstService extends AbstractCrmService {
   @Autowired
   CrmCampDspHstDao dao;

   @Override
   public ICrmDao getDao() {
       return dao;
   }
}
