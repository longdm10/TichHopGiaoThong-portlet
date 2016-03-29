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

import java.util.List;

import vn.gt.dao.danhmuc.model.DmShipType;
import vn.gt.dao.danhmuc.service.base.DmShipTypeLocalServiceBaseImpl;

/**
 * The implementation of the dm ship type local service.
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the
 * {@link vn.gt.dao.danhmuc.service.DmShipTypeLocalService} interface.
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can
 * only be accessed from within the same VM.
 * </p>
 *
 * @author win_64
 * @see vn.gt.dao.danhmuc.service.base.DmShipTypeLocalServiceBaseImpl
 * @see vn.gt.dao.danhmuc.service.DmShipTypeLocalServiceUtil
 */
public class DmShipTypeLocalServiceImpl extends DmShipTypeLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use {@link vn.gt.dao.danhmuc.service.DmShipTypeLocalServiceUtil} to access
	 * the dm ship type local service.
	 */
	public DmShipType getByShipTypeCode(String shipTypeCode) {
		try {
			List<DmShipType> dmShipTypeCodes = dmShipTypePersistence.findByShipTypeCode(shipTypeCode);
			if (dmShipTypeCodes != null && dmShipTypeCodes.size() > 0) {
				return dmShipTypeCodes.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}