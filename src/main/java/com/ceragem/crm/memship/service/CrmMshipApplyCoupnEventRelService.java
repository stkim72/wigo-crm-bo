package com.ceragem.crm.memship.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ceragem.crm.sys.service.AbstractCrmService;
import com.ceragem.crm.memship.dao.CrmMshipApplyCoupnEventRelDao;
import com.ceragem.crm.sys.dao.ICrmDao;

/**
 * 
 * @ClassName    CrmMshipApplyCoupnEventRelService
 * @author    user
 * @date    2022. 5. 13.
 * @Version    1.0
 * @description    맴버십기본정책-이벤트쿠폰정책 Service
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CrmMshipApplyCoupnEventRelService extends AbstractCrmService {
   @Autowired
   CrmMshipApplyCoupnEventRelDao dao;

   @Override
   public ICrmDao getDao() {
       return dao;
   }
}
