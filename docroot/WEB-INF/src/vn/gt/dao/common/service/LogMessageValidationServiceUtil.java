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

package vn.gt.dao.common.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the log message validation remote service. This utility wraps {@link vn.gt.dao.common.service.impl.LogMessageValidationServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author win_64
 * @see LogMessageValidationService
 * @see vn.gt.dao.common.service.base.LogMessageValidationServiceBaseImpl
 * @see vn.gt.dao.common.service.impl.LogMessageValidationServiceImpl
 * @generated
 */
public class LogMessageValidationServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link vn.gt.dao.common.service.impl.LogMessageValidationServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static void clearService() {
		_service = null;
	}

	public static LogMessageValidationService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					LogMessageValidationService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					LogMessageValidationService.class.getName(),
					portletClassLoader);

			_service = new LogMessageValidationServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(LogMessageValidationServiceUtil.class,
				"_service");
			MethodCache.remove(LogMessageValidationService.class);
		}

		return _service;
	}

	public void setService(LogMessageValidationService service) {
		MethodCache.remove(LogMessageValidationService.class);

		_service = service;

		ReferenceRegistry.registerReference(LogMessageValidationServiceUtil.class,
			"_service");
		MethodCache.remove(LogMessageValidationService.class);
	}

	private static LogMessageValidationService _service;
}