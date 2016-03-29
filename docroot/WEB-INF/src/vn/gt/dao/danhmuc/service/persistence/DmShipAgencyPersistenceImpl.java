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

package vn.gt.dao.danhmuc.service.persistence;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import vn.gt.dao.danhmuc.NoSuchDmShipAgencyException;
import vn.gt.dao.danhmuc.model.DmShipAgency;
import vn.gt.dao.danhmuc.model.impl.DmShipAgencyImpl;
import vn.gt.dao.danhmuc.model.impl.DmShipAgencyModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the dm ship agency service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author win_64
 * @see DmShipAgencyPersistence
 * @see DmShipAgencyUtil
 * @generated
 */
public class DmShipAgencyPersistenceImpl extends BasePersistenceImpl<DmShipAgency>
	implements DmShipAgencyPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DmShipAgencyUtil} to access the dm ship agency persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DmShipAgencyImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SHIPAGENCYCODE =
		new FinderPath(DmShipAgencyModelImpl.ENTITY_CACHE_ENABLED,
			DmShipAgencyModelImpl.FINDER_CACHE_ENABLED, DmShipAgencyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByShipAgencyCode",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SHIPAGENCYCODE =
		new FinderPath(DmShipAgencyModelImpl.ENTITY_CACHE_ENABLED,
			DmShipAgencyModelImpl.FINDER_CACHE_ENABLED, DmShipAgencyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByShipAgencyCode",
			new String[] { String.class.getName() },
			DmShipAgencyModelImpl.SHIPAGENCYCODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SHIPAGENCYCODE = new FinderPath(DmShipAgencyModelImpl.ENTITY_CACHE_ENABLED,
			DmShipAgencyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByShipAgencyCode",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DmShipAgencyModelImpl.ENTITY_CACHE_ENABLED,
			DmShipAgencyModelImpl.FINDER_CACHE_ENABLED, DmShipAgencyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DmShipAgencyModelImpl.ENTITY_CACHE_ENABLED,
			DmShipAgencyModelImpl.FINDER_CACHE_ENABLED, DmShipAgencyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DmShipAgencyModelImpl.ENTITY_CACHE_ENABLED,
			DmShipAgencyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the dm ship agency in the entity cache if it is enabled.
	 *
	 * @param dmShipAgency the dm ship agency
	 */
	public void cacheResult(DmShipAgency dmShipAgency) {
		EntityCacheUtil.putResult(DmShipAgencyModelImpl.ENTITY_CACHE_ENABLED,
			DmShipAgencyImpl.class, dmShipAgency.getPrimaryKey(), dmShipAgency);

		dmShipAgency.resetOriginalValues();
	}

	/**
	 * Caches the dm ship agencies in the entity cache if it is enabled.
	 *
	 * @param dmShipAgencies the dm ship agencies
	 */
	public void cacheResult(List<DmShipAgency> dmShipAgencies) {
		for (DmShipAgency dmShipAgency : dmShipAgencies) {
			if (EntityCacheUtil.getResult(
						DmShipAgencyModelImpl.ENTITY_CACHE_ENABLED,
						DmShipAgencyImpl.class, dmShipAgency.getPrimaryKey()) == null) {
				cacheResult(dmShipAgency);
			}
			else {
				dmShipAgency.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all dm ship agencies.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DmShipAgencyImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DmShipAgencyImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the dm ship agency.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DmShipAgency dmShipAgency) {
		EntityCacheUtil.removeResult(DmShipAgencyModelImpl.ENTITY_CACHE_ENABLED,
			DmShipAgencyImpl.class, dmShipAgency.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<DmShipAgency> dmShipAgencies) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DmShipAgency dmShipAgency : dmShipAgencies) {
			EntityCacheUtil.removeResult(DmShipAgencyModelImpl.ENTITY_CACHE_ENABLED,
				DmShipAgencyImpl.class, dmShipAgency.getPrimaryKey());
		}
	}

	/**
	 * Creates a new dm ship agency with the primary key. Does not add the dm ship agency to the database.
	 *
	 * @param id the primary key for the new dm ship agency
	 * @return the new dm ship agency
	 */
	public DmShipAgency create(int id) {
		DmShipAgency dmShipAgency = new DmShipAgencyImpl();

		dmShipAgency.setNew(true);
		dmShipAgency.setPrimaryKey(id);

		return dmShipAgency;
	}

	/**
	 * Removes the dm ship agency with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the dm ship agency
	 * @return the dm ship agency that was removed
	 * @throws vn.gt.dao.danhmuc.NoSuchDmShipAgencyException if a dm ship agency with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DmShipAgency remove(int id)
		throws NoSuchDmShipAgencyException, SystemException {
		return remove(Integer.valueOf(id));
	}

	/**
	 * Removes the dm ship agency with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dm ship agency
	 * @return the dm ship agency that was removed
	 * @throws vn.gt.dao.danhmuc.NoSuchDmShipAgencyException if a dm ship agency with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DmShipAgency remove(Serializable primaryKey)
		throws NoSuchDmShipAgencyException, SystemException {
		Session session = null;

		try {
			session = openSession();

			DmShipAgency dmShipAgency = (DmShipAgency)session.get(DmShipAgencyImpl.class,
					primaryKey);

			if (dmShipAgency == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDmShipAgencyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(dmShipAgency);
		}
		catch (NoSuchDmShipAgencyException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected DmShipAgency removeImpl(DmShipAgency dmShipAgency)
		throws SystemException {
		dmShipAgency = toUnwrappedModel(dmShipAgency);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, dmShipAgency);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(dmShipAgency);

		return dmShipAgency;
	}

	@Override
	public DmShipAgency updateImpl(
		vn.gt.dao.danhmuc.model.DmShipAgency dmShipAgency, boolean merge)
		throws SystemException {
		dmShipAgency = toUnwrappedModel(dmShipAgency);

		boolean isNew = dmShipAgency.isNew();

		DmShipAgencyModelImpl dmShipAgencyModelImpl = (DmShipAgencyModelImpl)dmShipAgency;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, dmShipAgency, merge);

			dmShipAgency.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !DmShipAgencyModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((dmShipAgencyModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SHIPAGENCYCODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						dmShipAgencyModelImpl.getOriginalShipAgencyCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SHIPAGENCYCODE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SHIPAGENCYCODE,
					args);

				args = new Object[] { dmShipAgencyModelImpl.getShipAgencyCode() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SHIPAGENCYCODE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SHIPAGENCYCODE,
					args);
			}
		}

		EntityCacheUtil.putResult(DmShipAgencyModelImpl.ENTITY_CACHE_ENABLED,
			DmShipAgencyImpl.class, dmShipAgency.getPrimaryKey(), dmShipAgency);

		return dmShipAgency;
	}

	protected DmShipAgency toUnwrappedModel(DmShipAgency dmShipAgency) {
		if (dmShipAgency instanceof DmShipAgencyImpl) {
			return dmShipAgency;
		}

		DmShipAgencyImpl dmShipAgencyImpl = new DmShipAgencyImpl();

		dmShipAgencyImpl.setNew(dmShipAgency.isNew());
		dmShipAgencyImpl.setPrimaryKey(dmShipAgency.getPrimaryKey());

		dmShipAgencyImpl.setId(dmShipAgency.getId());
		dmShipAgencyImpl.setShipAgencyCode(dmShipAgency.getShipAgencyCode());
		dmShipAgencyImpl.setShipAgencyName(dmShipAgency.getShipAgencyName());
		dmShipAgencyImpl.setShipAgencyNameVN(dmShipAgency.getShipAgencyNameVN());
		dmShipAgencyImpl.setTaxCode(dmShipAgency.getTaxCode());
		dmShipAgencyImpl.setStateCode(dmShipAgency.getStateCode());
		dmShipAgencyImpl.setCitycode(dmShipAgency.getCitycode());
		dmShipAgencyImpl.setAddress(dmShipAgency.getAddress());
		dmShipAgencyImpl.setAddressVN(dmShipAgency.getAddressVN());
		dmShipAgencyImpl.setPhone(dmShipAgency.getPhone());
		dmShipAgencyImpl.setFax(dmShipAgency.getFax());
		dmShipAgencyImpl.setEmail(dmShipAgency.getEmail());
		dmShipAgencyImpl.setDescription(dmShipAgency.getDescription());
		dmShipAgencyImpl.setContacter(dmShipAgency.getContacter());
		dmShipAgencyImpl.setPosition(dmShipAgency.getPosition());
		dmShipAgencyImpl.setContactTell(dmShipAgency.getContactTell());
		dmShipAgencyImpl.setIsDelete(dmShipAgency.getIsDelete());
		dmShipAgencyImpl.setMarkedAsDelete(dmShipAgency.getMarkedAsDelete());
		dmShipAgencyImpl.setModifiedDate(dmShipAgency.getModifiedDate());
		dmShipAgencyImpl.setRequestedDate(dmShipAgency.getRequestedDate());
		dmShipAgencyImpl.setSyncVersion(dmShipAgency.getSyncVersion());

		return dmShipAgencyImpl;
	}

	/**
	 * Returns the dm ship agency with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the dm ship agency
	 * @return the dm ship agency
	 * @throws com.liferay.portal.NoSuchModelException if a dm ship agency with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DmShipAgency findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Integer)primaryKey).intValue());
	}

	/**
	 * Returns the dm ship agency with the primary key or throws a {@link vn.gt.dao.danhmuc.NoSuchDmShipAgencyException} if it could not be found.
	 *
	 * @param id the primary key of the dm ship agency
	 * @return the dm ship agency
	 * @throws vn.gt.dao.danhmuc.NoSuchDmShipAgencyException if a dm ship agency with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DmShipAgency findByPrimaryKey(int id)
		throws NoSuchDmShipAgencyException, SystemException {
		DmShipAgency dmShipAgency = fetchByPrimaryKey(id);

		if (dmShipAgency == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchDmShipAgencyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return dmShipAgency;
	}

	/**
	 * Returns the dm ship agency with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dm ship agency
	 * @return the dm ship agency, or <code>null</code> if a dm ship agency with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DmShipAgency fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Integer)primaryKey).intValue());
	}

	/**
	 * Returns the dm ship agency with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the dm ship agency
	 * @return the dm ship agency, or <code>null</code> if a dm ship agency with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DmShipAgency fetchByPrimaryKey(int id) throws SystemException {
		DmShipAgency dmShipAgency = (DmShipAgency)EntityCacheUtil.getResult(DmShipAgencyModelImpl.ENTITY_CACHE_ENABLED,
				DmShipAgencyImpl.class, id);

		if (dmShipAgency == _nullDmShipAgency) {
			return null;
		}

		if (dmShipAgency == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				dmShipAgency = (DmShipAgency)session.get(DmShipAgencyImpl.class,
						Integer.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (dmShipAgency != null) {
					cacheResult(dmShipAgency);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(DmShipAgencyModelImpl.ENTITY_CACHE_ENABLED,
						DmShipAgencyImpl.class, id, _nullDmShipAgency);
				}

				closeSession(session);
			}
		}

		return dmShipAgency;
	}

	/**
	 * Returns all the dm ship agencies where shipAgencyCode = &#63;.
	 *
	 * @param shipAgencyCode the ship agency code
	 * @return the matching dm ship agencies
	 * @throws SystemException if a system exception occurred
	 */
	public List<DmShipAgency> findByShipAgencyCode(String shipAgencyCode)
		throws SystemException {
		return findByShipAgencyCode(shipAgencyCode, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dm ship agencies where shipAgencyCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param shipAgencyCode the ship agency code
	 * @param start the lower bound of the range of dm ship agencies
	 * @param end the upper bound of the range of dm ship agencies (not inclusive)
	 * @return the range of matching dm ship agencies
	 * @throws SystemException if a system exception occurred
	 */
	public List<DmShipAgency> findByShipAgencyCode(String shipAgencyCode,
		int start, int end) throws SystemException {
		return findByShipAgencyCode(shipAgencyCode, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dm ship agencies where shipAgencyCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param shipAgencyCode the ship agency code
	 * @param start the lower bound of the range of dm ship agencies
	 * @param end the upper bound of the range of dm ship agencies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dm ship agencies
	 * @throws SystemException if a system exception occurred
	 */
	public List<DmShipAgency> findByShipAgencyCode(String shipAgencyCode,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SHIPAGENCYCODE;
			finderArgs = new Object[] { shipAgencyCode };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SHIPAGENCYCODE;
			finderArgs = new Object[] {
					shipAgencyCode,
					
					start, end, orderByComparator
				};
		}

		List<DmShipAgency> list = (List<DmShipAgency>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_DMSHIPAGENCY_WHERE);

			if (shipAgencyCode == null) {
				query.append(_FINDER_COLUMN_SHIPAGENCYCODE_SHIPAGENCYCODE_1);
			}
			else {
				if (shipAgencyCode.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_SHIPAGENCYCODE_SHIPAGENCYCODE_3);
				}
				else {
					query.append(_FINDER_COLUMN_SHIPAGENCYCODE_SHIPAGENCYCODE_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(DmShipAgencyModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (shipAgencyCode != null) {
					qPos.add(shipAgencyCode);
				}

				list = (List<DmShipAgency>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first dm ship agency in the ordered set where shipAgencyCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param shipAgencyCode the ship agency code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dm ship agency
	 * @throws vn.gt.dao.danhmuc.NoSuchDmShipAgencyException if a matching dm ship agency could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DmShipAgency findByShipAgencyCode_First(String shipAgencyCode,
		OrderByComparator orderByComparator)
		throws NoSuchDmShipAgencyException, SystemException {
		List<DmShipAgency> list = findByShipAgencyCode(shipAgencyCode, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("shipAgencyCode=");
			msg.append(shipAgencyCode);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchDmShipAgencyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last dm ship agency in the ordered set where shipAgencyCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param shipAgencyCode the ship agency code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dm ship agency
	 * @throws vn.gt.dao.danhmuc.NoSuchDmShipAgencyException if a matching dm ship agency could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DmShipAgency findByShipAgencyCode_Last(String shipAgencyCode,
		OrderByComparator orderByComparator)
		throws NoSuchDmShipAgencyException, SystemException {
		int count = countByShipAgencyCode(shipAgencyCode);

		List<DmShipAgency> list = findByShipAgencyCode(shipAgencyCode,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("shipAgencyCode=");
			msg.append(shipAgencyCode);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchDmShipAgencyException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the dm ship agencies before and after the current dm ship agency in the ordered set where shipAgencyCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current dm ship agency
	 * @param shipAgencyCode the ship agency code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dm ship agency
	 * @throws vn.gt.dao.danhmuc.NoSuchDmShipAgencyException if a dm ship agency with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DmShipAgency[] findByShipAgencyCode_PrevAndNext(int id,
		String shipAgencyCode, OrderByComparator orderByComparator)
		throws NoSuchDmShipAgencyException, SystemException {
		DmShipAgency dmShipAgency = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			DmShipAgency[] array = new DmShipAgencyImpl[3];

			array[0] = getByShipAgencyCode_PrevAndNext(session, dmShipAgency,
					shipAgencyCode, orderByComparator, true);

			array[1] = dmShipAgency;

			array[2] = getByShipAgencyCode_PrevAndNext(session, dmShipAgency,
					shipAgencyCode, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DmShipAgency getByShipAgencyCode_PrevAndNext(Session session,
		DmShipAgency dmShipAgency, String shipAgencyCode,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DMSHIPAGENCY_WHERE);

		if (shipAgencyCode == null) {
			query.append(_FINDER_COLUMN_SHIPAGENCYCODE_SHIPAGENCYCODE_1);
		}
		else {
			if (shipAgencyCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SHIPAGENCYCODE_SHIPAGENCYCODE_3);
			}
			else {
				query.append(_FINDER_COLUMN_SHIPAGENCYCODE_SHIPAGENCYCODE_2);
			}
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(DmShipAgencyModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (shipAgencyCode != null) {
			qPos.add(shipAgencyCode);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(dmShipAgency);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DmShipAgency> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the dm ship agencies.
	 *
	 * @return the dm ship agencies
	 * @throws SystemException if a system exception occurred
	 */
	public List<DmShipAgency> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dm ship agencies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of dm ship agencies
	 * @param end the upper bound of the range of dm ship agencies (not inclusive)
	 * @return the range of dm ship agencies
	 * @throws SystemException if a system exception occurred
	 */
	public List<DmShipAgency> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the dm ship agencies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of dm ship agencies
	 * @param end the upper bound of the range of dm ship agencies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dm ship agencies
	 * @throws SystemException if a system exception occurred
	 */
	public List<DmShipAgency> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<DmShipAgency> list = (List<DmShipAgency>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DMSHIPAGENCY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DMSHIPAGENCY.concat(DmShipAgencyModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<DmShipAgency>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<DmShipAgency>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the dm ship agencies where shipAgencyCode = &#63; from the database.
	 *
	 * @param shipAgencyCode the ship agency code
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByShipAgencyCode(String shipAgencyCode)
		throws SystemException {
		for (DmShipAgency dmShipAgency : findByShipAgencyCode(shipAgencyCode)) {
			remove(dmShipAgency);
		}
	}

	/**
	 * Removes all the dm ship agencies from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (DmShipAgency dmShipAgency : findAll()) {
			remove(dmShipAgency);
		}
	}

	/**
	 * Returns the number of dm ship agencies where shipAgencyCode = &#63;.
	 *
	 * @param shipAgencyCode the ship agency code
	 * @return the number of matching dm ship agencies
	 * @throws SystemException if a system exception occurred
	 */
	public int countByShipAgencyCode(String shipAgencyCode)
		throws SystemException {
		Object[] finderArgs = new Object[] { shipAgencyCode };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_SHIPAGENCYCODE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DMSHIPAGENCY_WHERE);

			if (shipAgencyCode == null) {
				query.append(_FINDER_COLUMN_SHIPAGENCYCODE_SHIPAGENCYCODE_1);
			}
			else {
				if (shipAgencyCode.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_SHIPAGENCYCODE_SHIPAGENCYCODE_3);
				}
				else {
					query.append(_FINDER_COLUMN_SHIPAGENCYCODE_SHIPAGENCYCODE_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (shipAgencyCode != null) {
					qPos.add(shipAgencyCode);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SHIPAGENCYCODE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of dm ship agencies.
	 *
	 * @return the number of dm ship agencies
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DMSHIPAGENCY);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the dm ship agency persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.gt.dao.danhmuc.model.DmShipAgency")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<DmShipAgency>> listenersList = new ArrayList<ModelListener<DmShipAgency>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<DmShipAgency>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(DmShipAgencyImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = DmArrivalPurposePersistence.class)
	protected DmArrivalPurposePersistence dmArrivalPurposePersistence;
	@BeanReference(type = DmDocTypePersistence.class)
	protected DmDocTypePersistence dmDocTypePersistence;
	@BeanReference(type = DmEnterrisePersistence.class)
	protected DmEnterrisePersistence dmEnterrisePersistence;
	@BeanReference(type = DmGoodsPersistence.class)
	protected DmGoodsPersistence dmGoodsPersistence;
	@BeanReference(type = DmGoodsTypePersistence.class)
	protected DmGoodsTypePersistence dmGoodsTypePersistence;
	@BeanReference(type = DmHistoryArrivalPurposePersistence.class)
	protected DmHistoryArrivalPurposePersistence dmHistoryArrivalPurposePersistence;
	@BeanReference(type = DmHistoryDocTypePersistence.class)
	protected DmHistoryDocTypePersistence dmHistoryDocTypePersistence;
	@BeanReference(type = DmHistoryEnterrisePersistence.class)
	protected DmHistoryEnterrisePersistence dmHistoryEnterrisePersistence;
	@BeanReference(type = DmHistoryGoodsPersistence.class)
	protected DmHistoryGoodsPersistence dmHistoryGoodsPersistence;
	@BeanReference(type = DmHistoryGoodsTypePersistence.class)
	protected DmHistoryGoodsTypePersistence dmHistoryGoodsTypePersistence;
	@BeanReference(type = DmHistoryMaritimePersistence.class)
	protected DmHistoryMaritimePersistence dmHistoryMaritimePersistence;
	@BeanReference(type = DmHistoryPackagePersistence.class)
	protected DmHistoryPackagePersistence dmHistoryPackagePersistence;
	@BeanReference(type = DmHistoryPassportTypePersistence.class)
	protected DmHistoryPassportTypePersistence dmHistoryPassportTypePersistence;
	@BeanReference(type = DmHistoryPortPersistence.class)
	protected DmHistoryPortPersistence dmHistoryPortPersistence;
	@BeanReference(type = DmHistoryPortHarbourPersistence.class)
	protected DmHistoryPortHarbourPersistence dmHistoryPortHarbourPersistence;
	@BeanReference(type = DmHistoryPortRegionPersistence.class)
	protected DmHistoryPortRegionPersistence dmHistoryPortRegionPersistence;
	@BeanReference(type = DmHistoryPortWharfPersistence.class)
	protected DmHistoryPortWharfPersistence dmHistoryPortWharfPersistence;
	@BeanReference(type = DmHistoryRankRatingPersistence.class)
	protected DmHistoryRankRatingPersistence dmHistoryRankRatingPersistence;
	@BeanReference(type = DmHistoryRepresentativePersistence.class)
	protected DmHistoryRepresentativePersistence dmHistoryRepresentativePersistence;
	@BeanReference(type = DmHistorySecurityLevelPersistence.class)
	protected DmHistorySecurityLevelPersistence dmHistorySecurityLevelPersistence;
	@BeanReference(type = DmHistoryShipAgencyPersistence.class)
	protected DmHistoryShipAgencyPersistence dmHistoryShipAgencyPersistence;
	@BeanReference(type = DmHistoryShipTypePersistence.class)
	protected DmHistoryShipTypePersistence dmHistoryShipTypePersistence;
	@BeanReference(type = DmHistoryStatePersistence.class)
	protected DmHistoryStatePersistence dmHistoryStatePersistence;
	@BeanReference(type = DmHistoryUnitGeneralPersistence.class)
	protected DmHistoryUnitGeneralPersistence dmHistoryUnitGeneralPersistence;
	@BeanReference(type = DmMaritimePersistence.class)
	protected DmMaritimePersistence dmMaritimePersistence;
	@BeanReference(type = DmPackagePersistence.class)
	protected DmPackagePersistence dmPackagePersistence;
	@BeanReference(type = DmPassportTypePersistence.class)
	protected DmPassportTypePersistence dmPassportTypePersistence;
	@BeanReference(type = DmPortPersistence.class)
	protected DmPortPersistence dmPortPersistence;
	@BeanReference(type = DmPortHarbourPersistence.class)
	protected DmPortHarbourPersistence dmPortHarbourPersistence;
	@BeanReference(type = DmPortRegionPersistence.class)
	protected DmPortRegionPersistence dmPortRegionPersistence;
	@BeanReference(type = DmPortWharfPersistence.class)
	protected DmPortWharfPersistence dmPortWharfPersistence;
	@BeanReference(type = DmRankRatingPersistence.class)
	protected DmRankRatingPersistence dmRankRatingPersistence;
	@BeanReference(type = DmRepresentativePersistence.class)
	protected DmRepresentativePersistence dmRepresentativePersistence;
	@BeanReference(type = DmSecurityLevelPersistence.class)
	protected DmSecurityLevelPersistence dmSecurityLevelPersistence;
	@BeanReference(type = DmShipAgencyPersistence.class)
	protected DmShipAgencyPersistence dmShipAgencyPersistence;
	@BeanReference(type = DmShipTypePersistence.class)
	protected DmShipTypePersistence dmShipTypePersistence;
	@BeanReference(type = DmStatePersistence.class)
	protected DmStatePersistence dmStatePersistence;
	@BeanReference(type = DmSyncCategoryPersistence.class)
	protected DmSyncCategoryPersistence dmSyncCategoryPersistence;
	@BeanReference(type = DmTestN01RequestPersistence.class)
	protected DmTestN01RequestPersistence dmTestN01RequestPersistence;
	@BeanReference(type = DmUnitGeneralPersistence.class)
	protected DmUnitGeneralPersistence dmUnitGeneralPersistence;
	@BeanReference(type = HistoryRmdcShipPersistence.class)
	protected HistoryRmdcShipPersistence historyRmdcShipPersistence;
	@BeanReference(type = HistorySyncVersionPersistence.class)
	protected HistorySyncVersionPersistence historySyncVersionPersistence;
	@BeanReference(type = RmdcShipPersistence.class)
	protected RmdcShipPersistence rmdcShipPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_DMSHIPAGENCY = "SELECT dmShipAgency FROM DmShipAgency dmShipAgency";
	private static final String _SQL_SELECT_DMSHIPAGENCY_WHERE = "SELECT dmShipAgency FROM DmShipAgency dmShipAgency WHERE ";
	private static final String _SQL_COUNT_DMSHIPAGENCY = "SELECT COUNT(dmShipAgency) FROM DmShipAgency dmShipAgency";
	private static final String _SQL_COUNT_DMSHIPAGENCY_WHERE = "SELECT COUNT(dmShipAgency) FROM DmShipAgency dmShipAgency WHERE ";
	private static final String _FINDER_COLUMN_SHIPAGENCYCODE_SHIPAGENCYCODE_1 = "dmShipAgency.shipAgencyCode IS NULL";
	private static final String _FINDER_COLUMN_SHIPAGENCYCODE_SHIPAGENCYCODE_2 = "dmShipAgency.shipAgencyCode = ?";
	private static final String _FINDER_COLUMN_SHIPAGENCYCODE_SHIPAGENCYCODE_3 = "(dmShipAgency.shipAgencyCode IS NULL OR dmShipAgency.shipAgencyCode = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "dmShipAgency.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DmShipAgency exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No DmShipAgency exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DmShipAgencyPersistenceImpl.class);
	private static DmShipAgency _nullDmShipAgency = new DmShipAgencyImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<DmShipAgency> toCacheModel() {
				return _nullDmShipAgencyCacheModel;
			}
		};

	private static CacheModel<DmShipAgency> _nullDmShipAgencyCacheModel = new CacheModel<DmShipAgency>() {
			public DmShipAgency toEntityModel() {
				return _nullDmShipAgency;
			}
		};
}