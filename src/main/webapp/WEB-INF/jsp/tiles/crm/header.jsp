<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="reqrend" scope="request">V0.05</c:set>
<c:set var="leftBoxHeight1" value="780px" scope="request"/>
<c:set var="leftBoxHeight2" value="750px" scope="request"/>
<c:set var="leftBoxHeight3" value="620px" scope="request"/>
<c:set var="rightBoxHeight" value="775px" scope="request"/>
<c:set var="rightBoxHeight1" value="634px" scope="request"/>
<c:set var="rightBoxHeight2" value="343px" scope="request"/>
<c:set var="rightBoxHeight3" value="667px" scope="request"/>
<c:set var="rightBoxHeight4" value="694px" scope="request"/>
<c:set var="rightBoxHeight5" value="775px" scope="request"/>

 <title>MRCRM</title>
<link rel="shortcut icon" href="/static/crm/images/favicon.ico">
<!-- library -->
<script type="text/javascript" src="/static/crm/js/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" type="text/css" href="/static/crm/plugins/swiper/swiper.min.css">
<script type="text/javascript" src="/static/crm/plugins/swiper/swiper.min.js"></script>
<link rel="stylesheet" type="text/css" href="/static/crm/plugins/jquery.mCustomScrollbar/jquery.mCustomScrollbar.css">
<script type="text/javascript" src="/static/crm/plugins/jquery.mCustomScrollbar/jquery.mCustomScrollbar.concat.min.js"></script>
<link rel="stylesheet" href="/static/crm/css/jquery-ui.css">
<script type="text/javascript" src="/static/crm/js/jquery-ui.js"></script>
<!-- //library -->
<!-- customer -->
<link rel="stylesheet" href="/static/crm/css/ui.css?reqrend=${reqrend}">
<%-- <script type="text/javascript" src="/static/crm/js/ui.js?reqrend=${reqrend}"></script> --%>



<!--  membership  -->
<c:set var="now" value="<%=new java.util.Date()%>" />
<c:set var="dayVer"><fmt:formatDate value="${now}" pattern="yyyyMMddhhmmss" /></c:set> 
<script type="text/javascript" src="/static/crm/js/memship.js?reqrend=<c:out value="${dayVer}" />" />"></script>
<link rel="stylesheet" type="text/css" media="all" href="/static/crm/css/memship.css?reqrend=<c:out value="${dayVer}" />">
<!--  membership  -->


<!-- multiselect -->
<link rel="stylesheet" type="text/css" media="all" href="/static/js/multiselect/css/jquery.multiselect.css">
<link rel="stylesheet" type="text/css" media="all" href="/static/js/multiselect/css/jquery.multiselect.filter.css">
<script src="<c:url value='/static/js/multiselect/src/jquery.multiselect.js'/>"></script>
<script src="<c:url value='/static/js/multiselect/i18n/jquery.multiselect.ko.js'/>"></script>
<script src="<c:url value='/static/js/multiselect/src/jquery.multiselect.filter.js'/>"></script>

<!-- Font Awesome -->
<link rel="stylesheet" href="<c:url value='/static/css/fontawesome-free/css/all.min.css'/>" />
<!-- jstree -->
<link rel="stylesheet" href="<c:url value='/static/js/js-tree/themes/default/style.min.css'/>" />

<!-- jQuery -->
<script src="<c:url value='/static/js/jquery-blockui/jquery.blockUI.js'/>"></script>
<script src="<c:url value='/static/js/jquery-form/jquery.form.min.js'/>"></script>
<script src="<c:url value='/static/js/jquery-inputmask/jquery.inputmask.min.js'/>"></script>
<script src="<c:url value='/static/js/jquery-cookie/jquery.cookie.js'/>"></script>
<script src="<c:url value='/static/js/exceljs.js'/>"></script>
<script src="<c:url value='/static/js/js-tree/jstree.min.js'/>"></script>
<script src="<c:url value='/static/js/jquery.ui.monthpicker.js'/>"></script>
<script src="<c:url value='/static/js/myTooltip/myTooltip.js'/>"></script>
<link rel="stylesheet" href="<c:url value='/static/js/circliful/circliful.css'/>" />
<script src="<c:url value='/static/js/circliful/circliful.js'/>"></script>


<link rel="stylesheet" href="<c:url value='/static/js/toastUI/tui-time-picker.css'/>" />
<link rel="stylesheet" href="<c:url value='/static/js/toastUI/tui-date-picker.min.css'/>" />
<link rel="stylesheet" href="<c:url value='/static/js/toastUI/tui-grid.min.css'/>" />

<script src="<c:url value='/static/js/toastUI/tui-time-picker.js'/>"></script>
<script src="<c:url value='/static/js/toastUI/tui-date-picker.min.js'/>"></script>
<script src="<c:url value='/static/js/toastUI/tui-grid.min.js'/>"></script>

<script src="<c:url value='/static/js/jszip.min.js'/>"></script>

<!-- ???????????? -->
<link rel="stylesheet" href="<c:url value='/static/js/fancybox/jquery.fancybox.min.css'/>" />
<script src="<c:url value='/static/js/fancybox/jquery.fancybox.min.js'/>"></script>


<!-- select2 -->
<link rel="stylesheet" href="<c:url value='/static/js/select2/css/select2.min.css'/>" />
<script src="<c:url value='/static/js/select2/js/select2.min.js'/>"></script>
<script src="<c:url value='/static/js/select2/js/i18n/ko.js'/>"></script>

<!-- selectize -->
<link rel="stylesheet" href="<c:url value='/static/js/selectize/selectize.default.css'/>" />
<script src="<c:url value='/static/js/selectize/selectize.min.js'/>"></script>


<script src="/static/js/moment/moment.min.js"></script>

<script src="<c:url value='/static/js/utilities.js?reqrend=${reqrend}'/>"></script>	
<script src="<c:url value='/static/js/grid_toast_class.js?reqrend=${reqrend}'/>"></script>	
<script src="<c:url value='/static/js/gridWrap_toast.js?reqrend=${reqrend}'/>"></script>
<script src="<c:url value='/static/js/ez-tree.js?reqrend=${reqrend}'/>"></script>
<script src="<c:url value='/static/js/ez-attachfile.js?reqrend=${reqrend}'/>"></script>


<script type="text/javascript">

var _user_auth_c = "${currentMenu.menuRegAuthYn}";
var _user_auth_r = "${currentMenu.menuReadAuthYn}";
var _user_auth_u = "${currentMenu.menuAmdAuthYn}";
var _user_auth_d = "${currentMenu.menuDelAuthYn}";

var _urlSuffix = "${urlSuffix}";
var _PROGRAM_ID ='${currentMenuCd}';
var _SYSTEM_ID  ='${currentSystemId}';
var _basePath = "<c:url value='${urlPrefix}' />";
var _code_url = "<c:url value='${urlPrefix}/commCode/getComboCode'/>${urlSuffix}";
var _fileInfo_url = "<c:url value='${urlPrefix}/file/getFileInfo'/>${urlSuffix}";
var _file_upload_url = "<c:url value='${urlPrefix}/file/uploadTempFile'/>${urlSuffix}";
var _s3_download_url = "<c:out value='${s3prefix}' />";
var _user_login_id = "${LOGIN_USER.loginId}"
var _file_white_list = ${s180};
$("document").ready(function(){
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
	/* tab */

	$( ".date" ).datepicker({
		dateFormat: "yymmdd",
		prevText: '?????? ???',
		nextText: '?????? ???',
		monthNames: ['1???', '2???', '3???', '4???', '5???', '6???', '7???', '8???', '9???', '10???', '11???', '12???'],
		monthNamesShort: ['1???', '2???', '3???', '4???', '5???', '6???', '7???', '8???', '9???', '10???', '11???', '12???'],
		dayNames: ['???', '???', '???', '???', '???', '???', '???'],
		dayNamesShort: ['???', '???', '???', '???', '???', '???', '???'],
		dayNamesMin: ['???', '???', '???', '???', '???', '???', '???'],
		showMonthAfterYear: true,
		yearSuffix: '???',
	});
});

$(document).ajaxError(function(event, jqxhr, settings, thrownError) {


    if (jqxhr.status == _ERROR_NEED_LOGIN) {
        alert("????????? ?????????????????????.");
        top.location.href = "<c:url value='/login/sso' />";
    } else if (jqxhr.status == _ERROR_BAN_LOGIN) {
        alert("?????? ???????????? ???????????? ???????????? ?????????.");
        top.location.href = "<c:url value='/login/sso' />";
    } else if (jqxhr.status == _ERROR_HAS_NO_RIGHT) {
        alert("?????? ????????? ????????? ????????????.");
    }
});

function logout(){
	Utilities.getAjax("<c:url value='/login/logout${urlSuffix}' />",{},true,function(data,jqXHR){
        if(Utilities.processResult(data,jqXHR,"??????????????? ??????????????????."))
        {
        	 top.location.href = data.url;//"<c:url value='/login/' />";
        }
    });
}
function excelDownload(elem,data){
	var gridId = data.gridId;
	if(!gridId)
		return;
	var grid = window[gridId];
	var name = data.dispName;
	if(!name)
		name = data.name;
	grid.exportExcel(name+".xlsx",true);
}
function openFileModal(fileCd,fileCtgryCd){
	if(!fileCtgryCd)
		fileCtgryCd = "";
	var url = "<c:url value='${urlPrefix}/file/fileInfo${urlSuffix}'/>?fileCd=" + fileCd + "&fileCtgryCd=" + fileCtgryCd;
	Utilities.openModal(url,800,600);
}
// function goMenu(el,data){
// 	var href = el.data("href");
// 	if(!href || href.indexOf("#") > -1)
// 		return;
// 	var url = "/" + href  + "${urlSuffix}";
// 	if(data.menuPopupYn == "Y")
// 		window.open(url);
// 	else 
// 		location.href = url;
// }
function changeSystem(elem,data){
	var systemCd = elem.val();
	var param = {systemCd : systemCd}
	var url = "/createUserToken";
	Utilities.getAjax(url, param, false, function(data, jqXHR) {
		if (Utilities.processResult(data, jqXHR, "????????? ???????????? ???????????????.")) {
			var token = data.data.token;
			var url = elem.find("option:selected").data("systemUrl");
			$("#frmMoveSystem")[0].action = url;
			$("#sysToken").val(token);
			$("#frmMoveSystem")[0].submit();
		}
	});
}
function openDesc() {
	if($(".headingBox").find("h3").attr("class") != "active"){
		$(".headingBox").find("h3").addClass("active");
	} else {
		$(".headingBox").find("h3").removeClass("active");
	}
}

function setToday(){
    const today = moment();
    dt = today.format("YYYYMMDD");
    $("#strtDt").val(dt);
    $("#strtDt").change();
    $("#endDt").val(dt);
    $("#endDt").change();
}
function set1Week(){
    var dt = $("#endDt").val();
    if(!dt)
    {
        const today = moment();
        dt = today.format("YYYYMMDD");
        $("#endDt").val(dt);
    }
    var endDt = moment(dt,"YYYYMMDD");
    var strtDt = endDt.add(-6, 'day').format("YYYYMMDD");
    $("#strtDt").val(strtDt);
    $("#strtDt").change();
    $("#endDt").val(dt);
    $("#endDt").change();
}
function set1month(){
    var dt = $("#endDt").val();
    if(!dt)
    {
        const today = moment();
        dt = today.format("YYYYMMDD");
        $("#endDt").val(dt);
    }
    var endDt = moment(dt,"YYYYMMDD");
    var strtDt = endDt.add(-1, 'M').format("YYYYMMDD");
    $("#strtDt").val(strtDt);
    $("#strtDt").change();
    $("#endDt").val(dt);
    $("#endDt").change();
}
function set3month(){
    var dt = $("#endDt").val();
    if(!dt)
    {
        const today = moment();
        dt = today.format("YYYYMMDD");
        $("#endDt").val(dt);
    }
    var endDt = moment(dt,"YYYYMMDD");
    var strtDt = endDt.add(-3, 'M').format("YYYYMMDD");
    $("#strtDt").val(strtDt);
    $("#strtDt").change();
    $("#endDt").val(dt);
    $("#endDt").change();
}
function set6month(){
    var dt = $("#endDt").val();
    if(!dt)
    {
        const today = moment();
        dt = today.format("YYYYMMDD");
        $("#endDt").val(dt);
    }
    var endDt = moment(dt,"YYYYMMDD");
    var strtDt = endDt.add(-6, 'M').format("YYYYMMDD");
    $("#strtDt").val(strtDt);
    $("#strtDt").change();
    $("#endDt").val(dt);
    $("#endDt").change();
}
function setAllmonth(){
    $("#strtDt").val("");
    $("#strtDt").change();
    $("#endDt").val("");
    $("#endDt").change();
}

function setCurrentBtn(elem){
	$("[data-click=setToday]").removeClass("tutor-btn-current");
	$("[data-click=set1Week]").removeClass("tutor-btn-current");
	$("[data-click=set1month]").removeClass("tutor-btn-current");
	$("[data-click=set3month]").removeClass("tutor-btn-current");
	$("[data-click=set6month]").removeClass("tutor-btn-current");
	$("[data-click=setAllmonth]").removeClass("tutor-btn-current");

	$("[data-click=setToday]").addClass("btnBasic");
	$("[data-click=set1Week]").addClass("btnBasic");
	$("[data-click=set1month]").addClass("btnBasic");
	$("[data-click=set3month]").addClass("btnBasic");
	$("[data-click=set6month]").addClass("btnBasic");
	$("[data-click=setAllmonth]").addClass("btnBasic");
	elem.addClass("tutor-btn-current");
	elem.removeClass("btnBasic");
}

function addExcelLog(excelName,searchParam,json){
	try{
		
		var url = "${urlPrefix}/excelLog/addLog";
		var param = {
				dnldNm : excelName
		};
		if(json && searchParam && searchParam.dnldTxn && searchParam.pfmWorkCd == "003" ){
			
			let list = Array.isArray(json) ? json  : json.data.contents;
			if(Array.isArray(list) && list.length){
				const d = list[0];
				if(d["itgCustNo"] &&  d["custNm"]){
					param.dnldTxn = searchParam.dnldTxn;
					param.itgCustNo = d["itgCustNo"]; 
					param.pfmWorkCd = "003";
					param.inqryCnt  = list.length;
					param.inqryTxn = param.itgCustNo;
					for(let i=1;i<list.length;i++){
						param.inqryTxn += "," + list[i].itgCustNo;
					}
				}
			}
			console.log(param);
		}
		
		Utilities.getAjax(url,param,true,function(data,jqXHR){
	    });	
	}catch(e){}
	
}
</script>
<style>
.ui-corner-all span {
	margin-left : 10px;
}
.mSort2 ul {
width: 100%;
}
.btnTopMargin {
	margin-top: 14px;
}
/* .mGrid1 .gLeft .mBox1{height:730px;} */

.gridWrap{
border-top : solid 0px;
border-bottom : solid 0px;
border-left : solid 1px;
border-right : solid 1px;
border-color : #AAAAAA
}
.tui-grid-container {
  width: 100%;
  position: relative;
  border-width: 0;
  clear: both;
  font-size: 12px;
  font-family: Pretendard, -apple-system, BlinkMacSystemFont, system-ui, 'Apple SD Gothic Neo', 'Malgun Gothic', sans-serif;
}

th.tui-grid-cell.tui-grid-cell-header.tui-grid-cell-row-header {
    background-color: #ffeded;
    
  
  color: #686868;
    
}
.tui-grid-scrollbar-right-top {
border-color : #CCCCCC;
 border-right : 0px; 
}
.tui-grid-scrollbar-right-bottom {
border-color : #AAAAAA
}
.tui-grid-context-menu{
	text-align : left;
}
.gridViewChecked {	
	background-color : #FFF1E8 !important;
}
  .gridView {
  	text-align:center;
   	margin-bottom : 1; 
  	padding-bottom : 1;
/*     width: 100%; */
/*     height: 500px; */
  }
  .gridview_pagination{
    margin-top: 10px;
  }
  .right {
    text-align:right;
  }
  .left {
    text-align:left;
  }
  .center {
    text-align:center;
  }
  .list-group-item {
  padding : 4px;
  }
  .treeview span.icon
  {
  margin-right : 10px !important;
  }
  .tui-datepicker {
    z-index : 100;
  }
    .tui-calendar-btn{
  	margin-top : 10px !important;
  }
  
  
  .tui-calendar * {
    -webkit-box-sizing: border-box !important;
    -moz-box-sizing: border-box !important;
    box-sizing: border-box !important;
}

.tui-datepicker * {
    -webkit-box-sizing: border-box !important;
    -moz-box-sizing: border-box !important;
    box-sizing: border-box !important;
    border : none !important;;
}

.tui-grid-layer-state {
  z-index: 14 !important;
}
.tui-calendar-btn {
    overflow: hidden !important;
    position: absolute !important;
    top: 0 !important;
    width: 32px !important;
    height: 50px !important;
    line-height: 400px !important;
    z-index: 10 !important;
    cursor: pointer !important;
    border: none !important;
    background-color: #fff !important;
    margin : 0px !important;
}

.jstree-anchor:hover {
color : #F27800;
background-color: #fff;
} 

.jstree-icon .jstree-ocl :hover{
color : #F27800;
background-color: #fff;
}

.jstree-anchor .jstree-clicked .jstree-icon {
color : #F27800;
background-color: #fff;
}

.jstree-default .jstree-clicked{
color : #F27800;
background:#fff;
 border-radius:0px; 
 box-shadow:inset 0 0 0px #999999 
}   

.tree {
	overflow-x: hidden;
	overflow-y: auto;
	width: 100%;
	height: 400px;
/* 	padding: 10px; */
	border-top : 1px;
	border-top-style  : solid;
}

.ui-datepicker {
z-index : 1000!important;
}
.ui-state-active,
.ui-widget-content .ui-state-active,
.ui-widget-header .ui-state-active,
a.ui-button:active,
.ui-button:active,
.ui-button.ui-state-active:hover {
	border: none!important;
	background: #999999;
	font-weight: normal;
	color: #ffffff;
}
.selectize-dropdown {
  position: absolute;
  z-index: 10000; /* adjust as necessary */
  border: 1px solid #d0d0d0;
  background: #ffffff;
  margin: -1px 0 0 0;
  border-top: 0 none;  
}
</style>
