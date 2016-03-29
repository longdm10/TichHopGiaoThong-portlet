/**
 * 
 */
package vn.gt.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * @author win_64
 */
public class FormatData {
	
	public static SimpleDateFormat formatDateShort = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	static SimpleDateFormat formatDateShort2 = new SimpleDateFormat("yyyy-MM-dd");
	public static SimpleDateFormat formatDateShort3 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	static SimpleDateFormat formatDateShort4 = new SimpleDateFormat("HH:mm dd/MM/yyyy");
	static SimpleDateFormat formatDD = new SimpleDateFormat("dd");
	static SimpleDateFormat formatMM = new SimpleDateFormat("MM");
	static SimpleDateFormat formatYYYY = new SimpleDateFormat("yyyy");
	static SimpleDateFormat formatDDMMYYYY = new SimpleDateFormat("dd/MM/yyyy");
	static SimpleDateFormat formatDDMMYYY2 = new SimpleDateFormat("dd-MM-yyyy");
	
	public static String parseLongToString(long value) {
		try {
			return String.valueOf(value);
		} catch (Exception es) {
			return null;
		}
	}
	
	public static String parseIntToString(int value) {
		try {
			return String.valueOf(value);
		} catch (Exception es) {
			return null;
		}
	}
	
	public static String getDayOfMonth(Date date) {
		try {
			return formatDD.format(date);
		} catch (Exception es) {
		}
		return "";
	}
	
	public static String getMonth(Date date) {
		try {
			return formatMM.format(date);
		} catch (Exception es) {
		}
		return "";
	}
	
	public static String getYear(Date date) {
		try {
			return formatYYYY.format(date);
		} catch (Exception es) {
		}
		return "";
	}
	
	public static String getToday() {
		try {
			return formatDDMMYYYY.format(new Date());
		} catch (Exception es) {
		}
		return "";
	}
	
	public static String parseDateToTringDDMMYYY(Date date) {
		try {
			return formatDDMMYYYY.format(date);
		} catch (Exception es) {
		}
		return "";
	}
	
	public static String parseDateToTring(Date date) {
		try {
			return formatDateShort.format(date);
		} catch (Exception es) {
		}
		return "";
	}
	
	public static String parseDateToTringType3(Date date) {
		try {
			return formatDateShort3.format(date);
		} catch (Exception es) {
		}
		return "";
	}
	
	public static String parseDateToTringType4(Date date) {
		try {
			return formatDateShort4.format(date);
		} catch (Exception es) {
		}
		return "";
	}
	
	public static String parseDateToStringType5(Date date) {
		try {
			return formatDDMMYYY2.format(date);
		} catch (Exception e) {
		}
		return "";
	}
	
	public static String parseDateToStringType6(Date date) {
		try {
			return formatDateShort2.format(date);
		} catch (Exception e) {
		}
		return "";
	}
	
	public static XMLGregorianCalendar convertFromDateToXMLGregorianCalendar(Date date) {
		XMLGregorianCalendar dateReturn = null;
		try {
			GregorianCalendar c = new GregorianCalendar();
			c.setTime(date);
			dateReturn = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		} catch (Exception es) {
			// es.printStackTrace();
			try {
				dateReturn = DatatypeFactory.newInstance().newXMLGregorianCalendar();
			} catch (Exception e) {
				// e.printStackTrace();
			}
		}
		return dateReturn;
	}
	
	public static Date parseStringToDate(String date) {
		try {
			if (date == null || date.length() == 0) {
				return null;
			}
			return formatDateShort.parse(date.trim());
		} catch (Exception es) {
			try {
				return formatDateShort2.parse(date.trim());
			} catch (Exception e1) {
				try {
					return formatDateShort3.parse(date.trim());
				} catch (Exception e2) {
					try {
						return formatDateShort4.parse(date.trim());
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		return new Date();
	}
	
	public static Date parseDateShort3StringToDate(String date) {
		try {
			return formatDateShort3.parse(date);
		} catch (Exception e) {
		}
		return new Date();
	}
	
	/**
	 * Convert from String to Long
	 * 
	 * @param value
	 * @return
	 */
	public static long convertToLong(String value) {
		try {
			return Long.parseLong(value.trim());
		} catch (Exception es) {
		}
		
		return 0;
	}
	
	/**
	 * Convert from String to Double
	 * 
	 * @param value
	 * @return
	 */
	public static double convertToDouble(String value) {
		try {
			return Double.parseDouble(value.trim());
		} catch (Exception es) {
		}
		
		return 0;
	}
	
	/**
	 * Convert from String to Long
	 * 
	 * @param value
	 * @return
	 */
	public static int convertToInt(String value) {
		try {
			return Integer.parseInt(value.trim());
		} catch (Exception es) {
		}
		
		return 0;
	}
	
	public static boolean isThisDateValid(String dateToValidate) {
		
		if (dateToValidate == null) {
			return false;
		}
		formatDateShort.setLenient(false);
		try {
			// if not valid, it will throw ParseException
			formatDateShort.parse(dateToValidate.trim());
		} catch (ParseException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public static String formatIntToString(int data) {
		try {
			if (data < 10) {
				return "0" + data;
			}
		} catch (Exception es) {
		}
		
		return String.valueOf(data);
	}
	
	public static String checkData(long number1, long number2) {
		try {
			if (number1 == number2) {
				return "selected=\"selected\"";
			}
		} catch (Exception es) {
		}
		return "";
	}
	
	public static String checkedData(String dmCode, String value) {
		try {
			if (dmCode.equals(value)) {
				return "selected=\"selected\"";
			}
		} catch (Exception es) {
		}
		return "";
	}
	
	public static String congNgay(Date date) {
		try {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			
			calendar.add(Calendar.DAY_OF_YEAR, 1);
			return formatDateShort3.format(calendar.getTime());
		} catch (Exception e) {
		}
		return "";
	}
	
	public static Date subTractDate(Date dateInstance, int numberDay) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateInstance);
		cal.add(Calendar.DATE, -numberDay);
		Date dateBefore30Days = cal.getTime();
		return dateBefore30Days;
	}
	
}
