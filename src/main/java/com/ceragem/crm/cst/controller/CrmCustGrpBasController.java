package com.ceragem.crm.cst.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ceragem.crm.common.model.EzMap;
import com.ceragem.crm.common.model.EzPaginationInfo;
import com.ceragem.crm.common.util.SessionUtil;
import com.ceragem.crm.common.util.Utilities;
import com.ceragem.crm.cst.model.CrmCustGrpBasVo;
import com.ceragem.crm.cst.model.CrmCustGrpTargetCondVo;
import com.ceragem.crm.cst.service.CrmCustGrpBasService;
import com.ceragem.crm.sys.model.CrmLoginUserVo;

/**
 * @Author 주재민
 * @date 2022.04.07
 * @description
 * 
 * CRM 고객그룹기본 Controller
 */

//@Slf4j
@Controller
@RequestMapping(value = { "custGroup", "{menuCd}/custGroup" })
public class CrmCustGrpBasController{

	@Autowired
	CrmCustGrpBasService grpService;
	
	@Value("${spring.eon.send.url}")
	String eonUrl;
	
	@Value("${spring.eon.send.user}")
	String eonUser;
	
	@GetMapping(value = { "", "index" })
	public String home(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm.type3") + "cst/CR060";
	}
	
	@GetMapping(value = { "popGroupBasInfoUpd" })
	public String popGroupBasInfoUpd(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm.blank") + "cst/CR060_1";
	}
	
	@GetMapping(value = { "popGroupBasInfoReg" })
	public String popGroupBasInfoReg(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm.blank") + "cst/CR053";
	}
	
	@GetMapping(value = { "popGroupSearchInfo" })
	public String popGroupSearchInfo(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm.blank") + "cst/CR052";
	}
	
	@GetMapping(value = { "pageTargetExtInfo" })
	public String pageTargetExtInfo(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm.blank") + "cst/CR054";
	}
	
	@GetMapping(value = { "popTargetConfirmInfo" })
	public String popTargetConfirmInfo(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm.blank") + "cst/CR054_1";
	}
	
	@GetMapping(value = { "popTargetQueryInfo" })
	public String popTargetQueryInfo(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm.blank") + "cst/CR054_2";
	}
	
	@GetMapping(value = { "pageTargetRelInfo" })
	public String pageTargetRelInfo(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm.blank") + "cst/CR057";
	}
	
	@GetMapping(value = { "pageTargetCustInfo" })
	public String pageTargetCustInfo(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAllAttributes(param);
		model.addAttribute("eonUrl",eonUrl);
		model.addAttribute("eonUser",eonUser);
		return Utilities.getProperty("tiles.crm.blank") + "cst/CR058";
	}
	
	@GetMapping(value = { "pageTargetCustSendInfo" })
	public String pageTargetCustSendInfo(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm.blank") + "cst/CR059";
	}
	
	@GetMapping(value = { "popExprnGodsSearchInfo" })
	public String popExprnGodsSearchInfo(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm.blank") + "cst/CR054_3";
	}
	
	@GetMapping(value = { "popDealGodsSearchInfo" })
	public String popDealGodsSearchInfo(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm.blank") + "cst/CR054_4";
	}
	
	//고객그룹 기본정보 관련
	@PostMapping(value = { "getGroupBasList" })
	public @ResponseBody Object getGroupBasList(@RequestBody EzMap param) throws Exception {
		EzPaginationInfo page = param.getPaginationInfo();
		List<EzMap> list = grpService.getGroupBasList(param);
		page.setTotalRecordCount(list.size());
//		page.setTotalRecordCount(grpService.getGroupBasListCount(param));	//페이징 일단 안함 - 새로고침 이슈로인해
		return Utilities.getGridData(list,page);
	}
	
	@PostMapping(value = { "getGroupBasInfo" })
	public @ResponseBody Object getGroupBasInfo(@RequestBody EzMap param) throws Exception {
		CrmCustGrpBasVo info = grpService.getGroupBasInfo(param);
		return info;
	}
	
	@PostMapping(value = { "addGroupBasInfo" })
	public @ResponseBody Object addGroupBasInfo(@RequestBody CrmCustGrpBasVo vo) throws Exception {
		vo.setStat("C");
		return grpService.setSaveGroupBasInfo(vo); 
	}
	
	@PostMapping(value = { "updGroupBasInfo" })
	public @ResponseBody Object updGroupBasInfo(@RequestBody CrmCustGrpBasVo vo) throws Exception {
		vo.setStat("U");
		return grpService.setSaveGroupBasInfo(vo);
	}
	
	@PostMapping(value = { "delGroupBasInfoList" })
	public @ResponseBody Object delGroupBasInfoList(@RequestBody List<CrmCustGrpBasVo> list) throws Exception {
		return grpService.deleteGroupBasInfoList(list);
	}
	
	@PostMapping(value = { "saveGroupBasInfoList" })
	public @ResponseBody Object saveGroupBasInfoList(@RequestBody List<CrmCustGrpBasVo> list) throws Exception {
		return grpService.saveGroupBasInfoList(list);
	}
	//고객그룹 기본정보 관련
	
	//대상 조건정보 관련
	@PostMapping(value = { "getTargetCondInfo" })
	public @ResponseBody Object getTargetCondInfo(@RequestBody EzMap param) throws Exception {
		CrmCustGrpTargetCondVo info = new CrmCustGrpTargetCondVo();
		info.setCustMasterCond(grpService.getMstrCondInfo(param));
		info.setCnttHstCond(grpService.getCnttHstCondInfo(param));
		info.setDealHstCond(grpService.getDealHstCondInfo(param));
		
		return info;
	}
	
	@PostMapping(value = { "updTargetCondInfo" })
	public @ResponseBody Object updTargetCondInfo(@RequestBody CrmCustGrpTargetCondVo vo) throws Exception {
		return grpService.updateTargetCondInfo(vo);
	}
	
	@PostMapping(value = { "getExprnGodsSearchList" })
	public @ResponseBody Object getExprnGodsSearchList(@RequestBody EzMap param) throws Exception {
		EzPaginationInfo page = param.getPaginationInfo();
		List<EzMap> list = grpService.getExprnGodsSearchList(param);
		page.setTotalRecordCount(grpService.getExprnGodsSearchListCount(param));
		return Utilities.getGridData(list,page);
	}
	
	@PostMapping(value = { "addDealGodsInfoList" })
	public @ResponseBody Object addDealGodsInfoList(@RequestBody EzMap param) throws Exception {
		return grpService.insertDealGodsInfoList(param);
	}
	
	@PostMapping(value = { "delDealGodsInfoList" })
	public @ResponseBody Object delDealGodsInfoList(@RequestBody List<EzMap> param) throws Exception {
		return grpService.deleteDealGodsInfoList(param);
	}
	
	@PostMapping(value = { "getDealGodsSearchList" })
	public @ResponseBody Object getDealGodsSearchList(@RequestBody EzMap param) throws Exception {
		EzPaginationInfo page = param.getPaginationInfo();
		List<EzMap> list = grpService.getDealGodsSearchList(param);
		page.setTotalRecordCount(grpService.getDealGodsSearchListCount(param));
		return Utilities.getGridData(list,page);
	}
	//대상 조건정보 관련
	
	//대상 고객추출 관련	
	@PostMapping(value = { "getTargetSearchList" })	//현재 입력된 고객그룹조건을 전송해 대상고객을 검색한다.
	public @ResponseBody Object getTargetSearchList(@RequestBody CrmCustGrpTargetCondVo vo) throws Exception {
		EzPaginationInfo page = new EzPaginationInfo();
		List<EzMap> list = grpService.getTargetSearchList(vo);
		page.setTotalRecordCount(list.size());
		
		return Utilities.getGridData(list,page);
	}
	
	@PostMapping(value = { "getTargetSearchPagingList" })	//현재 입력된 고객그룹조건을 전송해 대상고객을 검색한다.(페이징처리)
	public @ResponseBody Object getTargetSearchPagingList(@RequestBody CrmCustGrpTargetCondVo vo) throws Exception {
		List<EzMap> list = grpService.getTargetSearchPagingList(vo);
		vo.setTotalCount(grpService.getTargetSearchPagingListCount(vo));
		
		EzMap pageMap = new EzMap();
		pageMap.setInt("page", vo.getPage());
		pageMap.setInt("totalCount", vo.getTotalCount());
		pageMap.setInt("perPage", vo.getPerPage());
		
		return Utilities.getVoGridData(list,pageMap);
	}
	
	@PostMapping(value = { "getTargetQuery" })	//현재 입력된 고객그룹조건을 전송해 대상고객 검색쿼리를 추출한다.
	public @ResponseBody Object getTargetQuery(@RequestBody CrmCustGrpTargetCondVo vo) throws Exception {
		CrmCustGrpBasVo rtnVal = grpService.getTargetQuery(vo);
		return rtnVal;
	}
	
	@PostMapping(value = { "getTargetWithQuery" })	//직접입력한 쿼리를 전송해 대상고객을 검색한다.
	public @ResponseBody Object getTargetWithQuery(@RequestBody EzMap param) throws Exception {
		EzPaginationInfo page = param.getPaginationInfo();
		List<EzMap> list = grpService.getTargetWithQuery(param);
		page.setTotalRecordCount(grpService.getTargetWithQueryCount(param));
		
		return Utilities.getGridData(list,page);
	}
	
	@PostMapping(value = { "saveTargetQuery" })
	public @ResponseBody Object saveTargetQuery(@RequestBody EzMap param) throws Exception {
		CrmLoginUserVo user = SessionUtil.getLoginUser();
		param.put("amdrId", user.getAmdrId());
		return grpService.saveTargetQuery(param);
	}
	//대상 고객추출 관련
	
	//대상 고객선정 관련
	@PostMapping(value = { "getTargetRelList" })
	public @ResponseBody Object getTargetRelList(@RequestBody EzMap param) throws Exception {
		EzPaginationInfo page = param.getPaginationInfo();
		List<EzMap> list = grpService.getTargetRelList(param);
		page.setTotalRecordCount(grpService.getTargetRelListCount(param));
		return Utilities.getGridData(list,page);
	}
	
	@PostMapping(value = { "delTargetRelList" })
	public @ResponseBody Object delTargetRelList(@RequestBody EzMap param) throws Exception {
		return grpService.deleteTargetRelList(param);
	}
	
	@PostMapping(value = { "updTargetSearchCustNo" })
	public @ResponseBody Object updTargetSearchCustNo(@RequestBody EzMap param) throws Exception {
		return grpService.updateTargetSearchCustNo(param);
	}
	
	@PostMapping(value = { "updTargetRelList" })
	public @ResponseBody Object updTargetRelList(@RequestBody EzMap param) throws Exception {
		return grpService.updateTargetRelList(param);
	}
	
	@PostMapping(value = { "saveTargetRelList1" })
	public @ResponseBody Object saveTargetRelList1(@RequestBody EzMap param) throws Exception {
		return grpService.saveTargetRelList1(param);
	}
	
	@PostMapping(value = { "saveTargetRelList2" })
	public @ResponseBody Object saveTargetRelList2(@RequestBody EzMap param) throws Exception {
		return grpService.saveTargetRelList2(param);
	}
	
	@PostMapping(value = { "saveTargetRelInpQuery" })
	public @ResponseBody Object saveTargetRelInpQuery(@RequestBody EzMap param) throws Exception {
		return grpService.saveTargetRelInpQuery(param);
	}
	
	@PostMapping(value = { "saveTargetCondNRelList" })
	public @ResponseBody Object saveTargetCondNRelList(@RequestBody CrmCustGrpTargetCondVo vo) throws Exception {
		return grpService.saveTargetCondNRelList(vo);
	}
	//대상 고객선정 관련
	
	//대상 고객검색 관련
	@PostMapping(value = { "getTargetCustList" })
	public @ResponseBody Object getTargetCustList(@RequestBody EzMap param) throws Exception {
		EzPaginationInfo page = param.getPaginationInfo();
		List<EzMap> list = grpService.getTargetCustList(param);
		page.setTotalRecordCount(grpService.getTargetCustListCount(param));
		
		return Utilities.getGridData(list,page);
	}
	
	@PostMapping(value = { "getTargetCustGradeList" })
	public @ResponseBody Object getTargetCustGradeList(@RequestBody EzMap param) throws Exception {
		List<EzMap> list = grpService.getTargetCustGradeList(param);
		
		return list;
	}
	//대상 고객검색 관련
	
	//대상 고객발송 관련
	@PostMapping(value = { "saveTargetSendGroupInfo" })
	public @ResponseBody Object saveTargetSendGroupInfo(@RequestBody EzMap param) throws Exception {
		return grpService.saveTargetSendGroupInfo(param);
	}
	
	@PostMapping(value = { "saveTotalTargetSendGroupInfo" })
	public @ResponseBody Object saveTotalTargetSendGroupInfo(@RequestBody EzMap param) throws Exception {
		return grpService.saveTotalTargetSendGroupInfo(param);
	}
	
	@PostMapping(value = { "saveTargetSendInfo" })
	public @ResponseBody Object saveTargetSendInfo(@RequestBody EzMap param) throws Exception {
		return grpService.saveTargetSendInfo(param);
	}
	
	@PostMapping(value = { "saveTotalTargetSendInfo" })
	public @ResponseBody Object saveTotalTargetSendInfo(@RequestBody EzMap param) throws Exception {
		return grpService.saveTotalTargetSendInfo(param);
	}
	
	@PostMapping(value = { "getTargetCustSendList" })
	public @ResponseBody Object getTargetCustSendList(@RequestBody EzMap param) throws Exception {
		EzPaginationInfo page = param.getPaginationInfo();
		List<EzMap> list = grpService.getTargetCustSendList(param);
		page.setTotalRecordCount(grpService.getTargetCustSendListCount(param));
		
		return Utilities.getGridData(list,page);
	}
	//대상 고객발송 관련
}
