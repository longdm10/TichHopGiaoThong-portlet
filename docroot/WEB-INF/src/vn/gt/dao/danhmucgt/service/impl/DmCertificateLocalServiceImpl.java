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

package vn.gt.dao.danhmucgt.service.impl;

import java.util.ArrayList;
import java.util.List;

import vn.gt.dao.danhmucgt.model.DmCertificate;
import vn.gt.dao.danhmucgt.service.base.DmCertificateLocalServiceBaseImpl;

/**
 * The implementation of the dm certificate local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link vn.gt.dao.danhmucgt.service.DmCertificateLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author win_64
 * @see vn.gt.dao.danhmucgt.service.base.DmCertificateLocalServiceBaseImpl
 * @see vn.gt.dao.danhmucgt.service.DmCertificateLocalServiceUtil
 */
public class DmCertificateLocalServiceImpl
	extends DmCertificateLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link vn.gt.dao.danhmucgt.service.DmCertificateLocalServiceUtil} to access the dm certificate local service.
	 */
	
	public List<DmCertificate> findByCertificateCode(String certificateCode) {
		try {
			return dmCertificatePersistence.findByCertificateCode(certificateCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<DmCertificate>();
	}
	
	public List<DmCertificate> findByCertificateCodeAndcertificateName(String certificateCode, String certificateName) {
		try {
			return dmCertificatePersistence.findByCertificateCodeAndCertificateName(certificateCode, certificateName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<DmCertificate>();
	}
}