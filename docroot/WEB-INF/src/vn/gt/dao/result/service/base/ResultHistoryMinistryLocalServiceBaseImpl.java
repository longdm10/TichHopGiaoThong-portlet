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

package vn.gt.dao.result.service.base;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import vn.gt.dao.result.model.ResultHistoryMinistry;
import vn.gt.dao.result.service.ResultCertificateLocalService;
import vn.gt.dao.result.service.ResultCertificateService;
import vn.gt.dao.result.service.ResultCompetionLocalService;
import vn.gt.dao.result.service.ResultCompetionService;
import vn.gt.dao.result.service.ResultDeclarationLocalService;
import vn.gt.dao.result.service.ResultDeclarationService;
import vn.gt.dao.result.service.ResultHistoryMinistryLocalService;
import vn.gt.dao.result.service.ResultHistoryMinistryService;
import vn.gt.dao.result.service.ResultMinistryLocalService;
import vn.gt.dao.result.service.ResultMinistryService;
import vn.gt.dao.result.service.ResultNotificationLocalService;
import vn.gt.dao.result.service.ResultNotificationService;
import vn.gt.dao.result.service.persistence.ResultCertificatePersistence;
import vn.gt.dao.result.service.persistence.ResultCompetionPersistence;
import vn.gt.dao.result.service.persistence.ResultDeclarationFinder;
import vn.gt.dao.result.service.persistence.ResultDeclarationPersistence;
import vn.gt.dao.result.service.persistence.ResultHistoryMinistryFinder;
import vn.gt.dao.result.service.persistence.ResultHistoryMinistryPersistence;
import vn.gt.dao.result.service.persistence.ResultMinistryFinder;
import vn.gt.dao.result.service.persistence.ResultMinistryPersistence;
import vn.gt.dao.result.service.persistence.ResultNotificationFinder;
import vn.gt.dao.result.service.persistence.ResultNotificationPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the result history ministry local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link vn.gt.dao.result.service.impl.ResultHistoryMinistryLocalServiceImpl}.
 * </p>
 *
 * @author win_64
 * @see vn.gt.dao.result.service.impl.ResultHistoryMinistryLocalServiceImpl
 * @see vn.gt.dao.result.service.ResultHistoryMinistryLocalServiceUtil
 * @generated
 */
public abstract class ResultHistoryMinistryLocalServiceBaseImpl
	implements ResultHistoryMinistryLocalService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link vn.gt.dao.result.service.ResultHistoryMinistryLocalServiceUtil} to access the result history ministry local service.
	 */

	/**
	 * Adds the result history ministry to the database. Also notifies the appropriate model listeners.
	 *
	 * @param resultHistoryMinistry the result history ministry
	 * @return the result history ministry that was added
	 * @throws SystemException if a system exception occurred
	 */
	public ResultHistoryMinistry addResultHistoryMinistry(
		ResultHistoryMinistry resultHistoryMinistry) throws SystemException {
		resultHistoryMinistry.setNew(true);

		resultHistoryMinistry = resultHistoryMinistryPersistence.update(resultHistoryMinistry,
				false);

		Indexer indexer = IndexerRegistryUtil.getIndexer(getModelClassName());

		if (indexer != null) {
			try {
				indexer.reindex(resultHistoryMinistry);
			}
			catch (SearchException se) {
				if (_log.isWarnEnabled()) {
					_log.warn(se, se);
				}
			}
		}

		return resultHistoryMinistry;
	}

	/**
	 * Creates a new result history ministry with the primary key. Does not add the result history ministry to the database.
	 *
	 * @param id the primary key for the new result history ministry
	 * @return the new result history ministry
	 */
	public ResultHistoryMinistry createResultHistoryMinistry(long id) {
		return resultHistoryMinistryPersistence.create(id);
	}

	/**
	 * Deletes the result history ministry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the result history ministry
	 * @throws PortalException if a result history ministry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public void deleteResultHistoryMinistry(long id)
		throws PortalException, SystemException {
		ResultHistoryMinistry resultHistoryMinistry = resultHistoryMinistryPersistence.remove(id);

		Indexer indexer = IndexerRegistryUtil.getIndexer(getModelClassName());

		if (indexer != null) {
			try {
				indexer.delete(resultHistoryMinistry);
			}
			catch (SearchException se) {
				if (_log.isWarnEnabled()) {
					_log.warn(se, se);
				}
			}
		}
	}

	/**
	 * Deletes the result history ministry from the database. Also notifies the appropriate model listeners.
	 *
	 * @param resultHistoryMinistry the result history ministry
	 * @throws SystemException if a system exception occurred
	 */
	public void deleteResultHistoryMinistry(
		ResultHistoryMinistry resultHistoryMinistry) throws SystemException {
		resultHistoryMinistryPersistence.remove(resultHistoryMinistry);

		Indexer indexer = IndexerRegistryUtil.getIndexer(getModelClassName());

		if (indexer != null) {
			try {
				indexer.delete(resultHistoryMinistry);
			}
			catch (SearchException se) {
				if (_log.isWarnEnabled()) {
					_log.warn(se, se);
				}
			}
		}
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return resultHistoryMinistryPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return resultHistoryMinistryPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return resultHistoryMinistryPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return resultHistoryMinistryPersistence.countWithDynamicQuery(dynamicQuery);
	}

	public ResultHistoryMinistry fetchResultHistoryMinistry(long id)
		throws SystemException {
		return resultHistoryMinistryPersistence.fetchByPrimaryKey(id);
	}

	/**
	 * Returns the result history ministry with the primary key.
	 *
	 * @param id the primary key of the result history ministry
	 * @return the result history ministry
	 * @throws PortalException if a result history ministry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ResultHistoryMinistry getResultHistoryMinistry(long id)
		throws PortalException, SystemException {
		return resultHistoryMinistryPersistence.findByPrimaryKey(id);
	}

	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return resultHistoryMinistryPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the result history ministries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of result history ministries
	 * @param end the upper bound of the range of result history ministries (not inclusive)
	 * @return the range of result history ministries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ResultHistoryMinistry> getResultHistoryMinistries(int start,
		int end) throws SystemException {
		return resultHistoryMinistryPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of result history ministries.
	 *
	 * @return the number of result history ministries
	 * @throws SystemException if a system exception occurred
	 */
	public int getResultHistoryMinistriesCount() throws SystemException {
		return resultHistoryMinistryPersistence.countAll();
	}

	/**
	 * Updates the result history ministry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param resultHistoryMinistry the result history ministry
	 * @return the result history ministry that was updated
	 * @throws SystemException if a system exception occurred
	 */
	public ResultHistoryMinistry updateResultHistoryMinistry(
		ResultHistoryMinistry resultHistoryMinistry) throws SystemException {
		return updateResultHistoryMinistry(resultHistoryMinistry, true);
	}

	/**
	 * Updates the result history ministry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param resultHistoryMinistry the result history ministry
	 * @param merge whether to merge the result history ministry with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the result history ministry that was updated
	 * @throws SystemException if a system exception occurred
	 */
	public ResultHistoryMinistry updateResultHistoryMinistry(
		ResultHistoryMinistry resultHistoryMinistry, boolean merge)
		throws SystemException {
		resultHistoryMinistry.setNew(false);

		resultHistoryMinistry = resultHistoryMinistryPersistence.update(resultHistoryMinistry,
				merge);

		Indexer indexer = IndexerRegistryUtil.getIndexer(getModelClassName());

		if (indexer != null) {
			try {
				indexer.reindex(resultHistoryMinistry);
			}
			catch (SearchException se) {
				if (_log.isWarnEnabled()) {
					_log.warn(se, se);
				}
			}
		}

		return resultHistoryMinistry;
	}

	/**
	 * Returns the result certificate local service.
	 *
	 * @return the result certificate local service
	 */
	public ResultCertificateLocalService getResultCertificateLocalService() {
		return resultCertificateLocalService;
	}

	/**
	 * Sets the result certificate local service.
	 *
	 * @param resultCertificateLocalService the result certificate local service
	 */
	public void setResultCertificateLocalService(
		ResultCertificateLocalService resultCertificateLocalService) {
		this.resultCertificateLocalService = resultCertificateLocalService;
	}

	/**
	 * Returns the result certificate remote service.
	 *
	 * @return the result certificate remote service
	 */
	public ResultCertificateService getResultCertificateService() {
		return resultCertificateService;
	}

	/**
	 * Sets the result certificate remote service.
	 *
	 * @param resultCertificateService the result certificate remote service
	 */
	public void setResultCertificateService(
		ResultCertificateService resultCertificateService) {
		this.resultCertificateService = resultCertificateService;
	}

	/**
	 * Returns the result certificate persistence.
	 *
	 * @return the result certificate persistence
	 */
	public ResultCertificatePersistence getResultCertificatePersistence() {
		return resultCertificatePersistence;
	}

	/**
	 * Sets the result certificate persistence.
	 *
	 * @param resultCertificatePersistence the result certificate persistence
	 */
	public void setResultCertificatePersistence(
		ResultCertificatePersistence resultCertificatePersistence) {
		this.resultCertificatePersistence = resultCertificatePersistence;
	}

	/**
	 * Returns the result competion local service.
	 *
	 * @return the result competion local service
	 */
	public ResultCompetionLocalService getResultCompetionLocalService() {
		return resultCompetionLocalService;
	}

	/**
	 * Sets the result competion local service.
	 *
	 * @param resultCompetionLocalService the result competion local service
	 */
	public void setResultCompetionLocalService(
		ResultCompetionLocalService resultCompetionLocalService) {
		this.resultCompetionLocalService = resultCompetionLocalService;
	}

	/**
	 * Returns the result competion remote service.
	 *
	 * @return the result competion remote service
	 */
	public ResultCompetionService getResultCompetionService() {
		return resultCompetionService;
	}

	/**
	 * Sets the result competion remote service.
	 *
	 * @param resultCompetionService the result competion remote service
	 */
	public void setResultCompetionService(
		ResultCompetionService resultCompetionService) {
		this.resultCompetionService = resultCompetionService;
	}

	/**
	 * Returns the result competion persistence.
	 *
	 * @return the result competion persistence
	 */
	public ResultCompetionPersistence getResultCompetionPersistence() {
		return resultCompetionPersistence;
	}

	/**
	 * Sets the result competion persistence.
	 *
	 * @param resultCompetionPersistence the result competion persistence
	 */
	public void setResultCompetionPersistence(
		ResultCompetionPersistence resultCompetionPersistence) {
		this.resultCompetionPersistence = resultCompetionPersistence;
	}

	/**
	 * Returns the result declaration local service.
	 *
	 * @return the result declaration local service
	 */
	public ResultDeclarationLocalService getResultDeclarationLocalService() {
		return resultDeclarationLocalService;
	}

	/**
	 * Sets the result declaration local service.
	 *
	 * @param resultDeclarationLocalService the result declaration local service
	 */
	public void setResultDeclarationLocalService(
		ResultDeclarationLocalService resultDeclarationLocalService) {
		this.resultDeclarationLocalService = resultDeclarationLocalService;
	}

	/**
	 * Returns the result declaration remote service.
	 *
	 * @return the result declaration remote service
	 */
	public ResultDeclarationService getResultDeclarationService() {
		return resultDeclarationService;
	}

	/**
	 * Sets the result declaration remote service.
	 *
	 * @param resultDeclarationService the result declaration remote service
	 */
	public void setResultDeclarationService(
		ResultDeclarationService resultDeclarationService) {
		this.resultDeclarationService = resultDeclarationService;
	}

	/**
	 * Returns the result declaration persistence.
	 *
	 * @return the result declaration persistence
	 */
	public ResultDeclarationPersistence getResultDeclarationPersistence() {
		return resultDeclarationPersistence;
	}

	/**
	 * Sets the result declaration persistence.
	 *
	 * @param resultDeclarationPersistence the result declaration persistence
	 */
	public void setResultDeclarationPersistence(
		ResultDeclarationPersistence resultDeclarationPersistence) {
		this.resultDeclarationPersistence = resultDeclarationPersistence;
	}

	/**
	 * Returns the result declaration finder.
	 *
	 * @return the result declaration finder
	 */
	public ResultDeclarationFinder getResultDeclarationFinder() {
		return resultDeclarationFinder;
	}

	/**
	 * Sets the result declaration finder.
	 *
	 * @param resultDeclarationFinder the result declaration finder
	 */
	public void setResultDeclarationFinder(
		ResultDeclarationFinder resultDeclarationFinder) {
		this.resultDeclarationFinder = resultDeclarationFinder;
	}

	/**
	 * Returns the result history ministry local service.
	 *
	 * @return the result history ministry local service
	 */
	public ResultHistoryMinistryLocalService getResultHistoryMinistryLocalService() {
		return resultHistoryMinistryLocalService;
	}

	/**
	 * Sets the result history ministry local service.
	 *
	 * @param resultHistoryMinistryLocalService the result history ministry local service
	 */
	public void setResultHistoryMinistryLocalService(
		ResultHistoryMinistryLocalService resultHistoryMinistryLocalService) {
		this.resultHistoryMinistryLocalService = resultHistoryMinistryLocalService;
	}

	/**
	 * Returns the result history ministry remote service.
	 *
	 * @return the result history ministry remote service
	 */
	public ResultHistoryMinistryService getResultHistoryMinistryService() {
		return resultHistoryMinistryService;
	}

	/**
	 * Sets the result history ministry remote service.
	 *
	 * @param resultHistoryMinistryService the result history ministry remote service
	 */
	public void setResultHistoryMinistryService(
		ResultHistoryMinistryService resultHistoryMinistryService) {
		this.resultHistoryMinistryService = resultHistoryMinistryService;
	}

	/**
	 * Returns the result history ministry persistence.
	 *
	 * @return the result history ministry persistence
	 */
	public ResultHistoryMinistryPersistence getResultHistoryMinistryPersistence() {
		return resultHistoryMinistryPersistence;
	}

	/**
	 * Sets the result history ministry persistence.
	 *
	 * @param resultHistoryMinistryPersistence the result history ministry persistence
	 */
	public void setResultHistoryMinistryPersistence(
		ResultHistoryMinistryPersistence resultHistoryMinistryPersistence) {
		this.resultHistoryMinistryPersistence = resultHistoryMinistryPersistence;
	}

	/**
	 * Returns the result history ministry finder.
	 *
	 * @return the result history ministry finder
	 */
	public ResultHistoryMinistryFinder getResultHistoryMinistryFinder() {
		return resultHistoryMinistryFinder;
	}

	/**
	 * Sets the result history ministry finder.
	 *
	 * @param resultHistoryMinistryFinder the result history ministry finder
	 */
	public void setResultHistoryMinistryFinder(
		ResultHistoryMinistryFinder resultHistoryMinistryFinder) {
		this.resultHistoryMinistryFinder = resultHistoryMinistryFinder;
	}

	/**
	 * Returns the result ministry local service.
	 *
	 * @return the result ministry local service
	 */
	public ResultMinistryLocalService getResultMinistryLocalService() {
		return resultMinistryLocalService;
	}

	/**
	 * Sets the result ministry local service.
	 *
	 * @param resultMinistryLocalService the result ministry local service
	 */
	public void setResultMinistryLocalService(
		ResultMinistryLocalService resultMinistryLocalService) {
		this.resultMinistryLocalService = resultMinistryLocalService;
	}

	/**
	 * Returns the result ministry remote service.
	 *
	 * @return the result ministry remote service
	 */
	public ResultMinistryService getResultMinistryService() {
		return resultMinistryService;
	}

	/**
	 * Sets the result ministry remote service.
	 *
	 * @param resultMinistryService the result ministry remote service
	 */
	public void setResultMinistryService(
		ResultMinistryService resultMinistryService) {
		this.resultMinistryService = resultMinistryService;
	}

	/**
	 * Returns the result ministry persistence.
	 *
	 * @return the result ministry persistence
	 */
	public ResultMinistryPersistence getResultMinistryPersistence() {
		return resultMinistryPersistence;
	}

	/**
	 * Sets the result ministry persistence.
	 *
	 * @param resultMinistryPersistence the result ministry persistence
	 */
	public void setResultMinistryPersistence(
		ResultMinistryPersistence resultMinistryPersistence) {
		this.resultMinistryPersistence = resultMinistryPersistence;
	}

	/**
	 * Returns the result ministry finder.
	 *
	 * @return the result ministry finder
	 */
	public ResultMinistryFinder getResultMinistryFinder() {
		return resultMinistryFinder;
	}

	/**
	 * Sets the result ministry finder.
	 *
	 * @param resultMinistryFinder the result ministry finder
	 */
	public void setResultMinistryFinder(
		ResultMinistryFinder resultMinistryFinder) {
		this.resultMinistryFinder = resultMinistryFinder;
	}

	/**
	 * Returns the result notification local service.
	 *
	 * @return the result notification local service
	 */
	public ResultNotificationLocalService getResultNotificationLocalService() {
		return resultNotificationLocalService;
	}

	/**
	 * Sets the result notification local service.
	 *
	 * @param resultNotificationLocalService the result notification local service
	 */
	public void setResultNotificationLocalService(
		ResultNotificationLocalService resultNotificationLocalService) {
		this.resultNotificationLocalService = resultNotificationLocalService;
	}

	/**
	 * Returns the result notification remote service.
	 *
	 * @return the result notification remote service
	 */
	public ResultNotificationService getResultNotificationService() {
		return resultNotificationService;
	}

	/**
	 * Sets the result notification remote service.
	 *
	 * @param resultNotificationService the result notification remote service
	 */
	public void setResultNotificationService(
		ResultNotificationService resultNotificationService) {
		this.resultNotificationService = resultNotificationService;
	}

	/**
	 * Returns the result notification persistence.
	 *
	 * @return the result notification persistence
	 */
	public ResultNotificationPersistence getResultNotificationPersistence() {
		return resultNotificationPersistence;
	}

	/**
	 * Sets the result notification persistence.
	 *
	 * @param resultNotificationPersistence the result notification persistence
	 */
	public void setResultNotificationPersistence(
		ResultNotificationPersistence resultNotificationPersistence) {
		this.resultNotificationPersistence = resultNotificationPersistence;
	}

	/**
	 * Returns the result notification finder.
	 *
	 * @return the result notification finder
	 */
	public ResultNotificationFinder getResultNotificationFinder() {
		return resultNotificationFinder;
	}

	/**
	 * Sets the result notification finder.
	 *
	 * @param resultNotificationFinder the result notification finder
	 */
	public void setResultNotificationFinder(
		ResultNotificationFinder resultNotificationFinder) {
		this.resultNotificationFinder = resultNotificationFinder;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the resource remote service.
	 *
	 * @return the resource remote service
	 */
	public ResourceService getResourceService() {
		return resourceService;
	}

	/**
	 * Sets the resource remote service.
	 *
	 * @param resourceService the resource remote service
	 */
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	/**
	 * Returns the resource persistence.
	 *
	 * @return the resource persistence
	 */
	public ResourcePersistence getResourcePersistence() {
		return resourcePersistence;
	}

	/**
	 * Sets the resource persistence.
	 *
	 * @param resourcePersistence the resource persistence
	 */
	public void setResourcePersistence(ResourcePersistence resourcePersistence) {
		this.resourcePersistence = resourcePersistence;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		PersistedModelLocalServiceRegistryUtil.register("vn.gt.dao.result.model.ResultHistoryMinistry",
			resultHistoryMinistryLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"vn.gt.dao.result.model.ResultHistoryMinistry");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	protected Class<?> getModelClass() {
		return ResultHistoryMinistry.class;
	}

	protected String getModelClassName() {
		return ResultHistoryMinistry.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = resultHistoryMinistryPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = ResultCertificateLocalService.class)
	protected ResultCertificateLocalService resultCertificateLocalService;
	@BeanReference(type = ResultCertificateService.class)
	protected ResultCertificateService resultCertificateService;
	@BeanReference(type = ResultCertificatePersistence.class)
	protected ResultCertificatePersistence resultCertificatePersistence;
	@BeanReference(type = ResultCompetionLocalService.class)
	protected ResultCompetionLocalService resultCompetionLocalService;
	@BeanReference(type = ResultCompetionService.class)
	protected ResultCompetionService resultCompetionService;
	@BeanReference(type = ResultCompetionPersistence.class)
	protected ResultCompetionPersistence resultCompetionPersistence;
	@BeanReference(type = ResultDeclarationLocalService.class)
	protected ResultDeclarationLocalService resultDeclarationLocalService;
	@BeanReference(type = ResultDeclarationService.class)
	protected ResultDeclarationService resultDeclarationService;
	@BeanReference(type = ResultDeclarationPersistence.class)
	protected ResultDeclarationPersistence resultDeclarationPersistence;
	@BeanReference(type = ResultDeclarationFinder.class)
	protected ResultDeclarationFinder resultDeclarationFinder;
	@BeanReference(type = ResultHistoryMinistryLocalService.class)
	protected ResultHistoryMinistryLocalService resultHistoryMinistryLocalService;
	@BeanReference(type = ResultHistoryMinistryService.class)
	protected ResultHistoryMinistryService resultHistoryMinistryService;
	@BeanReference(type = ResultHistoryMinistryPersistence.class)
	protected ResultHistoryMinistryPersistence resultHistoryMinistryPersistence;
	@BeanReference(type = ResultHistoryMinistryFinder.class)
	protected ResultHistoryMinistryFinder resultHistoryMinistryFinder;
	@BeanReference(type = ResultMinistryLocalService.class)
	protected ResultMinistryLocalService resultMinistryLocalService;
	@BeanReference(type = ResultMinistryService.class)
	protected ResultMinistryService resultMinistryService;
	@BeanReference(type = ResultMinistryPersistence.class)
	protected ResultMinistryPersistence resultMinistryPersistence;
	@BeanReference(type = ResultMinistryFinder.class)
	protected ResultMinistryFinder resultMinistryFinder;
	@BeanReference(type = ResultNotificationLocalService.class)
	protected ResultNotificationLocalService resultNotificationLocalService;
	@BeanReference(type = ResultNotificationService.class)
	protected ResultNotificationService resultNotificationService;
	@BeanReference(type = ResultNotificationPersistence.class)
	protected ResultNotificationPersistence resultNotificationPersistence;
	@BeanReference(type = ResultNotificationFinder.class)
	protected ResultNotificationFinder resultNotificationFinder;
	@BeanReference(type = CounterLocalService.class)
	protected CounterLocalService counterLocalService;
	@BeanReference(type = ResourceLocalService.class)
	protected ResourceLocalService resourceLocalService;
	@BeanReference(type = ResourceService.class)
	protected ResourceService resourceService;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserLocalService.class)
	protected UserLocalService userLocalService;
	@BeanReference(type = UserService.class)
	protected UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static Log _log = LogFactoryUtil.getLog(ResultHistoryMinistryLocalServiceBaseImpl.class);
	private String _beanIdentifier;
}