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

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;

import vn.gt.dao.danhmuc.model.DmMaritime;
import vn.gt.dao.danhmuc.service.base.DmMaritimeLocalServiceBaseImpl;

/**
 * The implementation of the dm maritime local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link vn.gt.dao.danhmuc.service.DmMaritimeLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author win_64
 * @see vn.gt.dao.danhmuc.service.base.DmMaritimeLocalServiceBaseImpl
 * @see vn.gt.dao.danhmuc.service.DmMaritimeLocalServiceUtil
 */
public class DmMaritimeLocalServiceImpl extends DmMaritimeLocalServiceBaseImpl {

	/**
	 * Returns all the dm maritimes.
	 *
	 * @return the dm maritimes
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public java.util.List<vn.gt.dao.danhmuc.model.DmMaritime> findAll() {
		try {
			return dmMaritimePersistence.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Returns a range of all the dm maritimes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of
	 * <code>end - start</code> instances. <code>start</code> and
	 * <code>end</code> are not primary keys, they are indexes in the result
	 * set. Thus, <code>0</code> refers to the first result in the set. Setting
	 * both <code>start</code> and <code>end</code> to
	 * {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return
	 * the full result set.
	 * </p>
	 *
	 * @param start
	 *            the lower bound of the range of dm maritimes
	 * @param end
	 *            the upper bound of the range of dm maritimes (not inclusive)
	 * @return the range of dm maritimes
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public List<DmMaritime> findAll(int start, int end) {
		try {
			return dmMaritimePersistence.findAll(start, end);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * vn.gt.dao.danhmuc.service.DmMaritimeLocalServiceUtil} to access the dm
	 * maritime local service.
	 */

	public DmMaritime getByMaritimeCode(String maritimeCode) {
		try {
			List<DmMaritime> dmMaritimes = dmMaritimePersistence.findByMaritimeCode(maritimeCode);
			if (dmMaritimes != null && dmMaritimes.size() > 0) {
				return dmMaritimes.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Returns the number of dm maritimes where maritimeCode = &#63;.
	 *
	 * @param maritimeCode
	 *            the maritime code
	 * @return the number of matching dm maritimes
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public int countByMaritimeCode(java.lang.String maritimeCode) {
		try {
			return dmMaritimePersistence.countByMaritimeCode(maritimeCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<DmMaritime> findRangeOrderBy(int start, int end, OrderByComparator orderByComparator) {
		try {
			return dmMaritimePersistence.findAll(start, end, orderByComparator);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<DmMaritime> getAll() {
		try {
			return dmMaritimeFinder.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<DmMaritime>();
	}
}