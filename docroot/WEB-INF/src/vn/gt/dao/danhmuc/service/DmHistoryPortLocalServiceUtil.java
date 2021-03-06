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
 * The utility for the dm history port local service. This utility wraps {@link vn.gt.dao.danhmuc.service.impl.DmHistoryPortLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author win_64
 * @see DmHistoryPortLocalService
 * @see vn.gt.dao.danhmuc.service.base.DmHistoryPortLocalServiceBaseImpl
 * @see vn.gt.dao.danhmuc.service.impl.DmHistoryPortLocalServiceImpl
 * @generated
 */
public class DmHistoryPortLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link vn.gt.dao.danhmuc.service.impl.DmHistoryPortLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the dm history port to the database. Also notifies the appropriate model listeners.
	*
	* @param dmHistoryPort the dm history port
	* @return the dm history port that was added
	* @throws SystemException if a system exception occurred
	*/
	public static vn.gt.dao.danhmuc.model.DmHistoryPort addDmHistoryPort(
		vn.gt.dao.danhmuc.model.DmHistoryPort dmHistoryPort)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addDmHistoryPort(dmHistoryPort);
	}

	/**
	* Creates a new dm history port with the primary key. Does not add the dm history port to the database.
	*
	* @param id the primary key for the new dm history port
	* @return the new dm history port
	*/
	public static vn.gt.dao.danhmuc.model.DmHistoryPort createDmHistoryPort(
		int id) {
		return getService().createDmHistoryPort(id);
	}

	/**
	* Deletes the dm history port with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the dm history port
	* @throws PortalException if a dm history port with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteDmHistoryPort(int id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteDmHistoryPort(id);
	}

	/**
	* Deletes the dm history port from the database. Also notifies the appropriate model listeners.
	*
	* @param dmHistoryPort the dm history port
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteDmHistoryPort(
		vn.gt.dao.danhmuc.model.DmHistoryPort dmHistoryPort)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteDmHistoryPort(dmHistoryPort);
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

	public static vn.gt.dao.danhmuc.model.DmHistoryPort fetchDmHistoryPort(
		int id) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchDmHistoryPort(id);
	}

	/**
	* Returns the dm history port with the primary key.
	*
	* @param id the primary key of the dm history port
	* @return the dm history port
	* @throws PortalException if a dm history port with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.gt.dao.danhmuc.model.DmHistoryPort getDmHistoryPort(int id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getDmHistoryPort(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the dm history ports.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of dm history ports
	* @param end the upper bound of the range of dm history ports (not inclusive)
	* @return the range of dm history ports
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.gt.dao.danhmuc.model.DmHistoryPort> getDmHistoryPorts(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDmHistoryPorts(start, end);
	}

	/**
	* Returns the number of dm history ports.
	*
	* @return the number of dm history ports
	* @throws SystemException if a system exception occurred
	*/
	public static int getDmHistoryPortsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDmHistoryPortsCount();
	}

	/**
	* Updates the dm history port in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param dmHistoryPort the dm history port
	* @return the dm history port that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static vn.gt.dao.danhmuc.model.DmHistoryPort updateDmHistoryPort(
		vn.gt.dao.danhmuc.model.DmHistoryPort dmHistoryPort)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateDmHistoryPort(dmHistoryPort);
	}

	/**
	* Updates the dm history port in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param dmHistoryPort the dm history port
	* @param merge whether to merge the dm history port with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the dm history port that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static vn.gt.dao.danhmuc.model.DmHistoryPort updateDmHistoryPort(
		vn.gt.dao.danhmuc.model.DmHistoryPort dmHistoryPort, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateDmHistoryPort(dmHistoryPort, merge);
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

	public static vn.gt.dao.danhmuc.model.DmHistoryPort findByPortCodeAndSyncVersion(
		java.lang.String portCode, java.lang.String syncVersion) {
		return getService().findByPortCodeAndSyncVersion(portCode, syncVersion);
	}

	public static void clearService() {
		_service = null;
	}

	public static DmHistoryPortLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					DmHistoryPortLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					DmHistoryPortLocalService.class.getName(),
					portletClassLoader);

			_service = new DmHistoryPortLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(DmHistoryPortLocalServiceUtil.class,
				"_service");
			MethodCache.remove(DmHistoryPortLocalService.class);
		}

		return _service;
	}

	public void setService(DmHistoryPortLocalService service) {
		MethodCache.remove(DmHistoryPortLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(DmHistoryPortLocalServiceUtil.class,
			"_service");
		MethodCache.remove(DmHistoryPortLocalService.class);
	}

	private static DmHistoryPortLocalService _service;
}