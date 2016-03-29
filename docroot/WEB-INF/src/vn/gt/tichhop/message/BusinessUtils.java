/**
 * 
 */

package vn.gt.tichhop.message;

import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.portlet.ActionRequest;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.User;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

import vn.gt.dao.common.model.LogMessageValidation;
import vn.gt.dao.common.model.UserPort;
import vn.gt.dao.common.service.LogMessageValidationLocalServiceUtil;
import vn.gt.dao.common.service.UserPortLocalServiceUtil;
import vn.gt.dao.danhmuc.model.DmMaritime;
import vn.gt.dao.danhmuc.model.DmPort;
import vn.gt.dao.danhmuc.model.DmPortHarbour;
import vn.gt.dao.danhmuc.model.DmPortRegion;
import vn.gt.dao.danhmuc.model.DmPortWharf;
import vn.gt.dao.danhmuc.service.DmMaritimeLocalServiceUtil;
import vn.gt.dao.danhmuc.service.DmPortHarbourLocalServiceUtil;
import vn.gt.dao.danhmuc.service.DmPortLocalServiceUtil;
import vn.gt.dao.danhmuc.service.DmPortRegionLocalServiceUtil;
import vn.gt.dao.danhmuc.service.DmPortWharfLocalServiceUtil;
import vn.gt.dao.danhmucgt.model.DmGtOrganization;
import vn.gt.dao.danhmucgt.service.DmGtOrganizationLocalServiceUtil;
import vn.gt.dao.noticeandmessage.model.HistoryInterfaceRequest;
import vn.gt.dao.noticeandmessage.model.HistoryInterfaceRequestField;
import vn.gt.dao.noticeandmessage.model.InterfaceRequest;
import vn.gt.dao.noticeandmessage.model.IssueShiftingOrder;
import vn.gt.dao.noticeandmessage.model.TempDocument;
import vn.gt.dao.noticeandmessage.model.impl.HistoryInterfaceRequestImpl;
import vn.gt.dao.noticeandmessage.model.impl.InterfaceRequestImpl;
import vn.gt.dao.noticeandmessage.model.impl.IssueShiftingOrderImpl;
import vn.gt.dao.noticeandmessage.model.impl.TempDocumentImpl;
import vn.gt.dao.noticeandmessage.service.HistoryInterfaceRequestFieldLocalServiceUtil;
import vn.gt.dao.noticeandmessage.service.HistoryInterfaceRequestLocalServiceUtil;
import vn.gt.dao.noticeandmessage.service.InterfaceRequestLocalServiceUtil;
import vn.gt.dao.noticeandmessage.service.IssueShiftingOrderLocalServiceUtil;
import vn.gt.dao.noticeandmessage.service.TempDocumentLocalServiceUtil;
import vn.gt.dao.result.model.ResultDeclaration;
import vn.gt.dao.result.model.ResultHistoryMinistry;
import vn.gt.dao.result.model.ResultMinistry;
import vn.gt.dao.result.model.ResultNotification;
import vn.gt.dao.result.model.impl.ResultHistoryMinistryImpl;
import vn.gt.dao.result.model.impl.ResultMinistryImpl;
import vn.gt.dao.result.model.impl.ResultNotificationImpl;
import vn.gt.dao.result.service.ResultDeclarationLocalServiceUtil;
import vn.gt.dao.result.service.ResultHistoryMinistryLocalServiceUtil;
import vn.gt.dao.result.service.ResultMinistryLocalServiceUtil;
import vn.gt.dao.result.service.ResultNotificationLocalServiceUtil;
import vn.gt.tichhop.message.giaothong2haiquan.AcceptanceForTransit2Xml;
import vn.gt.tichhop.message.giaothong2haiquan.CreateMessageFactory;
import vn.gt.tichhop.message.giaothong2haiquan.PermissionForTransit2Xml;
import vn.gt.tichhop.message.giaothong2haiquan.PortClearance2Xml;
import vn.gt.tichhop.message.giaothong2haiquan.ShiftingOrder2Xml;
import vn.gt.tichhop.message.haiquan2giaothong.CargoDeclaration2Temp;
import vn.gt.tichhop.message.haiquan2giaothong.CrewEffectsDeclaration2Temp;
import vn.gt.tichhop.message.haiquan2giaothong.CrewList2Temp;
import vn.gt.tichhop.message.haiquan2giaothong.DangerousGoodsManifest2Temp;
import vn.gt.tichhop.message.haiquan2giaothong.DeclarationForAnimalQuarantine2Temp;
import vn.gt.tichhop.message.haiquan2giaothong.DeclarationForPlantQuarantine2Temp;
import vn.gt.tichhop.message.haiquan2giaothong.GeneralDeclaration2Temp;
import vn.gt.tichhop.message.haiquan2giaothong.HealthQuanrantineDeclare2Temp;
import vn.gt.tichhop.message.haiquan2giaothong.InterfaceRequest2TempUtils;
import vn.gt.tichhop.message.haiquan2giaothong.NoticeOfArrival2Temp;
import vn.gt.tichhop.message.haiquan2giaothong.PassengerList2Temp;
import vn.gt.tichhop.message.haiquan2giaothong.ShipSecurityNotification2Temp;
import vn.gt.tichhop.message.haiquan2giaothong.ShipsStoresDeclaration2Temp;
import vn.gt.tichhop.message.haiquan2giaothong.inland.Attachment2ResultCertificate;
import vn.gt.tichhop.message.haiquan2giaothong.inland.InlandCrewList2Temp;
import vn.gt.tichhop.message.haiquan2giaothong.inland.InlandGeneralDeclaration2Temp;
import vn.gt.tichhop.message.haiquan2giaothong.inland.InlandNoticeOfArrival2Temp;
import vn.gt.tichhop.message.haiquan2giaothong.inland.InlandPassengerList2Temp;
import vn.gt.tichhop.sendmessage.MessgaePriorityLevels;
import vn.gt.tichhop.sendmessage.SendMessgaeFunctions;
import vn.gt.tichhop.threat.ObjectExcute;
import vn.gt.tichhop.threat.ThreadPassingMessage;
import vn.gt.utils.ConstantCoQuanBanNganh;
import vn.gt.utils.FormatData;
import vn.gt.utils.KeyParams;
import vn.gt.utils.PageType;
import vn.gt.utils.config.ConfigurationManager;
import vn.gt.utils.validation.CargoDeclarationValidation;
import vn.gt.utils.validation.CrewEffectsDeclarationValidation;
import vn.gt.utils.validation.CrewListValidation;
import vn.gt.utils.validation.DangerousGoodsManifestValidation;
import vn.gt.utils.validation.DeclarationForAnimalQuarantineValidation;
import vn.gt.utils.validation.DeclarationForPlantQuarantineValidation;
import vn.gt.utils.validation.GeneralDeclarationValidation;
import vn.gt.utils.validation.HeaderValidation;
import vn.gt.utils.validation.HealthQuanrantineDeclareValidation;
import vn.gt.utils.validation.NoticeOfArrivalValidation;
import vn.gt.utils.validation.PassengerListValidation;
import vn.gt.utils.validation.ShipSecurityNotificationValidation;
import vn.gt.utils.validation.ShipsStoresDeclarationValidation;
import vn.gt.utils.validation.inland.AttachmentValidation;
import vn.gt.utils.validation.inland.InlandCrewListValidation;
import vn.gt.utils.validation.inland.InlandNoticeOfArrivalValidation;
import vn.gt.utils.validation.inland.InlandPassengerListValidation;
import vn.gt.utils.validation.inland.InlandPortClearanceValidation;
import vn.gt.utils.validation.inland.InlandShiftingOrderValidation;
import vn.nsw.Header;
import vn.nsw.Header.From;
import vn.nsw.Header.Reference;
import vn.nsw.Header.Subject;
import vn.nsw.Header.To;
import vn.nsw.ObjectFactory;
import vn.nsw.fac.ReadMessages;
import vn.nsw.model.CargoDeclaration;
import vn.nsw.model.CrewEffectsDeclaration;
import vn.nsw.model.CrewLists;
import vn.nsw.model.DangerousGoodsManifest;
import vn.nsw.model.DeclarationForAnimalQuarantine;
import vn.nsw.model.DeclarationForPlantQuarantine;
import vn.nsw.model.GeneralDeclaration;
import vn.nsw.model.HealthQuanrantineDeclare;
import vn.nsw.model.NoticeOfArrival;
import vn.nsw.model.NoticeOfArrivalCancel;
import vn.nsw.model.PassengerList;
import vn.nsw.model.ShiftingOrder;
import vn.nsw.model.ShipSecurityNotification;
import vn.nsw.model.ShipsStoresDeclaration;
import vn.nsw.model.inland.Attachment;
import vn.nsw.model.inland.InlandCrewLists;
import vn.nsw.model.inland.InlandGeneralDeclaration;
import vn.nsw.model.inland.InlandNoticeOfArrival;
import vn.nsw.model.inland.InlandPassengerList;
import vn.nsw.model.inland.InlandPortClearance;
import vn.nsw.model.inland.InlandShiftingOrder;

import java.io.ByteArrayInputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

/**
 * @author win_64
 * 
 */
public class BusinessUtils {

	private static Log log = LogFactoryUtil.getLog(BusinessUtils.class);

	public static final String HqmcToBoGiaoThong = "IN";
	public static final String CangVuToBoGiaoThong = "IN";
	public static final String BoGiaoThongToHqmc = "OUT";

	// Ham phan tich du lieu nhan tu NSW.
	public String receiveMessage(String dataInput) {
		try {
			Header header = null;
			String data = replaceXML(dataInput.trim());
			
			header = ReadMessages.readXMLMessagesHeader(data);
			
			System.out.println("===============header.getTo().getIdentity()" +header.getTo().getIdentity());
			System.out.println("===================getTo().getMinistryCode())"+header.getTo().getMinistryCode());
			System.out.println("===================header.getTo().getName()"+header.getTo().getName());
			System.out.println("===============================getTo().getOrganizationCode()"+header.getTo().getOrganizationCode());
			// String reason =
			
			if (header != null) {
				// Nhan ket qua xu ly ban nganh.
				log.info("==receiveMessage==Type=" + header.getSubject().getType());
				
				if (NhanKetQuaCoQuanBanNganhUtils.checkCoQuanBanNganh(header)) {
					log.info("==receiveMessage==Nhan ket qua xu ly ban nganh==Type=" + header.getSubject().getType());
					log.info("==receiveMessage==Nhan ket qua xu ly ban nganh==Function==" + header.getSubject().getFunction());
					
					//truong hop bussiness phan HOI CUA CO QUAN BAN NHGANH
					insertHistory(header, dataInput, HqmcToBoGiaoThong, TrangThaiHoSo.HISTORY_REQUEST_STATE_MOI_YEU_CAU, null);
					
					String messageId = header.getReference().getMessageId();
					long documentName = header.getSubject().getReference();
					int documentYear = header.getSubject().getDocumentYear();
					
					//---------gui qua ben Cang Vu
					List<Object> objects = new ArrayList<Object>();
					objects.add(header);
					
					ThreadPassingMessage.init().add(new ObjectExcute(header, objects, dataInput));
					
					updateHistory(header.getReference().getMessageId(), TrangThaiHoSo.HISTORY_REQUEST_STATE_GHI_NHAN);
					//---------ket thuc gui cang vu
					
					
					//TODO Thực hiện logic các bản tin gửi sang
					String xmlResult = NhanKetQuaCoQuanBanNganhUtils.executeKetQuaBanNganh(header, data);
					
					// Cap nhat trang thai la tiep nhan voi truong hop da tiep nhan ban khai.
					if (documentName > 0) {
						List<TempDocument> tempDocuments = TempDocumentLocalServiceUtil.findTemDocumentByDocumentNameAndDocumentYear(documentName, documentYear);
						if (tempDocuments != null && tempDocuments.size() > 0) {
							String locCode = tempDocuments.get(0).getMaritimeCode();
							updateInterFaceRequestForCoQuanBanNganh(messageId, TrangThaiHoSo.HISTORY_REQUEST_STATE_GHI_NHAN, locCode);
						}
					}
					
					// Insert history truoc khi gui di.
					insertHistory(header, xmlResult, BoGiaoThongToHqmc, TrangThaiHoSo.DA_GHI_NHO_YEU_CAU, UUID.randomUUID().toString());
					
					return xmlResult;
					
				} else if (header.getSubject() != null && header.getSubject().getType() == MessageType.HUY_LENH_DIEU_DONG
						&& header.getSubject().getFunction().equals(MessageType.FUNCTION_KHAI_HUY_HO_SO)) {
					
					log.info("==receiveMessage==HuyLenhDieuDong==Type=" + header.getSubject().getType() + "==Function==" + header.getSubject().getFunction());
					
					NhanThongBaoHuy huyLenhDieuDongUtils = new NhanThongBaoHuy();
					return huyLenhDieuDongUtils.huyLenhDieuDong(header, dataInput, data);
					
				} else if (header.getSubject() != null && header.getSubject().getType() == MessageType.HUY_GIAY_PHEP_ROI_CANG
						&& header.getSubject().getFunction().equals(MessageType.FUNCTION_KHAI_HUY_HO_SO)) {
					NhanThongBaoHuy nhanThongBaoHuy = new NhanThongBaoHuy();
					return nhanThongBaoHuy.huyGiayPhepRoiCang(header, dataInput, data);
					
				} else if (header.getSubject() != null && header.getSubject().getType() == MessageType.HUY_GIAY_PHEP_QUA_CANH
						&& header.getSubject().getFunction().equals(MessageType.FUNCTION_KHAI_HUY_HO_SO)) {
					NhanThongBaoHuy nhanThongBaoHuy = new NhanThongBaoHuy();
					return nhanThongBaoHuy.huyGiayPhepQuaCanh(header, dataInput, data);
					
				} else if (header.getSubject() != null && header.getSubject().getType() == MessageType.KHAI_HUY_HO_SO
						&& header.getSubject().getFunction().equals(MessageType.FUNCTION_KHAI_HUY_HO_SO)) {
					NhanThongBaoHuy nhanThongBaoHuy = new NhanThongBaoHuy();
					return nhanThongBaoHuy.khaiHuyHoSo(header, dataInput, data);
					
				} else if (header.getSubject() != null && header.getSubject().getType() == MessageType.Y_CAU_CAP_LAI_GIAY_PHEP_ROI_CANG
						&& header.getSubject().getFunction().equals(MessageType.FUNCTION_DE_NGHI_CAP_LAI)) {
					 System.out.println("VAO Y_CAU_CAP_LAI_GIAY_PHEP_ROI_CANG && FUNCTION_DE_NGHI_CAP_LAI");
					
					
					NhanThongBaoHuy nhanThongBaoHuy = new NhanThongBaoHuy();
					return nhanThongBaoHuy.deNghiCapLaiGiayPhepRoiCang(header, dataInput, data);
					
				} else if (header.getSubject() != null && header.getSubject().getType() == MessageType.Y_CAU_CAP_LAI_GIAY_PHEP_QUA_CANH
						&& header.getSubject().getFunction().equals(MessageType.FUNCTION_DE_NGHI_CAP_LAI)) {
					NhanThongBaoHuy nhanThongBaoHuy = new NhanThongBaoHuy();
					return nhanThongBaoHuy.deNghiCapLaiGiayPhepQuaCanh(header, dataInput, data);
					
				} else {
					//Insert cac ban khai vao db, khi co ban khai gui den
					log.info("==receiveMessage==Insert cac ban khai vao db, khi co ban khai gui den==type=" + header.getSubject().getType());
					log.info("==receiveMessage==Insert cac ban khai vao db, khi co ban khai gui den==function==" + header.getSubject().getFunction());
					return nhanBanKhai(header, dataInput, data);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	/**Ham phan tich du lieu cac ban khai nhan tu NSW.*/
	private String nhanBanKhai(Header header, String dataInput, String data) {
		// Tao ban tin tra ve bao da nhan thong tin.
		try {
			
			log.info("==Starting==nhanBanKhai==MessageId==" + header.getReference().getMessageId());
			
			// Insert history.
			String kq = insertHistory(header, dataInput, HqmcToBoGiaoThong, TrangThaiHoSo.HISTORY_REQUEST_STATE_MOI_YEU_CAU, null);
			if (kq != null && kq.length() > 0) {
				
				// Ban tin tra ve khi validate error.
				String xmlResultError = createReturnContentAfterValidationErrorFromNSW(header, kq);
				
				// insertHistory(header, xmlResultError, BoGiaoThongToHqmc, TrangThaiHoSo.DA_GHI_NHO_YEU_CAU, UUID.randomUUID().toString());
				log.info("==End==nhanBanKhai====MessageId=======" + header.getReference().getMessageId());
				return xmlResultError;
			} else {
				// Insert temp table.
				int documentType = header.getSubject().getDocumentType();
				List<Object> liObjects;
				System.out.println("documentType  "+documentType);
				if (documentType == MessageType.TAU_RA || documentType == MessageType.TAU_VAO) {
					liObjects = MessageFactory.converXMLMessagesContentToInLandObject(data);
				}else {
				
				 liObjects = MessageFactory.converXMLMessagesContentToObject(data);
				}
				
				if (validationData(header, liObjects, HqmcToBoGiaoThong)) {
					String reason = MessageFactory.getReason2Content(data);
					if (reason == null || reason.length() == 0) {
						reason = "NIL";
					}
					
					log.info("==Reason==" + reason + "==Function==" + header.getSubject().getFunction() + "==Type==" + header.getSubject().getType() + "DocumentType" + header.getSubject().getDocumentType());
					
					
					//dung.le
//					if(header.getSubject().getDocumentType() == MessageType.TAU_VAO || header.getSubject().getDocumentType() == MessageType.TAU_RA) {
//						if(header.getSubject().getFunction().equals(MessageType.FUNCTION_BO_SUNG_CHUNG_TU) 
//								|| header.getSubject().getFunction().equals(MessageType.FUNCTION_KHAI_SUA)) {
//							if(header.getSubject().getType() == MessageType.BAN_KHAI_CHUNG || header.getSubject().getType() == MessageType.BAN_KHAI_DANH_SACH_THUYEN_VIEN) {
//								ResultNotification notification = new ResultNotificationImpl();	
//								notification.setBusinessTypeCode(header.getSubject().getType());
//								notification.setDocumentName(header.getSubject().getReference());
//								notification.setDocumentYear(header.getSubject().getDocumentYear());
//								notification.setLatestDate(header.getSubject().getSendDate());
//								notification.setRequestCode(header.getReference().getMessageId());
//								TempDocument tempDocument = TempDocumentLocalServiceUtil.findTemDocumentByDocumentNameDocumentYear(header.getSubject().getReference(), header.getSubject().getDocumentYear());
//								
//								if (tempDocument != null) {
//									notification.setMaritimeCode(tempDocument.getMaritimeCode());
//								}
//								if (reason != null) {
//									notification.setRemarks(reason);
//								}
//								notification.setRole(0);
//								notification.setRequestState(1);
//								notification.setIsReply(0);
//								ResultNotificationLocalServiceUtil.addResultNotification(notification);
//							}
//						}
//					}
//					
					
					if ((header.getSubject().getFunction().equals(MessageType.FUNCTION_BO_SUNG_CHUNG_TU) && header.getSubject().getType() == MessageType.HO_SO) ||
						header.getSubject().getType() == MessageType.XAC_BAO_TAU_DEN_CANG ||
						header.getSubject().getType() == MessageType.XAC_BAO_TAU_QUA_CANH 
						
							) {
						
						ResultNotification notification = new ResultNotificationImpl();
						// public static final String FUNCTION_BO_SUNG_CHUNG_TU = "05";
						if (header.getSubject().getType() == MessageType.HO_SO) {
							notification.setBusinessTypeCode(5);
						} else {
							notification.setBusinessTypeCode(header.getSubject().getType());
						}
						
						notification.setDocumentName(header.getSubject().getReference());
						notification.setDocumentYear(header.getSubject().getDocumentYear());
						notification.setLatestDate(header.getSubject().getSendDate());
						notification.setRequestCode(header.getReference().getMessageId());
						
						TempDocument tempDocument = TempDocumentLocalServiceUtil.findTemDocumentByDocumentNameDocumentYear(header.getSubject().getReference(), header.getSubject().getDocumentYear());
						
						if (tempDocument != null) {
							notification.setMaritimeCode(tempDocument.getMaritimeCode());
						}
						if (reason != null) {
							notification.setRemarks(reason);
						}
						notification.setRole(0);
						notification.setRequestState(1);
						notification.setIsReply(0);
						ResultNotificationLocalServiceUtil.addResultNotification(notification);
					}
					
					//TODO Buoc nay insert du lieu cac ban vao db
					ThreadPassingMessage.init().add(new ObjectExcute(header, liObjects, dataInput));
					
					updateHistory(header.getReference().getMessageId(), TrangThaiHoSo.HISTORY_REQUEST_STATE_GHI_NHAN);
					
					
					/**
					 * //Check co ban khai chung ko
					 * Th1: BKC gửi trước khi cấp LDD
					 * - TGD cập nhật theo thứ tự ưu tiên: 1. LDD; 2. XB; 3. TB; 4. BKAN
					 * */
					//checkShipDateFormOrShipDateTo(liObjects, header);
					
				} else {
					//TODO Tra ve ban tin validation error va update khong ghi nhan yeu cau.
					updateHistory(header.getReference().getMessageId(), TrangThaiHoSo.HISTORY_REQUEST_STATE_KHONG_GHI_NHAN);
					String error = "";
					List<LogMessageValidation> logMessageValidations = LogMessageValidationLocalServiceUtil.findByDocumentNameDocumentYear(header.getSubject().getReference(), header.getSubject().getDocumentYear());
					
					if (logMessageValidations != null && logMessageValidations.size() > 0) {
						LogMessageValidation logMessageValidation = logMessageValidations.get(0);
						error = logMessageValidation.getDataValidation();
					}
					log.info("==ERROR==" + error);
					
					// Ban tin tra ve khi validate error.
					String xmlResultError = createReturnContentAfterValidationErrorFromNSW(header, error);
					insertHistory(header, xmlResultError, BoGiaoThongToHqmc, TrangThaiHoSo.DA_GHI_NHO_YEU_CAU, UUID.randomUUID().toString());
					log.info("==End==ERROR==nhanBanKhai====MessageId=======" + header.getReference().getMessageId());
					return xmlResultError;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Ban tin tra ve dung.
		int documentType = header.getSubject().getDocumentType();
		String xmlResult = "";
//		if (documentType == MessageType.TAU_RA || documentType == MessageType.TAU_VAO) {
//			 xmlResult = createReturnContentAfterParserDataReceiverFromNSWInland(header);
//		} 
//		else {
			xmlResult = createReturnContentAfterParserDataReceiverFromNSW(header);
		//} 
		header.getSubject().setFunction(MessageType.FUNCTION_TYPE_MESSAGETYPE_RESPONSE_WHEN_RECEIVE_REQUEST + "");
		insertHistory(header, xmlResult, BoGiaoThongToHqmc, TrangThaiHoSo.DA_GHI_NHO_YEU_CAU, UUID.randomUUID().toString());
		
		log.info("==End nhanBanKhai====MessageId=======" + header.getReference().getMessageId());
		return xmlResult;
	}

	// Ham phan tich du lieu response nhan tu NSW.
	public boolean insertHistoryReceiveMessageResponse(String dataInput) {
		boolean result = false;
		
		// Tao ban tin tra ve bao da nhan thong tin.
		try {
			Header header = null;
			log.info("===insertHistoryReceiveMessageResponse==Thong tin nhan tu HQMC===");
			String data = replaceXML(dataInput.trim());
			header = ReadMessages.readXMLMessagesHeader(data);
			if (header != null) {
				int type = header.getSubject().getType();
				String function = header.getSubject().getFunction();
				// Insert history.
				String resultMethod = insertHistory(header, dataInput, HqmcToBoGiaoThong, TrangThaiHoSo.DA_GHI_NHO_YEU_CAU, UUID.randomUUID().toString());
				if (resultMethod == null) {
					//log.info("TRUEEEEEEEEEEEEEEEEEEE==============resultMethod " + function);
					result = true;
					//insert thanh cong HistoryInterfaceRequest, InterfaceRequest
//					if (FormatData.convertToInt(function) == MessageType.FUNCTION_TU_CHOI_HO_SO) {
//						log.info("FALSEEEEEEEEEEEEEEEEEEE==============resultMethod");
//						log.info("===insertHistoryReceiveMessageResponse==Thong tin nhan tu HQMC===Type==" + type + "==Function==" + function + "==FUNCTION_TU_CHOI_HO_SO==");
//						result = false;
//					}
				} else {
					result = false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}

	// Ham phan tich du lieu response nhan tu NSW.
	public boolean insertHistorySendMessage(String dataInput) {
		boolean result = false;
		try {
			Header header = null;
			String data = replaceXML(dataInput.trim());
			
			// Tao ban tin tra ve bao da nhan thong tin.
			header = ReadMessages.readXMLMessagesHeader(data);
			
			// Insert history.
			String resultMethod = insertHistory(header, dataInput, BoGiaoThongToHqmc, TrangThaiHoSo.DA_GHI_NHO_YEU_CAU, UUID.randomUUID().toString());
			if (resultMethod == null) {
				result = true;
			} else {
				result = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}

	// Ham phan tich du lieu gui sang tu BGTVT.
	/**
	 * Input: Version of PortClearance2Xml or ShiftingOrder2Xml or
	 * PermissionForTransit2Xml Output:
	 * */
	public String sendMessageResult(Header header, String version, String requestCode) {
		int mesageType = 0;
		String functionType = "00";
		Object obj = null;
		String xmlResult = "";
		String data = "";
	//	TempDocument tempDocument = TempDocumentLocalServiceUtil.findTemDocumentByDocumentNameDocumentYear(header.getSubject().getDocumentType(), header.getSubject().getDocumentYear());
		// Tao ban tin tra ve bao da nhan thong tin.
		try {

			// Insert temp table.
			mesageType = header.getSubject().getType();
			functionType = header.getSubject().getFunction();

			// if (functionType == 1) {
			if (functionType.equals(MessageType.FUNCTION_KHAI_BAO)) {
				if (MessageType.GIAY_PHEP_ROI_CANG_BO_GTVT_CAP_KHI_XUAT_CANH == mesageType) {

					// Giay phep roi cang
					PortClearance2Xml portClearance2Xml = new PortClearance2Xml();
					obj = portClearance2Xml.insert2PortClearance(header
							.getSubject().getReference(), header.getSubject()
							.getDocumentYear());
				} else if (MessageType.LENH_DIEU_DONG == mesageType) {

					// Lenh dieu dong.
					ShiftingOrder2Xml shiftingOrder2Xml = new ShiftingOrder2Xml();
					obj = shiftingOrder2Xml.insert2ShiftingOrder(header
							.getSubject().getReference(), header.getSubject()
							.getDocumentYear());
				} else if (MessageType.THONG_BAO_CHO_PHEP_TAU_QUA_CANH == mesageType) {

					// Thong bao cho phep tau qua canh
					AcceptanceForTransit2Xml acceptanceForTransit2Xml = new AcceptanceForTransit2Xml();
					obj = acceptanceForTransit2Xml.insert2AcceptanceForTransit(
							header.getSubject().getReference(), header
									.getSubject().getDocumentYear());

				} else if (MessageType.GIAY_PHEP_QUA_CANH == mesageType) {

					// Giay phep qua canh.
					PermissionForTransit2Xml permissionForTransit2Xml = new PermissionForTransit2Xml();
					obj = permissionForTransit2Xml
							.insert2PerForTransitByVersion(header.getSubject()
									.getReference(), header.getSubject()
									.getDocumentYear(), version);

				}
			}
			if (obj != null) {
				xmlResult = MessageFactory.convertObjectToXml(obj);
//				log.info("=====Thong tin cua BGTVT chuan bi gui sang NSW==="
//						+ xmlResult);

				// Insert history.
				insertHistory(header, xmlResult, BoGiaoThongToHqmc,
						TrangThaiHoSo.DA_GHI_NHO_YEU_CAU, UUID.randomUUID()
								.toString());
			} else {
				return "";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		data = createContentSendFromBGTVTToNSW(header, xmlResult);
		SendMessgaeFunctions.insertMessageQueue(header, data, "OUT", requestCode, MessgaePriorityLevels.HIGHT);
		return createContentSendFromBGTVTToNSW(header, xmlResult);
	}

	public String sendMessageRejectKH(Header header, String rejectCode, String rejectDesc, String organization, String division, String name, Date rejectDate, String requestCode) {
		String xmlTagReject = "";
		String data = "";
		//TempDocument tempDocument = TempDocumentLocalServiceUtil.findTemDocumentByDocumentNameDocumentYear(header.getSubject().getDocumentType(), header.getSubject().getDocumentYear());
		try {
			
				xmlTagReject = CreateMessageFactory.createMessageReject(rejectCode, rejectDesc, organization, division, name, rejectDate);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(header.getSubject().getDocumentType() == 4 || header.getSubject().getDocumentType() == 5) {
			data = createContentSendFromBGTVTToNSWInland(header, xmlTagReject);
			SendMessgaeFunctions.insertMessageQueue(header, data, BusinessUtils.BoGiaoThongToHqmc, requestCode, MessgaePriorityLevels.HIGHT);
			return createContentSendFromBGTVTToNSWInland(header, xmlTagReject);
		} else {
			data = createContentSendFromBGTVTToNSWInland(header, xmlTagReject);
			SendMessgaeFunctions.insertMessageQueue(header, data, BusinessUtils.BoGiaoThongToHqmc, requestCode, MessgaePriorityLevels.HIGHT);
			return createContentSendFromBGTVTToNSW(header, xmlTagReject);
		}
	}
	
	// Ham gui ban tin tu choi tu BGTVT sang NSW
	public String sendMessageReject(Header header, String rejectCode, String rejectDesc, String organization, String division, String name, Date rejectDate, String requestCode) {
		String xmlTagReject = "";
		String data = "";
		//TempDocument tempDocument = TempDocumentLocalServiceUtil.findTemDocumentByDocumentNameDocumentYear(header.getSubject().getDocumentType(), header.getSubject().getDocumentYear());
		try {
			if(header.getSubject().getDocumentType() == 4 || header.getSubject().getDocumentType() == 5) {
				
				xmlTagReject = CreateMessageFactory.createMessageRejectInland(rejectCode, rejectDesc, organization, division, name, rejectDate);
			} else {
				xmlTagReject = CreateMessageFactory.createMessageReject(rejectCode, rejectDesc, organization, division, name, rejectDate);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(header.getSubject().getDocumentType() == 4 || header.getSubject().getDocumentType() == 5) {
			data = createContentSendFromBGTVTToNSWInland(header, xmlTagReject);
			SendMessgaeFunctions.insertMessageQueue(header, data, "OUT", requestCode, MessgaePriorityLevels.HIGHT);
			return createContentSendFromBGTVTToNSWInland(header, xmlTagReject);
		} else {
			data = createContentSendFromBGTVTToNSW(header, xmlTagReject);
			SendMessgaeFunctions.insertMessageQueue(header, data, "OUT", requestCode, MessgaePriorityLevels.HIGHT);
			return createContentSendFromBGTVTToNSW(header, xmlTagReject);
		}
	}
	
	public String sendMessageRejectInland(Header header, String rejectCode, String rejectDesc, String organization, String division, String name, Date rejectDate, String requestCode) {
		String xmlTagReject = "";
		String data = "";
		//TempDocument tempDocument = TempDocumentLocalServiceUtil.findTemDocumentByDocumentNameDocumentYear(header.getSubject().getDocumentType(), header.getSubject().getDocumentYear());
		try {
			xmlTagReject = CreateMessageFactory.createMessageRejectInland(rejectCode, rejectDesc, organization, division, name, rejectDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(header.getSubject().getDocumentType() == 4 || header.getSubject().getDocumentType() == 5) {
			data = createContentSendFromBGTVTToNSWInland(header, xmlTagReject);
			SendMessgaeFunctions.insertMessageQueue(header, data, "OUT", requestCode, MessgaePriorityLevels.HIGHT);
			return createContentSendFromBGTVTToNSWInland(header, xmlTagReject);
		} else {
			data = createContentSendFromBGTVTToNSW(header, xmlTagReject);
			SendMessgaeFunctions.insertMessageQueue(header, data, "OUT", requestCode, MessgaePriorityLevels.HIGHT);
			return createContentSendFromBGTVTToNSW(header, xmlTagReject);
		}
	}

	public String sendMessageModify(Header header, Modify modify, String requestCode) {
		String xmlResult = "";
		String data = "";
		//TempDocument tempDocument = TempDocumentLocalServiceUtil.findTemDocumentByDocumentNameDocumentYear(header.getSubject().getDocumentType(), header.getSubject().getDocumentYear());
		try {
			xmlResult = MessageFactory.convertObjectToXml(modify);
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e);
		}
		log.info("==sendMessageModify==xmlResult==");
	//	log.info(xmlResult);
		
		
		if(header.getSubject().getDocumentType() == 4) {
			data = createContentSendFromBGTVTToNSWInland(header, xmlResult);
			SendMessgaeFunctions.insertMessageQueue(header, data, "OUT", requestCode, MessgaePriorityLevels.HIGHT);
			return createContentSendFromBGTVTToNSWInland(header, xmlResult);
		} else {
			data = createContentSendFromBGTVTToNSW(header, xmlResult);
			SendMessgaeFunctions.insertMessageQueue(header, data, "OUT", requestCode, MessgaePriorityLevels.HIGHT);
			return createContentSendFromBGTVTToNSW(header, xmlResult);
		}
	}

	// Ham gui ban tin tu choi tu BGTVT sang NSW
	public String sendMessageHuyHoSo(Header header, String organization, String division, String name, Date canceDate, String reason, String requestCode) {
		String xmlResult = "";
		String data="";
	//	TempDocument tempDocument = TempDocumentLocalServiceUtil.findTemDocumentByDocumentNameDocumentYear(header.getSubject().getDocumentType(), header.getSubject().getDocumentYear());
		try {
			
			if(header.getSubject().getDocumentType() == 4 || header.getSubject().getDocumentType() == 5) {
				xmlResult = CreateMessageFactory.createMessageHuyGiayPhepRoiCangInland(organization, division, name, canceDate, reason, 1);
			} else {
				xmlResult = CreateMessageFactory.createMessageHuyGiayPhepRoiCang(organization, division, name, canceDate, reason, 1);
			}
			
			// Insert history.
			insertHistory(header, xmlResult, BoGiaoThongToHqmc, TrangThaiHoSo.DA_GHI_NHO_YEU_CAU, UUID.randomUUID().toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(header.getSubject().getDocumentType() == 4 || header.getSubject().getDocumentType() == 5) {
			data = createContentSendFromBGTVTToNSWInland(header, xmlResult);
			SendMessgaeFunctions.insertMessageQueue(header, data, "OUT", requestCode, MessgaePriorityLevels.HIGHT);
			return createContentSendFromBGTVTToNSWInland(header, xmlResult);
		} else {
			data = createContentSendFromBGTVTToNSW(header, xmlResult);
			SendMessgaeFunctions.insertMessageQueue(header, data, "OUT", requestCode, MessgaePriorityLevels.HIGHT);
			return createContentSendFromBGTVTToNSW(header, xmlResult);
		}
	}

	
	public String sendMessageHuyHoSoNew(Header header, String organization, String division, String name, Date canceDate, String reason, String requestCode) {
		String xmlResult = "";
		String data = "";
		//TempDocument tempDocument = TempDocumentLocalServiceUtil.findTemDocumentByDocumentNameDocumentYear(header.getSubject().getDocumentType(), header.getSubject().getDocumentYear());
		try {
		
				xmlResult = CreateMessageFactory.createMessageHuyGiayPhepRoiCang(organization, division, name, canceDate, reason, 1);
			
			// Insert history.
			insertHistory(header, xmlResult, BoGiaoThongToHqmc, TrangThaiHoSo.DA_GHI_NHO_YEU_CAU, UUID.randomUUID().toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(header.getSubject().getDocumentType() == 4 || header.getSubject().getDocumentType() == 5) {
			data = createContentSendFromBGTVTToNSWInland(header, xmlResult);
			SendMessgaeFunctions.insertMessageQueue(header, data, "OUT", requestCode, MessgaePriorityLevels.HIGHT);
			return createContentSendFromBGTVTToNSWInland(header, xmlResult);
		} else {
			data = createContentSendFromBGTVTToNSW(header, xmlResult);
			SendMessgaeFunctions.insertMessageQueue(header, data, "OUT", requestCode, MessgaePriorityLevels.HIGHT);
			return createContentSendFromBGTVTToNSW(header, xmlResult);
		}
	}
	
	
	// Ham gui ban tin tu choi tu BGTVT sang NSW
	public String sendMessageHuyHoLenhDieuDong(Header header, String organization, String division, String name, String reason, Date canceDate, Integer isApprove,String requestCode) {
		String xmlResult = "";
		String data = "";
		//TempDocument tempDocument = TempDocumentLocalServiceUtil.findTemDocumentByDocumentNameDocumentYear(header.getSubject().getDocumentType(), header.getSubject().getDocumentYear());
		// Tao ban tin tra ve bao da nhan thong tin.
		try {
			
	
				xmlResult = CreateMessageFactory.createMessageHuyLenhDieuDong(organization, division, name, reason, canceDate, isApprove);
			
			
			// Insert history.
			insertHistory(header, xmlResult, BoGiaoThongToHqmc, TrangThaiHoSo.DA_GHI_NHO_YEU_CAU, UUID.randomUUID().toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(header.getSubject().getDocumentType() == 4 || header.getSubject().getDocumentType() == 5) {
			data = createContentSendFromBGTVTToNSWInland(header, xmlResult);
			SendMessgaeFunctions.insertMessageQueue(header, data, "OUT", requestCode, MessgaePriorityLevels.HIGHT);
			return createContentSendFromBGTVTToNSWInland(header, xmlResult);
		} else {
			data = createContentSendFromBGTVTToNSW(header, xmlResult);
			SendMessgaeFunctions.insertMessageQueue(header, data, "OUT", requestCode, MessgaePriorityLevels.HIGHT);
			return createContentSendFromBGTVTToNSW(header, xmlResult);
		}
	}

	public String sendMessageHuyGiayPhepRoiCang(Header header, String organization, String division, String name, String reason, Date canceDate, Integer isApprove, String requestCode) {
		String xmlResult = "";
		String data = "";
		//TempDocument tempDocument = TempDocumentLocalServiceUtil.findTemDocumentByDocumentNameDocumentYear(header.getSubject().getDocumentType(), header.getSubject().getDocumentYear());
		log.info("==sendMessageHuyGiayPhepRoiCang==");
		// Tao ban tin tra ve bao da nhan thong tin.
		try {
			xmlResult = CreateMessageFactory.createMessageHuyGiayPhepRoiCang(organization, division, name, reason, canceDate, isApprove);
			
			// Insert history.
			insertHistory(header, xmlResult, BoGiaoThongToHqmc, TrangThaiHoSo.DA_GHI_NHO_YEU_CAU, UUID.randomUUID().toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		data = createContentSendFromBGTVTToNSW(header, xmlResult);
		SendMessgaeFunctions.insertMessageQueue(header, data, "OUT", requestCode, MessgaePriorityLevels.HIGHT);
		return createContentSendFromBGTVTToNSW(header, xmlResult);
	}

	public String sendMessageHuyGiayPhepQuaCanh(Header header, String organization, String division, String name, String reason, Date canceDate, Integer isApprove, String requestCode) {
		String xmlResult = "";
		String data = "";
		//TempDocument tempDocument = TempDocumentLocalServiceUtil.findTemDocumentByDocumentNameDocumentYear(header.getSubject().getDocumentType(), header.getSubject().getDocumentYear());
		log.info("==sendMessageHuyGiayPhepQuaCanh==");
		// Tao ban tin tra ve bao da nhan thong tin.
		try {
			
			xmlResult = CreateMessageFactory.createMessageHuyGiayPhepQuaCanh(organization, division, name, reason, canceDate, isApprove);
			
			// Insert history.
			insertHistory(header, xmlResult, BoGiaoThongToHqmc, TrangThaiHoSo.DA_GHI_NHO_YEU_CAU, UUID.randomUUID().toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		data = createContentSendFromBGTVTToNSW(header, xmlResult);
		SendMessgaeFunctions.insertMessageQueue(header, data, "OUT", requestCode, MessgaePriorityLevels.HIGHT);
		return createContentSendFromBGTVTToNSW(header, xmlResult);
	}

	public String sendMessageKhaiHuyHoSo(Header header, String organization, String division, String name, String reason, Date canceDate, Integer isApprove, String requestCode) {
		String xmlResult = "";
		String data = "";
	//	TempDocument tempDocument = TempDocumentLocalServiceUtil.findTemDocumentByDocumentNameDocumentYear(header.getSubject().getDocumentType(), header.getSubject().getDocumentYear());
		log.info("==sendMessageKhaiHuyHoSo==");
		// Tao ban tin tra ve bao da nhan thong tin.
		try {
			
			xmlResult = CreateMessageFactory.createMessageKhaiHuyHoSo(organization, division, name, reason, canceDate, isApprove);
			
			// Insert history.
			insertHistory(header, xmlResult, BoGiaoThongToHqmc, TrangThaiHoSo.DA_GHI_NHO_YEU_CAU, UUID.randomUUID().toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		data = createContentSendFromBGTVTToNSW(header, xmlResult);
		SendMessgaeFunctions.insertMessageQueue(header, data, "OUT", requestCode, MessgaePriorityLevels.HIGHT);
		return createContentSendFromBGTVTToNSW(header, xmlResult);
	}

	// Ham gui ban tin tu choi tu BGTVT sang NSW
	public String sendShiftingOrder(Header header, TempDocument tempDocument) {
		log.info("==sendShiftingOrder=");
		String xmlResult = "";
		String data = "";
		try {
			ShiftingOrder2Xml shiftingOrder2Xml = new ShiftingOrder2Xml();
			ShiftingOrder shiftingOrder = shiftingOrder2Xml.insert2ShiftingOrderByVersion(tempDocument.getDocumentName(),
					tempDocument.getDocumentYear(), header.getReference().getVersion());
			
			if (shiftingOrder.getPortofAuthority() != null && shiftingOrder.getPortofAuthority().length() > 0) {
				DmMaritime dmMaritime = DmMaritimeLocalServiceUtil.getByMaritimeCode(shiftingOrder.getPortofAuthority());
				if (dmMaritime != null) {
					shiftingOrder.setPortofAuthority(dmMaritime.getMaritimeReference());
				}
			}
			// / Sua lai truoc khi gui di
			// TODO sendShiftingOrder XXXXX
			// shiftingOrder.setShiftingPortWharfCode("XXXXX");
			xmlResult = MessageFactory.convertObjectToXml(shiftingOrder);
			
			// Insert history.
			insertHistory(header, xmlResult, BoGiaoThongToHqmc, TrangThaiHoSo.DA_GHI_NHO_YEU_CAU, UUID.randomUUID().toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		data = createContentSendFromBGTVTToNSW(header, xmlResult);
		SendMessgaeFunctions.insertMessageQueue(header, data, "OUT", tempDocument.getRequestCode(), MessgaePriorityLevels.HIGHT);
		return createContentSendFromBGTVTToNSW(header, xmlResult);
	}

	// Ham gui ban tin tu choi tu BGTVT sang NSW
	public String sendShiftingOrderInland(Header header, TempDocument tempDocument) {
		log.info("==sendShiftingOrder=");
		String xmlResult = "";
		String data = "";
		try {
			ShiftingOrder2Xml shiftingOrder2Xml = new ShiftingOrder2Xml();
			InlandShiftingOrder shiftingOrder = shiftingOrder2Xml.insert2ShiftingOrderByVersionInland(tempDocument.getDocumentName(),
					tempDocument.getDocumentYear(), header.getReference().getVersion());
			
			if (shiftingOrder.getPortofAuthority() != null && shiftingOrder.getPortofAuthority().length() > 0) {
				DmMaritime dmMaritime = DmMaritimeLocalServiceUtil.getByMaritimeCode(shiftingOrder.getPortofAuthority());
				if (dmMaritime != null) {
					shiftingOrder.setPortofAuthority(dmMaritime.getMaritimeReference());
				}
			}
			// / Sua lai truoc khi gui di
			// TODO sendShiftingOrder XXXXX
			// shiftingOrder.setShiftingPortWharfCode("XXXXX");
			xmlResult = MessageFactory.convertObjectToXml(shiftingOrder);
			
			// Insert history.
			insertHistory(header, xmlResult, BoGiaoThongToHqmc, TrangThaiHoSo.DA_GHI_NHO_YEU_CAU, UUID.randomUUID().toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		data = createContentSendFromBGTVTToNSWInland(header, xmlResult);
		SendMessgaeFunctions.insertMessageQueue(header, data, "OUT", tempDocument.getRequestCode(), MessgaePriorityLevels.HIGHT);
		return createContentSendFromBGTVTToNSWInland(header, xmlResult);
	}	
	
	
	public String sendNoticeOfArrivalCancel(Header header, TempDocument tempDocument, String rejectCode, String rejectDesc, String organization,
			String division, String name, Date rejectDate) {
		
		String xmlResult = "";
		String data = "";
		log.info("==sendNoticeOfArrivalCancel==");
		// Tao ban tin tra ve bao da nhan thong tin.
		try {
			
			NoticeOfArrivalCancel noticeOfArrivalCancel = new NoticeOfArrivalCancel();
			noticeOfArrivalCancel.setCallSign(tempDocument.getCallSign());
			noticeOfArrivalCancel.setCancelDate(FormatData.parseDateToTring(rejectDate));
			noticeOfArrivalCancel.setDivision(division);
			noticeOfArrivalCancel.setDocumentName(tempDocument.getDocumentName() + "");
			noticeOfArrivalCancel.setFlagStateOfShip(tempDocument.getStateCode());
			noticeOfArrivalCancel.setIMONumber(tempDocument.getImo());
			noticeOfArrivalCancel.setName(name);
			noticeOfArrivalCancel.setNameOfMaster(tempDocument.getShipCaptain());
			noticeOfArrivalCancel.setNameOfShip(tempDocument.getShipName());
			noticeOfArrivalCancel.setOrganization(organization);
			noticeOfArrivalCancel.setShipTypeCode(tempDocument.getShipTypeCode());
			noticeOfArrivalCancel.setUserCreated(tempDocument.getUserCreated());
			
			xmlResult = CreateMessageFactory.createNoticeOfArrivalCancel(noticeOfArrivalCancel);
			
			// Insert history.
			insertHistory(header, xmlResult, BoGiaoThongToHqmc, TrangThaiHoSo.DA_GHI_NHO_YEU_CAU, UUID.randomUUID().toString());
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}
		data = createContentSendFromBGTVTToNSW(header, xmlResult);
		SendMessgaeFunctions.insertMessageQueue(header, data, "OUT", tempDocument.getRequestCode(), MessgaePriorityLevels.HIGHT);
		return createContentSendFromBGTVTToNSW(header, xmlResult);
	}

	// Ham gui ban tin chap nhan tu BGTVT sang NSW
	public String sendMessageAccept(Header header, String organization, String division, String name, Date acceptDate, String requestCode) {
		log.info("==sendMessageAccept==");
		String xmlResult = "";
		String data = "";
		//System.out.println("====header.getSubject().getDocumentType()=====" + header.getReference().getMessageId()+ "header.getSubject().getDocumentYear()" + header.getSubject().getDocumentYear());
		//TempDocument tempDocument = TempDocumentLocalServiceUtil.findTemDocumentByDocumentNameDocumentYear(Long.valueOf(header.getReference().getMessageId()), header.getSubject().getDocumentYear());
		// Tao ban tin tra ve bao da nhan thong tin.
		try {
			
			xmlResult = CreateMessageFactory.createMessageAccept(organization, division, name, acceptDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(header.getSubject().getDocumentType() == 4 || header.getSubject().getDocumentType() == 5) {
			data = createContentSendFromBGTVTToNSWInland(header, xmlResult);
			
				SendMessgaeFunctions.insertMessageQueue(header, data, "OUT", requestCode, MessgaePriorityLevels.HIGHT);
			
			
			return createContentSendFromBGTVTToNSWInland(header, xmlResult);
		} else {
			data = createContentSendFromBGTVTToNSW(header, xmlResult);
			SendMessgaeFunctions.insertMessageQueue(header, data, "OUT", requestCode, MessgaePriorityLevels.HIGHT);
			return createContentSendFromBGTVTToNSW(header, xmlResult);
		}
		
		
	}
	
	
	
	
	//dungle them message SentMessageAcceptDinhKem
	public String SentMessageRejectDinhKem(Header header, String rejectDesc, String organization, String division, String name, Date rejectDate, TempDocument tempDocument) {
		log.info("==Them SentMessageRejectDinhKem==");
		String xmlResult = "";
		String data = "";
		// Tao ban tin tra ve bao da nhan thong tin.
		try {
			
			xmlResult = CreateMessageFactory.createMessageAcceptDinhKem( rejectDesc,  organization,  division,  name,  rejectDate, tempDocument);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(header.getSubject().getDocumentType() == MessageType.TAU_VAO || header.getSubject().getDocumentType() == MessageType.TAU_RA) {
			data = createContentSendFromBGTVTToNSWInland(header, xmlResult);
			SendMessgaeFunctions.insertMessageQueue(header, data, "OUT", tempDocument.getRequestCode(), MessgaePriorityLevels.HIGHT);
			return createContentSendFromBGTVTToNSWInland(header, xmlResult);
		} else {
			data = createContentSendFromBGTVTToNSW(header, xmlResult);
			SendMessgaeFunctions.insertMessageQueue(header, data, "OUT", tempDocument.getRequestCode(), MessgaePriorityLevels.HIGHT);
			return createContentSendFromBGTVTToNSW(header, xmlResult);
		}
	}
	
	public String SentMessageAcceptDinhKem(Header header, String rejectDesc, String organization, String division, String name, Date rejectDate, TempDocument tempDocument) {
		log.info("==Them SentMessageAcceptDinhKem==");
		String xmlResult = "";
		String data = "";
		// Tao ban tin tra ve bao da nhan thong tin.
		try {
			
			xmlResult = CreateMessageFactory.createMessageDongYDinhKem( rejectDesc,  organization,  division,  name,  rejectDate, tempDocument);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(header.getSubject().getDocumentType() == MessageType.TAU_VAO || header.getSubject().getDocumentType() == MessageType.TAU_RA) {
			
			data = createContentSendFromBGTVTToNSWInland(header, xmlResult);
			SendMessgaeFunctions.insertMessageQueue(header, data, "OUT", tempDocument.getRequestCode(), MessgaePriorityLevels.HIGHT);
			return createContentSendFromBGTVTToNSWInland(header, xmlResult);
		} else {
			data = createContentSendFromBGTVTToNSW(header, xmlResult);
			SendMessgaeFunctions.insertMessageQueue(header, data, "OUT", tempDocument.getRequestCode(), MessgaePriorityLevels.HIGHT);
			return createContentSendFromBGTVTToNSW(header, xmlResult);
		}
	}
	
	
	public String SentMessageTucChoiDinhKem(Header header, String rejectDesc, String organization, String division, String name, Date rejectDate, TempDocument tempDocument, String lydotuchoi) {
		log.info("==Them SentMessageAcceptDinhKem==");
		String xmlResult = "";
		String data = "";
		
		// Tao ban tin tra ve bao da nhan thong tin.
		try {
			
			
			xmlResult = CreateMessageFactory.createMessageTuChoiDinhKem( rejectDesc,  organization,  division,  name,  rejectDate, tempDocument, lydotuchoi);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(header.getSubject().getDocumentType() == MessageType.TAU_VAO || header.getSubject().getDocumentType() == MessageType.TAU_RA) {
			data = createContentSendFromBGTVTToNSWInland(header, xmlResult);
			SendMessgaeFunctions.insertMessageQueue(header, data, "OUT", tempDocument.getRequestCode(), MessgaePriorityLevels.HIGHT);
			return createContentSendFromBGTVTToNSWInland(header, xmlResult);
		} else {
			data = createContentSendFromBGTVTToNSW(header, xmlResult);
			SendMessgaeFunctions.insertMessageQueue(header, data, "OUT", tempDocument.getRequestCode(), MessgaePriorityLevels.HIGHT);
			return createContentSendFromBGTVTToNSW(header, xmlResult);
		}
	}

	// Ham gui ban tin xac nhan tu BGTVT sang NSW.
	public String sendMessageConformed(Header header, Date acceptDate, String requestCode) {
		
		String xmlResult = "";
		String data = "";
		//TempDocument tempDocument = TempDocumentLocalServiceUtil.findTemDocumentByDocumentNameDocumentYear(header.getSubject().getDocumentType(), header.getSubject().getDocumentYear());
		log.info("==sendMessageConformed==");
		// Tao ban tin tra ve bao da nhan thong tin.
		try {
			xmlResult = "<ReceiveDate>" + FormatData.parseDateToTring(new Date()) + "</ReceiveDate>";
			
			// Insert history.
			insertHistory(header, xmlResult, BoGiaoThongToHqmc, TrangThaiHoSo.DA_GHI_NHO_YEU_CAU, UUID.randomUUID().toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(header.getSubject().getDocumentType() == 4 || header.getSubject().getDocumentType() == 5) {
			data = createContentSendFromBGTVTToNSWInland(header, xmlResult);
			SendMessgaeFunctions.insertMessageQueue(header, data, "OUT", requestCode, MessgaePriorityLevels.HIGHT);
			return createContentSendFromBGTVTToNSWInland(header, xmlResult);
		} else {
			data = createContentSendFromBGTVTToNSW(header, xmlResult);
			SendMessgaeFunctions.insertMessageQueue(header, data, "OUT", requestCode, MessgaePriorityLevels.HIGHT);
			return createContentSendFromBGTVTToNSW(header, xmlResult);
		}
		
	}

	/**
	 * @param header
	 * @param liObjects
	 * @param requestDirection
	 * @return true: la du lieu dung, false la du lieu sai.
	 */
	public boolean validationData(Header header, List<Object> liObjects, String requestDirection) {
		boolean resultStatus = true;
		try {
			HeaderValidation headerValidation = new HeaderValidation();
			if (!headerValidation.validation(header, requestDirection)) {
				resultStatus = false;
			}
			for (Object object : liObjects) {
				if (object instanceof ShipSecurityNotification) {
					ShipSecurityNotificationValidation securityNotificationValidation = new ShipSecurityNotificationValidation();
					if (!securityNotificationValidation.validation(ShipSecurityNotification.class.cast(object), header, requestDirection)) {
						resultStatus = false;
					}
				} else if (object instanceof CargoDeclaration) {
					CargoDeclarationValidation cargoDeclarationValidation = new CargoDeclarationValidation();
					if (!cargoDeclarationValidation.validation(CargoDeclaration.class.cast(object), header, requestDirection)) {
						resultStatus = false;
					}
				} else if (object instanceof CrewLists) {
					CrewListValidation crewListValidation = new CrewListValidation();
					if (!crewListValidation.validation(CrewLists.class.cast(object), header, requestDirection)) {
						resultStatus = false;
					}
				} else if (object instanceof DangerousGoodsManifest) {
					DangerousGoodsManifestValidation dangerousGoodsManifestValidation = new DangerousGoodsManifestValidation();
					if (!dangerousGoodsManifestValidation.validation(DangerousGoodsManifest.class.cast(object), header, requestDirection)) {
						resultStatus = false;
					}
				} else if (object instanceof CrewEffectsDeclaration) {
					CrewEffectsDeclarationValidation crewEffectsDeclarationValidation = new CrewEffectsDeclarationValidation();
					if (!crewEffectsDeclarationValidation.validation(CrewEffectsDeclaration.class.cast(object), header, requestDirection)) {
						resultStatus = false;
					}
				} else if (object instanceof NoticeOfArrival) {
					NoticeOfArrivalValidation noticeOfArrivalValidation = new NoticeOfArrivalValidation();
					if (!noticeOfArrivalValidation.validation(NoticeOfArrival.class.cast(object), header, requestDirection)) {
						resultStatus = false;
					}
				} else if (object instanceof PassengerList) {
					PassengerListValidation passengerListValidation = new PassengerListValidation();
					if (!passengerListValidation.validation(PassengerList.class.cast(object), header, requestDirection)) {
						resultStatus = false;
					}
				} else if (object instanceof ShipsStoresDeclaration) {
					ShipsStoresDeclarationValidation shipsStoresDeclarationValidation = new ShipsStoresDeclarationValidation();
					if (!shipsStoresDeclarationValidation.validation(ShipsStoresDeclaration.class.cast(object), header, requestDirection)) {
						resultStatus = false;
					}
				} else if (object instanceof DeclarationForAnimalQuarantine) {
					DeclarationForAnimalQuarantineValidation declarationForAnimalQuarantineValidation = new DeclarationForAnimalQuarantineValidation();
					if (!declarationForAnimalQuarantineValidation.validation(DeclarationForAnimalQuarantine.class.cast(object), header,
							requestDirection)) {
						resultStatus = false;
					}
				} else if (object instanceof DeclarationForPlantQuarantine) {
					DeclarationForPlantQuarantineValidation declarationForPlantQuarantineValidation = new DeclarationForPlantQuarantineValidation();
					if (!declarationForPlantQuarantineValidation.validation(DeclarationForPlantQuarantine.class.cast(object), header,
							requestDirection)) {
						resultStatus = false;
					}
				} else if (object instanceof GeneralDeclaration) {
					GeneralDeclarationValidation generalDeclarationValidation = new GeneralDeclarationValidation();
					if (!generalDeclarationValidation.validation(GeneralDeclaration.class.cast(object), header, requestDirection)) {
						resultStatus = false;
					}
				} else if (object instanceof HealthQuanrantineDeclare) {
					HealthQuanrantineDeclareValidation healthQuanrantineDeclareValidation = new HealthQuanrantineDeclareValidation();
					if (!healthQuanrantineDeclareValidation.validation(HealthQuanrantineDeclare.class.cast(object), header, requestDirection)) {
						resultStatus = false;
					}
				}
				/* 
				  Inland
				 * */
				else if(object instanceof InlandShiftingOrder) {
					InlandShiftingOrderValidation inlandShiftingOrderValidation = new InlandShiftingOrderValidation();
					if(!inlandShiftingOrderValidation.validation(InlandShiftingOrder.class.cast(object), header, requestDirection)) {
						resultStatus = false;
					}
							
				} else if(object instanceof InlandCrewLists) {
					InlandCrewListValidation inlandCrewListValidation = new InlandCrewListValidation();
					if(!inlandCrewListValidation.validation(InlandCrewLists.class.cast(object), header, requestDirection)) {
						resultStatus = false;
					}
				} else if(object instanceof InlandPassengerList) {
					InlandPassengerListValidation inlandPassengerList = new InlandPassengerListValidation();
					if(!inlandPassengerList.validation(InlandPassengerList.class.cast(object), header, requestDirection)) {
						resultStatus = false;
					}
				} else if(object instanceof InlandPortClearance) {
					InlandPortClearanceValidation inlandPortClearanceValidation = new InlandPortClearanceValidation();
					if(!inlandPortClearanceValidation.validation(InlandPortClearance.class.cast(object), header, requestDirection)) {
						resultStatus = false;
					}
				} else if(object instanceof InlandNoticeOfArrival) {
					InlandNoticeOfArrivalValidation inlandNoticeOfArrivalValidation = new InlandNoticeOfArrivalValidation();
					if(!inlandNoticeOfArrivalValidation.validation(InlandNoticeOfArrival.class.cast(object), header, requestDirection)) {
						resultStatus = false;
					}
				} else if(object instanceof Attachment) {
					AttachmentValidation attachmentValidation = new AttachmentValidation();
					if(!attachmentValidation.validation(Attachment.class.cast(object), header, requestDirection)) {
						resultStatus = false;
					}
				} 
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultStatus;
	}

	public String insertTempTable(Header header, List<Object> liObjects) {
		// boolean result = true;
		System.out.println("==insertTempTable==");
		try {
			for (Object object : liObjects) {
				
				if (object instanceof ShipSecurityNotification) {
					ShipSecurityNotification2Temp securityNotification2Temp = new ShipSecurityNotification2Temp();
					securityNotification2Temp.insert2Temp(ShipSecurityNotification.class.cast(object), header);
					
				} else if (object instanceof CargoDeclaration) {
					CargoDeclaration2Temp cargoDeclaration2Temp = new CargoDeclaration2Temp();
					cargoDeclaration2Temp.insert2Temp(CargoDeclaration.class.cast(object), header);
					
				} else if (object instanceof CrewLists) {
					
					CrewList2Temp crewList2Temp = new CrewList2Temp();
					crewList2Temp.insert2Temp(CrewLists.class.cast(object), header);
					
				} else if (object instanceof DangerousGoodsManifest) {
					DangerousGoodsManifest2Temp dangerousGoodsManifest2Temp = new DangerousGoodsManifest2Temp();
					dangerousGoodsManifest2Temp.insert2Temp(DangerousGoodsManifest.class.cast(object), header);
					
				} else if (object instanceof CrewEffectsDeclaration) {
					CrewEffectsDeclaration2Temp crewEffectsDeclaration2Temp = new CrewEffectsDeclaration2Temp();
					crewEffectsDeclaration2Temp.insert2Temp(CrewEffectsDeclaration.class.cast(object), header);
					
				} else if (object instanceof NoticeOfArrival) {
					NoticeOfArrival2Temp noticeOfArrival2Temp = new NoticeOfArrival2Temp();
					noticeOfArrival2Temp.insert2Temp(NoticeOfArrival.class.cast(object), header);
					
				} else if (object instanceof PassengerList) {
					PassengerList2Temp passengerList2Temp = new PassengerList2Temp();
					passengerList2Temp.insert2Temp(PassengerList.class.cast(object), header);
					
				} else if (object instanceof ShipsStoresDeclaration) {
					ShipsStoresDeclaration2Temp shipsStoresDeclaration2Temp = new ShipsStoresDeclaration2Temp();
					shipsStoresDeclaration2Temp.insert2Temp(ShipsStoresDeclaration.class.cast(object), header);
				} else if (object instanceof DeclarationForAnimalQuarantine) {
					DeclarationForAnimalQuarantine2Temp declarationForAnimalQuarantine2Temp = new DeclarationForAnimalQuarantine2Temp();
					declarationForAnimalQuarantine2Temp.insert2Temp(DeclarationForAnimalQuarantine.class.cast(object), header);
					
				} else if (object instanceof DeclarationForPlantQuarantine) {
					DeclarationForPlantQuarantine2Temp declarationForPlantQuarantine2Temp = new DeclarationForPlantQuarantine2Temp();
					declarationForPlantQuarantine2Temp.insert2Temp(DeclarationForPlantQuarantine.class.cast(object), header);
					
				} else if (object instanceof GeneralDeclaration) {
					GeneralDeclaration2Temp generalDeclaration2Temp = new GeneralDeclaration2Temp();
					generalDeclaration2Temp.insert2Temp(GeneralDeclaration.class.cast(object), header);
					
				} else if (object instanceof HealthQuanrantineDeclare) {
					HealthQuanrantineDeclare2Temp healthQuanrantineDeclare2Temp = new HealthQuanrantineDeclare2Temp();
					healthQuanrantineDeclare2Temp.insert2Temp(HealthQuanrantineDeclare.class.cast(object), header);
				}
				
				//Inland GeneralDeclaration
				
				else if (object instanceof InlandGeneralDeclaration) {
					System.out.println("==insertTempTable==  InlandGeneralDeclaration");
					InlandGeneralDeclaration2Temp inlandGeneralDeclaration2Temp = new InlandGeneralDeclaration2Temp();
					inlandGeneralDeclaration2Temp.insert2Temp(InlandGeneralDeclaration.class.cast(object), header);
				} 
				else if (object instanceof InlandPassengerList) {
					System.out.println("==insertTempTable==  InlandPassengerList");
					InlandPassengerList2Temp inlandPassengerList2Temp = new InlandPassengerList2Temp();
					inlandPassengerList2Temp.insert2TempInland(InlandPassengerList.class.cast(object), header);
				} else if (object instanceof InlandNoticeOfArrival) {
					System.out.println("==insertTempTable==  InlandNoticeOfArrival");
					InlandNoticeOfArrival2Temp inlandNoticeOfArrival2Temp = new InlandNoticeOfArrival2Temp();
					inlandNoticeOfArrival2Temp.insert2Temp(InlandNoticeOfArrival.class.cast(object), header);
				} else if (object instanceof InlandCrewLists) {
					System.out.println("==insertTempTable==  InlandCrewLists");
					InlandCrewList2Temp inlandCrewList2Temp = new InlandCrewList2Temp();
					inlandCrewList2Temp.insert2Temp(InlandCrewLists.class.cast(object), header);
				}else if (object instanceof Attachment) {
					System.out.println("==insertResultCertificate==  Attachment");
					Attachment2ResultCertificate attachment2ResultCertificate = new Attachment2ResultCertificate();
					attachment2ResultCertificate.insert2ResultCertificate(Attachment.class.cast(object), header);
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
		return null;
	}

	public String insertHistory(Header header, String data, String direction, int requestState, String uuid) {
		String kq = null;
		try {
			
			if (uuid == null) {
				log.info("==Starting insert--InterfaceRequest MessageId==" + header.getReference().getMessageId());
			} else {
				log.info("==Starting insert--InterfaceRequest MessageId==" + uuid);
			}
			InterfaceRequest interfaceRequest = new InterfaceRequestImpl();
			// interfaceRequest.setRemarks(remarks)
			interfaceRequest.setBusinessType(String.valueOf(header.getSubject().getType()));
			interfaceRequest.setDocumentType(String.valueOf(header.getSubject().getDocumentType()));
			interfaceRequest.setFunctionType(header.getSubject().getFunction());
			
			interfaceRequest.setReceiverIdentify(header.getTo().getIdentity());
			interfaceRequest.setRequestVersion(header.getReference().getVersion());
			interfaceRequest.setReceiverName(header.getTo().getName());
			
			interfaceRequest.setSenderIdentify(header.getFrom().getIdentity());
			interfaceRequest.setSenderName(header.getFrom().getName());
			
			if (uuid == null) {
				interfaceRequest.setRequestCode(header.getReference().getMessageId());
			} else {
				interfaceRequest.setRequestCode(uuid);
			}
			//Bo? vao day, nhung HistoryInterfaceRequest van de?
			//interfaceRequest.setRequestContent(data);
			interfaceRequest.setRequestDate(FormatData.parseStringToDate(header.getSubject().getSendDate()));
			interfaceRequest.setRequestDirection(direction);// HqmcToBoGiaoThong
			interfaceRequest.setRequestedDate(new Date());
			interfaceRequest.setRequestResponseTime(new Date());
			interfaceRequest.setRequestState(requestState);// TrangThaiHoSo.DA_GHI_NHO_YEU_CAU
			
			
			InterfaceRequestLocalServiceUtil.addInterfaceRequest(interfaceRequest);
			if (uuid == null) {
				log.info("==End insert--InterfaceRequest MessageId==" + header.getReference().getMessageId());
			} else {
				log.info("==End insert--InterfaceRequest MessageId==" + uuid);
			}
		} catch (Exception e) {
			
			if (uuid == null) {
				log.info("== Exception insert--InterfaceRequest MessageId==" + header.getReference().getMessageId());
			} else {
				log.info("== Exception insert--InterfaceRequest MessageId==" + uuid);
			}
			e.printStackTrace();
			kq = e.getMessage();
		}
		
		// History
		HistoryInterfaceRequest historyInterfaceRequest = null;
		try {
			if (uuid == null) {
				log.info("== Starting insert==HistoryInterfaceRequest MessageId==" + header.getReference().getMessageId());
			} else {
				log.info("== Starting insert==HistoryInterfaceRequest MessageId==" + uuid);
			}
			historyInterfaceRequest = new HistoryInterfaceRequestImpl();
			
			historyInterfaceRequest.setBusinessType(String.valueOf(header.getSubject().getType()));
			historyInterfaceRequest.setDocumentType(String.valueOf(header.getSubject().getDocumentType()));
			historyInterfaceRequest.setFunctionType(header.getSubject().getFunction());
			
			historyInterfaceRequest.setReceiverIdentify(header.getTo().getIdentity());
			historyInterfaceRequest.setRequestVersion(header.getReference().getVersion());
			historyInterfaceRequest.setReceiverName(header.getTo().getName());
			
			historyInterfaceRequest.setSenderIdentify(header.getFrom().getIdentity());
			historyInterfaceRequest.setSenderName(header.getFrom().getName());
			
			if (uuid == null) {
				historyInterfaceRequest.setRequestCode(header.getReference().getMessageId());
			} else {
				historyInterfaceRequest.setRequestCode(uuid);
			}
			
			historyInterfaceRequest.setRequestContent(data);
			historyInterfaceRequest.setRequestDate(FormatData.parseStringToDate(header.getSubject().getSendDate()));
			historyInterfaceRequest.setRequestDirection(direction);
			historyInterfaceRequest.setRequestedDate(new Date());
			historyInterfaceRequest.setRequestResponseTime(new Date());
			historyInterfaceRequest.setRequestState(requestState);
			
			HistoryInterfaceRequestLocalServiceUtil.addHistoryInterfaceRequest(historyInterfaceRequest);
			if (uuid == null) {
				log.info("== End insert==HistoryInterfaceRequest MessageId==" + header.getReference().getMessageId());
			} else {
				log.info("== End insert==HistoryInterfaceRequest MessageId==" + uuid);
			}
		} catch (Exception e) {
			if (uuid == null) {
				log.info("== Exception insert==HistoryInterfaceRequest MessageId==" + header.getReference().getMessageId());
			} else {
				log.info("== Exception insert==HistoryInterfaceRequest MessageId==" + uuid);
			}
			e.printStackTrace();
			try {
				if (historyInterfaceRequest != null) {
					log.info("== Retry insert==HistoryInterfaceRequest MessageId==" + historyInterfaceRequest);
					HistoryInterfaceRequestLocalServiceUtil.addHistoryInterfaceRequest(historyInterfaceRequest);
				} else {
					log.info("== insert==empty HistoryInterfaceRequest MessageId==" + uuid);
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			kq = e.getMessage();
		}
		
		return kq;
	}
	
	public String insertHistoryThreeIssue(Header header, String data, String direction, int requestState, String uuid, String userName) {
		String kq = null;
		try {
			
			log.info("==Starting==InsertHistoryThreeIssue===MessageId==UUID==" + uuid);
			
			InterfaceRequest interfaceRequest = new InterfaceRequestImpl();
			interfaceRequest.setRemarks(getRemarkChapNhan(userName));
			
			interfaceRequest.setBusinessType(String.valueOf(header.getSubject().getType()));
			interfaceRequest.setDocumentType(String.valueOf(header.getSubject().getDocumentType()));
			interfaceRequest.setFunctionType(header.getSubject().getFunction());
			
			interfaceRequest.setReceiverIdentify(header.getTo().getIdentity());
			interfaceRequest.setRequestVersion(header.getReference().getVersion());
			interfaceRequest.setReceiverName(header.getTo().getName());
			
			interfaceRequest.setSenderIdentify(header.getFrom().getIdentity());
			interfaceRequest.setSenderName(header.getFrom().getName());
			
			if (uuid == null) {
				interfaceRequest.setRequestCode(header.getReference().getMessageId());
			} else {
				interfaceRequest.setRequestCode(uuid);
			}
			
			interfaceRequest.setRequestDate(FormatData.parseStringToDate(header.getSubject().getSendDate()));
			interfaceRequest.setRequestDirection(direction);// HqmcToBoGiaoThong
			interfaceRequest.setRequestedDate(new Date());
			interfaceRequest.setRequestResponseTime(new Date());
			interfaceRequest.setRequestState(requestState);// TrangThaiHoSo.DA_GHI_NHO_YEU_CAU
			
			
			InterfaceRequestLocalServiceUtil.addInterfaceRequest(interfaceRequest);
			if (uuid == null) {
				log.info("==End==InsertHistoryThreeIssue===MessageId==" + header.getReference().getMessageId());
			} else {
				log.info("==End==InsertHistoryThreeIssue===MessageId==" + uuid);
			}
		} catch (Exception e) {
			
			if (uuid == null) {
				log.info("== Exception==InsertHistoryThreeIssue===MessageId==" + header.getReference().getMessageId());
			} else {
				log.info("== Exception==InsertHistoryThreeIssue===MessageId==" + uuid);
			}
			e.printStackTrace();
			kq = e.getMessage();
		}
		
		// History
		HistoryInterfaceRequest historyInterfaceRequest = null;
		try {
			if (uuid == null) {
				log.info("== Starting insert==InsertHistoryThreeIssue===MessageId==" + header.getReference().getMessageId());
			} else {
				log.info("== Starting insert==InsertHistoryThreeIssue===MessageId==" + uuid);
			}
			historyInterfaceRequest = new HistoryInterfaceRequestImpl();
			
			historyInterfaceRequest.setBusinessType(String.valueOf(header.getSubject().getType()));
			historyInterfaceRequest.setDocumentType(String.valueOf(header.getSubject().getDocumentType()));
			historyInterfaceRequest.setFunctionType(header.getSubject().getFunction());
			
			historyInterfaceRequest.setReceiverIdentify(header.getTo().getIdentity());
			historyInterfaceRequest.setRequestVersion(header.getReference().getVersion());
			historyInterfaceRequest.setReceiverName(header.getTo().getName());
			
			historyInterfaceRequest.setSenderIdentify(header.getFrom().getIdentity());
			historyInterfaceRequest.setSenderName(header.getFrom().getName());
			
			if (uuid == null) {
				historyInterfaceRequest.setRequestCode(header.getReference().getMessageId());
			} else {
				historyInterfaceRequest.setRequestCode(uuid);
			}
			
			historyInterfaceRequest.setRequestContent(data);
			historyInterfaceRequest.setRequestDate(FormatData.parseStringToDate(header.getSubject().getSendDate()));
			historyInterfaceRequest.setRequestDirection(direction);
			historyInterfaceRequest.setRequestedDate(new Date());
			historyInterfaceRequest.setRequestResponseTime(new Date());
			historyInterfaceRequest.setRequestState(requestState);
			historyInterfaceRequest.setRemarks(getRemarkChapNhan(userName));
			
			HistoryInterfaceRequestLocalServiceUtil.addHistoryInterfaceRequest(historyInterfaceRequest);
			if (uuid == null) {
				log.info("== End insert==HistoryInterfaceRequest MessageId==" + header.getReference().getMessageId());
			} else {
				log.info("== End insert==HistoryInterfaceRequest MessageId==" + uuid);
			}
		} catch (Exception e) {
			if (uuid == null) {
				log.info("== Exception insert==HistoryInterfaceRequest MessageId==" + header.getReference().getMessageId());
			} else {
				log.info("== Exception insert==HistoryInterfaceRequest MessageId==" + uuid);
			}
			e.printStackTrace();
			kq = e.getMessage();
		}
		return kq;
	}

	public void updateHistory(String requestCode, int requestState) {
		try {
			log.info("==updateHistory==(RequestCode)=messageId==" + requestCode);
			InterfaceRequest interfaceRequest = InterfaceRequestLocalServiceUtil.findInterfaceRequestByRequestCode(requestCode);
			interfaceRequest.setRequestState(requestState);
			InterfaceRequestLocalServiceUtil.updateInterfaceRequest(interfaceRequest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// History
		try {
//			HistoryInterfaceRequest historyInterfaceRequest = HistoryInterfaceRequestLocalServiceUtil.findHistoryInterfaceRequestByRequestCode(requestCode);
//			historyInterfaceRequest.setRequestState(requestState);
//			HistoryInterfaceRequestLocalServiceUtil.updateHistoryInterfaceRequest(historyInterfaceRequest);
			HistoryInterfaceRequestField field = HistoryInterfaceRequestFieldLocalServiceUtil.getByRequestCode(requestCode);
			if (Validator.isNotNull(field)) {
				Hashtable<String, String> hashSql = new Hashtable<String, String>();
				hashSql.put(InterfaceRequest2TempUtils.RequestState, requestState + "");
				String sqlUpateById = InterfaceRequest2TempUtils.sqlUpateById(hashSql, field.getId());
				log.info("==updateHistory==sqlUpateById==" + sqlUpateById);
				int updateHistoryInterfaceRequest = HistoryInterfaceRequestLocalServiceUtil.updateHistoryInterfaceRequest(sqlUpateById);
				log.info("==updateHistory==sqlUpateById==" + updateHistoryInterfaceRequest);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateInterFaceRequestForCoQuanBanNganh(String requestCode, int requestState, String locCode) {
		try {
			log.info("==updateInterFaceRequestForCoQuanBanNganh==RequestCode==" + requestCode);
			InterfaceRequest interfaceRequest = InterfaceRequestLocalServiceUtil.findInterfaceRequestByRequestCode(requestCode);
			interfaceRequest.setRequestState(requestState);
			interfaceRequest.setOrganizationCode("01");
			interfaceRequest.setLocCode(locCode);
			InterfaceRequestLocalServiceUtil.updateInterfaceRequest(interfaceRequest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// History
		try {
//			HistoryInterfaceRequest historyInterfaceRequest = HistoryInterfaceRequestLocalServiceUtil.findHistoryInterfaceRequestByRequestCode(requestCode);
//			historyInterfaceRequest.setRequestState(requestState);
//			historyInterfaceRequest.setOrganizationCode("01");
//			historyInterfaceRequest.setLocCode(locCode);
//			HistoryInterfaceRequestLocalServiceUtil.updateHistoryInterfaceRequest(historyInterfaceRequest);
			
			HistoryInterfaceRequestField field = HistoryInterfaceRequestFieldLocalServiceUtil.getByRequestCode(requestCode);
			if (Validator.isNotNull(field)) {
				Hashtable<String, String> hashSql = new Hashtable<String, String>();
				hashSql.put(InterfaceRequest2TempUtils.RequestState, requestState + "");
				hashSql.put(InterfaceRequest2TempUtils.OrganizationCode, "01");
				hashSql.put(InterfaceRequest2TempUtils.LocCode, locCode);
				
				String sqlUpateById = InterfaceRequest2TempUtils.sqlUpateById(hashSql, field.getId());
				log.info("==updateInterFaceRequestForCoQuanBanNganh==sqlUpateById==" + sqlUpateById);
				int updateHistoryInterfaceRequest = HistoryInterfaceRequestLocalServiceUtil.updateHistoryInterfaceRequest(sqlUpateById);
				log.info("==updateInterFaceRequestForCoQuanBanNganh==sqlUpateById==" + updateHistoryInterfaceRequest);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean insertTempDocument(String requestCode, String requestState, String documentName, String documentYear,
			String documentTypeCode, String userCreated, String shipAgencyCode, String shipName, String shipTypeCode, String stateCode,
			String shipCaptain, String imo, String grt, String nt, String dwt, String unitGRT, String unitNT, String unitDWT, String callSign,
			long preDocumentName) {
		try {
			List<TempDocument> liTempDocuments = TempDocumentLocalServiceUtil.findTemDocumentByDocumentNameAndDocumentYear(
					FormatData.convertToLong(documentName), FormatData.convertToInt(documentYear));
			if (liTempDocuments == null || liTempDocuments.size() == 0) {
				TempDocument tempDocument = new TempDocumentImpl();
				
				tempDocument.setRequestCode(requestCode);
				tempDocument.setRequestState(TrangThaiHoSo.TEMP_DOCUMENT_CHO_TIEP_NHAN);
				tempDocument.setDocumentName(preDocumentName);
				tempDocument.setDocumentYear(FormatData.convertToInt(documentYear));
				tempDocument.setUserCreated(userCreated);
				tempDocument.setShipAgencyCode(shipAgencyCode);
				tempDocument.setShipName(shipName);
				tempDocument.setShipTypeCode(shipTypeCode);
				tempDocument.setStateCode(stateCode);
				tempDocument.setShipCaptain(shipCaptain);
				tempDocument.setImo(imo);
				tempDocument.setGrt(FormatData.convertToLong(grt));
				tempDocument.setNt(FormatData.convertToLong(nt));
				tempDocument.setDwt(FormatData.convertToLong(dwt));
				tempDocument.setMaritimeCode("19"); // Tam theo yeu cau BA.
				tempDocument.setUnitDWT(unitDWT);
				tempDocument.setUnitGRT(unitGRT);
				tempDocument.setUnitNT(unitNT);
				tempDocument.setCallSign(callSign);
				tempDocument.setPreDocumentName(String.valueOf(preDocumentName));
				tempDocument.setCreatedDate(new Date());
				tempDocument.setLastModifiedDate(new Date());
				
				TempDocumentLocalServiceUtil.addTempDocument(tempDocument);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static synchronized boolean insert2TempDocument(TempDocument tempDocument, Header header, Object obj) {
		try {
			List<TempDocument> liTempDocuments = TempDocumentLocalServiceUtil.findTemDocumentByDocumentNameAndDocumentYear(tempDocument.getDocumentName(), tempDocument.getDocumentYear());
			
			if (liTempDocuments != null && liTempDocuments.size() > 0) {
				tempDocument = liTempDocuments.get(0);
			} else {
				tempDocument.setRequestState(TrangThaiHoSo.TEMP_DOCUMENT_CHO_TIEP_NHAN);
			}
			
			tempDocument.setPreDocumentName(String.valueOf(header.getSubject().getPreReference()));
			
			//TODO=TempDocumnt -- Tinh ShipDateFrom
			if (header.getSubject().getType() == MessageType.FUNCTION_TYPE_MESSAGETYPE_RESPONSE_WHEN_RECEIVE_REQUEST) {
				if (obj instanceof GeneralDeclaration) {
					tempDocument.setShipDateFrom(FormatData.parseStringToDate(GeneralDeclaration.class.cast(obj).getDateOfArrival()));
					
					if (header.getSubject().getDocumentType() == MessageType.XUAT_CANH) {
						tempDocument.setShipDateTo(FormatData.parseStringToDate(GeneralDeclaration.class.cast(obj).getDateOfArrival()));
					}
					
					tempDocument.setGrt(FormatData.convertToDouble(GeneralDeclaration.class.cast(obj).getGrossTonnage()));
					tempDocument.setUnitGRT(GeneralDeclaration.class.cast(obj).getGrossTonnageUnit());
					tempDocument.setUnitNT(GeneralDeclaration.class.cast(obj).getNetTonnageUnit());
					tempDocument.setNt(FormatData.convertToDouble(GeneralDeclaration.class.cast(obj).getNetTonnage()));
					
					tempDocument.setShipAgencyCode(GeneralDeclaration.class.cast(obj).getTaxCodeOfShipownersAgents());
					tempDocument.setArrivalShipAgency(GeneralDeclaration.class.cast(obj).getTaxCodeOfShipownersAgents());
					tempDocument.setDepartureShipAgency(GeneralDeclaration.class.cast(obj).getTaxCodeOfShipownersAgents());
					
					// BinhNT edit with Hong Son, 10-10-2014, 23h
					DmPortRegion dmPortRegion = DmPortRegionLocalServiceUtil.getByPortRegionCode(GeneralDeclaration.class.cast(obj).getPortRegionCode());
					if (dmPortRegion != null) {
						tempDocument.setMaritimeCode(dmPortRegion.getPortRegionRef());
					} else {
						DmPort dmPort = DmPortLocalServiceUtil.getByPortCode(GeneralDeclaration.class.cast(obj).getPortOfArrivalCode());
						if (dmPort != null) {
							tempDocument.setMaritimeCode(dmPort.getLoCode());
						} else {
							DmPortWharf dmPortWharf = DmPortWharfLocalServiceUtil.getByPortWharfCode(GeneralDeclaration.class.cast(obj).getPortRegionCode());
							if (dmPortWharf != null) {
								DmPortRegion dmPortRegion12 = DmPortRegionLocalServiceUtil.getByPortRegionCode(dmPortWharf.getPortRegionCode());
								if (dmPortRegion12 != null) {
									tempDocument.setMaritimeCode(dmPortRegion12.getPortRegionRef());
								}
							} else {
								DmPortHarbour dmPortHarbour = DmPortHarbourLocalServiceUtil.getByPortHarbourCode(GeneralDeclaration.class.cast(obj).getPortHarbourCode());
								if (dmPortHarbour != null) {
									tempDocument.setMaritimeCode(dmPortHarbour.getPortRegionCode());
								} else {
									tempDocument.setMaritimeCode("19");
								}
							}
						}
					}
					
					// BinhNT Add 2014-10-10
					try {
						// Gia tri mac dinh neu ben HQMC khong truyen du lieu
						// sang.
						if (tempDocument.getMaritimeCode() == null ||
							(tempDocument.getMaritimeCode() != null && tempDocument.getMaritimeCode().trim().length() == 0)) {
							tempDocument.setMaritimeCode("19");
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			} else {
				if (header.getSubject().getType() == MessageType.BAN_KHAI_AN_NINH_TAU_BIEN) {
					tempDocument.setShipDateFrom(FormatData.parseStringToDate(ShipSecurityNotification.class.cast(obj).getETA()));
					
					tempDocument.setGrt(FormatData.convertToDouble(ShipSecurityNotification.class.cast(obj).getGrossTonnage()));
					tempDocument.setUnitGRT(ShipSecurityNotification.class.cast(obj).getGrossTonnageUnit());
					
					tempDocument.setShipAgencyCode(ShipSecurityNotification.class.cast(obj).getTaxCodeOfShipAgent());
					tempDocument.setArrivalShipAgency(ShipSecurityNotification.class.cast(obj).getTaxCodeOfShipAgent());
					tempDocument.setDepartureShipAgency(ShipSecurityNotification.class.cast(obj).getTaxCodeOfShipAgent());
					
					tempDocument.setPortRegionCode(ShipSecurityNotification.class.cast(obj).getPortRegionCode());
					
					DmPortRegion dmPortRegion = DmPortRegionLocalServiceUtil.getByPortRegionCode(ShipSecurityNotification.class.cast(obj).getPortRegionCode());
					if (dmPortRegion != null) {
						tempDocument.setMaritimeCode(dmPortRegion.getPortRegionRef());
					} else {
						DmPortWharf dmPortWharf = DmPortWharfLocalServiceUtil.getByPortWharfCode(ShipSecurityNotification.class.cast(obj).getPortRegionCode());
						if (dmPortWharf != null) {
							DmPortRegion dmPortRegion1 = DmPortRegionLocalServiceUtil.getByPortRegionCode(dmPortWharf.getPortRegionCode());
							if (dmPortRegion1 != null) {
								tempDocument.setMaritimeCode(dmPortRegion1.getPortRegionRef());
							} else {
								tempDocument.setMaritimeCode("19");
							}
						}
					}
					// BinhNT Add 2014-10-10
					try {
						// Gia tri mac dinh neu ben HQMC khong truyen du lieu sang.
						if (tempDocument.getMaritimeCode() == null
								|| (tempDocument.getMaritimeCode() != null && tempDocument.getMaritimeCode().trim().length() == 0)) {
							tempDocument.setMaritimeCode("19");
						}
					} catch (Exception e) {
						e.printStackTrace();
						log.error(e);
					}
				} else if (header.getSubject().getType() == MessageType.THONG_BAO_TAU_DEN_CANG
						|| header.getSubject().getType() == MessageType.THONG_BAO_TAU_ROI_CANG
						|| header.getSubject().getType() == MessageType.XAC_BAO_TAU_DEN_CANG
						|| header.getSubject().getType() == MessageType.THONG_BAO_TAU_QUA_CANH
						|| header.getSubject().getType() == MessageType.XAC_BAO_TAU_QUA_CANH) {
					tempDocument.setShipDateFrom(FormatData.parseStringToDate(NoticeOfArrival.class.cast(obj).getTimeOfArrival()));
					if (header.getSubject().getDocumentType() == MessageType.XUAT_CANH) {
						tempDocument.setShipDateTo(FormatData.parseStringToDate(NoticeOfArrival.class.cast(obj).getTimeOfArrival()));
					}
					
					tempDocument.setGrt(FormatData.convertToDouble(NoticeOfArrival.class.cast(obj).getGT()));
					tempDocument.setUnitGRT(NoticeOfArrival.class.cast(obj).getGTUNIT());
					tempDocument.setUnitDWT(NoticeOfArrival.class.cast(obj).getDWTUNIT());
					tempDocument.setDwt(FormatData.convertToDouble(NoticeOfArrival.class.cast(obj).getDWT()));
					
					tempDocument.setShipAgencyCode(NoticeOfArrival.class.cast(obj).getTaxCodeOfShipownersAgents());
					tempDocument.setArrivalShipAgency(NoticeOfArrival.class.cast(obj).getTaxCodeOfShipownersAgents());
					tempDocument.setDepartureShipAgency(NoticeOfArrival.class.cast(obj).getTaxCodeOfShipownersAgents());
					
					if (NoticeOfArrival.class.cast(obj).getPortOfArrivalCode() != null) {
						tempDocument.setPortCode(NoticeOfArrival.class.cast(obj).getPortOfArrivalCode());
					}
					
					if (NoticeOfArrival.class.cast(obj).getPortRegionCode() != null) {
						tempDocument.setPortRegionCode(NoticeOfArrival.class.cast(obj).getPortRegionCode());
					}
					
					if (NoticeOfArrival.class.cast(obj).getLastPortOfCallCode() != null) {
						tempDocument.setLastPortCode(NoticeOfArrival.class.cast(obj).getLastPortOfCallCode());
					}
					
					// BinhNT edit with Hong Son, 10-10-2014, 22h33
					DmPortRegion dmPortRegion = DmPortRegionLocalServiceUtil.getByPortRegionCode(NoticeOfArrival.class.cast(obj).getPortRegionCode());
					if (dmPortRegion != null) {
						tempDocument.setMaritimeCode(dmPortRegion.getPortRegionRef());
					} else {
						DmPort dmPort = DmPortLocalServiceUtil.getByPortCode(NoticeOfArrival.class.cast(obj).getPortOfArrivalCode());
						if (dmPort != null) {
							tempDocument.setMaritimeCode(dmPort.getLoCode());
						} else {
							DmPortWharf dmPortWharf = DmPortWharfLocalServiceUtil.getByPortWharfCode(NoticeOfArrival.class.cast(obj)
									.getPortRegionCode());
							if (dmPortWharf != null) {
								DmPortRegion dmPortRegion12 = DmPortRegionLocalServiceUtil.getByPortRegionCode(dmPortWharf.getPortRegionCode());
								if (dmPortRegion12 != null) {
									tempDocument.setMaritimeCode(dmPortRegion12.getPortRegionRef());
								}
							} else {
								DmPortHarbour dmPortHarbour = DmPortHarbourLocalServiceUtil.getByPortHarbourCode(NoticeOfArrival.class.cast(obj)
										.getPortHarbourCode());
								if (dmPortHarbour != null) {
									tempDocument.setMaritimeCode(dmPortHarbour.getPortRegionCode());
								} else {
									tempDocument.setMaritimeCode("19");
								}
							}
						}
					}
					
					// BinhNT Add 2014-10-10
					try {
						// Gia tri mac dinh neu ben HQMC khong truyen du lieu
						// sang.
						if (tempDocument.getMaritimeCode() == null
								|| (tempDocument.getMaritimeCode() != null && tempDocument.getMaritimeCode().trim().length() == 0)) {
							tempDocument.setMaritimeCode("19");
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			
			tempDocument.setLastModifiedDate(new Date());
			
			if (liTempDocuments == null || liTempDocuments.size() == 0) {
				
				if (tempDocument.getDocumentTypeCode() == null || tempDocument.getDocumentTypeCode().trim().length() == 0
						|| tempDocument.getDocumentTypeCode().trim().compareTo(String.valueOf(PageType.DOCUMENT_TYPE_NHAP_CANH)) == 0) {
					tempDocument.setDocumentTypeCode(MessageType.LOAT_THU_TUC_NHAP_CANH);
					tempDocument.setShipPosition(PageType.POSITION_SHIP_NHAP_CANH);
				} else if (tempDocument.getDocumentTypeCode().trim().compareTo(String.valueOf(PageType.DOCUMENT_TYPE_XUAT_CANH)) == 0) {
					
					tempDocument.setDocumentTypeCode(MessageType.LOAT_THU_TUC_XUAT_CANH);
					tempDocument.setShipPosition(PageType.POSITION_SHIP_XUAT_CANH);
				} else if (tempDocument.getDocumentTypeCode().trim().compareTo(String.valueOf(PageType.DOCUMENT_TYPE_QUA_CANH)) == 0) {
					
					tempDocument.setDocumentTypeCode(MessageType.LOAT_THU_TUC_QUA_CANH);
					tempDocument.setShipPosition(PageType.POSITION_SHIP_NHAP_CANH);
				}
				tempDocument.setCreatedDate(FormatData.parseStringToDate(header.getSubject().getSendDate()));
				TempDocumentLocalServiceUtil.addTempDocument(tempDocument);
			} else {
				TempDocumentLocalServiceUtil.updateTempDocument(tempDocument);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}
		return false;
	}

	public static synchronized boolean insert2InlanTempDocument(TempDocument tempDocument, Header header, Object obj) {
		try {
			List<TempDocument> liTempDocuments = TempDocumentLocalServiceUtil.findTemDocumentByDocumentNameAndDocumentYear(tempDocument.getDocumentName(), tempDocument.getDocumentYear());
			
			if (liTempDocuments != null && liTempDocuments.size() > 0) {
				tempDocument = liTempDocuments.get(0);
			} else {
				tempDocument.setRequestState(TrangThaiHoSo.TEMP_DOCUMENT_CHO_TIEP_NHAN);
			}
			
			tempDocument.setPreDocumentName(String.valueOf(header.getSubject().getPreReference()));
			
			//TODO=TempDocumnt -- Tinh ShipDateFrom
			if (header.getSubject().getType() == MessageType.FUNCTION_TYPE_MESSAGETYPE_RESPONSE_WHEN_RECEIVE_REQUEST) {
				if (obj instanceof InlandGeneralDeclaration) {
					InlandGeneralDeclaration inlandGeneralDeclaration =InlandGeneralDeclaration.class.cast(obj);
					tempDocument.setShipDateFrom(FormatData.parseStringToDate(inlandGeneralDeclaration.getDateOfArrival()));
					
					if (header.getSubject().getDocumentType() == MessageType.TAU_RA) {
						tempDocument.setShipDateTo(FormatData.parseStringToDate(inlandGeneralDeclaration.getDateOfArrival()));
						
					}
					
//					tempDocument.setGrt(FormatData.convertToDouble(inlandGeneralDeclaration.getGrossTonnage()));
//					tempDocument.setUnitGRT(inlandGeneralDeclaration.getGrossTonnageUnit());
//					tempDocument.setUnitNT(inlandGeneralDeclaration.getNetTonnageUnit());
				//	tempDocument.setNt(FormatData.convertToDouble(inlandGeneralDeclaration.getNetTonnage()));
					
					tempDocument.setShipAgencyCode(inlandGeneralDeclaration.getTaxCodeOfShipownersAgents());
					tempDocument.setArrivalShipAgency(inlandGeneralDeclaration.getTaxCodeOfShipownersAgents());
					tempDocument.setDepartureShipAgency(inlandGeneralDeclaration.getTaxCodeOfShipownersAgents());
					
					// BinhNT edit with Hong Son, 10-10-2014, 23h
					DmPortRegion dmPortRegion = DmPortRegionLocalServiceUtil.getByPortRegionCode(inlandGeneralDeclaration.getPortRegionCode());
					if (dmPortRegion != null) {
						tempDocument.setMaritimeCode(dmPortRegion.getPortRegionRef());
					} else {
						DmPort dmPort = DmPortLocalServiceUtil.getByPortCode(inlandGeneralDeclaration.getPortOfArrivalCode());
						if (dmPort != null) {
							tempDocument.setMaritimeCode(dmPort.getLoCode());
						} else {
							DmPortWharf dmPortWharf = DmPortWharfLocalServiceUtil.getByPortWharfCode(inlandGeneralDeclaration.getPortRegionCode());
							if (dmPortWharf != null) {
								DmPortRegion dmPortRegion12 = DmPortRegionLocalServiceUtil.getByPortRegionCode(dmPortWharf.getPortRegionCode());
								if (dmPortRegion12 != null) {
									tempDocument.setMaritimeCode(dmPortRegion12.getPortRegionRef());
								}
							} else {
								DmPortHarbour dmPortHarbour = DmPortHarbourLocalServiceUtil.getByPortHarbourCode(inlandGeneralDeclaration.getPortHarbourCode());
								if (dmPortHarbour != null) {
									tempDocument.setMaritimeCode(dmPortHarbour.getPortRegionCode());
								} else {
									tempDocument.setMaritimeCode("19");
								}
							}
						}
					}
					
					// BinhNT Add 2014-10-10
					try {
						// Gia tri mac dinh neu ben HQMC khong truyen du lieu
						// sang.
						if (tempDocument.getMaritimeCode() == null ||
							(tempDocument.getMaritimeCode() != null && tempDocument.getMaritimeCode().trim().length() == 0)) {
							tempDocument.setMaritimeCode("19");
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			} else {
				if (header.getSubject().getType() == MessageType.BAN_KHAI_AN_NINH_TAU_BIEN) {
					tempDocument.setShipDateFrom(FormatData.parseStringToDate(ShipSecurityNotification.class.cast(obj).getETA()));
					
					tempDocument.setGrt(FormatData.convertToDouble(ShipSecurityNotification.class.cast(obj).getGrossTonnage()));
					tempDocument.setUnitGRT(ShipSecurityNotification.class.cast(obj).getGrossTonnageUnit());
					
					tempDocument.setShipAgencyCode(ShipSecurityNotification.class.cast(obj).getTaxCodeOfShipAgent());
					tempDocument.setArrivalShipAgency(ShipSecurityNotification.class.cast(obj).getTaxCodeOfShipAgent());
					tempDocument.setDepartureShipAgency(ShipSecurityNotification.class.cast(obj).getTaxCodeOfShipAgent());
					
					tempDocument.setPortRegionCode(ShipSecurityNotification.class.cast(obj).getPortRegionCode());
					
					DmPortRegion dmPortRegion = DmPortRegionLocalServiceUtil.getByPortRegionCode(ShipSecurityNotification.class.cast(obj).getPortRegionCode());
					if (dmPortRegion != null) {
						tempDocument.setMaritimeCode(dmPortRegion.getPortRegionRef());
					} else {
						DmPortWharf dmPortWharf = DmPortWharfLocalServiceUtil.getByPortWharfCode(ShipSecurityNotification.class.cast(obj).getPortRegionCode());
						if (dmPortWharf != null) {
							DmPortRegion dmPortRegion1 = DmPortRegionLocalServiceUtil.getByPortRegionCode(dmPortWharf.getPortRegionCode());
							if (dmPortRegion1 != null) {
								tempDocument.setMaritimeCode(dmPortRegion1.getPortRegionRef());
							} else {
								tempDocument.setMaritimeCode("19");
							}
						}
					}
					// BinhNT Add 2014-10-10
					try {
						// Gia tri mac dinh neu ben HQMC khong truyen du lieu sang.
						if (tempDocument.getMaritimeCode() == null
								|| (tempDocument.getMaritimeCode() != null && tempDocument.getMaritimeCode().trim().length() == 0)) {
							tempDocument.setMaritimeCode("19");
						}
					} catch (Exception e) {
						e.printStackTrace();
						log.error(e);
					}
				} else if (header.getSubject().getType() == MessageType.THONG_BAO_TAU_DEN_CANG
						|| header.getSubject().getType() == MessageType.THONG_BAO_TAU_ROI_CANG
						|| header.getSubject().getType() == MessageType.XAC_BAO_TAU_DEN_CANG
						|| header.getSubject().getType() == MessageType.THONG_BAO_TAU_QUA_CANH
						|| header.getSubject().getType() == MessageType.XAC_BAO_TAU_QUA_CANH) {
					InlandNoticeOfArrival inlandNoticeOfArrival = InlandNoticeOfArrival.class.cast(obj);
					tempDocument.setShipDateFrom(FormatData.parseStringToDate(inlandNoticeOfArrival.getTimeOfArrival()));
					if (header.getSubject().getDocumentType() == MessageType.XUAT_CANH) {
						tempDocument.setShipDateTo(FormatData.parseStringToDate(inlandNoticeOfArrival.getTimeOfArrival()));
					}
					
//					tempDocument.setGrt(FormatData.convertToDouble(inlandNoticeOfArrival.getGT()));
//					tempDocument.setUnitGRT(inlandNoticeOfArrival.getGTUNIT());
//					tempDocument.setUnitDWT(inlandNoticeOfArrival.getDWTUNIT());
//					tempDocument.setDwt(FormatData.convertToDouble(inlandNoticeOfArrival.getDWT()));
					
					tempDocument.setShipAgencyCode(inlandNoticeOfArrival.getTaxCodeOfShipownersAgents());
					tempDocument.setArrivalShipAgency(inlandNoticeOfArrival.getTaxCodeOfShipownersAgents());
					tempDocument.setDepartureShipAgency(inlandNoticeOfArrival.getTaxCodeOfShipownersAgents());
					
					if (inlandNoticeOfArrival.getPortOfArrivalCode() != null) {
						tempDocument.setPortCode(inlandNoticeOfArrival.getPortOfArrivalCode());
					}
					
					if (inlandNoticeOfArrival.getPortRegionCode() != null) {
						tempDocument.setPortRegionCode(inlandNoticeOfArrival.getPortRegionCode());
					}
					
					if (inlandNoticeOfArrival.getLastPortOfCallCode() != null) {
						tempDocument.setLastPortCode(inlandNoticeOfArrival.getLastPortOfCallCode());
					}
					
					// BinhNT edit with Hong Son, 10-10-2014, 22h33
					DmPortRegion dmPortRegion = DmPortRegionLocalServiceUtil.getByPortRegionCode(inlandNoticeOfArrival.getPortRegionCode());
					if (dmPortRegion != null) {
						tempDocument.setMaritimeCode(dmPortRegion.getPortRegionRef());
					} else {
						DmPort dmPort = DmPortLocalServiceUtil.getByPortCode(inlandNoticeOfArrival.getPortOfArrivalCode());
						if (dmPort != null) {
							tempDocument.setMaritimeCode(dmPort.getLoCode());
						} else {
							DmPortWharf dmPortWharf = DmPortWharfLocalServiceUtil.getByPortWharfCode(inlandNoticeOfArrival
									.getPortRegionCode());
							if (dmPortWharf != null) {
								DmPortRegion dmPortRegion12 = DmPortRegionLocalServiceUtil.getByPortRegionCode(dmPortWharf.getPortRegionCode());
								if (dmPortRegion12 != null) {
									tempDocument.setMaritimeCode(dmPortRegion12.getPortRegionRef());
								}
							} else {
								DmPortHarbour dmPortHarbour = DmPortHarbourLocalServiceUtil.getByPortHarbourCode(inlandNoticeOfArrival
										.getPortHarbourCode());
								if (dmPortHarbour != null) {
									tempDocument.setMaritimeCode(dmPortHarbour.getPortRegionCode());
								} else {
									tempDocument.setMaritimeCode("19");
								}
							}
						}
					}
					
					// BinhNT Add 2014-10-10
					try {
						// Gia tri mac dinh neu ben HQMC khong truyen du lieu
						// sang.
						if (tempDocument.getMaritimeCode() == null
								|| (tempDocument.getMaritimeCode() != null && tempDocument.getMaritimeCode().trim().length() == 0)) {
							tempDocument.setMaritimeCode("19");
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			
			tempDocument.setLastModifiedDate(new Date());
			
			if (liTempDocuments == null || liTempDocuments.size() == 0) {
				
				if (tempDocument.getDocumentTypeCode() == null || tempDocument.getDocumentTypeCode().trim().length() == 0
						|| tempDocument.getDocumentTypeCode().trim().compareTo(String.valueOf(PageType.DOCUMENT_TYPE_NHAP_CANH)) == 0) {
					tempDocument.setDocumentTypeCode(MessageType.LOAT_THU_TUC_NHAP_CANH);
					tempDocument.setShipPosition(PageType.POSITION_SHIP_NHAP_CANH);
				} else if (tempDocument.getDocumentTypeCode().trim().compareTo(String.valueOf(PageType.DOCUMENT_TYPE_XUAT_CANH)) == 0) {
					
					tempDocument.setDocumentTypeCode(MessageType.LOAT_THU_TUC_XUAT_CANH);
					tempDocument.setShipPosition(PageType.POSITION_SHIP_XUAT_CANH);
				} else if (tempDocument.getDocumentTypeCode().trim().compareTo(String.valueOf(PageType.DOCUMENT_TYPE_QUA_CANH)) == 0) {
					
					tempDocument.setDocumentTypeCode(MessageType.LOAT_THU_TUC_QUA_CANH);
					tempDocument.setShipPosition(PageType.POSITION_SHIP_NHAP_CANH);
				}else if (tempDocument.getDocumentTypeCode().trim().compareTo(String.valueOf(PageType.DOCUMENT_TYPE_VAO_CANG)) == 0) {
					
					tempDocument.setDocumentTypeCode(MessageType.LOAT_THU_TUC_VAO_CANG);
					tempDocument.setShipPosition(PageType.POSITION_SHIP_VAO_CANG); 
				}else if (tempDocument.getDocumentTypeCode().trim().compareTo(String.valueOf(PageType.DOCUMENT_TYPE_RA_CANG)) == 0) {
					
					tempDocument.setDocumentTypeCode(MessageType.LOAT_THU_TUC_ROI_CANG);
					tempDocument.setShipPosition(PageType.POSITION_SHIP_RA_CANG);
				}
				tempDocument.setCreatedDate(FormatData.parseStringToDate(header.getSubject().getSendDate()));
				//Chuyen sang thu tuc 
				if (header.getSubject().getDocumentType() == MessageType.TAU_RA) {
					tempDocument.setRequestState(12);
					tempDocument.setDocumentStatusCode(18);
					
				}
				TempDocumentLocalServiceUtil.addTempDocument(tempDocument);
			} else {
				//Chuyen sang thu tuc 
				if (header.getSubject().getDocumentType() == MessageType.TAU_RA) {
					tempDocument.setRequestState(12);
					tempDocument.setDocumentStatusCode(18);
					
				}

				TempDocumentLocalServiceUtil.updateTempDocument(tempDocument);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}
		return false;
	}
//	
//	public static synchronized boolean insert2InlanTempDocument(TempDocument tempDocument, Header header, Object obj) {
//		try {
//			System.out.println("insert2InlanTempDocument header.getSubject().getType()  "+header.getSubject().getType() );
//			List<TempDocument> liTempDocuments = TempDocumentLocalServiceUtil.findTemDocumentByDocumentNameAndDocumentYear(tempDocument.getDocumentName(), tempDocument.getDocumentYear());
//			
//			if (liTempDocuments != null && liTempDocuments.size() > 0) {
//				tempDocument = liTempDocuments.get(0);
//			} else {
//				tempDocument.setRequestState(TrangThaiHoSo.TEMP_DOCUMENT_CHO_TIEP_NHAN);
//			}
//			
//			tempDocument.setPreDocumentName(String.valueOf(header.getSubject().getPreReference()));
//			System.out.println(1);
//			//TODO=TempDocumnt -- Tinh ShipDateFrom
//			if (header.getSubject().getType() == MessageType.FUNCTION_TYPE_MESSAGETYPE_RESPONSE_WHEN_RECEIVE_REQUEST) {
//				if (obj instanceof InlandGeneralDeclaration) {
//					System.out.println(2);
//					tempDocument.setShipDateFrom(FormatData.parseStringToDate(InlandinlandGeneralDeclaration.getDateOfArrival()));
//					
//					if (header.getSubject().getDocumentType() == MessageType.TAU_VAO) {
//						tempDocument.setShipDateTo(FormatData.parseStringToDate(InlandGeneralDeclaration.class.cast(obj).getDateOfArrival()));
//					}
//					System.out.println(21);
////					tempDocument.setGrt(FormatData.convertToDouble(InlandinlandGeneralDeclaration.getGrossTonnage()));
////					tempDocument.setUnitGRT(InlandinlandGeneralDeclaration.getGrossTonnageUnit());
////					tempDocument.setUnitNT(InlandinlandGeneralDeclaration.getNetTonnageUnit());
////					tempDocument.setNt(FormatData.convertToDouble(InlandinlandGeneralDeclaration.getNetTonnage()));
//					
//					tempDocument.setShipAgencyCode(InlandinlandGeneralDeclaration.getTaxCodeOfShipownersAgents());
//					tempDocument.setArrivalShipAgency(InlandinlandGeneralDeclaration.getTaxCodeOfShipownersAgents());
//					tempDocument.setDepartureShipAgency(InlandinlandGeneralDeclaration.getTaxCodeOfShipownersAgents());
//					System.out.println(22);
//					// BinhNT edit with Hong Son, 10-10-2014, 23h
//					DmPortRegion dmPortRegion = DmPortRegionLocalServiceUtil.getByPortRegionCode(InlandinlandGeneralDeclaration.getPortRegionCode());
//					if (dmPortRegion != null) {
//						System.out.println(23);
//						tempDocument.setMaritimeCode(dmPortRegion.getPortRegionRef());
//					} else {
//						System.out.println(24);
//						DmPort dmPort = DmPortLocalServiceUtil.getByPortCode(InlandinlandGeneralDeclaration.getPortOfArrivalCode());
//						if (dmPort != null) {
//							tempDocument.setMaritimeCode(dmPort.getLoCode());
//						} else {
//							DmPortWharf dmPortWharf = DmPortWharfLocalServiceUtil.getByPortWharfCode(InlandinlandGeneralDeclaration.getPortRegionCode());
//							if (dmPortWharf != null) {
//								DmPortRegion dmPortRegion12 = DmPortRegionLocalServiceUtil.getByPortRegionCode(dmPortWharf.getPortRegionCode());
//								if (dmPortRegion12 != null) {
//									tempDocument.setMaritimeCode(dmPortRegion12.getPortRegionRef());
//								}
//							} else {
//								DmPortHarbour dmPortHarbour = DmPortHarbourLocalServiceUtil.getByPortHarbourCode(InlandinlandGeneralDeclaration.getPortHarbourCode());
//								if (dmPortHarbour != null) {
//									tempDocument.setMaritimeCode(dmPortHarbour.getPortRegionCode());
//								} else {
//									tempDocument.setMaritimeCode("19");
//								}
//							}
//						}
//					}
//					System.out.println(24);
//					
//					// BinhNT Add 2014-10-10
////					try {
//						// Gia tri mac dinh neu ben HQMC khong truyen du lieu
//						// sang.
//						if (tempDocument.getMaritimeCode() == null ||
//							(tempDocument.getMaritimeCode() != null && tempDocument.getMaritimeCode().length() == 0)) {
//							tempDocument.setMaritimeCode("19");
//						}
////					} catch (Exception e) {
////						e.printStackTrace();
////					}
//						System.out.println(25);
//				}
//				System.out.println(26);
//			} else {
//				if (header.getSubject().getType() == MessageType.THONG_BAO_TAU_DEN_CANG
//						|| header.getSubject().getType() == MessageType.THONG_BAO_TAU_ROI_CANG
//						|| header.getSubject().getType() == MessageType.XAC_BAO_TAU_DEN_CANG
//						|| header.getSubject().getType() == MessageType.THONG_BAO_TAU_QUA_CANH
//						|| header.getSubject().getType() == MessageType.XAC_BAO_TAU_QUA_CANH) {
//					InlandNoticeOfArrival inlandNoticeOfArrival = InlandNoticeOfArrival.class.cast(obj);
//					tempDocument.setShipDateFrom(FormatData.parseStringToDate(inlandNoticeOfArrival.getTimeOfArrival()));
//					if (header.getSubject().getDocumentType() == MessageType.TAU_RA) {
//						tempDocument.setShipDateTo(FormatData.parseStringToDate(inlandNoticeOfArrival.getTimeOfArrival()));
//					}
//					
////					tempDocument.setGrt(FormatData.convertToDouble(inlandNoticeOfArrival.getGT()));
////					tempDocument.setUnitGRT(inlandNoticeOfArrival.getGTUNIT());
////					tempDocument.setUnitDWT(inlandNoticeOfArrival.getDWTUNIT());
////					tempDocument.setDwt(FormatData.convertToDouble(inlandNoticeOfArrival.getDWT()));
//					
//					tempDocument.setShipAgencyCode(inlandNoticeOfArrival.getTaxCodeOfShipownersAgents());
//					tempDocument.setArrivalShipAgency(inlandNoticeOfArrival.getTaxCodeOfShipownersAgents());
//					tempDocument.setDepartureShipAgency(inlandNoticeOfArrival.getTaxCodeOfShipownersAgents());
//					System.out.println(27);
//					if (inlandNoticeOfArrival.getPortOfArrivalCode() != null) {
//						System.out.println(28);
//						tempDocument.setPortCode(inlandNoticeOfArrival.getPortOfArrivalCode());
//					}
//					
//					if (inlandNoticeOfArrival.getPortRegionCode() != null) {
//						System.out.println(29);
//						tempDocument.setPortRegionCode(inlandNoticeOfArrival.getPortRegionCode());
//					}
//					
//					if (inlandNoticeOfArrival.getLastPortOfCallCode() != null) {
//						System.out.println(30);
//						tempDocument.setLastPortCode(inlandNoticeOfArrival.getLastPortOfCallCode());
//					}
//					
//					// BinhNT edit with Hong Son, 10-10-2014, 22h33
//					DmPortRegion dmPortRegion = DmPortRegionLocalServiceUtil.getByPortRegionCode(inlandNoticeOfArrival.getPortRegionCode());
//					if (dmPortRegion != null) {
//						tempDocument.setMaritimeCode(dmPortRegion.getPortRegionRef());
//					} else {
//						DmPort dmPort = DmPortLocalServiceUtil.getByPortCode(inlandNoticeOfArrival.getPortOfArrivalCode());
//						if (dmPort != null) {
//							tempDocument.setMaritimeCode(dmPort.getLoCode());
//						} else {
//							DmPortWharf dmPortWharf = DmPortWharfLocalServiceUtil.getByPortWharfCode(inlandNoticeOfArrival
//									.getPortRegionCode());
//							if (dmPortWharf != null) {
//								DmPortRegion dmPortRegion12 = DmPortRegionLocalServiceUtil.getByPortRegionCode(dmPortWharf.getPortRegionCode());
//								if (dmPortRegion12 != null) {
//									tempDocument.setMaritimeCode(dmPortRegion12.getPortRegionRef());
//								}
//							} else {
//								DmPortHarbour dmPortHarbour = DmPortHarbourLocalServiceUtil.getByPortHarbourCode(inlandNoticeOfArrival
//										.getPortHarbourCode());
//								if (dmPortHarbour != null) {
//									tempDocument.setMaritimeCode(dmPortHarbour.getPortRegionCode());
//								} else {
//									tempDocument.setMaritimeCode("19");
//								}
//							}
//						}
//					}
//					
//					// BinhNT Add 2014-10-10
//					//try {
//						// Gia tri mac dinh neu ben HQMC khong truyen du lieu
//						// sang.
//						if (tempDocument.getMaritimeCode() == null
//								|| (tempDocument.getMaritimeCode() != null && tempDocument.getMaritimeCode().length() == 0)) {
//							tempDocument.setMaritimeCode("19");
//						}
////					} catch (Exception e) {
////						e.printStackTrace();
////					}
//			
//			}
//				
//			
//			tempDocument.setLastModifiedDate(new Date());
//			System.out.println(3);
//			if (liTempDocuments == null || liTempDocuments.size() == 0) {
//				System.out.println(4);
//				if (tempDocument.getDocumentTypeCode() == null || tempDocument.getDocumentTypeCode().trim().length() == 0
//						|| tempDocument.getDocumentTypeCode().trim().compareTo(String.valueOf(PageType.DOCUMENT_TYPE_VAO_CANG)) == 0) {
//					tempDocument.setDocumentTypeCode(MessageType.LOAT_THU_TUC_VAO_CANG);
//					tempDocument.setShipPosition(PageType.POSITION_SHIP_VAO_CANG);
//					System.out.println(5);
//				} else if (tempDocument.getDocumentTypeCode().trim().compareTo(String.valueOf(PageType.DOCUMENT_TYPE_RA_CANG)) == 0) {
//					System.out.println(6);
//					tempDocument.setDocumentTypeCode(MessageType.LOAT_THU_TUC_ROI_CANG);
//					tempDocument.setShipPosition(PageType.POSITION_SHIP_RA_CANG);
//				}
//				System.out.println(7);
//				tempDocument.setCreatedDate(FormatData.parseStringToDate(header.getSubject().getSendDate()));
//				TempDocumentLocalServiceUtil.addTempDocument(tempDocument);
//			} else {
//				TempDocumentLocalServiceUtil.updateTempDocument(tempDocument);
//			}
//			return true;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			log.error(e);
//		}
//		return false;
//	}

	public String createReturnContentAfterParserDataReceiverFromNSW(
			Header header) {
		Messsage messsage = new Messsage(
				String.valueOf(header.getReference().getVersion()),
				UUID.randomUUID().toString(),
				header.getFrom().getName(),
				String.valueOf(header.getFrom().getIdentity()),
				header.getTo().getName(),
				String.valueOf(header.getTo().getIdentity()),
				String.valueOf(header.getSubject().getDocumentType()),
				FormatData.formatIntToString(header.getSubject().getType()),
				String.valueOf(MessageType.FUNCTION_TYPE_MESSAGETYPE_RESPONSE_WHEN_RECEIVE_REQUEST),
				String.valueOf(header.getSubject().getReference()), String
						.valueOf(header.getSubject().getPreReference()), String
						.valueOf(header.getSubject().getDocumentYear()), header
						.getSubject().getSendDate());

		String xmlResult = MessageFactory.createMessageRequest(messsage);

		xmlResult = xmlResult.replace(MessageFactory.NOI_DUNG_TRA_VE,
				"<ReceiveDate>" + FormatData.parseDateToTring(new Date())
						+ "</ReceiveDate>");
		log.info("==createReturnContentAfterParserDataReceiverFromNSW===Thong tin tra ve HQMC===");
		log.info(xmlResult);
		return xmlResult;
	}
	
	
	//dung.le handsome clone 
	public String createReturnContentAfterParserDataReceiverFromNSWInland(
			Header header) {
		MesssageInland MesssageInland = new MesssageInland(
				String.valueOf(header.getReference().getVersion()),
				UUID.randomUUID().toString(),
				header.getFrom().getName(),
				String.valueOf(header.getFrom().getIdentity()),
				
				String.valueOf(header.getFrom().getCountryCode()),
				String.valueOf(header.getFrom().getMinistryCode()),
				String.valueOf(header.getFrom().getOrganizationCode()),
				String.valueOf(header.getFrom().getUnitCode()),
				
				
				header.getTo().getName(),
				String.valueOf(header.getTo().getIdentity()),
				String.valueOf(header.getTo().getCountryCode()),
				String.valueOf(header.getTo().getMinistryCode()),
				String.valueOf(header.getTo().getOrganizationCode()),
				String.valueOf(header.getTo().getUnitCode()),
				String.valueOf(header.getSubject().getDocumentType()),
				FormatData.formatIntToString(header.getSubject().getType()),
				String.valueOf(MessageType.FUNCTION_TYPE_MESSAGETYPE_RESPONSE_WHEN_RECEIVE_REQUEST),
				String.valueOf(header.getSubject().getReference()), String
						.valueOf(header.getSubject().getPreReference()), String
						.valueOf(header.getSubject().getDocumentYear()), header
						.getSubject().getSendDate());

		String xmlResult = MessageFactory.createMessageRequestInland(MesssageInland);

		xmlResult = xmlResult.replace(MessageFactory.NOI_DUNG_TRA_VE,
				"<ReceiveDate>" + FormatData.parseDateToTring(new Date())
						+ "</ReceiveDate>");
		log.info("==createReturnContentAfterParserDataReceiverFromNSW===Thong tin tra ve HQMC===");
		log.info(xmlResult);
		return xmlResult;
	}

	private String createReturnContentAfterValidationErrorFromNSW(Header header, String lyDo) {
		if (lyDo == null || lyDo.length() == 0) {
			lyDo = "Validation error.";
		}
		Messsage messsage = new Messsage(String.valueOf(header.getReference().getVersion()), UUID.randomUUID().toString(),
				header.getFrom().getName(), String.valueOf(header.getFrom().getIdentity()), header.getTo().getName(), String.valueOf(header.getTo()
						.getIdentity()), String.valueOf(header.getSubject().getDocumentType()), FormatData.formatIntToString(header.getSubject()
						.getType()), String.valueOf(MessageType.FUNCTION_TYPE_MESSAGETYPE_RESPONSE_WHEN_ERROR_VALIDATION), String.valueOf(header
						.getSubject().getReference()), String.valueOf(header.getSubject().getPreReference()), String.valueOf(header.getSubject()
						.getDocumentYear()), header.getSubject().getSendDate());
		
		String xmlResult = MessageFactory.createMessageRequest(messsage);
		
		xmlResult = xmlResult.replace(MessageFactory.NOI_DUNG_TRA_VE,
				CreateMessageFactory.createMessageRejectSystem(header.getReference().getMessageId(), lyDo, "System", "System", new Date()));
		log.info("==createReturnContentAfterValidationErrorFromNSW===Thong tin tra ve HQMC===");
		log.info(xmlResult);
		return xmlResult;
	}

	public String createContentSendFromBGTVTToNSW(Header header, String xmlInnerTagContent) {
		String xmlResult = null;
		try {
/*			Messsage messsage = new Messsage(String.valueOf(header.getReference().getVersion()),
			 * UUID.randomUUID().toString(),
			 * header.getFrom().getName(),
			 * String.valueOf(header.getFrom().getIdentity()),
			 * header.getTo().getName(),
			 * String.valueOf(header.getTo().getIdentity()),
			 * String.valueOf(header.getSubject().getDocumentType()),
				FormatData.formatIntToString(header.getSubject().getType()),
				String.valueOf(header.getSubject().getFunction()),
				String.valueOf(header.getSubject().getReference()),
				String.valueOf(header.getSubject().getPreReference()),
				String.valueOf(header.getSubject().getDocumentYear()),
				header.getSubject().getSendDate());*/
			
			String ref_version = String.valueOf(header.getReference().getVersion());
			String ref_messageId = UUID.randomUUID().toString();
			String frm_name = header.getFrom().getName();
			String frm_identity = String.valueOf(header.getFrom().getIdentity());
			String to_name = header.getTo().getName();
			
			String to_identity = String.valueOf(header.getTo().getIdentity());
			String documentType = String.valueOf(header.getSubject().getDocumentType());
			String type = FormatData.formatIntToString(header.getSubject().getType());
			String function = String.valueOf(header.getSubject().getFunction());
			String reference = String.valueOf(header.getSubject().getReference());
			String preReference = String.valueOf(header.getSubject().getPreReference());
			String documentYear = String.valueOf(header.getSubject().getDocumentYear());
			String sendDate = header.getSubject().getSendDate();
			
			Messsage messsage = new Messsage(ref_version, ref_messageId, frm_name, frm_identity, to_name, to_identity, documentType, type , function , reference , preReference , documentYear , sendDate );
			
			xmlResult = MessageFactory.createMessageRequest(messsage);
			xmlResult = xmlResult.replace(MessageFactory.NOI_DUNG_TRA_VE, xmlInnerTagContent);
			
			log.info("==createContentSendFromBGTVTToNSW===Thong tin BGTVT gui sang HQMC===");
//			log.info(xmlResult);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}
		
		return xmlResult;
	}
	
	
	public String createContentSendFromBGTVTToNSWInland(Header header, String xmlInnerTagContent) {
		String xmlResult = null;
		try {
/*			Messsage messsage = new Messsage(String.valueOf(header.getReference().getVersion()),
			 * UUID.randomUUID().toString(),
			 * header.getFrom().getName(),
			 * String.valueOf(header.getFrom().getIdentity()),
			 * header.getTo().getName(),
			 * String.valueOf(header.getTo().getIdentity()),
			 * String.valueOf(header.getSubject().getDocumentType()),
				FormatData.formatIntToString(header.getSubject().getType()),
				String.valueOf(header.getSubject().getFunction()),
				String.valueOf(header.getSubject().getReference()),
				String.valueOf(header.getSubject().getPreReference()),
				String.valueOf(header.getSubject().getDocumentYear()),
				header.getSubject().getSendDate());*/
			
			String ref_version = String.valueOf(header.getReference().getVersion());
			String ref_messageId = UUID.randomUUID().toString();
			
			
			
			String frm_name = header.getFrom().getName();
			String frm_identity = String.valueOf(header.getFrom().getIdentity());
			String frm_CountryCode = String.valueOf(header.getFrom().getCountryCode());
			String frm_MinistryCode = String.valueOf(header.getFrom().getMinistryCode());
			String frm_OrganizationCode = String.valueOf(header.getFrom().getOrganizationCode());
			String frm_UnitCode = String.valueOf(header.getFrom().getUnitCode());
			
			String to_name = header.getTo().getName();
			String to_identity = String.valueOf(header.getTo().getIdentity());
			String to_CountryCode = String.valueOf(header.getTo().getCountryCode());
			String to_MinistryCode = String.valueOf(header.getTo().getMinistryCode());
			String to_OrganizationCode = String.valueOf(header.getTo().getOrganizationCode());
			String to_UnitCode = String.valueOf(header.getTo().getUnitCode());
			
			
			
			String documentType = String.valueOf(header.getSubject().getDocumentType());
			String type = FormatData.formatIntToString(header.getSubject().getType());
			String function = String.valueOf(header.getSubject().getFunction());
			String reference = String.valueOf(header.getSubject().getReference());
			String preReference = String.valueOf(header.getSubject().getPreReference());
			String documentYear = String.valueOf(header.getSubject().getDocumentYear());
			String sendDate = header.getSubject().getSendDate();
			
			MesssageInland messsageinland = new MesssageInland(ref_version, ref_messageId, frm_name, frm_identity, to_name, to_identity, documentType, type , function , reference , preReference , documentYear , sendDate 
				,frm_CountryCode, frm_MinistryCode, frm_OrganizationCode, frm_UnitCode, to_CountryCode, to_MinistryCode, to_OrganizationCode, to_UnitCode	);
			
			xmlResult = MessageFactory.createMessageRequestInland(messsageinland);
			xmlResult = xmlResult.replace(MessageFactory.NOI_DUNG_TRA_VE, xmlInnerTagContent);
			
			log.info("==createContentSendFromBGTVTToNSW===Thong tin BGTVT gui sang HQMC===");
//			log.info(xmlResult);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}
		
		return xmlResult;
	}
	

	public String replaceXML(String data) {
		try {
			//log.info("dataaaaaaaaaaaaa" + data);
			String dataPrefix = data.substring(0, data.indexOf("?>") + 2).toLowerCase();
			if (dataPrefix.contains("version") && dataPrefix.contains("encoding")) {
				return data.substring(data.indexOf("?>") + 2, data.length());
			}
			return data;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}
		
		return data;
	}

	public static Header crateHeader(TempDocument tempDocument, int documentType, String function, int type, String userName, InterfaceRequest interfaceRequest) {
		try {
			Header header = new Header();
			Subject subject = new Subject();
			subject.setDocumentType(documentType);
			
			if (tempDocument != null) {
				subject.setDocumentYear(tempDocument.getDocumentYear());
				subject.setPreReference(tempDocument.getDocumentName());
				subject.setReference(tempDocument.getDocumentName());
			}
			
			subject.setFunction(function);
			subject.setSendDate(FormatData.parseDateToTring(new Date()));
			subject.setType(type);
			
			From from = new From();
			from.setIdentity("BGTVT");// chua biet lay dau
			from.setName(userName);
			
			To to = new To();
			to.setIdentity("BTC");
			
			Reference ref = new Reference();
			ref.setMessageId("BGTVT" + Long.toString(System.currentTimeMillis()));
			
			if (interfaceRequest != null) {
				to.setName(interfaceRequest.getSenderName());
				ref.setVersion(interfaceRequest.getRequestVersion());
			} else {
				to.setName("System");
				ref.setVersion("1.0");
			}
			
			header.setFrom(from);
			header.setTo(to);
			header.setReference(ref);
			header.setSubject(subject);
			
			return header;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}
		return null;
	}
	
	
	public static Header crateHeaderInland(TempDocument tempDocument, int documentType, String function, int type, String userName, InterfaceRequest interfaceRequest) {
		try {
			Header header = new Header();
			Subject subject = new Subject();
			subject.setDocumentType(documentType);
			
			if (tempDocument != null) {
				subject.setDocumentYear(tempDocument.getDocumentYear());
				subject.setPreReference(tempDocument.getDocumentName());
				subject.setReference(tempDocument.getDocumentName());
			}
			
			subject.setFunction(function);
			subject.setSendDate(FormatData.parseDateToTring(new Date()));
			subject.setType(type);
			
			From from = new From();
			from.setIdentity("BGTVT");// chua biet lay dau
			from.setName(userName);
			from.setCountryCode("VN");
			from.setMinistryCode("BGTVT");
			from.setOrganizationCode("CHH");
			from.setUnitCode("CHH");
			
			
			To to = new To();
			to.setIdentity("BTC");
			to.setCountryCode("VN");
			to.setMinistryCode("BTC");
			to.setOrganizationCode("BTC");
			to.setUnitCode("BTC");
			
			Reference ref = new Reference();
			ref.setMessageId("BGTVT" + Long.toString(System.currentTimeMillis()));
			
			if (interfaceRequest != null) {
				to.setName(interfaceRequest.getSenderName());
				
				ref.setVersion(interfaceRequest.getRequestVersion());
			} else {
				to.setName("System");
				ref.setVersion("1.0");
			}
			
			header.setFrom(from);
			header.setTo(to);
			header.setReference(ref);
			header.setSubject(subject);
			
			return header;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}
		return null;
	}

	public IssueShiftingOrder lenhDieuDong(ActionRequest resourceRequest, long documentName, int documentYear, String username) {
		
		try {
			Random random = new Random();
			
			long id = ParamUtil.getLong(resourceRequest, "idIssueShiftingOrder");
			
			// Lenh dieu dong so??????
			String numberShiftingOrder = String.valueOf(random.nextInt(100000));
			
			// Cang vu hang hai null
			String portofAuthority = ParamUtil.getString(resourceRequest, "maritimeCode");
			log.info("==Cang vu hang hai==maritimeCode=" + portofAuthority);
			
			// Ten taushipName
			String nameOfShip = ParamUtil.getString(resourceRequest, "shipName");
			log.info("==Ten taushipName==nameOfShip=" + nameOfShip);
			
			// Quoc tich tau
			String flagStateOfShip = ParamUtil.getString(resourceRequest, "stateCode");
			log.info("==Quoc tich tau==flagStateOfShip=" + flagStateOfShip);
			
			String anchoringPortCode = ParamUtil.getString(resourceRequest, "arrivalPortCode");// Ma cang neo dau, cang toi
			
			// TODO dinhminh 1000 ban ghi, ko lay dc, du lieu null
			// Cau cang dang neo dau
			String anchoringPortWharfCode = ParamUtil.getString(resourceRequest, "portWharfCode");// di chuyen toi
			log.info("==Cau cang dang neo dau==portWharfCode=" + anchoringPortWharfCode);
			
			// Ma cau cang di chuyen toi
			String shiftingPortWharfCode = anchoringPortWharfCode;
			
			// Thoi gian dieu dong
			Date shiftingDate = ParamUtil.getDate(resourceRequest, "purposeDate", FormatData.formatDateShort3);
			log.info("==Thoi gian dieu dong==purposeDate=" + shiftingDate);
			
			// muc dich neo dau
			String purposeName = ParamUtil.getString(resourceRequest, "purposeName");
			log.info("==muc dich neo dau==purposeName=" + purposeName);
			
			// ly do dieu dong
			String reasonToShift = ParamUtil.getString(resourceRequest, "reasonToShift");
			log.info("==ly do dieu dong==reasonToShift=" + reasonToShift);
			
			if (reasonToShift.length() == 0) {
				reasonToShift = purposeName;
			}
			
			// ngay cap
			Date issueDate = ParamUtil.getDate(resourceRequest, "issueDate", FormatData.formatDateShort3);
			
			// giam doc cang vu hang hai
			String directorOfMaritimeAdministration = "GD";
			long urs = 0;
			 urs = UserLocalServiceUtil.getUserIdByEmailAddress(10154, username);
			 System.out.println("=============userID ==== " + urs);
			if(urs != 0) {
				UserPort defaultCode = UserPortLocalServiceUtil.findByUserId(urs);
				System.out.println("urs!=0");
				if(defaultCode != null) {
					DmMaritime dmMaritime = DmMaritimeLocalServiceUtil.getByMaritimeCode(defaultCode.getPortCode());
					System.out.println("dmMaritime.getCitycode()== " + dmMaritime.getCitycode());
					if(dmMaritime != null) {
						directorOfMaritimeAdministration = dmMaritime.getCitycode();
					}
				}
			}
			
			
			String requestCode = ParamUtil.getString(resourceRequest, "requestCodeShifOrder");
			
			// giay phep so
			String certificateNo = ParamUtil.getString(resourceRequest, "certificateNo");
			String unitCertificateNo = ParamUtil.getString(resourceRequest, "unitCertificateNo");
			
			String representative = ParamUtil.getString(resourceRequest, "representative");
			String versionNo = ParamUtil.getString(resourceRequest, "versionNo");
			String portHarbourCode = ParamUtil.getString(resourceRequest, "portHarbourCode");
			String remarks = ParamUtil.getString(resourceRequest, PageType.LY_DO_TU_CHOI);
			
			log.info("==lenhDieuDong==documentName===" + documentName + "==documentYear==" + documentYear + "===ID==" + id + "==requestCode=="
					+ requestCode);
			log.info("==lenhDieuDong==representative=" + representative);
			
			IssueShiftingOrder shiftOrder = new IssueShiftingOrderImpl();
			
			shiftOrder.setNumberShiftingOrder(numberShiftingOrder);
			shiftOrder.setDocumentName(documentName);
			shiftOrder.setDocumentYear(documentYear);
			shiftOrder.setPortofAuthority(portofAuthority);
			shiftOrder.setNameOfShip(nameOfShip);
			shiftOrder.setFlagStateOfShip(flagStateOfShip);
			shiftOrder.setAnchoringPortCode(anchoringPortCode);
			shiftOrder.setAnchoringPortWharfCode(anchoringPortWharfCode);
			shiftOrder.setPortHarbourCode(portHarbourCode);
			shiftOrder.setShiftingPortWharfCode(shiftingPortWharfCode);
			shiftOrder.setShiftingDate(shiftingDate);
			shiftOrder.setReasonToShift(reasonToShift);
			shiftOrder.setIssueDate(issueDate);
			shiftOrder.setDirectorOfMaritime(directorOfMaritimeAdministration);
			shiftOrder.setCertificateNo(certificateNo.trim() + "/" + unitCertificateNo.trim());
			shiftOrder.setRepresentative(representative);
			shiftOrder.setVersionNo(versionNo);
			shiftOrder.setRepresentative(representative);
			
			String capLenhDieuDong = ParamUtil.getString(resourceRequest, PageType.LAN_CAP_LENH_DIEU_DONG);
			String suaLenhDieuDong = ParamUtil.getString(resourceRequest, PageType.LAN_SUA_LENH_DIEU_DONG);
			
			log.info("==cap_LenhDieuDong====" + capLenhDieuDong + "====sua_LenhDieuDong====" + suaLenhDieuDong);
			
			if (capLenhDieuDong.equalsIgnoreCase(KeyParams.MOT_LAN)) {
				
				shiftOrder.setRequestCode(UUID.randomUUID().toString());
				shiftOrder.setRequestState(TrangThaiBanKhaiNhapCanh.KHAI_MOI);
				shiftOrder = IssueShiftingOrderLocalServiceUtil.addIssueShiftingOrder(shiftOrder);
				log.info("===========MOT_LAN=id=" + id + "INSERT");
				
			} else if (suaLenhDieuDong.equalsIgnoreCase(KeyParams.MOT_LAN)) {
				
				shiftOrder.setId(id);
				shiftOrder.setRequestCode(requestCode);
				shiftOrder.setRequestState(TrangThaiBanKhaiNhapCanh.KHAI_SUA);
				shiftOrder = IssueShiftingOrderLocalServiceUtil.updateIssueShiftingOrder(shiftOrder);
				log.info("===========MOT_LAN=id=" + id + "=UPDATE");
				
			} else if (capLenhDieuDong.equalsIgnoreCase(KeyParams.N_LAN)) {
				
				// TODO Nhap Canh truong hop cap lai
				shiftOrder.setRequestCode(UUID.randomUUID().toString());
				shiftOrder.setRequestState(TrangThaiBanKhaiNhapCanh.SUA_DOI_BO_XUNG);
				shiftOrder.setRemarks(remarks);
				
				shiftOrder = IssueShiftingOrderLocalServiceUtil.addIssueShiftingOrder(shiftOrder);
				log.info("===========N_LAN==" + "INSERT");
				
			} else if (suaLenhDieuDong.equalsIgnoreCase(KeyParams.N_LAN)) {
				
				shiftOrder.setId(id);
				shiftOrder.setRequestCode(requestCode);
				shiftOrder.setRequestState(TrangThaiBanKhaiNhapCanh.SUA_DOI_BO_XUNG);
				shiftOrder = IssueShiftingOrderLocalServiceUtil.updateIssueShiftingOrder(shiftOrder);
				log.info("===========N_LAN=id=" + id + "=UPDATE");
			}
			return shiftOrder;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}
		return null;
	}

	/**
	 * Lay cang cua user dang nhap
	 * 
	 * @param userName
	 * @return
	 */
	public static String getOrganizationFromUser(ActionRequest resourceRequest) {
		String result = null;
		try {
			
		//	System.out.println("======getOrganizationFromUser resourceRequest ===" + resourceRequest);
			
			User user = PortalUtil.getUser(resourceRequest);
			UserPort userPort = UserPortLocalServiceUtil.findByUserId(user.getUserId());
			
		//	System.out.println("======getOrganizationFromUser user.getUserId() ===" + user.getUserId());
			if (userPort != null) {
				result = userPort.getPortCode();
				DmGtOrganization dmGtOrganization = DmGtOrganizationLocalServiceUtil.findByOrganizationCode(result);
				if (dmGtOrganization != null) {
					result = dmGtOrganization.getOrganizationName();
				} else {
					DmMaritime maritime = DmMaritimeLocalServiceUtil.getByMaritimeCode(userPort.getPortCode());
					if (Validator.isNotNull(maritime)) {
						result = maritime.getMaritimeNameVN();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}
		return result;
	}

	public String getDivision(ActionRequest resourceRequest) {
		String result = "Ke Hoach";
		try {
			
			String organizationId = (String) resourceRequest.getPortletSession().getAttribute(PageType.ORGANIZATION_TYPE, resourceRequest.getPortletSession().APPLICATION_SCOPE);
			if (organizationId != null && organizationId.length() > 0) {
				Organization organization = OrganizationLocalServiceUtil.fetchOrganization(Long.valueOf(organizationId));
				if (organization != null) {
					result = organization.getName();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}
		return result;
	}

	//TODO minhhandsome issue = 109
	public static boolean updateResultDeclaration(int messageType, long documentName, int documentYear, int status) {
		boolean result = true;
		try {
			
		//	System.out.println("=============VAO updateResultDeclaration===============");
			List<ResultDeclaration> resultDeclarations = ResultDeclarationLocalServiceUtil.findByDocumentNameAndBusinessTypeCodeAndDocumentYear(
					messageType, documentName, documentYear);
			if (resultDeclarations != null && resultDeclarations.size() > 0) {
				
				ResultDeclaration resultDeclaration = resultDeclarations.get(0);
				if(resultDeclaration.getRequestState() == 9) {
					
				//	System.out.println("=============VAO updateResultDeclaration===============9");
					
					
				} else {
					resultDeclaration.setRequestState(status);
					ResultDeclarationLocalServiceUtil.updateResultDeclaration(resultDeclaration);
				}
				
			}
		} catch (Exception e) {
			result = false;
			e.printStackTrace();
			log.error(e);
		}
		return result;
	}

	public String sendMessageHoSo(Header header, Date acceptDate) {
		
		String xmlResult = "";
		// Tao ban tin tra ve bao da nhan thong tin.
		try {
			xmlResult = "<ReceiveDate>" + FormatData.parseDateToTring(new Date()) + "</ReceiveDate>";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return createContentSendFromBGTVTToNSW(header, xmlResult);
	}

	public static String getRemarkPheDuyet(String userName) {
		String result = userName;
		result = "[" + userName + "] - " + ConfigurationManager.getStrProp("pheDuyet", " - Phe Duyet - ") + 
				"[" + FormatData.parseDateToTringType3(new Date()) + "]";
		return result;
	}

	public static String getRemarkPheDuyetTB(String userName, Date approvalTime) {
		String result = userName;
		result = "[" + userName + "] - " + ConfigurationManager.getStrProp("pheDuyet", " - Phe Duyet - ") +
				"[" + FormatData.parseDateToTringType3(approvalTime) + "]";
		return result;
	}

	public static String getRemarkChapNhan(String userName) {
		String result = userName;
		result = "[" + userName + "] - " + ConfigurationManager.getStrProp("chapNhan", " - Chap Nhan - ") +
				"[" + FormatData.parseDateToTringType3(new Date()) + "]";
		return result;
	}

	public static String getRemarkTuChoi(String userName, String lyDoTuChoi) {
		if (lyDoTuChoi == null || lyDoTuChoi.length() == 0) {
			lyDoTuChoi = "Tu Choi";
		}
		String result = userName;
		result = "[" + userName + "] - " + ConfigurationManager.getStrProp("tuchoi", " - Tu Choi - ") +
				"[" + FormatData.parseDateToTringType3(new Date()) + "] " + ConfigurationManager.getStrProp("lydo", " - Ly  Do - ") +
				"[" + lyDoTuChoi + "]";
		return result;
	}
	
	public static String getRemarkBoSung(String userName, String lyDoBoSung) {
		if (lyDoBoSung == null || lyDoBoSung.length() == 0) {
			lyDoBoSung = "Bo sung";
		}
		String result = userName;
		result = "[" + userName + "] - "
				+ ConfigurationManager.getStrProp("lydobosung", " - Bo sung - ")
				+ "[" + FormatData.parseDateToTringType3(new Date()) + "] "
				+ ConfigurationManager.getStrProp("lydo", " - Ly  Do - ") + "["
				+ lyDoBoSung + "]";
		return result;
	}
	
	public static String getRemarkHuy(String userName, String lyDoHuy) {
		if (lyDoHuy == null || lyDoHuy.length() == 0) {
			lyDoHuy = "Huy";
		}
		String result = userName;
		result = "[" + userName + "] - "
				+ ConfigurationManager.getStrProp("lydohuy", " - Huy - ")
				+ "[" + FormatData.parseDateToTringType3(new Date()) + "] "
				+ ConfigurationManager.getStrProp("lydo", " - Ly  Do - ") + "["
				+ lyDoHuy + "]";
		return result;
	}

	public static String getRemarkTuChoiTB(String userName, String lyDoTuChoi,
			Date approvalTime) {
		String result = userName;
		result = "[" + userName + "] - "
				+ ConfigurationManager.getStrProp("tuchoi", " - Tu Choi - ")
				+ "[" + FormatData.parseDateToTringType3(approvalTime) + "] "
				+ ConfigurationManager.getStrProp("lydo", " - Ly  Do - ") + "["
				+ lyDoTuChoi + "]";
		return result;
	}
	
	public static String getRemarkCapLai(String userName, String lydoCapLai, Date ngayCapLai) {
		String result = userName;
		result = "[" + userName + "] - "
				+ ConfigurationManager.getStrProp("caplai", " - Cap lai - ")
				+ "[" + FormatData.parseDateToTringType3(ngayCapLai) + "] "
				+ ConfigurationManager.getStrProp("lydo", " - Ly  Do - ") + "["
				+ lydoCapLai + "]";
		return result;
	}

	public static void insertOrUpdateResultMinistry(int documentName, int documentYear, String function, String remarks) {
		try {
			ResultMinistry resultMinistry = null;
			if (resultMinistry == null) {
				resultMinistry = new ResultMinistryImpl();
				setValue2ResultMinistry(resultMinistry, documentName, documentYear, function, remarks);
				ResultMinistryLocalServiceUtil.addResultMinistry(resultMinistry);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}
	}
	
	public static void insertResultHistoryMinistry(int documentName, int documentYear, String function, String remarks) {
		try {
			log.info("==insertResultHistoryMinistry==");
			ResultHistoryMinistry resultMinistry = new ResultHistoryMinistryImpl();
			
			resultMinistry.setBusinessTypeCode(MessageType.HO_SO);
			resultMinistry.setDocumentName(documentName);
			resultMinistry.setDocumentYear(documentYear);
			resultMinistry.setLatestDate(new Date());
			resultMinistry.setRequestCode(Long.toString(System.currentTimeMillis()));
			resultMinistry.setResponse(function);
			resultMinistry.setRequestState(TrangThaiBanKhai.TRANG_THAI_BANG_KHAI_MOI);
			resultMinistry.setMinistryCode(ConstantCoQuanBanNganh.BGTVT);
			resultMinistry.setRemarks(remarks);
			
			ResultHistoryMinistryLocalServiceUtil.addResultHistoryMinistry(resultMinistry);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}
	}
	
	private static void setValue2ResultMinistry(ResultMinistry resultMinistry, int documentName, int documentYear, String function, String remarks) {
		resultMinistry.setBusinessTypeCode(MessageType.HO_SO);
		resultMinistry.setDocumentName(documentName);
		resultMinistry.setDocumentYear(documentYear);
		resultMinistry.setLatestDate(new Date());
		resultMinistry.setRequestCode(Long.toString(System.currentTimeMillis()));
		resultMinistry.setResponse(function);
		resultMinistry.setRequestState(TrangThaiBanKhai.TRANG_THAI_BANG_KHAI_MOI);
		resultMinistry.setMinistryCode(ConstantCoQuanBanNganh.BGTVT);
		resultMinistry.setRemarks(remarks);
	}
	
	
	
	public static boolean updateLyDoResultNotification(String userlogin, String lydo, int businessTypeCode, String maritimeCode, long documentName,
			int documentYear) {
		log.info("===updateLyDoResultNotification===");
		boolean result = true;
		try {
			ResultNotification notification = null;
			notification = ResultNotificationLocalServiceUtil.findByBusinessTypeCode(businessTypeCode, documentName, documentYear);
			if (notification == null) {
				log.info("========vao insert====ResultNotification=====");
				
				notification = new ResultNotificationImpl();
				
				notification.setRequestCode(UUID.randomUUID().toString());
				notification.setDocumentYear(documentYear);
				notification.setDocumentName(documentName);
				notification.setMaritimeCode(maritimeCode);
				notification.setRequestState(1);
				notification.setResponse(lydo);
				notification.setResponseTime(new Date());
				notification.setRole(4);
				notification.setOfficerName(userlogin);
				notification.setLatestDate(String.valueOf(FormatData.parseDateToTring(new Date())));
				notification.setBusinessTypeCode(businessTypeCode);
				notification.setIsReply(1);
				
				ResultNotificationLocalServiceUtil.addResultNotification(notification);
			} else {
				log.info("========vao update====ResultNotification=====");
				
				notification.setMaritimeCode(maritimeCode);
				notification.setRequestState(1);
				notification.setResponse(lydo);
				notification.setResponseTime(new Date());
				notification.setRole(4);
				notification.setOfficerName(userlogin);
				notification.setBusinessTypeCode(businessTypeCode);
				notification.setIsReply(1);
				ResultNotificationLocalServiceUtil.updateResultNotification(notification);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
			result = false;
		}
		return result;
	}

	/**Ham su dung de insert vao InterfaceRequest cho 3 ban khai, lenhdieudong, giaypheproicang, giayphepquacanh*/
	public boolean insertHistorySendMessageThreeIssue(String xmlData, String userName, String requestCodeIssue) {
		boolean result = false;
		try {
			Header header = null;
			String data = replaceXML(xmlData.trim());
			
			// Tao ban tin tra ve bao da nhan thong tin.
			header = ReadMessages.readXMLMessagesHeader(data);
			
			// Insert history.
			String resultMethod = insertHistoryThreeIssue(header, xmlData, BoGiaoThongToHqmc, TrangThaiHoSo.DA_GHI_NHO_YEU_CAU, requestCodeIssue, userName);
			if (resultMethod == null) {
				result = true;
			} else {
				result = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
			log.error(e);
		}
		return result;
	}
	
	public static Header readXmlMessageHeader(String xmlString)
			throws Exception {
			
			XPath xPath = XPathFactory.newInstance().newXPath();
			String expression = "Envelope/Header";//"//Body/Content";//
			
			DOMSource source = null;
			ByteArrayInputStream stream = new ByteArrayInputStream(xmlString.getBytes("UTF-8"));
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(stream);
			
			Node node = (Node) xPath.compile(expression).evaluate(doc, XPathConstants.NODE);
			source = new DOMSource(node);
			
			TransformerFactory tFactory = TransformerFactory.newInstance();
			Transformer transformer = tFactory.newTransformer();
			transformer.setOutputProperty("indent", "yes");
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			
			StringWriter sw = new StringWriter();
			StreamResult result = new StreamResult(sw);
			
			transformer.transform(source, result);
			//System.out.println(sw.toString());
			
			StringReader reader = new StringReader(sw.toString());
			
			// create a JAXBContext capable of handling classes generated into
			// Document doc1 =XmlUtils.parseXmlFile("C://header.xml", false);
			
			JAXBContext jc = JAXBContext.newInstance(ObjectFactory.class);
			
			// create an Unmarshaller
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			String xmlHeader = sw.toString();
			//xmlString=xmlString.replaceAll("\\<\\?xml(.+?)\\?\\>", "").trim();
			
			ByteArrayInputStream input = new ByteArrayInputStream(xmlHeader.getBytes("UTF-8"));
			
			// unmarshal a po instance document into a tree of Java content
			// objects composed of classes from the primer.po package.
			
			Header header = (Header) unmarshaller.unmarshal(input);
			return header;
			
		}
	
}
