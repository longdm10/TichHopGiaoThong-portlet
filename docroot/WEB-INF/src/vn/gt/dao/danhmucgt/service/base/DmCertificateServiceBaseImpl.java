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

package vn.gt.dao.danhmucgt.service.base;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.base.PrincipalBean;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import vn.gt.dao.danhmucgt.model.DmCertificate;
import vn.gt.dao.danhmucgt.service.DmCertificateLocalService;
import vn.gt.dao.danhmucgt.service.DmCertificateService;
import vn.gt.dao.danhmucgt.service.DmGTBusinessTypeLocalService;
import vn.gt.dao.danhmucgt.service.DmGTBusinessTypeService;
import vn.gt.dao.danhmucgt.service.DmGTFunctionTypeLocalService;
import vn.gt.dao.danhmucgt.service.DmGTFunctionTypeService;
import vn.gt.dao.danhmucgt.service.DmGTShipPositionLocalService;
import vn.gt.dao.danhmucgt.service.DmGTShipPositionService;
import vn.gt.dao.danhmucgt.service.DmGtOrganizationLocalService;
import vn.gt.dao.danhmucgt.service.DmGtOrganizationService;
import vn.gt.dao.danhmucgt.service.DmGtReportCategoryLocalService;
import vn.gt.dao.danhmucgt.service.DmGtReportCategoryService;
import vn.gt.dao.danhmucgt.service.DmGtReportTemplateLocalService;
import vn.gt.dao.danhmucgt.service.DmGtReportTemplateService;
import vn.gt.dao.danhmucgt.service.DmGtRouteConfigLocalService;
import vn.gt.dao.danhmucgt.service.DmGtRouteConfigService;
import vn.gt.dao.danhmucgt.service.DmGtStatusLocalService;
import vn.gt.dao.danhmucgt.service.DmGtStatusService;
import vn.gt.dao.danhmucgt.service.DmGtVersionLocalService;
import vn.gt.dao.danhmucgt.service.DmHistoryMinistryLocalService;
import vn.gt.dao.danhmucgt.service.DmHistoryMinistryService;
import vn.gt.dao.danhmucgt.service.DmMinistryLocalService;
import vn.gt.dao.danhmucgt.service.DmMinistryService;
import vn.gt.dao.danhmucgt.service.persistence.DmCertificatePersistence;
import vn.gt.dao.danhmucgt.service.persistence.DmGTBusinessTypePersistence;
import vn.gt.dao.danhmucgt.service.persistence.DmGTFunctionTypePersistence;
import vn.gt.dao.danhmucgt.service.persistence.DmGTShipPositionFinder;
import vn.gt.dao.danhmucgt.service.persistence.DmGTShipPositionPersistence;
import vn.gt.dao.danhmucgt.service.persistence.DmGtOrganizationPersistence;
import vn.gt.dao.danhmucgt.service.persistence.DmGtReportCategoryPersistence;
import vn.gt.dao.danhmucgt.service.persistence.DmGtReportTemplatePersistence;
import vn.gt.dao.danhmucgt.service.persistence.DmGtRouteConfigPersistence;
import vn.gt.dao.danhmucgt.service.persistence.DmGtStatusFinder;
import vn.gt.dao.danhmucgt.service.persistence.DmGtStatusPersistence;
import vn.gt.dao.danhmucgt.service.persistence.DmGtVersionPersistence;
import vn.gt.dao.danhmucgt.service.persistence.DmHistoryMinistryPersistence;
import vn.gt.dao.danhmucgt.service.persistence.DmMinistryPersistence;

import javax.sql.DataSource;

/**
 * The base implementation of the dm certificate remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link vn.gt.dao.danhmucgt.service.impl.DmCertificateServiceImpl}.
 * </p>
 *
 * @author win_64
 * @see vn.gt.dao.danhmucgt.service.impl.DmCertificateServiceImpl
 * @see vn.gt.dao.danhmucgt.service.DmCertificateServiceUtil
 * @generated
 */
public abstract class DmCertificateServiceBaseImpl extends PrincipalBean
	implements DmCertificateService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link vn.gt.dao.danhmucgt.service.DmCertificateServiceUtil} to access the dm certificate remote service.
	 */

	/**
	 * Returns the dm certificate local service.
	 *
	 * @return the dm certificate local service
	 */
	public DmCertificateLocalService getDmCertificateLocalService() {
		return dmCertificateLocalService;
	}

	/**
	 * Sets the dm certificate local service.
	 *
	 * @param dmCertificateLocalService the dm certificate local service
	 */
	public void setDmCertificateLocalService(
		DmCertificateLocalService dmCertificateLocalService) {
		this.dmCertificateLocalService = dmCertificateLocalService;
	}

	/**
	 * Returns the dm certificate remote service.
	 *
	 * @return the dm certificate remote service
	 */
	public DmCertificateService getDmCertificateService() {
		return dmCertificateService;
	}

	/**
	 * Sets the dm certificate remote service.
	 *
	 * @param dmCertificateService the dm certificate remote service
	 */
	public void setDmCertificateService(
		DmCertificateService dmCertificateService) {
		this.dmCertificateService = dmCertificateService;
	}

	/**
	 * Returns the dm certificate persistence.
	 *
	 * @return the dm certificate persistence
	 */
	public DmCertificatePersistence getDmCertificatePersistence() {
		return dmCertificatePersistence;
	}

	/**
	 * Sets the dm certificate persistence.
	 *
	 * @param dmCertificatePersistence the dm certificate persistence
	 */
	public void setDmCertificatePersistence(
		DmCertificatePersistence dmCertificatePersistence) {
		this.dmCertificatePersistence = dmCertificatePersistence;
	}

	/**
	 * Returns the dm g t business type local service.
	 *
	 * @return the dm g t business type local service
	 */
	public DmGTBusinessTypeLocalService getDmGTBusinessTypeLocalService() {
		return dmGTBusinessTypeLocalService;
	}

	/**
	 * Sets the dm g t business type local service.
	 *
	 * @param dmGTBusinessTypeLocalService the dm g t business type local service
	 */
	public void setDmGTBusinessTypeLocalService(
		DmGTBusinessTypeLocalService dmGTBusinessTypeLocalService) {
		this.dmGTBusinessTypeLocalService = dmGTBusinessTypeLocalService;
	}

	/**
	 * Returns the dm g t business type remote service.
	 *
	 * @return the dm g t business type remote service
	 */
	public DmGTBusinessTypeService getDmGTBusinessTypeService() {
		return dmGTBusinessTypeService;
	}

	/**
	 * Sets the dm g t business type remote service.
	 *
	 * @param dmGTBusinessTypeService the dm g t business type remote service
	 */
	public void setDmGTBusinessTypeService(
		DmGTBusinessTypeService dmGTBusinessTypeService) {
		this.dmGTBusinessTypeService = dmGTBusinessTypeService;
	}

	/**
	 * Returns the dm g t business type persistence.
	 *
	 * @return the dm g t business type persistence
	 */
	public DmGTBusinessTypePersistence getDmGTBusinessTypePersistence() {
		return dmGTBusinessTypePersistence;
	}

	/**
	 * Sets the dm g t business type persistence.
	 *
	 * @param dmGTBusinessTypePersistence the dm g t business type persistence
	 */
	public void setDmGTBusinessTypePersistence(
		DmGTBusinessTypePersistence dmGTBusinessTypePersistence) {
		this.dmGTBusinessTypePersistence = dmGTBusinessTypePersistence;
	}

	/**
	 * Returns the dm g t function type local service.
	 *
	 * @return the dm g t function type local service
	 */
	public DmGTFunctionTypeLocalService getDmGTFunctionTypeLocalService() {
		return dmGTFunctionTypeLocalService;
	}

	/**
	 * Sets the dm g t function type local service.
	 *
	 * @param dmGTFunctionTypeLocalService the dm g t function type local service
	 */
	public void setDmGTFunctionTypeLocalService(
		DmGTFunctionTypeLocalService dmGTFunctionTypeLocalService) {
		this.dmGTFunctionTypeLocalService = dmGTFunctionTypeLocalService;
	}

	/**
	 * Returns the dm g t function type remote service.
	 *
	 * @return the dm g t function type remote service
	 */
	public DmGTFunctionTypeService getDmGTFunctionTypeService() {
		return dmGTFunctionTypeService;
	}

	/**
	 * Sets the dm g t function type remote service.
	 *
	 * @param dmGTFunctionTypeService the dm g t function type remote service
	 */
	public void setDmGTFunctionTypeService(
		DmGTFunctionTypeService dmGTFunctionTypeService) {
		this.dmGTFunctionTypeService = dmGTFunctionTypeService;
	}

	/**
	 * Returns the dm g t function type persistence.
	 *
	 * @return the dm g t function type persistence
	 */
	public DmGTFunctionTypePersistence getDmGTFunctionTypePersistence() {
		return dmGTFunctionTypePersistence;
	}

	/**
	 * Sets the dm g t function type persistence.
	 *
	 * @param dmGTFunctionTypePersistence the dm g t function type persistence
	 */
	public void setDmGTFunctionTypePersistence(
		DmGTFunctionTypePersistence dmGTFunctionTypePersistence) {
		this.dmGTFunctionTypePersistence = dmGTFunctionTypePersistence;
	}

	/**
	 * Returns the dm gt organization local service.
	 *
	 * @return the dm gt organization local service
	 */
	public DmGtOrganizationLocalService getDmGtOrganizationLocalService() {
		return dmGtOrganizationLocalService;
	}

	/**
	 * Sets the dm gt organization local service.
	 *
	 * @param dmGtOrganizationLocalService the dm gt organization local service
	 */
	public void setDmGtOrganizationLocalService(
		DmGtOrganizationLocalService dmGtOrganizationLocalService) {
		this.dmGtOrganizationLocalService = dmGtOrganizationLocalService;
	}

	/**
	 * Returns the dm gt organization remote service.
	 *
	 * @return the dm gt organization remote service
	 */
	public DmGtOrganizationService getDmGtOrganizationService() {
		return dmGtOrganizationService;
	}

	/**
	 * Sets the dm gt organization remote service.
	 *
	 * @param dmGtOrganizationService the dm gt organization remote service
	 */
	public void setDmGtOrganizationService(
		DmGtOrganizationService dmGtOrganizationService) {
		this.dmGtOrganizationService = dmGtOrganizationService;
	}

	/**
	 * Returns the dm gt organization persistence.
	 *
	 * @return the dm gt organization persistence
	 */
	public DmGtOrganizationPersistence getDmGtOrganizationPersistence() {
		return dmGtOrganizationPersistence;
	}

	/**
	 * Sets the dm gt organization persistence.
	 *
	 * @param dmGtOrganizationPersistence the dm gt organization persistence
	 */
	public void setDmGtOrganizationPersistence(
		DmGtOrganizationPersistence dmGtOrganizationPersistence) {
		this.dmGtOrganizationPersistence = dmGtOrganizationPersistence;
	}

	/**
	 * Returns the dm gt report category local service.
	 *
	 * @return the dm gt report category local service
	 */
	public DmGtReportCategoryLocalService getDmGtReportCategoryLocalService() {
		return dmGtReportCategoryLocalService;
	}

	/**
	 * Sets the dm gt report category local service.
	 *
	 * @param dmGtReportCategoryLocalService the dm gt report category local service
	 */
	public void setDmGtReportCategoryLocalService(
		DmGtReportCategoryLocalService dmGtReportCategoryLocalService) {
		this.dmGtReportCategoryLocalService = dmGtReportCategoryLocalService;
	}

	/**
	 * Returns the dm gt report category remote service.
	 *
	 * @return the dm gt report category remote service
	 */
	public DmGtReportCategoryService getDmGtReportCategoryService() {
		return dmGtReportCategoryService;
	}

	/**
	 * Sets the dm gt report category remote service.
	 *
	 * @param dmGtReportCategoryService the dm gt report category remote service
	 */
	public void setDmGtReportCategoryService(
		DmGtReportCategoryService dmGtReportCategoryService) {
		this.dmGtReportCategoryService = dmGtReportCategoryService;
	}

	/**
	 * Returns the dm gt report category persistence.
	 *
	 * @return the dm gt report category persistence
	 */
	public DmGtReportCategoryPersistence getDmGtReportCategoryPersistence() {
		return dmGtReportCategoryPersistence;
	}

	/**
	 * Sets the dm gt report category persistence.
	 *
	 * @param dmGtReportCategoryPersistence the dm gt report category persistence
	 */
	public void setDmGtReportCategoryPersistence(
		DmGtReportCategoryPersistence dmGtReportCategoryPersistence) {
		this.dmGtReportCategoryPersistence = dmGtReportCategoryPersistence;
	}

	/**
	 * Returns the dm gt report template local service.
	 *
	 * @return the dm gt report template local service
	 */
	public DmGtReportTemplateLocalService getDmGtReportTemplateLocalService() {
		return dmGtReportTemplateLocalService;
	}

	/**
	 * Sets the dm gt report template local service.
	 *
	 * @param dmGtReportTemplateLocalService the dm gt report template local service
	 */
	public void setDmGtReportTemplateLocalService(
		DmGtReportTemplateLocalService dmGtReportTemplateLocalService) {
		this.dmGtReportTemplateLocalService = dmGtReportTemplateLocalService;
	}

	/**
	 * Returns the dm gt report template remote service.
	 *
	 * @return the dm gt report template remote service
	 */
	public DmGtReportTemplateService getDmGtReportTemplateService() {
		return dmGtReportTemplateService;
	}

	/**
	 * Sets the dm gt report template remote service.
	 *
	 * @param dmGtReportTemplateService the dm gt report template remote service
	 */
	public void setDmGtReportTemplateService(
		DmGtReportTemplateService dmGtReportTemplateService) {
		this.dmGtReportTemplateService = dmGtReportTemplateService;
	}

	/**
	 * Returns the dm gt report template persistence.
	 *
	 * @return the dm gt report template persistence
	 */
	public DmGtReportTemplatePersistence getDmGtReportTemplatePersistence() {
		return dmGtReportTemplatePersistence;
	}

	/**
	 * Sets the dm gt report template persistence.
	 *
	 * @param dmGtReportTemplatePersistence the dm gt report template persistence
	 */
	public void setDmGtReportTemplatePersistence(
		DmGtReportTemplatePersistence dmGtReportTemplatePersistence) {
		this.dmGtReportTemplatePersistence = dmGtReportTemplatePersistence;
	}

	/**
	 * Returns the dm gt route config local service.
	 *
	 * @return the dm gt route config local service
	 */
	public DmGtRouteConfigLocalService getDmGtRouteConfigLocalService() {
		return dmGtRouteConfigLocalService;
	}

	/**
	 * Sets the dm gt route config local service.
	 *
	 * @param dmGtRouteConfigLocalService the dm gt route config local service
	 */
	public void setDmGtRouteConfigLocalService(
		DmGtRouteConfigLocalService dmGtRouteConfigLocalService) {
		this.dmGtRouteConfigLocalService = dmGtRouteConfigLocalService;
	}

	/**
	 * Returns the dm gt route config remote service.
	 *
	 * @return the dm gt route config remote service
	 */
	public DmGtRouteConfigService getDmGtRouteConfigService() {
		return dmGtRouteConfigService;
	}

	/**
	 * Sets the dm gt route config remote service.
	 *
	 * @param dmGtRouteConfigService the dm gt route config remote service
	 */
	public void setDmGtRouteConfigService(
		DmGtRouteConfigService dmGtRouteConfigService) {
		this.dmGtRouteConfigService = dmGtRouteConfigService;
	}

	/**
	 * Returns the dm gt route config persistence.
	 *
	 * @return the dm gt route config persistence
	 */
	public DmGtRouteConfigPersistence getDmGtRouteConfigPersistence() {
		return dmGtRouteConfigPersistence;
	}

	/**
	 * Sets the dm gt route config persistence.
	 *
	 * @param dmGtRouteConfigPersistence the dm gt route config persistence
	 */
	public void setDmGtRouteConfigPersistence(
		DmGtRouteConfigPersistence dmGtRouteConfigPersistence) {
		this.dmGtRouteConfigPersistence = dmGtRouteConfigPersistence;
	}

	/**
	 * Returns the dm g t ship position local service.
	 *
	 * @return the dm g t ship position local service
	 */
	public DmGTShipPositionLocalService getDmGTShipPositionLocalService() {
		return dmGTShipPositionLocalService;
	}

	/**
	 * Sets the dm g t ship position local service.
	 *
	 * @param dmGTShipPositionLocalService the dm g t ship position local service
	 */
	public void setDmGTShipPositionLocalService(
		DmGTShipPositionLocalService dmGTShipPositionLocalService) {
		this.dmGTShipPositionLocalService = dmGTShipPositionLocalService;
	}

	/**
	 * Returns the dm g t ship position remote service.
	 *
	 * @return the dm g t ship position remote service
	 */
	public DmGTShipPositionService getDmGTShipPositionService() {
		return dmGTShipPositionService;
	}

	/**
	 * Sets the dm g t ship position remote service.
	 *
	 * @param dmGTShipPositionService the dm g t ship position remote service
	 */
	public void setDmGTShipPositionService(
		DmGTShipPositionService dmGTShipPositionService) {
		this.dmGTShipPositionService = dmGTShipPositionService;
	}

	/**
	 * Returns the dm g t ship position persistence.
	 *
	 * @return the dm g t ship position persistence
	 */
	public DmGTShipPositionPersistence getDmGTShipPositionPersistence() {
		return dmGTShipPositionPersistence;
	}

	/**
	 * Sets the dm g t ship position persistence.
	 *
	 * @param dmGTShipPositionPersistence the dm g t ship position persistence
	 */
	public void setDmGTShipPositionPersistence(
		DmGTShipPositionPersistence dmGTShipPositionPersistence) {
		this.dmGTShipPositionPersistence = dmGTShipPositionPersistence;
	}

	/**
	 * Returns the dm g t ship position finder.
	 *
	 * @return the dm g t ship position finder
	 */
	public DmGTShipPositionFinder getDmGTShipPositionFinder() {
		return dmGTShipPositionFinder;
	}

	/**
	 * Sets the dm g t ship position finder.
	 *
	 * @param dmGTShipPositionFinder the dm g t ship position finder
	 */
	public void setDmGTShipPositionFinder(
		DmGTShipPositionFinder dmGTShipPositionFinder) {
		this.dmGTShipPositionFinder = dmGTShipPositionFinder;
	}

	/**
	 * Returns the dm gt status local service.
	 *
	 * @return the dm gt status local service
	 */
	public DmGtStatusLocalService getDmGtStatusLocalService() {
		return dmGtStatusLocalService;
	}

	/**
	 * Sets the dm gt status local service.
	 *
	 * @param dmGtStatusLocalService the dm gt status local service
	 */
	public void setDmGtStatusLocalService(
		DmGtStatusLocalService dmGtStatusLocalService) {
		this.dmGtStatusLocalService = dmGtStatusLocalService;
	}

	/**
	 * Returns the dm gt status remote service.
	 *
	 * @return the dm gt status remote service
	 */
	public DmGtStatusService getDmGtStatusService() {
		return dmGtStatusService;
	}

	/**
	 * Sets the dm gt status remote service.
	 *
	 * @param dmGtStatusService the dm gt status remote service
	 */
	public void setDmGtStatusService(DmGtStatusService dmGtStatusService) {
		this.dmGtStatusService = dmGtStatusService;
	}

	/**
	 * Returns the dm gt status persistence.
	 *
	 * @return the dm gt status persistence
	 */
	public DmGtStatusPersistence getDmGtStatusPersistence() {
		return dmGtStatusPersistence;
	}

	/**
	 * Sets the dm gt status persistence.
	 *
	 * @param dmGtStatusPersistence the dm gt status persistence
	 */
	public void setDmGtStatusPersistence(
		DmGtStatusPersistence dmGtStatusPersistence) {
		this.dmGtStatusPersistence = dmGtStatusPersistence;
	}

	/**
	 * Returns the dm gt status finder.
	 *
	 * @return the dm gt status finder
	 */
	public DmGtStatusFinder getDmGtStatusFinder() {
		return dmGtStatusFinder;
	}

	/**
	 * Sets the dm gt status finder.
	 *
	 * @param dmGtStatusFinder the dm gt status finder
	 */
	public void setDmGtStatusFinder(DmGtStatusFinder dmGtStatusFinder) {
		this.dmGtStatusFinder = dmGtStatusFinder;
	}

	/**
	 * Returns the dm gt version local service.
	 *
	 * @return the dm gt version local service
	 */
	public DmGtVersionLocalService getDmGtVersionLocalService() {
		return dmGtVersionLocalService;
	}

	/**
	 * Sets the dm gt version local service.
	 *
	 * @param dmGtVersionLocalService the dm gt version local service
	 */
	public void setDmGtVersionLocalService(
		DmGtVersionLocalService dmGtVersionLocalService) {
		this.dmGtVersionLocalService = dmGtVersionLocalService;
	}

	/**
	 * Returns the dm gt version persistence.
	 *
	 * @return the dm gt version persistence
	 */
	public DmGtVersionPersistence getDmGtVersionPersistence() {
		return dmGtVersionPersistence;
	}

	/**
	 * Sets the dm gt version persistence.
	 *
	 * @param dmGtVersionPersistence the dm gt version persistence
	 */
	public void setDmGtVersionPersistence(
		DmGtVersionPersistence dmGtVersionPersistence) {
		this.dmGtVersionPersistence = dmGtVersionPersistence;
	}

	/**
	 * Returns the dm history ministry local service.
	 *
	 * @return the dm history ministry local service
	 */
	public DmHistoryMinistryLocalService getDmHistoryMinistryLocalService() {
		return dmHistoryMinistryLocalService;
	}

	/**
	 * Sets the dm history ministry local service.
	 *
	 * @param dmHistoryMinistryLocalService the dm history ministry local service
	 */
	public void setDmHistoryMinistryLocalService(
		DmHistoryMinistryLocalService dmHistoryMinistryLocalService) {
		this.dmHistoryMinistryLocalService = dmHistoryMinistryLocalService;
	}

	/**
	 * Returns the dm history ministry remote service.
	 *
	 * @return the dm history ministry remote service
	 */
	public DmHistoryMinistryService getDmHistoryMinistryService() {
		return dmHistoryMinistryService;
	}

	/**
	 * Sets the dm history ministry remote service.
	 *
	 * @param dmHistoryMinistryService the dm history ministry remote service
	 */
	public void setDmHistoryMinistryService(
		DmHistoryMinistryService dmHistoryMinistryService) {
		this.dmHistoryMinistryService = dmHistoryMinistryService;
	}

	/**
	 * Returns the dm history ministry persistence.
	 *
	 * @return the dm history ministry persistence
	 */
	public DmHistoryMinistryPersistence getDmHistoryMinistryPersistence() {
		return dmHistoryMinistryPersistence;
	}

	/**
	 * Sets the dm history ministry persistence.
	 *
	 * @param dmHistoryMinistryPersistence the dm history ministry persistence
	 */
	public void setDmHistoryMinistryPersistence(
		DmHistoryMinistryPersistence dmHistoryMinistryPersistence) {
		this.dmHistoryMinistryPersistence = dmHistoryMinistryPersistence;
	}

	/**
	 * Returns the dm ministry local service.
	 *
	 * @return the dm ministry local service
	 */
	public DmMinistryLocalService getDmMinistryLocalService() {
		return dmMinistryLocalService;
	}

	/**
	 * Sets the dm ministry local service.
	 *
	 * @param dmMinistryLocalService the dm ministry local service
	 */
	public void setDmMinistryLocalService(
		DmMinistryLocalService dmMinistryLocalService) {
		this.dmMinistryLocalService = dmMinistryLocalService;
	}

	/**
	 * Returns the dm ministry remote service.
	 *
	 * @return the dm ministry remote service
	 */
	public DmMinistryService getDmMinistryService() {
		return dmMinistryService;
	}

	/**
	 * Sets the dm ministry remote service.
	 *
	 * @param dmMinistryService the dm ministry remote service
	 */
	public void setDmMinistryService(DmMinistryService dmMinistryService) {
		this.dmMinistryService = dmMinistryService;
	}

	/**
	 * Returns the dm ministry persistence.
	 *
	 * @return the dm ministry persistence
	 */
	public DmMinistryPersistence getDmMinistryPersistence() {
		return dmMinistryPersistence;
	}

	/**
	 * Sets the dm ministry persistence.
	 *
	 * @param dmMinistryPersistence the dm ministry persistence
	 */
	public void setDmMinistryPersistence(
		DmMinistryPersistence dmMinistryPersistence) {
		this.dmMinistryPersistence = dmMinistryPersistence;
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
	}

	public void destroy() {
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
		return DmCertificate.class;
	}

	protected String getModelClassName() {
		return DmCertificate.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = dmCertificatePersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = DmCertificateLocalService.class)
	protected DmCertificateLocalService dmCertificateLocalService;
	@BeanReference(type = DmCertificateService.class)
	protected DmCertificateService dmCertificateService;
	@BeanReference(type = DmCertificatePersistence.class)
	protected DmCertificatePersistence dmCertificatePersistence;
	@BeanReference(type = DmGTBusinessTypeLocalService.class)
	protected DmGTBusinessTypeLocalService dmGTBusinessTypeLocalService;
	@BeanReference(type = DmGTBusinessTypeService.class)
	protected DmGTBusinessTypeService dmGTBusinessTypeService;
	@BeanReference(type = DmGTBusinessTypePersistence.class)
	protected DmGTBusinessTypePersistence dmGTBusinessTypePersistence;
	@BeanReference(type = DmGTFunctionTypeLocalService.class)
	protected DmGTFunctionTypeLocalService dmGTFunctionTypeLocalService;
	@BeanReference(type = DmGTFunctionTypeService.class)
	protected DmGTFunctionTypeService dmGTFunctionTypeService;
	@BeanReference(type = DmGTFunctionTypePersistence.class)
	protected DmGTFunctionTypePersistence dmGTFunctionTypePersistence;
	@BeanReference(type = DmGtOrganizationLocalService.class)
	protected DmGtOrganizationLocalService dmGtOrganizationLocalService;
	@BeanReference(type = DmGtOrganizationService.class)
	protected DmGtOrganizationService dmGtOrganizationService;
	@BeanReference(type = DmGtOrganizationPersistence.class)
	protected DmGtOrganizationPersistence dmGtOrganizationPersistence;
	@BeanReference(type = DmGtReportCategoryLocalService.class)
	protected DmGtReportCategoryLocalService dmGtReportCategoryLocalService;
	@BeanReference(type = DmGtReportCategoryService.class)
	protected DmGtReportCategoryService dmGtReportCategoryService;
	@BeanReference(type = DmGtReportCategoryPersistence.class)
	protected DmGtReportCategoryPersistence dmGtReportCategoryPersistence;
	@BeanReference(type = DmGtReportTemplateLocalService.class)
	protected DmGtReportTemplateLocalService dmGtReportTemplateLocalService;
	@BeanReference(type = DmGtReportTemplateService.class)
	protected DmGtReportTemplateService dmGtReportTemplateService;
	@BeanReference(type = DmGtReportTemplatePersistence.class)
	protected DmGtReportTemplatePersistence dmGtReportTemplatePersistence;
	@BeanReference(type = DmGtRouteConfigLocalService.class)
	protected DmGtRouteConfigLocalService dmGtRouteConfigLocalService;
	@BeanReference(type = DmGtRouteConfigService.class)
	protected DmGtRouteConfigService dmGtRouteConfigService;
	@BeanReference(type = DmGtRouteConfigPersistence.class)
	protected DmGtRouteConfigPersistence dmGtRouteConfigPersistence;
	@BeanReference(type = DmGTShipPositionLocalService.class)
	protected DmGTShipPositionLocalService dmGTShipPositionLocalService;
	@BeanReference(type = DmGTShipPositionService.class)
	protected DmGTShipPositionService dmGTShipPositionService;
	@BeanReference(type = DmGTShipPositionPersistence.class)
	protected DmGTShipPositionPersistence dmGTShipPositionPersistence;
	@BeanReference(type = DmGTShipPositionFinder.class)
	protected DmGTShipPositionFinder dmGTShipPositionFinder;
	@BeanReference(type = DmGtStatusLocalService.class)
	protected DmGtStatusLocalService dmGtStatusLocalService;
	@BeanReference(type = DmGtStatusService.class)
	protected DmGtStatusService dmGtStatusService;
	@BeanReference(type = DmGtStatusPersistence.class)
	protected DmGtStatusPersistence dmGtStatusPersistence;
	@BeanReference(type = DmGtStatusFinder.class)
	protected DmGtStatusFinder dmGtStatusFinder;
	@BeanReference(type = DmGtVersionLocalService.class)
	protected DmGtVersionLocalService dmGtVersionLocalService;
	@BeanReference(type = DmGtVersionPersistence.class)
	protected DmGtVersionPersistence dmGtVersionPersistence;
	@BeanReference(type = DmHistoryMinistryLocalService.class)
	protected DmHistoryMinistryLocalService dmHistoryMinistryLocalService;
	@BeanReference(type = DmHistoryMinistryService.class)
	protected DmHistoryMinistryService dmHistoryMinistryService;
	@BeanReference(type = DmHistoryMinistryPersistence.class)
	protected DmHistoryMinistryPersistence dmHistoryMinistryPersistence;
	@BeanReference(type = DmMinistryLocalService.class)
	protected DmMinistryLocalService dmMinistryLocalService;
	@BeanReference(type = DmMinistryService.class)
	protected DmMinistryService dmMinistryService;
	@BeanReference(type = DmMinistryPersistence.class)
	protected DmMinistryPersistence dmMinistryPersistence;
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
	private String _beanIdentifier;
}