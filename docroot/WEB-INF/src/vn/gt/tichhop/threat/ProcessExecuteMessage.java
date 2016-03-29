/**
 * 
 */
package vn.gt.tichhop.threat;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import org.tempuri.IMTService;

import vn.gt.dao.danhmucgt.model.DmGtRouteConfig;
import vn.gt.dao.noticeandmessage.model.HistoryInterfaceRequest;
import vn.gt.dao.noticeandmessage.model.InterfaceRequest;
import vn.gt.dao.noticeandmessage.model.TempDocument;
import vn.gt.dao.noticeandmessage.service.HistoryInterfaceRequestLocalServiceUtil;
import vn.gt.dao.noticeandmessage.service.InterfaceRequestLocalServiceUtil;
import vn.gt.dao.noticeandmessage.service.TempDocumentLocalServiceUtil;
import vn.gt.tichhop.message.BusinessInsertTableResultUtils;
import vn.gt.tichhop.message.BusinessUtils;
import vn.gt.tichhop.message.MessageType;
import vn.gt.utils.CallWs2HaiQuan;
import vn.nsw.Header;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * @author win_64
 */
public class ProcessExecuteMessage implements Runnable {
	
	Log _log = LogFactoryUtil.getLog(ProcessExecuteMessage.class);
	private Thread t;
	private int timeSleep = 1000;
	private String threadName;
	private BusinessUtils businessUtils = new BusinessUtils();
	
	public ProcessExecuteMessage(String name, int timeSleep) {
		threadName = name;
		this.timeSleep = timeSleep;
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				ObjectExcute objectExcute = ThreadPassingMessage.listData.poll();
				if (objectExcute != null) {
					_log.info("===========Executing thread========================." + t.getName() + ":::Data==Objects==size==" + objectExcute.getLiObjects().size());
					Header header = objectExcute.getHeader();
					// Neu la cac cang vu tich hop.
					String lyDoTuChoi = businessUtils.insertTempTable(objectExcute.getHeader(), objectExcute.getLiObjects());
					if (lyDoTuChoi != null && lyDoTuChoi.length() > 0) {
						sendMessageTuChoiHoSo("System", lyDoTuChoi, objectExcute.getHeader());
					} else {
						
						// Add 20-10-2014
						//TODO Sau khi insert vao cac TempTable
						
						if(header.getSubject().getDocumentType()==MessageType.TAU_RA||header.getSubject().getDocumentType()==MessageType.TAU_VAO){
							BusinessInsertTableResultUtils.insertLanResultNotification(header, objectExcute.getLiObjects());
						}else{
							BusinessInsertTableResultUtils.insertResultNotification(header, objectExcute.getLiObjects());
						}	
						if (checkCangVuTichHop(objectExcute)) {
							_log.info("===========Executing thread===================ThreadPassingMessageTichHopCangVu.init().add=====.");
							ThreadPassingMessageTichHopCangVu.init().add(objectExcute);
						}
					}
				}
				Thread.sleep(timeSleep);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void start() {
		if (t == null) {
			t = new Thread(this, threadName);
			t.start();
			_log.info("===Starting-------------- " + t.getName());
		}
	}
	
	private boolean checkCangVuTichHop(ObjectExcute objectExcute) {
		List<TempDocument> liTempDocuments = TempDocumentLocalServiceUtil.findTemDocumentByDocumentNameAndDocumentYear(objectExcute.getHeader()
				.getSubject().getReference(), objectExcute.getHeader().getSubject().getDocumentYear());
		
		if (liTempDocuments != null && liTempDocuments.size() > 0) {
			_log.info("==============liTempDocuments.get(0).getMaritimeCode()===========" + liTempDocuments.get(0).getMaritimeCode());
			try {
				InterfaceRequest interfaceRequest = InterfaceRequestLocalServiceUtil.findInterfaceRequestByRequestCode(objectExcute.getHeader()
						.getReference().getMessageId());
				if (interfaceRequest != null) {
					interfaceRequest.setLocCode(liTempDocuments.get(0).getMaritimeCode());
					interfaceRequest.setOrganizationCode("01");
					InterfaceRequestLocalServiceUtil.updateInterfaceRequest(interfaceRequest);
				}
			} catch (Exception e) {
				e.printStackTrace();
				_log.info(e);
			}
			//TODO tam thoi de comment
			try {
				HistoryInterfaceRequest historyInterfaceRequest = HistoryInterfaceRequestLocalServiceUtil.findHistoryInterfaceRequestByRequestCode(objectExcute.getHeader().getReference().getMessageId());
				if (historyInterfaceRequest != null) {
					historyInterfaceRequest.setLocCode(liTempDocuments.get(0).getMaritimeCode());
					historyInterfaceRequest.setOrganizationCode("01");
					HistoryInterfaceRequestLocalServiceUtil.updateHistoryInterfaceRequest(historyInterfaceRequest);
				}
//				HistoryInterfaceRequestField historyInterfaceRequestFile = HistoryInterfaceRequestFieldLocalServiceUtil.getByRequestCode(objectExcute.getHeader().getReference().getMessageId());
//				if (historyInterfaceRequestFile != null) {
//					Hashtable<String, String> hashSql = new Hashtable<String, String>();
//					hashSql.put(InterfaceRequest2TempUtils.LocCode, liTempDocuments.get(0).getMaritimeCode());
//					hashSql.put(InterfaceRequest2TempUtils.OrganizationCode, "01");
//					String sqlUpateByRequestCode = InterfaceRequest2TempUtils.sqlUpateByRequestCode(hashSql, objectExcute.getHeader().getReference().getMessageId());
//					_log.info("==checkCangVuTichHop==sqlUpateByRequestCode==" + sqlUpateByRequestCode);
//					int updateHistoryInterfaceRequest = HistoryInterfaceRequestLocalServiceUtil.updateHistoryInterfaceRequest(sqlUpateByRequestCode);
//					_log.info("==checkCangVuTichHop==sqlUpateByRequestCode==" + updateHistoryInterfaceRequest);
//				}
			} catch (Exception e) {
				e.printStackTrace();
				_log.info(e);
			}

			for (DmGtRouteConfig dmGtRouteConfig : ThreadPassingMessage.liConfigs) {
				if (dmGtRouteConfig != null && dmGtRouteConfig.getLocCode().compareTo(liTempDocuments.get(0).getMaritimeCode()) == 0) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	private void sendMessageTuChoiHoSo(String userName, String lyDoTuChoi, Header header) throws RemoteException {
		// InterfaceRequest interfaceRequest = InterfaceRequestLocalServiceUtil.findInterfaceRequestByRequestCode(requestCode);
		String function = MessageType.FUNCTION_TU_CHOI_HO_SO_CHUNG_TU;
		header.getSubject().setFunction(function);
		
		if (lyDoTuChoi == null || lyDoTuChoi.length() == 0) {
			lyDoTuChoi = "System";
		}
		BusinessUtils businessUtils = new BusinessUtils();
		String xmlData = businessUtils.sendMessageReject(header, header.getReference().getMessageId(), lyDoTuChoi, "System", "System", header
				.getFrom().getName(), new Date(), null);
		
		xmlData = businessUtils.createContentSendFromBGTVTToNSW(header, xmlData);
		IMTService imtService = CallWs2HaiQuan.getIMTSercice();
		
		if (xmlData != null && xmlData.length() > 0) {
			businessUtils.insertHistorySendMessage(xmlData);
			
			_log.info("==xml==");
			_log.info(xmlData);
			String  xml = "";
			if(MessageType.TAU_VAO == header.getSubject().getDocumentType() ||MessageType.TAU_RA == header.getSubject().getDocumentType()){
				_log.info("==Call receiveFromInland==");
			//	xml = imtService.receiveFromInland(xmlData);
				
			}else{
				_log.info("==Call receiveResultFromMT==");
				//xml = imtService.receiveResultFromMT(xmlData);
			}
			
			_log.info("=======Du lieu NHAN  HQMC day ========");
			_log.info(xml);
			businessUtils.insertHistoryReceiveMessageResponse(xml);
		}
	}
	
}
