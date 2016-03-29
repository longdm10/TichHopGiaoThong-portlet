<%@page import="javax.portlet.PortletSession"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="vn.gt.utils.CheckBusinessUtil"%>
<%@page import="vn.gt.tichhop.report.ReportsBusinessUtils"%>
<%@page import="vn.gt.tichhop.report.ReportConstant"%>
<%@page import="vn.gt.utils.PageType"%>
<%@page import="vn.gt.tichhop.message.MessageType"%>
<%@page import="java.text.SimpleDateFormat"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.util.HttpUtil"%>
<%@page import="vn.gt.utils.document.DocumentUtils"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.model.User"%>

<%@page pageEncoding="UTF-8"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
	int documentNameReport = ParamUtil.getInteger(request, PageType.DOCUMENT_NAME);
	int documentYearReport = ParamUtil.getInteger(request, PageType.DOCUMENT_YEAR);
	int messageTypeReport = ParamUtil.getInteger(request, PageType.MESSAGE_TYPE);
	String requestCodeReport = ParamUtil.getString(request, PageType.REQUEST_CODE);
	String documentType = ParamUtil.getString(request, PageType.DOCUMENT_TYPE);
	
	String documentNameRcc = ParamUtil.getString(request, PageType.DOCUMENT_NAME_VIEW_RCC);
	String documentYearRcc = ParamUtil.getString(request, PageType.DOCUMENT_YEAR_VIEW_RCC);
	String requestCodeRcc = ParamUtil.getString(request, PageType.REQUEST_CODE_VIEW_RCC);
	String messageTypeRcc = ParamUtil.getString(request, PageType.MESSAGE_TYPE_VIEW_RCC);
	String loaiThuTucReport = "";
	if (portletSession.getAttribute(MessageType.LOAT_THU_TUC, PortletSession.APPLICATION_SCOPE) != null) {
		loaiThuTucReport = (String) portletSession.getAttribute(MessageType.LOAT_THU_TUC, PortletSession.APPLICATION_SCOPE);
	}
	
	System.out.println("===documentNameRcc== " + documentNameRcc + " ===documentYearRcc== " + documentYearRcc + "==requestCodeRcc== " + requestCodeRcc + "==messageTypeRcc== " + messageTypeRcc);
	
	
	if(documentNameRcc!=null && documentYearRcc != null && requestCodeRcc != null && messageTypeRcc != null) {
		if(!documentNameRcc.equals("")) {
			documentNameReport = Integer.valueOf(documentNameRcc);
		} 
		
		if(!documentYearRcc.equals("")) {
			documentYearReport = Integer.valueOf(documentYearRcc);
		}
		
		if(!documentNameRcc.equals("")) {
			documentNameReport = Integer.valueOf(documentNameRcc);
		}
		

		if(!requestCodeRcc.equals("")) {
			requestCodeReport = requestCodeRcc;
			loaiThuTucReport = MessageType.LOAT_THU_TUC_ROI_CANG;
		}
		
		
		
	}
	
	
	// config
	// File Export
	
	String tenFileExport = "defaultExport.pdfs";
	System.out.println("==37==report_export.jsp==Report===messageTypeReport=:" + messageTypeReport);
	System.out.println("==38==report_export.jsp==documentNameReport===" + documentNameReport + "========documentYearReport===" + documentYearReport + "========requestCodeReport===" + requestCodeReport);
	
	if (messageTypeReport == MessageType.BAN_KHAI_AN_NINH_TAU_BIEN) {
		tenFileExport = ReportConstant.ShipSecurityNotification_EXPORT;
		
	} else if (messageTypeReport == MessageType.THONG_BAO_TAU_DEN_CANG) {
		tenFileExport = ReportConstant.NOTICE_OF_ARRIVAL_EXPORT;
		
	} else if (messageTypeReport == MessageType.THONG_BAO_TAU_ROI_CANG) {
		tenFileExport = ReportConstant.THONG_BAO_TAU_ROI_CANG_EXPORT;
		
	} else if (messageTypeReport == MessageType.THONG_BAO_TAU_QUA_CANH) {
		tenFileExport = ReportConstant.THONG_BAO_TAU_QUA_CANH_EXPORT;
		
	} else if (messageTypeReport == MessageType.XAC_BAO_TAU_DEN_CANG) {
		tenFileExport = ReportConstant.XACBAO_NOTICE_OF_ARRIVAL_EXPORT;
		
	} else if (messageTypeReport == MessageType.XAC_BAO_TAU_ROI_CANG) {
		tenFileExport = ReportConstant.XAC_BAO_TAU_ROI_CANG_EXPORT;
		
	} else if (messageTypeReport == MessageType.XAC_BAO_TAU_QUA_CANH) {
		tenFileExport = ReportConstant.XAC_BAO_TAU_QUA_CANH_EXPORT;
		
	} else if (messageTypeReport == MessageType.BAN_KHAI_HANG_HOA) {
		tenFileExport = ReportConstant.CargoDeclaration_EXPORT;
		
	} else if (messageTypeReport == MessageType.BAN_KHAI_DANH_SACH_THUYEN_VIEN) {
		tenFileExport = ReportConstant.CREW_LIST_EXPORT;
		
	} else if (messageTypeReport == MessageType.LENH_DIEU_DONG) {
		tenFileExport = ReportConstant.SHIFTING_ORDER_EXPORT;
		
	} else if (messageTypeReport == MessageType.BAN_KHAI_DANH_SACH_HANH_KHACH) {
		tenFileExport = ReportConstant.PASSENGER_LIST_EXPORT;
		
	} else if (messageTypeReport == MessageType.BAN_KHAI_KIEM_DICH_THUC_VAT) {
		tenFileExport = ReportConstant.DECLARATION_FOR_PLANT_QUARANTINE_EXPORT;
		
	} else if (messageTypeReport == MessageType.BAN_KHAI_HANH_LY_THUYEN_VIEN) {
		tenFileExport = ReportConstant.CREW_EFFECTS_DECLARATION_EXPORT;
		
	} else if (messageTypeReport == MessageType.BAN_KHAI_DANH_SACH_HANG_HOA_NGUY_HIEM) {
		tenFileExport = ReportConstant.DANGEROUS_GOODS_MANIFEST_EXPORT;
		
	} else if (messageTypeReport == MessageType.BAN_KHAI_KIEM_DICH_DONG_VAT) {
		tenFileExport = ReportConstant.DECLARATION_FOR_ANIMAL_QUARANTINE_EXPORT;
		
	} else if (messageTypeReport == MessageType.BAN_KHAI_CHUNG) {
		tenFileExport = ReportConstant.GENERAL_DECLARATION_EXPORT;
		
	} else if (messageTypeReport == MessageType.BAN_KHAI_DU_TRU_CUA_TAU) {
		tenFileExport = ReportConstant.SHIP_STORES_DECLARATION_EXPORT;
		
	} else if (messageTypeReport == MessageType.BAN_KHAI_BAO_Y_TE_HANG_HAI) {
		tenFileExport = ReportConstant.DECLARATION_OF_HEALTH_EXPORT;
		
	} else if (messageTypeReport == MessageType.GIAY_PHEP_QUA_CANH) {
		tenFileExport = ReportConstant.PERMISSION_FOR_TRANSIT_EXPORT;
		
	} else if (messageTypeReport == MessageType.GIAY_PHEP_ROI_CANG_BO_GTVT_CAP_KHI_XUAT_CANH) {
		tenFileExport = ReportConstant.ISSUE_PORT_CLEARANCE_EXPORT;
		if (documentType!=null &&documentType.equals(MessageType.LOAT_THU_TUC_ROI_CANG)) {
			loaiThuTucReport =MessageType.LOAT_THU_TUC_ROI_CANG;
		}
	}
	
	
	User userLogin = PortalUtil.getUser(request);

	System.out.println("==report_export.jsp======tenFileExport===" + tenFileExport);
	//
	//ReportsBusinessUtils action = new ReportsBusinessUtils();
	long nanoTimePDF = ReportsBusinessUtils.actionExport(requestCodeReport, documentNameReport, documentYearReport, messageTypeReport, loaiThuTucReport);
	
	long digitalAttached = 0;
	if (messageTypeReport == MessageType.LENH_DIEU_DONG || messageTypeReport == MessageType.GIAY_PHEP_QUA_CANH || messageTypeReport == MessageType.GIAY_PHEP_ROI_CANG_BO_GTVT_CAP_KHI_XUAT_CANH) {
		digitalAttached = ReportsBusinessUtils.checkDigitalAttachedFile(userLogin, requestCodeReport, messageTypeReport, loaiThuTucReport);
	}
	
	
	
	 if (nanoTimePDF > 0) {
		tenFileExport = nanoTimePDF + "_" + tenFileExport;
	} else {
		tenFileExport = "defaultExport.pdfs";
	}
	
	String UrlFile = request.getContextPath() + "/export/" + tenFileExport;
	String UrlFileDowLoad = UrlFile.replace(".pdfs", ".pdf");
	String UrlFileBinhNT = UrlFile.replaceAll("/", "%2F");
	
	
	
	String getRequestCode = CheckBusinessUtil.getRequestCode(requestCodeReport, documentNameReport, documentYearReport, messageTypeReport);
	
	if (digitalAttached > 0) {
		System.out.println("==report_export.jsp======digitalAttached===" + digitalAttached);
		UrlFile = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + DocumentUtils.getLinkDownloadFromNoiLuuTruTaiLieuId(digitalAttached);
		System.out.println("==report_export.jsp======urlFile===");
		getRequestCode = "coFile";
	} 
	
	if (getRequestCode.trim().length() > 0 && messageTypeReport != MessageType.BAN_KHAI_HANH_LY_HANH_KHACH_ROI_TAU && (loaiThuTucReport !=MessageType.LOAT_THU_TUC_ROI_CANG && loaiThuTucReport !=MessageType.LOAT_THU_TUC_VAO_CANG )  ){
%>

<input type="hidden" id="nanoTimePDF" value="<%=nanoTimePDF%>" />
<div>
	<OBJECT data="<%=UrlFile%>#view=FitH&scrollbar=0&amp;page=1&toolbar=0&statusbar=0&messages=0&navpanes=0"
			type="text/html"
			TITLE="SamplePdf"
			WIDTH="100%"
			HEIGHT="1500px"
			style="background: white;
			min-height: 100%;"  >
		<a href="<%=UrlFileDowLoad%>">Tải xuống file</a> 
	</object>
	
</div>


<%
	//System.out.println("vao trong if==LOAD DUOC FILE=: getRequestCode=:"+getRequestCode+"==UrlFile=="+UrlFile);
	} else if (getRequestCode.trim().length() > 0 && messageTypeReport != MessageType.BAN_KHAI_HANH_LY_HANH_KHACH_ROI_TAU && (loaiThuTucReport ==MessageType.LOAT_THU_TUC_ROI_CANG || loaiThuTucReport ==MessageType.LOAT_THU_TUC_VAO_CANG )){
%>
<div>
	<OBJECT data="<%=UrlFile%>#view=FitH&scrollbar=0&amp;page=1&toolbar=0&statusbar=0&messages=0&navpanes=0"
			type="text/html"
			TITLE="SamplePdf"
			WIDTH="100%"
			HEIGHT="800px"
			style="background: white;
			min-height: 100%;"  >
		<a href="<%=UrlFileDowLoad%>">Tải xuống file</a> 
	</object>
	
</div>

<%
	//System.out.println("vao trong if==LOAD DUOC FILE=: getRequestCode=:"+getRequestCode+"==UrlFile=="+UrlFile);
	}
	%>