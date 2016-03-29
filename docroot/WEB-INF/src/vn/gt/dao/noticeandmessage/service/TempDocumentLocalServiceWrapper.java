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

package vn.gt.dao.noticeandmessage.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link TempDocumentLocalService}.
 * </p>
 *
 * @author    win_64
 * @see       TempDocumentLocalService
 * @generated
 */
public class TempDocumentLocalServiceWrapper implements TempDocumentLocalService,
	ServiceWrapper<TempDocumentLocalService> {
	public TempDocumentLocalServiceWrapper(
		TempDocumentLocalService tempDocumentLocalService) {
		_tempDocumentLocalService = tempDocumentLocalService;
	}

	/**
	* Adds the temp document to the database. Also notifies the appropriate model listeners.
	*
	* @param tempDocument the temp document
	* @return the temp document that was added
	* @throws SystemException if a system exception occurred
	*/
	public vn.gt.dao.noticeandmessage.model.TempDocument addTempDocument(
		vn.gt.dao.noticeandmessage.model.TempDocument tempDocument)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tempDocumentLocalService.addTempDocument(tempDocument);
	}

	/**
	* Creates a new temp document with the primary key. Does not add the temp document to the database.
	*
	* @param id the primary key for the new temp document
	* @return the new temp document
	*/
	public vn.gt.dao.noticeandmessage.model.TempDocument createTempDocument(
		long id) {
		return _tempDocumentLocalService.createTempDocument(id);
	}

	/**
	* Deletes the temp document with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the temp document
	* @throws PortalException if a temp document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteTempDocument(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_tempDocumentLocalService.deleteTempDocument(id);
	}

	/**
	* Deletes the temp document from the database. Also notifies the appropriate model listeners.
	*
	* @param tempDocument the temp document
	* @throws SystemException if a system exception occurred
	*/
	public void deleteTempDocument(
		vn.gt.dao.noticeandmessage.model.TempDocument tempDocument)
		throws com.liferay.portal.kernel.exception.SystemException {
		_tempDocumentLocalService.deleteTempDocument(tempDocument);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tempDocumentLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _tempDocumentLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tempDocumentLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tempDocumentLocalService.dynamicQueryCount(dynamicQuery);
	}

	public vn.gt.dao.noticeandmessage.model.TempDocument fetchTempDocument(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return _tempDocumentLocalService.fetchTempDocument(id);
	}

	/**
	* Returns the temp document with the primary key.
	*
	* @param id the primary key of the temp document
	* @return the temp document
	* @throws PortalException if a temp document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.gt.dao.noticeandmessage.model.TempDocument getTempDocument(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tempDocumentLocalService.getTempDocument(id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tempDocumentLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the temp documents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of temp documents
	* @param end the upper bound of the range of temp documents (not inclusive)
	* @return the range of temp documents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.gt.dao.noticeandmessage.model.TempDocument> getTempDocuments(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tempDocumentLocalService.getTempDocuments(start, end);
	}

	/**
	* Returns the number of temp documents.
	*
	* @return the number of temp documents
	* @throws SystemException if a system exception occurred
	*/
	public int getTempDocumentsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tempDocumentLocalService.getTempDocumentsCount();
	}

	/**
	* Updates the temp document in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tempDocument the temp document
	* @return the temp document that was updated
	* @throws SystemException if a system exception occurred
	*/
	public vn.gt.dao.noticeandmessage.model.TempDocument updateTempDocument(
		vn.gt.dao.noticeandmessage.model.TempDocument tempDocument)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tempDocumentLocalService.updateTempDocument(tempDocument);
	}

	/**
	* Updates the temp document in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tempDocument the temp document
	* @param merge whether to merge the temp document with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the temp document that was updated
	* @throws SystemException if a system exception occurred
	*/
	public vn.gt.dao.noticeandmessage.model.TempDocument updateTempDocument(
		vn.gt.dao.noticeandmessage.model.TempDocument tempDocument,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tempDocumentLocalService.updateTempDocument(tempDocument, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _tempDocumentLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_tempDocumentLocalService.setBeanIdentifier(beanIdentifier);
	}

	public vn.gt.dao.noticeandmessage.model.TempDocument getTemDocumentByRequestCode(
		java.lang.String requestCode) {
		return _tempDocumentLocalService.getTemDocumentByRequestCode(requestCode);
	}

	public vn.gt.dao.noticeandmessage.model.TempDocument getByDocumentNameAndDocumentYear(
		long documentName, int documentYear) throws java.lang.Exception {
		return _tempDocumentLocalService.getByDocumentNameAndDocumentYear(documentName,
			documentYear);
	}

	public java.lang.String getCallSignByDocumentNameAndDocumentYear(
		long documentName, int documentYear) {
		return _tempDocumentLocalService.getCallSignByDocumentNameAndDocumentYear(documentName,
			documentYear);
	}

	public java.util.List<vn.gt.dao.noticeandmessage.model.TempDocument> findTemDocumentByDocumentNameAndDocumentYear(
		long documentName, int documentYear) {
		return _tempDocumentLocalService.findTemDocumentByDocumentNameAndDocumentYear(documentName,
			documentYear);
	}

	public java.util.List<vn.gt.dao.noticeandmessage.model.TempDocument> findTempDocumentArivalByMaritimeCodeAndDateFromAndDateTo(
		java.lang.String maritimeCode, java.lang.String dateFrom,
		java.lang.String dateTo, java.lang.String documentTypeCode,
		java.lang.String requestState, java.lang.String documentStatusCode) {
		return _tempDocumentLocalService.findTempDocumentArivalByMaritimeCodeAndDateFromAndDateTo(maritimeCode,
			dateFrom, dateTo, documentTypeCode, requestState, documentStatusCode);
	}

	public java.util.List<vn.gt.dao.noticeandmessage.model.TempDocument> findTempDocumentLeaveByMaritimeCodeAndDateFromAndDateTo(
		java.lang.String maritimeCode, java.lang.String dateFrom,
		java.lang.String dateTo, java.lang.String documentTypeCode,
		java.lang.String requestState, java.lang.String documentStatusCode) {
		return _tempDocumentLocalService.findTempDocumentLeaveByMaritimeCodeAndDateFromAndDateTo(maritimeCode,
			dateFrom, dateTo, documentTypeCode, requestState, documentStatusCode);
	}

	public long countTempDocumentForStatisticsReport(
		java.lang.String maritimeCode, java.lang.String dateFrom,
		java.lang.String dateTo, java.lang.String documentTypeCode,
		java.lang.String requestState, java.lang.String documentStatusCode) {
		return _tempDocumentLocalService.countTempDocumentForStatisticsReport(maritimeCode,
			dateFrom, dateTo, documentTypeCode, requestState, documentStatusCode);
	}

	public java.util.List<vn.gt.portlet.baocaotichhop.thongke.dvcong.FlowChartDataByDate> countTempDocumentForStatisticsByDate(
		java.lang.String maritimeCode, java.lang.String dateFrom,
		java.lang.String dateTo, java.lang.String documentTypeCode,
		java.lang.String requestState, java.lang.String documentStatusCode) {
		return _tempDocumentLocalService.countTempDocumentForStatisticsByDate(maritimeCode,
			dateFrom, dateTo, documentTypeCode, requestState, documentStatusCode);
	}

	public long countTempDocumentJoinIssueShiftingOrderForStatisticsReport(
		java.lang.String maritimeCode, java.lang.String dateFrom,
		java.lang.String dateTo, java.lang.String documentTypeCode,
		java.lang.String requestState, java.lang.String issRequestState,
		java.lang.String documentStatusCode) {
		return _tempDocumentLocalService.countTempDocumentJoinIssueShiftingOrderForStatisticsReport(maritimeCode,
			dateFrom, dateTo, documentTypeCode, requestState, issRequestState,
			documentStatusCode);
	}

	public long countTempDocumentJoinIssuePermissionTransitForStatisticsReport(
		java.lang.String maritimeCode, java.lang.String dateFrom,
		java.lang.String dateTo, java.lang.String documentTypeCode,
		java.lang.String requestState, java.lang.String issRequestState,
		java.lang.String documentStatusCode) {
		return _tempDocumentLocalService.countTempDocumentJoinIssuePermissionTransitForStatisticsReport(maritimeCode,
			dateFrom, dateTo, documentTypeCode, requestState, issRequestState,
			documentStatusCode);
	}

	public long countTempDocumentJoinIssuePortClearanceForStatisticsReport(
		java.lang.String maritimeCode, java.lang.String dateFrom,
		java.lang.String dateTo, java.lang.String documentTypeCode,
		java.lang.String requestState, java.lang.String issRequestState,
		java.lang.String documentStatusCode) {
		return _tempDocumentLocalService.countTempDocumentJoinIssuePortClearanceForStatisticsReport(maritimeCode,
			dateFrom, dateTo, documentTypeCode, requestState, issRequestState,
			documentStatusCode);
	}

	public vn.gt.dao.noticeandmessage.model.TempDocument findTemDocumentByDocumentNameDocumentYear(
		long documentName, int documentYear) {
		return _tempDocumentLocalService.findTemDocumentByDocumentNameDocumentYear(documentName,
			documentYear);
	}

	public java.util.List<vn.gt.dao.noticeandmessage.model.TempDocument> findTempDocumentByRequestState(
		java.lang.String requestState, java.lang.String documentTypeCode,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tempDocumentLocalService.findTempDocumentByRequestState(requestState,
			documentTypeCode, start, end);
	}

	public int countTempDocumentByRequestState(java.lang.String requestState,
		java.lang.String documentTypeCode) {
		return _tempDocumentLocalService.countTempDocumentByRequestState(requestState,
			documentTypeCode);
	}

	public java.util.List<vn.gt.dao.noticeandmessage.model.TempDocument> findTempDocumentByDocumentStatusCode(
		java.lang.String documentStatusCode, java.lang.String documentTypeCode,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tempDocumentLocalService.findTempDocumentByDocumentStatusCode(documentStatusCode,
			documentTypeCode, start, end);
	}

	public int countTempDocumentByDocumentStatusCode(
		java.lang.String documentStatusCode, java.lang.String documentTypeCode) {
		return _tempDocumentLocalService.countTempDocumentByDocumentStatusCode(documentStatusCode,
			documentTypeCode);
	}

	public java.util.List<vn.gt.dao.noticeandmessage.model.TempDocument> findTempDocumentByKeHoach(
		java.lang.String requestState, java.lang.String documentTypeCode,
		java.lang.String maritimeCode, java.lang.String shipName,
		java.lang.String positionCode, java.lang.String portRegionCode,
		java.lang.String mabankhai, java.lang.String stateCode,
		java.lang.String shipDateFromStart, java.lang.String shipDateFromEnd,
		java.lang.String shipDateToStart, java.lang.String shipDateToEnd,
		java.lang.String callSign, java.lang.String imo,
		java.lang.String ngayLamThuTucFrom, java.lang.String ngayLamThuTucTo,
		int start, int end) {
		return _tempDocumentLocalService.findTempDocumentByKeHoach(requestState,
			documentTypeCode, maritimeCode, shipName, positionCode,
			portRegionCode, mabankhai, stateCode, shipDateFromStart,
			shipDateFromEnd, shipDateToStart, shipDateToEnd, callSign, imo,
			ngayLamThuTucFrom, ngayLamThuTucTo, start, end);
	}

	public int countTempDocumentByKeHoach(java.lang.String requestState,
		java.lang.String documentTypeCode, java.lang.String maritimeCode,
		java.lang.String shipName, java.lang.String positionCode,
		java.lang.String portRegionCode, java.lang.String mabankhai,
		java.lang.String stateCode, java.lang.String shipDateFromStart,
		java.lang.String shipDateFromEnd, java.lang.String shipDateToStart,
		java.lang.String shipDateToEnd, java.lang.String callSign,
		java.lang.String imo, java.lang.String ngayLamThuTucFrom,
		java.lang.String ngayLamThuTucTo) {
		return _tempDocumentLocalService.countTempDocumentByKeHoach(requestState,
			documentTypeCode, maritimeCode, shipName, positionCode,
			portRegionCode, mabankhai, stateCode, shipDateFromStart,
			shipDateFromEnd, shipDateToStart, shipDateToEnd, callSign, imo,
			ngayLamThuTucFrom, ngayLamThuTucTo);
	}

	public java.util.List<vn.gt.dao.noticeandmessage.model.TempDocument> findAll(
		int start, int end) {
		return _tempDocumentLocalService.findAll(start, end);
	}

	public int countAll() {
		return _tempDocumentLocalService.countAll();
	}

	public java.util.List<vn.gt.dao.noticeandmessage.model.TempDocument> findTempDocumentByThuTuc(
		java.lang.String documentTypeCode, java.lang.String documentName,
		java.lang.String documentYear, java.lang.String maLoaiHoSo,
		java.lang.String shipName, java.lang.String shipTypeCode,
		java.lang.String stateCode, java.lang.String shipCaptain,
		java.lang.String callSign, java.lang.String userCreated, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _tempDocumentLocalService.findTempDocumentByThuTuc(documentTypeCode,
			documentName, documentYear, maLoaiHoSo, shipName, shipTypeCode,
			stateCode, shipCaptain, callSign, userCreated, start, end);
	}

	public int countTempDocumentByThuTuc(java.lang.String documentTypeCode,
		java.lang.String documentName, java.lang.String documentYear,
		java.lang.String maLoaiHoSo, java.lang.String shipName,
		java.lang.String shipTypeCode, java.lang.String stateCode,
		java.lang.String shipCaptain, java.lang.String callSign,
		java.lang.String userCreated)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tempDocumentLocalService.countTempDocumentByThuTuc(documentTypeCode,
			documentName, documentYear, maLoaiHoSo, shipName, shipTypeCode,
			stateCode, shipCaptain, callSign, userCreated);
	}

	public java.util.List<vn.gt.dao.noticeandmessage.model.TempDocument> findDanhSachHoSoRoleThuTuc(
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
		return _tempDocumentLocalService.findDanhSachHoSoRoleThuTuc(documentTypeCode,
			maritimeCode, portCode, lastPortCode, shipName, stateCode,
			callSign, imo, shipPosition, shipDateFromStart, shipDateFromEnd,
			shipDateToStart, shipDateToEnd, documentStatusCode,
			arrivalShipAgency, nameArrivalShipAgency, departureShipAgency,
			nameDepartureShipAgency, portRegionCode, ngayLamThuTucFrom,
			ngayLamThuTucTo, maBanKhai, start, end);
	}

	public int countDanhSachHoSoRoleThuTuc(java.lang.String documentTypeCode,
		java.lang.String maritimeCode, java.lang.String portCode,
		java.lang.String lastPortCode, java.lang.String shipName,
		java.lang.String stateCode, java.lang.String callSign,
		java.lang.String imo, java.lang.String shipPosition,
		java.lang.String shipDateFromStart, java.lang.String shipDateFromEnd,
		java.lang.String shipDateToStart, java.lang.String shipDateToEnd,
		java.lang.String documentStatusCode,
		java.lang.String arrivalShipAgency,
		java.lang.String nameArrivalShipAgency,
		java.lang.String departureShipAgency,
		java.lang.String nameDepartureShipAgency,
		java.lang.String portRegionCode, java.lang.String ngayLamThuTucFrom,
		java.lang.String ngayLamThuTucTo, java.lang.String maBanKhai)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tempDocumentLocalService.countDanhSachHoSoRoleThuTuc(documentTypeCode,
			maritimeCode, portCode, lastPortCode, shipName, stateCode,
			callSign, imo, shipPosition, shipDateFromStart, shipDateFromEnd,
			shipDateToStart, shipDateToEnd, documentStatusCode,
			arrivalShipAgency, nameArrivalShipAgency, departureShipAgency,
			nameDepartureShipAgency, portRegionCode, ngayLamThuTucFrom,
			ngayLamThuTucTo, maBanKhai);
	}

	public java.util.List<vn.gt.dao.noticeandmessage.model.TempDocument> findTempDocumentInfo(
		java.lang.String documentStatusCode, java.lang.String maritimeCode,
		java.lang.String portCode, java.lang.String shipName,
		java.lang.String callSign, java.lang.String shipDateFrom,
		java.lang.String shipDateTo, int start, int end) {
		return _tempDocumentLocalService.findTempDocumentInfo(documentStatusCode,
			maritimeCode, portCode, shipName, callSign, shipDateFrom,
			shipDateTo, start, end);
	}

	public int countTempDocumentInfo(java.lang.String documentStatusCode,
		java.lang.String maritimeCode, java.lang.String portCode,
		java.lang.String shipName, java.lang.String callSign,
		java.lang.String shipDateFrom, java.lang.String shipDateTo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tempDocumentLocalService.countTempDocumentInfo(documentStatusCode,
			maritimeCode, portCode, shipName, callSign, shipDateFrom, shipDateTo);
	}

	public java.util.List<vn.gt.dao.noticeandmessage.model.TempDocument> findKeHoachYCBS()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tempDocumentLocalService.findKeHoachYCBS();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public TempDocumentLocalService getWrappedTempDocumentLocalService() {
		return _tempDocumentLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedTempDocumentLocalService(
		TempDocumentLocalService tempDocumentLocalService) {
		_tempDocumentLocalService = tempDocumentLocalService;
	}

	public TempDocumentLocalService getWrappedService() {
		return _tempDocumentLocalService;
	}

	public void setWrappedService(
		TempDocumentLocalService tempDocumentLocalService) {
		_tempDocumentLocalService = tempDocumentLocalService;
	}

	private TempDocumentLocalService _tempDocumentLocalService;
}