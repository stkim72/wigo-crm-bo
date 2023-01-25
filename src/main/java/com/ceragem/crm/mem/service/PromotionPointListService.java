package com.ceragem.crm.mem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ceragem.crm.sys.service.AbstractCrmService;
import com.ceragem.crm.mem.dao.PromotionPointListDao;
import com.ceragem.crm.sys.dao.ICrmDao;

/**
 * 
 * @ClassName    	PromotionPointListService
 * @author    		황재희
 * @date    		2022. 5. 12.
 * @Version    		1.0
 * @description    	프로모션 탭 포인트현황 Service
 * @Company    		Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class PromotionPointListService extends AbstractCrmService {
   @Autowired
   PromotionPointListDao dao;

   @Override
   public ICrmDao getDao() {
       return dao;
   }
}
