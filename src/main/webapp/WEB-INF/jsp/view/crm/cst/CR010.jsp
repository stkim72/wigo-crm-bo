<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="code" uri="/WEB-INF/tlds/ezTagLib.tld"%>
<c:set var="addMode" value="${addMode==true}" />

	
	<form id="frmMain">
 
		<input type="hidden" id="stat" name="stat" value="${addMode ? 'c' : 'u'}"/>
		<input type="hidden" id="cntplcSeq" name="cntplcSeq" value="${vo.cntplcSeq }"/>
	   	<input type="hidden" id="itgCustNo"  name="itgCustNo" value="${vo.itgCustNo }"/>
	   	<!-- 
	   	<input type="hidden" id="cntplcTypeCd" name="cntplcTypeCd" value="${vo.cntplcTypeCd }" /> 
	   	<input type="hidden" id="repCntplcYn" name="repCntplcYn" value="${vo.repCntplcYn }" />
	   	<input type="hidden" id="telNo" name="telNo" value="${vo.telNo }"/>
	   	-->
	   	<input type="hidden" id="telNoEncVal" name="telNoEncVal" value="${vo.telNoEncVal }"/>
	   	<input type="hidden" id="telBkDgtNo" name="telBkDgtNo" value="${vo.telBkDgtNo }"/>
	   	<!-- 
	   	<input type="hidden" id="zipCd" name="zipCd" value="${vo.zipCd }"/>
	   	<input type="hidden" id="addr1Ctnts" name="addr1Ctnts" value="${vo.addr1Ctnts }"/>
	   	<input type="hidden" id="addr2Ctnts" name="addr2Ctnts" value="${vo.addr2Ctnts }"/>
	   	-->
	   	<input type="hidden" id="emailAddr" name="emailAddr" value="${vo.emailAddr }"/>
	   	<input type="hidden" id="regChlCd" name="regChlCd" value="${vo.regChlCd }"/>
	   	<input type="hidden" id="delYn" name="delYn" value="${vo.delYn }"/>
	   	<input type="hidden" id="amdrId" name="amdrId" value="${vo.amdrId }"/>
	   	<input type="hidden" id="amdDt" name="amdDt" value="${vo.amdDt }"/>
	   	<input type="hidden" id="regrId" name="regrId" value="${vo.regrId }"/>
	   	<input type="hidden" id="regDt" name="regDt" value="${vo.regDt }"/>
 		   		
		<div class="title">
	        <h1>${addMode? "????????? ??????" : "????????? ??????" }</h1>
	        <a href="#" data-btn-type="closeModal" class="close">?????? ??????</a>
	    </div>
	    
		<div class="cont">
	  	
			<div class="gTitle1 line">
				<h3 class="mTitle1">????????? ????????????</h3>	
				<div class="gRt">
					<button class="mBtn1" data-click="saveRepCntplc">?????????????????????</button>
					<code:btnGroup name="Contact" hideDelete="${addMode? true:false }" hideInsert="true" />
					
	            </div>	
	        </div>
	        <!-- board -->
	        <div class="mBoard2"> 
	            <table>
	                <caption>????????? ????????????</caption>
	                <colgroup>
	                    <col width="15%">
	                    <col width="*%">
	                    <col width="16%">
	                </colgroup>
	                <tbody>
	                    <tr>
							<th class="left" scope="row">???????????????</th>
							<td class="left" colspan="2">
								<code:commCode id="cntplcTypeCd" name="cntplcTypeCd" codeCd="CU300" prefixValue="" multiple="false" selectedValue="${vo.cntplcTypeCd }"/>
							</td>
	                    </tr>	                
	                    <tr>
	                        <th scope="row" class="left"><span class="iMust">?????????</span></th>
	                        <td colspan="2">
	                            <input type="text" class="it must" title="?????????" name="telNo" id="telNo" value="${vo.telNo }" >
	                        </td>
<!-- 	                        <td> -->
<!-- 	                            <a href="#" class="mBtn1 m lWhite">????????????</a> -->
<!-- 	                        </td>	                         -->
	                    </tr>
	                    <tr>
							<th scope="row" class="left">????????????</th>
							<td class="left" colspan="2">
								<div class="mFlex2">
									<div class="mFind1">
										<input type="text" class="it" title="????????????" name="zipCd" id="zipCd" value="${vo.zipCd }" readonly="readonly" >
										<!-- <a href="#" class="iFind">??????</a>  -->
										<!-- ???????????? ????????? ??????  -->
										<a href="#" data-click="popupZip" id="btnPopupZip" class="iFind">??????</a>
									</div>
								</div>
							</td>
                        </tr>

	                    <tr>
							<th scope="row" class="left">??????</th>
							<td class="left" colspan="2">
								<div class="mFlex2">
									<input type="text" class="it" title="??????" name="addr1Ctnts" id="addr1Ctnts" value="${vo.addr1Ctnts }" readonly="readonly">
								</div>
							</td>
                        </tr>
	                    <tr>
							<th scope="row" class="left">????????????</th>
							<td class="left" colspan="2">
								<div class="mFlex2">
									<input type="text" class="it" title="????????????" name="addr2Ctnts" id="addr2Ctnts" value="${vo.addr2Ctnts }" >
								</div>
							</td>
                        </tr>        
<!-- 	                    <tr> -->
<!-- 							<th scope="row" class="left">??????????????????</th> -->
<!-- 							<td class="left" colspan="2"> -->
<!-- 								<label class="mCheckbox1"> -->
<%-- 									<input type="checkbox" title="??????????????????" name="repCntplcYn" id="repCntplcYn" value="${vo.repCntplcYn }" > --%>
<!-- 									<span class="label">??????????????????</span> -->
<!-- 								</label> -->
<!-- 							</td> -->
<!--                         </tr>                                                                     -->
	                </tbody>
	            </table>

	        </div>
  	
		</div>
	</form>	



<script>

// 	$("#postStaDt").val(moment("${vo.postStaDt }").format("YYYYMMDD"));
//	$("#postEndDt").val(moment("${vo.postEndDt }").format("YYYYMMDD"));
	
	// ????????? ?????? ??? ??????
	function saveContact(){
		var saveJson = Utilities.formToMap("frmMain");
		if(!saveJson.cntplcTypeCd){
			alert("????????? ????????? ???????????????");
			$("#cntplcTypeCd")[0].focus();
			return;
			
		}
		if(!saveJson.telNo){
			alert("???????????? ???????????????");
			$("#telNo")[0].focus();
			return;
			
		}
		
		// ???????????? ??????
		$("#repCntplcYn").prop("checked")? $("#repCntplcYn").val("Y") : $("#repCntplcYn").val("N");
		// ?????? ??????
		$("#delYn").val("N");
		// ?????? ??????
		$("#regChlCd").val("CRM");		

		var url = "<c:url value='${urlPrefix}/sub/crmCustCntplcBas/save${urlSuffix}'/>";
		Utilities.getAjax(url,saveJson,true,function(data , jqXHR){
            if(Utilities.processResult(data , jqXHR , "????????? ????????? ??????????????????."))
            {
            	
                alert("????????? ????????? ??????????????????.");
                Utilities.getOpener().search1();
                Utilities.closeModal();
            }
        });
	}
	
	// ????????? ??????
	function removeContact()
	{
		Utilities.getOpener().deleteContact($("#cntplcSeq").val());
		Utilities.closeModal();
	}
	
	function onAddressSelect(data){

		$("#zipCd").val(data.zipNo);
		$("#addr1Ctnts").val(data.roadAddr);

	}
	
	/* ?????? ????????? ???????????? */
	function popupZip(){
		
		// ???????????? ?????? ????????? ?????????
		Utilities.openZipPop("onAddressSelect");
	}
	
	function saveRepCntplc(){
		var bConfirm = confirm("?????????????????? ?????????????????????????");
		if(!bConfirm){
			return;
		}
		
		var param = Utilities.formToMap("frmMain");
		
		var url = "<c:url value='${urlPrefix}/saveRepCntplc${urlSuffix}'/>";
		Utilities.getAjax(url,param,true,function(data,jqXHR){
			if(Utilities.processResult(data,jqXHR,"????????? ??????????????????."))
			{
				alert("?????????????????? ?????????????????????.");
				Utilities.getOpener().search1();
				Utilities.closeModal();
			}
		});
	}
</script>