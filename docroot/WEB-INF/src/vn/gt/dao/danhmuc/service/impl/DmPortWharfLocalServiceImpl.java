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

import vn.gt.dao.danhmuc.model.DmPortWharf;
import vn.gt.dao.danhmuc.service.base.DmPortWharfLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the dm port wharf local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link vn.gt.dao.danhmuc.service.DmPortWharfLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author win_64
 * @see vn.gt.dao.danhmuc.service.base.DmPortWharfLocalServiceBaseImpl
 * @see vn.gt.dao.danhmuc.service.DmPortWharfLocalServiceUtil
 */
public class DmPortWharfLocalServiceImpl extends DmPortWharfLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link vn.gt.dao.danhmuc.service.DmPortWharfLocalServiceUtil} to access the dm port wharf local service.
	 */
	public DmPortWharf getByPortWharfCode(String portWharfCode) {
		try {
			List<DmPortWharf> dmPortWharfes = dmPortWharfPersistence.findByPortWharfCode(portWharfCode);
			if (dmPortWharfes != null && dmPortWharfes.size() > 0) {
				return dmPortWharfes.get(0);
			}
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<DmPortWharf> findByPortRegionCode(String portRegionCode) {
		try {
			return dmPortWharfPersistence.findByPortRegionCode(portRegionCode);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * ascOrdesc:
	 * asc = true
	 * desc = false
	 * */
	public List<DmPortWharf> findByPortRegionCodeAndPortHarbourCodeOrNullOrderPortCode(String portRegionCode, String portHarbourCode, boolean ascOrdesc) {
		try {
			return dmPortWharfFinder.findByPortRegionCodeAndPortHarbourCodeOrNullOrderPortCode(portRegionCode, portHarbourCode, ascOrdesc);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<DmPortWharf> findByPortHarbourCodeOrNull(String portHarbourCode, boolean ascOrdesc) {
		try {
			return dmPortWharfFinder.findByPortHarbourCodeOrNull(portHarbourCode, ascOrdesc);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<DmPortWharf> findByPortRegionCodeOrderPortCode(String portRegionCode, boolean ascOrdesc) {
		try {
			return dmPortWharfFinder.findByPortRegionCodeOrderPortCode(portRegionCode, ascOrdesc);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}