<%@page import="vn.gt.utils.DateUtils"%>
<%@page import="vn.gt.dao.noticeandmessage.model.impl.TempGeneralDeclarationImpl"%>
<%@page import="vn.gt.dao.noticeandmessage.service.TempGeneralDeclarationLocalServiceUtil"%>
<%@page import="vn.gt.dao.noticeandmessage.model.TempGeneralDeclaration"%>
<%@page import="vn.gt.dao.noticeandmessage.service.IssuePortClearanceLocalServiceUtil"%>
<%@page import="vn.gt.utils.KeyParams"%>
<%@page import="vn.gt.dao.danhmuc.service.DmRepresentativeLocalServiceUtil"%>
<%@page import="vn.gt.dao.danhmuc.model.DmRepresentative"%>
<%@page import="vn.gt.dao.danhmuc.service.DmPortRegionLocalServiceUtil"%>
<%@page import="vn.gt.dao.danhmuc.model.DmPortRegion"%>
<%@page import="vn.gt.dao.noticeandmessage.model.impl.IssuePermissionForTransitImpl"%>
<%@page import="java.util.Random"%>
<%@page import="vn.gt.utils.ConvertUtil"%>
<%@page import="java.util.UUID"%>
<%@page import="vn.gt.dao.noticeandmessage.service.IssuePermissionForTransitLocalServiceUtil"%>
<%@page import="vn.gt.dao.noticeandmessage.model.IssuePermissionForTransit"%>
<%@page import="vn.gt.dao.danhmuc.model.impl.DmMaritimeImpl"%>
<%@page import="vn.gt.dao.danhmuc.service.DmMaritimeLocalServiceUtil"%>
<%@page import="vn.gt.dao.danhmuc.model.DmMaritime"%>
<%@page import="vn.gt.dao.common.service.UserPortLocalServiceUtil"%>
<%@page import="vn.gt.dao.common.model.UserPort"%>
<%@page import="vn.gt.dao.danhmuc.service.DmStateLocalServiceUtil"%>
<%@page import="vn.gt.dao.danhmuc.model.DmState"%>
<%@page import="vn.gt.dao.danhmuc.service.DmUnitGeneralLocalServiceUtil"%>
<%@page import="vn.gt.dao.danhmuc.model.DmUnitGeneral"%>
<%@page import="vn.gt.dao.danhmuc.model.impl.DmGoodsImpl"%>
<%@page import="vn.gt.dao.danhmuc.model.DmGoods"%>
<%@page import="vn.gt.dao.danhmuc.service.DmGoodsLocalServiceUtil"%>
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
<%@page pageEncoding="UTF-8"%>
<%@ include file="/html/init.jsp"%>

<%
	String documentName = renderRequest.getParameter(PageType.DOCUMENT_NAME);
	String messageType = renderRequest.getParameter(PageType.MESSAGE_TYPE);
	int documentYear = FormatData.convertToInt(renderRequest.getParameter(PageType.DOCUMENT_YEAR));
	String requestCodethuTuc = ParamUtil.getString(request, PageType.REQUEST_CODE);
	
	//du lieu lay tu, Temp_Document
	TempDocument tempDoc = TempDocumentLocalServiceUtil.findTemDocumentByDocumentNameDocumentYear(FormatData.convertToLong(documentName), documentYear);
	if (Validator.isNull(tempDoc)) {
		tempDoc = new TempDocumentImpl();
	}
	
	DmState dmState = DmStateLocalServiceUtil.getByStateCode(tempDoc.getStateCode());
	
	//fill du lieu cang den
	UserPort userPort = UserPortLocalServiceUtil.findByUserId(user.getUserId());
	List<DmPort> ports = null;
	
	if (userPort != null) {
		ports = DmPortLocalServiceUtil.findByLoCode(userPort.getPortCode());
	}
	
	if (Validator.isNull(ports)) { 
		ports = new ArrayList<DmPort>(); 
	}
	
	List<DmUnitGeneral> units = DmUnitGeneralLocalServiceUtil.getDmUnitGenerals(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	if (Validator.isNull(units)) { units = new ArrayList<DmUnitGeneral>(); }
	
	DmMaritime maritime = DmMaritimeLocalServiceUtil.getByMaritimeCode(tempDoc.getMaritimeCode().trim());

	if (Validator.isNull(maritime)) {maritime = new DmMaritimeImpl(); }
	
	//Loai hang hoa qua canh, du lieu lay loai hang hoa
	//Xac bao
	String noticeShipType = "2";
	List<TempNoTiceShipMessage> quaCanhs = TempNoTiceShipMessageLocalServiceUtil.
		findBydocumentNameAndDocumentYearAndNoticeShipType(FormatData.convertToLong(documentName), documentYear, noticeShipType);
	
	TempNoTiceShipMessage tempNoticeShip = null;
	
	if (Validator.isNotNull(quaCanhs) && quaCanhs.size() > 0) {
		tempNoticeShip = quaCanhs.get(0);
	} else {
		tempNoticeShip = new TempNoTiceShipMessageImpl();
	}
	
	DmGoods dmGoods = DmGoodsLocalServiceUtil.getByGoodsItemCode(tempNoticeShip.getTypeOfCargo());
	if (Validator.isNull(dmGoods)) {
		dmGoods = new DmGoodsImpl();
	}
	
	List<DmGoods> dsHangHoa = DmGoodsLocalServiceUtil.getDmGoodses(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	if (Validator.isNull(dsHangHoa)) {
		dsHangHoa = new ArrayList<DmGoods>();
	}
	
	TempGeneralDeclaration generalDeclaration = TempGeneralDeclarationLocalServiceUtil.getLastByDocumentNameAndDocumentYear(FormatData.convertToLong(documentName), documentYear);
	if (Validator.isNull(generalDeclaration)) { generalDeclaration = new TempGeneralDeclarationImpl(); }
	
	IssuePermissionForTransit perForTransitEdit = IssuePermissionForTransitLocalServiceUtil.getByrequestCode(requestCodethuTuc);
	if (Validator.isNull(perForTransitEdit)) { perForTransitEdit = new IssuePermissionForTransitImpl(); }
		
	int countPerForTransit = IssuePermissionForTransitLocalServiceUtil.countByDocumentNameAndDocumentYear(FormatData.convertToLong(documentName), documentYear);
	
	String capPerForTransit = ParamUtil.getString(request, PageType.LAN_CAP_PERMISSION_FOR_TRANSIT);
	
	String lyDoCapLai = ParamUtil.getString(request, "lyDoCapLaiPermissionForTransit");
	
	System.out.println("===tao_giay_phep_qua_canh.jsp===lyDoCapLai===" + lyDoCapLai);
	System.out.println("===tao_giay_phep_qua_canh.jsp===request_ThuTuc===" + requestCodethuTuc + "===count_PerForTransit===" + countPerForTransit + "==cap_PortClearance==" + capPerForTransit);
%>

<script type="text/javascript">var imageFilesPath = '<%=request.getContextPath()%>'+"/img/";</script>

<div style="height: 10px">&nbsp;</div>
<div style="width: 100%; text-align: center; font-weight: bolder;">GIẤY PHÉP QUÁ CẢNH</div>
<div style="height: 20px">&nbsp;</div>
	<div class="AccordionPanelContent">
		<!---------------------------  COLUMN 1 --------------------------->
		<div class="tbl_left boxlabel" style="width: 49.99%">
			<table class="table_noboder">
				<thead>
					<tr>
						<input type="text" hidden="true" id="idPerForTransit" name="idPerForTransit" value="<%=Validator.isNotNull(perForTransitEdit.getId()) ? perForTransitEdit.getId() : StringPool.BLANK%>">
						<input type="text" hidden="true" id="requestCodePerForTransit" name="requestCodePerForTransit" value="<%=Validator.isNotNull(perForTransitEdit.getRequestCode()) ? perForTransitEdit.getRequestCode() : UUID.randomUUID().toString()%>">
						<input type="text" hidden="true" id="numberPermissionForTransit" name="numberPermissionForTransit" value="<%=Validator.isNotNull(perForTransitEdit.getNumberPermissionForTransit()) ? perForTransitEdit.getNumberPermissionForTransit() : new Random().nextInt(100000)%>">
						<input type="text" hidden="true" id="lyDoCapLaiPermissionForTransit" name="lyDoCapLaiPermissionForTransit" value="<%=lyDoCapLai%>">
						
						<th class="text-left" width="30%"><liferay-ui:message key="vn.dtt.thutuc.tentau" /></th>
						<td class="text-leftu">
							<input type="text" style="width: 98%" class="egov-inputfield" readonly="readonly"
									name="nameOfship" id="nameOfship"
									value="<%= tempDoc.getShipName()%>">
						</td>
					</tr>
					
					
					<tr>
						<th class="text-left" width="30%"><liferay-ui:message key="vn.dtt.thutuc.hohieu" /></th>
						<td class="text-leftu" >
							<input type="text" style="width: 98%" readonly="readonly" class="egov-inputfield"
									name="callSign" id="callSign"
									value="<%=Validator.isNotNull(tempDoc.getCallSign()) ? tempDoc.getCallSign() : StringPool.BLANK%>">
						</td>
					</tr>
					
					
					<tr>
						<th class="text-left" width="30%"><liferay-ui:message key="vn.dtt.thutuc.tenthuyentruong" /></th>
						<td class="text-leftu">
							<input type="text" style="width: 98%" class="egov-inputfield" readonly="readonly"
									name="nameOfMaster" id="nameOfMaster"
									value="<%=Validator.isNotNull(tempDoc.getShipCaptain()) ? tempDoc.getShipCaptain() : Validator.isNotNull(tempDoc.getCallSign()) %>">
						</td>
					</tr>
					
					
					<tr>
						<th class="text-left" width="30%"><liferay-ui:message key="vn.dtt.thutuc.soluonghanhkhach" />&nbsp;<span style="color:#FF0000;">(*)</span></th>
						<td class="text-leftu" >
							<input type="text" name="numberOfPassengers" id="numberOfPassengers" hidden="true"
									value="<%=Validator.isNotNull(tempNoticeShip.getPassengerNumber()) ? tempNoticeShip.getPassengerNumber() : StringPool.BLANK%>">
							<input type="text" class="egov-inputfield" readonly="readonly" style="width: 98%"
									value="<%=Validator.isNotNull(tempNoticeShip.getPassengerNumber()) ? tempNoticeShip.getPassengerNumber() + " Pers" : StringPool.BLANK%>">
						</td>
					</tr>
					
					
					<tr>
						<th class="text-left" width="30%"><liferay-ui:message key="vn.dtt.thutuc.loaihanghoaquacanh" />&nbsp;<span style="color:#FF0000;">(*)</span></th>
						<td class="text-leftu">
							<% String sTransitOfCargo = Validator.isNotNull(perForTransitEdit.getTransitCargo()) ? perForTransitEdit.getTransitCargo() : dmGoods.getGoodsItemCode(); %>
							<select name="transitOfCargo" id="transitOfCargo" style="width: 98%" >
								<% for (DmGoods item : dsHangHoa) { %>
									<option <%=item.getGoodsItemCode().equalsIgnoreCase(sTransitOfCargo) ? "selected" : "" %>
										value="<%=item.getGoodsItemCode()%>"><%=item.getGoodsItemName()%></option>
								<% } %>
							</select>
						</td>
					</tr>
					
					
					<!-- Duoc phep qua canh Viet Nam tu: khu vuc cang -->
					<tr>
						<th class="text-left" width="30%"><liferay-ui:message key="vn.dtt.thutuc.khuvucangtu" />&nbsp;<span style="color:#FF0000;">(*)</span></th>
						<td class="text-leftu" >
							<%
							List<DmPortRegion> lstRegion = DmPortRegionLocalServiceUtil.getDmPortRegions(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
							String sPermittedTransitFrom = Validator.isNotNull(perForTransitEdit.getPermittedTransitFrom()) ? perForTransitEdit.getPermittedTransitFrom() : lstRegion.get(0).getPortRegionCode();
							%>
							<input type="text" hidden="true"
									id="permittedTransitFrom"
									name="permittedTransitFrom" 
									value="<%= sPermittedTransitFrom %>">
							<select id="holdPermittedTransitFrom" name="holdPermittedTransitFrom">
								<%for (DmPortRegion item : lstRegion) {%>
									<option
										<%=item.getPortRegionCode().equalsIgnoreCase(sPermittedTransitFrom) ? "selected" : "" %>
										value="<%=item.getPortRegionCode()%>"><%=item.getPortRegionNameVN()%></option>
								<%}%>
							</select>
						</td>
					</tr>
					
					
					<!-- thoi gian khoi hanh -->
					<tr>
						<th class="text-left" width="30%"><liferay-ui:message key="vn.dtt.thutuc.thoigiankhoihanh" />&nbsp;<span style="color:#FF0000;">(*)</span></th>
						<td class="text-leftu" >
							<input type="text" required
									id="timeOfDeparture" name="timeOfDeparture"
									onclick="gtCalendar('timeOfDeparture')"
									value="<%= Validator.isNotNull(tempDoc.getShipDateFrom()) ? FormatData.parseDateToTringType3(tempDoc.getShipDateFrom()) : (Validator.isNotNull(generalDeclaration.getDateOfArrival()) ? FormatData.parseDateToTringType3(generalDeclaration.getDateOfArrival()) : StringPool.BLANK) %>">
						</td>
					</tr>
					
					<!-- ngay cap giay phep -->
					<tr>
						<th class="text-left" width="30%"><liferay-ui:message key="vn.dtt.thutuc.ngaycapgiayphep" />&nbsp;<span style="color:#FF0000;">(*)</span></th>
						<td class="text-leftu" >
							<input type="text" required
									id="dateOfSign"
									name="dateOfSign"
									onclick="gtCalendar('dateOfSign')"
									value="<%= Validator.isNotNull(perForTransitEdit.getDateOfSign()) ? FormatData.parseDateToTringType3(perForTransitEdit.getDateOfSign()) :FormatData.parseDateToTringType3(new Date())%>">
						</td>
					</tr>
				</thead>
			</table>
		</div>
		
		<!---------------------------  COLUMN 2 --------------------------->
		<div class="tbl_left boxlabel" style="width: 49.99%">
			<table class="table_noboder">
				<thead>
					<!-- so luong hanh khach -->
					<input type="text" name="passengerNumber" id="passengerNumber" value="<%=Validator.isNotNull(tempNoticeShip.getPassengerNumber()) ? tempNoticeShip.getPassengerNumber() : StringPool.BLANK%>" hidden="true">
					
					<tr>
						<th class="text-left" width="30%"><liferay-ui:message key="vn.dtt.thutuc.quoctich" /></th>
						<td class="text-leftu" colspan="2">
							<input type="text" hidden="true" name="stateCode" id="stateCode" value="<%=tempDoc.getStateCode()%>">
							<input type="text" style="width: 98%" class="egov-inputfield"
									readonly="readonly"
									value="<%=Validator.isNotNull(dmState.getStateName()) ? dmState.getStateName() : tempDoc.getStateCode()%>">
						</td>
					</tr>
					
					
					<tr>
						<th class="text-left" width="30%"><liferay-ui:message key="vn.dtt.thutuc.gt" /></th>
						<td class="text-leftu" colspan="2">
							<input type="text" name="grt" id="grt" value="<%=tempDoc.getGrt()%>" hidden="true">
							
							<%
							String unitGrt = tempDoc.getUnitGRT();
							for (DmUnitGeneral item : units) {
								if (item.getUnitCode().trim().equalsIgnoreCase(tempDoc.getUnitGRT())) {
									unitGrt = item.getUnitName();
									break;
								}
							}
							%>
							<input type="text" style="width: 98%" class="egov-inputfield"
									readonly="readonly"
									value="<%= tempDoc.getGrt() + " " + unitGrt%>">
						</td>
					</tr>
					
					<!-- cang lam thu tuc qua canh -->
					<tr>
						<th class="text-left" width="30%"><liferay-ui:message key="vn.dtt.thutuc.canglamthutucquacanh" /></th>
						<td class="text-leftu" colspan="2">
							<input type="text" hidden="true"
									id="portofAuthority"
									name="portofAuthority"
									value="<%=tempDoc.getMaritimeCode().trim()%>">
							<input type="text" readonly="readonly"
									id="portofAuthority"
									name="portofAuthority"
									value="<%=Validator.isNotNull(maritime.getMaritimeNameVN()) ? maritime.getMaritimeNameVN() : tempDoc.getMaritimeCode()%>">
						</td>
					</tr>

					<!-- so luong thuyen vien -->
					<tr>
						<th class="text-left" width="30%"><liferay-ui:message key="vn.dtt.thutuc.soluongthuyenvien" />&nbsp;<span style="color:#FF0000;">(*)</span></th>
						<td class="text-leftu" colspan="2">
							<input type="text" hidden="true"
									name="numberOfCrews" id="numberOfCrews"
									value="<%=Validator.isNotNull(tempNoticeShip.getCrewNumber()) ? tempNoticeShip.getCrewNumber() : StringPool.BLANK%>">
							<input type="text" style="width: 98%" class="egov-inputfield"
									readonly="readonly"
									value="<%=Validator.isNotNull(tempNoticeShip.getCrewNumber()) ? tempNoticeShip.getCrewNumber() + " Pers" : StringPool.BLANK%>">
						</td>
					</tr>
					
					
					
					<!-- so luong loai hang hoa qua canh -->
					<tr>
						<th class="text-left" width="30%"><liferay-ui:message key="vn.dtt.thutuc.soluong" />&nbsp;<span style="color:#FF0000;">(*)</span></th>
						<td class="text-leftu">
							<%
							String sVolumeTransitCargo = "";
							if (Validator.isNotNull(perForTransitEdit.getVolumeCargo())) {
								sVolumeTransitCargo = perForTransitEdit.getVolumeCargo() + "";
							} else {
								sVolumeTransitCargo = Validator.isNotNull(tempNoticeShip.getQuantityAndTypeOfCargo()) ? tempNoticeShip.getQuantityAndTypeOfCargo() : StringPool.BLANK;
							}
							
							String sCargoUnit = Validator.isNotNull(perForTransitEdit.getCargoUnit()) ? perForTransitEdit.getCargoUnit() : tempNoticeShip.getUnitQuantityofCargo() ;
							%>
							<input type="text" required style="width: 52.2%" class="egov-inputfield"
									value="<%= sVolumeTransitCargo %>"
									name="volumeTransitCargo"
									id="volumeTransitCargo">
								
							<select name="unitVolumeTransitCargo" id="unitVolumeTransitCargo" style="width: 45%">
								<%for (DmUnitGeneral unit : units) {%>
									<option
										<%=unit.getUnitCode().equalsIgnoreCase(sCargoUnit) ? "selected" : "" %>
										value="<%=unit.getUnitCode()%>"><%=unit.getUnitName()%></option>
								<%}%>
							</select>
						</td>
					</tr>
					
					<!-- Duoc phep qua canh den, dl tu dm_quoc_gia, dm_state -->
					<tr>
						<th class="text-left" width="30%"><liferay-ui:message key="vn.dtt.thutuc.duocphepquacanhden" />&nbsp;<span style="color:#FF0000;">(*)</span></th>
						
						<td class="text-leftu" colspan="2">
						<%
						List<DmState> lstState = DmStateLocalServiceUtil.getAllOrderByName();
						String sPermittedTransitTo = Validator.isNotNull(perForTransitEdit.getPermittedTransitTo()) ? perForTransitEdit.getPermittedTransitTo() : lstState.get(0).getStateCode();
						%>
							<input  hidden="true"
									id=permittedTransitTo
									name="permittedTransitTo" 
									value="<%=sPermittedTransitTo%>" />
							
							<select id="holdPermittedTransitTo" name="holdPermittedTransitTo">
								<%for (DmState state : lstState) {%>
									<option <%=state.getStateCode().equalsIgnoreCase(sPermittedTransitTo) ? "selected" : "" %>
										value="<%=state.getStateCode()%>"><%=state.getStateName()%></option>
								<%}%>
							</select>
						</td>
					</tr>
					
					
					
					<tr>
						<th class="text-left" width="30%"><liferay-ui:message key="vn.dtt.thutuc.thoigianhieuluc" />&nbsp;<span style="color:#FF0000;">(*)</span></th>
						<td class="text-leftu" colspan="2">
							<%
							String thoiGianHieuLuc = Validator.isNotNull(tempDoc.getShipDateFrom()) ? 
									DateUtils.getAfterNumberOfDayAgrument(tempDoc.getShipDateFrom(), 1) : 
									(Validator.isNotNull(generalDeclaration.getDateOfArrival()) ? 
											DateUtils.getAfterNumberOfDayAgrument(generalDeclaration.getDateOfArrival(), 1) : DateUtils.getAfterNumberOfDayAgrument(new Date(), 1));
							%>
						
							<input type="text" required
									id="validUntil" name="validUntil"
									onclick="gtCalendar('validUntil')"
									value="<%=Validator.isNotNull(perForTransitEdit.getValidUntil()) ? FormatData.parseDateToTringType3(perForTransitEdit.getValidUntil()) : thoiGianHieuLuc%>">
						
						</td>
					</tr>
					
					<!-------------------- giay phep so -------------------->
					<tr>
						<th class="text-left" width="30%"><liferay-ui:message key="vn.dtt.thutuc.giayphepso" />&nbsp;<span style="color:#FF0000;">(*)</span></th>
						<td class="text-leftu" colspan="2">
						<!--  ?? IssuePortClearanceLocalServiceUtil.capGiayPhepSo(maritime.getMaritimeReference()) -->
							<input type="text" required style="width: 52.2%" class="egov-inputfield"
									name="certificateNo"
									id="certificateNo"
									value="<%=Validator.isNotNull(perForTransitEdit.getCertificateNo()) ?
											ConvertUtil.splitString(perForTransitEdit.getCertificateNo()) :
											StringPool.BLANK%>">
								
							<input type="text" readonly="readonly" style="width: 45%"
									id="unitCertificateNo"
									name="unitCertificateNo"
									value="<%=Validator.isNotNull(maritime.getMaritimeReference()) ? maritime.getMaritimeReference() : StringPool.BLANK %>">
						</td>
					</tr>
					
					<!-- dai dien cang vu -->
					<tr>
						<th class="text-left" width="30%"><liferay-ui:message key="vn.dtt.kehoach.daidiencangvu" /></th>
						<td class="text-leftu">
							<%
								String sRepresentative = Validator.isNotNull(perForTransitEdit.getRepresentative()) ? perForTransitEdit.getRepresentative() : StringPool.BLANK;
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
					
					<tr hidden="true">
						<th class="text-left" width="30%"><liferay-ui:message key="vn.dtt.thutuc.version" /></th>
						<td class="text-leftu">
							<%
							String iVersionNo = "";
							if (capPerForTransit.length() > 0) {
								iVersionNo = (countPerForTransit + 1) + "";
							} else {
								iVersionNo = Validator.isNotNull(perForTransitEdit.getVersionNo()) ? perForTransitEdit.getVersionNo() : 1 + "";
							}
							%>
							<input type="text" readonly="readonly"
									id="versionNo" name="versionNo"
									value="<%= iVersionNo%>">
						</td>
					</tr>
				</thead>
			</table>
		</div>
	</div>
<script type="text/javascript">
	$(document).ready(function() {
		$('#holdPermittedTransitTo').change(function(event) {
			var code = $("select#holdPermittedTransitTo").val();
			$("input[id=permittedTransitTo]").val(code);
		});

		$('#holdPermittedTransitFrom').change(function(event) {
			var code = $("select#holdPermittedTransitFrom").val();
			$("input[id=permittedTransitFrom]").val(code);
		});
	});
</script>
