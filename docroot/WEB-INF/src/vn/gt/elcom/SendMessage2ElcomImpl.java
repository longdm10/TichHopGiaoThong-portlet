package vn.gt.elcom;

import vn.gt.tichhop.threat.ObjectExcute;
import vn.gt.tichhop.threat.ProcessExecuteMessageTichHopCangUtils;

public class SendMessage2ElcomImpl implements ISendMessage2Elcom {
	public SendMessage2ElcomImpl() {

	}

	@Override
	public String sendAndGetMessage(String requestMessage) {
		System.out.println("Message from Cang Vu   "+requestMessage);
//		ThreadPassingMessageTichHopCangVu.init().add(
//				new ObjectExcute(null, null, requestMessage));
		ProcessExecuteMessageTichHopCangUtils processExecuteMessageTichHopCangUtils = new ProcessExecuteMessageTichHopCangUtils();
		String xml =processExecuteMessageTichHopCangUtils.nhanThongTinCangVu(new ObjectExcute(null, null, requestMessage));
	
		System.out.println("Message tra lai Cang Vu   "+xml);
		return xml;

	}

}
