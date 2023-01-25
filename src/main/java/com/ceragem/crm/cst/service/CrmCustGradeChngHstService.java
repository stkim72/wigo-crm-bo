package com.ceragem.crm.cst.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ceragem.crm.sys.service.AbstractCrmService;
import com.ceragem.crm.cst.dao.CrmCustGradeChngHstDao;
import com.ceragem.crm.cst.model.CrmCustGradeChngHstVo;
import com.ceragem.crm.sys.dao.ICrmDao;

/**
 * 
 * @ClassName    CrmCustGradeChngHstService
 * @author    user
 * @date    2022. 5. 17.
 * @Version    1.0
 * @description    CRM고객등급변경이력 Service
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CrmCustGradeChngHstService extends AbstractCrmService {
	@Autowired
	CrmCustGradeChngHstDao dao;

	@Override
	public ICrmDao getDao() {
		return dao;
	}

	public int insertDay(CrmCustGradeChngHstVo custGradeChngHstVo) {
		return dao.insertDay(custGradeChngHstVo);
	}
}
