package com.ceragem.crm.memship.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceragem.crm.common.model.EzApiException;
import com.ceragem.crm.common.model.EzMap;
import com.ceragem.crm.common.util.Constants;
import com.ceragem.crm.common.util.Utilities;
import com.ceragem.crm.mem.model.PointIssueVo;
import com.ceragem.crm.mem.service.PointIssueService;
import com.ceragem.crm.memship.dao.CrmMshipStmpBasDao;
import com.ceragem.crm.memship.model.CrmMshipCoupnBasVo;
import com.ceragem.crm.memship.model.CrmMshipStmpBasVo;
import com.ceragem.crm.sys.dao.ICrmDao;
import com.ceragem.crm.sys.service.AbstractCrmService;

/**
 * 
 * @ClassName CrmMshipStmpBasService
 * @author Lee Kwang
 * @date 2022. 5. 17.
 * @Version 1.0
 * @description CRM멤버십스탬프기본 Service
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Service
public class CrmMshipStmpBasService extends AbstractCrmService {

	@Autowired
	CrmMshipCoupnBasService coupnBasService;

	@Autowired
	PointIssueService pointIssueService;

	@Autowired
	CrmMshipStmpBasDao dao;

	@Override
	public ICrmDao getDao() {
		return dao;
	}

	public String getMaxStmpNo() {
		return dao.getMaxStmpNo();
	}

	public int insertChlCode(EzMap prm) {
		return dao.insertChlCode(prm);
	}

	public List<EzMap> getStmpHisList(EzMap param) {
		return dao.getStmpHisList(param);
	}

	public int getStmpHisListCount(EzMap param) {
		return dao.getStmpHisListCount(param);
	}

	public int deleteStmpHis(CrmMshipStmpBasVo list) {
		return dao.deleteStmpHis(list);
	}

	public int deleteStmpStor(CrmMshipStmpBasVo list) {
		return dao.deleteStmpStor(list);
	}

	public int deleteStmpGods(CrmMshipStmpBasVo list) {
		return dao.deleteStmpGods(list);
	}

	public int deleteStmpChl(CrmMshipStmpBasVo list) {
		return dao.deleteStmpChl(list);
	}

	public int copyStmpMaster(CrmMshipStmpBasVo vo) {
		return dao.copyStmpMaster(vo);
	}

	public int copyStmpStore(EzMap parm) {
		return dao.copyStmpStore(parm);
	}

	public int copyStmpGods(EzMap parm) {
		return dao.copyStmpGods(parm);
	}

	public int copyStmpChl(EzMap parm) {
		return dao.copyStmpChl(parm);
	}

	public EzMap checkIssueHis(EzMap parm) {
		return dao.checkIssueHis(parm);
	}

	public CrmMshipStmpBasVo getStmpBasInfo(Map<String, Object> param) {
		return dao.getStmpBasInfo(param);
	}

	public List<CrmMshipStmpBasVo> searchStmpList(EzMap param) {
		return dao.searchStmpList(param);
	}

	public List<EzMap> getComnList(EzMap param) {
		return dao.getComnList(param);
	}

	public List<EzMap> getListPop(EzMap param) {
		return dao.getListPop(param);
	}

	public List<EzMap> getListPopForCust(EzMap param) {
		return dao.getListPopForCust(param);
	}

	public int getListPopForCustCount(EzMap param) {
		return dao.getListPopForCustCount(param);
	}

	public int saveStmpIssue(EzMap param) throws Exception {

		EzMap chitPrm = new EzMap();
		chitPrm.put("chitNo", String.valueOf(param.get("chitNo")));
		int chitCnt = dao.checkChitNo(chitPrm);
		if (chitCnt > 0) {
			throw new EzApiException(Constants._API_DOUBLE_CHIT_NO_DATA, Constants._API_DOUBLE_CHIT_NO_DATA_MSG);
		}

		int accumCnt = param.getInt("issueAccumCnt");

		CrmMshipStmpBasVo masterInfo = dao.getStmpBasInfo(param);

		int result = 0;

		for (int i = 0; i < accumCnt; i++) {
			EzMap hisPrm = new EzMap();
			hisPrm.put("mshipStmpBasNo", masterInfo.getMshipStmpBasNo());
			hisPrm.put("itgCustNo", String.valueOf(param.get("itgCustNo")));
			int totHisStmp = dao.getStmpTotalHist(hisPrm);

			// 판수에 찍힌 스탬프 보다 많을경우
			if (masterInfo.getStmpMaxYn().equals("N")) {
				long maxCnt = Long.parseLong(String.valueOf(masterInfo.getStmpMaxCnt()))
						* Long.parseLong(String.valueOf(masterInfo.getStmpQnty()));
				if (totHisStmp >= maxCnt) {
					continue;
				}
			}

			// 적립
			EzMap inHisPrm = new EzMap();
			inHisPrm.put("mshipStmpBasNo", masterInfo.getMshipStmpBasNo()); // 스탬프 번호
			inHisPrm.put("itgCustNo", String.valueOf(param.get("itgCustNo"))); // 회원 통합번호
			inHisPrm.put("mshipGradeCd", String.valueOf(param.get("mshipGradeCd"))); // 회원 등급
			inHisPrm.put("storNo", String.valueOf(param.get("storNo"))); // 매장 코드
			inHisPrm.put("stmpBasNm", masterInfo.getStmpBasNm()); // 스탬프 명
			inHisPrm.put("fromUsePossDt", Utilities.getDateFormat(masterInfo.getFromUsePossDt())); // from 사용가능
			inHisPrm.put("toUsePossDt", Utilities.getDateFormat(masterInfo.getToUsePossDt())); // to 사용 가능
			inHisPrm.put("chitNo", String.valueOf(param.get("chitNo"))); // 전표번호

			String hstSeq = dao.getStmpHisSeq(inHisPrm);
			EzMap seqInfo = new EzMap();

			int stmpCnt = 0;
			int issueCnt = 0;
			if (hstSeq != null) {
				seqInfo = dao.getStmpMaxSeq(hstSeq);
				stmpCnt = Integer.parseInt(String.valueOf(seqInfo.get("stmpAccumQnty")));
				issueCnt = Integer.parseInt(String.valueOf(seqInfo.get("issueCnt")));
			}

			long stmpQnty = Long.parseLong(String.valueOf(masterInfo.getStmpQnty()));
			if (stmpCnt == stmpQnty) {
				stmpCnt = 0;
				issueCnt += 1;
			}

			// 쿠폰 , 포인트 적립
			if ((stmpCnt + 1) == stmpQnty) {

				// 쿠폰 마스터 정보로 쿠폰 발급연동 MCP22051315382955708 쿠폰 마스터
				// 쿠폰,포인트 전송
				if (masterInfo.getBnfitCd().equals("001")) { // 포인트
					
					Calendar cal = Calendar.getInstance();
//					SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyyMMddHHmmss", Locale.KOREA);
					cal.setTime(new Date());
//					String extncDt = simpleDateFormat1.format(cal.getTime());
					
					PointIssueVo vo = new PointIssueVo();
					// vo.setChitNo(String.valueOf(param.get("chitNo")));
					vo.setChitNo(Utilities.getAutoSeq("CHT"));
					vo.setItgCustNo(String.valueOf(param.get("itgCustNo")));
					vo.setOccurPointScore(masterInfo.getPointScore() + "");
					vo.setPblsDivCd("903");

					EzMap ret = pointIssueService.savePointScore(vo);
					if (ret == null) {
						throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
					}
					inHisPrm.put("pointScore", masterInfo.getPointScore());

				} else if (masterInfo.getBnfitCd().equals("002")) { // 쿠폰
					CrmMshipCoupnBasVo vo = new CrmMshipCoupnBasVo();
					vo.setCustNoList(null);
					vo.setCustNo(String.valueOf(param.get("itgCustNo")));
					vo.setMshipCoupnBasNo(masterInfo.getCoupnNo());

					if (!vo.getCustNo().equals("")) {
						vo.setCustNoList(vo.getCustNo().split(",", -1));
					}

					int res = coupnBasService.pubCouponAll(vo);
					if (res == 0) {
						throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
					}
					// 쿠폰 발급된 번호
					inHisPrm.put("mshipCoupnBasNo", masterInfo.getCoupnNo());
					String coupnNo = coupnBasService.getCoupnNoForCust(inHisPrm);
					if (coupnNo == null) {
						throw new EzApiException(Constants._API_CODE_NO_DATA, Constants._API_CODE_NO_DATA_MSG);
					}
					inHisPrm.put("coupnNo", coupnNo);
				}
			}

			inHisPrm.put("stmpAccumQnty", (stmpCnt + 1)); // 스탬프수량
			inHisPrm.put("issueCnt", issueCnt); // 스탬프수량
			result = dao.insertStmpHis(inHisPrm);
		}
		return result;
	}

	public EzMap getStmpBasInfoForPopup(Map<String, Object> param) {
		return dao.getStmpBasInfoForPopup(param);
	}

	public List<EzMap> getTargetSearchListForStmp(EzMap param) {
		return dao.getTargetSearchListForStmp(param);
	}

	public int getTargetSearchForStmpCount(EzMap param) {
		return dao.getTargetSearchForStmpCount(param);
	}

	public int updateStmpInfo(CrmMshipStmpBasVo vo) {
		return dao.updateStmpInfo(vo);
	}

	public int searchStmpListCount(EzMap param) {
		return dao.searchStmpListCount(param);
	}
}
