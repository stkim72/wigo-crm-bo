package com.ceragem.crm.memship.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceragem.crm.memship.dao.CrmAdvncmtHstDao;
import com.ceragem.crm.memship.model.CrmAdvncmtHstVo;
import com.ceragem.crm.sys.dao.ICrmDao;
import com.ceragem.crm.sys.service.AbstractCrmService;

/**
 * 
 * @ClassName    CrmAdvncmtHstService
 * @author    user
 * @date    2022. 5. 30.
 * @Version    1.0
 * @description    CRM승급이력 Service
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CrmAdvncmtHstService extends AbstractCrmService {
	@Autowired
	CrmAdvncmtHstDao dao;

	@Override
	public ICrmDao getDao() {
		return dao;
	}

	public int saveAdvncmtHst(CrmAdvncmtHstVo vo) throws Exception {


		// 승급점수 히스토리 작성
		// 회원 테이블 승급 내역 업데이트 

		return dao.saveAdvncmtHst(vo);
	}
}
