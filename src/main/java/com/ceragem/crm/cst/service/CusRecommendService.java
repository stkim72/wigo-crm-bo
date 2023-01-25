package com.ceragem.crm.cst.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceragem.crm.cst.dao.CusRecommendDao;
import com.ceragem.crm.sys.dao.ICrmDao;
import com.ceragem.crm.sys.service.AbstractCrmService;

/**
 * 
 * @ClassName   CusRecommendService
 * @author      황재희
 * @date        2022. 4. 28.
 * @Version     1.0
 * @description 제휴사 목록 Service
 * @Company     Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CusRecommendService extends AbstractCrmService {
   @Autowired
   CusRecommendDao dao;

   @Override
   public ICrmDao getDao() {
       return dao;
   }
   
}
