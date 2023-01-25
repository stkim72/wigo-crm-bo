package com.ceragem.crm.camp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ceragem.crm.sys.service.AbstractCrmService;
import com.ceragem.crm.camp.dao.CrmCampChlBasDao;
import com.ceragem.crm.sys.dao.ICrmDao;

/**
 * 
 * @ClassName    CrmCampChlBasService
 * @author    user
 * @date    2022. 6. 11.
 * @Version    1.0
 * @description    캠페인발송채널기본 Service
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CrmCampChlBasService extends AbstractCrmService {
   @Autowired
   CrmCampChlBasDao dao;

   @Override
   public ICrmDao getDao() {
       return dao;
   }
}
