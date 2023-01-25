package com.ceragem.crm.cst.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ceragem.crm.sys.service.AbstractCrmService;
import com.ceragem.crm.cst.dao.CusCouponListDao;
import com.ceragem.crm.sys.dao.ICrmDao;

/**
 * 
 * @ClassName    CusCouponListService
 * @author    황의겸
 * @date    2022. 4. 13.
 * @Version    1.0
 * @description    CRM쿠폰이력 Service
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CusCouponListService extends AbstractCrmService {
   @Autowired
   CusCouponListDao dao;

   @Override
   public ICrmDao getDao() {
       return dao;
   }
}
