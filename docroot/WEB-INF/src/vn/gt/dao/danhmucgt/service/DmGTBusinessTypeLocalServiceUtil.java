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

package vn.gt.dao.danhmucgt.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the dm g t business type local service. This utility wraps {@link vn.gt.dao.danhmucgt.service.impl.DmGTBusinessTypeLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author win_64
 * @see DmGTBusinessTypeLocalService
 * @see vn.gt.dao.danhmucgt.service.base.DmGTBusinessTypeLocalServiceBaseImpl
 * @see vn.gt.dao.danhmucgt.service.impl.DmGTBusinessTypeLocalServiceImpl
 * @generated
 */
public class DmGTBusinessTypeLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link vn.gt.dao.danhmucgt.service.impl.DmGTBusinessTypeLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the dm g t business type to the database. Also notifies the appropriate model listeners.
	*
	* @param dmGTBusinessType the dm g t business type
	* @return the dm g t business type that was added
	* @throws SystemException if a system exception occurred
	*/
	public static vn.gt.dao.danhmucgt.model.DmGTBusinessType addDmGTBusinessType(
		vn.gt.dao.danhmucgt.model.DmGTBusinessType dmGTBusinessType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addDmGTBusinessType(dmGTBusinessType);
	}

	/**
	* Creates a new dm g t business type with the primary key. Does not add the dm g t business type to the database.
	*
	* @param id the primary key for the new dm g t business type
	* @return the new dm g t business type
	*/
	public static vn.gt.dao.danhmucgt.model.DmGTBusinessType createDmGTBusinessType(
		long id) {
		return getService().createDmGTBusinessType(id);
	}

	/**
	* Deletes the dm g t business type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the dm g t business type
	* @throws PortalException if a dm g t business type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteDmGTBusinessType(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteDmGTBusinessType(id);
	}

	/**
	* Deletes the dm g t business type from the database. Also notifies the appropriate model listeners.
	*
	* @param dmGTBusinessType the dm g t business type
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteDmGTBusinessType(
		vn.gt.dao.danhmucgt.model.DmGTBusinessType dmGTBusinessType)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteDmGTBusinessType(dmGTBusinessType);
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

	public static vn.gt.dao.danhmucgt.model.DmGTBusinessType fetchDmGTBusinessType(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchDmGTBusinessType(id);
	}

	/**
	* Returns the dm g t business type with the primary key.
	*
	* @param id the primary key of the dm g t business type
	* @return the dm g t business type
	* @throws PortalException if a dm g t business type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.gt.dao.danhmucgt.model.DmGTBusinessType getDmGTBusinessType(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getDmGTBusinessType(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the dm g t business types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of dm g t business types
	* @param end the upper bound of the range of dm g t business types (not inclusive)
	* @return the range of dm g t business types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.gt.dao.danhmucgt.model.DmGTBusinessType> getDmGTBusinessTypes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDmGTBusinessTypes(start, end);
	}

	/**
	* Returns the number of dm g t business types.
	*
	* @return the number of dm g t business types
	* @throws SystemException if a system exception occurred
	*/
	public static int getDmGTBusinessTypesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDmGTBusinessTypesCount();
	}

	/**
	* Updates the dm g t business type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param dmGTBusinessType the dm g t business type
	* @return the dm g t business type that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static vn.gt.dao.danhmucgt.model.DmGTBusinessType updateDmGTBusinessType(
		vn.gt.dao.danhmucgt.model.DmGTBusinessType dmGTBusinessType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateDmGTBusinessType(dmGTBusinessType);
	}

	/**
	* Updates the dm g t business type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param dmGTBusinessType the dm g t business type
	* @param merge whether to merge the dm g t business type with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the dm g t business type that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static vn.gt.dao.danhmucgt.model.DmGTBusinessType updateDmGTBusinessType(
		vn.gt.dao.danhmucgt.model.DmGTBusinessType dmGTBusinessType,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateDmGTBusinessType(dmGTBusinessType, merge);
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

	public static int countByBusinessTypeCode(int businessTypeCode) {
		return getService().countByBusinessTypeCode(businessTypeCode);
	}

	public static vn.gt.dao.danhmucgt.model.DmGTBusinessType getByBusinessTypeCode(
		int businessTypeCode) {
		return getService().getByBusinessTypeCode(businessTypeCode);
	}

	public static void clearService() {
		_service = null;
	}

	public static DmGTBusinessTypeLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					DmGTBusinessTypeLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					DmGTBusinessTypeLocalService.class.getName(),
					portletClassLoader);

			_service = new DmGTBusinessTypeLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(DmGTBusinessTypeLocalServiceUtil.class,
				"_service");
			MethodCache.remove(DmGTBusinessTypeLocalService.class);
		}

		return _service;
	}

	public void setService(DmGTBusinessTypeLocalService service) {
		MethodCache.remove(DmGTBusinessTypeLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(DmGTBusinessTypeLocalServiceUtil.class,
			"_service");
		MethodCache.remove(DmGTBusinessTypeLocalService.class);
	}

	private static DmGTBusinessTypeLocalService _service;
}