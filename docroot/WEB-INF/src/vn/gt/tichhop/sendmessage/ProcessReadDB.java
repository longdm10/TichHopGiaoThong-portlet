package vn.gt.tichhop.sendmessage;

import java.util.List;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import vn.dao.gt.asw.model.AswmsgMessageQueue;
import vn.dao.gt.asw.service.AswmsgMessageQueueLocalServiceUtil;
import vn.gt.tichhop.message.BusinessUtils;
import vn.gt.utils.config.ConfigurationManager;
import vn.nsw.Header;

public class ProcessReadDB implements Runnable{
	Log _log = LogFactoryUtil.getLog(ProcessReadDB.class);
	private Thread t;
	private int timeSleep = 900;
	private String threadName;
	

	public ProcessReadDB(String name, int timeSleep) {
		this.threadName = name;
		this.timeSleep = timeSleep;
	}

	@Override
	public void run() {
		System.out.println("go to run db");
		Header headerRequest = null;
//		String xml = "";
		int count = ConfigurationManager.getIntProp(
				"vn.gt.count.sendmessage", 20);
		System.out.println("==========count======  " + count);
		int check = ConfigurationManager.getIntProp("vn.gt.coguihaykhong", 1);
		if(check>0){
			while (true) {
				int size = ThreatSentMessage.sendMessageQueue.size();
				if (size==0) {
				try {
//						System.out.println("True");
						List<AswmsgMessageQueue> aswmsgMessageQueues = AswmsgMessageQueueLocalServiceUtil
								.getListMessage2Queue(count);
						
						System.out.println("====aswmsgMessageQueues==== size===  " + aswmsgMessageQueues.size());
						
						if(aswmsgMessageQueues!=null&&aswmsgMessageQueues.size()>0)
						{
							int sizeAswmsgMessageQueue = aswmsgMessageQueues.size();
							System.out.println("sizeAswmsgMessageQueue  "+sizeAswmsgMessageQueue);
//							Header headerRequest = null;
							for (int i = 0; i < sizeAswmsgMessageQueue; i++) {
								AswmsgMessageQueue messageQueue = aswmsgMessageQueues.get(i);
								int priority=messageQueue.getPriority()-MessgaePriorityLevels.COUNT;
//								String data = vn.dtt.gt.dk.message.MessageUtils.replaceXML(messageQueue.getAllContent());
//								headerRequest = MessageUtils.readXmlMessageHeader(data);
								long id = messageQueue.getId();
//								System.out.println("sizeAswmsgMessageQueue  "+id);
//								int soLanGui = messageQueue.getSoLanGui();
								AswmsgMessageQueueLocalServiceUtil.updatePriorityAswmsgMessageQueue(priority, id);
								
//								sendMessage(headerRequest, data,	id,soLanGui);
								
							}
						}
						ThreatSentMessage.sendMessageQueue.addAll(aswmsgMessageQueues);
						System.out.println("ThreatSentMessage.sendMessageQueue.addAll(aswmsgMessageQueues).size" + ThreatSentMessage.sendMessageQueue.size());
						Thread.sleep(timeSleep);				
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		
	}
	
//	private void sendMessage(Header headerRequest, String xml,long id,int soLanGui) {
//		System.out.println("sendMessage1");
//		if (xml != null && xml.length() >0 && id > 0) {
//			
//			try {
////				messageQueue.setPriority(messageQueue.getPriority()-MessgaePriorityLevels.COUNT);
////				AswmsgMessageQueueLocalServiceUtil.updateAswmsgMessageQueue(messageQueue);
////					//xml = messageQueue.getAllContent();
//
//					//System.out.println("  xml   " + xml);
////					IMTService imtService = CallWs2HaiQuan
////							.getIMTSercice();
////					System.out
////							.println("=====Du lieu gui di HQMC====SelectedVehicleListForPayment====="
////									+ xml);
//				BusinessUtils bus  = new BusinessUtils();	
//				String data = bus.replaceXML(xml);
////					headerRequest = MessageUtils
////							.readXmlMessageHeader(data);
//					AswmsgMessageLogDao.insertMessageLog(
//							headerRequest, xml,
//							MessageKey.HTTH_BGT_TO_NSW,
//							TrangThaiHoSo.DA_BO_SUNG_CHO_TIEP_NHAP,
//							headerRequest.getReference().getMessageId());
//					String dulieuXml = SOAPClientSAAJ.callWebservice(data);
//					System.out.println("sendMessage2 "+dulieuXml);
////					String dulieuXml = imtService.receive(xml);
////					String dulieuXml = imtService.receive(data);
//					//System.out.println("sendMessage3");
////					System.out
////							.println("=======Du lieu NHAN==HQMC==day =====SelectedVehicleListForPayment====="
////									+ dulieuXml);
//					if(dulieuXml!=null&&dulieuXml.length()>0){
//						Header headerResponse = MessageUtils
//								.readXmlMessageHeader(dulieuXml);
////						if(headerResponse!=null&&headerResponse.getSubject().getFunction()!=null&&headerResponse.getSubject().getFunction().equals( MessageType.HO_SO)){
//						if(headerResponse!=null&&headerResponse.getSubject().getFunction()!=null&&headerResponse.getSubject().getFunction().length()>0){
//							AswmsgMessageLogDao.insertMessageLog(
//									headerResponse, dulieuXml,
//									MessageKey.NSW_TO_HTTT_BGT,
//									TrangThaiHoSo.DA_BO_SUNG_CHO_TIEP_NHAP,
//									headerResponse.getReference().getMessageId());
//							
//							AswmsgMessageQueueLocalServiceUtil
//									.deleteAswmsgMessageQueue(id);
//						}else{
//							updateWithException(headerRequest, xml, id, soLanGui, " gia tri tra ve tu Hai Quan null");
//						}
//					}
//				
//			} catch (Exception e2) {
//				e2.printStackTrace();
//				// mr.The Anh Fix bug (nothing)
//				updateWithException(headerRequest, xml, id, soLanGui, e2.toString());
//			}
//		}
//	}

//	private void updateWithException(Header headerRequest, String xml, long id,
//			int soLanGui, String exceptionString) {
//		int check = DKConfigurationManager.getIntProp("solangui_message", 5);
//		int soLanGuiSau = soLanGui +1;
//		if(soLanGui<check){
//			try {
//				MonitorMessageQueue monitorMessageQueue =  MonitorMessageQueueLocalServiceUtil.fetchMonitorMessageQueue(id);
//				if(monitorMessageQueue!=null){
//					monitorMessageQueue.setPriority(15);
//					monitorMessageQueue.setSoLanGui(soLanGuiSau);
//					MonitorMessageQueueLocalServiceUtil.updateMonitorMessageQueue(monitorMessageQueue);
//				}
//
//			} catch (SystemException e) {				
//				e.printStackTrace();
//			}
//		}
//		if(headerRequest!=null){
//			AswmsgMessageLogDao
//				.insertMessageLogWhenException(
//						headerRequest,
//						xml,
//						MessageKey.HTTH_BGT_TO_NSW_ERROR,
//						TrangThaiHoSo.DA_BO_SUNG_CHO_TIEP_NHAP,
//						headerRequest.getReference().getMessageId(),
//						exceptionString,soLanGui);
//		}
//	}

	public void start() {
		if (t == null) {
			t = new Thread(this, threadName);
			t.start();
			_log.debug("===Starting-------------- " + t.getName());
		}
	}

}
