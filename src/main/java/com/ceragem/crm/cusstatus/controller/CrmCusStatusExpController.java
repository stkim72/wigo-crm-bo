package com.ceragem.crm.cusstatus.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ceragem.crm.common.model.EzMap;
import com.ceragem.crm.common.model.EzPaginationInfo;
import com.ceragem.crm.common.util.Utilities;
import com.ceragem.crm.cusstatus.model.CrmResponseVo;
import com.ceragem.crm.cusstatus.service.CrmCusStatusExpService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping(value = { "memdash2" })
@RequiredArgsConstructor
public class CrmCusStatusExpController {
	private final CrmCusStatusExpService service;

	@GetMapping(value = { "", "index" })
	public String init(Model model) throws Exception {

		model.addAttribute("pieDataExp", service.getExpPie()); // 초기 그래프 정보
		model.addAttribute("pieDataExpGen", service.getExpGenPie());
		model.addAttribute("pieDataExpGra", service.getExpGra());
		model.addAttribute("barExpAgeData", service.getExpAgeBar());
		model.addAttribute("barExpDayData", service.getExpDayBar());

		return Utilities.getProperty("tiles.crm") + "cusStatus/memdash2";
	}

	@PostMapping(value = { "getList" })
	public @ResponseBody Object getList(@RequestBody EzMap param) throws Exception {

		List<EzMap> list = service.getList(param);
		EzPaginationInfo page = param.getPaginationInfo();
		page.setTotalRecordCount(service.getListCount(param));
		return Utilities.getGridData(list, page);
	}

	@PostMapping(value = { "getGraphData" })
	public @ResponseBody Object getGraphData(@RequestBody EzMap param) throws Exception {
		Map<String, Object> pie = new HashMap<String, Object>();
		pie.put("memberType", service.getMemberTypeList(param));
		pie.put("gender", service.getGenderList(param));
		pie.put("grade", service.getMemberGradeList(param));
		pie.put("number", service.getNumberList(param));
		Map<String, Object> bar = new HashMap<String, Object>();
		bar.put("age", service.getAgeList(param));
		bar.put("week", service.getWeekList(param));
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("pie", pie);
		map.put("bar", bar);
		return map;

	}

	// 수정된 그래프 정보
	@PostMapping(value = { "editGetExpPie" })
	public @ResponseBody Object editGetExpPie(@RequestBody CrmResponseVo param) throws Exception {
		return service.getExpPie(param);
	}

	@PostMapping(value = { "editGetExpGenPie" })
	public @ResponseBody Object editGetExpGenPie(@RequestBody CrmResponseVo param) throws Exception {
		return service.getExpGenPie(param);
	}

	@PostMapping(value = { "editGetExpGra" })
	public @ResponseBody Object editGetExpGra(@RequestBody CrmResponseVo param) throws Exception {
		return service.getExpGra(param);
	}

	@PostMapping(value = { "editGetExpAgeBar" })
	public @ResponseBody Object editGetExpAgeBar(@RequestBody CrmResponseVo param) throws Exception {
		return service.getExpAgeBar(param);
	}

	@PostMapping(value = { "editGetExpDayBar" })
	public @ResponseBody Object editGetExpDayBar(@RequestBody CrmResponseVo param) throws Exception {
		return service.getExpDayBar(param);
	}

}
