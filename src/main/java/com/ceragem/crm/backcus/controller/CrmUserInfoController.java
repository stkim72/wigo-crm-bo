package com.ceragem.crm.backcus.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ceragem.crm.backcus.model.CrmAsDetailVo;
import com.ceragem.crm.backcus.model.CrmCollabiDetailVo;
import com.ceragem.crm.backcus.model.CrmUserInfoDetailVo;
import com.ceragem.crm.backcus.model.CrmUserInfoVo;
import com.ceragem.crm.backcus.service.CrmUserInfoService;
import com.ceragem.crm.common.model.EzMap;
import com.ceragem.crm.common.model.EzPaginationInfo;
import com.ceragem.crm.common.util.Utilities;

import lombok.RequiredArgsConstructor;

/**
 * @author : 서동민
 * @date : 2022. 5. 23.
 * @Version : 1.0
 */

@Controller
@RequestMapping(value = { "userInfo" })
@RequiredArgsConstructor
public class CrmUserInfoController {
	private final CrmUserInfoService service;

	@GetMapping(value = { "", "index" })
	public String init() throws Exception {
		return Utilities.getProperty("tiles.crm") + "backcus/userInfo";
	}

	@PostMapping(value = { "getList" })
	public @ResponseBody Object getList(@RequestBody EzMap param) throws Exception {
		EzPaginationInfo page = param.getPaginationInfo();
		List<CrmUserInfoVo> list = service.getList(param);
		page.setTotalRecordCount(service.getListCount(param));
		return Utilities.getGridData(list, page);
	}

	@PostMapping(value = { "getListMask" })
	public @ResponseBody Object getListUnMasked(@RequestBody EzMap param) throws Exception {
		EzPaginationInfo page = param.getPaginationInfo();
		List<CrmUserInfoVo> list = service.getListMask(param);
		page.setTotalRecordCount(service.getListCount(param));
		return Utilities.getGridData(list, page);
	}

	@PostMapping(value = { "asGetList" })
	public @ResponseBody Object asGetList(@RequestBody EzMap param) throws Exception {
		EzPaginationInfo page = param.getPaginationInfo();
		List<CrmAsDetailVo> list = service.asGetList(param);
		page.setTotalRecordCount(service.getListCount(param));
		return Utilities.getGridData(list, page);
	}

	@PostMapping(value = { "asGetListMask" })
	public @ResponseBody Object asGetListMask(@RequestBody EzMap param) throws Exception {
		EzPaginationInfo page = param.getPaginationInfo();
		List<CrmAsDetailVo> list = service.asGetListMask(param);
		page.setTotalRecordCount(service.getListCount(param));
		return Utilities.getGridData(list, page);
	}

	@PostMapping(value = { "asCustGetListMask" })
	public @ResponseBody Object asCustGetListMask(@RequestBody EzMap param) throws Exception {
		EzPaginationInfo page = param.getPaginationInfo();
		List<CrmAsDetailVo> list = service.asCustGetListMask(param);
		page.setTotalRecordCount(service.getListCount(param));
		return Utilities.getGridData(list, page);
	}

	@PostMapping(value = { "asCustGetList" })
	public @ResponseBody Object asCustGetList(@RequestBody EzMap param) throws Exception {
		EzPaginationInfo page = param.getPaginationInfo();
		List<CrmAsDetailVo> list = service.asCustGetList(param);
		page.setTotalRecordCount(service.getListCount(param));
		return Utilities.getGridData(list, page);
	}

	@PostMapping(value = { "collabiGetList" })
	public @ResponseBody Object collabiGetList(@RequestBody EzMap param) throws Exception {
		EzPaginationInfo page = param.getPaginationInfo();
		List<CrmCollabiDetailVo> list = service.collabiGetList(param);
		page.setTotalRecordCount(service.getListCount(param));
		return Utilities.getGridData(list, page);
	}

	@PostMapping(value = { "collabiGetListMask" })
	public @ResponseBody Object collabiGetListMask(@RequestBody EzMap param) throws Exception {
		EzPaginationInfo page = param.getPaginationInfo();
		List<CrmCollabiDetailVo> list = service.collabiGetListMask(param);
		page.setTotalRecordCount(service.getListCount(param));
		return Utilities.getGridData(list, page);
	}

	@GetMapping(value = { "detail/{userNum}" })
	public String detail(CrmUserInfoDetailVo vo, @PathVariable("userNum") String userNum,
			@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		vo.setUserNum(userNum);
		model.addAttribute("userInfoDetail", service.get(vo));
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm.blank") + "backcus/userDetailPop";
	}

	@GetMapping(value = { "memDetail/{loginId}" })
	public String memDetail(CrmUserInfoDetailVo vo, @PathVariable("loginId") String loginId,
			@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		vo.setLoginId(loginId);
		model.addAttribute("userInfoDetail", service.get(vo));
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm.blank") + "backcus/userDetailPop";
	}

	@GetMapping(value = { "collabiDetail/{collabiSeq}" })
	public String collabiDetail(CrmCollabiDetailVo vo, @PathVariable("collabiSeq") String collabiSeq,
			@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		vo.setCollabiSeq(collabiSeq);
		model.addAttribute("collabiDetail", service.collabiGet(vo));
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm.blank") + "backcus/collabiDetailPop";
	}

	@GetMapping(value = { "asDetail/{asCaseId}" })
	public String asDetail(CrmAsDetailVo vo, @PathVariable("asCaseId") String asCaseId,
			@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		vo.setAsCaseId(asCaseId);
		model.addAttribute("asDetail", service.asGet(vo));
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm.blank") + "backcus/asDetailPop";
	}
}
