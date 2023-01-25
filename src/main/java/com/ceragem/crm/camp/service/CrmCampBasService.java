package com.ceragem.crm.camp.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceragem.crm.camp.dao.CrmCampBasDao;
import com.ceragem.crm.camp.dao.CrmCampTgtGrpBasDao;
import com.ceragem.crm.camp.dao.CrmCampTgtrBasDao;
import com.ceragem.crm.camp.model.CrmCampBasVo;
import com.ceragem.crm.camp.model.CrmCampTgtGrpBasVo;
import com.ceragem.crm.common.model.EzMap;
import com.ceragem.crm.common.util.Utilities;
import com.ceragem.crm.cst.dao.CrmCustGrpBasDao;
import com.ceragem.crm.cst.service.CrmCustGrpBasService;
import com.ceragem.crm.sys.dao.ICrmDao;
import com.ceragem.crm.sys.service.AbstractCrmService;

/**
 * 
 * @ClassName CrmCampBasService
 * @author user
 * @date 2022. 5. 2.
 * @Version 1.0
 * @description CRM캠페인기본 Service
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */

@Service
public class CrmCampBasService extends AbstractCrmService {

	@Autowired
	CrmCampBasDao dao;

	@Autowired
	CrmCampTgtGrpBasDao grpDao;

	@Autowired
	CrmCampTgtrBasDao grpCusDao;

	@Autowired
	CrmCustGrpBasDao custGrpDao;

	@Autowired
	CrmCustGrpBasService grpService;

	@Override
	public ICrmDao getDao() {
		return dao;
	}

	public int saveBenfit(CrmCampBasVo vo) {
		return dao.saveBenfit(vo);
	}

	public int updateCampStatus(CrmCampBasVo vo) {
		return dao.updateCampStatus(vo);
	}

	public <T> List<T> getIndirectUserList(Object param) throws Exception {
		return dao.getIndirectUserList(param);
	}

	public int getIndirectUserListCount(Object param) throws Exception {
		return dao.getIndirectUserListCount(param);
	}
	
	public int getselectCustGrp(CrmCampBasVo param) throws Exception {
		return dao.selectCustGrp(param);
	}

	public int saveAll(CrmCampBasVo vo) throws Exception {

		int rtnCusCnt = 0;
		

		// 2차 저장시 부모 캠페인이 있고,
		// 1차 종료후 일자가 있다면 캠페인 실행 일자를 구한다
		// 매번 1차 캠페인의 종료일을 가져와서 업데이트 해야 한다.

		if (!"".equals(vo.getPrntsCampBasNo()) && vo.getEndAftrDayCnt() != null && vo.getPrntsCampBasNo() != null
				&& vo.getEndAftrDayCnt() != null) {

			CrmCampBasVo orgInfo = Utilities.beanToBean(vo, CrmCampBasVo.class);
			orgInfo.setCampBasNo(vo.getPrntsCampBasNo());
			CrmCampBasVo info = dao.select(orgInfo);

			Calendar cal = Calendar.getInstance();
			DateFormat df = new SimpleDateFormat("yyyyMMdd", Locale.KOREA);
			cal.setTime(df.parse(info.getCampEndYmd()));
			cal.add(Calendar.DATE, vo.getEndAftrDayCnt());

			vo.setCampStaYmd(df.format(cal.getTime()));
			vo.setCampEndYmd(df.format(cal.getTime()));

		}

		// 캠페인 기본 내역 저장
		EzMap rtnMap = save(vo);

		if ("C".equals(vo.getStat())) {
			if (Integer.parseInt(rtnMap.get("insert").toString()) > 0) {
				rtnCusCnt = Integer.parseInt(rtnMap.get("insert").toString());
			}
		} else {
			if (Integer.parseInt(rtnMap.get("update").toString()) > 0) {
				rtnCusCnt = Integer.parseInt(rtnMap.get("update").toString());
			}
		}

		// 캠페인 대상그룹 저장
		// CrmCustGrpBasVo custGrpInfo = custGrpDao.selectGroupBasInfo(vo);
		CrmCampTgtGrpBasVo crmCampTgtGrpBasVo = new CrmCampTgtGrpBasVo();

		crmCampTgtGrpBasVo.setCampBasNo(vo.getCampBasNo()); // 캠페인 고유 코드
		crmCampTgtGrpBasVo.setCustGrpNo(vo.getApplyGrpNo()); // 대상군 그룹 코드

		// 고객그룹에서 쿼리 저장을 안하고 있어서 가져오기 힘듬
		// CrmCustGrpBasVo rtnQry = grpService.getTargetQuery(vo);

		crmCampTgtGrpBasVo.setTgtExtrSqlCtnts(null); // 쿼리내용
		crmCampTgtGrpBasVo.setDspChlCd("CRM");
		crmCampTgtGrpBasVo.setRegChlCd("CRM");
		crmCampTgtGrpBasVo.setDspYn("Y");

		if ("C".equals(vo.getStat())) {

			// 캠페인 그룹 저장
			grpDao.grpSave(crmCampTgtGrpBasVo);

			// 캠페인 대상그룹 고객 저장
			rtnCusCnt += grpCusDao.grpCusSave(crmCampTgtGrpBasVo);

		} else {

			// 업데이트일 경우 CAMP_TGT_GRP_BAS_NO 를 읽어온다.
			CrmCampTgtGrpBasVo crmCampTgtGrpBasVo2 = grpDao.select(crmCampTgtGrpBasVo);
			String yetCustGrpNo = vo.getYetGrpNo();

			if (crmCampTgtGrpBasVo2 == null) {

				crmCampTgtGrpBasVo2 = new CrmCampTgtGrpBasVo();
				crmCampTgtGrpBasVo2.setCustGrpNo(vo.getApplyGrpNo());
				crmCampTgtGrpBasVo2.setCampBasNo(vo.getCampBasNo());

				// 캠페인 그룹 저장
				rtnCusCnt += grpDao.grpSave(crmCampTgtGrpBasVo);
				crmCampTgtGrpBasVo2.setCampTgtGrpBasNo(crmCampTgtGrpBasVo.getCampTgtGrpBasNo());

				// 캠페인 대상그룹 고객 저장
				// rtnCusCnt = grpCusDao.grpCusSave(crmCampTgtGrpBasVo);

			} else {

				if (!vo.getApplyGrpNo().equals(yetCustGrpNo)) {

					crmCampTgtGrpBasVo2.setCustGrpNo(vo.getApplyGrpNo());
					crmCampTgtGrpBasVo2.setCampBasNo(vo.getCampBasNo());

					rtnCusCnt += grpDao.update(crmCampTgtGrpBasVo2);

				}

			}

			// 이전 그룹코드와 수정 그룹코드가 같다면 업데이트 하지 않는다. 틀릴경우만 업데이트 함
			if (!vo.getApplyGrpNo().equals(yetCustGrpNo)) {

				// 캠페인 대상그룹 고객 저장
				grpCusDao.delete(crmCampTgtGrpBasVo2);
				rtnCusCnt += grpCusDao.grpCusSave(crmCampTgtGrpBasVo2);

				// 1차 캠페인인데 반응 2차 캠페인 있다면.
//			    if( !"".equals( vo.getLowRspnCampNo() ) ) {
//
//			    	crmCampTgtGrpBasVo2.setCampTgtGrpBasNo(null);
//			    	crmCampTgtGrpBasVo2.setCampBasNo( vo.getLowRspnCampNo() );
//			    	grpCusDao.delete(crmCampTgtGrpBasVo2);
//					//rtnCusCnt = grpCusDao.grpCusSave(crmCampTgtGrpBasVo2);
//					 
//			    }
//			    
//			    // 1차 캠페인인데 미반응 2차 캠페인 있다면.
//			    if( !"".equals( vo.getLowRspnDnaCampNo() ) ) {
//			    	crmCampTgtGrpBasVo2.setCampTgtGrpBasNo(null);
//			    	crmCampTgtGrpBasVo2.setCampBasNo( vo.getLowRspnDnaCampNo() );
//			    	grpCusDao.delete(crmCampTgtGrpBasVo2);
//					//rtnCusCnt = grpCusDao.grpCusSave(crmCampTgtGrpBasVo2);
//			    	
//			    }

			}

		}

		return rtnCusCnt;
	}

	// 테스트 메세지 전송
	public int sndTstMsg(CrmCampBasVo vo) {

		CrmCampBasVo campBasVo = dao.select(vo);
		campBasVo.setTestSmsNo(vo.getTestSmsNo());
		campBasVo.setItgCustNo(vo.getItgCustNo());
		campBasVo.setCustNm(vo.getCustNm());
		int tstMsgCnt = 0;

		if (campBasVo != null) {

			// 캠페인에서 포인트를 지급한다면.
			if ("09".equals(vo.getZ023Group())) {

				if (Integer.valueOf(campBasVo.getApplyPoint()) > 0) {
					campBasVo.setZ023Group("09");
					campBasVo.setCustNm("포인트테스트");
					campBasVo.setItgCustNo("CST8888888888");

					if ("PUSH".equals(vo.getSendType())) {
						tstMsgCnt += dao.insertPush(campBasVo);
					} else {
						tstMsgCnt += dao.insertMsg(campBasVo);
					}
				}

			}

			else if ("10".equals(vo.getZ023Group())) {
				// 캠페인에서 쿠폰을 지급한다면.
				if (!"".equals(campBasVo.getApplyCoupnBasNo())) {
					campBasVo.setZ023Group("10");
					campBasVo.setCustNm("쿠폰테스트");
					campBasVo.setItgCustNo("CST9999999999");
					if ("PUSH".equals(vo.getSendType())) {
						tstMsgCnt += dao.insertPush(campBasVo);
					} else {
						tstMsgCnt += dao.insertMsg(campBasVo);
					}
				}
			}

			else if ("11".equals(vo.getZ023Group())) {
				// 캠페인에서 쿠폰,포인트를 지급한다면.
				// if( !"".equals(campBasVo.getApplyCoupnBasNo() ) ) {
				campBasVo.setZ023Group("11");
				campBasVo.setCustNm("쿠폰,포인트테스트");
				campBasVo.setItgCustNo("CST777777777");
				if ("PUSH".equals(vo.getSendType())) {
					tstMsgCnt += dao.insertPush(campBasVo);
				} else {
					tstMsgCnt += dao.insertMsg(campBasVo);
				}
				// }

			}

		}

		return tstMsgCnt;
	}

}
