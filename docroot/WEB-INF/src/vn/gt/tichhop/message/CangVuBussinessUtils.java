package vn.gt.tichhop.message;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import vn.gt.dao.noticeandmessage.model.IssuePortClearance;
import vn.gt.dao.noticeandmessage.model.IssueShiftingOrder;
import vn.gt.dao.noticeandmessage.model.TempDocument;
import vn.gt.dao.noticeandmessage.model.impl.IssuePortClearanceImpl;
import vn.gt.dao.noticeandmessage.model.impl.IssueShiftingOrderImpl;
import vn.gt.dao.noticeandmessage.service.IssuePortClearanceLocalServiceUtil;
import vn.gt.dao.noticeandmessage.service.IssueShiftingOrderLocalServiceUtil;
import vn.gt.dao.result.model.ResultHistoryMinistry;
import vn.gt.dao.result.model.ResultMinistry;
import vn.gt.dao.result.model.impl.ResultHistoryMinistryImpl;
import vn.gt.dao.result.model.impl.ResultMinistryImpl;
import vn.gt.dao.result.service.ResultHistoryMinistryLocalServiceUtil;
import vn.gt.dao.result.service.ResultMinistryLocalServiceUtil;
import vn.gt.portlet.business.Constans;
import vn.gt.utils.FormatData;
import vn.gt.utils.validation.HeaderValidation;
import vn.gt.utils.validation.PermissionForTransitValidation;
import vn.gt.utils.validation.PortClearanceValidation;
import vn.gt.utils.validation.ShiftingOrderValidation;
import vn.nsw.Header;
import vn.nsw.model.PermissionForTransit;
import vn.nsw.model.PortClearance;
import vn.nsw.model.ShiftingOrder;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class CangVuBussinessUtils {
	static Log _log = LogFactoryUtil.getLog(CangVuBussinessUtils.class);
	
	public static void insertOrUpdateResultMinistry(TempDocument tempDocument, String function, String name, String division, String organization,
			String remarks) {
		try {
			_log.debug("===insertOrUpdateResultMinistry===function===" + function);
			List<ResultMinistry> resultMinistrys = ResultMinistryLocalServiceUtil.findByDocumentNameAnddocumentYearMinistryCodeBusinessTypeCode(
					(new Long(tempDocument.getDocumentName())).intValue(), tempDocument.getDocumentYear(), tempDocument.getRequestCode(),
					MessageType.HO_SO);
			ResultMinistry resultMinistry = null;
			if (resultMinistrys != null && resultMinistrys.size() > 0) {
				resultMinistry = resultMinistrys.get(0);
			}
			if (resultMinistry == null) {
				_log.debug("insertOrUpdateResultMinistry ");
				resultMinistry = new ResultMinistryImpl();
				setValue2ResultMinistry(tempDocument, resultMinistry, function, name, division, organization, remarks);
				ResultMinistryLocalServiceUtil.addResultMinistry(resultMinistry);
			} else {
				setValue2ResultMinistry(tempDocument, resultMinistry, function, name, division, organization, remarks);
				ResultMinistryLocalServiceUtil.updateResultMinistry(resultMinistry);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void setValue2ResultMinistry(TempDocument tempDocument, ResultMinistry resultMinistry, String function, String name,
			String division, String organization, String remarks) {
		
		resultMinistry.setBusinessTypeCode(MessageType.HO_SO);
		
		resultMinistry.setDocumentName((new Long(tempDocument.getDocumentName())).intValue());
		resultMinistry.setDocumentYear(tempDocument.getDocumentYear());
		resultMinistry.setLatestDate(new Date());
		resultMinistry.setRequestCode(tempDocument.getRequestCode());
		resultMinistry.setResponse(function);
		resultMinistry.setRequestState(TrangThaiBanKhai.TRANG_THAI_BANG_KHAI_MOI);
		resultMinistry.setMinistryCode(Constans.BGTVT);
		
		resultMinistry.setOfficerName(name);
		resultMinistry.setDivision(division);
		resultMinistry.setOrganization(organization);
		resultMinistry.setRemarks(remarks);
		
	}
	
	public static void setValue2HistoryMinistry(TempDocument tempDocument, ResultHistoryMinistry resultMinistry, String function, String name,
			String division, String organization, String remarks) {
		resultMinistry.setBusinessTypeCode(MessageType.HO_SO);
		
		resultMinistry.setDocumentName((new Long(tempDocument.getDocumentName())).intValue());
		resultMinistry.setDocumentYear(tempDocument.getDocumentYear());
		resultMinistry.setLatestDate(new Date());
		resultMinistry.setRequestCode(tempDocument.getRequestCode());
		resultMinistry.setResponse(function);
		resultMinistry.setRequestState(TrangThaiBanKhai.TRANG_THAI_BANG_KHAI_MOI);
		resultMinistry.setMinistryCode(Constans.BGTVT);
		
		resultMinistry.setOfficerName(name);
		resultMinistry.setDivision(division);
		resultMinistry.setOrganization(organization);
		resultMinistry.setRemarks(remarks);
	}
	
	public static void insertResultHistoryMinistry(TempDocument tempDocument, String function, String name, String division, String organization,
			String remarks) {
		try {
			_log.debug("insertOrUpdateResultMinistry ");
			
			ResultHistoryMinistry resultMinistry = new ResultHistoryMinistryImpl();
			resultMinistry.setBusinessTypeCode(MessageType.HO_SO);
			resultMinistry.setDocumentName((new Long(tempDocument.getDocumentName())).intValue());
			resultMinistry.setDocumentYear(tempDocument.getDocumentYear());
			resultMinistry.setLatestDate(new Date());
			// resultMinistry.setRemarks(remarks)
			resultMinistry.setRequestCode(tempDocument.getRequestCode());
			resultMinistry.setResponse(function);
			// resultMinistry.setOfficerName(officerName)
			setValue2HistoryMinistry(tempDocument, resultMinistry, function, name, division, organization, remarks);
			ResultHistoryMinistryLocalServiceUtil.addResultHistoryMinistry(resultMinistry);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean validationDataCangVuToHaiQuan(Header header, List<Object> liObjects, String requestDirection) {
		boolean resultStatus = true;
		try {
			HeaderValidation headerValidation = new HeaderValidation();
			if (!headerValidation.validation(header, requestDirection)) {
				resultStatus = false;
			}
			for (Object object : liObjects) {
				if (object instanceof ShiftingOrder) {
					ShiftingOrderValidation shiftingOrder = new ShiftingOrderValidation();
					if (!shiftingOrder.validation(ShiftingOrder.class.cast(object), header, requestDirection)) {
						resultStatus = false;
					}
					
				} else if (object instanceof PortClearance) {
					PortClearanceValidation portClearance = new PortClearanceValidation();
					if (!portClearance.validation(PortClearance.class.cast(object), header, requestDirection)) {
						resultStatus = false;
					}
					
				} else if (object instanceof PermissionForTransit) {
					PermissionForTransitValidation permissionForTransit = new PermissionForTransitValidation();
					if (!permissionForTransit.validation(PermissionForTransit.class.cast(object), header, requestDirection)) {
						resultStatus = false;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			_log.error(e);
		}
		return resultStatus;
	}
	
	public boolean insert2ShiftingOrder(ShiftingOrder shiftingOrder, Header header) throws Exception {
		try {
			
			IssueShiftingOrder issue = new IssueShiftingOrderImpl();
			
			issue.setRequestCode(UUID.randomUUID().toString());
			issue.setNumberShiftingOrder(shiftingOrder.getNumberShiftingOrder());
			issue.setDocumentName(FormatData.convertToLong(shiftingOrder.getDocumentName()));
			issue.setDocumentYear(FormatData.convertToInt(shiftingOrder.getDocumentYear()));
			issue.setPortofAuthority(shiftingOrder.getPortofAuthority());
			issue.setNameOfShip(shiftingOrder.getNameOfShip());
			issue.setFlagStateOfShip(shiftingOrder.getFlagStateOfShip());
			issue.setPortHarbourCode(shiftingOrder.getPortHarbourCode());
			issue.setRepresentative(shiftingOrder.getRepresentative());
			issue.setAnchoringPortCode(shiftingOrder.getAnchoringPortCode());
			issue.setAnchoringPortWharfCode(shiftingOrder.getAnchoringPortWharfCode());
			
			// issue.setShiftingPortWharfCode(shiftingOrder.getShiftingPortWharfCode());
			issue.setShiftingDate(FormatData.parseStringToDate(shiftingOrder.getShiftingDate()));
			
			issue.setReasonToShift(shiftingOrder.getReasonToShift());
			issue.setIssueDate(FormatData.parseStringToDate(shiftingOrder.getIssueDate()));
			issue.setDirectorOfMaritime(shiftingOrder.getDirectorOfMaritimeAdministration());
			issue.setCertificateNo(shiftingOrder.getCertificateNo());
			issue.setRequestState(MessageType.CHAP_NHAN_BAN_KHAI);
			
			IssueShiftingOrderLocalServiceUtil.addIssueShiftingOrder(issue);
			
			return true;
		} catch (Exception e) {
			_log.error(e);
			e.printStackTrace();
		}
		return false;
	}
	
	public void insertIssueTable(Header header, List<Object> liObjects) {
		try {
			_log.debug("insertIssueTable   ");
			
			for (Object object : liObjects) {
				if (object instanceof ShiftingOrder) {
					
					insert2ShiftingOrder(ShiftingOrder.class.cast(object), header);
					_log.debug("insertIssueTable  ShiftingOrder ");
				}
				
				if (object instanceof PortClearance) {
					insert2PortClearance(PortClearance.class.cast(object), header);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			_log.error(e);
		}
	}
	
	public boolean insert2PortClearance(PortClearance portClearance, Header header) throws Exception {
		try {
			_log.debug("insert2PortClearance  " + portClearance.getCallSign());
			IssuePortClearance issue = new IssuePortClearanceImpl();
			
			issue.setRequestCode(UUID.randomUUID().toString());
			issue.setNumberPortClearance(portClearance.getNumberPortClearance());
			issue.setDocumentName(FormatData.convertToLong(portClearance.getDocumentName()));
			issue.setDocumentYear(FormatData.convertToInt(portClearance.getDocumentYear()));
			issue.setPortofAuthority(portClearance.getPortofAuthority());
			issue.setNameOfShip(portClearance.getNameOfShip());
			issue.setFlagStateOfShip(portClearance.getFlagStateOfShip());
			issue.setNumberOfCrews(FormatData.convertToInt(portClearance.getNumberOfCrews()));
			issue.setNumberOfPassengers(FormatData.convertToInt(portClearance.getNumberOfPassengers()));
			issue.setCallSign(portClearance.getCallSign());
			issue.setNameOfMaster(portClearance.getNameOfMaster());
			issue.setCargo(portClearance.getCargo());
			issue.setVolumeCargo(FormatData.convertToDouble(portClearance.getVolumeCargo()));
			issue.setRepresentative(portClearance.getRepresentative());
			issue.setCargoUnit(portClearance.getCargoUnit());
			issue.setTransitCargo(portClearance.getTransitCargo());
			
			issue.setVolumeTransitCargo(FormatData.convertToDouble(portClearance.getVolumeTransitCargo()));
			issue.setTransitCargoUnit(portClearance.getTransitCargoUnit());
			
			issue.setTimeOfDeparture(FormatData.parseStringToDate(portClearance.getTimeOfDeparture()));
			
			issue.setNextPortOfCallCode(portClearance.getNextPortOfCallCode());
			
			issue.setValidUntil(FormatData.parseStringToDate(portClearance.getValidUntil()));
			issue.setIssueDate(FormatData.parseStringToDate(portClearance.getIssueDate()));
			issue.setDirectorOfMaritime(portClearance.getDirectorOfMaritimeAdministration());
			
			issue.setCertificateNo(portClearance.getCertificateNo());
			issue.setGt(FormatData.convertToDouble(portClearance.getGT()));
			issue.setRequestState(MessageType.CHAP_NHAN_BAN_KHAI);
			
			IssuePortClearanceLocalServiceUtil.addIssuePortClearance(issue);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
