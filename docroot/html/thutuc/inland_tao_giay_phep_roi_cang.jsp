<%@page import="vn.gt.tichhop.message.TrangThaiBanKhaiXuatCanh"%>
<%@page import="vn.gt.dao.noticeandmessage.model.TempPassengerDetails"%>
<%@page import="vn.gt.dao.noticeandmessage.model.TempPassengerList"%>
<%@page import="vn.gt.dao.noticeandmessage.service.TempCrewDetailsLocalServiceUtil"%>
<%@page import="vn.gt.dao.noticeandmessage.service.TempPassengerListLocalServiceUtil"%>
<%@page import="vn.gt.dao.noticeandmessage.service.TempPassengerDetailsLocalServiceUtil"%>
<%@page import="vn.gt.dao.noticeandmessage.model.TempCrewDetails"%>
<%@page import="vn.gt.dao.noticeandmessage.service.TempCrewListLocalServiceUtil"%>
<%@page import="vn.gt.dao.noticeandmessage.model.TempCrewList"%>
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
	/* if (Validator.isNull(dmGoodsType)) {
		dmGoodsType = new DmGoodsTypeImpl();
	} */
	
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
	
	int countPortClearance = IssuePortClearanceLocalServiceUtil.countByDocumentNameAndDocumentYear(FormatData.convertToLong(documentName), documentYear);
	
	String capPortClearance = ParamUtil.getString(request, PageType.LAN_CAP_PORT_CLEARANCE);
	
	String lyDoCapLaiGiayPhep = ParamUtil.getString(request, PageType.HUY_HO_SO);

	
	LogFactoryUtil.getLog(ThuTucAction.class).info("===/inland_tao_giay_phep_roi_cang.jsp===request_ThuTuc======" + requestCodethuTuc);
	LogFactoryUtil.getLog(ThuTucAction.class).info("===/inland_tao_giay_phep_roi_cang.jsp===count_PortClearance=" + countPortClearance);
	LogFactoryUtil.getLog(ThuTucAction.class).info("===/inland_tao_giay_phep_roi_cang.jsp===cap_PortClearance===" + capPortClearance);
	LogFactoryUtil.getLog(ThuTucAction.class).info("===/inland_tao_giay_phep_roi_cang.jsp===lyDoCapLaiGiayPhep===" + lyDoCapLaiGiayPhep);
%>

<script type="text/javascript">var imageFilesPath = '<%=request.getContextPath()%>'+"/img/";</script>

<div style="height: 10px">&nbsp;</div>
<div style="width: 100%; text-align: center; font-weight: bolder;">GIẤY PHÉP RỜI CẢNG</div>
<div style="height: 20px">&nbsp;</div>
<div class="AccordionPanelContent">

	<!--------------------------------- COLUMN 1  --------------------------------->
	<div class="tbl_left boxlabel" style="width: 45%">
		<table class="table_noboder">
			<thead>
				<tr>
					<input type="text" hidden="true" name="maritimeCode" value="<%=tempDoc.getMaritimeCode()%>">
					<input type="text" hidden="true" name="stateCode" value="<%=tempDoc.getStateCode()%>">
					<input type="text" hidden="true" id="idPortClearance" name="idPortClearance" value="<%=Validator.isNotNull(portClearanceEdit.getId()) ? portClearanceEdit.getId() : StringPool.BLANK%>">
					<input type="text" hidden="true" id="requestCodePortClearance" name="requestCodePortClearance" value="<%=Validator.isNotNull(portClearanceEdit.getRequestCode()) ? portClearanceEdit.getRequestCode() : UUID.randomUUID().toString()%>">
					<input type="text" hidden="true" id="numberPortClearance" name="numberPortClearance" value="<%=Validator.isNotNull(portClearanceEdit.getNumberPortClearance()) ? portClearanceEdit.getNumberPortClearance() : String.valueOf(new Random().nextInt(100000))%>">
					<input type="text" hidden="true" id="lyDoCapLaiPortClearance" name="lyDoCapLaiPortClearance" value="<%=lyDoCapLaiGiayPhep%>">
					
					<th class="text-left" width="40%"><liferay-ui:message key="vn.dtt.thutuc.tentau" /></th>
					<td class="text-leftu">
						<input type="text" class="egov-inputfield" readonly="readonly" style="width: 98%"
								name="nameOfship" id="nameOfship"
								value="<%=tempDoc.getShipName()%>">
					</td>
				</tr>
				
				<tr>
					<th class="text-left" width="40%"><liferay-ui:message key="vn.dtt.thutuc.quoctich" /></th>
					<%
						List<DmState> lstState = DmStateLocalServiceUtil.getDmStates(QueryUtil.ALL_POS, QueryUtil.ALL_POS);					
							if(lstState != null && lstState.size() > 0){
								for(DmState state:lstState){
									if("VN".equals(state.getStateCode())){
										%>
										<td class="text-leftu" colspan="2">
											<input type="text" hidden="true" name="flagStateOfShip_Name" id="flagStateOfShip_Name" value="<%=state.getStateCode()%>">
											<input type="text" style="width: 98%" class="egov-inputfield" readonly="true" value="<%=state.getStateName()%>">
										</td>
										<%
									}
								}
							}
					%>										
				</tr>	
				
				<tr>
					<th class="text-left" width="40%"><liferay-ui:message key="vn.dtt.thutuc.hohieu" /></th>
					<td class="text-leftu" colspan="2">
						<input type="text" style="width: 98%" class="egov-inputfield" readonly="true"
								name="callSign" id="callSign"
								value="<%=Validator.isNotNull(tempDoc.getCallSign()) ? tempDoc.getCallSign() : StringPool.BLANK%>">
					</td>
				</tr>
				
				<tr>
					<th class="text-left" width="40%"><liferay-ui:message key="vn.dtt.thutuc.gt" /></th>
					<td class="text-leftu">
						<input type="text" style="width: 98%" class="egov-inputfield" readonly="readonly"
								name="grt" id="grt" 
								value="<%=(tempDoc.getGrt() > 0 ) ? tempDoc.getGrt() : StringPool.BLANK%>">
					</td>
				</tr>
				
				<tr>
					<th class="text-left" width="40%"><liferay-ui:message key="vn.dtt.thutuc.tenthuyentruong" /></th>
					<td class="text-leftu">
						<input type="text" style="width: 98%" class="egov-inputfield" readonly="readonly"
								name="nameOfMaster" id="nameOfMaster"
								value="<%=tempDoc.getShipCaptain()%>">
					</td>
				</tr>		
				
				<tr>				
					<th class="text-left" width="40%"><liferay-ui:message key="vn.dtt.thutuc.soluongthuyenvien" /></th>
					<td class="text-leftu" colspan="2">
						<%
							List<TempCrewList> tempCrewList = null;
							//tempCrewList = TempCrewListLocalServiceUtil.findBydocumentNameAnddocumentYear(FormatData.convertToLong(documentName), documentYear, 0, 1);
							 if(requestCodethuTuc != null && requestCodethuTuc.trim().length() > 0){
								tempCrewList = TempCrewListLocalServiceUtil.findByRequestCode(requestCodethuTuc);
							}else{
								tempCrewList = TempCrewListLocalServiceUtil.findBydocumentNameAnddocumentYear(FormatData.convertToLong(documentName), documentYear, 0, 1);
							} 
							
							List<TempCrewDetails> lstTempCrewDetails = null;
							if (tempCrewList != null && tempCrewList.size() > 0) {
								TempCrewList tmpCrewList = tempCrewList.get(0);
								
								lstTempCrewDetails = TempCrewDetailsLocalServiceUtil.findByRequestCode(tmpCrewList.getRequestCode());
								
							}	
						%>
					
						<input type="text" hidden="true"
								name="numberOfCrews" id="numberOfCrews"
								value="<%= (portClearanceEdit.getNumberOfCrews() > 0) ? portClearanceEdit.getNumberOfCrews() : (Validator.isNotNull(lstTempCrewDetails) ? lstTempCrewDetails.size() : StringPool.BLANK)%>"/>
						<input type="text" style="width: 98%" class="egov-inputfield"
								readonly="true"
								value="<%=(portClearanceEdit.getNumberOfCrews() > 0) ? (portClearanceEdit.getNumberOfCrews() + " Người") : ( Validator.isNotNull(lstTempCrewDetails) ? (lstTempCrewDetails.size() + "Người") : StringPool.BLANK)%>"/>
					</td>
				</tr>
				
				<tr>
					<%
						List<TempPassengerList> tempPassengerList = null;
						//tempPassengerList = TempPassengerListLocalServiceUtil.findBydocumentNameAndDocumentYear(FormatData.convertToLong(documentName), documentYear, 0, 1);
						if (requestCodethuTuc != null && requestCodethuTuc.trim().length() > 0) {
							tempPassengerList = TempPassengerListLocalServiceUtil.findByRequestCode(requestCodethuTuc);
						} else {
							tempPassengerList = TempPassengerListLocalServiceUtil.findBydocumentNameAndDocumentYear(FormatData.convertToLong(documentName),
									documentYear, 0, 1);
						}						
						 
						List<TempPassengerDetails> lstTempPassengerDetails = null;
						if(tempPassengerList != null && tempPassengerList.size() > 0){
							TempPassengerList tmpPassengerList = tempPassengerList.get(0);
							lstTempPassengerDetails = TempPassengerDetailsLocalServiceUtil.findByRequestCode(tmpPassengerList.getRequestCode());
						}
					%>
					<th class="text-left" width="40%"><liferay-ui:message key="vn.dtt.thutuc.soluonghanhkhach" /></th>
					<td class="text-leftu" >
						<input type="text" hidden="true"
								name="numberOfPassengers" id="numberOfPassengers"
								value="<%= (portClearanceEdit.getNumberOfPassengers() > 0) ? portClearanceEdit.getNumberOfPassengers() : (Validator.isNotNull(lstTempPassengerDetails) ? lstTempPassengerDetails.size() : StringPool.BLANK)%>"/>
								
						<input type="text" style="width: 98%" class="egov-inputfield" readonly="true"
								value="<%=(portClearanceEdit.getNumberOfPassengers() > 0) ? (portClearanceEdit.getNumberOfPassengers() + " Người") : (Validator.isNotNull(lstTempPassengerDetails) ? (lstTempPassengerDetails.size() + " Người") : StringPool.BLANK)%>"/>
					</td>
				</tr>	
				<tr>
					<th class="text-left" width="40%"><liferay-ui:message key="vn.dtt.thutuc.loaihanghoa" /></th>
					<td class="text-leftu">
						<select name="typeOfCargo" id="typeOfCargo">						
						<%
						String sLoaiHangHoa = "";
						List<DmGoodsType> lstDmGoodType = DmGoodsTypeLocalServiceUtil.getDmGoodsTypes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
						if(lstDmGoodType != null && lstDmGoodType.size() > 0){
							String cargo = portClearanceEdit.getCargo();
							if(cargo != null){
								for(DmGoodsType goodTypeItem: lstDmGoodType){
									String goodTypeCode = goodTypeItem.getGoodsTypeCode();
									sLoaiHangHoa = goodTypeCode.equalsIgnoreCase(cargo)? goodTypeItem.getGoodsTypeNameVN() : goodTypeItem.getGoodsTypeName();
									%>
									<option value="<%=goodTypeCode%>" <%=goodTypeCode.equalsIgnoreCase(cargo) ? "selected" : "" %>><%=goodTypeItem.getGoodsTypeNameVN() %></option>
									<%
								}
							}else{						
								%>
									<option value="LUA_CHON" selected>--- LỰA CHỌN --- </option>
								<%
								for(DmGoodsType goodTypeItem: lstDmGoodType){
									String goodTypeCode = goodTypeItem.getGoodsTypeCode();
									%>
									<option value="<%=goodTypeCode%>"><%=goodTypeItem.getGoodsTypeNameVN() %></option>
									<%
								}
							}
						}
						
							/* String sLoaiHangHoa = "";
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
							} */
						%>
						</select>					
						<%-- <input type="text" style="width: 98%" class="egov-inputfield" readonly="readonly"
								name="holdTypeOfCargo" id="holdTypeOfCargo"
								value="<%=sLoaiHangHoa%>">
								
						<input type="text" hidden="true"
								name="typeOfCargo" id="typeOfCargo"
								value="<%=loaiHangHoa%>"> --%>
					
					</td>
				</tr>
				
				<!-- so luong loai hang hoa-->
				<tr>
					<th class="text-left" width="40%"><liferay-ui:message key="vn.dtt.thutuc.soluong" /></th>
					<td class="text-leftu">
						<input type="text" style="width: 48%" class="egov-inputfield"
								name="volumeCargo" id="volumeCargo"
								value="<%= (Validator.isNotNull(portClearanceEdit.getVolumeCargo()) ? portClearanceEdit.getVolumeCargo() : StringPool.BLANK)%>">
						<%
						for (DmUnitGeneral unit : units) {
							if (unit.getUnitCode().equalsIgnoreCase(portClearanceEdit.getCargoUnit())) {
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
																
			</thead>
		</table>
	</div>
	
	<div class="tbl_left boxlabel" style="width: 10%">
	</div>
	
	<!----------- COLUMN 2 ----------->
	<div class="tbl_left boxlabel" style="width: 45%">
		<table class="table_noboder">
			<thead>				
				
				<!-- CANG DEN - CANG ROI --- x-->
				<tr>
					<th class="text-left" width="40%"><liferay-ui:message key="vn.dtt.thutuc.cangroi" /></th>
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
					String gprc = "";
					
					String thoigianroicangg = "";
					thoigianroicangg = FormatData.parseDateToTringType3(tempDoc.getShipDateTo());
					System.out.print("======ThoiGian roi cang===  "+ thoigianroicangg );
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
					<th class="text-left" width="40%"><liferay-ui:message key="vn.dtt.thutuc.thoigianroicang" />&nbsp;<span style="color:#FF0000;">(*)</span></th>
					<td class="text-leftu">
						<input type="text" style="width: 98%" required
								id="timeOfDeparture"
								name="timeOfDeparture"
								value="<%=gprc%>"
								onclick="gtCalendar('timeOfDeparture')">
					</td>
				</tr>
				
				
				<!-- giay phep so -->
				<tr>
					<th class="text-left" width="40%"><liferay-ui:message key="vn.dtt.thutuc.giayphepso" />&nbsp;<span style="color:#FF0000;">(*)</th>
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
					<th class="text-left" width="40%"><liferay-ui:message key="vn.dtt.thutuc.thoigianhieuluc" />&nbsp;<span style="color:#FF0000;">(*)</span></th>
					<td class="text-leftu">
						<input type="text" style="width: 98%" required="true"
								id="timeOfValidUntil"
								name="timeOfValidUntil"
								value="<%=sTimeOfValidUntil%>"
								onclick="gtCalendar('timeOfValidUntil')">
					</td>
				</tr>
				
				<!-- ----------Ngay cap phep-------------- -->
				<%
				sTimeOfValidUntil = FormatData.parseDateToTringType3(new Date());
				%>
				<tr>
					<th class="text-left" width="40%">Ngày cấp phép&nbsp;<span style="color:#FF0000;">(*)</span></th>
					<td class="text-leftu">
						<input type="text" style="width: 98%" required="true"
								id="issueDate" name="issueDate"
								value="<%=sTimeOfValidUntil%>"
								onclick="gtCalendar('issueDate')">
					</td>
				</tr>
				<!-- CANG DEN, TEMdOCUMENT, LASTPORTcode, danhmuc dmport, cung dong cang roi, ko chinh sua -->
				<!-- install db: nexportofcallcode = lastportcode -->
				<%
				DmPort cangden = DmPortLocalServiceUtil.getByPortCode(Validator.isNotNull(banKhaiChungLast.getLastPortOfCallCode()) ? banKhaiChungLast.getLastPortOfCallCode() : tempDoc.getLastPortCode());
				if (Validator.isNull(cangden)) { cangden = new DmPortImpl(); }
				%>
				<tr>
					<th class="text-left" width="40%"><liferay-ui:message key="vn.dtt.thutuc.cangden"/></th>
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
					<th class="text-left" width="40%"><liferay-ui:message key="vn.dtt.kehoach.daidiencangvu" /></th>
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
					<th class="text-left" width="40%"><liferay-ui:message key="vn.dtt.thutuc.version" /></th>
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
				<tr style="height: 28px">
					<th class="text-left" width="40%">&nbsp;</th>
					<td class="text-leftu">&nbsp;</td>
				</tr>
				
				<tr style="height: 28px">					
					<td class="text-left" colspan="2"><span style="color:#FF0000;">(*) </span><liferay-ui:message key="vn.dtt.thutuc.truongbatbuoc" /></td>
				</tr>
			</thead>
		</table>
	</div>
</div>
