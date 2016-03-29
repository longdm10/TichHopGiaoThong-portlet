/**
 * 
 */
package vn.gt.tichhop.threat;

import java.util.UUID;

import vn.gt.dao.noticeandmessage.model.HistoryInterfaceRequest;
import vn.gt.dao.noticeandmessage.service.HistoryInterfaceRequestLocalServiceUtil;
import vn.gt.tichhop.message.BusinessUtils;
import vn.gt.tichhop.message.MessageType;
import vn.gt.tichhop.message.TrangThaiHoSo;
import vn.gt.utils.CallWs2CangVu;
import vn.gt.utils.FormatData;
import vn.nsw.Header;
import vn.nsw.fac.ReadMessages;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * @author win_64
 */
public class ProcessExecuteMessageTichHopCang implements Runnable {
	
	Log _log = LogFactoryUtil.getLog(ProcessExecuteMessageTichHopCang.class);
	private Thread t;
	private int timeSleep = 1000;
	private String threadName;
	private BusinessUtils businessUtils = new BusinessUtils();
	
	public ProcessExecuteMessageTichHopCang(String name, int timeSleep) {
		threadName = name;
		this.timeSleep = timeSleep;
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				ObjectExcute objectExcute = ThreadPassingMessageTichHopCangVu.init().getObjectExcute();
				
				if (objectExcute != null) {
					if (objectExcute.getHeader() != null && objectExcute.getLiObjects() != null) {
						
						// La ban tin Cang vu gui len.
						int messageType = objectExcute.getHeader().getSubject().getType();
						_log.info("==check co gui qua hai quan ko messageType==" + messageType);
						
						if (messageType == MessageType.BAN_KHAI_AN_NINH_TAU_BIEN |
								messageType == MessageType.BAN_KHAI_HANG_HOA |
								messageType == MessageType.THONG_BAO_TAU_DEN_CANG |
								messageType == MessageType.XAC_BAO_TAU_DEN_CANG |
								messageType == MessageType.HO_SO |
								messageType == MessageType.THONG_BAO_TAU_ROI_CANG |
								messageType == MessageType.BO_NGANH_PHE_DUYET_HO_SO |
								messageType == MessageType.HUY_GIAY_PHEP_ROI_CANG |
								messageType == MessageType.XAC_NHAN_HUY_LENH_DIEU_DONG |
								messageType == MessageType.Y_CAU_CAP_LAI_GIAY_PHEP_ROI_CANG |
								messageType == MessageType.XAC_NHAN_THONG_QUAN) {
							
							sendChapNhan(objectExcute);
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
	
	private void sendChapNhan(ObjectExcute objectExcute) {
		try {
			_log.info("=============gui  sang cang vu=========== " + objectExcute.getXmlData());
			String vinamarineResponse = CallWs2CangVu.getVNMWS().sendMessage(objectExcute.getXmlData());
			_log.info("======================================Nhan ve tu cang vu================= " + vinamarineResponse);
			
			insertHistoryReceiveMessageResponse(vinamarineResponse);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void insertHistoryReceiveMessageResponse(String dataInput) {
		Header header = null;
		_log.info("===insertHistoryReceiveMessageResponse==Thong tin nhan tu Cang Vu===" + dataInput);
		String data = businessUtils.replaceXML(dataInput.trim());
		
		// Tao ban tin tra ve bao da nhan thong tin.
		try {
			header = ReadMessages.readXMLMessagesHeader(data);
			_log.info("insertHistoryReceiveMessageResponse  " + header.getSubject().getFunction());
			if (header.getSubject().getFunction().equals(MessageType.FUNCTION_THONG_BAO_DA_NHAN_DUOC)) {
				_log.info("insertHistoryReceiveMessageResponse  " + header.getSubject().getFunction());
				businessUtils.insertHistory(header, dataInput, BusinessUtils.HqmcToBoGiaoThong, TrangThaiHoSo.DA_GHI_NHO_YEU_CAU, UUID.randomUUID()
						.toString());
				
				try {
					String messageId = header.getReference().getMessageId();
					HistoryInterfaceRequest historyInterfaceRequest = HistoryInterfaceRequestLocalServiceUtil
							.findHistoryInterfaceRequestByRequestCode(messageId);
					historyInterfaceRequest.setSendingDate(FormatData.parseStringToDate(header.getSubject().getSendDate()));
					if (historyInterfaceRequest.getRequestState() == 1) {
						historyInterfaceRequest.setRequestState(2);
					} else if (historyInterfaceRequest.getRequestState() == 3 || historyInterfaceRequest.getRequestState() == 2) {
						historyInterfaceRequest.setRequestState(4);
					}
					HistoryInterfaceRequestLocalServiceUtil.updateHistoryInterfaceRequest(historyInterfaceRequest);
				} catch (Exception e) {
					e.printStackTrace();
					_log.info(e);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			_log.info(e);
		}
	}
	
}
