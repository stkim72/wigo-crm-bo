<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="code" uri="/WEB-INF/tlds/ezTagLib.tld"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>



<div class="mPopup1">
	<!-- header -->
	<div class="title">
		<h1>캠페인 상세</h1>
		<a href="#" data-click="closeModal" class="close">팝업 닫기</a>
	</div>
	<!-- //header -->

	<!-- cont -->
	<div class="cont">


		<form role="form" id="frmDetail" name="frmDetail">

			<input type="hidden" id="stat" name="stat" value="${addMode}" />
			<input type="hidden" id="applyPoint" name="applyPoint" value="${cpinfo.applyPoint}" />
			<input type="hidden" id="applyPointStaYmd" name="applyPointStaYmd" value="${cpinfo.applyPointStaYmd}" />
			<input type="hidden" id="applyPointEndYmd" name="applyPointEndYmd" value="${cpinfo.applyPointEndYmd}" />
			<input type="hidden" id="applyPointValidPerd" name="applyPointValidPerd" value="${cpinfo.applyPointValidPerd}" />
			<input type="hidden" id="applyCoupnBasNo" name="applyCoupnBasNo" value="${cpinfo.applyCoupnBasNo}" />
			<input type="hidden" id="yetGrpNo" name="yetGrpNo" value="${cpinfo.applyGrpNo}" />
			<input type="hidden" id="applyGrpNo" name="applyGrpNo" value="${cpinfo.applyGrpNo}" />
			<input type="hidden" id="dspCtntTypeNo" name="dspCtntTypeNo" value="${cpinfo.dspCtntTypeNo}" />
			<input type="hidden" id="coupnIssueCnt" name="coupnIssueCnt" value="${cpinfo.coupnIssueCnt}" />


			<div class="gTitle1 line">
				<h3 class="mTitle1">기본정보</h3>
				<div class="gRt">
				
				 <c:if test="${addMode == 'U'}">
				 
				 	<c:if test="${cpinfo.campStatusCd == '001' }">
					<a href="#" class="mBtn1 lWhite" onclick="statusChk('002')">승인</a> 
					</c:if>
					
					<c:if test="${cpinfo.campStatusCd == '002' || cpinfo.campStatusCd == '003' }">
					<a href="#" class="mBtn1 lWhite" onclick="statusChk('004')">중지</a> 
					</c:if>
					
					
					<!-- <a href="#" class="mBtn1 gray">승인요청</a> -->
				</c:if>
					
					<!-- <a href="#" class="mBtn1 gray">중지요청</a>  -->
					<a href="#" class="mBtn1 primary" data-click="saveCamp" id="btnSaveCamp"><c:if test="${addMode == 'C'}">등록</c:if> <c:if test="${addMode == 'U'}">수정</c:if></a>
				</div>
			</div>
			<!-- board -->
			<div class="mBoard2">
				<table>
					<caption>기본정보</caption>
					<colgroup>
						<col width="7%">
						<col width="8%">
						<col width="4%">
						<col width="6%">
						<col width="7%">
						<col width="18%">
						<col width="8%">
						<col width="*">
						<col width="8%">
					</colgroup>
					<tbody>
						<tr>
							<th scope="row" class="left"><span class="iMust">캠페인 코드</span></th>
							<td colspan="3"><input type="text" class="it data-check must" id="campBasNo" name="campBasNo" value="${cpinfo.campBasNo}" placeholder="자동생성" readonly disabled>
							</td>
							<th scope="row" class="left">캠페인 명</th>
							<td colspan="3">
								<input type="text" class="it data-check" title="캠페인명" id="campBasNm" name="campBasNm" value="${cpinfo.campBasNm}">
							</td>
							<th scope="row" class="left">캠페인 유형</th>
							<td colspan="3">
								<div class="mFlex2">
									<span class="flex"> 
										<code:commCode className="select data-check w160" id="campTypeCd" name="campTypeCd" codeCd="CM010" prefixLabel="캠페인유형" prefixValue="" selectedValue="${cpinfo.campTypeCd}" />
									</span>
									<!--    <a href="#" class="mBtn1 m lWhite">버튼</a> -->
								</div>
							</td>
						</tr>
						<tr>
						
							<th scope="row" class="left">캠페인 형태</th>
							<td colspan="3">
								<code:commCode className="select data-check " id="campShapCd" name="campShapCd" codeCd="CM020" prefixLabel="캠페인형태" prefixValue="" selectedValue="${cpinfo.campShapCd}" others=" onchange='chkShap(this)' "/>
							</td>
							
							<th scope="row" class="left">주문 채널</th>
							<td colspan="3" class="left"><label class="mCheckbox1">
								<input type="checkbox" title="POS" class="data-check " name="ordrChlListAll" id="ordrChlListAll" onclick="cpnChlChk(this)"> <span class="label">전체</span>
							</label> 
							
							<label class="mCheckbox1"> 
								<code:commCode className="select data-check w160" id="ordrChlList" name="ordrChlList" codeCd="ST040" others=" title='주문 채널' " multiple="true" selectedValue="${cpinfo.ordrChlList}" />
							</label>							
							</td>
							
							<th scope="row" class="left">캠페인 상태</th>
							<td colspan="3" class="left">
							
								<c:choose>	
								<c:when  test="${ cpinfo.campStatusCd eq '003' }">					
									실행중 수정불가
									<input type="hidden" name="campStatusCd" id="campStatusCd" value="${cpinfo.campStatusCd}">
								</c:when>
								<c:otherwise>
								 <code:commCode className="select data-check w160" id="campStatusCd" name="campStatusCd" codeCd="CM040" prefixLabel="캠페인상태" prefixValue="" others=" title='캠페인 상태' " selectedValue="${cpinfo.campStatusCd}" />
								</c:otherwise>
								
								</c:choose>
								
							</td>
							
						</tr>

						<tr>
							<th scope="row" class="left">캠페인 기간</th>
							<td colspan="3">
								<div class="mDate1">
									<input type="text" class="it data-check date" title="캠페인 시작일" data-type="dateRangeStart" data-range-end="campEndYmd" id="campStaYmd" name="campStaYmd" value="${cpinfo.campStaYmd}" autocomplete="off" >
									<span class="bar">~</span> <input type="text" class="it data-check date" data-button="Y" id="campEndYmd" name="campEndYmd" value="${cpinfo.campEndYmd}"  autocomplete="off" >
								</div>
							</td>
							<th scope="row" class="left">발송가능시간</th>
							<td colspan="4" >
							
							<%-- <select class="select data-check w80" name="campFtgabltPlcyCd" id="campFtgabltPlcyCd" title="피로도 정책" value="${cpinfo.campFtgabltPlcyCd}">
									<option value="001">중복허용</option>
							</select> --%>
							
							
							<select class="select data-check w80" title="발송 시간" name="ftgabltStaHour" id="ftgabltStaHour">
									<option value="">선택</option>
									<c:set var="start" value="00" />
									<c:forEach begin="0" end="24" var="idx" step="1">
										<c:choose>
											<c:when test="${ (start + idx) < 10 }">
												<option value="<c:out value="0${start + idx}" />"
													<c:if test="${cpinfo.ftgabltStaHour == '0'+ (start + idx)}"><c:out value="selected" /></c:if>><c:out
														value="0${start + idx}" /></option>
											</c:when>
											<c:when test="${ (start + idx) >= 10 }">
												<option value="<c:out value="${start + idx}" />"
													<c:if test="${cpinfo.ftgabltStaHour == start + idx}"><c:out value="selected" /></c:if>><c:out
														value="${start + idx}" /></option>
											</c:when>
										</c:choose>
									</c:forEach>
							</select>시
							
							<select class="select data-check w80" title="발송 시간" name="ftgabltStaMnut" id="ftgabltStaMnut">
									<option value="">선택</option>
									<c:set var="start" value="00" />
									<c:forEach begin="0" end="50" var="idx" step="10">
										<c:choose>
											<c:when test="${ (start + idx) < 10 }">
												<option value="<c:out value="0${start + idx}" />"
													<c:if test="${cpinfo.ftgabltStaMnut == '0'+ (start + idx)}">selected</c:if>><c:out value="0${start + idx}" /></option>
											</c:when>
											<c:when test="${ (start + idx) >= 10 }">
												<option value="<c:out value="${start + idx}" />"
													<c:if test="${cpinfo.ftgabltStaMnut == start + idx}">selected</c:if>>${start + idx}</option>
											</c:when>
										</c:choose>
									</c:forEach>
							</select>분
							
							<select class="select data-check w80" title="발송 시간" name="ftgabltEndHour" id="ftgabltEndHour">
									<option value="">선택</option>
									<c:set var="start" value="00" />
									<c:forEach begin="0" end="24" var="idx" step="1">
										<c:choose>
											<c:when test="${ (start + idx) < 10 }">
												<option value="<c:out value="0${start + idx}" />"
													<c:if test="${cpinfo.ftgabltEndHour == '0'+ (start + idx)}"> selected</c:if>><c:out
														value="0${start + idx}" /></option>
											</c:when>
											<c:when test="${ (start + idx) >= 10 }">
												<option value="<c:out value="${start + idx}" />"
													<c:if test="${cpinfo.ftgabltEndHour == start + idx}"> selected</c:if>><c:out
														value="${start + idx}" /></option>
											</c:when>
										</c:choose>
									</c:forEach>
							</select> 시
							
							<select class="select data-check w80" title="발송 시간" name="ftgabltEndMnut" id="ftgabltEndMnut">
									<option value="">선택</option>
									<c:set var="start" value="00" />
									<c:forEach begin="0" end="50" var="idx" step="10">
										<c:choose>
											<c:when test="${ (start + idx) < 10 }">
												<option value="<c:out value="0${start + idx}" />"
													<c:if test="${cpinfo.ftgabltEndMnut == '0'+ (start + idx)}"> selected</c:if>><c:out
														value="0${start + idx}" /></option>
											</c:when>
											<c:when test="${ (start + idx) >= 10 }">
												<option value="<c:out value="${start + idx}" />"
													<c:if test="${cpinfo.ftgabltEndMnut == start + idx}"> selected</c:if>><c:out
														value="${start + idx}" /></option>
											</c:when>
										</c:choose>
									</c:forEach>
							</select> 분
							
							
							
							
							</td>
							<th scope="row" class="left">전체 예산</th>
							<td colspan="2">
								<div class="mFlex2 w160">
									<span class="flex"> 
									
									<input type="text" class="it data-check right number2 comma" data-type="number2" title="전체 예산" maxlength="11" id="wholeBdgetAmt" name="wholeBdgetAmt" value="${cpinfo.wholeBdgetAmt}">
									
									</span> 
									
									<span class="bar">원</span>
								</div>
							</td>
							
						</tr>
						
						
						
					   <% //1차 캠페인이 있을 경우 2차 캠페인 등록 가능  %>	
						<c:if test="${cpinfo.campBasNo ne null}">
						
						<tr>
							<th scope="row"  class="center">2차 캠페인<br>(반응)</th>
							<td colspan="3">
								<div class="mFlex2 w240">
									<span class="flex"> 
										<input type="text" class="it  right" title="2차 캠페인(반응)" id="lowRspnCampNo" name="lowRspnCampNo" value="${cpinfo.lowRspnCampNo}" />
									</span> <a href="#" class="mBtn1 m lWhite btnCamp2" onclick="newCampain2('Y')"><c:if test="${cpinfo.lowRspnCampNo ne null}">수정</c:if><c:if test="${cpinfo.lowRspnCampNo eq null}">등록</c:if></a>
								</div>
							</td>
							<th scope="row" class="center" >2차 캠페인<br>(미반응)</th>
							<td colspan="2">
								<div class="mFlex2 w240">
									<span class="flex"> 
										<input type="text" class="it  right" title="2차 캠페인(미반응)" id="lowRspnDnaCampNo" name="lowRspnDnaCampNo" value="${cpinfo.lowRspnDnaCampNo}" />
									</span> <a href="#" class="mBtn1 m lWhite btnCamp2" onclick="newCampain2('N')" ><c:if test="${cpinfo.lowRspnDnaCampNo ne null}">수정</c:if><c:if test="${cpinfo.lowRspnDnaCampNo eq null}">등록</c:if></a>
								</div>
							</td>
							
							
							<th scope="row" class="center" >등록일</th>
							<td colspan="2">
								<div class="mFlex2 ">
									<span class="flex"> 
										<input type="text" class="it  right"  id="regDt" name="regDt" readonly value="${cpinfo.regDt}" />
									</span>
								</div>
							</td>
							
							<th scope="row" class="center" >등록자</th>
							<td >
								<div class="mFlex2 ">
									<span class="flex"> 
										<input type="text" class="it  right" id="regrId" name="regrId" readonly value="${cpinfo.regrId}" />
									</span>
								</div>
							</td>
						</tr>
						
						</c:if>
						
						
						<tr>

							<th scope="row" class="left">반복주기</th>
							<td>
							
							<code:commCode className="select data-check w100" id="rpeatCd" name="rpeatCd" codeCd="CM050" prefixLabel="선택" prefixValue="" others=" onchange='chkCycle(this);'"  selectedValue="${cpinfo.rpeatCd}" />
						</td>


							<th scope="row" class="left">반복 월</th>
							<td><select class="select data-check w120 cyclegrp001 " name="rpeatMonth" id="rpeatMonth" disabled>
									<option value="">선택</option>
									<c:forEach begin="1" end="12" var="idx" step="1">
										<option value="<c:out value="${idx}" />"
											<c:if test="${cpinfo.rpeatMonth == idx}"><c:out value="selected" /></c:if>><c:out
												value="${idx}" />월
										</option>
									</c:forEach>
							</select></td>



							<th scope="row" class="left">반복 일</th>
							<td>
							
							<select class="select data-check w80 cyclegrp001  " name="rpeatDay" id="rpeatDay" disabled>
									<option value="">선택</option>
									<c:set var="start" value="1" />
									<c:forEach begin="0" end="29" var="idx" step="1">
										<c:choose>
											<c:when test="${ (start + idx) < 10 }">
												<option value="<c:out value="0${start + idx}" />"
													<c:if test="${cpinfo.rpeatDay == '0'+ (start + idx)}"><c:out value="selected" /></c:if>><c:out
														value="0${start + idx}" />일
												</option>
											</c:when>
											<c:when test="${ (start + idx) >= 10 }">
												<option value="<c:out value="${start + idx}" />"
													<c:if test="${cpinfo.rpeatDay == start + idx}"><c:out value="selected" /></c:if>><c:out
														value="${start + idx}" />일
												</option>
											</c:when>
										</c:choose>
									</c:forEach>
							</select></td>
							<th scope="row" class="left">반복 요일</th>
							<td colspan="3" class="left"><label class="mCheckbox1">
									<input type="checkbox" title="월" class="cyclegrp001 cyclegrp003 cyclegrp004 dowUse" name="dow1UseYn" id="dow1UseYn" value="Y" disabled
									<c:if test="${cpinfo.dow1UseYn == 'Y'}"><c:out value="checked" /></c:if>>
									<span class="label">월</span>
							</label> 
							
							<label class="mCheckbox1"> 
							<input type="checkbox" title="화" class="cyclegrp001 cyclegrp003 cyclegrp004 dowUse" name="dow2UseYn" id="dow2UseYn" value="Y" disabled
									<c:if test="${cpinfo.dow2UseYn == 'Y'}"><c:out value="checked" /></c:if>>
									<span class="label">화</span>
							</label> 
							
							<label class="mCheckbox1"> 
							<input type="checkbox" title="수" class="cyclegrp001 cyclegrp003 cyclegrp004 dowUse" name="dow3UseYn" id="dow3UseYn" value="Y" disabled
									<c:if test="${cpinfo.dow3UseYn == 'Y'}"><c:out value="checked" /></c:if>>
									<span class="label">수</span>
							</label> 
							
							<label class="mCheckbox1"> 
							<input type="checkbox"
									title="목" class="cyclegrp001 cyclegrp003 cyclegrp004 dowUse" name="dow4UseYn" id="dow4UseYn" value="Y" disabled
									<c:if test="${cpinfo.dow4UseYn == 'Y'}"><c:out value="checked" /></c:if>>
									<span class="label">목</span>
							</label> 
							
							<label class="mCheckbox1"> <input type="checkbox"
									title="금" class="cyclegrp001 cyclegrp003 cyclegrp004 dowUse" name="dow5UseYn" id="dow5UseYn" value="Y" disabled
									<c:if test="${cpinfo.dow5UseYn == 'Y'}"><c:out value="checked" /></c:if>>
									<span class="label">금</span>
							</label> 
							
							<label class="mCheckbox1"> <input type="checkbox"
									title="토" class="cyclegrp001 cyclegrp003 cyclegrp004 dowUse" name="dow6UseYn" id="dow6UseYn" value="Y" disabled
									<c:if test="${cpinfo.dow6UseYn == 'Y'}"><c:out value="checked"/></c:if>>
									<span class="label">토</span>
							</label> 
							
							<label class="mCheckbox1"> <input type="checkbox"
									title="일" class="cyclegrp001 cyclegrp003 cyclegrp004 dowUse" name="dow7UseYn" id="dow7UseYn" value="Y" disabled
									<c:if test="${cpinfo.dow7UseYn == 'Y'}"><c:out value="checked" /></c:if>>
									<span class="label">일</span>
							</label>
							
							</td>


							<th scope="row" class="left">발송 시간</th>
							<td>
							
							<select class="select data-check w80" title="발송 시간" name="dspHour" id="dspHour" onchange="chkDspHour(this)">
									<option value="">선택</option>
									<c:set var="start" value="00" />
									<c:forEach begin="0" end="24" var="idx" step="1">
										<c:choose>
											<c:when test="${ (start + idx) < 10 }">
												<option value="<c:out value="0${start + idx}" />"
													<c:if test="${cpinfo.dspHour == '0'+ (start + idx)}"><c:out value="selected" /></c:if>><c:out
														value="0${start + idx}" /></option>
											</c:when>
											<c:when test="${ (start + idx) >= 10 }">
												<option value="<c:out value="${start + idx}" />"
													<c:if test="${cpinfo.dspHour == start + idx}"><c:out value="selected" /></c:if>><c:out
														value="${start + idx}" /></option>
											</c:when>
										</c:choose>
									</c:forEach>
							</select>
							
							</td>


						</tr>
					</tbody>
				</table>
			</div>
			<!-- //board -->

			<div class="gTitle1 line">
				<h3 class="mTitle1">캠페인 대상</h3>
				<div class="gRt">
					<!-- <a href="#" class="mBtn1 gray" data-click="popTarget">캠페인 대상군 추가</a> -->
				</div>
			</div>
			<!-- list -->
			<div class="mList1">
				<ul>
					<li>
						<div class="tit">혜택</div>
						
						<div class="txt">
							<div class="txtBg"  id="bnfitInfo" style="line-height:20px">
									
									
									<c:if test="${cpinfo.applyPoint ne null and cpinfo.applyPoint ne '' and cpinfo.applyPoint ne '0'}">
										<fmt:formatNumber value="${cpinfo.applyPoint}"  pattern="#,###" /> P
										<%-- <br>(유효기간:${cpinfo.applyPointStaYmd} ~ ${cpinfo.applyPointEndYmd}) --%>
										<br>(유효기간:${cpinfo.applyPointValidPerd}개월)
									</c:if>
									
									<c:if test="${cpinfo.applyCoupnBasNoNm ne null and cpinfo.applyCoupnBasNoNm ne '' }">
										<br>${cpinfo.applyCoupnBasNoNm} ${cpinfo.coupnIssueCnt}매<br>(${cpinfo.applyCoupnBasNo})
									</c:if>
								    
								    
							</div>
						</div> 
						
						<!-- <a href="#" class="bt" data-click="popTgtPoint">선택</a> -->
						
						<c:if test="${cpinfo.campStatusCd eq '001' || cpinfo.campStatusCd eq null }">						
							<a href="#"  data-click="popTgtPoint" class="bt">선택</a>
						</c:if>
						
						
						
					</li>
					<li>
						<div class="tit">대상선택</div>
						<div class="txt">
							<div class="txtBg" id="tgtInfo"><br>
									<c:if test="${cpinfo.applyGrpNo ne null }">
										${cpinfo.applyGrpNoNm} <br> (${cpinfo.applyGrpNo})
									</c:if>
							
							</div>
						</div> 
						
						<c:if test="${ cpinfo.campStatusCd ne '003' and cpinfo.campStatusCd ne '004'   and cpinfo.campStatusCd ne '005'   }">						
							<a href="#"  data-click="popTarget" class="bt">선택</a>
						</c:if>
						
					</li>
					
					
					<%-- <li style="">
						<div class="tit">발송채널</div>
						<div class="txt">
							<div class="txtBg">
							<br>
								 <select class="select  data-check" name="dspChlCd" id="dspChlCd" title="유형" >
                                       
                                        <option value="">선택</option>
                                        <c:forEach items="${chlList}" var="m"  varStatus="status">
                                            <option value="${m.campDspBasNo}" <c:if test="${cpinfo.dspChlCd == m.campDspBasNo}">selected</c:if> > ${m.campDspChlNm}  / ${m.campDspAmt} 원</option>
                                        </c:forEach>
	                                                    
                                 </select>
							</div>
						</div> 
						<div style="height:38px"></div>
						<!-- <a href="#" data-click="popTgtChl" class="bt hidden"   >선택</a> -->
						
						
					</li> --%>
					
					
					
					<li>
						<div class="tit">발송 컨텐츠</div>
						<div class="txt">
							<div class="txtBg" id="tmpltInfo">
								
								<c:if test="${cpinfo.dspCtntTypeNo ne null }">
										${cpinfo.dspCtntTypeNoNm}<br>(${cpinfo.dspCtntTypeNo})
								</c:if>
									
									
							</div>
						</div> 
						
						<c:if test="${cpinfo.campStatusCd eq '001' || cpinfo.campStatusCd eq null }">								
							<a href="#" data-click="popTgtCtnt" class="bt">선택</a>
						</c:if>
						
					</li>
				</ul>
			</div>
			<!-- //list -->

		</form>

	</div>
	<!-- //cont -->



</div>


<script>

	$(document).ready(function() {

		// 주문채널 체크처리
		/* 	var ordrChlList = "${cpinfo.ordrChlList}";
		 var arrOrdr = null;
		 if( ordrChlList != "" ){
		
		 arrOrdr = ordrChlList.split("/");
		 for( var i=0 ; i < arrOrdr.length ; i++ ){
		 $("input:checkbox[name='multiselect_arrOrdrChlList'][value='"+ arrOrdr[i] +"']").trigger('click');
		 }
		
		 } */
		 
		chkCycle( $('#rpeatCd') );
		chkShap( $('#campShapCd') );
		 
		 

	});
	
	function reload(){
		location.reload();
	}

	// 캠페인 등록 및 수정
	function saveCamp() {
		
		

		var valid = validateForm("#frmDetail"); //  class='data-check' 인 경우만 체크

		if (valid) {

			var saveJson = Utilities.formToMap("frmDetail");

			/* 	if( $("#coupnKndCd").val() == "002" ){
					if( $("#applyAmt").val() > 100 ){
						alert("정률할인은 100% 이상을 초과할 수 없습니다."+ $("#applyAmt").val());
						$("#applyAmt").val(""); 
						$("#applyAmt").focus();
						return false;
					}
				}

				if( $("input[name='admtMethCd']:checked").val() == "002" ){
				 	
					if( $("#admtAmt").val() > 100 ){
						alert("정산정률은 100% 이상을 초과할 수 없습니다."+ $("#admtAmt").val());
						$("#admtAmt").val("");
						$("#admtAmt").focus();
						return false;
					}
				 	
				} */
				

			var campSta = Number($("#campStaYmd").val());
			var campEnd = Number($("#campEndYmd").val());
			
			if( campSta > campEnd ){
				alert("캠페인 기간 종료일이 시작일 보다 작을 수 없습니다.");
				$("#campEndYmd").focus();
				return false;			
			}
			
			
			
			if( $("#applyPoint").val() == '' && $("#applyCoupnBasNo").val() == '' ){
				alert("캠페인 혜택을 선택해 주세요.");
				return false;
			}	
				
				
			if( $("#applyGrpNo").val() == '' ){
				alert("캠페인 대상군을 선택해 주세요.");
				return false;
			}
			
			if( $("#dspCtntTypeNo").val() == '' ){
				alert("캠페인 발송콘텐츠를 선택해 주세요.");
				return false;
			}

			
			
			
			var dsphour = $("#dspHour").val() +"00";
			var stahour = $("#ftgabltStaHour").val() +""+ $("#ftgabltStaMnut").val();
			var endhour = $("#ftgabltEndHour").val() +""+ $("#ftgabltEndMnut").val();

			
			if( dsphour < stahour || dsphour > endhour ){			
				alert("설정한 시간은 발송 가능한 시간이 아닙니다.");
				$("#dspHour").val('');
				$("#dspHour").focus();
				return false;
			}
				
			$("#btnSaveCamp").hide();
			
			var url = "<c:url value='${urlPrefix}/save${urlSuffix}'/>";
			Utilities.getAjax(url, saveJson, true, function(data, jqXHR) {
				
				if( jqXHR.responseText == 'ErrGrpCustCnt'){
					
					alert("대상그룹에 실제 회원이 존재하지 않습니다.");
					$("#btnSaveCamp").show();
					return false;
					
				}else{
				
					if (Utilities.processResult(data, jqXHR, "캠페인 저장에 실패했습니다.")) {
						alert("캠페인 저장이 완료되었습니다.");
						$("#btnSaveCamp").show();
						closeModal();
	
					}else{
						$("#btnSaveCamp").show();
					}
				
				}
			});

		} else {

			alert("필수 항목들을 기입해 주세요.");
			$("#btnSaveCamp").show();
			return false;
		}

	}

	// 반복주기 선택에 따른 제어
	function chkCycle(obj) {
		
		$(".cyclegrp001").attr("disabled", true);
		//$(".cyclegrp004").prop("checked", false);

		// 1회
		if ($(obj).val() == '001') {
			$(".dowUse").prop('checked', false);
			$(".cyclegrp001").attr("disabled", true);
			

			$("#rpeatMonth").val("");
			$("#rpeatDay").val("");
		}

		// 매일
		if ($(obj).val() == '002') {
			$(".dowUse").prop('checked', false);
			$("#cyclegrp001").attr("disabled", true);

			$("#rpeatMonth").val("");
			$("#rpeatDay").val("");
		}
		
		// 매주
		if ($(obj).val() == '003') {
			$("#rpeatDay").attr("disabled", true);
			$(".cyclegrp003").attr("disabled", false);

			$("#rpeatMonth").val("");
			$("#rpeatDay").val("");
		}
		
		// 매월
		if ($(obj).val() == '004') {
			
			$(".dowUse").prop('checked', false);
			
			$("#rpeatMonth").attr("disabled", true);
			$("#rpeatDay").attr("disabled", false);

			$("#rpeatMonth").val("");
			
			$(".cyclegrp004").prop("checked", false);
			$(".cyclegrp004").attr("disabled", true);
			 
		}
		
		// 분기
		if ($(obj).val() == '005' ) {
			
			$(".dowUse").prop('checked', false);

			//$(".cyclegrp004").prop("checked", false);
			
			$(".cyclegrp001").attr("disabled", true);
			$(".cyclegrp004").attr("disabled", true);
			

			$("#rpeatMonth").val("");
			$("#rpeatDay").val("");
			$("#rpeatMonth").attr("disabled", true);
			$("#rpeatDay").attr("disabled", true);
			
		}
		
		
		//  매년
		if ( $(obj).val() == '006') {
			
			$(".dowUse").prop('checked', false);

			$(".cyclegrp001").attr("disabled", false);

			//$(".cyclegrp004").prop("checked", false);
			$(".cyclegrp004").attr("disabled", true);
			
		}
		
		

	}

	//쿠폰사용기간 설정 체크
	function cpnChlChk(obj) {

		var objName = $(obj).attr("name");

		if ($(obj).is(":checked")) {
			$(".ui-multiselect-all").trigger('click');
			$("#arrOrdrChlList_ms").hide();
		} else {
			$(".ui-multiselect-none").trigger('click');
			$("#arrOrdrChlList_ms").show();
		}
	}

	// 켐페인 대상군 추가
	function popTarget() {

		//var url = "<c:url value='${urlPrefix}/popTarget${urlSuffix}'/>?campBasNo=";
		//Utilities.openModal(url, 1200, 600);
		Utilities.openGroupSelPop('retTarget');
	}

	// 대상군 리턴값
	function retTarget(data) {
		
		
		if (data != null) {
			
			if( data.custCnt == 0 ){
				
				alert('대상 고객수가 0인 그룹은 등록할 수 없습니다.');
				
				
			}else{

				$("#frmDetail #applyGrpNo").val(data.custGrpNo);
				
				var info = data.custGrpNm + "<br>(" + data.custCnt + " 명)";
				$("#tgtInfo").html(info);
			}
			
		}
	}
	
	// 혜택
	function bindBenfit(data){
		
		var info = "";


		log("#vvv  ="+ data.applyPoint  );
		if( data.applyPoint > 0 ){
			//info += addComma(data.applyPoint) + " P <br>(유효기간 : " + data.applyPointStaYmd + " ~ "+  data.applyPointEndYmd +")";
			info += addComma(data.applyPoint) + " P <br>(유효기간 : " + data.applyPointValidPerd +"개월)";

			$("#frmDetail #applyPoint").val(data.applyPoint);
			//$("#frmDetail #applyPointStaYmd").val(data.applyPointStaYmd);
			//$("#frmDetail #applyPointEndYmd").val(data.applyPointEndYmd);
			$("#frmDetail #applyPointValidPerd").val(data.applyPointValidPerd);
			
		}else{
			$("#frmDetail #applyPoint").val("");
			$("#frmDetail #applyPointValidPerd").val("");
		}
		
		if( data.applyCoupnBasNo != null ){
			info += '<br>' + data.applyCoupnBasNoNm +" "+ data.coupnIssueCnt +"매 ("+  data.applyCoupnBasNo +")";
			$("#frmDetail #applyCoupnBasNo").val(data.applyCoupnBasNo);
			$("#frmDetail #coupnIssueCnt").val(data.coupnIssueCnt);
		}else{
			$("#frmDetail #applyCoupnBasNo").val("");
			$("#frmDetail #coupnIssueCnt").val("");
		}
		
		$("#bnfitInfo").html( info );
		
	}
	
	
	// 발송 콘텐츠
	function bindTemplet(data){

		var info = "";
		if( data.campTempltBasNo != '' ){
			info += data.tmpltNm +" ("+  data.campTempltBasNo +")";
			$("#frmDetail #dspCtntTypeNo").val(data.campTempltBasNo);
			
		}
	
		$("#tmpltInfo").html( info );
		
	}

	// 캠페인 대상 포인트 헤택 선택
	function popTgtPoint() {
		var url = "<c:url value='${urlPrefix}/popTgtBnfit${urlSuffix}'/>?campBasNo="+ $("#campBasNo").val();
		Utilities.openModal(url, 1100,750);
	}

	//캠페인 대상 발송 채널 선택
	function popTgtChl() {
		var url = "<c:url value='${urlPrefix}/popTgtChl${urlSuffix}'/>?campBasNo="+ $("#campBasNo").val();
		Utilities.openModal(url, 1200, 600);
	}

	//캠페인 대상 발송 템플릿 설정
	function popTgtCtnt() {
		
		var url = "<c:url value='${urlPrefix}/popTgtCtnt${urlSuffix}'/>?campBasNo="+ $("#campBasNo").val() +"&dspCtntTypeNo="+  $("#frmDetail #dspCtntTypeNo").val();
		
		Utilities.openModal(url, 1200, 600);
	}
	
	
	// 승인, 중지 처리
	function statusChk(campStatusCd){
		
		log("campStatusCd = "+ campStatusCd);

			var statChk = "";
		    var obj = new Object(); //key, value형태로 저장할 Object
		    
		    obj.campStatusCd = campStatusCd;
		    obj.campBasNo =  $("#campBasNo").val();
			
			var url = "<c:url value='${urlPrefix}/updateCampStatus${urlSuffix}'/>";
			Utilities.getAjax(url, obj, true, function(data, jqXHR) {
				if (Utilities.processResult(data, jqXHR, "상태코드 변경에 실패했습니다.")) {
					alert("상태코드 변경을 완료하였습니다.");
					closeModal();
				}
			});
	}
	
	// 2차 캠페인 생성 팝업
	function newCampain2(rspnApplyYn){
		
		//closeModal();
		
		var url = "<c:url value='${urlPrefix}/add2th${urlSuffix}'/>?campBasNo="+  $("#campBasNo").val() +"&lowRspnCampNo="+ $("#lowRspnCampNo").val() +"&lowRspnDnaCampNo="+ $("#lowRspnDnaCampNo").val() +"&rspnApplyYn="+ rspnApplyYn;
		Utilities.openModal(url, 1200, 600);
	
	}
	
	// 반응,원샷 체크 
	function chkShap(obj){
		//log(  "${addMode} // "+ $(obj).val() );
		
		//if( "${addMode}" == "C") return;
		
		if( $(obj).val() == '001' ){
			
			if( "${addMode}" == "C"){
				
				$("#lowRspnCampNo").val("");
				$("#lowRspnDnaCampNo").val("");
				$("#lowRspnCampNo").attr("disabled", true);
				$("#lowRspnDnaCampNo").attr("disabled", true);
				$(".btnCamp2").hide();
				
			}else{
					
				$("#lowRspnCampNo").attr("disabled", false);
				$("#lowRspnDnaCampNo").attr("disabled", false);
				$(".btnCamp2").show();
			
			}
		}else{
			
				$("#lowRspnCampNo").val("");
				$("#lowRspnDnaCampNo").val("");
				$("#lowRspnCampNo").attr("disabled", true);
				$("#lowRspnDnaCampNo").attr("disabled", true);
				$(".btnCamp2").hide();
			
		}
		
	}
	
	
	// 발송가능 시간 체크 
	function chkDspHour(obj){
		
		var dsphour = $(obj).val() +"00";
		var stahour = $("#ftgabltStaHour").val() +""+ $("#ftgabltStaMnut").val();
		var endhour = $("#ftgabltEndHour").val() +""+ $("#ftgabltEndMnut").val();

		
		if( dsphour < stahour || dsphour > endhour ){			
			alert("설정한 시간은 발송 가능한 시간이 아닙니다.");
			$(obj).val('');
			$(obj).focus();
			return false;
		}
		
	
	}
</script>
