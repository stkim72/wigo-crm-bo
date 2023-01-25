package com.ceragem.crm.memship.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ceragem.crm.sys.service.AbstractCrmService;
import com.ceragem.crm.memship.dao.CrmMshipPrvCoupnRelDao;
import com.ceragem.crm.sys.dao.ICrmDao;

/**
 * 
 * @ClassName    CrmMshipPrvCoupnRelService
 * @author    user
 * @date    2022. 4. 20.
 * @Version    1.0
 * @description    CRM멤버십제공쿠폰관계 Service
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CrmMshipPrvCoupnRelService extends AbstractCrmService {
   @Autowired
   CrmMshipPrvCoupnRelDao dao;

   @Override
   public ICrmDao getDao() {
       return dao;
   }
}
