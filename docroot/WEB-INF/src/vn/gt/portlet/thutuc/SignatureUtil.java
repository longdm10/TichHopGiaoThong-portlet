package vn.gt.portlet.thutuc;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;

import javax.imageio.ImageIO;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import vgca.svrsigner.ServerSigner;
import vn.gt.dao.common.model.UserPort;
import vn.gt.dao.common.service.UserPortLocalServiceUtil;
import vn.gt.dao.danhmuc.model.DmHistoryMaritime;
import vn.gt.dao.danhmuc.model.DmMaritime;
import vn.gt.dao.danhmuc.service.DmHistoryMaritimeLocalServiceUtil;
import vn.gt.dao.danhmuc.service.DmMaritimeLocalServiceUtil;
import vn.gt.dao.noticeandmessage.model.TempDocument;
import vn.gt.portlet.kehoach1.ExtractTextLocations;

import vn.gt.tichhop.message.MessageType;
import vn.gt.tichhop.report.ReportConstant;
import vn.gt.tichhop.report.ReportUtils;
import vn.gt.utils.ConvertUtil;
import vn.gt.utils.PageType;
import vn.gt.utils.config.ConfigurationManager;

import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfSignatureAppearance;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.Base64;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.security.permission.PermissionThreadLocal;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;

public class SignatureUtil {
	public static Log log = LogFactoryUtil.getLog(SignatureUtil.class);

	public static void genComputerHashByNoiDungHoSo(ResourceRequest resourceRequest, ResourceResponse resourceResponse, String filePath,
			long documentName) throws IOException {
		log.info("------vao 0 genComputerHashByNoiDungHoSo-----");
		long userId = PortalUtil.getUserId(resourceRequest);
		byte[] inHash = null;
		String filePath2 = "";
		String fieldName = StringPool.BLANK;
		JSONObject jsonFeed = JSONFactoryUtil.createJSONObject();
		String tenDangNhap = "";

		JSONArray hashComputers = JSONFactoryUtil.getJSONFactory().createJSONArray();
		JSONArray signFieldNames = JSONFactoryUtil.getJSONFactory().createJSONArray();
		JSONArray filePaths = JSONFactoryUtil.getJSONFactory().createJSONArray();
		JSONArray messages = JSONFactoryUtil.getJSONFactory().createJSONArray();
		JSONArray _url_vehicle = JSONFactoryUtil.getJSONFactory().createJSONArray();
		JSONArray _id_vehicle = JSONFactoryUtil.getJSONFactory().createJSONArray();

		try {
			// String realExportPathTmp = request.getContextPath();
			User user = UserLocalServiceUtil.fetchUser(userId);
			if (user != null) {
				tenDangNhap = user.getScreenName();
			}
			log.info("***************************tenDangNhap: " + tenDangNhap);

			String realPath = ReportUtils.getTemplateReportFilePath(resourceRequest, filePath);
			String realExportPath = realPath + "chuky/";

			String imageBase64 = StringPool.BLANK;
			String cer = "/opt/liferay/jboss-7.0.2/standalone/deployments/TichHopGiaoThong-portlet.war/chuky/";
			String cerPath = cer + tenDangNhap + ".cer";
			String signImagePath = "";
			String imgsrc = "/opt/liferay/jboss-7.0.2/standalone/deployments/TichHopGiaoThong-portlet.war/chuky/";
			signImagePath = imgsrc + tenDangNhap + ".png";

			log.info("*****123**********thu tuc*******123*****cerPath: " + cerPath);
			log.info("*******123***thu tuc***********123******signImagePath: " + signImagePath);

			imageBase64 = SignatureUtil.getSignatureImageBase64ByPath(signImagePath);

			BufferedImage bufferedImage = SignatureUtil.getImageByPath(signImagePath);

			// String urlFile = StringPool.BLANK;
			//
			// urlFile = PortalUtil.getPortalURL(request);
			//
			// urlFile = urlFile +
			// DocumentUtils.getLinkDownloadFromNoiLuuTruTaiLieuId(noidungHoSo.getTaiLieuDinhKem());

			log.info("***************123 thu tuc************urlFile: " + filePath);

			// tinh toa do chu ky
			ExtractTextLocations textLocation = new ExtractTextLocations(filePath);

			log.info("***************thu tuc******************" + textLocation.getAnchorX() + "-" + textLocation.getAnchorY()
					+ "***************thu tuc*****************");

			log.info("*********************thu tuc************" + textLocation.getPageLLX() + "-" + textLocation.getPageURX() + "-"
					+ textLocation.getPageLLY() + "-" + textLocation.getPageURY() + "*************thu tuc******************");

			// doc file cer tren server
			Certificate cert = SignatureUtil.getCertificateByPath(cerPath);
			ServerSigner signer = SignatureUtil.getServerSigner(filePath, cert, imageBase64);

			log.info("*********123**********thu tuc********signer: " + signer + "*******filePath:" + filePath);

			// tinh kich thuoc cua anh

			int signatureImageWidth = (bufferedImage != null && bufferedImage.getWidth() > 0) ? bufferedImage.getWidth() : 80;

			int signatureImageHeight = (bufferedImage != null && bufferedImage.getHeight() > 0) ? bufferedImage.getHeight() : 80;
			float llx = textLocation.getAnchorX();

			float urx = llx + signatureImageWidth / 3;

			float lly = textLocation.getPageURY() - textLocation.getAnchorY() - signatureImageHeight / 3;

			float ury = lly + signatureImageHeight / 3;

			// inHash = signer.computeHash(new Rectangle(llx + 65, lly - 55, urx
			// + 114, ury-20), 1);
			
			signer.setSignatureAppearance(PdfSignatureAppearance.RenderingMode.GRAPHIC);   
			inHash = signer.computeHash(new Rectangle(llx, lly, urx, ury), 1);


			fieldName = signer.getSignatureName();
			signFieldNames.put(fieldName);
			hashComputers.put(Base64.encode(inHash));
			filePaths.put(filePath);
			log.info("*****thu tuc********inHash: " + inHash + "-----thu tuc------fieldName: " + fieldName + "---thu tuc-------filePath: " + filePath);
			messages.put("success");
		} catch (Exception e) {
			messages.put("Error signature filePath: " + filePath);
			hashComputers.put(StringPool.BLANK);
			signFieldNames.put(StringPool.BLANK);
			filePaths.put(filePath);
			log.error(e);
		}
		
		
		log.info("-----------hashComputers: " +hashComputers );

		jsonFeed.put("hashComputers", hashComputers);
		jsonFeed.put("signFieldNames", signFieldNames);
		jsonFeed.put("filePaths", filePaths);
		jsonFeed.put("msg", messages);
		log.info("-----------messages: " +messages );
		log.info("-----------filePaths: " +filePaths );
		
		PrintWriter out = resourceResponse.getWriter();
		out.print(jsonFeed.toString());
	}

	public static String makeReportFille(ResourceRequest resourceRequest, long documentName, String tieuDe, int actionType) throws SystemException,
			Exception, PortalException {

		// var nanoTimePDF = $('#nanoTimePDF').val();

		log.info("--thu tuc--vao`-makeReportFille-----");
		String fileName = "";
		long userId = PortalUtil.getUserId(resourceRequest);
		String nanoTimePDF = ParamUtil.getString(resourceRequest, "nanoTimePDF");
		String messageType = ParamUtil.getString(resourceRequest, PageType.MESSAGE_TYPE);
		log.info("--thu tuc--`-nanoTimePDF----thu tuc-" + nanoTimePDF);
		// _Shifting_Order.pdf
		String urlFile = "/opt/liferay/jboss-7.0.2/standalone/deployments/TichHopGiaoThong-portlet.war/export/" + nanoTimePDF;
	 if(MessageType.GIAY_PHEP_QUA_CANH == ConvertUtil.convertToLong(messageType)){
			urlFile = urlFile + "_" + ReportConstant.PERMISSION_FOR_TRANSIT_EXPORT;
			log.info("--thu tuc--`-urlFile----thu tuc giay phep qua canh-" + urlFile);
			
		} else if(MessageType.GIAY_PHEP_ROI_CANG_BO_GTVT_CAP_KHI_XUAT_CANH == ConvertUtil.convertToLong(messageType)){
			urlFile = urlFile + "_" + ReportConstant.ISSUE_PORT_CLEARANCE_EXPORT;
			log.info("--thu tuc--`-urlFile----thu tuc giay phep qua canh-" + urlFile);
			
		}
		return urlFile;
	}

	
	
	public static void genComputerHashByNoiDungHoSoDongDau(ResourceRequest resourceRequest, ResourceResponse resourceResponse, String filePath,
			long documentName) throws IOException, PortalException, SystemException {
		log.info("------vao 0 genComputerHashByNoiDungHoSo-----");
		long userId = PortalUtil.getUserId(resourceRequest);
		byte[] inHash = null;
		String filePath2 = "";
		String fieldName = StringPool.BLANK;
		JSONObject jsonFeed = JSONFactoryUtil.createJSONObject();
		String tenDangNhap = "";
		String cangvu = "";

		JSONArray hashComputers = JSONFactoryUtil.getJSONFactory().createJSONArray();
		JSONArray signFieldNames = JSONFactoryUtil.getJSONFactory().createJSONArray();
		JSONArray filePaths = JSONFactoryUtil.getJSONFactory().createJSONArray();
		JSONArray messages = JSONFactoryUtil.getJSONFactory().createJSONArray();
		JSONArray _url_vehicle = JSONFactoryUtil.getJSONFactory().createJSONArray();
		JSONArray _id_vehicle = JSONFactoryUtil.getJSONFactory().createJSONArray();

		User userLogin = PortalUtil.getUser(resourceRequest);
		UserPort portDefault = UserPortLocalServiceUtil.findByUserId(userLogin.getUserId());

		if (Validator.isNull(portDefault)) {
			// not do something
		} else {
			DmMaritime byMaritimeCode = DmMaritimeLocalServiceUtil.getByMaritimeCode(portDefault.getPortCode());
			cangvu = byMaritimeCode.getMaritimeReference();
		}

		try {
			// String realExportPathTmp = request.getContextPath();
			User user = UserLocalServiceUtil.fetchUser(userId);
			if (user != null) {
				tenDangNhap = user.getScreenName();

			}
			log.info("***************************tenDangNhap: " + tenDangNhap);

			log.info("***********55555555555555555555****************cangvu: " + cangvu);

			String realPath = ReportUtils.getTemplateReportFilePath(resourceRequest, filePath);
			String realExportPath = realPath + "chuky/";

			String imageBase64 = StringPool.BLANK;
			String cer = "/opt/liferay/jboss-7.0.2/standalone/deployments/TichHopGiaoThong-portlet.war/chuky/";
			String cerPath = cer + cangvu + ".cer";
			String signImagePath = "";
			String imgsrc = "/opt/liferay/jboss-7.0.2/standalone/deployments/TichHopGiaoThong-portlet.war/chuky/";
			signImagePath = imgsrc + cangvu + "_condau.png";

			log.info("***************************cerPath: " + cerPath);
			log.info("***************************signImagePath: " + signImagePath);

			imageBase64 = SignatureUtil.getSignatureImageBase64ByPath(signImagePath);

			BufferedImage bufferedImage = SignatureUtil.getImageByPath(signImagePath);

			// String urlFile = StringPool.BLANK;
			//
			// urlFile = PortalUtil.getPortalURL(request);
			//
			// urlFile = urlFile +
			// DocumentUtils.getLinkDownloadFromNoiLuuTruTaiLieuId(noidungHoSo.getTaiLieuDinhKem());

			log.info("***************************urlFile: " + filePath);

			// tinh toa do chu ky
			ExtractTextLocations textLocation = new ExtractTextLocations(filePath);

			log.info("*********************************" + textLocation.getAnchorX() + "-" + textLocation.getAnchorY()
					+ "********************************");

			log.info("*********************************" + textLocation.getPageLLX() + "-" + textLocation.getPageURX() + "-"
					+ textLocation.getPageLLY() + "-" + textLocation.getPageURY() + "*******************************");

			// doc file cer tren server
			Certificate cert = SignatureUtil.getCertificateByPath(cerPath);
			ServerSigner signer = SignatureUtil.getServerSigner(filePath, cert, imageBase64);

			log.info("***************************signer: " + signer + "*******filePath:" + filePath);

			// tinh kich thuoc cua anh

			int signatureImageWidth = (bufferedImage != null && bufferedImage.getWidth() > 0) ? bufferedImage.getWidth() : 80;

			int signatureImageHeight = (bufferedImage != null && bufferedImage.getHeight() > 0) ? bufferedImage.getHeight() : 80;
			float llx = textLocation.getAnchorX();

			float urx = llx + signatureImageWidth / 3;

			float lly = textLocation.getPageURY() - textLocation.getAnchorY() - signatureImageHeight / 3;

			float ury = lly + signatureImageHeight / 3;

			// inHash = signer.computeHash(new Rectangle(llx + 65, lly - 55, urx
			signer.setSignatureAppearance(PdfSignatureAppearance.RenderingMode.GRAPHIC);   
			// + 114, ury-20), 1);
			inHash = signer.computeHash(new Rectangle(llx, lly, urx, ury), 1);

			fieldName = signer.getSignatureName();
			signFieldNames.put(fieldName);
			hashComputers.put(Base64.encode(inHash));
			filePaths.put(filePath);
			log.info("**************inHash: " + inHash + "-----------fieldName: " + fieldName + "----------filePath: " + filePath);
			messages.put("success");
		} catch (Exception e) {
			messages.put("Error signature filePath: " + filePath);
			hashComputers.put(StringPool.BLANK);
			signFieldNames.put(StringPool.BLANK);
			filePaths.put(filePath);
			log.error(e);
		}

		jsonFeed.put("hashComputers", hashComputers);
		jsonFeed.put("signFieldNames", signFieldNames);
		jsonFeed.put("filePaths", filePaths);
		jsonFeed.put("msg", messages);

		PrintWriter out = resourceResponse.getWriter();
		out.print(jsonFeed.toString());
	}

	
	

	public static Certificate getCertificateByPath(String path) throws CertificateException, FileNotFoundException, URISyntaxException {
		CertificateFactory cf = CertificateFactory.getInstance("X.509");

		Certificate cert = cf.generateCertificate(new FileInputStream(new File(path)));

		return cert;
	}

	public static Certificate getCertificateByURL(String url) throws CertificateException, FileNotFoundException, URISyntaxException {
		CertificateFactory cf = CertificateFactory.getInstance("X.509");

		Certificate cert = cf.generateCertificate(new FileInputStream(new File(new URI(url))));

		return cert;
	}

	public static ServerSigner getServerSigner(String fullPath, Certificate cert, String imageBase64) {
		ServerSigner signer = new ServerSigner(fullPath, cert);
		signer.setSignatureGraphic(imageBase64);
		signer.setSignatureAppearance(PdfSignatureAppearance.RenderingMode.GRAPHIC_AND_DESCRIPTION);
		return signer;
	}

	public static String getSignatureImageBase64(String url) {

		String base64 = StringPool.BLANK;

		InputStream is = null;

		ByteArrayOutputStream os = null;

		try {
			is = new URL(url).openStream();
			os = new ByteArrayOutputStream();

			byte[] buffer = new byte[1024];

			byte[] imageBuff = null;

			int length;

			while ((length = is.read(buffer)) != -1)
				os.write(buffer, 0, length); // copy streams

			imageBuff = os.toByteArray();

			base64 = Base64.encode(imageBuff);

		} catch (Exception e) {
			_log.error(e);
		} finally {
			try {
				if (is != null) {
					is.close();
				}
				if (os != null) {
					os.close();
				}
			} catch (IOException e) {
				_log.error(e);
			}
		}
		return base64;
	}

	public static String getSignatureImageBase64ByPath(String fullPath) {

		String base64 = StringPool.BLANK;

		InputStream is = null;

		ByteArrayOutputStream os = null;

		try {
			is = new FileInputStream(new File(fullPath));
			os = new ByteArrayOutputStream();

			byte[] buffer = new byte[1024];

			byte[] imageBuff = null;

			int length;

			while ((length = is.read(buffer)) != -1)
				os.write(buffer, 0, length); // copy streams

			imageBuff = os.toByteArray();

			base64 = Base64.encode(imageBuff);

		} catch (Exception e) {
			_log.error(e);
		} finally {
			try {
				if (is != null) {
					is.close();
				}
				if (os != null) {
					os.close();
				}
			} catch (IOException e) {
				_log.error(e);
			}
		}
		return base64;
	}

	public static BufferedImage getImage(String url) throws IOException, URISyntaxException {
		InputStream is = null;
		BufferedImage bimg = null;
		try {
			is = new URL(url).openStream();
			bimg = ImageIO.read(is);
		} catch (Exception e) {
			_log.error(e);
		} finally {
			if (is != null) {
				is.close();
			}
		}

		return bimg;
	}

	public static BufferedImage getImageByPath(String fullPath) throws IOException, URISyntaxException {
		InputStream is = null;
		BufferedImage bimg = null;
		try {
			is = new FileInputStream(new File(fullPath));
			bimg = ImageIO.read(is);
		} catch (Exception e) {
			_log.error(e);
		} finally {
			if (is != null) {
				is.close();
			}
		}

		return bimg;
	}

	public static String saveAsPdf(String dest, long fileId) throws IOException {
		log.info("--999994444349999--`-saveAsPdf----9934343499999-");
		// BufferedImage image = null;
		InputStream is = null;
		OutputStream os = null;
		String imagePath = StringPool.BLANK;
		try {

			// URL url = new URL(strURL);
			// image = ImageIO.read(url);
			// is = new URL(strURL).openStream();
			FileEntry fileEntry = getFileEntry(fileId);
			if (fileEntry == null)
				return null;
			// is = getInputStreamByFileEntryId(fileId);
			is = fileEntry.getContentStream();
			// image = ImageIO.read(is);
			imagePath = dest + "/" + fileEntry.getTitle();
			// ImageIO.write(image, ext, new File(fileName));

			os = new FileOutputStream(imagePath);

			byte[] b = new byte[1024];
			int length;

			while ((length = is.read(b)) != -1) {
				os.write(b, 0, length);
			}

		} catch (Exception e) {

			_log.error(e);
		} finally {
			if (is != null) {
				is.close();
			}
			if (os != null) {
				os.close();
			}
		}
		return imagePath;
	}

	public static String saveAsImage(String strURL, String dest, String email, String ext, long fileId) throws IOException {
		log.info("--999994444349999--`-saveAsImage----9934343499999-");
		// BufferedImage image = null;
		InputStream is = null;
		OutputStream os = null;
		String imagePath = StringPool.BLANK;
		try {

			// URL url = new URL(strURL);
			// image = ImageIO.read(url);
			// is = new URL(strURL).openStream();
			is = getInputStreamByFileEntryId(fileId);
			// image = ImageIO.read(is);
			imagePath = dest + email + "." + ext;
			// ImageIO.write(image, ext, new File(fileName));

			os = new FileOutputStream(imagePath);

			byte[] b = new byte[1024];
			int length;

			while ((length = is.read(b)) != -1) {
				os.write(b, 0, length);
			}

		} catch (IOException e) {
			_log.error(e);
		} finally {
			if (is != null) {
				is.close();
			}
			if (os != null) {
				os.close();
			}
		}
		return imagePath;
	}

	public static FileEntry getFileEntry(long fileEnTryId) {
		FileEntry fileEntry = null;

		log.info("--999994444349999--`-fileEntry----9934343499999-" + fileEntry);
		try {
			long userId = ConfigurationManager.getLongProp("id_admin", 10196);
			// long userId = 10198;
			// LogFactoryMOC.getLog(DocumentUtils.class).debug("===Starting check permission============userId======="
			// + userId);
			User user = UserLocalServiceUtil.getUserById(userId);

			PermissionThreadLocal.setPermissionChecker(PermissionCheckerFactoryUtil.create(user, true));
			fileEntry = DLAppLocalServiceUtil.getFileEntry(fileEnTryId);

			// inputStream = fileEntry.getContentStream();
		} catch (Exception e) {
			e.printStackTrace();
			// LogFactoryMOC.getLog(DocumentUtils.class).error(e);
		}

		// LogFactoryMOC.getLog(DocumentUtils.class).debug("===== getInputStreamByFileEntryId return inputStream :::"
		// + inputStream);
		return fileEntry;
	}

	public static InputStream getInputStreamByFileEntryId(long fileEnTryId) {
		InputStream inputStream = null;
		log.info("--999994444349999--`vao day -getInputStreamByFileEntryId----9934343499999-");
		try {
			long userId = ConfigurationManager.getLongProp("id_admin", 10196);
			User user = UserLocalServiceUtil.getUserById(userId);

			PermissionThreadLocal.setPermissionChecker(PermissionCheckerFactoryUtil.create(user, true));
			FileEntry fileEntry = DLAppLocalServiceUtil.getFileEntry(fileEnTryId);

			inputStream = fileEntry.getContentStream();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return inputStream;
	}

	private static Log _log = LogFactoryUtil.getLog(SignatureUtil.class);
}
