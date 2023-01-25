package com.ceragem.crm.cst.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ceragem.crm.sys.service.AbstractCrmService;
import com.ceragem.crm.cst.dao.CusSurveyListDao;
import com.ceragem.crm.sys.dao.ICrmDao;

/**
 * 
 * @ClassName    CusSurveyListService
 * @author    황의겸
 * @date    2022. 4. 27.
 * @Version    1.0
 * @description    CRM설문이력 Service
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CusSurveyListService extends AbstractCrmService {
   @Autowired
   CusSurveyListDao dao;

   @Override
   public ICrmDao getDao() {
       return dao;
   }
}
