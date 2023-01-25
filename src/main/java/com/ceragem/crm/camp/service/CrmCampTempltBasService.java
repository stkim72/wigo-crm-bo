package com.ceragem.crm.camp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ceragem.crm.sys.service.AbstractCrmService;
import com.ceragem.crm.camp.dao.CrmCampTempltBasDao;
import com.ceragem.crm.sys.dao.ICrmDao;

/**
 * 
 * @ClassName    CrmCampTempltBasService
 * @author    user
 * @date    2022. 6. 9.
 * @Version    1.0
 * @description    캠페인템플릿기본 Service
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CrmCampTempltBasService extends AbstractCrmService {
   @Autowired
   CrmCampTempltBasDao dao;

   @Override
   public ICrmDao getDao() {
       return dao;
   }
}
