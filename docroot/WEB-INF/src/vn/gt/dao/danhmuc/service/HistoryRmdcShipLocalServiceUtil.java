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

package vn.gt.dao.danhmuc.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the history rmdc ship local service. This utility wraps {@link vn.gt.dao.danhmuc.service.impl.HistoryRmdcShipLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author win_64
 * @see HistoryRmdcShipLocalService
 * @see vn.gt.dao.danhmuc.service.base.HistoryRmdcShipLocalServiceBaseImpl
 * @see vn.gt.dao.danhmuc.service.impl.HistoryRmdcShipLocalServiceImpl
 * @generated
 */
public class HistoryRmdcShipLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link vn.gt.dao.danhmuc.service.impl.HistoryRmdcShipLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the history rmdc ship to the database. Also notifies the appropriate model listeners.
	*
	* @param historyRmdcShip the history rmdc ship
	* @return the history rmdc ship that was added
	* @throws SystemException if a system exception occurred
	*/
	public static vn.gt.dao.danhmuc.model.HistoryRmdcShip addHistoryRmdcShip(
		vn.gt.dao.danhmuc.model.HistoryRmdcShip historyRmdcShip)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addHistoryRmdcShip(historyRmdcShip);
	}

	/**
	* Creates a new history rmdc ship with the primary key. Does not add the history rmdc ship to the database.
	*
	* @param id the primary key for the new history rmdc ship
	* @return the new history rmdc ship
	*/
	public static vn.gt.dao.danhmuc.model.HistoryRmdcShip createHistoryRmdcShip(
		long id) {
		return getService().createHistoryRmdcShip(id);
	}

	/**
	* Deletes the history rmdc ship with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the history rmdc ship
	* @throws PortalException if a history rmdc ship with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteHistoryRmdcShip(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteHistoryRmdcShip(id);
	}

	/**
	* Deletes the history rmdc ship from the database. Also notifies the appropriate model listeners.
	*
	* @param historyRmdcShip the history rmdc ship
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteHistoryRmdcShip(
		vn.gt.dao.danhmuc.model.HistoryRmdcShip historyRmdcShip)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteHistoryRmdcShip(historyRmdcShip);
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

	public static vn.gt.dao.danhmuc.model.HistoryRmdcShip fetchHistoryRmdcShip(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchHistoryRmdcShip(id);
	}

	/**
	* Returns the history rmdc ship with the primary key.
	*
	* @param id the primary key of the history rmdc ship
	* @return the history rmdc ship
	* @throws PortalException if a history rmdc ship with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.gt.dao.danhmuc.model.HistoryRmdcShip getHistoryRmdcShip(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getHistoryRmdcShip(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the history rmdc ships.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of history rmdc ships
	* @param end the upper bound of the range of history rmdc ships (not inclusive)
	* @return the range of history rmdc ships
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.gt.dao.danhmuc.model.HistoryRmdcShip> getHistoryRmdcShips(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getHistoryRmdcShips(start, end);
	}

	/**
	* Returns the number of history rmdc ships.
	*
	* @return the number of history rmdc ships
	* @throws SystemException if a system exception occurred
	*/
	public static int getHistoryRmdcShipsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getHistoryRmdcShipsCount();
	}

	/**
	* Updates the history rmdc ship in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param historyRmdcShip the history rmdc ship
	* @return the history rmdc ship that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static vn.gt.dao.danhmuc.model.HistoryRmdcShip updateHistoryRmdcShip(
		vn.gt.dao.danhmuc.model.HistoryRmdcShip historyRmdcShip)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateHistoryRmdcShip(historyRmdcShip);
	}

	/**
	* Updates the history rmdc ship in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param historyRmdcShip the history rmdc ship
	* @param merge whether to merge the history rmdc ship with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the history rmdc ship that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static vn.gt.dao.danhmuc.model.HistoryRmdcShip updateHistoryRmdcShip(
		vn.gt.dao.danhmuc.model.HistoryRmdcShip historyRmdcShip, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateHistoryRmdcShip(historyRmdcShip, merge);
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

	public static void clearService() {
		_service = null;
	}

	public static HistoryRmdcShipLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					HistoryRmdcShipLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					HistoryRmdcShipLocalService.class.getName(),
					portletClassLoader);

			_service = new HistoryRmdcShipLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(HistoryRmdcShipLocalServiceUtil.class,
				"_service");
			MethodCache.remove(HistoryRmdcShipLocalService.class);
		}

		return _service;
	}

	public void setService(HistoryRmdcShipLocalService service) {
		MethodCache.remove(HistoryRmdcShipLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(HistoryRmdcShipLocalServiceUtil.class,
			"_service");
		MethodCache.remove(HistoryRmdcShipLocalService.class);
	}

	private static HistoryRmdcShipLocalService _service;
}