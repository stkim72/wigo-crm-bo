package com.ceragem.crm.cst.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceragem.crm.cst.dao.RecommendCusDao;
import com.ceragem.crm.sys.dao.ICrmDao;
import com.ceragem.crm.sys.service.AbstractCrmService;

/**
 * 
 * @ClassName    RecommendCusService
 * @author    황의겸
 * @date    2022. 5. 24.
 * @Version    1.0
 * @description    CRM 추천고객기본 Service
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class RecommendCusService extends AbstractCrmService {
   @Autowired
   RecommendCusDao dao;

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
