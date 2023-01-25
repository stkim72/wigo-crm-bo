package com.ceragem.crm.cusstatus.controller;

import java.util.List;

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
import com.ceragem.crm.cusstatus.service.CrmCusStatusService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping(value = { "memdash1" })
@RequiredArgsConstructor
public class CrmCusStatusController {
	private final CrmCusStatusService service;

	@GetMapping(value = { "", "index" })
	public String init(Model model) throws Exception {
//		model.addAttribute("pieData", service.getGradePie());
//		model.addAttribute("barData", service.getGradeBar());
		return Utilities.getProperty("tiles.crm") + "cusStatus/memdash1";
	}

	@PostMapping(value = { "getList" })
	public @ResponseBody Object getList(@RequestBody EzMap param) throws Exception {
		List<EzMap> list = service.getList(param);
		EzPaginationInfo page = param.getPaginationInfo();
		page.setTotalRecordCount(service.getListCount(param));
		return Utilities.getGridData(list, page);
	}

	@PostMapping(value = { "editPieGraph" })
	public @ResponseBody List<Integer> editPieGraph(@RequestBody CrmResponseVo param) throws Exception {
		return service.getGradePie(param);
	}

	@PostMapping(value = { "editBarGraph" })
	public @ResponseBody List<Integer> editBarGraph(@RequestBody CrmResponseVo param) throws Exception {
		return service.getGradeBar(param);
	}

	@PostMapping(value = { "lineGraphLabel" })
	public @ResponseBody List<String> lineGraphLabel(@RequestBody EzMap param) {
		return service.monthRegCntM(param);
	}

	@PostMapping(value = { "lineGraphData" })
	public @ResponseBody List<List<Integer>> lineGraphData(@RequestBody EzMap param) {
		return service.monthRegCnt(param);
	}

	@PostMapping(value = { "graphData" })
	public @ResponseBody Object graphData(@RequestBody EzMap param) {
		return service.getGraphData(param);
	}

	@GetMapping(value = { "gradeLevel" })
	public @ResponseBody List<String> gradeLevel() {
		return service.gradeLevel();
	}
}
