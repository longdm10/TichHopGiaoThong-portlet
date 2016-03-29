package vn.gt.tichhop.sendmessage;

import java.util.List;

import org.tempuri.IMTService;

import vn.dao.gt.asw.model.AswmsgMessageQueue;
import vn.dao.gt.asw.model.MonitorMessageQueue;
import vn.dao.gt.asw.service.AswmsgMessageQueueLocalServiceUtil;
import vn.dao.gt.asw.service.MonitorMessageQueueLocalServiceUtil;
import vn.gt.dao.noticeandmessage.model.HistoryInterfaceRequest;
import vn.gt.dao.noticeandmessage.model.InterfaceRequest;
import vn.gt.dao.noticeandmessage.model.TempDocument;
import vn.gt.dao.noticeandmessage.service.HistoryInterfaceRequestLocalServiceUtil;
import vn.gt.dao.noticeandmessage.service.InterfaceRequestLocalServiceUtil;
import vn.gt.dao.noticeandmessage.service.TempDocumentLocalServiceUtil;
import vn.gt.tichhop.message.BusinessUtils;
import vn.gt.tichhop.message.MessageType;
import vn.gt.utils.CallWs2HaiQuan;
import vn.gt.utils.config.ConfigurationManager;
import vn.nsw.Header;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class ProcessSendMessage implements Runnable {
	Log _log = LogFactoryUtil.getLog(ProcessSendMessage.class);
	private Thread t;
	private int timeSleep = 900;
	private String threadName;

	// FunctionNghiepVu functionNghiepVu = new FunctionNghiepVu();

	public ProcessSendMessage(String name, int timeSleep) {
		this.threadName = name;
		this.timeSleep = timeSleep;
	}

	@Override
	public void run() {
		System.out.println("go to run of thread");
		int check = ConfigurationManager.getIntProp("vn.gt.coguihaykhong", 1);
		System.out.println("CHECK============= " + check);
		if (check > 0) {
			System.out.println("go to run of thread 1");
			while (true) {
				System.out.println("go to run of thread 1");
				try {
					try {
						System.out.println("go to run of thread 2");
						Thread.sleep(timeSleep);
					} catch (Exception e1) {
					}
					System.out.println("go to run of thread 3");
					Header headerRequest = null;
					String xml = "";
					AswmsgMessageQueue messageQueue = ThreatSentMessage.sendMessageQueue
							.poll();
					if(messageQueue != null) {
						System.out.println("====headerREQ: " + headerRequest);
						sendMessage(headerRequest, xml, messageQueue);
					} else {
						System.out.println("messageQueue is null");
					}
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}

	private void sendMessage(Header headerRequest, String xml,
			AswmsgMessageQueue messageQueue) {
		
		if (messageQueue != null) {
			int soLanGui = messageQueue.getSoLanGui();
			long id = messageQueue.getId();
			try {
				// messageQueue.setPriority(messageQueue.getPriority()-MessgaePriorityLevels.COUNT);
				// AswmsgMessageQueueLocalServiceUtil.updateAswmsgMessageQueue(messageQueue);
				// //xml = messageQueue.getAllContent();

				// System.out.println("  xml   " + xml);
				IMTService imtService = CallWs2HaiQuan.getIMTSercice();
				// System.out
				// .println("=====Du lieu gui di HQMC====SelectedVehicleListForPayment====="
				// + messageQueue.getAllContent());
				BusinessUtils bus = new BusinessUtils();
				String data = bus.replaceXML(messageQueue.getAllContent());
				System.out.println("data=== + " +data);
				headerRequest = BusinessUtils.readXmlMessageHeader(data);
				System.out.println("headerRequest====================  " +headerRequest);
				// AswmsgMessageLogDao.insertMessageLog(
				// headerRequest, messageQueue.getAllContent(),
				// MessageKey.HTTH_BGT_TO_NSW,
				// TrangThaiHoSo.DA_BO_SUNG_CHO_TIEP_NHAP,
				// headerRequest.getReference().getMessageId());
				List<TempDocument> liTempDocuments = TempDocumentLocalServiceUtil
						.findTemDocumentByDocumentNameAndDocumentYear(headerRequest
								.getSubject().getReference(), headerRequest
								.getSubject().getDocumentYear());
				if (liTempDocuments != null && liTempDocuments.size() > 0) {
					_log.info("==============liTempDocuments.get(0).getMaritimeCode()==========="
							+ liTempDocuments.get(0).getMaritimeCode());
					try {
						InterfaceRequest interfaceRequest = InterfaceRequestLocalServiceUtil
								.findInterfaceRequestByRequestCode(headerRequest
										.getReference().getMessageId());
						if (interfaceRequest != null) {
							interfaceRequest.setLocCode(liTempDocuments.get(0)
									.getMaritimeCode());
							interfaceRequest.setOrganizationCode("01");
							InterfaceRequestLocalServiceUtil
									.updateInterfaceRequest(interfaceRequest);
						}
					} catch (Exception e) {
						e.printStackTrace();
						_log.info(e);
					}

					// System.out.println("messageQueue.getAllContent()  "+messageQueue.getAllContent());
					String dulieuXml = null;
					if (headerRequest.getSubject().getDocumentType() == MessageType.TAU_RA
							|| headerRequest.getSubject().getDocumentType() == MessageType.TAU_VAO) {
						dulieuXml = imtService.receiveFromInland(messageQueue
								.getAllContent());
					} else {
						dulieuXml = imtService.receiveResultFromMT(messageQueue
								.getAllContent());
					}

					if (dulieuXml != null && dulieuXml.length() > 0) {
						Header headerResponse = BusinessUtils
								.readXmlMessageHeader(dulieuXml);
						long phieuXuLyPhuId = messageQueue.getPhieuXuLyPhuId();
						String messageId = headerResponse.getReference()
								.getMessageId();
						String transactionId = messageQueue.getDocumentType();
						try {
							HistoryInterfaceRequest historyInterfaceRequest = HistoryInterfaceRequestLocalServiceUtil
									.findHistoryInterfaceRequestByRequestCode(messageId);
							if (historyInterfaceRequest != null) {
								historyInterfaceRequest
										.setLocCode(liTempDocuments.get(0)
												.getMaritimeCode());
								historyInterfaceRequest
										.setOrganizationCode("01");
								HistoryInterfaceRequestLocalServiceUtil
										.updateHistoryInterfaceRequest(historyInterfaceRequest);
							}
							// HistoryInterfaceRequestField
							// historyInterfaceRequestFile =
							// HistoryInterfaceRequestFieldLocalServiceUtil.getByRequestCode(objectExcute.getHeader().getReference().getMessageId());
							// if (historyInterfaceRequestFile != null) {
							// Hashtable<String, String> hashSql = new
							// Hashtable<String, String>();
							// hashSql.put(InterfaceRequest2TempUtils.LocCode,
							// liTempDocuments.get(0).getMaritimeCode());
							// hashSql.put(InterfaceRequest2TempUtils.OrganizationCode,
							// "01");
							// String sqlUpateByRequestCode =
							// InterfaceRequest2TempUtils.sqlUpateByRequestCode(hashSql,
							// objectExcute.getHeader().getReference().getMessageId());
							// _log.info("==checkCangVuTichHop==sqlUpateByRequestCode=="
							// + sqlUpateByRequestCode);
							// int updateHistoryInterfaceRequest =
							// HistoryInterfaceRequestLocalServiceUtil.updateHistoryInterfaceRequest(sqlUpateByRequestCode);
							// _log.info("==checkCangVuTichHop==sqlUpateByRequestCode=="
							// + updateHistoryInterfaceRequest);
							// }
						} catch (Exception e) {
							e.printStackTrace();
							_log.info(e);
						}

						AswmsgMessageQueueLocalServiceUtil
								.deleteAswmsgMessageQueue(messageQueue.getId());
						// cacMessageDacBiet(headerRequest,
						// phieuXuLyPhuId,messageId,transactionId);
					} else {
						updateWithException(headerRequest, xml, id, soLanGui,
								"Khong co du lieu nhan ve");
					}
				}

			} catch (Exception e2) {
				e2.printStackTrace();
				// mr.The Anh Fix bug (nothing)
				updateWithException(headerRequest, xml, id, soLanGui,
						e2.toString());
			}
		}

	}

	private void updateWithException(Header headerRequest, String xml, long id,
			int soLanGui, String exceptionString) {
		int check = ConfigurationManager.getIntProp("solangui_message", 5);
		int soLanGuiSau = soLanGui + 1;
		if (soLanGui < check) {
			try {
				MonitorMessageQueue monitorMessageQueue = MonitorMessageQueueLocalServiceUtil
						.fetchMonitorMessageQueue(id);
				if (monitorMessageQueue != null) {
					monitorMessageQueue.setPriority(15);
					monitorMessageQueue.setSoLanGui(soLanGuiSau);
					MonitorMessageQueueLocalServiceUtil
							.updateMonitorMessageQueue(monitorMessageQueue);
				}

			} catch (SystemException e) {
				e.printStackTrace();
			}
		}
		if (headerRequest != null) {
			List<TempDocument> liTempDocuments = TempDocumentLocalServiceUtil
					.findTemDocumentByDocumentNameAndDocumentYear(headerRequest
							.getSubject().getReference(), headerRequest
							.getSubject().getDocumentYear());
			if (liTempDocuments != null && liTempDocuments.size() > 0) {
				InterfaceRequest interfaceRequest = InterfaceRequestLocalServiceUtil
						.findInterfaceRequestByRequestCode(headerRequest
								.getReference().getMessageId());
				if (interfaceRequest != null) {
					interfaceRequest.setLocCode(liTempDocuments.get(0)
							.getMaritimeCode());
					interfaceRequest.setOrganizationCode("01");
					try {
						InterfaceRequestLocalServiceUtil
								.updateInterfaceRequest(interfaceRequest);
					} catch (SystemException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}

	}

	public void start() {
		System.out.println("go to start processsssss");
		if (t == null) {
			t = new Thread(this, threadName);
			t.start();
			_log.debug("===Starting-------------- " + t.getName());
		}
	}

}
