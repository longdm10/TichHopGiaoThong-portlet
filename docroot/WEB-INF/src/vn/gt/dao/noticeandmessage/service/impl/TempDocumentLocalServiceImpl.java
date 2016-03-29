/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package vn.gt.dao.noticeandmessage.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import vn.gt.dao.noticeandmessage.model.TempDocument;
import vn.gt.dao.noticeandmessage.service.base.TempDocumentLocalServiceBaseImpl;
import vn.gt.portlet.baocaotichhop.thongke.dvcong.FlowChartDataByDate;
import vn.gt.tichhop.message.MessageType;

/**
 * The implementation of the temp document local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link vn.gt.dao.noticeandmessage.service.TempDocumentLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author win_64
 * @see vn.gt.dao.noticeandmessage.service.base.TempDocumentLocalServiceBaseImpl
 * @see vn.gt.dao.noticeandmessage.service.TempDocumentLocalServiceUtil
 */
public class TempDocumentLocalServiceImpl extends TempDocumentLocalServiceBaseImpl {
	
	private Log log = LogFactoryUtil.getLog(TempDocumentLocalServiceImpl.class);

	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * vn.gt.dao.noticeandmessage.service.TempDocumentLocalServiceUtil} to
	 * access the temp document local service.
	 */
	
	public TempDocument getTemDocumentByRequestCode(String requestCode) {
		try {
			List<TempDocument> documents = tempDocumentPersistence.findByRequestCode(requestCode);
			if (documents != null && documents.size() > 0) {
				return documents.get(0);
			}
		} catch (Exception e) {
			log.equals(e);
		}
		return null;
	}
	
	public TempDocument getByDocumentNameAndDocumentYear(long documentName, int documentYear) throws Exception {
		return tempDocumentFinder.getByDocumentNameAndDocumentYear(documentName, documentYear);
	}
	
	
	
	public String getCallSignByDocumentNameAndDocumentYear(long documentName, int documentYear) {
		try {
			return tempDocumentFinder.getCallSignByDocumentNameAndDocumentYear(documentName, documentYear);
		} catch (Exception e) {
			log.equals(e);
		}
		return null;
	}
	
	public List<TempDocument> findTemDocumentByDocumentNameAndDocumentYear(long documentName, int documentYear) {
		try {
			return tempDocumentFinder.findTemDocumentByDocumentNameAndDocumentYear(documentName, documentYear);
		} catch (Exception es) {
			es.printStackTrace();
			log.error(es);
		}
		return new ArrayList<TempDocument>();
	}

	public List<TempDocument> findTempDocumentArivalByMaritimeCodeAndDateFromAndDateTo(String maritimeCode, String dateFrom, String dateTo,
			String documentTypeCode, String requestState, String documentStatusCode) {
		try {
			return tempDocumentFinder.findTempDocumentArivalByMaritimeCodeAndDateFromAndDateTo(maritimeCode, dateFrom, dateTo, documentTypeCode,
					requestState, documentStatusCode);
		} catch (Exception es) {
			es.printStackTrace();
			log.error(es);
		}
		return null;
	}

	public List<TempDocument> findTempDocumentLeaveByMaritimeCodeAndDateFromAndDateTo(String maritimeCode, String dateFrom, String dateTo,
			String documentTypeCode, String requestState, String documentStatusCode) {
		try {
			return tempDocumentFinder.findTempDocumentLeaveByMaritimeCodeAndDateFromAndDateTo(maritimeCode, dateFrom, dateTo, documentTypeCode,
					requestState, documentStatusCode);
		} catch (Exception es) {
			es.printStackTrace();
			log.error(es);
		}
		return null;
	}

	public long countTempDocumentForStatisticsReport(String maritimeCode, String dateFrom, String dateTo, String documentTypeCode,
			String requestState, String documentStatusCode) {
		try {
			return tempDocumentFinder.countTempDocumentForStatisticsReport(maritimeCode, dateFrom, dateTo, documentTypeCode, requestState,
					documentStatusCode);
		} catch (Exception es) {
			es.printStackTrace();
			log.error(es);
		}
		return 0;
	}

	public List<FlowChartDataByDate> countTempDocumentForStatisticsByDate(String maritimeCode, String dateFrom, String dateTo,
			String documentTypeCode, String requestState, String documentStatusCode) {
		List<FlowChartDataByDate> result = null;
		try {
			result = tempDocumentFinder.countTempDocumentForStatisticsByDate(maritimeCode, dateFrom, dateTo, documentTypeCode, requestState,
					documentStatusCode);
		} catch (Exception es) {
			es.printStackTrace();
			log.error(es);
		}
		return result;
	}

	public long countTempDocumentJoinIssueShiftingOrderForStatisticsReport(String maritimeCode, String dateFrom, String dateTo,
			String documentTypeCode, String requestState, String issRequestState, String documentStatusCode) {
		try {
			return tempDocumentFinder.countTempDocumentJoinIssueShiftingOrderForStatisticsReport(maritimeCode, dateFrom, dateTo, documentTypeCode,
					requestState, issRequestState, documentStatusCode);
		} catch (Exception es) {
			es.printStackTrace();
			log.error(es);
		}
		return 0;
	}

	public long countTempDocumentJoinIssuePermissionTransitForStatisticsReport(String maritimeCode, String dateFrom, String dateTo,
			String documentTypeCode, String requestState, String issRequestState, String documentStatusCode) {
		try {
			return tempDocumentFinder.countTempDocumentJoinIssuePermissionTransitForStatisticsReport(maritimeCode, dateFrom, dateTo,
					documentTypeCode, requestState, issRequestState, documentStatusCode);
		} catch (Exception es) {
			es.printStackTrace();
			log.error(es);
		}
		return 0;
	}

	public long countTempDocumentJoinIssuePortClearanceForStatisticsReport(String maritimeCode, String dateFrom, String dateTo,
			String documentTypeCode, String requestState, String issRequestState, String documentStatusCode) {
		try {
			return tempDocumentFinder.countTempDocumentJoinIssuePortClearanceForStatisticsReport(maritimeCode, dateFrom, dateTo, documentTypeCode,
					requestState, issRequestState, documentStatusCode);
		} catch (Exception es) {
			es.printStackTrace();
			log.error(es);
		}
		return 0;
	}

	public TempDocument findTemDocumentByDocumentNameDocumentYear(long documentName, int documentYear) {
		try {
			return tempDocumentFinder.findTemDocumentByDocumentNameDocumentYear(documentName, documentYear);
		} catch (Exception es) {
			es.printStackTrace();
			log.error(es);
		}
		return null;
	}

	public List<TempDocument> findTempDocumentByRequestState(String requestState, String documentTypeCode, int start, int end) throws SystemException {
		try {
			return tempDocumentFinder.findTempDocumentByRequestState(requestState, documentTypeCode, start, end);
		} catch (Exception es) {
			es.printStackTrace();
			log.error(es);
		}
		return new ArrayList<TempDocument>();
	}

	public int countTempDocumentByRequestState(String requestState, String documentTypeCode) {
		try {
			return tempDocumentFinder.countTempDocumentByRequestState(requestState, documentTypeCode);
		} catch (Exception es) {
			es.printStackTrace();
			log.error(es);
		}
		return 0;
	}

	public List<TempDocument> findTempDocumentByDocumentStatusCode(String documentStatusCode, String documentTypeCode, int start, int end)
			throws SystemException {
		try {
			return tempDocumentFinder.findTempDocumentByDocumentStatusCode(documentStatusCode, documentTypeCode, start, end);
		} catch (Exception es) {
			es.printStackTrace();
			log.error(es);
		}
		return new ArrayList<TempDocument>();
	}

	public int countTempDocumentByDocumentStatusCode(String documentStatusCode, String documentTypeCode) {
		try {
			return tempDocumentFinder.countTempDocumentByDocumentStatusCode(documentStatusCode, documentTypeCode);
		} catch (Exception es) {
			es.printStackTrace();
			log.error(es);
		}
		return 0;
	}

	public List<TempDocument> findTempDocumentByKeHoach(String requestState, String documentTypeCode,
			String maritimeCode, String shipName, String positionCode, String portRegionCode, String mabankhai, String stateCode,
			String shipDateFromStart, String shipDateFromEnd, String shipDateToStart, String shipDateToEnd,
			String callSign, String imo, String ngayLamThuTucFrom, String ngayLamThuTucTo, int start, int end) {

		try {
			return tempDocumentFinder.findTempDocumentByKeHoach(requestState, documentTypeCode, maritimeCode, shipName, positionCode, portRegionCode,
					mabankhai, stateCode,
					shipDateFromStart, shipDateFromEnd, shipDateToStart, shipDateToEnd,
					callSign, imo, ngayLamThuTucFrom, ngayLamThuTucTo, start, end);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public int countTempDocumentByKeHoach(String requestState, String documentTypeCode, String maritimeCode, String shipName, String positionCode,
			String portRegionCode, String mabankhai, String stateCode,
			String shipDateFromStart, String shipDateFromEnd, String shipDateToStart, String shipDateToEnd,
			String callSign, String imo, String ngayLamThuTucFrom, String ngayLamThuTucTo) {

		try {
			return tempDocumentFinder.countTempDocumentByKeHoach(requestState, documentTypeCode, maritimeCode, shipName, positionCode,
					portRegionCode, mabankhai, stateCode,
					shipDateFromStart, shipDateFromEnd, shipDateToStart, shipDateToEnd,
					callSign, imo, ngayLamThuTucFrom, ngayLamThuTucTo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<TempDocument> findAll(int start, int end) {
		try {
			return tempDocumentPersistence.findAll(start, end);
		} catch (Exception es) {
			es.printStackTrace();
			log.error(es);
		}
		return new ArrayList<TempDocument>();
	}

	public int countAll() {
		try {
			return tempDocumentPersistence.countAll();
		} catch (Exception es) {
			es.printStackTrace();
			log.error(es);
		}
		return 0;
	}

	

	public List<TempDocument> findTempDocumentByThuTuc(String documentTypeCode, String documentName,
			String documentYear, String maLoaiHoSo, String shipName, String shipTypeCode, String stateCode, String shipCaptain, String callSign,
			String userCreated, int start, int end) throws SystemException {
		return tempDocumentFinder.findTempDocumentByThuTuc(documentTypeCode, documentName, documentYear, maLoaiHoSo, shipName, shipTypeCode,
				stateCode, shipCaptain, callSign, userCreated, start, end);
	}

	public int countTempDocumentByThuTuc(String documentTypeCode, String documentName, String documentYear, String maLoaiHoSo, String shipName,
			String shipTypeCode, String stateCode, String shipCaptain, String callSign, String userCreated)
			throws SystemException {
		return tempDocumentFinder.countTempDocumentByThuTuc(documentTypeCode, documentName, documentYear, maLoaiHoSo, shipName, shipTypeCode,
				stateCode, shipCaptain, callSign, userCreated);
	}

	public List<TempDocument> findDanhSachHoSoRoleThuTuc(String documentTypeCode, String maritimeCode,
			String portCode, String lastPortCode, String shipName, String stateCode, String callSign, String imo, String shipPosition,
			String shipDateFromStart, String shipDateFromEnd, String shipDateToStart, String shipDateToEnd, String documentStatusCode,
			String arrivalShipAgency, String nameArrivalShipAgency, String departureShipAgency, String nameDepartureShipAgency,
			String portRegionCode, String ngayLamThuTucFrom, String ngayLamThuTucTo, String maBanKhai, int start, int end)
			throws SystemException {
		
		log.info("==nameArrivalShipAgency====" + nameArrivalShipAgency + "==arrivalShipAgency====" + arrivalShipAgency);
		log.info("==nameDepartureShipAgency==" + nameDepartureShipAgency + "==departureShipAgency==" + departureShipAgency);
		
		if ((nameArrivalShipAgency.trim().length() > 0 && arrivalShipAgency.trim().length() == 0) ||
			(nameDepartureShipAgency.trim().length() > 0 && departureShipAgency.trim().length() == 0)) {
			return tempDocumentFinder.findDanhSachHoSoRoleThuTucLikeShipAgency(documentTypeCode, maritimeCode, portCode, lastPortCode, shipName, stateCode, callSign,
					imo, shipPosition, shipDateFromStart, shipDateFromEnd, shipDateToStart, shipDateToEnd, documentStatusCode,
					arrivalShipAgency, nameArrivalShipAgency, departureShipAgency, nameDepartureShipAgency,
					portRegionCode, ngayLamThuTucFrom, ngayLamThuTucTo, maBanKhai, start, end);
		} else {
			return tempDocumentFinder.findDanhSachHoSoRoleThuTuc(documentTypeCode, maritimeCode, portCode, lastPortCode, shipName, stateCode, callSign,
					imo, shipPosition, shipDateFromStart, shipDateFromEnd, shipDateToStart, shipDateToEnd, documentStatusCode,
					arrivalShipAgency, nameArrivalShipAgency, departureShipAgency, nameDepartureShipAgency,
					portRegionCode, ngayLamThuTucFrom, ngayLamThuTucTo, maBanKhai, start, end);
		}
	}

	public int countDanhSachHoSoRoleThuTuc(String documentTypeCode, String maritimeCode, String portCode, String lastPortCode, String shipName,
			String stateCode, String callSign, String imo, String shipPosition,
			String shipDateFromStart, String shipDateFromEnd, String shipDateToStart, String shipDateToEnd, String documentStatusCode,
			String arrivalShipAgency, String nameArrivalShipAgency, String departureShipAgency, String nameDepartureShipAgency,
			String portRegionCode, String ngayLamThuTucFrom, String ngayLamThuTucTo,
			String maBanKhai) throws SystemException {
		
		log.info("==nameArrivalShipAgency====" + nameArrivalShipAgency + "==arrivalShipAgency====" + arrivalShipAgency);
		log.info("==nameDepartureShipAgency==" + nameDepartureShipAgency + "==departureShipAgency==" + departureShipAgency);
		
		if ((nameArrivalShipAgency.trim().length() > 0 && arrivalShipAgency.trim().length() == 0) ||
				(nameDepartureShipAgency.trim().length() > 0 && departureShipAgency.trim().length() == 0)) {
			
			return tempDocumentFinder.countDanhSachHoSoRoleThuTucLikeShipAgency(documentTypeCode, maritimeCode, portCode, lastPortCode, shipName, stateCode, callSign,
					imo, shipPosition, shipDateFromStart, shipDateFromEnd, shipDateToStart, shipDateToEnd, documentStatusCode,
					arrivalShipAgency, nameArrivalShipAgency, departureShipAgency, nameDepartureShipAgency,
					portRegionCode, ngayLamThuTucFrom, ngayLamThuTucTo, maBanKhai);
			
		} else {
			return tempDocumentFinder.countDanhSachHoSoRoleThuTuc(documentTypeCode, maritimeCode, portCode, lastPortCode, shipName, stateCode, callSign,
					imo, shipPosition, shipDateFromStart, shipDateFromEnd, shipDateToStart, shipDateToEnd, documentStatusCode,
					arrivalShipAgency, nameArrivalShipAgency, departureShipAgency, nameDepartureShipAgency,
					portRegionCode, ngayLamThuTucFrom, ngayLamThuTucTo, maBanKhai);
		}
		
		
	}

	public List<TempDocument> findTempDocumentInfo(String documentStatusCode, String maritimeCode, String portCode, String shipName, String callSign,
			String shipDateFrom, String shipDateTo, int start, int end) {
		try {
			return tempDocumentFinder.findTempDocumentInfo(documentStatusCode, maritimeCode, portCode, shipName, callSign, shipDateFrom, shipDateTo,
					start, end);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public int countTempDocumentInfo(String documentStatusCode, String maritimeCode, String portCode, String shipName, String callSign,
			String shipDateFrom, String shipDateTo) throws SystemException {
		try {
			return tempDocumentFinder.countTempDocumentInfo(documentStatusCode, maritimeCode, portCode, shipName, callSign, shipDateFrom, shipDateTo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public List<TempDocument> findKeHoachYCBS() throws SystemException {
		return tempDocumentFinder.findKeHoachYCBS();
	}
}