package com.ceragem.crm.cst.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceragem.crm.common.model.BaseVo;
import com.ceragem.crm.common.model.EzMap;
import com.ceragem.crm.common.util.Utilities;
import com.ceragem.crm.cst.dao.CusKnownpersonListDao;
import com.ceragem.crm.sys.dao.ICrmDao;
import com.ceragem.crm.sys.service.AbstractCrmService;

/**
 * 
 * @ClassName    CusKnownpersonListService
 * @author    황의겸
 * @date    2022. 4. 28.
 * @Version    1.0
 * @description    CRM지인이력 Service
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CusKnownpersonListService extends AbstractCrmService {
   @Autowired
   CusKnownpersonListDao dao;

   @Override
   public ICrmDao getDao() {
       return dao;
   }
   
   public EzMap saveAcqieRelCd(BaseVo vo) throws Exception {
	   return Utilities.getUpdateResult(updateAcqieRelCd(vo), vo);
   }
   
   public int updateAcqieRelCd(Object param)  throws Exception {
	   return dao.updateAcqieRelCd(param);
   }
   
}
