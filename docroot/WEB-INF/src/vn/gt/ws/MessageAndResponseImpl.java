package vn.gt.ws;

import javax.servlet.http.HttpServletRequest;

import org.apache.axis.MessageContext;
import org.apache.axis.transport.http.HTTPConstants;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import vn.gt.facade.IMessageAndResponse;
import vn.gt.tichhop.message.BusinessUtils;
import vn.gt.utils.config.ConfigurationManager;

public class MessageAndResponseImpl implements IMessageAndResponse {

	Log _log = LogFactoryUtil.getLog(MessageAndResponseImpl.class);
	private String ip_call_web_service = ConfigurationManager.getStrProp("ip_call_web_service", "").trim().toLowerCase();

	public MessageAndResponseImpl(){
	}

	@Override
	public String sendAndGetMessage(String requestMessage) {
		String ipClientCallWS = "";
		try {
			ipClientCallWS = ((HttpServletRequest)MessageContext.getCurrentContext().getProperty(HTTPConstants.MC_HTTP_SERVLETREQUEST)).getRemoteAddr();
			if (ipClientCallWS != null) {
				ipClientCallWS = ipClientCallWS.trim().toLowerCase();
			}
			System.out.println(ip_call_web_service + "===IPConfig===Khong lay duoc Ip client goi WS == IPClient= " + ipClientCallWS);
		} catch (Exception es) {
			es.printStackTrace();
		}

		try {
			if (ip_call_web_service == null || ip_call_web_service.trim().length() == 0) {

				System.out.println("====Config khong chan ip call webservice ============= ");
				return executeBusiness(requestMessage);
			} else if (ipClientCallWS != null && ipClientCallWS.trim().length() > 0) {

				System.out.println("====Config chan ip call webservice = =======");
				if (ipClientCallWS.trim().compareTo(ip_call_web_service) == 0 || ipClientCallWS.trim().contains(ip_call_web_service)) {

					return executeBusiness(requestMessage);
				}
				System.out.println(ip_call_web_service + "===IPConfig===Ip client goi WS khong dung IP dang ky== IPClient= " + ipClientCallWS);
			}
		} catch (Exception es) {
			es.printStackTrace();
		}

		System.out.println("============Truyen sai xml ne================" + requestMessage);
		return "Can not parse xml";
	}

	private String executeBusiness(String requestMessage) {
		BusinessUtils businessUtils = new BusinessUtils();
	//	System.out.println("=====Thong tin nhan tu HQMC===" + requestMessage);
		String xmlReturn = businessUtils.receiveMessage(requestMessage);
		//System.out.println("============Tra du lieu  hai quan================" + xmlReturn);
		return xmlReturn;
	}
}
