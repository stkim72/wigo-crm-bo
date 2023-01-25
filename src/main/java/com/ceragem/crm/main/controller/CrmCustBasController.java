package com.ceragem.crm.main.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ceragem.crm.common.model.EzApiException;
import com.ceragem.crm.common.model.EzMap;
import com.ceragem.crm.common.model.EzPaginationInfo;
import com.ceragem.crm.common.util.Constants;
import com.ceragem.crm.common.util.Utilities;
import com.ceragem.crm.cst.model.CrmCustAsSubmitHistVo;
import com.ceragem.crm.cst.model.CrmCustBosCntrtTxnDtlVo;
import com.ceragem.crm.cst.model.CrmCustCntplcBasVo;
import com.ceragem.crm.cst.model.CrmCustExprnHstVo;
import com.ceragem.crm.cst.model.CrmCustGradeChngHstVo;
import com.ceragem.crm.cst.model.CrmCustHshldBasVo;
import com.ceragem.crm.cst.model.CrmCustInfoChngHstVo;
import com.ceragem.crm.cst.model.CrmCustInfoPtuseAgreeHstVo;
import com.ceragem.crm.cst.model.CrmCustPatronStorBasVo;
import com.ceragem.crm.cst.model.CrmCustPhnCnslDtlHistVo;
import com.ceragem.crm.cst.model.CrmCustPosSaleHstVo;
import com.ceragem.crm.cst.model.CrmRcvRfslHstVo;
import com.ceragem.crm.cst.model.CusCampaignListVo;
import com.ceragem.crm.cst.model.CusCardListVo;
import com.ceragem.crm.cst.model.CusCeraCkListVo;
import com.ceragem.crm.cst.model.CusCeraDnaListVo;
import com.ceragem.crm.cst.model.CusCeraIotListVo;
import com.ceragem.crm.cst.model.CusCouponListVo;
import com.ceragem.crm.cst.model.CusKnownpersonListVo;
import com.ceragem.crm.cst.model.CusPointListVo;
import com.ceragem.crm.cst.model.CusRecommendVo;
import com.ceragem.crm.cst.model.CusSendListVo;
import com.ceragem.crm.cst.model.CusStampListVo;
import com.ceragem.crm.cst.model.CusSurveyListVo;
import com.ceragem.crm.cst.service.CrmCustAsSubmitHistService;
import com.ceragem.crm.cst.service.CrmCustBosCntrtHstService;
import com.ceragem.crm.cst.service.CrmCustBosCntrtTxnHCService;
import com.ceragem.crm.cst.service.CrmCustBosHcHstService;
import com.ceragem.crm.cst.service.CrmCustCntplcBasService;
import com.ceragem.crm.cst.service.CrmCustExprnHstService;
import com.ceragem.crm.cst.service.CrmCustGradeChngHstService;
import com.ceragem.crm.cst.service.CrmCustHshldBasService;
import com.ceragem.crm.cst.service.CrmCustInfoChngHstService;
import com.ceragem.crm.cst.service.CrmCustInfoPtuseAgreeHstService;
import com.ceragem.crm.cst.service.CrmCustPatronStorBasService;
import com.ceragem.crm.cst.service.CrmCustPhnCnslDtlHistService;
import com.ceragem.crm.cst.service.CrmCustPhnCnslHistService;
import com.ceragem.crm.cst.service.CrmCustPosSaleHstService;
import com.ceragem.crm.cst.service.CrmCustSynthesisHstService;
import com.ceragem.crm.cst.service.CrmRcvRfslHstService;
import com.ceragem.crm.cst.service.CusCampaignListService;
import com.ceragem.crm.cst.service.CusCardListService;
import com.ceragem.crm.cst.service.CusCeraCkListService;
import com.ceragem.crm.cst.service.CusCeraDnaListService;
import com.ceragem.crm.cst.service.CusCeraIotListService;
import com.ceragem.crm.cst.service.CusCouponListService;
import com.ceragem.crm.cst.service.CusKnownpersonListService;
import com.ceragem.crm.cst.service.CusLoginListService;
import com.ceragem.crm.cst.service.CusPointListService;
import com.ceragem.crm.cst.service.CusRecommendService;
import com.ceragem.crm.cst.service.CusSendListService;
import com.ceragem.crm.cst.service.CusStampListService;
import com.ceragem.crm.cst.service.CusSurveyListService;
import com.ceragem.crm.main.model.CrmCustBasVo;
import com.ceragem.crm.main.service.CrmCustBasService;
import com.ceragem.crm.mem.model.PointIssueVo;
import com.ceragem.crm.mem.service.PointIssueService;
import com.ceragem.crm.memship.model.CrmAdvncmtHstVo;
import com.ceragem.crm.memship.model.CrmCardPblsHstVo;
import com.ceragem.crm.memship.model.CrmMshipCoupnBasVo;
import com.ceragem.crm.memship.service.CrmAdvncmtHstService;
import com.ceragem.crm.memship.service.CrmMshipCardBasService;
import com.ceragem.crm.memship.service.CrmMshipCoupnBasService;
import com.ceragem.crm.memship.service.CrmMshipStmpBasService;

/**
 * 
 * @ClassName    CrmCustBasController
 * @author    user
 * @date    2022. 4. 19.
 * @Version    1.0
 * @description    CRM고객기본 Controller
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */

/**
 * @author jDaddy
 *
 */
/**
 * @author jDaddy
 *
 */
@Controller
@RequestMapping(value = { "crmCustBas", "{menuCd}/crmCustBas" })
public class CrmCustBasController {

	@Autowired
	CrmCustBasService service;

	// eon
	@Value("${spring.eon.send.url}")
	String eonUrl;

	@Value("${spring.eon.send.user}")
	String eonUser;

	@Autowired
	CrmCustCntplcBasService crmCustCntplcBasService;

//CSV : 종합이력
	@Autowired
	CrmCustSynthesisHstService crmCustSynthesisHstService;

// 회원이력
	@Autowired
	CusCouponListService couponService;
	@Autowired
	CusPointListService pointService;
	@Autowired
	CusStampListService stampService;
	@Autowired
	CusCardListService cardService;
	@Autowired
	CusSendListService sendService;
	@Autowired
	CusKnownpersonListService knownpersonService;
	@Autowired
	CusSurveyListService surveyService;
	@Autowired
	CusCampaignListService campaignService;
	@Autowired
	CusLoginListService loginService;
	@Autowired
	CusRecommendService recommendService;
	@Autowired
	CusCeraCkListService ceraCkService;
	@Autowired
	CusCeraDnaListService ceraDnaService;
	@Autowired
	CusCeraIotListService ceraIotService;
	@Autowired
	PointIssueService pointIssueService;

//CSV : 부가정보 가족결합(가족관계)
	@Autowired
	CrmCustHshldBasService crmCustHshldBasService;
//CSV : 부가정보 등급변경 이력 탭
	@Autowired
	CrmCustGradeChngHstService crmCustGradeChngHstService;
// CSV : 부가정보 정보동의 탭 서비스
	@Autowired
	CrmCustInfoPtuseAgreeHstService crmCustInfoPtuseAgreeHstService;
//CSV : 부가정보 정보동의 탭 서비스
	@Autowired
	CrmRcvRfslHstService crmRcvRfslHstService;
//CSV : 부가정보 정보변경 탭 서비스
	@Autowired
	CrmCustInfoChngHstService crmCustInfoChngHstService;
//CSV : 부가정보 단골매장 탭 서비스
	@Autowired
	CrmCustPatronStorBasService crmCustPatronStorBasService;

//CSV : 상담이력 탭 서비스
	@Autowired
	CrmCustPhnCnslHistService crmCustPhnCnslHistService;

//CSV : 보스거래이력 보스이력 탭 서비스
	@Autowired
	CrmCustBosCntrtHstService crmCustBosCntrtHstService;

//CSV : POS이력 탭 서비스
	@Autowired
	CrmCustPosSaleHstService crmCustPosSaleHstService;

//상담상세 
	@Autowired
	CrmCustPhnCnslDtlHistService crmCustPhnCnslDtlHistService;

//CSV : AS이력 AS이력 탭 서비스
	@Autowired
	CrmCustAsSubmitHistService crmCustAsSubmitHistService;

//CSV : 접촉이력 HC이력 탭 서비스
	@Autowired
	CrmCustBosHcHstService crmCustBosHcHstService;

//CSV : 접촉이력 홈체험이력 탭 서비스
	@Autowired
	CrmCustBosCntrtTxnHCService crmCustBosCntrtTxnHCService;

//CSV : 접촉이력 체험이력 탭 서비스
	@Autowired
	CrmCustExprnHstService crmCustExprnHstService;

// 승급점수 지급 버튼 
	@Autowired
	CrmAdvncmtHstService crmAdvncmtHstservice;

// 카드 발급 서비스
	@Autowired
	CrmMshipCardBasService cardBasService;

// 쿠폰발급	
	@Autowired
	CrmMshipCoupnBasService coupnBasService;

	@Autowired
	CrmMshipStmpBasService stmpBasService;

//회원이력

	/**
	 * 
	 * @author user
	 * @date 2022. 4. 19. * @param param
	 * @param model
	 * @return
	 * @throws Exception
	 * @description CRM고객기본 목록페이지
	 *
	 */
	@GetMapping(value = { "", "index" })
	public String init(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAttribute("eonUrl", eonUrl);
		model.addAttribute("eonUser", eonUser);
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm") + "main/CR001";
	}

//=====================================================================================
//가족결합(관계) 시작
//=====================================================================================
	/**
	 * 
	 * @author user
	 * @date 2022. 4. 19. * @param param
	 * @param model
	 * @return
	 * @throws Exception
	 * @description CRM가족결합(가족관계)
	 *
	 */
	@GetMapping(value = { "sub/crmCustHshldBasList" })
	public String crmCustHshldBasList(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm") + "cst/CR007";
	}

	/**
	 * 
	 * @author user
	 * @date 2022. 4. 13. * @param rparam
	 * @return
	 * @throws Exception
	 * @description CRM가족결합(가족관계) 등록모드 팝업호출
	 *
	 */
	@GetMapping(value = { "sub/crmCustHshldBas/add" })
	public String subCrmCustHshldBasAdd(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {

//	model.addAllAttributes(param);

		// 자동채번 예시 : CNT + YYMMDDHHMISS + 일련번호5자리 : CNT+ 220414100242 + 01689
		CrmCustHshldBasVo vo = new CrmCustHshldBasVo();

		vo.setRepHshldNo((String) param.get("repHshldNo"));

		model.addAttribute("vo", vo);
		model.addAttribute("addMode", true);

		return Utilities.getProperty("tiles.crm.blank") + "cst/CR008";

	}

	/**
	 * 
	 * @author user
	 * @date 2022. 4. 13. * @param rparam
	 * @return
	 * @throws Exception
	 * @description CRM가족결합(가족관계) 수정모드 팝업호출
	 *
	 */
//@GetMapping(value = { "sub/crmCustHshldBas/mod" })
//public String subCrmCustHshldBasMod(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
//
//
//	model.addAllAttributes(param);
//
//	// 자동채번 예시 : CNT + YYMMDDHHMISS + 일련번호5자리 : CNT+ 220414100242 + 01689
//	Map<String, Object> vo = crmCustHshldBasService.getData(param);
//
//	model.addAttribute("vo", vo);
//	model.addAttribute("addMode", false);
//	
//	return Utilities.getProperty("tiles.crm.blank") + "cst/CR008";
//
//}

	@GetMapping(value = { "sub/crmCustHshldBas/mod/{itgCustNo}" })
	public String subCrmCustHshldBasMod(CrmCustHshldBasVo vo, @PathVariable("itgCustNo") String itgCustNo,
			@RequestParam Map<String, Object> param, ModelMap model) throws Exception {

//	param.keySet().add("itgCustNo");
//	param.keySet().add("repHshldNo");
		param.put("itgCustNo", itgCustNo);

		Map<String, Object> val = crmCustHshldBasService.getData(param);

		model.addAttribute("vo", val);

		model.addAttribute("addMode", false);
//	model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm.blank") + "cst/CR008";
	}

	/**
	 * 
	 * @author user
	 * @date 2022. 4. 13. * @param vo
	 * @return
	 * @throws Exception
	 * @description CRM가족결합(가족관계) 저장
	 */
	@PostMapping(value = { "sub/crmCustHshldBas/save" })
	public @ResponseBody Object subCrmCustHshldBassave(@RequestBody CrmCustHshldBasVo vo) throws Exception {

		String state = vo.getStat();
		vo.setRegChlCd("CRM");

		if (state.equals("c")) {
			return crmCustHshldBasService.insert(vo);
		} else {
			return crmCustHshldBasService.update(vo);
		}

	}

	/**
	 * 
	 * @author user
	 * @date 2022. 4. 13. * @param vo
	 * @return
	 * @throws Exception
	 * @description CRM가족결합(가족관계) 삭제
	 */
	@PostMapping(value = { "sub/crmCustHshldBas/remove" })
	public @ResponseBody Object subCrmCustHshldBasDelete(@RequestBody CrmCustHshldBasVo vo) throws Exception {

// 	String state = vo.getStat();
		vo.setRegChlCd("CRM");

		return crmCustHshldBasService.delete(vo);

	}
//=====================================================================================
// 가족결합(관계등록) 끝
//=====================================================================================  

	/**
	 * 
	 * @author 안재홍
	 * @date 2022. 4. 7. * @param param
	 * @param model
	 * @return
	 * @throws Exception
	 * @description CRM연락처기본 목록페이지
	 *
	 */
	@GetMapping(value = { "sub/crmCustCntplcBas" })
	public String subCrmCustCntplcBasInit(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAllAttributes(param);
		// return Utilities.getProperty("tiles.crm") + "cst/CR009";
		return "crm/cst/CR009";
	}

	/**
	 * 
	 * @author 황의겸
	 * @date 2022. 4. 26. * @param param
	 * @param model
	 * @return
	 * @throws Exception
	 * @description CRM 회원이력기본 목록페이지 ( 쿠폰, 포인트, 스탬프, 카드, 발송)
	 *
	 */
	@GetMapping(value = { "sub/couponList" })
	public String couponList(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm") + "cst/CR041";
	}

	@GetMapping(value = { "sub/pointList" })
	public String pointList(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm") + "cst/CR042";
	}

	@GetMapping(value = { "sub/stampList" })
	public String stampList(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm") + "cst/CR043";
	}

	@GetMapping(value = { "sub/cardList" })
	public String cardList(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm") + "cst/CR044";
	}

	@GetMapping(value = { "sub/sendList" })
	public String sendList(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm") + "cst/CR045";
	}

	@GetMapping(value = { "sub/knownpersonList" })
	public String knownpersonList(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm") + "cst/CR027";
	}

	@GetMapping(value = { "/knownpersonSavePop" })
	public String knownpersonSavePop(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm") + "cst/CR028";
	}

	@GetMapping(value = { "/knownpersonDelPop" })
	public String knownpersonDelPop(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm") + "cst/knownpersonDelPop";
	}

	@GetMapping(value = { "sub/surveyList" })
	public String surveyList(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm") + "cst/CR046";
	}

	@GetMapping(value = { "sub/campaignList" })
	public String campaignList(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm") + "cst/CR047";
	}

	@GetMapping(value = { "sub/advncmtList" })
	public String advncmtList(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm") + "cst/CR200";
	}

	@GetMapping(value = { "sub/loginList" })
	public String loginList(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm") + "cst/CR048";
	}

	@GetMapping(value = { "sub/recommendList" })
	public String recommendList(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm") + "cst/CR029";
	}

	@GetMapping(value = { "sub/ceraCkList" })
	public String ceraCkList(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm") + "cst/CR025";
	}

	/*
	 * @GetMapping(value = { "sub/ceraCkPop" }) public String
	 * ceraCkPop(@RequestParam Map<String, Object> param, ModelMap model) throws
	 * Exception { model.addAllAttributes(param); return
	 * Utilities.getProperty("tiles.crm.blank") + "cst/CR026"; }
	 */
	@GetMapping(value = { "sub/ceraCkPop/{neuroMeasureNo}/{itgCustNo}" })
	public String ceraCkPop(CusCeraCkListVo vo, @PathVariable("neuroMeasureNo") String neuroMeasureNo,
			@PathVariable("itgCustNo") String itgCustNo, @RequestParam Map<String, Object> param, ModelMap model)
			throws Exception {
		vo.setItgCustNo(itgCustNo);
		vo.setNeuroMeasureNo(neuroMeasureNo);

		model.addAttribute("ceraCk", ceraCkService.get(vo));
		model.addAllAttributes(param);

		return Utilities.getProperty("tiles.crm.blank") + "cst/CR026";
	}

	@GetMapping(value = { "sub/ceraDnaList" })
	public String ceraDnaList(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm") + "cst/CR039";
	}

	@GetMapping(value = { "sub/ceraIotList" })
	public String ceraIotList(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm") + "cst/CR040";
	}

	@GetMapping(value = { "sub/pointPopup/{itgCustNo}" })
	public String pointPopup(PointIssueVo vo, @PathVariable("itgCustNo") String itgCustNo,
			@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		vo.setItgCustNo(itgCustNo);
		model.addAttribute("PointIssue", pointIssueService.selectUserInfo(vo));
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm") + "mem/MB021";
	}

	@PostMapping(value = { "/sub/pointPopup/savePointScore" })
	public @ResponseBody Object savePointScore(@RequestBody PointIssueVo vo) throws Exception {

		if (vo.getApplyPointValidPerd() != null) {

			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date());
			DateFormat df = new SimpleDateFormat("yyyyMMdd", Locale.KOREA);
			DateFormat df2 = new SimpleDateFormat("yyyyMMddHHmmss", Locale.KOREA);

			// 유효기간시작일시
			vo.setValidPerdStaYmd(df.format(cal.getTime()));

			// 발행 일시
			vo.setPblsDt(df2.format(cal.getTime()));

			cal.add(Calendar.YEAR, vo.getApplyPointValidPerd());

			// 유효기간종료일시
			vo.setValidPerdEndYmd(df.format(cal.getTime()));

			// vo.setExtncDt( df2.format(cal.getTime()) );

		}
		
		return pointIssueService.savePointScore(vo);
	}

	/**
	 * 
	 * @author 김은성
	 * @date 2022. 6. 22.
	 * @param param
	 * @param model
	 * @return
	 * @throws Exception
	 * @description 승급점수 지급
	 *
	 */
	@GetMapping(value = { "sub/advncmtPopup/{itgCustNo}" })
	public String pointPopup(CrmAdvncmtHstVo vo, @PathVariable("itgCustNo") String itgCustNo,
			@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		vo.setItgCustNo(itgCustNo);

		// CrmAdvncmtHstVo crmAdvncmtHstVo =
		// Utilities.beanToBean(pointIssueService.selectUserInfo(vo),
		// CrmAdvncmtHstVo.class);

		model.addAttribute("advncmtIssue", pointIssueService.selectUserInfo(vo));
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm") + "mem/MB140";
	}

	/**
	 * 
	 * @author 김은성
	 * @date 2022. 6. 22.
	 * @param param
	 * @param model
	 * @return
	 * @throws Exception
	 * @description 승급점수 지급 저장
	 * 
	 */
	@PostMapping(value = { "sub/advncmtPopup/saveAdvncmtScore" })
	public @ResponseBody Object saveAdvncmtScore(@RequestBody CrmAdvncmtHstVo vo) throws Exception {

//		int cnt = 
		crmAdvncmtHstservice.saveAdvncmtHst(vo);

		if (!"".equals(vo.getAdvncmtHstSeq())) {
			vo.setCnt(1);
		}

		return vo;
	}

	/**
	 * 
	 * @author 김은성
	 * @date 2022. 6. 22.
	 * @param param
	 * @param model
	 * @return
	 * @throws Exception
	 * @description 카드발급
	 *
	 */
	@GetMapping(value = { "sub/cardPopup/{itgCustNo}" })
	public String cardPopup(CrmAdvncmtHstVo vo, @PathVariable("itgCustNo") String itgCustNo,
			@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		vo.setItgCustNo(itgCustNo);
		model.addAttribute("cardIssue", pointIssueService.selectUserInfo(vo));
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm") + "mem/MB200";
	}

	/**
	 * 
	 * @author 김은성
	 * @date 2022. 6. 22.
	 * @param param
	 * @param model
	 * @return
	 * @throws Exception
	 * @description 카드발급
	 *
	 */
	@GetMapping(value = { "sub/popCard" })
	public String popCard(CrmAdvncmtHstVo vo, @RequestParam Map<String, Object> param, ModelMap model)
			throws Exception {

		return Utilities.getProperty("tiles.crm") + "mem/popCard";
	}

	/**
	 * 
	 * @author 김은성
	 * @date 2022. 6. 22.
	 * @param param
	 * @param model
	 * @return
	 * @throws Exception
	 * @description 스탬프발급
	 *
	 */
	@GetMapping(value = { "sub/stmpPopup/{itgCustNo}" })
	public String stmpPopup(CrmAdvncmtHstVo vo, @PathVariable("itgCustNo") String itgCustNo,
			@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		vo.setItgCustNo(itgCustNo);
		model.addAttribute("stmpIssue", pointIssueService.selectUserInfo(vo));
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm") + "mem/MB220";
	}

	/**
	 * 
	 * @author 김은성
	 * @date 2022. 6. 22.
	 * @param param
	 * @param model
	 * @return
	 * @throws Exception
	 * @description 스탬프 팝업
	 *
	 */
	@GetMapping(value = { "sub/popStmp" })
	public String popStmp(CrmAdvncmtHstVo vo, @RequestParam Map<String, Object> param, ModelMap model)
			throws Exception {
		model.addAttribute("itgCustNo", String.valueOf(param.get("itgCustNo")));
		return Utilities.getProperty("tiles.crm") + "mem/popStmp";
	}

	/**
	 * 
	 * @author 김은성
	 * @date 2022. 6. 22.
	 * @param param
	 * @param model
	 * @return
	 * @throws Exception
	 * @description 쿠폰발급
	 *
	 */
	@GetMapping(value = { "sub/coupnPopup/{itgCustNo}" })
	public String coupnPopup(CrmAdvncmtHstVo vo, @PathVariable("itgCustNo") String itgCustNo,
			@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		vo.setItgCustNo(itgCustNo);
		model.addAttribute("coupnIssue", pointIssueService.selectUserInfo(vo));
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm") + "mem/MB230";
	}

	/**
	 * 
	 * @author 김은성
	 * @date 2022. 6. 22.
	 * @param param
	 * @param model
	 * @return
	 * @throws Exception
	 * @description 쿠폰 팝업
	 *
	 */
	@GetMapping(value = { "sub/popCoupn" })
	public String popCoupn(CrmAdvncmtHstVo vo, @RequestParam Map<String, Object> param, ModelMap model)
			throws Exception {

		return Utilities.getProperty("tiles.crm") + "mem/popCoupn";
	}

	/**
	 * 
	 * @author 김은성
	 * @date 2022. 6. 22.
	 * @param param
	 * @param model
	 * @return
	 * @throws Exception
	 * @description 쿠폰발급 저장
	 *
	 */
	@PostMapping(value = { "/sub/coupnPopup/saveCoupnIssue" })
	public @ResponseBody Object saveCoupnIssue(@RequestBody CrmMshipCoupnBasVo vo) throws Exception {

		vo.setCustNoList(null);

		if (!vo.getCustNo().equals("")) {
			// vo.setCustNoList(Arrays.asList(vo.getCustNo().split(",", -1)));
			vo.setCustNoList(vo.getCustNo().split(",", -1));

			//////////////////////////////
			CrmMshipCoupnBasVo basVo = coupnBasService.get(vo);

			// 유효기간 체크
			long now = System.currentTimeMillis();
			String toDay = new SimpleDateFormat("yyyyMMdd", Locale.KOREA).format(now);
			if (Integer.parseInt(basVo.getToPblsStdDay()) < Integer.parseInt(toDay)) {
				throw new EzApiException(Constants._API_COUPN_OVER_DAY_DATA, Constants._API_COUPN_OVER_DAY_DATA_MSG);
			}

			// 회원등급
			if (!Arrays.asList(basVo.getApplyMshpGradeCtnts().toString().split(",")).contains(vo.getMshipGradeCd())) {
				throw new EzApiException(Constants._API_COUPN_GRADE_DATA, Constants._API_COUPN_GRADE_DATA_MSG);
			}

			// 일최대 발급
			int dayCoupnCnt = coupnBasService.getDayCoupnCnt(basVo);
			int maxIssueCnt = basVo.getMaxIssueCnt();
			int otherCnt = maxIssueCnt - dayCoupnCnt;
			if (otherCnt <= 0) {
				throw new EzApiException(Constants._API_COUPN_MAXDAY_DATA, Constants._API_COUPN_MAXDAY_DATA_MSG);
			}

			// 회원당 제한수량
			if (basVo.getCoupnIssueMethCd().equals("002")) {
				int custCoupnCnt = coupnBasService.getCustCoupnCnt(vo);
				if (custCoupnCnt >= basVo.getIssueRstrtnCnt()) {
					throw new EzApiException(Constants._API_COUPN_MAXCNT_DATA, Constants._API_COUPN_MAXCNT_DATA_MSG);
				}
			}
			//////////////////////////////
		}

		int res = coupnBasService.pubCouponAll(vo);

		return res;

	}

	/**
	 * 
	 * @author 김은성
	 * @date 2022. 6. 22.
	 * @param param
	 * @param model
	 * @return
	 * @throws Exception
	 * @description 카드발급 저장
	 *
	 */
	@PostMapping(value = { "/sub/cardPopup/saveCardIssue" })
	public @ResponseBody Object saveCardIssue(@RequestBody CrmCardPblsHstVo vo) throws Exception {

		long cnt = cardBasService.pubCard(vo);

		vo.setCnt(cnt);
		return vo;

	}

	/**
	 * 
	 * @author 안재홍
	 * @date 2022. 4. 29. * @param param
	 * @param model
	 * @return
	 * @throws Exception
	 * @description CRM 회원이력기본 종합이력
	 */
	// 접촉이력 : HC이력
	@GetMapping(value = { "syn/crmCustSynthesisHstList" })
	public String crmCustSynthesisHstList(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm") + "cst/CR006";
	}

	@GetMapping(value = { "syn/crmCustSynthesisHst2List" })
	public String crmCustSynthesisHst2List(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm") + "cst/CR210";
	}

	/**
	 * 
	 * @author 안재홍
	 * @date 2022. 4. 29. * @param param
	 * @param model
	 * @return
	 * @throws Exception
	 * @description CRM 회원이력기본 부가정보 ( 정보동의이력, 수신거부이력, 등급변경이력, 정보변경이력, 단골매장이력 , 거래이력
	 *              ,상담이력, 상담상세 , AS이력목록)
	 *
	 */
	@GetMapping(value = { "sub/crmCustInfoPtuseAgreeHstList" })
	public String crmCustInfoPtuseAgreeHstList(@RequestParam Map<String, Object> param, ModelMap model)
			throws Exception {
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm") + "cst/CR012";
	}

	@GetMapping(value = { "sub/crmRcvRfslHstList" })
	public String crmRcvRfslHstList(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm") + "cst/CR014";
	}

//부가정보 > 등급변경
	@GetMapping(value = { "sub/crmCustGradeChngHstList" })
	public String crmCustGradeChngHstList(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm") + "cst/CR015";
	}

// 부가정보 > 정보변경
	@GetMapping(value = { "sub/crmCustInfoChngHstList" })
	public String crmCustInfoChngHstList(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm") + "cst/CR016";
	}

//부가정보 > 단골매장
	@GetMapping(value = { "sub/crmCustPatronStorBasList" })
	public String crmCustPatronStorBasList(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm") + "cst/CR011";
	}

//BOS거래이력
	@GetMapping(value = { "trn/crmCustBosCntrtTxnList" })
	public String crmCustBosCntrtTxnList(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm") + "cst/CR017";
	}

//BOS거래이력상세
	@GetMapping(value = { "trn/crmCustBosCntrtTxnDtlList/{itgCustNo}/{cntrNo}" })
	public String crmCustBosCntrtTxnDtlList(@RequestParam Map<String, Object> param,
			@PathVariable("itgCustNo") String itgCustNo, @PathVariable("cntrNo") String cntrNo,
			CrmCustBosCntrtTxnDtlVo crmCustBosCntrtTxnDtlVo, ModelMap model) throws Exception {

//	crmCustPhnCnslDtlHistVo.setItgCustNo(itgCustNo);
//	crmCustPhnCnslDtlHistVo.setCnslHistNo("20220513112208283PLT33");
//	http://192.168.70.64:8082/ctc/v1.0/history/20220513112208283PLT33/	

		Map<String, String> vo = crmCustBosCntrtHstService.get(cntrNo);

//	((CrmCustBosCntrtTxnDtlVo) vo).setItgCustNo(itgCustNo);
		model.addAttribute("vo", vo);

		// model.addAttribute("vo", null);
		model.addAllAttributes(param);

		return Utilities.getProperty("tiles.crm.blank") + "cst/CR018";

	}

//POS거래이력
	@GetMapping(value = { "trn/crmCustPosSaleHstList" })
	public String crmCustPosSaleHstList(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm") + "cst/CR150";
	}

//상담이력목록
	@GetMapping(value = { "cot/crmCustPhnCnslHistList" })
	public String crmCustPhnCnslHistList(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm") + "cst/CR019";
	}

//상담이력상세
	@GetMapping(value = { "cot/crmCustPhnCnslDtlHist/{itgCustNo}/{cnslHistNo}" })
	public String crmCustPhnCnslDtlHist(@RequestParam Map<String, Object> param,
			@PathVariable("itgCustNo") String itgCustNo, @PathVariable("cnslHistNo") String cnslHistNo,
			CrmCustPhnCnslDtlHistVo crmCustPhnCnslDtlHistVo, ModelMap model) throws Exception {

//	crmCustPhnCnslDtlHistVo.setItgCustNo(itgCustNo);
//	crmCustPhnCnslDtlHistVo.setCnslHistNo("20220513112208283PLT33");
//	http://192.168.70.64:8082/ctc/v1.0/history/20220513112208283PLT33/	

		CrmCustPhnCnslDtlHistVo vo = crmCustPhnCnslDtlHistService.get(cnslHistNo);
		vo.setItgCustNo(itgCustNo);
		model.addAttribute("vo", vo);
		// model.addAttribute("vo", null);
		model.addAllAttributes(param);

		return Utilities.getProperty("tiles.crm.blank") + "cst/CR020";

	}

//AS이력목록
	@GetMapping(value = { "cot/crmCustAsSubmitHistList" })
	public String crmCustAsSubmitHistList(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm") + "cst/CR021";
	}

//AS이력상세
	@GetMapping(value = { "cot/crmCustAsSubmitDtlHist/{itgCustNo}/{hstSeq}/{submitDate}" })
	public String crmCustAsSubmitHist(@RequestParam Map<String, Object> param,
			@PathVariable("itgCustNo") String itgCustNo, @PathVariable("hstSeq") String hstSeq,
			@PathVariable("submitDate") String submitDate, CrmCustAsSubmitHistVo crmCustAsSubmitHistVo, ModelMap model)
			throws Exception {

		crmCustAsSubmitHistVo.setItgCustNo(itgCustNo);
		crmCustAsSubmitHistVo.setHstSeq(hstSeq);

		CrmCustAsSubmitHistVo returnVo = crmCustAsSubmitHistService.get(crmCustAsSubmitHistVo);
		returnVo.setSubmitDate(submitDate);

		model.addAttribute("vo", returnVo);
		// model.addAttribute("vo", null);
		model.addAllAttributes(param);

		return Utilities.getProperty("tiles.crm.blank") + "cst/CR022";

	}

//홈체험이력
	@GetMapping(value = { "cot/crmCustBosCntrtTxnHCList" })
	public String crmCustBosCntrtTxnHCList(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm") + "cst/CR140";
	}

// 접촉이력 : 체험이력
	@GetMapping(value = { "cot/crmCustExprnHstList" })
	public String crmCustExprnHstList(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm") + "cst/CR023";
	}

//접촉이력 : HC이력
	@GetMapping(value = { "cot/crmCustBosHcHstList" })
	public String crmCustBosHcHstList(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm") + "cst/CR024";
	}
//@GetMapping(value = { "detail/{stpltNo}" })
//public String detail(StipulationListVo vo, @PathVariable("stpltNo") String stpltNo, @RequestParam Map<String, Object> param, ModelMap model) throws Exception {
//	vo.setStpltNo(stpltNo);
//	model.addAttribute("Stipulation", service.get(vo));
//	model.addAllAttributes(param);
//	return Utilities.getProperty("tiles.crm") + "mem/StipulationDetail";
//}

	// 종합이력 목록
	@PostMapping(value = { "getCrmCustSynthesisHstList" })
	public @ResponseBody Object getCrmCustSynthesisHstList(@RequestBody EzMap param) throws Exception {
		List<EzMap> list = crmCustSynthesisHstService.getGridList(param);
		return Utilities.getGridData(list);
	}

	// 종합이력(고객여정) 목록
	@PostMapping(value = { "getCrmCustSynthesisHst2List" })
	public @ResponseBody Object getCrmCustSynthesisHst2List(@RequestBody EzMap param) throws Exception {
		EzPaginationInfo page = param.getPaginationInfo();
		List<CrmRcvRfslHstVo> list = crmCustSynthesisHstService.getCrmCustSynthesisHst2List(param);
		page.setTotalRecordCount(crmCustSynthesisHstService.getCrmCustSynthesisHst2ListCount(param));
		return Utilities.getGridData(list, page);
	}

	/**
	 * 
	 * @author 황의겸
	 * @date 2022. 4. 26. * @param param
	 * @param model
	 * @return
	 * @throws Exception
	 * @description CRM 회원이력기본 목록검색 ( 쿠폰, 포인트, 스탬프, 카드, 발송)
	 *
	 */
	@PostMapping(value = { "getCouponList" })
	public @ResponseBody Object getCouponList(@RequestBody EzMap param) throws Exception {
		EzPaginationInfo page = param.getPaginationInfo();
		List<CusCouponListVo> list = couponService.getList(param);
		page.setTotalRecordCount(couponService.getListCount(param));
		return Utilities.getGridData(list, page);
	}

	@PostMapping(value = { "getPointList" })
	public @ResponseBody Object getPointList(@RequestBody EzMap param) throws Exception {
		EzPaginationInfo page = param.getPaginationInfo();
		List<CusPointListVo> list = pointService.getList(param);
		page.setTotalRecordCount(pointService.getListCount(param));
		return Utilities.getGridData(list, page);
	}

	@PostMapping(value = { "getStampList" })
	public @ResponseBody Object getStampList(@RequestBody EzMap param) throws Exception {
		EzPaginationInfo page = param.getPaginationInfo();
		List<CusStampListVo> list = stampService.searchStmpList(param);
		page.setTotalRecordCount(stampService.searchStmpListCount(param));
		return Utilities.getGridData(list, page);
	}

	@PostMapping(value = { "getCardList" })
	public @ResponseBody Object getCardList(@RequestBody EzMap param) throws Exception {
		EzPaginationInfo page = param.getPaginationInfo();
		List<CusCardListVo> list = cardService.getList(param);
		page.setTotalRecordCount(cardService.getListCount(param));
		return Utilities.getGridData(list, page);
	}

	@PostMapping(value = { "getSendList" })
	public @ResponseBody Object getSendList(@RequestBody EzMap param) throws Exception {
		EzPaginationInfo page = param.getPaginationInfo();
		List<CusSendListVo> list = sendService.getList(param);
		page.setTotalRecordCount(sendService.getListCount(param));
		return Utilities.getGridData(list, page);
	}

	@PostMapping(value = { "getKnownpersonList" })
	public @ResponseBody Object getKnownpersonList(@RequestBody EzMap param) throws Exception {
		EzPaginationInfo page = param.getPaginationInfo();
		List<CusKnownpersonListVo> list = knownpersonService.getList(param);
		page.setTotalRecordCount(knownpersonService.getListCount(param));
		return Utilities.getGridData(list, page);
	}

	@PostMapping(value = { "getSurveyList" })
	public @ResponseBody Object getSurveyList(@RequestBody EzMap param) throws Exception {
		EzPaginationInfo page = param.getPaginationInfo();
		List<CusSurveyListVo> list = surveyService.getList(param);
		page.setTotalRecordCount(surveyService.getListCount(param));
		return Utilities.getGridData(list, page);
	}

	@PostMapping(value = { "getRecommendList" })
	public @ResponseBody Object getRecommendList(@RequestBody EzMap param) throws Exception {
		EzPaginationInfo page = param.getPaginationInfo();
		List<CusRecommendVo> list = recommendService.getList(param);
		page.setTotalRecordCount(recommendService.getListCount(param));
		return Utilities.getGridData(list, page);
	}

	@PostMapping(value = { "getCeraCkList" })
	public @ResponseBody Object getCeraCkList(@RequestBody EzMap param) throws Exception {
		EzPaginationInfo page = param.getPaginationInfo();
		List<CusCeraCkListVo> list = ceraCkService.getList(param);
		page.setTotalRecordCount(ceraCkService.getListCount(param));
		return Utilities.getGridData(list, page);
	}

	@PostMapping(value = { "getCeraDnaList" })
	public @ResponseBody Object getCeraDnaList(@RequestBody EzMap param) throws Exception {
		EzPaginationInfo page = param.getPaginationInfo();
		List<CusCeraDnaListVo> list = ceraDnaService.getList(param);
		page.setTotalRecordCount(ceraDnaService.getListCount(param));
		return Utilities.getGridData(list, page);
	}

	@PostMapping(value = { "getCeraIotList" })
	public @ResponseBody Object getCeraIotList(@RequestBody EzMap param) throws Exception {
		EzPaginationInfo page = param.getPaginationInfo();
		List<CusCeraIotListVo> list = ceraIotService.getList(param);
		page.setTotalRecordCount(ceraIotService.getListCount(param));
		return Utilities.getGridData(list, page);
	}

	@PostMapping(value = { "getCampaignList" })
	public @ResponseBody Object getCampaignList(@RequestBody EzMap param) throws Exception {
		EzPaginationInfo page = param.getPaginationInfo();
		List<CusCampaignListVo> list = campaignService.getList(param);
		page.setTotalRecordCount(campaignService.getListCount(param));
		return Utilities.getGridData(list, page);
	}

	@PostMapping(value = { "getAdvncmtList" })
	public @ResponseBody Object getAdvncmtList(@RequestBody EzMap param) throws Exception {
		EzPaginationInfo page = param.getPaginationInfo();
		List<CrmAdvncmtHstVo> list = crmAdvncmtHstservice.getList(param);
		page.setTotalRecordCount(crmAdvncmtHstservice.getListCount(param));
		return Utilities.getGridData(list, page);
	}

	/**
	 * 
	 * @author 안재홍
	 * @date 2022. 4. 29. * @param param
	 * @param model
	 * @return
	 * @throws Exception
	 * @description CRM 회원이력기본 부가정보 목록검색 ( 가족결합(가족관계) , 정보동의이력 , 수신거부이력, 등급변경, 정보변경
	 *              , 단골매장 이력 리스트 , 거래이력, 상담이력)
	 *
	 */
//가족결합(가족관계) 목록
	@PostMapping(value = { "getCrmCustHshldBasList" })
	public @ResponseBody Object getCrmCustHshldBasList(@RequestBody EzMap param) throws Exception {
//  EzPaginationInfo page = param.getPaginationInfo();
//  List<CrmCustInfoPtuseAgreeHstVo> list = crmCustInfoPtuseAgreeHstService.getList(param);
//  page.setTotalRecordCount(crmCustInfoPtuseAgreeHstService.getListCount(param));
//  return Utilities.getGridData(list,page);
		return crmCustHshldBasService.getGridList(param);
	}

//정보동의 목록
	@PostMapping(value = { "getCrmCustInfoPtuseAgreeHstList" })
	public @ResponseBody Object getCrmCustInfoPtuseAgreeHstList(@RequestBody EzMap param) throws Exception {
		EzPaginationInfo page = param.getPaginationInfo();
		List<CrmCustInfoPtuseAgreeHstVo> list = crmCustInfoPtuseAgreeHstService.getList(param);
		page.setTotalRecordCount(crmCustInfoPtuseAgreeHstService.getListCount(param));
		return Utilities.getGridData(list, page);
	}

//수신거부 목록
	@PostMapping(value = { "getCrmRcvRfslHstList" })
	public @ResponseBody Object getCrmRcvRfslHstList(@RequestBody EzMap param) throws Exception {
		EzPaginationInfo page = param.getPaginationInfo();
		List<CrmRcvRfslHstVo> list = crmRcvRfslHstService.getList(param);
		page.setTotalRecordCount(crmRcvRfslHstService.getListCount(param));
		return Utilities.getGridData(list, page);
	}

//등급변경 목록
	@PostMapping(value = { "getCrmCustGradeChngHstList" })
	public @ResponseBody Object getCrmCustGradeChngHstList(@RequestBody EzMap param) throws Exception {
		EzPaginationInfo page = param.getPaginationInfo();
		List<CrmCustGradeChngHstVo> list = crmCustGradeChngHstService.getList(param);
		page.setTotalRecordCount(crmCustGradeChngHstService.getListCount(param));
		return Utilities.getGridData(list, page);
	}

//정보변경 목록
	@PostMapping(value = { "getCrmCustInfoChngHstList" })
	public @ResponseBody Object getCrmCustInfoChngHstList(@RequestBody EzMap param) throws Exception {
		EzPaginationInfo page = param.getPaginationInfo();
		List<CrmCustInfoChngHstVo> list = crmCustInfoChngHstService.getList(param);
		page.setTotalRecordCount(crmCustInfoChngHstService.getListCount(param));
		return Utilities.getGridData(list, page);
	}

//단골매장 목록
	@PostMapping(value = { "getCrmCustPatronStorBasList" })
	public @ResponseBody Object getCrmCustPatronStorBasList(@RequestBody EzMap param) throws Exception {
		EzPaginationInfo page = param.getPaginationInfo();
		List<CrmCustPatronStorBasVo> list = crmCustPatronStorBasService.getList(param);
		page.setTotalRecordCount(crmCustPatronStorBasService.getListCount(param));
		return Utilities.getGridData(list, page);
	}

//보스거래이력 목록
	@PostMapping(value = { "getCrmCustBosCntrtTxnList" })
	public @ResponseBody Object getCrmCustBosCntrtTxnList(@RequestBody EzMap param) throws Exception {
//  EzPaginationInfo page = param.getPaginationInfo();
//  List<CrmCustBosCntrtHstVo> list = crmCustBosCntrtHstService.getList(param);
//  page.setTotalRecordCount(crmCustBosCntrtHstService.getListCount(param));
//  return Utilities.getGridData(list,page);
		return crmCustBosCntrtHstService.getGridList(param);

	}

//포스거래이력 목록
	@PostMapping(value = { "getCrmCustPosSaleHstList" })
	public @ResponseBody Object getCrmCustPosSaleHstList(@RequestBody EzMap param) throws Exception {
		EzPaginationInfo page = param.getPaginationInfo();
		List<CrmCustPosSaleHstVo> list = crmCustPosSaleHstService.getList(param);
		page.setTotalRecordCount(crmCustPosSaleHstService.getListCount(param));
		return Utilities.getGridData(list, page);
//return crmCustBosCntrtHstService.getGridList(param);

	}

//상담이력 목록
	@PostMapping(value = { "getCrmCustPhnCnslHistList" })
	public @ResponseBody Object getCrmCustPhnCnslHistList(@RequestBody EzMap param) throws Exception {
//    EzPaginationInfo page = param.getPaginationInfo();
//    List<CrmCustPhnCnslHistVo> list = crmCustPhnCnslHistService.getList(param);
//    page.setTotalRecordCount(crmCustPhnCnslHistService.getListCount(param));
//    return Utilities.getGridData(list,page);

		return crmCustPhnCnslHistService.getGridList(param);

	}

//AS이력 목록
	@PostMapping(value = { "getCrmCustAsSubmitHistList" })
	public @ResponseBody Object getCrmCustAsSubmitHistList(@RequestBody EzMap param) throws Exception {
//  EzPaginationInfo page = param.getPaginationInfo();
//  List<CrmCustAsSubmitHistVo> list = crmCustAsSubmitHistService.getList(param);
//  page.setTotalRecordCount(crmCustAsSubmitHistService.getListCount(param));
//  return Utilities.getGridData(list,page);
		return crmCustAsSubmitHistService.getGridList(param);
	}

//홈체험이력 목록
	@PostMapping(value = { "getCrmCustBosCntrtTxnHCList" })
	public @ResponseBody Object getCrmCustBosCntrtTxnHCList(@RequestBody EzMap param) throws Exception {
//EzPaginationInfo page = param.getPaginationInfo();
//List<CrmCustBosCntrtTxnHCVo> list = crmCustBosCntrtTxnHCService.getList(param);
//page.setTotalRecordCount(crmCustBosCntrtTxnHCService.getListCount(param));
//return Utilities.getGridData(list,page);
		return crmCustBosCntrtTxnHCService.getGridList(param);
	}

//체험이력 목록
	@PostMapping(value = { "getCrmCustExprnHstList" })
	public @ResponseBody Object getCrmCustExprnHstList(@RequestBody EzMap param) throws Exception {
		EzPaginationInfo page = param.getPaginationInfo();
		List<CrmCustExprnHstVo> list = crmCustExprnHstService.getList(param);
		page.setTotalRecordCount(crmCustExprnHstService.getListCount(param));
		return Utilities.getGridData(list, page);
	}

//HC이력 목록
	@PostMapping(value = { "getCrmCustBosHcHstList" })
	public @ResponseBody Object getCrmCustBosHcHstList(@RequestBody EzMap param) throws Exception {
//EzPaginationInfo page = param.getPaginationInfo();
//List<CrmCustBosHcHstVo> list = crmCustBosHcHstService.getList(param);
//page.setTotalRecordCount(crmCustBosHcHstService.getListCount(param));
//return Utilities.getGridData(list,page);
		return crmCustBosHcHstService.getGridList(param);
	}

	/**
	 * 
	 * @author 황의겸
	 * @date 2022. 4. 29.
	 * @param vo
	 * @return
	 * @throws Exception
	 * @description 약관 상세 저장
	 *
	 */
	@PostMapping(value = { "saveKnownperson" })
	public @ResponseBody Object saveKnownperson(@RequestBody CusKnownpersonListVo vo) throws Exception {
		return knownpersonService.save(vo);
	}

	@PostMapping(value = { "saveAcqieRelCd" })
	public @ResponseBody Object saveAcqieRelCd(@RequestBody CusKnownpersonListVo vo) throws Exception {
		return knownpersonService.saveAcqieRelCd(vo);
	}

	/**
	 * 
	 * @author user
	 * @date 2022. 4. 13. * @param param
	 * @return
	 * @throws Exception
	 * @description CRM고객연락처기본 목록검색
	 *
	 */
	@PostMapping(value = { "sub/crmCustCntplcBas/getList" })
	public @ResponseBody Object subCrmCustCntplcBasGetList(@RequestBody EzMap param) throws Exception {
//    EzPaginationInfo page = param.getPaginationInfo();
//    List<CrmCustHshldBasVo> list = service.getList(param);
//    page.setTotalRecordCount(service.getListCount(param));
//    return Utilities.getGridData(list,page);
		return crmCustCntplcBasService.getGridList(param);
	}

	/**
	 * 
	 * @author user
	 * @date 2022. 4. 13. * @param rparam
	 * @return
	 * @throws Exception
	 * @description CRM고객연락처기본 1건검색
	 *
	 */
	@GetMapping(value = { "sub/crmCustCntplcBas/get" })
	public @ResponseBody Object subCrmCustCntplcBasGet(@RequestParam Map<String, Object> rparam) throws Exception {
		EzMap param = new EzMap(rparam);
		return crmCustCntplcBasService.get(param);
	}

	/**
	 * 
	 * @author user
	 * @date 2022. 4. 13. * @param rparam
	 * @return
	 * @throws Exception
	 * @description CRM고객연락처기본 등록모드 팝업호출
	 *
	 */
	@GetMapping(value = { "sub/crmCustCntplcBas/add" })
	public String subCrmCustCntplcBasAdd(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {

		model.addAllAttributes(param);

		// 자동채번 예시 : CNT + YYMMDDHHMISS + 일련번호5자리 : CNT+ 220414100242 + 01689
		CrmCustCntplcBasVo vo = new CrmCustCntplcBasVo();

		vo.setCntplcSeq(Utilities.getAutoSeq("CNT"));
		vo.setItgCustNo((String) param.get("itgCustNo"));

		model.addAttribute("vo", vo);
		model.addAttribute("addMode", true);

		return Utilities.getProperty("tiles.crm.blank") + "cst/CR010";

	}

	/**
	 * 
	 * @author user
	 * @date 2022. 4. 13. * @param rparam
	 * @return
	 * @throws Exception
	 * @description CRM고객연락처기본 수정모드 팝업호출
	 *
	 */
	@GetMapping(value = { "sub/crmCustCntplcBas/mod" })
	public String subCrmCustCntplcBasMod(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {

		model.addAllAttributes(param);

		// 자동채번 예시 : CNT + YYMMDDHHMISS + 일련번호5자리 : CNT+ 220414100242 + 01689
		Map<String, Object> vo = crmCustCntplcBasService.getData(param.get("cntplcSeq"));

		model.addAttribute("vo", vo);
		model.addAttribute("addMode", false);

		return Utilities.getProperty("tiles.crm.blank") + "cst/CR010";

	}

	/**
	 * 
	 * @author user
	 * @date 2022. 4. 13. * @param vo
	 * @return
	 * @throws Exception
	 * @description CRM고객연락처기본 저장
	 */
	@PostMapping(value = { "sub/crmCustCntplcBas/save" })
	public @ResponseBody Object subCrmCustCntplcBassave(@RequestBody CrmCustCntplcBasVo vo) throws Exception {

		String state = vo.getStat();
		vo.setRegChlCd("CRM");

		if (state.equals("c")) {
			return crmCustCntplcBasService.insert(vo);
		} else {
			return crmCustCntplcBasService.update(vo);
		}

	}

	/**
	 * 
	 * @author user
	 * @date 2022. 4. 13. * @param vo
	 * @return
	 * @throws Exception
	 * @description CRM고객연락처기본 삭제
	 */
	@PostMapping(value = { "sub/crmCustCntplcBas/remove" })
	public @ResponseBody Object subCrmCustCntplcBasDelete(@RequestBody CrmCustCntplcBasVo vo) throws Exception {

// 	String state = vo.getStat();
		vo.setRegChlCd("CRM");

		return crmCustCntplcBasService.delete(vo);

	}

	/**
	 * 
	 * @author user
	 * @date 2022. 4. 13. * @param list
	 * @return
	 * @throws Exception
	 * @description CRM고객연락처기본 리스트 저장
	 *
	 */
	@PostMapping(value = { "sub/crmCustCntplcBas/saveList" })
	public @ResponseBody Object subCrmCustCntplcBassaveList(@RequestBody List<CrmCustCntplcBasVo> list)
			throws Exception {
		return crmCustCntplcBasService.saveList(list);
	}

	/**
	 * 
	 * @author user
	 * @date 2022. 4. 13.
	 * @param list
	 * @return
	 * @throws Exception
	 * @description CRM고객연락처기본 리스트 삭제
	 *
	 */
	@PostMapping(value = { "sub/crmCustCntplcBas/deleteList" })
	public @ResponseBody Object subCrmCustCntplcBasdeleteList(@RequestBody List<CrmCustCntplcBasVo> list)
			throws Exception {
		return crmCustCntplcBasService.deleteList(list);
	}

	/**
	 * 
	 * @author user
	 * @date 2022. 4. 19. * @param param
	 * @return
	 * @throws Exception
	 * @description CRM고객기본 목록검색
	 *
	 */
	@PostMapping(value = { "getList" })
	public @ResponseBody Object getList(@RequestBody EzMap param) throws Exception {
//    EzPaginationInfo page = param.getPaginationInfo();
//    List<CrmCustBasVo> list = service.getList(param);
//    page.setTotalRecordCount(service.getListCount(param));
//    return Utilities.getGridData(list,page);
		return service.getGridList(param);
	}

	/**
	 * 
	 * @author user
	 * @date 2022. 4. 19. * @param rparam
	 * @return
	 * @throws Exception
	 * @description CRM고객기본 1건검색
	 *
	 */
	@GetMapping(value = { "get" })
	public @ResponseBody Object get(@RequestParam Map<String, Object> rparam) throws Exception {
		EzMap param = new EzMap(rparam);
		return service.get(param);
	}

	/**
	 * 
	 * @author user
	 * @date 2022. 4. 19. * @param vo
	 * @return
	 * @throws Exception
	 * @description CRM고객기본 저장
	 */
	@PostMapping(value = { "save" })
	public @ResponseBody Object save(@RequestBody CrmCustBasVo vo) throws Exception {

//		String test = ""; 
//		vo.setUserCd(Utilities.getLoginUserCd());
		vo.setIndiInfoHandlPrsnNo(Utilities.getLoginUserCd());
		vo.setConnPrsnIpAddr(Utilities.getPeerIp());
		return service.update(vo);
	}

	/**
	 * 
	 * @author user
	 * @date 2022. 4. 19. * @param list
	 * @return
	 * @throws Exception
	 * @description CRM고객기본 리스트 저장
	 *
	 */
	@PostMapping(value = { "saveList" })
	public @ResponseBody Object saveList(@RequestBody List<CrmCustBasVo> list) throws Exception {
		return service.saveList(list);
	}

	/**
	 * 
	 * @author user
	 * @date 2022. 4. 19.
	 * @param list
	 * @return
	 * @throws Exception
	 * @description CRM고객기본 리스트 삭제
	 *
	 */
	@PostMapping(value = { "deleteList" })
	public @ResponseBody Object deleteList(@RequestBody List<CrmCustBasVo> list) throws Exception {
		return service.deleteList(list);
	}

	/**
	 * 
	 * @author user
	 * @date 2022. 7. 6. * @param vo
	 * @return
	 * @throws Exception
	 * @description CRM고객 연락처정보탭 대표연락처여부 수정
	 */
	@PostMapping(value = { "saveRepCntplc" })
	public @ResponseBody Object saveRepCntplc(@RequestBody CrmCustBasVo vo) throws Exception {
		return service.saveRepCntplc(vo);
	}

	/**
	 * 스탬프 적립
	 * 
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = { "/sub/stmpPopup/saveStmpIssue" })
	public @ResponseBody Object saveStmpIssue(@RequestBody EzMap param) throws Exception {
		return stmpBasService.saveStmpIssue(param);
	}

	/**
	 * CRM멤버십 휴면등록
	 * 
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = { "/saveMemshipDormancy" })
	public @ResponseBody Object saveMemshipDormancy(@RequestBody CrmCustBasVo vo) throws Exception {
		return service.saveMemshipDormancy(vo);
	}

	/**
	 * CRM멤버십 휴면등록
	 * 
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = { "/saveMemshipCancelDormancy" })
	public @ResponseBody Object saveMemshipCancelDormancy(@RequestBody CrmCustBasVo vo) throws Exception {
		return service.saveMemshipCancelDormancy(vo);
	}

	/**
	 * CRM멤버십 탈회
	 * 
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = { "/deleteMemShip" })
	public @ResponseBody Object deleteMemship(@RequestBody CrmCustBasVo vo) throws Exception {
		return service.deleteMemShip(vo);
	}

	// 통합고객검색 개인 고객발송 관련
	@PostMapping(value = { "saveTargetSendInfo" })
	public @ResponseBody Object saveTargetSendInfo(@RequestBody EzMap param) throws Exception {
		return service.saveTargetSendInfo(param);
	}

	@PostMapping(value = { "getUsePointForBos" })
	public @ResponseBody Object getUsePointForBos(@RequestBody EzMap param) throws Exception {
		return pointIssueService.getUsePointForBos(param);
	}

	@PostMapping(value = { "getOccurPointForBos" })
	public @ResponseBody Object getOccurPointForBos(@RequestBody EzMap param) throws Exception {
		return pointIssueService.getOccurPointForBos(param);
	}

	@PostMapping(value = { "updateAdvn" })
	public @ResponseBody Object updateAdvn(@RequestBody CrmCustBasVo vo) throws Exception {
		return service.updateAdvn(vo);
	}

}
