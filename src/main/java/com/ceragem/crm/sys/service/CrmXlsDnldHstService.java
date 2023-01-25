package com.ceragem.crm.sys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceragem.crm.common.util.Utilities;
import com.ceragem.crm.sys.dao.CrmSnstvInfoInqryHstDao;
import com.ceragem.crm.sys.dao.CrmXlsDnldHstDao;
import com.ceragem.crm.sys.dao.ICrmDao;
import com.ceragem.crm.sys.model.CrmXlsDnldHstVo;

@Service
public class CrmXlsDnldHstService extends AbstractCrmService {
	@Autowired
	CrmXlsDnldHstDao dao;
	
	@Autowired
	CrmSnstvInfoInqryHstDao inqDao;

	@Override
	public ICrmDao getDao() {
		return dao;
	}

	public void addLog(CrmXlsDnldHstVo vo) {
		String menuCd = Utilities.getCurrentMenuCd();
		if (Utilities.isEmpty(menuCd))
			return;
		vo.setMenuCd(menuCd);
		dao.insert(vo);
		
//		if(Utilities.isNotEmpty(vo.getDnldTxn())  && Utilities.isNotEmpty(vo.getPfmWorkCd()) ) {
//			vo.setIndiInfoHandlPrsnNo(Utilities.getLoginUserCd());
//			vo.setConnPrsnIpAddr(Utilities.getPeerIp());
//			vo.setRegChlCd("CRM");
//			inqDao.insert(vo);
//		}

	}
}
