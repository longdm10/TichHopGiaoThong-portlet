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

import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * @author win_64
 */
public class TempDocumentLocalServiceClp implements TempDocumentLocalService {
	public TempDocumentLocalServiceClp(ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;

		_addTempDocumentMethodKey0 = new MethodKey(_classLoaderProxy.getClassName(),
				"addTempDocument",
				vn.gt.dao.noticeandmessage.model.TempDocument.class);

		_createTempDocumentMethodKey1 = new MethodKey(_classLoaderProxy.getClassName(),
				"createTempDocument", long.class);

		_deleteTempDocumentMethodKey2 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteTempDocument", long.class);

		_deleteTempDocumentMethodKey3 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteTempDocument",
				vn.gt.dao.noticeandmessage.model.TempDocument.class);

		_dynamicQueryMethodKey4 = new MethodKey(_classLoaderProxy.getClassName(),
				"dynamicQuery",
				com.liferay.portal.kernel.dao.orm.DynamicQuery.class);

		_dynamicQueryMethodKey5 = new MethodKey(_classLoaderProxy.getClassName(),
				"dynamicQuery",
				com.liferay.portal.kernel.dao.orm.DynamicQuery.class,
				int.class, int.class);

		_dynamicQueryMethodKey6 = new MethodKey(_classLoaderProxy.getClassName(),
				"dynamicQuery",
				com.liferay.portal.kernel.dao.orm.DynamicQuery.class,
				int.class, int.class,
				com.liferay.portal.kernel.util.OrderByComparator.class);

		_dynamicQueryCountMethodKey7 = new MethodKey(_classLoaderProxy.getClassName(),
				"dynamicQueryCount",
				com.liferay.portal.kernel.dao.orm.DynamicQuery.class);

		_fetchTempDocumentMethodKey8 = new MethodKey(_classLoaderProxy.getClassName(),
				"fetchTempDocument", long.class);

		_getTempDocumentMethodKey9 = new MethodKey(_classLoaderProxy.getClassName(),
				"getTempDocument", long.class);

		_getPersistedModelMethodKey10 = new MethodKey(_classLoaderProxy.getClassName(),
				"getPersistedModel", java.io.Serializable.class);

		_getTempDocumentsMethodKey11 = new MethodKey(_classLoaderProxy.getClassName(),
				"getTempDocuments", int.class, int.class);

		_getTempDocumentsCountMethodKey12 = new MethodKey(_classLoaderProxy.getClassName(),
				"getTempDocumentsCount");

		_updateTempDocumentMethodKey13 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateTempDocument",
				vn.gt.dao.noticeandmessage.model.TempDocument.class);

		_updateTempDocumentMethodKey14 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateTempDocument",
				vn.gt.dao.noticeandmessage.model.TempDocument.class,
				boolean.class);

		_getBeanIdentifierMethodKey15 = new MethodKey(_classLoaderProxy.getClassName(),
				"getBeanIdentifier");

		_setBeanIdentifierMethodKey16 = new MethodKey(_classLoaderProxy.getClassName(),
				"setBeanIdentifier", java.lang.String.class);

		_getTemDocumentByRequestCodeMethodKey17 = new MethodKey(_classLoaderProxy.getClassName(),
				"getTemDocumentByRequestCode", java.lang.String.class);

		_getByDocumentNameAndDocumentYearMethodKey18 = new MethodKey(_classLoaderProxy.getClassName(),
				"getByDocumentNameAndDocumentYear", long.class, int.class);

		_getCallSignByDocumentNameAndDocumentYearMethodKey19 = new MethodKey(_classLoaderProxy.getClassName(),
				"getCallSignByDocumentNameAndDocumentYear", long.class,
				int.class);

		_findTemDocumentByDocumentNameAndDocumentYearMethodKey20 = new MethodKey(_classLoaderProxy.getClassName(),
				"findTemDocumentByDocumentNameAndDocumentYear", long.class,
				int.class);

		_findTempDocumentArivalByMaritimeCodeAndDateFromAndDateToMethodKey21 = new MethodKey(_classLoaderProxy.getClassName(),
				"findTempDocumentArivalByMaritimeCodeAndDateFromAndDateTo",
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class);

		_findTempDocumentLeaveByMaritimeCodeAndDateFromAndDateToMethodKey22 = new MethodKey(_classLoaderProxy.getClassName(),
				"findTempDocumentLeaveByMaritimeCodeAndDateFromAndDateTo",
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class);

		_countTempDocumentForStatisticsReportMethodKey23 = new MethodKey(_classLoaderProxy.getClassName(),
				"countTempDocumentForStatisticsReport", java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class);

		_countTempDocumentForStatisticsByDateMethodKey24 = new MethodKey(_classLoaderProxy.getClassName(),
				"countTempDocumentForStatisticsByDate", java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class);

		_countTempDocumentJoinIssueShiftingOrderForStatisticsReportMethodKey25 = new MethodKey(_classLoaderProxy.getClassName(),
				"countTempDocumentJoinIssueShiftingOrderForStatisticsReport",
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class);

		_countTempDocumentJoinIssuePermissionTransitForStatisticsReportMethodKey26 = new MethodKey(_classLoaderProxy.getClassName(),
				"countTempDocumentJoinIssuePermissionTransitForStatisticsReport",
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class);

		_countTempDocumentJoinIssuePortClearanceForStatisticsReportMethodKey27 = new MethodKey(_classLoaderProxy.getClassName(),
				"countTempDocumentJoinIssuePortClearanceForStatisticsReport",
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class);

		_findTemDocumentByDocumentNameDocumentYearMethodKey28 = new MethodKey(_classLoaderProxy.getClassName(),
				"findTemDocumentByDocumentNameDocumentYear", long.class,
				int.class);

		_findTempDocumentByRequestStateMethodKey29 = new MethodKey(_classLoaderProxy.getClassName(),
				"findTempDocumentByRequestState", java.lang.String.class,
				java.lang.String.class, int.class, int.class);

		_countTempDocumentByRequestStateMethodKey30 = new MethodKey(_classLoaderProxy.getClassName(),
				"countTempDocumentByRequestState", java.lang.String.class,
				java.lang.String.class);

		_findTempDocumentByDocumentStatusCodeMethodKey31 = new MethodKey(_classLoaderProxy.getClassName(),
				"findTempDocumentByDocumentStatusCode", java.lang.String.class,
				java.lang.String.class, int.class, int.class);

		_countTempDocumentByDocumentStatusCodeMethodKey32 = new MethodKey(_classLoaderProxy.getClassName(),
				"countTempDocumentByDocumentStatusCode",
				java.lang.String.class, java.lang.String.class);

		_findTempDocumentByKeHoachMethodKey33 = new MethodKey(_classLoaderProxy.getClassName(),
				"findTempDocumentByKeHoach", java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, int.class, int.class);

		_countTempDocumentByKeHoachMethodKey34 = new MethodKey(_classLoaderProxy.getClassName(),
				"countTempDocumentByKeHoach", java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class);

		_findAllMethodKey35 = new MethodKey(_classLoaderProxy.getClassName(),
				"findAll", int.class, int.class);

		_countAllMethodKey36 = new MethodKey(_classLoaderProxy.getClassName(),
				"countAll");

		_findTempDocumentByThuTucMethodKey37 = new MethodKey(_classLoaderProxy.getClassName(),
				"findTempDocumentByThuTuc", java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, int.class, int.class);

		_countTempDocumentByThuTucMethodKey38 = new MethodKey(_classLoaderProxy.getClassName(),
				"countTempDocumentByThuTuc", java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class);

		_findDanhSachHoSoRoleThuTucMethodKey39 = new MethodKey(_classLoaderProxy.getClassName(),
				"findDanhSachHoSoRoleThuTuc", java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, int.class, int.class);

		_countDanhSachHoSoRoleThuTucMethodKey40 = new MethodKey(_classLoaderProxy.getClassName(),
				"countDanhSachHoSoRoleThuTuc", java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class);

		_findTempDocumentInfoMethodKey41 = new MethodKey(_classLoaderProxy.getClassName(),
				"findTempDocumentInfo", java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class, int.class,
				int.class);

		_countTempDocumentInfoMethodKey42 = new MethodKey(_classLoaderProxy.getClassName(),
				"countTempDocumentInfo", java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class);

		_findKeHoachYCBSMethodKey43 = new MethodKey(_classLoaderProxy.getClassName(),
				"findKeHoachYCBS");
	}

	public vn.gt.dao.noticeandmessage.model.TempDocument addTempDocument(
		vn.gt.dao.noticeandmessage.model.TempDocument tempDocument)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addTempDocumentMethodKey0,
				ClpSerializer.translateInput(tempDocument));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (vn.gt.dao.noticeandmessage.model.TempDocument)ClpSerializer.translateOutput(returnObj);
	}

	public vn.gt.dao.noticeandmessage.model.TempDocument createTempDocument(
		long id) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_createTempDocumentMethodKey1,
				id);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (vn.gt.dao.noticeandmessage.model.TempDocument)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteTempDocument(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteTempDocumentMethodKey2,
				id);

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public void deleteTempDocument(
		vn.gt.dao.noticeandmessage.model.TempDocument tempDocument)
		throws com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteTempDocumentMethodKey3,
				ClpSerializer.translateInput(tempDocument));

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_dynamicQueryMethodKey4,
				ClpSerializer.translateInput(dynamicQuery));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_dynamicQueryMethodKey5,
				ClpSerializer.translateInput(dynamicQuery), start, end);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_dynamicQueryMethodKey6,
				ClpSerializer.translateInput(dynamicQuery), start, end,
				ClpSerializer.translateInput(orderByComparator));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_dynamicQueryCountMethodKey7,
				ClpSerializer.translateInput(dynamicQuery));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Long)returnObj).longValue();
	}

	public vn.gt.dao.noticeandmessage.model.TempDocument fetchTempDocument(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_fetchTempDocumentMethodKey8,
				id);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (vn.gt.dao.noticeandmessage.model.TempDocument)ClpSerializer.translateOutput(returnObj);
	}

	public vn.gt.dao.noticeandmessage.model.TempDocument getTempDocument(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getTempDocumentMethodKey9,
				id);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (vn.gt.dao.noticeandmessage.model.TempDocument)ClpSerializer.translateOutput(returnObj);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getPersistedModelMethodKey10,
				ClpSerializer.translateInput(primaryKeyObj));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.portal.model.PersistedModel)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<vn.gt.dao.noticeandmessage.model.TempDocument> getTempDocuments(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getTempDocumentsMethodKey11,
				start, end);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<vn.gt.dao.noticeandmessage.model.TempDocument>)ClpSerializer.translateOutput(returnObj);
	}

	public int getTempDocumentsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getTempDocumentsCountMethodKey12);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	public vn.gt.dao.noticeandmessage.model.TempDocument updateTempDocument(
		vn.gt.dao.noticeandmessage.model.TempDocument tempDocument)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateTempDocumentMethodKey13,
				ClpSerializer.translateInput(tempDocument));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (vn.gt.dao.noticeandmessage.model.TempDocument)ClpSerializer.translateOutput(returnObj);
	}

	public vn.gt.dao.noticeandmessage.model.TempDocument updateTempDocument(
		vn.gt.dao.noticeandmessage.model.TempDocument tempDocument,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateTempDocumentMethodKey14,
				ClpSerializer.translateInput(tempDocument), merge);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (vn.gt.dao.noticeandmessage.model.TempDocument)ClpSerializer.translateOutput(returnObj);
	}

	public java.lang.String getBeanIdentifier() {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getBeanIdentifierMethodKey15);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		MethodHandler methodHandler = new MethodHandler(_setBeanIdentifierMethodKey16,
				ClpSerializer.translateInput(beanIdentifier));

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public vn.gt.dao.noticeandmessage.model.TempDocument getTemDocumentByRequestCode(
		java.lang.String requestCode) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getTemDocumentByRequestCodeMethodKey17,
				ClpSerializer.translateInput(requestCode));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (vn.gt.dao.noticeandmessage.model.TempDocument)ClpSerializer.translateOutput(returnObj);
	}

	public vn.gt.dao.noticeandmessage.model.TempDocument getByDocumentNameAndDocumentYear(
		long documentName, int documentYear) throws java.lang.Exception {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getByDocumentNameAndDocumentYearMethodKey18,
				documentName, documentYear);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof java.lang.Exception) {
				throw (java.lang.Exception)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (vn.gt.dao.noticeandmessage.model.TempDocument)ClpSerializer.translateOutput(returnObj);
	}

	public java.lang.String getCallSignByDocumentNameAndDocumentYear(
		long documentName, int documentYear) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getCallSignByDocumentNameAndDocumentYearMethodKey19,
				documentName, documentYear);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<vn.gt.dao.noticeandmessage.model.TempDocument> findTemDocumentByDocumentNameAndDocumentYear(
		long documentName, int documentYear) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findTemDocumentByDocumentNameAndDocumentYearMethodKey20,
				documentName, documentYear);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<vn.gt.dao.noticeandmessage.model.TempDocument>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<vn.gt.dao.noticeandmessage.model.TempDocument> findTempDocumentArivalByMaritimeCodeAndDateFromAndDateTo(
		java.lang.String maritimeCode, java.lang.String dateFrom,
		java.lang.String dateTo, java.lang.String documentTypeCode,
		java.lang.String requestState, java.lang.String documentStatusCode) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findTempDocumentArivalByMaritimeCodeAndDateFromAndDateToMethodKey21,
				ClpSerializer.translateInput(maritimeCode),
				ClpSerializer.translateInput(dateFrom),
				ClpSerializer.translateInput(dateTo),
				ClpSerializer.translateInput(documentTypeCode),
				ClpSerializer.translateInput(requestState),
				ClpSerializer.translateInput(documentStatusCode));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<vn.gt.dao.noticeandmessage.model.TempDocument>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<vn.gt.dao.noticeandmessage.model.TempDocument> findTempDocumentLeaveByMaritimeCodeAndDateFromAndDateTo(
		java.lang.String maritimeCode, java.lang.String dateFrom,
		java.lang.String dateTo, java.lang.String documentTypeCode,
		java.lang.String requestState, java.lang.String documentStatusCode) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findTempDocumentLeaveByMaritimeCodeAndDateFromAndDateToMethodKey22,
				ClpSerializer.translateInput(maritimeCode),
				ClpSerializer.translateInput(dateFrom),
				ClpSerializer.translateInput(dateTo),
				ClpSerializer.translateInput(documentTypeCode),
				ClpSerializer.translateInput(requestState),
				ClpSerializer.translateInput(documentStatusCode));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<vn.gt.dao.noticeandmessage.model.TempDocument>)ClpSerializer.translateOutput(returnObj);
	}

	public long countTempDocumentForStatisticsReport(
		java.lang.String maritimeCode, java.lang.String dateFrom,
		java.lang.String dateTo, java.lang.String documentTypeCode,
		java.lang.String requestState, java.lang.String documentStatusCode) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countTempDocumentForStatisticsReportMethodKey23,
				ClpSerializer.translateInput(maritimeCode),
				ClpSerializer.translateInput(dateFrom),
				ClpSerializer.translateInput(dateTo),
				ClpSerializer.translateInput(documentTypeCode),
				ClpSerializer.translateInput(requestState),
				ClpSerializer.translateInput(documentStatusCode));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Long)returnObj).longValue();
	}

	public java.util.List<vn.gt.portlet.baocaotichhop.thongke.dvcong.FlowChartDataByDate> countTempDocumentForStatisticsByDate(
		java.lang.String maritimeCode, java.lang.String dateFrom,
		java.lang.String dateTo, java.lang.String documentTypeCode,
		java.lang.String requestState, java.lang.String documentStatusCode) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countTempDocumentForStatisticsByDateMethodKey24,
				ClpSerializer.translateInput(maritimeCode),
				ClpSerializer.translateInput(dateFrom),
				ClpSerializer.translateInput(dateTo),
				ClpSerializer.translateInput(documentTypeCode),
				ClpSerializer.translateInput(requestState),
				ClpSerializer.translateInput(documentStatusCode));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<vn.gt.portlet.baocaotichhop.thongke.dvcong.FlowChartDataByDate>)ClpSerializer.translateOutput(returnObj);
	}

	public long countTempDocumentJoinIssueShiftingOrderForStatisticsReport(
		java.lang.String maritimeCode, java.lang.String dateFrom,
		java.lang.String dateTo, java.lang.String documentTypeCode,
		java.lang.String requestState, java.lang.String issRequestState,
		java.lang.String documentStatusCode) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countTempDocumentJoinIssueShiftingOrderForStatisticsReportMethodKey25,
				ClpSerializer.translateInput(maritimeCode),
				ClpSerializer.translateInput(dateFrom),
				ClpSerializer.translateInput(dateTo),
				ClpSerializer.translateInput(documentTypeCode),
				ClpSerializer.translateInput(requestState),
				ClpSerializer.translateInput(issRequestState),
				ClpSerializer.translateInput(documentStatusCode));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Long)returnObj).longValue();
	}

	public long countTempDocumentJoinIssuePermissionTransitForStatisticsReport(
		java.lang.String maritimeCode, java.lang.String dateFrom,
		java.lang.String dateTo, java.lang.String documentTypeCode,
		java.lang.String requestState, java.lang.String issRequestState,
		java.lang.String documentStatusCode) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countTempDocumentJoinIssuePermissionTransitForStatisticsReportMethodKey26,
				ClpSerializer.translateInput(maritimeCode),
				ClpSerializer.translateInput(dateFrom),
				ClpSerializer.translateInput(dateTo),
				ClpSerializer.translateInput(documentTypeCode),
				ClpSerializer.translateInput(requestState),
				ClpSerializer.translateInput(issRequestState),
				ClpSerializer.translateInput(documentStatusCode));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Long)returnObj).longValue();
	}

	public long countTempDocumentJoinIssuePortClearanceForStatisticsReport(
		java.lang.String maritimeCode, java.lang.String dateFrom,
		java.lang.String dateTo, java.lang.String documentTypeCode,
		java.lang.String requestState, java.lang.String issRequestState,
		java.lang.String documentStatusCode) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countTempDocumentJoinIssuePortClearanceForStatisticsReportMethodKey27,
				ClpSerializer.translateInput(maritimeCode),
				ClpSerializer.translateInput(dateFrom),
				ClpSerializer.translateInput(dateTo),
				ClpSerializer.translateInput(documentTypeCode),
				ClpSerializer.translateInput(requestState),
				ClpSerializer.translateInput(issRequestState),
				ClpSerializer.translateInput(documentStatusCode));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Long)returnObj).longValue();
	}

	public vn.gt.dao.noticeandmessage.model.TempDocument findTemDocumentByDocumentNameDocumentYear(
		long documentName, int documentYear) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findTemDocumentByDocumentNameDocumentYearMethodKey28,
				documentName, documentYear);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (vn.gt.dao.noticeandmessage.model.TempDocument)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<vn.gt.dao.noticeandmessage.model.TempDocument> findTempDocumentByRequestState(
		java.lang.String requestState, java.lang.String documentTypeCode,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findTempDocumentByRequestStateMethodKey29,
				ClpSerializer.translateInput(requestState),
				ClpSerializer.translateInput(documentTypeCode), start, end);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<vn.gt.dao.noticeandmessage.model.TempDocument>)ClpSerializer.translateOutput(returnObj);
	}

	public int countTempDocumentByRequestState(java.lang.String requestState,
		java.lang.String documentTypeCode) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countTempDocumentByRequestStateMethodKey30,
				ClpSerializer.translateInput(requestState),
				ClpSerializer.translateInput(documentTypeCode));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	public java.util.List<vn.gt.dao.noticeandmessage.model.TempDocument> findTempDocumentByDocumentStatusCode(
		java.lang.String documentStatusCode, java.lang.String documentTypeCode,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findTempDocumentByDocumentStatusCodeMethodKey31,
				ClpSerializer.translateInput(documentStatusCode),
				ClpSerializer.translateInput(documentTypeCode), start, end);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<vn.gt.dao.noticeandmessage.model.TempDocument>)ClpSerializer.translateOutput(returnObj);
	}

	public int countTempDocumentByDocumentStatusCode(
		java.lang.String documentStatusCode, java.lang.String documentTypeCode) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countTempDocumentByDocumentStatusCodeMethodKey32,
				ClpSerializer.translateInput(documentStatusCode),
				ClpSerializer.translateInput(documentTypeCode));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
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
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findTempDocumentByKeHoachMethodKey33,
				ClpSerializer.translateInput(requestState),
				ClpSerializer.translateInput(documentTypeCode),
				ClpSerializer.translateInput(maritimeCode),
				ClpSerializer.translateInput(shipName),
				ClpSerializer.translateInput(positionCode),
				ClpSerializer.translateInput(portRegionCode),
				ClpSerializer.translateInput(mabankhai),
				ClpSerializer.translateInput(stateCode),
				ClpSerializer.translateInput(shipDateFromStart),
				ClpSerializer.translateInput(shipDateFromEnd),
				ClpSerializer.translateInput(shipDateToStart),
				ClpSerializer.translateInput(shipDateToEnd),
				ClpSerializer.translateInput(callSign),
				ClpSerializer.translateInput(imo),
				ClpSerializer.translateInput(ngayLamThuTucFrom),
				ClpSerializer.translateInput(ngayLamThuTucTo), start, end);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<vn.gt.dao.noticeandmessage.model.TempDocument>)ClpSerializer.translateOutput(returnObj);
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
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countTempDocumentByKeHoachMethodKey34,
				ClpSerializer.translateInput(requestState),
				ClpSerializer.translateInput(documentTypeCode),
				ClpSerializer.translateInput(maritimeCode),
				ClpSerializer.translateInput(shipName),
				ClpSerializer.translateInput(positionCode),
				ClpSerializer.translateInput(portRegionCode),
				ClpSerializer.translateInput(mabankhai),
				ClpSerializer.translateInput(stateCode),
				ClpSerializer.translateInput(shipDateFromStart),
				ClpSerializer.translateInput(shipDateFromEnd),
				ClpSerializer.translateInput(shipDateToStart),
				ClpSerializer.translateInput(shipDateToEnd),
				ClpSerializer.translateInput(callSign),
				ClpSerializer.translateInput(imo),
				ClpSerializer.translateInput(ngayLamThuTucFrom),
				ClpSerializer.translateInput(ngayLamThuTucTo));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	public java.util.List<vn.gt.dao.noticeandmessage.model.TempDocument> findAll(
		int start, int end) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findAllMethodKey35,
				start, end);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<vn.gt.dao.noticeandmessage.model.TempDocument>)ClpSerializer.translateOutput(returnObj);
	}

	public int countAll() {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countAllMethodKey36);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	public java.util.List<vn.gt.dao.noticeandmessage.model.TempDocument> findTempDocumentByThuTuc(
		java.lang.String documentTypeCode, java.lang.String documentName,
		java.lang.String documentYear, java.lang.String maLoaiHoSo,
		java.lang.String shipName, java.lang.String shipTypeCode,
		java.lang.String stateCode, java.lang.String shipCaptain,
		java.lang.String callSign, java.lang.String userCreated, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findTempDocumentByThuTucMethodKey37,
				ClpSerializer.translateInput(documentTypeCode),
				ClpSerializer.translateInput(documentName),
				ClpSerializer.translateInput(documentYear),
				ClpSerializer.translateInput(maLoaiHoSo),
				ClpSerializer.translateInput(shipName),
				ClpSerializer.translateInput(shipTypeCode),
				ClpSerializer.translateInput(stateCode),
				ClpSerializer.translateInput(shipCaptain),
				ClpSerializer.translateInput(callSign),
				ClpSerializer.translateInput(userCreated), start, end);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<vn.gt.dao.noticeandmessage.model.TempDocument>)ClpSerializer.translateOutput(returnObj);
	}

	public int countTempDocumentByThuTuc(java.lang.String documentTypeCode,
		java.lang.String documentName, java.lang.String documentYear,
		java.lang.String maLoaiHoSo, java.lang.String shipName,
		java.lang.String shipTypeCode, java.lang.String stateCode,
		java.lang.String shipCaptain, java.lang.String callSign,
		java.lang.String userCreated)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countTempDocumentByThuTucMethodKey38,
				ClpSerializer.translateInput(documentTypeCode),
				ClpSerializer.translateInput(documentName),
				ClpSerializer.translateInput(documentYear),
				ClpSerializer.translateInput(maLoaiHoSo),
				ClpSerializer.translateInput(shipName),
				ClpSerializer.translateInput(shipTypeCode),
				ClpSerializer.translateInput(stateCode),
				ClpSerializer.translateInput(shipCaptain),
				ClpSerializer.translateInput(callSign),
				ClpSerializer.translateInput(userCreated));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
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
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findDanhSachHoSoRoleThuTucMethodKey39,
				ClpSerializer.translateInput(documentTypeCode),
				ClpSerializer.translateInput(maritimeCode),
				ClpSerializer.translateInput(portCode),
				ClpSerializer.translateInput(lastPortCode),
				ClpSerializer.translateInput(shipName),
				ClpSerializer.translateInput(stateCode),
				ClpSerializer.translateInput(callSign),
				ClpSerializer.translateInput(imo),
				ClpSerializer.translateInput(shipPosition),
				ClpSerializer.translateInput(shipDateFromStart),
				ClpSerializer.translateInput(shipDateFromEnd),
				ClpSerializer.translateInput(shipDateToStart),
				ClpSerializer.translateInput(shipDateToEnd),
				ClpSerializer.translateInput(documentStatusCode),
				ClpSerializer.translateInput(arrivalShipAgency),
				ClpSerializer.translateInput(nameArrivalShipAgency),
				ClpSerializer.translateInput(departureShipAgency),
				ClpSerializer.translateInput(nameDepartureShipAgency),
				ClpSerializer.translateInput(portRegionCode),
				ClpSerializer.translateInput(ngayLamThuTucFrom),
				ClpSerializer.translateInput(ngayLamThuTucTo),
				ClpSerializer.translateInput(maBanKhai), start, end);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<vn.gt.dao.noticeandmessage.model.TempDocument>)ClpSerializer.translateOutput(returnObj);
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
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countDanhSachHoSoRoleThuTucMethodKey40,
				ClpSerializer.translateInput(documentTypeCode),
				ClpSerializer.translateInput(maritimeCode),
				ClpSerializer.translateInput(portCode),
				ClpSerializer.translateInput(lastPortCode),
				ClpSerializer.translateInput(shipName),
				ClpSerializer.translateInput(stateCode),
				ClpSerializer.translateInput(callSign),
				ClpSerializer.translateInput(imo),
				ClpSerializer.translateInput(shipPosition),
				ClpSerializer.translateInput(shipDateFromStart),
				ClpSerializer.translateInput(shipDateFromEnd),
				ClpSerializer.translateInput(shipDateToStart),
				ClpSerializer.translateInput(shipDateToEnd),
				ClpSerializer.translateInput(documentStatusCode),
				ClpSerializer.translateInput(arrivalShipAgency),
				ClpSerializer.translateInput(nameArrivalShipAgency),
				ClpSerializer.translateInput(departureShipAgency),
				ClpSerializer.translateInput(nameDepartureShipAgency),
				ClpSerializer.translateInput(portRegionCode),
				ClpSerializer.translateInput(ngayLamThuTucFrom),
				ClpSerializer.translateInput(ngayLamThuTucTo),
				ClpSerializer.translateInput(maBanKhai));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	public java.util.List<vn.gt.dao.noticeandmessage.model.TempDocument> findTempDocumentInfo(
		java.lang.String documentStatusCode, java.lang.String maritimeCode,
		java.lang.String portCode, java.lang.String shipName,
		java.lang.String callSign, java.lang.String shipDateFrom,
		java.lang.String shipDateTo, int start, int end) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findTempDocumentInfoMethodKey41,
				ClpSerializer.translateInput(documentStatusCode),
				ClpSerializer.translateInput(maritimeCode),
				ClpSerializer.translateInput(portCode),
				ClpSerializer.translateInput(shipName),
				ClpSerializer.translateInput(callSign),
				ClpSerializer.translateInput(shipDateFrom),
				ClpSerializer.translateInput(shipDateTo), start, end);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<vn.gt.dao.noticeandmessage.model.TempDocument>)ClpSerializer.translateOutput(returnObj);
	}

	public int countTempDocumentInfo(java.lang.String documentStatusCode,
		java.lang.String maritimeCode, java.lang.String portCode,
		java.lang.String shipName, java.lang.String callSign,
		java.lang.String shipDateFrom, java.lang.String shipDateTo)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countTempDocumentInfoMethodKey42,
				ClpSerializer.translateInput(documentStatusCode),
				ClpSerializer.translateInput(maritimeCode),
				ClpSerializer.translateInput(portCode),
				ClpSerializer.translateInput(shipName),
				ClpSerializer.translateInput(callSign),
				ClpSerializer.translateInput(shipDateFrom),
				ClpSerializer.translateInput(shipDateTo));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	public java.util.List<vn.gt.dao.noticeandmessage.model.TempDocument> findKeHoachYCBS()
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findKeHoachYCBSMethodKey43);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<vn.gt.dao.noticeandmessage.model.TempDocument>)ClpSerializer.translateOutput(returnObj);
	}

	public ClassLoaderProxy getClassLoaderProxy() {
		return _classLoaderProxy;
	}

	private ClassLoaderProxy _classLoaderProxy;
	private MethodKey _addTempDocumentMethodKey0;
	private MethodKey _createTempDocumentMethodKey1;
	private MethodKey _deleteTempDocumentMethodKey2;
	private MethodKey _deleteTempDocumentMethodKey3;
	private MethodKey _dynamicQueryMethodKey4;
	private MethodKey _dynamicQueryMethodKey5;
	private MethodKey _dynamicQueryMethodKey6;
	private MethodKey _dynamicQueryCountMethodKey7;
	private MethodKey _fetchTempDocumentMethodKey8;
	private MethodKey _getTempDocumentMethodKey9;
	private MethodKey _getPersistedModelMethodKey10;
	private MethodKey _getTempDocumentsMethodKey11;
	private MethodKey _getTempDocumentsCountMethodKey12;
	private MethodKey _updateTempDocumentMethodKey13;
	private MethodKey _updateTempDocumentMethodKey14;
	private MethodKey _getBeanIdentifierMethodKey15;
	private MethodKey _setBeanIdentifierMethodKey16;
	private MethodKey _getTemDocumentByRequestCodeMethodKey17;
	private MethodKey _getByDocumentNameAndDocumentYearMethodKey18;
	private MethodKey _getCallSignByDocumentNameAndDocumentYearMethodKey19;
	private MethodKey _findTemDocumentByDocumentNameAndDocumentYearMethodKey20;
	private MethodKey _findTempDocumentArivalByMaritimeCodeAndDateFromAndDateToMethodKey21;
	private MethodKey _findTempDocumentLeaveByMaritimeCodeAndDateFromAndDateToMethodKey22;
	private MethodKey _countTempDocumentForStatisticsReportMethodKey23;
	private MethodKey _countTempDocumentForStatisticsByDateMethodKey24;
	private MethodKey _countTempDocumentJoinIssueShiftingOrderForStatisticsReportMethodKey25;
	private MethodKey _countTempDocumentJoinIssuePermissionTransitForStatisticsReportMethodKey26;
	private MethodKey _countTempDocumentJoinIssuePortClearanceForStatisticsReportMethodKey27;
	private MethodKey _findTemDocumentByDocumentNameDocumentYearMethodKey28;
	private MethodKey _findTempDocumentByRequestStateMethodKey29;
	private MethodKey _countTempDocumentByRequestStateMethodKey30;
	private MethodKey _findTempDocumentByDocumentStatusCodeMethodKey31;
	private MethodKey _countTempDocumentByDocumentStatusCodeMethodKey32;
	private MethodKey _findTempDocumentByKeHoachMethodKey33;
	private MethodKey _countTempDocumentByKeHoachMethodKey34;
	private MethodKey _findAllMethodKey35;
	private MethodKey _countAllMethodKey36;
	private MethodKey _findTempDocumentByThuTucMethodKey37;
	private MethodKey _countTempDocumentByThuTucMethodKey38;
	private MethodKey _findDanhSachHoSoRoleThuTucMethodKey39;
	private MethodKey _countDanhSachHoSoRoleThuTucMethodKey40;
	private MethodKey _findTempDocumentInfoMethodKey41;
	private MethodKey _countTempDocumentInfoMethodKey42;
	private MethodKey _findKeHoachYCBSMethodKey43;
}