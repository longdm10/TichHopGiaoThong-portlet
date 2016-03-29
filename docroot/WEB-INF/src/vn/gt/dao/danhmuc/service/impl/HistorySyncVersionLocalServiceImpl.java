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

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;

import vn.gt.dao.danhmuc.model.HistorySyncVersion;
import vn.gt.dao.danhmuc.service.base.HistorySyncVersionLocalServiceBaseImpl;

/**
 * The implementation of the history sync version local service.
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the
 * {@link vn.gt.dao.danhmuc.service.HistorySyncVersionLocalService} interface.
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can
 * only be accessed from within the same VM.
 * </p>
 *
 * @author win_64
 * @see vn.gt.dao.danhmuc.service.base.HistorySyncVersionLocalServiceBaseImpl
 * @see vn.gt.dao.danhmuc.service.HistorySyncVersionLocalServiceUtil
 */
public class HistorySyncVersionLocalServiceImpl extends HistorySyncVersionLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use {@link vn.gt.dao.danhmuc.service.HistorySyncVersionLocalServiceUtil}
	 * to access the history sync version local service.
	 */
	public String getsyncVersion(Date requestedDate, String categoryID) throws SystemException {
		List<HistorySyncVersion> historySyncVersions = historySyncVersionFinder.getsyncVersion(requestedDate, categoryID);
		if (historySyncVersions != null && historySyncVersions.size() > 0) {
			return historySyncVersions.get(0).getSyncVersion();
		}
		return "";
	}
}