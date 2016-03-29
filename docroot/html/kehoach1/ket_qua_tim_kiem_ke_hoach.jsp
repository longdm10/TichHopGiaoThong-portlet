<%@page import="vn.gt.dao.noticeandmessage.model.InterfaceRequestField"%>
<%@page import="vn.gt.dao.noticeandmessage.service.InterfaceRequestFieldLocalServiceUtil"%>
<%@page import="vn.gt.menu.MenuConstraint"%>
<%@page import="javax.portlet.PortletSession"%>
<%@page import="vn.gt.dao.common.service.UserPortLocalServiceUtil"%>
<%@page import="vn.gt.dao.common.model.UserPort"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="vn.gt.utils.CheckBusinessUtil"%>
<%@page import="vn.gt.dao.danhmuc.model.DmPortRegion"%>
<%@page import="vn.gt.dao.danhmuc.service.DmPortRegionLocalServiceUtil"%>
<%@page import="vn.gt.dao.noticeandmessage.service.persistence.TempDocumentFinderUtil"%>
<%@page import="vn.gt.utils.KeyParams"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="vn.gt.portlet.Utils"%>
<%@page import="vn.gt.dao.noticeandmessage.service.InterfaceRequestLocalServiceUtil"%>
<%@page import="vn.gt.dao.noticeandmessage.model.InterfaceRequest"%>
<%@page import="vn.gt.dao.danhmuc.service.DmHistoryStateLocalServiceUtil"%>
<%@page import="vn.gt.dao.danhmuc.model.DmHistoryState"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="vn.gt.utils.ActionUtils"%>
<%@page import="vn.gt.dao.danhmucgt.service.DmGtStatusLocalServiceUtil"%>
<%@page import="vn.gt.dao.danhmucgt.model.DmGtStatus"%>
<%@page import="vn.gt.dao.danhmuc.service.impl.DmHistoryShipAgencyLocalServiceImpl"%>
<%@page import="vn.gt.dao.danhmuc.service.DmHistoryShipAgencyLocalServiceUtil"%>
<%@page import="vn.gt.dao.danhmuc.model.DmHistoryShipAgency"%>
<%@page import="vn.gt.utils.FormatData"%>
<%@page import="vn.gt.dao.danhmuc.service.DmDocTypeLocalServiceUtil"%>
<%@page import="vn.gt.dao.danhmuc.model.impl.DmDocTypeImpl"%>
<%@page import="vn.gt.dao.danhmuc.service.impl.DmDocTypeLocalServiceImpl"%>
<%@page import="vn.gt.dao.danhmuc.model.DmDocType"%>
<%@page import="vn.gt.dao.danhmuc.service.impl.DmArrivalPurposeLocalServiceImpl"%>
<%@page import="vn.gt.dao.danhmuc.model.DmArrivalPurpose"%>
<%@page import="vn.gt.dao.noticeandmessage.model.TempDocument"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="vn.gt.utils.PageType"%>
<%@page import="vn.gt.tichhop.message.MessageType"%>
<%@page import="vn.gt.dao.noticeandmessage.service.TempDocumentLocalServiceUtil"%>
<%@page pageEncoding="UTF-8"%>
<%@ include file="/html/init.jsp"%>

<%
	String loaiThuTuc = "";
	if (portletSession.getAttribute(MessageType.LOAT_THU_TUC, PortletSession.APPLICATION_SCOPE) != null) {
		loaiThuTuc = (String)portletSession.getAttribute(MessageType.LOAT_THU_TUC, PortletSession.APPLICATION_SCOPE);
	}

	String mabankhai = ParamUtil.getString(request, KeyParams.MA_BAN_KHAI).trim();
	String maritimeCode = ParamUtil.getString(request, KeyParams.MARITIME_CODE).trim();
	String shipName = ParamUtil.getString(request, KeyParams.SHIP_NAME).trim();
	String positionCode = ParamUtil.getString(request, KeyParams.POSITION_CODE).trim();
	String portRegionCode = ParamUtil.getString(request, KeyParams.PORT_REGION_CODE).trim();
	
	String stateCode = ParamUtil.getString(request, KeyParams.STATE_CODE).trim();
	
	String shipDateFromStart = ParamUtil.getString(request, KeyParams.SHIP_DATE_FROM_START).trim();
	String shipDateFromEnd = ParamUtil.getString(request, KeyParams.SHIP_DATE_FROM_END).trim();
	
	String shipDateToStart = ParamUtil.getString(request, KeyParams.SHIP_DATE_TO_START).trim();
	String shipDateToEnd = ParamUtil.getString(request, KeyParams.SHIP_DATE_TO_END).trim();
	
	String requestState = ParamUtil.getString(request, KeyParams.REQUEST_STATUS).trim();
	String callSign = ParamUtil.getString(request, KeyParams.CALL_SIGN).trim();
	String imo = ParamUtil.getString(request, KeyParams.IMO).trim();
	
	String ngayLamThuTucFrom = ParamUtil.getString(request, "ngayLamThuTucFrom").trim();
	String ngayLamThuTucTo = ParamUtil.getString(request, "ngayLamThuTucTo").trim();
	
	PortletURL portletUrl = renderResponse.createRenderURL();
	
	portletUrl.setParameter(KeyParams.MA_BAN_KHAI, mabankhai);
	portletUrl.setParameter(KeyParams.MARITIME_CODE, maritimeCode);
	portletUrl.setParameter(KeyParams.SHIP_NAME, shipName);
	portletUrl.setParameter(KeyParams.POSITION_CODE, positionCode);
	portletUrl.setParameter(KeyParams.PORT_REGION_CODE, portRegionCode);
	portletUrl.setParameter(KeyParams.STATE_CODE, stateCode);
	
	portletUrl.setParameter(KeyParams.SHIP_DATE_FROM_START, shipDateFromStart);
	portletUrl.setParameter(KeyParams.SHIP_DATE_FROM_END, shipDateFromEnd);
	
	portletUrl.setParameter(KeyParams.SHIP_DATE_TO_START, shipDateToEnd);
	portletUrl.setParameter(KeyParams.SHIP_DATE_TO_START, shipDateToEnd);
	
	portletUrl.setParameter(KeyParams.REQUEST_STATUS, requestState);
	portletUrl.setParameter(KeyParams.CALL_SIGN, callSign);
	portletUrl.setParameter(KeyParams.IMO, imo);
	portletUrl.setParameter(MenuConstraint.SESSION_MENU_SELECTED, ParamUtil.getString(request, MenuConstraint.SESSION_MENU_SELECTED));
	
	String transactionKeyword = URLDecoder.decode(ParamUtil.getString(request, "transactionKeyword"), StringPool.UTF8);
	
	SearchContainer searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, 20, portletUrl, null, null);
	
	User userLogin = PortalUtil.getUser(request);
	UserPort portDefault = UserPortLocalServiceUtil.findByUserId(userLogin.getUserId());
	if (Validator.isNull(portDefault)) {
		//not do something
	} else {
		if (Validator.isNull(maritimeCode)) {
			maritimeCode = portDefault.getPortCode();;
		}
	}
	
	if (Validator.isNull(positionCode)) {
		String message = Utils.checkLoaiThuTuc(loaiThuTuc);
		
		if (MessageType.LOAT_THU_TUC_NHAP_CANH == message || MessageType.LOAT_THU_TUC_QUA_CANH == message) {
			positionCode = "1";
			
		} else if (MessageType.LOAT_THU_TUC_XUAT_CANH == message) {
			positionCode = "3";
			
		}else if (MessageType.LOAT_THU_TUC_VAO_CANG == message) {
			positionCode = "1";			
		}else if (MessageType.LOAT_THU_TUC_ROI_CANG == message) {
			positionCode = "3";
			
		} else if (MessageType.LOAT_THU_TUC_DANG_DI_CHUYEN == message) {
			positionCode = "";
		}
	}
	
	if (Validator.isNull(requestState) || requestState.equalsIgnoreCase("")) {
		requestState = CheckBusinessUtil.getTrangThaiHoSoDefaultForm(MessageType.ROLE_KE_HOACH);
	}
	
	List<TempDocument> results = null;
	//results = TempDocumentLocalServiceUtil.findTempDocumentByRequestState("11,12,13,14,15,16,17", Utils.checkLoaiThuTuc(loaiThuTuc), searchContainer.getStart(), searchContainer.getEnd());
	results = TempDocumentLocalServiceUtil.findTempDocumentByKeHoach(requestState, Utils.checkLoaiThuTuc(loaiThuTuc),
		maritimeCode, shipName, positionCode, portRegionCode, mabankhai, stateCode,
		shipDateFromStart, shipDateFromEnd, shipDateToStart, shipDateToEnd,
		callSign, imo, ngayLamThuTucFrom, ngayLamThuTucTo, searchContainer.getStart(), searchContainer.getEnd());
			
	
	if (results == null) { results = new ArrayList<TempDocument>(); }
	
	long longTotal = TempDocumentLocalServiceUtil.countTempDocumentByKeHoach(requestState, Utils.checkLoaiThuTuc(loaiThuTuc),
		maritimeCode, shipName, positionCode, portRegionCode, mabankhai, stateCode,
		shipDateFromStart, shipDateFromEnd, shipDateToStart, shipDateToEnd,
		callSign, imo, ngayLamThuTucFrom, ngayLamThuTucTo);
	//long longTotal = TempDocumentLocalServiceUtil.countTempDocumentByRequestState("11,12,13,14,15,16,17", Utils.checkLoaiThuTuc(loaiThuTuc));
	
	searchContainer.setTotal(Integer.parseInt(String.valueOf(longTotal)));
	searchContainer.setResults(results);
	
	String tenLoaiThuTuc = "Danh sách tàu thuyền đến và rời cảng biển";
	if (portletSession.getAttribute(MessageType.LOAT_THU_TUC_TEN, PortletSession.APPLICATION_SCOPE) != null) {
		tenLoaiThuTuc = (String)portletSession.getAttribute(MessageType.LOAT_THU_TUC_TEN, PortletSession.APPLICATION_SCOPE);
	}
%>

<div class="wd-content-container bgdanhsach">
	<h2 class="tlemenu"><%=tenLoaiThuTuc %></h2>
	<div class="boxnd">
		<table class="wd-table"> 
			<thead>
				<tr>
					<th  width="15px"><liferay-ui:message key="vn.dtt.kehoach.stt" /></th>
					<th><liferay-ui:message  key="vn.dtt.kehoach.tinhtrang" /></th>
					<th><liferay-ui:message key="vn.dtt.kehoach.mabankhai" /></th>
					<th><liferay-ui:message  key="vn.dtt.kehoach.tentau" /></th>
					<th><liferay-ui:message key="vn.dtt.kehoach.hohieu" /></th>
					<th><liferay-ui:message key="vn.dtt.kehoach.IMO" /></th>
					<th><liferay-ui:message  key="vn.dtt.kehoach.quoctich" /></th>
					
					<%if (loaiThuTuc.trim().length() == 0 || loaiThuTuc.compareTo(MessageType.LOAT_THU_TUC_NHAP_CANH) == 0 || loaiThuTuc.compareTo(MessageType.LOAT_THU_TUC_VAO_CANG) == 0) {%>
						<th><liferay-ui:message key="vn.dtt.kehoach.danhsach.thoigianden" /></th>
						
					<%} else if (loaiThuTuc.compareTo(MessageType.LOAT_THU_TUC_XUAT_CANH) == 0 || loaiThuTuc.compareTo(MessageType.LOAT_THU_TUC_ROI_CANG) == 0) {%>
						<th><liferay-ui:message key="vn.dtt.kehoach.danhsach.thoigianroi" /></th>
						
					<%} else if (loaiThuTuc.compareTo(MessageType.LOAT_THU_TUC_QUA_CANH) == 0) {%>
						<th><liferay-ui:message key="vn.dtt.kehoach.thoigianquacanh" /></th>
						
					<%} else if (loaiThuTuc.compareTo(MessageType.LOAT_THU_TUC_DANG_DI_CHUYEN) == 0) {%>
						<th><liferay-ui:message key="vn.dtt.kehoach.danhsach.thoigianden" /></th>
						<th><liferay-ui:message key="vn.dtt.kehoach.danhsach.thoigianroi" /></th>
					<%}%>
					<th><liferay-ui:message  key="vn.dtt.kehoach.nguoikhai" /></th>
					<th>Thời gian nộp hồ sơ </th>
					<th width="100px"><liferay-ui:message  key="vn.dtt.kehoach.thaotac" /></th>
				</tr>
			</thead>
			<tbody>
			<%
			TempDocument temDoc = null;
			DmGtStatus dmGtStatus = null;
			DmHistoryState dmHistoryState = null;
			InterfaceRequestField interfaceRequest = null;
			for (int i = 0; i < results.size(); i++) {
				temDoc = (TempDocument) results.get(i);
				dmGtStatus = DmGtStatusLocalServiceUtil.findByStatusCode(temDoc.getRequestState(), MessageType.ROLE_KE_HOACH);
				dmHistoryState = DmHistoryStateLocalServiceUtil.getByStateCode(temDoc.getStateCode());
				interfaceRequest = InterfaceRequestFieldLocalServiceUtil.getByRequestCode(temDoc.getRequestCode());
			%>
			<portlet:renderURL var="xemHoSo">
				<portlet:param name="jspPage" value="/html/kehoach/view.jsp" />
				<portlet:param name="<%=PageType.DOCUMENT_NAME %>" value="<%=String.valueOf(temDoc.getDocumentName())%>" />
				<portlet:param name="<%=PageType.DOCUMENT_YEAR %>" value="<%=String.valueOf(temDoc.getDocumentYear())%>" />
				<portlet:param name="<%=PageType.MESSAGE_TYPE %>" value="<%=String.valueOf(PageType.THANH_PHAN_HO_SO)%>" />
				<portlet:param name="<%=String.valueOf(PageType.PAGE_TYPE) %>" value="<%=String.valueOf(PageType.KE_HOACH_DETAIL)%>" />
				<portlet:param name="<%=MenuConstraint.SESSION_MENU_SELECTED%>" value="<%=ParamUtil.getString(request, MenuConstraint.SESSION_MENU_SELECTED)%>" />
			</portlet:renderURL>
			
			<tr <%=CheckBusinessUtil.checkColorKeHoach(temDoc.getRequestState()) %>>
				<td><%=(searchContainer.getStart() +  (i+1))%></td>
				<td class="text-left"><%=Validator.isNotNull(dmGtStatus) ? dmGtStatus.getStatusName() : temDoc.getRequestState() %></td>
				<td class="text-left"><%=Validator.isNotNull(temDoc.getDocumentName()) ? temDoc.getDocumentName() : ""%></td>
				<td class="text-left"><%=Validator.isNotNull(temDoc.getShipName()) ? temDoc.getShipName() : ""%></td>
				<td class="text-left"><%=Validator.isNotNull(temDoc.getCallSign()) ? temDoc.getCallSign() : ""%></td>
				<td class="text-left"><%=Validator.isNotNull(temDoc.getImo()) ? temDoc.getImo() : ""%></td>
				<td class="text-left"><%=Validator.isNotNull(dmHistoryState) ? dmHistoryState.getStateName() : temDoc.getStateCode()%></td>

				<%if (loaiThuTuc.trim().length() == 0 || loaiThuTuc.compareTo(MessageType.LOAT_THU_TUC_NHAP_CANH) == 0 || loaiThuTuc.compareTo(MessageType.LOAT_THU_TUC_QUA_CANH) == 0 || loaiThuTuc.compareTo(MessageType.LOAT_THU_TUC_VAO_CANG) == 0) {%>
					<td class="text-left"><%=FormatData.parseDateToTringType3(temDoc.getShipDateFrom())%></td>
					
				<%} else if (loaiThuTuc.compareTo(MessageType.LOAT_THU_TUC_XUAT_CANH) == 0 || loaiThuTuc.compareTo(MessageType.LOAT_THU_TUC_ROI_CANG) == 0) {%>
					<td class="text-left"><%=FormatData.parseDateToTringType3(temDoc.getShipDateTo())%></td>
					
				<%} else if (loaiThuTuc.compareTo(MessageType.LOAT_THU_TUC_DANG_DI_CHUYEN) == 0) {
					if (temDoc.getDocumentTypeCode().equals(MessageType.LOAT_THU_TUC_NHAP_CANH) || temDoc.getDocumentTypeCode().equals(MessageType.LOAT_THU_TUC_QUA_CANH) || temDoc.getDocumentTypeCode().equals(MessageType.LOAT_THU_TUC_VAO_CANG)) {
					%>
						<td class="text-left"><%=FormatData.parseDateToTringType3(temDoc.getShipDateFrom())%></td>
						<td class="text-left"></td>
						
					<%} else if (temDoc.getDocumentTypeCode().equals(MessageType.LOAT_THU_TUC_XUAT_CANH) || temDoc.getDocumentTypeCode().equals(MessageType.LOAT_THU_TUC_ROI_CANG)) {%>
						<td class="text-left"></td>
						<td class="text-left"><%=FormatData.parseDateToTringType3(temDoc.getShipDateTo())%></td>
						
					<%}%>
				<%}%>
				
				<td class="text-left"><%=Validator.isNotNull(interfaceRequest) ? interfaceRequest.getSenderName() : temDoc.getRequestCode()%></td>
				<td class="text-left"><%=Validator.isNotNull(temDoc.getCreatedDate()) ? FormatData.parseDateToTringType3(temDoc.getCreatedDate()) : ""%></td>
				<td class="text-left">
					<a href="<%=xemHoSo.toString()%>">
					<img src="<%=request.getContextPath()%>/img/icon/icon_xemhs.png"></a>
				</td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<div class="tongso">
		<liferay-ui:search-paginator searchContainer="<%= searchContainer %>" />
	</div>
</div>