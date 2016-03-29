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

package vn.gt.dao.noticeandmessage.service.persistence;

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

import vn.gt.dao.noticeandmessage.NoSuchTempDeclarationOfHealthException;
import vn.gt.dao.noticeandmessage.model.TempDeclarationOfHealth;
import vn.gt.dao.noticeandmessage.model.impl.TempDeclarationOfHealthImpl;
import vn.gt.dao.noticeandmessage.model.impl.TempDeclarationOfHealthModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the temp declaration of health service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author win_64
 * @see TempDeclarationOfHealthPersistence
 * @see TempDeclarationOfHealthUtil
 * @generated
 */
public class TempDeclarationOfHealthPersistenceImpl extends BasePersistenceImpl<TempDeclarationOfHealth>
	implements TempDeclarationOfHealthPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TempDeclarationOfHealthUtil} to access the temp declaration of health persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TempDeclarationOfHealthImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DOCUMENTNAMEANDDOCUMENTYEAR =
		new FinderPath(TempDeclarationOfHealthModelImpl.ENTITY_CACHE_ENABLED,
			TempDeclarationOfHealthModelImpl.FINDER_CACHE_ENABLED,
			TempDeclarationOfHealthImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBydocumentNameAnddocumentYear",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DOCUMENTNAMEANDDOCUMENTYEAR =
		new FinderPath(TempDeclarationOfHealthModelImpl.ENTITY_CACHE_ENABLED,
			TempDeclarationOfHealthModelImpl.FINDER_CACHE_ENABLED,
			TempDeclarationOfHealthImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBydocumentNameAnddocumentYear",
			new String[] { Long.class.getName(), Integer.class.getName() },
			TempDeclarationOfHealthModelImpl.DOCUMENTNAME_COLUMN_BITMASK |
			TempDeclarationOfHealthModelImpl.DOCUMENTYEAR_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DOCUMENTNAMEANDDOCUMENTYEAR =
		new FinderPath(TempDeclarationOfHealthModelImpl.ENTITY_CACHE_ENABLED,
			TempDeclarationOfHealthModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBydocumentNameAnddocumentYear",
			new String[] { Long.class.getName(), Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DOCUMENTNAMEANDDOCUMENTYEARREQUESTSTATE =
		new FinderPath(TempDeclarationOfHealthModelImpl.ENTITY_CACHE_ENABLED,
			TempDeclarationOfHealthModelImpl.FINDER_CACHE_ENABLED,
			TempDeclarationOfHealthImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBydocumentNameAnddocumentYearRequestState",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DOCUMENTNAMEANDDOCUMENTYEARREQUESTSTATE =
		new FinderPath(TempDeclarationOfHealthModelImpl.ENTITY_CACHE_ENABLED,
			TempDeclarationOfHealthModelImpl.FINDER_CACHE_ENABLED,
			TempDeclarationOfHealthImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBydocumentNameAnddocumentYearRequestState",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName()
			},
			TempDeclarationOfHealthModelImpl.DOCUMENTNAME_COLUMN_BITMASK |
			TempDeclarationOfHealthModelImpl.DOCUMENTYEAR_COLUMN_BITMASK |
			TempDeclarationOfHealthModelImpl.REQUESTSTATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DOCUMENTNAMEANDDOCUMENTYEARREQUESTSTATE =
		new FinderPath(TempDeclarationOfHealthModelImpl.ENTITY_CACHE_ENABLED,
			TempDeclarationOfHealthModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBydocumentNameAnddocumentYearRequestState",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_REQUESTCODE =
		new FinderPath(TempDeclarationOfHealthModelImpl.ENTITY_CACHE_ENABLED,
			TempDeclarationOfHealthModelImpl.FINDER_CACHE_ENABLED,
			TempDeclarationOfHealthImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRequestCode",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REQUESTCODE =
		new FinderPath(TempDeclarationOfHealthModelImpl.ENTITY_CACHE_ENABLED,
			TempDeclarationOfHealthModelImpl.FINDER_CACHE_ENABLED,
			TempDeclarationOfHealthImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRequestCode",
			new String[] { String.class.getName() },
			TempDeclarationOfHealthModelImpl.REQUESTCODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_REQUESTCODE = new FinderPath(TempDeclarationOfHealthModelImpl.ENTITY_CACHE_ENABLED,
			TempDeclarationOfHealthModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRequestCode",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TempDeclarationOfHealthModelImpl.ENTITY_CACHE_ENABLED,
			TempDeclarationOfHealthModelImpl.FINDER_CACHE_ENABLED,
			TempDeclarationOfHealthImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TempDeclarationOfHealthModelImpl.ENTITY_CACHE_ENABLED,
			TempDeclarationOfHealthModelImpl.FINDER_CACHE_ENABLED,
			TempDeclarationOfHealthImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TempDeclarationOfHealthModelImpl.ENTITY_CACHE_ENABLED,
			TempDeclarationOfHealthModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the temp declaration of health in the entity cache if it is enabled.
	 *
	 * @param tempDeclarationOfHealth the temp declaration of health
	 */
	public void cacheResult(TempDeclarationOfHealth tempDeclarationOfHealth) {
		EntityCacheUtil.putResult(TempDeclarationOfHealthModelImpl.ENTITY_CACHE_ENABLED,
			TempDeclarationOfHealthImpl.class,
			tempDeclarationOfHealth.getPrimaryKey(), tempDeclarationOfHealth);

		tempDeclarationOfHealth.resetOriginalValues();
	}

	/**
	 * Caches the temp declaration of healths in the entity cache if it is enabled.
	 *
	 * @param tempDeclarationOfHealths the temp declaration of healths
	 */
	public void cacheResult(
		List<TempDeclarationOfHealth> tempDeclarationOfHealths) {
		for (TempDeclarationOfHealth tempDeclarationOfHealth : tempDeclarationOfHealths) {
			if (EntityCacheUtil.getResult(
						TempDeclarationOfHealthModelImpl.ENTITY_CACHE_ENABLED,
						TempDeclarationOfHealthImpl.class,
						tempDeclarationOfHealth.getPrimaryKey()) == null) {
				cacheResult(tempDeclarationOfHealth);
			}
			else {
				tempDeclarationOfHealth.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all temp declaration of healths.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TempDeclarationOfHealthImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TempDeclarationOfHealthImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the temp declaration of health.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TempDeclarationOfHealth tempDeclarationOfHealth) {
		EntityCacheUtil.removeResult(TempDeclarationOfHealthModelImpl.ENTITY_CACHE_ENABLED,
			TempDeclarationOfHealthImpl.class,
			tempDeclarationOfHealth.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<TempDeclarationOfHealth> tempDeclarationOfHealths) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TempDeclarationOfHealth tempDeclarationOfHealth : tempDeclarationOfHealths) {
			EntityCacheUtil.removeResult(TempDeclarationOfHealthModelImpl.ENTITY_CACHE_ENABLED,
				TempDeclarationOfHealthImpl.class,
				tempDeclarationOfHealth.getPrimaryKey());
		}
	}

	/**
	 * Creates a new temp declaration of health with the primary key. Does not add the temp declaration of health to the database.
	 *
	 * @param id the primary key for the new temp declaration of health
	 * @return the new temp declaration of health
	 */
	public TempDeclarationOfHealth create(long id) {
		TempDeclarationOfHealth tempDeclarationOfHealth = new TempDeclarationOfHealthImpl();

		tempDeclarationOfHealth.setNew(true);
		tempDeclarationOfHealth.setPrimaryKey(id);

		return tempDeclarationOfHealth;
	}

	/**
	 * Removes the temp declaration of health with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the temp declaration of health
	 * @return the temp declaration of health that was removed
	 * @throws vn.gt.dao.noticeandmessage.NoSuchTempDeclarationOfHealthException if a temp declaration of health with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TempDeclarationOfHealth remove(long id)
		throws NoSuchTempDeclarationOfHealthException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the temp declaration of health with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the temp declaration of health
	 * @return the temp declaration of health that was removed
	 * @throws vn.gt.dao.noticeandmessage.NoSuchTempDeclarationOfHealthException if a temp declaration of health with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TempDeclarationOfHealth remove(Serializable primaryKey)
		throws NoSuchTempDeclarationOfHealthException, SystemException {
		Session session = null;

		try {
			session = openSession();

			TempDeclarationOfHealth tempDeclarationOfHealth = (TempDeclarationOfHealth)session.get(TempDeclarationOfHealthImpl.class,
					primaryKey);

			if (tempDeclarationOfHealth == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTempDeclarationOfHealthException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(tempDeclarationOfHealth);
		}
		catch (NoSuchTempDeclarationOfHealthException nsee) {
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
	protected TempDeclarationOfHealth removeImpl(
		TempDeclarationOfHealth tempDeclarationOfHealth)
		throws SystemException {
		tempDeclarationOfHealth = toUnwrappedModel(tempDeclarationOfHealth);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, tempDeclarationOfHealth);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(tempDeclarationOfHealth);

		return tempDeclarationOfHealth;
	}

	@Override
	public TempDeclarationOfHealth updateImpl(
		vn.gt.dao.noticeandmessage.model.TempDeclarationOfHealth tempDeclarationOfHealth,
		boolean merge) throws SystemException {
		tempDeclarationOfHealth = toUnwrappedModel(tempDeclarationOfHealth);

		boolean isNew = tempDeclarationOfHealth.isNew();

		TempDeclarationOfHealthModelImpl tempDeclarationOfHealthModelImpl = (TempDeclarationOfHealthModelImpl)tempDeclarationOfHealth;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, tempDeclarationOfHealth, merge);

			tempDeclarationOfHealth.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TempDeclarationOfHealthModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((tempDeclarationOfHealthModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DOCUMENTNAMEANDDOCUMENTYEAR.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(tempDeclarationOfHealthModelImpl.getOriginalDocumentName()),
						Integer.valueOf(tempDeclarationOfHealthModelImpl.getOriginalDocumentYear())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DOCUMENTNAMEANDDOCUMENTYEAR,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DOCUMENTNAMEANDDOCUMENTYEAR,
					args);

				args = new Object[] {
						Long.valueOf(tempDeclarationOfHealthModelImpl.getDocumentName()),
						Integer.valueOf(tempDeclarationOfHealthModelImpl.getDocumentYear())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DOCUMENTNAMEANDDOCUMENTYEAR,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DOCUMENTNAMEANDDOCUMENTYEAR,
					args);
			}

			if ((tempDeclarationOfHealthModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DOCUMENTNAMEANDDOCUMENTYEARREQUESTSTATE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(tempDeclarationOfHealthModelImpl.getOriginalDocumentName()),
						Integer.valueOf(tempDeclarationOfHealthModelImpl.getOriginalDocumentYear()),
						Integer.valueOf(tempDeclarationOfHealthModelImpl.getOriginalRequestState())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DOCUMENTNAMEANDDOCUMENTYEARREQUESTSTATE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DOCUMENTNAMEANDDOCUMENTYEARREQUESTSTATE,
					args);

				args = new Object[] {
						Long.valueOf(tempDeclarationOfHealthModelImpl.getDocumentName()),
						Integer.valueOf(tempDeclarationOfHealthModelImpl.getDocumentYear()),
						Integer.valueOf(tempDeclarationOfHealthModelImpl.getRequestState())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DOCUMENTNAMEANDDOCUMENTYEARREQUESTSTATE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DOCUMENTNAMEANDDOCUMENTYEARREQUESTSTATE,
					args);
			}

			if ((tempDeclarationOfHealthModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REQUESTCODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						tempDeclarationOfHealthModelImpl.getOriginalRequestCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_REQUESTCODE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REQUESTCODE,
					args);

				args = new Object[] {
						tempDeclarationOfHealthModelImpl.getRequestCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_REQUESTCODE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REQUESTCODE,
					args);
			}
		}

		EntityCacheUtil.putResult(TempDeclarationOfHealthModelImpl.ENTITY_CACHE_ENABLED,
			TempDeclarationOfHealthImpl.class,
			tempDeclarationOfHealth.getPrimaryKey(), tempDeclarationOfHealth);

		return tempDeclarationOfHealth;
	}

	protected TempDeclarationOfHealth toUnwrappedModel(
		TempDeclarationOfHealth tempDeclarationOfHealth) {
		if (tempDeclarationOfHealth instanceof TempDeclarationOfHealthImpl) {
			return tempDeclarationOfHealth;
		}

		TempDeclarationOfHealthImpl tempDeclarationOfHealthImpl = new TempDeclarationOfHealthImpl();

		tempDeclarationOfHealthImpl.setNew(tempDeclarationOfHealth.isNew());
		tempDeclarationOfHealthImpl.setPrimaryKey(tempDeclarationOfHealth.getPrimaryKey());

		tempDeclarationOfHealthImpl.setId(tempDeclarationOfHealth.getId());
		tempDeclarationOfHealthImpl.setRequestCode(tempDeclarationOfHealth.getRequestCode());
		tempDeclarationOfHealthImpl.setRequestState(tempDeclarationOfHealth.getRequestState());
		tempDeclarationOfHealthImpl.setDocumentName(tempDeclarationOfHealth.getDocumentName());
		tempDeclarationOfHealthImpl.setDocumentYear(tempDeclarationOfHealth.getDocumentYear());
		tempDeclarationOfHealthImpl.setUserCreated(tempDeclarationOfHealth.getUserCreated());
		tempDeclarationOfHealthImpl.setSubmittedPortCode(tempDeclarationOfHealth.getSubmittedPortCode());
		tempDeclarationOfHealthImpl.setDateSubmitted(tempDeclarationOfHealth.getDateSubmitted());
		tempDeclarationOfHealthImpl.setNameOfShip(tempDeclarationOfHealth.getNameOfShip());
		tempDeclarationOfHealthImpl.setRegistration(tempDeclarationOfHealth.getRegistration());
		tempDeclarationOfHealthImpl.setImoNumber(tempDeclarationOfHealth.getImoNumber());
		tempDeclarationOfHealthImpl.setArrivingFrom(tempDeclarationOfHealth.getArrivingFrom());
		tempDeclarationOfHealthImpl.setSailingTo(tempDeclarationOfHealth.getSailingTo());
		tempDeclarationOfHealthImpl.setNationality(tempDeclarationOfHealth.getNationality());
		tempDeclarationOfHealthImpl.setMasterName(tempDeclarationOfHealth.getMasterName());
		tempDeclarationOfHealthImpl.setGrossTonnage(tempDeclarationOfHealth.getGrossTonnage());
		tempDeclarationOfHealthImpl.setGrossTonnageUnit(tempDeclarationOfHealth.getGrossTonnageUnit());
		tempDeclarationOfHealthImpl.setTonnage(tempDeclarationOfHealth.getTonnage());
		tempDeclarationOfHealthImpl.setTonnageUnit(tempDeclarationOfHealth.getTonnageUnit());
		tempDeclarationOfHealthImpl.setCertificatecarried(tempDeclarationOfHealth.getCertificatecarried());
		tempDeclarationOfHealthImpl.setIssuedAt(tempDeclarationOfHealth.getIssuedAt());
		tempDeclarationOfHealthImpl.setIssueDate(tempDeclarationOfHealth.getIssueDate());
		tempDeclarationOfHealthImpl.setReInspectionrequired(tempDeclarationOfHealth.getReInspectionrequired());
		tempDeclarationOfHealthImpl.setIsShipVisitedWHO(tempDeclarationOfHealth.getIsShipVisitedWHO());
		tempDeclarationOfHealthImpl.setVisitedWHOPortCode(tempDeclarationOfHealth.getVisitedWHOPortCode());
		tempDeclarationOfHealthImpl.setDateOfVisitedWHO(tempDeclarationOfHealth.getDateOfVisitedWHO());
		tempDeclarationOfHealthImpl.setListPortName(tempDeclarationOfHealth.getListPortName());
		tempDeclarationOfHealthImpl.setDoctorName(tempDeclarationOfHealth.getDoctorName());
		tempDeclarationOfHealthImpl.setDoctorSigndate(tempDeclarationOfHealth.getDoctorSigndate());
		tempDeclarationOfHealthImpl.setSignPlace(tempDeclarationOfHealth.getSignPlace());
		tempDeclarationOfHealthImpl.setSignDate(tempDeclarationOfHealth.getSignDate());
		tempDeclarationOfHealthImpl.setMasterSigned(tempDeclarationOfHealth.getMasterSigned());
		tempDeclarationOfHealthImpl.setMasterSignedImage(tempDeclarationOfHealth.getMasterSignedImage());
		tempDeclarationOfHealthImpl.setAttachedFile(tempDeclarationOfHealth.getAttachedFile());

		return tempDeclarationOfHealthImpl;
	}

	/**
	 * Returns the temp declaration of health with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the temp declaration of health
	 * @return the temp declaration of health
	 * @throws com.liferay.portal.NoSuchModelException if a temp declaration of health with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TempDeclarationOfHealth findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the temp declaration of health with the primary key or throws a {@link vn.gt.dao.noticeandmessage.NoSuchTempDeclarationOfHealthException} if it could not be found.
	 *
	 * @param id the primary key of the temp declaration of health
	 * @return the temp declaration of health
	 * @throws vn.gt.dao.noticeandmessage.NoSuchTempDeclarationOfHealthException if a temp declaration of health with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TempDeclarationOfHealth findByPrimaryKey(long id)
		throws NoSuchTempDeclarationOfHealthException, SystemException {
		TempDeclarationOfHealth tempDeclarationOfHealth = fetchByPrimaryKey(id);

		if (tempDeclarationOfHealth == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchTempDeclarationOfHealthException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return tempDeclarationOfHealth;
	}

	/**
	 * Returns the temp declaration of health with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the temp declaration of health
	 * @return the temp declaration of health, or <code>null</code> if a temp declaration of health with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TempDeclarationOfHealth fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the temp declaration of health with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the temp declaration of health
	 * @return the temp declaration of health, or <code>null</code> if a temp declaration of health with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TempDeclarationOfHealth fetchByPrimaryKey(long id)
		throws SystemException {
		TempDeclarationOfHealth tempDeclarationOfHealth = (TempDeclarationOfHealth)EntityCacheUtil.getResult(TempDeclarationOfHealthModelImpl.ENTITY_CACHE_ENABLED,
				TempDeclarationOfHealthImpl.class, id);

		if (tempDeclarationOfHealth == _nullTempDeclarationOfHealth) {
			return null;
		}

		if (tempDeclarationOfHealth == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				tempDeclarationOfHealth = (TempDeclarationOfHealth)session.get(TempDeclarationOfHealthImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (tempDeclarationOfHealth != null) {
					cacheResult(tempDeclarationOfHealth);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(TempDeclarationOfHealthModelImpl.ENTITY_CACHE_ENABLED,
						TempDeclarationOfHealthImpl.class, id,
						_nullTempDeclarationOfHealth);
				}

				closeSession(session);
			}
		}

		return tempDeclarationOfHealth;
	}

	/**
	 * Returns all the temp declaration of healths where documentName = &#63; and documentYear = &#63;.
	 *
	 * @param documentName the document name
	 * @param documentYear the document year
	 * @return the matching temp declaration of healths
	 * @throws SystemException if a system exception occurred
	 */
	public List<TempDeclarationOfHealth> findBydocumentNameAnddocumentYear(
		long documentName, int documentYear) throws SystemException {
		return findBydocumentNameAnddocumentYear(documentName, documentYear,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the temp declaration of healths where documentName = &#63; and documentYear = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param documentName the document name
	 * @param documentYear the document year
	 * @param start the lower bound of the range of temp declaration of healths
	 * @param end the upper bound of the range of temp declaration of healths (not inclusive)
	 * @return the range of matching temp declaration of healths
	 * @throws SystemException if a system exception occurred
	 */
	public List<TempDeclarationOfHealth> findBydocumentNameAnddocumentYear(
		long documentName, int documentYear, int start, int end)
		throws SystemException {
		return findBydocumentNameAnddocumentYear(documentName, documentYear,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the temp declaration of healths where documentName = &#63; and documentYear = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param documentName the document name
	 * @param documentYear the document year
	 * @param start the lower bound of the range of temp declaration of healths
	 * @param end the upper bound of the range of temp declaration of healths (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching temp declaration of healths
	 * @throws SystemException if a system exception occurred
	 */
	public List<TempDeclarationOfHealth> findBydocumentNameAnddocumentYear(
		long documentName, int documentYear, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DOCUMENTNAMEANDDOCUMENTYEAR;
			finderArgs = new Object[] { documentName, documentYear };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DOCUMENTNAMEANDDOCUMENTYEAR;
			finderArgs = new Object[] {
					documentName, documentYear,
					
					start, end, orderByComparator
				};
		}

		List<TempDeclarationOfHealth> list = (List<TempDeclarationOfHealth>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_TEMPDECLARATIONOFHEALTH_WHERE);

			query.append(_FINDER_COLUMN_DOCUMENTNAMEANDDOCUMENTYEAR_DOCUMENTNAME_2);

			query.append(_FINDER_COLUMN_DOCUMENTNAMEANDDOCUMENTYEAR_DOCUMENTYEAR_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(TempDeclarationOfHealthModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(documentName);

				qPos.add(documentYear);

				list = (List<TempDeclarationOfHealth>)QueryUtil.list(q,
						getDialect(), start, end);
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
	 * Returns the first temp declaration of health in the ordered set where documentName = &#63; and documentYear = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param documentName the document name
	 * @param documentYear the document year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching temp declaration of health
	 * @throws vn.gt.dao.noticeandmessage.NoSuchTempDeclarationOfHealthException if a matching temp declaration of health could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TempDeclarationOfHealth findBydocumentNameAnddocumentYear_First(
		long documentName, int documentYear, OrderByComparator orderByComparator)
		throws NoSuchTempDeclarationOfHealthException, SystemException {
		List<TempDeclarationOfHealth> list = findBydocumentNameAnddocumentYear(documentName,
				documentYear, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("documentName=");
			msg.append(documentName);

			msg.append(", documentYear=");
			msg.append(documentYear);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTempDeclarationOfHealthException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last temp declaration of health in the ordered set where documentName = &#63; and documentYear = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param documentName the document name
	 * @param documentYear the document year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching temp declaration of health
	 * @throws vn.gt.dao.noticeandmessage.NoSuchTempDeclarationOfHealthException if a matching temp declaration of health could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TempDeclarationOfHealth findBydocumentNameAnddocumentYear_Last(
		long documentName, int documentYear, OrderByComparator orderByComparator)
		throws NoSuchTempDeclarationOfHealthException, SystemException {
		int count = countBydocumentNameAnddocumentYear(documentName,
				documentYear);

		List<TempDeclarationOfHealth> list = findBydocumentNameAnddocumentYear(documentName,
				documentYear, count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("documentName=");
			msg.append(documentName);

			msg.append(", documentYear=");
			msg.append(documentYear);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTempDeclarationOfHealthException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the temp declaration of healths before and after the current temp declaration of health in the ordered set where documentName = &#63; and documentYear = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current temp declaration of health
	 * @param documentName the document name
	 * @param documentYear the document year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next temp declaration of health
	 * @throws vn.gt.dao.noticeandmessage.NoSuchTempDeclarationOfHealthException if a temp declaration of health with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TempDeclarationOfHealth[] findBydocumentNameAnddocumentYear_PrevAndNext(
		long id, long documentName, int documentYear,
		OrderByComparator orderByComparator)
		throws NoSuchTempDeclarationOfHealthException, SystemException {
		TempDeclarationOfHealth tempDeclarationOfHealth = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			TempDeclarationOfHealth[] array = new TempDeclarationOfHealthImpl[3];

			array[0] = getBydocumentNameAnddocumentYear_PrevAndNext(session,
					tempDeclarationOfHealth, documentName, documentYear,
					orderByComparator, true);

			array[1] = tempDeclarationOfHealth;

			array[2] = getBydocumentNameAnddocumentYear_PrevAndNext(session,
					tempDeclarationOfHealth, documentName, documentYear,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TempDeclarationOfHealth getBydocumentNameAnddocumentYear_PrevAndNext(
		Session session, TempDeclarationOfHealth tempDeclarationOfHealth,
		long documentName, int documentYear,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TEMPDECLARATIONOFHEALTH_WHERE);

		query.append(_FINDER_COLUMN_DOCUMENTNAMEANDDOCUMENTYEAR_DOCUMENTNAME_2);

		query.append(_FINDER_COLUMN_DOCUMENTNAMEANDDOCUMENTYEAR_DOCUMENTYEAR_2);

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
			query.append(TempDeclarationOfHealthModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(documentName);

		qPos.add(documentYear);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tempDeclarationOfHealth);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TempDeclarationOfHealth> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the temp declaration of healths where documentName = &#63; and documentYear = &#63; and requestState = &#63;.
	 *
	 * @param documentName the document name
	 * @param documentYear the document year
	 * @param requestState the request state
	 * @return the matching temp declaration of healths
	 * @throws SystemException if a system exception occurred
	 */
	public List<TempDeclarationOfHealth> findBydocumentNameAnddocumentYearRequestState(
		long documentName, int documentYear, int requestState)
		throws SystemException {
		return findBydocumentNameAnddocumentYearRequestState(documentName,
			documentYear, requestState, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the temp declaration of healths where documentName = &#63; and documentYear = &#63; and requestState = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param documentName the document name
	 * @param documentYear the document year
	 * @param requestState the request state
	 * @param start the lower bound of the range of temp declaration of healths
	 * @param end the upper bound of the range of temp declaration of healths (not inclusive)
	 * @return the range of matching temp declaration of healths
	 * @throws SystemException if a system exception occurred
	 */
	public List<TempDeclarationOfHealth> findBydocumentNameAnddocumentYearRequestState(
		long documentName, int documentYear, int requestState, int start,
		int end) throws SystemException {
		return findBydocumentNameAnddocumentYearRequestState(documentName,
			documentYear, requestState, start, end, null);
	}

	/**
	 * Returns an ordered range of all the temp declaration of healths where documentName = &#63; and documentYear = &#63; and requestState = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param documentName the document name
	 * @param documentYear the document year
	 * @param requestState the request state
	 * @param start the lower bound of the range of temp declaration of healths
	 * @param end the upper bound of the range of temp declaration of healths (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching temp declaration of healths
	 * @throws SystemException if a system exception occurred
	 */
	public List<TempDeclarationOfHealth> findBydocumentNameAnddocumentYearRequestState(
		long documentName, int documentYear, int requestState, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DOCUMENTNAMEANDDOCUMENTYEARREQUESTSTATE;
			finderArgs = new Object[] { documentName, documentYear, requestState };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DOCUMENTNAMEANDDOCUMENTYEARREQUESTSTATE;
			finderArgs = new Object[] {
					documentName, documentYear, requestState,
					
					start, end, orderByComparator
				};
		}

		List<TempDeclarationOfHealth> list = (List<TempDeclarationOfHealth>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_TEMPDECLARATIONOFHEALTH_WHERE);

			query.append(_FINDER_COLUMN_DOCUMENTNAMEANDDOCUMENTYEARREQUESTSTATE_DOCUMENTNAME_2);

			query.append(_FINDER_COLUMN_DOCUMENTNAMEANDDOCUMENTYEARREQUESTSTATE_DOCUMENTYEAR_2);

			query.append(_FINDER_COLUMN_DOCUMENTNAMEANDDOCUMENTYEARREQUESTSTATE_REQUESTSTATE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(TempDeclarationOfHealthModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(documentName);

				qPos.add(documentYear);

				qPos.add(requestState);

				list = (List<TempDeclarationOfHealth>)QueryUtil.list(q,
						getDialect(), start, end);
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
	 * Returns the first temp declaration of health in the ordered set where documentName = &#63; and documentYear = &#63; and requestState = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param documentName the document name
	 * @param documentYear the document year
	 * @param requestState the request state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching temp declaration of health
	 * @throws vn.gt.dao.noticeandmessage.NoSuchTempDeclarationOfHealthException if a matching temp declaration of health could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TempDeclarationOfHealth findBydocumentNameAnddocumentYearRequestState_First(
		long documentName, int documentYear, int requestState,
		OrderByComparator orderByComparator)
		throws NoSuchTempDeclarationOfHealthException, SystemException {
		List<TempDeclarationOfHealth> list = findBydocumentNameAnddocumentYearRequestState(documentName,
				documentYear, requestState, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("documentName=");
			msg.append(documentName);

			msg.append(", documentYear=");
			msg.append(documentYear);

			msg.append(", requestState=");
			msg.append(requestState);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTempDeclarationOfHealthException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last temp declaration of health in the ordered set where documentName = &#63; and documentYear = &#63; and requestState = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param documentName the document name
	 * @param documentYear the document year
	 * @param requestState the request state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching temp declaration of health
	 * @throws vn.gt.dao.noticeandmessage.NoSuchTempDeclarationOfHealthException if a matching temp declaration of health could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TempDeclarationOfHealth findBydocumentNameAnddocumentYearRequestState_Last(
		long documentName, int documentYear, int requestState,
		OrderByComparator orderByComparator)
		throws NoSuchTempDeclarationOfHealthException, SystemException {
		int count = countBydocumentNameAnddocumentYearRequestState(documentName,
				documentYear, requestState);

		List<TempDeclarationOfHealth> list = findBydocumentNameAnddocumentYearRequestState(documentName,
				documentYear, requestState, count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("documentName=");
			msg.append(documentName);

			msg.append(", documentYear=");
			msg.append(documentYear);

			msg.append(", requestState=");
			msg.append(requestState);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTempDeclarationOfHealthException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the temp declaration of healths before and after the current temp declaration of health in the ordered set where documentName = &#63; and documentYear = &#63; and requestState = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current temp declaration of health
	 * @param documentName the document name
	 * @param documentYear the document year
	 * @param requestState the request state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next temp declaration of health
	 * @throws vn.gt.dao.noticeandmessage.NoSuchTempDeclarationOfHealthException if a temp declaration of health with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TempDeclarationOfHealth[] findBydocumentNameAnddocumentYearRequestState_PrevAndNext(
		long id, long documentName, int documentYear, int requestState,
		OrderByComparator orderByComparator)
		throws NoSuchTempDeclarationOfHealthException, SystemException {
		TempDeclarationOfHealth tempDeclarationOfHealth = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			TempDeclarationOfHealth[] array = new TempDeclarationOfHealthImpl[3];

			array[0] = getBydocumentNameAnddocumentYearRequestState_PrevAndNext(session,
					tempDeclarationOfHealth, documentName, documentYear,
					requestState, orderByComparator, true);

			array[1] = tempDeclarationOfHealth;

			array[2] = getBydocumentNameAnddocumentYearRequestState_PrevAndNext(session,
					tempDeclarationOfHealth, documentName, documentYear,
					requestState, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TempDeclarationOfHealth getBydocumentNameAnddocumentYearRequestState_PrevAndNext(
		Session session, TempDeclarationOfHealth tempDeclarationOfHealth,
		long documentName, int documentYear, int requestState,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TEMPDECLARATIONOFHEALTH_WHERE);

		query.append(_FINDER_COLUMN_DOCUMENTNAMEANDDOCUMENTYEARREQUESTSTATE_DOCUMENTNAME_2);

		query.append(_FINDER_COLUMN_DOCUMENTNAMEANDDOCUMENTYEARREQUESTSTATE_DOCUMENTYEAR_2);

		query.append(_FINDER_COLUMN_DOCUMENTNAMEANDDOCUMENTYEARREQUESTSTATE_REQUESTSTATE_2);

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
			query.append(TempDeclarationOfHealthModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(documentName);

		qPos.add(documentYear);

		qPos.add(requestState);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tempDeclarationOfHealth);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TempDeclarationOfHealth> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the temp declaration of healths where requestCode = &#63;.
	 *
	 * @param requestCode the request code
	 * @return the matching temp declaration of healths
	 * @throws SystemException if a system exception occurred
	 */
	public List<TempDeclarationOfHealth> findByRequestCode(String requestCode)
		throws SystemException {
		return findByRequestCode(requestCode, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the temp declaration of healths where requestCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param requestCode the request code
	 * @param start the lower bound of the range of temp declaration of healths
	 * @param end the upper bound of the range of temp declaration of healths (not inclusive)
	 * @return the range of matching temp declaration of healths
	 * @throws SystemException if a system exception occurred
	 */
	public List<TempDeclarationOfHealth> findByRequestCode(String requestCode,
		int start, int end) throws SystemException {
		return findByRequestCode(requestCode, start, end, null);
	}

	/**
	 * Returns an ordered range of all the temp declaration of healths where requestCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param requestCode the request code
	 * @param start the lower bound of the range of temp declaration of healths
	 * @param end the upper bound of the range of temp declaration of healths (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching temp declaration of healths
	 * @throws SystemException if a system exception occurred
	 */
	public List<TempDeclarationOfHealth> findByRequestCode(String requestCode,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REQUESTCODE;
			finderArgs = new Object[] { requestCode };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_REQUESTCODE;
			finderArgs = new Object[] { requestCode, start, end, orderByComparator };
		}

		List<TempDeclarationOfHealth> list = (List<TempDeclarationOfHealth>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_TEMPDECLARATIONOFHEALTH_WHERE);

			if (requestCode == null) {
				query.append(_FINDER_COLUMN_REQUESTCODE_REQUESTCODE_1);
			}
			else {
				if (requestCode.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_REQUESTCODE_REQUESTCODE_3);
				}
				else {
					query.append(_FINDER_COLUMN_REQUESTCODE_REQUESTCODE_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(TempDeclarationOfHealthModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (requestCode != null) {
					qPos.add(requestCode);
				}

				list = (List<TempDeclarationOfHealth>)QueryUtil.list(q,
						getDialect(), start, end);
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
	 * Returns the first temp declaration of health in the ordered set where requestCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param requestCode the request code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching temp declaration of health
	 * @throws vn.gt.dao.noticeandmessage.NoSuchTempDeclarationOfHealthException if a matching temp declaration of health could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TempDeclarationOfHealth findByRequestCode_First(String requestCode,
		OrderByComparator orderByComparator)
		throws NoSuchTempDeclarationOfHealthException, SystemException {
		List<TempDeclarationOfHealth> list = findByRequestCode(requestCode, 0,
				1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("requestCode=");
			msg.append(requestCode);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTempDeclarationOfHealthException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last temp declaration of health in the ordered set where requestCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param requestCode the request code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching temp declaration of health
	 * @throws vn.gt.dao.noticeandmessage.NoSuchTempDeclarationOfHealthException if a matching temp declaration of health could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TempDeclarationOfHealth findByRequestCode_Last(String requestCode,
		OrderByComparator orderByComparator)
		throws NoSuchTempDeclarationOfHealthException, SystemException {
		int count = countByRequestCode(requestCode);

		List<TempDeclarationOfHealth> list = findByRequestCode(requestCode,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("requestCode=");
			msg.append(requestCode);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchTempDeclarationOfHealthException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the temp declaration of healths before and after the current temp declaration of health in the ordered set where requestCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current temp declaration of health
	 * @param requestCode the request code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next temp declaration of health
	 * @throws vn.gt.dao.noticeandmessage.NoSuchTempDeclarationOfHealthException if a temp declaration of health with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TempDeclarationOfHealth[] findByRequestCode_PrevAndNext(long id,
		String requestCode, OrderByComparator orderByComparator)
		throws NoSuchTempDeclarationOfHealthException, SystemException {
		TempDeclarationOfHealth tempDeclarationOfHealth = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			TempDeclarationOfHealth[] array = new TempDeclarationOfHealthImpl[3];

			array[0] = getByRequestCode_PrevAndNext(session,
					tempDeclarationOfHealth, requestCode, orderByComparator,
					true);

			array[1] = tempDeclarationOfHealth;

			array[2] = getByRequestCode_PrevAndNext(session,
					tempDeclarationOfHealth, requestCode, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TempDeclarationOfHealth getByRequestCode_PrevAndNext(
		Session session, TempDeclarationOfHealth tempDeclarationOfHealth,
		String requestCode, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TEMPDECLARATIONOFHEALTH_WHERE);

		if (requestCode == null) {
			query.append(_FINDER_COLUMN_REQUESTCODE_REQUESTCODE_1);
		}
		else {
			if (requestCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_REQUESTCODE_REQUESTCODE_3);
			}
			else {
				query.append(_FINDER_COLUMN_REQUESTCODE_REQUESTCODE_2);
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
			query.append(TempDeclarationOfHealthModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (requestCode != null) {
			qPos.add(requestCode);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tempDeclarationOfHealth);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TempDeclarationOfHealth> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the temp declaration of healths.
	 *
	 * @return the temp declaration of healths
	 * @throws SystemException if a system exception occurred
	 */
	public List<TempDeclarationOfHealth> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the temp declaration of healths.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of temp declaration of healths
	 * @param end the upper bound of the range of temp declaration of healths (not inclusive)
	 * @return the range of temp declaration of healths
	 * @throws SystemException if a system exception occurred
	 */
	public List<TempDeclarationOfHealth> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the temp declaration of healths.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of temp declaration of healths
	 * @param end the upper bound of the range of temp declaration of healths (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of temp declaration of healths
	 * @throws SystemException if a system exception occurred
	 */
	public List<TempDeclarationOfHealth> findAll(int start, int end,
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

		List<TempDeclarationOfHealth> list = (List<TempDeclarationOfHealth>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TEMPDECLARATIONOFHEALTH);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TEMPDECLARATIONOFHEALTH.concat(TempDeclarationOfHealthModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<TempDeclarationOfHealth>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<TempDeclarationOfHealth>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the temp declaration of healths where documentName = &#63; and documentYear = &#63; from the database.
	 *
	 * @param documentName the document name
	 * @param documentYear the document year
	 * @throws SystemException if a system exception occurred
	 */
	public void removeBydocumentNameAnddocumentYear(long documentName,
		int documentYear) throws SystemException {
		for (TempDeclarationOfHealth tempDeclarationOfHealth : findBydocumentNameAnddocumentYear(
				documentName, documentYear)) {
			remove(tempDeclarationOfHealth);
		}
	}

	/**
	 * Removes all the temp declaration of healths where documentName = &#63; and documentYear = &#63; and requestState = &#63; from the database.
	 *
	 * @param documentName the document name
	 * @param documentYear the document year
	 * @param requestState the request state
	 * @throws SystemException if a system exception occurred
	 */
	public void removeBydocumentNameAnddocumentYearRequestState(
		long documentName, int documentYear, int requestState)
		throws SystemException {
		for (TempDeclarationOfHealth tempDeclarationOfHealth : findBydocumentNameAnddocumentYearRequestState(
				documentName, documentYear, requestState)) {
			remove(tempDeclarationOfHealth);
		}
	}

	/**
	 * Removes all the temp declaration of healths where requestCode = &#63; from the database.
	 *
	 * @param requestCode the request code
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByRequestCode(String requestCode)
		throws SystemException {
		for (TempDeclarationOfHealth tempDeclarationOfHealth : findByRequestCode(
				requestCode)) {
			remove(tempDeclarationOfHealth);
		}
	}

	/**
	 * Removes all the temp declaration of healths from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (TempDeclarationOfHealth tempDeclarationOfHealth : findAll()) {
			remove(tempDeclarationOfHealth);
		}
	}

	/**
	 * Returns the number of temp declaration of healths where documentName = &#63; and documentYear = &#63;.
	 *
	 * @param documentName the document name
	 * @param documentYear the document year
	 * @return the number of matching temp declaration of healths
	 * @throws SystemException if a system exception occurred
	 */
	public int countBydocumentNameAnddocumentYear(long documentName,
		int documentYear) throws SystemException {
		Object[] finderArgs = new Object[] { documentName, documentYear };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DOCUMENTNAMEANDDOCUMENTYEAR,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TEMPDECLARATIONOFHEALTH_WHERE);

			query.append(_FINDER_COLUMN_DOCUMENTNAMEANDDOCUMENTYEAR_DOCUMENTNAME_2);

			query.append(_FINDER_COLUMN_DOCUMENTNAMEANDDOCUMENTYEAR_DOCUMENTYEAR_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(documentName);

				qPos.add(documentYear);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DOCUMENTNAMEANDDOCUMENTYEAR,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of temp declaration of healths where documentName = &#63; and documentYear = &#63; and requestState = &#63;.
	 *
	 * @param documentName the document name
	 * @param documentYear the document year
	 * @param requestState the request state
	 * @return the number of matching temp declaration of healths
	 * @throws SystemException if a system exception occurred
	 */
	public int countBydocumentNameAnddocumentYearRequestState(
		long documentName, int documentYear, int requestState)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				documentName, documentYear, requestState
			};

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DOCUMENTNAMEANDDOCUMENTYEARREQUESTSTATE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_TEMPDECLARATIONOFHEALTH_WHERE);

			query.append(_FINDER_COLUMN_DOCUMENTNAMEANDDOCUMENTYEARREQUESTSTATE_DOCUMENTNAME_2);

			query.append(_FINDER_COLUMN_DOCUMENTNAMEANDDOCUMENTYEARREQUESTSTATE_DOCUMENTYEAR_2);

			query.append(_FINDER_COLUMN_DOCUMENTNAMEANDDOCUMENTYEARREQUESTSTATE_REQUESTSTATE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(documentName);

				qPos.add(documentYear);

				qPos.add(requestState);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DOCUMENTNAMEANDDOCUMENTYEARREQUESTSTATE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of temp declaration of healths where requestCode = &#63;.
	 *
	 * @param requestCode the request code
	 * @return the number of matching temp declaration of healths
	 * @throws SystemException if a system exception occurred
	 */
	public int countByRequestCode(String requestCode) throws SystemException {
		Object[] finderArgs = new Object[] { requestCode };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_REQUESTCODE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TEMPDECLARATIONOFHEALTH_WHERE);

			if (requestCode == null) {
				query.append(_FINDER_COLUMN_REQUESTCODE_REQUESTCODE_1);
			}
			else {
				if (requestCode.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_REQUESTCODE_REQUESTCODE_3);
				}
				else {
					query.append(_FINDER_COLUMN_REQUESTCODE_REQUESTCODE_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (requestCode != null) {
					qPos.add(requestCode);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_REQUESTCODE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of temp declaration of healths.
	 *
	 * @return the number of temp declaration of healths
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TEMPDECLARATIONOFHEALTH);

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
	 * Initializes the temp declaration of health persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.gt.dao.noticeandmessage.model.TempDeclarationOfHealth")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<TempDeclarationOfHealth>> listenersList = new ArrayList<ModelListener<TempDeclarationOfHealth>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<TempDeclarationOfHealth>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(TempDeclarationOfHealthImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = HistoryInterfaceRequestPersistence.class)
	protected HistoryInterfaceRequestPersistence historyInterfaceRequestPersistence;
	@BeanReference(type = HistoryInterfaceRequestFieldPersistence.class)
	protected HistoryInterfaceRequestFieldPersistence historyInterfaceRequestFieldPersistence;
	@BeanReference(type = InterfaceRequestPersistence.class)
	protected InterfaceRequestPersistence interfaceRequestPersistence;
	@BeanReference(type = InterfaceRequestFieldPersistence.class)
	protected InterfaceRequestFieldPersistence interfaceRequestFieldPersistence;
	@BeanReference(type = IssueAcceptanceForTransitPersistence.class)
	protected IssueAcceptanceForTransitPersistence issueAcceptanceForTransitPersistence;
	@BeanReference(type = IssuePermissionForTransitPersistence.class)
	protected IssuePermissionForTransitPersistence issuePermissionForTransitPersistence;
	@BeanReference(type = IssuePortClearancePersistence.class)
	protected IssuePortClearancePersistence issuePortClearancePersistence;
	@BeanReference(type = IssueShiftingOrderPersistence.class)
	protected IssueShiftingOrderPersistence issueShiftingOrderPersistence;
	@BeanReference(type = ModifyPersistence.class)
	protected ModifyPersistence modifyPersistence;
	@BeanReference(type = NoticeShipMessagePersistence.class)
	protected NoticeShipMessagePersistence noticeShipMessagePersistence;
	@BeanReference(type = TempAnimalQuarantinePersistence.class)
	protected TempAnimalQuarantinePersistence tempAnimalQuarantinePersistence;
	@BeanReference(type = TempAttachmentDeclarationHealthPersistence.class)
	protected TempAttachmentDeclarationHealthPersistence tempAttachmentDeclarationHealthPersistence;
	@BeanReference(type = TempCargoDeclarationPersistence.class)
	protected TempCargoDeclarationPersistence tempCargoDeclarationPersistence;
	@BeanReference(type = TempCrewDetailsPersistence.class)
	protected TempCrewDetailsPersistence tempCrewDetailsPersistence;
	@BeanReference(type = TempCrewEffectsDeclarationPersistence.class)
	protected TempCrewEffectsDeclarationPersistence tempCrewEffectsDeclarationPersistence;
	@BeanReference(type = TempCrewEffectsItemsPersistence.class)
	protected TempCrewEffectsItemsPersistence tempCrewEffectsItemsPersistence;
	@BeanReference(type = TempCrewListPersistence.class)
	protected TempCrewListPersistence tempCrewListPersistence;
	@BeanReference(type = TempDangerousGoodsItemsPersistence.class)
	protected TempDangerousGoodsItemsPersistence tempDangerousGoodsItemsPersistence;
	@BeanReference(type = TempDangerousGoodsNanifestPersistence.class)
	protected TempDangerousGoodsNanifestPersistence tempDangerousGoodsNanifestPersistence;
	@BeanReference(type = TempDeclarationForAnimalQuarantinePersistence.class)
	protected TempDeclarationForAnimalQuarantinePersistence tempDeclarationForAnimalQuarantinePersistence;
	@BeanReference(type = TempDeclarationForPlantQuarantinePersistence.class)
	protected TempDeclarationForPlantQuarantinePersistence tempDeclarationForPlantQuarantinePersistence;
	@BeanReference(type = TempDeclarationOfHealthPersistence.class)
	protected TempDeclarationOfHealthPersistence tempDeclarationOfHealthPersistence;
	@BeanReference(type = TempDocumentPersistence.class)
	protected TempDocumentPersistence tempDocumentPersistence;
	@BeanReference(type = TempGeneralDeclarationPersistence.class)
	protected TempGeneralDeclarationPersistence tempGeneralDeclarationPersistence;
	@BeanReference(type = TempGoodsItemsPersistence.class)
	protected TempGoodsItemsPersistence tempGoodsItemsPersistence;
	@BeanReference(type = TempHealthCrewPassengerListPersistence.class)
	protected TempHealthCrewPassengerListPersistence tempHealthCrewPassengerListPersistence;
	@BeanReference(type = TempHealthQuestionPersistence.class)
	protected TempHealthQuestionPersistence tempHealthQuestionPersistence;
	@BeanReference(type = TempNoTiceShipMessagePersistence.class)
	protected TempNoTiceShipMessagePersistence tempNoTiceShipMessagePersistence;
	@BeanReference(type = TempPassengerDetailsPersistence.class)
	protected TempPassengerDetailsPersistence tempPassengerDetailsPersistence;
	@BeanReference(type = TempPassengerListPersistence.class)
	protected TempPassengerListPersistence tempPassengerListPersistence;
	@BeanReference(type = TempPlantQuarantinePersistence.class)
	protected TempPlantQuarantinePersistence tempPlantQuarantinePersistence;
	@BeanReference(type = TempShipSecurityMessagePersistence.class)
	protected TempShipSecurityMessagePersistence tempShipSecurityMessagePersistence;
	@BeanReference(type = TempShipSecurityPortItemsPersistence.class)
	protected TempShipSecurityPortItemsPersistence tempShipSecurityPortItemsPersistence;
	@BeanReference(type = TempShipStoresDeclarationPersistence.class)
	protected TempShipStoresDeclarationPersistence tempShipStoresDeclarationPersistence;
	@BeanReference(type = TempShipStoresItemsPersistence.class)
	protected TempShipStoresItemsPersistence tempShipStoresItemsPersistence;
	@BeanReference(type = TempUnitGeneralPersistence.class)
	protected TempUnitGeneralPersistence tempUnitGeneralPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_TEMPDECLARATIONOFHEALTH = "SELECT tempDeclarationOfHealth FROM TempDeclarationOfHealth tempDeclarationOfHealth";
	private static final String _SQL_SELECT_TEMPDECLARATIONOFHEALTH_WHERE = "SELECT tempDeclarationOfHealth FROM TempDeclarationOfHealth tempDeclarationOfHealth WHERE ";
	private static final String _SQL_COUNT_TEMPDECLARATIONOFHEALTH = "SELECT COUNT(tempDeclarationOfHealth) FROM TempDeclarationOfHealth tempDeclarationOfHealth";
	private static final String _SQL_COUNT_TEMPDECLARATIONOFHEALTH_WHERE = "SELECT COUNT(tempDeclarationOfHealth) FROM TempDeclarationOfHealth tempDeclarationOfHealth WHERE ";
	private static final String _FINDER_COLUMN_DOCUMENTNAMEANDDOCUMENTYEAR_DOCUMENTNAME_2 =
		"tempDeclarationOfHealth.documentName = ? AND ";
	private static final String _FINDER_COLUMN_DOCUMENTNAMEANDDOCUMENTYEAR_DOCUMENTYEAR_2 =
		"tempDeclarationOfHealth.documentYear = ?";
	private static final String _FINDER_COLUMN_DOCUMENTNAMEANDDOCUMENTYEARREQUESTSTATE_DOCUMENTNAME_2 =
		"tempDeclarationOfHealth.documentName = ? AND ";
	private static final String _FINDER_COLUMN_DOCUMENTNAMEANDDOCUMENTYEARREQUESTSTATE_DOCUMENTYEAR_2 =
		"tempDeclarationOfHealth.documentYear = ? AND ";
	private static final String _FINDER_COLUMN_DOCUMENTNAMEANDDOCUMENTYEARREQUESTSTATE_REQUESTSTATE_2 =
		"tempDeclarationOfHealth.requestState = ?";
	private static final String _FINDER_COLUMN_REQUESTCODE_REQUESTCODE_1 = "tempDeclarationOfHealth.requestCode IS NULL";
	private static final String _FINDER_COLUMN_REQUESTCODE_REQUESTCODE_2 = "tempDeclarationOfHealth.requestCode = ?";
	private static final String _FINDER_COLUMN_REQUESTCODE_REQUESTCODE_3 = "(tempDeclarationOfHealth.requestCode IS NULL OR tempDeclarationOfHealth.requestCode = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "tempDeclarationOfHealth.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TempDeclarationOfHealth exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TempDeclarationOfHealth exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TempDeclarationOfHealthPersistenceImpl.class);
	private static TempDeclarationOfHealth _nullTempDeclarationOfHealth = new TempDeclarationOfHealthImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TempDeclarationOfHealth> toCacheModel() {
				return _nullTempDeclarationOfHealthCacheModel;
			}
		};

	private static CacheModel<TempDeclarationOfHealth> _nullTempDeclarationOfHealthCacheModel =
		new CacheModel<TempDeclarationOfHealth>() {
			public TempDeclarationOfHealth toEntityModel() {
				return _nullTempDeclarationOfHealth;
			}
		};
}