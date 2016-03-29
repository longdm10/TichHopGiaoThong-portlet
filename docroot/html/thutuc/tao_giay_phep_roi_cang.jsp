<%@page import="vn.gt.tichhop.message.TrangThaiBanKhaiXuatCanh"%>
<%@page import="vn.gt.tichhop.message.MessageType"%>
<%@page import="vn.gt.portlet.thutuc.ThuTucAction"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="vn.gt.utils.KeyParams"%>
<%@page import="vn.gt.dao.danhmuc.service.DmRepresentativeLocalServiceUtil"%>
<%@page import="vn.gt.dao.danhmuc.model.DmRepresentative"%>
<%@page import="vn.gt.dao.noticeandmessage.model.impl.IssuePortClearanceImpl"%>
<%@page import="java.util.Random"%>
<%@page import="vn.gt.utils.ConvertUtil"%>
<%@page import="java.util.UUID"%>
<%@page import="vn.gt.dao.danhmuc.model.impl.DmGoodsTypeImpl"%>
<%@page import="vn.gt.dao.danhmuc.service.DmGoodsTypeLocalServiceUtil"%>
<%@page import="vn.gt.dao.danhmuc.model.DmGoodsType"%>
<%@page import="vn.gt.dao.danhmuc.model.impl.DmMaritimeImpl"%>
<%@page import="vn.gt.dao.danhmuc.service.DmMaritimeLocalServiceUtil"%>
<%@page import="vn.gt.dao.danhmuc.model.DmMaritime"%>
<%@page import="vn.gt.dao.noticeandmessage.model.impl.TempGeneralDeclarationImpl"%>
<%@page import="vn.gt.dao.noticeandmessage.service.TempGeneralDeclarationLocalServiceUtil"%>
<%@page import="vn.gt.dao.noticeandmessage.model.TempGeneralDeclaration"%>
<%@page import="vn.gt.dao.danhmuc.model.impl.DmPortImpl"%>
<%@page import="vn.gt.dao.common.service.UserPortLocalServiceUtil"%>
<%@page import="vn.gt.dao.common.model.UserPort"%>
<%@page import="vn.gt.dao.danhmuc.service.DmStateLocalServiceUtil"%>
<%@page import="vn.gt.dao.danhmuc.model.DmState"%>
<%@page import="vn.gt.dao.danhmuc.service.DmUnitGeneralLocalServiceUtil"%>
<%@page import="vn.gt.dao.danhmuc.model.DmUnitGeneral"%>
<%@page import="vn.gt.utils.PageType"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="vn.gt.dao.danhmuc.service.DmPortLocalServiceUtil"%>
<%@page import="vn.gt.dao.danhmuc.model.DmPort"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="vn.gt.dao.noticeandmessage.model.impl.TempDocumentImpl"%>
<%@page import="vn.gt.dao.noticeandmessage.service.TempDocumentLocalServiceUtil"%>
<%@page import="vn.gt.dao.noticeandmessage.model.impl.TempNoTiceShipMessageImpl"%>
<%@page import="vn.gt.dao.noticeandmessage.service.TempNoTiceShipMessageLocalServiceUtil"%>
<%@page import="vn.gt.dao.noticeandmessage.model.TempNoTiceShipMessage"%>
<%@page import="vn.gt.dao.noticeandmessage.model.TempDocument"%>
<%@page import="vn.gt.utils.FormatData"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="java.util.List"%>
<%@page import="vn.gt.dao.noticeandmessage.service.IssuePortClearanceLocalServiceUtil"%>
<%@page import="vn.gt.dao.noticeandmessage.model.IssuePortClearance"%>
<%@page import="javax.portlet.PortletSession"%>
<%@page pageEncoding="UTF-8"%>
<%@ include file="/html/init.jsp"%>

<%
	String loaiThuTuc = "";
	if (portletSession.getAttribute(MessageType.LOAT_THU_TUC, PortletSession.APPLICATION_SCOPE) != null) {
		loaiThuTuc = (String)portletSession.getAttribute(MessageType.LOAT_THU_TUC, PortletSession.APPLICATION_SCOPE);
	}

	String documentName = renderRequest.getParameter(PageType.DOCUMENT_NAME);
	String messageType = renderRequest.getParameter(PageType.MESSAGE_TYPE);
	int documentYear = FormatData.convertToInt(renderRequest.getParameter(PageType.DOCUMENT_YEAR));
	String requestCodethuTuc = ParamUtil.getString(request, PageType.REQUEST_CODE);
	
	//du lieu lay tu, Temp_Document, fill NT, DWT from DmDocument
	TempDocument tempDoc = TempDocumentLocalServiceUtil.findTemDocumentByDocumentNameDocumentYear(FormatData.convertToLong(documentName), documentYear);
	if (Validator.isNull(tempDoc)) { tempDoc = new TempDocumentImpl(); }
	
	//du lieu lay loai hang hoa
	//Thong bao moi nhat
	TempNoTiceShipMessage thongBaoLast = TempNoTiceShipMessageLocalServiceUtil.getThongBaoLastByDocumentNameAndDocumentYear(FormatData.convertToLong(documentName), documentYear);
	//List<TempNoTiceShipMessage> tempNoticeShipList = TempNoTiceShipMessageLocalServiceUtil.findBydocumentNameAndDocumentYearAndNoticeShipType(FormatData.convertToLong(documentName), documentYear, PageType.TYPE_THONG_BAO_TAU_DEN_CANG);
	//if (tempNoticeShipList != null && tempNoticeShipList.size() > 0) {
	//	tempNoticeShip = tempNoticeShipList.get(0);
	//} else {
	//	tempNoticeShip = new TempNoTiceShipMessageImpl();
	//}
	if (Validator.isNull(thongBaoLast)) { thongBaoLast = new TempNoTiceShipMessageImpl(); }
	
	TempGeneralDeclaration banKhaiChungLast = TempGeneralDeclarationLocalServiceUtil.getLastByDocumentNameAndDocumentYear(FormatData.convertToLong(documentName), documentYear);
	if (Validator.isNull(banKhaiChungLast)) { banKhaiChungLast = new TempGeneralDeclarationImpl(); }
	
	DmGoodsType dmGoodsType = DmGoodsTypeLocalServiceUtil.getByGoodsTypeCode(thongBaoLast.getTypeOfCargo());
	if (Validator.isNull(dmGoodsType)) {
		dmGoodsType = new DmGoodsTypeImpl();
	}
	
	DmState dmState = DmStateLocalServiceUtil.getByStateCode(Validator.isNotNull(banKhaiChungLast.getFlagStateOfShip()) ? banKhaiChungLast.getFlagStateOfShip() : tempDoc.getStateCode());
	String maStCode = "";
	if(dmState == null) {
		maStCode = "";
	} else {
		maStCode = dmState.getStateCode();
	}
	
	//fill du lieu cang den
	UserPort userPort = UserPortLocalServiceUtil.findByUserId(user.getUserId());
	List<DmPort> ports = null;
	if (userPort != null) { ports = DmPortLocalServiceUtil.findByLoCode(userPort.getPortCode()); }
	if (Validator.isNull(ports)) { ports = new ArrayList<DmPort>(); }
	
	DmPort cangRoiLast = DmPortLocalServiceUtil.getByPortCode(banKhaiChungLast.getPortOfArrivalCode());
	if (Validator.isNull(cangRoiLast)) { cangRoiLast = new DmPortImpl(); }
	
	List<DmUnitGeneral> units = DmUnitGeneralLocalServiceUtil.getDmUnitGenerals(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	if (Validator.isNull(units)) { units = new ArrayList<DmUnitGeneral>(); }
	
	
	DmMaritime maritime = DmMaritimeLocalServiceUtil.getByMaritimeCode(tempDoc.getMaritimeCode());
	if (Validator.isNull(maritime)) { maritime = new DmMaritimeImpl(); }
	
	IssuePortClearance portClearanceEdit = IssuePortClearanceLocalServiceUtil.getByRequestCode(requestCodethuTuc);
	if (Validator.isNull(portClearanceEdit)) { portClearanceEdit = new IssuePortClearanceImpl(); }
	
	//tempDoc = TempDocumentLocalServiceUtil.findTemDocumentByDocumentNameDocumentYear(FormatData.convertToLong(documentName), documentYear);
	
	int countPortClearance = IssuePortClearanceLocalServiceUtil.countByDocumentNameAndDocumentYear(FormatData.convertToLong(documentName), documentYear);
	
	String capPortClearance = ParamUtil.getString(request, PageType.LAN_CAP_PORT_CLEARANCE);
	
	String lyDoCapLaiGiayPhep = ParamUtil.getString(request, PageType.HUY_HO_SO);

	
	LogFactoryUtil.getLog(ThuTucAction.class).info("===/tao_giay_phep_roi_cang.jsp===request_ThuTuc======" + requestCodethuTuc);
	LogFactoryUtil.getLog(ThuTucAction.class).info("===/tao_giay_phep_roi_cang.jsp===count_PortClearance=" + countPortClearance);
	LogFactoryUtil.getLog(ThuTucAction.class).info("===/tao_giay_phep_roi_cang.jsp===cap_PortClearance===" + capPortClearance);
	LogFactoryUtil.getLog(ThuTucAction.class).info("===/tao_giay_phep_roi_cang.jsp===lyDoCapLaiGiayPhep===" + lyDoCapLaiGiayPhep);
%>

<script type="text/javascript">var imageFilesPath = '<%=request.getContextPath()%>'+"/img/";</script>

<div style="height: 10px">&nbsp;</div>
<div style="width: 100%; text-align: center; font-weight: bolder;">GIẤY PHÉP RỜI CẢNG</div>
<div style="height: 20px">&nbsp;</div>
<div class="AccordionPanelContent">

	<!--------------------------------- COLUMN 1  --------------------------------->
	<div class="tbl_left boxlabel" style="width: 33.33%">
		<table class="table_noboder">
			<thead>
				<tr>
					<input type="text" hidden="true" name="maritimeCode" value="<%=tempDoc.getMaritimeCode()%>">
					<input type="text" hidden="true" name="stateCode" value="<%=tempDoc.getStateCode()%>">
					<input type="text" hidden="true" id="idPortClearance" name="idPortClearance" value="<%=Validator.isNotNull(portClearanceEdit.getId()) ? portClearanceEdit.getId() : StringPool.BLANK%>">
					<input type="text" hidden="true" id="requestCodePortClearance" name="requestCodePortClearance" value="<%=Validator.isNotNull(portClearanceEdit.getRequestCode()) ? portClearanceEdit.getRequestCode() : UUID.randomUUID().toString()%>">
					<input type="text" hidden="true" id="numberPortClearance" name="numberPortClearance" value="<%=Validator.isNotNull(portClearanceEdit.getNumberPortClearance()) ? portClearanceEdit.getNumberPortClearance() : String.valueOf(new Random().nextInt(100000))%>">
					<input type="text" hidden="true" id="lyDoCapLaiPortClearance" name="lyDoCapLaiPortClearance" value="<%=lyDoCapLaiGiayPhep%>">
					
					<th class="text-left" width="30%"><liferay-ui:message key="vn.dtt.thutuc.tentau" /></th>
					<td class="text-leftu">
						<input type="text" class="egov-inputfield" readonly="readonly" style="width: 98%"
								name="nameOfship" id="nameOfship"
								value="<%=tempDoc.getShipName()%>">
					</td>
				</tr>
				<tr>
					<th class="text-left" width="30%"><liferay-ui:message key="vn.dtt.thutuc.gt" /></th>
					<td class="text-leftu">
						<input type="text" style="width: 98%" class="egov-inputfield" readonly="readonly"
								name="grt" id="grt" 
								value="<%=tempDoc.getGrt()%>">
					</td>
				</tr>
				<tr>
					<th class="text-left" width="30%"><liferay-ui:message key="vn.dtt.thutuc.tenthuyentruong" /></th>
					<td class="text-leftu">
						<input type="text" style="width: 98%" class="egov-inputfield" readonly="readonly"
								name="nameOfMaster" id="nameOfMaster"
								value="<%=tempDoc.getShipCaptain()%>">
					</td>
				</tr>
				
				<tr>
					<th class="text-left" width="30%"><liferay-ui:message key="vn.dtt.thutuc.loaihanghoa" /></th>
					<td class="text-leftu">
						<%
						String sLoaiHangHoa = "";
						String loaiHangHoa = "";
						if (dmGoodsType.getGoodsTypeNameVN() != null && dmGoodsType.getGoodsTypeNameVN().trim().length() > 0) {
							sLoaiHangHoa = dmGoodsType.getGoodsTypeNameVN();
							loaiHangHoa = dmGoodsType.getGoodsTypeCode();
						} else if (dmGoodsType.getGoodsTypeName() != null) {
							sLoaiHangHoa = dmGoodsType.getGoodsTypeName();
							loaiHangHoa = dmGoodsType.getGoodsTypeCode();
						} else {
							sLoaiHangHoa = thongBaoLast.getTypeOfCargo();
							loaiHangHoa = thongBaoLast.getTypeOfCargo();
						}
						%>
						
						<input type="text" style="width: 98%" class="egov-inputfield" readonly="readonly"
								name="holdTypeOfCargo" id="holdTypeOfCargo"
								value="<%=sLoaiHangHoa%>">
								
						<input type="text" hidden="true"
								name="typeOfCargo" id="typeOfCargo"
								value="<%=loaiHangHoa%>">
					</td>
				</tr>
				
				<%
					if(loaiThuTuc != null && loaiThuTuc.trim().compareTo(MessageType.LOAT_THU_TUC_ROI_CANG) != 0){
				%>
				<!-- loai hang hoa qua canh -->
				<tr>
					<th class="text-left" width="30%"><liferay-ui:message key="vn.dtt.thutuc.loaihanghoaquacanh" />&nbsp;<span style="color:#FF0000;">(*)</th>
					<td class="text-leftu">
						<input type="text" style="width: 98%" class="egov-inputfield" required
								name="transitOfCargo"
								id="transitOfCargo"
								value="<%= Validator.isNotNull(portClearanceEdit.getTransitCargo()) ? portClearanceEdit.getTransitCargo() : "As per Manifest"%>">
					</td>
				</tr>
				
				<%
					}
				%>
				<!-- ???? date of arrival of row cuoi cung ban khai chung, -->
				<%
					List<TempGeneralDeclaration> datadateofarrivals =  TempGeneralDeclarationLocalServiceUtil.findByDocumentNameAndDocumentYear(FormatData.convertToLong(documentName), documentYear);
					TempGeneralDeclaration dateofarrival = null;
					if(Validator.isNotNull(datadateofarrivals) && datadateofarrivals.size() > 0) {
						dateofarrival = datadateofarrivals.get(datadateofarrivals.size() - 1);
					}
					if (Validator.isNull(dateofarrival)) {
						dateofarrival = new TempGeneralDeclarationImpl();
					}
					String sTimeOfDeparture = "";
					if (Validator.isNotNull(portClearanceEdit.getTimeOfDeparture())) {
						sTimeOfDeparture = FormatData.parseDateToTringType3(portClearanceEdit.getTimeOfDeparture());
					} else {
						sTimeOfDeparture = FormatData.parseDateToTringType3(Validator.isNotNull(dateofarrival.getDateOfArrival()) ? dateofarrival.getDateOfArrival() : new Date());
					}
					
					String thoigianroicangg = "";
					thoigianroicangg = FormatData.parseDateToTringType3(tempDoc.getShipDateTo());
					System.out.print("======ThoiGian roi cang===  "+ thoigianroicangg );
					String gprc = "";
					
					List<IssuePortClearance> lstTaoOrSuaGiayPhepXuatCanh =
			       			IssuePortClearanceLocalServiceUtil.findByDocumentYearAndDocumentYearOrderByColumn(
			       				FormatData.convertToLong(documentName), documentYear, KeyParams.VERSION_NO, KeyParams.ORDER_BY_DESC);
					if(messageType.compareTo(String.valueOf(MessageType.GIAY_PHEP_ROI_CANG_BO_GTVT_CAP_KHI_XUAT_CANH)) == 0 &&
	          				lstTaoOrSuaGiayPhepXuatCanh != null && lstTaoOrSuaGiayPhepXuatCanh.size() == 0 && tempDoc.getDocumentStatusCode() == TrangThaiBanKhaiXuatCanh.DE_NGHI_CAP_GIAY_PHEP) {
						gprc = thoigianroicangg;
						System.out.print("======ThoiGian roi cang gprc===  "+ gprc );
					} else {
						gprc = sTimeOfDeparture;
						System.out.print("======ThoiGian roi cang gprc===else  "+ gprc );
					}
				%>
				<tr>
					<th class="text-left" width="30%"><liferay-ui:message key="vn.dtt.thutuc.thoigianroicang" />&nbsp;<span style="color:#FF0000;">(*)</span></th>
					<td class="text-leftu">
						<input type="text" style="width: 98%" required
								id="timeOfDeparture"
								name="timeOfDeparture"
								value="<%=gprc%>"
								onclick="gtCalendar('timeOfDeparture')">
					</td>
				</tr>
				
				
				
				<!-- ??? thoi gian hieu luc = thoigianroicang + 24h 1 ngay -->
				<!-- ??? thoi gian hieu luc = thoigianHIENTAI + 24h 1 ngay -->
				<%
					String sTimeOfValidUntil = "";
					//if (Validator.isNotNull(portClearanceEdit.getValidUntil())) {
					//	sTimeOfValidUntil = FormatData.parseDateToTringType3(portClearanceEdit.getValidUntil());
					//} else {
					//	sTimeOfValidUntil = FormatData.congNgay(Validator.isNotNull(dateofarrival.getDateOfArrival()) ? dateofarrival.getDateOfArrival() : new Date());
					//}
					sTimeOfValidUntil = FormatData.congNgay(new Date());
				%>
				<tr>
					<th class="text-left" width="30%"><liferay-ui:message key="vn.dtt.thutuc.thoigianhieuluc" />&nbsp;<span style="color:#FF0000;">(*)</span></th>
					<td class="text-leftu">
						<input type="text" style="width: 98%" required="true"
								id="timeOfValidUntil"
								name="timeOfValidUntil"
								value="<%=sTimeOfValidUntil%>"
								onclick="gtCalendar('timeOfValidUntil')">
					</td>
				</tr>
			</thead>
		</table>
	</div>
	
	<!----------- COLUMN 2 ----------->
	<div class="tbl_left boxlabel" style="width: 33.33%">
		<table class="table_noboder">
			<thead>
				<tr>
					<th class="text-left" width="30%"><liferay-ui:message key="vn.dtt.thutuc.quoctich" /></th>
					<td class="text-leftu" colspan="2">
					<%
						List<DmState> lstState = DmStateLocalServiceUtil.getDmStates(QueryUtil.ALL_POS, QueryUtil.ALL_POS);					
							if(lstState != null && lstState.size() > 0){
								for(DmState state:lstState){
									if("VN".equals(state.getStateCode())){
										%>
											<input type="text" hidden="true" name="stateCode" id="stateCode" value="<%=tempDoc.getStateCode()%>">
											<input type="text" style="width: 98%" class="egov-inputfield" readonly="true" value="<%=state.getStateName()%>">
										<%
									}
								}
							}
						%>						
					</td>
				</tr>
				<tr>
					<th class="text-left" width="30%"><liferay-ui:message key="vn.dtt.thutuc.nt" /></th>
					<td class="text-leftu" colspan="2">
						<input type="text" style="width: 98%" class="egov-inputfield" readonly="true"
								name="nt" id="nt"
								value="<%=Validator.isNotNull(tempDoc.getNt()) ? tempDoc.getNt() : StringPool.BLANK%>">
					</td>
				</tr>
				
				<tr>
					<th class="text-left" width="30%"><liferay-ui:message key="vn.dtt.thutuc.soluongthuyenvien" /></th>
					<td class="text-leftu" colspan="2">
						<input type="text" hidden="true"
								name="numberOfCrews" id="numberOfCrews"
								value="<%=Validator.isNotNull(banKhaiChungLast.getNumberOfCrew()) ? (banKhaiChungLast.getNumberOfCrew()) :
									(Validator.isNotNull(thongBaoLast.getCrewNumber()) ? thongBaoLast.getCrewNumber() : StringPool.BLANK)%>">
						<input type="text" style="width: 98%" class="egov-inputfield"
								readonly="true"
								value="<%=Validator.isNotNull(banKhaiChungLast.getNumberOfCrew()) ? (banKhaiChungLast.getNumberOfCrew() + " Pers") : 
									(Validator.isNotNull(thongBaoLast.getCrewNumber()) ? (thongBaoLast.getCrewNumber() + " Pers") : StringPool.BLANK)%>">
					</td>
				</tr>
				
				<!-- so luong loai hang hoa-->
				<tr>
					<th class="text-left" width="30%"><liferay-ui:message key="vn.dtt.thutuc.soluong" /></th>
					<td class="text-leftu">
						<input type="text" style="width: 48%" class="egov-inputfield" readonly="true"
								name="volumeCargo" id="volumeCargo"
								value="<%= (Validator.isNotNull(thongBaoLast.getQuantityAndTypeOfCargo()) ? thongBaoLast.getQuantityAndTypeOfCargo() : StringPool.BLANK)%>">
						<%
						for (DmUnitGeneral unit : units) {
							if (unit.getUnitCode().equalsIgnoreCase(thongBaoLast.getUnitQuantityofCargo())) {
								%>
								<input type="text" name="unitVolumeCargo" id="unitVolumeCargo" style="width: 48.7%" hidden="true" value="<%=unit.getUnitCode()%>">
								<input type="text" style="width: 48.7%" readonly="readonly" value="<%=unit.getUnitName()%>">
								<%
								break;
								}
							}
						%>
					</td>
				</tr>
				
				<!-- so luong loai hang hoa qua canh -->
				<%
					if(loaiThuTuc != null && loaiThuTuc.trim().compareTo(MessageType.LOAT_THU_TUC_ROI_CANG) != 0){
				%>
				<tr>
					<th class="text-left" width="30%"><liferay-ui:message key="vn.dtt.thutuc.soluong" />&nbsp;<span style="color:#FF0000;">(*)</th>
					<td class="text-leftu">
						<input type="text" class="egov-inputfield" style="width: 48%" required
								name="volumeTransitCargo" id="volumeTransitCargo"
								value="<%=Validator.isNotNull(portClearanceEdit.getVolumeTransitCargo()) ? portClearanceEdit.getVolumeTransitCargo() : "0"%>">
						
						<select name="unitVolumeTransitCargo" id="unitVolumeTransitCargo" style="width: 48.7%">
							<%
							String sUnitVolumeTransitCargo = Validator.isNotNull(portClearanceEdit.getTransitCargoUnit()) ? portClearanceEdit.getTransitCargoUnit() : "";
							for (DmUnitGeneral unit : units) {
							%>
								<option <%=unit.getUnitCode().equalsIgnoreCase(sUnitVolumeTransitCargo) ? "selected" : "" %>
									value="<%=unit.getUnitCode()%>"><%=unit.getUnitName()%></option>
							<%}%>
						</select>
					</td>
				</tr>
				<%
					}
				%>
				
				<!-- CANG DEN - CANG ROI --- x-->
				<tr>
					<th class="text-left" width="30%"><liferay-ui:message key="vn.dtt.thutuc.cangroi" /></th>
					<td class="text-leftu" colspan="2">
						<%
						if (Validator.isNotNull(cangRoiLast.getPortName())) {
							%>
							<input type="hidden" id="cangroi" name="cangroi" value="<%=cangRoiLast.getPortCode()%>">
							<input type="text" style="width: 98%" class="egov-inputfield" readonly="true" value="<%=cangRoiLast.getPortName()%>">
						<%} else {%>
							<select id="cangroi" name="cangroi" style="width: 98%">
								<%for (DmPort port : ports) {%>
									<option <%=port.getPortCode().equalsIgnoreCase(banKhaiChungLast.getPortOfArrivalCode()) ? "selected" : ""%>
										value="<%=port.getPortCode()%>" ><%=port.getPortName()%></option>
								<%}%>
							</select>
						<%}%>
						
					</td>
				</tr>
				
				<!-- giay phep so -->
				<tr>
					<th class="text-left" width="30%"><liferay-ui:message key="vn.dtt.thutuc.giayphepso" />&nbsp;<span style="color:#FF0000;">(*)</th>
					<td class="text-leftu" colspan="2">
						<!--  ?? IssuePortClearanceLocalServiceUtil.capGiayPhepSo(maritime.getMaritimeReference()) -->
						<input type="text" class="egov-inputfield" style="width: 48%"
								name="certificateNo"
								id="certificateNo"
								value="<%=Validator.isNotNull(portClearanceEdit.getCertificateNo()) ?
										ConvertUtil.splitString(portClearanceEdit.getCertificateNo()) :
										StringPool.BLANK%>">
						
						<input readonly="readonly" type="text" style="width: 48.7%"
								id="unitCertificateNo"
								name="unitCertificateNo"
								value="<%= Validator.isNotNull(maritime.getMaritimeReference()) ? maritime.getMaritimeReference() : StringPool.BLANK%>">
					</td>
				</tr>
				
				
				<!-- ----------Ngay cap phep-------------- -->
				<%
				sTimeOfValidUntil = FormatData.parseDateToTringType3(new Date());
				%>
				<tr>
					<th class="text-left" width="30%">Ngày cấp phép&nbsp;<span style="color:#FF0000;">(*)</span></th>
					<td class="text-leftu">
						<input type="text" style="width: 98%" required="true"
								id="issueDate" name="issueDate"
								value="<%=sTimeOfValidUntil%>"
								onclick="gtCalendar('issueDate')">
					</td>
				</tr>
				
			</thead>
		</table>
	</div>
	
	<!-- ----------------COLUMN 3---------------------- -->
	<div class="tbl_left boxlabel" style="width: 33.33%">
		<table class="table_noboder">
			<thead>
				<tr>
					<th class="text-left" width="30%"><liferay-ui:message key="vn.dtt.thutuc.hohieu" /></th>
					<td class="text-leftu" colspan="2">
						<input type="text" style="width: 98%" class="egov-inputfield" readonly="true"
								name="callSign" id="callSign"
								value="<%=Validator.isNotNull(tempDoc.getCallSign()) ? tempDoc.getCallSign() : StringPool.BLANK%>">
					</td>
				</tr>
				
				<tr>
					<th class="text-left" width="30%"><liferay-ui:message key="vn.dtt.thutuc.dwt" /></th>
					<td class="text-leftu" colspan="2">
						<input type="text" style="width: 98%" class="egov-inputfield" readonly="true"
								name="dwt" id="dwt"
								value="<%=Validator.isNotNull(tempDoc.getDwt()) ? tempDoc.getDwt() : StringPool.BLANK%>">
					</td>
				</tr>
				<tr>
					<th class="text-left" width="30%"><liferay-ui:message key="vn.dtt.thutuc.soluonghanhkhach" /></th>
					<td class="text-leftu" >
						<input type="text" hidden="true"
								name="numberOfPassengers" id="numberOfPassengers"
								value="<%=Validator.isNotNull(banKhaiChungLast.getNumberOfPassengers()) ? (banKhaiChungLast.getNumberOfPassengers()) :
										(Validator.isNotNull(thongBaoLast.getPassengerNumber()) ? thongBaoLast.getPassengerNumber() : StringPool.BLANK)%>">
								
						<input type="text" style="width: 98%" class="egov-inputfield" readonly="true"
								value="<%=Validator.isNotNull(banKhaiChungLast.getNumberOfPassengers()) ? (banKhaiChungLast.getNumberOfPassengers() + " Pers") :
										(Validator.isNotNull(thongBaoLast.getPassengerNumber()) ? thongBaoLast.getPassengerNumber() + " Pers" : StringPool.BLANK)%>">
					</td>
				</tr>
				
				<tr style="height: 28px">
					<th class="text-left" width="30%">&nbsp;</th>
					<td class="text-leftu">&nbsp;</td>
				</tr>
				<tr style="height: 28px">
					<th class="text-left" width="30%">&nbsp;</th>
					<td class="text-leftu">&nbsp;</td>
				</tr>
				
				
				<!-- CANG DEN, TEMdOCUMENT, LASTPORTcode, danhmuc dmport, cung dong cang roi, ko chinh sua -->
				<!-- install db: nexportofcallcode = lastportcode -->
				<%
				DmPort cangden = DmPortLocalServiceUtil.getByPortCode(Validator.isNotNull(banKhaiChungLast.getLastPortOfCallCode()) ? banKhaiChungLast.getLastPortOfCallCode() : tempDoc.getLastPortCode());
				if (Validator.isNull(cangden)) { cangden = new DmPortImpl(); }
				%>
				<tr>
					<th class="text-left" width="30%"><liferay-ui:message key="vn.dtt.thutuc.cangden"/></th>
					<td class="text-leftu" >
					
						<input type="text" hidden="true"
								name="nextPortOfCallCode" id="nextPortOfCallCode"
								value="<%=Validator.isNotNull(banKhaiChungLast.getLastPortOfCallCode()) ? banKhaiChungLast.getLastPortOfCallCode() :
									(Validator.isNotNull(tempDoc.getLastPortCode()) ? tempDoc.getLastPortCode() : StringPool.BLANK)%>">
								
						<input type="text" class="egov-inputfield" readonly="true" style="width: 98%"
								value="<%=Validator.isNotNull(cangden.getPortName()) ? cangden.getPortName() : StringPool.BLANK%>">
					</td>
				</tr>
				
				
				
				<!-- dai dien cang vu -->
				<tr>
					<th class="text-left" width="30%"><liferay-ui:message key="vn.dtt.kehoach.daidiencangvu" /></th>
					<td class="text-leftu">
						<%
						String sRepresentative = Validator.isNotNull(portClearanceEdit.getRepresentative()) ? portClearanceEdit.getRepresentative() : StringPool.BLANK;
						List<DmRepresentative> dmRepresentatives = DmRepresentativeLocalServiceUtil.getDmRepresentatives(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
						%>
						<select id="representative" name="representative" style="width: 98%">
							<option value="<%=KeyParams.GIAM_DOC%>" <%=KeyParams.GIAM_DOC.equalsIgnoreCase(sRepresentative) ? "selected" : "" %>><%="GIÁM ĐỐC"%></option>
							<%for (DmRepresentative item : dmRepresentatives) {%>
								<option value="<%=item.getRepName()%>" <%=item.getRepNameVN().equalsIgnoreCase(sRepresentative) ? "selected" : "" %>><%=item.getRepName()%></option>
							<%}%>
						</select>
					</td>
				</tr>
				
				<!-- ko hien thi, nhung co su dung -->
				<tr hidden="true">
					<th class="text-left" width="30%"><liferay-ui:message key="vn.dtt.thutuc.version" /></th>
					<td class="text-leftu">
						<%
						String iVersionNo = "";
						if (capPortClearance.length() > 0) {
							iVersionNo = (countPortClearance + 1) + "";
						} else {
							iVersionNo = Validator.isNotNull(portClearanceEdit.getVersionNo()) ? portClearanceEdit.getVersionNo() : 1+"";
						}
						%>
						<input readonly="readonly" type="text" id="versionNo" name="versionNo" value="<%=iVersionNo%>">
					</td>
				</tr>
			</thead>
		</table>
	</div>
</div>
<script type="text/javascript">
	$("#volumeTransitCargo").change(function() {
		var volumn = $('#volumeTransitCargo').val();
		var fVolumn = parseFloat(volumn);
		if (isNaN(fVolumn) | fVolumn === 0) {
			$('#volumeTransitCargo').val("0");
		} else {
			var arrayVolumn = volumn.split(".");
			if (arrayVolumn.length > 2) {
				$('#volumeTransitCargo').val("0");
			} else {
				for (i = 0; i < arrayVolumn.length; i++) {
					arrayVolumn[i] = $.trim(arrayVolumn[i]);
					var sSpaceVolumn = arrayVolumn[i].split(" ");
					var temp = "";
					for (j = 0; j < sSpaceVolumn.length; j++) { temp = temp + sSpaceVolumn[j]; }
					arrayVolumn[i] = temp;
				}
				if (arrayVolumn.length == 2) { $('#volumeTransitCargo').val(arrayVolumn[0] + "." + arrayVolumn[1]); } else { $('#volumeTransitCargo').val(arrayVolumn[0]); }
			}
		}
	});
</script>