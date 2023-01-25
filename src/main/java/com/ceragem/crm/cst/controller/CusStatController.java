package com.ceragem.crm.cst.controller;

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
import com.ceragem.crm.cst.model.CusStatVo;
import com.ceragem.crm.cst.service.CusStatService;
import com.ceragem.crm.cusstatus.service.CrmCusStatusExpService;

/**
 * 
 * @ClassName CusStatController
 * @author user
 * @date 2022. 7. 18.
 * @Version 1.0
 * @description CRM고객기본 Controller
 * @Company Copyright ⓒ wigo.ai. All Right Reserved
 */

@Controller
@RequestMapping(value = { "cusStat", "{menuCd}/cusStat" })
public class CusStatController {

	@Autowired
	CusStatService service;

	@Autowired
	CrmCusStatusExpService expService;

	/**
	 * 
	 * @author user
	 * @date 2022. 7. 18. * @param param
	 * @param model
	 * @return
	 * @throws Exception
	 * @description CRM고객기본 목록페이지
	 *
	 */
	@GetMapping(value = { "", "index" })
	public String init(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm") + "cst/memberStat";
	}

	/**
	 *
	 * @author 황재희
	 * @date 2022. 7. 18.
	 * @return
	 * @throws Exception
	 * @description 멤버십 회원통계 성별분포 그리드 조회
	 *
	 */
	@PostMapping(value = { "getMemberStat1List" })
	public @ResponseBody Object getMemberStat1List(@RequestBody EzMap param) throws Exception {
		List<CusStatVo> list = service.getMemberStat1List(param);
		return Utilities.getGridData(list);
	}

	/**
	 *
	 * @author 황재희
	 * @date 2022. 7. 19.
	 * @return
	 * @throws Exception
	 * @description 멤버십 회원통계 연령분포 그리드 조회
	 *
	 */
	@PostMapping(value = { "getMemberStat2List" })
	public @ResponseBody Object getMemberStat2List(@RequestBody EzMap param) throws Exception {
		List<CusStatVo> list = service.getMemberStat2List(param);
		return Utilities.getGridData(list);
	}

	/**
	 *
	 * @author 황재희
	 * @date 2022. 7. 19.
	 * @return
	 * @throws Exception
	 * @description 멤버십 회원통계 신규회원 그리드 조회
	 *
	 */
	@PostMapping(value = { "getMemberStat3List" })
	public @ResponseBody Object getMemberStat3List(@RequestBody EzMap param) throws Exception {
		List<CusStatVo> list = service.getMemberStat3List(param);
		return Utilities.getGridData(list);
	}

	/**
	 * 
	 * @author 황재희
	 * @date 2022. 8. 31. * @param param
	 * @param model
	 * @return
	 * @throws Exception
	 * @description 추천 통계 페이지
	 *
	 */
	@GetMapping(value = { "Reccom" })
	public String Reccom(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm") + "cst/CR216";
	}

	/**
	 *
	 * @author 황재희
	 * @date 2022. 8. 30.
	 * @return
	 * @throws Exception
	 * @description 추천 통계 성별분포 그리드 조회
	 *
	 */
	@PostMapping(value = { "getRecommendStat1List" })
	public @ResponseBody Object getRecommendStat1List(@RequestBody EzMap param) throws Exception {
		List<CusStatVo> list = service.getRecommendStat1List(param);
		return Utilities.getGridData(list);
	}

	/**
	 *
	 * @author 황재희
	 * @date 2022. 8. 30.
	 * @return
	 * @throws Exception
	 * @description 추천 통계 연령분포 그리드 조회
	 *
	 */
	@PostMapping(value = { "getRecommendStat2List" })
	public @ResponseBody Object getRecommendStat2List(@RequestBody EzMap param) throws Exception {
		List<CusStatVo> list = service.getRecommendStat2List(param);
		return Utilities.getGridData(list);
	}

	/**
	 *
	 * @author 황재희
	 * @date 2022. 8. 30.
	 * @return
	 * @throws Exception
	 * @description 추천 통계 일별회원추천 그리드 조회
	 *
	 */
	@PostMapping(value = { "getRecommendStat3List" })
	public @ResponseBody Object getRecommendStat3List(@RequestBody EzMap param) throws Exception {
		List<CusStatVo> list = service.getRecommendStat3List(param);
		return Utilities.getGridData(list);
	}

	/**
	 *
	 * @author 황재희
	 * @date 2022. 8. 30.
	 * @return
	 * @throws Exception
	 * @description 추천 통계 체험추천Top10 그리드 조회
	 *
	 */
	@PostMapping(value = { "getRecommendStat4List" })
	public @ResponseBody Object getRecommendStat4List(@RequestBody EzMap param) throws Exception {
		List<CusStatVo> list = service.getRecommendStat4List(param);
		return Utilities.getGridData(list);
	}

	/**
	 *
	 * @author 황재희
	 * @date 2022. 8. 30.
	 * @return
	 * @throws Exception
	 * @description 추천 통계 구매추천Top10 그리드 조회
	 *
	 */
	@PostMapping(value = { "getRecommendStat5List" })
	public @ResponseBody Object getRecommendStat5List(@RequestBody EzMap param) throws Exception {
		List<CusStatVo> list = service.getRecommendStat5List(param);
		return Utilities.getGridData(list);
	}

	/**
	 *
	 * @author 황재희
	 * @date 2022. 8. 30.
	 * @return
	 * @throws Exception
	 * @description 추천 통계 가입추천Top10 그리드 조회
	 *
	 */
	@PostMapping(value = { "getRecommendStat6List" })
	public @ResponseBody Object getRecommendStat6List(@RequestBody EzMap param) throws Exception {
		List<CusStatVo> list = service.getRecommendStat6List(param);
		return Utilities.getGridData(list);
	}

	/**
	 * 
	 * @author user
	 * @date 2022. 7. 18. * @param param
	 * @param model
	 * @return
	 * @throws Exception
	 * @description 활동 회원통계 목록페이지
	 *
	 */
	@GetMapping(value = { "activeStat" })
	public String activeStat(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {

		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm") + "cst/activeStat";
	}

	/**
	 *
	 * @author 황의겸
	 * @date 2022. 7. 19.
	 * @return
	 * @throws Exception
	 * @description 활동 회원통계 성별 그리드 조회
	 *
	 */
	@PostMapping(value = { "getActiveStat1List" })
	public @ResponseBody Object getActiveStat1List(@RequestBody EzMap param) throws Exception {
		List<CusStatVo> list = service.getActiveStat1List(param);
		return Utilities.getGridData(list);
	}

	/**
	 *
	 * @author 황의겸
	 * @date 2022. 7. 19.
	 * @return
	 * @throws Exception
	 * @description 활동 회원통계 연령 그리드 조회
	 *
	 */
	@PostMapping(value = { "getActiveStat2List" })
	public @ResponseBody Object getActiveStat2List(@RequestBody EzMap param) throws Exception {
		List<CusStatVo> list = service.getActiveStat2List(param);
		return Utilities.getGridData(list);
	}

	/**
	 *
	 * @author 황의겸
	 * @date 2022. 7. 19.
	 * @return
	 * @throws Exception
	 * @description 활동 회원통계 등급 그리드 조회
	 *
	 */
	@PostMapping(value = { "getActiveStat3List" })
	public @ResponseBody Object getActiveStat3List(@RequestBody EzMap param) throws Exception {
		List<CusStatVo> list = service.getActiveStat3List(param);
		return Utilities.getGridData(list);
	}

	/**
	 * 
	 * @author user
	 * @date 2022. 7. 18. * @param param
	 * @param model
	 * @return
	 * @throws Exception
	 * @description 세라체크 측정 고객 통계 목록페이지
	 *
	 */
	@GetMapping(value = { "ceraCkStat" })
	public String ceraCkStat(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {

		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm") + "cst/ceraCkStat";
	}

	/**
	 *
	 * @author 황의겸
	 * @date 2022. 7. 19.
	 * @return
	 * @throws Exception
	 * @description 세라체크 측정 고객 통계 성별 그리드 조회
	 *
	 */
	@PostMapping(value = { "getCeraCkStat1List" })
	public @ResponseBody Object getCeraCkStat1List(@RequestBody EzMap param) throws Exception {
		List<CusStatVo> list = service.getCeraCkStat1List(param);
		return Utilities.getGridData(list);
	}

	/**
	 *
	 * @author 황의겸
	 * @date 2022. 7. 19.
	 * @return
	 * @throws Exception
	 * @description 세라체크 측정 고객 통계 연령 그리드 조회
	 *
	 */
	@PostMapping(value = { "getCeraCkStat2List" })
	public @ResponseBody Object getCeraCkStat2List(@RequestBody EzMap param) throws Exception {
		List<CusStatVo> list = service.getCeraCkStat2List(param);
		return Utilities.getGridData(list);
	}

	/**
	 *
	 * @author 황의겸
	 * @date 2022. 7. 19.
	 * @return
	 * @throws Exception
	 * @description 세라체크 측정 고객 통계 일별측정회원 그리드 조회
	 *
	 */
	@PostMapping(value = { "getCeraCkStat3List" })
	public @ResponseBody Object getCeraCkStat3List(@RequestBody EzMap param) throws Exception {
		List<CusStatVo> list = service.getCeraCkStat3List(param);
		return Utilities.getGridData(list);
	}

	/**
	 * 
	 * @author user
	 * @date 2022. 7. 18. * @param param
	 * @param model
	 * @return
	 * @throws Exception
	 * @description 등급별 회원통계 목록페이지
	 *
	 */
	@GetMapping(value = { "gradeStat" })
	public String gradeStat(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {

		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm") + "cst/gradeStat";
	}

	/**
	 *
	 * @author 황의겸
	 * @date 2022. 7. 19.
	 * @return
	 * @throws Exception
	 * @description 등급별 회원통계 그리드 조회
	 *
	 */
	@PostMapping(value = { "getGradeStat1List" })
	public @ResponseBody Object getGradeStat1List(@RequestBody EzMap param) throws Exception {
		List<CusStatVo> list = service.getGradeStat1List(param);
		return Utilities.getGridData(list);
	}

	/**
	 * 
	 * @author user
	 * @date 2022. 7. 18. * @param param
	 * @return
	 * @throws Exception
	 * @description CRM고객기본 목록검색
	 *
	 */
	@PostMapping(value = { "getList" })
	public @ResponseBody Object getList(@RequestBody EzMap param) throws Exception {
		EzPaginationInfo page = param.getPaginationInfo();
		List<CusStatVo> list = service.getList(param);
		page.setTotalRecordCount(service.getListCount(param));
		return Utilities.getGridData(list, page);
	}

	/**
	 * 
	 * @author user
	 * @date 2022. 7. 18. * @param rparam
	 * @return
	 * @throws Exception
	 * @description CRM고객기본 1건검색
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
	 * @date 2022. 7. 18. * @param vo
	 * @return
	 * @throws Exception
	 * @description CRM고객기본 저장
	 */
	@PostMapping(value = { "save" })
	public @ResponseBody Object save(@RequestBody CusStatVo vo) throws Exception {
		return service.save(vo);
	}

	/**
	 * 
	 * @author user
	 * @date 2022. 7. 18. * @param list
	 * @return
	 * @throws Exception
	 * @description CRM고객기본 리스트 저장
	 *
	 */
	@PostMapping(value = { "saveList" })
	public @ResponseBody Object saveList(@RequestBody List<CusStatVo> list) throws Exception {
		return service.saveList(list);
	}

	/**
	 * 
	 * @author user
	 * @date 2022. 7. 18.
	 * @param list
	 * @return
	 * @throws Exception
	 * @description CRM고객기본 리스트 삭제
	 *
	 */
	@PostMapping(value = { "deleteList" })
	public @ResponseBody Object deleteList(@RequestBody List<CusStatVo> list) throws Exception {
		return service.deleteList(list);
	}

	/**
	 * @Author 주재민
	 * @date 2022.08.31
	 * @param param
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value = { "iotUseStats" })
	public String iotUseStats(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		// IOT사용 통계 페이지
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm") + "cst/CR217";
	}

	@GetMapping(value = { "iotUseAgeStats" })
	public String iotUseAgeStats(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm") + "cst/CR217_1";
	}

	@GetMapping(value = { "iotUseGndrStats" })
	public String iotUseGndrStats(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm") + "cst/CR217_2";
	}

	@GetMapping(value = { "iotUseGradeStats" })
	public String iotUseGradeStats(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm") + "cst/CR217_3";
	}

	/**
	 * @Author 주재민
	 * @date 2022.08.30
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = { "getIotUseAgeStats" })
	public @ResponseBody Object getIotUseAgeStats(@RequestBody EzMap param) throws Exception {
		// IOT사용 통계 연령분포 조회
		EzPaginationInfo page = new EzPaginationInfo();
		List<EzMap> list = service.getIotUseAgeStats(param);
		page.setTotalRecordCount(list.size());
		return Utilities.getGridData(list, page);
	}

	/**
	 * @Author 주재민
	 * @date 2022.08.30
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = { "getIotUseAgeModeStats" })
	public @ResponseBody Object getIotUseAgeModeStats(@RequestBody EzMap param) throws Exception {
		// IOT사용 통계 연령별 모드사용 조회
		EzPaginationInfo page = new EzPaginationInfo();
		List<EzMap> list = service.getIotUseAgeModeStats(param);
		page.setTotalRecordCount(list.size());
		return Utilities.getGridData(list, page);
	}

	/**
	 * @Author 주재민
	 * @date 2022.08.30
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = { "getIotUseGndrStats" })
	public @ResponseBody Object getIotUseGndrStats(@RequestBody EzMap param) throws Exception {
		// IOT사용 통계 성별분포 조회
		EzPaginationInfo page = new EzPaginationInfo();
		List<EzMap> list = service.getIotUseGndrStats(param);
		page.setTotalRecordCount(list.size());
		return Utilities.getGridData(list, page);
	}

	/**
	 * @Author 주재민
	 * @date 2022.08.30
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = { "getIotUseGndrModeStats" })
	public @ResponseBody Object getIotUseGndrModeStats(@RequestBody EzMap param) throws Exception {
		// IOT사용 통계 성별 모드사용 조회
		EzPaginationInfo page = new EzPaginationInfo();
		List<EzMap> list = service.getIotUseGndrModeStats(param);
		page.setTotalRecordCount(list.size());
		return Utilities.getGridData(list, page);
	}

	/**
	 * @Author 주재민
	 * @date 2022.08.30
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = { "getIotUseGradeStats" })
	public @ResponseBody Object getIotUseGradeStats(@RequestBody EzMap param) throws Exception {
		// IOT사용 통계 등급별분포 조회
		EzPaginationInfo page = new EzPaginationInfo();
		List<EzMap> list = service.getIotUseGradeStats(param);
		page.setTotalRecordCount(list.size());
		return Utilities.getGridData(list, page);
	}

	/**
	 * 
	 * @author 황재희
	 * @date 2022. 9. 7. * @param param
	 * @param model
	 * @return
	 * @throws Exception
	 * @description 체험 통계 페이지
	 *
	 */
	@GetMapping(value = { "exprn" })
	public String exprn(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm") + "cst/CR219";
	}

	/**
	 *
	 * @author 황재희
	 * @date 2022. 9. 7.
	 * @return
	 * @throws Exception
	 * @description 체험통계 그리드 조회
	 *
	 */
	@PostMapping(value = { "getExperienceStatList" })
	public @ResponseBody Object getExperienceStatList(@RequestBody EzMap param) throws Exception {
		List<EzMap> list = expService.getList(param);
		EzPaginationInfo page = param.getPaginationInfo();
		int cnt = expService.getListCount(param);
		page.setTotalRecordCount(cnt);
		return Utilities.getGridData(list, page);
	}
}
