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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the temp crew effects items local service. This utility wraps {@link vn.gt.dao.noticeandmessage.service.impl.TempCrewEffectsItemsLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author win_64
 * @see TempCrewEffectsItemsLocalService
 * @see vn.gt.dao.noticeandmessage.service.base.TempCrewEffectsItemsLocalServiceBaseImpl
 * @see vn.gt.dao.noticeandmessage.service.impl.TempCrewEffectsItemsLocalServiceImpl
 * @generated
 */
public class TempCrewEffectsItemsLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link vn.gt.dao.noticeandmessage.service.impl.TempCrewEffectsItemsLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the temp crew effects items to the database. Also notifies the appropriate model listeners.
	*
	* @param tempCrewEffectsItems the temp crew effects items
	* @return the temp crew effects items that was added
	* @throws SystemException if a system exception occurred
	*/
	public static vn.gt.dao.noticeandmessage.model.TempCrewEffectsItems addTempCrewEffectsItems(
		vn.gt.dao.noticeandmessage.model.TempCrewEffectsItems tempCrewEffectsItems)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addTempCrewEffectsItems(tempCrewEffectsItems);
	}

	/**
	* Creates a new temp crew effects items with the primary key. Does not add the temp crew effects items to the database.
	*
	* @param id the primary key for the new temp crew effects items
	* @return the new temp crew effects items
	*/
	public static vn.gt.dao.noticeandmessage.model.TempCrewEffectsItems createTempCrewEffectsItems(
		long id) {
		return getService().createTempCrewEffectsItems(id);
	}

	/**
	* Deletes the temp crew effects items with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the temp crew effects items
	* @throws PortalException if a temp crew effects items with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteTempCrewEffectsItems(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteTempCrewEffectsItems(id);
	}

	/**
	* Deletes the temp crew effects items from the database. Also notifies the appropriate model listeners.
	*
	* @param tempCrewEffectsItems the temp crew effects items
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteTempCrewEffectsItems(
		vn.gt.dao.noticeandmessage.model.TempCrewEffectsItems tempCrewEffectsItems)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteTempCrewEffectsItems(tempCrewEffectsItems);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static vn.gt.dao.noticeandmessage.model.TempCrewEffectsItems fetchTempCrewEffectsItems(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchTempCrewEffectsItems(id);
	}

	/**
	* Returns the temp crew effects items with the primary key.
	*
	* @param id the primary key of the temp crew effects items
	* @return the temp crew effects items
	* @throws PortalException if a temp crew effects items with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.gt.dao.noticeandmessage.model.TempCrewEffectsItems getTempCrewEffectsItems(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getTempCrewEffectsItems(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the temp crew effects itemses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of temp crew effects itemses
	* @param end the upper bound of the range of temp crew effects itemses (not inclusive)
	* @return the range of temp crew effects itemses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.gt.dao.noticeandmessage.model.TempCrewEffectsItems> getTempCrewEffectsItemses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTempCrewEffectsItemses(start, end);
	}

	/**
	* Returns the number of temp crew effects itemses.
	*
	* @return the number of temp crew effects itemses
	* @throws SystemException if a system exception occurred
	*/
	public static int getTempCrewEffectsItemsesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTempCrewEffectsItemsesCount();
	}

	/**
	* Updates the temp crew effects items in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tempCrewEffectsItems the temp crew effects items
	* @return the temp crew effects items that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static vn.gt.dao.noticeandmessage.model.TempCrewEffectsItems updateTempCrewEffectsItems(
		vn.gt.dao.noticeandmessage.model.TempCrewEffectsItems tempCrewEffectsItems)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateTempCrewEffectsItems(tempCrewEffectsItems);
	}

	/**
	* Updates the temp crew effects items in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tempCrewEffectsItems the temp crew effects items
	* @param merge whether to merge the temp crew effects items with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the temp crew effects items that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static vn.gt.dao.noticeandmessage.model.TempCrewEffectsItems updateTempCrewEffectsItems(
		vn.gt.dao.noticeandmessage.model.TempCrewEffectsItems tempCrewEffectsItems,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateTempCrewEffectsItems(tempCrewEffectsItems, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.util.List<vn.gt.dao.noticeandmessage.model.TempCrewEffectsItems> findByRequestCode(
		java.lang.String requestCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByRequestCode(requestCode);
	}

	public static vn.gt.dao.noticeandmessage.model.TempCrewEffectsItems findTempCrewEffectsItemsByRequestCode(
		java.lang.String requestCode) {
		return getService().findTempCrewEffectsItemsByRequestCode(requestCode);
	}

	public static void clearService() {
		_service = null;
	}

	public static TempCrewEffectsItemsLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					TempCrewEffectsItemsLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					TempCrewEffectsItemsLocalService.class.getName(),
					portletClassLoader);

			_service = new TempCrewEffectsItemsLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(TempCrewEffectsItemsLocalServiceUtil.class,
				"_service");
			MethodCache.remove(TempCrewEffectsItemsLocalService.class);
		}

		return _service;
	}

	public void setService(TempCrewEffectsItemsLocalService service) {
		MethodCache.remove(TempCrewEffectsItemsLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(TempCrewEffectsItemsLocalServiceUtil.class,
			"_service");
		MethodCache.remove(TempCrewEffectsItemsLocalService.class);
	}

	private static TempCrewEffectsItemsLocalService _service;
}