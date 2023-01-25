package com.ceragem.crm.camp.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import com.ceragem.crm.common.util.Utilities;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ceragem.crm.common.model.EzMap;
import com.ceragem.crm.common.model.EzPaginationInfo;
import com.ceragem.crm.camp.model.CrmCampDspBasVo;
import com.ceragem.crm.camp.model.CrmCampTempltBasVo;
import com.ceragem.crm.camp.service.CrmCampBasService;
import com.ceragem.crm.camp.service.CrmCampDspBasService;
import com.ceragem.crm.camp.service.CrmCampTempltBasService;

/**
 * 
 * @ClassName    CrmCampTempltBasController
 * @author    user
 * @date    2022. 6. 9.
 * @Version    1.0
 * @description    캠페인템플릿기본 Controller
 * @Company    Copyright ⓒ wigo.ai. All Right Reserved
 */

@Slf4j
@Controller
@RequestMapping(value = { "crmCampTempltBas", "{menuCd}/crmCampTempltBas" })
public class CrmCampTempltBasController{
	

	
	@Value("${spring.eon.barcode-url}")
	String barcodeUrl;
	

	@Autowired
	CrmCampTempltBasService service;

	@Autowired
	CrmCampBasService campBasservice;

	@Autowired
	CrmCampDspBasService dspService;



	/**
	 * 
	 * @author user
	 * @date 2022. 6. 9. * @param param
	 * @param model
	 * @return
	 * @throws Exception
	 * @description 캠페인템플릿기본 목록페이지
	 *
	 */
	@GetMapping(value = { "", "index" })
	public String init(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAllAttributes(param);
		
		List<CrmCampDspBasVo> list = dspService.getList(param);
		model.addAttribute("chlList", list);
		

		model.addAttribute("barcodeUrl", barcodeUrl ); 
		
		
		return Utilities.getProperty("tiles.crm") + "camp/crmCampTempltBasList";
	}

	
	@GetMapping(value = { "editor" })
	public String editor(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAllAttributes(param);

		log.debug("SmartEditor2.html = "+ Utilities.getProperty("tiles.crm") );
		return Utilities.getProperty("tiles.crm") +"camp/SmartEditor2";
	}
	
	
	/**
	 * 
	 * @author user
	 * @date 2022. 6. 9. * @param param
	 * @return
	 * @throws Exception
	 * @description 캠페인템플릿기본 목록검색
	 *
	 */
	@PostMapping(value = { "getList" })
	public @ResponseBody Object getList(@RequestBody EzMap param) throws Exception {
		EzPaginationInfo page = param.getPaginationInfo();
		List<CrmCampTempltBasVo> list = service.getList(param);
		page.setTotalRecordCount(service.getListCount(param));
		return Utilities.getGridData(list,page);
	}

	/**
	 * 
	 * @author user
	 * @date 2022. 6. 9. * @param rparam
	 * @return
	 * @throws Exception
	 * @description 캠페인템플릿기본 1건검색
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
	 * @date 2022. 6. 9. * @param vo
	 * @return
	 * @throws Exception
	 * @description 캠페인템플릿기본 저장
	 * */@PostMapping(value = {"save" })
	 public @ResponseBody Object save(@RequestBody CrmCampTempltBasVo vo) throws Exception {
		 return service.save(vo);
	 }

	 /**
	  * 
	  * @author user
	  * @date 2022. 6. 9. * @param list
	  * @return
	  * @throws Exception
	  * @description 캠페인템플릿기본 리스트 저장
	  *
	  */
	 @PostMapping(value = { "saveList" })
	 public @ResponseBody Object saveList(@RequestBody List<CrmCampTempltBasVo> list) throws Exception {
		 return service.saveList(list);
	 }
	 /**
	  * 
	  * @author user
	  * @date 2022. 6. 9.
	  * @param list
	  * @return
	  * @throws Exception
	  * @description 캠페인템플릿기본 리스트 삭제
	  *
	  */
	 @PostMapping(value = { "deleteList" })
	 public @ResponseBody Object deleteList(@RequestBody List<CrmCampTempltBasVo> list) throws Exception {
		 return service.deleteList(list);
	 }
	 
	 /**
	  * 
	  * @author user
	  * @date 2022. 6. 9.
	  * @param list
	  * @return
	  * @throws Exception
	  * @description 캠페인템플릿기본 리스트 삭제
	  *
	  */
	 @PostMapping(value = { "delete" })
	 public @ResponseBody Object delete(@RequestBody CrmCampTempltBasVo list) throws Exception {
		 return service.delete(list);
	 }
}
