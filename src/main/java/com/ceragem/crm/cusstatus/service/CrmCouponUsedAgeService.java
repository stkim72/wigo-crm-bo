package com.ceragem.crm.cusstatus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceragem.crm.common.model.EzMap;
import com.ceragem.crm.cusstatus.dao.CrmCouponUsedAgeDao;
import com.ceragem.crm.sys.dao.ICrmDao;
import com.ceragem.crm.sys.service.AbstractCrmService;

import lombok.RequiredArgsConstructor;

/**
 * @author Seo Dong Min(dm.seo@kt.com)
 *
 */
@Service
@RequiredArgsConstructor
public class CrmCouponUsedAgeService extends AbstractCrmService {
	
	@Autowired
	private final CrmCouponUsedAgeDao dao;

	@Override
	public ICrmDao getDao() {
		return dao;
	}

	public List<EzMap> getCoupnUseAge10List(EzMap param) {
		return dao.getCoupnUseAge10List(param);
	}

	public List<EzMap> getCoupnUseAge20List(EzMap param) {
		return dao.getCoupnUseAge20List(param);
	}

	public List<EzMap> getCoupnUseAge30List(EzMap param) {
		return dao.getCoupnUseAge30List(param);
	}

	public List<EzMap> getCoupnUseAge40List(EzMap param) {
		return dao.getCoupnUseAge40List(param);
	}

	public List<EzMap> getCoupnUseAge50List(EzMap param) {
		return dao.getCoupnUseAge50List(param);
	}

	public List<EzMap> getCoupnUseAge60List(EzMap param) {
		return dao.getCoupnUseAge60List(param);
	}

	public List<EzMap> getCoupnUseAge70List(EzMap param) {
		return dao.getCoupnUseAge70List(param);
	}

	public List<EzMap> getCoupnUseAge99List(EzMap param) {
		return dao.getCoupnUseAge99List(param);
	}

	public List<EzMap> getCoupnUseAgeTot(EzMap param) {
		return dao.getCoupnUseAgeTot(param);
	}

	public List<EzMap> getCoupnUseAgeGndr(EzMap param) {
		return dao.getCoupnUseAgeGndr(param);
	}

	
}
