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

package vn.gt.dao.noticeandmessage.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author win_64
 */
public class TempDocumentFinderUtil {
	public static java.lang.String getCallSignByDocumentNameAndDocumentYear(
		long documentName, int documentYear)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .getCallSignByDocumentNameAndDocumentYear(documentName,
			documentYear);
	}

	public static vn.gt.dao.noticeandmessage.model.TempDocument getByDocumentNameAndDocumentYear(
		long documentName, int documentYear)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .getByDocumentNameAndDocumentYear(documentName, documentYear);
	}

	public static long countTempDocumentJoinIssuePermissionTransitForStatisticsReport(
		java.lang.String maritimeCode, java.lang.String dateFrom,
		java.lang.String dateTo, java.lang.String documentTypeCode,
		java.lang.String requestState, java.lang.String issRequestState,
		java.lang.String documentStatusCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countTempDocumentJoinIssuePermissionTransitForStatisticsReport(maritimeCode,
			dateFrom, dateTo, documentTypeCode, requestState, issRequestState,
			documentStatusCode);
	}

	public static long countTempDocumentJoinIssuePortClearanceForStatisticsReport(
		java.lang.String maritimeCode, java.lang.String dateFrom,
		java.lang.String dateTo, java.lang.String documentTypeCode,
		java.lang.String requestState, java.lang.String issRequestState,
		java.lang.String documentStatusCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countTempDocumentJoinIssuePortClearanceForStatisticsReport(maritimeCode,
			dateFrom, dateTo, documentTypeCode, requestState, issRequestState,
			documentStatusCode);
	}

	public static long countTempDocumentJoinIssueShiftingOrderForStatisticsReport(
		java.lang.String maritimeCode, java.lang.String dateFrom,
		java.lang.String dateTo, java.lang.String documentTypeCode,
		java.lang.String requestState, java.lang.String issRequestState,
		java.lang.String documentStatusCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countTempDocumentJoinIssueShiftingOrderForStatisticsReport(maritimeCode,
			dateFrom, dateTo, documentTypeCode, requestState, issRequestState,
			documentStatusCode);
	}

	public static long countTempDocumentForStatisticsReport(
		java.lang.String maritimeCode, java.lang.String dateFrom,
		java.lang.String dateTo, java.lang.String documentTypeCode,
		java.lang.String requestState, java.lang.String documentStatusCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countTempDocumentForStatisticsReport(maritimeCode,
			dateFrom, dateTo, documentTypeCode, requestState, documentStatusCode);
	}

	public static java.util.List<vn.gt.portlet.baocaotichhop.thongke.dvcong.FlowChartDataByDate> countTempDocumentForStatisticsByDate(
		java.lang.String maritimeCode, java.lang.String dateFrom,
		java.lang.String dateTo, java.lang.String documentTypeCode,
		java.lang.String requestState, java.lang.String documentStatusCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countTempDocumentForStatisticsByDate(maritimeCode,
			dateFrom, dateTo, documentTypeCode, requestState, documentStatusCode);
	}

	public static int countTempDocumentByDocumentStatusCode(
		java.lang.String documentStatusCode, java.lang.String documentTypeCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countTempDocumentByDocumentStatusCode(documentStatusCode,
			documentTypeCode);
	}

	public static java.util.List<vn.gt.dao.noticeandmessage.model.TempDocument> findTempDocumentArivalByMaritimeCodeAndDateFromAndDateTo(
		java.lang.String maritimeCode, java.lang.String dateFrom,
		java.lang.String dateTo, java.lang.String documentTypeCode,
		java.lang.String requestState, java.lang.String documentStatusCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findTempDocumentArivalByMaritimeCodeAndDateFromAndDateTo(maritimeCode,
			dateFrom, dateTo, documentTypeCode, requestState, documentStatusCode);
	}

	public static java.util.List<vn.gt.dao.noticeandmessage.model.TempDocument> findTempDocumentLeaveByMaritimeCodeAndDateFromAndDateTo(
		java.lang.String maritimeCode, java.lang.String dateFrom,
		java.lang.String dateTo, java.lang.String documentTypeCode,
		java.lang.String requestState, java.lang.String documentStatusCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findTempDocumentLeaveByMaritimeCodeAndDateFromAndDateTo(maritimeCode,
			dateFrom, dateTo, documentTypeCode, requestState, documentStatusCode);
	}

	public static java.util.List<vn.gt.dao.noticeandmessage.model.TempDocument> findTemDocumentByDocumentNameAndDocumentYear(
		long documentName, int documentYear)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findTemDocumentByDocumentNameAndDocumentYear(documentName,
			documentYear);
	}

	public static vn.gt.dao.noticeandmessage.model.TempDocument findTemDocumentByDocumentNameDocumentYear(
		long documentName, int documentYear)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findTemDocumentByDocumentNameDocumentYear(documentName,
			documentYear);
	}

	public static java.util.List<vn.gt.dao.noticeandmessage.model.TempDocument> findTempDocumentByKeHoach(
		java.lang.String requestState, java.lang.String documentTypeCode,
		java.lang.String maritimeCode, java.lang.String shipName,
		java.lang.String positionCode, java.lang.String portRegionCode,
		java.lang.String mabankhai, java.lang.String stateCode,
		java.lang.String shipDateFromStart, java.lang.String shipDateFromEnd,
		java.lang.String shipDateToStart, java.lang.String shipDateToEnd,
		java.lang.String callSign, java.lang.String imo,
		java.lang.String ngayLamThuTucFrom, java.lang.String ngayLamThuTucTo,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findTempDocumentByKeHoach(requestState, documentTypeCode,
			maritimeCode, shipName, positionCode, portRegionCode, mabankhai,
			stateCode, shipDateFromStart, shipDateFromEnd, shipDateToStart,
			shipDateToEnd, callSign, imo, ngayLamThuTucFrom, ngayLamThuTucTo,
			start, end);
	}

	public static java.util.List<vn.gt.dao.noticeandmessage.model.TempDocument> findTempDocumentByDocumentStatusCode(
		java.lang.String documentStatusCode, java.lang.String documentTypeCode,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findTempDocumentByDocumentStatusCode(documentStatusCode,
			documentTypeCode, start, end);
	}

	public static java.util.List<vn.gt.dao.noticeandmessage.model.TempDocument> findTempDocumentByRequestState(
		java.lang.String requestState, java.lang.String documentTypeCode,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findTempDocumentByRequestState(requestState,
			documentTypeCode, start, end);
	}

	public static int countTempDocumentByRequestState(
		java.lang.String requestState, java.lang.String documentTypeCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countTempDocumentByRequestState(requestState,
			documentTypeCode);
	}

	public static int countTempDocumentByKeHoach(
		java.lang.String requestState, java.lang.String documentTypeCode,
		java.lang.String maritimeCode, java.lang.String shipName,
		java.lang.String positionCode, java.lang.String portRegionCode,
		java.lang.String mabankhai, java.lang.String stateCode,
		java.lang.String shipDateFromStart, java.lang.String shipDateFromEnd,
		java.lang.String shipDateToStart, java.lang.String shipDateToEnd,
		java.lang.String callSign, java.lang.String imo,
		java.lang.String ngayLamThuTucFrom, java.lang.String ngayLamThuTucTo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countTempDocumentByKeHoach(requestState, documentTypeCode,
			maritimeCode, shipName, positionCode, portRegionCode, mabankhai,
			stateCode, shipDateFromStart, shipDateFromEnd, shipDateToStart,
			shipDateToEnd, callSign, imo, ngayLamThuTucFrom, ngayLamThuTucTo);
	}

	public static java.util.List<vn.gt.dao.noticeandmessage.model.TempDocument> findTempDocumentByThuTuc(
		java.lang.String documentTypeCode, java.lang.String documentName,
		java.lang.String documentYear, java.lang.String maLoaiHoSo,
		java.lang.String shipName, java.lang.String shipTypeCode,
		java.lang.String stateCode, java.lang.String shipCaptain,
		java.lang.String callSign, java.lang.String userCreated, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findTempDocumentByThuTuc(documentTypeCode, documentName,
			documentYear, maLoaiHoSo, shipName, shipTypeCode, stateCode,
			shipCaptain, callSign, userCreated, start, end);
	}

	public static int countTempDocumentByThuTuc(
		java.lang.String documentTypeCode, java.lang.String documentName,
		java.lang.String documentYear, java.lang.String maLoaiHoSo,
		java.lang.String shipName, java.lang.String shipTypeCode,
		java.lang.String stateCode, java.lang.String shipCaptain,
		java.lang.String callSign, java.lang.String userCreated)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countTempDocumentByThuTuc(documentTypeCode, documentName,
			documentYear, maLoaiHoSo, shipName, shipTypeCode, stateCode,
			shipCaptain, callSign, userCreated);
	}

	public static java.util.List<vn.gt.dao.noticeandmessage.model.TempDocument> findDanhSachHoSoRoleThuTuc(
		java.lang.String documentTypeCode, java.lang.String maritimeCode,
		java.lang.String portCode, java.lang.String lastPortCode,
		java.lang.String shipName, java.lang.String stateCode,
		java.lang.String callSign, java.lang.String imo,
		java.lang.String shipPosition, java.lang.String shipDateFromStart,
		java.lang.String shipDateFromEnd, java.lang.String shipDateToStart,
		java.lang.String shipDateToEnd, java.lang.String documentStatusCode,
		java.lang.String arrivalShipAgency,
		java.lang.String nameArrivalShipAgency,
		java.lang.String departureShipAgency,
		java.lang.String nameDepartureShipAgency,
		java.lang.String portRegionCode, java.lang.String ngayLamThuTucFrom,
		java.lang.String ngayLamThuTucTo, java.lang.String maBanKhai,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findDanhSachHoSoRoleThuTuc(documentTypeCode, maritimeCode,
			portCode, lastPortCode, shipName, stateCode, callSign, imo,
			shipPosition, shipDateFromStart, shipDateFromEnd, shipDateToStart,
			shipDateToEnd, documentStatusCode, arrivalShipAgency,
			nameArrivalShipAgency, departureShipAgency,
			nameDepartureShipAgency, portRegionCode, ngayLamThuTucFrom,
			ngayLamThuTucTo, maBanKhai, start, end);
	}

	public static java.util.List<vn.gt.dao.noticeandmessage.model.TempDocument> findDanhSachHoSoRoleThuTucLikeShipAgency(
		java.lang.String documentTypeCode, java.lang.String maritimeCode,
		java.lang.String portCode, java.lang.String lastPortCode,
		java.lang.String shipName, java.lang.String stateCode,
		java.lang.String callSign, java.lang.String imo,
		java.lang.String shipPosition, java.lang.String shipDateFromStart,
		java.lang.String shipDateFromEnd, java.lang.String shipDateToStart,
		java.lang.String shipDateToEnd, java.lang.String documentStatusCode,
		java.lang.String arrivalShipAgency,
		java.lang.String nameArrivalShipAgency,
		java.lang.String departureShipAgency,
		java.lang.String nameDepartureShipAgency,
		java.lang.String portRegionCode, java.lang.String ngayLamThuTucFrom,
		java.lang.String ngayLamThuTucTo, java.lang.String maBanKhai,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findDanhSachHoSoRoleThuTucLikeShipAgency(documentTypeCode,
			maritimeCode, portCode, lastPortCode, shipName, stateCode,
			callSign, imo, shipPosition, shipDateFromStart, shipDateFromEnd,
			shipDateToStart, shipDateToEnd, documentStatusCode,
			arrivalShipAgency, nameArrivalShipAgency, departureShipAgency,
			nameDepartureShipAgency, portRegionCode, ngayLamThuTucFrom,
			ngayLamThuTucTo, maBanKhai, start, end);
	}

	public static int countDanhSachHoSoRoleThuTuc(
		java.lang.String documentTypeCode, java.lang.String maritimeCode,
		java.lang.String portCode, java.lang.String lastPortCode,
		java.lang.String shipName, java.lang.String stateCode,
		java.lang.String callSign, java.lang.String imo,
		java.lang.String shipPosition, java.lang.String shipDateFromStart,
		java.lang.String shipDateFromEnd, java.lang.String shipDateToStart,
		java.lang.String shipDateToEnd, java.lang.String documentStatusCode,
		java.lang.String arrivalShipAgency,
		java.lang.String nameArrivalShipAgency,
		java.lang.String departureShipAgency,
		java.lang.String nameDepartureShipAgency,
		java.lang.String portRegionCode, java.lang.String ngayLamThuTucFrom,
		java.lang.String ngayLamThuTucTo, java.lang.String maBanKhai)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countDanhSachHoSoRoleThuTuc(documentTypeCode, maritimeCode,
			portCode, lastPortCode, shipName, stateCode, callSign, imo,
			shipPosition, shipDateFromStart, shipDateFromEnd, shipDateToStart,
			shipDateToEnd, documentStatusCode, arrivalShipAgency,
			nameArrivalShipAgency, departureShipAgency,
			nameDepartureShipAgency, portRegionCode, ngayLamThuTucFrom,
			ngayLamThuTucTo, maBanKhai);
	}

	public static int countDanhSachHoSoRoleThuTucLikeShipAgency(
		java.lang.String documentTypeCode, java.lang.String maritimeCode,
		java.lang.String portCode, java.lang.String lastPortCode,
		java.lang.String shipName, java.lang.String stateCode,
		java.lang.String callSign, java.lang.String imo,
		java.lang.String shipPosition, java.lang.String shipDateFromStart,
		java.lang.String shipDateFromEnd, java.lang.String shipDateToStart,
		java.lang.String shipDateToEnd, java.lang.String documentStatusCode,
		java.lang.String arrivalShipAgency,
		java.lang.String nameArrivalShipAgency,
		java.lang.String departureShipAgency,
		java.lang.String nameDepartureShipAgency,
		java.lang.String portRegionCode, java.lang.String ngayLamThuTucFrom,
		java.lang.String ngayLamThuTucTo, java.lang.String maBanKhai)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countDanhSachHoSoRoleThuTucLikeShipAgency(documentTypeCode,
			maritimeCode, portCode, lastPortCode, shipName, stateCode,
			callSign, imo, shipPosition, shipDateFromStart, shipDateFromEnd,
			shipDateToStart, shipDateToEnd, documentStatusCode,
			arrivalShipAgency, nameArrivalShipAgency, departureShipAgency,
			nameDepartureShipAgency, portRegionCode, ngayLamThuTucFrom,
			ngayLamThuTucTo, maBanKhai);
	}

	public static java.util.List<vn.gt.dao.noticeandmessage.model.TempDocument> findTempDocumentInfo(
		java.lang.String documentStatusCode, java.lang.String maritimeCode,
		java.lang.String portCode, java.lang.String shipName,
		java.lang.String callSign, java.lang.String shipDateFrom,
		java.lang.String shipDateTo, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findTempDocumentInfo(documentStatusCode, maritimeCode,
			portCode, shipName, callSign, shipDateFrom, shipDateTo, start, end);
	}

	public static int countTempDocumentInfo(
		java.lang.String documentStatusCode, java.lang.String maritimeCode,
		java.lang.String portCode, java.lang.String shipName,
		java.lang.String callSign, java.lang.String shipDateFrom,
		java.lang.String shipDateTo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countTempDocumentInfo(documentStatusCode, maritimeCode,
			portCode, shipName, callSign, shipDateFrom, shipDateTo);
	}

	public static java.util.List<vn.gt.dao.noticeandmessage.model.TempDocument> findKeHoachYCBS()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findKeHoachYCBS();
	}

	public static TempDocumentFinder getFinder() {
		if (_finder == null) {
			_finder = (TempDocumentFinder)PortletBeanLocatorUtil.locate(vn.gt.dao.noticeandmessage.service.ClpSerializer.getServletContextName(),
					TempDocumentFinder.class.getName());

			ReferenceRegistry.registerReference(TempDocumentFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(TempDocumentFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(TempDocumentFinderUtil.class,
			"_finder");
	}

	private static TempDocumentFinder _finder;
}