package vn.gt.portlet.thutuc;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import vn.gt.dao.result.model.ResultCertificate;
import vn.gt.dao.result.model.impl.ResultCertificateImpl;
import vn.gt.dao.result.service.ResultCertificateLocalServiceUtil;
import vn.gt.utils.FormatData;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;

public class ResultCertificate2DbUtils {
	
	public static void insertResultCertificate(ActionResponse httpReq, ActionRequest resourceRequest, long documentName, int documentYear) {
		
		int docCount = ParamUtil.getInteger(resourceRequest, "docCount");
		String hoTenLogin = ParamUtil.getString(resourceRequest, "hoTenLogin");
		String registerNo;
		String certificateCode;
		String certificateName;
		String certificateIssueDate;
		String certificateExpiredDate;
		String examinationDate;
		String checkboxValue = null;
		String isRender = "true";
		
		List<ResultCertificate> lstCertificate;
		
		httpReq.setRenderParameter("docCount", String.valueOf(docCount));
		httpReq.setRenderParameter("hoTenLogin", hoTenLogin);
		httpReq.setRenderParameter("isRender", isRender);
		
		ResultCertificate certificate = null;
		for (int i = 1; i <= docCount; i++) {
			
			checkboxValue = ParamUtil.getString(resourceRequest, "checked_" + i);
			httpReq.setRenderParameter("checked_" + i, checkboxValue);
			
			registerNo = ParamUtil.getString(resourceRequest, "registerNo_" + i);
			httpReq.setRenderParameter("registerNo_" + i, registerNo);
			
			certificateCode = ParamUtil.getString(resourceRequest, "certificateCode_" + i);
			httpReq.setRenderParameter("certificateCode_" + i, certificateCode);
			
			certificateName = ParamUtil.getString(resourceRequest, "certificateName_" + i);
			httpReq.setRenderParameter("certificateName_" + i, certificateName);
			
			certificateIssueDate = ParamUtil.getString(resourceRequest, "certificateIssueDate_" + i);
			
			httpReq.setRenderParameter("certificateIssueDate_" + i, certificateIssueDate);
			
			certificateExpiredDate = ParamUtil.getString(resourceRequest, "certificateExpiredDate_" + i);
			httpReq.setRenderParameter("certificateExpiredDate_" + i, certificateExpiredDate);
			
			examinationDate = ParamUtil.getString(resourceRequest, "examinationDate_" + i);
			httpReq.setRenderParameter("examinationDate_" + i, examinationDate);
			
			lstCertificate = ResultCertificateLocalServiceUtil.findByDocumentNameAndDocumentYearAndCertificateCode(documentName, documentYear,
					certificateCode);
			if ((lstCertificate != null) && (lstCertificate.size() > 0)) {
				certificate = lstCertificate.get(0);
				certificate.setDocumentName(documentName);
				certificate.setDocumentYear(documentYear);
				certificate.setCertificateNo(registerNo);
				certificate.setCertificateCode(certificateCode);
				if ((certificateIssueDate != null) && (!certificateIssueDate.trim().isEmpty())) {
					certificate.setCertificateIssueDate(FormatData.parseStringToDate(certificateIssueDate));
				}
				if ((certificateExpiredDate != null) && (!certificateExpiredDate.trim().isEmpty())) {
					certificate.setCertificateExpiredDate(FormatData.parseStringToDate(certificateExpiredDate));
				}
				if ((examinationDate != null) && (!examinationDate.trim().isEmpty())) {
					certificate.setExaminationDate(FormatData.parseStringToDate(examinationDate));
				}
				certificate.setApprovalName(hoTenLogin);
				if ((checkboxValue != null) && (checkboxValue.equalsIgnoreCase("on"))) {
					certificate.setIsExamined(1);
				} else {
					certificate.setIsExamined(0);
				}
				
				try {
					ResultCertificateLocalServiceUtil.updateResultCertificate(certificate);
				} catch (SystemException e) {
					e.printStackTrace();
				}
			} else {
				certificate = new ResultCertificateImpl();
				certificate.setDocumentName(documentName);
				certificate.setDocumentYear(documentYear);
				certificate.setCertificateNo(registerNo);
				certificate.setCertificateCode(certificateCode);
				
				if ((certificateIssueDate != null) && (!certificateIssueDate.trim().isEmpty())) {
					certificate.setCertificateIssueDate(FormatData.parseStringToDate(certificateIssueDate));
				}
				if ((certificateExpiredDate != null) && (!certificateExpiredDate.trim().isEmpty())) {
					certificate.setCertificateExpiredDate(FormatData.parseStringToDate(certificateExpiredDate));
				}
				if ((examinationDate != null) && (!examinationDate.trim().isEmpty())) {
					certificate.setExaminationDate(FormatData.parseStringToDate(examinationDate));
				}
				certificate.setApprovalName(hoTenLogin);
				
				if ((checkboxValue != null) && (checkboxValue.equalsIgnoreCase("on"))) {
					certificate.setIsExamined(1);
				} else {
					certificate.setIsExamined(0);
				}
				
				try {
					ResultCertificateLocalServiceUtil.addResultCertificate(certificate);
				} catch (SystemException e) {
					e.printStackTrace();
				}
			}
			
		}
	}
	
	public static void insertMandatoryResultCertificate(ActionResponse httpReq, ActionRequest resourceRequest, long documentName, int documentYear) {
		
		int docCount = ParamUtil.getInteger(resourceRequest, "docCount");
		String hoTenLogin = ParamUtil.getString(resourceRequest, "hoTenLogin");
		String registerNo;
		String certificateCode;
		String certificateName;
		String certificateIssueDate;
		String certificateExpiredDate;
		String examinationDate;		
		String mandatoryCheckboxValue = null;
		String isRender = "true";
		
		List<ResultCertificate> lstCertificate;
		
		httpReq.setRenderParameter("docCount", String.valueOf(docCount));
		httpReq.setRenderParameter("hoTenLogin", hoTenLogin);
		httpReq.setRenderParameter("isRender", isRender);
		
		ResultCertificate certificate = null;
		for (int i = 1; i <= docCount; i++) {
			
			mandatoryCheckboxValue = ParamUtil.getString(resourceRequest, "mandatoryChecked_" + i);
			httpReq.setRenderParameter("mandatoryChecked_" + i, mandatoryCheckboxValue);
			
//			if(mandatoryCheckboxValue!=null) {
//				System.out.println("mandatoryCheckboxValue Khac null" + mandatoryCheckboxValue);
//			} else{
//				System.out.println("NULLL");
//			}
			
			registerNo = ParamUtil.getString(resourceRequest, "registerNo_" + i);
			httpReq.setRenderParameter("registerNo_" + i, registerNo);
			
			certificateCode = ParamUtil.getString(resourceRequest, "certificateCode_" + i);
			httpReq.setRenderParameter("certificateCode_" + i, certificateCode);
			
			certificateName = ParamUtil.getString(resourceRequest, "certificateName_" + i);
			httpReq.setRenderParameter("certificateName_" + i, certificateName);
			
			certificateIssueDate = ParamUtil.getString(resourceRequest, "certificateIssueDate_" + i);
			
			httpReq.setRenderParameter("certificateIssueDate_" + i, certificateIssueDate);
			
			certificateExpiredDate = ParamUtil.getString(resourceRequest, "certificateExpiredDate_" + i);
			httpReq.setRenderParameter("certificateExpiredDate_" + i, certificateExpiredDate);
			
			examinationDate = ParamUtil.getString(resourceRequest, "examinationDate_" + i);
			httpReq.setRenderParameter("examinationDate_" + i, examinationDate);
			
			lstCertificate = ResultCertificateLocalServiceUtil.findByDocumentNameAndDocumentYearAndCertificateCode(documentName, documentYear,
					certificateCode);			
			if ((lstCertificate != null) && (lstCertificate.size() > 0)) {
				certificate = lstCertificate.get(0);
				certificate.setDocumentName(documentName);
				certificate.setDocumentYear(documentYear);
				certificate.setCertificateNo(registerNo);
				certificate.setCertificateCode(certificateCode);
				if ((certificateIssueDate != null) && (!certificateIssueDate.trim().isEmpty())) {
					certificate.setCertificateIssueDate(FormatData.parseStringToDate(certificateIssueDate));
				}
				if ((certificateExpiredDate != null) && (!certificateExpiredDate.trim().isEmpty())) {
					certificate.setCertificateExpiredDate(FormatData.parseStringToDate(certificateExpiredDate));
				}
				if ((examinationDate != null) && (!examinationDate.trim().isEmpty())) {
					certificate.setExaminationDate(FormatData.parseStringToDate(examinationDate));
				}
				certificate.setApprovalName(hoTenLogin);	
				if ((mandatoryCheckboxValue != null) && (mandatoryCheckboxValue.equalsIgnoreCase("on"))) {
					certificate.setMandatory(1);
				//	System.out.println("====VAO certificate.setMandatory(1);aaaaaaaaa");
				} else {
					certificate.setMandatory(0);
				}				
				try {
					ResultCertificateLocalServiceUtil.updateResultCertificate(certificate);
				//	System.out.println("update thanh cong;aaaaaaaaa");
				} catch (SystemException e) {
					e.printStackTrace();
				}
			} else {
				certificate = new ResultCertificateImpl();
				certificate.setDocumentName(documentName);
				certificate.setDocumentYear(documentYear);
				certificate.setCertificateNo(registerNo);
				certificate.setCertificateCode(certificateCode);
				
				if ((certificateIssueDate != null) && (!certificateIssueDate.trim().isEmpty())) {
					certificate.setCertificateIssueDate(FormatData.parseStringToDate(certificateIssueDate));
				}
				if ((certificateExpiredDate != null) && (!certificateExpiredDate.trim().isEmpty())) {
					certificate.setCertificateExpiredDate(FormatData.parseStringToDate(certificateExpiredDate));
				}
				if ((examinationDate != null) && (!examinationDate.trim().isEmpty())) {
					certificate.setExaminationDate(FormatData.parseStringToDate(examinationDate));
				}
				certificate.setApprovalName(hoTenLogin);				
				
				if ((mandatoryCheckboxValue != null) && (mandatoryCheckboxValue.equalsIgnoreCase("on"))) {
					certificate.setMandatory(1);
					
					//System.out.println("====VAO certificate.setMandatory(1);");
				} else {
					certificate.setMandatory(0);
				}
								
				try {
					ResultCertificateLocalServiceUtil.addResultCertificate(certificate);
				} catch (SystemException e) {
					e.printStackTrace();
				}
			}
			
		}
	}
	
	public static void insertExaminedResultCertificate(ActionResponse httpReq, ActionRequest resourceRequest, long documentName, int documentYear) {
		
		int docCount = ParamUtil.getInteger(resourceRequest, "docCount");
		String hoTenLogin = ParamUtil.getString(resourceRequest, "hoTenLogin");
		String registerNo;
		String certificateCode;
		String certificateName;
		String certificateIssueDate;
		String certificateExpiredDate;
		String examinationDate;
		String examniedCheckboxValue = null;		
		String isRender = "true";
		
		List<ResultCertificate> lstCertificate;
		
		httpReq.setRenderParameter("docCount", String.valueOf(docCount));
		httpReq.setRenderParameter("hoTenLogin", hoTenLogin);
		httpReq.setRenderParameter("isRender", isRender);
		
		ResultCertificate certificate = null;
		for (int i = 1; i <= docCount; i++) {
			
			examniedCheckboxValue = ParamUtil.getString(resourceRequest, "examniedChecked_" + i);
			httpReq.setRenderParameter("examniedChecked_" + i, examniedCheckboxValue);			
			
			registerNo = ParamUtil.getString(resourceRequest, "registerNo_" + i);
			httpReq.setRenderParameter("registerNo_" + i, registerNo);
			
			certificateCode = ParamUtil.getString(resourceRequest, "certificateCode_" + i);
			httpReq.setRenderParameter("certificateCode_" + i, certificateCode);
			
			certificateName = ParamUtil.getString(resourceRequest, "certificateName_" + i);
			httpReq.setRenderParameter("certificateName_" + i, certificateName);
			
			certificateIssueDate = ParamUtil.getString(resourceRequest, "certificateIssueDate_" + i);
			
			httpReq.setRenderParameter("certificateIssueDate_" + i, certificateIssueDate);
			
			certificateExpiredDate = ParamUtil.getString(resourceRequest, "certificateExpiredDate_" + i);
			httpReq.setRenderParameter("certificateExpiredDate_" + i, certificateExpiredDate);
			
			examinationDate = ParamUtil.getString(resourceRequest, "examinationDate_" + i);
			httpReq.setRenderParameter("examinationDate_" + i, examinationDate);
			
			lstCertificate = ResultCertificateLocalServiceUtil.findByDocumentNameAndDocumentYearAndCertificateCode(documentName, documentYear,
					certificateCode);
			if ((lstCertificate != null) && (lstCertificate.size() > 0)) {
				certificate = lstCertificate.get(0);
				certificate.setDocumentName(documentName);
				certificate.setDocumentYear(documentYear);
				certificate.setCertificateNo(registerNo);
				certificate.setCertificateCode(certificateCode);
				if ((certificateIssueDate != null) && (!certificateIssueDate.trim().isEmpty())) {
					certificate.setCertificateIssueDate(FormatData.parseStringToDate(certificateIssueDate));
				}
				if ((certificateExpiredDate != null) && (!certificateExpiredDate.trim().isEmpty())) {
					certificate.setCertificateExpiredDate(FormatData.parseStringToDate(certificateExpiredDate));
				}
				if ((examinationDate != null) && (!examinationDate.trim().isEmpty())) {
					certificate.setExaminationDate(FormatData.parseStringToDate(examinationDate));
				}
				certificate.setApprovalName(hoTenLogin);
				if ((examniedCheckboxValue != null) && (examniedCheckboxValue.equalsIgnoreCase("on"))) {
					certificate.setIsExamined(1);
				} else {
					certificate.setIsExamined(0);
				}
				
				try {
					ResultCertificateLocalServiceUtil.updateResultCertificate(certificate);
				} catch (SystemException e) {
					e.printStackTrace();
				}
			} else {
				certificate = new ResultCertificateImpl();
				certificate.setDocumentName(documentName);
				certificate.setDocumentYear(documentYear);
				certificate.setCertificateNo(registerNo);
				certificate.setCertificateCode(certificateCode);
				
				if ((certificateIssueDate != null) && (!certificateIssueDate.trim().isEmpty())) {
					certificate.setCertificateIssueDate(FormatData.parseStringToDate(certificateIssueDate));
				}
				if ((certificateExpiredDate != null) && (!certificateExpiredDate.trim().isEmpty())) {
					certificate.setCertificateExpiredDate(FormatData.parseStringToDate(certificateExpiredDate));
				}
				if ((examinationDate != null) && (!examinationDate.trim().isEmpty())) {
					certificate.setExaminationDate(FormatData.parseStringToDate(examinationDate));
				}
				certificate.setApprovalName(hoTenLogin);
				
				if ((examniedCheckboxValue != null) && (examniedCheckboxValue.equalsIgnoreCase("on"))) {
					certificate.setIsExamined(1);
				} else {
					certificate.setIsExamined(0);
				}				
								
				try {
					ResultCertificateLocalServiceUtil.addResultCertificate(certificate);
				} catch (SystemException e) {
					e.printStackTrace();
				}
			}
			
		}
	}
}
