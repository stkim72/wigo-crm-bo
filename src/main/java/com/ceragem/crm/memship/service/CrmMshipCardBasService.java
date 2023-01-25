package com.ceragem.crm.memship.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceragem.crm.memship.dao.CrmMshipCardBasDao;
import com.ceragem.crm.memship.model.CrmCardPblsHstVo;
import com.ceragem.crm.sys.dao.ICrmDao;
import com.ceragem.crm.sys.service.AbstractCrmService;

/**
 * 
 * @ClassName    CrmMshipCardBasService
 * @author    user
 * @date    2022. 4. 28.
 * @Version    1.0
 * @description    CRM멤버십카드기본 Service
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CrmMshipCardBasService extends AbstractCrmService {
   @Autowired
   CrmMshipCardBasDao dao;

   @Override
   public ICrmDao getDao() {
       return dao;
   }

	public long pubCard(CrmCardPblsHstVo vo) {	
		return dao.pubCard(vo);
	}
}
