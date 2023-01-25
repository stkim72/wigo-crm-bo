package com.ceragem.crm.memship.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ceragem.crm.common.model.EzMap;
import com.ceragem.crm.common.model.EzPaginationInfo;
import com.ceragem.crm.common.util.Utilities;
import com.ceragem.crm.mem.model.PartnerHomeVo;
import com.ceragem.crm.mem.service.PartnerHomeService;
import com.ceragem.crm.mem.service.PointIssueService;
import com.ceragem.crm.memship.model.CrmAdvncmtHstVo;
import com.ceragem.crm.memship.model.CrmMshipApplyChlRelVo;
import com.ceragem.crm.memship.model.CrmMshipApplyGodsRelVo;
import com.ceragem.crm.memship.model.CrmMshipApplyStorRelVo;
import com.ceragem.crm.memship.model.CrmMshipCoupnBasVo;
import com.ceragem.crm.memship.model.CrmMshipStmpBasVo;
import com.ceragem.crm.memship.model.CrmStorBasVo;
import com.ceragem.crm.memship.service.CrmGodsBasService;
import com.ceragem.crm.memship.service.CrmMshipApplyChlRelService;
import com.ceragem.crm.memship.service.CrmMshipApplyGodsRelService;
import com.ceragem.crm.memship.service.CrmMshipApplyStorRelService;
import com.ceragem.crm.memship.service.CrmMshipCoupnBasService;
import com.ceragem.crm.memship.service.CrmMshipStmpBasService;
import com.ceragem.crm.memship.service.CrmStorBasService;
import com.ceragem.crm.sys.model.CrmComnCdBaseVo;
import com.ceragem.crm.sys.service.CrmComnCdService;

/**
 * 
 * @ClassName CrmMshipCoupnBasController
 * @author Lee Kwang
 * @date 2022. 5. 17.
 * @Version 1.0
 * @description CRM멤버십스탬프기본 Controller
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Controller
@RequestMapping(value = { "crmMshipStampBas", "{menuCd}/crmMshipStampBas" })
public class CrmMshipStampBasController {

	@Autowired
	CrmComnCdService codeService;

	@Autowired
	CrmMshipStmpBasService service;

	@Autowired
	CrmMshipCoupnBasService serviceCpn;

	@Autowired
	CrmGodsBasService serviceGodsBase;

	@Autowired
	CrmMshipApplyStorRelService serviceStoreRel;

	@Autowired
	CrmMshipApplyGodsRelService serviceGodsRel;

	@Autowired
	CrmStorBasService serviceStroeBase;

	@Autowired
	PartnerHomeService servicePartner;

	@Autowired
	CrmMshipApplyChlRelService serviceChlRel;

	@Autowired
	PointIssueService pointIssueService;

	/**
	 * 
	 * @author Lee Kwang
	 * @date 2022. 10. 17.
	 * @param param
	 * @param model
	 * @return
	 * @throws Exception
	 * @description 스탬프 시작
	 *
	 */
	@GetMapping(value = { "", "index" })
	public String init(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {

		Map<String, Object> comnData = new HashMap<>();
		comnData.put("comnCdLvlNo", "2");
		comnData.put("useYn", "Y");

		List<EzMap> godsLclss = serviceGodsBase.getGodsLclss(null);
		param.put("godsLclss", godsLclss);

		model.addAllAttributes(param);

		return Utilities.getProperty("tiles.crm.type3") + "memship/crmMshipStampBasList";
	}

	/**
	 * 
	 * @author Lee Kwang
	 * @date 2022. 10. 17.
	 * @param param
	 * @return
	 * @throws Exception
	 * @description 스탬프 마스터 리스트
	 *
	 */
	@PostMapping(value = { "getList" })
	public @ResponseBody Object getList(@RequestBody EzMap param) throws Exception {
		EzPaginationInfo page = param.getPaginationInfo();
		List<CrmMshipStmpBasVo> list = service.getList(param);
		page.setTotalRecordCount(service.getListCount(param));
		return Utilities.getGridData(list, page);
	}

	/**
	 * 
	 * @author Lee Kwang
	 * @date 2022. 10. 17.
	 * @param param
	 * @return
	 * @throws Exception
	 * @description 스탬프 마스터 팝업
	 *
	 */
	@PostMapping(value = { "getListPop" })
	public @ResponseBody Object getListPop(@RequestBody EzMap param) throws Exception {
		EzPaginationInfo page = param.getPaginationInfo();
		List<EzMap> list = service.getListPop(param);
		page.setTotalRecordCount(list.size());
		return Utilities.getGridData(list, page);
	}

	/**
	 * 스탬프 마스터 리스트
	 * 
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = { "getListPopForCust" })
	public @ResponseBody Object getListPopForCust(@RequestBody EzMap param) throws Exception {
		EzPaginationInfo page = param.getPaginationInfo();
		List<EzMap> list = service.getListPopForCust(param);
		page.setTotalRecordCount(service.getListPopForCustCount(param));
		return Utilities.getGridData(list, page);
	}

	/**
	 * 
	 * @author Lee Kwang
	 * @date 2022. 10. 17.
	 * @param vo
	 * @return
	 * @throws Exception
	 * @description 스탬프 등록/수정
	 *
	 */
	@PostMapping(value = { "save" })
	public @ResponseBody Object save(@RequestBody CrmMshipStmpBasVo vo) throws Exception {
		vo.setAccumChlTxn(vo.getAccumChl());
		EzMap save = service.save(vo);
		if ("C".equalsIgnoreCase(vo.getStat()) || "U".equalsIgnoreCase(vo.getStat())) {
			String stmpNo = null;
			if ("C".equalsIgnoreCase(vo.getStat())) {
				stmpNo = service.getMaxStmpNo();
			} else if ("U".equalsIgnoreCase(vo.getStat())) {
				stmpNo = vo.getMshipStmpBasNo();
			}

			CrmMshipApplyChlRelVo chlDelVo = new CrmMshipApplyChlRelVo();
			chlDelVo.setMshipStmpBasNo(stmpNo);
			serviceChlRel.delete(chlDelVo);

			List<String> chl = vo.getAccumChls();
			for (String chlCode : chl) {
				CrmMshipApplyChlRelVo chlVo = new CrmMshipApplyChlRelVo();
				chlVo.setMshipStmpBasNo(stmpNo);
				chlVo.setApplyChlCd(chlCode);
				chlVo.setStat("C");
				serviceChlRel.save(chlVo);
			}
		}
		return save;
	}

	/**
	 * 
	 * @author Lee Kwang
	 * @date 2022. 10. 17.
	 * @param vo
	 * @return
	 * @throws Exception
	 * @description 스탬프 마스터 복사
	 *
	 */
	@PostMapping(value = { "copy" })
	public @ResponseBody Object copy(@RequestBody CrmMshipStmpBasVo vo) throws Exception {

		EzMap save = service.save(vo);

		int result = 0;
		result += service.copyStmpMaster(vo);
		if (result > 0) {
			String maxStmpNo = service.getMaxStmpNo();
			EzMap parm = new EzMap();
			parm.put("mshipStmpBasNo", vo.getMshipStmpBasNo());
			parm.put("maxStmpNo", maxStmpNo);
			parm.put("amdrId", vo.getAmdrId());
			parm.put("regrId", vo.getRegrId());

			result += service.copyStmpStore(parm);
			result += service.copyStmpGods(parm);
			result += service.copyStmpChl(parm);
		}
		return save;
	}

	/**
	 * 
	 * @author Lee Kwang
	 * @date 2022. 10. 17.
	 * @param param
	 * @return
	 * @throws Exception
	 * @description 스탬프 쿠폰검색
	 *
	 */
	@PostMapping(value = { "searchCpn" })
	public @ResponseBody Object searchCpn(@RequestBody EzMap param) throws Exception {
		EzPaginationInfo page = param.getPaginationInfo();

		param.put("useYn", "Y");

		List<CrmMshipCoupnBasVo> list = serviceCpn.getList(param);
		page.setTotalRecordCount(serviceCpn.getListCount(param));

		return Utilities.getGridData(list, page);
	}

	/**
	 * 
	 * @author Lee Kwang
	 * @date 2022. 10. 17.
	 * @param list
	 * @return
	 * @throws Exception
	 * @description 스탬프 삭제
	 *
	 */
	@PostMapping(value = { "delete" })
	public @ResponseBody Object delete(@RequestBody CrmMshipStmpBasVo list) throws Exception {

		int delete = service.delete(list);
		if (delete > 0) {
			service.deleteStmpHis(list);
			service.deleteStmpStor(list);
			service.deleteStmpGods(list);
			service.deleteStmpChl(list);
		}
		return delete;
	}

	/**
	 * 
	 * @author Lee Kwang
	 * @date 2022. 10. 17.
	 * @param param
	 * @return
	 * @throws Exception
	 * @description 사용매장 리스트
	 *
	 */
	@PostMapping(value = { "getListStoreRel" })
	public @ResponseBody Object getListStoreRel(@RequestBody EzMap param) throws Exception {
		EzPaginationInfo page = param.getPaginationInfo();
		List<CrmMshipApplyStorRelVo> list = serviceStoreRel.getList(param);
		page.setTotalRecordCount(serviceStoreRel.getListCount(param));
		return Utilities.getGridData(list, page);
	}

	/**
	 * 
	 * @author Lee Kwang
	 * @date 2022. 10. 17.
	 * @param param
	 * @param model
	 * @return
	 * @throws Exception
	 * @description 매장선택 팝업
	 *
	 */
	@RequestMapping(value = { "popStore" }, method = { RequestMethod.POST, RequestMethod.GET })
	public String popStore(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {

		model.addAllAttributes(param);
		// 전체 매장
		List<CrmStorBasVo> list = (List<CrmStorBasVo>) serviceStroeBase.getTreeList(param);

		// 쿠폰이 적용된 매장
		List<CrmStorBasVo> storeList = null;
		if (!Utilities.isEmpty(param.get("mshipStmpBasNo"))) {
			storeList = (List<CrmStorBasVo>) serviceStroeBase.getStoreList(param);
		}

		model.addAttribute("allStore", list);
		model.addAttribute("storeList", storeList);

		return Utilities.getProperty("tiles.crm") + "memship/popStore";
	}

	/**
	 * 
	 * @author Lee Kwang
	 * @date 2022. 10. 17.
	 * @param list
	 * @return
	 * @throws Exception
	 * @description 매장관리 저장
	 *
	 */
	@PostMapping(value = { "saveStoreList" })
	public @ResponseBody Object saveStoreList(@RequestBody List<CrmMshipApplyStorRelVo> list) throws Exception {
		return serviceStoreRel.saveList(list);
	}

	/**
	 * 
	 * @author Lee Kwang
	 * @date 2022. 10. 17.
	 * @param list
	 * @return
	 * @throws Exception
	 * @description 매장관리 삭제
	 *
	 */
	@PostMapping(value = { "delStoreList" })
	public @ResponseBody Object delStoreList(@RequestBody List<CrmMshipApplyStorRelVo> list) throws Exception {
		return serviceStoreRel.deleteList(list);
	}

	/**
	 * 
	 * @author Lee Kwang
	 * @date 2022. 10. 17.
	 * @param param
	 * @return
	 * @throws Exception
	 * @description 상품 공통코드 조회 [{"topComnCd":no,"comnCdLvlNo":"2"}]
	 *
	 */
	@PostMapping(value = { "getComnCdList" })
	public @ResponseBody Object getComnCdList(@RequestBody Map<String, Object> param) throws Exception {
		EzMap vo = new EzMap(param);
		List<EzMap> list = service.getComnList(vo);
		return list;
	}

	/**
	 * 
	 * @author Lee Kwang
	 * @date 2022. 10. 17.
	 * @param param
	 * @return
	 * @throws Exception
	 * @description 상품리스트
	 *
	 */
	@PostMapping(value = { "getGodsList" })
	public @ResponseBody Object getGodsList(@RequestBody Map<String, Object> param) throws Exception {
		List<CrmComnCdBaseVo> list = serviceGodsBase.getList(param);
		return list;
	}

	/**
	 * 
	 * @author Lee Kwang
	 * @date 2022. 10. 17.
	 * @param list
	 * @return
	 * @throws Exception
	 * @description 상품관리 팝업
	 *
	 */
	@PostMapping(value = { "saveGodsList" })
	public @ResponseBody Object saveGodsList(@RequestBody List<CrmMshipApplyGodsRelVo> list) throws Exception {
		return serviceGodsRel.saveList(list);
	}

	/**
	 * 
	 * @author Lee Kwang
	 * @date 2022. 10. 17.
	 * @return
	 * @throws Exception
	 * @description 제휴사 정보조회
	 *
	 */
	@PostMapping(value = { "getPartnerList" })
	public @ResponseBody List<PartnerHomeVo> getPartnerList() throws Exception {
		return servicePartner.getList(null);
	}

	/**
	 * 
	 * @author Lee Kwang
	 * @date 2022. 10. 17.
	 * @param param
	 * @return
	 * @throws Exception
	 * @description 등록상품 리스트
	 *
	 */
	@PostMapping(value = { "getGodsRelList" })
	public @ResponseBody Object getGodsRelList(@RequestBody EzMap param) throws Exception {

		EzPaginationInfo page = param.getPaginationInfo();
		List<CrmMshipApplyGodsRelVo> list = serviceGodsRel.getList(param);
		page.setTotalRecordCount(serviceGodsRel.getListCount(param));
		return Utilities.getGridData(list, page);
	}

	/**
	 * 
	 * @author Lee Kwang
	 * @date 2022. 10. 17.
	 * @param param
	 * @return
	 * @throws Exception
	 * @description 발행이력
	 *
	 */
	@PostMapping(value = { "getListStmpRel" })
	public @ResponseBody Object getListStmpRel(@RequestBody EzMap param) throws Exception {
		EzPaginationInfo page = param.getPaginationInfo();
		List<EzMap> list = service.getStmpHisList(param);

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).get("mphonNo") != null) {
				String mphoneNo = Utilities.decrypt(String.valueOf(list.get(i).get("mphonNo")));
				String strFrontNo = mphoneNo.substring(0, 3);
				String strBackNo = mphoneNo.substring(mphoneNo.length() - 4, mphoneNo.length());
				list.get(i).put("mphonNo", strFrontNo + "-****-" + strBackNo);
			}
		}
		page.setTotalRecordCount(service.getStmpHisListCount(param));
		return Utilities.getGridData(list, page);
	}

	/**
	 * 
	 * @author Lee Kwang
	 * @date 2022. 10. 17.
	 * @param vo
	 * @return
	 * @throws Exception
	 * @description 스탬프 이력체크
	 *
	 */
	@PostMapping(value = { "checkIssue" })
	public @ResponseBody Object checkIssue(@RequestBody CrmMshipStmpBasVo vo) throws Exception {

		EzMap parm = new EzMap();
		parm.put("mshipStmpBasNo", vo.getMshipStmpBasNo());
		EzMap check = service.checkIssueHis(parm);
		return check;
	}

	/**
	 * 
	 * @author Lee Kwang
	 * @date 2022. 10. 17.
	 * @param param
	 * @param model
	 * @return
	 * @throws Exception
	 * @description 스탬프 발행
	 *
	 */
	@GetMapping(value = { "stampIssue" })
	public String stampIssue(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		return Utilities.getProperty("tiles.crm") + "memship/crmMshipStampIssueList";
	}

	/**
	 * 
	 * @author Lee Kwang
	 * @date 2022. 10. 17.
	 * @param param
	 * @return
	 * @throws Exception
	 * @description 스탬프 발행이력 검색
	 *
	 */
	@PostMapping(value = { "searchStmpList" })
	public @ResponseBody Object searchStmpList(@RequestBody EzMap param) throws Exception {
		EzPaginationInfo page = param.getPaginationInfo();
		List<CrmMshipStmpBasVo> list = service.searchStmpList(param);
		page.setTotalRecordCount(service.searchStmpListCount(param));
		return Utilities.getGridData(list, page);
	}

	/**
	 * 
	 * @author Lee Kwang
	 * @date 2022. 10. 17.
	 * @param param
	 * @param model
	 * @return
	 * @throws Exception
	 * @description 스탬프 상세보기
	 *
	 */
	@GetMapping(value = { "add" })
	public String add(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {

		CrmMshipStmpBasVo stmpInfo = service.getStmpBasInfo(param);

		Map<String, Object> comnData = new HashMap<>();
		comnData.put("topComnCd", "ST040");
		comnData.put("comnCdLvlNo", "2");
		comnData.put("useYn", "Y");
		List<CrmComnCdBaseVo> chlList = codeService.getList(comnData);

		model.addAttribute("chlList", chlList);
		model.addAttribute("stmpInfo", stmpInfo);

		List<EzMap> godsLclss = serviceGodsBase.getGodsLclss(null);
		param.put("godsLclss", godsLclss);
		model.addAllAttributes(param);

		return Utilities.getProperty("tiles.crm") + "memship/crmMshipStampIssueDetail";
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
	@GetMapping(value = { "stmpPopupManual" })
	public String stmpPopupManual(CrmAdvncmtHstVo vo, @RequestParam Map<String, Object> param, ModelMap model)
			throws Exception {
		EzMap stmpInfo = service.getStmpBasInfoForPopup(param);
		model.addAttribute("stmpIssue", stmpInfo);
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm") + "mem/MB221";
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
	@GetMapping(value = { "popUser" })
	public String popCoupn(CrmAdvncmtHstVo vo, @RequestParam Map<String, Object> param, ModelMap model)
			throws Exception {
		model.addAttribute("mshipStmpBasNo", String.valueOf(param.get("mshipStmpBasNo")).trim());
		return Utilities.getProperty("tiles.crm") + "mem/popUser";
	}

	/**
	 * 
	 * @author 김은성
	 * @date 2022. 4. 7. * @param param
	 * @return
	 * @throws Exception
	 * @description CRM멤버십쿠폰기본 회원조회
	 *
	 */
	@PostMapping(value = { "getMemSearchList" })
	public @ResponseBody Object getMemSearchList(@RequestBody EzMap param) throws Exception {

		EzPaginationInfo page = param.getPaginationInfo();
		List<EzMap> list = service.getTargetSearchListForStmp(param);
		int count = service.getTargetSearchForStmpCount(param);
		page.setTotalRecordCount(count);

		return Utilities.getGridData(list, page);
	}

	/**
	 * 
	 * @author Lee Kwang
	 * @date 2022. 10. 17.
	 * @param param
	 * @return
	 * @throws Exception
	 * @description 스탬프 적립
	 *
	 */
	@PostMapping(value = { "/sub/stmpPopup/saveStmpIssue" })
	public @ResponseBody Object saveStmpIssue(@RequestBody EzMap param) throws Exception {
		return service.saveStmpIssue(param);
	}

	/**
	 * 
	 * @author Lee Kwang
	 * @date 2022. 10. 17.
	 * @param param
	 * @param model
	 * @return
	 * @throws Exception
	 * @description 상품팝업
	 *
	 */
	@RequestMapping(value = { "popGods" }, method = { RequestMethod.POST, RequestMethod.GET })
	public String popGods(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {

		model.addAllAttributes(param);

		// 전체 상품
		List<CrmMshipApplyGodsRelVo> list = serviceGodsRel.selectAllGodList(param);

		// 적용된 상품 매장
		List<CrmMshipApplyGodsRelVo> godsList = null;

		if (!Utilities.isEmpty(param.get("mshipStmpBasNo"))) {
			godsList = serviceGodsRel.selectGodList(param);
		}

		model.addAttribute("allGods", list);
		model.addAttribute("godsList", godsList);

		List<EzMap> godsLclss = serviceGodsBase.getGodsLclss(null);
		param.put("godsLclss", godsLclss);
		model.addAllAttributes(param);

		return Utilities.getProperty("tiles.crm") + "memship/popGods";
	}

	/**
	 * 
	 * @author Lee Kwang
	 * @date 2022. 10. 17.
	 * @param list
	 * @return
	 * @throws Exception
	 * @description 상품삭제
	 *
	 */
	@PostMapping(value = { "delGodsList" })
	public @ResponseBody Object delGodsList(@RequestBody List<CrmMshipApplyGodsRelVo> list) throws Exception {
		return serviceGodsRel.deleteList(list);
	}

	/**
	 * 
	 * @author Lee Kwang
	 * @date 2022. 10. 17.
	 * @param vo
	 * @return
	 * @throws Exception
	 * @description 스탬프 내용변경 (이력 있을시 기간,사용여부 만 가능)
	 *
	 */
	@PostMapping(value = { "updateStmpInfo" })
	public @ResponseBody Object updateStmpInfo(@RequestBody CrmMshipStmpBasVo vo) throws Exception {
		return service.updateStmpInfo(vo);
	}
}
