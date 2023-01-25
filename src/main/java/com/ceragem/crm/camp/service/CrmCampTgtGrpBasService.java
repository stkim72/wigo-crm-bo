package com.ceragem.crm.camp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ceragem.crm.sys.service.AbstractCrmService;
import com.ceragem.crm.camp.dao.CrmCampTgtGrpBasDao;
import com.ceragem.crm.sys.dao.ICrmDao;

/**
 * 
 * @ClassName    CrmCampTgtGrpBasService
 * @author    user
 * @date    2022. 7. 24.
 * @Version    1.0
 * @description    CRM캠페인대상그룹기본 Service
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CrmCampTgtGrpBasService extends AbstractCrmService {
   @Autowired
   CrmCampTgtGrpBasDao dao;

   @Override
   public ICrmDao getDao() {
       return dao;
   }
}
