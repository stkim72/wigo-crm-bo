package com.ceragem.crm.mem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ceragem.crm.sys.service.AbstractCrmService;
import com.ceragem.crm.mem.dao.StipulationListDao;
import com.ceragem.crm.mem.model.StipulationListVo;
import com.ceragem.crm.sys.dao.ICrmDao;

/**
 * 
 * @ClassName   StipulationListService
 * @author      황재희
 * @date        2022. 4. 8.
 * @Version     1.0
 * @description 약관 목록 Service
 * @Company     Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class StipulationListService extends AbstractCrmService {
   @Autowired
   StipulationListDao dao;

   @Override
   public ICrmDao getDao() {
       return dao;
   }
   
   public StipulationListVo getKey()  throws Exception{
		return dao.getKey();
	}
}