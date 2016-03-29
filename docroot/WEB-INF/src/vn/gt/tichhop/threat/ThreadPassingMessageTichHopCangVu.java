/**
 * 
 */
package vn.gt.tichhop.threat;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

import vn.gt.utils.config.ConfigurationManager;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * @author win_64
 */
public class ThreadPassingMessageTichHopCangVu {
	
	private static ThreadPassingMessageTichHopCangVu threadPassingMessageTichHopCangVu = null;
	Log _log = LogFactoryUtil.getLog(ThreadPassingMessageTichHopCangVu.class);
	private static ConcurrentLinkedQueue<ObjectExcute> listData = new ConcurrentLinkedQueue<ObjectExcute>();
	private int numberProcess = 5;
	private int timeSleep = 1000;
	private static List<ProcessExecuteMessageTichHopCang> listThrea = new ArrayList<ProcessExecuteMessageTichHopCang>();
	
	public static ThreadPassingMessageTichHopCangVu init() {
		try {
			if (threadPassingMessageTichHopCangVu == null) {
				int numberProcess = ConfigurationManager.getIntProp("vn.gt.number.process.tich.hop.cang.vu", 5);
				int timeSleep = ConfigurationManager.getIntProp("vn.gt.time.sleep.process.tich.hop.cang.vu", 4000);
				threadPassingMessageTichHopCangVu = new ThreadPassingMessageTichHopCangVu(numberProcess, timeSleep);
				threadPassingMessageTichHopCangVu.startProcess();
			}
			return threadPassingMessageTichHopCangVu;
		} catch (Exception es) {
			es.printStackTrace();
		}
		return null;
	}
	
	public void add(ObjectExcute excute) {
		listData.add(excute);
	}
	
	public ObjectExcute getObjectExcute() {
		return listData.poll();
	}
	
	private ThreadPassingMessageTichHopCangVu(int numberProcess, int timeSleep) {
		this.numberProcess = numberProcess;
		this.timeSleep = timeSleep;
		_log.debug("==========Initing ThreadPassingMessageTichHopCangVu with numberProcess:" + this.numberProcess + "=======timeSleep==="
				+ this.timeSleep);
	}
	
	private void startProcess() {
		ProcessExecuteMessageTichHopCang processExecuteMessage = null;
		
		if (listThrea != null && listThrea.size() == 0) {
			
			for (int i = 1; i <= this.numberProcess; i++) {
				processExecuteMessage = new ProcessExecuteMessageTichHopCang("ProcessExecuteMessageTichHopCang " + i, this.timeSleep);
				processExecuteMessage.start();
				listThrea.add(processExecuteMessage);
			}
		}
	}
}
