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

package vn.gt.dao.common.service.base;

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

import vn.gt.dao.common.model.UserPort;
import vn.gt.dao.common.service.LogMessageValidationLocalService;
import vn.gt.dao.common.service.LogMessageValidationService;
import vn.gt.dao.common.service.UserPortLocalService;
import vn.gt.dao.common.service.UserPortService;
import vn.gt.dao.common.service.persistence.LogMessageValidationPersistence;
import vn.gt.dao.common.service.persistence.UserPortPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the user port local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link vn.gt.dao.common.service.impl.UserPortLocalServiceImpl}.
 * </p>
 *
 * @author win_64
 * @see vn.gt.dao.common.service.impl.UserPortLocalServiceImpl
 * @see vn.gt.dao.common.service.UserPortLocalServiceUtil
 * @generated
 */
public abstract class UserPortLocalServiceBaseImpl
	implements UserPortLocalService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link vn.gt.dao.common.service.UserPortLocalServiceUtil} to access the user port local service.
	 */

	/**
	 * Adds the user port to the database. Also notifies the appropriate model listeners.
	 *
	 * @param userPort the user port
	 * @return the user port that was added
	 * @throws SystemException if a system exception occurred
	 */
	public UserPort addUserPort(UserPort userPort) throws SystemException {
		userPort.setNew(true);

		userPort = userPortPersistence.update(userPort, false);

		Indexer indexer = IndexerRegistryUtil.getIndexer(getModelClassName());

		if (indexer != null) {
			try {
				indexer.reindex(userPort);
			}
			catch (SearchException se) {
				if (_log.isWarnEnabled()) {
					_log.warn(se, se);
				}
			}
		}

		return userPort;
	}

	/**
	 * Creates a new user port with the primary key. Does not add the user port to the database.
	 *
	 * @param id the primary key for the new user port
	 * @return the new user port
	 */
	public UserPort createUserPort(long id) {
		return userPortPersistence.create(id);
	}

	/**
	 * Deletes the user port with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the user port
	 * @throws PortalException if a user port with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public void deleteUserPort(long id) throws PortalException, SystemException {
		UserPort userPort = userPortPersistence.remove(id);

		Indexer indexer = IndexerRegistryUtil.getIndexer(getModelClassName());

		if (indexer != null) {
			try {
				indexer.delete(userPort);
			}
			catch (SearchException se) {
				if (_log.isWarnEnabled()) {
					_log.warn(se, se);
				}
			}
		}
	}

	/**
	 * Deletes the user port from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userPort the user port
	 * @throws SystemException if a system exception occurred
	 */
	public void deleteUserPort(UserPort userPort) throws SystemException {
		userPortPersistence.remove(userPort);

		Indexer indexer = IndexerRegistryUtil.getIndexer(getModelClassName());

		if (indexer != null) {
			try {
				indexer.delete(userPort);
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
		return userPortPersistence.findWithDynamicQuery(dynamicQuery);
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
		return userPortPersistence.findWithDynamicQuery(dynamicQuery, start, end);
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
		return userPortPersistence.findWithDynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return userPortPersistence.countWithDynamicQuery(dynamicQuery);
	}

	public UserPort fetchUserPort(long id) throws SystemException {
		return userPortPersistence.fetchByPrimaryKey(id);
	}

	/**
	 * Returns the user port with the primary key.
	 *
	 * @param id the primary key of the user port
	 * @return the user port
	 * @throws PortalException if a user port with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserPort getUserPort(long id)
		throws PortalException, SystemException {
		return userPortPersistence.findByPrimaryKey(id);
	}

	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return userPortPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the user ports.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of user ports
	 * @param end the upper bound of the range of user ports (not inclusive)
	 * @return the range of user ports
	 * @throws SystemException if a system exception occurred
	 */
	public List<UserPort> getUserPorts(int start, int end)
		throws SystemException {
		return userPortPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of user ports.
	 *
	 * @return the number of user ports
	 * @throws SystemException if a system exception occurred
	 */
	public int getUserPortsCount() throws SystemException {
		return userPortPersistence.countAll();
	}

	/**
	 * Updates the user port in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param userPort the user port
	 * @return the user port that was updated
	 * @throws SystemException if a system exception occurred
	 */
	public UserPort updateUserPort(UserPort userPort) throws SystemException {
		return updateUserPort(userPort, true);
	}

	/**
	 * Updates the user port in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param userPort the user port
	 * @param merge whether to merge the user port with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the user port that was updated
	 * @throws SystemException if a system exception occurred
	 */
	public UserPort updateUserPort(UserPort userPort, boolean merge)
		throws SystemException {
		userPort.setNew(false);

		userPort = userPortPersistence.update(userPort, merge);

		Indexer indexer = IndexerRegistryUtil.getIndexer(getModelClassName());

		if (indexer != null) {
			try {
				indexer.reindex(userPort);
			}
			catch (SearchException se) {
				if (_log.isWarnEnabled()) {
					_log.warn(se, se);
				}
			}
		}

		return userPort;
	}

	/**
	 * Returns the log message validation local service.
	 *
	 * @return the log message validation local service
	 */
	public LogMessageValidationLocalService getLogMessageValidationLocalService() {
		return logMessageValidationLocalService;
	}

	/**
	 * Sets the log message validation local service.
	 *
	 * @param logMessageValidationLocalService the log message validation local service
	 */
	public void setLogMessageValidationLocalService(
		LogMessageValidationLocalService logMessageValidationLocalService) {
		this.logMessageValidationLocalService = logMessageValidationLocalService;
	}

	/**
	 * Returns the log message validation remote service.
	 *
	 * @return the log message validation remote service
	 */
	public LogMessageValidationService getLogMessageValidationService() {
		return logMessageValidationService;
	}

	/**
	 * Sets the log message validation remote service.
	 *
	 * @param logMessageValidationService the log message validation remote service
	 */
	public void setLogMessageValidationService(
		LogMessageValidationService logMessageValidationService) {
		this.logMessageValidationService = logMessageValidationService;
	}

	/**
	 * Returns the log message validation persistence.
	 *
	 * @return the log message validation persistence
	 */
	public LogMessageValidationPersistence getLogMessageValidationPersistence() {
		return logMessageValidationPersistence;
	}

	/**
	 * Sets the log message validation persistence.
	 *
	 * @param logMessageValidationPersistence the log message validation persistence
	 */
	public void setLogMessageValidationPersistence(
		LogMessageValidationPersistence logMessageValidationPersistence) {
		this.logMessageValidationPersistence = logMessageValidationPersistence;
	}

	/**
	 * Returns the user port local service.
	 *
	 * @return the user port local service
	 */
	public UserPortLocalService getUserPortLocalService() {
		return userPortLocalService;
	}

	/**
	 * Sets the user port local service.
	 *
	 * @param userPortLocalService the user port local service
	 */
	public void setUserPortLocalService(
		UserPortLocalService userPortLocalService) {
		this.userPortLocalService = userPortLocalService;
	}

	/**
	 * Returns the user port remote service.
	 *
	 * @return the user port remote service
	 */
	public UserPortService getUserPortService() {
		return userPortService;
	}

	/**
	 * Sets the user port remote service.
	 *
	 * @param userPortService the user port remote service
	 */
	public void setUserPortService(UserPortService userPortService) {
		this.userPortService = userPortService;
	}

	/**
	 * Returns the user port persistence.
	 *
	 * @return the user port persistence
	 */
	public UserPortPersistence getUserPortPersistence() {
		return userPortPersistence;
	}

	/**
	 * Sets the user port persistence.
	 *
	 * @param userPortPersistence the user port persistence
	 */
	public void setUserPortPersistence(UserPortPersistence userPortPersistence) {
		this.userPortPersistence = userPortPersistence;
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
		PersistedModelLocalServiceRegistryUtil.register("vn.gt.dao.common.model.UserPort",
			userPortLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"vn.gt.dao.common.model.UserPort");
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
		return UserPort.class;
	}

	protected String getModelClassName() {
		return UserPort.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = userPortPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = LogMessageValidationLocalService.class)
	protected LogMessageValidationLocalService logMessageValidationLocalService;
	@BeanReference(type = LogMessageValidationService.class)
	protected LogMessageValidationService logMessageValidationService;
	@BeanReference(type = LogMessageValidationPersistence.class)
	protected LogMessageValidationPersistence logMessageValidationPersistence;
	@BeanReference(type = UserPortLocalService.class)
	protected UserPortLocalService userPortLocalService;
	@BeanReference(type = UserPortService.class)
	protected UserPortService userPortService;
	@BeanReference(type = UserPortPersistence.class)
	protected UserPortPersistence userPortPersistence;
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
	private static Log _log = LogFactoryUtil.getLog(UserPortLocalServiceBaseImpl.class);
	private String _beanIdentifier;
}