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
import com.ceragem.crm.cusstatus.service.CrmCusStatusAccService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping(value = { "memdash3" })
@RequiredArgsConstructor
public class CrmCusStatusAccController {
	private final CrmCusStatusAccService service;

	@GetMapping(value = { "", "index"})
	public String init(Model model) throws Exception {
		model.addAttribute("barLabels", service.barLabels());
		model.addAttribute("normalData", service.normalData());
		model.addAttribute("dormarcyData", service.dormarcyData());
		model.addAttribute("lineLabels", service.lineLabels());
		model.addAttribute("lineNormal", service.lineNormal());
		model.addAttribute("lineDormarcy", service.lineDormarcy());
		return Utilities.getProperty("tiles.crm") + "cusStatus/memdash3";
	}

	@PostMapping(value = { "getList" })
	public @ResponseBody Object getList(@RequestBody EzMap param) throws Exception {
		List<EzMap> list = service.getList(param);
		EzPaginationInfo page = param.getPaginationInfo();
		page.setTotalRecordCount(service.getListCount(param));
		return Utilities.getGridData(list,page);
	}
	
	@PostMapping(value = { "editBarGraph" })
	public @ResponseBody Object editBarGraph(@RequestBody CrmResponseVo param) throws Exception {
		return service.editBarGraph(param);
	}
	
	@PostMapping(value = { "editLineGraph" })
	public @ResponseBody Object editLineGraph(@RequestBody CrmResponseVo param) throws Exception {
		return service.editLineGraph(param);
	}
}
