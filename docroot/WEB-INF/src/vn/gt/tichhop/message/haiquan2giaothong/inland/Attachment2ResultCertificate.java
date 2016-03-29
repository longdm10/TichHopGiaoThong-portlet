package vn.gt.tichhop.message.haiquan2giaothong.inland;

import java.util.List;

import vn.gt.dao.result.model.ResultCertificate;
import vn.gt.dao.result.model.impl.ResultCertificateImpl;
import vn.gt.dao.result.service.ResultCertificateLocalServiceUtil;
import vn.gt.utils.FormatData;
import vn.nsw.Header;
import vn.nsw.model.inland.Attachment;
import vn.nsw.model.inland.Attachment.AttachmentList;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;


public class Attachment2ResultCertificate {
	Log _log = LogFactoryUtil.getLog(Attachment2ResultCertificate.class);

	public boolean insert2ResultCertificate(Attachment attachment, Header header) throws Exception {

		try {
			_log.info("====insert2ResultCertificate=======" );
			long documentName = header.getSubject().getReference();
			int documentYear = header.getSubject().getDocumentYear();

			List<AttachmentList> attachmentLists = null;
			if (attachment.getAttachmentList() != null) {
				attachmentLists = attachment.getAttachmentList();
			}
			if (attachmentLists != null && attachmentLists.size() > 0) {
				for (AttachmentList item : attachmentLists) {				
					String certificateCode = item.getAttachmentType();
					
					List<ResultCertificate> lstResultCertificateExist = ResultCertificateLocalServiceUtil.findByDocumentNameAndDocumentYearAndCertificateCode(documentName, documentYear, certificateCode);
					if(lstResultCertificateExist != null && lstResultCertificateExist.size() > 0){
						for (ResultCertificate  rsExist: lstResultCertificateExist) {
							ResultCertificateLocalServiceUtil.deleteResultCertificate(rsExist);
						}						
					}else{
						ResultCertificate rs = new ResultCertificateImpl();			
						rs.setDocumentName(documentName);
						rs.setDocumentYear(documentYear);	
						rs.setCertificateCode(item.getAttachmentType());
						rs.setCertificateNo(item.getCertificateNo());
						rs.setCertificateExpiredDate(FormatData.parseStringToDate(item.getExpirationDate()));
						rs.setExaminationDate(FormatData.parseStringToDate(item.getDateOfPeriodicInspection()));
						rs.setCertificateIssueDate(FormatData.parseStringToDate(item.getProvidedDate()));
						
						try {
							ResultCertificateLocalServiceUtil.addResultCertificate(rs);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
			
			return true;
		} catch (Exception e) {
			_log.error(e);
			e.printStackTrace();
		}
		return false;
	}

}
