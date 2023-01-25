package com.ceragem.crm.cst.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ceragem.crm.sys.service.AbstractCrmService;
import com.ceragem.crm.cst.dao.CusCampaignListDao;
import com.ceragem.crm.sys.dao.ICrmDao;

/**
 * 
 * @ClassName    CusCampaignListService
 * @author    황의겸
 * @date    2022. 4. 27.
 * @Version    1.0
 * @description    CRM프로모션이력 Service
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CusCampaignListService extends AbstractCrmService {
   @Autowired
   CusCampaignListDao dao;

   @Override
   public ICrmDao getDao() {
       return dao;
   }
}
