package com.ceragem.crm.memship.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
import com.ceragem.crm.cst.model.CrmCustGrpBasVo;
import com.ceragem.crm.cst.service.CrmCustGrpBasService;
import com.ceragem.crm.main.service.CrmCustBasService;
import com.ceragem.crm.mem.model.PartnerHomeVo;
import com.ceragem.crm.mem.service.PartnerHomeService;
import com.ceragem.crm.memship.model.CrmCoupnPblsHstVo;
import com.ceragem.crm.memship.model.CrmGodsBasVo;
import com.ceragem.crm.memship.model.CrmMshipApplyChlRelVo;
import com.ceragem.crm.memship.model.CrmMshipApplyGodsRelVo;
import com.ceragem.crm.memship.model.CrmMshipApplyStorRelVo;
import com.ceragem.crm.memship.model.CrmMshipCoupnBasVo;
import com.ceragem.crm.memship.model.CrmMshipCoupnPubCustVo;
import com.ceragem.crm.memship.model.CrmStorBasVo;
import com.ceragem.crm.memship.service.CrmCoupnPblsHstService;
import com.ceragem.crm.memship.service.CrmGodsBasService;
import com.ceragem.crm.memship.service.CrmMshipApplyChlRelService;
import com.ceragem.crm.memship.service.CrmMshipApplyGodsRelService;
import com.ceragem.crm.memship.service.CrmMshipApplyStorRelService;
import com.ceragem.crm.memship.service.CrmMshipCoupnBasService;
import com.ceragem.crm.memship.service.CrmStorBasService;
import com.ceragem.crm.sys.model.CrmComnCdBaseVo;
import com.ceragem.crm.sys.service.CrmComnCdService;

/**
 * 
 * @ClassName CrmMshipCoupnBasController
 * @author ?????????
 * @date 2022. 4. 7.
 * @Version 1.0
 * @description CRM????????????????????? Controller
 * @Company Copyright ??? wigo.ai. All Right Reserved
 */

@Controller
@RequestMapping(value = { "crmMshipCoupnBas", "{menuCd}/crmMshipCoupnBas" })
public class CrmMshipCoupnBasController {

	@Autowired
	CrmMshipCoupnBasService service;

	@Autowired
	CrmGodsBasService serviceGodsBase;

	@Autowired
	CrmMshipApplyStorRelService serviceStoreRel;

	@Autowired
	CrmMshipApplyGodsRelService serviceGodsRel;

	@Autowired
	CrmMshipApplyChlRelService serviceChlRel;

	@Autowired
	CrmStorBasService serviceStroeBase;

	@Autowired
	CrmComnCdService codeService;

	@Autowired
	CrmCustBasService serviceCustBase;

	@Autowired
	CrmCoupnPblsHstService serviceCpn;

	@Autowired
	CrmCustGrpBasService serviceGrpBase;

	@Autowired
	PartnerHomeService servicePartner;

	@Value("${spring.eon.send.url}")
	String eonUrl;

	@Value("${spring.eon.send.user}")
	String eonUser;

	/**
	 * 
	 * @author ?????????
	 * @date 2022. 4. 7. * @param param
	 * @param model
	 * @return
	 * @throws Exception
	 * @description CRM????????????????????? ???????????????
	 *
	 */
	@GetMapping(value = { "", "index" })
	public String init(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm") + "memship/crmMshipCoupnBasList";
	}

	/**
	 * 
	 * @author ?????????
	 * @date 2022. 4. 7. * @param param
	 * @return
	 * @throws Exception
	 * @description CRM????????????????????? ????????????
	 *
	 */
	@PostMapping(value = { "getList" })
	public @ResponseBody Object getList(@RequestBody EzMap param) throws Exception {
		EzPaginationInfo page = param.getPaginationInfo();
		List<CrmMshipCoupnBasVo> list = service.getList(param);
		page.setTotalRecordCount(service.getListCount(param));
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
	 * @description ???????????? ??????
	 *
	 */
	@GetMapping(value = { "add" })
	public String add(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {

		model.addAttribute("addMode", "c");

		// ?????????????????????????????? ????????? ??????
		if (!param.get("mshipCoupnBasNo").equals("")) {
			model.addAttribute("cpinfo", this.get(param));
			model.addAttribute("addMode", "u");
		}

		List<EzMap> godsLclss = serviceGodsBase.getGodsLclss(null);
		param.put("godsLclss", godsLclss);
		model.addAllAttributes(param);

		return Utilities.getProperty("tiles.crm") + "memship/crmMshipCoupnBasDetail";
	}

	/**
	 * 
	 * @author Lee Kwang
	 * @date 2022. 10. 17.
	 * @param param
	 * @param model
	 * @return
	 * @throws Exception
	 * @description CRM????????????????????? ??????????????????
	 *
	 */
	@GetMapping(value = { "cpnIssue" })
	public String cpnIssue(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {

		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm") + "memship/crmCoupnIssue";
	}

	/**
	 * 
	 * @author Lee Kwang
	 * @date 2022. 10. 17.
	 * @param param
	 * @param model
	 * @return
	 * @throws Exception
	 * @description CRM????????????????????? ??????????????????
	 *
	 */
	@GetMapping(value = { "cpnStoreIssue" })
	public String cpnStoreIssue(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {

		model.addAllAttributes(param);

		List<CrmMshipApplyStorRelVo> storNo = serviceStoreRel.getList(param);

		if (!Utilities.isEmpty(storNo) || storNo.size() > 0) {
			StringBuffer bf = new StringBuffer();
			String stor = "";
			for (CrmMshipApplyStorRelVo vo : storNo) {
				bf.append(vo.getStorNo());
				bf.append(",");
			}
			stor = bf.toString();
			model.addAttribute("storeNo", stor.substring(0, stor.length() - 1));
		}

		return Utilities.getProperty("tiles.crm") + "memship/crmCoupnStoreIssue";
	}

	/**
	 * 
	 * @author Lee Kwang
	 * @date 2022. 10. 17.
	 * @param param
	 * @param model
	 * @return
	 * @throws Exception
	 * @description CRM????????????????????? ????????????
	 *
	 */
	@GetMapping(value = { "popMemSearch" })
	public String popMemSearch(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {

		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm") + "memship/popMemSearch";
	}

	/**
	 * 
	 * @author Lee Kwang
	 * @date 2022. 10. 17.
	 * @param param
	 * @param model
	 * @return
	 * @throws Exception
	 * @description CRM????????????????????? ??????????????????
	 *
	 */
	@GetMapping(value = { "popGrpSearch" })
	public String popGrpSearch(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {

		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm") + "memship/popGrpSearch";
	}

	/**
	 * 
	 * @author Lee Kwang
	 * @date 2022. 10. 17.
	 * @param param
	 * @return
	 * @throws Exception
	 * @description CRM???????????? ????????????
	 *
	 */
	@GetMapping(value = { "getGodsBaseList" })
	public @ResponseBody Object getGodsBaseList(@RequestParam Map<String, Object> param) throws Exception {
		param.put("useYn", "Y");
		List<CrmGodsBasVo> list = serviceGodsBase.getList(param);
		return list;
	}

	/**
	 * 
	 * @author Lee Kwang
	 * @date 2022. 10. 17.
	 * @param rparam
	 * @return
	 * @throws Exception
	 * @description CRM????????????????????? 1?????????
	 *
	 */
	@GetMapping(value = { "get" })
	public @ResponseBody Object get(@RequestParam Map<String, Object> rparam) throws Exception {

		EzMap param = new EzMap(rparam);
		return service.get(param);
	}

	/**
	 * 
	 * @author ?????????
	 * @date 2022. 4. 7. * @param vo
	 * @return
	 * @throws Exception
	 * @description CRM????????????????????? ??????
	 */

	@PostMapping(value = { "save" })
	public @ResponseBody Object save(@RequestBody CrmMshipCoupnBasVo vo) throws Exception {

		if (!vo.getFromUseHour1().equals("") && !vo.getFromUseHour2().equals("")) {
			vo.setFromUseHour(vo.getFromUseHour1() + "" + vo.getFromUseHour2());
		}

		if (!vo.getToUseHour1().equals("") && !vo.getToUseHour2().equals("")) {
			vo.setToUseHour(vo.getToUseHour1() + "" + vo.getToUseHour2());
		}

		return service.save(vo);
	}

	/**
	 * 
	 * @author ?????????
	 * @date 2022. 4. 7. * @param vo
	 * @return
	 * @throws Exception
	 * @description CRM????????????????????? ??????
	 */

	@PostMapping(value = { "saveCpn" })
	public @ResponseBody Object saveCpn(@RequestBody CrmMshipCoupnBasVo vo) throws Exception {

		EzMap save = (EzMap) this.save(vo);
		EzMap result = save;
		if ("C".equalsIgnoreCase(vo.getStat()) && save != null) {
			result = service.getCoupnInfoForLast(vo);
		}
		if ("U".equalsIgnoreCase(vo.getStat()) && save != null) {
			result = service.getCoupnInfo(vo);
			// ????????? ?????? ????????? ?????? (?????? ?????? ??????)
			serviceCpn.updatePblsHist(result);
		}
		return result;
	}

	/**
	 * 
	 * @author ?????????
	 * @date 2022. 4. 7. * @param vo
	 * @return
	 * @throws Exception
	 * @description CRM????????????????????? ??????
	 */

	@PostMapping(value = { "cpyCoupon" })
	public @ResponseBody Object cpyCoupon(@RequestBody CrmMshipCoupnBasVo vo) throws Exception {
		// insert select ??? ???????????? ORA-12899: value too large for column
		// "CRMOWN"."CRM_MSHIP_COUPN_BAS"."DUP_USE_YN" (actual: 3, maximum: 1)
		// ????????? ??????
		EzMap data = new EzMap(vo);
		EzMap pram = new EzMap();
		pram.put("mshipCoupnBasNo", data.get("mshipCoupnBasNo"));

		CrmMshipCoupnBasVo master = service.get(pram); // newMshipCoupnBasNo
		master.setUseYn("N");
		master.setCoupnBasNm(master.getCoupnBasNm() + "_??????");
		master.setMshipCoupnBasNo(null);
		int cnt = service.insert(master);
		if (cnt == 1) {
			EzMap last = service.getCoupnInfoForLast(vo);
			String oldMshipCoupnBasNo = data.getString("mshipCoupnBasNo");
			String newMshipCoupnBasNo = last.getString("mshipCoupnBasNo");

			EzMap cpyData = new EzMap();
			cpyData.put("oldMshipCoupnBasNo", oldMshipCoupnBasNo);
			cpyData.put("newMshipCoupnBasNo", newMshipCoupnBasNo);

			// ????????????
			service.copyStor(cpyData);
			// ????????????
			service.copyGods(cpyData);
			// ????????????
			service.copyChls(cpyData);

		}

		return master;
	}

	/**
	 * 
	 * @author ?????????
	 * @date 2022. 4. 7. * @param list
	 * @return
	 * @throws Exception
	 * @description CRM????????????????????? ????????? ??????
	 *
	 */
	@PostMapping(value = { "saveList" })
	public @ResponseBody Object saveList(@RequestBody List<CrmMshipCoupnBasVo> list) throws Exception {
		return service.saveList(list);
	}

	/**
	 * 
	 * @author ?????????
	 * @date 2022. 4. 7.
	 * @param list
	 * @return
	 * @throws Exception
	 * @description CRM????????????????????? ????????? ??????
	 *
	 */
	@PostMapping(value = { "deleteList" })
	public @ResponseBody Object deleteList(@RequestBody List<CrmMshipCoupnBasVo> list) throws Exception {
		return service.deleteList(list);
	}

	/**
	 * 
	 * @author ?????????
	 * @date 2022. 4. 7.
	 * @param list
	 * @return
	 * @throws Exception
	 * @description CRM????????????????????? ????????? ??????
	 *
	 */
	@PostMapping(value = { "delete" })
	public @ResponseBody Object delete(@RequestBody CrmMshipCoupnBasVo list) throws Exception {
		EzMap map = new EzMap();
		map.put("mshipCoupnBasNo", list.getMshipCoupnBasNo());
		int cnt = serviceCpn.getListCount(map);
		int result = 0;
		if (cnt == 0) {
			result = service.delete(list);
		}

		return result;
	}

	/**
	 * 
	 * @author user
	 * @date 2022. 4. 21. * @param param
	 * @return
	 * @throws Exception
	 * @description CRM??????????????????????????? ????????????
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
	 * @author user
	 * @date 2022. 4. 21. * @param param
	 * @return
	 * @throws Exception
	 * @description CRM??????????????????????????? ????????????
	 *
	 */
	@PostMapping(value = { "getStoreTree" })
	public @ResponseBody Object getStoreTree(@RequestBody EzMap param) throws Exception {
		Object list = serviceStroeBase.getTreeList(param);
		return list;
	}

	/**
	 * 
	 * @author ?????????
	 * @date 2022. 4. 7. * @param param
	 * @return
	 * @throws Exception
	 * @description CRM????????????????????? ????????????
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
	 * @author ?????????
	 * @date 2022. 4. 7. * @param param
	 * @return
	 * @throws Exception
	 * @description CRM????????????????????? ????????????
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
	 * @author ?????????
	 * @date 2022. 4. 7. * @param param
	 * @param model
	 * @return
	 * @throws Exception
	 * @description CRM????????????????????? ???????????? ?????? ??????
	 *
	 */
	@RequestMapping(value = { "popStore" }, method = { RequestMethod.POST, RequestMethod.GET })
	public String popStore(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {

		model.addAllAttributes(param);

		// ?????? ??????
		List<CrmStorBasVo> list = (List<CrmStorBasVo>) serviceStroeBase.getTreeList(param);

		// ????????? ????????? ??????
		List<CrmStorBasVo> storeList = null;
		if (!Utilities.isEmpty(param.get("mshipCoupnBasNo")) || !Utilities.isEmpty(param.get("mshipCardBasNo"))
				|| !Utilities.isEmpty(param.get("mshipPromBasNo")) || !Utilities.isEmpty(param.get("mshipStmpBasNo"))
				|| !Utilities.isEmpty(param.get("mshipPlcyBasNo"))) {
			storeList = (List<CrmStorBasVo>) serviceStroeBase.getStoreList(param);
		}

		model.addAttribute("allStore", list);
		model.addAttribute("storeList", storeList);

		return Utilities.getProperty("tiles.crm") + "memship/popStore";
	}

	/**
	 * 
	 * @author ?????????
	 * @date 2022. 4. 7. * @param param
	 * @param model
	 * @return
	 * @throws Exception
	 * @description CRM????????????????????? ???????????? ?????? ??????
	 *
	 */
	@RequestMapping(value = { "popGods" }, method = { RequestMethod.POST, RequestMethod.GET })
	public String popGods(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {

		model.addAllAttributes(param);

		// ?????? ??????
		List<CrmMshipApplyGodsRelVo> list = serviceGodsRel.selectAllGodList(param);

		// ????????? ?????? ??????
		List<CrmMshipApplyGodsRelVo> godsList = null;

		if (!Utilities.isEmpty(param.get("mshipCoupnBasNo")) || !Utilities.isEmpty(param.get("mshipCardBasNo"))
				|| !Utilities.isEmpty(param.get("mshipPromBasNo"))) {
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
	 * @author ?????????
	 * @date 2022. 4. 7. * @param param
	 * @param model
	 * @return
	 * @throws Exception
	 * @description CRM????????????????????? ???????????? ?????? ??????
	 *
	 */

	@RequestMapping(value = { "popChl" }, method = { RequestMethod.POST, RequestMethod.GET })
	public String popChl(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAllAttributes(param);

		// ?????? ??????
		param.put("codeCd", "ST040");
		List<CrmComnCdBaseVo> list = serviceChlRel.selectAllChlList(param);

		// ????????? ??????
		List<CrmMshipApplyChlRelVo> channelList = null;

		if (!Utilities.isEmpty(param.get("mshipCoupnBasNo")) || !Utilities.isEmpty(param.get("mshipCardBasNo"))
				|| !Utilities.isEmpty(param.get("mshipPromBasNo"))) {
			channelList = serviceChlRel.selectChlList(param);
		}

		model.addAttribute("allChannel", list);
		model.addAttribute("channelList", channelList);

		return Utilities.getProperty("tiles.crm") + "memship/popChl";
	}

	/**
	 * 
	 * @author ?????????
	 * @date 2022. 4. 7. * @param list
	 * @return
	 * @throws Exception
	 * @description CRM????????????????????? ?????? ??????
	 *
	 */
	@PostMapping(value = { "saveStoreList" })
	public @ResponseBody Object saveStoreList(@RequestBody List<CrmMshipApplyStorRelVo> list) throws Exception {
		return serviceStoreRel.saveList(list);
	}

	/**
	 * 
	 * @author ?????????
	 * @date 2022. 4. 7. * @param list
	 * @return
	 * @throws Exception
	 * @description CRM????????????????????? ?????? ??????
	 *
	 */
	@PostMapping(value = { "delStoreList" })
	public @ResponseBody Object delStoreList(@RequestBody List<CrmMshipApplyStorRelVo> list) throws Exception {
		return serviceStoreRel.deleteList(list);
	}

	/**
	 * 
	 * @author ?????????
	 * @date 2022. 4. 7. * @param list
	 * @return
	 * @throws Exception
	 * @description CRM????????????????????? ?????? ??????
	 *
	 */
	@PostMapping(value = { "saveGodsList" })
	public @ResponseBody Object saveGodsList(@RequestBody List<CrmMshipApplyGodsRelVo> list) throws Exception {
		return serviceGodsRel.saveList(list);
	}

	/**
	 * 
	 * @author ?????????
	 * @date 2022. 4. 7. * @param list
	 * @return
	 * @throws Exception
	 * @description CRM????????????????????? ?????? ??????
	 *
	 */
	@PostMapping(value = { "delGodsList" })
	public @ResponseBody Object delGodsList(@RequestBody List<CrmMshipApplyGodsRelVo> list) throws Exception {
		return serviceGodsRel.deleteList(list);
	}

	/**
	 * 
	 * @author ?????????
	 * @date 2022. 4. 7. * @param list
	 * @return
	 * @throws Exception
	 * @description CRM????????????????????? ?????? ??????
	 *
	 */
	@PostMapping(value = { "saveChlList" })
	public @ResponseBody Object saveChlList(@RequestBody List<CrmMshipApplyChlRelVo> list) throws Exception {
		return serviceChlRel.saveList(list);
	}

	/**
	 * 
	 * @author ?????????
	 * @date 2022. 4. 7. * @param list
	 * @return
	 * @throws Exception
	 * @description CRM????????????????????? ?????? ??????
	 *
	 */
	@PostMapping(value = { "delChlList" })
	public @ResponseBody Object delChlList(@RequestBody List<CrmMshipApplyChlRelVo> list) throws Exception {
		return serviceChlRel.deleteList(list);
	}

	/**
	 * 
	 * @author ?????????
	 * @date 2022. 4. 7. * @param param
	 * @return
	 * @throws Exception
	 * @description CRM????????????????????? ????????????
	 *
	 */
	@PostMapping(value = { "getMemSearchList" })
	public @ResponseBody Object getMemSearchList(@RequestBody EzMap param) throws Exception {

		EzPaginationInfo page = param.getPaginationInfo();
		List<EzMap> list = service.getTargetSearchList(param);
		int count = service.getTargetSearchCount(param);
		page.setTotalRecordCount(count);

		return Utilities.getGridData(list, page);
	}

	/**
	 * 
	 * @author ?????????
	 * @date 2022. 4. 7. * @param param
	 * @return
	 * @throws Exception
	 * @description CRM????????????????????? ????????????
	 *
	 */
	@PostMapping(value = { "getMemSearchListForAll" })
	public @ResponseBody Object getMemSearchListForAll(@RequestBody EzMap param) throws Exception {

		List<EzMap> list = service.getTargetSearchListForAll(param);

		return Utilities.getGridData(list);
	}

	/**
	 * 
	 * @author ?????????
	 * @date 2022. 4. 7. * @param param
	 * @return
	 * @throws Exception
	 * @description CRM????????????????????? ????????????
	 *
	 */
	@PostMapping(value = { "getGrpSearchList" })
	public @ResponseBody Object getGrpSearchList(@RequestBody EzMap param) throws Exception {
		EzPaginationInfo page = param.getPaginationInfo();

		List<CrmCustGrpBasVo> list = serviceGrpBase.getGroupBasList(param);
		page.setTotalRecordCount(serviceGrpBase.getGroupBasListCount(param));
		return Utilities.getGridData(list, page);
	}

	/**
	 * 
	 * @author ?????????
	 * @date 2022. 4. 7. * @param param
	 * @return
	 * @throws Exception
	 * @description CRM????????????????????? ???????????? ??????
	 *
	 */
	@PostMapping(value = { "getCpnList" })
	public @ResponseBody Object getCpnList(@RequestBody EzMap param) throws Exception {
		EzPaginationInfo page = param.getPaginationInfo();
		List<CrmMshipApplyChlRelVo> list = serviceCpn.getList(param);
		page.setTotalRecordCount(serviceCpn.getListCount(param));
		return Utilities.getGridData(list, page);
	}

	/**
	 * 
	 * @author ?????????
	 * @date 2022. 4. 7. * @param param
	 * @return
	 * @throws Exception
	 * @description CRM????????????????????? ?????? ??????
	 *
	 */

	@PostMapping(value = { "pubCoupon" })
	public @ResponseBody Object pubCoupon(@RequestBody CrmMshipCoupnBasVo vo) throws Exception {

		vo.setCustNoList(null);
		vo.setCustGrpNoList(null);

		if (!vo.getCustNo().equals("")) {
			vo.setCustNoList(vo.getCustNo().split(",", -1)); // vo.setCustNoList(Arrays.asList(vo.getCustNo().split(",",
																// -1)));
		}
		if (!vo.getCustGrpNo().equals("")) {
			vo.setCustGrpNoList(vo.getCustGrpNo().split(",", -1)); // vo.setCustGrpNoList(Arrays.asList(vo.getCustGrpNo().split(",",
																	// -1)));
		}

		return service.pubCouponAll(vo);

	}

	/**
	 * 
	 * @author ?????????
	 * @date 2022. 4. 7. * @param param
	 * @param model
	 * @return
	 * @throws Exception
	 * @description CRM????????????????????? ???????????? ?????? ??????
	 *
	 */
	@RequestMapping(value = { "popStoreSearch" }, method = { RequestMethod.POST, RequestMethod.GET })
	public String popStoreSearch(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {

		model.addAllAttributes(param);

		// ?????? ??????
		List<CrmStorBasVo> list = (List<CrmStorBasVo>) serviceStroeBase.getTreeList(param);

		model.addAttribute("allStore", list);

		return Utilities.getProperty("tiles.crm") + "memship/popStoreSearch";
	}

	/**
	 * 
	 * @author ?????????
	 * @date 2022. 4. 7. * @param param
	 * @return
	 * @throws Exception
	 * @description CRM????????????????????? ?????? ??????
	 *
	 */

	@PostMapping(value = { "pubStoreCoupon" })
	public @ResponseBody Object pubStoreCoupon(@RequestBody CrmMshipCoupnBasVo vo) throws Exception {

		return service.pubStoreCoupon(vo);

	}

	/**
	 *
	 * @author ?????????
	 * @date 2022. 4. 21.
	 * @return
	 * @throws Exception
	 * @description ????????? ?????? ??????
	 *
	 */
	@PostMapping(value = { "getPartnerList" })
	public @ResponseBody List<PartnerHomeVo> getPartnerList() throws Exception {
		return servicePartner.getList(null);
	}

	/**
	 * 
	 * @author ?????????
	 * @date 2022. 4. 7. * @param param
	 * @return
	 * @throws Exception
	 * @description CRM????????????????????? ????????????
	 *
	 */
	@PostMapping(value = { "getPubCustList" })
	public @ResponseBody Object getPubCustList(@RequestBody EzMap param) throws Exception {

		List<CrmMshipCoupnPubCustVo> resultData = service.getPubCustList(param);
		EzPaginationInfo page = param.getPaginationInfo();
		int totCount = service.getPubCustListCount(param);
		page.setTotalRecordCount(totCount);
		return Utilities.getGridData(resultData, page);
	}

	/**
	 * 
	 * @author Lee Kwang
	 * @date 2022. 10. 17.
	 * @param param
	 * @param model
	 * @return
	 * @throws Exception
	 * @description ???????????? ??????
	 *
	 */
	@GetMapping(value = { "coupnIssue" })
	public String coupnIssue(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAttribute("eonUrl", eonUrl);
		model.addAttribute("eonUser", eonUser);
		return Utilities.getProperty("tiles.crm") + "memship/crmMshipCoupnIssueList";
	}

	/**
	 * 
	 * @author Lee Kwang
	 * @date 2022. 10. 17.
	 * @param param
	 * @return
	 * @throws Exception
	 * @description ???????????? ??????
	 *
	 */
	@PostMapping(value = { "searchCoupnList" })
	public @ResponseBody Object searchCoupnList(@RequestBody EzMap param) throws Exception {
		EzPaginationInfo page = param.getPaginationInfo();
		List<CrmMshipCoupnBasVo> list = service.searchCoupnList(param);
		page.setTotalRecordCount(service.searchCoupnListCount(param));
		return Utilities.getGridData(list, page);
	}

	/**
	 * 
	 * @author ?????????
	 * @date 2022. 4. 7. * @param list
	 * @return
	 * @throws Exception
	 * @description CRM????????????????????? ????????? ??????
	 *
	 */
	@PostMapping(value = { "updateCancel" })
	public @ResponseBody Object updateCancel(@RequestBody List<CrmCoupnPblsHstVo> list) throws Exception {
		return serviceCpn.updateCancel(list);
	}

	/**
	 * 
	 * @author ?????????
	 * @date 2022. 4. 7. * @param list
	 * @return
	 * @throws Exception
	 * @description CRM??????????????????
	 *
	 */
	@PostMapping(value = { "sendMsgCoupn" })
	public @ResponseBody Object sendMsgCoupn(@RequestBody EzMap param) // @RequestBody List<EzMap> list
			throws Exception {
		return service.sendMsgCoupnInfo(param);
	}

	/**
	 * 
	 * @author ?????????
	 * @date 2022. 4. 7. * @param list
	 * @return
	 * @throws Exception
	 * @description CRM????????????????????? ????????? ??????
	 *
	 */
	@PostMapping(value = { "deleteCoupon" })
	public @ResponseBody Object deleteCoupon(@RequestBody List<CrmCoupnPblsHstVo> list) throws Exception {
		return serviceCpn.deleteCoupon(list);
	}

	/**
	 * 
	 * @author Lee Kwang
	 * @date 2022. 10. 17.
	 * @param param
	 * @return
	 * @throws Exception
	 * @description ???????????? ????????????
	 *
	 */
	@PostMapping(value = { "sendMsgCoupnAll" })
	public @ResponseBody Object sendMsgCoupnAll(@RequestBody EzMap param) throws Exception {
		return service.sendMsgCoupnAll(param);
	}
}
