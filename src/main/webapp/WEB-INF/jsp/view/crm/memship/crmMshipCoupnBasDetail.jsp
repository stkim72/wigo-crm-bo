<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="code" uri="/WEB-INF/tlds/ezTagLib.tld"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



<style>

.ui-widget-content .ui-state-active:hover {
	border: 1px solid #003eff;
	background: #007fff;
	font-weight: normal;
	color: #ffffff;
}

.ui-menu-item b {
	color: red;
}

.tui-datetime-input{
	width:110px;
}

.select{
	width:110px;
}


.mBox1.h717 {
     height: 600px;
}

.mGrid2.type2 .mBoard1 {
    height: 500px !important;
}

.mBox1 {
    background-color: #fff;
    border: 1px solid #9c9c9c;
    padding: 17px 10px;
    height:600px;
    /* margin-right:10px */
}

 #frmDetail label.error { margin-left: 10px; color:red; }

.demoInputBox{padding:10px; border:#F0F0F0 1px solid; border-radius:4px;}
.btnAction{background-color:#2FC332;border:0;padding:10px 40px;color:#FFF;border:#F0F0F0 1px solid; border-radius:4px;}
.invalid{border:#FF0000 1px solid;}        
        
</style>


<script>
$(document).ready(function() {
	/* tab */
	$(".jsTab1 li > a").on("click",function(){
		$(this).parent().parent().children().removeClass("active");
		$(this).parent().addClass("active");
		return false;
	});
	$(".jsTab2 li > a").on("click",function(){
		$(this).parent().parent().children().removeClass("active");
		$(this).parent().addClass("active");
		$(this).parent().parent().parent().parent().children(".tabCont").addClass("hidden");
		$( $(this).attr("href") ).removeClass("hidden");
		return false;
	});
	/* //tab */
});
</script>



<div class="mPopup1">



	
	    <!-- header -->
    <div class="title">
    
        <h1>??????????????? ??????</h1>
        <a href="#"  data-click="closeModal"   class="close">?????? ??????</a>
    </div>
    <!-- //header -->
    
    <div id="wrapIframe" class="closed"> <!-- ???????????? ?????? -->
    	
	<div class="mGrid1">
		<!-- right -->
		<div class="gRight">

<br>
			<!-- sort -->
			<div class="mSort2">
			
         	<form role="form" id="frmSearch" name="frmSearch">
				<ul>
					<li class="wAuto">
						<div class="tit">???????????????</div>
						<div class="txt">
                            <div class="mFlex2">
								<span class="flex"><input type="text" class="it w185" name="mshipCoupnBasNo" id="mshipCoupnBasNo"  required="true" disabled placeholder="????????????" value="${cpinfo.mshipCoupnBasNo}" title="???????????????"></span>
                                <span class="button">
                                   <!--  <a href="#" class="mBtn1" data-click="searchGods">??????</a> -->
                                </span>
							</div>
						</div>
					</li>
				</ul>
                <div class="button posRt"> <!-- ?????? ?????? : class="posRt" -->
                
               
                   <!--  <a href="#" class="mBtn1 gray">?????? API ??????</a> -->
                    <a href="#" class="mBtn1 gray" data-click="cpnIssue">??????????????????</a>
                    <a href="#" class="mBtn1 gray" data-click="cpnStoreIssue">?????????????????????</a>
                </div>
            </form>    
			</div>
			<!-- //sort -->

            <!-- grid -->
            <div class="mGrid2">
                <!-- left -->
                <div class="lt">
                
                
         	<form role="form" id="frmDetail" name="frmDetail">
         	
				<input type="hidden" id="stat" name="stat" value="${addMode}"/>
         		<input type="hidden" name="mshipCoupnBasNo" id="mshipCoupnBasNo" value="${cpinfo.mshipCoupnBasNo}">
         		<input type="hidden" name="coupnApplyDivCd1" id="coupnApplyDivCd1" value="${cpinfo.coupnApplyDivCd1}">

                    <!-- box -->
                    <div class="mBox1 p24 pt28 h717"> 
                        <!-- 
                            class="pt28" : padding-top="28"
                            class="h717" : height="717"
                        -->
                        <div class="gTitle1 line">
                            <h3 class="mTitle1">????????????</h3>
                       
                        </div>
                        
                       <div class="flex" style="float:right;margin-top:-35px;margin-left:100px;width:200px">
                           ????????????
                            <label class="mRadio1 type2 fs12">
                                  <input type="radio"  title="??????" name="useYn" class="data-check" id="useYn" value="Y"   required="true"  <c:if test="${cpinfo.useYn == 'Y'}"><c:out value="checked" /></c:if>>
                                  <span class="label">??????</span>
                              </label>
                              <label class="mRadio1 type2 fs12">
                                  <input type="radio"  title="?????????" name="useYn"  class="data-check"  id="useYn" value="N"   required="true"  <c:if test="${cpinfo.useYn == 'N'}"><c:out value="checked" /></c:if>>
                                  <span class="label">?????????</span>
                              </label>
                       </div> 
                           
                           
                        <div class="mBoard2">
                            <table>
                                <caption>????????????</caption>
                                <colgroup>
                                    <col width="11%">
                                    <col width="15%">
                                    <col width="15%">
                                    <col width="15%">
                                    <col width="10%">
                                    <col width="*">
                                </colgroup>
                                <tbody>
                                    <tr>
                                        <th scope="row" class="left">??????????????????</th>
                                        <td>
                                           <code:commCode  className="select data-check" id="coupnClassCd" name="coupnClassCd" codeCd="MB120" prefixLabel="??????" prefixValue="" selectedValue="${cpinfo.coupnClassCd}" />
                                        </td>
                                        <th scope="row" class="left">????????????</th>
                                        <td>
                                           <code:commCode  className="select data-check" id="coupnTgtCd" name="coupnTgtCd" codeCd="MB100" prefixLabel="??????" prefixValue="" selectedValue="${cpinfo.coupnTgtCd}" others=" onchange=\"chkCoupnTgtCd(this)\"" />
                                        </td>
                                        <th scope="row" class="left">???????????????</th>
                                        <td>
                                            <div class="mFlex2">
                                                
                                           <code:commCode  className="select data-check" id="coupnTypeCd" name="coupnTypeCd" codeCd="MB080" prefixLabel="??????" prefixValue="" selectedValue="${cpinfo.coupnTypeCd}" />
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th scope="row" class="left">?????? ????????????</th>
                                        <td colspan="3">
                                            <input type="text" class="it data-check" title="?????? ????????????"  name="coupnBasNm" id="coupnBasNm"  required="true"  value="${cpinfo.coupnBasNm}">
                                        </td>
                                        <th scope="row" class="left">????????????</th>
                                        <td>
											<div class="mDate1">
												 <input type="text" class="it data-check" title="?????? ?????????"  data-type="dateRangeStart"  required="true"   data-range-end="toPblsStdDay"  data-button="Y"  name="fromPblsStdDay" id="fromPblsStdDay" value="${cpinfo.fromPblsStdDay}">
                                    
					                            <span class="bar">~</span>
									                        
											<input type="text" class="it data-check " title="?????? ????????????" name="toPblsStdDay" required  id="toPblsStdDay" data-button="Y"  value="${cpinfo.toPblsStdDay}">
											</div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <%-- <th scope="row" class="left">??????????????????</th>
                                        <td colspan="3" class="left" style="padding:5px;line-height:28px">
                                       
                                        <code:commCode  className="select data-check mshipGrp" id="mshipGradeCd" name="mshipGradeCd" codeCd="MB010" prefixLabel="??????" prefixValue="" change="chkGrade" selectedValue="${cpinfo.mshipGradeCd}"/>
	                                    <code:commCode  className="select data-check mshipGrp" id="mshpGradeCd" name="mshpGradeCd" codeCd="MB020" prefixLabel="??????" prefixValue="" others="  " selectedValue="${cpinfo.mshpGradeCd}"/>
	                                    <select class="select w130 data-check mshipGrp"  name="cprtCmpNo" id="cprtCmpNo" disabled>
	                                    	<option value="">????????? ??????</option>
	                                    </select>
                                            
                                        </td> --%>
                                        <th scope="row" class="left">?????? ?????? ??????</th>
                                        <td colspan="3">
                                            <div class="mFlex2">
                                                <span class="flex">
                                                    <code:commCode  className="select data-check" id="coupnIssueMethCd" name="coupnIssueMethCd" codeCd="MB110" prefixLabel="??????" prefixValue="" others=" onChange=\"chkCnt(this)\" " selectedValue="${cpinfo.coupnIssueMethCd}"/>
                                                </span>
                                                <span class="flex w1">
                                                
                                                <c:set var="issueRstrtnCnt" value="0"></c:set>
                                                <c:if test="${cpinfo.coupnIssueMethCd == '002'}"> 
                                                	<c:set var="issueRstrtnCnt" value="${cpinfo.coupnIssueMethCd}"></c:set>
												</c:if> 
												
                                                    <input type="text" class="it right w50" title="??????"   data-type="number"   name="issueRstrtnCnt" id="issueRstrtnCnt"  maxlength="5"   <c:if test="${cpinfo.coupnIssueMethCd != '002'}"><c:out value="disabled"/> </c:if> value="${issueRstrtnCnt}"/>
                                                    <span class="bar2">???</span>
                                                </span>
                                            </div>
                                        </td>
                                        <th scope="row" class="left">?????????</th>
                                        <td colspan="3">
                                            <div class="mFlex2">
                                                <span class="flex w1" id="regrId">
                                                ${cpinfo.regrNm}
                                                </span>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th scope="row" class="left">??? ???????????? ??????</th>
                                        <td>
                                            <div class="mFlex2">
                                                <span class="flex">
                                                    <input type="text" class="it right data-check comma" title="?????? ?????? ??????"  data-type="number2"  name="maxUseCnt" id="maxUseCnt"   maxlength="10"   value="${cpinfo.maxUseCnt}">
                                                </span>
                                                <span class="bar2">???</span>
                                            </div>
                                        </td>
                                        <th scope="row" class="left">??? ???????????? ??????</th>
                                        <td>
                                            <div class="mFlex2">
                                                <span class="flex">
                                                    <input type="text" class="it right data-check comma" title="?????? ?????? ??????"   data-type="number2"  name="maxIssueCnt" id="maxIssueCnt"  maxlength="10"   value="${cpinfo.maxIssueCnt}">
                                                </span>
                                                <span class="bar2">???</span>
                                            </div>
                                        </td>
                                        <th scope="row" class="left">?????????</th>
                                        <td>
                                            <div class="mFlex2">
                                                <span class="flex w1" id="regDt">
                                                	${cpinfo.regDt}
                                                </span>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                    	<th scope="row" class="left">??????????????????</th>
		                                <td class="left" colspan="5">
						                    <span id="applyMshpGradeCtnts"></span>
						                    <label class="mCheckbox1">
												<input type="checkbox" title="?????????" id="mshipTypeCds" name="mshipTypeCds">
												<span class="label">?????????</span>
											</label>
											<select class="select w130 mshipGrp" name="cprtCmpNo" id="cprtCmpNo">
		                                    	<option value="">????????? ??????</option>
		                                    </select>
						                </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        
                        <div class="gTitle1 line">
                            <h3 class="mTitle1">????????????</h3>
                        </div>
                        <div class="mBoard2">
                            <table>
                                <caption>????????????</caption>
                                <colgroup>
                                    <col width="10%">
                                    <col width="12%">
                                    <col width="10%">
                                    <col width="12%">
                                    <col width="10%">
                                    <col width="12%">
                                    <col width="10%">
                                    <col width="12%">
                                </colgroup>
                                <tbody>
                                    <tr>
                                        
                                        <th scope="row" class="left">????????????</th>
                                        <td class="left">
                                        	<code:commCode  className="select data-check" id="coupnKndCd" name="coupnKndCd" codeCd="MB130" prefixLabel="??????" prefixValue=""  others=" onchange=\"chkUse()\"" selectedValue="${cpinfo.coupnKndCd}"/>
                                        </td>
                                        
                                        <th scope="row" class="left">????????????</th>
                                        <td class="left">
                                            <input type="text" class="it right w75 data-check grp01 comma" title="????????????"  name="applyAmt" id="applyAmt"   maxlength="14"  data-type="number2" onkeyup="chkApplyAmt(this)" value="${cpinfo.applyAmt}">
                                            <span class="bar2">???</span>
                                        </td>
                                        
                                        <th scope="row" class="left">?????????</th>
                                        <td class="left">
                                            <input type="text" class="it right w60 data-check grp02 comma" title="?????????"  name="applyRate" id="applyRate"   maxlength="14"  data-type="number2" onkeyup="chkApplyAmt(this)" value="${cpinfo.applyRate}">
                                            <span class="bar2">%</span>
                                        </td>
                                        
                                        <th scope="row" class="left">???????????????</th>
                                        <td class="left">
                                            <input type="text" class="it right w75 data-check grp05 comma" title="???????????????"  name="applyPoint" id="applyPoint"   maxlength="14"  data-type="number2" onkeyup="chkApplyAmt(this)" value="${cpinfo.applyPoint}">
                                            <span class="bar2">P</span>
                                        </td>
                                    
                                    </tr>
                                    <tr>
                               			<th scope="row" class="left">??????????????????</th>
                                        <td class="left">
                                            <input type="text" class="it right w75 data-check grp01 grp02  comma" title="??????????????????"   data-type="number2"  maxlength="14"  name="minBuyAmt" id="minBuyAmt" value="${cpinfo.minBuyAmt}">
                                            <span class="bar2">???</span>
                                        </td>
                                        <th scope="row" class="left">??????????????????</th>
                                        <td class="left">
                                            <input type="text" class="it right w75 data-check grp02  comma" title="??????????????????"   data-type="number2"  name="maxDcAmt"  maxlength="14"  id="maxDcAmt" value="${cpinfo.maxDcAmt}">
                                            <span class="bar2">???</span>
                                        </td>
                                        <th scope="row" class="left">????????????</th>
                                        <td class="left" colspan="4">
                                            <label class="mCheckbox1">
                                                <input type="checkbox" title="???" name="dow1UseYn" id="dow1UseYn" value="Y" <c:if test="${cpinfo.dow1UseYn == 'Y' or cpinfo.dow1UseYn == null}"><c:out value="checked" /></c:if>>
                                                <span class="label">???</span>
                                            </label>
                                            <label class="mCheckbox1">
                                                <input type="checkbox" title="???" name="dow2UseYn" id="dow2UseYn" value="Y" <c:if test="${cpinfo.dow2UseYn == 'Y' or cpinfo.dow2UseYn == null}"><c:out value="checked" /></c:if>>
                                                <span class="label">???</span>
                                            </label>
                                            <label class="mCheckbox1">
                                                <input type="checkbox" title="???" name="dow3UseYn" id="dow3UseYn" value="Y" <c:if test="${cpinfo.dow3UseYn == 'Y' or cpinfo.dow3UseYn == null}"><c:out value="checked" /></c:if>>
                                                <span class="label">???</span>
                                            </label>
                                            <label class="mCheckbox1">
                                                <input type="checkbox" title="???" name="dow4UseYn" id="dow4UseYn" value="Y" <c:if test="${cpinfo.dow4UseYn == 'Y' or cpinfo.dow4UseYn == null}"><c:out value="checked" /></c:if>>
                                                <span class="label">???</span>
                                            </label>
                                            <label class="mCheckbox1">
                                                <input type="checkbox" title="???" name="dow5UseYn" id="dow5UseYn" value="Y" <c:if test="${cpinfo.dow5UseYn == 'Y' or cpinfo.dow5UseYn == null}"><c:out value="checked" /></c:if>>
                                                <span class="label">???</span>
                                            </label>
                                            <label class="mCheckbox1">
                                                <input type="checkbox" title="???" name="dow6UseYn" id="dow6UseYn" value="Y" <c:if test="${cpinfo.dow6UseYn == 'Y' or cpinfo.dow6UseYn == null}"><c:out value="checked"/></c:if>>
                                                <span class="label">???</span>
                                            </label>
                                            <label class="mCheckbox1">
                                                <input type="checkbox" title="???" name="dow7UseYn" id="dow7UseYn" value="Y"   <c:if test="${cpinfo.dow7UseYn == 'Y' or cpinfo.dow7UseYn == null}"><c:out value="checked" /></c:if>>
                                                <span class="label">???</span>
                                            </label>
                                        </td>
                               		</tr>
                                    <tr>
                                    	<th scope="row" class="left">??????????????????</th>
                                        <td class="left" colspan="2">
                                             <code:commCode  className="select data-check grp01 grp02 grp03 grp04 grp05" id="useDivCd" name="useDivCd" codeCd="MB100" prefixLabel="??????" prefixValue=""  selectedValue="${cpinfo.useDivCd}"/>
                                        </td>
                                        <th scope="row" class="left">????????????</th>
                                        <td class="left" colspan="4">
                                            <select class="select wAuto data-check" title="??????"  name="fromUseHour1" id="fromUseHour1">
                                            	<option value="">??????</option>
                                              <c:set var="start" value="00" />												
									          <c:forEach begin="0" end="23" var="idx" step="1" varStatus="i">							
									          	<fmt:formatNumber var="hh" minIntegerDigits="2" value="${idx}" type="number"/>
									          	<option value="<c:out value="${hh}" />"  <c:if test="${cpinfo.fromUseHour1 == hh or (cpinfo.fromUseHour1 == null and i.first)}"><c:out value="selected" /></c:if> ><c:out value="${hh}" /></option>
									          </c:forEach>
                                            </select>
                                            
                                            <span class="bar2">???  </span>
                                            <select class="select wAuto data-check" title="???"  name="fromUseHour2" id="fromUseHour2">
                                            	<option value="">??????</option>
                                                <c:set var="start" value="00" />												
										        <c:forEach begin="0" end="55" var="idx" step="5" varStatus="i">		
										        	<fmt:formatNumber var="mm" minIntegerDigits="2" value="${idx}" type="number"/>
										          	<option value="<c:out value="${mm}" />"   <c:if test="${cpinfo.fromUseHour2 == mm or (cpinfo.fromUseHour1 == null and i.first)}"><c:out value=" selected" /></c:if> ><c:out value="${mm}" /></option>
										        </c:forEach>
										        <option value="<c:out value="59" />"   <c:if test="${cpinfo.fromUseHour2 == 59}"><c:out value=" selected" /></c:if> >59</option>	<!-- 59????????? -->
                                            </select>
                                            <span class="bar2">???</span>
                                            
                                             ~
                                               
                                            <select class="select wAuto data-check" title="??????"  name="toUseHour1" id="toUseHour1">
                                            	<option value="">??????</option>
                                              <c:set var="start" value="00" />												
									          <c:forEach begin="0" end="23" var="idx" step="1" varStatus="i">
									          	<fmt:formatNumber var="hh" minIntegerDigits="2" value="${idx}" type="number"/>
									          	<option value="<c:out value="${hh}" />"   <c:if test="${cpinfo.toUseHour1 == hh or (cpinfo.toUseHour1 == null and i.last)}"><c:out value="selected" /></c:if> ><c:out value="${hh}" /></option>							
									          </c:forEach>
                                            </select>
                                            
                                            <span class="bar2">???  </span>
                                            <select class="select wAuto data-check" title="???"  name="toUseHour2" id="toUseHour2">
                                            	<option value="">??????</option>
                                                <c:set var="start" value="00" />												
									          <c:forEach begin="0" end="55" var="idx" step="5" varStatus="i">		
									          	<fmt:formatNumber var="mm" minIntegerDigits="2" value="${idx}" type="number"/>
									          	<option value="<c:out value="${mm}" />"   <c:if test="${cpinfo.toUseHour2 == mm or (cpinfo.toUseHour2 == null and i.last)}"><c:out value=" selected" /></c:if> ><c:out value="${mm}" /></option>
									          </c:forEach>
									          <option value="<c:out value="59" />"   <c:if test="${cpinfo.toUseHour2 == 59 or (cpinfo.toUseHour2 == null)}"><c:out value=" selected" /></c:if> >59</option>  <!-- 59????????? -->
                                            </select>
                                            <span class="bar2">???</span>
                                            
                                            
                                        </td>
                                    </tr>
                                    <tr>
                                    	<th scope="row" class="left">???????????? ??????</th>
                                        <td class="left" colspan="4">
                                            <div class="mFlex2">
                                                <span class="flex w1">
                                                    <input type="text" class="it right w40 data-check"   data-type="number"   maxlength="5"  name="applyCnt" id="applyCnt" value="${cpinfo.applyCnt eq null? '0':cpinfo.applyCnt}">
                                                    <span class="bar2">???</span>
                                                </span>
                                                <span class="flex">
                                                    <input type="text" class="it data-check grp03"  name="godsNm" id="godsNm" value="${cpinfo.godsNm}" placeholder="????????????">
                                                    <input type="hidden" class="it data-check grp03"  class="it "  name="prsnttnGodsCd" id="prsnttnGodsCd" value="${cpinfo.prsnttnGodsCd}">
                                                </span>
                                            </div>
                                        </td>
                                        <th scope="row" class="left" colspan="3"></th>
                                    </tr>
                                    <tr>
                                    	<th scope="row" class="left">??????????????????</th>
                                        <td colspan="4">
                                            <div class="mFlex2">
                                                <span class="flex">
                                                
                                                	<label class="mCheckbox1">
		                                                <input type="checkbox" title="????????????????????????"  name="useStdDayCondCd" id="useStdDayCondCd" value="Y"  onclick="cpnUseDateChk()" <c:if test="${cpinfo.useStdDayCondCd == 'Y'}"><c:out value="checked" /></c:if> >
		                                                <span class="label">????????? ??????</span>
		                                            </label>
		                                            
                                                </span>
                                                <input type="text" class="it center w35" title="???" name="coupnUsePossDay" id="coupnUsePossDay"  data-type="number"  maxlength="8"  <c:if test="${cpinfo.useStdDayCondCd != 'Y'}"><c:out value="disabled" /></c:if>   value="${cpinfo.coupnUsePossDay}">
                                                <span class="bar2">???</span>
                                                <div class="mDate1">
                                                    <input type="text" class="it "  data-type="dateRangeStart" data-range-end="toUseStdDay"  title="???????????? ?????????"  name="fromUseStdDay" id="fromUseStdDay"   <c:if test="${cpinfo.useStdDayCondCd == 'Y'}"><c:out value="disabled" /></c:if>  value="${cpinfo.fromUseStdDay}">
                                                    <span class="bar">~</span>
                                                    <input type="text" class="it " title="???????????? ????????????" name="toUseStdDay" id="toUseStdDay"    <c:if test="${cpinfo.useStdDayCondCd == 'Y'}"><c:out value="disabled" /></c:if>    value="${cpinfo.toUseStdDay}">
                                                </div>
                                            </div>
                                        </td>
                                        <th scope="row" class="left">??????????????????</th>
                                        <td colspan="2">
                                            <div class="mFlex2">
                                                <label class="mCheckbox1">
                                                    <input type="checkbox" title="????????????" name="giftPossYn" id="giftPossYn" value="Y"   <c:if test="${cpinfo.giftPossYn == 'Y'}"><c:out value="checked" /></c:if> >
                                                    <span class="label">????????????</span>
                                                </label>
                                            </div>
                                        </td>
                                    </tr>

                                </tbody>
                            </table>
                        </div>
                        

                        <div class="gTitle1 line">
                            <h3 class="mTitle1">????????????</h3>
                        </div>
                        <div class="mBoard2">
                            <table>
                                <caption>????????????</caption>
                                <colgroup>
                                    <col width="11%">
                                    <col width="20%">
                                    <col width="11%">
                                    <col width="*">
                                </colgroup>
                                <tbody>
                                    <tr>
                                        <th scope="row" class="left">????????????</th>
                                        <td class="left">
                                            <label class="mRadio1 type2 fs12">
                                                <input type="radio"  title=??????"   class=" "  data-type="number" name="admtMethCd" id="admtMethCd" value="001" onclick="$('#admtAmt').val('')" <c:if test="${cpinfo.admtMethCd == '001'}"><c:out value="checked" /></c:if>>
                                                <span class="label">??????</span>
                                            </label>
                                            <label class="mRadio1 type2 fs12">
                                                <input type="radio"  title="??????"   class=" "  data-type="number" name="admtMethCd" id="admtMethCd" value="002"  onclick="$('#admtAmt').val('')"  <c:if test="${cpinfo.admtMethCd == '002'}"><c:out value="checked" /></c:if>>
                                                <span class="label">??????</span>
                                            </label>
                                        </td>
                                        <th scope="row" class="left">????????????</th>
                                        <td class="left">
                                            <input type="text" class="it right w80 data-check comma" onkeyup="chkAmt(this);" title="????????????"  data-type="number2"  maxlength="14"   name="admtAmt" id="admtAmt" value="${cpinfo.admtAmt}">
                                            <span class="tx">???/%</span>
                                            <span class="txtRed">* ???????????????</span>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        
                        <div class="gTitle1 line">
                            <h3 class="mTitle1">??????</h3>
                        </div>
                        <div class="mBoard2">
                            <table>
                                <caption>??????</caption>
                                <colgroup>
                                    <col width="10%">
                                    <col width="*">
                                </colgroup>
                                <tbody>
                                    <tr>
                                        <th scope="row" class="left">??????</th>
                                        <td class="left">
                                        	<input type="text" class="it data-check"  name="coupnRmark" id="coupnRmark" value="${cpinfo.coupnRmark}" placeholder="??????">
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                       
                 <div class="button posRt" style="float:right">
                 
						<%-- <code:btnGroup name="Coupon" gridId="grdDetail"  hideExcel="true"/> --%>
						
						
                        <a href="#" class="mBtn1 lGray" data-click="closeModal"  id="btnClose" >??????</a>
				
                        <a href="#" class="mBtn1 lGray " data-click="delCoupon"  id="btnDel" style="display:none" >??????</a>
				 		<a href="#" class="mBtn1 lPrimary"   data-click="saveCoupon" id="btnEdit" >??????</a>
                        
                        
				</div>
				
                    </div>
                    <!-- //box -->

					</form>
                </div>
                <!-- //left -->
                
                
                
                <!-- right -->
                <div class="rt">
                    
                    <!-- tab -->
                    <div class="mTab1 jsTab2">
                        <ul>
                        
                            <li class="active"><a href="#jsTabCont1_3">????????????</a></li>
                            <li><a href="#jsTabCont1_1">????????????</a></li>
                            <li><a href="#jsTabCont1_2">????????????</a></li>
                            <li><a href="#jsTabCont1_4">????????????</a></li>
                        </ul>
                    </div>
                    <!-- //tab -->
                    
                    <div id="jsTabCont1_1" class="mBox1 p10 tabCont hidden">
                    
                    
                    	 <!-- box -->
			             <form name="frmStore" id="frmStore" onsubmit="searchStoreRel();return false;">
            	
			            	<input type="hidden" name="mshipCoupnBasNo" id="mshipCoupnBasNo" value="${cpinfo.mshipCoupnBasNo}">
			            
			            
			                <!-- sort -->
			                <div class="mSort2 mini"> <!-- class="mini" => ???????????? ?????? ?????? ?????????-->
			                    <ul>
			                        <li class="wAuto ml20">
			                            <div class="tit">??????</div>
			                            <div class="txt">
			                                <code:commCode  className="select" id="distrctCd" name="distrctCd" codeCd="CU100" prefixLabel="??????" prefixValue=""/>
			                            </div>
			                        </li>
			                        <!-- <li class="wAuto ml20">
			                            <div class="tit">????????????</div>
			                            <div class="txt">
			                                <input type="text"  className="it" id="storNo" name="storNo" codeCd="MB160" />
			                            </div>
			                        </li> -->
			                        <li class="wAuto ml35">
			                            <div class="tit">?????????</div>
			                            <div class="txt">
			                                 <input type="text" class="it" name="storNm" id="storNm" value=""/>
			                            </div>
			                            <span class="button">
			                                <button type="submit" class="mBtn1 btnSubmit"  data-file-info="button" data-click="searchStoreRel" >??????</a>
			                            </span>
			                        </li>
			                    </ul>
			                    <div class="button posRt"> <!-- ?????? ?????? : class="posRt" -->
			                        <a href="#" data-grid-id="grdShopList" data-disp-name="" data-click="saveStorePop" id="btnSaveStore" class="mBtn1 m lWhite" style="cursor: pointer;">??????</a>
			                    </div>
			                </div>
			                
			                </form>
			                <!-- //sort -->
			                
			                 <div id="divShop" style="height:540px"
								  data-post="Y"
								  data-grid-id="grdShopList"
								  data-pagenation="Y"
								  data-get-url="<c:url value='/crmMshipApplyStorRel/getList'/>"
								  data-type="grid" 
								  data-tpl-url="<c:url value='/static/gridTemplate/memship/crmMshipApplyStorRel.xml'/>"
							  >
							</div>
			            
			              <!-- //box -->
			              
			              
                    </div>
                    
                    <div id="jsTabCont1_2" class="mBox1 p10 tabCont hidden">
                    	 <!-- box -->
			             <form name="frmGods" id="frmGods" onsubmit="searchGodsRel();return false;">
            	
			            	<input type="hidden" name="mshipCoupnBasNo" id="mshipCoupnBasNo" value="${cpinfo.mshipCoupnBasNo}">
			            
			            
			                <!-- sort -->
			                <div class="mSort2 mini"> <!-- class="mini" => ???????????? ?????? ?????? ?????????-->
			                    <ul>
			                        <li class="wAuto ml20">
			                            <div class="tit">?????????</div>
			                            <div class="txt">
			                                <select class="select ml20" id="godsTypeCd" name="godsTypeCd">
											   <option value="">??????????????????.</option>
											     <c:forEach var="item" items="${godsLclss}">
											     	<option value="${item.godsLclssCd}">${item.godsLclssCdNm}</option>
											    </c:forEach>
											 </select>
			                            </div>
			                        </li>
			                    
			                        <li class="wAuto ml35">
			                            <div class="tit">?????????</div>
			                            <div class="txt">
			                                 <input type="text" class="it" name="godsNm" id="godsNm" value=""/>
			                            </div>
			                            <span class="button">
			                                <button type="submit" class="mBtn1 btnSubmit"  data-file-info="button" data-click="searchGodsRel" >??????</a>
			                            </span>
			                        </li>
			                    </ul>
			                    <div class="button posRt"> <!-- ?????? ?????? : class="posRt" -->
			                        <a href="#" data-grid-id="grdGods" data-disp-name="" data-click="saveGodsPop" id="btnSaveGodsDetail" class="mBtn1 m lWhite" style="cursor: pointer;">??????</a>
			                    </div>
			                </div>
			                
			                </form>
			                <!-- //sort -->
			                
			                 <div id="divGods" style="height:540px"
								  data-post="Y"
								  data-grid-id="grdGodsList"
								  data-pagenation="Y"
								  data-get-url="<c:url value='/crmMshipCoupnBas/getGodsRelList'/>"
								  data-type="grid" 
								  data-tpl-url="<c:url value='/static/gridTemplate/memship/crmMshipApplyGodsRel.xml'/>"
							  >
							</div>
			            
			              <!-- //box -->
                    </div>
                    
                    <div id="jsTabCont1_3" class="mBox1 p10 tabCont ">
                   
								 <!-- box -->
			             <form name="frmChl" id="frmChl" onsubmit="searchChlRel();return false;">
            	
			            	<input type="hidden" name="mshipCoupnBasNo" id="mshipCoupnBasNo" value="${cpinfo.mshipCoupnBasNo}">
			            
			            
			                <!-- sort -->
			                <div class="mSort2 mini"> <!-- class="mini" => ???????????? ?????? ?????? ?????????-->
			                    <ul>
			                       
			                        <li class="wAuto ml35">
			                            <div class="tit">??????</div>
			                            <div class="txt">
			                                  <code:commCode  className="select" id="applyChlCd" name="applyChlCd" codeCd="ST040" prefixLabel="??????" prefixValue=""/>
			                            </div>
			                            <span class="button">
			                                <button type="submit" class="mBtn1 btnSubmit"  data-file-info="button" data-click="searchChlRel" >??????</a>
			                            </span>
			                        </li>
			                    </ul>
			                    <div class="button posRt"> <!-- ?????? ?????? : class="posRt" -->
			                        <a href="#" data-grid-id="grdChlList" data-disp-name="" data-click="saveChlPop" id="btnSaveChl" class="mBtn1 m lWhite" style="cursor: pointer;">??????</a>
			                    </div>
			                </div>
			                
			                </form>
			                <!-- //sort -->
			                
			                    <div id="divChl" style="height:540px"
								  data-post="Y"
								  data-grid-id="grdChlList"
								  data-pagenation="Y"
								  data-get-url="<c:url value='/crmMshipApplyStorRel/getChlRelList'/>"
								  data-type="grid" 
								  data-tpl-url="<c:url value='/static/gridTemplate/memship/crmMshipApplyChlRel.xml'/>"
							  >
							</div>
			            
			              <!-- //box -->
			              
						 </div>
						 
						<div id="jsTabCont1_4" class="mBox1 p10 tabCont hidden">
						

							<form name="frmCpn" id="frmCpn" >
            	
			            	<input type="hidden" name="mshipCoupnBasNo" id="mshipCoupnBasNo" value="${cpinfo.mshipCoupnBasNo}">
			            
			            
			                <!-- sort -->
			                <div class="mSort2 mini"> <!-- class="mini" => ???????????? ?????? ?????? ?????????-->
			                    <ul>
			                        <li class="wAuto ">
			                           <%--  <div class="tit w80">???????????????</div>
			                            <div class="txt">
			                               <code:commCode  className="select" id="coupnTypeCd" name="coupnTypeCd" codeCd="MB080" prefixLabel="??????" prefixValue=""/>
			                            </div>
			                            
			                            <div class="tit w80">??????????????????</div>
			                            <div class="txt">
			                                <code:commCode  className="select" id="coupnClassCd" name="coupnClassCd" codeCd="MB120" prefixLabel="??????" prefixValue=""/>
			                            </div>
			                            
			                            <div class="tit w80">????????????</div>
			                            <div class="txt">
			                                <code:commCode  className="select" id="coupnTgtCd" name="coupnTgtCd" codeCd="MB100" prefixLabel="??????" prefixValue=""/>
			                            </div>
			                            
			                                 <div class="tit w100">?????????????????????</div>
			                            <div class="txt">
			                                <code:commCode  className="select" id="useYn" name="useYn" codeCd="S010" prefixLabel="??????" prefixValue=""/>
			                            </div> --%>
			                            <div class="tit">??????????????????</div>
			                            <div class="txt">
			                                 <input type="text" class="it" title="??????????????????" name="coupnPblsBasNo" id="coupnPblsBasNo"   value="">
			                            </div>
			                            <div class="tit">??????????????????</div>
			                            <div class="txt">
			                                 <input type="text" class="it" title="??????????????????" name="itgCustNo" id="itgCustNo"   value="">
			                            </div>
			                            <div class="tit">?????????</div>
			                            <div class="txt">
			                                 <input type="text" class="it" title="?????????" name="custNm" id="custNm"   value="">
			                            </div>
			                        	<div class="tit">????????????</div>
			                            <div class="txt">
			                                 <input type="text" class="it" title="????????????" name="mphonNo" id="mphonNo"   value="">
			                            </div>
			                        </li>
			                        
			                   
			                    </ul>
			                    
			                    
			                     <ul>
			                        <li class="wAuto ml20">
			                       <%-- 
			                            <div class="tit">??????????????????</div>
			                            <div class="txt">
			                                 <input type="text" class="it" title="??????????????????" name="coupnBasNm" id="coupnBasNm"   value="">
			                            </div>
			                            
			                            <div class="tit">????????????</div>
			                            <div class="txt">
			                                <code:commCode  className="select" id="coupnTgtCd" name="coupnTgtCd" codeCd="MB100" prefixLabel="??????" prefixValue=""/>
			                            </div> --%>
			                            
			                            <div class="tit">??????????????????</div>
			                            <div class="txt">
			                               <input type="text" class="it w80" title="?????? ?????????"  data-type="dateRangeStart" data-range-end="toRegDt"  data-button="Y"  name="fromRegDt" id="fromRegDt" value="">
                                    
					                            <span class="bar">~</span>
									                        
											<input type="text" class="it  w80" title="?????? ????????????" name="toRegDt" id="toRegDt" data-button="Y"  value="">
			                            </div>
			                         
			                        </li>
			                        
			                         <li class="wAuto ml20">
			                            <div class="tit">??????????????????</div>
			                            <div class="txt">
			                               <input type="text" class="it w80" title="?????? ?????????"  data-type="dateRangeStart" data-range-end="toUseDt"  data-button="Y"  name="fromUseDt" id="fromUseDt" value="">
                                    
					                            <span class="bar">~</span>
									                        
											<input type="text" class="it  w80" title="?????? ????????????" name="toUseDt" id="toUseDt" data-button="Y"  value="">
			                            </div>
			                            
			                          
			                            <span class="button">
			                                <button type="submit" class="mBtn1 btnSubmit"  data-file-info="button" data-click="searchCpn" >??????</a>
			                            </span>
			                        </li>
			                            <a href="#" data-click="excelDownload" id="excelDownload" class="mBtn1 m lPrimary">????????????</a>
			                    </ul>
			                    
			                    
			                    
			                    
			                    <!-- <div class="button posRt"> ?????? ?????? : class="posRt"
			                        <a href="#" data-grid-id="grdGods" data-disp-name="" data-click="saveGodsList" id="btnSaveGodsDetail" class="mBtn1 m lWhite" style="cursor: pointer;">??????</a>
			                    </div> -->
			                </div>
			                
			                </form>
			                <!-- //sort -->
			                
			                    <div id="divCpn" style="height:509px"
								  data-post="Y"
								  data-grid-id="grdCpnList"
								  data-pagenation="Y"
								  data-get-url="<c:url value='/crmMshipCardBasList/getCpnList'/>"
								  data-type="grid" 
								  data-block-ui="Y"
								  data-scroll-x="Y"
								  data-tpl-url="<c:url value='/static/gridTemplate/memship/crmCoupnPblsHst.xml'/>"
								  >
								</div>
			                
			                
						</div> 
                </div>
                <!-- //right -->
	</div>
	
</div>



<script>
var _current_code_cd = null;

/* ?????? ?????? */
window.onload = function(){
/* 	$("#btnInsert").hide();
	$("#btnUpdate").hide();
	$("#btnDelete").hide(); */
	
	dateSetting();
	
	var applyMshpGradeCtnts = "${cpinfo.applyMshpGradeCtnts}";
	Utilities.setChkboxData("applyMshpGradeCtnts", "MB020", "mCheckbox1", applyMshpGradeCtnts);
	
	var mshipTypeCds = "${cpinfo.mshipTypeCds}";
	if (mshipTypeCds == '001') {
		$('#mshipTypeCds').prop("checked",true);
	} else {
		$('#mshipTypeCds').prop("checked",false);
	}
	
	// ????????? ????????? ?????????
	var url = "<c:url value='${urlPrefix}/getPartnerList${urlSuffix}'/>";
	Utilities.getAjax(url, null, true, function(data, jqXHR) {
		if (Utilities.processResult(data, jqXHR, "????????? ???????????? ???????????? ???????????????.")) {
		
			$.each( data , function(i){
				$("#cprtCmpNo").append("<option value='"+ this.cprtCmpNo +"' "+  (("${cpinfo.cprtCmpNo}" == this.cprtCmpNo) ? 'selected' : '' ) +">"+  this.cprtCmpNm +"</option>\n");
			});
			
		}
	});

}


function dateSetting(){
	var strStartDay= moment().format('YYYYMMDD');
    var strEndDay = moment().format("YYYYMMDD");
    
    $("#fromRegDt").val(strStartDay);
    $("#toRegDt").val(strEndDay);
}

/* ???????????? ?????? ???????????? */
function excelDownload() {
	var coupnBasNm = $('#frmDetail #coupnBasNm').val();
	grdCpnList.exportExcel(coupnBasNm+"_????????????.xlsx");
}

/* ???????????? ?????? ????????? */
function excelUpload() {
	grdShopList.importExcel();
}

/* ???????????? ????????? load */
function grdShopList_load(gridView, gridId) {	
	if( "${cpinfo.mshipCoupnBasNo}" != "") searchStoreRel(); // ???????????? ??????
}
/* ???????????? ????????? load */
function grdGodsList_load(gridView, gridId) {
	if( "${cpinfo.mshipCoupnBasNo}" != "") searchGodsRel();  // ???????????? ??????
}

/* ???????????? ????????? load */
function grdChlList_load(gridView, gridId) {
	if( "${cpinfo.mshipCoupnBasNo}" != "") searchChlRel();  // ???????????? ??????
}

/* ???????????? ????????? load */
function grdCpnList_load(gridView, gridId) {
	//if( "${cpinfo.mshipCoupnBasNo}" != "") searchCpn();  // ???????????? ??????
}



/* ???????????? ????????? load */
function grdDetail_load(gridView, gridId) {
	console.log("grdDetail_load");
}

/* ???????????? Row?????? ??? */
function grdShopList_rowChanged(grdList, oldRow, newRow, rowData) {
	console.log("grdShopList_rowChanged");
	if(rowData.stat == "c")
		_current_code_cd = "c";
	else
		_current_code_cd = rowData.comnCd;
	if (newRow > -1) {
	
		var param = {
			topComnCd : rowData.topComnCd,
			prntsComnCd : rowData.comnCd,
			comnCdLvlNo : Number(rowData.comnCdLvlNo) + 1,
			recordCountPerPage : 100000
		};
		if(!param.prntsComnCd)
			param.prntsComnCd = "QWERTREWQ";
		var url = "<c:url value='${urlPrefix}/getList'/>${urlSuffix}";
		//grdDetail.loadUrl(url, param);
	}
}


function onGridLoad(gridView, gridId) {
	console.log("onGridLoad");
}

/* ????????? ?????? ?????? */
function onGridCellClick(gridView, rowIndex, columnName, colIndex,
		fieldIndex) {

}

/* ????????? ?????? ?????? ?????? */
function onGridCellDblClick(gridView, rowIndex, columnName, colIndex,
		fieldIndex) {

}

function onGridRowChanged(gridView, oldRow, newRow) {

}

/* ???????????? ?????? */
function searchStoreRel() {
	if ($("#frmStore #mshipCoupnBasNo").val() != '') {
		$("form#frmStore").find("#currentPageNo").val(1);
	 	var url = "<c:url value='${urlPrefix}/getListStoreRel${urlSuffix}'/>";
		var param = Utilities.formToMap("frmStore");
		param.recordCountPerPage = 20;
		grdShopList.loadUrl(url, param);
	}
	//grdDetail.clear();
} 



/* ???????????? ?????? */
function searchGodsRel() {
	if ($("#frmGods #mshipCoupnBasNo").val() != '') {
		$("form#frmGods").find("#currentPageNo").val(1);
	 	var url = "<c:url value='${urlPrefix}/getGodsRelList${urlSuffix}'/>";
		var param = Utilities.formToMap("frmGods");
		param.recordCountPerPage = 20;
		grdGodsList.loadUrl(url, param);
	}
	//grdDetail.clear();
} 



/* ???????????? ?????? */
function searchChlRel() {
	if ($("#frmChl #mshipCoupnBasNo").val() != '') {
		$("form#frmChl").find("#currentPageNo").val(1);
	 	var url = "<c:url value='${urlPrefix}/getChlRelList${urlSuffix}'/>";
		var param = Utilities.formToMap("frmChl");
		param.recordCountPerPage = 20;
		grdChlList.loadUrl(url, param);
	}
	//grdDetail.clear();
} 

/* ???????????? ?????? */
function searchCpn() {
	var valid = validateForm("#frmCpn"); //  class='data-check' ??? ????????? ??????
	if(!valid) {
		alert("?????? ???????????? ????????? ?????????.");
		return;
	}
	
	$("form#frmCpn").find("#currentPageNo").val(1);
 	var url = "<c:url value='${urlPrefix}/getCpnList${urlSuffix}'/>";
	var param = Utilities.formToMap("frmCpn");
	if (param.mshipCoupnBasNo == '') {
		param.mshipCoupnBasNo = $('#frmSearch #mshipCoupnBasNo').val();
	}
	param.recordCountPerPage = 20;
	grdCpnList.loadUrl(url, param);
} 




function saveStorePop(){
	var url = "<c:url value='${urlPrefix}/popStore${urlSuffix}'/>?mshipCoupnBasNo="+$('#frmSearch #mshipCoupnBasNo').val();
	Utilities.openModal(url, "1200", "800");
}


function saveGodsPop(){
	var url = "<c:url value='${urlPrefix}/popGods${urlSuffix}'/>?mshipCoupnBasNo="+$('#frmSearch #mshipCoupnBasNo').val();
	Utilities.openModal(url, "1000", "800");
}


function saveChlPop(){
	var url = "<c:url value='${urlPrefix}/popChl${urlSuffix}'/>?mshipCoupnBasNo="+$('#frmSearch #mshipCoupnBasNo').val();
	Utilities.openModal(url, "1000", "800");
}


/* ?????? ?????? */
function saveCoupon(){
	
	var valid = validateForm("#frmDetail"); //  class='data-check' ??? ????????? ??????

	var saveJson = Utilities.formToMap("frmDetail");

	var fromUsePossDt = Number(saveJson.fromPblsStdDay.replaceAll("-",""));
	var toUsePossDt = Number(saveJson.toPblsStdDay.replaceAll("-",""));
	if (fromUsePossDt > toUsePossDt) {
		alert('?????????????????? ???????????? ??????????????? ????????? ????????????.');
		$('#frmDetail #toUsePossDt').val('');
		return;
	}

	var now = new Date();
	var toDay = Number(now.getFullYear()+""+("0" + (now.getMonth() + 1)).slice(-2)+""+("0"+now.getDate()).slice(-2));
	if (toUsePossDt < toDay) {
		alert('?????????????????? ???????????? ???????????? ????????????.');
		return;
	}
	
	if(valid) {
		
		if( $("#coupnKndCd").val() == "002" ){
			if( $("#applyAmt").val() > 100 ){
				alert("??????????????? 100% ????????? ????????? ??? ????????????."+ $("#applyAmt").val());
				$("#applyAmt").val(""); 
				$("#applyAmt").focus();
				return false;
			}
		}

		if( $("input[name='admtMethCd']:checked").val() == "002" ){
		 	
			if( $("#admtAmt").val() > 100 ){
				alert("??????????????? 100% ????????? ????????? ??? ????????????."+ $("#admtAmt").val());
				$("#admtAmt").val("");
				$("#admtAmt").focus();
				return false;
			}
		 	
		}

		if ($('#frmDetail #mshipCoupnBasNo').val() != '') {
			saveJson.stat = 'u'
		}
		
		if ($("#frmDetail #mshipTypeCds").is(":checked")) {
			saveJson.mshipTypeCds = '001';
		}
		
		//console.log(saveJson);
		// return;
		
		var url = "<c:url value='${urlPrefix}/saveCpn${urlSuffix}'/>";
		Utilities.getAjax(url,saveJson,true,function(data,jqXHR){
	        if(Utilities.processResult(data,jqXHR,"?????? ????????? ??????????????????."))
	        {
	            alert("?????? ????????? ?????????????????????.");
	            // console.log( Utilities.getTopWindow() );
	            // Utilities.getTopWindow().search();
    			// Utilities.getOpener().search();
	            // Utilities.closeModal();
	            $('#frmSearch #mshipCoupnBasNo').val(data.mshipCoupnBasNo);
	            $("#frmChl #mshipCoupnBasNo").val(data.mshipCoupnBasNo);
	            $('#frmStore #mshipCoupnBasNo').val(data.mshipCoupnBasNo);
	            $('#frmGods #mshipCoupnBasNo').val(data.mshipCoupnBasNo);
	            $('#frmDetail #mshipCoupnBasNo').val(data.mshipCoupnBasNo);
	            $('#frmDetail #regrId').text(data.regrId);
	            $('#frmDetail #regDt').text(data.regDt); 
	            $('#frmDetail #stat').val('u'); 
	       	 	// Utilities.closeModal();
	         	// Utilities.getOpener().search();
	            
	        }
	    });
	
	}else{
		
		alert("?????? ???????????? ????????? ?????????.");
		return false;
	}
}

function closeModal(){
	/* console.log( Utilities.getOpener().grdList.getCurrentPage());
	return ; */
	 //console.log( Utilities.getOpener().grdList.getCurrentPage());
	 Utilities.closeModal();
     Utilities.getOpener().search();
     //Utilities.getOpener().currnPg(Utilities.getOpener().grdList.getCurrentPage());
}

function applyMShipGradeSetting(data){
	if(data != null){
		Utilities.mapToForm(data, "frmMain");
		Utilities.setChkboxData("applyMshpGradeCtnts", "MB020", "mCheckbox1", data.applyMshpGradeCtnts);
	}else{
		Utilities.mapToForm(data, "frmMain");
		Utilities.setChkboxData("applyMshpGradeCtnts", "MB020", "mCheckbox1", "");
	}
}




/* ???????????? ?????? Validate*/
function saveValidate(gridView){
	var cuGridData = gridView.getSaveJson();
	for(var i=0; i<cuGridData.length; i++){
	    if(Utilities.isEmpty(cuGridData[i].comnCd)){
	    	alert("?????????????????? ???????????????.");
	    	return false;
	    }
// 	    if(Utilities.isEmpty(cuGridData[i].comnCdOdrg)||cuGridData[i].comnCdOdrg<=0){
// 	    	alert("????????? 1???????????????.");
// 	    	return false;
// 	    }
	    if(Utilities.isEmpty(cuGridData[i].comnCdNm)){
            alert("???????????? ???????????????.");
            return false;
        }
	}
	return true;
}

/* ????????? ???????????? ?????? ????????? ?????? */
function dataSetting(objJson){
	applyMShipGradeSetting(objJson);
	$("#applyMshpGradeCtnts").val(objJson.applyMshpGradeCtnts);
}


/* ????????? ??? ?????? */
function grdList_cellClick(gridView, itemIndex, column, index, field){
	var objJson = gridView.getCurrentJson();
	dataSetting(objJson);
}

/* ????????? ??? ?????? */
function grdList_checked(grid, rowKey, row, checked){
	var objJson = grid.getCurrentJson();
	dataSetting(objJson);
}

function search() {
	console.log("pop search");
}

// ????????????
$(function() {
	
	if( "${cpinfo.mshipCoupnBasNo}" != ""){
		$("#btnDel").show();
	}
    
    var url = "<c:url value='${urlPrefix}/getGodsBaseList${urlSuffix}'/>";
    $('#godsNm').autocomplete({
    	delay: 200,
    	minLength: 2,
        source : function(request, response) {
            $.ajax({
            	type : 'get',
                url: url +"?godsNm="+ $('#godsNm').val() ,
                success : function(data) {
                    // ???????????? json ????????? response ??? ?????? ??????
                    response(
                        $.map(data, function(item) {
                            return {
                                value : item.godsNm , 
                                label : item.godsNm ,
                                test : item.godsNo
                            }
                        })
                    );
                }
            });
        }
    }).autocomplete('instance')._renderItem = function(ul, item) { // UI ??????
    	
    	return $("<li>")
        .append("<div class='autocomplete-item'><div class='autocomplete-img-container'></div><div onclick=\"searchGodsBase('"+ item.label +"', '"+ item.test +"')\"> " + item.label + "</div></div>")
          .appendTo(ul);
    	
    };
    
});


// ?????? ????????? ??? ??????
function searchGodsBase(label, val){
	$("#prsnttnGodsCd").val(val);
	$("#godsNm").val(label);
}


// ?????????????????? ?????? ??????
function cpnUseDateChk(){
	
	if( $("#useStdDayCondCd").is(":checked") ){

		$("#fromUseStdDay").val("");
		$("#fromUseStdDay").attr("disabled", true);
		$("#toUseStdDay").val("");
		$("#toUseStdDay").attr("disabled", true);
		$("#coupnUsePossDay").val('');
		$("#coupnUsePossDay").attr("disabled", false);
		
	}else{
		
		$("#fromUseStdDay").val("");
		$("#fromUseStdDay").attr("disabled", false);
		$("#toUseStdDay").val("");
		$("#toUseStdDay").attr("disabled", false);
		$("#coupnUsePossDay").val('');
		$("#coupnUsePossDay").attr("disabled", true);
	}
}


//?????????????????? ??????
function cpnUseDayChk(){
	
	if( $("#coupnUsePossYn").is(":checked") ){		
		$("#coupnUsePossDayCnt").val("");
		$("#coupnUsePossDayCnt").attr("disabled", false);		
	}else{		
		$("#coupnUsePossDayCnt").val("");	
		$("#coupnUsePossDayCnt").attr("disabled", true);
	}
}


function delCoupon(){
	
	if( $.trim( $("#mshipCoupnBasNo").val() ) == "" ){
		alert("?????? ?????? ????????? ????????????.");
		return false;
	}else{
		
		
		//var deljson = "[ {'mshipCoupnBasNo' : '"+ $.trim( $("#mshipCoupnBasNo").val() ) +"'} ]";
		
		var param = {
				mshipCoupnBasNo : $.trim( $("#mshipCoupnBasNo").val() )
			};
		
		if( confirm("?????? ?????? ???????????? ????????????????????????? ?????? ??? ????????? ????????? ?????? ????????? ????????? ????????? ?????? ????????? ?????????.")){
		
			var url = "<c:url value='${urlPrefix}/delete${urlSuffix}'/>";
			Utilities.getAjax(url,param,true,function(data,jqXHR){
		        if(Utilities.processResult(data,jqXHR,"??????????????? ????????? ??????????????????."))
		        {
		        	console.log(data);
		        	if (data > 0) {
			            alert("?????????????????? ?????????????????????.");
			            Utilities.getOpener().search();
			            Utilities.closeModal();
				        // Utilities.getTopWindow().search();
		        	} else {
		        		alert("????????? ????????? ????????? ?????? ????????? ?????????.");
		        	}
		        }
		    });
		
		}
		
		return false;
		
	}
	
}

// ?????????????????? ??????
function cpnIssue(){
	
	var url = "<c:url value='${urlPrefix}/cpnIssue${urlSuffix}'/>?mshipCoupnBasNo="+$('#frmSearch #mshipCoupnBasNo').val();
	Utilities.openModal(url, "900", "700");
	
}


//?????????????????? ??????
function cpnStoreIssue(){
	
	var url = "<c:url value='${urlPrefix}/cpnStoreIssue${urlSuffix}'/>?mshipCoupnBasNo="+$('#frmSearch #mshipCoupnBasNo').val();
	Utilities.openModal(url, "500", "400");
	
}

// ?????? ?????? ?????? ??????
function chkCnt( obj ){
	if( $(obj).val() != "002"){
		$("#issueRstrtnCnt").val("");
		$("#issueRstrtnCnt").attr("disabled", true);
	}else{
		$("#issueRstrtnCnt").val("");
		$("#issueRstrtnCnt").attr("disabled", false);
	}
}

// ???????????? ??????
function chkAmt(obj){	
	
	if( $("input[name='admtMethCd']:checked").val() == "002" ){
	 	
		if( $(obj).val() > 100 ){
			alert("??????????????? 100% ????????? ????????? ??? ????????????.");
			$(obj).val(""); 
		}
	 	
	}

}

function chkApplyAmt(obj){	
	if( $("#coupnKndCd").val() == "002" ){
		if( $(obj).val() > 100 ){
			alert("??????????????? 100% ????????? ????????? ??? ????????????.");
			$(obj).val(""); 
		}
	}
}


$(document).ready(function(){
	
	// ????????? ????????? ?????????
	/* var url = "<c:url value='${urlPrefix}/getPartnerList${urlSuffix}'/>";
	Utilities.getAjax(url, null, true, function(data, jqXHR) {
		if (Utilities.processResult(data, jqXHR, "????????? ???????????? ???????????? ???????????????.")) {
		
			$.each( data , function(i){
				$("#cprtCmpNo").append("<option value='"+ this.cprtCmpNo +"' "+  (("${cpinfo.cprtCmpNo}" == this.cprtCmpNo) ? 'selected' : '' ) +">"+  this.cprtCmpNm +"</option>\n");
			});
			
		}
		
		chkGrade( "#mshipGradeCd" );
		
	}); */
	
	chkUse();
	
	$(".mshipGrp").val("");
	//$(".mshipGrp").attr("disabled", true);
	// $("#cprtCmpNo").attr("disabled", true);
	
	// ????????? ????????? ?????? ????????????
	if( "${cpinfo.coupnTgtCd}" == "002" ){
		$(".mshipGrp").val("");
		$(".mshipGrp").attr("disabled", true);
	}
	
	// mshipTypeCds  // cprtCmpNo // coupnTgtCd
	$('#mshipTypeCds').click(function(){
		if ($('#coupnTgtCd').val() == '002') {
			$('#mshipTypeCds').prop("checked",false);
			$("#cprtCmpNo").val('');
		} 
	});

});

function chkGrade(obj){
	
	//cardTypeCd  mshipGradeApplyCtnts cprtCmpNo
	
	if( $(obj).val() == "" ){
		$("#frmDetail #mshpGradeCd").attr("disabled", true);
		$("#frmDetail #cprtCmpNo").attr("disabled", true);
		
		$("#frmDetail #mshpGradeCd").val("");
		$("#frmDetail #cprtCmpNo").val("");		
	}
	
	if( $(obj).val() == "001" ){
		$("#frmDetail #mshpGradeCd").attr("disabled", true);
		$("#frmDetail #cprtCmpNo").attr("disabled", true);	
		
		$("#frmDetail #mshpGradeCd").val("");
		$("#frmDetail #cprtCmpNo").val("");			
	}
	
	if( $(obj).val() == "002" ){

		$("#frmDetail #mshpGradeCd").attr("disabled", true);
		$("#frmDetail #cprtCmpNo").attr("disabled", false);	
		
		$("#frmDetail #mshpGradeCd").val("");
	}
	
	if( $(obj).val() == "003" ){

		$("#frmDetail #mshpGradeCd").attr("disabled", false);
		$("#frmDetail #cprtCmpNo").attr("disabled", true);	
		

		$("#frmDetail #cprtCmpNo").val("");	
	}
	
}

function chkUse(){
	
	var useVal = $("#coupnKndCd").val();
	
	// ?????? ????????? ??????
		
	$("#useDivCd").attr("disabled", true);
	$("#applyAmt").attr("disabled", true);
	$("#applyRate").attr("disabled", true);
	$("#applyPoint").attr("disabled", true);
	// $("#applyCnt").attr("disabled", true);
	$("#godsNm").attr("disabled", true);
	$("#prsnttnGodsCd").attr("disabled", true);
	$("#minBuyAmt").attr("disabled", true);
	$("#maxDcAmt").attr("disabled", true);
	/*
	$("#fromUseHour1").attr("disabled", true);
	$("#fromUseHour2").attr("disabled", true);
	$("#toUseHour1").attr("disabled", true);
	$("#toUseHour2").attr("disabled", true); 
	*/
	
	if( useVal == "001" ){
		$(".grp01").attr("disabled", false);
	}
	
	if( useVal == "002" ){
		$(".grp02").attr("disabled", false);
	}
	
	if( useVal == "003" ){
		$(".grp03").attr("disabled", false);
	}
	
	if( useVal == "004" ){
		$(".grp04").attr("disabled", false);
	}
		
	if( useVal == "005" ){
		$(".grp05").attr("disabled", false);
	}
	
	
	$.each( $("#frmDetail").find('input, select, checkbox'), function(j){

		if( typeof( $(this).attr("disabled") ) == "string" ){
			$(this).val("");
		}
		
	});
	
}


function chkCoupnTgtCd(obj){
	if( $(obj).val() == "002" ){
		$(".mshipGrp").val("");
		$(".mshipGrp").attr("disabled", true);
		$('#mshipTypeCds').prop("checked",false);
	} else {
		$(".mshipGrp").val("");
		$(".mshipGrp").attr("disabled", false);
	}
}

</script>



