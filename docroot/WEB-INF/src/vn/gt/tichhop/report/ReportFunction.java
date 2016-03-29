
package vn.gt.tichhop.report;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import vn.gt.tichhop.message.MessageType;
import vn.gt.utils.config.ConfigurationManager;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

public class ReportFunction {
	
	private static Log log = LogFactoryUtil.getLog(ReportFunction.class);
	
	static SimpleDateFormat formatDateShort = new SimpleDateFormat("dd/MM/yyyy");
	static SimpleDateFormat formatDateLong1 = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
	static SimpleDateFormat formatDateLong2 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	static SimpleDateFormat formatDateLong3 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	private static String GIO = ConfigurationManager.getStrProp("vn.gt.label.report.gio", "");
	private static String NGAY = ConfigurationManager.getStrProp("vn.gt.label.report.ngay", "");
	private static String THANG = ConfigurationManager.getStrProp("vn.gt.label.report.thang", "");
	private static String NAM = ConfigurationManager.getStrProp("vn.gt.label.report.nam", "");
	private static String NGAY_UPPERCASE = ConfigurationManager.getStrProp("vn.gt.label.report.ngay.uppercase", "");
	
	private static int NHAP_CANH = 1;
	private static int XUAT_CANH = 2;
	private static int QUA_CANH = 3;
	private static int ORTHER_CANH = 4;
	
	public static String parseDateToString(Date date) {
		if (Validator.isNotNull(date)) {
			try {
				return formatDateShort.format(date);
			} catch (Exception es) {
				log.error(es);
			}
		}
		return "";
	}
	
	public static String parseDateToString1(Date date) {
		if (Validator.isNotNull(date)) {
			try {
				return formatDateLong1.format(date);
			} catch (Exception es) {
				log.error(es);
			}
		}
		return "";
	}
	
	public static String parseDateToString2 (Date date) {
		if(Validator.isNotNull(date)) {
			try {
				return formatDateLong2.format(date);
			} catch (Exception es) {
				log.error(es);
			}
		}
		return "";
	}
	
	public static String parseDateToString3 (String sDate) {
		if(Validator.isNotNull(sDate)) {
			try {
				Date date = formatDateLong3.parse(sDate);
				return formatDateLong3.format(date);
			} catch (Exception es) {
				log.error(es);
			}
		}
		return "";
	}
	
	public static String parserDateToString3 (Date date) {
		if (Validator.isNotNull(date)) {
			try {
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(date);
				
				int hours = calendar.get(Calendar.HOUR_OF_DAY);
				String sHours = "";
				if (hours < 10) { sHours = "0" + hours; }
				else { sHours = hours + ""; }
				
				int minutes = calendar.get(Calendar.MINUTE);
				String sMinutes = "";
				if (minutes < 10) { sMinutes = "0" + minutes ; }
				else { sMinutes = minutes + ""; };
				
				int day = calendar.get(Calendar.DAY_OF_MONTH);
				String sDay = "";
				if (day < 10) { sDay = "0" + day; }
				else { sDay = day + ""; };
				
				int month = calendar.get(Calendar.MONTH) + 1;
				String sMonth = "";
				if (month < 10) { sMonth = "0" + month; }
				else { sMonth = month + ""; }
				
				int year = calendar.get(Calendar.YEAR);
				return sHours + ":" + sMinutes + " " + NGAY + " " + sDay + " " + THANG + " " + sMonth + " " + NAM + " " + year;
			} catch (Exception e) {
				log.error(e);
			}
		}
		return "";
	}
	
	public static String parserDateToString3NEW (Date date) {
		if (Validator.isNotNull(date)) {
			try {
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(date);
				
				int hours = calendar.get(Calendar.HOUR_OF_DAY);
				String sHours = "";
				if (hours < 10) { sHours = "0" + hours; }
				else { sHours = hours + ""; }
				
				int minutes = calendar.get(Calendar.MINUTE);
				String sMinutes = "";
				if (minutes < 10) { sMinutes = "0" + minutes ; }
				else { sMinutes = minutes + ""; };
				
				int day = calendar.get(Calendar.DAY_OF_MONTH);
				String sDay = "";
				if (day < 10) { sDay = "0" + day; }
				else { sDay = day + ""; };
				
				int month = calendar.get(Calendar.MONTH) + 1;
				String sMonth = "";
				if (month < 10) { sMonth = "0" + month; }
				else { sMonth = month + ""; }
				
				int year = calendar.get(Calendar.YEAR);
				return sHours +" "+ GIO+" " + sMinutes + " " + NGAY + " " + sDay + " " + THANG + " " + sMonth + " " + NAM + " " + year;
			} catch (Exception e) {
				log.error(e);
			}
		}
		return "";
	}	
	
	
	public static String parserDateToString3LT (Date date) {
		if (Validator.isNotNull(date)) {
			try {
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(date);
				int hours = calendar.get(Calendar.HOUR_OF_DAY);
				int minutes = calendar.get(Calendar.MINUTE);
				
				String sHours = "";
				if (hours < 10) { sHours = "0" + hours; }
				else { sHours = hours + ""; };
				
				String sMinutes = "";
				if (minutes < 10) { sMinutes = "0" + minutes ; }
				else { sMinutes = minutes + ""; };
				
				int day = calendar.get(Calendar.DAY_OF_MONTH);
				
				String sDay = "";
				if (day < 10) { sDay = "0" + day; }
				else { sDay = day + ""; }
				
				int month = calendar.get(Calendar.MONTH) + 1;
				String sMonth = "";
				if (month < 10) { sMonth = "0" + month; }
				else { sMonth = month + ""; }
				
				int year = calendar.get(Calendar.YEAR);
				return sDay + "/" + sMonth + "/" + year + "-" + sHours + sMinutes + " " + "LT";
			} catch (Exception e) {
				log.error(e);
			}
		}
		return "";
	}
	
	
	public static String parserDateToString3LTInland (Date date) {
		if (Validator.isNotNull(date)) {
			try {
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(date);
				int hours = calendar.get(Calendar.HOUR_OF_DAY);
				int minutes = calendar.get(Calendar.MINUTE);
				
				String sHours = "";
				if (hours < 10) { sHours = "0" + hours; }
				else { sHours = hours + ""; };
				
				String sMinutes = "";
				if (minutes < 10) { sMinutes = "0" + minutes ; }
				else { sMinutes = minutes + ""; };
				
				int day = calendar.get(Calendar.DAY_OF_MONTH);
				
				String sDay = "";
				if (day < 10) { sDay = "0" + day; }
				else { sDay = day + ""; }
				
				int month = calendar.get(Calendar.MONTH) + 1;
				String sMonth = "";
				if (month < 10) { sMonth = "0" + month; }
				else { sMonth = month + ""; }
				
				int year = calendar.get(Calendar.YEAR);
				return sDay + "/" + sMonth + "/" + year + "-" + sHours +":"+ sMinutes ;
			} catch (Exception e) {
				log.error(e);
			}
		}
		return "";
	}
	
	
	public static String parserDateToString4 (Date date) {
		if (Validator.isNotNull(date)) {
			try {
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(date);
				int day = calendar.get(Calendar.DAY_OF_MONTH);
				String sDay = "";
				if (day < 10) { sDay = "0" + day;
				} else { sDay = day + ""; }

				int month = calendar.get(Calendar.MONTH) + 1;
				String sMonth = "";
				if (month < 10) { sMonth = "0" + month; }
				else { sMonth = month + ""; }
				
				int year = calendar.get(Calendar.YEAR);
				return NGAY + " " + sDay + " " + THANG + " " + sMonth + " " + NAM + " " + year;
			} catch (Exception e) {
				log.error(e);
			}
		}
		return "";
	}
	
	public static String parserDateToString5 (Date date) {
		if (Validator.isNotNull(date)) {
			try {
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(date);
				
				int day = calendar.get(Calendar.DAY_OF_MONTH);
				String sDay = "";
				if (day < 10) { sDay = "0" + day;
				} else { sDay = day + ""; }

				int month = calendar.get(Calendar.MONTH) + 1;
				String sMonth = "";
				if (month < 10) { sMonth = "0" + month; }
				else { sMonth = month + ""; }
				
				int year = calendar.get(Calendar.YEAR);
				return NGAY_UPPERCASE + " " + sDay + " " + THANG + " " + sMonth + " " + NAM + " " + year;
			} catch (Exception e) {
				log.error(e);
			}
		}
		return "";
	}
	
	public static int iLoaiThuTuc(String sLoaiThuTuc) {
		if (sLoaiThuTuc.compareTo(MessageType.LOAT_THU_TUC_NHAP_CANH) == 0) {
			return NHAP_CANH;
		} else if (sLoaiThuTuc.compareTo(MessageType.LOAT_THU_TUC_XUAT_CANH) == 0) {
			return XUAT_CANH;
		} else if (sLoaiThuTuc.compareTo(MessageType.LOAT_THU_TUC_QUA_CANH) == 0) {
			return QUA_CANH;
		}else if (sLoaiThuTuc.compareTo(MessageType.LOAT_THU_TUC_VAO_CANG) == 0) {
			return MessageType.TAU_VAO;
		}else if (sLoaiThuTuc.compareTo(MessageType.LOAT_THU_TUC_ROI_CANG) == 0) {
			return MessageType.TAU_RA;
		}
		return ORTHER_CANH;
	}
}