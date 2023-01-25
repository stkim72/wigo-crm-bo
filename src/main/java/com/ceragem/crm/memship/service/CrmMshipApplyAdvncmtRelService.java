package com.ceragem.crm.memship.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ceragem.crm.sys.service.AbstractCrmService;
import com.ceragem.crm.memship.dao.CrmMshipApplyAdvncmtRelDao;
import com.ceragem.crm.sys.dao.ICrmDao;

/**
 * 
 * @ClassName    CrmMshipApplyAdvncmtRelService
 * @author    user
 * @date    2022. 5. 15.
 * @Version    1.0
 * @description    맴버십기본정책-승급점수정책 Service
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CrmMshipApplyAdvncmtRelService extends AbstractCrmService {
   @Autowired
   CrmMshipApplyAdvncmtRelDao dao;

   @Override
   public ICrmDao getDao() {
       return dao;
   }
}
