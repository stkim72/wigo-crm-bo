package com.ceragem.crm.cusstatus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceragem.crm.common.model.EzMap;
import com.ceragem.crm.cusstatus.dao.CrmCouponUsedBuysDao;
import com.ceragem.crm.sys.dao.ICrmDao;
import com.ceragem.crm.sys.service.AbstractCrmService;

import lombok.RequiredArgsConstructor;

/**
 * @author Seo Dong Min(dm.seo@kt.com)
 *
 */
@Service
@RequiredArgsConstructor
public class CrmCouponUsedBuysService extends AbstractCrmService {
	
	@Autowired
	private final CrmCouponUsedBuysDao dao;

	@Override
	public ICrmDao getDao() {
		return dao;
	}

	public List<EzMap> getCoupnMasterForSelect(EzMap param) {
		return dao.getCoupnMasterForSelect(param);
	}

	public int getCoupnMasterForSelectCount(EzMap param) {
		return dao.getCoupnMasterForSelectCount(param);
	}

	public List<EzMap> getCoupnUseBuysList(EzMap param) {
		return dao.getCoupnUseBuysList(param);
	}

	public int getCoupnUseBuysCount(EzMap param) {
		return dao.getCoupnUseBuysCount(param);
	}

	public List<EzMap> getCoupnUseBuyDetailList(EzMap param) {
		return dao.getCoupnUseBuyDetailList(param);
	}

	public int getCoupnUseBuyDetailCount(EzMap param) {
		return dao.getCoupnUseBuyDetailCount(param);
	}
	
}
