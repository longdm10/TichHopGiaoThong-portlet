/**
 * 
 */
package vn.gt.tichhop.threat;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

import vn.gt.dao.danhmucgt.model.DmGtRouteConfig;
import vn.gt.dao.danhmucgt.service.DmGtRouteConfigLocalServiceUtil;
import vn.gt.utils.config.ConfigurationManager;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * @author win_64
 */
public class ThreadPassingMessage {
	
	private static ThreadPassingMessage threadPassingMessage = null;
	Log _log = LogFactoryUtil.getLog(ThreadPassingMessage.class);
	public static ConcurrentLinkedQueue<ObjectExcute> listData = new ConcurrentLinkedQueue<ObjectExcute>();
	private int numberProcess = 5;
	private int timeSleep = 1000;
	public static List<DmGtRouteConfig> liConfigs = new ArrayList<DmGtRouteConfig>();
	private static List<ProcessExecuteMessage> listThrea = new ArrayList<ProcessExecuteMessage>();
	
	public static ThreadPassingMessage init() {
		try {
			if (threadPassingMessage == null) {
				int numberProcess = ConfigurationManager.getIntProp("vn.gt.number.process", 5);
				int timeSleep = ConfigurationManager.getIntProp("vn.gt.time.sleep.process", 4000);
				liConfigs = DmGtRouteConfigLocalServiceUtil.findByIsDelete(0);
				threadPassingMessage = new ThreadPassingMessage(numberProcess, timeSleep);
				threadPassingMessage.startProcess();
			}
			return threadPassingMessage;
		} catch (Exception es) {
			es.printStackTrace();
		}
		return null;
	}
	
	public void add(ObjectExcute excute) {
		listData.add(excute);
	}
	
	private ThreadPassingMessage(int numberProcess, int timeSleep) {
		this.numberProcess = numberProcess;
		this.timeSleep = timeSleep;
		_log.info("==========Initing ThreadPassingMessage with numberProcess:" + this.numberProcess + "=======timeSleep===" + this.timeSleep);
	}
	
	private void startProcess() {
		ProcessExecuteMessage processExecuteMessage = null;
		
		if (listThrea != null && listThrea.size() == 0) {
			
			for (int i = 1; i <= this.numberProcess; i++) {
				processExecuteMessage = new ProcessExecuteMessage("Process " + i, this.timeSleep);
				processExecuteMessage.start();
				listThrea.add(processExecuteMessage);
			}
		}
	}
}
