package com.ceragem.crm.memship.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceragem.crm.common.model.EzMap;
import com.ceragem.crm.main.model.CrmCustBasVo;
import com.ceragem.crm.memship.dao.CrmCardPblsHstDao;
import com.ceragem.crm.memship.model.CrmCardCustBasVo;
import com.ceragem.crm.memship.model.CrmCardPblsHstVo;
import com.ceragem.crm.sys.dao.ICrmDao;
import com.ceragem.crm.sys.service.AbstractCrmService;

/**
 * 
 * @ClassName    CrmCardPblsHstService
 * @author    user
 * @date    2022. 5. 4.
 * @Version    1.0
 * @description    CRM카드발행이력 Service
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CrmCardPblsHstService extends AbstractCrmService {
   @Autowired
   CrmCardPblsHstDao dao;

   
   @Override
   public ICrmDao getDao() {
       return dao;
   }

	public CrmCustBasVo getCustInfo(CrmCardPblsHstVo vo) {
		return dao.getCustInfo(vo);
	}

	public List<CrmCardCustBasVo> getCustInfo(EzMap param) {
		return dao.getCustInfo(param);
	}

	public int getCustListCount(EzMap param) {
		return  dao.getCustListCount(param);
	}


}
