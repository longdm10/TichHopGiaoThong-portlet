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

package vn.gt.dao.danhmuc.service.impl;

import vn.gt.dao.danhmuc.NoSuchDmHistoryUnitGeneralException;
import vn.gt.dao.danhmuc.model.DmHistoryUnitGeneral;
import vn.gt.dao.danhmuc.service.base.DmHistoryUnitGeneralLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the dm history unit general local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link vn.gt.dao.danhmuc.service.DmHistoryUnitGeneralLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author win_64
 * @see vn.gt.dao.danhmuc.service.base.DmHistoryUnitGeneralLocalServiceBaseImpl
 * @see vn.gt.dao.danhmuc.service.DmHistoryUnitGeneralLocalServiceUtil
 */
public class DmHistoryUnitGeneralLocalServiceImpl
	extends DmHistoryUnitGeneralLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link vn.gt.dao.danhmuc.service.DmHistoryUnitGeneralLocalServiceUtil} to access the dm history unit general local service.
	 */
	public DmHistoryUnitGeneral getByUnitCodeAndSyncVersion(String unitCode, String syncVersion) {
		try {
			return dmHistoryUnitGeneralPersistence.findByUnitCodeAndSyncVersion(unitCode, syncVersion);
		} catch (NoSuchDmHistoryUnitGeneralException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}
}