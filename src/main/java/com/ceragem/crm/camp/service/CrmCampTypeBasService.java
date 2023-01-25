package com.ceragem.crm.camp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ceragem.crm.sys.service.AbstractCrmService;
import com.ceragem.crm.camp.dao.CrmCampTypeBasDao;
import com.ceragem.crm.sys.dao.ICrmDao;

/**
 * 
 * @ClassName    CrmCampTypeBasService
 * @author    user
 * @date    2022. 6. 14.
 * @Version    1.0
 * @description    캠페인유형기본 Service
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CrmCampTypeBasService extends AbstractCrmService {
   @Autowired
   CrmCampTypeBasDao dao;

   @Override
   public ICrmDao getDao() {
       return dao;
   }
}
