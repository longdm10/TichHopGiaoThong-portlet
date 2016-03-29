package vn.gt.portlet.thutuc;

import java.io.IOException;
import java.io.File;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.commons.io.FileUtils;

import vgca.svrsigner.ServerSigner;
import vn.gt.portlet.kehoach1.ConvertUtil;
import vn.gt.portlet.kehoach1.PortletUtil;
import vn.gt.portlet.thutuc.SignatureUtil;
import vn.gt.tichhop.report.ReportUtils;
import vn.gt.utils.document.DocumentStorageImpl;
import vn.gt.utils.document.ResultUpload;

import com.liferay.portal.kernel.util.Base64;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.gt.dao.danhmuc.model.DmPort;
import vn.gt.dao.danhmuc.model.DmPortRegion;
import vn.gt.dao.danhmuc.service.DmPortLocalServiceUtil;
import vn.gt.dao.danhmuc.service.DmPortRegionLocalServiceUtil;
import vn.gt.dao.noticeandmessage.model.IssuePermissionForTransit;
import vn.gt.dao.noticeandmessage.model.IssuePortClearance;
import vn.gt.dao.noticeandmessage.model.TempDocument;
import vn.gt.dao.noticeandmessage.service.IssuePermissionForTransitLocalServiceUtil;
import vn.gt.dao.noticeandmessage.service.IssuePortClearanceLocalServiceUtil;
import vn.gt.dao.noticeandmessage.service.TempDocumentLocalServiceUtil;
import vn.gt.menu.MenuConstraint;
import vn.gt.portlet.TransportationMVCAction;
import vn.gt.tichhop.message.BusinessUtils;
import vn.gt.tichhop.message.MessageType;
import vn.gt.tichhop.message.haiquan2giaothong.NhapCanhHaiQuan2GiaoThongBusiness;
import vn.gt.tichhop.message.haiquan2giaothong.QuaCanhHaiQuan2GiaoThongBusiness;
import vn.gt.tichhop.message.haiquan2giaothong.XuatCanhHaiQuan2GiaoThongBusiness;
import vn.gt.utils.FormatData;
import vn.gt.utils.KeyParams;
import vn.gt.utils.PageType;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;




/**
 * Portlet implementation class ThuTucAction
 */
public class ThuTucAction extends TransportationMVCAction {
	
	private Log log = LogFactoryUtil.getLog(ThuTucAction.class);
	
	public void doiChieuHoSoQuaCanh(ActionRequest resourceRequest, ActionResponse httpReq) throws NumberFormatException, Exception {
		log.info("====Method==doiChieuHoSoQuaCanh=======");
		long documentName = ParamUtil.getLong(resourceRequest, PageType.DOCUMENT_NAME);
		int messageType = ParamUtil.getInteger(resourceRequest, PageType.MESSAGE_TYPE);
		int documentYear = ParamUtil.getInteger(resourceRequest, PageType.DOCUMENT_YEAR);
		String pageType = ParamUtil.getString(resourceRequest, PageType.PAGE_TYPE);
		String tieuDe = ParamUtil.getString(resourceRequest, PageType.TIEU_DE_BAN_KHAI);
		String requestCode = ParamUtil.getString(resourceRequest, PageType.REQUEST_CODE);
		String menuSelected = ParamUtil.getString(resourceRequest, MenuConstraint.SESSION_MENU_SELECTED);
		
		int actionType = ParamUtil.getInteger(resourceRequest, PageType.ACTION_TYPE);
		String roleType = "";
		
		if (resourceRequest.getPortletSession().getAttribute(PageType.ROLE_TYPE, PortletSession.APPLICATION_SCOPE) != null) {
			roleType = resourceRequest.getPortletSession().getAttribute(PageType.ROLE_TYPE, PortletSession.APPLICATION_SCOPE).toString();
		}
		
		log.info("====call doiChieuHoSoQuaCanh=====documentName==" + documentName);
		
		httpReq.setRenderParameter(PageType.DOCUMENT_NAME, String.valueOf(documentName));
		httpReq.setRenderParameter(PageType.MESSAGE_TYPE, String.valueOf(messageType));
		httpReq.setRenderParameter(PageType.DOCUMENT_YEAR, String.valueOf(documentYear));
		httpReq.setRenderParameter(PageType.PAGE_TYPE, pageType);
		httpReq.setRenderParameter(PageType.TIEU_DE_BAN_KHAI, tieuDe);
		
		if (requestCode != null && requestCode.length() > 0) {
			httpReq.setRenderParameter(PageType.REQUEST_CODE, requestCode);
		}
		if (menuSelected != null && menuSelected.trim().length() > 0) {
			httpReq.setRenderParameter(MenuConstraint.SESSION_MENU_SELECTED, menuSelected);
		}
		
		PortletConfig portletConfig = (PortletConfig) resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		SessionMessages.add(resourceRequest, portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	}
	
	public void kiemDuyetHoSoNhapCanh(ActionRequest resourceRequest, ActionResponse httpReq) throws NumberFormatException, Exception {		
		Integer btnActionType =  FormatData.convertToInt(ParamUtil.getString(resourceRequest, "BTN_ACTION_TYPE"));	
		String lyDoTuChoiGiayTo = ParamUtil.getString(resourceRequest, PageType.LY_DO_TU_CHOI_GIAY_TO);
		log.info("================  int btnActionType: " + btnActionType);
		log.info("================  lyDoTuChoiGiayTo: " + lyDoTuChoiGiayTo);
		
		long documentName = ParamUtil.getLong(resourceRequest, PageType.DOCUMENT_NAME);
		int messageType = 0;
		int documentYear = ParamUtil.getInteger(resourceRequest, PageType.DOCUMENT_YEAR);
		String pageType = ParamUtil.getString(resourceRequest, PageType.PAGE_TYPE);
		String tieuDe = ParamUtil.getString(resourceRequest, PageType.TIEU_DE_BAN_KHAI);
		String menuSelected = ParamUtil.getString(resourceRequest, MenuConstraint.SESSION_MENU_SELECTED);
		String userLogin = getUserName(resourceRequest, httpReq);
		String requestCode = ParamUtil.getString(resourceRequest, PageType.REQUEST_CODE);
		String messageType1 = ParamUtil.getString(resourceRequest, PageType.MESSAGE_TYPE);
		
		messageType = Integer.valueOf(messageType1);
		
		
		if(btnActionType != null && btnActionType == 1){
			ResultCertificate2DbUtils.insertMandatoryResultCertificate(httpReq, resourceRequest, documentName, documentYear);
		}else if(btnActionType != null && btnActionType == 2){
			ResultCertificate2DbUtils.insertExaminedResultCertificate(httpReq, resourceRequest, documentName, documentYear);
		}else if(btnActionType != null && btnActionType == 0){
			
		}else{
			ResultCertificate2DbUtils.insertResultCertificate(httpReq, resourceRequest, documentName, documentYear);
		}
		
		//log.debug("====call kiemDuyetHoSoNhapCanh=====documentName==" + documentName);
		
		//log.info("====kiemDuyetHoSo==RoiCang=== messageType===AAAAAAAAAAAAAAAAAAAAAAAAAAAAA " + messageType  + "requestCode====:   " + requestCode + "Pagetype action == " + pageType);
		XuatCanhHaiQuan2GiaoThongBusiness xuatCanhHaiQuan2GiaoThongBusiness  = new XuatCanhHaiQuan2GiaoThongBusiness();
		xuatCanhHaiQuan2GiaoThongBusiness.sentMessageKiemDuyetHoSoDinhKem(userLogin, Integer.valueOf(pageType), documentName, documentYear, requestCode,
				messageType, resourceRequest, httpReq, btnActionType, lyDoTuChoiGiayTo);
		ResultCertificate2DbUtils.insertResultCertificate(httpReq, resourceRequest, documentName, documentYear);
		
		httpReq.setRenderParameter(PageType.DOCUMENT_NAME, String.valueOf(documentName));
		httpReq.setRenderParameter(PageType.MESSAGE_TYPE, String.valueOf(messageType));
		httpReq.setRenderParameter(PageType.DOCUMENT_YEAR, String.valueOf(documentYear));
		httpReq.setRenderParameter("BTN_ACTION_TYPE", String.valueOf(btnActionType));
		httpReq.setRenderParameter(PageType.PAGE_TYPE, pageType);
		httpReq.setRenderParameter(PageType.TIEU_DE_BAN_KHAI, tieuDe);
		if (menuSelected != null && menuSelected.trim().length() > 0) {
			httpReq.setRenderParameter(MenuConstraint.SESSION_MENU_SELECTED, menuSelected);
		}
		
		PortletConfig portletConfig = (PortletConfig) resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		SessionMessages.add(resourceRequest, portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	}
	
	public void kiemDuyetHoSoQuaCanh(ActionRequest resourceRequest, ActionResponse httpReq) throws NumberFormatException, Exception {
		
		log.info("================kiemDuyetHoSoQuaCanh================");
		
		long documentName = ParamUtil.getLong(resourceRequest, PageType.DOCUMENT_NAME);
		int messageType = ParamUtil.getInteger(resourceRequest, PageType.MESSAGE_TYPE);
		int documentYear = ParamUtil.getInteger(resourceRequest, PageType.DOCUMENT_YEAR);
		String pageType = ParamUtil.getString(resourceRequest, PageType.PAGE_TYPE);
		String tieuDe = ParamUtil.getString(resourceRequest, PageType.TIEU_DE_BAN_KHAI);
		String requestCode = ParamUtil.getString(resourceRequest, PageType.REQUEST_CODE);
		int actionType = ParamUtil.getInteger(resourceRequest, PageType.ACTION_TYPE);
		String menuSelected = ParamUtil.getString(resourceRequest, MenuConstraint.SESSION_MENU_SELECTED);
		String roleType = "";
		if (resourceRequest.getPortletSession().getAttribute(PageType.ROLE_TYPE, PortletSession.APPLICATION_SCOPE) != null) {
			roleType = resourceRequest.getPortletSession().getAttribute(PageType.ROLE_TYPE, PortletSession.APPLICATION_SCOPE).toString();
		}
		
		ResultCertificate2DbUtils.insertResultCertificate(httpReq, resourceRequest, documentName, documentYear);
		
		log.debug("====call kiemDuyetHoSoQuaCanh=====documentName==" + documentName);
		
		httpReq.setRenderParameter(PageType.DOCUMENT_NAME, String.valueOf(documentName));
		httpReq.setRenderParameter(PageType.MESSAGE_TYPE, String.valueOf(messageType));
		httpReq.setRenderParameter(PageType.DOCUMENT_YEAR, String.valueOf(documentYear));
		httpReq.setRenderParameter(PageType.PAGE_TYPE, pageType);
		httpReq.setRenderParameter(PageType.TIEU_DE_BAN_KHAI, tieuDe);
		if (requestCode != null && requestCode.length() > 0) {
			httpReq.setRenderParameter(PageType.REQUEST_CODE, requestCode);
		}
		if (menuSelected != null && menuSelected.trim().length() > 0) {
			httpReq.setRenderParameter(MenuConstraint.SESSION_MENU_SELECTED, menuSelected);
		}
		
		PortletConfig portletConfig = (PortletConfig) resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		SessionMessages.add(resourceRequest, portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	}
	
	public void kiemDuyetHoSoXuatCanh(ActionRequest resourceRequest, ActionResponse httpReq) throws NumberFormatException, Exception {
		
		log.info("================kiemDuyetHoSo==XUAT CANH================");
		
		long documentName = ParamUtil.getLong(resourceRequest, PageType.DOCUMENT_NAME);
		int messageType = ParamUtil.getInteger(resourceRequest, PageType.MESSAGE_TYPE);
		int documentYear = ParamUtil.getInteger(resourceRequest, PageType.DOCUMENT_YEAR);
		String pageType = ParamUtil.getString(resourceRequest, PageType.PAGE_TYPE);
		int actionType = ParamUtil.getInteger(resourceRequest, PageType.ACTION_TYPE);
		String requestCode = ParamUtil.getString(resourceRequest, PageType.REQUEST_CODE);
		String tieuDe = ParamUtil.getString(resourceRequest, PageType.TIEU_DE_BAN_KHAI);
		String menuSelected = ParamUtil.getString(resourceRequest, MenuConstraint.SESSION_MENU_SELECTED);
		
		String roleType = "";
		if (resourceRequest.getPortletSession().getAttribute(PageType.ROLE_TYPE, PortletSession.APPLICATION_SCOPE) != null) {
			roleType = resourceRequest.getPortletSession().getAttribute(PageType.ROLE_TYPE, PortletSession.APPLICATION_SCOPE).toString();
		}
		
		ResultCertificate2DbUtils.insertResultCertificate(httpReq, resourceRequest, documentName, documentYear);
		
		log.debug("====call kiemDuyetHoSoXuatCanh=====documentName==" + documentName);
		
		httpReq.setRenderParameter(PageType.DOCUMENT_NAME, String.valueOf(documentName));
		httpReq.setRenderParameter(PageType.MESSAGE_TYPE, String.valueOf(messageType));
		httpReq.setRenderParameter(PageType.DOCUMENT_YEAR, String.valueOf(documentYear));
		httpReq.setRenderParameter(PageType.PAGE_TYPE, pageType);
		if (requestCode != null && requestCode.length() > 0) {
			httpReq.setRenderParameter(PageType.REQUEST_CODE, requestCode);
		}
		httpReq.setRenderParameter(PageType.TIEU_DE_BAN_KHAI, tieuDe);
		if (menuSelected != null && menuSelected.trim().length() > 0) {
			httpReq.setRenderParameter(MenuConstraint.SESSION_MENU_SELECTED, menuSelected);
		}
		
		PortletConfig portletConfig = (PortletConfig) resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		SessionMessages.add(resourceRequest, portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	}
	
	public void kiemDuyetHoSoRoiCang(ActionRequest resourceRequest, ActionResponse httpReq) throws NumberFormatException, Exception {	
		Integer btnActionType =  FormatData.convertToInt(ParamUtil.getString(resourceRequest, "BTN_ACTION_TYPE"));			
		String lyDoTuChoiGiayTo = ParamUtil.getString(resourceRequest, PageType.LY_DO_TU_CHOI_GIAY_TO);
		log.info("================  int btnActionType: " + btnActionType);		
		log.info("================  lyDoTuChoiGiayTo: " + lyDoTuChoiGiayTo);	
		log.info("================kiemDuyetHoSo==RoiCang================");
		
		long documentName = ParamUtil.getLong(resourceRequest, PageType.DOCUMENT_NAME);
		int messageType = ParamUtil.getInteger(resourceRequest, PageType.MESSAGE_TYPE);
		int documentYear = ParamUtil.getInteger(resourceRequest, PageType.DOCUMENT_YEAR);
		String pageType = ParamUtil.getString(resourceRequest, PageType.PAGE_TYPE);
		int actionType = ParamUtil.getInteger(resourceRequest, PageType.ACTION_TYPE);
		String requestCode = ParamUtil.getString(resourceRequest, PageType.REQUEST_CODE);
		String tieuDe = ParamUtil.getString(resourceRequest, PageType.TIEU_DE_BAN_KHAI);
		String menuSelected = ParamUtil.getString(resourceRequest, MenuConstraint.SESSION_MENU_SELECTED);
		String userLogin = getUserName(resourceRequest, httpReq);
		/*String roleType = "";
		if (resourceRequest.getPortletSession().getAttribute(PageType.ROLE_TYPE, PortletSession.APPLICATION_SCOPE) != null) {
			roleType = resourceRequest.getPortletSession().getAttribute(PageType.ROLE_TYPE, PortletSession.APPLICATION_SCOPE).toString();
		}*/
		//TempDocument temDocument = TempDocumentLocalServiceUtil.findTemDocumentByDocumentNameDocumentYear(documentName, documentYear);
		
		log.info("kiemDuyetHoSo==RoiCang ACTION TYPE " + actionType);
		
		if(btnActionType != null && btnActionType == 1){
			ResultCertificate2DbUtils.insertMandatoryResultCertificate(httpReq, resourceRequest, documentName, documentYear);
		}else if(btnActionType != null && btnActionType == 2){
			ResultCertificate2DbUtils.insertExaminedResultCertificate(httpReq, resourceRequest, documentName, documentYear);
		}else if(btnActionType != null && btnActionType == 0){
			
		}else{
			ResultCertificate2DbUtils.insertResultCertificate(httpReq, resourceRequest, documentName, documentYear);
		}	
		
		
		
		log.info("====kiemDuyetHoSo==RoiCang=== messageType===AAAAAAAAAAAAAAAAAAAAAAAAAAAAA" + messageType + "requestCode====:   " + requestCode + "Pagetype action == " + pageType);
		XuatCanhHaiQuan2GiaoThongBusiness xuatCanhHaiQuan2GiaoThongBusiness  = new XuatCanhHaiQuan2GiaoThongBusiness();
		xuatCanhHaiQuan2GiaoThongBusiness.sentMessageKiemDuyetHoSoDinhKem(userLogin, Integer.valueOf(pageType), documentName, documentYear, requestCode,
				messageType, resourceRequest, httpReq, btnActionType, lyDoTuChoiGiayTo);
		
		
		
//		if(temDocument.getDocumentTypeCode().equals("4")) {
//			NhapCanhHaiQuan2GiaoThongBusiness giaoThongBusiness = new NhapCanhHaiQuan2GiaoThongBusiness();
//			Boolean result = giaoThongBusiness.xuLyNhapCanhRoleThuTucInland( documentName, messageType, documentYear, actionType,
//					getUserName(resourceRequest, httpReq), resourceRequest, httpReq);
//		} else {
//			XuatCanhHaiQuan2GiaoThongBusiness giaoThongBusiness = new XuatCanhHaiQuan2GiaoThongBusiness();
//			Boolean result = giaoThongBusiness.xuLyNhapCanhRoleThuTucInland(documentName, messageType, documentYear, actionType,
//					getUserName(resourceRequest, httpReq), resourceRequest, httpReq);
//		}
		
		
		
		
		log.debug("====call kiemDuyetHoSoRoiCang=====documentName==" + documentName);
		
		httpReq.setRenderParameter(PageType.DOCUMENT_NAME, String.valueOf(documentName));
		httpReq.setRenderParameter(PageType.MESSAGE_TYPE, String.valueOf(messageType));
		httpReq.setRenderParameter(PageType.DOCUMENT_YEAR, String.valueOf(documentYear));
		httpReq.setRenderParameter(PageType.PAGE_TYPE, pageType);
		httpReq.setRenderParameter(PageType.ACTION_TYPE, String.valueOf(actionType));
		httpReq.setRenderParameter("BTN_ACTION_TYPE", String.valueOf(btnActionType));
		if (requestCode != null && requestCode.length() > 0) {
			httpReq.setRenderParameter(PageType.REQUEST_CODE, requestCode);
		}
		httpReq.setRenderParameter(PageType.TIEU_DE_BAN_KHAI, tieuDe);
		if (menuSelected != null && menuSelected.trim().length() > 0) {
			httpReq.setRenderParameter(MenuConstraint.SESSION_MENU_SELECTED, menuSelected);
		}
		
		PortletConfig portletConfig = (PortletConfig) resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		SessionMessages.add(resourceRequest, portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	}
	
	public void yeuCauBoSungHoSo(ActionRequest resourceRequest, ActionResponse httpReq) throws NumberFormatException, Exception {
		log.info("==Vao day==Method==yeuCauBoSungHoSo=====");
		
		long documentName = ParamUtil.getLong(resourceRequest, PageType.DOCUMENT_NAME);
		int messageType = ParamUtil.getInteger(resourceRequest, PageType.MESSAGE_TYPE);
		int documentYear = ParamUtil.getInteger(resourceRequest, PageType.DOCUMENT_YEAR);
		String pageType = ParamUtil.getString(resourceRequest, PageType.PAGE_TYPE);
		String tieuDe = ParamUtil.getString(resourceRequest, PageType.TIEU_DE_BAN_KHAI);
		int actionType = ParamUtil.getInteger(resourceRequest, PageType.ACTION_TYPE);
		String requestCode = ParamUtil.getString(resourceRequest, PageType.REQUEST_CODE);
		String menuSelected = ParamUtil.getString(resourceRequest, MenuConstraint.SESSION_MENU_SELECTED);
		
		String roleType = "";
		
		if (resourceRequest.getPortletSession().getAttribute(PageType.ROLE_TYPE, PortletSession.APPLICATION_SCOPE) != null) {
			roleType = resourceRequest.getPortletSession().getAttribute(PageType.ROLE_TYPE, PortletSession.APPLICATION_SCOPE).toString();
		}
		
		
		NhapCanhHaiQuan2GiaoThongBusiness business = new NhapCanhHaiQuan2GiaoThongBusiness();
		business.thuTucGuiBanTinYeuCauBoSungBanKhai(documentName, documentYear, messageType, actionType, resourceRequest);
		
		httpReq.setRenderParameter(PageType.DOCUMENT_NAME, String.valueOf(documentName));
		httpReq.setRenderParameter(PageType.MESSAGE_TYPE, String.valueOf(messageType));
		httpReq.setRenderParameter(PageType.DOCUMENT_YEAR, String.valueOf(documentYear));
		httpReq.setRenderParameter(PageType.PAGE_TYPE, pageType);
		
		if (requestCode != null && requestCode.length() > 0) {
			httpReq.setRenderParameter(PageType.REQUEST_CODE, requestCode);
		}
		
		httpReq.setRenderParameter(PageType.TIEU_DE_BAN_KHAI, tieuDe);
		if (menuSelected != null && menuSelected.trim().length() > 0) {
			httpReq.setRenderParameter(MenuConstraint.SESSION_MENU_SELECTED, menuSelected);
		}
		
		PortletConfig portletConfig = (PortletConfig) resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		SessionMessages.add(resourceRequest, portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	}
	
	
	
	public void thuTucNhapCanh(ActionRequest resourceRequest, ActionResponse httpReq) throws NumberFormatException, Exception {
		long documentName = ParamUtil.getLong(resourceRequest, PageType.DOCUMENT_NAME);
		int messageType = ParamUtil.getInteger(resourceRequest, PageType.MESSAGE_TYPE);
		int documentYear = ParamUtil.getInteger(resourceRequest, PageType.DOCUMENT_YEAR);
		String pageType = ParamUtil.getString(resourceRequest, PageType.PAGE_TYPE);
		String tieuDe = ParamUtil.getString(resourceRequest, PageType.TIEU_DE_BAN_KHAI);
		int actionType = ParamUtil.getInteger(resourceRequest, PageType.ACTION_TYPE);
		String requestCode = ParamUtil.getString(resourceRequest, PageType.REQUEST_CODE);
		String menuSelected = ParamUtil.getString(resourceRequest, MenuConstraint.SESSION_MENU_SELECTED);
		String userLogin = getUserName(resourceRequest, httpReq);
		
		String roleType = "";
		if (resourceRequest.getPortletSession().getAttribute(PageType.ROLE_TYPE, PortletSession.APPLICATION_SCOPE) != null) {
			roleType = resourceRequest.getPortletSession().getAttribute(PageType.ROLE_TYPE, PortletSession.APPLICATION_SCOPE).toString();
		}
		
		NhapCanhHaiQuan2GiaoThongBusiness giaoThongBusiness = new NhapCanhHaiQuan2GiaoThongBusiness();
		Boolean result = giaoThongBusiness.xuLyNhapCanhRoleThuTuc(userLogin, documentName, messageType, documentYear, actionType,
				getUserName(resourceRequest, httpReq), resourceRequest, httpReq);
		
		log.info("====call thuTucNhapCanh=====documentName==" + documentName);
		
		httpReq.setRenderParameter(PageType.DOCUMENT_NAME, String.valueOf(documentName));
		httpReq.setRenderParameter(PageType.MESSAGE_TYPE, String.valueOf(messageType));
		httpReq.setRenderParameter(PageType.DOCUMENT_YEAR, String.valueOf(documentYear));
		httpReq.setRenderParameter(PageType.PAGE_TYPE, pageType);
		httpReq.setRenderParameter(PageType.TIEU_DE_BAN_KHAI, tieuDe);
		if (requestCode != null && requestCode.length() > 0) {
			httpReq.setRenderParameter(PageType.REQUEST_CODE, requestCode);
		}
		if (menuSelected != null && menuSelected.trim().length() > 0) {
			httpReq.setRenderParameter(MenuConstraint.SESSION_MENU_SELECTED, menuSelected);
		}
		
		PortletConfig portletConfig = (PortletConfig) resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		SessionMessages.add(resourceRequest, portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	}
	
	
	//inland vao cang
	
	public void thuTucVaoCang(ActionRequest resourceRequest, ActionResponse httpReq) throws NumberFormatException, Exception {
		long documentName = ParamUtil.getLong(resourceRequest, PageType.DOCUMENT_NAME);
		int messageType = ParamUtil.getInteger(resourceRequest, PageType.MESSAGE_TYPE);
		int documentYear = ParamUtil.getInteger(resourceRequest, PageType.DOCUMENT_YEAR);
		String pageType = ParamUtil.getString(resourceRequest, PageType.PAGE_TYPE);
		String tieuDe = ParamUtil.getString(resourceRequest, PageType.TIEU_DE_BAN_KHAI);
		int actionType = ParamUtil.getInteger(resourceRequest, PageType.ACTION_TYPE);
		String requestCode = ParamUtil.getString(resourceRequest, PageType.REQUEST_CODE);
		String menuSelected = ParamUtil.getString(resourceRequest, MenuConstraint.SESSION_MENU_SELECTED);
		String userLogin = getUserName(resourceRequest, httpReq);
		
		String roleType = "";
		if (resourceRequest.getPortletSession().getAttribute(PageType.ROLE_TYPE, PortletSession.APPLICATION_SCOPE) != null) {
			roleType = resourceRequest.getPortletSession().getAttribute(PageType.ROLE_TYPE, PortletSession.APPLICATION_SCOPE).toString();
		}
		
		NhapCanhHaiQuan2GiaoThongBusiness giaoThongBusiness = new NhapCanhHaiQuan2GiaoThongBusiness();
		Boolean result = giaoThongBusiness.xuLyNhapCanhRoleThuTuc(userLogin, documentName, messageType, documentYear, actionType,
				getUserName(resourceRequest, httpReq), resourceRequest, httpReq);
		
		log.info("====call thuTucNhapCanh=====documentName==" + documentName);
		
		httpReq.setRenderParameter(PageType.DOCUMENT_NAME, String.valueOf(documentName));
		httpReq.setRenderParameter(PageType.MESSAGE_TYPE, String.valueOf(messageType));
		httpReq.setRenderParameter(PageType.DOCUMENT_YEAR, String.valueOf(documentYear));
		httpReq.setRenderParameter(PageType.PAGE_TYPE, pageType);
		httpReq.setRenderParameter(PageType.TIEU_DE_BAN_KHAI, tieuDe);
		if (requestCode != null && requestCode.length() > 0) {
			httpReq.setRenderParameter(PageType.REQUEST_CODE, requestCode);
		}
		if (menuSelected != null && menuSelected.trim().length() > 0) {
			httpReq.setRenderParameter(MenuConstraint.SESSION_MENU_SELECTED, menuSelected);
		}
		
		PortletConfig portletConfig = (PortletConfig) resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		SessionMessages.add(resourceRequest, portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	}
		
	public void thuTucRoiCang(ActionRequest resourceRequest, ActionResponse httpReq) throws NumberFormatException, Exception {
		
		
		log.info("VAO DAYYYYYYYYYYYYYYYYYY thuTucRoiCang");
		
		long documentName = ParamUtil.getLong(resourceRequest, PageType.DOCUMENT_NAME);
		int messageType = ParamUtil.getInteger(resourceRequest, PageType.MESSAGE_TYPE);
		int documentYear = ParamUtil.getInteger(resourceRequest, PageType.DOCUMENT_YEAR);
		
		String pageType = ParamUtil.getString(resourceRequest, PageType.PAGE_TYPE);
		String tieuDe = ParamUtil.getString(resourceRequest, PageType.TIEU_DE_BAN_KHAI);
		int actionType = ParamUtil.getInteger(resourceRequest, PageType.ACTION_TYPE);
		String requestCode = ParamUtil.getString(resourceRequest, PageType.REQUEST_CODE);
		String menuSelected = ParamUtil.getString(resourceRequest, MenuConstraint.SESSION_MENU_SELECTED);
		String userLogin = getUserName(resourceRequest, httpReq);
		String roleType = "";
		
		 /*if (requestCode == null || requestCode.trim().length() == 0) {
			 String requestCodePortClearance = ParamUtil.getString(resourceRequest, "requestCodePortClearance");
			 if (requestCodePortClearance != null && requestCodePortClearance.trim().length() > 0) {
				 requestCode = requestCodePortClearance;
			 } else {
				 String requestCodePerForTransit = ParamUtil.getString(resourceRequest, "requestCodePerForTransit");
				 if (requestCodePerForTransit != null && requestCodePerForTransit.trim().length() > 0) {
					 requestCode = requestCodePerForTransit;
				 }
			 }
		 }*/
		
		// Truong hop cap lai, do requestCode is new, nen phai lay lai requestCod moi
		String capPortClearance = ParamUtil.getString(resourceRequest, PageType.LAN_CAP_PORT_CLEARANCE);
		
		if (resourceRequest.getPortletSession().getAttribute(PageType.ROLE_TYPE, PortletSession.APPLICATION_SCOPE) != null) {
			roleType = resourceRequest.getPortletSession().getAttribute(PageType.ROLE_TYPE, PortletSession.APPLICATION_SCOPE).toString();
		}
		
		XuatCanhHaiQuan2GiaoThongBusiness giaoThongBusiness = new XuatCanhHaiQuan2GiaoThongBusiness();
		giaoThongBusiness.xuLyXuatCanhRoleThuTuc(userLogin, documentName, messageType, documentYear, actionType,
				getUserName(resourceRequest, httpReq), requestCode, resourceRequest, httpReq);
		
		if (capPortClearance.compareTo(KeyParams.N_LAN) == 0 || capPortClearance.compareTo(KeyParams.MOT_LAN) == 0) {
			
			IssuePortClearance portClearance = IssuePortClearanceLocalServiceUtil.findByDocumentYearAndDocumentYearOrderByColumn(documentName,
					documentYear, KeyParams.VERSION_NO, KeyParams.ORDER_BY_DESC).get(0);
			if (portClearance.getRequestCode() != null && portClearance.getRequestCode().trim().length() > 0) {
				requestCode = portClearance.getRequestCode();
			}
		}
		
		log.info("====call thuTucRoiCang=====documentName==" + documentName + "==documentYear==" + documentYear + "==messageType==" + messageType
				+ "==actionType==" + actionType + "==requestCode==" + requestCode);
		
		httpReq.setRenderParameter(PageType.DOCUMENT_NAME, String.valueOf(documentName));
		httpReq.setRenderParameter(PageType.MESSAGE_TYPE, String.valueOf(messageType));
		httpReq.setRenderParameter(PageType.DOCUMENT_YEAR, String.valueOf(documentYear));
		
		httpReq.setRenderParameter(PageType.PAGE_TYPE, pageType);
		httpReq.setRenderParameter(PageType.TIEU_DE_BAN_KHAI, tieuDe);
		httpReq.setRenderParameter(PageType.REQUEST_CODE, requestCode);
		if (menuSelected != null && menuSelected.trim().length() > 0) {
			httpReq.setRenderParameter(MenuConstraint.SESSION_MENU_SELECTED, menuSelected);
		}
		
		PortletConfig portletConfig = (PortletConfig) resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		SessionMessages.add(resourceRequest, portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	}
	
	
	/* chinh  29/12/2015*/
	
public void thuTucXuatCanhKyso(ActionRequest resourceRequest, ActionResponse httpReq) throws NumberFormatException, Exception {
		
		long documentName = ParamUtil.getLong(resourceRequest, PageType.DOCUMENT_NAME);
		int messageType = ParamUtil.getInteger(resourceRequest, PageType.MESSAGE_TYPE);
		int documentYear = ParamUtil.getInteger(resourceRequest, PageType.DOCUMENT_YEAR);
		
		String pageType = ParamUtil.getString(resourceRequest, PageType.PAGE_TYPE);
		String tieuDe = ParamUtil.getString(resourceRequest, PageType.TIEU_DE_BAN_KHAI);
		int actionType = ParamUtil.getInteger(resourceRequest, PageType.ACTION_TYPE);
		String requestCode = ParamUtil.getString(resourceRequest, PageType.REQUEST_CODE);
		String menuSelected = ParamUtil.getString(resourceRequest, MenuConstraint.SESSION_MENU_SELECTED);
		String userLogin = getUserName(resourceRequest, httpReq);
		String roleType = "";
		
		String capPortClearance = ParamUtil.getString(resourceRequest, PageType.LAN_CAP_PORT_CLEARANCE);
		
		if (resourceRequest.getPortletSession().getAttribute(PageType.ROLE_TYPE, PortletSession.APPLICATION_SCOPE) != null) {
			roleType = resourceRequest.getPortletSession().getAttribute(PageType.ROLE_TYPE, PortletSession.APPLICATION_SCOPE).toString();
		}
		
		XuatCanhHaiQuan2GiaoThongBusiness giaoThongBusiness = new XuatCanhHaiQuan2GiaoThongBusiness();
		giaoThongBusiness.xuLyXuatCanhRoleThuTuc(userLogin, documentName, messageType, documentYear, actionType,
				getUserName(resourceRequest, httpReq), requestCode, resourceRequest, httpReq);
		
		if (capPortClearance.compareTo(KeyParams.N_LAN) == 0 || capPortClearance.compareTo(KeyParams.MOT_LAN) == 0) {
			
			IssuePortClearance portClearance = IssuePortClearanceLocalServiceUtil.findByDocumentYearAndDocumentYearOrderByColumn(documentName,
					documentYear, KeyParams.VERSION_NO, KeyParams.ORDER_BY_DESC).get(0);
			if (portClearance.getRequestCode() != null && portClearance.getRequestCode().trim().length() > 0) {
				requestCode = portClearance.getRequestCode();
			}
		}
		
		log.info("====call thuTucXuatCanh=====documentName==" + documentName + "==documentYear==" + documentYear + "==messageType==" + messageType
				+ "==actionType==" + actionType + "==requestCode==" + requestCode);
		
		httpReq.setRenderParameter(PageType.DOCUMENT_NAME, String.valueOf(documentName));
		httpReq.setRenderParameter(PageType.MESSAGE_TYPE, String.valueOf(messageType));
		httpReq.setRenderParameter(PageType.DOCUMENT_YEAR, String.valueOf(documentYear));
		
		httpReq.setRenderParameter(PageType.PAGE_TYPE, pageType);
		httpReq.setRenderParameter(PageType.TIEU_DE_BAN_KHAI, tieuDe);
		httpReq.setRenderParameter(PageType.REQUEST_CODE, requestCode);
		if (menuSelected != null && menuSelected.trim().length() > 0) {
			httpReq.setRenderParameter(MenuConstraint.SESSION_MENU_SELECTED, menuSelected);
		}
		
		PortletConfig portletConfig = (PortletConfig) resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		SessionMessages.add(resourceRequest, portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	}
	
public void thuTucXuatCanhDongDau(ActionRequest resourceRequest, ActionResponse httpReq) throws NumberFormatException, Exception {
	
	long documentName = ParamUtil.getLong(resourceRequest, PageType.DOCUMENT_NAME);
	int messageType = ParamUtil.getInteger(resourceRequest, PageType.MESSAGE_TYPE);
	int documentYear = ParamUtil.getInteger(resourceRequest, PageType.DOCUMENT_YEAR);
	
	String pageType = ParamUtil.getString(resourceRequest, PageType.PAGE_TYPE);
	String tieuDe = ParamUtil.getString(resourceRequest, PageType.TIEU_DE_BAN_KHAI);
	int actionType = ParamUtil.getInteger(resourceRequest, PageType.ACTION_TYPE);
	String requestCode = ParamUtil.getString(resourceRequest, PageType.REQUEST_CODE);
	String menuSelected = ParamUtil.getString(resourceRequest, MenuConstraint.SESSION_MENU_SELECTED);
	String userLogin = getUserName(resourceRequest, httpReq);
	String roleType = "";
	
	String capPortClearance = ParamUtil.getString(resourceRequest, PageType.LAN_CAP_PORT_CLEARANCE);
	
	if (resourceRequest.getPortletSession().getAttribute(PageType.ROLE_TYPE, PortletSession.APPLICATION_SCOPE) != null) {
		roleType = resourceRequest.getPortletSession().getAttribute(PageType.ROLE_TYPE, PortletSession.APPLICATION_SCOPE).toString();
	}
	
	XuatCanhHaiQuan2GiaoThongBusiness giaoThongBusiness = new XuatCanhHaiQuan2GiaoThongBusiness();
	giaoThongBusiness.xuLyXuatCanhRoleThuTuc(userLogin, documentName, messageType, documentYear, actionType,
			getUserName(resourceRequest, httpReq), requestCode, resourceRequest, httpReq);
	
	if (capPortClearance.compareTo(KeyParams.N_LAN) == 0 || capPortClearance.compareTo(KeyParams.MOT_LAN) == 0) {
		
		IssuePortClearance portClearance = IssuePortClearanceLocalServiceUtil.findByDocumentYearAndDocumentYearOrderByColumn(documentName,
				documentYear, KeyParams.VERSION_NO, KeyParams.ORDER_BY_DESC).get(0);
		if (portClearance.getRequestCode() != null && portClearance.getRequestCode().trim().length() > 0) {
			requestCode = portClearance.getRequestCode();
		}
	}
	
	log.info("====call thuTucXuatCanh=====documentName==" + documentName + "==documentYear==" + documentYear + "==messageType==" + messageType
			+ "==actionType==" + actionType + "==requestCode==" + requestCode);
	
	httpReq.setRenderParameter(PageType.DOCUMENT_NAME, String.valueOf(documentName));
	httpReq.setRenderParameter(PageType.MESSAGE_TYPE, String.valueOf(messageType));
	httpReq.setRenderParameter(PageType.DOCUMENT_YEAR, String.valueOf(documentYear));
	
	httpReq.setRenderParameter(PageType.PAGE_TYPE, pageType);
	httpReq.setRenderParameter(PageType.TIEU_DE_BAN_KHAI, tieuDe);
	httpReq.setRenderParameter(PageType.REQUEST_CODE, requestCode);
	if (menuSelected != null && menuSelected.trim().length() > 0) {
		httpReq.setRenderParameter(MenuConstraint.SESSION_MENU_SELECTED, menuSelected);
	}
	
	PortletConfig portletConfig = (PortletConfig) resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
	SessionMessages.add(resourceRequest, portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
}
	
	
	//chinh 
	
	public void thuTucQuaCanhKyso(ActionRequest resourceRequest, ActionResponse httpReq) throws NumberFormatException, Exception {
		log.info("====chinh thuTucQuaCanh=====documentName==");
		long documentName = ParamUtil.getLong(resourceRequest, PageType.DOCUMENT_NAME);
		int messageType = ParamUtil.getInteger(resourceRequest, PageType.MESSAGE_TYPE);
		int documentYear = ParamUtil.getInteger(resourceRequest, PageType.DOCUMENT_YEAR);
		
		String pageType = ParamUtil.getString(resourceRequest, PageType.PAGE_TYPE);
		String tieuDe = ParamUtil.getString(resourceRequest, PageType.TIEU_DE_BAN_KHAI);
		int actionType = ParamUtil.getInteger(resourceRequest, PageType.ACTION_TYPE);
		String requestCode = ParamUtil.getString(resourceRequest, PageType.REQUEST_CODE);
		String menuSelected = ParamUtil.getString(resourceRequest, MenuConstraint.SESSION_MENU_SELECTED);
		String userLogin = getUserName(resourceRequest, httpReq);
		String roleType = "";
		
		// Truong hop cap lai, do requestCode is new, nen phai lay lai requestCod moi
		String capPerForTransit = ParamUtil.getString(resourceRequest, PageType.LAN_CAP_PERMISSION_FOR_TRANSIT);
		
		if (resourceRequest.getPortletSession().getAttribute(PageType.ROLE_TYPE, PortletSession.APPLICATION_SCOPE) != null) {
			roleType = resourceRequest.getPortletSession().getAttribute(PageType.ROLE_TYPE, PortletSession.APPLICATION_SCOPE).toString();
		}
		
		QuaCanhHaiQuan2GiaoThongBusiness giaoThongBusiness = new QuaCanhHaiQuan2GiaoThongBusiness();
		giaoThongBusiness.xuLyQuaCanhRoleThuTuc(userLogin, documentName, messageType, documentYear, actionType,
				getUserName(resourceRequest, httpReq), resourceRequest, httpReq);
		
		if (capPerForTransit.compareTo(KeyParams.N_LAN) == 0 || capPerForTransit.compareTo(KeyParams.MOT_LAN) == 0) {
			IssuePermissionForTransit perForTransit = IssuePermissionForTransitLocalServiceUtil.findByDocumentYearAndDocumentYearOrderByColumn(
					documentName, documentYear, KeyParams.VERSION_NO, KeyParams.ORDER_BY_DESC).get(0);
			requestCode = perForTransit.getRequestCode();
		}
		
		log.info("====call thuTucQuaCanh=====documentName==" + documentName + "===requestCode===" + requestCode);
		
		httpReq.setRenderParameter(PageType.DOCUMENT_NAME, String.valueOf(documentName));
		httpReq.setRenderParameter(PageType.MESSAGE_TYPE, String.valueOf(messageType));
		httpReq.setRenderParameter(PageType.DOCUMENT_YEAR, String.valueOf(documentYear));
		
		httpReq.setRenderParameter(PageType.PAGE_TYPE, pageType);
		httpReq.setRenderParameter(PageType.TIEU_DE_BAN_KHAI, tieuDe);
		httpReq.setRenderParameter(PageType.REQUEST_CODE, requestCode);
		
		if (menuSelected != null && menuSelected.trim().length() > 0) {
			httpReq.setRenderParameter(MenuConstraint.SESSION_MENU_SELECTED, menuSelected);
		}
		
		PortletConfig portletConfig = (PortletConfig) resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		SessionMessages.add(resourceRequest, portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	}
	


	public void thuTucQuaCanhDongDau(ActionRequest resourceRequest, ActionResponse httpReq) throws NumberFormatException, Exception {
		log.info("====chinh thuTucQuaCanh=====documentName==");
		long documentName = ParamUtil.getLong(resourceRequest, PageType.DOCUMENT_NAME);
		int messageType = ParamUtil.getInteger(resourceRequest, PageType.MESSAGE_TYPE);
		int documentYear = ParamUtil.getInteger(resourceRequest, PageType.DOCUMENT_YEAR);
		
		String pageType = ParamUtil.getString(resourceRequest, PageType.PAGE_TYPE);
		String tieuDe = ParamUtil.getString(resourceRequest, PageType.TIEU_DE_BAN_KHAI);
		int actionType = ParamUtil.getInteger(resourceRequest, PageType.ACTION_TYPE);
		String requestCode = ParamUtil.getString(resourceRequest, PageType.REQUEST_CODE);
		String menuSelected = ParamUtil.getString(resourceRequest, MenuConstraint.SESSION_MENU_SELECTED);
		String userLogin = getUserName(resourceRequest, httpReq);
		String roleType = "";
		
		// Truong hop cap lai, do requestCode is new, nen phai lay lai requestCod moi
		String capPerForTransit = ParamUtil.getString(resourceRequest, PageType.LAN_CAP_PERMISSION_FOR_TRANSIT);
		
		if (resourceRequest.getPortletSession().getAttribute(PageType.ROLE_TYPE, PortletSession.APPLICATION_SCOPE) != null) {
			roleType = resourceRequest.getPortletSession().getAttribute(PageType.ROLE_TYPE, PortletSession.APPLICATION_SCOPE).toString();
		}
		
		QuaCanhHaiQuan2GiaoThongBusiness giaoThongBusiness = new QuaCanhHaiQuan2GiaoThongBusiness();
		giaoThongBusiness.xuLyQuaCanhRoleThuTuc(userLogin, documentName, messageType, documentYear, actionType,
				getUserName(resourceRequest, httpReq), resourceRequest, httpReq);
		
		if (capPerForTransit.compareTo(KeyParams.N_LAN) == 0 || capPerForTransit.compareTo(KeyParams.MOT_LAN) == 0) {
			IssuePermissionForTransit perForTransit = IssuePermissionForTransitLocalServiceUtil.findByDocumentYearAndDocumentYearOrderByColumn(
					documentName, documentYear, KeyParams.VERSION_NO, KeyParams.ORDER_BY_DESC).get(0);
			requestCode = perForTransit.getRequestCode();
		}
		
		log.info("====call thuTucQuaCanh=====documentName==" + documentName + "===requestCode===" + requestCode);
		
		httpReq.setRenderParameter(PageType.DOCUMENT_NAME, String.valueOf(documentName));
		httpReq.setRenderParameter(PageType.MESSAGE_TYPE, String.valueOf(messageType));
		httpReq.setRenderParameter(PageType.DOCUMENT_YEAR, String.valueOf(documentYear));
		
		httpReq.setRenderParameter(PageType.PAGE_TYPE, pageType);
		httpReq.setRenderParameter(PageType.TIEU_DE_BAN_KHAI, tieuDe);
		httpReq.setRenderParameter(PageType.REQUEST_CODE, requestCode);
		
		if (menuSelected != null && menuSelected.trim().length() > 0) {
			httpReq.setRenderParameter(MenuConstraint.SESSION_MENU_SELECTED, menuSelected);
		}
		
		PortletConfig portletConfig = (PortletConfig) resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		SessionMessages.add(resourceRequest, portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	}
	
	
	public void thuTucXuatCanh(ActionRequest resourceRequest, ActionResponse httpReq) throws NumberFormatException, Exception {
		
		long documentName = ParamUtil.getLong(resourceRequest, PageType.DOCUMENT_NAME);
		int messageType = ParamUtil.getInteger(resourceRequest, PageType.MESSAGE_TYPE);
		int documentYear = ParamUtil.getInteger(resourceRequest, PageType.DOCUMENT_YEAR);
		
		String pageType = ParamUtil.getString(resourceRequest, PageType.PAGE_TYPE);
		String tieuDe = ParamUtil.getString(resourceRequest, PageType.TIEU_DE_BAN_KHAI);
		int actionType = ParamUtil.getInteger(resourceRequest, PageType.ACTION_TYPE);
		String requestCode = ParamUtil.getString(resourceRequest, PageType.REQUEST_CODE);
		String menuSelected = ParamUtil.getString(resourceRequest, MenuConstraint.SESSION_MENU_SELECTED);
		String userLogin = getUserName(resourceRequest, httpReq);
		String roleType = "";
		
		// if (requestCode == null || requestCode.trim().length() == 0) {
		// String requestCodePortClearance = ParamUtil.getString(resourceRequest, "requestCodePortClearance");
		// if (requestCodePortClearance != null && requestCodePortClearance.trim().length() > 0) {
		// requestCode = requestCodePortClearance;
		// } else {
		// String requestCodePerForTransit = ParamUtil.getString(resourceRequest, "requestCodePerForTransit");
		// if (requestCodePerForTransit != null && requestCodePerForTransit.trim().length() > 0) {
		// requestCode = requestCodePerForTransit;
		// }
		// }
		// }
		
		// Truong hop cap lai, do requestCode is new, nen phai lay lai requestCod moi
		String capPortClearance = ParamUtil.getString(resourceRequest, PageType.LAN_CAP_PORT_CLEARANCE);
		
		if (resourceRequest.getPortletSession().getAttribute(PageType.ROLE_TYPE, PortletSession.APPLICATION_SCOPE) != null) {
			roleType = resourceRequest.getPortletSession().getAttribute(PageType.ROLE_TYPE, PortletSession.APPLICATION_SCOPE).toString();
		}
		
		XuatCanhHaiQuan2GiaoThongBusiness giaoThongBusiness = new XuatCanhHaiQuan2GiaoThongBusiness();
		giaoThongBusiness.xuLyXuatCanhRoleThuTuc(userLogin, documentName, messageType, documentYear, actionType,
				getUserName(resourceRequest, httpReq), requestCode, resourceRequest, httpReq);
		
		if (capPortClearance.compareTo(KeyParams.N_LAN) == 0 || capPortClearance.compareTo(KeyParams.MOT_LAN) == 0) {
			
			IssuePortClearance portClearance = IssuePortClearanceLocalServiceUtil.findByDocumentYearAndDocumentYearOrderByColumn(documentName,
					documentYear, KeyParams.VERSION_NO, KeyParams.ORDER_BY_DESC).get(0);
			if (portClearance.getRequestCode() != null && portClearance.getRequestCode().trim().length() > 0) {
				requestCode = portClearance.getRequestCode();
			}
		}
		
		log.info("====call thuTucXuatCanh=====documentName==" + documentName + "==documentYear==" + documentYear + "==messageType==" + messageType
				+ "==actionType==" + actionType + "==requestCode==" + requestCode);
		
		httpReq.setRenderParameter(PageType.DOCUMENT_NAME, String.valueOf(documentName));
		httpReq.setRenderParameter(PageType.MESSAGE_TYPE, String.valueOf(messageType));
		httpReq.setRenderParameter(PageType.DOCUMENT_YEAR, String.valueOf(documentYear));
		
		httpReq.setRenderParameter(PageType.PAGE_TYPE, pageType);
		httpReq.setRenderParameter(PageType.TIEU_DE_BAN_KHAI, tieuDe);
		httpReq.setRenderParameter(PageType.REQUEST_CODE, requestCode);
		if (menuSelected != null && menuSelected.trim().length() > 0) {
			httpReq.setRenderParameter(MenuConstraint.SESSION_MENU_SELECTED, menuSelected);
		}
		
		PortletConfig portletConfig = (PortletConfig) resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		SessionMessages.add(resourceRequest, portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	}
	
	public void thuTucQuaCanh(ActionRequest resourceRequest, ActionResponse httpReq) throws NumberFormatException, Exception {
		
		long documentName = ParamUtil.getLong(resourceRequest, PageType.DOCUMENT_NAME);
		int messageType = ParamUtil.getInteger(resourceRequest, PageType.MESSAGE_TYPE);
		int documentYear = ParamUtil.getInteger(resourceRequest, PageType.DOCUMENT_YEAR);
		
		String pageType = ParamUtil.getString(resourceRequest, PageType.PAGE_TYPE);
		String tieuDe = ParamUtil.getString(resourceRequest, PageType.TIEU_DE_BAN_KHAI);
		int actionType = ParamUtil.getInteger(resourceRequest, PageType.ACTION_TYPE);
		String requestCode = ParamUtil.getString(resourceRequest, PageType.REQUEST_CODE);
		String menuSelected = ParamUtil.getString(resourceRequest, MenuConstraint.SESSION_MENU_SELECTED);
		String userLogin = getUserName(resourceRequest, httpReq);
		String roleType = "";
		
		// Truong hop cap lai, do requestCode is new, nen phai lay lai requestCod moi
		String capPerForTransit = ParamUtil.getString(resourceRequest, PageType.LAN_CAP_PERMISSION_FOR_TRANSIT);
		
		if (resourceRequest.getPortletSession().getAttribute(PageType.ROLE_TYPE, PortletSession.APPLICATION_SCOPE) != null) {
			roleType = resourceRequest.getPortletSession().getAttribute(PageType.ROLE_TYPE, PortletSession.APPLICATION_SCOPE).toString();
		}
		
		QuaCanhHaiQuan2GiaoThongBusiness giaoThongBusiness = new QuaCanhHaiQuan2GiaoThongBusiness();
		giaoThongBusiness.xuLyQuaCanhRoleThuTuc(userLogin, documentName, messageType, documentYear, actionType,
				getUserName(resourceRequest, httpReq), resourceRequest, httpReq);
		
		if (capPerForTransit.compareTo(KeyParams.N_LAN) == 0 || capPerForTransit.compareTo(KeyParams.MOT_LAN) == 0) {
			IssuePermissionForTransit perForTransit = IssuePermissionForTransitLocalServiceUtil.findByDocumentYearAndDocumentYearOrderByColumn(
					documentName, documentYear, KeyParams.VERSION_NO, KeyParams.ORDER_BY_DESC).get(0);
			requestCode = perForTransit.getRequestCode();
		}
		
		log.info("====call thuTucQuaCanh=====documentName==" + documentName + "===requestCode===" + requestCode);
		
		httpReq.setRenderParameter(PageType.DOCUMENT_NAME, String.valueOf(documentName));
		httpReq.setRenderParameter(PageType.MESSAGE_TYPE, String.valueOf(messageType));
		httpReq.setRenderParameter(PageType.DOCUMENT_YEAR, String.valueOf(documentYear));
		
		httpReq.setRenderParameter(PageType.PAGE_TYPE, pageType);
		httpReq.setRenderParameter(PageType.TIEU_DE_BAN_KHAI, tieuDe);
		httpReq.setRenderParameter(PageType.REQUEST_CODE, requestCode);
		
		if (menuSelected != null && menuSelected.trim().length() > 0) {
			httpReq.setRenderParameter(MenuConstraint.SESSION_MENU_SELECTED, menuSelected);
		}
		
		PortletConfig portletConfig = (PortletConfig) resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		SessionMessages.add(resourceRequest, portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	}
	
	public void chuyenGiaoDienRoiCang(ActionRequest resourceRequest, ActionResponse httpReq) throws SystemException {
		log.info("==chuyenGiaoDienRoiCang==");
		
		long documentName = ParamUtil.getLong(resourceRequest, PageType.DOCUMENT_NAME);
		int messageType = ParamUtil.getInteger(resourceRequest, PageType.MESSAGE_TYPE);
		int documentYear = ParamUtil.getInteger(resourceRequest, PageType.DOCUMENT_YEAR);
		
		String pageType = ParamUtil.getString(resourceRequest, PageType.PAGE_TYPE);
		String tieuDe = ParamUtil.getString(resourceRequest, PageType.TIEU_DE_BAN_KHAI);
		
		int actionType = ParamUtil.getInteger(resourceRequest, PageType.ACTION_TYPE);
		
		String requestCode = ParamUtil.getString(resourceRequest, PageType.REQUEST_CODE);
		String menuSelected = ParamUtil.getString(resourceRequest, MenuConstraint.SESSION_MENU_SELECTED);
		
		// ////1 lan
		String capNhapPortClearance = ParamUtil.getString(resourceRequest, PageType.CHUYEN_GIAO_DIEN_CAP_NHAP_PORT_CLEARANCE);
		
		// /// n lan
		String capNhapPortClearanceLanThuN = ParamUtil.getString(resourceRequest, PageType.CHUYEN_GIAO_DIEN_CAP_NHAP_PORT_CLEARANCE_LAN_THU_N);
		String lanCapPortClearance = ParamUtil.getString(resourceRequest, PageType.LAN_CAP_PORT_CLEARANCE);
		String lanSuaPortClearance = ParamUtil.getString(resourceRequest, PageType.LAN_SUA_PORT_CLEARANCE);
		
		String roleType = "";
		
		if (resourceRequest.getPortletSession().getAttribute(PageType.ROLE_TYPE, PortletSession.APPLICATION_SCOPE) != null) {
			roleType = resourceRequest.getPortletSession().getAttribute(PageType.ROLE_TYPE, PortletSession.APPLICATION_SCOPE).toString();
		}
		String lyDoCapLaiRC = ParamUtil.getString(resourceRequest, PageType.HUY_HO_SO);
		if (lyDoCapLaiRC == null || lyDoCapLaiRC.length() == 0) {
			lyDoCapLaiRC = "lyDoCapLaiRC";
		}
		String userLogin = getUserName(resourceRequest, httpReq);
		log.info("=========cap lai xuat canh lyDoCapLaiRC========" + lyDoCapLaiRC);
		
		TempDocument tempDocument = TempDocumentLocalServiceUtil.findTemDocumentByDocumentNameDocumentYear(documentName, documentYear);
		BusinessUtils.updateLyDoResultNotification(userLogin, lyDoCapLaiRC, MessageType.Y_CAU_CAP_LAI_GIAY_PHEP_ROI_CANG,
				tempDocument.getMaritimeCode(), documentName, documentYear);
		
		httpReq.setRenderParameter(PageType.DOCUMENT_NAME, String.valueOf(documentName));
		httpReq.setRenderParameter(PageType.MESSAGE_TYPE, String.valueOf(messageType));
		httpReq.setRenderParameter(PageType.DOCUMENT_YEAR, String.valueOf(documentYear));
		httpReq.setRenderParameter(PageType.PAGE_TYPE, pageType);
		httpReq.setRenderParameter(PageType.TIEU_DE_BAN_KHAI, tieuDe);
		httpReq.setRenderParameter(PageType.ACTION_TYPE, actionType + "");
		httpReq.setRenderParameter(PageType.REQUEST_CODE, requestCode);
		
		httpReq.setRenderParameter(PageType.HUY_HO_SO, lyDoCapLaiRC);
		
		// /////1 lan
		httpReq.setRenderParameter(PageType.CHUYEN_GIAO_DIEN_CAP_NHAP_PORT_CLEARANCE, capNhapPortClearance);
		
		// ///// n lan
		httpReq.setRenderParameter(PageType.CHUYEN_GIAO_DIEN_CAP_NHAP_PORT_CLEARANCE_LAN_THU_N, capNhapPortClearanceLanThuN);
		
		httpReq.setRenderParameter(PageType.LAN_CAP_PORT_CLEARANCE, lanCapPortClearance);
		httpReq.setRenderParameter(PageType.LAN_SUA_PORT_CLEARANCE, lanSuaPortClearance);
		if (menuSelected != null && menuSelected.trim().length() > 0) {
			httpReq.setRenderParameter(MenuConstraint.SESSION_MENU_SELECTED, menuSelected);
		}
		
		PortletConfig portletConfig = (PortletConfig) resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		SessionMessages.add(resourceRequest, portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	}
	
	public void chuyenGiaoDienXuatCanh(ActionRequest resourceRequest, ActionResponse httpReq) throws SystemException {
		log.info("==chuyenGiaoDienXuatCanh==");
		
		long documentName = ParamUtil.getLong(resourceRequest, PageType.DOCUMENT_NAME);
		int messageType = ParamUtil.getInteger(resourceRequest, PageType.MESSAGE_TYPE);
		int documentYear = ParamUtil.getInteger(resourceRequest, PageType.DOCUMENT_YEAR);
		
		String pageType = ParamUtil.getString(resourceRequest, PageType.PAGE_TYPE);
		String tieuDe = ParamUtil.getString(resourceRequest, PageType.TIEU_DE_BAN_KHAI);
		
		int actionType = ParamUtil.getInteger(resourceRequest, PageType.ACTION_TYPE);
		
		String requestCode = ParamUtil.getString(resourceRequest, PageType.REQUEST_CODE);
		String menuSelected = ParamUtil.getString(resourceRequest, MenuConstraint.SESSION_MENU_SELECTED);
		
		// ////1 lan
		String capNhapPortClearance = ParamUtil.getString(resourceRequest, PageType.CHUYEN_GIAO_DIEN_CAP_NHAP_PORT_CLEARANCE);
		
		// /// n lan
		String capNhapPortClearanceLanThuN = ParamUtil.getString(resourceRequest, PageType.CHUYEN_GIAO_DIEN_CAP_NHAP_PORT_CLEARANCE_LAN_THU_N);
		String lanCapPortClearance = ParamUtil.getString(resourceRequest, PageType.LAN_CAP_PORT_CLEARANCE);
		String lanSuaPortClearance = ParamUtil.getString(resourceRequest, PageType.LAN_SUA_PORT_CLEARANCE);
		
		String roleType = "";
		
		if (resourceRequest.getPortletSession().getAttribute(PageType.ROLE_TYPE, PortletSession.APPLICATION_SCOPE) != null) {
			roleType = resourceRequest.getPortletSession().getAttribute(PageType.ROLE_TYPE, PortletSession.APPLICATION_SCOPE).toString();
		}
		String lyDoCapLaiXC = ParamUtil.getString(resourceRequest, PageType.HUY_HO_SO);
		if (lyDoCapLaiXC == null || lyDoCapLaiXC.length() == 0) {
			lyDoCapLaiXC = "lyDoCapLaiXC";
		}
		String userLogin = getUserName(resourceRequest, httpReq);
		log.info("=========cap lai xuat canh lyDoCapLaiXC========" + lyDoCapLaiXC);
		
		TempDocument tempDocument = TempDocumentLocalServiceUtil.findTemDocumentByDocumentNameDocumentYear(documentName, documentYear);
		BusinessUtils.updateLyDoResultNotification(userLogin, lyDoCapLaiXC, MessageType.Y_CAU_CAP_LAI_GIAY_PHEP_ROI_CANG,
				tempDocument.getMaritimeCode(), documentName, documentYear);
		
		httpReq.setRenderParameter(PageType.DOCUMENT_NAME, String.valueOf(documentName));
		httpReq.setRenderParameter(PageType.MESSAGE_TYPE, String.valueOf(messageType));
		httpReq.setRenderParameter(PageType.DOCUMENT_YEAR, String.valueOf(documentYear));
		httpReq.setRenderParameter(PageType.PAGE_TYPE, pageType);
		httpReq.setRenderParameter(PageType.TIEU_DE_BAN_KHAI, tieuDe);
		httpReq.setRenderParameter(PageType.ACTION_TYPE, actionType + "");
		httpReq.setRenderParameter(PageType.REQUEST_CODE, requestCode);
		
		httpReq.setRenderParameter(PageType.HUY_HO_SO, lyDoCapLaiXC);
		
		// /////1 lan
		httpReq.setRenderParameter(PageType.CHUYEN_GIAO_DIEN_CAP_NHAP_PORT_CLEARANCE, capNhapPortClearance);
		
		// ///// n lan
		httpReq.setRenderParameter(PageType.CHUYEN_GIAO_DIEN_CAP_NHAP_PORT_CLEARANCE_LAN_THU_N, capNhapPortClearanceLanThuN);
		
		httpReq.setRenderParameter(PageType.LAN_CAP_PORT_CLEARANCE, lanCapPortClearance);
		httpReq.setRenderParameter(PageType.LAN_SUA_PORT_CLEARANCE, lanSuaPortClearance);
		if (menuSelected != null && menuSelected.trim().length() > 0) {
			httpReq.setRenderParameter(MenuConstraint.SESSION_MENU_SELECTED, menuSelected);
		}
		
		PortletConfig portletConfig = (PortletConfig) resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		SessionMessages.add(resourceRequest, portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	}
	
	public void chuyenGiaoDienQuaCanh(ActionRequest request, ActionResponse httpReq) {
		log.info("==chuyenGiaoDienQuaCanh==");
		
		long documentName = ParamUtil.getLong(request, PageType.DOCUMENT_NAME);
		int messageType = ParamUtil.getInteger(request, PageType.MESSAGE_TYPE);
		int documentYear = ParamUtil.getInteger(request, PageType.DOCUMENT_YEAR);
		
		String menuSelected = ParamUtil.getString(request, MenuConstraint.SESSION_MENU_SELECTED);
		String pageType = ParamUtil.getString(request, PageType.PAGE_TYPE);
		String tieuDe = ParamUtil.getString(request, PageType.TIEU_DE_BAN_KHAI);
		
		int actionType = ParamUtil.getInteger(request, PageType.ACTION_TYPE);
		
		String requestCode = ParamUtil.getString(request, PageType.REQUEST_CODE);
		
		String lyDoCapLai = ParamUtil.getString(request, "HuyHoSo");
		log.info("=========cap lai qua canh lyDoCapLaiQC============" + lyDoCapLai);
		
		// /////////1 lan
		String capNhapPerForTransit = ParamUtil.getString(request, PageType.CHUYEN_GIAO_DIEN_CAP_NHAP_PERMISSION_FOR_TRANSIT);
		
		// ////////n lan
		String capNhapPerForTransitLanThuN = ParamUtil.getString(request, PageType.CHUYEN_GIAO_DIEN_CAP_NHAP_PERMISSION_FOR_TRANSIT_LAN_THU_N);
		String lanCapPerForTransit = ParamUtil.getString(request, PageType.LAN_CAP_PERMISSION_FOR_TRANSIT);
		String lanSuaPerForTransit = ParamUtil.getString(request, PageType.LAN_SUA_PERMISSION_FOR_TRANSIT);
		
		String roleType = "";
		
		if (request.getPortletSession().getAttribute(PageType.ROLE_TYPE, PortletSession.APPLICATION_SCOPE) != null) {
			roleType = request.getPortletSession().getAttribute(PageType.ROLE_TYPE, PortletSession.APPLICATION_SCOPE).toString();
		}
		
		//String lyDoCapLaiQC = ParamUtil.getString(request, PageType.LY_DO_CAP_LAI);
		//if (lyDoCapLaiQC == null || lyDoCapLaiQC.length() == 0) {
			// lyDoCapLaiQC = ParamUtil.getString(resourceRequest, PageType.HUY_HO_SO);
			// if (lyDoCapLaiQC == null || lyDoCapLaiQC.length() == 0) {
			// lyDoCapLaiQC = ParamUtil.getString(resourceRequest, PageType.LY_DO_TU_CHOI);
			// }else if (lyDoCapLaiQC == null || lyDoCapLaiQC.length() == 0) {
			// lyDoCapLaiQC = ParamUtil.getString(resourceRequest, PageType.LY_DO_YEU_CAU_BO_SUNG);
			// }
			
		//	lyDoCapLaiQC = ParamUtil.getString(request, PageType.LY_DO_TU_CHOI);
		//}
		String userLogin = getUserName(request, httpReq);
		
		TempDocument tempDocument = TempDocumentLocalServiceUtil.findTemDocumentByDocumentNameDocumentYear(documentName, documentYear);
		BusinessUtils.updateLyDoResultNotification(userLogin, lyDoCapLai, MessageType.Y_CAU_CAP_LAI_GIAY_PHEP_QUA_CANH,
				tempDocument.getMaritimeCode(), documentName, documentYear);
		
		httpReq.setRenderParameter(PageType.DOCUMENT_NAME, String.valueOf(documentName));
		httpReq.setRenderParameter(PageType.DOCUMENT_YEAR, String.valueOf(documentYear));
		httpReq.setRenderParameter(PageType.MESSAGE_TYPE, String.valueOf(messageType));
		httpReq.setRenderParameter("lyDoCapLaiPermissionForTransit", lyDoCapLai);
		
		
		httpReq.setRenderParameter(PageType.PAGE_TYPE, pageType);
		httpReq.setRenderParameter(PageType.TIEU_DE_BAN_KHAI, tieuDe);
		httpReq.setRenderParameter(PageType.ACTION_TYPE, actionType + "");
		httpReq.setRenderParameter(PageType.REQUEST_CODE, requestCode);
		
		// ///////1 lan
		httpReq.setRenderParameter(PageType.CHUYEN_GIAO_DIEN_CAP_NHAP_PERMISSION_FOR_TRANSIT, capNhapPerForTransit);
		
		// //////n lan
		httpReq.setRenderParameter(PageType.CHUYEN_GIAO_DIEN_CAP_NHAP_PERMISSION_FOR_TRANSIT_LAN_THU_N, capNhapPerForTransitLanThuN);
		
		httpReq.setRenderParameter(PageType.LAN_CAP_PERMISSION_FOR_TRANSIT, lanCapPerForTransit);
		httpReq.setRenderParameter(PageType.LAN_SUA_PERMISSION_FOR_TRANSIT, lanSuaPerForTransit);
		if (menuSelected != null && menuSelected.trim().length() > 0) {
			httpReq.setRenderParameter(MenuConstraint.SESSION_MENU_SELECTED, menuSelected);
		}
		
		PortletConfig portletConfig = (PortletConfig) request.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		SessionMessages.add(request, portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	}
	
	public void searchThuTuc(ActionRequest request, ActionResponse httpReq) {
		
		String maritimeCode = ParamUtil.getString(request, "maritimeCode").trim();
		String portCode = ParamUtil.getString(request, "portCode").trim();
		String lastPortCode = ParamUtil.getString(request, "lastPortCode").trim();
		
		String shipName = ParamUtil.getString(request, "shipName").trim();
		String stateCode = ParamUtil.getString(request, "stateCode").trim();
		String callSign = ParamUtil.getString(request, "callSign").trim();
		String imo = ParamUtil.getString(request, "imo").trim();
		
		String shipPosition = ParamUtil.getString(request, "shipPosition").trim();
		
		String shipDateFromStart = ParamUtil.getString(request, "shipDateFromStart").trim();
		String shipDateFromEnd = ParamUtil.getString(request, "shipDateFromEnd").trim();
		
		String shipDateToStart = ParamUtil.getString(request, "shipDateToStart").trim();
		String shipDateToEnd = ParamUtil.getString(request, "shipDateToEnd").trim();
		
		String ngayLamThuTucFrom = ParamUtil.getString(request, "ngayLamThuTucFrom").trim();
		String ngayLamThuTucTo = ParamUtil.getString(request, "ngayLamThuTucTo").trim();
		
		String maBanKhai = ParamUtil.getString(request, "maBanKhai");
		
		String documentStatusCode = ParamUtil.getString(request, "documentStatusCode").trim();
		
		String arrivalShipAgency = ParamUtil.getString(request, "arrivalShipAgency").trim();
		String departureShipAgency = ParamUtil.getString(request, "departureShipAgency").trim();
		
		String portRegionCode = ParamUtil.getString(request, "portRegionCode").trim();
		
		// _log.info("====searchThuTuc-maritimeCode=====maritimeCode==" + maritimeCode);
		
		httpReq.setRenderParameter("maritimeCode", maritimeCode);
		httpReq.setRenderParameter("portCode", portCode);
		httpReq.setRenderParameter("lastPortCode", lastPortCode);
		
		httpReq.setRenderParameter("shipName", shipName);
		httpReq.setRenderParameter("stateCode", stateCode);
		httpReq.setRenderParameter("callSign", callSign);
		httpReq.setRenderParameter("imo", imo);
		
		httpReq.setRenderParameter("shipPosition", shipPosition);
		
		httpReq.setRenderParameter("shipDateFromStart", shipDateFromStart);
		httpReq.setRenderParameter("shipDateFromEnd", shipDateFromEnd);
		
		httpReq.setRenderParameter("shipDateToStart", shipDateToStart);
		httpReq.setRenderParameter("shipDateToEnd", shipDateToEnd);
		
		httpReq.setRenderParameter("ngayLamThuTucFrom", ngayLamThuTucFrom);
		httpReq.setRenderParameter("ngayLamThuTucTo", ngayLamThuTucTo);
		httpReq.setRenderParameter("maBanKhai", maBanKhai);
		
		httpReq.setRenderParameter("documentStatusCode", documentStatusCode);
		
		httpReq.setRenderParameter("nameArrivalShipAgency", ParamUtil.getString(request, "nameArrivalShipAgency").trim());
		httpReq.setRenderParameter("arrivalShipAgency", arrivalShipAgency);
		
		httpReq.setRenderParameter("nameDepartureShipAgency", ParamUtil.getString(request, "nameDepartureShipAgency").trim());
		httpReq.setRenderParameter("departureShipAgency", departureShipAgency);
		
		httpReq.setRenderParameter("portRegionCode", portRegionCode);
		
		String menuSelect = ParamUtil.getString(request, MenuConstraint.SESSION_MENU_SELECTED);
		httpReq.setRenderParameter(MenuConstraint.SESSION_MENU_SELECTED, menuSelect);
		
		PortletConfig portletConfig = (PortletConfig) request.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		SessionMessages.add(request, portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	}
	
	/*
	 * Action tranfer
	 */
	
	public void findPortRegionAndPortBymaritimeCode(ActionRequest resourceRequest, ActionResponse httpReq) throws IOException {
		
		String maritimeCode = ParamUtil.getString(resourceRequest, "maritimeCode");
		// Process Jason feed
		JSONObject jsonFeed = JSONFactoryUtil.createJSONObject();
		JSONArray _name = JSONFactoryUtil.getJSONFactory().createJSONArray();
		JSONArray _id = JSONFactoryUtil.getJSONFactory().createJSONArray();
		
		//
		List<DmPortRegion> dsPortRegion = DmPortRegionLocalServiceUtil.findPortRegionByPortRegionRef(maritimeCode);
		if (dsPortRegion == null) {
			dsPortRegion = new ArrayList<DmPortRegion>();
		}
		
		for (DmPortRegion item : dsPortRegion) {
			_id.put(item.getPortRegionCode());
			_name.put(item.getPortRegionName());
		}
		
		jsonFeed.put("idPortRegion", _id);
		jsonFeed.put("namePortRegion", _name);
		
		_id = JSONFactoryUtil.getJSONFactory().createJSONArray();
		_name = JSONFactoryUtil.getJSONFactory().createJSONArray();
		
		// _id.put("----");
		// _name.put(luaChon_label);
		
		List<DmPort> dsPorts = DmPortLocalServiceUtil.findByLoCode(maritimeCode);
		if (dsPorts == null) {
			dsPorts = new ArrayList<DmPort>();
		}
		
		for (DmPort item : dsPorts) {
			_id.put(item.getPortCode());
			_name.put(item.getPortName());
		}
		
		jsonFeed.put("idPort", _id);
		jsonFeed.put("namePort", _name);
		
		HttpServletResponse resourceResponse = PortalUtil.getHttpServletResponse(httpReq);
		
		// resourceRequest.setAttribute("portRegionRef", portRegionRef);
		
		resourceResponse.setContentType("application/json");
		resourceResponse.setCharacterEncoding("UTF-8");
		resourceResponse.getWriter().write(jsonFeed.toString());
		resourceResponse.getWriter().close();
	}
	
	public void menuThuTuc(ActionRequest resourceRequest, ActionResponse httpReq) throws NumberFormatException, Exception {
		
		String menuSelect = ParamUtil.getString(resourceRequest, MenuConstraint.SESSION_MENU_SELECTED);
		httpReq.setRenderParameter(MenuConstraint.SESSION_MENU_SELECTED, menuSelect);
		
		PortletConfig portletConfig = (PortletConfig) resourceRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		SessionMessages.add(resourceRequest, portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	}
	
	public static String getUrlFlag(String flagMenu) {
		if (flagMenu.equalsIgnoreCase(MessageType.LOAT_THU_TUC_NHAP_CANH)) {
			return "/group/thu-tuc/danh-sach-tau-thuyen-nhap-canh";
		} else if (flagMenu.equalsIgnoreCase(MessageType.LOAT_THU_TUC_QUA_CANH)) {
			return "/group/thu-tuc/danh-sach-tau-thuyen-qua-canh";
		} else if (flagMenu.equalsIgnoreCase(MessageType.LOAT_THU_TUC_XUAT_CANH)) {
			return "/group/thu-tuc/danh-sach-tau-thuyen-xuat-canh";
		}else if (flagMenu.equalsIgnoreCase(MessageType.LOAT_THU_TUC_VAO_CANG)) {
			return "/group/thu-tuc/danh-sach-tau-thuyen-vao-cang";
		}else if (flagMenu.equalsIgnoreCase(MessageType.LOAT_THU_TUC_ROI_CANG)) {
			return "/group/thu-tuc/danh-sach-tau-thuyen-roi-cang";
		} else if (flagMenu.equalsIgnoreCase(MessageType.LOAT_THU_TUC_DANG_DI_CHUYEN)) {
			return "/group/thu-tuc/lich-su-tau-thuyen-di-chuyen";
		}
		return "";
	}
	
	/* chinh 29/12/2015 */
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {
		try {

			log.info("-----------vao ------------serveResource thu tuc");
			String type = ParamUtil.getString(resourceRequest, "type");
			log.info(" -----------type : " + type);
			if (type != null && type.trim().equals("getComputerHash")) {
				getComputerHash(resourceRequest, resourceResponse);
			} else if (type != null && type.trim().equals("getComputerHashDongDau")) {
				getComputerHashDongDau(resourceRequest, resourceResponse);
			} 
		} catch (Exception e1) {

		}
	}

	public void getComputerHash(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException {
		log.info("-----------vao ------------getComputerHash thu tuc----------");
		try {
			long documentName = ParamUtil.getLong(resourceRequest, PageType.DOCUMENT_NAME);
			int messageType = ParamUtil.getInteger(resourceRequest, PageType.MESSAGE_TYPE);// type
			int documentYear = ParamUtil.getInteger(resourceRequest, PageType.DOCUMENT_YEAR);
			String pageType = ParamUtil.getString(resourceRequest, PageType.PAGE_TYPE);
			int actionType = ParamUtil.getInteger(resourceRequest, PageType.ACTION_TYPE);
			String tieuDe = ParamUtil.getString(resourceRequest, PageType.TIEU_DE_BAN_KHAI);
			log.info("-----------vao ------------getComputerHash documentName thu tuc:----------" + documentName);
			String filePath = "";
			// -- lay repath :
			filePath = SignatureUtil.makeReportFille(resourceRequest, documentName, tieuDe, actionType);

			SignatureUtil.genComputerHashByNoiDungHoSo(resourceRequest, resourceResponse, filePath, documentName);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void signature(ActionRequest actionRequest, ActionResponse actionResponse) {
		String sign = ParamUtil.getString(actionRequest, "sign");
		String signFieldName = ParamUtil.getString(actionRequest, "signFieldName");
		String filePath = ParamUtil.getString(actionRequest, "filePath");

		JSONObject jsonFeed = JSONFactoryUtil.createJSONObject();
		log.info("=====thu tuc===filePath==thu tuc===" + filePath);

		log.info("=====thu tuc===signFieldName===thu tuc==" + signFieldName);

		log.info("======thu tuc==sign=thu tuc====" + sign);
		if (Validator.isNotNull(sign) && Validator.isNotNull(filePath)) {
			byte[] signature = Base64.decode(sign);

			try {
				ServerSigner signer = new ServerSigner(filePath, null);
				log.info("======55555==filePath=thu tuc====" + filePath);
				signer.completeSign(signature, signFieldName);
				log.info("======77777==signFieldName=thu tuc====" + signFieldName);

				String fileName = filePath.substring(filePath.lastIndexOf("/") + 1);
				String fileNameSigned = fileName.substring(0, fileName.indexOf(".pdf")) + ".signed.pdf";

				log.info("======thu tuc==signFieldName  fileNameSigned=thu tuc====" + fileNameSigned);

				filePath = filePath.substring(0, filePath.lastIndexOf("/") + 1) + fileNameSigned;
				log.info("======thu tuc==signFieldName  filePath=thu tuc====" + filePath);

				DocumentStorageImpl document = new DocumentStorageImpl();
				long userId = PortalUtil.getUser(actionRequest).getUserId();

				File file = new File(filePath);
				byte[] readFileToByteArray = FileUtils.readFileToByteArray(file);
				ResultUpload upload = document.upload(userId, readFileToByteArray, "duyet_giay_phep_qua_canh_thu_tuc" + System.nanoTime()
						+ ".pdf");
				log.info("9999userId000000=======" + userId);
				log.info("9999file000000=======" + file);
				log.info("--------FILE LUU TRU-------------");
				log.info(upload.getUrl());
				log.info(upload.getFileId());

				jsonFeed.put("msg", "success");
				jsonFeed.put("filePath", filePath);
				jsonFeed.put("fileId", upload.getFileId());

			} catch (Exception e) {
				log.info("EXCEPTION::::::::::::" + e);
				jsonFeed.put("msg", "error");
			} finally {
				try {
					PortletUtil.writeJSON(actionResponse, jsonFeed);
				} catch (Exception e) {
					log.info("EXCEPTION in finally block:::::::::::" + e);
				}
			}
		} else {
			log.info("Cannot sign the file: " + filePath);
		}
	}

	// chinh dong dau

		
			public void getComputerHashDongDau(ResourceRequest resourceRequest, ResourceResponse response) throws IOException {
				try {
					long documentName = ParamUtil.getLong(resourceRequest, PageType.DOCUMENT_NAME);
					int messageType = ParamUtil.getInteger(resourceRequest, PageType.MESSAGE_TYPE);// type
					int documentYear = ParamUtil.getInteger(resourceRequest, PageType.DOCUMENT_YEAR);
					String pageType = ParamUtil.getString(resourceRequest, PageType.PAGE_TYPE);
					int actionType = ParamUtil.getInteger(resourceRequest, PageType.ACTION_TYPE);
					String tieuDe = ParamUtil.getString(resourceRequest, PageType.TIEU_DE_BAN_KHAI);
					String noiDungHoSo = ParamUtil.getString(resourceRequest, "RequestCode");
					long noiDungHoSoId = ConvertUtil.convertToLong(noiDungHoSo);
					String realPath = ReportUtils.getTemplateReportFilePath(resourceRequest);
					String realExportPath = realPath + "export/";
					String urlFile = null;
					if (noiDungHoSoId > 1) {
						urlFile = SignatureUtil.saveAsPdf(realExportPath, noiDungHoSoId);
					}
					

					String tenFileExport = "";

					
					log.info("---------filePath: " + urlFile);
					SignatureUtil.genComputerHashByNoiDungHoSoDongDau(resourceRequest, response, urlFile, documentName);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			public void signatureDongDau(ActionRequest actionRequest, ActionResponse actionResponse) {
				String sign = ParamUtil.getString(actionRequest, "sign");
				String signFieldName = ParamUtil.getString(actionRequest, "signFieldName");
				String filePath = ParamUtil.getString(actionRequest, "filePath");

				JSONObject jsonFeed = JSONFactoryUtil.createJSONObject();
				log.info("=====9999999===filePath==99999999===" + filePath);

				log.info("=====99999999===signFieldName===9999999999==" + signFieldName);

				log.info("======9999999==sign=9999999999====" + sign);
				if (Validator.isNotNull(sign) && Validator.isNotNull(filePath)) {
					byte[] signature = Base64.decode(sign);

					try {
						ServerSigner signer = new ServerSigner(filePath, null);

						signer.completeSign(signature, signFieldName);

						String fileName = filePath.substring(filePath.lastIndexOf("/") + 1);
						String fileNameSigned = fileName.substring(0, fileName.indexOf(".pdf")) + ".signed.pdf";

						filePath = filePath.substring(0, filePath.lastIndexOf("/") + 1) + fileNameSigned;

						DocumentStorageImpl document = new DocumentStorageImpl();
						long userId = PortalUtil.getUser(actionRequest).getUserId();

						File file = new File(filePath);
						byte[] readFileToByteArray = FileUtils.readFileToByteArray(file);
						ResultUpload upload = document.upload(userId, readFileToByteArray, "duyet" + System.nanoTime() + ".signed.pdf");
						log.info("9999userId000000=======" + userId);
						log.info("9999file000000=======" + file);
						log.info("--------FILE LUU TRU-----ching dong dau--------");
						log.info(upload.getUrl());
						log.info(upload.getFileId());

						jsonFeed.put("msg", "success");
						jsonFeed.put("filePath", filePath);
						jsonFeed.put("fileId", upload.getFileId());

					} catch (Exception e) {
						log.info("EXCEPTION::::::::::::" + e);
						jsonFeed.put("msg", "error");
					} finally {
						try {
							PortletUtil.writeJSON(actionResponse, jsonFeed);
						} catch (Exception e) {
							log.info("EXCEPTION in finally block:::::::::::" + e);
						}
					}
				} else {
					log.info("Cannot sign the file: " + filePath);
				}
			}
		
		
}
