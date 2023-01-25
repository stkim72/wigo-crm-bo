package com.ceragem.crm.cst.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ceragem.crm.sys.service.AbstractCrmService;
import com.ceragem.crm.cst.dao.LoyalCusDao;
import com.ceragem.crm.sys.dao.ICrmDao;

/**
 * 
 * @ClassName    LoyalCusService
 * @author    황의겸
 * @date    2022. 5. 16.
 * @Version    1.0
 * @description    CRM 충성고객기본 Service
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class LoyalCusService extends AbstractCrmService {
   @Autowired
   LoyalCusDao dao;

   @Override
   public ICrmDao getDao() {
       return dao;
   }
   
   public <T> List<T> selectBosCntrtDetail(Object param)  throws Exception {
	   return dao.selectBosCntrtDetail(param);
   }
   
   public int selectBosCntrtDetailCount(Object param)  throws Exception {
	   return dao.selectBosCntrtDetailCount(param);
   }
   
   public <T> List<T> selectRcmdDetail(Object param)  throws Exception {
	   return dao.selectRcmdDetail(param);
   }
   
   public int selectRcmdDetailCount(Object param)  throws Exception {
	   return dao.selectRcmdDetailCount(param);
   }
}
