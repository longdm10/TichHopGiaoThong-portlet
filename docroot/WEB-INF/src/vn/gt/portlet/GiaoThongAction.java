package vn.gt.portlet;

import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.tempuri.IMTService;

import vn.gt.tichhop.message.BusinessUtils;
import vn.gt.tichhop.message.MessageType;
import vn.gt.tichhop.message.haiquan2giaothong.NhapCanhHaiQuan2GiaoThongBusiness;
import vn.gt.utils.CallWs2HaiQuan;
import vn.gt.utils.FormatData;
import vn.nsw.Header;
import vn.nsw.Header.From;
import vn.nsw.Header.Reference;
import vn.nsw.Header.Subject;
import vn.nsw.Header.To;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class GiaoThongAction extends MVCPortlet {
	private static Log log = LogFactoryUtil.getLog(GiaoThongAction.class);
	
	private User getUser(ActionRequest resourceRequest, ActionResponse httpReq) {
	
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		return themeDisplay.getUser();
	}
	
	public void searchDocument(ResourceRequest request, ResourceResponse response) throws Exception {
	
	}
	
	public void callMessageFromHaiQuan(ActionRequest resourceRequest, ActionResponse httpReq) throws NumberFormatException, Exception {
	
		String xmlData = "";
		
		Header header = new Header();
		BusinessUtils businessUtils = new BusinessUtils();
		
		int type = ParamUtil.getInteger(resourceRequest, "type_");
		String function = ParamUtil.getString(resourceRequest, "function");
		
		int ref_version = ParamUtil.getInteger(resourceRequest, "ref_version");
		String ref_messageId = ParamUtil.getString(resourceRequest, "ref_messageId");
		
		String frm_name = ParamUtil.getString(resourceRequest, "frm_name");
		int frm_identity = ParamUtil.getInteger(resourceRequest, "frm_identity");
		
		String to_name = ParamUtil.getString(resourceRequest, "to_name");
		int to_identity = ParamUtil.getInteger(resourceRequest, "to_identity");
		
		int documentType = ParamUtil.getInteger(resourceRequest, "documentType");
		int reference = ParamUtil.getInteger(resourceRequest, "reference");
		int preReference = ParamUtil.getInteger(resourceRequest, "preReference");
		int documentYear = ParamUtil.getInteger(resourceRequest, "documentYear");
		String sendDate = ParamUtil.getString(resourceRequest, "sendDate");
		
		Subject subject = new Subject();
		subject.setDocumentType(documentType);
		subject.setDocumentYear(documentYear);
		subject.setFunction(function);
		subject.setPreReference(preReference);
		subject.setReference(reference);
		subject.setSendDate(FormatData.parseDateToTring(FormatData.parseStringToDate(sendDate)));
		subject.setType(type);
		
		From from = new From();
		from.setIdentity(String.valueOf(frm_identity));
		from.setName(frm_name);
		
		To to = new To();
		to.setIdentity(String.valueOf(to_identity));
		to.setName(to_name);
		
		Reference ref = new Reference();
		ref.setMessageId(ref_messageId);
		ref.setVersion(String.valueOf(ref_version));
		
		header.setFrom(from);
		header.setTo(to);
		header.setReference(ref);
		header.setSubject(subject);
		
		
		if (function.equals( 22) && type == 99) {
			//tu choi ho so, chung tu
			xmlData = businessUtils.sendMessageReject(header, ref_messageId, "anhnt1", "anhnt2", "anhnt3", "anhnt4", new Date(), null);
			
		} else if (function.equals( 21) && type == 99) {
			//chap nhan ho so, chung tu
			xmlData = businessUtils.sendMessageAccept(header, "anhnt5", "anhnt6", "anhnt7", new Date(), null);
			
		} else if (function.equals( 23) && type == 99) {
			//xac nhan hoan thanh thu tuc
			xmlData = businessUtils.sendMessageConformed(header, new Date(), null);
			
		} else if (function.equals( 1)) {
			//Tra ket qua
			xmlData = businessUtils.sendMessageResult(header, "", null);
		}
		
		
		
//		
//		if (MessageValidates.validateMessages(resourceRequest)) {
//			MessageUtils messageUtils = new MessageUtils();
//			String result = messageUtils.genMessages(resourceRequest, httpReq);
//			System.out.println(result);
//		} else {
//			MessageUtils messageUtils = new MessageUtils();
//			String result = messageUtils.genMessages(resourceRequest, httpReq);
//			System.out.println(result);
//		}
//		
		
		System.out.println("=======Du lieu gui HQMC day ========" + xmlData);
		
	   IMTService imtService =	 CallWs2HaiQuan.getIMTSercice();
	   
	   String result="";
	   if(MessageType.TAU_VAO == documentType || MessageType.TAU_RA == documentType){
		   log.info("call receiveFromInland ");
		   result = imtService.receiveFromInland(xmlData);
	   }else{	   
		   result =  imtService.receiveResultFromMT(xmlData);
	   }
	   System.out.println("=======Du lieu NHAN  HQMC day ========" + result);
	   
	   businessUtils.insertHistoryReceiveMessageResponse(result);
	   
	   resourceRequest.setAttribute("RESULT", result);
	   
		
	}
	
}
