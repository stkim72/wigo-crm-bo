package com.ceragem.crm.memship.controller;

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
import com.ceragem.crm.memship.model.CrmGodsBasVo;
import com.ceragem.crm.memship.model.CrmMshipApplyAdvncmtRelVo;
import com.ceragem.crm.memship.model.CrmMshipApplyCoupnEventRelVo;
import com.ceragem.crm.memship.model.CrmMshipApplyCoupnRelVo;
import com.ceragem.crm.memship.model.CrmMshipApplyGodsRelVo;
import com.ceragem.crm.memship.model.CrmMshipApplyPointRelVo;
import com.ceragem.crm.memship.model.CrmMshipApplyStorRelVo;
import com.ceragem.crm.memship.model.CrmMshipCoupnBasVo;
import com.ceragem.crm.memship.model.CrmMshipPlcyBasVo;
import com.ceragem.crm.memship.model.CrmMshipPrvCoupnRelVo;
import com.ceragem.crm.memship.model.CrmStorBasVo;
import com.ceragem.crm.memship.service.CrmGodsBasService;
import com.ceragem.crm.memship.service.CrmMshipApplyAdvncmtRelService;
import com.ceragem.crm.memship.service.CrmMshipApplyCoupnEventRelService;
import com.ceragem.crm.memship.service.CrmMshipApplyCoupnRelService;
import com.ceragem.crm.memship.service.CrmMshipApplyGodsRelService;
import com.ceragem.crm.memship.service.CrmMshipApplyPointRelService;
import com.ceragem.crm.memship.service.CrmMshipApplyStorRelService;
import com.ceragem.crm.memship.service.CrmMshipCoupnBasService;
import com.ceragem.crm.memship.service.CrmMshipPlcyBasService;
import com.ceragem.crm.memship.service.CrmMshipPrvCoupnRelService;
import com.ceragem.crm.memship.service.CrmStorBasService;
import com.ceragem.crm.sys.model.CrmComnCdBaseVo;
import com.ceragem.crm.sys.service.CrmComnCdService;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @ClassName CrmMshipPlcyBasController
 * @author user
 * @date 2022. 4. 11.
 * @Version 1.0
 * @description CRM멤버십정책기본 Controller
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */
@Slf4j
@Controller
@RequestMapping(value = { "memberPolicy", "{menuCd}/memberPolicy" })
public class CrmMshipPlcyBasController {

	@Autowired
	CrmMshipPlcyBasService service;

	@Autowired
	CrmMshipApplyGodsRelService serviceGodsRel;

	@Autowired
	CrmGodsBasService serviceGodsBas;

	@Autowired
	CrmComnCdService serviceComnCd;

	@Autowired
	CrmMshipCoupnBasService serviceCoupnBase;

	@Autowired
	CrmMshipPrvCoupnRelService servicePrvCoupn;

	@Autowired
	PartnerHomeService servicePartner;

	@Autowired
	CrmMshipApplyCoupnRelService serviceCoupnRel;

	@Autowired
	CrmMshipApplyCoupnEventRelService serviceEventRel;

	@Autowired
	CrmComnCdService codeService;

	@Autowired
	CrmMshipApplyPointRelService serviceEventPointRel;

	@Autowired
	CrmMshipApplyAdvncmtRelService serviceAdvnRel;

	@Autowired
	CrmStorBasService serviceStroeBase;

	@Autowired
	CrmMshipApplyStorRelService serviceStoreRel;

	/**
	 * 
	 * @author user
	 * @date 2022. 4. 11. * @param param
	 * @param model
	 * @return
	 * @throws Exception
	 * @description CRM멤버십정책기본 목록페이지
	 *
	 */
	@GetMapping(value = { "", "index" })
	public String init(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAllAttributes(param);

		// model.addAttribute("eventList", serviceEventRel.getList(param));

		 param.put("codeCd", "L");
		 param.put("codeType", "godsClassNo");
		List<CrmComnCdBaseVo> godsList = codeService.getComboCode(param);
		model.addAttribute("godsList", godsList);
		model.addAttribute("eventList", serviceEventRel.getList(param));

		return Utilities.getProperty("tiles.crm") + "memship/crmMshipPlcyBasList";
	}

	/**
	 * 
	 * @author user
	 * @date 2022. 4. 11. * @param param
	 * @return
	 * @throws Exception
	 * @description CRM멤버십정책기본 목록검색
	 *
	 */
	@PostMapping(value = { "getList" })
	public @ResponseBody Object getList(@RequestBody EzMap param) throws Exception {
		EzPaginationInfo page = param.getPaginationInfo();
		List<CrmMshipPlcyBasVo> list = service.getList(param);
		page.setTotalRecordCount(service.getListCount(param));

		return Utilities.getGridData(list, page);
	}

	/**
	 * 
	 * @author user
	 * @date 2022. 4. 15. * @param param
	 * @return
	 * @throws Exception
	 * @description CRM멤버십적용제품관계 목록검색
	 *
	 */
	@RequestMapping(value = { "getListGods" })
	public @ResponseBody Object getListGods(@RequestBody Map<String, Object> param) throws Exception {

		List<CrmMshipApplyGodsRelVo> list = serviceGodsRel.getList(param);
		return list;

	}

	/**
	 * 
	 * @author user
	 * @date 2022. 4. 11. * @param rparam
	 * @return
	 * @throws Exception
	 * @description CRM멤버십정책기본 1건검색
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
	 * @date 2022. 4. 11. * @param vo
	 * @return
	 * @throws Exception
	 * @description CRM멤버십정책기본 저장
	 */
	@PostMapping(value = { "save" })
	public @ResponseBody Object save(@RequestBody CrmMshipPlcyBasVo vo) throws Exception {
		return service.save(vo);
	}

	/**
	 * 
	 * @author user
	 * @date 2022. 4. 11. * @param vo
	 * @return
	 * @throws Exception
	 * @description CRM제품할인정책 저장
	 */
	@PostMapping(value = { "saveGods" })
	public @ResponseBody Object saveGods(@RequestBody List<CrmMshipApplyGodsRelVo> list) throws Exception {

		return service.saveList(list);
	}

	/**
	 * 
	 * @author user
	 * @date 2022. 4. 11. * @param vo
	 * @return
	 * @throws Exception
	 * @description CRM멤버십정책기본 저장
	 */
	@PostMapping(value = { "copy" })
	public @ResponseBody Object copy(@RequestBody CrmMshipPlcyBasVo vo) throws Exception {
		return service.save(vo);
	}

	/**
	 * 
	 * @author user
	 * @date 2022. 4. 11. * @param list
	 * @return
	 * @throws Exception
	 * @description CRM멤버십정책기본 리스트 저장
	 *
	 */
	@PostMapping(value = { "saveList" })
	public @ResponseBody Object saveList(@RequestBody List<CrmMshipPlcyBasVo> list) throws Exception {
		return service.saveList(list);
	}

	/**
	 * 
	 * @author user
	 * @date 2022. 4. 11. * @param list
	 * @return
	 * @throws Exception
	 * @description CRM멤버십정책기본 리스트 저장
	 *
	 */

	@PostMapping(value = { "saveGodsList" })
	public @ResponseBody Object saveGodsList(@RequestBody List<CrmMshipApplyGodsRelVo> list) throws Exception {
		return serviceGodsRel.saveList(list);
	}

	/**
	 * 
	 * @author user
	 * @date 2022. 4. 11. * @param list
	 * @return
	 * @throws Exception
	 * @description CRM멤버십정책 쿠폰제공 정책 저장
	 *
	 */

	@PostMapping(value = { "saveCouponList" })
	public @ResponseBody Object saveCouponList(@RequestBody List<CrmMshipApplyCoupnRelVo> list) throws Exception {
		log.debug("############ saveCouponList");
		return serviceCoupnRel.saveList(list);
	}

	/**
	 * 
	 * @author user
	 * @date 2022. 4. 11. * @param param
	 * @return
	 * @throws Exception
	 * @description CRM멤버십정책기본 목록검색
	 *
	 */
	@PostMapping(value = { "getEventList" })
	public @ResponseBody Object getEventList(@RequestBody Map<String, Object> param) throws Exception {

		List<CrmMshipApplyCoupnEventRelVo> list = serviceEventRel.getList(param);

		if (list.size() == 0) {
			param.put("mshipPlcyBasNo", null);
			list = serviceEventRel.getList(param);
		}
		return list;
	}

	/**
	 * 
	 * @author user
	 * @date 2022. 4. 11. * @param list
	 * @return
	 * @throws Exception
	 * @description CRM멤버십정책 이벤트 쿠폰 정책 저장
	 *
	 */

	@PostMapping(value = { "saveEventList" })
	public @ResponseBody Object saveEventList(@RequestBody List<CrmMshipApplyCoupnEventRelVo> list) throws Exception {
		log.debug("############ saveEventList");
		return serviceEventRel.saveList(list);
	}

	/**
	 * 
	 * @author user
	 * @date 2022. 4. 11.
	 * @param list
	 * @return
	 * @throws Exception
	 * @description CRM멤버십정책기본 리스트 삭제
	 *
	 */
	@PostMapping(value = { "deleteEventList" })
	public @ResponseBody Object deleteEventList(@RequestBody List<CrmMshipApplyCoupnEventRelVo> list) throws Exception {
		return serviceEventRel.deleteList(list);
	}

	/**
	 * 
	 * @author user
	 * @date 2022. 4. 18. * @param param
	 * @return
	 * @throws Exception
	 * @description CRM 쿠폰제공정책
	 *
	 */
	@PostMapping(value = { "getListApplyCoupnList" })
	public @ResponseBody Object getListApplyCoupnList(@RequestBody Map<String, Object> param) throws Exception {
		List<CrmMshipPrvCoupnRelVo> list = serviceCoupnRel.getList(param);
		return list;
	}

	/**
	 * 
	 * @author user
	 * @date 2022. 4. 18. * @param param
	 * @return
	 * @throws Exception
	 * @description CRM제품기본 목록검색
	 *
	 */
	@PostMapping(value = { "getGodsBaseList" })
	public @ResponseBody Object getGodsBaseList(@RequestBody Map<String, Object> param) throws Exception {
		List<CrmGodsBasVo> list = serviceGodsBas.getList(param);
		return list;
	}

	/**
	 * 
	 * @author user
	 * @date 2022. 4. 18. * @param param
	 * @return
	 * @throws Exception
	 * @description CRM제품기본 목록검색
	 *
	 */
	@PostMapping(value = { "getCoupnBaseList" })
	public @ResponseBody Object getCoupnBaseList(@RequestParam Map<String, Object> param) throws Exception {

		log.debug("########## " + param.get("coupnTypeCd"));
		List<CrmMshipCoupnBasVo> list = serviceCoupnBase.getList(param);
		return list;
	}

	/**
	 * 
	 * @author user
	 * @date 2022. 4. 18. * @param param
	 * @return
	 * @throws Exception
	 * @description CRM제품구분
	 *
	 */
	@PostMapping(value = { "getGodsDivList" })
	public @ResponseBody Object getGodsDivList(@RequestBody Map<String, Object> param) throws Exception {
		//List<CrmComnCdBaseVo> list = serviceComnCd.getList(param);
		
		 param.put("codeCd", "L");
		 param.put("codeType", "godsClassNo");
		List<CrmComnCdBaseVo> godsList = codeService.getComboCode(param);
		
		
		return godsList;
	}

	/**
	 * 
	 * @author user
	 * @date 2022. 4. 11.
	 * @param list
	 * @return
	 * @throws Exception
	 * @description CRM멤버십정책기본 포인트제외제품 삭제
	 *
	 */
	@PostMapping(value = { "deleteGodsRelList" })
	public @ResponseBody Object deleteGodsRelList(@RequestBody List<CrmMshipApplyGodsRelVo> list) throws Exception {
		return serviceGodsRel.deleteList(list);
	}

	/**
	 * 
	 * @author user
	 * @date 2022. 4. 11.
	 * @param list
	 * @return
	 * @throws Exception
	 * @description CRM멤버십정책기본 등급별 쿠폰 삭제
	 *
	 */
	@PostMapping(value = { "deleteCoupunRelList" })
	public @ResponseBody Object deleteCoupunRelList(@RequestBody List<CrmMshipApplyCoupnRelVo> list) throws Exception {
		return serviceCoupnRel.deleteList(list);
	}

	/**
	 * 
	 * @author user
	 * @date 2022. 4. 11.
	 * @param list
	 * @return
	 * @throws Exception
	 * @description CRM멤버십정책기본 리스트 삭제
	 *
	 */
	@PostMapping(value = { "deleteList" })
	public @ResponseBody Object deleteList(@RequestBody List<CrmMshipPlcyBasVo> list) throws Exception {
		return service.deleteList(list);
	}

	/**
	 *
	 * @author 김은성
	 * @date 2022. 4. 21.
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
	 * @author user
	 * @date 2022. 4. 11. * @param param
	 * @return
	 * @throws Exception
	 * @description CRM멤버십정책기본 이벤트 포인트 정책
	 *
	 */
	@PostMapping(value = { "getPointList" })
	public @ResponseBody Object getPointList(@RequestBody Map<String, Object> param) throws Exception {

		List<CrmMshipApplyPointRelVo> list = serviceEventPointRel.getList(param);

		if (list.size() == 0) {
			param.put("mshipPlcyBasNo", null);
			list = serviceEventPointRel.getList(param);
		}
		return list;
	}

	/**
	 * 
	 * @author user
	 * @date 2022. 4. 11. * @param list
	 * @return
	 * @throws Exception
	 * @description CRM멤버십정책 이벤트 포인트 정책 저장
	 *
	 */

	@PostMapping(value = { "savePointList" })
	public @ResponseBody Object savePointList(@RequestBody List<CrmMshipApplyPointRelVo> list) throws Exception {
		log.debug("############ savePointList");
		return serviceEventPointRel.saveList(list);
	}

	/**
	 * 
	 * @author user
	 * @date 2022. 4. 11.
	 * @param list
	 * @return
	 * @throws Exception
	 * @description CRM멤버십정책기본 이벤트 포인트 정책 삭제
	 *
	 */
	@PostMapping(value = { "deletePointList" })
	public @ResponseBody Object deletePointList(@RequestBody List<CrmMshipApplyPointRelVo> list) throws Exception {
		return serviceEventPointRel.deleteList(list);
	}

	/**
	 * 
	 * @author user
	 * @date 2022. 4. 11. * @param param
	 * @return
	 * @throws Exception
	 * @description CRM멤버십정책기본 이벤트 포인트 정책
	 *
	 */
	@PostMapping(value = { "getAdvnList" })
	public @ResponseBody Object getAdvnList(@RequestBody Map<String, Object> param) throws Exception {

		List<CrmMshipApplyAdvncmtRelVo> list = serviceAdvnRel.getList(param);

		if (list.size() == 0) {
			param.put("mshipPlcyBasNo", null);
			list = serviceAdvnRel.getList(param);
		}
		return list;
	}

	/**
	 * 
	 * @author user
	 * @date 2022. 4. 11. * @param list
	 * @return
	 * @throws Exception
	 * @description CRM멤버십정책 이벤트 포인트 정책 저장
	 *
	 */

	@PostMapping(value = { "saveAdvnList" })
	public @ResponseBody Object saveAdvnList(@RequestBody List<CrmMshipApplyAdvncmtRelVo> list) throws Exception {
		log.debug("############ savePointList");
		return serviceAdvnRel.saveList(list);
	}

	/**
	 * 
	 * @author user
	 * @date 2022. 4. 11.
	 * @param list
	 * @return
	 * @throws Exception
	 * @description CRM멤버십정책기본 이벤트 포인트 정책 삭제
	 *
	 */
	@PostMapping(value = { "deleteAdvnList" })
	public @ResponseBody Object deleteAdvnList(@RequestBody List<CrmMshipApplyAdvncmtRelVo> list) throws Exception {
		return serviceAdvnRel.deleteList(list);
	}

	/**
	 * 
	 * @author user
	 * @date 2022. 4. 21. * @param param
	 * @return
	 * @throws Exception
	 * @description CRM멤버십적용매장관계 목록검색
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
	 * @author 김은성
	 * @date 2022. 4. 7. * @param param
	 * @param model
	 * @return
	 * @throws Exception
	 * @description CRM멤버십쿠폰기본 적용매장 관리 팝업
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

		return Utilities.getProperty("tiles.crm") + "memship/popStore";
	}

	/**
	 * 
	 * @author 김은성
	 * @date 2022. 4. 7. * @param list
	 * @return
	 * @throws Exception
	 * @description CRM멤버십쿠폰기본 점포 추가
	 *
	 */
	@PostMapping(value = { "saveStoreList" })
	public @ResponseBody Object saveStoreList(@RequestBody List<CrmMshipApplyStorRelVo> list) throws Exception {
		return serviceStoreRel.saveList(list);
	}

	/**
	 * 
	 * @author 김은성
	 * @date 2022. 4. 7. * @param list
	 * @return
	 * @throws Exception
	 * @description CRM멤버십쿠폰기본 점포 삭제
	 *
	 */
	@PostMapping(value = { "delStoreList" })
	public @ResponseBody Object delStoreList(@RequestBody List<CrmMshipApplyStorRelVo> list) throws Exception {
		return serviceStoreRel.deleteList(list);
	}

}
