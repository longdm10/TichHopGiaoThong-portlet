package vn.gt.portlet.baocao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import javax.portlet.PortletException;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import vn.gt.portlet.baocao.kehoachdieudong.KeHoachDieuDongExport;
import vn.gt.portlet.baocao.thongke.dvcong.DichVuCongExport;
import vn.gt.portlet.baocao.thongke.dvcongtheophongban.DVCongTheoPhongBanExport;
import vn.gt.portlet.baocao.thongke.tinhhinhnophs.TinhHinhNopHoSoExport;
import vn.gt.portlet.baocao.thongtintau.kiemtrathongtintau.KiemTraThongTinTauExport;
import vn.gt.portlet.baocao.thongtintau.phanhoicuacqcn.PhanHoiCuaCqcnExport;
import vn.gt.portlet.baocao.tinhhinhdukienneodau.TinhHinhDuKienNeoDauExport;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class BaoCaoBussinessUtils {
	
	private Log log = LogFactoryUtil.getLog(BaoCaoBussinessUtils.class);
	
	private String pathFileTemp = "/opt/liferay/jboss-7.0.2/standalone/deployments/TichHopGiaoThong-portlet.war/report/baocao/";
	private String pathFileSub = "/opt/liferay/jboss-7.0.2/standalone/deployments/TichHopGiaoThong-portlet.war/export/";
	
	/*
	 * Function Export to Server
	 */
	
	public boolean actionBaoCaoThongKeExport(int reportCode, String maritimeCode, String ngayLap, String dateFrom, String dateTo) throws Exception {
		
		boolean result = true;
		
		if (reportCode == BaoCaoConstant.BAO_CAO_KE_HOACH_DIEU_DONG) {
			log.debug("********* Vao KeHoachDieuDongExport ********* ");
			KeHoachDieuDongExport action = new KeHoachDieuDongExport();
			result = action.export2Report(reportCode, maritimeCode, ngayLap, dateFrom, dateTo);
		} else if (reportCode == BaoCaoConstant.THONG_BAO_TINH_HINH_TAU_THUYEN_DU_KIEN_NEO_DAU_TAI_CANG) {
			log.debug("********* Vao TinhHinhDuKienNeoDauExport ********* ");
			TinhHinhDuKienNeoDauExport action = new TinhHinhDuKienNeoDauExport();
			result = action.export2Report(reportCode, maritimeCode, ngayLap, dateFrom, dateTo);
		} else if (reportCode == BaoCaoConstant.BAO_CAO_THONG_KE_TINH_HINH_NOP_HO_SO) {
			log.debug("********* Vao TinhHinhNopHoSoExport ********* ");
			TinhHinhNopHoSoExport action = new TinhHinhNopHoSoExport();
			result = action.export2Report(ngayLap, maritimeCode, dateFrom, dateTo);
		} else if (reportCode == BaoCaoConstant.BAO_CAO_THONG_KE_HO_SO_THEO_PHONG_BAN) {
			log.debug("********* Vao DVCongTheoPhongBanExport ********* ");
			DVCongTheoPhongBanExport action = new DVCongTheoPhongBanExport();
			result = action.export2Report(ngayLap, maritimeCode, dateFrom, dateTo);
		} else if (reportCode == BaoCaoConstant.BAO_CAO_THONG_KE_DICH_VU_CONG) {
			log.debug("********* Vao DichVuCongExport ********* ");
			DichVuCongExport action = new DichVuCongExport();
			result = action.export2Report(ngayLap, maritimeCode, dateFrom, dateTo);
		}
		
		return result;
	}
	
	public boolean actionExportThongKeTinhHinhNopHoSo(String reportDate, String maritimeCode, String dateFrom, String dateTo) throws Exception {
		
		TinhHinhNopHoSoExport action = new TinhHinhNopHoSoExport();
		action.export2Report(reportDate, maritimeCode, dateFrom, dateTo);
		
		return true;
	}
	
	public boolean actionExportThongKeDVCongTheoPhongBan(String reportDate, String maritimeCode, String dateFrom, String dateTo) throws Exception {
		
		DVCongTheoPhongBanExport action = new DVCongTheoPhongBanExport();
		action.export2Report(reportDate, maritimeCode, dateFrom, dateTo);
		
		return true;
	}
	
	public boolean actionExportThongKeDichVuCong(String reportDate, String maritimeCode, String dateFrom, String dateTo) throws Exception {
		
		DichVuCongExport action = new DichVuCongExport();
		action.export2Report(reportDate, maritimeCode, dateFrom, dateTo);
		
		return true;
	}
	
	public long actionExportThongTinTau(long documentName, int documentYear, String ministryCode) throws Exception {
		PhanHoiCuaCqcnExport action = new PhanHoiCuaCqcnExport();
		return action.export2Report(documentName, documentYear, ministryCode);
	}
	
	public boolean actionExportKiemTraThongTinTau(long documentName, int documentYear) throws Exception {
		
		KiemTraThongTinTauExport action = new KiemTraThongTinTauExport();
		action.export2Report(documentName, documentYear);
		
		return true;
	}
	
	/*
	 * Function Export to Server
	 */
	public long exportFunction(String tenFile_Template, String tenFile_Export, JRDataSource dataSource, Map<String, Object> parameters) throws IOException, PortletException {
		long nanoTime = System.nanoTime();
		try {
			InputStream inputStream = new FileInputStream(pathFileTemp + tenFile_Template);
			JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
			
			JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
			
			parameters.put("SUBREPORT_DIR", pathFileTemp);
			
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
			
			JasperExportManager.exportReportToPdfFile(jasperPrint, pathFileSub + nanoTime + "_" +tenFile_Export);
			return nanoTime;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public void exportFunctionModuleBaoCao(String tenFile_Template, String tenFile_Export, JRDataSource dataSource, Map<String, Object> parameters) throws IOException, PortletException {
		try {
			InputStream inputStream = new FileInputStream(pathFileTemp + tenFile_Template);
			JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
			
			JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
			
			parameters.put("SUBREPORT_DIR", pathFileTemp);
			
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
			
			JasperExportManager.exportReportToPdfFile(jasperPrint, pathFileSub + tenFile_Export);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
