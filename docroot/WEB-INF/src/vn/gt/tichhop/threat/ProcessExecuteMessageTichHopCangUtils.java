/**
 * 
 */
package vn.gt.tichhop.threat;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.tempuri.IMTService;

import vn.gt.dao.danhmuc.model.DmMaritime;
import vn.gt.dao.danhmuc.service.DmMaritimeLocalServiceUtil;
import vn.gt.dao.noticeandmessage.model.HistoryInterfaceRequest;
import vn.gt.dao.noticeandmessage.model.InterfaceRequest;
import vn.gt.dao.noticeandmessage.model.IssuePortClearance;
import vn.gt.dao.noticeandmessage.model.IssueShiftingOrder;
import vn.gt.dao.noticeandmessage.model.TempCrewList;
import vn.gt.dao.noticeandmessage.model.TempDangerousGoodsNanifest;
import vn.gt.dao.noticeandmessage.model.TempDocument;
import vn.gt.dao.noticeandmessage.model.TempGeneralDeclaration;
import vn.gt.dao.noticeandmessage.model.TempNoTiceShipMessage;
import vn.gt.dao.noticeandmessage.model.TempShipSecurityMessage;
import vn.gt.dao.noticeandmessage.service.HistoryInterfaceRequestLocalServiceUtil;
import vn.gt.dao.noticeandmessage.service.InterfaceRequestLocalServiceUtil;
import vn.gt.dao.noticeandmessage.service.IssuePortClearanceLocalServiceUtil;
import vn.gt.dao.noticeandmessage.service.IssueShiftingOrderLocalServiceUtil;
import vn.gt.dao.noticeandmessage.service.TempCrewListLocalServiceUtil;
import vn.gt.dao.noticeandmessage.service.TempDangerousGoodsNanifestLocalServiceUtil;
import vn.gt.dao.noticeandmessage.service.TempDocumentLocalServiceUtil;
import vn.gt.dao.noticeandmessage.service.TempGeneralDeclarationLocalServiceUtil;
import vn.gt.dao.noticeandmessage.service.TempNoTiceShipMessageLocalServiceUtil;
import vn.gt.dao.noticeandmessage.service.TempShipSecurityMessageLocalServiceUtil;
import vn.gt.dao.result.model.ResultCompetion;
import vn.gt.dao.result.model.ResultDeclaration;
import vn.gt.dao.result.model.ResultNotification;
import vn.gt.dao.result.model.impl.ResultCompetionImpl;
import vn.gt.dao.result.model.impl.ResultNotificationImpl;
import vn.gt.dao.result.service.ResultCompetionLocalServiceUtil;
import vn.gt.dao.result.service.ResultDeclarationLocalServiceUtil;
import vn.gt.dao.result.service.ResultNotificationLocalServiceUtil;
import vn.gt.tichhop.message.AccepterMessage;
import vn.gt.tichhop.message.BusinessUtils;
import vn.gt.tichhop.message.CangVuBussinessUtils;
import vn.gt.tichhop.message.DeNghiCapLaiGiayPhep;
import vn.gt.tichhop.message.MessageFactory;
import vn.gt.tichhop.message.MessageType;
import vn.gt.tichhop.message.RejectMessage;
import vn.gt.tichhop.message.TrangThaiBanKhaiNhapCanh;
import vn.gt.tichhop.message.TrangThaiBanKhaiXuatCanh;
import vn.gt.tichhop.message.TrangThaiHoSo;
import vn.gt.tichhop.message.XacNhanHuyThuTuc;
import vn.gt.tichhop.message.giaothong2haiquan.CreateMessageFactory;
import vn.gt.utils.CallWs2HaiQuan;
import vn.gt.utils.ConstantCoQuanBanNganh;
import vn.gt.utils.FormatData;
import vn.gt.utils.KeyParams;
import vn.nsw.Header;
import vn.nsw.Header.Reference;
import vn.nsw.Header.Subject;
import vn.nsw.Header.To;
import vn.nsw.fac.ReadMessages;
import vn.nsw.model.PortClearance;
import vn.nsw.model.ShiftingOrder;
import vn.nsw.model.XacNhanHuyLenhDieuDong;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

/**
 * @author win_64
 */
public class ProcessExecuteMessageTichHopCangUtils {
	
	Log log = LogFactoryUtil.getLog(ProcessExecuteMessageTichHopCangUtils.class);
	private BusinessUtils businessUtils = new BusinessUtils();
	private CangVuBussinessUtils cangvuBussionessUtils = new CangVuBussinessUtils();
	
	public ProcessExecuteMessageTichHopCangUtils() {
	}
	
	public static final String[] FUNCTION_VALUES = { "21", "22", "23", "24" };
	
	public static boolean checkFunction(String function) {
		boolean result = false;
		for (int i = 0; i < FUNCTION_VALUES.length; i++) {
			result = true;
		}
		return result;
	}
	
	public String nhanThongTinCangVu(ObjectExcute objectExcute) {
		String dataXml = "";
		try {
			if (objectExcute != null) {
				if (objectExcute.getHeader() == null && objectExcute.getLiObjects() == null) {
					
					Header headerReceive = null;
					log.debug("=====Thong tin nhan tu ELCOM===" + objectExcute.getXmlData());
					
					String data = businessUtils.replaceXML(objectExcute.getXmlData().trim());
					log.debug("=====Thong tin nhan tu ELcom sau khi bo xml define===" + data);
					
					headerReceive = ReadMessages.readXMLMessagesHeader(data);
					
					// dataXml = createMessageSend2CangVu(headerReceive, true);
					boolean validate = true;
					
					String function = headerReceive.getSubject().getFunction();
					Integer messageType = headerReceive.getSubject().getType();
					
					if (messageType == MessageType.BAN_KHAI_AN_NINH_TAU_BIEN) {
						validate = tichHop_BanKhaiAnNinh(objectExcute, headerReceive);
						
					} else if (messageType == MessageType.BAN_KHAI_HANG_HOA) {
						validate = tichHop_BanKhaiHangHoa(objectExcute, headerReceive);
						
					} else if (messageType == MessageType.THONG_BAO_TAU_DEN_CANG) {
						validate = tichHop_ThongBao_TauDenCang(objectExcute, headerReceive);
						
					} else if (messageType == MessageType.XAC_BAO_TAU_DEN_CANG) {
						validate = tichHop_XacBao_TauDenCang(objectExcute, headerReceive);
						
					} else if (messageType == MessageType.HO_SO) {
						validate = tichHop_HoSo(objectExcute, headerReceive);
						
					} else if (messageType == MessageType.LENH_DIEU_DONG) {
						validate = tichHop_LenhDieuDong(objectExcute, headerReceive);
						
					} else if (messageType == MessageType.THONG_BAO_TAU_ROI_CANG) {
						validate = tichHop_ThongBao_TauRoiCang(objectExcute, headerReceive);
						
					} else if (messageType == MessageType.GIAY_PHEP_ROI_CANG_BO_GTVT_CAP_KHI_XUAT_CANH) {
						validate = tichHop_GiayPhep_RoiCang(objectExcute, headerReceive);
					} else if (messageType == MessageType.HUY_LENH_DIEU_DONG) {
						validate = huyLenhDieuDong(objectExcute, headerReceive);
					} else if (messageType == MessageType.Y_CAU_CAP_LAI_GIAY_PHEP_ROI_CANG) {
						validate = yCauLuuLaiGiayPhepRoiCang(objectExcute, headerReceive);
					} else if (messageType == MessageType.HUY_GIAY_PHEP_ROI_CANG) {
						validate = huyGiayPhepRoiCang(objectExcute, headerReceive);
					}
					
					if (!validate) {
						dataXml = createMessageSend2CangVu(headerReceive, false);
					} else {
						dataXml = createMessageSend2CangVu(headerReceive, true);
					}
					if (function != null && checkFunction(function)) {
						sendMessage2HQ(objectExcute.getXmlData());
						// } else if (function != null && MessageType.FUNCTION_KHAI_HUY_HO_SO.equals(function)) {
						// sendMessage2HQWith03(objectExcute.getXmlData());
					} else {
						if (messageType == MessageType.LENH_DIEU_DONG || messageType == MessageType.GIAY_PHEP_ROI_CANG_BO_GTVT_CAP_KHI_XUAT_CANH
								|| messageType == MessageType.HUY_LENH_DIEU_DONG || messageType == MessageType.HUY_GIAY_PHEP_ROI_CANG
								|| messageType == MessageType.Y_CAU_CAP_LAI_GIAY_PHEP_ROI_CANG) {
							sendMessage2HQ(objectExcute.getXmlData());
						}
					}
					
				}
				
			}
		} catch (Exception es) {
			es.printStackTrace();
		}
		return dataXml;
	}
	
	private void sendMessage2HQWith03(String xmlData) {
		try {
			IMTService imtService = CallWs2HaiQuan.getIMTSercice();
			if (xmlData != null && xmlData.length() > 0) {
				businessUtils.insertHistorySendMessage(xmlData);
				log.debug(" Gui Hai Quan xml  " + xmlData);
				xmlData = imtService.receiveResultFromMT(xmlData);
				log.debug("Nhan tu hai quan xml  " + xmlData);
				businessUtils.insertHistoryReceiveMessageResponse(xmlData);
			}
		} catch (Exception e) {
		}
	}
	
	private void sendMessage2HQ(String xmlData) {
		try {
			IMTService imtService = CallWs2HaiQuan.getIMTSercice();
			String xml = "";
			log.debug("sendMessage2HQ  " + xmlData);
			
			xmlData = businessUtils.replaceXML(xmlData);
			Header header = ReadMessages.readXMLMessagesHeader(xmlData);
			header.getFrom().setIdentity(ConstantCoQuanBanNganh.BGTVT);
			header.getFrom().setName(ConstantCoQuanBanNganh.TEN_BGTVT);
			businessUtils.insertHistorySendMessage(xmlData);
			Object object = MessageFactory.convertXmltoObjectWithFunction(new Integer(header.getSubject().getFunction()), header.getSubject()
					.getType(), xmlData);
			
			if (object != null) {
				if (object instanceof RejectMessage) {
					RejectMessage rejectMessage = (RejectMessage) object;
					xml = CreateMessageFactory.createMessageReject(rejectMessage.getRejectCode(), rejectMessage.getRejectDesc(),
							rejectMessage.getOrganization(), rejectMessage.getDivision(), rejectMessage.getName(),
							FormatData.parseStringToDate(rejectMessage.getRejectDate()));
					// resultMinistry.set
				} else if (object instanceof AccepterMessage) {
					AccepterMessage accepterMessage = (AccepterMessage) object;
					xml = CreateMessageFactory.createMessageAccept(accepterMessage.getOrganization(), accepterMessage.getDivision(),
							accepterMessage.getName(), new Date());
				} else if (object instanceof String) {
					String receiveDate = (String) object;
					xml = CreateMessageFactory.createMessageHoanThanh(receiveDate);
				} else if (object instanceof XacNhanHuyThuTuc) {
					XacNhanHuyThuTuc xacNhanHuyThuTuc = (XacNhanHuyThuTuc) object;
					xml = CreateMessageFactory.createMessageHuyHoSo(xacNhanHuyThuTuc.getOrganization(), xacNhanHuyThuTuc.getDivision(),
							xacNhanHuyThuTuc.getName(), FormatData.parseStringToDate(xacNhanHuyThuTuc.getCancelDate()), xacNhanHuyThuTuc.getReason());
				} else if (object instanceof ShiftingOrder) {
					ShiftingOrder shiftingOrder = (ShiftingOrder) object;
					xml = sendShiftingOrder(header, shiftingOrder, businessUtils);
					// xml = CreateMessageFactory.createMessageHuyHoSo(
					// xacNhanHuyThuTuc.getOrganization(),
					// xacNhanHuyThuTuc.getDivision(), xacNhanHuyThuTuc
					// .getName(), FormatData
					// .parseStringToDate(xacNhanHuyThuTuc
					// .getCancelDate()));
				} else if (object instanceof PortClearance) {
					PortClearance portClearance = (PortClearance) object;
					
					if (portClearance.getPortofAuthority() != null && portClearance.getPortofAuthority().length() > 0) {
						DmMaritime dmMaritime = DmMaritimeLocalServiceUtil.getByMaritimeCode(portClearance.getPortofAuthority());
						log.debug("portClearance.getPortofAuthority()   " + portClearance.getPortofAuthority());
						if (dmMaritime != null) {
							log.debug("dmMaritime.getMaritimeReference()" + dmMaritime.getMaritimeReference());
							portClearance.setPortofAuthority(dmMaritime.getMaritimeReference());
						}
					} else {
						log.debug(" dech co gi");
					}
					// portClearance.setPortofAuthority(t)
					xml = MessageFactory.convertObjectToXml(portClearance);
					
				} else if (object instanceof String) {
					StringBuilder xmlResult = new StringBuilder("");
					xmlResult.append("<ReceiveDate>");
					xmlResult.append((String) object);
					xmlResult.append("</ReceiveDate>");
					xml = xmlResult.toString();
				}
			}
			
			xml = businessUtils.createContentSendFromBGTVTToNSW(header, xml);
			if (xml != null && xml.length() > 0) {
				log.debug(" Gui Hai Quan xml  " + xml);				
				if(MessageType.TAU_VAO == header.getSubject().getDocumentType() ||MessageType.TAU_RA == header.getSubject().getDocumentType()){
					log.debug(" Call  receiveFromInland ---" );	
				//	xml = imtService.receiveFromInland(xmlData);
					
				}else{
					log.debug(" Call  receiveResultFromMT ----" );
				//	xml = imtService.receiveResultFromMT(xmlData);	
				}
				log.debug("Nhan tu hai quan xml  " + xml);
				businessUtils.insertHistoryReceiveMessageResponse(xml);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private String createMessageSend2CangVu(Header headerReceive, boolean check) {
		log.debug("createMessageSend2CangVu ");
		String dataXml;
		String identity = Long.toString(System.currentTimeMillis());
		
		Reference ref = headerReceive.getReference();
		
		ref.setMessageId("BGTVT" + identity);
		
		Header.From from = headerReceive.getFrom();
		
		String name = from.getName();
		from.setName("BGTVT");
		
		// from.setIdentity(identity);
		Subject subject = headerReceive.getSubject();
		if (check) {
			subject.setFunction(String.valueOf(MessageType.FUNCTION_TYPE_MESSAGETYPE_RESPONSE_WHEN_RECEIVE_REQUEST));
		} else {
			subject.setFunction(String.valueOf(MessageType.FUNCTION_TYPE_MESSAGETYPE_RESPONSE_WHEN_ERROR_VALIDATION));
		}
		subject.setSendDate(FormatData.parseDateToTring(new Date()));
		To to = headerReceive.getTo();
		String toIdentity = to.getIdentity();
		to.setIdentity(from.getIdentity());
		from.setIdentity(toIdentity);
		to.setName(name);
		BusinessUtils businessUtils = new BusinessUtils();
		dataXml = businessUtils.sendMessageHoSo(headerReceive, new Date());
		return dataXml;
	}
	
	// private void sendChapNhan(ObjectExcute objectExcute) {
	// try {
	// _log.debug("=============gui  sang cang vu=========== "
	// + objectExcute.getXmlData());
	// String vinamarineResponse = CallWs2CangVu.getVNMWS().sendMessage(
	// objectExcute.getXmlData());
	//
	// System.out
	// .println("======================================Nhan ve tu cang vu================= "
	// + vinamarineResponse);
	//
	// // businessUtils.insertHistoryReceiveMessageResponse(xml);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	//
	private boolean tichHop_BanKhaiAnNinh(ObjectExcute objectExcute, Header headerReceive) throws SystemException {
		boolean result = true;
		
		String function = headerReceive.getSubject().getFunction();
		
		String xmlData = objectExcute.getXmlData();
		
		String requestCodeOld = headerReceive.getReference().getMessageId();
		
		// List<Object> liObjects = MessageFactory.converXMLMessagesContentToObject(xmlData);
		//
		// result = businessUtils.validationData(headerReceive, liObjects,BusinessUtils.CangVuToBoGiaoThong);
		//
		//
		// if (!result) {
		// HistoryInterfaceRequest historyinterfaceRequest = HistoryInterfaceRequestLocalServiceUtil.findByRequestCode(requestCodeOld);
		//
		// if (historyinterfaceRequest != null) {
		// historyinterfaceRequest.setRequestState(TrangThaiHoSo.HISTORY_REQUEST_STATE_KHONG_GHI_NHAN);
		// HistoryInterfaceRequestLocalServiceUtil.updateHistoryInterfaceRequest(historyinterfaceRequest);
		// }
		// return result;
		// }
		
		// if (function.equalsIgnoreCase(MessageType.FUNCTION_THONG_BAO_DA_NHAN_DUOC)) {
		// request Codt tu sinh insert trong History_Interface_Request
		// function99(headerReceive, xmlData);
		//
		// } else
		
		if (function.equalsIgnoreCase(MessageType.FUNCTION_CHAP_NHAN_HO_SO_CHUNG_TU)) {
			
			businessUtils.insertHistory(headerReceive, xmlData, BusinessUtils.CangVuToBoGiaoThong, TrangThaiHoSo.HISTORY_REQUEST_STATE_GHI_NHAN, UUID
					.randomUUID().toString());
			
			List<TempShipSecurityMessage> temps = TempShipSecurityMessageLocalServiceUtil.findByRequestCode(requestCodeOld);
			
			if (Validator.isNotNull(temps) && temps.size() > 0) {
				
				TempShipSecurityMessage temp = temps.get(0);
				temp.setRequestState(TrangThaiHoSo.CHAP_NHAN_BAN_KHAI);
				TempShipSecurityMessageLocalServiceUtil.updateTempShipSecurityMessage(temp);
			}
			
			int documentYear = headerReceive.getSubject().getDocumentYear();
			int type = headerReceive.getSubject().getType();
			int reference = (int) headerReceive.getSubject().getReference();
			
			List<ResultDeclaration> resultDeList = ResultDeclarationLocalServiceUtil.findByDocumentNameAndBusinessTypeCodeAndDocumentYear(type,
					reference, documentYear);
			
			if (Validator.isNotNull(resultDeList) && resultDeList.size() > 0) {
				ResultDeclaration obj = resultDeList.get(0);
				obj.setRequestState(TrangThaiHoSo.CHAP_NHAN_BAN_KHAI);
				ResultDeclarationLocalServiceUtil.updateResultDeclaration(obj);
			}
			try {
				AccepterMessage accepterMessage = MessageFactory.convertXmltoAccepterMessage(xmlData);
				updateOrInsertInterfaceRequest(requestCodeOld, MessageType.FUNCTION_CHAP_NHAN_HO_SO, accepterMessage.getName(), "");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			// Gui ban tin sang HQMC: Function 21 messagetype 10
			// sendChapNhan(objectExcute);
			
		} else if (function.equalsIgnoreCase(MessageType.FUNCTION_TU_CHOI_HO_SO_CHUNG_TU)) {
			
			businessUtils.insertHistory(headerReceive, xmlData, BusinessUtils.CangVuToBoGiaoThong, TrangThaiHoSo.HISTORY_REQUEST_STATE_GHI_NHAN, UUID
					.randomUUID().toString());
			
			List<TempShipSecurityMessage> temps = TempShipSecurityMessageLocalServiceUtil.findByRequestCode(requestCodeOld);
			
			if (Validator.isNotNull(temps) && temps.size() > 0) {
				TempShipSecurityMessage temp = temps.get(0);
				temp.setRequestState(TrangThaiHoSo.TU_CHOI_BAN_KHAI);
				TempShipSecurityMessageLocalServiceUtil.updateTempShipSecurityMessage(temp);
			}
			
			int documentYear = headerReceive.getSubject().getDocumentYear();
			int type = headerReceive.getSubject().getType();
			int reference = (int) headerReceive.getSubject().getReference();
			
			List<ResultDeclaration> resultDeList = ResultDeclarationLocalServiceUtil.findByDocumentNameAndBusinessTypeCodeAndDocumentYear(type,
					reference, documentYear);
			
			if (Validator.isNotNull(resultDeList) && resultDeList.size() > 0) {
				
				ResultDeclaration obj = resultDeList.get(0);
				obj.setRequestState(TrangThaiHoSo.TU_CHOI_BAN_KHAI);
				ResultDeclarationLocalServiceUtil.updateResultDeclaration(obj);
			}
			try {
				RejectMessage rejectMessage = MessageFactory.convertXmltoRejectMessage(xmlData);
				updateOrInsertInterfaceRequest(requestCodeOld, MessageType.FUNCTION_TU_CHOI_HO_SO, rejectMessage.getName(),
						rejectMessage.getRejectDesc());
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 4, Gui ban tin sang HQMC: Neu He thong KHoNG tu choi, ma do Can bo tu choi thi gui HQMC.
			// Function 22 messagetype 10 sendChapNhan(objectExcute);
		}
		
		return result;
	}
	
	private boolean tichHop_ThongBao_TauDenCang(ObjectExcute objectExcute, Header headerReceive) throws SystemException {
		boolean result = true;
		
		String function = headerReceive.getSubject().getFunction();
		
		String xmlData = objectExcute.getXmlData();
		
		// Trang thai request ban dau
		String requestCodeOld = headerReceive.getReference().getMessageId();
		
		// List<Object> liObjects = MessageFactory.converXMLMessagesContentToObject(xmlData);
		//
		// result = businessUtils.validationData(headerReceive, liObjects,
		// BusinessUtils.CangVuToBoGiaoThong);
		// if (!result) {
		// HistoryInterfaceRequest historyinterfaceRequest = HistoryInterfaceRequestLocalServiceUtil.findByRequestCode(requestCodeOld);
		//
		// if (historyinterfaceRequest != null) {
		// historyinterfaceRequest.setRequestState(TrangThaiHoSo.HISTORY_REQUEST_STATE_KHONG_GHI_NHAN);
		// HistoryInterfaceRequestLocalServiceUtil.updateHistoryInterfaceRequest(historyinterfaceRequest);
		// }
		// return result;
		// }
		// if (function.equalsIgnoreCase(MessageType.FUNCTION_TU_CHOI_HO_SO_CHUNG_TU)) {
		// request Code tu sinh insert trong History_Interface_Request
		// function99(headerReceive, xmlData);
		//
		// } else
		
		if (function.equalsIgnoreCase(MessageType.FUNCTION_CHAP_NHAN_HO_SO_CHUNG_TU)) {
			
			businessUtils.insertHistory(headerReceive, xmlData, BusinessUtils.CangVuToBoGiaoThong, TrangThaiHoSo.HISTORY_REQUEST_STATE_GHI_NHAN, UUID
					.randomUUID().toString());
			
			TempNoTiceShipMessage tempTBs = TempNoTiceShipMessageLocalServiceUtil.findTempNoTiceShipMessageTbByRequestCode(requestCodeOld);
			
			if (Validator.isNotNull(tempTBs)) {
				tempTBs.setRequestState(TrangThaiHoSo.CHAP_NHAN_BAN_KHAI);
				TempNoTiceShipMessageLocalServiceUtil.updateTempNoTiceShipMessage(tempTBs);
			}
			
			int documentYear = headerReceive.getSubject().getDocumentYear();
			int type = headerReceive.getSubject().getType();
			int reference = (int) headerReceive.getSubject().getReference();
			
			List<ResultDeclaration> resultDeList = ResultDeclarationLocalServiceUtil.findByDocumentNameAndBusinessTypeCodeAndDocumentYear(type,
					reference, documentYear);
			
			if (Validator.isNotNull(resultDeList) && resultDeList.size() > 0) {
				ResultDeclaration obj = resultDeList.get(0);
				obj.setRequestState(TrangThaiHoSo.CHAP_NHAN_BAN_KHAI);
				ResultDeclarationLocalServiceUtil.updateResultDeclaration(obj);
			}
			
			try {
				AccepterMessage accepterMessage = MessageFactory.convertXmltoAccepterMessage(xmlData);
				updateOrInsertInterfaceRequest(requestCodeOld, MessageType.FUNCTION_CHAP_NHAN_HO_SO, accepterMessage.getName(), "");
			} catch (Exception e) {
				e.printStackTrace();
			}
			// updateOrInsertInterfaceRequest(requestCodeOld,
			// MessageType.FUNCTION_CHAP_NHAN_HO_SO);
			// 4, GUI ban tin sang HQMC
			// sendChapNhan(objectExcute);
			
		} else if (function.equalsIgnoreCase(MessageType.FUNCTION_TU_CHOI_HO_SO_CHUNG_TU)) {
			
			businessUtils.insertHistory(headerReceive, xmlData, BusinessUtils.CangVuToBoGiaoThong, TrangThaiHoSo.HISTORY_REQUEST_STATE_GHI_NHAN, UUID
					.randomUUID().toString());
			
			TempNoTiceShipMessage tempTB = TempNoTiceShipMessageLocalServiceUtil.findTempNoTiceShipMessageTbByRequestCode(requestCodeOld);
			
			if (Validator.isNotNull(tempTB)) {
				tempTB.setRequestState(TrangThaiHoSo.TU_CHOI_BAN_KHAI);
				TempNoTiceShipMessageLocalServiceUtil.updateTempNoTiceShipMessage(tempTB);
			}
			
			int documentYear = headerReceive.getSubject().getDocumentYear();
			int type = headerReceive.getSubject().getType();
			int reference = (int) headerReceive.getSubject().getReference();
			
			List<ResultDeclaration> resultDeList = ResultDeclarationLocalServiceUtil.findByDocumentNameAndBusinessTypeCodeAndDocumentYear(type,
					reference, documentYear);
			
			if (Validator.isNotNull(resultDeList) && resultDeList.size() > 0) {
				ResultDeclaration obj = resultDeList.get(0);
				obj.setRequestState(TrangThaiHoSo.TU_CHOI_BAN_KHAI);
				ResultDeclarationLocalServiceUtil.updateResultDeclaration(obj);
			}
			try {
				RejectMessage rejectMessage = MessageFactory.convertXmltoRejectMessage(xmlData);
				updateOrInsertInterfaceRequest(requestCodeOld, MessageType.FUNCTION_TU_CHOI_HO_SO, rejectMessage.getName(),
						rejectMessage.getRejectDesc());
			} catch (Exception e) {
				e.printStackTrace();
			}
			// Gui ban tin sang HQMC: Neu He thong KHoNG tu choi, ma do Can bo
			// tu choi thi gui HQMC.
			// Function 22 messagetype 10
			// sendChapNhan(objectExcute);
		}
		return result;
	}
	
	private boolean tichHop_BanKhaiHangHoa(ObjectExcute objectExcute, Header headerReceive) {
		boolean result = true;
		
		return result;
	}
	
	private boolean tichHop_XacBao_TauDenCang(ObjectExcute objectExcute, Header headerReceive) throws SystemException {
		boolean result = true;
		String function = headerReceive.getSubject().getFunction();
		
		String xmlData = objectExcute.getXmlData();
		
		List<Object> liObjects = MessageFactory.converXMLMessagesContentToObject(xmlData);
		
		result = businessUtils.validationData(headerReceive, liObjects, BusinessUtils.CangVuToBoGiaoThong);
		
		// Trang thai request ban dau
		String requestCodeOld = headerReceive.getReference().getMessageId();
		
		if (!result) {
			HistoryInterfaceRequest hiRequest = HistoryInterfaceRequestLocalServiceUtil.findByRequestCode(requestCodeOld);
			
			if (hiRequest != null) {
				hiRequest.setRequestState(TrangThaiHoSo.HISTORY_REQUEST_STATE_KHONG_GHI_NHAN);
				HistoryInterfaceRequestLocalServiceUtil.updateHistoryInterfaceRequest(hiRequest);
			}
			return result;
		}
		
		if (function.equalsIgnoreCase(MessageType.FUNCTION_CHAP_NHAN_HO_SO_CHUNG_TU)) {
			
			businessUtils.insertHistory(headerReceive, xmlData, BusinessUtils.CangVuToBoGiaoThong, TrangThaiHoSo.HISTORY_REQUEST_STATE_GHI_NHAN, UUID
					.randomUUID().toString());
			
			TempNoTiceShipMessage tempXB = TempNoTiceShipMessageLocalServiceUtil.findTempNoTiceShipMessageXbByRequestCode(requestCodeOld);
			if (Validator.isNotNull(tempXB)) {
				tempXB.setRequestState(TrangThaiHoSo.CHAP_NHAN_BAN_KHAI);
				TempNoTiceShipMessageLocalServiceUtil.updateTempNoTiceShipMessage(tempXB);
			}
			
			int documentYear = headerReceive.getSubject().getDocumentYear();
			int type = headerReceive.getSubject().getType();
			int reference = (int) headerReceive.getSubject().getReference();
			
			List<ResultDeclaration> resultDeList = ResultDeclarationLocalServiceUtil.findByDocumentNameAndBusinessTypeCodeAndDocumentYear(type,
					reference, documentYear);
			
			if (Validator.isNotNull(resultDeList) && resultDeList.size() > 0) {
				ResultDeclaration obj = resultDeList.get(0);
				obj.setRequestState(TrangThaiHoSo.CHAP_NHAN_BAN_KHAI);
				ResultDeclarationLocalServiceUtil.updateResultDeclaration(obj);
			}
			
		} else if (function.equalsIgnoreCase(MessageType.FUNCTION_TU_CHOI_HO_SO_CHUNG_TU)) {
			businessUtils.insertHistory(headerReceive, xmlData, BusinessUtils.CangVuToBoGiaoThong, TrangThaiHoSo.HISTORY_REQUEST_STATE_GHI_NHAN, UUID
					.randomUUID().toString());
			
			TempNoTiceShipMessage tempXB = TempNoTiceShipMessageLocalServiceUtil.findTempNoTiceShipMessageXbByRequestCode(requestCodeOld);
			if (Validator.isNotNull(tempXB)) {
				tempXB.setRequestState(TrangThaiHoSo.TU_CHOI_BAN_KHAI);
				TempNoTiceShipMessageLocalServiceUtil.updateTempNoTiceShipMessage(tempXB);
			}
			
			int documentYear = headerReceive.getSubject().getDocumentYear();
			int type = headerReceive.getSubject().getType();
			int reference = (int) headerReceive.getSubject().getReference();
			List<ResultDeclaration> resultDeList = ResultDeclarationLocalServiceUtil.findByDocumentNameAndBusinessTypeCodeAndDocumentYear(type,
					reference, documentYear);
			
			if (Validator.isNotNull(resultDeList) && resultDeList.size() > 0) {
				ResultDeclaration obj = resultDeList.get(0);
				obj.setRequestState(TrangThaiHoSo.TU_CHOI_BAN_KHAI);
				ResultDeclarationLocalServiceUtil.updateResultDeclaration(obj);
			}
			
		}
		return result;
	}
	
	private boolean tichHop_HoSo(ObjectExcute objectExcute, Header headerReceive) throws SystemException {
		boolean result = true;
		String function = headerReceive.getSubject().getFunction();
		
		String xmlData = objectExcute.getXmlData();
		
		List<Object> liObjects = MessageFactory.converXMLMessagesContentToObject(xmlData);
		
		result = businessUtils.validationData(headerReceive, liObjects, BusinessUtils.CangVuToBoGiaoThong);
		
		// Trang thai request ban dau
		String requestCodeOld = headerReceive.getReference().getMessageId();
		
		if (!result) {
			HistoryInterfaceRequest hiRequest = HistoryInterfaceRequestLocalServiceUtil.findByRequestCode(requestCodeOld);
			
			if (hiRequest != null) {
				hiRequest.setRequestState(TrangThaiHoSo.HISTORY_REQUEST_STATE_KHONG_GHI_NHAN);
				HistoryInterfaceRequestLocalServiceUtil.updateHistoryInterfaceRequest(hiRequest);
			}
			
			return result;
		}
		
		if (function.equalsIgnoreCase(MessageType.FUNCTION_CHAP_NHAN_HO_SO_CHUNG_TU)) {
			
			businessUtils.insertHistory(headerReceive, xmlData, BusinessUtils.CangVuToBoGiaoThong, TrangThaiHoSo.HISTORY_REQUEST_STATE_GHI_NHAN, UUID
					.randomUUID().toString());
			
			List<TempDocument> documents = TempDocumentLocalServiceUtil.findTemDocumentByDocumentNameAndDocumentYear((new Long(headerReceive
					.getSubject().getReference())).intValue(), headerReceive.getSubject().getDocumentYear());
			
			if (documents != null && documents.size() > 0) {
				TempDocument document = documents.get(0);
				
				if (document.getDocumentTypeCode().equals(MessageType.LOAT_THU_TUC_XUAT_CANH)) {
					
					if (document.getDocumentStatusCode() == TrangThaiHoSo.YEU_CAU_SUA_DOI_BO_SUNG
							| document.getDocumentStatusCode() == TrangThaiHoSo.DA_TIEP_NHAP) {
						
						document.setDocumentStatusCode(TrangThaiHoSo.CHO_PHE_DUYET_HOAN_THANH_THU_TUC);
					}
					
					// --------
					if (document.getRequestState() == TrangThaiHoSo.TEMP_DOCUMENT_CHO_TIEP_NHAN) {
						
						document.setRequestState(TrangThaiHoSo.KE_HOACH_TIEP_NHAN);
						document.setDocumentStatusCode(TrangThaiHoSo.DA_TIEP_NHAP);
					}
					
					TempDocumentLocalServiceUtil.updateTempDocument(document);
					
				} else if (document.getDocumentTypeCode().equals(MessageType.LOAT_THU_TUC_NHAP_CANH)) {
					
					if (document.getDocumentStatusCode() == TrangThaiHoSo.DA_TIEP_NHAP
							|| document.getDocumentStatusCode() == TrangThaiHoSo.YEU_CAU_SUA_DOI_BO_SUNG) {
						
						document.setDocumentStatusCode(TrangThaiHoSo.CHO_PHE_DUYET_HOAN_THANH_THU_TUC);
						
					}
					
					if (document.getRequestState() == TrangThaiHoSo.TEMP_DOCUMENT_CHO_TIEP_NHAN) {
						
						document.setRequestState(TrangThaiHoSo.CHO_CAP_LENH_DIEU_DONG);
					}
					
					TempDocumentLocalServiceUtil.updateTempDocument(document);
				}
				
			}
			
		} else if (function.equalsIgnoreCase(MessageType.FUNCTION_TU_CHOI_HO_SO_CHUNG_TU)) {
			
			businessUtils.insertHistory(headerReceive, xmlData, BusinessUtils.CangVuToBoGiaoThong, TrangThaiHoSo.HISTORY_REQUEST_STATE_GHI_NHAN, UUID
					.randomUUID().toString());
			
			List<TempDocument> documents = TempDocumentLocalServiceUtil.findTemDocumentByDocumentNameAndDocumentYear((new Long(headerReceive
					.getSubject().getReference())).intValue(), headerReceive.getSubject().getDocumentYear());
			
			if (documents != null && documents.size() > 0) {
				TempDocument temp = documents.get(0);
				if (temp.getDocumentStatusCode() == TrangThaiHoSo.DA_TIEP_NHAP) {
					temp.setDocumentStatusCode(TrangThaiHoSo.YEU_CAU_SUA_DOI_BO_SUNG);
				}
				
				if (temp.getRequestState() == TrangThaiHoSo.TEMP_DOCUMENT_CHO_TIEP_NHAN) {
					temp.setRequestState(TrangThaiHoSo.KE_HOACH_TU_CHOI_TIEP_NHAN);
				}
				
				TempDocumentLocalServiceUtil.updateTempDocument(temp);
			}
			
			// 4, Gui ban tin sang HQMC:, Function 22 messagetype 99
			// sendChapNhan(objectExcute);
			
		} else if (function.equalsIgnoreCase(MessageType.FUNCTION_XAC_NHAN_HOAN_THANH_THU_TUC)) {
			
			long documentName = headerReceive.getSubject().getReference();
			int documentYear = headerReceive.getSubject().getDocumentYear();
			
			businessUtils.insertHistory(headerReceive, xmlData, BusinessUtils.CangVuToBoGiaoThong, TrangThaiHoSo.HISTORY_REQUEST_STATE_GHI_NHAN, UUID
					.randomUUID().toString());
			
			List<TempDocument> documents = TempDocumentLocalServiceUtil.findTemDocumentByDocumentNameAndDocumentYear((new Long(headerReceive
					.getSubject().getReference())).intValue(), headerReceive.getSubject().getDocumentYear());
			
			if (documents != null && documents.size() > 0) {
				TempDocument temp = documents.get(0);
				if (temp.getDocumentStatusCode() == TrangThaiHoSo.CHO_PHE_DUYET_HOAN_THANH_THU_TUC) {
					temp.setDocumentStatusCode(TrangThaiHoSo.PHE_DUYET_HOAN_THANH_THU_TUC);
				}
				updateOrInsertResultCompetion(temp, MessageType.DA_PHE_DUYET);
				TempDocumentLocalServiceUtil.updateTempDocument(temp);
				
				doiChieuBanKhaiChoPheDuyet(MessageType.BAN_KHAI_AN_NINH_TAU_BIEN, documentName, documentYear);
				doiChieuBanKhaiChoPheDuyet(MessageType.BAN_KHAI_CHUNG, documentName, documentYear);
				doiChieuBanKhaiChoPheDuyet(MessageType.BAN_KHAI_DANH_SACH_THUYEN_VIEN, documentName, documentYear);
				doiChieuBanKhaiChoPheDuyet(MessageType.BAN_KHAI_DANH_SACH_HANG_HOA_NGUY_HIEM, documentName, documentYear);
			}
			
		} else if (function.equalsIgnoreCase(MessageType.FUNCTION_XAC_NHAN_HUY_THU_TUC)) {
			
			result = xacNhanHuyThuTuc(objectExcute, headerReceive, result, xmlData);
			
		}
		return result;
	}
	
	
	
	private boolean tichHop_ThongBao_TauRoiCang(ObjectExcute objectExcute, Header headerReceive) throws SystemException {
		boolean result = true;
		log.debug("tichHop_ThongBao_TauRoiCang ");
		String function = headerReceive.getSubject().getFunction();
		
		String xmlData = objectExcute.getXmlData();
		
		log.debug("result " + result);
		// Trang thai request ban dau
		String requestCodeOld = headerReceive.getReference().getMessageId();
		
		log.debug("function " + function);
		
		if (function.equalsIgnoreCase(MessageType.FUNCTION_CHAP_NHAN_HO_SO_CHUNG_TU)) {
			
			log.debug("MessageType.FUNCTION_CHAP_NHAN_HO_SO_CHUNG_TU " + MessageType.FUNCTION_CHAP_NHAN_HO_SO_CHUNG_TU);
			
			businessUtils.insertHistory(headerReceive, xmlData, BusinessUtils.CangVuToBoGiaoThong, TrangThaiHoSo.HISTORY_REQUEST_STATE_GHI_NHAN, UUID
					.randomUUID().toString());
			
			// TODO ----- dieu kien thuc tuc xuat canh
			List<TempDocument> documents = TempDocumentLocalServiceUtil.findTemDocumentByDocumentNameAndDocumentYear((new Long(headerReceive
					.getSubject().getReference())).intValue(), headerReceive.getSubject().getDocumentYear());
			
			if (documents != null && documents.size() > 0) {
				TempDocument temp = documents.get(0);
				if (temp.getRequestState() == TrangThaiHoSo.TEMP_DOCUMENT_CHO_TIEP_NHAN) {
					
					temp.setRequestState(TrangThaiHoSo.KE_HOACH_TIEP_NHAN);
					temp.setDocumentStatusCode(TrangThaiHoSo.DA_TIEP_NHAP);
					
					TempDocumentLocalServiceUtil.updateTempDocument(temp);
				}
			}
			
			TempNoTiceShipMessage tempTB = TempNoTiceShipMessageLocalServiceUtil.findTempNoTiceShipMessageTbByRequestCode(requestCodeOld);
			
			if (tempTB != null) {
				
				log.debug("(tempTB!=null ");
				tempTB.setRequestState(TrangThaiHoSo.CHAP_NHAN_BAN_KHAI);
				TempNoTiceShipMessageLocalServiceUtil.updateTempNoTiceShipMessage(tempTB);
				
			} else {
				
				log.debug("(tempTB==null ");
			}
			
			int documentYear = headerReceive.getSubject().getDocumentYear();
			int type = headerReceive.getSubject().getType();
			int reference = (int) headerReceive.getSubject().getReference();
			
			List<ResultDeclaration> resultDeList = ResultDeclarationLocalServiceUtil.findByDocumentNameAndBusinessTypeCodeAndDocumentYear(type,
					reference, documentYear);
			
			if (Validator.isNotNull(resultDeList) && resultDeList.size() > 0) {
				ResultDeclaration obj = resultDeList.get(0);
				obj.setRequestState(TrangThaiHoSo.CHAP_NHAN_BAN_KHAI);
				ResultDeclarationLocalServiceUtil.updateResultDeclaration(obj);
			}
			
			try {
				AccepterMessage accepterMessage = MessageFactory.convertXmltoAccepterMessage(xmlData);
				updateOrInsertInterfaceRequest(requestCodeOld, MessageType.FUNCTION_CHAP_NHAN_HO_SO, accepterMessage.getName(), "");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			// 4, Gui ban tin sang HQMC: Function 21 messagetype 31
			// sendChapNhan(objectExcute);
			
		} else if (function.equalsIgnoreCase(MessageType.FUNCTION_TU_CHOI_HO_SO_CHUNG_TU)) {
			log.debug("MessageType.FUNCTION_TU_CHOI_HO_SO_CHUNG_TU " + MessageType.FUNCTION_TU_CHOI_HO_SO_CHUNG_TU);
			
			businessUtils.insertHistory(headerReceive, xmlData, BusinessUtils.CangVuToBoGiaoThong, TrangThaiHoSo.HISTORY_REQUEST_STATE_GHI_NHAN, UUID
					.randomUUID().toString());
			
			TempNoTiceShipMessage tempTB = TempNoTiceShipMessageLocalServiceUtil.findTempNoTiceShipMessageTbByRequestCode(requestCodeOld);
			
			if (tempTB != null) {
				log.debug("(tempTB!=null ");
				tempTB.setRequestState(TrangThaiHoSo.TU_CHOI_BAN_KHAI);
				TempNoTiceShipMessageLocalServiceUtil.updateTempNoTiceShipMessage(tempTB);
				
			} else {
				log.debug("(tempTB==null ");
			}
			
			int documentYear = headerReceive.getSubject().getDocumentYear();
			int type = headerReceive.getSubject().getType();
			int reference = (int) headerReceive.getSubject().getReference();
			
			List<ResultDeclaration> resultDeList = ResultDeclarationLocalServiceUtil.findByDocumentNameAndBusinessTypeCodeAndDocumentYear(type,
					reference, documentYear);
			
			if (Validator.isNotNull(resultDeList) && resultDeList.size() > 0) {
				
				ResultDeclaration obj = resultDeList.get(0);
				obj.setRequestState(TrangThaiHoSo.TU_CHOI_BAN_KHAI);
				ResultDeclarationLocalServiceUtil.updateResultDeclaration(obj);
			}
			try {
				RejectMessage rejectMessage = MessageFactory.convertXmltoRejectMessage(xmlData);
				updateOrInsertInterfaceRequest(requestCodeOld, MessageType.FUNCTION_TU_CHOI_HO_SO, rejectMessage.getName(),
						rejectMessage.getRejectDesc());
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 4, Gui ban tin sang HQMC: Function 22 messagetype 31
			// sendChapNhan(objectExcute);
		}
		return result;
	}
	
	private boolean tichHop_LenhDieuDong(ObjectExcute objectExcute, Header headerReceive) throws SystemException {
		log.debug("tichHop_LenhDieuDong");
		boolean result = true;
		
		String function = headerReceive.getSubject().getFunction();
		
		String xmlData = objectExcute.getXmlData();
		
		List<Object> liObjects = MessageFactory.converXMLMessagesContentToObject(xmlData);
		
		// Validation cang vu gui sang
		result = cangvuBussionessUtils.validationDataCangVuToHaiQuan(headerReceive, liObjects, BusinessUtils.CangVuToBoGiaoThong);
		
		// Trang thai request ban dau
		String requestCodeOld = headerReceive.getReference().getMessageId();
		log.debug("requestCodeOld  " + requestCodeOld + " result  " + result);
		if (!result) {
			HistoryInterfaceRequest hiRequest = HistoryInterfaceRequestLocalServiceUtil.findByRequestCode(requestCodeOld);
			
			if (hiRequest != null) {
				hiRequest.setRequestState(TrangThaiHoSo.HISTORY_REQUEST_STATE_KHONG_GHI_NHAN);
				HistoryInterfaceRequestLocalServiceUtil.updateHistoryInterfaceRequest(hiRequest);
			}
			return result;
		}
		
		if (function.equalsIgnoreCase(MessageType.FUNCTION_KHAI_BAO)) {
			log.debug("MessageType.FUNCTION_KHAI_BAO  " + MessageType.FUNCTION_KHAI_BAO);
			businessUtils.insertHistory(headerReceive, xmlData, BusinessUtils.CangVuToBoGiaoThong, TrangThaiHoSo.HISTORY_REQUEST_STATE_GHI_NHAN, UUID
					.randomUUID().toString());
			
			List<TempDocument> documents = TempDocumentLocalServiceUtil.findTemDocumentByDocumentNameAndDocumentYear((new Long(headerReceive
					.getSubject().getReference())).intValue(), headerReceive.getSubject().getDocumentYear());
			
			if (documents != null && documents.size() > 0) {
				
				TempDocument document = documents.get(0);
				
				log.debug("document  " + MessageType.FUNCTION_KHAI_BAO);
				
				if (document.getRequestState() == TrangThaiHoSo.CHO_CAP_LENH_DIEU_DONG
						| document.getRequestState() == TrangThaiHoSo.TEMP_DOCUMENT_CHO_TIEP_NHAN) {
					
					document.setRequestState(TrangThaiHoSo.DA_CAP_LENH_DIEU_DONG);
					document.setDocumentStatusCode(TrangThaiHoSo.DA_TIEP_NHAP);
					document.setShipPosition(MessageType.SHIP_POSSITION_TRONG_CANG);
					
					TempDocumentLocalServiceUtil.updateTempDocument(document);
					log.debug("ocument.getRequestState()  " + document.getRequestState());
					
					// TODO insert vao issue_shifting_order
					try {
						cangvuBussionessUtils.insertIssueTable(headerReceive, liObjects);
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}
			}
		}
		return result;
	}
	
private boolean tichHop_GiayPhep_RoiCang(ObjectExcute objectExcute, Header headerReceive) throws SystemException {
		
		boolean result = true;
		
		String function = headerReceive.getSubject().getFunction();
		
		String xmlData = objectExcute.getXmlData();
		
		List<Object> liObjects = MessageFactory.converXMLMessagesContentToObject(xmlData);
		
		result = cangvuBussionessUtils.validationDataCangVuToHaiQuan(headerReceive, liObjects, BusinessUtils.CangVuToBoGiaoThong);
		
		// Trang thai request ban dau
		String requestCodeOld = headerReceive.getReference().getMessageId();
		log.debug(" validationDataCangVuToHaiQuan  " + result + " requestCodeOld  " + requestCodeOld);
		if (!result) {
			HistoryInterfaceRequest hiRequest = HistoryInterfaceRequestLocalServiceUtil.findByRequestCode(requestCodeOld);
			
			if (hiRequest != null) {
				hiRequest.setRequestState(TrangThaiHoSo.HISTORY_REQUEST_STATE_KHONG_GHI_NHAN);
				HistoryInterfaceRequestLocalServiceUtil.updateHistoryInterfaceRequest(hiRequest);
			}
			return result;
		}
		
		if (function.equalsIgnoreCase(MessageType.FUNCTION_KHAI_BAO)) {
			log.debug("MessageType.FUNCTION_KHAI_BAO  " + MessageType.FUNCTION_KHAI_BAO);
			businessUtils.insertHistory(headerReceive, xmlData, BusinessUtils.CangVuToBoGiaoThong, TrangThaiHoSo.HISTORY_REQUEST_STATE_GHI_NHAN, UUID
					.randomUUID().toString());
			
			List<TempDocument> documents = TempDocumentLocalServiceUtil.findTemDocumentByDocumentNameAndDocumentYear((new Long(headerReceive
					.getSubject().getReference())).intValue(), headerReceive.getSubject().getDocumentYear());
			
			if (documents != null && documents.size() > 0) {
				TempDocument document = documents.get(0);
				log.debug("document.getDocumentStatusCode()   " + document.getDocumentStatusCode());
				
				if (document.getDocumentStatusCode() == TrangThaiHoSo.CHO_PHE_DUYET_HOAN_THANH_THU_TUC
						|| document.getDocumentStatusCode() == TrangThaiHoSo.DA_TIEP_NHAP) {
					
					document.setDocumentStatusCode(TrangThaiHoSo.PHE_DUYET_HOAN_THANH_THU_TUC);
					TempDocumentLocalServiceUtil.updateTempDocument(document);
				}
				
				log.debug("document.getDocumentStatusCode()   " + document.getDocumentStatusCode());
				
				if (document.getDocumentStatusCode() == TrangThaiHoSo.PHE_DUYET_HOAN_THANH_THU_TUC) {
					// insert IssuePortClearance
					try {
						cangvuBussionessUtils.insertIssueTable(headerReceive, liObjects);
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}
			}
		}
		
		return result;
	}
	
	private boolean huyLenhDieuDong(ObjectExcute objectExcute, Header headerReceive) throws SystemException {
		boolean result = true;
		
		TempDocument temp = TempDocumentLocalServiceUtil.findTemDocumentByDocumentNameDocumentYear(headerReceive.getSubject().getReference(),
				headerReceive.getSubject().getDocumentYear());
		
		temp.setRequestState(TrangThaiBanKhaiNhapCanh.DA_HUY_LENH_DIEU_DONG);
		temp.setDocumentStatusCode(TrangThaiBanKhaiNhapCanh.HUY_THU_TUC_TAU_THUYEN_NHAP_CANH);
		TempDocumentLocalServiceUtil.updateTempDocument(temp);
		
		List<IssueShiftingOrder> lstShiftOrder = IssueShiftingOrderLocalServiceUtil.findByDocumentYearAndDocumentYearOrderByColumn(headerReceive
				.getSubject().getReference(), headerReceive.getSubject().getDocumentYear(), KeyParams.VERSION_NO, KeyParams.ORDER_BY_DESC);
		for (IssueShiftingOrder item : lstShiftOrder) {
			item.setRequestState(TrangThaiBanKhaiNhapCanh.KHAI_HUY);
			IssueShiftingOrderLocalServiceUtil.updateIssueShiftingOrder(item);
		}
		try {
			
			Object obj = MessageFactory.convertXmltoObject(MessageType.HUY_LENH_DIEU_DONG, objectExcute.getXmlData());
			
			ResultNotification notification = ResultNotificationLocalServiceUtil.findByBusinessTypeCodeOrderbyLastestDate(
					MessageType.XAC_NHAN_HUY_LENH_DIEU_DONG + "", headerReceive.getSubject().getReference(), headerReceive.getSubject()
							.getDocumentYear());
			if (notification == null) {
				notification = new ResultNotificationImpl();
				if (obj instanceof XacNhanHuyLenhDieuDong) {
					
					notification.setBusinessTypeCode(MessageType.XAC_NHAN_HUY_LENH_DIEU_DONG);
					
					notification.setDocumentName(headerReceive.getSubject().getReference());
					notification.setDocumentYear(headerReceive.getSubject().getDocumentYear());
					notification.setLatestDate(headerReceive.getSubject().getSendDate());
					notification.setRequestCode(headerReceive.getReference().getMessageId());
					if (temp != null) {
						notification.setMaritimeCode(temp.getMaritimeCode());
					}
					notification.setResponse(((XacNhanHuyLenhDieuDong) obj).getReason());
					
					notification.setResponseTime(FormatData.parseStringToDate(((XacNhanHuyLenhDieuDong) obj).getCancelDate()));
					notification.setOrganization(((XacNhanHuyLenhDieuDong) obj).getOrganization());
					notification.setOfficerName(((XacNhanHuyLenhDieuDong) obj).getName());
					notification.setDivision(((XacNhanHuyLenhDieuDong) obj).getDivision());
					notification.setRole(2);
					notification.setRequestState(new Integer(((XacNhanHuyLenhDieuDong) obj).getIsApprove()));
					notification.setIsReply(1);
					
				}
				
				ResultNotificationLocalServiceUtil.addResultNotification(notification);
			} else {
				if (obj instanceof XacNhanHuyLenhDieuDong) {
					
					notification.setBusinessTypeCode(MessageType.XAC_NHAN_HUY_LENH_DIEU_DONG);
					
					notification.setDocumentName(headerReceive.getSubject().getReference());
					notification.setDocumentYear(headerReceive.getSubject().getDocumentYear());
					if (temp != null) {
						notification.setMaritimeCode(temp.getMaritimeCode());
					}
					notification.setResponse(((XacNhanHuyLenhDieuDong) obj).getReason());
					notification.setResponseTime(FormatData.parseStringToDate(((XacNhanHuyLenhDieuDong) obj).getCancelDate()));
					notification.setOrganization(((XacNhanHuyLenhDieuDong) obj).getOrganization());
					notification.setOfficerName(((XacNhanHuyLenhDieuDong) obj).getName());
					notification.setDivision(((XacNhanHuyLenhDieuDong) obj).getDivision());
					notification.setRole(2);
					notification.setRequestState(new Integer(((XacNhanHuyLenhDieuDong) obj).getIsApprove()));
					notification.setIsReply(1);
					
				}
				ResultNotificationLocalServiceUtil.updateResultNotification(notification);
			}
			
		} catch (Exception e) {
			result = false;
			e.printStackTrace();
		}
		
		return result;
	}
	
	private boolean yCauLuuLaiGiayPhepRoiCang(ObjectExcute objectExcute, Header headerReceive) throws SystemException {
		boolean result = true;
		try {
			TempDocument temp = TempDocumentLocalServiceUtil.findTemDocumentByDocumentNameDocumentYear(headerReceive.getSubject().getReference(),
					headerReceive.getSubject().getDocumentYear());
			
			DeNghiCapLaiGiayPhep deNghiCapLaiGiayPhep = MessageFactory.convertXmltoDeNghiCapLaiGiayPhep(objectExcute.getXmlData());
			
			ResultNotification notification = ResultNotificationLocalServiceUtil.findByBusinessTypeCodeOrderbyLastestDate(
					MessageType.Y_CAU_CAP_LAI_GIAY_PHEP_ROI_CANG + "", headerReceive.getSubject().getReference(), headerReceive.getSubject()
							.getDocumentYear());
			if (notification == null) {
				notification = new ResultNotificationImpl();
				
				notification.setBusinessTypeCode(MessageType.Y_CAU_CAP_LAI_GIAY_PHEP_ROI_CANG);
				
				notification.setDocumentName(headerReceive.getSubject().getReference());
				notification.setDocumentYear(headerReceive.getSubject().getDocumentYear());
				notification.setLatestDate(headerReceive.getSubject().getSendDate());
				notification.setRequestCode(headerReceive.getReference().getMessageId());
				if (temp != null) {
					notification.setMaritimeCode(temp.getMaritimeCode());
				}
				notification.setResponse(deNghiCapLaiGiayPhep.getReason());
				notification.setResponseTime(FormatData.parseStringToDate(deNghiCapLaiGiayPhep.getRenewDate()));
				notification.setOrganization(deNghiCapLaiGiayPhep.getOrganization());
				notification.setOfficerName(deNghiCapLaiGiayPhep.getName());
				notification.setDivision(deNghiCapLaiGiayPhep.getDivision());
				notification.setRole(4);
				notification.setRequestState(1);
				notification.setIsReply(1);
				
				ResultNotificationLocalServiceUtil.addResultNotification(notification);
			} else {
				
				notification.setBusinessTypeCode(MessageType.Y_CAU_CAP_LAI_GIAY_PHEP_ROI_CANG);
				
				notification.setDocumentName(headerReceive.getSubject().getReference());
				notification.setDocumentYear(headerReceive.getSubject().getDocumentYear());
				notification.setRequestCode(headerReceive.getReference().getMessageId());
				if (temp != null) {
					notification.setMaritimeCode(temp.getMaritimeCode());
				}
				notification.setResponse(deNghiCapLaiGiayPhep.getReason());
				notification.setResponseTime(FormatData.parseStringToDate(deNghiCapLaiGiayPhep.getRenewDate()));
				notification.setOrganization(deNghiCapLaiGiayPhep.getOrganization());
				notification.setOfficerName(deNghiCapLaiGiayPhep.getName());
				notification.setDivision(deNghiCapLaiGiayPhep.getDivision());
				notification.setRole(4);
				notification.setRequestState(1);
				notification.setIsReply(1);
				
				ResultNotificationLocalServiceUtil.updateResultNotification(notification);
			}
			
		} catch (Exception e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}
	
	private boolean xacNhanHuyThuTuc(ObjectExcute objectExcute, Header headerReceive, boolean result, String xmlData) throws SystemException {
		businessUtils.insertHistory(headerReceive, xmlData, BusinessUtils.CangVuToBoGiaoThong, TrangThaiHoSo.HISTORY_REQUEST_STATE_GHI_NHAN, UUID
				.randomUUID().toString());
		
		List<TempDocument> documents = TempDocumentLocalServiceUtil.findTemDocumentByDocumentNameAndDocumentYear((new Long(headerReceive.getSubject()
				.getReference())).intValue(), headerReceive.getSubject().getDocumentYear());
		
		if (documents != null && documents.size() > 0) {
			TempDocument temp = documents.get(0);
			
			if (temp.getDocumentStatusCode() == TrangThaiHoSo.CHO_PHE_DUYET_HOAN_THANH_THU_TUC
					| temp.getDocumentStatusCode() == TrangThaiHoSo.YEU_CAU_SUA_DOI_BO_SUNG) {
				temp.setDocumentStatusCode(TrangThaiHoSo.HUY_THU_TUC);
			}
			updateOrInsertResultCompetion(temp, MessageType.TU_CHOI);
			TempDocumentLocalServiceUtil.updateTempDocument(temp);
		}
		try {
			TempDocument temp = documents.get(0);
			Object obj = MessageFactory.convertXmltoObject(MessageType.KHAI_HUY_HO_SO, objectExcute.getXmlData());
			
			ResultNotification reNotifi = ResultNotificationLocalServiceUtil.findByBusinessTypeCodeOrderbyLastestDate(
					MessageType.KHAI_HUY_HO_SO + "", headerReceive.getSubject().getReference(), headerReceive.getSubject().getDocumentYear());
			if (reNotifi == null) {
				reNotifi = new ResultNotificationImpl();
				if (obj instanceof XacNhanHuyThuTuc) {
					
					reNotifi.setBusinessTypeCode(MessageType.KHAI_HUY_HO_SO);
					
					reNotifi.setDocumentName(headerReceive.getSubject().getReference());
					reNotifi.setDocumentYear(headerReceive.getSubject().getDocumentYear());
					reNotifi.setLatestDate(headerReceive.getSubject().getSendDate());
					reNotifi.setRequestCode(headerReceive.getReference().getMessageId());
					if (temp != null) {
						reNotifi.setMaritimeCode(temp.getMaritimeCode());
					}
					reNotifi.setResponse(((XacNhanHuyThuTuc) obj).getReason());
					reNotifi.setResponseTime(FormatData.parseStringToDate(((XacNhanHuyThuTuc) obj).getCancelDate()));
					reNotifi.setOrganization(((XacNhanHuyThuTuc) obj).getOrganization());
					reNotifi.setOfficerName(((XacNhanHuyThuTuc) obj).getName());
					reNotifi.setDivision(((XacNhanHuyThuTuc) obj).getDivision());
					reNotifi.setRole(4);
					reNotifi.setRequestState(1);
					reNotifi.setIsReply(1);
					
				}
				ResultNotificationLocalServiceUtil.addResultNotification(reNotifi);
			} else {
				if (obj instanceof XacNhanHuyThuTuc) {
					
					reNotifi.setBusinessTypeCode(MessageType.KHAI_HUY_HO_SO);
					
					reNotifi.setDocumentName(headerReceive.getSubject().getReference());
					reNotifi.setDocumentYear(headerReceive.getSubject().getDocumentYear());
					reNotifi.setRequestCode(headerReceive.getReference().getMessageId());
					if (temp != null) {
						reNotifi.setMaritimeCode(temp.getMaritimeCode());
					}
					reNotifi.setResponse(((XacNhanHuyThuTuc) obj).getReason());
					reNotifi.setResponseTime(FormatData.parseStringToDate(((XacNhanHuyThuTuc) obj).getCancelDate()));
					reNotifi.setOrganization(((XacNhanHuyThuTuc) obj).getOrganization());
					reNotifi.setOfficerName(((XacNhanHuyThuTuc) obj).getName());
					reNotifi.setDivision(((XacNhanHuyThuTuc) obj).getDivision());
					reNotifi.setRole(4);
					reNotifi.setRequestState(1);
					reNotifi.setIsReply(1);
					
				}
				ResultNotificationLocalServiceUtil.updateResultNotification(reNotifi);
			}
			
		} catch (Exception e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}
	
	// private boolean huyGiayPhepQuaCanh(ObjectExcute objectExcute,
	// Header headerReceive) throws SystemException {
	// boolean result = true;
	//
	// TempDocument temp = TempDocumentLocalServiceUtil
	// .findTemDocumentByDocumentNameDocumentYear(headerReceive
	// .getSubject().getReference(), headerReceive
	// .getSubject().getDocumentYear());
	//
	// temp.setRequestState(TrangThaiBanKhaiNhapCanh.DA_HUY_LENH_DIEU_DONG);
	// temp.setDocumentStatusCode(TrangThaiBanKhaiNhapCanh.HUY_THU_TUC_TAU_THUYEN_NHAP_CANH);
	// TempDocumentLocalServiceUtil.updateTempDocument(temp);
	//
	// List<IssueShiftingOrder> lstShiftOrder =
	// IssueShiftingOrderLocalServiceUtil
	// .findByDocumentYearAndDocumentYearOrderByColumn(headerReceive
	// .getSubject().getReference(), headerReceive
	// .getSubject().getDocumentYear(), KeyParams.VERSION_NO,
	// KeyParams.ORDER_BY_DESC);
	// for (IssueShiftingOrder item : lstShiftOrder) {
	// item.setRequestState(TrangThaiBanKhaiNhapCanh.KHAI_HUY);
	// IssueShiftingOrderLocalServiceUtil.updateIssueShiftingOrder(item);
	// }
	// try {
	//
	// Object obj = MessageFactory.convertXmltoObject(
	// MessageType.HUY_LENH_DIEU_DONG, objectExcute.getXmlData());
	//
	// ResultNotification resultNotification =
	// ResultNotificationLocalServiceUtil
	// .findByBusinessTypeCodeOrderbyLastestDate(
	// MessageType.XAC_NHAN_HUY_LENH_DIEU_DONG + "",
	// headerReceive.getSubject().getReference(),
	// headerReceive.getSubject().getDocumentYear());
	// if (resultNotification == null) {
	// resultNotification = new ResultNotificationImpl();
	// setData2Notification(headerReceive, temp, obj,
	// resultNotification,
	// MessageType.XAC_NHAN_HUY_LENH_DIEU_DONG);
	// ResultNotificationLocalServiceUtil
	// .addResultNotification(resultNotification);
	// } else {
	// setData2Notification(headerReceive, temp, obj,
	// resultNotification,
	// MessageType.XAC_NHAN_HUY_LENH_DIEU_DONG);
	// ResultNotificationLocalServiceUtil
	// .updateResultNotification(resultNotification);
	// }
	//
	// } catch (Exception e) {
	// result = false;
	// e.printStackTrace();
	// }
	//
	// return result;
	// }
	
	private boolean huyGiayPhepRoiCang(ObjectExcute objectExcute, Header headerReceive) throws SystemException {
		boolean result = true;
		
		TempDocument temp = TempDocumentLocalServiceUtil.findTemDocumentByDocumentNameDocumentYear(headerReceive.getSubject().getReference(),
				headerReceive.getSubject().getDocumentYear());
		
		temp.setDocumentStatusCode(TrangThaiBanKhaiXuatCanh.HUY_THU_TUC_TAU_THUYEN_XUAT_CANH);
		TempDocumentLocalServiceUtil.updateTempDocument(temp);
		
		List<IssuePortClearance> issuePortClearance = IssuePortClearanceLocalServiceUtil.findByDocumentYearAndDocumentYearOrderByColumn(headerReceive
				.getSubject().getReference(), headerReceive.getSubject().getDocumentYear(), KeyParams.VERSION_NO, KeyParams.ORDER_BY_DESC);
		for (IssuePortClearance item : issuePortClearance) {
			item.setRequestState(TrangThaiBanKhaiNhapCanh.KHAI_HUY);
			IssuePortClearanceLocalServiceUtil.updateIssuePortClearance(item);
		}
		try {
			
			Object obj = MessageFactory.convertXmltoObject(MessageType.HUY_GIAY_PHEP_ROI_CANG, objectExcute.getXmlData());
			
			ResultNotification reNotification = ResultNotificationLocalServiceUtil.findByBusinessTypeCodeOrderbyLastestDate(
					MessageType.HUY_GIAY_PHEP_ROI_CANG + "", headerReceive.getSubject().getReference(), headerReceive.getSubject().getDocumentYear());
			if (reNotification == null) {
				reNotification = new ResultNotificationImpl();
				if (obj instanceof XacNhanHuyThuTuc) {
					
					reNotification.setBusinessTypeCode(MessageType.HUY_GIAY_PHEP_ROI_CANG);
					
					reNotification.setDocumentName(headerReceive.getSubject().getReference());
					reNotification.setDocumentYear(headerReceive.getSubject().getDocumentYear());
					reNotification.setLatestDate(headerReceive.getSubject().getSendDate());
					reNotification.setRequestCode(headerReceive.getReference().getMessageId());
					if (temp != null) {
						reNotification.setMaritimeCode(temp.getMaritimeCode());
					}
					reNotification.setResponse(((XacNhanHuyThuTuc) obj).getReason());
					
					reNotification.setResponseTime(FormatData.parseStringToDate(((XacNhanHuyThuTuc) obj).getCancelDate()));
					reNotification.setOrganization(((XacNhanHuyThuTuc) obj).getOrganization());
					reNotification.setOfficerName(((XacNhanHuyThuTuc) obj).getName());
					reNotification.setDivision(((XacNhanHuyThuTuc) obj).getDivision());
					reNotification.setRole(4);
					reNotification.setRequestState(new Integer(((XacNhanHuyThuTuc) obj).getIsApprove()));
					reNotification.setIsReply(1);
					
				}
				ResultNotificationLocalServiceUtil.addResultNotification(reNotification);
			} else {
				if (obj instanceof XacNhanHuyThuTuc) {
					
					reNotification.setBusinessTypeCode(MessageType.HUY_GIAY_PHEP_ROI_CANG);
					
					reNotification.setDocumentName(headerReceive.getSubject().getReference());
					reNotification.setDocumentYear(headerReceive.getSubject().getDocumentYear());
					if (temp != null) {
						reNotification.setMaritimeCode(temp.getMaritimeCode());
					}
					reNotification.setResponse(((XacNhanHuyThuTuc) obj).getReason());
					
					reNotification.setResponseTime(FormatData.parseStringToDate(((XacNhanHuyThuTuc) obj).getCancelDate()));
					reNotification.setOrganization(((XacNhanHuyThuTuc) obj).getOrganization());
					reNotification.setOfficerName(((XacNhanHuyThuTuc) obj).getName());
					reNotification.setDivision(((XacNhanHuyThuTuc) obj).getDivision());
					reNotification.setRole(4);
					reNotification.setRequestState(new Integer(((XacNhanHuyThuTuc) obj).getIsApprove()));
					reNotification.setIsReply(1);
					
				}
				ResultNotificationLocalServiceUtil.updateResultNotification(reNotification);
			}
			
		} catch (Exception e) {
			result = false;
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	
	public void updateOrInsertInterfaceRequest(String requestCodeOld, int responseStatus, String approvalName, String reason) {
		try {
			InterfaceRequest interfaceRequest = InterfaceRequestLocalServiceUtil.findInterfaceRequestByRequestCode(requestCodeOld);
			if (interfaceRequest != null) {
				// String approvalName = "Can Bo Cang Vu";
				
				if (responseStatus == MessageType.FUNCTION_CHAP_NHAN_HO_SO) {
					interfaceRequest.setRemarks(BusinessUtils.getRemarkChapNhan(approvalName));
				} else {
					interfaceRequest.setRemarks(BusinessUtils.getRemarkTuChoi(approvalName, reason));
				}
				InterfaceRequestLocalServiceUtil.updateInterfaceRequest(interfaceRequest);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateOrInsertResultCompetion(TempDocument temp, int responseStatus) {
		
		ResultCompetion reCompetion = null;
		reCompetion = ResultCompetionLocalServiceUtil.findByDocumentNameAndDocumentYear(temp.getDocumentName(), temp.getDocumentYear());
		
		String maritimeCode = temp.getMaritimeCode();
		String nameOfShip = temp.getShipName();
		String nameOfMaster = temp.getShipCaptain();
		String portOfArrivalCode = temp.getPortCode();
		String certificateNo = "";
		String flagStateOfShip = temp.getStateCode();
		double grossTonnage = temp.getGrt();
		Date approvalTime = new Date();
		String approvalName = "Can Bo Cang Vu";
		
		try {
			
			if (reCompetion == null) {
				
				log.debug("========vao insert====xacNhanHoanThanhThuTucNhapCanhTruongHopHuy=====");
				reCompetion = new ResultCompetionImpl();
				reCompetion.setMaritimeCode(maritimeCode);
				reCompetion.setNameOfShip(nameOfShip);
				reCompetion.setNameOfMaster(nameOfMaster);
				reCompetion.setPortOfArrivalCode(portOfArrivalCode);
				reCompetion.setCertificateNo(certificateNo);
				reCompetion.setFlagStateOfShip(flagStateOfShip);
				reCompetion.setGrossTonnage(grossTonnage);
				reCompetion.setApprovalTime(approvalTime);
				reCompetion.setApprovalName(approvalName);
				
				reCompetion.setRequestState(TrangThaiHoSo.KE_HOACH_TIEP_NHAN);
				reCompetion.setResponseStatusCVHH(responseStatus);
				reCompetion.setResponseTimeCVHH(new Date());
				if (responseStatus == MessageType.DA_PHE_DUYET) {
					reCompetion.setResponseCVHH(BusinessUtils.getRemarkChapNhan(approvalName));
				} else {
					reCompetion.setResponseCVHH(BusinessUtils.getRemarkTuChoi(approvalName, "Tu choi tu cang vu"));
				}
				
				reCompetion.setDocumentName(temp.getDocumentName());
				reCompetion.setDocumentYear(temp.getDocumentYear());
				reCompetion.setRequestCode(UUID.randomUUID().toString());
				
				ResultCompetionLocalServiceUtil.addResultCompetion(reCompetion);
			} else {
				log.debug("xacNhanHoanThanhThuTucNhapCanhTruongHopHuy vao update");
				reCompetion.setMaritimeCode(maritimeCode);
				reCompetion.setNameOfShip(nameOfShip);
				reCompetion.setNameOfMaster(nameOfMaster);
				reCompetion.setPortOfArrivalCode(portOfArrivalCode);
				reCompetion.setCertificateNo(certificateNo);
				reCompetion.setFlagStateOfShip(flagStateOfShip);
				reCompetion.setGrossTonnage(grossTonnage);
				reCompetion.setApprovalTime(approvalTime);
				reCompetion.setApprovalName(approvalName);
				
				reCompetion.setRequestState(TrangThaiHoSo.KE_HOACH_TIEP_NHAN);
				reCompetion.setResponseStatusCVHH(responseStatus);
				reCompetion.setResponseTimeCVHH(new Date());
				if (responseStatus == MessageType.DA_PHE_DUYET) {
					reCompetion.setResponseCVHH(BusinessUtils.getRemarkChapNhan(approvalName));
				} else {
					reCompetion.setResponseCVHH(BusinessUtils.getRemarkTuChoi(approvalName, "Tu choi tu cang vu"));
				}
				
				ResultCompetionLocalServiceUtil.updateResultCompetion(reCompetion);
				log.debug("UPDATE XONG setRequestState" + reCompetion.getRequestState());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void doiChieuBanKhaiChoPheDuyet(int messageType, long documentName, int documentYear) throws SystemException {
		
		List<ResultDeclaration> list = ResultDeclarationLocalServiceUtil.findByDocumentNameAndBusinessTypeCodeAndDocumentYear(messageType,
				documentName, documentYear);
		
		String requestCode = "";
		
		if (list.size() > 0) {
			requestCode = list.get(0).getRequestCode();
		}
		
		if (messageType == MessageType.BAN_KHAI_AN_NINH_TAU_BIEN) {
			List<TempShipSecurityMessage> tempSSMs = TempShipSecurityMessageLocalServiceUtil.findByRequestCode(requestCode);
			
			if (tempSSMs != null && tempSSMs.size() > 0) {
				TempShipSecurityMessage message = tempSSMs.get(0);
				message.setRequestState(MessageType.TRANG_THAI_BANG_KHAI_DOI_CHIEU);
				TempShipSecurityMessageLocalServiceUtil.updateTempShipSecurityMessage(message);
			}
			
		} else if (messageType == MessageType.BAN_KHAI_CHUNG) {
			List<TempGeneralDeclaration> tempGDs = TempGeneralDeclarationLocalServiceUtil.findByRequestCode(requestCode);
			
			if (tempGDs != null && tempGDs.size() > 0) {
				TempGeneralDeclaration declaration = tempGDs.get(0);
				declaration.setRequestState(MessageType.TRANG_THAI_BANG_KHAI_DOI_CHIEU);
				TempGeneralDeclarationLocalServiceUtil.updateTempGeneralDeclaration(declaration);
			}
			
		} else if (messageType == MessageType.BAN_KHAI_DANH_SACH_THUYEN_VIEN) {
			List<TempCrewList> crews = TempCrewListLocalServiceUtil.findByRequestCode(requestCode);
			
			if (crews != null && crews.size() > 0) {
				TempCrewList crew = crews.get(0);
				crew.setRequestState(MessageType.TRANG_THAI_BANG_KHAI_DOI_CHIEU);
				TempCrewListLocalServiceUtil.updateTempCrewList(crew);
			}
			
		} else if (messageType == MessageType.BAN_KHAI_HANG_HOA) {
			List<TempDangerousGoodsNanifest> results = TempDangerousGoodsNanifestLocalServiceUtil.findByRequestCode(requestCode);
			
			if (results != null && results.size() > 0) {
				TempDangerousGoodsNanifest goodsNanifest = results.get(0);
				goodsNanifest.setRequestState(MessageType.TRANG_THAI_BANG_KHAI_DOI_CHIEU);
				TempDangerousGoodsNanifestLocalServiceUtil.updateTempDangerousGoodsNanifest(goodsNanifest);
			}
		}
	}
	
	public String sendShiftingOrder(Header header, ShiftingOrder shiftingOrder, BusinessUtils businessUtils) {
		
		String xmlResult = "";
		try {
			
			if (shiftingOrder.getPortofAuthority() != null && shiftingOrder.getPortofAuthority().length() > 0) {
				DmMaritime dmMaritime = DmMaritimeLocalServiceUtil.getByMaritimeCode(shiftingOrder.getPortofAuthority());
				if (dmMaritime != null) {
					shiftingOrder.setPortofAuthority(dmMaritime.getMaritimeReference());
				}
			}
			// Sua lai truoc khi gui di
			// shiftingOrder.setShiftingPortWharfCode("XXXXX");
			xmlResult = MessageFactory.convertObjectToXml(shiftingOrder);
			
			// Insert history.
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}
		
		return xmlResult;
		// return businessUtils.createContentSendFromBGTVTToNSW(header, xmlResult);
	}
	
}
