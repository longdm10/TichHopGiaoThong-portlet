package vn.gt.utils.validation;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import vn.gt.dao.common.model.LogMessageValidation;
import vn.gt.dao.common.model.impl.LogMessageValidationImpl;
import vn.gt.utils.FormatData;
import vn.gt.utils.config.ConfigurationManager;
import vn.nsw.Header;

public class HeaderValidation {
	Log _log = LogFactoryUtil.getLog(HeaderValidation.class);

	public boolean validation(Header header, String requestDirection) throws Exception {
		LogMessageValidation logMessageValidation = new LogMessageValidationImpl();
		logMessageValidation.setRequestCode(header.getReference().getMessageId());
		logMessageValidation.setRequestDirection(requestDirection);
		boolean status = true;
		int [] maLoi2={1,5,6};
		int [] maLoi4={5,6};
		
//Reference
		//version
		if(header.getReference().getVersion() != null){
		status = ValidationUtils.checkValidation(header.getReference().getVersion().trim(), logMessageValidation, "00", "Version", "04", maLoi4, 50, status);
		}
		//messageId
		if(header.getReference().getMessageId() != null){
		status = ValidationUtils.checkValidation(header.getReference().getMessageId().trim(), logMessageValidation, "00", "MessageId", "05", maLoi4, 35, status);
		}
//From
		//name
		if (header.getFrom() == null || header.getFrom().getName() == null) {
			status = false;
		} else {
			status = ValidationUtils.checkValidation(header.getFrom().getName().trim(), logMessageValidation, "00", "Name", "07", maLoi2, 255, status);
		}
		
		//identity
		if (header.getFrom() == null || header.getFrom().getIdentity() == null) {
			status = false;
		} else if(header.getFrom().getIdentity() != null){
			status = ValidationUtils.checkValidation(header.getFrom().getIdentity().trim(), logMessageValidation, "00", "Identity", "08", maLoi4, 13, status);
		}
//To
		//name
		status = ValidationUtils.checkValidation(header.getTo().getName().trim(), logMessageValidation, "00", "Name", "10", maLoi2, 255, status);
		
		//identity
		if(header.getTo().getIdentity() != null){
			status = ValidationUtils.checkValidation(header.getTo().getIdentity().trim(), logMessageValidation, "00", "Identity", "11", maLoi4, 13, status);
		}
//Subject
		//documentType
		_log.debug("---------------documenttype----------" +header.getSubject().getDocumentType());
			if (header.getSubject().getDocumentType()<1) {
				status = false;
				logMessageValidation.setTagProperty("DocumentType");
				logMessageValidation.setDataValidation("N00113: "+ConfigurationManager.getStrProp("vn.gt.logMessageValidation.N001",""));
				ValidationUtils.addLogMessageValidation(logMessageValidation);
			} else if(header.getSubject().getDocumentType()<0 || header.getSubject().getDocumentType()>9){
				status = false;
				logMessageValidation.setTagProperty("DocumentType");
				logMessageValidation.setDataValidation("N00413: "+ConfigurationManager.getStrProp("vn.gt.logMessageValidation.N004", ""));
				ValidationUtils.addLogMessageValidation(logMessageValidation);
				}
		//type 
			//danh muc
			if (header.getSubject().getType()<1) {
				status = false;
				logMessageValidation.setTagProperty("Type");
				logMessageValidation.setDataValidation("N00114: "+ConfigurationManager.getStrProp("vn.gt.logMessageValidation.N001",""));
				ValidationUtils.addLogMessageValidation(logMessageValidation);
			} else if(header.getSubject().getType()<0 || header.getSubject().getType()>999){
				status = false;
				logMessageValidation.setTagProperty("Type");
				logMessageValidation.setDataValidation("N00414: "+ConfigurationManager.getStrProp("vn.gt.logMessageValidation.N004", ""));
				ValidationUtils.addLogMessageValidation(logMessageValidation);
			}
			
			//function
			//danh muc
			if (FormatData.convertToInt(header.getSubject().getFunction())<1) {
				status = false;
				logMessageValidation.setTagProperty("Function");
				logMessageValidation.setDataValidation("N00115: "+ConfigurationManager.getStrProp("vn.gt.logMessageValidation.N001",""));
				ValidationUtils.addLogMessageValidation(logMessageValidation);
			} else if(FormatData.convertToInt(header.getSubject().getFunction())<0 || FormatData.convertToInt(header.getSubject().getFunction())>999){
				status = false;
				logMessageValidation.setTagProperty("Function");
				logMessageValidation.setDataValidation("N00415: "+ConfigurationManager.getStrProp("vn.gt.logMessageValidation.N004", ""));
				ValidationUtils.addLogMessageValidation(logMessageValidation);
			}
			//reference
			if (header.getSubject().getReference()<1) {
				status = false;
				logMessageValidation.setTagProperty("Reference");
				logMessageValidation.setDataValidation("N00116: "+ConfigurationManager.getStrProp("vn.gt.logMessageValidation.N001",""));
				ValidationUtils.addLogMessageValidation(logMessageValidation);
			} else if(header.getSubject().getReference()<0 || header.getSubject().getReference()> 999999999){
				status = false;
				logMessageValidation.setTagProperty("Reference");
				logMessageValidation.setDataValidation("N00416: "+ConfigurationManager.getStrProp("vn.gt.logMessageValidation.N004", ""));
				ValidationUtils.addLogMessageValidation(logMessageValidation);
			}
			//preReference
			if (header.getSubject().getPreReference()<1) {
				status = false;
				logMessageValidation.setTagProperty("PreReference");
				logMessageValidation.setDataValidation("N00117: "+ConfigurationManager.getStrProp("vn.gt.logMessageValidation.N001",""));
				ValidationUtils.addLogMessageValidation(logMessageValidation);
			} else if(header.getSubject().getPreReference()<0 || header.getSubject().getPreReference()> 999999999){
				status = false;
				logMessageValidation.setTagProperty("PreReference");
				logMessageValidation.setDataValidation("N00417: "+ConfigurationManager.getStrProp("vn.gt.logMessageValidation.N004", ""));
				ValidationUtils.addLogMessageValidation(logMessageValidation);
			}
			//documentYear
			if (header.getSubject().getDocumentYear()<1) {
				status = false;
				logMessageValidation.setTagProperty("DocumentYear");
				logMessageValidation.setDataValidation("N00118: "+ConfigurationManager.getStrProp("vn.gt.logMessageValidation.N001",""));
				ValidationUtils.addLogMessageValidation(logMessageValidation);
			} else if(header.getSubject().getDocumentYear()<1000 || header.getSubject().getDocumentYear()> 9999){
				status = false;
				logMessageValidation.setTagProperty("DocumentYear");
				logMessageValidation.setDataValidation("N00418: "+ConfigurationManager.getStrProp("vn.gt.logMessageValidation.N004", ""));
				ValidationUtils.addLogMessageValidation(logMessageValidation);
			}
			//sendDate
			if(header.getSubject().getSendDate()==null){
				status = false;
				logMessageValidation.setTagProperty("SendDate");
				logMessageValidation.setDataValidation("N00119: "+ConfigurationManager.getStrProp("vn.gt.logMessageValidation.N001",""));
				ValidationUtils.addLogMessageValidation(logMessageValidation);
			}else if(!FormatData.isThisDateValid(header.getSubject().getSendDate())){
				status = false;
				logMessageValidation.setTagProperty("SendDate");
				logMessageValidation.setDataValidation("N00719: "+ConfigurationManager.getStrProp("vn.gt.logMessageValidation.N007",""));
				ValidationUtils.addLogMessageValidation(logMessageValidation);
			}
			
			return status;
		}
	}


