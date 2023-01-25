package com.ceragem.crm.mem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ceragem.crm.sys.service.AbstractCrmService;
import com.ceragem.crm.mem.dao.CalculateStatusDao;
import com.ceragem.crm.sys.dao.ICrmDao;

/**
 * 
 * @ClassName    CalculateStatusService
 * @author    안재홍
 * @date    2022. 6. 9.
 * @Version    1.0
 * @description    정산현황 Service
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CalculateStatusService extends AbstractCrmService {
   @Autowired
   CalculateStatusDao dao;

   @Override
   public ICrmDao getDao() {
       return dao;
   }
}
