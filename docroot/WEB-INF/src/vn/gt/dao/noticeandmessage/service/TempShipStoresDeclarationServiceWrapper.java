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
 * This class is a wrapper for {@link TempShipStoresDeclarationService}.
 * </p>
 *
 * @author    win_64
 * @see       TempShipStoresDeclarationService
 * @generated
 */
public class TempShipStoresDeclarationServiceWrapper
	implements TempShipStoresDeclarationService,
		ServiceWrapper<TempShipStoresDeclarationService> {
	public TempShipStoresDeclarationServiceWrapper(
		TempShipStoresDeclarationService tempShipStoresDeclarationService) {
		_tempShipStoresDeclarationService = tempShipStoresDeclarationService;
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public TempShipStoresDeclarationService getWrappedTempShipStoresDeclarationService() {
		return _tempShipStoresDeclarationService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedTempShipStoresDeclarationService(
		TempShipStoresDeclarationService tempShipStoresDeclarationService) {
		_tempShipStoresDeclarationService = tempShipStoresDeclarationService;
	}

	public TempShipStoresDeclarationService getWrappedService() {
		return _tempShipStoresDeclarationService;
	}

	public void setWrappedService(
		TempShipStoresDeclarationService tempShipStoresDeclarationService) {
		_tempShipStoresDeclarationService = tempShipStoresDeclarationService;
	}

	private TempShipStoresDeclarationService _tempShipStoresDeclarationService;
}