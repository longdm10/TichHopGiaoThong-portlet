package vn.gt.tichhop.sendmessage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import vn.dao.gt.asw.model.AswmsgMessageQueue;
import vn.gt.utils.config.ConfigurationManager;

public class ThreatSentMessage {
	private static ThreatSentMessage threadPassingMessage = null;
	Log _log = LogFactoryUtil.getLog(ThreatSentMessage.class);
	public static ConcurrentLinkedQueue<AswmsgMessageQueue> sendMessageQueue = new ConcurrentLinkedQueue<AswmsgMessageQueue>();
	private static List<ProcessSendMessage> listThrea = new ArrayList<ProcessSendMessage>();
	private int numberProcess = 2;
	private int timeSleep = 900;
	
	public static ThreatSentMessage init() {
		try {
			System.out.println("====Go to init()====  ");
          //  if (threadPassingMessage == null) {
            	System.out.println("====Go to init()==== && threadPassingMessage ");
            	int numberProcess = ConfigurationManager.getIntProp("vn.gt.number.process.sendmessage", 1);
            	int timeSleep = ConfigurationManager.getIntProp("vn.gt.time.sleep.process.sendmessage", 900);
            	System.out.println("==numberProcess "+ numberProcess + "timeSleep  " + timeSleep);
            	threadPassingMessage = new ThreatSentMessage(numberProcess, timeSleep);
            	threadPassingMessage.startProcess();
         //   }
           // System.out.println("====Go to init()====  no if");
            return threadPassingMessage;
		} catch (Exception es) {
			es.printStackTrace();
		}
		return null;
	}
	
	private ThreatSentMessage(int numberProcess, int timeSleep) {
		this.numberProcess = numberProcess;
		this.timeSleep = timeSleep;
		_log.debug("==========Initing ThreatSentMessage with numberProcess:" + this.numberProcess + "=======timeSleep===" + this.timeSleep);
	}
	
	private void startProcess() {
		ProcessSendMessage processExecuteMessage = null;
		
		if (listThrea != null && listThrea.size() == 0) {
		
			for (int i = 1; i <= this.numberProcess; i++) {
				System.out.println("==go to start process==");
				processExecuteMessage = new ProcessSendMessage("===ProcessSendMessage== " + i, this.timeSleep);
				processExecuteMessage.start();
				listThrea.add(processExecuteMessage);
				
			}
		}
	}
}
