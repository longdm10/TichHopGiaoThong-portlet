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

import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * @author win_64
 */
public class DmRankRatingLocalServiceClp implements DmRankRatingLocalService {
	public DmRankRatingLocalServiceClp(ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;

		_addDmRankRatingMethodKey0 = new MethodKey(_classLoaderProxy.getClassName(),
				"addDmRankRating", vn.gt.dao.danhmuc.model.DmRankRating.class);

		_createDmRankRatingMethodKey1 = new MethodKey(_classLoaderProxy.getClassName(),
				"createDmRankRating", int.class);

		_deleteDmRankRatingMethodKey2 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteDmRankRating", int.class);

		_deleteDmRankRatingMethodKey3 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteDmRankRating", vn.gt.dao.danhmuc.model.DmRankRating.class);

		_dynamicQueryMethodKey4 = new MethodKey(_classLoaderProxy.getClassName(),
				"dynamicQuery",
				com.liferay.portal.kernel.dao.orm.DynamicQuery.class);

		_dynamicQueryMethodKey5 = new MethodKey(_classLoaderProxy.getClassName(),
				"dynamicQuery",
				com.liferay.portal.kernel.dao.orm.DynamicQuery.class,
				int.class, int.class);

		_dynamicQueryMethodKey6 = new MethodKey(_classLoaderProxy.getClassName(),
				"dynamicQuery",
				com.liferay.portal.kernel.dao.orm.DynamicQuery.class,
				int.class, int.class,
				com.liferay.portal.kernel.util.OrderByComparator.class);

		_dynamicQueryCountMethodKey7 = new MethodKey(_classLoaderProxy.getClassName(),
				"dynamicQueryCount",
				com.liferay.portal.kernel.dao.orm.DynamicQuery.class);

		_fetchDmRankRatingMethodKey8 = new MethodKey(_classLoaderProxy.getClassName(),
				"fetchDmRankRating", int.class);

		_getDmRankRatingMethodKey9 = new MethodKey(_classLoaderProxy.getClassName(),
				"getDmRankRating", int.class);

		_getPersistedModelMethodKey10 = new MethodKey(_classLoaderProxy.getClassName(),
				"getPersistedModel", java.io.Serializable.class);

		_getDmRankRatingsMethodKey11 = new MethodKey(_classLoaderProxy.getClassName(),
				"getDmRankRatings", int.class, int.class);

		_getDmRankRatingsCountMethodKey12 = new MethodKey(_classLoaderProxy.getClassName(),
				"getDmRankRatingsCount");

		_updateDmRankRatingMethodKey13 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateDmRankRating", vn.gt.dao.danhmuc.model.DmRankRating.class);

		_updateDmRankRatingMethodKey14 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateDmRankRating",
				vn.gt.dao.danhmuc.model.DmRankRating.class, boolean.class);

		_getBeanIdentifierMethodKey15 = new MethodKey(_classLoaderProxy.getClassName(),
				"getBeanIdentifier");

		_setBeanIdentifierMethodKey16 = new MethodKey(_classLoaderProxy.getClassName(),
				"setBeanIdentifier", java.lang.String.class);

		_getByRankCodeMethodKey17 = new MethodKey(_classLoaderProxy.getClassName(),
				"getByRankCode", java.lang.String.class);
	}

	public vn.gt.dao.danhmuc.model.DmRankRating addDmRankRating(
		vn.gt.dao.danhmuc.model.DmRankRating dmRankRating)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addDmRankRatingMethodKey0,
				ClpSerializer.translateInput(dmRankRating));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (vn.gt.dao.danhmuc.model.DmRankRating)ClpSerializer.translateOutput(returnObj);
	}

	public vn.gt.dao.danhmuc.model.DmRankRating createDmRankRating(int id) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_createDmRankRatingMethodKey1,
				id);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (vn.gt.dao.danhmuc.model.DmRankRating)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteDmRankRating(int id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteDmRankRatingMethodKey2,
				id);

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public void deleteDmRankRating(
		vn.gt.dao.danhmuc.model.DmRankRating dmRankRating)
		throws com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteDmRankRatingMethodKey3,
				ClpSerializer.translateInput(dmRankRating));

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_dynamicQueryMethodKey4,
				ClpSerializer.translateInput(dynamicQuery));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_dynamicQueryMethodKey5,
				ClpSerializer.translateInput(dynamicQuery), start, end);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_dynamicQueryMethodKey6,
				ClpSerializer.translateInput(dynamicQuery), start, end,
				ClpSerializer.translateInput(orderByComparator));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_dynamicQueryCountMethodKey7,
				ClpSerializer.translateInput(dynamicQuery));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Long)returnObj).longValue();
	}

	public vn.gt.dao.danhmuc.model.DmRankRating fetchDmRankRating(int id)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_fetchDmRankRatingMethodKey8,
				id);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (vn.gt.dao.danhmuc.model.DmRankRating)ClpSerializer.translateOutput(returnObj);
	}

	public vn.gt.dao.danhmuc.model.DmRankRating getDmRankRating(int id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getDmRankRatingMethodKey9,
				id);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (vn.gt.dao.danhmuc.model.DmRankRating)ClpSerializer.translateOutput(returnObj);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getPersistedModelMethodKey10,
				ClpSerializer.translateInput(primaryKeyObj));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.portal.model.PersistedModel)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<vn.gt.dao.danhmuc.model.DmRankRating> getDmRankRatings(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getDmRankRatingsMethodKey11,
				start, end);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<vn.gt.dao.danhmuc.model.DmRankRating>)ClpSerializer.translateOutput(returnObj);
	}

	public int getDmRankRatingsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getDmRankRatingsCountMethodKey12);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	public vn.gt.dao.danhmuc.model.DmRankRating updateDmRankRating(
		vn.gt.dao.danhmuc.model.DmRankRating dmRankRating)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateDmRankRatingMethodKey13,
				ClpSerializer.translateInput(dmRankRating));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (vn.gt.dao.danhmuc.model.DmRankRating)ClpSerializer.translateOutput(returnObj);
	}

	public vn.gt.dao.danhmuc.model.DmRankRating updateDmRankRating(
		vn.gt.dao.danhmuc.model.DmRankRating dmRankRating, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateDmRankRatingMethodKey14,
				ClpSerializer.translateInput(dmRankRating), merge);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (vn.gt.dao.danhmuc.model.DmRankRating)ClpSerializer.translateOutput(returnObj);
	}

	public java.lang.String getBeanIdentifier() {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getBeanIdentifierMethodKey15);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		MethodHandler methodHandler = new MethodHandler(_setBeanIdentifierMethodKey16,
				ClpSerializer.translateInput(beanIdentifier));

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public vn.gt.dao.danhmuc.model.DmRankRating getByRankCode(
		java.lang.String rankCode) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getByRankCodeMethodKey17,
				ClpSerializer.translateInput(rankCode));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (vn.gt.dao.danhmuc.model.DmRankRating)ClpSerializer.translateOutput(returnObj);
	}

	public ClassLoaderProxy getClassLoaderProxy() {
		return _classLoaderProxy;
	}

	private ClassLoaderProxy _classLoaderProxy;
	private MethodKey _addDmRankRatingMethodKey0;
	private MethodKey _createDmRankRatingMethodKey1;
	private MethodKey _deleteDmRankRatingMethodKey2;
	private MethodKey _deleteDmRankRatingMethodKey3;
	private MethodKey _dynamicQueryMethodKey4;
	private MethodKey _dynamicQueryMethodKey5;
	private MethodKey _dynamicQueryMethodKey6;
	private MethodKey _dynamicQueryCountMethodKey7;
	private MethodKey _fetchDmRankRatingMethodKey8;
	private MethodKey _getDmRankRatingMethodKey9;
	private MethodKey _getPersistedModelMethodKey10;
	private MethodKey _getDmRankRatingsMethodKey11;
	private MethodKey _getDmRankRatingsCountMethodKey12;
	private MethodKey _updateDmRankRatingMethodKey13;
	private MethodKey _updateDmRankRatingMethodKey14;
	private MethodKey _getBeanIdentifierMethodKey15;
	private MethodKey _setBeanIdentifierMethodKey16;
	private MethodKey _getByRankCodeMethodKey17;
}