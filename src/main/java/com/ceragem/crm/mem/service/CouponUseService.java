package com.ceragem.crm.mem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ceragem.crm.sys.service.AbstractCrmService;
import com.ceragem.crm.mem.dao.CouponUseDao;
import com.ceragem.crm.sys.dao.ICrmDao;

/**
 * 
 * @ClassName    CouponUseService
 * @author    황의겸
 * @date    2022. 6. 9.
 * @Version    1.0
 * @description    쿠폰사용현황 Service
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CouponUseService extends AbstractCrmService {
   @Autowired
   CouponUseDao dao;

   @Override
   public ICrmDao getDao() {
       return dao;
   }
}
