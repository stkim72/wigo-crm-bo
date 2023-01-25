package com.ceragem.crm.cusstatus.dao;

import java.util.List;

import com.ceragem.crm.sys.dao.ICrmDao;
import com.ceragem.crm.sys.mapper.CrmMapper;

@CrmMapper
public interface CrmCouponUsedDao extends ICrmDao{
	List<String> barLabels();
	List<String> barLabels(String storNoGraph, String custNmGraph, String stndDateYGraph, String stndDateMGraph, String coupnTypeCdGraph);
	List<Integer> barData();
	List<Integer> barData(String storNoGraph, String custNmGraph, String stndDateYGraph, String stndDateMGraph, String coupnTypeCdGraph);
}
