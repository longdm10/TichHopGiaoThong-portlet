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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * The interface for the issue permission for transit local service.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author win_64
 * @see IssuePermissionForTransitLocalServiceUtil
 * @see vn.gt.dao.noticeandmessage.service.base.IssuePermissionForTransitLocalServiceBaseImpl
 * @see vn.gt.dao.noticeandmessage.service.impl.IssuePermissionForTransitLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface IssuePermissionForTransitLocalService
	extends PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link IssuePermissionForTransitLocalServiceUtil} to access the issue permission for transit local service. Add custom service methods to {@link vn.gt.dao.noticeandmessage.service.impl.IssuePermissionForTransitLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the issue permission for transit to the database. Also notifies the appropriate model listeners.
	*
	* @param issuePermissionForTransit the issue permission for transit
	* @return the issue permission for transit that was added
	* @throws SystemException if a system exception occurred
	*/
	public vn.gt.dao.noticeandmessage.model.IssuePermissionForTransit addIssuePermissionForTransit(
		vn.gt.dao.noticeandmessage.model.IssuePermissionForTransit issuePermissionForTransit)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new issue permission for transit with the primary key. Does not add the issue permission for transit to the database.
	*
	* @param id the primary key for the new issue permission for transit
	* @return the new issue permission for transit
	*/
	public vn.gt.dao.noticeandmessage.model.IssuePermissionForTransit createIssuePermissionForTransit(
		long id);

	/**
	* Deletes the issue permission for transit with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the issue permission for transit
	* @throws PortalException if a issue permission for transit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteIssuePermissionForTransit(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the issue permission for transit from the database. Also notifies the appropriate model listeners.
	*
	* @param issuePermissionForTransit the issue permission for transit
	* @throws SystemException if a system exception occurred
	*/
	public void deleteIssuePermissionForTransit(
		vn.gt.dao.noticeandmessage.model.IssuePermissionForTransit issuePermissionForTransit)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public vn.gt.dao.noticeandmessage.model.IssuePermissionForTransit fetchIssuePermissionForTransit(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the issue permission for transit with the primary key.
	*
	* @param id the primary key of the issue permission for transit
	* @return the issue permission for transit
	* @throws PortalException if a issue permission for transit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public vn.gt.dao.noticeandmessage.model.IssuePermissionForTransit getIssuePermissionForTransit(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the issue permission for transits.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of issue permission for transits
	* @param end the upper bound of the range of issue permission for transits (not inclusive)
	* @return the range of issue permission for transits
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<vn.gt.dao.noticeandmessage.model.IssuePermissionForTransit> getIssuePermissionForTransits(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of issue permission for transits.
	*
	* @return the number of issue permission for transits
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getIssuePermissionForTransitsCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the issue permission for transit in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param issuePermissionForTransit the issue permission for transit
	* @return the issue permission for transit that was updated
	* @throws SystemException if a system exception occurred
	*/
	public vn.gt.dao.noticeandmessage.model.IssuePermissionForTransit updateIssuePermissionForTransit(
		vn.gt.dao.noticeandmessage.model.IssuePermissionForTransit issuePermissionForTransit)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the issue permission for transit in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param issuePermissionForTransit the issue permission for transit
	* @param merge whether to merge the issue permission for transit with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the issue permission for transit that was updated
	* @throws SystemException if a system exception occurred
	*/
	public vn.gt.dao.noticeandmessage.model.IssuePermissionForTransit updateIssuePermissionForTransit(
		vn.gt.dao.noticeandmessage.model.IssuePermissionForTransit issuePermissionForTransit,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	public java.util.List<vn.gt.dao.noticeandmessage.model.IssuePermissionForTransit> findIssuePermissionForTransitByDocumentYearAndDocumentYear(
		long documentName, int documentYear);

	public vn.gt.dao.noticeandmessage.model.IssuePermissionForTransit findIssuePermissionForTransitByDocumentYearAndDocumentYearAndRequestState(
		long documentName, int documentYear, int requestState);

	public java.util.List<vn.gt.dao.noticeandmessage.model.IssuePermissionForTransit> findByrequestCode(
		java.lang.String requestCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public vn.gt.dao.noticeandmessage.model.IssuePermissionForTransit getByrequestCode(
		java.lang.String requestCode);

	public java.util.List<vn.gt.dao.noticeandmessage.model.IssuePermissionForTransit> findBydocumentNameAndDocumentYear(
		long documentName, int documentYear)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<vn.gt.dao.noticeandmessage.model.IssuePermissionForTransit> findBydocumentNameAndDocumentYear(
		long documentName, int documentYear, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<vn.gt.dao.noticeandmessage.model.IssuePermissionForTransit> findIssuePermissionForTransitInfo(
		java.lang.String requestState, java.lang.String maritimeCode,
		java.lang.String portCode, java.lang.String shipName,
		java.lang.String callSign, java.lang.String shipDateFrom,
		java.lang.String shipDateTo, int start, int end);

	public int countIssuePermissionForTransitInfo(
		java.lang.String requestState, java.lang.String maritimeCode,
		java.lang.String portCode, java.lang.String shipName,
		java.lang.String callSign, java.lang.String shipDateFrom,
		java.lang.String shipDateTo);

	public int countByDocumentNameAndDocumentYear(long documentName,
		int documentYear);

	public java.util.List<vn.gt.dao.noticeandmessage.model.IssuePermissionForTransit> findByDocumentYearAndDocumentYearOrderByColumn(
		long documentName, int documentYear, java.lang.String orderByColumn,
		boolean ascOrdesc);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public vn.gt.dao.noticeandmessage.model.IssuePermissionForTransit getByDocumentNameAndDocumentYearAndVersionNo(
		long documentName, int documentYear, java.lang.String versionNo);

	public java.lang.String capGiayPhepSo(java.lang.String maritimeReference)
		throws com.liferay.portal.kernel.exception.SystemException;
}