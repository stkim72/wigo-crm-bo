package com.ceragem.crm.cst.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceragem.crm.cst.dao.PurchasingCusDao;
import com.ceragem.crm.sys.dao.ICrmDao;
import com.ceragem.crm.sys.service.AbstractCrmService;

/**
 * 
 * @ClassName    PurchasingCusService
 * @author    황의겸
 * @date    2022. 5. 16.
 * @Version    1.0
 * @description    CRM 구매고객기본 Service
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class PurchasingCusService extends AbstractCrmService {
   @Autowired
   PurchasingCusDao dao;

   @Override
   public ICrmDao getDao() {
       return dao;
   }
   
   public <T> List<T> selectDetail(Object param)  throws Exception {
	   return dao.selectDetail(param);
   }
   
   public int selectDetailCount(Object param)  throws Exception {
	   return dao.selectDetailCount(param);
   }
   
}
