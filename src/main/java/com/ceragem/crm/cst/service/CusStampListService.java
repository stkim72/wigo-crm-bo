package com.ceragem.crm.cst.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ceragem.crm.sys.service.AbstractCrmService;
import com.ceragem.crm.cst.dao.CusStampListDao;
import com.ceragem.crm.sys.dao.ICrmDao;

/**
 * 
 * @ClassName    CusStampListService
 * @author    황의겸
 * @date    2022. 4. 19.
 * @Version    1.0
 * @description    CRM스탬프이력 Service
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CusStampListService extends AbstractCrmService {
   @Autowired
   CusStampListDao dao;

   @Override
   public ICrmDao getDao() {
       return dao;
   }
   
   public <T> List<T> searchStmpList(Object param)  throws Exception {
       return dao.searchStmpList(param);
   }
   
   public int searchStmpListCount(Object param)  throws Exception {
       return dao.searchStmpListCount(param);
   }
   
   
}
