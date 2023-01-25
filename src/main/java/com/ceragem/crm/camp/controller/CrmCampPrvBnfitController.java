package com.ceragem.crm.camp.controller;

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

import com.ceragem.crm.camp.model.CrmCampBasVo;
import com.ceragem.crm.camp.service.CrmCampBasService;
import com.ceragem.crm.common.model.EzMap;
import com.ceragem.crm.common.model.EzPaginationInfo;
import com.ceragem.crm.common.util.Utilities;

/**
 * 
 * @ClassName    CrmCampBasController
 * @author    user
 * @date    2022. 5. 2.
 * @Version    1.0
 * @description    CRM캠페인기본 Controller
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */

@Controller
@RequestMapping(value = { "crmCampPrvBnfit", "{menuCd}/crmCampPrvBnfit" })
public class CrmCampPrvBnfitController{

	@Autowired
	CrmCampBasService service;

	/**
	 * 
	 * @author user
	 * @date 2022. 5. 2. * @param param
	 * @param model
	 * @return
	 * @throws Exception
	 * @description CRM캠페인기본 목록페이지
	 *
	 */
	@GetMapping(value = { "", "index" })
	public String init(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm") + "camp/crmCampPrvBnfit";
	}

	/**
	 * 
	 * @author user
	 * @date 2022. 5. 2. * @param param
	 * @return
	 * @throws Exception
	 * @description CRM캠페인기본 목록검색
	 *
	 */
	@PostMapping(value = { "getList" })
	public @ResponseBody Object getList(@RequestBody EzMap param) throws Exception {
		EzPaginationInfo page = param.getPaginationInfo();
		List<CrmCampBasVo> list = service.getList(param);
		page.setTotalRecordCount(service.getListCount(param));
		return Utilities.getGridData(list,page);
	}

	/**
	 * 
	 * @author user
	 * @date 2022. 5. 2. * @param rparam
	 * @return
	 * @throws Exception
	 * @description CRM캠페인기본 1건검색
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
	 * @date 2022. 5. 2. * @param vo
	 * @return
	 * @throws Exception
	 * @description CRM캠페인기본 저장
	 * */
	@PostMapping(value = {"save" })
	public @ResponseBody Object save(@RequestBody CrmCampBasVo vo) throws Exception {
		return service.save(vo);
	}

	/**
	 * 
	 * @author user
	 * @date 2022. 5. 2. * @param vo
	 * @return
	 * @throws Exception
	 * @description CRM캠페인기본 신규생성
	 */
	@GetMapping(value = { "add" })
	public String add(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {


		model.addAttribute("addMode", "C" ); 		 

		// 멤버십쿠폰기본번호가 넘어올 경우 
		if( !param.get("campBasNo").equals("") ) {
			model.addAttribute("cpinfo", param ); 
			model.addAttribute("addMode", "U" ); 
		}

		//		param.put("codeCd", "MB020");
		//		List<CrmComnCdBaseVo> list = codeService.getComboCode(param);
		//		model.addAttribute("memknd", list);
		return Utilities.getProperty("tiles.crm") + "camp/crmCampBasDetail";
	}



	/**
	 * 
	 * @author user
	 * @date 2022. 5. 2. * @param list
	 * @return
	 * @throws Exception
	 * @description CRM캠페인기본 리스트 저장
	 *
	 */
	@PostMapping(value = { "saveList" })
	public @ResponseBody Object saveList(@RequestBody List<CrmCampBasVo> list) throws Exception {
		return service.saveList(list);
	}
	/**
	 * 
	 * @author user
	 * @date 2022. 5. 2.
	 * @param list
	 * @return
	 * @throws Exception
	 * @description CRM캠페인기본 리스트 삭제
	 *
	 */
	@PostMapping(value = { "deleteList" })
	public @ResponseBody Object deleteList(@RequestBody List<CrmCampBasVo> list) throws Exception {
		return service.deleteList(list);
	}


	 /**
	  * 
	  * @author user
	  * @date 2022. 5. 2. * @param vo
	  * @return
	  * @throws Exception
	  * @description CRM캠페인 대상군 추가
	*/
	@GetMapping(value = { "popTarget" })
	public String popTarget(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {


		model.addAttribute("addMode", "C" ); 		 

		// 멤버십쿠폰기본번호가 넘어올 경우 
//		if( !param.get("campBasNo").equals("") ) {
//			model.addAttribute("cpinfo", param ); 
//			model.addAttribute("addMode", "U" ); 
//		}

		return Utilities.getProperty("tiles.crm") + "camp/popTarget";
	}
	
	
}
