package com.ceragem.crm.cusstatus.dao;

import java.util.List;

import com.ceragem.crm.common.model.EzMap;
import com.ceragem.crm.sys.dao.ICrmDao;
import com.ceragem.crm.sys.mapper.CrmMapper;

@CrmMapper
public interface CrmCouponUsedAgeDao extends ICrmDao{

	List<EzMap> getCoupnUseAge10List(EzMap param);

	List<EzMap> getCoupnUseAge20List(EzMap param);

	List<EzMap> getCoupnUseAge30List(EzMap param);

	List<EzMap> getCoupnUseAge40List(EzMap param);

	List<EzMap> getCoupnUseAge50List(EzMap param);

	List<EzMap> getCoupnUseAge60List(EzMap param);

	List<EzMap> getCoupnUseAge70List(EzMap param);

	List<EzMap> getCoupnUseAge99List(EzMap param);

	List<EzMap> getCoupnUseAgeTot(EzMap param);

	List<EzMap> getCoupnUseAgeGndr(EzMap param);

}
