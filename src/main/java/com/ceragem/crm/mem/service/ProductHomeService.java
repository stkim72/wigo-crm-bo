package com.ceragem.crm.mem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceragem.crm.mem.dao.ProductHomeDao;
import com.ceragem.crm.sys.dao.ICrmDao;
import com.ceragem.crm.sys.service.AbstractCrmService;

/**
 * 
 * @ClassName   ProductHomeService
 * @author      황의겸
 * @date        2022. 5. 12.
 * @Version     1.0
 * @description 제품 목록 Service
 * @Company     Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class ProductHomeService extends AbstractCrmService {
   @Autowired
   ProductHomeDao dao;

   @Override
   public ICrmDao getDao() {
       return dao;
   }
}
