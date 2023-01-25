package com.ceragem.crm.camp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ceragem.crm.camp.model.CrmCampBasVo;
import com.ceragem.crm.camp.model.CrmCampDspBasVo;
import com.ceragem.crm.camp.service.CrmCampBasService;
import com.ceragem.crm.camp.service.CrmCampDspBasService;
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
@RequestMapping(value = { "crmCampBas", "{menuCd}/crmCampBas" })
public class CrmCampBasController{
	
	
	
	@Value("${spring.eon.barcode-url}")
	String barcodeUrl;
	
	
	

	@Autowired
	CrmCampBasService service;


	@Autowired
	CrmCampDspBasService dspService;



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

		return Utilities.getProperty("tiles.crm") + "camp/crmCampBasList";
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

		vo.setOrdrChlList( Utilities.convArryToStrs(vo.getOrdrChlList(), ",") );
		
		// 그룹에 실제 회원이 있는 지 확인한다. 
		int grpCnt = service.getselectCustGrp(vo);
		if( grpCnt == 0 ) {
			return "ErrGrpCustCnt";
		}		
		return service.saveAll(vo);
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
	 * @description CRM캠페인기본 신규생성
	 */
	@GetMapping(value = { "add" })
	public String add(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {


		model.addAttribute("addMode", "C" ); 		 

		// 캠페인 기본번호가 넘어올 경우 
		if( !param.get("campBasNo").equals("") ) {

			model.addAttribute("cpinfo", get(param) ); 
			model.addAttribute("addMode", "U" ); 
		}else {

			param.put("ftgabltStaHour", "09");
			param.put("ftgabltStaMnut", "00");
			param.put("ftgabltEndHour", "18");
			param.put("ftgabltEndMnut", "00");
			
			model.addAttribute("cpinfo", param ); 
			
		}


		List<CrmCampDspBasVo> list = dspService.getList(param);
		model.addAttribute("chlList", list);

		//		param.put("codeCd", "MB020");
		//		List<CrmComnCdBaseVo> list = codeService.getComboCode(param);
		//		model.addAttribute("memknd", list);
		return Utilities.getProperty("tiles.crm") + "camp/crmCampBasDetail";
	}


	/**
	 * 
	 * @author user
	 * @date 2022. 5. 2. * @param vo
	 * @return
	 * @throws Exception
	 * @description CRM캠페인기본 2차 캠페인 생성
	 */
	@GetMapping(value = { "add2th" })
	public String add2th(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {

		model.addAttribute("addMode", "C" );

		// 2차 캠페인 반응 등록 Y,  미반응 등록 N
		String rspnApplyYn = (String) param.get("rspnApplyYn");
		model.addAttribute("rspnApplyYn", rspnApplyYn );



		// 2차 캠페인 반응 등록
		if( !param.get("campBasNo").equals("") &&  "Y".equals( rspnApplyYn )  ) {


			// 2차 반응이 등록되어 있다면
			if( !param.get("lowRspnCampNo").equals("") ) {
				param.put("prntsCampBasNo",  param.get("campBasNo") );
				param.put("campBasNo", param.get("lowRspnCampNo"));
				model.addAttribute("addMode", "U" );
			}else {
				param.put("prntsCampBasNo",  param.get("campBasNo") );
			}

			CrmCampBasVo crmCampBasVo = (CrmCampBasVo) get(param);

			// 2차 반응 기본 번호가 없을 경우 
			if( param.get("lowRspnCampNo").equals("") ) {
				crmCampBasVo.setPrntsCampBasNo( ""+ param.get("prntsCampBasNo") );
				crmCampBasVo.setCampBasNo(null);
				crmCampBasVo.setApplyPoint(null);
				crmCampBasVo.setApplyCoupnBasNo(null);
				crmCampBasVo.setApplyCoupnBasNoNm(null);
				crmCampBasVo.setDspChlCd(null);
				crmCampBasVo.setDspCtntTypeNo(null);
				crmCampBasVo.setDspCtntTypeNoNm(null);
			}

			model.addAttribute("cpinfo", crmCampBasVo );
		}



		// 2차 캠페인 미반응 등록
		if( !param.get("campBasNo").equals("") &&  "N".equals( rspnApplyYn )  ) {


			// 2차 반응이 등록되어 있다면
			if( !param.get("lowRspnDnaCampNo").equals("") ) {
				param.put("prntsCampBasNo",  param.get("campBasNo") );
				param.put("campBasNo", param.get("lowRspnDnaCampNo"));
				model.addAttribute("addMode", "U" );
			}else {
				param.put("prntsCampBasNo",  param.get("campBasNo") );
			}

			CrmCampBasVo crmCampBasVo = (CrmCampBasVo) get(param);

			// 2차 반응 기본 번호가 없을 경우 
			if( param.get("lowRspnDnaCampNo").equals("") ) {
				crmCampBasVo.setPrntsCampBasNo( ""+ param.get("prntsCampBasNo") );
				crmCampBasVo.setCampBasNo(null);
				crmCampBasVo.setApplyPoint(null);
				crmCampBasVo.setApplyCoupnBasNo(null);
				crmCampBasVo.setApplyCoupnBasNoNm(null);
				crmCampBasVo.setDspChlCd(null);
				crmCampBasVo.setDspCtntTypeNo(null);
				crmCampBasVo.setDspCtntTypeNoNm(null);
			}

			model.addAttribute("cpinfo", crmCampBasVo );
		}


		List<CrmCampDspBasVo> list = dspService.getList(param);
		model.addAttribute("chlList", list);

		return Utilities.getProperty("tiles.crm") + "camp/crmCampBasDetail2";

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


	/**
	 * 
	 * @author user
	 * @date 2022. 5. 2. * @param vo
	 * @return
	 * @throws Exception
	 * @description CRM캠페인 대상군 혜택 관리
	 */
	@GetMapping(value = { "popTgtBnfit" })
	public String popTgtBnfit(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {


		model.addAttribute("addMode", "C" ); 		 

		// 멤버십쿠폰기본번호가 넘어올 경우 
		//		if( !param.get("campBasNo").equals("") ) {
		//			model.addAttribute("cpinfo", param ); 
		//			model.addAttribute("addMode", "U" ); 
		//		}

		model.addAttribute("campBasNo", param.get("campBasNo") ); 
		return Utilities.getProperty("tiles.crm") + "camp/popTgtBnfit";
	}


	/**
	 * 
	 * @author user
	 * @date 2022. 5. 2. * @param vo
	 * @return
	 * @throws Exception
	 * @description CRM캠페인 대상군 발송채널
	 */
	@GetMapping(value = { "popTgtChl" })
	public String popTgtChl(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {


		model.addAttribute("addMode", "C" ); 		 

		// 멤버십쿠폰기본번호가 넘어올 경우 
		//		if( !param.get("campBasNo").equals("") ) {
		//			model.addAttribute("cpinfo", param ); 
		//			model.addAttribute("addMode", "U" ); 
		//		}

		return Utilities.getProperty("tiles.crm") + "camp/popTgtChl";
	}

	/**
	 * 
	 * @author user
	 * @date 2022. 5. 2. * @param vo
	 * @return
	 * @throws Exception
	 * @description CRM캠페인 대상군 발송 콘텐츠 설정
	 */
	@GetMapping(value = { "popTgtCtnt" })
	public String popTgtCtnt(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {


		
		
		List<CrmCampDspBasVo> list = dspService.getList(param);
		model.addAttribute("chlList", list);

		model.addAllAttributes(param);
		model.addAttribute("addMode", "C" ); 	
		model.addAttribute("barcodeUrl", barcodeUrl ); 
		
		// 멤버십쿠폰기본번호가 넘어올 경우 
		//		if( !param.get("campBasNo").equals("") ) {
		//			model.addAttribute("cpinfo", param ); 
		//			model.addAttribute("addMode", "U" ); 
		//		}

		return Utilities.getProperty("tiles.crm") + "camp/popTgtCtnt";
	}




	/**
	 * 
	 * @author user
	 * @date 2022. 5. 2. * @param param
	 * @param model
	 * @return
	 * @throws Exception
	 * @description CRM캠페인관리 승인관리
	 *
	 */
	@GetMapping(value = { "crmCampApprBas" })
	public String crmCampApprBase(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm") + "camp/crmCampApprBasList";
	}


	/**
	 * 
	 * @author user
	 * @date 2022. 5. 2. * @param param
	 * @return
	 * @throws Exception
	 * @description CRM캠페인기본 승인 목록검색
	 *
	 */
	@PostMapping(value = { "getApprList" })
	public @ResponseBody Object getApprList(@RequestBody EzMap param) throws Exception {

		param.put("campStatusCd", "001");
		EzPaginationInfo page = param.getPaginationInfo();
		List<CrmCampBasVo> list = service.getList(param);
		page.setTotalRecordCount(service.getListCount(param));
		return Utilities.getGridData(list,page);
	}



	/**
	 * 
	 * @author user
	 * @date 2022. 5. 2. * @param param
	 * @param model
	 * @return
	 * @throws Exception
	 * @description CRM캠페인관리 모니터링
	 *
	 */
	@GetMapping(value = { "crmCampMonitor" })
	public String crmCampMonitor(@RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm") + "camp/crmCampMonitor";
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
	@PostMapping(value = { "saveMonitorList" })
	public @ResponseBody Object saveMonitorList(@RequestBody List<CrmCampBasVo> list) throws Exception {
		return service.saveList(list);
	}


	/**
	 * 
	 * @author user
	 * @date 2022. 5. 2. * @param vo
	 * @return
	 * @throws Exception
	 * @description CRM캠페인 혜택 저장
	 * */
	@PostMapping(value = {"saveBenfit" })
	public @ResponseBody int saveBenfit(@RequestBody CrmCampBasVo vo) throws Exception {

		return service.saveBenfit(vo);
	}


	/**
	 * 
	 * @author user
	 * @date 2022. 5. 2. * @param vo
	 * @return
	 * @throws Exception
	 * @description CRM캠페인 혜택 저장
	 * */
	@PostMapping(value = {"updateCampStatus" })
	public @ResponseBody int updateCampStatus(@RequestBody CrmCampBasVo vo) throws Exception {

		return service.updateCampStatus(vo);
	}



	/**
	 * 
	 * @author      김은성
	 * @date        2022. 6. 21.
	 * @return
	 * @throws      Exception
	 * @description 캠페인 모니터링 직접반응 팝업(그리드 더블 클릭)
	 *                             
	 */
	@GetMapping(value = { "monitorDirPopup/{campBasNo}" })
	public String monitorDirPopup(CrmCampBasVo vo, @PathVariable("campBasNo") String campBasNo, @RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		vo.setCampBasNo(campBasNo);
		model.addAttribute("campBasNo", campBasNo);
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm") + "camp/crmCampMonitorDirPop";
	}
	

	/**
	 * 
	 * @author      김은성
	 * @date        2022. 6. 21.
	 * @return
	 * @throws      Exception
	 * @description 캠페인 모니터링 간접반응 팝업(그리드 더블 클릭)
	 *                             
	 */
	@GetMapping(value = { "monitorInDirPopup/{campBasNo}" })
	public String monitorInDirPopup(CrmCampBasVo vo, @PathVariable("campBasNo") String campBasNo, @RequestParam Map<String, Object> param, ModelMap model) throws Exception {
		vo.setCampBasNo(campBasNo);
		model.addAttribute("campBasNo", campBasNo);
		model.addAllAttributes(param);
		return Utilities.getProperty("tiles.crm") + "camp/crmCampMonitorInDirPop";
	}
	
	
	
	/**
	*
	* @author      김은성
	* @date        2022. 6. 22.
	* @return
	* @throws      Exception
	* @description 캠페인 모니터링 간접반응 리스트 검색
	*
	*/
	@PostMapping(value = { "getIndirectUserList" })
	public @ResponseBody Object getIndirectUserList(@RequestBody EzMap param) throws Exception {
	   EzPaginationInfo page = param.getPaginationInfo();
	   List<CrmCampBasVo> list = service.getIndirectUserList(param);
	   page.setTotalRecordCount(service.getIndirectUserListCount(param));
	   return Utilities.getGridData(list,page);
	}
	
	
	
	/**
	*
	* @author      김은성
	* @date        2022. 6. 22.
	* @return
	* @throws      Exception
	* @description 캠페인 임시 sms 전송
	*
	*/
	@PostMapping(value = { "sndTstMsg" })
	public @ResponseBody int sndTstMsg(@RequestBody CrmCampBasVo vo) throws Exception {
		
	
		return service.sndTstMsg(vo);
		
	}
	

}
