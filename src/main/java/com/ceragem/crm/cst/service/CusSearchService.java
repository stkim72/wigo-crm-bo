package com.ceragem.crm.cst.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ceragem.crm.sys.service.AbstractCrmService;
import com.ceragem.crm.cst.dao.CusSearchDao;
import com.ceragem.crm.sys.dao.ICrmDao;

/**
 * 
 * @ClassName    CusSearchService
 * @author    황의겸
 * @date    2022. 4. 25.
 * @Version    1.0
 * @description    CRM 회원 선택 팝업 Service
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CusSearchService extends AbstractCrmService {
   @Autowired
   CusSearchDao dao;

   @Override
   public ICrmDao getDao() {
       return dao;
   }
}
