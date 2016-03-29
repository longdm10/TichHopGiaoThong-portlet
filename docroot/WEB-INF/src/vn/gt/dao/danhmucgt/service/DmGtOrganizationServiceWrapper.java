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

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link DmGtOrganizationService}.
 * </p>
 *
 * @author    win_64
 * @see       DmGtOrganizationService
 * @generated
 */
public class DmGtOrganizationServiceWrapper implements DmGtOrganizationService,
	ServiceWrapper<DmGtOrganizationService> {
	public DmGtOrganizationServiceWrapper(
		DmGtOrganizationService dmGtOrganizationService) {
		_dmGtOrganizationService = dmGtOrganizationService;
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public DmGtOrganizationService getWrappedDmGtOrganizationService() {
		return _dmGtOrganizationService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedDmGtOrganizationService(
		DmGtOrganizationService dmGtOrganizationService) {
		_dmGtOrganizationService = dmGtOrganizationService;
	}

	public DmGtOrganizationService getWrappedService() {
		return _dmGtOrganizationService;
	}

	public void setWrappedService(
		DmGtOrganizationService dmGtOrganizationService) {
		_dmGtOrganizationService = dmGtOrganizationService;
	}

	private DmGtOrganizationService _dmGtOrganizationService;
}