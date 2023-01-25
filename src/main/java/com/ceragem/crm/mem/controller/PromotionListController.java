package com.ceragem.crm.mem.controller;

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
import com.ceragem.crm.mem.model.PromotionListVo;
import com.ceragem.crm.mem.service.PartnerHomeService;
import com.ceragem.crm.mem.service.PromotionListService;
import com.ceragem.crm.memship.model.CrmMshipApplyChlRelVo;
import com.ceragem.crm.memship.model.CrmMshipApplyGodsRelVo;
import com.ceragem.crm.memship.model.CrmMshipApplyStorRelVo;
import com.ceragem.crm.memship.model.CrmStorBasVo;
import com.ceragem.crm.memship.service.CrmGodsBasService;
import com.ceragem.crm.memship.service.CrmMshipApplyChlRelService;
import com.ceragem.crm.memship.service.CrmMshipApplyGodsRelService;
import com.ceragem.crm.memship.service.CrmMshipApplyStorRelService;
import com.ceragem.crm.memship.service.CrmStorBasService;
import com.ceragem.crm.sys.model.CrmComnCdBaseVo;

/**
 * 
 * @ClassName PromotionListController
 * @author 황재희
 * @date 2022. 5. 23.
 * @Version 1.0
 * @description CRM멤버십프로모션기본 Controller
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
//@Slf4j
@Controller
@RequestMapping(value = { "promotionList", "{menuCd}/promotionList" })
public class PromotionListController {

	@Autowired
	PromotionListService service;

	@Autowired
	PartnerHomeService servicePartner;

	@Autowired
	CrmMshipApplyChlRelService serviceChlRel;

	@Autowired
	CrmMshipApplyStorRelService serviceStoreRel;

	@Autowired
	CrmMshipApplyGodsRelService serviceGodsRel;

	@Autowired
	CrmStorBasService serviceStroeBase;

	@Autowired
	CrmGodsBasService serviceGodsBase;

	/**
	 * 
	 * @author 황재희
	 * @date 2022. 5. 23. * @param param
	 * @param model
	 * @return
	 * @throws Exception
	 * @description CRM멤버십프로모션기본 목록페이지
	 *
	 */
	@GetMapping(value = { "", "index" })
	public String init(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		List<EzMap> godsLclss = serviceGodsBase.getGodsLclss(null);
		param.put("godsLclss", godsLclss);

		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm") + "mem/MB040";
	}

	/**
	 * 
	 * @author 황재희
	 * @date 2022. 5. 23. * @param param
	 * @return
	 * @throws Exception
	 * @description CRM멤버십프로모션기본 목록검색
	 *
	 */
	@PostMapping(value = { "getList" })
	public @ResponseBody Object getList(@RequestBody EzMap param) throws Exception {
		EzPaginationInfo page = param.getPaginationInfo();
		List<PromotionListVo> list = service.getList(param);
		page.setTotalRecordCount(service.getListCount(param));
		return Utilities.getGridData(list, page);
	}

	/**
	 * 
	 * @author 황재희
	 * @date 2022. 5. 23. * @param rparam
	 * @return
	 * @throws Exception
	 * @description CRM멤버십프로모션기본 1건검색
	 *
	 */
	@GetMapping(value = { "get" })
	public @ResponseBody Object get(@RequestParam Map<String, Object> rparam) throws Exception {
		EzMap param = new EzMap(rparam);
		return service.get(param);
	}

	/**
	 * 
	 * @author 황재희
	 * @date 2022. 5. 23. * @param vo
	 * @return
	 * @throws Exception
	 * @description CRM멤버십프로모션기본 저장
	 */
	@PostMapping(value = { "save" })
	public @ResponseBody Object save(@RequestBody PromotionListVo vo) throws Exception {
		return service.save(vo);
	}

	/**
	 * 
	 * @author 황재희
	 * @date 2022. 5. 23. * @param list
	 * @return
	 * @throws Exception
	 * @description CRM멤버십프로모션기본 리스트 저장
	 *
	 */
	@PostMapping(value = { "saveList" })
	public @ResponseBody Object saveList(@RequestBody List<PromotionListVo> list) throws Exception {
		return service.saveList(list);
	}

	/**
	 * 
	 * @author 황재희
	 * @date 2022. 5. 23.
	 * @param list
	 * @return
	 * @throws Exception
	 * @description CRM멤버십프로모션기본 리스트 삭제
	 *
	 */
	@PostMapping(value = { "deleteList" })
	public @ResponseBody Object deleteList(@RequestBody List<PromotionListVo> list) throws Exception {
		return service.deleteList(list);
	}

	/**
	 * 
	 * @author 황재희
	 * @date 2022. 5. 27.
	 * @param list
	 * @return
	 * @throws Exception
	 * @description 제휴사 목록 검색
	 *
	 */
	@PostMapping(value = { "getPartnerList" })
	public @ResponseBody List<PartnerHomeVo> getPartnerList() throws Exception {
		return servicePartner.getList(null);
	}

	/**
	 * 
	 * @author 황재희
	 * @date 2022. 5. 30.
	 * @param list
	 * @return
	 * @throws Exception
	 * @description 프로모션 복사
	 *
	 */
	@PostMapping(value = { "copy" })
	public @ResponseBody Object copy(@RequestBody PromotionListVo vo) throws Exception {

		EzMap save = service.save(vo);

		service.copyPromotion(vo);
		String maxPromNo = service.getMaxPromNo();

		EzMap parm = new EzMap();
		parm.put("mshipPromBasNo", vo.getMshipPromBasNo());
		parm.put("maxPromNo", maxPromNo);
		parm.put("amdrId", vo.getAmdrId());
		parm.put("regrId", vo.getRegrId());

		service.copyPromStore(parm);
		service.copyPromGods(parm);

		return save;
	}

	/**
	 * 
	 * @author 황재희
	 * @date 2022. 6. 2. * @param param
	 * @return
	 * @throws Exception
	 * @description 프로모션 적용매장 검색
	 *
	 */
	@PostMapping(value = { "getChlRelList" })
	public @ResponseBody Object getChlRelList(@RequestBody EzMap param) throws Exception {
		EzPaginationInfo page = param.getPaginationInfo();
		List<CrmMshipApplyChlRelVo> list = serviceChlRel.getList(param);
		page.setTotalRecordCount(serviceChlRel.getListCount(param));
		return Utilities.getGridData(list, page);
	}

	/**
	 * 
	 * @author 황재희
	 * @date 2022. 6. 2.
	 * @param list
	 * @return
	 * @throws Exception
	 * @description 프로모션 적용채널 관리 팝업
	 *
	 */
	@RequestMapping(value = { "popChl" }, method = { RequestMethod.POST, RequestMethod.GET })
	public String popChl(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAllAttributes(param);
		// 전체 채널
		param.put("codeCd", "ST040");
		List<CrmComnCdBaseVo> list = serviceChlRel.selectAllChlList(param);

		// 선택된 채널
		List<CrmMshipApplyChlRelVo> channelList = serviceChlRel.selectChlList(param);

		model.addAttribute("allChannel", list);
		model.addAttribute("channelList", channelList);

		return Utilities.getProperty("tiles.crm") + "mem/MB048";
	}

	/**
	 * 
	 * @author 황재희
	 * @date 2022. 6. 2. * @param list
	 * @return
	 * @throws Exception
	 * @description 프로모션 적용채널 추가
	 *
	 */
	@PostMapping(value = { "saveChlList" })
	public @ResponseBody Object saveChlList(@RequestBody List<CrmMshipApplyChlRelVo> list) throws Exception {
		return serviceChlRel.saveList(list);
	}

	/**
	 * 
	 * @author 황재희
	 * @date 2022. 6. 2. * @param list
	 * @return
	 * @throws Exception
	 * @description 프로모션 적용채널 삭제
	 *
	 */
	@PostMapping(value = { "delChlList" })
	public @ResponseBody Object delChlList(@RequestBody List<CrmMshipApplyChlRelVo> list) throws Exception {
		return serviceChlRel.deleteList(list);
	}

	/**
	 * 
	 * @author user
	 * @date 2022. 4. 21. * @param param
	 * @return
	 * @throws Exception
	 * @description 프로모션 매장 목록검색
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
	 * @author 황재희
	 * @date 2022. 6. 7. * @param param
	 * @param model
	 * @return
	 * @throws Exception
	 * @description 프로모션 적용매장 관리 팝업
	 *
	 */
	@RequestMapping(value = { "popStore" }, method = { RequestMethod.POST, RequestMethod.GET })
	public String popStore(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {

		model.addAllAttributes(param);

		// 전체 매장
		List<CrmStorBasVo> list = (List<CrmStorBasVo>) serviceStroeBase.getTreeList(param);

		// 쿠폰이 적용된 매장
		List<CrmStorBasVo> storeList = (List<CrmStorBasVo>) serviceStroeBase.getStoreList(param);

		model.addAttribute("allStore", list);
		model.addAttribute("storeList", storeList);

		// return Utilities.getProperty("tiles.crm") + "mem/MB044"; // 동일한 페이지 인데 별도로 만들
		// 필요없음
		return Utilities.getProperty("tiles.crm") + "memship/popStore";
	}

	/**
	 * 
	 * @author 황재희
	 * @date 2022. 6. 7. * @param list
	 * @return
	 * @throws Exception
	 * @description 프로모션 매장 추가
	 *
	 */
	@PostMapping(value = { "saveStoreList" })
	public @ResponseBody Object saveStoreList(@RequestBody List<CrmMshipApplyStorRelVo> list) throws Exception {
		return serviceStoreRel.saveList(list);
	}

	/**
	 * 
	 * @author 황재희
	 * @date 2022. 6. 7. * @param list
	 * @return
	 * @throws Exception
	 * @description 프로모션 매장 삭제
	 *
	 */
	@PostMapping(value = { "delStoreList" })
	public @ResponseBody Object delStoreList(@RequestBody List<CrmMshipApplyStorRelVo> list) throws Exception {
		return serviceStoreRel.deleteList(list);
	}

	/**
	 * 
	 * @author 황재희
	 * @date 2022. 6. 7. * @param param
	 * @return
	 * @throws Exception
	 * @description 프로모션 상품 목록검색
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
	 * @author 황재희
	 * @date 2022. 6. 7. * @param param
	 * @param model
	 * @return
	 * @throws Exception
	 * @description 프로모션 적용상품 관리 팝업
	 *
	 */
	@RequestMapping(value = { "popGods" }, method = { RequestMethod.POST, RequestMethod.GET })
	public String popGods(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {

		model.addAllAttributes(param);

		// 전체 상품
		List<CrmMshipApplyGodsRelVo> list = serviceGodsRel.selectAllGodList(param);

		// 적용된 상품 매장
		List<CrmMshipApplyGodsRelVo> godsList = serviceGodsRel.selectGodList(param);

		model.addAttribute("allGods", list);
		model.addAttribute("godsList", godsList);

		List<EzMap> godsLclss = serviceGodsBase.getGodsLclss(null);
		param.put("godsLclss", godsLclss);
		model.addAllAttributes(param);

		return Utilities.getProperty("tiles.crm") + "mem/MB046";
	}

	/**
	 * 
	 * @author 황재희
	 * @date 2022. 6. 7. * @param list
	 * @return
	 * @throws Exception
	 * @description 프로모션 상품 추가
	 *
	 */
	@PostMapping(value = { "saveGodsList" })
	public @ResponseBody Object saveGodsList(@RequestBody List<CrmMshipApplyGodsRelVo> list) throws Exception {
		return serviceGodsRel.saveList(list);
	}

	/**
	 * 
	 * @author 황재희
	 * @date 2022. 6. 7. * @param list
	 * @return
	 * @throws Exception
	 * @description 프로모션 상품 삭제
	 *
	 */
	@PostMapping(value = { "delGodsList" })
	public @ResponseBody Object delGodsList(@RequestBody List<CrmMshipApplyGodsRelVo> list) throws Exception {
		return serviceGodsRel.deleteList(list);
	}

	/**
	 *
	 * @author 황재희
	 * @date 2022. 6. 9.
	 * @return
	 * @throws Exception
	 * @description 프로모션 주문현황 검색
	 *
	 */
	@PostMapping(value = { "getBosOrderList" })
	public @ResponseBody Object getBosOrderList(@RequestBody EzMap param) throws Exception {
		EzPaginationInfo page = param.getPaginationInfo();

		EzMap promInfo = service.getPromInfo(param);
		if (Utilities.isEmpty(promInfo) || promInfo == null) {
			return null;
		}
		// statusCd , 002 >> 진행중
//		if (!promInfo.getString("statusCd").equals("002")) {
//			return null;
//		}

		List<EzMap> ordList = service.getOrderList(param);
		String bosOrdNo = "";
		StringBuffer bf = new StringBuffer();
		for (EzMap ezMap : ordList) {
			if (!Utilities.isEmpty(ezMap.get("bosOrdNos"))) {
				bf.append(ezMap.getString("bosOrdNos"));
				bf.append(",");
			}
		}

		bosOrdNo = bf.toString();

		String[] bosOrdNos = bosOrdNo.split(",");
		param.put("bosOrdNos", bosOrdNos);

		if (!Utilities.isEmpty(promInfo.getString("applyMshpGradeCtnts"))) {
			String[] gradeCd = promInfo.getString("applyMshpGradeCtnts").split(",");
			param.put("gradeCd", gradeCd);
		}

		if (!Utilities.isEmpty(promInfo.getString("mshipTypeCds"))) {
			String[] typeCd = promInfo.getString("mshipTypeCds").split(",");
			param.put("typeCd", typeCd);
		}

		if (!Utilities.isEmpty(promInfo.getString("cprtCmpNo"))) {
			String cmpNo = promInfo.getString("cprtCmpNo");
			param.put("cmpNo", cmpNo);
		}

		List<PromotionListVo> list = service.getBosOrderList(param);
		page.setTotalRecordCount(service.getBosOrderListCount(param));
		return Utilities.getGridData(list, page);
	}

	/**
	 *
	 * @author 황재희
	 * @date 2022. 6. 9.
	 * @return
	 * @throws Exception
	 * @description 프로모션 주문현황 검색
	 *
	 */
	@PostMapping(value = { "getPosOrderList" })
	public @ResponseBody Object getPosOrderList(@RequestBody EzMap param) throws Exception {
		EzPaginationInfo page = param.getPaginationInfo();

		EzMap promInfo = service.getPromInfo(param);
		if (Utilities.isEmpty(promInfo) || promInfo == null) {
			return null;
		}

		List<EzMap> ordList = service.getOrderList(param);
		String posOrdNo = "";
		StringBuffer bf = new StringBuffer();
		for (EzMap ezMap : ordList) {
			if (!Utilities.isEmpty(ezMap.get("posOrdNos"))) {
				bf.append(ezMap.getString("posOrdNos"));
				bf.append(",");
			}
		}
		posOrdNo = bf.toString();
		String[] posOrdNos = posOrdNo.split(",");
		param.put("posOrdNos", posOrdNos);

		// statusCd , 002 >> 진행중
//		if (!promInfo.getString("statusCd").equals("002")) {
//			return null;
//		}
		if (!Utilities.isEmpty(promInfo.getString("applyMshpGradeCtnts"))) {
			String[] gradeCd = promInfo.getString("applyMshpGradeCtnts").split(",");
			param.put("gradeCd", gradeCd);
		}

		if (!Utilities.isEmpty(promInfo.getString("mshipTypeCds"))) {
			String[] typeCd = promInfo.getString("mshipTypeCds").split(",");
			param.put("typeCd", typeCd);
		}

		if (!Utilities.isEmpty(promInfo.getString("cprtCmpNo"))) {
			String cmpNo = promInfo.getString("cprtCmpNo");
			param.put("cmpNo", cmpNo);
		}

		List<PromotionListVo> list = service.getPosOrderList(param);
		page.setTotalRecordCount(service.getPosOrderListCount(param));
		return Utilities.getGridData(list, page);
	}

	/**
	 *
	 * @author 황재희
	 * @date 2022. 6. 13.
	 * @return
	 * @throws Exception
	 * @description 프로모션 포인트현황 검색
	 *
	 */
	@PostMapping(value = { "getPointList" })
	public @ResponseBody Object getPointList(@RequestBody EzMap param) throws Exception {
		EzPaginationInfo page = param.getPaginationInfo();
		List<PromotionListVo> list = service.getPointList(param);
		page.setTotalRecordCount(service.getPointListCount(param));
		return Utilities.getGridData(list, page);
	}

	/**
	 *
	 * @author 황재희
	 * @date 2022. 6. 15.
	 * @return
	 * @throws Exception
	 * @description 프로모션 쿠폰현황 검색
	 *
	 */
	@PostMapping(value = { "getCoupnList" })
	public @ResponseBody Object getCoupnList(@RequestBody EzMap param) throws Exception {
		EzPaginationInfo page = param.getPaginationInfo();
		List<PromotionListVo> list = service.getCoupnList(param);
		page.setTotalRecordCount(service.getCoupnListCount(param));
		return Utilities.getGridData(list, page);
	}
}
