package com.ceragem.crm.cst.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ceragem.crm.sys.service.AbstractCrmService;
import com.ceragem.crm.cst.dao.ExpectCusDao;
import com.ceragem.crm.cst.model.ExpectCusVo;
import com.ceragem.crm.sys.dao.ICrmDao;

/**
 * 
 * @ClassName    ExpectCusService
 * @author    황의겸
 * @date    2022. 5. 16.
 * @Version    1.0
 * @description    CRM 가망고객기본 Service
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class ExpectCusService extends AbstractCrmService {
   @Autowired
   ExpectCusDao dao;

   @Override
   public ICrmDao getDao() {
       return dao;
   }
   
   public ExpectCusVo selectReceiveInfo(Object param)  throws Exception{
		return dao.selectReceiveInfo(param);
	}
   
}
