package com.ceragem.crm.sys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceragem.crm.common.model.EzMap;
import com.ceragem.crm.sys.dao.CrmGrpMenuHstDao;
import com.ceragem.crm.sys.dao.CrmGrpMenuRelDao;
import com.ceragem.crm.sys.dao.ICrmDao;
import com.ceragem.crm.sys.model.CrmGrpMenuRelVo;

@Service
public class CrmGrpMenuRelService extends AbstractCrmService {
	@Autowired
	CrmGrpMenuRelDao dao;
	
	@Autowired
	CrmGrpMenuHstDao hstDao;
	@Override
	public ICrmDao getDao() {
		return dao;
	}
	@Override
	public int insert(Object param) throws Exception {
		hstDao.insert(param);
		return super.insert(param);
	}
	@Override
	public int delete(Object param) throws Exception {
		hstDao.insertDelete(param);
		return super.delete(param);
	}
	public Object saveMenuGroup(String menuCd, List<CrmGrpMenuRelVo> list) throws Exception {
		EzMap param = new EzMap();
		param.setString("menuCd", menuCd);
		dao.deleteMenuCd(param);
		return insertList(list);
	}
	public Object saveGroupMenu(String grpCd, List<CrmGrpMenuRelVo> list) throws Exception {
		EzMap param = new EzMap();
		param.setString("grpCd", grpCd);
		dao.deleteGrpCd(param);
		return insertList(list);
	}
	
}
