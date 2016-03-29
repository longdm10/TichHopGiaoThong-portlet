package vn.gt.tichhop.sendmessage;

import java.util.ArrayList;
import java.util.List;

import vn.gt.utils.config.ConfigurationManager;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class ThreatReadDB {
	private static ThreatReadDB threatReadDB = null;
	Log _log = LogFactoryUtil.getLog(ThreatSentMessage.class);	
	private static List<ProcessReadDB> listThrea = new ArrayList<ProcessReadDB>();
	private int numberProcess = 1;
	private int timeSleep = 9000;
	
	public static ThreatReadDB init() {
		System.out.println("====Go to init()====  ");
		try {
        //    if (threatReadDB == null) {
            	int numberProcess = ConfigurationManager.getIntProp("vn.gt.count.processreaddb", 1);
            	int timeSleep = ConfigurationManager.getIntProp("vn.gt.time.sleep.process.readerdb", 9000);
            	threatReadDB = new ThreatReadDB(numberProcess, timeSleep);
            	threatReadDB.startProcess();
          //  }
            return threatReadDB;
		} catch (Exception es) {
			es.printStackTrace();
		}
		return null;
	}
	
	private ThreatReadDB(int numberProcess, int timeSleep) {
		this.numberProcess = numberProcess;
		this.timeSleep = timeSleep;
		_log.debug("==========Initing ThreatSentMessage with numberProcess:" + this.numberProcess + "=======timeSleep===" + this.timeSleep);
	}
	
	private void startProcess() {
		ProcessReadDB processReadDb = null;
		
		if (listThrea != null && listThrea.size() == 0) {
		
			for (int i = 1; i <= this.numberProcess; i++) {
				processReadDb = new ProcessReadDB("===ProcessReadDB== " + i, this.timeSleep);
				processReadDb.start();
				listThrea.add(processReadDb);
			}
		}
	}
}
