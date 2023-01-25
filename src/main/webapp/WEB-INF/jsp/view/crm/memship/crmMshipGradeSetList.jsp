<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="code" uri="/WEB-INF/tlds/ezTagLib.tld"%> 


<style>

.tui-datepicker {
    z-index: 90000000;
    position: fixed;
}

</style>
<!-- right -->
		<div class="">

			<!-- sort -->
			<!-- <div class="mSort2">
				<ul>
					<li class="w32per">
						<div class="tit">사용여부</div>
						<div class="txt">
							<div class="mFlex2">
								<span class="flex">
                                    <select class="select" title="사용여부">
                                        <option></option>
                                    </select>
                                </span>
                                <span class="button">
                                    <a href="#" class="mBtn1">검색</a>
                                </span>
							</div>
						</div>
					</li>
				</ul>
			</div> -->
			<!-- //sort -->

			<!-- box -->
			<div class="mBox1 p24">
				
				<div class="gTitle1">
					<h3 class="mTitle1">등급점수 목록</h3>
					<div class="gRt">
						<a href="#" class="mBtn1 gray" data-click="modify">저장</a>
					</div> 
				</div>
				<!-- board -->
				<div class="mBoard1 mCustomScrollbar hSortRow1 pType1"> 
                    <!--
                        class="hSortRow1"   => 상단 검색이 1줄 일 경우
                        class="pType1"      => td height="30px"
                    -->
                    
                    <form role="form" id="frmList" name="frmList">
                    
                    
					<table>
						<caption>캠페인 목록</caption>
						
						<thead>
							<tr>
								<th scope="col">NO</th>
								<th scope="col">등급점수명</th>
								<th scope="col" >등급점수(구매금액당)</th>
								<th scope="col" >지급점수</th>
								<th scope="col" >등급점수율%(구매금액당)</th>
								
								
								<th scope="col">월체험제한 횟수</th>
								<th scope="col">일체험제한 횟수</th>
								<th scope="col">유효기간(개월)</th>
								
								<th scope="col" >등록일</th>
							</tr>
							
							
							
						</thead>
						<tbody id="grdList">
						
							 <c:forEach items="${grdList}" var="m"  varStatus="status"> 
						
							
								
						
							<tr class="grdList">
								<td>
								<input type="hidden" name="stat" id="stat"  class="it"  value="${m.gradeSeq eq null  ? 'C' : 'U'}" >
								<input type="hidden" name="topComnCd" id="topComnCd"  class="it w20"  value="${m.topComnCd2}" >
								<input type="hidden" name="comnCd" id="comnCd"  class="it w30"  value="${m.comnCd2}" >
								<input type="${m.gradeSeq eq null ? 'text' : 'hidden' }" name="gradeSeq" id="gradeSeq"  class="it w30"  value="${m.gradeSeq }" >
					
								${m.gradeSeq}
								
								</td>
								
								<td><input type="hidden" name="pointNm" id="pointNm"  class="it"  value="${m.comnCdNm}" >${m.comnCdNm}</td>
								
					
								  
								<td><input type="text" name="payStdGradeScore" id="payStdGradeScore"  data-type="number"  size="4" maxlength="4" class="it" style="width:30px" value="${m.payStdGradeScore}" ></td>
								<td><input type="text" name="payScore" id="payScore"  data-type="number"  size="4" maxlength="4" class="it" style="width:30px" value="${m.payScore}" ></td>
								
								<td><input type="text" name="gradePointRate" id="gradePointRate"  data-type="number"  size="4" maxlength="4" class="it" style="width:30px" value="${m.gradePointRate}"></td>
								
								<td><input type="text" name="monthExprnRstrtnCnt" id="monthExprnRstrtnCnt"  data-type="number"  size="4" maxlength="4" class="it" style="width:30px" value="${m.monthExprnRstrtnCnt}"></td>
								
								<td><input type="text" name="dayExprnRstrtnCnt" id="dayExprnRstrtnCnt"  data-type="number"  size="4" maxlength="4" class="it" style="width:30px" value="${m.dayExprnRstrtnCnt}"></td>
								
								<td><input type="text" name="validPerd" id="validPerd"  data-type="number"  size="4" maxlength="4" class="it" style="width:30px" value="${m.validPerd}"></td>
								
							
								<td>${m.regDt}</td>
								
							</tr>
						
						</c:forEach>
							
						</tbody>
					</table>
					
					</form>
					
					
				</div>
				<!-- //board -->
				
			</div>
			<!-- //box -->

		</div>
		<!-- //right -->
	                  



<script>

jQuery.fn.serializeObject = function() { 
	var obj = null; 
	try { if(this[0].tagName && this[0].tagName.toUpperCase() == "FORM" ) { 
		var arr = this.serializeArray(); 
			if(arr){ 
				obj = {};
				jQuery.each(arr, function() { 
					log( this.name +" = "+ this.value );
					obj[this.name].add(this.value); 
				}); 
			} 
		} 
	}catch(e) {
		alert(e.message); 
	}finally {
		
	} 
	return obj; 
}




// 저장하기
function modify(){
	
	var sndData = getRowObject(".grdList");
	

		//if(valid) {

			var url = "<c:url value='${urlPrefix}/saveList${urlSuffix}'/>";
			Utilities.getAjax(url,sndData,true,function(data,jqXHR){
		        if(Utilities.processResult(data,jqXHR,"등급 정책 저장에 실패했습니다."))
		        {
		            alert("등급 정책 저장이 완료되었습니다.");
		            location.reload();
		          
		        }
		    });
		
		//}
	}




</script>

