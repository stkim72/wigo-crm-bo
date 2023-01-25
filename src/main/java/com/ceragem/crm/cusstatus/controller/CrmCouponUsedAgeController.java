package com.ceragem.crm.cusstatus.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.ceragem.crm.common.util.Utilities;
import com.ceragem.crm.cusstatus.service.CrmCouponUsedAgeService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping(value = { "couponUsedAge" })
@RequiredArgsConstructor
public class CrmCouponUsedAgeController {

	@Autowired
	private final CrmCouponUsedAgeService service;

	@GetMapping(value = { "", "index" })
	public String init(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm") + "cusStatus/couponUsedAge";
	}

	@PostMapping(value = { "getList" })
	public @ResponseBody Object getList(@RequestBody EzMap param) throws Exception {
		List<EzMap> list = service.getList(param);
		EzPaginationInfo page = param.getPaginationInfo();
		page.setTotalRecordCount(service.getListCount(param));
		return Utilities.getGridData(list, page);
	}

	@PostMapping(value = { "getCoupnUsedAgeList" })
	public @ResponseBody Object getCoupnUseBuysList(@RequestBody EzMap param) throws Exception {

		List<EzMap> list = new ArrayList<EzMap>();

		List<EzMap> age10 = service.getCoupnUseAge10List(param);
		List<EzMap> age20 = service.getCoupnUseAge20List(param);
		List<EzMap> age30 = service.getCoupnUseAge30List(param);
		List<EzMap> age40 = service.getCoupnUseAge40List(param);
		List<EzMap> age50 = service.getCoupnUseAge50List(param);
		List<EzMap> age60 = service.getCoupnUseAge60List(param);
		List<EzMap> age70 = service.getCoupnUseAge70List(param);
		List<EzMap> age99 = service.getCoupnUseAge99List(param);

		for (int i = 0; i < 10; i++) {

			EzMap map = new EzMap();
			map.putAll((i < age10.size()) ? age10.get(i) : new EzMap());
			map.putAll((i < age20.size()) ? age20.get(i) : new EzMap());
			map.putAll((i < age30.size()) ? age30.get(i) : new EzMap());
			map.putAll((i < age40.size()) ? age40.get(i) : new EzMap());
			map.putAll((i < age50.size()) ? age50.get(i) : new EzMap());
			map.putAll((i < age60.size()) ? age60.get(i) : new EzMap());
			map.putAll((i < age70.size()) ? age70.get(i) : new EzMap());
			map.putAll((i < age99.size()) ? age99.get(i) : new EzMap());

			list.add(map);
		}

		return Utilities.getGridData(list);
	}

	@PostMapping(value = { "getCoupnUsedAgeTot" })
	public @ResponseBody Object getCoupnUsedAgeTot(@RequestBody EzMap param) throws Exception {

		List<EzMap> list = new ArrayList<EzMap>();

		List<EzMap> ageTot = service.getCoupnUseAgeTot(param);
		if (Utilities.isNotEmpty(ageTot)) {

			for (int i = 0; i < ageTot.size(); i++) {

				EzMap data = new EzMap();
				int tot = 0;
				EzMap map1 = ageTot.get(i);
				if (Utilities.isNotEmpty(map1)) {
					for (String strKey : map1.keySet()) {
						tot += map1.getInt(strKey);
					}
					data.putAll(map1);

					data.put("A", tot);
					list.add(data);
				}
			}
		}

		return Utilities.getGridData(list);
	}

	@PostMapping(value = { "getCoupnUsedGradeTot" })
	public @ResponseBody Object getCoupnUsedGradeTot(@RequestBody EzMap param) throws Exception {

		List<EzMap> list = new ArrayList<EzMap>();

		List<EzMap> ageGrd = service.getCoupnUseAgeGndr(param);

		if (Utilities.isNotEmpty(ageGrd)) {

			for (int i = 0; i < ageGrd.size(); i++) {

				EzMap data = new EzMap();
				int tot = 0;
				EzMap map2 = ageGrd.get(i);
				if (Utilities.isNotEmpty(map2)) {
					for (String strKey : map2.keySet()) {
						tot += map2.getInt(strKey);
					}
					data.putAll(map2);

					data.put("A", tot);
					list.add(data);
				}
			}
		}

		return Utilities.getGridData(list);
	}

}
