package com.ceragem.crm.camp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ceragem.crm.sys.service.AbstractCrmService;
import com.ceragem.crm.camp.dao.CrmCampBdgetBasDao;
import com.ceragem.crm.sys.dao.ICrmDao;

/**
 * 
 * @ClassName    CrmCampBdgetBasService
 * @author    user
 * @date    2022. 6. 12.
 * @Version    1.0
 * @description    캠페인발송예산관리 Service
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CrmCampBdgetBasService extends AbstractCrmService {
   @Autowired
   CrmCampBdgetBasDao dao;

   @Override
   public ICrmDao getDao() {
       return dao;
   }
}
