package vn.gt.tichhop.message.haiquan2giaothong;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;






import vn.gt.dao.noticeandmessage.model.IssuePermissionForTransit;
import vn.gt.dao.noticeandmessage.service.IssuePermissionForTransitLocalServiceUtil;







import org.tempuri.IMTService;

import vn.gt.dao.common.model.UserPort;
import vn.gt.dao.common.service.UserPortLocalServiceUtil;
import vn.gt.dao.danhmuc.model.DmMaritime;
import vn.gt.dao.danhmuc.service.DmMaritimeLocalServiceUtil;
import vn.gt.dao.noticeandmessage.model.InterfaceRequest;
import vn.gt.dao.noticeandmessage.model.IssuePortClearance;
import vn.gt.dao.noticeandmessage.model.Modify;
import vn.gt.dao.noticeandmessage.model.TempAnimalQuarantine;
import vn.gt.dao.noticeandmessage.model.TempCargoDeclaration;
import vn.gt.dao.noticeandmessage.model.TempCrewEffectsDeclaration;
import vn.gt.dao.noticeandmessage.model.TempCrewList;
import vn.gt.dao.noticeandmessage.model.TempDangerousGoodsNanifest;
import vn.gt.dao.noticeandmessage.model.TempDeclarationOfHealth;
import vn.gt.dao.noticeandmessage.model.TempDocument;
import vn.gt.dao.noticeandmessage.model.TempGeneralDeclaration;
import vn.gt.dao.noticeandmessage.model.TempNoTiceShipMessage;
import vn.gt.dao.noticeandmessage.model.TempPassengerList;
import vn.gt.dao.noticeandmessage.model.TempPlantQuarantine;
import vn.gt.dao.noticeandmessage.model.TempShipSecurityMessage;
import vn.gt.dao.noticeandmessage.model.TempShipStoresDeclaration;
import vn.gt.dao.noticeandmessage.model.impl.IssuePortClearanceImpl;
import vn.gt.dao.noticeandmessage.model.impl.ModifyImpl;
import vn.gt.dao.noticeandmessage.service.InterfaceRequestLocalServiceUtil;
import vn.gt.dao.noticeandmessage.service.IssuePortClearanceLocalServiceUtil;
import vn.gt.dao.noticeandmessage.service.ModifyLocalServiceUtil;
import vn.gt.dao.noticeandmessage.service.TempAnimalQuarantineLocalServiceUtil;
import vn.gt.dao.noticeandmessage.service.TempCargoDeclarationLocalServiceUtil;
import vn.gt.dao.noticeandmessage.service.TempCrewEffectsDeclarationLocalServiceUtil;
import vn.gt.dao.noticeandmessage.service.TempCrewListLocalServiceUtil;
import vn.gt.dao.noticeandmessage.service.TempDangerousGoodsNanifestLocalServiceUtil;
import vn.gt.dao.noticeandmessage.service.TempDeclarationOfHealthLocalServiceUtil;
import vn.gt.dao.noticeandmessage.service.TempDocumentLocalServiceUtil;
import vn.gt.dao.noticeandmessage.service.TempGeneralDeclarationLocalServiceUtil;
import vn.gt.dao.noticeandmessage.service.TempNoTiceShipMessageLocalServiceUtil;
import vn.gt.dao.noticeandmessage.service.TempPassengerListLocalServiceUtil;
import vn.gt.dao.noticeandmessage.service.TempPlantQuarantineLocalServiceUtil;
import vn.gt.dao.noticeandmessage.service.TempShipSecurityMessageLocalServiceUtil;
import vn.gt.dao.noticeandmessage.service.TempShipStoresDeclarationLocalServiceUtil;
import vn.gt.dao.result.model.ResultCompetion;
import vn.gt.dao.result.model.ResultDeclaration;
import vn.gt.dao.result.model.ResultNotification;
import vn.gt.dao.result.model.impl.ResultCompetionImpl;
import vn.gt.dao.result.model.impl.ResultDeclarationImpl;
import vn.gt.dao.result.model.impl.ResultNotificationImpl;
import vn.gt.dao.result.service.ResultCompetionLocalServiceUtil;
import vn.gt.dao.result.service.ResultDeclarationLocalServiceUtil;
import vn.gt.dao.result.service.ResultNotificationLocalServiceUtil;
import vn.gt.tichhop.message.BusinessUtils;
import vn.gt.tichhop.message.MessageFactory;
import vn.gt.tichhop.message.MessageType;
import vn.gt.tichhop.message.TrangThaiBanKhai;
import vn.gt.tichhop.message.TrangThaiBanKhaiNhapCanh;
import vn.gt.tichhop.message.TrangThaiBanKhaiQuaCanh;
import vn.gt.tichhop.message.TrangThaiBanKhaiXuatCanh;
import vn.gt.tichhop.message.giaothong2haiquan.PortClearance2Xml;
import vn.gt.utils.CallWs2HaiQuan;
import vn.gt.utils.CheckBusinessUtil;
import vn.gt.utils.FormatData;
import vn.gt.utils.KeyParams;
import vn.gt.utils.PageType;
import vn.nsw.Header;
import vn.nsw.model.PortClearance;
import vn.nsw.model.inland.InlandPortClearance;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

public class XuatCanhHaiQuan2GiaoThongBusiness {
	
	private Log log = LogFactoryUtil.getLog(XuatCanhHaiQuan2GiaoThongBusiness.class);
	
	
	
	public boolean xuLyXuatCanhRoleKeHoach(long documentName, int messageType, int documentYear, int actionType, String userName, String requestCode,
			ActionRequest request, ActionResponse httpReq) {
		boolean result = false;
		
		log.info("====call xuLyXuatCanhRoleKeHoach=====documentName==" + documentName);
		log.info("====call xuLyXuatCanhRoleKeHoach=====messageType==" + messageType);
		log.info("====call xuLyXuatCanhRoleKeHoach=====documentYear==" + documentYear);
		log.info("====call xuLyXuatCanhRoleKeHoach=====actionType==" + actionType);
		log.info("====call xuLyXuatCanhRoleKeHoach=====requestCode==" + requestCode);
		
		// Kiem tra xem ban khai nao truyen len
		switch (messageType) {
			case MessageType.THONG_BAO_TAU_ROI_CANG:
				
				log.info("VAO THONG_BAO_TAU_ROI_CANG=================");
				result = banKhaiThongBaoTauRoiCang(documentName, messageType, documentYear, actionType, userName, requestCode, request);
				break;
			case PageType.THANH_PHAN_HO_SO:
				log.info("VAO PageType.THANH_PHAN_HO_SO=!!!!");
				result = toanBoHoSoKeHoach(documentName, messageType, documentYear, actionType, userName, requestCode, request, httpReq);
				break;
		}
		
		return result;
	}
	//sent message 29, 65-1, 65-0 (dung.handsome)
	public void sentMessageKiemDuyetHoSoDinhKem(String userLogin ,int pageType, long documentName, int documentYear, String requestCode, int messageType, ActionRequest request, ActionResponse httpReq, int btnActionType, String lyDoTuChoi) throws Exception {
	//	log.info("dung.le MEssagety ======= " + messageType);
		TempDocument tempDocument = TempDocumentLocalServiceUtil.getByDocumentNameAndDocumentYear(documentName, documentYear);
		if(tempDocument != null) {
		//	log.info("dung.le MEssagety ======= IF" + messageType);
			if(pageType == 4) {
				//gui message 29
				if(btnActionType == 1) {
					//log.info("sentMessageKiemDuyetHoSoDinhKem btnActionType:= " + btnActionType);
					thuTucSentMessageYeuCauBoSungHoSoDinhKem(userLogin, tempDocument, messageType, requestCode, request);
				} else if(btnActionType == 2) {
					//log.info("sentMessageKiemDuyetHoSoDinhKem btnActionType:= " + btnActionType);
					thuTucSentMessageChapNhanHoSoDinhKem(userLogin, tempDocument, messageType, requestCode, request);
				} else if(btnActionType == 0) {
					thuTucSentMessageTuChoiHoSoDinhKem(userLogin, tempDocument, messageType, requestCode, request, lyDoTuChoi);
				}									 
			}
			
		}
		
	}
	
private void thuTucSentMessageTuChoiHoSoDinhKem(String userLogin, TempDocument tempDocument, int messageType, String requestCode, ActionRequest request, String lydotuchoi) throws RemoteException {
		
		log.info("==VAO thuTucSentMessageYeuCauBoSungHoSoDinhKem====");
		BusinessUtils businessUtils = new BusinessUtils();
		String xmlData = "";
		IMTService imtService = CallWs2HaiQuan.getIMTSercice();
		
		Header header = null;
		String function= MessageType.FUNCTION_THONG_BAO_CHAP_NHAN_HO_SO_CHUNG_TU_KINH_KEM;
		
		if (messageType == Integer.valueOf(MessageType.FUNCTION_CAC_GIAY_TO_PHAI_XUAT_TRINH)) {
			log.info("==VAO thuTucSentMessageYeuCauBoSungHoSoDinhKem====MessageType.FUNCTION_CAC_GIAY_TO_PHAI_XUAT_TRINH " + MessageType.FUNCTION_CAC_GIAY_TO_PHAI_XUAT_TRINH);
			
			requestCode = tempDocument.getRequestCode();
		}
		
		if(requestCode!=null) {
			log.info("==VAO thuTucSentMessageYeuCauBoSungHoSoDinhKem====  requestCode!=null");
			InterfaceRequest interfaceRequest = InterfaceRequestLocalServiceUtil.findByRequestCode(requestCode);
			if(tempDocument.getDocumentTypeCode().equals(MessageType.LOAT_THU_TUC_ROI_CANG)) {
			//	log.info("==VAO thuTucSentMessageYeuCauBoSungHoSoDinhKem====  requestCode!=null and getDocumentTypeCode()" + tempDocument.getDocumentTypeCode());
				header = BusinessUtils.crateHeaderInland(tempDocument, MessageType.TAU_RA, function, 65 , userLogin, interfaceRequest);
				xmlData = tuChoiSoDinhKem(messageType, function, xmlData, businessUtils, header, tempDocument, request, lydotuchoi);
			
			} else if(tempDocument.getDocumentTypeCode().equals(MessageType.LOAT_THU_TUC_VAO_CANG)) {
				//log.info("==VAO thuTucSentMessageYeuCauBoSungHoSoDinhKem====  requestCode!=null and getDocumentTypeCode()" + tempDocument.getDocumentTypeCode());
				header = BusinessUtils.crateHeaderInland(tempDocument, MessageType.TAU_VAO, function, 65 , userLogin, interfaceRequest);
				xmlData = tuChoiSoDinhKem(messageType, function, xmlData, businessUtils, header, tempDocument, request, lydotuchoi);
			} else if(tempDocument.getDocumentTypeCode().equals(MessageType.LOAT_THU_TUC_XUAT_CANH)) {
				//log.info("==VAO thuTucSentMessageYeuCauBoSungHoSoDinhKem====  requestCode!=null and getDocumentTypeCode()" + tempDocument.getDocumentTypeCode());
				header = BusinessUtils.crateHeader(tempDocument, MessageType.XUAT_CANH, function, 65 , userLogin, interfaceRequest);
				xmlData = tuChoiSoDinhKem(messageType, function, xmlData, businessUtils, header, tempDocument, request, lydotuchoi);
			} else if(tempDocument.getDocumentTypeCode().equals(MessageType.LOAT_THU_TUC_NHAP_CANH)) {
				//log.info("==VAO thuTucSentMessageYeuCauBoSungHoSoDinhKem====  requestCode!=null and getDocumentTypeCode()" + tempDocument.getDocumentTypeCode());
				header = BusinessUtils.crateHeader(tempDocument, MessageType.NHAP_CANH, function, 65 , userLogin, interfaceRequest);
				xmlData = tuChoiSoDinhKem(messageType, function, xmlData, businessUtils, header, tempDocument, request, lydotuchoi);
			} else if(tempDocument.getDocumentTypeCode().equals(MessageType.LOAT_THU_TUC_QUA_CANH)) {
				//log.info("==VAO thuTucSentMessageYeuCauBoSungHoSoDinhKem====  requestCode!=null and getDocumentTypeCode()" + tempDocument.getDocumentTypeCode());
				header = BusinessUtils.crateHeader(tempDocument, MessageType.QUA_CANH, function, 65 , userLogin, interfaceRequest);
				xmlData = tuChoiSoDinhKem(messageType, function, xmlData, businessUtils, header, tempDocument, request, lydotuchoi);
			}
			
			if (xmlData != null && xmlData.length() > 0) {
				
				//Chua ro nghiepvu insert nhu the nao (dung.le)
				boolean insertHistorySendMessage = businessUtils.insertHistorySendMessage(xmlData);
				log.info("==thuTucNhapCanhTraMessageHaiQuan==insertHistorySendMessage==" + insertHistorySendMessage);
				
				//String xml = imtService.receiveResultFromMT(xmlData);
				String  xml = "";
				if(tempDocument.getDocumentTypeCode().equals((MessageType.LOAT_THU_TUC_VAO_CANG)) || tempDocument.getDocumentTypeCode().equals(MessageType.LOAT_THU_TUC_ROI_CANG)){
					log.info(" ----CAll receiveFromInland------- ");
					//resevice mess from our message!
			//		xml = imtService.receiveFromInland(xmlData);
					
				}else{
					log.info(" ----CAll receiveResultFromMT------- ");
			//		xml = imtService.receiveResultFromMT(xmlData);
				}
				
				//log.info("===du lieu gui hai quan== " + xmlData );
				//log.info("=======Du lieu NHAN  HQMC day ========" + xml);
				boolean insertHistoryReceiveMessageResponse = businessUtils.insertHistoryReceiveMessageResponse(xml);
				log.info("==thuTucNhapCanhTraMessageHaiQuan==insertHistoryReceiveMessageResponse==" + insertHistoryReceiveMessageResponse);
			}
		}
	}
	
	
	
private void thuTucSentMessageChapNhanHoSoDinhKem(String userLogin, TempDocument tempDocument, int messageType, String requestCode, ActionRequest request) throws RemoteException {
		
		log.info("==VAO thuTucSentMessageYeuCauBoSungHoSoDinhKem====");
		BusinessUtils businessUtils = new BusinessUtils();
		String xmlData = "";
		IMTService imtService = CallWs2HaiQuan.getIMTSercice();
		
		Header header = null;
		String function= MessageType.FUNCTION_THONG_BAO_CHAP_NHAN_HO_SO_CHUNG_TU_KINH_KEM;
		
		if (messageType == Integer.valueOf(MessageType.FUNCTION_CAC_GIAY_TO_PHAI_XUAT_TRINH)) {
			log.info("==VAO thuTucSentMessageYeuCauBoSungHoSoDinhKem====MessageType.FUNCTION_CAC_GIAY_TO_PHAI_XUAT_TRINH " + MessageType.FUNCTION_CAC_GIAY_TO_PHAI_XUAT_TRINH);
			
			requestCode = tempDocument.getRequestCode();
		}
		
		if(requestCode!=null) {
			//log.info("==VAO thuTucSentMessageYeuCauBoSungHoSoDinhKem====  requestCode!=null");
			InterfaceRequest interfaceRequest = InterfaceRequestLocalServiceUtil.findByRequestCode(requestCode);
			if(tempDocument.getDocumentTypeCode().equals(MessageType.LOAT_THU_TUC_ROI_CANG)) {
			//	log.info("==VAO thuTucSentMessageYeuCauBoSungHoSoDinhKem====  requestCode!=null and getDocumentTypeCode()" + tempDocument.getDocumentTypeCode());
				header = BusinessUtils.crateHeaderInland(tempDocument, MessageType.TAU_RA, function, 65 , userLogin, interfaceRequest);
				xmlData = chapNhanHoSoDinhKem(messageType, function, xmlData, businessUtils, header, tempDocument, request);
			
			} else if(tempDocument.getDocumentTypeCode().equals(MessageType.LOAT_THU_TUC_VAO_CANG)) {
			//	log.info("==VAO thuTucSentMessageYeuCauBoSungHoSoDinhKem====  requestCode!=null and getDocumentTypeCode()" + tempDocument.getDocumentTypeCode());
				header = BusinessUtils.crateHeaderInland(tempDocument, MessageType.TAU_VAO, function, 65 , userLogin, interfaceRequest);
				xmlData = chapNhanHoSoDinhKem(messageType, function, xmlData, businessUtils, header, tempDocument, request);
			} else if(tempDocument.getDocumentTypeCode().equals(MessageType.LOAT_THU_TUC_XUAT_CANH)) {
			//	log.info("==VAO thuTucSentMessageYeuCauBoSungHoSoDinhKem====  requestCode!=null and getDocumentTypeCode()" + tempDocument.getDocumentTypeCode());
				header = BusinessUtils.crateHeader(tempDocument, MessageType.XUAT_CANH, function, 65 , userLogin, interfaceRequest);
				xmlData = chapNhanHoSoDinhKem(messageType, function, xmlData, businessUtils, header, tempDocument, request);
			} else if(tempDocument.getDocumentTypeCode().equals(MessageType.LOAT_THU_TUC_NHAP_CANH)) {
			//	log.info("==VAO thuTucSentMessageYeuCauBoSungHoSoDinhKem====  requestCode!=null and getDocumentTypeCode()" + tempDocument.getDocumentTypeCode());
				header = BusinessUtils.crateHeader(tempDocument, MessageType.NHAP_CANH, function, 65 , userLogin, interfaceRequest);
				xmlData = chapNhanHoSoDinhKem(messageType, function, xmlData, businessUtils, header, tempDocument, request);
			} else if(tempDocument.getDocumentTypeCode().equals(MessageType.LOAT_THU_TUC_QUA_CANH)) {
			//	log.info("==VAO thuTucSentMessageYeuCauBoSungHoSoDinhKem====  requestCode!=null and getDocumentTypeCode()" + tempDocument.getDocumentTypeCode());
				header = BusinessUtils.crateHeader(tempDocument, MessageType.QUA_CANH, function, 65 , userLogin, interfaceRequest);
				xmlData = chapNhanHoSoDinhKem(messageType, function, xmlData, businessUtils, header, tempDocument, request);
			}
			
			if (xmlData != null && xmlData.length() > 0) {
				
				//Chua ro nghiepvu insert nhu the nao (dung.le)
				boolean insertHistorySendMessage = businessUtils.insertHistorySendMessage(xmlData);
				log.info("==thuTucNhapCanhTraMessageHaiQuan==insertHistorySendMessage==" + insertHistorySendMessage);
				
				//String xml = imtService.receiveResultFromMT(xmlData);
				String  xml = "";
				if(tempDocument.getDocumentTypeCode().equals((MessageType.LOAT_THU_TUC_VAO_CANG)) || tempDocument.getDocumentTypeCode().equals(MessageType.LOAT_THU_TUC_ROI_CANG)){
				//	log.info(" ----CAll receiveFromInland------- ");
					//resevice mess from our message!
				//	xml = imtService.receiveFromInland(xmlData);
					
				}else{
				//	log.info(" ----CAll receiveResultFromMT------- ");
				//	xml = imtService.receiveResultFromMT(xmlData);
				}
			//	log.info("===du lieu gui hai quan== " + xmlData );
				
			//	log.info("=======Du lieu NHAN  HQMC day ========" + xml);
				boolean insertHistoryReceiveMessageResponse = businessUtils.insertHistoryReceiveMessageResponse(xml);
				log.info("==thuTucNhapCanhTraMessageHaiQuan==insertHistoryReceiveMessageResponse==" + insertHistoryReceiveMessageResponse);
			}
		}
	}
	
	
	private void thuTucSentMessageYeuCauBoSungHoSoDinhKem(String userLogin, TempDocument tempDocument, int messageType, String requestCode, ActionRequest request) throws RemoteException {
		
		log.info("==VAO thuTucSentMessageYeuCauBoSungHoSoDinhKem====");
		BusinessUtils businessUtils = new BusinessUtils();
		String xmlData = "";
		IMTService imtService = CallWs2HaiQuan.getIMTSercice();
		
		Header header = null;
		String function= MessageType.FUNCTION_THONG_BAO_BO_SUNG_HO_SO_CHUNG_TU_KINH_KEM;
		
		if (messageType == Integer.valueOf(MessageType.FUNCTION_CAC_GIAY_TO_PHAI_XUAT_TRINH)) {
			//log.info("==VAO thuTucSentMessageYeuCauBoSungHoSoDinhKem====MessageType.FUNCTION_CAC_GIAY_TO_PHAI_XUAT_TRINH " + MessageType.FUNCTION_CAC_GIAY_TO_PHAI_XUAT_TRINH);
			
			requestCode = tempDocument.getRequestCode();
		}
		
		if(requestCode!=null) {
		//	log.info("==VAO thuTucSentMessageYeuCauBoSungHoSoDinhKem====  requestCode!=null");
			InterfaceRequest interfaceRequest = InterfaceRequestLocalServiceUtil.findByRequestCode(requestCode);
			if(tempDocument.getDocumentTypeCode().equals(MessageType.LOAT_THU_TUC_ROI_CANG)) {
			//	log.info("==VAO thuTucSentMessageYeuCauBoSungHoSoDinhKem====  requestCode!=null and getDocumentTypeCode()" + tempDocument.getDocumentTypeCode());
				header = BusinessUtils.crateHeaderInland(tempDocument, MessageType.TAU_RA, function, 99 , userLogin, interfaceRequest);
				xmlData = tuChoiHoSoDinhKem(messageType, function, xmlData, businessUtils, header, tempDocument, request);
			
			} else if(tempDocument.getDocumentTypeCode().equals(MessageType.LOAT_THU_TUC_VAO_CANG)) {
				//log.info("==VAO thuTucSentMessageYeuCauBoSungHoSoDinhKem====  requestCode!=null and getDocumentTypeCode()" + tempDocument.getDocumentTypeCode());
				header = BusinessUtils.crateHeaderInland(tempDocument, MessageType.TAU_VAO, function, 99 , userLogin, interfaceRequest);
				xmlData = tuChoiHoSoDinhKem(messageType, function, xmlData, businessUtils, header, tempDocument, request);
			} else if(tempDocument.getDocumentTypeCode().equals(MessageType.LOAT_THU_TUC_NHAP_CANH)) {
				//log.info("==VAO thuTucSentMessageYeuCauBoSungHoSoDinhKem====  requestCode!=null and getDocumentTypeCode()" + tempDocument.getDocumentTypeCode());
				header = BusinessUtils.crateHeader(tempDocument, MessageType.NHAP_CANH, function, 99 , userLogin, interfaceRequest);
				xmlData = tuChoiHoSoDinhKem(messageType, function, xmlData, businessUtils, header, tempDocument, request);
			} else if(tempDocument.getDocumentTypeCode().equals(MessageType.LOAT_THU_TUC_XUAT_CANH)) {
				//log.info("==VAO thuTucSentMessageYeuCauBoSungHoSoDinhKem====  requestCode!=null and getDocumentTypeCode()" + tempDocument.getDocumentTypeCode());
				header = BusinessUtils.crateHeader(tempDocument, MessageType.XUAT_CANH, function, 99 , userLogin, interfaceRequest);
				xmlData = tuChoiHoSoDinhKem(messageType, function, xmlData, businessUtils, header, tempDocument, request);
			} else if(tempDocument.getDocumentTypeCode().equals(MessageType.LOAT_THU_TUC_QUA_CANH)) {
				//log.info("==VAO thuTucSentMessageYeuCauBoSungHoSoDinhKem====  requestCode!=null and getDocumentTypeCode()" + tempDocument.getDocumentTypeCode());
				header = BusinessUtils.crateHeader(tempDocument, MessageType.QUA_CANH, function, 99 , userLogin, interfaceRequest);
				xmlData = tuChoiHoSoDinhKem(messageType, function, xmlData, businessUtils, header, tempDocument, request);
			} 
			
			if (xmlData != null && xmlData.length() > 0) {
				
				//Chua ro nghiepvu insert nhu the nao (dung.le)
				boolean insertHistorySendMessage = businessUtils.insertHistorySendMessage(xmlData);
				//log.info("==thuTucNhapCanhTraMessageHaiQuan==insertHistorySendMessage==" + insertHistorySendMessage);
				
				//String xml = imtService.receiveResultFromMT(xmlData);
				String  xml = "";
				if(tempDocument.getDocumentTypeCode().equals((MessageType.LOAT_THU_TUC_VAO_CANG)) || tempDocument.getDocumentTypeCode().equals(MessageType.LOAT_THU_TUC_ROI_CANG)){
					log.info(" ----CAll receiveFromInland------- ");
					//resevice mess from our message!
				//	xml = imtService.receiveFromInland(xmlData);
					
				}else{
					log.info(" ----CAll receiveResultFromMT------- ");
				//	xml = imtService.receiveResultFromMT(xmlData);
				}
				
			//	log.info("===du lieu gui hai quan== " + xmlData );
				
			//	log.info("=======Du lieu NHAN  HQMC day ========" + xml);
				boolean insertHistoryReceiveMessageResponse = businessUtils.insertHistoryReceiveMessageResponse(xml);
				log.info("==thuTucNhapCanhTraMessageHaiQuan==insertHistoryReceiveMessageResponse==" + insertHistoryReceiveMessageResponse);
			}
		}
	}
	
	private String tuChoiHoSoDinhKem(int messageType, String function, String xmlData, BusinessUtils businessUtils, Header header,
			TempDocument tempDocument, ActionRequest resourceRequest) {
		
			xmlData = businessUtils.SentMessageRejectDinhKem(header, header.getReference().getMessageId(),
					BusinessUtils.getOrganizationFromUser(resourceRequest), businessUtils.getDivision(resourceRequest), header.getFrom().getName(),
					new Date(), tempDocument);
		return xmlData;
	}
//	
	private String chapNhanHoSoDinhKem(int messageType, String function, String xmlData, BusinessUtils businessUtils, Header header,
			TempDocument tempDocument, ActionRequest resourceRequest) {
		
			xmlData = businessUtils.SentMessageAcceptDinhKem(header, header.getReference().getMessageId(),
					BusinessUtils.getOrganizationFromUser(resourceRequest), businessUtils.getDivision(resourceRequest), header.getFrom().getName(),
					new Date(), tempDocument);
		return xmlData;
	}
	
	private String tuChoiSoDinhKem(int messageType, String function, String xmlData, BusinessUtils businessUtils, Header header,
			TempDocument tempDocument, ActionRequest resourceRequest, String lydotuchoi) {
		
			xmlData = businessUtils.SentMessageTucChoiDinhKem(header, header.getReference().getMessageId(),
					BusinessUtils.getOrganizationFromUser(resourceRequest), businessUtils.getDivision(resourceRequest), header.getFrom().getName(),
					new Date(), tempDocument, lydotuchoi);
		return xmlData;
	}
	
	public boolean xuLyXuatCanhRoleThuTuc(String userLogin, long documentName, int messageType, int documentYear, int actionType, String userName,
			String requestCode, ActionRequest request, ActionResponse httpReq) throws SystemException {
		
		log.info("==xuLyXuatCanhRoleThuTuc==actionType====actionType==" + actionType + "==messageType==" + messageType);
		boolean result = false;
		
		// Kiem tra xem ban khai nao truyen len
		switch (messageType) {
			case PageType.THANH_PHAN_HO_SO:
				log.info("==xuLyXuatCanhRoleThuTuc==messageType==" + messageType + "==THANH_PHAN_HO_SO");
				result = thanhPhanHoSoThucTuc(userLogin, documentName, messageType, documentYear, actionType, userName, requestCode, request, httpReq);
				break;
				
			case MessageType.BAN_KHAI_CHUNG:
				log.info("==xuLyXuatCanhRoleThuTuc==messageType==" + messageType + "==BAN_KHAI_CHUNG");
				result = banKhaiChung(documentName, messageType, documentYear, actionType, userName, requestCode, request);
				break;
				
			case MessageType.BAN_KHAI_DANH_SACH_THUYEN_VIEN:
				log.info("==xuLyXuatCanhRoleThuTuc==messageType==" + messageType + "==BAN_KHAI_DANH_SACH_THUYEN_VIEN");
				result = banKhaiDanhSachThuyenVien(documentName, messageType, documentYear, actionType, userName, requestCode, request);
				break;
				
			case MessageType.BAN_KHAI_DANH_SACH_HANH_KHACH:
				log.info("==xuLyXuatCanhRoleThuTuc==messageType==" + messageType + "==BAN_KHAI_DANH_SACH_HANH_KHACH");
				result = banKhaiDanhSachHanhKhach(documentName, messageType, documentYear, actionType, userName, requestCode, request);
				break;
				
			case MessageType.BAN_KHAI_HANG_HOA:
				log.info("==xuLyXuatCanhRoleThuTuc==messageType==" + messageType + "==BAN_KHAI_HANG_HOA");
				result = banKhaiDanhSachHangHoa(documentName, messageType, documentYear, actionType, userName, requestCode, request);
				break;
				
			case MessageType.BAN_KHAI_DU_TRU_CUA_TAU:
				log.info("==xuLyXuatCanhRoleThuTuc==messageType==" + messageType + "==BAN_KHAI_DU_TRU_CUA_TAU");
				result = banKhaiDuTruCuaTau(documentName, messageType, documentYear, actionType, userName, requestCode, request);
				break;
				
			case MessageType.BAN_KHAI_HANH_LY_HANH_KHACH_ROI_TAU:
				log.info("==xuLyXuatCanhRoleThuTuc==messageType==" + messageType + "==BAN_KHAI_HANH_LY_HANH_KHACH_ROI_TAU");
				result = banKhaiDanhSachHanhLyHanhKhachRoiTau(documentName, messageType, documentYear, actionType, userName, requestCode, request);
				break;
				
			case MessageType.GIAY_PHEP_ROI_CANG_BO_GTVT_CAP_KHI_XUAT_CANH:
				log.info("==xuLyXuatCanhRoleThuTuc==messageType==" + messageType + "==GIAY_PHEP_ROI_CANG_BO_GTVT_CAP_KHI_XUAT_CANH");
				result = thuTucActionGiayPhepRoiCangChoTauDen(userLogin, documentName, messageType, documentYear, actionType, userName, requestCode, request, httpReq);
				break;
				
			case MessageType.GIAY_PHEP_ROI_CANG_CHO_TAU_DEN:
				log.info("==xuLyXuatCanhRoleThuTuc==messageType==" + messageType + "==GIAY_PHEP_ROI_CANG_CHO_TAU_DEN");
				result = thuTucActionGiayPhepRoiCangChoTauDen(userLogin, documentName, messageType, documentYear, actionType, userName, requestCode, request, httpReq);
				break;
				
			case MessageType.XAC_NHAN_HOAN_THANH_THU_TUC:
				// ham, nay cho chuc nang thuc thi can ho hai quan gui messagage
				// thong bao den doanh nghiep, messageType = 23
				log.info("==xuLyXuatCanhRoleThuTuc==messageType==" + messageType + "==XAC_NHAN_HOAN_THANH_THU_TUC");
				result = xacNhanHoanThanhThuTuc(documentName, messageType, documentYear, actionType, userName, requestCode, request, httpReq);
				break;
		}
		
		return result;
	}
	
	// Anh The Anh lam tiep o day
	private boolean thanhPhanHoSoThucTuc(String userLogin, long documentName, int messageType, int documentYear, int actionType, String userName,
			String requestCode, ActionRequest resourceRequest, ActionResponse httpReq) {
		log.info("==thanhPhanHoSoThucTuc==actionType==" + actionType);
		boolean result = true;
		try {
			
			TempDocument tempDocument = null;
			InterfaceRequest interfaceRequest = null;
			Header header = null;
			BusinessUtils businessUtils = new BusinessUtils();
			String lyDoTuChoi = ParamUtil.getString(resourceRequest, PageType.LY_DO_TU_CHOI);
			if (lyDoTuChoi == null || lyDoTuChoi.length() == 0) {
				lyDoTuChoi = "System";
			}
			log.info("==thanhPhanHoSoThucTuc==lyDoTuChoi==" + lyDoTuChoi);
			tempDocument = TempDocumentLocalServiceUtil.findTemDocumentByDocumentNameDocumentYear(documentName, documentYear);
			
			String xmlData = "";
			
			switch (actionType) {
				case PageType.ACTION_TYPE_TIEP_NHAN:
					log.info("==thanhPhanHoSoThucTuc==actionType==ACTION_TYPE_TIEP_NHAN");
					// Khi tiep nhan
					if(tempDocument.getDocumentTypeCode().equals(MessageType.LOAT_THU_TUC_ROI_CANG)) {
						header = BusinessUtils.crateHeaderInland(tempDocument, MessageType.TAU_RA, MessageType.FUNCTION_CHAP_NHAN_HO_SO_CHUNG_TU,
								MessageType.HO_SO, userName, interfaceRequest);
					} else {
						header = BusinessUtils.crateHeader(tempDocument, MessageType.XUAT_CANH, MessageType.FUNCTION_CHAP_NHAN_HO_SO_CHUNG_TU,
								MessageType.HO_SO, userName, interfaceRequest);
					}
					
					xmlData = businessUtils.sendMessageAccept(header, BusinessUtils.getOrganizationFromUser(resourceRequest),
							businessUtils.getDivision(resourceRequest), header.getFrom().getName(), new Date(), tempDocument.getRequestCode());
					
					if (tempDocument.getRequestState() == TrangThaiBanKhaiXuatCanh.CHO_TIEP_NHAN) {
						tempDocument.setRequestState(TrangThaiBanKhaiXuatCanh.DA_TIEP_NHAN);
						tempDocument.setDocumentStatusCode(TrangThaiBanKhaiXuatCanh.THU_TUC_DA_TIEP_NHAN);
						
					}else if (tempDocument.getDocumentStatusCode() == TrangThaiBanKhaiXuatCanh.THU_TUC_DA_TIEP_NHAN) {
						tempDocument.setDocumentStatusCode(TrangThaiBanKhaiXuatCanh.CHO_PHE_DUYET_HOAN_THANH_THU_TUC);
						
					} else if (tempDocument.getDocumentStatusCode() == TrangThaiBanKhaiXuatCanh.YEU_CAU_SUA_DOI_BO_SUNG) {
						tempDocument.setDocumentStatusCode(TrangThaiBanKhaiXuatCanh.CHO_PHE_DUYET_HOAN_THANH_THU_TUC);
					}
					
					break;
				case PageType.ACTION_TYPE_TU_CHOI:
					log.info("==thanhPhanHoSoThucTuc==actionType==ACTION_TYPE_TU_CHOI -  Thuc chat la nut yeu cau bo sung tren trang thanh phan ho so (dung.le)");
					// Khi tu choi
					if(tempDocument.getDocumentTypeCode().equals(MessageType.LOAT_THU_TUC_ROI_CANG)) {
						header = BusinessUtils.crateHeaderInland(tempDocument, MessageType.TAU_RA, MessageType.FUNCTION_TU_SUA_DOI_BO_SUNG_THU_TUC,
								MessageType.HO_SO, userName, interfaceRequest);
						
						xmlData = businessUtils.sendMessageRejectInland(header, header.getReference().getMessageId(), lyDoTuChoi, BusinessUtils
								.getOrganizationFromUser(resourceRequest), businessUtils.getDivision(resourceRequest), header.getFrom().getName(),
								new Date(), tempDocument.getRequestCode());
					} else {
						header = BusinessUtils.crateHeader(tempDocument, MessageType.XUAT_CANH, MessageType.FUNCTION_TU_SUA_DOI_BO_XUNG_THU_TUC,
								MessageType.HO_SO, userName, interfaceRequest);
						
						xmlData = businessUtils.sendMessageReject(header, header.getReference().getMessageId(), lyDoTuChoi, BusinessUtils
								.getOrganizationFromUser(resourceRequest), businessUtils.getDivision(resourceRequest), header.getFrom().getName(),
								new Date(), tempDocument.getRequestCode());
					}
					
					if (tempDocument.getRequestState() == TrangThaiBanKhaiXuatCanh.CHO_TIEP_NHAN) {
						tempDocument.setRequestState(TrangThaiBanKhaiXuatCanh.TU_CHOI_TIEP_NHAN);
						tempDocument.setDocumentStatusCode(TrangThaiBanKhaiXuatCanh.HUY_THU_TUC_TAU_THUYEN_XUAT_CANH);
						
					} else if (tempDocument.getDocumentStatusCode() == TrangThaiBanKhaiXuatCanh.THU_TUC_DA_TIEP_NHAN) {
						tempDocument.setDocumentStatusCode(TrangThaiBanKhaiXuatCanh.YEU_CAU_SUA_DOI_BO_SUNG);
					}
					
					//truong hop ho so gui yeu cau bo sung hoac, phe duyet hoan thanh thu tuc
					if (tempDocument.getDocumentStatusCode() == TrangThaiBanKhai.THUTUC_CHO_PHE_DUYET_HOAN_THANH_THU_TUC || tempDocument.getDocumentStatusCode() == TrangThaiBanKhai.THUTUC_YEU_CAU_SUA_DOI_BO_SUNG) {
						lyDoTuChoi = ParamUtil.getString(resourceRequest, PageType.LY_DO_TU_CHOI);
						insertOrUpdateResultNotification(tempDocument, userName, lyDoTuChoi, MessageType.BO_SUNG_THU_TUC);
					}
					
					break;
				
				case PageType.ACTION_TYPE_HUY:
					log.info("==thanhPhanHoSoThucTuc==actionType==ACTION_TYPE_HUY");
					String lyDoHuyXC99 = ParamUtil.getString(resourceRequest, PageType.HUY_HO_SO);
					if (lyDoHuyXC99 == null || lyDoHuyXC99.length() == 0) {
						lyDoHuyXC99 = "lyDoHuyXC99";
					}
					
					BusinessUtils.insertOrUpdateResultMinistry((new Long(documentName)).intValue(), documentYear,
							MessageType.FUNCTION_XAC_NHAN_HUY_THU_TUC, BusinessUtils.getRemarkHuy(userName, lyDoHuyXC99));
					BusinessUtils.insertResultHistoryMinistry((new Long(documentName)).intValue(), documentYear,
							MessageType.FUNCTION_XAC_NHAN_HUY_THU_TUC, BusinessUtils.getRemarkHuy(userName, lyDoHuyXC99));
					log.info("===lyDoHuyXC99===" + lyDoHuyXC99);
					// Khi tu choi
					if(tempDocument.getDocumentTypeCode().equals(MessageType.LOAT_THU_TUC_ROI_CANG)) {
						header = BusinessUtils.crateHeaderInland(tempDocument, MessageType.TAU_RA, MessageType.FUNCTION_XAC_NHAN_HUY_THU_TUC,
								MessageType.HO_SO, userName, interfaceRequest);
					} else {
						header = BusinessUtils.crateHeader(tempDocument, MessageType.XUAT_CANH, MessageType.FUNCTION_XAC_NHAN_HUY_THU_TUC,
								MessageType.HO_SO, userName, interfaceRequest);
					}
					
					
					xmlData = businessUtils.sendMessageHuyHoSo(header, BusinessUtils.getOrganizationFromUser(resourceRequest),
							businessUtils.getDivision(resourceRequest), header.getFrom().getName(), new Date(), lyDoHuyXC99, tempDocument.getRequestCode());
					
					if (tempDocument.getDocumentStatusCode() == TrangThaiBanKhaiXuatCanh.CHO_PHE_DUYET_HOAN_THANH_THU_TUC) {
						xacNhanHoanThanhThuTucXuatCanhTruongHopHuy(resourceRequest, tempDocument.getDocumentName(), tempDocument.getDocumentYear(),
								lyDoHuyXC99);
						tempDocument.setDocumentStatusCode(TrangThaiBanKhaiXuatCanh.HUY_THU_TUC_TAU_THUYEN_XUAT_CANH);
						BusinessUtils.updateLyDoResultNotification(userLogin, lyDoHuyXC99, MessageType.HO_SO, tempDocument.getMaritimeCode(),
								documentName, documentYear);
					}
					
					break;
				case PageType.ACTION_TYPE_SUA_DOI:
					log.info("==thanhPhanHoSoThucTuc==actionType==ACTION_TYPE_TU_CHOI -  Thuc chat la nut yeu cau bo sung tren trang thanh phan ho so (dung.le)");
					// Khi tu choi
					if(tempDocument.getDocumentTypeCode().equals(MessageType.LOAT_THU_TUC_ROI_CANG)) {
//						header = BusinessUtils.crateHeaderInland(tempDocument, MessageType.TAU_RA, MessageType.FUNCTION_TU_SUA_DOI_BO_SUNG_THU_TUC,
//								MessageType.HO_SO, userName, interfaceRequest);
//						
//						xmlData = businessUtils.sendMessageRejectInland(header, header.getReference().getMessageId(), lyDoTuChoi, BusinessUtils
//								.getOrganizationFromUser(resourceRequest), businessUtils.getDivision(resourceRequest), header.getFrom().getName(),
//								new Date());
						
						header = BusinessUtils.crateHeaderInland(tempDocument, MessageType.TAU_RA, String.valueOf(MessageType.FUNCTION_TU_CHOI_HO_SO) ,
								MessageType.HO_SO, userName, interfaceRequest);
						
						xmlData = businessUtils.sendMessageRejectKH(header, header.getReference().getMessageId(), lyDoTuChoi,
								BusinessUtils.getOrganizationFromUser(resourceRequest), businessUtils.getDivision(resourceRequest),
								header.getFrom().getName(), new Date(), tempDocument.getRequestCode());
					} else {
						header = BusinessUtils.crateHeader(tempDocument, MessageType.XUAT_CANH, MessageType.FUNCTION_XAC_NHAN_HUY_THU_TUC,
								MessageType.HO_SO, userName, interfaceRequest);
						
						xmlData = businessUtils.sendMessageHuyHoSo(header, BusinessUtils.getOrganizationFromUser(resourceRequest),
								businessUtils.getDivision(resourceRequest), header.getFrom().getName(), new Date(), lyDoTuChoi, tempDocument.getRequestCode());
					}
					
					if (tempDocument.getRequestState() == TrangThaiBanKhaiXuatCanh.CHO_TIEP_NHAN || tempDocument.getDocumentStatusCode() == TrangThaiBanKhaiXuatCanh.THU_TUC_DA_TIEP_NHAN || tempDocument.getDocumentStatusCode() == TrangThaiBanKhai.THUTUC_YEU_CAU_SUA_DOI_BO_SUNG) {
						tempDocument.setRequestState(TrangThaiBanKhaiXuatCanh.TU_CHOI_TIEP_NHAN);
						tempDocument.setDocumentStatusCode(TrangThaiBanKhaiXuatCanh.HUY_THU_TUC_TAU_THUYEN_XUAT_CANH);
						
					}
//					else if (tempDocument.getDocumentStatusCode() == TrangThaiBanKhaiXuatCanh.THU_TUC_DA_TIEP_NHAN) {
//						tempDocument.setDocumentStatusCode(TrangThaiBanKhaiXuatCanh.YEU_CAU_SUA_DOI_BO_SUNG);
//					}
					
					//truong hop ho so gui yeu cau bo sung hoac, phe duyet hoan thanh thu tuc
					if (tempDocument.getDocumentStatusCode() == TrangThaiBanKhai.THUTUC_CHO_PHE_DUYET_HOAN_THANH_THU_TUC /* || tempDocument.getDocumentStatusCode() == TrangThaiBanKhai.THUTUC_YEU_CAU_SUA_DOI_BO_SUNG */) {
						lyDoTuChoi = ParamUtil.getString(resourceRequest, PageType.LY_DO_TU_CHOI);
						insertOrUpdateResultNotification(tempDocument, userName, lyDoTuChoi, MessageType.BO_SUNG_THU_TUC);
					}
					
					break;
					
					
			}
			TempDocumentLocalServiceUtil.updateTempDocument(tempDocument);
			
			if (xmlData != null && xmlData.trim().length() > 0) {
				if (tempDocument.getDocumentTypeCode().equals(MessageType.LOAT_THU_TUC_VAO_CANG) || tempDocument.getDocumentTypeCode().equals(MessageType.LOAT_THU_TUC_ROI_CANG)) {
					guiBanTinSangHQMC_TauVaoRa(xmlData, businessUtils);
				}else {
					guiBanTinSangHQMC(xmlData, businessUtils);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}
	
	
	
	private boolean toanBoHoSoKeHoach(long documentName, int messageType, int documentYear, int actionType, String userName, String requestCode,
			ActionRequest resourceRequest, ActionResponse httpReq) {
		boolean result = true;
		try {
			
			TempDocument tempDocument = null;
			InterfaceRequest interfaceRequest = null;
			Header header = null;
			
			BusinessUtils businessUtils = new BusinessUtils();
			
			String lyDoTuChoi = ParamUtil.getString(resourceRequest, PageType.LY_DO_TU_CHOI);
			if (lyDoTuChoi == null || lyDoTuChoi.length() == 0) {
				lyDoTuChoi = "System";
			}
			
			tempDocument = TempDocumentLocalServiceUtil.findTemDocumentByDocumentNameDocumentYear(documentName, documentYear);
			
			String xmlData = "";
			
			switch (actionType) {
				case PageType.ACTION_TYPE_TIEP_NHAN:
					// Khi tiep nhan
					header = BusinessUtils.crateHeader(tempDocument, MessageType.XUAT_CANH, MessageType.FUNCTION_CHAP_NHAN_HO_SO_CHUNG_TU,
						MessageType.HO_SO, userName, interfaceRequest);
					
					// xmlData = businessUtils.sendMessageAccept(header,
					// BusinessUtils.getOrganizationFromUser(resourceRequest),
					// businessUtils.getDivision(resourceRequest), header.getFrom().getName(), new Date());
					
					List<ResultDeclaration> lstDeclarations = ResultDeclarationLocalServiceUtil
						.findByDocumentNameAndBusinessTypeCodeAndDocumentYear(
							MessageType.THONG_BAO_TAU_ROI_CANG, tempDocument.getDocumentName(), tempDocument.getDocumentYear());
					
					if (lstDeclarations != null && lstDeclarations.size() > 0) {
						ResultDeclaration declaration = lstDeclarations.get(0);
						
						TempNoTiceShipMessage noticeShipMessage = TempNoTiceShipMessageLocalServiceUtil
							.findTempNoTiceShipMessageByRequestCode(declaration.getRequestCode());
						
						if (noticeShipMessage != null
								&& noticeShipMessage.getRequestState() != TrangThaiBanKhai.TRANG_THAI_BANG_KHAI_TIEP_NHAN
								&& noticeShipMessage.getRequestState() != TrangThaiBanKhai.TRANG_THAI_BANG_KHAI_TU_CHOI) {
							
							noticeShipMessage.setRequestState(TrangThaiBanKhai.TRANG_THAI_BANG_KHAI_TIEP_NHAN);
							
							BusinessUtils.updateResultDeclaration(MessageType.THONG_BAO_TAU_ROI_CANG, tempDocument.getDocumentName(),
								tempDocument.getDocumentYear(), TrangThaiBanKhai.TRANG_THAI_BANG_KHAI_TIEP_NHAN);
							
							TempNoTiceShipMessageLocalServiceUtil.updateTempNoTiceShipMessage(noticeShipMessage);
							
						}
					}
					
					if (tempDocument.getRequestState() == TrangThaiBanKhaiXuatCanh.CHO_TIEP_NHAN ||
							tempDocument.getRequestState() == TrangThaiBanKhaiNhapCanh.KE_HOACH_YEU_CAU_SUA_DOI_BO_SUNG) {
						
						tempDocument.setRequestState(TrangThaiBanKhaiXuatCanh.DA_TIEP_NHAN);
						tempDocument.setDocumentStatusCode(TrangThaiBanKhaiXuatCanh.THU_TUC_DA_TIEP_NHAN);
						
					}
					
					break;
				case PageType.ACTION_TYPE_TU_CHOI:
					
					BusinessUtils.insertOrUpdateResultMinistry((new Long(documentName)).intValue(), documentYear,
						MessageType.FUNCTION_TU_CHOI_HO_SO_CHUNG_TU, BusinessUtils.getRemarkTuChoi(userName, lyDoTuChoi));
					
					BusinessUtils.insertResultHistoryMinistry((new Long(documentName)).intValue(), documentYear,
						MessageType.FUNCTION_TU_CHOI_HO_SO_CHUNG_TU, BusinessUtils.getRemarkTuChoi(userName, lyDoTuChoi));
					
					// Khi tu choi
					header = BusinessUtils.crateHeader(tempDocument, MessageType.XUAT_CANH, MessageType.FUNCTION_TU_CHOI_HO_SO_CHUNG_TU,
						MessageType.HO_SO, userName, interfaceRequest);
					
					xmlData = businessUtils.sendMessageReject(header, header.getReference().getMessageId(), lyDoTuChoi, BusinessUtils
						.getOrganizationFromUser(resourceRequest), businessUtils.getDivision(resourceRequest), header.getFrom().getName(),
							new Date(), tempDocument.getRequestCode());
					
					if (tempDocument.getRequestState() == TrangThaiBanKhaiXuatCanh.CHO_TIEP_NHAN
							|| tempDocument.getRequestState() == TrangThaiBanKhaiNhapCanh.KE_HOACH_YEU_CAU_SUA_DOI_BO_SUNG) {
						tempDocument.setRequestState(TrangThaiBanKhaiXuatCanh.TU_CHOI_TIEP_NHAN);
						// tempDocument.setDocumentStatusCode(TrangThaiBanKhaiXuatCanh.HUY_THU_TUC_TAU_THUYEN_XUAT_CANH);
					}
					break;
				case PageType.ACTION_TYPE_SUA_DOI:
					xmlData = suaDoiKeHoach(documentName, messageType, documentYear, userName, resourceRequest, tempDocument, interfaceRequest,
							businessUtils);
					break;
			
			}
			
			log.info("==tempDocument===ShipTypeCode==" + tempDocument.getShipTypeCode());
			log.info("==tempDocument===" + tempDocument);
			log.info("==tempDocument===" + tempDocument.getRequestState());
			
			TempDocument document = TempDocumentLocalServiceUtil.updateTempDocument(tempDocument);
			log.info("==tempDocument==" + document.getRequestState());
			
			if (xmlData != null && xmlData.trim().length() > 0) {
				if (tempDocument.getDocumentTypeCode().equals(MessageType.LOAT_THU_TUC_VAO_CANG) || tempDocument.getDocumentTypeCode().equals(MessageType.LOAT_THU_TUC_ROI_CANG)) {
					guiBanTinSangHQMC_TauVaoRa(xmlData, businessUtils);
				}else {
					guiBanTinSangHQMC(xmlData, businessUtils);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}
	
	private String suaDoiKeHoach(long documentName, int messageType, int documentYear, String userName, ActionRequest resourceRequest,
			TempDocument tempDocument, InterfaceRequest interfaceRequest, BusinessUtils businessUtils) throws SystemException {
		String xmlData;
		if (tempDocument.getRequestState() == TrangThaiBanKhaiNhapCanh.CHO_TIEP_NHAN
				|| tempDocument.getRequestState() == TrangThaiBanKhaiNhapCanh.KE_HOACH_YEU_CAU_SUA_DOI_BO_SUNG) {
			
			tempDocument.setRequestState(TrangThaiBanKhaiNhapCanh.KE_HOACH_YEU_CAU_SUA_DOI_BO_SUNG);
			TempDocumentLocalServiceUtil.updateTempDocument(tempDocument);
			String lyDoSuaDoiBoSung = ParamUtil.getString(resourceRequest, PageType.LY_DO_SUADOI_BOSUNG);
			if (lyDoSuaDoiBoSung == null || lyDoSuaDoiBoSung.length() == 0) {
				lyDoSuaDoiBoSung = "System";
			}
			BusinessUtils.insertOrUpdateResultMinistry((new Long(documentName)).intValue(), documentYear, MessageType.FUNCTION_THONG_BAO_BO_XUNG,
					BusinessUtils.getRemarkBoSung(userName, lyDoSuaDoiBoSung));
			
			BusinessUtils.insertResultHistoryMinistry((new Long(documentName)).intValue(), documentYear, MessageType.FUNCTION_THONG_BAO_BO_XUNG,
					BusinessUtils.getRemarkBoSung(userName, lyDoSuaDoiBoSung));
			
			// ResultNotification
			
			insertOrUpdateResultNotification(tempDocument, userName, lyDoSuaDoiBoSung, MessageType.BO_SUNG_KE_HOACH);
			
		}
		xmlData = createXmlSuaDoiBoXung(messageType, tempDocument, userName, resourceRequest, businessUtils, interfaceRequest);
		return xmlData;
	}
	
	private boolean xacNhanHoanThanhThuTuc(long documentName, int messageType, int documentYear, int actionType, String userName, String requestCode,
			ActionRequest request, ActionResponse httpReq) {
		
		boolean result = true;
		
		log.info("===xacNhanHoanThanhThuTuc==actionType==" + actionType + "==messageType==" + messageType);
		
		try {
			
			TempDocument tempDocument = null;
			InterfaceRequest interfaceRequest = null;
			Header header = null;
			BusinessUtils businessUtils = new BusinessUtils();
			
			String lyDoTuChoi = ParamUtil.getString(request, PageType.LY_DO_TU_CHOI);
			if (lyDoTuChoi == null || lyDoTuChoi.length() == 0) {
				lyDoTuChoi = "System";
			}
			tempDocument = TempDocumentLocalServiceUtil.findTemDocumentByDocumentNameDocumentYear(documentName, documentYear);
			
			String xmlData = "";
			
			switch (actionType) {
			
				case PageType.ACTION_TYPE_HOAN_THANH_THU_TUC:
					// doi Minh sua phan cap giay phep
					if (tempDocument.getDocumentStatusCode() == TrangThaiBanKhaiXuatCanh.CHO_PHE_DUYET_HOAN_THANH_THU_TUC) {
						String flagStateOfShip = ParamUtil.getString(request, "flagStateOfShip");
						double grossTonnage = ParamUtil.getDouble(request, "grossTonnage");
						
						tempDocument.setDocumentStatusCode(TrangThaiBanKhaiXuatCanh.DE_NGHI_CAP_GIAY_PHEP);												
						tempDocument.setStateCode(flagStateOfShip);
						tempDocument.setGrt(grossTonnage);												
					}
					
					xacNhanHoanThanhThuTucXuatCanh(request, documentName, documentYear);
					break;
				case PageType.ACTION_TYPE_HUY:
					String reason = ParamUtil.getString(request, PageType.HUY_HO_SO);
					
					if (reason == null || reason.length() == 0) {
						reason = "System";
					}
					xacNhanHoanThanhThuTucXuatCanhTruongHopHuy(request, tempDocument.getDocumentName(), tempDocument.getDocumentYear(), reason);
					
					log.info("==reason==" + reason);
					// // Khi tu choi
					header = BusinessUtils.crateHeader(tempDocument, MessageType.XUAT_CANH, MessageType.FUNCTION_XAC_NHAN_HUY_THU_TUC,
							MessageType.HO_SO, userName, interfaceRequest);
					
					xmlData = businessUtils.sendMessageHuyHoSo(header, BusinessUtils.getOrganizationFromUser(request),
							businessUtils.getDivision(request), header.getFrom().getName(), new Date(), reason, tempDocument.getRequestCode());
					
					if (tempDocument.getDocumentStatusCode() == TrangThaiBanKhaiXuatCanh.CHO_PHE_DUYET_HOAN_THANH_THU_TUC) {
						tempDocument.setDocumentStatusCode(TrangThaiBanKhaiXuatCanh.HUY_THU_TUC_TAU_THUYEN_XUAT_CANH);
					}
					
					break;
				
				// can ho hai quan gui thong bao den doanh nghiep, anh The Anh
				case PageType.ACTION_TYPE_SUA_DOI:
					
					log.info("truong hop can bo hang hai gui thong diep sang bo giao thong, thong bao thieu ho so");
					log.info("actionType==" + actionType);
					lyDoTuChoi = ParamUtil.getString(request, PageType.LY_DO_SUADOI_BOSUNG);
					if (lyDoTuChoi.trim().length() == 0) {
						lyDoTuChoi = "System";
					}
					xmlData = createXmlSuaDoiBoXung(messageType, tempDocument, userName, request, businessUtils, interfaceRequest);
					insertOrUpdateResultNotification(tempDocument, userName, lyDoTuChoi, MessageType.BO_SUNG_KE_HOACH);
					break;
			}
			TempDocumentLocalServiceUtil.updateTempDocument(tempDocument);
			
			if (xmlData != null && xmlData.trim().length() > 0) {
				if (tempDocument.getDocumentTypeCode().equals(MessageType.LOAT_THU_TUC_VAO_CANG) || tempDocument.getDocumentTypeCode().equals(MessageType.LOAT_THU_TUC_ROI_CANG)) {
					guiBanTinSangHQMC_TauVaoRa(xmlData, businessUtils);
				}else {
					guiBanTinSangHQMC(xmlData, businessUtils);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}
	
	private boolean banKhaiDanhSachHangHoa(long documentName, int messageType, int documentYear, int actionType, String userName, String requestCode,
			ActionRequest resourceRequest) {
		boolean result = false;
		TempCargoDeclaration tempCargoDeclaration = null;
		String _requestCode = requestCode;
		TempDocument tempDocument = null;
		InterfaceRequest interfaceRequest = null;
		Header header = null;
		BusinessUtils businessUtils = new BusinessUtils();
		String xmlData = "";
		int trangThaiBanKhai = 0;
		
		switch (actionType) {
			case PageType.ACTION_TYPE_TIEP_NHAN:
				_requestCode = CheckBusinessUtil.getRequestCode(_requestCode, (int) documentName, documentYear, MessageType.BAN_KHAI_HANG_HOA);
				tempCargoDeclaration = TempCargoDeclarationLocalServiceUtil.findTempCargoDeclarationByRequestCode(_requestCode);
				
				if (tempCargoDeclaration != null) {
					tempDocument = TempDocumentLocalServiceUtil.findTemDocumentByDocumentNameDocumentYear(documentName, documentYear);
					interfaceRequest = InterfaceRequestLocalServiceUtil.findInterfaceRequestByRequestCode(_requestCode);
					if (interfaceRequest != null) {
						try {
							interfaceRequest.setRemarks(BusinessUtils.getRemarkChapNhan(userName));
							
							InterfaceRequestLocalServiceUtil.updateInterfaceRequest(interfaceRequest);
						} catch (Exception e) {
							
						}
					}
					
					header = BusinessUtils.crateHeader(tempDocument, MessageType.XUAT_CANH,
							FormatData.formatIntToString(PageType.DOCUMENT_TYPE_CHAP_NHAN), messageType, userName, interfaceRequest);
					
					// Gui thong tin di.
					xmlData = businessUtils.sendMessageAccept(header, getOrganization(businessUtils, resourceRequest),
							getDevision(businessUtils, resourceRequest), userName, new Date(), tempDocument.getRequestCode());
					trangThaiBanKhai = TrangThaiBanKhaiXuatCanh.CHAP_NHAN_BAN_KHAI;
				}
				break;
			case PageType.ACTION_TYPE_TU_CHOI:
				_requestCode = CheckBusinessUtil.getRequestCode(_requestCode, (int) documentName, documentYear, MessageType.BAN_KHAI_HANG_HOA);
				tempCargoDeclaration = TempCargoDeclarationLocalServiceUtil.findTempCargoDeclarationByRequestCode(_requestCode);
				
				if (tempCargoDeclaration != null) {
					tempDocument = TempDocumentLocalServiceUtil.findTemDocumentByDocumentNameDocumentYear(documentName, documentYear);
					interfaceRequest = InterfaceRequestLocalServiceUtil.findInterfaceRequestByRequestCode(_requestCode);
					if (interfaceRequest != null) {
						try {
							interfaceRequest.setRemarks(BusinessUtils.getRemarkTuChoi(userName,
									ParamUtil.getString(resourceRequest, PageType.LY_DO_TU_CHOI)));
							
							InterfaceRequestLocalServiceUtil.updateInterfaceRequest(interfaceRequest);
						} catch (Exception e) {
							
						}
					}
					header = BusinessUtils.crateHeader(tempDocument, MessageType.XUAT_CANH,
							FormatData.formatIntToString(PageType.DOCUMENT_TYPE_TU_CHOI), messageType, userName, interfaceRequest);
					
					// Gui thong tin di.
					// xmlData = businessUtils.sendMessageAccept(header,
					// getOrganization(), getDevision(), userName, new Date());
					businessUtils.sendMessageReject(header, "", ParamUtil.getString(resourceRequest, PageType.LY_DO_TU_CHOI),
							getOrganization(businessUtils, resourceRequest), getDevision(businessUtils, resourceRequest), userName, new Date(), tempDocument.getRequestCode());
					trangThaiBanKhai = TrangThaiBanKhaiXuatCanh.TU_CHOI_BAN_KHAI;
				}
				break;
		}
		
		if (trangThaiBanKhai > 0 || tempCargoDeclaration != null) {
			tempCargoDeclaration.setRequestState(trangThaiBanKhai);
			try {
				TempCargoDeclarationLocalServiceUtil.updateTempCargoDeclaration(tempCargoDeclaration);
			} catch (Exception e) {
				e.printStackTrace();
				log.equals(e);
			}
		}
		if (xmlData != null && xmlData.trim().length() > 0) {
			if (tempDocument.getDocumentTypeCode().equals(MessageType.LOAT_THU_TUC_VAO_CANG) || tempDocument.getDocumentTypeCode().equals(MessageType.LOAT_THU_TUC_ROI_CANG)) {
				guiBanTinSangHQMC_TauVaoRa(xmlData, businessUtils);
			}else {
				guiBanTinSangHQMC(xmlData, businessUtils);
			}
		}
		
		return result;
	}
	
	private boolean banKhaiDanhSachHanhKhach(long documentName, int messageType, int documentYear, int actionType, String userName,
			String requestCode, ActionRequest resourceRequest) {
		boolean result = false;
		TempPassengerList tempPassengerList = null;
		String _requestCode = requestCode;
		TempDocument tempDocument = null;
		InterfaceRequest interfaceRequest = null;
		Header header = null;
		BusinessUtils businessUtils = new BusinessUtils();
		String xmlData = "";
		int trangThaiBanKhai = 0;
		
		switch (actionType) {
			case PageType.ACTION_TYPE_TIEP_NHAN:
				_requestCode = CheckBusinessUtil.getRequestCode(_requestCode, (int) documentName, documentYear,
						MessageType.BAN_KHAI_DANH_SACH_HANH_KHACH);
				tempPassengerList = TempPassengerListLocalServiceUtil.findTempPassengerListByRequestCode(_requestCode);
				
				if (tempPassengerList != null) {
					tempDocument = TempDocumentLocalServiceUtil.findTemDocumentByDocumentNameDocumentYear(documentName, documentYear);
					interfaceRequest = InterfaceRequestLocalServiceUtil.findInterfaceRequestByRequestCode(_requestCode);
					if (interfaceRequest != null) {
						try {
							interfaceRequest.setRemarks(BusinessUtils.getRemarkChapNhan(userName));
							
							InterfaceRequestLocalServiceUtil.updateInterfaceRequest(interfaceRequest);
						} catch (Exception e) {
							
						}
					}
					if(tempDocument.getDocumentTypeCode().equals(MessageType.LOAT_THU_TUC_ROI_CANG)) {
						header = BusinessUtils.crateHeaderInland(tempDocument, MessageType.TAU_RA,
								FormatData.formatIntToString(PageType.DOCUMENT_TYPE_CHAP_NHAN), messageType, userName, interfaceRequest);
					} else {
						header = BusinessUtils.crateHeader(tempDocument, MessageType.XUAT_CANH,
								FormatData.formatIntToString(PageType.DOCUMENT_TYPE_CHAP_NHAN), messageType, userName, interfaceRequest);
					}
					
					// Gui thong tin di.
					xmlData = businessUtils.sendMessageAccept(header, getOrganization(businessUtils, resourceRequest),
							getDevision(businessUtils, resourceRequest), userName, new Date(), tempDocument.getRequestCode());
					trangThaiBanKhai = TrangThaiBanKhaiXuatCanh.CHAP_NHAN_BAN_KHAI;
				}
				break;
			case PageType.ACTION_TYPE_TU_CHOI:
				_requestCode = CheckBusinessUtil.getRequestCode(_requestCode, (int) documentName, documentYear,
						MessageType.BAN_KHAI_DANH_SACH_HANH_KHACH);
				tempPassengerList = TempPassengerListLocalServiceUtil.findTempPassengerListByRequestCode(_requestCode);
				
				if (tempPassengerList != null) {
					tempDocument = TempDocumentLocalServiceUtil.findTemDocumentByDocumentNameDocumentYear(documentName, documentYear);
					interfaceRequest = InterfaceRequestLocalServiceUtil.findInterfaceRequestByRequestCode(_requestCode);
					if (interfaceRequest != null) {
						try {
							interfaceRequest.setRemarks(BusinessUtils.getRemarkTuChoi(userName,
									ParamUtil.getString(resourceRequest, PageType.LY_DO_TU_CHOI)));
							
							InterfaceRequestLocalServiceUtil.updateInterfaceRequest(interfaceRequest);
						} catch (Exception e) {
							
						}
					}
					if(tempDocument.getDocumentTypeCode().equals(MessageType.LOAT_THU_TUC_ROI_CANG)) {
						header = BusinessUtils.crateHeaderInland(tempDocument, MessageType.TAU_RA, FormatData.formatIntToString(PageType.DOCUMENT_TYPE_TU_CHOI),
								MessageType.HO_SO, userName, interfaceRequest);
						
						xmlData = businessUtils.sendMessageReject(header, "", ParamUtil.getString(resourceRequest, PageType.LY_DO_TU_CHOI),
								getOrganization(businessUtils, resourceRequest), getDevision(businessUtils, resourceRequest), userName, new Date(), tempDocument.getRequestCode());
					} else {
						header = BusinessUtils.crateHeader(tempDocument, MessageType.XUAT_CANH,
								FormatData.formatIntToString(PageType.DOCUMENT_TYPE_TU_CHOI), messageType, userName, interfaceRequest);
						
						xmlData = businessUtils.sendMessageReject(header, "", ParamUtil.getString(resourceRequest, PageType.LY_DO_TU_CHOI),
								getOrganization(businessUtils, resourceRequest), getDevision(businessUtils, resourceRequest), userName, new Date(), tempDocument.getRequestCode());
					}
					// Gui thong tin di.
					// xmlData = businessUtils.sendMessageAccept(header,
					// getOrganization(), getDevision(), userName, new Date());
//					xmlData = businessUtils.sendMessageReject(header, "", ParamUtil.getString(resourceRequest, PageType.LY_DO_TU_CHOI),
//							getOrganization(businessUtils, resourceRequest), getDevision(businessUtils, resourceRequest), userName, new Date());
					trangThaiBanKhai = TrangThaiBanKhaiXuatCanh.TU_CHOI_BAN_KHAI;
				}
				break;
		}
		
		if (trangThaiBanKhai > 0 || tempPassengerList != null) {
			tempPassengerList.setRequestState(trangThaiBanKhai);
			try {
				TempPassengerListLocalServiceUtil.updateTempPassengerList(tempPassengerList);
			} catch (Exception e) {
				e.printStackTrace();
				log.equals(e);
			}
		}
		if (xmlData != null && xmlData.trim().length() > 0) {
			if (tempDocument.getDocumentTypeCode().equals(MessageType.LOAT_THU_TUC_VAO_CANG) || tempDocument.getDocumentTypeCode().equals(MessageType.LOAT_THU_TUC_ROI_CANG)) {
				guiBanTinSangHQMC_TauVaoRa(xmlData, businessUtils);
			}else {
				guiBanTinSangHQMC(xmlData, businessUtils);
			}
		}
		
		return result;
	}
	
	private boolean banKhaiDanhSachThuyenVien(long documentName, int messageType, int documentYear, int actionType, String userName,
			String requestCode, ActionRequest resourceRequest) {
		boolean result = false;
		TempCrewList tempCrewList = null;
		String _requestCode = requestCode;
		TempDocument tempDocument = null;
		InterfaceRequest interfaceRequest = null;
		Header header = null;
		BusinessUtils businessUtils = new BusinessUtils();
		String xmlData = "";
		int trangThaiBanKhai = 0;
		tempDocument = TempDocumentLocalServiceUtil.findTemDocumentByDocumentNameDocumentYear(documentName, documentYear);
		switch (actionType) {
			case PageType.ACTION_TYPE_TIEP_NHAN:
				_requestCode = CheckBusinessUtil.getRequestCode(_requestCode, (int) documentName, documentYear,
						MessageType.BAN_KHAI_DANH_SACH_THUYEN_VIEN);
				tempCrewList = TempCrewListLocalServiceUtil.findTempCrewListByRequestCode(_requestCode);
				
				if (tempCrewList != null) {
					
					interfaceRequest = InterfaceRequestLocalServiceUtil.findInterfaceRequestByRequestCode(_requestCode);
					if (interfaceRequest != null) {
						try {
							interfaceRequest.setRemarks(BusinessUtils.getRemarkChapNhan(userName));
							
							InterfaceRequestLocalServiceUtil.updateInterfaceRequest(interfaceRequest);
						} catch (Exception e) {
							
						}
					}
					if(tempDocument.getDocumentTypeCode().equals(MessageType.LOAT_THU_TUC_ROI_CANG)) {
						header = BusinessUtils.crateHeaderInland(tempDocument, MessageType.TAU_RA,
								FormatData.formatIntToString(PageType.DOCUMENT_TYPE_CHAP_NHAN), messageType, userName, interfaceRequest);
					} else {
						header = BusinessUtils.crateHeader(tempDocument, MessageType.XUAT_CANH,
								FormatData.formatIntToString(PageType.DOCUMENT_TYPE_CHAP_NHAN), messageType, userName, interfaceRequest);
					}
					
					// Gui thong tin di.
					xmlData = businessUtils.sendMessageAccept(header, getOrganization(businessUtils, resourceRequest),
							getDevision(businessUtils, resourceRequest), userName, new Date(), tempDocument.getRequestCode());
					trangThaiBanKhai = TrangThaiBanKhaiXuatCanh.CHAP_NHAN_BAN_KHAI;
				}
				break;
			case PageType.ACTION_TYPE_TU_CHOI:
				_requestCode = CheckBusinessUtil.getRequestCode(_requestCode, (int) documentName, documentYear,
						MessageType.BAN_KHAI_DANH_SACH_THUYEN_VIEN);
				tempCrewList = TempCrewListLocalServiceUtil.findTempCrewListByRequestCode(_requestCode);
				
				if (tempCrewList != null) {
					tempDocument = TempDocumentLocalServiceUtil.findTemDocumentByDocumentNameDocumentYear(documentName, documentYear);
					interfaceRequest = InterfaceRequestLocalServiceUtil.findInterfaceRequestByRequestCode(_requestCode);
					if (interfaceRequest != null) {
						try {
							interfaceRequest.setRemarks(BusinessUtils.getRemarkTuChoi(userName,
									ParamUtil.getString(resourceRequest, PageType.LY_DO_TU_CHOI)));
							
							InterfaceRequestLocalServiceUtil.updateInterfaceRequest(interfaceRequest);
						} catch (Exception e) {
							
						}
					}
					if(tempDocument.getDocumentTypeCode().equals(MessageType.LOAT_THU_TUC_ROI_CANG)) {
						header = BusinessUtils.crateHeaderInland(tempDocument, MessageType.TAU_RA, FormatData.formatIntToString(PageType.DOCUMENT_TYPE_TU_CHOI),
								MessageType.HO_SO, userName, interfaceRequest);
						
						xmlData = businessUtils.sendMessageReject(header, "", ParamUtil.getString(resourceRequest, PageType.LY_DO_TU_CHOI),
								getOrganization(businessUtils, resourceRequest), getDevision(businessUtils, resourceRequest), userName, new Date(), tempDocument.getRequestCode());
					} else {
						header = BusinessUtils.crateHeader(tempDocument, MessageType.XUAT_CANH,
								FormatData.formatIntToString(PageType.DOCUMENT_TYPE_TU_CHOI), messageType, userName, interfaceRequest);
						
						xmlData = businessUtils.sendMessageReject(header, "", ParamUtil.getString(resourceRequest, PageType.LY_DO_TU_CHOI),
								getOrganization(businessUtils, resourceRequest), getDevision(businessUtils, resourceRequest), userName, new Date(), tempDocument.getRequestCode());
					}
					
					// Gui thong tin di.
					// xmlData = businessUtils.sendMessageAccept(header,
					// getOrganization(), getDevision(), userName, new Date());
//					xmlData = businessUtils.sendMessageReject(header, "", ParamUtil.getString(resourceRequest, PageType.LY_DO_TU_CHOI),
//							getOrganization(businessUtils, resourceRequest), getDevision(businessUtils, resourceRequest), userName, new Date());
					trangThaiBanKhai = TrangThaiBanKhaiXuatCanh.TU_CHOI_BAN_KHAI;
				}
				break;
			case PageType.ACTION_TYPE_DOI_CHIEU:
				_requestCode = CheckBusinessUtil.getRequestCode(_requestCode, (int) documentName, documentYear,
						MessageType.BAN_KHAI_DANH_SACH_THUYEN_VIEN);
				tempCrewList = TempCrewListLocalServiceUtil.findTempCrewListByRequestCode(_requestCode);
				
				if (tempCrewList != null) {
					if (tempCrewList.getRequestState() != TrangThaiBanKhaiXuatCanh.DOI_CHIEU) {
						
						// Gui thong tin di.
						xmlData = null;
						trangThaiBanKhai = TrangThaiBanKhaiXuatCanh.DOI_CHIEU;
					}
				}
				System.out.println("===Docname == " + tempDocument.getDocumentName()+ "==docYear==" + tempDocument.getDocumentYear() + "==RequestCode==" + requestCode);
				if(tempDocument.getDocumentTypeCode().equals(MessageType.LOAT_THU_TUC_VAO_CANG) || tempDocument.getDocumentTypeCode().equals(MessageType.LOAT_THU_TUC_ROI_CANG)) {
					ResultDeclaration resultDeclaration =  ResultDeclarationLocalServiceUtil.findbyDocumentNameAndBusinessTypeCodeAndDocumentYearRequestCode(MessageType.BAN_KHAI_DANH_SACH_THUYEN_VIEN, documentName, documentYear, _requestCode);
					if(resultDeclaration != null) {
						resultDeclaration.setRemarks(BusinessUtils.getRemarkChapNhan(userName));
						try {
							ResultDeclarationLocalServiceUtil.updateResultDeclaration(resultDeclaration);
						} catch (SystemException e) {
							System.out.println("Catch Update");
							e.printStackTrace();
						}
					} else {
						log.info("resultDeclaration is null");
					}
				}
				
				BusinessUtils.updateResultDeclaration(MessageType.BAN_KHAI_DANH_SACH_THUYEN_VIEN, documentName, documentYear,
						TrangThaiBanKhai.TRANG_THAI_BANG_KHAI_DOI_CHIEU);
				break;
		}
		
		if (trangThaiBanKhai > 0 || tempCrewList != null) {
			tempCrewList.setRequestState(trangThaiBanKhai);
			try {
				TempCrewListLocalServiceUtil.updateTempCrewList(tempCrewList);
			} catch (Exception e) {
				e.printStackTrace();
				log.equals(e);
			}
		}
		if (xmlData != null && xmlData.trim().length() > 0) {
			if (tempDocument.getDocumentTypeCode().equals(MessageType.LOAT_THU_TUC_VAO_CANG) || tempDocument.getDocumentTypeCode().equals(MessageType.LOAT_THU_TUC_ROI_CANG)) {
				guiBanTinSangHQMC_TauVaoRa(xmlData, businessUtils);
			}else {
				guiBanTinSangHQMC(xmlData, businessUtils);
			}
		}
		
		return result;
	}
	
	private boolean banKhaiDuTruCuaTau(long documentName, int messageType, int documentYear, int actionType, String userName, String requestCode,
			ActionRequest resourceRequest) {
		boolean result = false;
		TempShipStoresDeclaration tempShipStoresDeclaration = null;
		String _requestCode = requestCode;
		TempDocument tempDocument = null;
		InterfaceRequest interfaceRequest = null;
		Header header = null;
		BusinessUtils businessUtils = new BusinessUtils();
		String xmlData = "";
		int trangThaiBanKhai = 0;
		
		switch (actionType) {
			case PageType.ACTION_TYPE_TIEP_NHAN:
				_requestCode = CheckBusinessUtil.getRequestCode(_requestCode, (int) documentName, documentYear, MessageType.BAN_KHAI_DU_TRU_CUA_TAU);
				tempShipStoresDeclaration = TempShipStoresDeclarationLocalServiceUtil.findTempShipStoresDeclarationByRequestCode(_requestCode);
				
				if (tempShipStoresDeclaration != null) {
					tempDocument = TempDocumentLocalServiceUtil.findTemDocumentByDocumentNameDocumentYear(documentName, documentYear);
					interfaceRequest = InterfaceRequestLocalServiceUtil.findInterfaceRequestByRequestCode(_requestCode);
					header = BusinessUtils.crateHeader(tempDocument, MessageType.XUAT_CANH,
							FormatData.formatIntToString(PageType.DOCUMENT_TYPE_CHAP_NHAN), messageType, userName, interfaceRequest);
					
					// Gui thong tin di.
					xmlData = businessUtils.sendMessageAccept(header, getOrganization(businessUtils, resourceRequest),
							getDevision(businessUtils, resourceRequest), userName, new Date(), tempDocument.getRequestCode());
					trangThaiBanKhai = TrangThaiBanKhaiXuatCanh.CHAP_NHAN_BAN_KHAI;
				}
				break;
			case PageType.ACTION_TYPE_TU_CHOI:
				_requestCode = CheckBusinessUtil.getRequestCode(_requestCode, (int) documentName, documentYear, MessageType.BAN_KHAI_DU_TRU_CUA_TAU);
				tempShipStoresDeclaration = TempShipStoresDeclarationLocalServiceUtil.findTempShipStoresDeclarationByRequestCode(_requestCode);
				
				if (tempShipStoresDeclaration != null) {
					tempDocument = TempDocumentLocalServiceUtil.findTemDocumentByDocumentNameDocumentYear(documentName, documentYear);
					interfaceRequest = InterfaceRequestLocalServiceUtil.findInterfaceRequestByRequestCode(_requestCode);
					header = BusinessUtils.crateHeader(tempDocument, MessageType.XUAT_CANH,
							FormatData.formatIntToString(PageType.DOCUMENT_TYPE_TU_CHOI), messageType, userName, interfaceRequest);
					
					// Gui thong tin di.
					// xmlData = businessUtils.sendMessageAccept(header,
					// getOrganization(), getDevision(), userName, new Date());
					xmlData = businessUtils.sendMessageReject(header, "", ParamUtil.getString(resourceRequest, PageType.LY_DO_TU_CHOI),
							getOrganization(businessUtils, resourceRequest), getDevision(businessUtils, resourceRequest), userName, new Date(), tempDocument.getRequestCode());
					trangThaiBanKhai = TrangThaiBanKhaiXuatCanh.TU_CHOI_BAN_KHAI;
				}
				break;
		}
		
		if (trangThaiBanKhai > 0 || tempShipStoresDeclaration != null) {
			tempShipStoresDeclaration.setRequestState(trangThaiBanKhai);
			try {
				TempShipStoresDeclarationLocalServiceUtil.updateTempShipStoresDeclaration(tempShipStoresDeclaration);
			} catch (Exception e) {
				e.printStackTrace();
				log.equals(e);
			}
		}
		if (xmlData != null && xmlData.trim().length() > 0) {
			if (tempDocument.getDocumentTypeCode().equals(MessageType.LOAT_THU_TUC_VAO_CANG) || tempDocument.getDocumentTypeCode().equals(MessageType.LOAT_THU_TUC_ROI_CANG)) {
				guiBanTinSangHQMC_TauVaoRa(xmlData, businessUtils);
			}else {
				guiBanTinSangHQMC(xmlData, businessUtils);
			}
		}
		
		return result;
	}
	
	private boolean banKhaiDanhSachHanhLyHanhKhachRoiTau(long documentName, int messageType, int documentYear, int actionType, String userName,
			String requestCode, ActionRequest resourceRequest) {
		boolean result = false;
		TempCrewEffectsDeclaration tempCrewEffectsDeclaration = null;
		String _requestCode = requestCode;
		TempDocument tempDocument = null;
		InterfaceRequest interfaceRequest = null;
		Header header = null;
		BusinessUtils businessUtils = new BusinessUtils();
		String xmlData = "";
		int trangThaiBanKhai = 0;
		
		switch (actionType) {
			case PageType.ACTION_TYPE_TIEP_NHAN:
				_requestCode = CheckBusinessUtil.getRequestCode(_requestCode, (int) documentName, documentYear, MessageType.BAN_KHAI_HANG_HOA);
				tempCrewEffectsDeclaration = TempCrewEffectsDeclarationLocalServiceUtil.findTempCrewEffectsDeclarationByRequestCode(_requestCode);
				
				if (tempCrewEffectsDeclaration != null) {
					tempDocument = TempDocumentLocalServiceUtil.findTemDocumentByDocumentNameDocumentYear(documentName, documentYear);
					interfaceRequest = InterfaceRequestLocalServiceUtil.findInterfaceRequestByRequestCode(_requestCode);
					header = BusinessUtils.crateHeader(tempDocument, MessageType.XUAT_CANH,
							FormatData.formatIntToString(PageType.DOCUMENT_TYPE_CHAP_NHAN), messageType, userName, interfaceRequest);
					
					// Gui thong tin di.
					xmlData = businessUtils.sendMessageAccept(header, getOrganization(businessUtils, resourceRequest),
							getDevision(businessUtils, resourceRequest), userName, new Date(), tempDocument.getRequestCode());
					trangThaiBanKhai = TrangThaiBanKhaiXuatCanh.CHAP_NHAN_BAN_KHAI;
				}
				break;
			case PageType.ACTION_TYPE_TU_CHOI:
				_requestCode = CheckBusinessUtil.getRequestCode(_requestCode, (int) documentName, documentYear, MessageType.BAN_KHAI_HANG_HOA);
				tempCrewEffectsDeclaration = TempCrewEffectsDeclarationLocalServiceUtil.findTempCrewEffectsDeclarationByRequestCode(_requestCode);
				
				if (tempCrewEffectsDeclaration != null) {
					tempDocument = TempDocumentLocalServiceUtil.findTemDocumentByDocumentNameDocumentYear(documentName, documentYear);
					interfaceRequest = InterfaceRequestLocalServiceUtil.findInterfaceRequestByRequestCode(_requestCode);
					header = BusinessUtils.crateHeader(tempDocument, MessageType.XUAT_CANH,
							FormatData.formatIntToString(PageType.DOCUMENT_TYPE_TU_CHOI), messageType, userName, interfaceRequest);
					
					// Gui thong tin di.
					// xmlData = businessUtils.sendMessageAccept(header,
					// getOrganization(), getDevision(), userName, new Date());
					xmlData = businessUtils.sendMessageReject(header, "", ParamUtil.getString(resourceRequest, PageType.LY_DO_TU_CHOI),
							getOrganization(businessUtils, resourceRequest), getDevision(businessUtils, resourceRequest), userName, new Date(), tempDocument.getRequestCode());
					trangThaiBanKhai = TrangThaiBanKhaiXuatCanh.TU_CHOI_BAN_KHAI;
				}
				break;
		}
		
		if (trangThaiBanKhai > 0 || tempCrewEffectsDeclaration != null) {
			tempCrewEffectsDeclaration.setRequestState(trangThaiBanKhai);
			try {
				TempCrewEffectsDeclarationLocalServiceUtil.updateTempCrewEffectsDeclaration(tempCrewEffectsDeclaration);
			} catch (Exception e) {
				e.printStackTrace();
				log.equals(e);
			}
		}
		if (xmlData != null && xmlData.trim().length() > 0) {
			if (tempDocument.getDocumentTypeCode().equals(MessageType.LOAT_THU_TUC_VAO_CANG) || tempDocument.getDocumentTypeCode().equals(MessageType.LOAT_THU_TUC_ROI_CANG)) {
				guiBanTinSangHQMC_TauVaoRa(xmlData, businessUtils);
			}else {
				guiBanTinSangHQMC(xmlData, businessUtils);
			}
		}
		
		return result;
	}
	
	
	
	private boolean banKhaiThongBaoTauRoiCang(long documentName, int messageType, int documentYear, int actionType, String userName, String requestCodePortClearn,
			ActionRequest request) {
		
		boolean result = false;
		TempNoTiceShipMessage tempNoTiceShipMessage = null;
		String _requestCode = requestCodePortClearn;
		TempDocument tempDocument = null;
		InterfaceRequest interfaceRequest = null;
		Header header = null;
		BusinessUtils businessUtils = new BusinessUtils();
		String xmlData = "";
		int trangThaiBanKhai = 0;
		
		switch (actionType) {
			case PageType.ACTION_TYPE_TIEP_NHAN:
				_requestCode = CheckBusinessUtil.getRequestCode(_requestCode, (int) documentName, documentYear, MessageType.THONG_BAO_TAU_ROI_CANG);
				interfaceRequest = InterfaceRequestLocalServiceUtil.findInterfaceRequestByRequestCode(_requestCode);
				log.info("====call banKhaiThongBaoTauRoiCang=====_requestCode==" + _requestCode);
				tempNoTiceShipMessage = TempNoTiceShipMessageLocalServiceUtil.findTempNoTiceShipMessageByRequestCode(_requestCode);
				log.info("====call banKhaiThongBaoTauRoiCang=====tempNoTiceShipMessage==" + tempNoTiceShipMessage.toString());
				
				if (tempNoTiceShipMessage != null) {
					interfaceRequest.setRemarks(BusinessUtils.getRemarkChapNhan(userName));
					try {
						InterfaceRequestLocalServiceUtil.updateInterfaceRequest(interfaceRequest);
					} catch (SystemException e1) {
						
						e1.printStackTrace();
					}
					tempDocument = TempDocumentLocalServiceUtil.findTemDocumentByDocumentNameDocumentYear(documentName, documentYear);
					
					header = BusinessUtils.crateHeader(tempDocument, MessageType.XUAT_CANH,
							FormatData.formatIntToString(PageType.DOCUMENT_TYPE_CHAP_NHAN), messageType, userName, interfaceRequest);
					
					// Gui thong tin di.
					xmlData = businessUtils.sendMessageAccept(header, getOrganization(businessUtils, request),
							getDevision(businessUtils, request), userName, new Date(), tempDocument.getRequestCode());
					trangThaiBanKhai = TrangThaiBanKhaiXuatCanh.CHAP_NHAN_BAN_KHAI;
					BusinessUtils.updateResultDeclaration(MessageType.THONG_BAO_TAU_ROI_CANG, tempDocument.getDocumentName(),
							tempDocument.getDocumentYear(), TrangThaiBanKhai.TRANG_THAI_BANG_KHAI_TIEP_NHAN);
				}
				break;
			case PageType.ACTION_TYPE_TU_CHOI:
				String lyDoTuChoi = ParamUtil.getString(request, PageType.LY_DO_TU_CHOI);
				if (lyDoTuChoi == null || lyDoTuChoi.length() == 0) {
					lyDoTuChoi = "System";
				}
				_requestCode = CheckBusinessUtil.getRequestCode(_requestCode, (int) documentName, documentYear, MessageType.THONG_BAO_TAU_ROI_CANG);
				interfaceRequest = InterfaceRequestLocalServiceUtil.findInterfaceRequestByRequestCode(_requestCode);
				tempNoTiceShipMessage = TempNoTiceShipMessageLocalServiceUtil.findTempNoTiceShipMessageByRequestCode(_requestCode);
				
				if (tempNoTiceShipMessage != null) {
					interfaceRequest.setRemarks(BusinessUtils.getRemarkTuChoi(userName, lyDoTuChoi));
					try {
						InterfaceRequestLocalServiceUtil.updateInterfaceRequest(interfaceRequest);
					} catch (SystemException e1) {
						
						e1.printStackTrace();
					}
					tempDocument = TempDocumentLocalServiceUtil.findTemDocumentByDocumentNameDocumentYear(documentName, documentYear);
					
					header = BusinessUtils.crateHeader(tempDocument, MessageType.XUAT_CANH,
							FormatData.formatIntToString(PageType.DOCUMENT_TYPE_TU_CHOI), messageType, userName, interfaceRequest);
					
					// Gui thong tin di.
					xmlData = businessUtils.sendMessageReject(header, "", ParamUtil.getString(request, PageType.LY_DO_TU_CHOI),
							getOrganization(businessUtils, request), getDevision(businessUtils, request), userName, new Date(), tempDocument.getRequestCode());
					trangThaiBanKhai = TrangThaiBanKhaiXuatCanh.TU_CHOI_BAN_KHAI;
					BusinessUtils.updateResultDeclaration(MessageType.THONG_BAO_TAU_ROI_CANG, tempDocument.getDocumentName(),
							tempDocument.getDocumentYear(), TrangThaiBanKhai.TRANG_THAI_BANG_KHAI_TU_CHOI);
				}
				break;
			case PageType.ACTION_TYPE_HUY:
				_requestCode = CheckBusinessUtil.getRequestCode(_requestCode, (int) documentName, documentYear, MessageType.THONG_BAO_TAU_ROI_CANG);
				tempNoTiceShipMessage = TempNoTiceShipMessageLocalServiceUtil.findTempNoTiceShipMessageByRequestCode(_requestCode);
				
				if (tempNoTiceShipMessage != null) {
					if (tempNoTiceShipMessage.getRequestState() == TrangThaiBanKhaiXuatCanh.CHAP_NHAN_BAN_KHAI) {
						tempDocument = TempDocumentLocalServiceUtil.findTemDocumentByDocumentNameDocumentYear(documentName, documentYear);
						// Gui thong tin di.
						xmlData = null;
						trangThaiBanKhai = TrangThaiBanKhaiXuatCanh.KHAI_HUY;
					}
				}
				break;
		}
		
		if (trangThaiBanKhai > 0 || tempNoTiceShipMessage != null) {
			tempNoTiceShipMessage.setRequestState(trangThaiBanKhai);
			try {
				TempNoTiceShipMessageLocalServiceUtil.updateTempNoTiceShipMessage(tempNoTiceShipMessage);
				
			} catch (Exception e) {
				e.printStackTrace();
				log.equals(e);
			}
			
		}
		if (xmlData != null && xmlData.trim().length() > 0) {
			if (tempDocument.getDocumentTypeCode().equals(MessageType.LOAT_THU_TUC_VAO_CANG) || tempDocument.getDocumentTypeCode().equals(MessageType.LOAT_THU_TUC_ROI_CANG)) {
				guiBanTinSangHQMC_TauVaoRa(xmlData, businessUtils);
			}else {
				guiBanTinSangHQMC(xmlData, businessUtils);
			}
		}
		
		return result;
	}
	
	private boolean banKhaiChung(long documentName, int messageType, int documentYear, int actionType, String userName, String requestCode,
			ActionRequest resourceRequest) {
		boolean result = false;
		TempGeneralDeclaration tempGeneralDeclaration = null;
		String _requestCode = requestCode;
		TempDocument tempDocument = null;
		InterfaceRequest interfaceRequest = null;
		Header header = null;
		BusinessUtils businessUtils = new BusinessUtils();
		String xmlData = "";
		int trangThaiBanKhai = 0;
		tempDocument = TempDocumentLocalServiceUtil.findTemDocumentByDocumentNameDocumentYear(documentName, documentYear);
		log.info("====call banKhaiThongBaoTauRoiCang=====_requestCode==" + _requestCode);
		switch (actionType) {
			case PageType.ACTION_TYPE_TIEP_NHAN:
				_requestCode = CheckBusinessUtil.getRequestCode(_requestCode, (int) documentName, documentYear, MessageType.BAN_KHAI_CHUNG);
				tempGeneralDeclaration = TempGeneralDeclarationLocalServiceUtil.findTempGeneralDeclarationByRequestCode(_requestCode);
				log.info("====call tempGeneralDeclaration=====_requestCode==" + tempGeneralDeclaration);
				
				if (tempGeneralDeclaration != null) {
					
					interfaceRequest = InterfaceRequestLocalServiceUtil.findInterfaceRequestByRequestCode(_requestCode);
					
					if (interfaceRequest != null) {
						try {
							interfaceRequest.setRemarks(BusinessUtils.getRemarkChapNhan(userName));
							InterfaceRequestLocalServiceUtil.updateInterfaceRequest(interfaceRequest);
						} catch (Exception e) {
							
						}
					}
					
					if(tempDocument.getDocumentTypeCode().equals(MessageType.LOAT_THU_TUC_ROI_CANG)) {
						header = BusinessUtils.crateHeaderInland(tempDocument, MessageType.TAU_RA,
								FormatData.formatIntToString(PageType.DOCUMENT_TYPE_CHAP_NHAN), messageType, userName, interfaceRequest);
					} else {
						header = BusinessUtils.crateHeader(tempDocument, MessageType.XUAT_CANH,
								FormatData.formatIntToString(PageType.DOCUMENT_TYPE_CHAP_NHAN), messageType, userName, interfaceRequest);
					}
					
					
					
					// Gui thong tin di.
					xmlData = businessUtils.sendMessageAccept(header, getOrganization(businessUtils, resourceRequest),
							getDevision(businessUtils, resourceRequest), userName, new Date(), tempDocument.getRequestCode());
					trangThaiBanKhai = TrangThaiBanKhaiXuatCanh.CHAP_NHAN_BAN_KHAI;
				}
				break;
			case PageType.ACTION_TYPE_TU_CHOI:
				//log.info("VAO TU CHOIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII");
				_requestCode = CheckBusinessUtil.getRequestCode(_requestCode, (int) documentName, documentYear, MessageType.BAN_KHAI_CHUNG);
				tempGeneralDeclaration = TempGeneralDeclarationLocalServiceUtil.findTempGeneralDeclarationByRequestCode(_requestCode);
				
				if (tempGeneralDeclaration != null) {
					tempDocument = TempDocumentLocalServiceUtil.findTemDocumentByDocumentNameDocumentYear(documentName, documentYear);
					interfaceRequest = InterfaceRequestLocalServiceUtil.findInterfaceRequestByRequestCode(_requestCode);
					if (interfaceRequest != null) {
						try {
							interfaceRequest.setRemarks(BusinessUtils.getRemarkTuChoi(userName,
									ParamUtil.getString(resourceRequest, PageType.LY_DO_TU_CHOI)));
							
							InterfaceRequestLocalServiceUtil.updateInterfaceRequest(interfaceRequest);
						} catch (Exception e) {
							
						}
					}
					
					if(tempDocument.getDocumentTypeCode().equals(MessageType.LOAT_THU_TUC_ROI_CANG)) {
						header = BusinessUtils.crateHeaderInland(tempDocument, MessageType.TAU_RA, FormatData.formatIntToString(PageType.DOCUMENT_TYPE_TU_CHOI),
								MessageType.HO_SO, userName, interfaceRequest);
						
						xmlData = businessUtils.sendMessageReject(header, "", ParamUtil.getString(resourceRequest, PageType.LY_DO_TU_CHOI),
								getOrganization(businessUtils, resourceRequest), getDevision(businessUtils, resourceRequest), userName, new Date(), tempDocument.getRequestCode());
					} else {
						header = BusinessUtils.crateHeader(tempDocument, MessageType.XUAT_CANH,
								FormatData.formatIntToString(PageType.DOCUMENT_TYPE_TU_CHOI), messageType, userName, interfaceRequest);
						
						xmlData = businessUtils.sendMessageReject(header, "", ParamUtil.getString(resourceRequest, PageType.LY_DO_TU_CHOI),
								getOrganization(businessUtils, resourceRequest), getDevision(businessUtils, resourceRequest), userName, new Date(), tempDocument.getRequestCode());
					}
					
					// Gui thong tin di.
					// xmlData = businessUtils.sendMessageAccept(header,
					// getOrganization(), getDevision(), userName, new Date());
//					xmlData = businessUtils.sendMessageReject(header, "", ParamUtil.getString(resourceRequest, PageType.LY_DO_TU_CHOI),
//							getOrganization(businessUtils, resourceRequest), getDevision(businessUtils, resourceRequest), userName, new Date());
					trangThaiBanKhai = TrangThaiBanKhaiXuatCanh.TU_CHOI_BAN_KHAI;
				}
				break;
			case PageType.ACTION_TYPE_DOI_CHIEU:
				_requestCode = CheckBusinessUtil.getRequestCode(_requestCode, (int) documentName, documentYear, MessageType.BAN_KHAI_CHUNG);
				tempGeneralDeclaration = TempGeneralDeclarationLocalServiceUtil.findTempGeneralDeclarationByRequestCode(_requestCode);
				//log.info("PageType.ACTION_TYPE_DOI_CHIEU  " + PageType.ACTION_TYPE_DOI_CHIEU);
				if (tempGeneralDeclaration != null) {
					if (tempGeneralDeclaration.getRequestState() != TrangThaiBanKhaiXuatCanh.DOI_CHIEU) {
						
						// Gui thong tin di.
						xmlData = null;
						trangThaiBanKhai = TrangThaiBanKhaiXuatCanh.DOI_CHIEU;
					}
				}
				System.out.println("===Docname == " + tempDocument.getDocumentName()+ "==docYear==" + tempDocument.getDocumentYear() + "==RequestCode==" + requestCode);
				if(tempDocument.getDocumentTypeCode().equals(MessageType.LOAT_THU_TUC_VAO_CANG) || tempDocument.getDocumentTypeCode().equals(MessageType.LOAT_THU_TUC_ROI_CANG)) {
					ResultDeclaration resultDeclaration =  ResultDeclarationLocalServiceUtil.findbyDocumentNameAndBusinessTypeCodeAndDocumentYearRequestCode(MessageType.BAN_KHAI_CHUNG, documentName, documentYear, _requestCode);
					
					if(resultDeclaration != null) {
						resultDeclaration.setRemarks(BusinessUtils.getRemarkChapNhan(userName));
						try {
							ResultDeclarationLocalServiceUtil.updateResultDeclaration(resultDeclaration);
						} catch (SystemException e) {
							System.out.println("Catch Update");
							e.printStackTrace();
						}
					} else {
						log.info("resultDeclaration is null");
					}
				}

				BusinessUtils.updateResultDeclaration(MessageType.BAN_KHAI_CHUNG, documentName, documentYear,
						TrangThaiBanKhai.TRANG_THAI_BANG_KHAI_DOI_CHIEU);
				break;
		}
		
		if (trangThaiBanKhai > 0 || tempGeneralDeclaration != null) {
			tempGeneralDeclaration.setRequestState(trangThaiBanKhai);
			try {
				TempGeneralDeclarationLocalServiceUtil.updateTempGeneralDeclaration(tempGeneralDeclaration);
			} catch (Exception e) {
				e.printStackTrace();
				log.equals(e);
			}
		}
		if (xmlData != null && xmlData.trim().length() > 0) {
			if (tempDocument.getDocumentTypeCode().equals(MessageType.LOAT_THU_TUC_VAO_CANG) || tempDocument.getDocumentTypeCode().equals(MessageType.LOAT_THU_TUC_ROI_CANG)) {
				guiBanTinSangHQMC_TauVaoRa(xmlData, businessUtils);
			}else {
				guiBanTinSangHQMC(xmlData, businessUtils);
			}
		}
		
		return result;
	}
	
	// private int checkFunction(InterfaceRequest interfaceRequest,
	// TempNoTiceShipMessage tempNoTiceShipMessage) {
	// if (interfaceRequest == null) {
	// return TrangThaiBanKhaiXuatCanh.KHAI_MOI;
	// } else {
	// if (interfaceRequest.getRequestVersion() == null) {
	// return TrangThaiBanKhaiXuatCanh.KHAI_MOI;
	// } else {
	// if (tempNoTiceShipMessage.getRequestState() ==
	// TrangThaiBanKhaiXuatCanh.YEU_CAU_DUOC_GHI_VAO_HE_THONG) {
	// return TrangThaiBanKhaiXuatCanh.KHAI_MOI;
	// } else if (tempNoTiceShipMessage.getRequestState() ==
	// TrangThaiBanKhaiXuatCanh.CHAP_NHAN_BAN_KHAI) {
	// return TrangThaiBanKhaiXuatCanh.KHAI_SUA;
	// } else if (tempNoTiceShipMessage.getRequestState() ==
	// TrangThaiBanKhaiXuatCanh.TU_CHOI_BAN_KHAI) {
	// return TrangThaiBanKhaiXuatCanh.SUA_DOI_BO_XUNG;
	// }
	// }
	// }
	//
	// return TrangThaiBanKhaiXuatCanh.KHAI_MOI;
	// }
	
	private String getOrganization(BusinessUtils businessUtils, ActionRequest resourceRequest) {
		return BusinessUtils.getOrganizationFromUser(resourceRequest);
	}
	
	private String getDevision(BusinessUtils businessUtils, ActionRequest resourceRequest) {
		
		return businessUtils.getDivision(resourceRequest);
	}
	
	private void guiBanTinSangHQMC(String xmlData, BusinessUtils businessUtils) {
		try {
			businessUtils.insertHistorySendMessage(xmlData);
			log.info("==guiBanTinSangHQMC receiveResultFromMT ==xmlData==");
			//log.info(xmlData);
			
			IMTService imtService = CallWs2HaiQuan.getIMTSercice();
			String xmlReceive = imtService.receiveResultFromMT(xmlData);
			
			log.info("==guiBanTinSangHQMC==xmlReceive==");
			//log.info(xmlReceive);
			
			businessUtils.insertHistoryReceiveMessageResponse(xmlReceive);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}
	}
	
	private void guiBanTinSangHQMC_TauVaoRa(String xmlData, BusinessUtils businessUtils) {
		try {
			businessUtils.insertHistorySendMessage(xmlData);
			log.info("==guiBanTinSangHQMC  receiveFromInland ==xmlData==");
			//log.info(xmlData);
			
			IMTService imtService = CallWs2HaiQuan.getIMTSercice();
			String xmlReceive = imtService.receiveFromInland(xmlData);
			
			log.info("==guiBanTinSangHQMC==xmlReceive==");
			//log.info(xmlReceive);
			
			businessUtils.insertHistoryReceiveMessageResponse(xmlReceive);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}
	}	
	
	private boolean thuTucActionGiayPhepRoiCangChoTauDen(String userLogin, long documentName, int messageType, int documentYear, int actionType, String userName,
			String requestCodePortClearance, ActionRequest request, ActionResponse resqonse) throws SystemException {
		
		boolean result = false;
		TempDocument tempDocument = null;
		InterfaceRequest interfaceRequest = null;
		Header header = null;
		BusinessUtils businessUtils = new BusinessUtils();
		// MessageFactory messageFactory = new MessageFactory();
		String xmlData = "";
		
//		log.info("==thuTucActionGiayPhepRoiCangChoTauDen=messageType===" + messageType + "====documentName===" + documentName + "====requestCodePortClearance===="
//				+ requestCodePortClearance);
		
		switch (actionType) {
			case PageType.ACTION_TYPE_TIEP_NHAN:
				
//				log.info("===START====ACTION_TYPE_TIEP_NHAN====documentName===" + documentName + "===messageType===" + messageType
//						+ "===requestCodePortClearance===" + requestCodePortClearance);
				
				taoGiayPhepRoiCang(documentName, messageType, documentYear, actionType, userName, requestCodePortClearance, request, resqonse);
				String lyDoCapLai = ParamUtil.getString(request, "lyDoCapLaiPortClearance");
				log.info("==thuTucActionGiayPhepRoiCangChoTauDen==lyDoCapLai==" + lyDoCapLai);
				
				InterfaceRequest interfacePortClearance = InterfaceRequestLocalServiceUtil.findByRequestCode(requestCodePortClearance);
				if (interfacePortClearance != null) {
					String issueDate = ParamUtil.getString(request, "issueDate");
					String remarkCapLai = BusinessUtils.getRemarkCapLai(userName, lyDoCapLai, FormatData.parseDateShort3StringToDate(issueDate));
					interfacePortClearance.setRemarks(remarkCapLai);
					InterfaceRequestLocalServiceUtil.updateInterfaceRequest(interfacePortClearance);
				}
				
				break;
			
			case PageType.ACTION_TYPE_SUA:
				
//				log.info("===START====ACTION_TYPE_SUA====documentName===" + documentName + "===messageType===" + messageType
//						+ "===requestCodePortClearance===" + requestCodePortClearance);
				
				taoGiayPhepRoiCang(documentName, messageType, documentYear, actionType, userName, requestCodePortClearance, request, resqonse);
				break;
			
			case PageType.ACTION_TYPE_DUYET:
				
				// _requestCode = CheckBusinessUtil.getRequestCode(requestCode,
				// (int) documentName, documentYear,
				// MessageType.GIAY_PHEP_ROI_CANG_BO_GTVT_CAP_KHI_XUAT_CANH);
				PortClearance2Xml portClearance2Xml = new PortClearance2Xml();
				tempDocument = TempDocumentLocalServiceUtil.findTemDocumentByDocumentNameDocumentYear(documentName, documentYear);
				if (tempDocument.getDocumentTypeCode().equals("5"))  {
					
					InlandPortClearance portClearance = portClearance2Xml.convertXMLPortClearanceInland(requestCodePortClearance);
					//InlandPortClearance inlandPortClearance = 
					
					if (portClearance != null) {
						if (portClearance.getPortofAuthority() != null && portClearance.getPortofAuthority().length() > 0) {
							DmMaritime dmMaritime = DmMaritimeLocalServiceUtil.getByMaritimeCode(portClearance.getPortofAuthority());
							if (dmMaritime != null) {
								portClearance.setPortofAuthority(dmMaritime.getMaritimeReference());
							}
						}
						
						
						
						if (tempDocument.getDocumentStatusCode() != TrangThaiBanKhaiXuatCanh.PHE_DUYET_HOAN_THANH_THU_TUC) {
							
							xacNhanHoanThanhThuTucXuatCanh(request, documentName, documentYear);
							
							tempDocument.setDocumentStatusCode(TrangThaiBanKhaiXuatCanh.PHE_DUYET_HOAN_THANH_THU_TUC);
							
							if (tempDocument != null) {
								TempDocumentLocalServiceUtil.updateTempDocument(tempDocument);
							}
							
						}
						
						IssuePortClearance portClearanceDuyet = IssuePortClearanceLocalServiceUtil.getByRequestCode(requestCodePortClearance);
						
						if (Validator.isNotNull(portClearanceDuyet.getRequestState())) {
							
							// TODO Xuat canh truong hop duyet
							portClearanceDuyet.setIsApproval(PageType.DUYET_PHE_CHUAN);
							portClearanceDuyet.setApprovalDate(new Date());
							portClearanceDuyet.setApprovalName(userName);
							
							portClearanceDuyet.setRequestState(TrangThaiBanKhaiXuatCanh.CHAP_NHAN_BAN_KHAI);
							IssuePortClearanceLocalServiceUtil.updateIssuePortClearance(portClearanceDuyet);
						}
						
						interfaceRequest = InterfaceRequestLocalServiceUtil.findInterfaceRequestByRequestCode(tempDocument.getRequestCode());
						header = BusinessUtils.crateHeader(tempDocument, MessageType.TAU_RA, MessageType.FUNCTION_KHAI_BAO, messageType, userName,
								interfaceRequest);
						header.getReference().setVersion(portClearanceDuyet.getVersionNo());
						
//						log.info("====ACTION_TYPE_DUYET_ GIAY PHEP ROI CANG====REQUEST_CODE====" + requestCodePortClearance
//								+ "====getNextPortOfCallCode===" + portClearance.getNextPortOfCallCode());
						
						// Gui thong tin di.
						xmlData = businessUtils.createContentSendFromBGTVTToNSWInland(header, MessageFactory.convertObjectToXml(portClearance));						
											
				}
				}else {
				
					
				
					PortClearance portClearance = portClearance2Xml.convertXMLPortClearance(requestCodePortClearance);
				//InlandPortClearance inlandPortClearance = 
				
				if (portClearance != null) {
					if (portClearance.getPortofAuthority() != null && portClearance.getPortofAuthority().length() > 0) {
						DmMaritime dmMaritime = DmMaritimeLocalServiceUtil.getByMaritimeCode(portClearance.getPortofAuthority());
						if (dmMaritime != null) {
							portClearance.setPortofAuthority(dmMaritime.getMaritimeReference());
						}
					}
					
				//	tempDocument = TempDocumentLocalServiceUtil.findTemDocumentByDocumentNameDocumentYear(documentName, documentYear);
					
					if (tempDocument.getDocumentStatusCode() != TrangThaiBanKhaiXuatCanh.PHE_DUYET_HOAN_THANH_THU_TUC) {
						
						xacNhanHoanThanhThuTucXuatCanh(request, documentName, documentYear);
						
						tempDocument.setDocumentStatusCode(TrangThaiBanKhaiXuatCanh.PHE_DUYET_HOAN_THANH_THU_TUC);
						
						if (tempDocument != null) {
							TempDocumentLocalServiceUtil.updateTempDocument(tempDocument);
						}
						
					}
					
					IssuePortClearance portClearanceDuyet = IssuePortClearanceLocalServiceUtil.getByRequestCode(requestCodePortClearance);
					
					if (Validator.isNotNull(portClearanceDuyet.getRequestState())) {
						
						// TODO Xuat canh truong hop duyet
						portClearanceDuyet.setIsApproval(PageType.DUYET_PHE_CHUAN);
						portClearanceDuyet.setApprovalDate(new Date());
						portClearanceDuyet.setApprovalName(userName);
						
						portClearanceDuyet.setRequestState(TrangThaiBanKhaiXuatCanh.CHAP_NHAN_BAN_KHAI);
						IssuePortClearanceLocalServiceUtil.updateIssuePortClearance(portClearanceDuyet);
					}
					
					interfaceRequest = InterfaceRequestLocalServiceUtil.findInterfaceRequestByRequestCode(tempDocument.getRequestCode());
					header = BusinessUtils.crateHeader(tempDocument, MessageType.XUAT_CANH, MessageType.FUNCTION_KHAI_BAO, messageType, userName,
							interfaceRequest);
					header.getReference().setVersion(portClearanceDuyet.getVersionNo());
					
//					log.info("====ACTION_TYPE_DUYET_ GIAY PHEP ROI CANG====REQUEST_CODE====" + requestCodePortClearance
//							+ "====getNextPortOfCallCode===" + portClearance.getNextPortOfCallCode());
					
					// Gui thong tin di.
					xmlData = businessUtils.createContentSendFromBGTVTToNSW(header, MessageFactory.convertObjectToXml(portClearance));					
				}
				}
					
					
					
					
					
					
					//log.info("==thuTucGiayPhepRoiCangChoTauDen==interfaceRequest==" + (Validator.isNull(interfaceRequest) ? "==NULL==" : "==not null==="));

				
					
				
				break;
				
				case PageType.ACTION_TYPE_KYSODUYET:
				
				log.info("=====xuLyGiayPhepxuat canh==ACTION_");
				tempDocument = TempDocumentLocalServiceUtil.findTemDocumentByDocumentNameDocumentYear(documentName, documentYear);
				IssuePortClearance portClearanceDuyet = IssuePortClearanceLocalServiceUtil.getByRequestCode(requestCodePortClearance);
				long addkyso = ParamUtil.getLong(request, "fileId");
				
				if (Validator.isNotNull(portClearanceDuyet)) {
					log.info("=====xuLyGiayPhepxuat canh==ACTION_TYPE_KYSODUYET ");
					portClearanceDuyet.setRequestState(TrangThaiBanKhaiXuatCanh.CHAP_NHAN_BAN_KHAI);
				//	perForTransitDuyetkyso.setIsApproval(PageType.DUYET_PHE_CHUAN);
					portClearanceDuyet.setApprovalDate(new Date());
					portClearanceDuyet.setApprovalName(userName);
					
					portClearanceDuyet.setStampStatus(1);
					portClearanceDuyet.setSignTitle(portClearanceDuyet.getRepresentative());
					portClearanceDuyet.setSignName(ParamUtil.getString(request, "signName"));
					portClearanceDuyet.setSignPlace(ParamUtil.getString(request, "signPlace"));
					portClearanceDuyet.setSignDate(ParamUtil.getDate(request, "signDate", FormatData.formatDateShort3));
					if (addkyso > 0 ){
						portClearanceDuyet.setAttachedFile(ParamUtil.getLong(request, "fileId"));
					}
					
					
				
					IssuePortClearanceLocalServiceUtil.updateIssuePortClearance(portClearanceDuyet);
					tempDocument.setDocumentStatusCode(TrangThaiBanKhaiXuatCanh.DE_NGHI_CAP_GIAY_PHEP);
				

					if (tempDocument != null) {
						TempDocumentLocalServiceUtil.updateTempDocument(tempDocument);
					}
					
					log.info("=====xuLyGiayPhepxuat canh==tempDocument "+tempDocument);
//					thuTucSendMessageGiayPhepQuaCanh(MessageType.GIAY_PHEP_QUA_CANH, perForTransitDuyetkyso.getVersionNo(), actionType, temp, userName,
//							requestCodeGiayPhepQuaCanh, request, response);
//					log.info("GUI=====GIAY_PHEP_QUA_CANH=====requestCode====" + requestCodeGiayPhepQuaCanh);
				}
				break;
				
			case PageType.ACTION_TYPE_DONGDAUDUYET:
				
				PortClearance2Xml portClearance2XmlDD = new PortClearance2Xml();
				PortClearance portClearanceDD = portClearance2XmlDD.convertXMLPortClearance(requestCodePortClearance);
				
				if (portClearanceDD != null) {
					if (portClearanceDD.getPortofAuthority() != null && portClearanceDD.getPortofAuthority().length() > 0) {
						log.info("==== chinh **************portClearance != null  7777*********** DUYET");
						DmMaritime dmMaritime = DmMaritimeLocalServiceUtil.getByMaritimeCode(portClearanceDD.getPortofAuthority());
						if (dmMaritime != null) {
							log.info("==== chinh **************dmMaritime != null*********** DUYET");
							portClearanceDD.setPortofAuthority(dmMaritime.getMaritimeReference());
						}
					}
				
				
				log.info("=====xuLyGiayPhepQuaCanh==ACTION_TYPE_DUYET");
				tempDocument = TempDocumentLocalServiceUtil.findTemDocumentByDocumentNameDocumentYear(documentName, documentYear);
				IssuePortClearance portClearanceDuyetDD = IssuePortClearanceLocalServiceUtil.getByRequestCode(requestCodePortClearance);
				long adddongdau = ParamUtil.getLong(request, "fileId");
				if (Validator.isNotNull(portClearanceDuyetDD)) {
					
					portClearanceDuyetDD.setRequestState(TrangThaiBanKhaiQuaCanh.CHAP_NHAN_BAN_KHAI);
				//	perForTransitDuyetkyso.setIsApproval(PageType.DUYET_PHE_CHUAN);
					portClearanceDuyetDD.setApprovalDate(new Date());
					portClearanceDuyetDD.setApprovalName(userName);
					
					portClearanceDuyetDD.setStampStatus(2);
					
					if (adddongdau > 0 ){
						portClearanceDuyetDD.setAttachedFile(ParamUtil.getLong(request, "fileId"));
					}
					
					IssuePortClearanceLocalServiceUtil.updateIssuePortClearance(portClearanceDuyetDD);
					

					tempDocument.setDocumentStatusCode(TrangThaiBanKhaiQuaCanh.PHE_DUYET_HOAN_THANH_THU_TUC);

					if (tempDocument != null) {
						TempDocumentLocalServiceUtil.updateTempDocument(tempDocument);
					}
					
//					thuTucSendMessageGiayPhepQuaCanh(MessageType.GIAY_PHEP_QUA_CANH, perForTransitDuyetkyso.getVersionNo(), actionType, temp, userName,
//							requestCodeGiayPhepQuaCanh, request, response);
//					log.info("GUI=====GIAY_PHEP_QUA_CANH=====requestCode====" + requestCodeGiayPhepQuaCanh);
				
				
					
				
					log.info("==guiBanTinSangHQMC==xmlReceive chinh 25/12/2015==");
				
					}
				header = BusinessUtils.crateHeader(tempDocument, MessageType.XUAT_CANH, MessageType.FUNCTION_KHAI_BAO, messageType, userName,
						interfaceRequest);
				header.getReference().setVersion(portClearanceDuyetDD.getVersionNo());
				xmlData = businessUtils.createContentSendFromBGTVTToNSW(header, MessageFactory.convertObjectToXml(portClearanceDD));
			}
				break;

			
			case PageType.ACTION_TYPE_HUY:
				
				// _requestCode = CheckBusinessUtil.getRequestCode(_requestCode,
				// (int) documentName, documentYear,
				// MessageType.GIAY_PHEP_ROI_CANG_BO_GTVT_CAP_KHI_XUAT_CANH);
				String lyDoHuyXC = ParamUtil.getString(request, PageType.HUY_HO_SO);
				
				if (lyDoHuyXC == null || lyDoHuyXC.length() == 0) {
					lyDoHuyXC = "lyDoHuyXC";
				}
				log.info("===========lyDoHuyXC=========================" + lyDoHuyXC);
				
				tempDocument = TempDocumentLocalServiceUtil.findTemDocumentByDocumentNameDocumentYear(documentName, documentYear);
				tempDocument.setDocumentStatusCode(TrangThaiBanKhaiXuatCanh.HUY_THU_TUC_TAU_THUYEN_XUAT_CANH);
				TempDocumentLocalServiceUtil.updateTempDocument(tempDocument);
				
				List<IssuePortClearance> lstPortClearances = IssuePortClearanceLocalServiceUtil.findByDocumentYearAndDocumentYearOrderByColumn(
						documentName, documentYear, KeyParams.VERSION_NO, KeyParams.ORDER_BY_DESC);
				
				for (IssuePortClearance object : lstPortClearances) {
					object.setRequestState(TrangThaiBanKhaiXuatCanh.KHAI_HUY);
					IssuePortClearanceLocalServiceUtil.updateIssuePortClearance(object);
				}
				
				//dung.le handsome edit
				if(tempDocument.getDocumentTypeCode().equals(MessageType.LOAT_THU_TUC_ROI_CANG)) {
					header = BusinessUtils.crateHeaderInland(tempDocument, MessageType.TAU_RA, MessageType.FUNCTION_KHAI_HUY_HO_SO,
							MessageType.HUY_GIAY_PHEP_ROI_CANG, userName, interfaceRequest);
				} else {
					header = BusinessUtils.crateHeader(tempDocument, MessageType.XUAT_CANH, MessageType.FUNCTION_KHAI_HUY_HO_SO,
							MessageType.HUY_GIAY_PHEP_ROI_CANG, userName, interfaceRequest);
				}
				
//				xmlData = businessUtils.sendMessageHuyHoSo(header, BusinessUtils.getOrganizationFromUser(request),
//						businessUtils.getDivision(request), header.getFrom().getName(), new Date(), lyDoHuyXC);
				
				xmlData = businessUtils.sendMessageHuyHoSoNew(header, BusinessUtils.getOrganizationFromUser(request),
						businessUtils.getDivision(request), header.getFrom().getName(), new Date(), lyDoHuyXC, tempDocument.getRequestCode());
				
				// TODO update Result Notification
				BusinessUtils.updateLyDoResultNotification(userLogin, lyDoHuyXC, MessageType.HUY_GIAY_PHEP_ROI_CANG, tempDocument.getMaritimeCode(),
						documentName, documentYear);
				
				List<IssuePortClearance> lissuePortClearances = IssuePortClearanceLocalServiceUtil
						.findIssuePortClearanceByDocumentYearAndDocumentYear(documentName, documentYear);
				
				if (lissuePortClearances != null && lissuePortClearances.size() > 0) {
					
					for (IssuePortClearance issue : lissuePortClearances) {
						
						issue.setIsCancel(1);
						issue.setCancelName(userLogin);
						issue.setCancelNote(lyDoHuyXC);
						issue.setCancelDate(new Date());
						IssuePortClearanceLocalServiceUtil.updateIssuePortClearance(issue);
					}
				}
				break;
		}
		
		if (xmlData != null && xmlData.trim().length() > 0) {
			//guiBanTinSangHQMC(xmlData, businessUtils);
			try {
				String  uid="BGTVT" + Long.toString(System.currentTimeMillis());
				businessUtils.insertHistorySendMessageThreeIssue(xmlData, userName, uid);
				log.info("==guiBanTinSangHQMC==xmlData==");
				log.info(xmlData);
				
				IMTService imtService = CallWs2HaiQuan.getIMTSercice();
				String xmlReceive = "";
		
				
				if( tempDocument.getDocumentTypeCode().equals(MessageType.LOAT_THU_TUC_VAO_CANG) || tempDocument.getDocumentTypeCode().equals(MessageType.LOAT_THU_TUC_ROI_CANG)){
					log.info(" ----CAll receiveFromInland------- ");
				//	xmlReceive = imtService.receiveFromInland(xmlData);
					
				}else{
					log.info(" ----CAll receiveResultFromMT------- ");
				//	xmlReceive = imtService.receiveResultFromMT(xmlData);
				}				
				log.info("==guiBanTinSangHQMC==xmlReceive==");
//				log.info(xmlReceive);
				
				businessUtils.insertHistoryReceiveMessageResponse(xmlReceive);
			} catch (Exception e) {
				e.printStackTrace();
				log.error(e);
			}
		}
		
		return result;
	}
	
	private IssuePortClearance taoGiayPhepRoiCang(long documentName, int messageType, int documentYear, int actionType, String userName,
			String requestCode, ActionRequest resourceRequest, ActionResponse httpReq) {
		
		try {
			
			// Giay phep roi cang so
			String numberPortClearance = ParamUtil.getString(resourceRequest, "numberPortClearance");
			
			// Cang vu hang hai
			String portofAuthority = ParamUtil.getString(resourceRequest, "maritimeCode");
			
			// Ten taushipName
			String nameOfShip = ParamUtil.getString(resourceRequest, "nameOfship");
			
			// Quoc tich tau
			String flagStateOfShip = ParamUtil.getString(resourceRequest, "stateCode");
			
			// So luong thuyen vien
			int numberOfCrews = ParamUtil.getInteger(resourceRequest, "numberOfCrews");
			
			// So luong hanh khach
			int numberOfPassengers = ParamUtil.getInteger(resourceRequest, "numberOfPassengers");
			
			// Ho hieu
			String callSign = ParamUtil.getString(resourceRequest, "callSign");
			
			// Ten thuyen truong
			String nameOfMaster = ParamUtil.getString(resourceRequest, "nameOfMaster");
			
			// Loai hang hoa
			String cargo = ParamUtil.getString(resourceRequest, "typeOfCargo");
			
			// So luong hang hoa
			int volumeCargo = ParamUtil.getInteger(resourceRequest, "volumeCargo");
			
			// Don vi tinh loai hang hoa
			String cargoUnit = ParamUtil.getString(resourceRequest, "unitVolumeCargo");
			
			// Loai hang hoa qua canh
			String transitCargo = ParamUtil.getString(resourceRequest, "transitOfCargo");
			
			// So luong hang hoa qua canh
			Double volumeTransitCargo = ParamUtil.getDouble(resourceRequest, "volumeTransitCargo");
			
			// Don vi tinh hang hoa qua canh
			String transitCargoUnit = ParamUtil.getString(resourceRequest, "unitVolumeTransitCargo");
			
			// Thoi gian roi cang
			Date timeOfDeparture = ParamUtil.getDate(resourceRequest, "timeOfDeparture", FormatData.formatDateShort3);
			
			// Ma cang den
			String nextPortOfCallCode = ParamUtil.getString(resourceRequest, "nextPortOfCallCode");
			
			// Co hieu luc
			Date validUntil = ParamUtil.getDate(resourceRequest, "timeOfValidUntil", FormatData.formatDateShort3);
			
			// Ngay cap
			Date issueDate = ParamUtil.getDate(resourceRequest, "issueDate", FormatData.formatDateShort3);
			if (Validator.isNull(issueDate)) { issueDate = new Date(); }
			
			// Giam doc cang vu hang hai
			String directorOfMaritime = "GD";
			
			
			//String directorOfMaritimeAdministration = "GD";
			long urs = 0;
			 urs = UserLocalServiceUtil.getUserIdByEmailAddress(10154, userName);
			 System.out.println("=============userID ==== " + urs);
			if(urs != 0) {
				UserPort defaultCode = UserPortLocalServiceUtil.findByUserId(urs);
				System.out.println("urs!=0");
				if(defaultCode != null) {
					DmMaritime dmMaritime = DmMaritimeLocalServiceUtil.getByMaritimeCode(defaultCode.getPortCode());
					System.out.println("dmMaritime.getCitycode()== " + dmMaritime.getCitycode());
					if(dmMaritime != null) {
						directorOfMaritime = dmMaritime.getCitycode();
					}
				}
			}
			// Giay phep so
			String certificateNo = ParamUtil.getString(resourceRequest, "certificateNo");
			
			String unitCertificate = ParamUtil.getString(resourceRequest, "unitCertificateNo");
			log.info("==cargo==" + cargo + "==volumeCargo==" + volumeCargo);
			// Dung tich toan phan
			double gt = ParamUtil.getDouble(resourceRequest, "grt");
			String versionNo = ParamUtil.getString(resourceRequest, "versionNo");
			
			long idPortClearance = ParamUtil.getLong(resourceRequest, "idPortClearance");
			String requestCodePortClearance = ParamUtil.getString(resourceRequest, "requestCodePortClearance");
			String representative = ParamUtil.getString(resourceRequest, "representative");
			String remarks = ParamUtil.getString(resourceRequest, PageType.LY_DO_TU_CHOI);
			
			IssuePortClearance portClearance = new IssuePortClearanceImpl();
			
			portClearance.setNumberPortClearance(numberPortClearance);
			portClearance.setDocumentName(documentName);
			portClearance.setDocumentYear(documentYear);
			portClearance.setPortofAuthority(portofAuthority);
			portClearance.setNameOfShip(nameOfShip);
			portClearance.setFlagStateOfShip(flagStateOfShip);
			portClearance.setNumberOfCrews(numberOfCrews);
			portClearance.setNumberOfPassengers(numberOfPassengers);
			portClearance.setCallSign(callSign);
			portClearance.setNameOfMaster(nameOfMaster);
			portClearance.setCargo(cargo);
			portClearance.setVolumeCargo(volumeCargo);
			portClearance.setCargoUnit(cargoUnit);
			portClearance.setTransitCargo(transitCargo);
			portClearance.setVolumeTransitCargo(volumeTransitCargo);
			portClearance.setTransitCargoUnit(transitCargoUnit);
			portClearance.setTimeOfDeparture(timeOfDeparture);
			portClearance.setNextPortOfCallCode(nextPortOfCallCode);
			portClearance.setValidUntil(validUntil);
			portClearance.setIssueDate(issueDate);
			portClearance.setDirectorOfMaritime(directorOfMaritime);
			portClearance.setCertificateNo(certificateNo.trim() + "/" + unitCertificate.trim());
			portClearance.setGt(gt);
			portClearance.setVersionNo(versionNo);
			
			// TODO xuat canh truong hop duyet
			// portClearance.setIsApproval(isApproval);
			// portClearance.setApprovalDate(approvalDate);
			// portClearance.setApprovalName(approvalName);
			
			// TODO xuat canh truong hop cap lai
			// portClearance.setRemarks(remarks);
			
			// TODO xuat canh truong hop huy?
			// portClearance.setIsCancel(isCancel);
			// portClearance.setCancelDate(cancelDate);
			// portClearance.setCancelName(cancelName);
			// portClearance.setCancelNote(cancelNote);
			
			portClearance.setRepresentative(representative);
			
			String capPortClearance = ParamUtil.getString(resourceRequest, PageType.LAN_CAP_PORT_CLEARANCE);
			String suaPortClearance = ParamUtil.getString(resourceRequest, PageType.LAN_SUA_PORT_CLEARANCE);
			
			//log.info("====taoGiayPhepRoiCang====capPortClearance=====" + capPortClearance + "=====suaPortClearance=====" + suaPortClearance);
			
			if (capPortClearance.equalsIgnoreCase(KeyParams.MOT_LAN)) {
				
				portClearance.setRequestCode(UUID.randomUUID().toString());
				portClearance.setRequestState(TrangThaiBanKhaiXuatCanh.KHAI_MOI);
				portClearance = IssuePortClearanceLocalServiceUtil.addIssuePortClearance(portClearance);
				log.info("===========MOT_LAN====" + "INSERT");
				
			} else if (suaPortClearance.equalsIgnoreCase(KeyParams.MOT_LAN)) {
				
				portClearance.setId(idPortClearance);
				portClearance.setRequestCode(requestCodePortClearance);
				portClearance.setRequestState(TrangThaiBanKhaiXuatCanh.KHAI_SUA);
				portClearance = IssuePortClearanceLocalServiceUtil.updateIssuePortClearance(portClearance);
				log.info("===========MOT_LAN====id===" + idPortClearance + "===UPDATE");
				
			} else if (capPortClearance.equalsIgnoreCase(KeyParams.N_LAN)) {
				
				portClearance.setRequestCode(UUID.randomUUID().toString());
				portClearance.setRequestState(TrangThaiBanKhaiXuatCanh.SUA_DOI_BO_XUNG);
				portClearance.setRemarks(remarks);
				portClearance = IssuePortClearanceLocalServiceUtil.addIssuePortClearance(portClearance);
				log.info("===========N_LAN=====" + "INSERT");
				
			} else if (suaPortClearance.equalsIgnoreCase(KeyParams.N_LAN)) {
				
				portClearance.setId(idPortClearance);
				portClearance.setRequestCode(requestCodePortClearance);
				portClearance.setRequestState(TrangThaiBanKhaiNhapCanh.KHAI_SUA);
				portClearance = IssuePortClearanceLocalServiceUtil.updateIssuePortClearance(portClearance);
				log.info("===========N_LAN===id===" + idPortClearance + "=UPDATE");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}
		return null;
	}
	
	public void xacNhanHoanThanhThuTucXuatCanhTruongHopHuy(ActionRequest resourceRequest, long documentName, int documentYear, String lyDoHuyXC99) {
		
		ResultCompetion resultCompetion = null;
		
		resultCompetion = ResultCompetionLocalServiceUtil.findByDocumentNameAndDocumentYear(documentName, documentYear);
		String maritimeCode = ParamUtil.getString(resourceRequest, "maritimeCode");
		String nameOfShip = ParamUtil.getString(resourceRequest, "nameOfShip");
		String nameOfMaster = ParamUtil.getString(resourceRequest, "nameOfMaster");
		String portOfArrivalCode = ParamUtil.getString(resourceRequest, "portOfArrivalCode");
		String certificateNo = ParamUtil.getString(resourceRequest, "certificateNo");
		String maritimeReference = ParamUtil.getString(resourceRequest, "maritimeReference");
		String flagStateOfShip = ParamUtil.getString(resourceRequest, "flagStateOfShip");
		double grossTonnage = ParamUtil.getDouble(resourceRequest, "grossTonnage");
		
		log.info("===vao vao =grossTonnage=" + grossTonnage);
		
		Date approvalTime = ParamUtil.getDate(resourceRequest, "approvalTime", FormatData.formatDateShort3);
		String approvalName = ParamUtil.getString(resourceRequest, "approvalName");
		
		try {
			log.info("xacNhanHoanThanhThuTucQuaCanhTruongHopHuy " + documentName + "  documentYear  " + documentYear);
			if (resultCompetion == null) {
				
				log.info("========vao insert====xacNhanHoanThanhThuTucQuaCanhTruongHopHuy=====");
				resultCompetion = new ResultCompetionImpl();
				resultCompetion.setMaritimeCode(maritimeCode);
				resultCompetion.setNameOfShip(nameOfShip);
				resultCompetion.setNameOfMaster(nameOfMaster);
				resultCompetion.setPortOfArrivalCode(portOfArrivalCode);
				resultCompetion.setCertificateNo(certificateNo);
				resultCompetion.setCertificateNo(certificateNo.trim() + "/" + maritimeReference.trim());
				resultCompetion.setFlagStateOfShip(flagStateOfShip);
				resultCompetion.setGrossTonnage(grossTonnage);
				resultCompetion.setApprovalTime(approvalTime);
				resultCompetion.setApprovalName(approvalName);
				
				resultCompetion.setRequestState(TrangThaiBanKhaiXuatCanh.HUY_THU_TUC_TAU_THUYEN_XUAT_CANH);
				resultCompetion.setResponseStatusCVHH(MessageType.TU_CHOI);
				resultCompetion.setResponseTimeCVHH(approvalTime);
				resultCompetion.setResponseCVHH(BusinessUtils.getRemarkTuChoiTB(PortalUtil.getUser(resourceRequest).getEmailAddress(), lyDoHuyXC99,
						approvalTime));
				
				resultCompetion.setDocumentName(documentName);
				resultCompetion.setDocumentYear(documentYear);
				resultCompetion.setRequestCode(UUID.randomUUID().toString());
				
				ResultCompetionLocalServiceUtil.addResultCompetion(resultCompetion);
			} else {
				
				log.info("xacNhanHoanThanhThuTucQuaCanhTruongHopHuy vao update");
				resultCompetion.setRequestState(TrangThaiBanKhaiXuatCanh.HUY_THU_TUC_TAU_THUYEN_XUAT_CANH);
				resultCompetion.setResponseStatusCVHH(MessageType.TU_CHOI);
				resultCompetion.setResponseTimeCVHH(approvalTime);
				resultCompetion.setResponseCVHH(BusinessUtils.getRemarkTuChoiTB(PortalUtil.getUser(resourceRequest).getEmailAddress(), lyDoHuyXC99,
						approvalTime));
				
				resultCompetion.setMaritimeCode(maritimeCode);
				resultCompetion.setNameOfShip(nameOfShip);
				resultCompetion.setNameOfMaster(nameOfMaster);
				resultCompetion.setPortOfArrivalCode(portOfArrivalCode);
				resultCompetion.setCertificateNo(certificateNo);
				resultCompetion.setCertificateNo(certificateNo.trim() + "/" + maritimeReference.trim());
				resultCompetion.setFlagStateOfShip(flagStateOfShip);
				resultCompetion.setGrossTonnage(grossTonnage);
				resultCompetion.setApprovalTime(approvalTime);
				resultCompetion.setApprovalName(approvalName);
				
				ResultCompetionLocalServiceUtil.updateResultCompetion(resultCompetion);
				
			//	log.info("UPDATE XONG setRequestState" + resultCompetion.getRequestState());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void xacNhanHoanThanhThuTucXuatCanh(ActionRequest resourceRequest, long documentName, int documentYear) {
		try {
			log.info("===vao xacNhanHoanThanhThuTucXuatCanh=====documentName=====" + documentName + "=====documentYear=====" + documentYear);
			
			String maritimeCode = ParamUtil.getString(resourceRequest, "maritimeCode");
			String nameOfShip = ParamUtil.getString(resourceRequest, "nameOfShip");
			String nameOfMaster = ParamUtil.getString(resourceRequest, "nameOfMaster");
			String portOfArrivalCode = ParamUtil.getString(resourceRequest, "portOfArrivalCode");
			String certificateNo = ParamUtil.getString(resourceRequest, "certificateNo");
			String maritimeReference = ParamUtil.getString(resourceRequest, "maritimeReference");
			String flagStateOfShip = ParamUtil.getString(resourceRequest, "flagStateOfShip");
			double grossTonnage = ParamUtil.getDouble(resourceRequest, "grossTonnage");
			Date approvalTime = ParamUtil.getDate(resourceRequest, "approvalTime", FormatData.formatDateShort3);
			String approvalName = ParamUtil.getString(resourceRequest, "approvalName");					
			
			ResultCompetion resultCompetion = null;
			resultCompetion = ResultCompetionLocalServiceUtil.findByDocumentNameAndDocumentYear(documentName, documentYear);
			
			if (resultCompetion == null) {
				
				log.info("========vao insert====xacNhanHoanThanhThuTucXuatCanh===== + flagStateOfShip" + flagStateOfShip);
				resultCompetion = new ResultCompetionImpl();
				resultCompetion.setMaritimeCode(maritimeCode);
				resultCompetion.setNameOfShip(nameOfShip);
				resultCompetion.setNameOfMaster(nameOfMaster);
				resultCompetion.setPortOfArrivalCode(portOfArrivalCode);
				resultCompetion.setCertificateNo(certificateNo);
				resultCompetion.setCertificateNo(certificateNo.trim() + "/" + maritimeReference.trim());
				resultCompetion.setFlagStateOfShip(flagStateOfShip);
				resultCompetion.setGrossTonnage(grossTonnage);
				resultCompetion.setApprovalTime(approvalTime);
				resultCompetion.setApprovalName(approvalName);
				
				resultCompetion.setRequestState(TrangThaiBanKhaiXuatCanh.PHE_DUYET_HOAN_THANH_THU_TUC);
				resultCompetion.setResponseStatusCVHH(MessageType.DA_PHE_DUYET);
				resultCompetion.setResponseTimeCVHH(approvalTime);
				resultCompetion.setResponseCVHH(BusinessUtils
						.getRemarkPheDuyetTB(PortalUtil.getUser(resourceRequest).getEmailAddress(), approvalTime));
				
				resultCompetion.setDocumentName(documentName);
				resultCompetion.setDocumentYear(documentYear);
				resultCompetion.setRequestCode(UUID.randomUUID().toString());
				
				ResultCompetionLocalServiceUtil.addResultCompetion(resultCompetion);
			} else {
				
			//	log.info("========vao update===xacNhanHoanThanhThuTucXuatCanh======");
				resultCompetion.setMaritimeCode(maritimeCode);
				resultCompetion.setNameOfShip(nameOfShip);
				resultCompetion.setNameOfMaster(nameOfMaster);
				resultCompetion.setPortOfArrivalCode(portOfArrivalCode);
				
				resultCompetion.setRequestState(TrangThaiBanKhaiXuatCanh.PHE_DUYET_HOAN_THANH_THU_TUC);
				resultCompetion.setResponseStatusCVHH(MessageType.DA_PHE_DUYET);
				resultCompetion.setResponseTimeCVHH(approvalTime);
				resultCompetion.setResponseCVHH(BusinessUtils
						.getRemarkPheDuyetTB(PortalUtil.getUser(resourceRequest).getEmailAddress(), approvalTime));
				
				resultCompetion.setCertificateNo(certificateNo);
				resultCompetion.setCertificateNo(certificateNo.trim() + "/" + maritimeReference.trim());
				resultCompetion.setFlagStateOfShip(flagStateOfShip);
				resultCompetion.setGrossTonnage(grossTonnage);
				resultCompetion.setApprovalTime(approvalTime);
				resultCompetion.setApprovalName(approvalName);
				
				ResultCompetionLocalServiceUtil.updateResultCompetion(resultCompetion);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @param tempDocument
	 * @param messageType
	 * @param actionType
	 * @param userName
	 * @return
	 */
	public boolean thayDoiTrangThaiToanBoBanKhai(TempDocument tempDocument, int messageType, int actionType, String userName, String requestCode) {
		boolean result = true;
		try {
			
			List<TempShipSecurityMessage> results = TempShipSecurityMessageLocalServiceUtil.findByRequestCode(requestCode);
			if (results != null && results.size() > 0) {
				TempShipSecurityMessage tempShipSecurityMessage = results.get(0);
				if (actionType == PageType.ACTION_TYPE_TIEP_NHAN) {
					tempShipSecurityMessage.setRequestState(TrangThaiBanKhai.TRANG_THAI_BANG_KHAI_TIEP_NHAN);
					
				} else if (actionType == PageType.ACTION_TYPE_DOI_CHIEU) {
					tempShipSecurityMessage.setRequestState(TrangThaiBanKhai.TRANG_THAI_BANG_KHAI_DOI_CHIEU);
				} else if (actionType == PageType.ACTION_TYPE_TU_CHOI) {
					tempShipSecurityMessage.setRequestState(TrangThaiBanKhai.TRANG_THAI_BANG_KHAI_TU_CHOI);
				} else if (actionType == PageType.ACTION_TYPE_HUY) {
					tempShipSecurityMessage.setRequestState(TrangThaiBanKhai.TRANG_THAI_BANG_KHAI_HUY);
				}
				TempShipSecurityMessageLocalServiceUtil.updateTempShipSecurityMessage(tempShipSecurityMessage);
			}
			
			List<TempCargoDeclaration> resultTempCargoDeclaration = TempCargoDeclarationLocalServiceUtil.findByRequestCode(requestCode);
			if (resultTempCargoDeclaration != null && resultTempCargoDeclaration.size() > 0) {
				TempCargoDeclaration tempCargoDeclaration = resultTempCargoDeclaration.get(0);
				if (actionType == PageType.ACTION_TYPE_TIEP_NHAN) {
					tempCargoDeclaration.setRequestState(TrangThaiBanKhai.TRANG_THAI_BANG_KHAI_TIEP_NHAN);
				} else if (actionType == PageType.ACTION_TYPE_DOI_CHIEU) {
					tempCargoDeclaration.setRequestState(TrangThaiBanKhai.TRANG_THAI_BANG_KHAI_DOI_CHIEU);
				} else if (actionType == PageType.ACTION_TYPE_TU_CHOI) {
					tempCargoDeclaration.setRequestState(TrangThaiBanKhai.TRANG_THAI_BANG_KHAI_TU_CHOI);
				} else if (actionType == PageType.ACTION_TYPE_HUY) {
					tempCargoDeclaration.setRequestState(TrangThaiBanKhai.TRANG_THAI_BANG_KHAI_HUY);
				}
				TempCargoDeclarationLocalServiceUtil.updateTempCargoDeclaration(tempCargoDeclaration);
			}
			
			List<TempNoTiceShipMessage> resultTempNoTiceShipMessage = TempNoTiceShipMessageLocalServiceUtil.findByRequestCode(requestCode);
			if (resultTempNoTiceShipMessage != null && resultTempNoTiceShipMessage.size() > 0) {
				TempNoTiceShipMessage tempNoticeShipMessage = resultTempNoTiceShipMessage.get(0);
				if (actionType == PageType.ACTION_TYPE_TIEP_NHAN) {
					tempNoticeShipMessage.setRequestState(TrangThaiBanKhai.TRANG_THAI_BANG_KHAI_TIEP_NHAN);
				} else if (actionType == PageType.ACTION_TYPE_DOI_CHIEU) {
					tempNoticeShipMessage.setRequestState(TrangThaiBanKhai.TRANG_THAI_BANG_KHAI_DOI_CHIEU);
				} else if (actionType == PageType.ACTION_TYPE_TU_CHOI) {
					tempNoticeShipMessage.setRequestState(TrangThaiBanKhai.TRANG_THAI_BANG_KHAI_TU_CHOI);
				} else if (actionType == PageType.ACTION_TYPE_HUY) {
					tempNoticeShipMessage.setRequestState(TrangThaiBanKhai.TRANG_THAI_BANG_KHAI_HUY);
				}
				TempNoTiceShipMessageLocalServiceUtil.updateTempNoTiceShipMessage(tempNoticeShipMessage);
			}
			
			List<TempGeneralDeclaration> resultGeneralDeclaration = TempGeneralDeclarationLocalServiceUtil.findByRequestCode(requestCode);
			if (resultGeneralDeclaration != null && resultGeneralDeclaration.size() > 0) {
				TempGeneralDeclaration tempGeneralDeclaration = resultGeneralDeclaration.get(0);
				if (actionType == PageType.ACTION_TYPE_TIEP_NHAN) {
					tempGeneralDeclaration.setRequestState(TrangThaiBanKhai.TRANG_THAI_BANG_KHAI_TIEP_NHAN);
				} else if (actionType == PageType.ACTION_TYPE_DOI_CHIEU) {
					tempGeneralDeclaration.setRequestState(TrangThaiBanKhai.TRANG_THAI_BANG_KHAI_DOI_CHIEU);
				} else if (actionType == PageType.ACTION_TYPE_TU_CHOI) {
					tempGeneralDeclaration.setRequestState(TrangThaiBanKhai.TRANG_THAI_BANG_KHAI_TU_CHOI);
				} else if (actionType == PageType.ACTION_TYPE_HUY) {
					tempGeneralDeclaration.setRequestState(TrangThaiBanKhai.TRANG_THAI_BANG_KHAI_HUY);
				}
				TempGeneralDeclarationLocalServiceUtil.updateTempGeneralDeclaration(tempGeneralDeclaration);
			}
			
			List<TempCrewList> resultCrewList = TempCrewListLocalServiceUtil.findByRequestCode(requestCode);
			if (resultCrewList != null && resultCrewList.size() > 0) {
				TempCrewList tempCrewList = resultCrewList.get(0);
				if (actionType == PageType.ACTION_TYPE_TIEP_NHAN) {
					tempCrewList.setRequestState(TrangThaiBanKhai.TRANG_THAI_BANG_KHAI_TIEP_NHAN);
				} else if (actionType == PageType.ACTION_TYPE_DOI_CHIEU) {
					tempCrewList.setRequestState(TrangThaiBanKhai.TRANG_THAI_BANG_KHAI_DOI_CHIEU);
				} else if (actionType == PageType.ACTION_TYPE_TU_CHOI) {
					tempCrewList.setRequestState(TrangThaiBanKhai.TRANG_THAI_BANG_KHAI_TU_CHOI);
				} else if (actionType == PageType.ACTION_TYPE_HUY) {
					tempCrewList.setRequestState(TrangThaiBanKhai.TRANG_THAI_BANG_KHAI_HUY);
				}
				TempCrewListLocalServiceUtil.updateTempCrewList(tempCrewList);
			}
			
			List<TempPassengerList> resultPassengerList = TempPassengerListLocalServiceUtil.findByRequestCode(requestCode);
			if (resultPassengerList != null && resultPassengerList.size() > 0) {
				TempPassengerList tempPassenger = resultPassengerList.get(0);
				if (actionType == PageType.ACTION_TYPE_TIEP_NHAN) {
					tempPassenger.setRequestState(TrangThaiBanKhai.TRANG_THAI_BANG_KHAI_TIEP_NHAN);
				} else if (actionType == PageType.ACTION_TYPE_DOI_CHIEU) {
					tempPassenger.setRequestState(TrangThaiBanKhai.TRANG_THAI_BANG_KHAI_DOI_CHIEU);
				} else if (actionType == PageType.ACTION_TYPE_TU_CHOI) {
					tempPassenger.setRequestState(TrangThaiBanKhai.TRANG_THAI_BANG_KHAI_TU_CHOI);
				} else if (actionType == PageType.ACTION_TYPE_HUY) {
					tempPassenger.setRequestState(TrangThaiBanKhai.TRANG_THAI_BANG_KHAI_HUY);
				}
				TempPassengerListLocalServiceUtil.updateTempPassengerList(tempPassenger);
			}
			
			List<TempDangerousGoodsNanifest> resultDangerousGoodsNanifests = TempDangerousGoodsNanifestLocalServiceUtil
					.findByRequestCode(requestCode);
			if (resultDangerousGoodsNanifests != null && resultDangerousGoodsNanifests.size() > 0) {
				TempDangerousGoodsNanifest tempDangerousGoodsNanifest = resultDangerousGoodsNanifests.get(0);
				if (actionType == PageType.ACTION_TYPE_TIEP_NHAN) {
					tempDangerousGoodsNanifest.setRequestState(TrangThaiBanKhai.TRANG_THAI_BANG_KHAI_TIEP_NHAN);
				} else if (actionType == PageType.ACTION_TYPE_DOI_CHIEU) {
					tempDangerousGoodsNanifest.setRequestState(TrangThaiBanKhai.TRANG_THAI_BANG_KHAI_DOI_CHIEU);
				} else if (actionType == PageType.ACTION_TYPE_TU_CHOI) {
					tempDangerousGoodsNanifest.setRequestState(TrangThaiBanKhai.TRANG_THAI_BANG_KHAI_TU_CHOI);
				} else if (actionType == PageType.ACTION_TYPE_HUY) {
					tempDangerousGoodsNanifest.setRequestState(TrangThaiBanKhai.TRANG_THAI_BANG_KHAI_HUY);
				}
				TempDangerousGoodsNanifestLocalServiceUtil.updateTempDangerousGoodsNanifest(tempDangerousGoodsNanifest);
			}
			
			List<TempShipStoresDeclaration> resultTempShipStoresDeclarations = TempShipStoresDeclarationLocalServiceUtil
					.findByRequestCode(requestCode);
			if (resultTempShipStoresDeclarations != null && resultTempShipStoresDeclarations.size() > 0) {
				TempShipStoresDeclaration tempShipStoresDeclaration = resultTempShipStoresDeclarations.get(0);
				if (actionType == PageType.ACTION_TYPE_TIEP_NHAN) {
					tempShipStoresDeclaration.setRequestState(TrangThaiBanKhai.TRANG_THAI_BANG_KHAI_TIEP_NHAN);
				} else if (actionType == PageType.ACTION_TYPE_DOI_CHIEU) {
					tempShipStoresDeclaration.setRequestState(TrangThaiBanKhai.TRANG_THAI_BANG_KHAI_DOI_CHIEU);
				} else if (actionType == PageType.ACTION_TYPE_TU_CHOI) {
					tempShipStoresDeclaration.setRequestState(TrangThaiBanKhai.TRANG_THAI_BANG_KHAI_TU_CHOI);
				} else if (actionType == PageType.ACTION_TYPE_HUY) {
					tempShipStoresDeclaration.setRequestState(TrangThaiBanKhai.TRANG_THAI_BANG_KHAI_HUY);
				}
				TempShipStoresDeclarationLocalServiceUtil.updateTempShipStoresDeclaration(tempShipStoresDeclaration);
			}
			
			List<TempCrewEffectsDeclaration> resultTempCrewEffectsDeclarations = TempCrewEffectsDeclarationLocalServiceUtil
					.findByRequestCode(requestCode);
			if (resultTempCrewEffectsDeclarations != null && resultTempCrewEffectsDeclarations.size() > 0) {
				TempCrewEffectsDeclaration tempCrewEffectsDeclaration = resultTempCrewEffectsDeclarations.get(0);
				if (actionType == PageType.ACTION_TYPE_TIEP_NHAN) {
					tempCrewEffectsDeclaration.setRequestState(TrangThaiBanKhai.TRANG_THAI_BANG_KHAI_TIEP_NHAN);
				} else if (actionType == PageType.ACTION_TYPE_DOI_CHIEU) {
					tempCrewEffectsDeclaration.setRequestState(TrangThaiBanKhai.TRANG_THAI_BANG_KHAI_DOI_CHIEU);
				} else if (actionType == PageType.ACTION_TYPE_TU_CHOI) {
					tempCrewEffectsDeclaration.setRequestState(TrangThaiBanKhai.TRANG_THAI_BANG_KHAI_TU_CHOI);
				} else if (actionType == PageType.ACTION_TYPE_HUY) {
					tempCrewEffectsDeclaration.setRequestState(TrangThaiBanKhai.TRANG_THAI_BANG_KHAI_HUY);
				}
				TempCrewEffectsDeclarationLocalServiceUtil.updateTempCrewEffectsDeclaration(tempCrewEffectsDeclaration);
			}
			
			List<TempDeclarationOfHealth> resultTempDeclarationOfHealths = TempDeclarationOfHealthLocalServiceUtil.findByRequestCode(requestCode);
			if (resultTempDeclarationOfHealths != null && resultTempDeclarationOfHealths.size() > 0) {
				TempDeclarationOfHealth tempDeclarationOfHealth = resultTempDeclarationOfHealths.get(0);
				if (actionType == PageType.ACTION_TYPE_TIEP_NHAN) {
					tempDeclarationOfHealth.setRequestState(TrangThaiBanKhai.TRANG_THAI_BANG_KHAI_TIEP_NHAN);
				} else if (actionType == PageType.ACTION_TYPE_DOI_CHIEU) {
					tempDeclarationOfHealth.setRequestState(TrangThaiBanKhai.TRANG_THAI_BANG_KHAI_DOI_CHIEU);
				} else if (actionType == PageType.ACTION_TYPE_TU_CHOI) {
					tempDeclarationOfHealth.setRequestState(TrangThaiBanKhai.TRANG_THAI_BANG_KHAI_TU_CHOI);
				} else if (actionType == PageType.ACTION_TYPE_HUY) {
					tempDeclarationOfHealth.setRequestState(TrangThaiBanKhai.TRANG_THAI_BANG_KHAI_HUY);
				}
				TempDeclarationOfHealthLocalServiceUtil.updateTempDeclarationOfHealth(tempDeclarationOfHealth);
			}
			
			List<TempAnimalQuarantine> resultAnimalQuarantines = TempAnimalQuarantineLocalServiceUtil.findByRequestCode(requestCode);
			if (resultAnimalQuarantines != null && resultAnimalQuarantines.size() > 0) {
				TempAnimalQuarantine tempPlantQuarantine = resultAnimalQuarantines.get(0);
				if (actionType == PageType.ACTION_TYPE_TIEP_NHAN) {
					tempPlantQuarantine.setRequestState(TrangThaiBanKhai.TRANG_THAI_BANG_KHAI_TIEP_NHAN);
				} else if (actionType == PageType.ACTION_TYPE_DOI_CHIEU) {
					tempPlantQuarantine.setRequestState(TrangThaiBanKhai.TRANG_THAI_BANG_KHAI_DOI_CHIEU);
				} else if (actionType == PageType.ACTION_TYPE_TU_CHOI) {
					tempPlantQuarantine.setRequestState(TrangThaiBanKhai.TRANG_THAI_BANG_KHAI_TU_CHOI);
				} else if (actionType == PageType.ACTION_TYPE_HUY) {
					tempPlantQuarantine.setRequestState(TrangThaiBanKhai.TRANG_THAI_BANG_KHAI_HUY);
				}
				TempAnimalQuarantineLocalServiceUtil.updateTempAnimalQuarantine(tempPlantQuarantine);
			}
			
			List<TempPlantQuarantine> resultTempPlantQuarantines = TempPlantQuarantineLocalServiceUtil.findByRequestCode(requestCode);
			if (resultTempPlantQuarantines != null && resultTempPlantQuarantines.size() > 0) {
				TempPlantQuarantine tempPlantQuarantine = resultTempPlantQuarantines.get(0);
				if (actionType == PageType.ACTION_TYPE_TIEP_NHAN) {
					tempPlantQuarantine.setRequestState(TrangThaiBanKhai.TRANG_THAI_BANG_KHAI_TIEP_NHAN);
				} else if (actionType == PageType.ACTION_TYPE_DOI_CHIEU) {
					tempPlantQuarantine.setRequestState(TrangThaiBanKhai.TRANG_THAI_BANG_KHAI_DOI_CHIEU);
				} else if (actionType == PageType.ACTION_TYPE_TU_CHOI) {
					tempPlantQuarantine.setRequestState(TrangThaiBanKhai.TRANG_THAI_BANG_KHAI_TU_CHOI);
				} else if (actionType == PageType.ACTION_TYPE_HUY) {
					tempPlantQuarantine.setRequestState(TrangThaiBanKhai.TRANG_THAI_BANG_KHAI_HUY);
				}
				TempPlantQuarantineLocalServiceUtil.updateTempPlantQuarantine(tempPlantQuarantine);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public void sendChapNhan(int messageType, String function, TempDocument tempDocument, String userName, String requestCode,
			ActionRequest resourceRequest) {
		try {
			InterfaceRequest interfaceRequest = InterfaceRequestLocalServiceUtil.findByRequestCode(requestCode);
			Header header = BusinessUtils.crateHeader(tempDocument, MessageType.NHAP_CANH, function, messageType, userName, interfaceRequest);
			
			BusinessUtils businessUtils = new BusinessUtils();
			IMTService imtService = CallWs2HaiQuan.getIMTSercice();
			String xmlData = businessUtils.sendMessageAccept(header, BusinessUtils.getOrganizationFromUser(resourceRequest),
					businessUtils.getDivision(resourceRequest), header.getFrom().getName(), new Date(), tempDocument.getRequestCode());
			if (xmlData != null && xmlData.length() > 0) {
				businessUtils.insertHistorySendMessage(xmlData);
				String xml = "";
			
		
				
				if( tempDocument.getDocumentTypeCode().equals(MessageType.LOAT_THU_TUC_VAO_CANG) || tempDocument.getDocumentTypeCode().equals(MessageType.LOAT_THU_TUC_ROI_CANG)){
					log.info(" ----CAll receiveFromInland------- ");
				//	xml = imtService.receiveFromInland(xmlData);
					
				}else{
					log.info(" ----CAll receiveResultFromMT------- ");
				//	xml = imtService.receiveResultFromMT(xmlData);
				}	
				
				businessUtils.insertHistoryReceiveMessageResponse(xml);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private String createXmlSuaDoiBoXung(int messageType, TempDocument tempDocument, String userName, ActionRequest resourceRequest,
			BusinessUtils businessUtils, InterfaceRequest interfaceRequest) throws SystemException {
		
		String function = MessageType.FUNCTION_THONG_BAO_BO_XUNG;
		String lyDoSuaDoiBoSung = ParamUtil.getString(resourceRequest, PageType.LY_DO_SUADOI_BOSUNG);
		if (lyDoSuaDoiBoSung == null || lyDoSuaDoiBoSung.length() == 0) {
			lyDoSuaDoiBoSung = "System";
		}
		if (interfaceRequest == null) {
			interfaceRequest = InterfaceRequestLocalServiceUtil.findInterfaceRequestByRequestCode(tempDocument.getRequestCode());
		}
		Header header = BusinessUtils.crateHeader(tempDocument, MessageType.XUAT_CANH, function, MessageType.HO_SO, userName, interfaceRequest);
		vn.gt.tichhop.message.Modify modify = new vn.gt.tichhop.message.Modify();
		modify.setDivision(businessUtils.getDivision(resourceRequest));
		modify.setOrganization(BusinessUtils.getOrganizationFromUser(resourceRequest));
		modify.setName(header.getFrom().getName());
		modify.setModifyDate(FormatData.parseDateToTring(new Date()));
		modify.setModifyDesc(lyDoSuaDoiBoSung);
		modify.setModifyCode("Bo Xung Ho So");
		// xmlData = MessageFactory.convertObjectToXml(modify);
		if (messageType == MessageType.XAC_BAO_TAU_DEN_CANG) {
			Modify modify2 = new ModifyImpl();
			modify2.setId(CounterLocalServiceUtil.increment(Modify.class.getName()));
			modify2.setDivision(modify.getDivision());
			modify2.setDocumentName(tempDocument.getDocumentName());
			modify2.setDocumentYear(tempDocument.getDocumentYear());
			modify2.setModifyCode(modify.getModifyCode());
			modify2.setModifyDesc(modify.getModifyDesc());
			modify2.setModifyDate(new Date());
			ModifyLocalServiceUtil.addModify(modify2);
		}
		return businessUtils.sendMessageModify(header, modify, tempDocument.getRequestCode());
	}
	
	private void insertOrUpdateResultNotification(TempDocument temp, String userName, String lyDoTuChoi, int messageType) {
		try {
			// MessageType.HUY_LENH_DIEU_DONG
			ResultNotification resultNotification = ResultNotificationLocalServiceUtil.findByBusinessTypeCode(messageType, temp.getDocumentName(),
					temp.getDocumentYear());
			if (resultNotification == null) {
				// Them moi.
				resultNotification = new ResultNotificationImpl();
				resultNotification.setBusinessTypeCode(messageType);
				resultNotification.setDivision("System");
				resultNotification.setDocumentName(temp.getDocumentName());
				resultNotification.setDocumentYear(temp.getDocumentYear());
				resultNotification.setLatestDate(FormatData.parseDateToTring(new Date()));
				resultNotification.setRequestCode(UUID.randomUUID().toString());
				
				if (temp != null) {
					resultNotification.setMaritimeCode(temp.getMaritimeCode());
				}
				
				// resultNotification.setRemarks(userName);
				
				resultNotification.setRole(2);
				resultNotification.setResponse(lyDoTuChoi);
				resultNotification.setRequestState(1);
				resultNotification.setResponseTime(new Date());
				resultNotification.setOfficerName(userName);
				resultNotification.setLatestDate(FormatData.parseDateToTring(new Date()));
				resultNotification.setIsReply(1);
				
				ResultNotificationLocalServiceUtil.addResultNotification(resultNotification);
			} else {
				resultNotification.setRole(2);
				resultNotification.setResponse(lyDoTuChoi);
				resultNotification.setRequestState(1);
				if (temp != null) {
					resultNotification.setMaritimeCode(temp.getMaritimeCode());
				}
				resultNotification.setResponseTime(new Date());
				resultNotification.setOfficerName(userName);
				resultNotification.setLatestDate(FormatData.parseDateToTring(new Date()));
				resultNotification.setIsReply(1);
				
				ResultNotificationLocalServiceUtil.updateResultNotification(resultNotification);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}
	}
	
}
