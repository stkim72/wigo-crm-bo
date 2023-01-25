package com.ceragem.crm.memship.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceragem.crm.common.model.EzApiException;
import com.ceragem.crm.common.model.EzMap;
import com.ceragem.crm.common.util.Constants;
import com.ceragem.crm.common.util.Utilities;
import com.ceragem.crm.memship.dao.CrmMshipCoupnBasDao;
import com.ceragem.crm.memship.model.CrmMshipCoupnBasVo;
import com.ceragem.crm.memship.model.CrmMshipCoupnPubCustVo;
import com.ceragem.crm.sys.dao.ICrmDao;
import com.ceragem.crm.sys.service.AbstractCrmService;

/**
 * 
 * @ClassName CrmMshipCoupnBasService
 * @author 김성태
 * @date 2022. 4. 7.
 * @Version 1.0
 * @description CRM멤버십쿠폰기본 Service
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CrmMshipCoupnBasService extends AbstractCrmService {
	@Autowired
	CrmMshipCoupnBasDao dao;
	List<String> custNoList;

	@Override
	public ICrmDao getDao() {
		return dao;
	}

	public int pubCouponAll(CrmMshipCoupnBasVo vo) throws Exception {

		CrmMshipCoupnBasVo voTem = get(vo);

		long now = System.currentTimeMillis();
		String toDay = new SimpleDateFormat("yyyyMMdd", Locale.KOREA).format(now);
		if (Integer.parseInt(voTem.getToPblsStdDay()) < Integer.parseInt(toDay)
				|| Integer.parseInt(voTem.getFromPblsStdDay()) > Integer.parseInt(toDay)) {
			throw new EzApiException(Constants._API_COUPN_OVER_DAY_DATA, Constants._API_COUPN_OVER_DAY_DATA_MSG);
		}

		int dayCoupnCnt = dao.getDayCoupnCnt(voTem); // 당일 발급된수량
		int maxIssueCnt = voTem.getMaxIssueCnt(); // 마스터 설정 수량
		int otherCnt = maxIssueCnt - dayCoupnCnt;

		EzMap param = new EzMap(voTem);

		param.put("cpnMshpGradeCd", voTem.getApplyMshpGradeCtnts().toString().split(","));
		param.put("coupnTgtCd", voTem.getCoupnTgtCd());
		param.put("custNo", vo.getCustNoList());
		param.put("grpNo", vo.getCustGrpNoList());

		int count = dao.getPubCustListCount(param);

		if ((otherCnt < 0) || (count > otherCnt)) {
			throw new EzApiException(Constants._API_COUPN_OVER_ISSUE_DATA, Constants._API_COUPN_OVER_ISSUE_DATA_MSG);
		}

		return dao.pubCouponAll(param);

	}

	public int pubStoreCoupon(CrmMshipCoupnBasVo vo) throws Exception {

		CrmMshipCoupnBasVo voTem = get(vo);

		long now = System.currentTimeMillis();
		String toDay = new SimpleDateFormat("yyyyMMdd", Locale.KOREA).format(now);
		if (Integer.parseInt(voTem.getToPblsStdDay()) < Integer.parseInt(toDay)
				|| Integer.parseInt(voTem.getFromPblsStdDay()) > Integer.parseInt(toDay)) {
			throw new EzApiException(Constants._API_COUPN_OVER_DAY_DATA, Constants._API_COUPN_OVER_DAY_DATA_MSG);
		}

		int dayCoupnCnt = dao.getDayCoupnCnt(voTem); // 당일 발급된수량
		int maxIssueCnt = voTem.getMaxIssueCnt(); // 마스터 설정 수량
		int otherCnt = maxIssueCnt - dayCoupnCnt;

		// 일최대 발급 체크
		if ((otherCnt < 0) || (vo.getPubCoupnCnt() > otherCnt)) {
			throw new EzApiException(Constants._API_COUPN_OVER_ISSUE_DATA, Constants._API_COUPN_OVER_ISSUE_DATA_MSG);
		}

		return dao.pubStroeCoupon(vo);
	}

	public int pubCouponCust(CrmMshipCoupnBasVo vo) {

		int custCnt = 0;
		if (vo.getCustNoList() != null)
			custCnt = dao.pubCoupon(vo);
		return custCnt;

	}

	public int pubCouponGrp(CrmMshipCoupnBasVo vo) {

		int custGrpCnt = 0;
		if (vo.getCustGrpNoList() != null)
			custGrpCnt = dao.pubGrpCoupon(vo);
		return custGrpCnt;

	}

	public List<CrmMshipCoupnPubCustVo> getPubCustList(EzMap param) throws Exception {

		List<String> custNoList = new ArrayList<>();
		List<String> custNos = new ArrayList<>();
		if (!StringUtils.isBlank(String.valueOf(param.get("custNo")))) {
			custNos = Arrays.asList(String.valueOf(param.get("custNo")).split(",", -1));
			for (String str : custNos) {
				custNoList.add(str);
			}
			param.put("custNo", custNoList);
		}

		if (!StringUtils.isBlank(String.valueOf(param.get("custGrpNo")))) {
			String[] custGrpNo = String.valueOf(param.get("custGrpNo")).split(",", -1);
			param.put("grpNo", custGrpNo);
		}

		CrmMshipCoupnBasVo vo = get(param);
		long now = System.currentTimeMillis();
		String toDay = new SimpleDateFormat("yyyyMMdd", Locale.KOREA).format(now);
		if (Integer.parseInt(vo.getToPblsStdDay()) < Integer.parseInt(toDay)
				|| Integer.parseInt(vo.getFromPblsStdDay()) > Integer.parseInt(toDay)) {
			throw new EzApiException(Constants._API_COUPN_OVER_DAY_DATA, Constants._API_COUPN_OVER_DAY_DATA_MSG);
		}

		param.put("cpnMshpGradeCd", vo.getApplyMshpGradeCtnts().toString().split(","));
		param.put("coupnTgtCd", vo.getCoupnTgtCd());

		// ----------------------------------
//		int dayCoupnCnt = 
		dao.getDayCoupnCnt(vo); // 당일 발급수량
//		int maxIssueCnt = 
		vo.getMaxIssueCnt();
//		int otherCnt = maxIssueCnt - dayCoupnCnt;

		return dao.getPubCustList(param);
	}

	public int getPubCustCount(EzMap param) {
		return dao.getPubCustCount(param);
	}

	public List<CrmMshipCoupnBasVo> searchCoupnList(EzMap param) {
		return dao.searchCoupnList(param);
	}

	public int searchCoupnListCount(EzMap param) {
		return dao.searchCoupnListCount(param);
	}

	public int getDayCoupnCnt(CrmMshipCoupnBasVo vo) {
		return dao.getDayCoupnCnt(vo);
	}

	public List<EzMap> getTargetSearchList(EzMap param) {
		return dao.getTargetSearchList(param);
	}

	public List<String> getCustGrpNo(EzMap grpNo) {
		return dao.getCustGrpNo(grpNo);
	}

	public int getTargetSearchCount(EzMap param) {
		return dao.getTargetSearchCount(param);
	}

	public List<EzMap> getTargetSearchListForAll(EzMap param) {
		return dao.getTargetSearchListForAll(param);
	}

	public String getCoupnNoForCust(EzMap inHisPrm) {
		return dao.getCoupnNoForCust(inHisPrm);
	}

	public EzMap getCoupnInfoForLast(CrmMshipCoupnBasVo vo) {
		return dao.getCoupnInfoForLast(vo);
	}

	public EzMap getCoupnInfo(CrmMshipCoupnBasVo vo) {
		return dao.getCoupnInfo(vo);
	}

	public List<EzMap> getCustPhonDecrypt(List<String> custHp) {
		return dao.getCustPhonDecrypt(custHp);
	}

	public int sendMsgCoupn(List<EzMap> sendData) {
		return dao.sendMsgCoupn(sendData);
	}

	@SuppressWarnings("unchecked")
	public EzMap sendMsgCoupnInfo(EzMap param) {

		List<EzMap> result = new ArrayList<EzMap>();

		List<EzMap> list = (List<EzMap>) param.get("arrJson");
		String clientId = (String) param.get("clientId");
		String campId = (String) param.get("campId");

		List<String> custHp = new ArrayList<String>();

		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> jdata = list.get(i);
			if (Utilities.isNotEmpty(jdata.get("itgCustNo"))) {
				custHp.add((String) jdata.get("itgCustNo"));
			}
		}

		List<EzMap> decPh = dao.getCustPhonDecrypt(custHp);

		List<EzMap> sendData = new ArrayList<EzMap>();
		int memSeq = 1;
		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> data = list.get(i);
			if (Utilities.isNotEmpty(data.get("itgCustNo")) && data.get("issuUseYn").equals("N")) {
				for (EzMap phon : decPh) {
					if (Utilities.isNotEmpty(phon.get("itgCustNo"))
							&& data.get("itgCustNo").equals(phon.get("itgCustNo"))) {
						EzMap sms = new EzMap();
						sms.put("clientId", clientId);
						sms.put("campId", campId);
						sms.put("memSeq", memSeq);
						sms.put("itgCustNo", data.get("itgCustNo"));
						sms.put("custNm", data.get("custNm"));
						sms.put("mphonNo", phon.get("mphonNo"));
						sms.put("emailAddr", phon.get("emailAddr"));
						sms.put("coupnPblsBasNo", data.get("coupnPblsBasNo"));
						sms.put("coupnBasNm", data.get("coupnBasNm"));
						sms.put("condToDt", data.get("condToDt")); // 유효기간
						sendData.add(sms);
					}
					memSeq++;
				}
			}
		}
		result.add(Utilities.getInsertResult(sendMsgCoupn(sendData), sendData));

		return Utilities.getSaveResult(result);
	}

	public int copyStor(EzMap cpyData) {
		return dao.copyStor(cpyData);
	}

	public int copyGods(EzMap cpyData) {
		return dao.copyGods(cpyData);
	}

	public int copyChls(EzMap cpyData) {
		return dao.copyChls(cpyData);
	}

	public int getCustCoupnCnt(CrmMshipCoupnBasVo vo) {
		return dao.getCustCoupnCnt(vo);
	}

	public int getPubCustListCount(EzMap param) {
		return dao.getPubCustListCount(param);
	}

	public Object sendMsgCoupnAll(EzMap param) {

		List<EzMap> result = new ArrayList<EzMap>();

		String clientId = (String) param.get("clientId");
		String campId = (String) param.get("campId");

		List<EzMap> list = dao.searchCoupnListAll(param);
		List<EzMap> sendData = new ArrayList<EzMap>();
		int memSeq = 1;
		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> data = list.get(i);
			if (Utilities.isNotEmpty(data.get("itgCustNo")) && data.get("issuUseYn").equals("N")
					&& data.get("mphonNo").toString().toCharArray().length < 13) {

				EzMap sms = new EzMap();
				sms.put("clientId", clientId);
				sms.put("campId", campId);
				sms.put("memSeq", memSeq);
				sms.put("itgCustNo", data.get("itgCustNo"));
				sms.put("custNm", data.get("custNm"));
				sms.put("mphonNo", data.get("mphonNo"));
				sms.put("emailAddr", data.get("emailAddr"));
				sms.put("coupnPblsBasNo", data.get("coupnPblsBasNo"));
				sms.put("coupnBasNm", data.get("coupnBasNm"));
				sms.put("condToDt", data.get("condToDt")); // 유효기간
				sendData.add(sms);

				memSeq++;
			}
		}
		result.add(Utilities.getInsertResult(sendMsgCoupn(sendData), sendData));

		return Utilities.getSaveResult(result);
	}

}
