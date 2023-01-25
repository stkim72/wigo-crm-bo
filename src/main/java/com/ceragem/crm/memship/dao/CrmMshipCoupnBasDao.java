package com.ceragem.crm.memship.dao;

import java.util.List;

import com.ceragem.crm.common.model.EzMap;
import com.ceragem.crm.memship.model.CrmMshipCoupnBasVo;
import com.ceragem.crm.memship.model.CrmMshipCoupnPubCustVo;
import com.ceragem.crm.sys.dao.ICrmDao;
import com.ceragem.crm.sys.mapper.CrmMapper;

@CrmMapper
public interface CrmMshipCoupnBasDao extends ICrmDao {

	int pubCoupon(CrmMshipCoupnBasVo vo);

	int pubGrpCoupon(CrmMshipCoupnBasVo vo);

	int pubStroeCoupon(CrmMshipCoupnBasVo vo);

	List<CrmMshipCoupnPubCustVo> getPubCustList(EzMap param);

	int getPubCustCount(EzMap param);

	List<CrmMshipCoupnBasVo> searchCoupnList(EzMap param);

	int searchCoupnListCount(EzMap param);

	int getDayCoupnCnt(CrmMshipCoupnBasVo vo);

	List<EzMap> getTargetSearchList(EzMap param);

	List<String> getCustGrpNo(EzMap grpNo);

	int getTargetSearchCount(EzMap param);

	List<EzMap> getTargetSearchListForAll(EzMap param);

	String getCoupnNoForCust(EzMap inHisPrm);

	EzMap getCoupnInfoForLast(CrmMshipCoupnBasVo vo);

	EzMap getCoupnInfo(CrmMshipCoupnBasVo vo);

	List<EzMap> getCustPhonDecrypt(List<String> custHp);

	int sendMsgCoupn(List<EzMap> sendData);

	int copyStor(EzMap cpyData);

	int copyGods(EzMap cpyData);

	int copyChls(EzMap cpyData);

	int getCustCoupnCnt(CrmMshipCoupnBasVo vo);

	int getPubCustListCount(EzMap param);

	int pubCouponAll(EzMap param);

	List<EzMap> searchCoupnListAll(EzMap param);
}
