<%@ include file="/html/init.jsp"%>
<%@page pageEncoding="UTF-8"%>

<%


//String loaiThuTuc = Validator.isNotNull(renderRequest.getParameter("loaiThuTuc")) ? renderRequest.getParameter("loaiThuTuc") : "";
String maritimeCode= ParamUtil.getString(request, "maritimeCode").trim();
String portCode= ParamUtil.getString(request, "portCode").trim();
String shipName = ParamUtil.getString(request, "shipName").trim();
String callSign = ParamUtil.getString(request, "callSign").trim();
String shipDateFrom = ParamUtil.getString(request, "shipDateFrom").trim();
String shipDateTo = ParamUtil.getString(request, "shipDateTo").trim();

String flagMenu = ParamUtil.getString(request, "flagMenu").trim();
%>

<div class="wd-content-container">
    <%@ include file="/html/thongtintau/menu-left-thong-tin-tau.jsp"%>
    <%@ include file="/html/thongtintau/tim_kiem_thong_tin_tau.jsp"%>
</div>

<%@ include file="/html/thongtintau/ket_qua_tim_kiem_thong_tin_tau.jsp"%>