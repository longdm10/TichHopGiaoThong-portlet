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

package vn.gt.dao.noticeandmessage.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import vn.gt.dao.noticeandmessage.model.TempCargoDeclaration;
import vn.gt.dao.noticeandmessage.service.TempCargoDeclarationLocalServiceUtil;

/**
 * The extended model base implementation for the TempCargoDeclaration service. Represents a row in the &quot;TEMP_CARGO_DECLARATION&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TempCargoDeclarationImpl}.
 * </p>
 *
 * @author win_64
 * @see TempCargoDeclarationImpl
 * @see vn.gt.dao.noticeandmessage.model.TempCargoDeclaration
 * @generated
 */
public abstract class TempCargoDeclarationBaseImpl
	extends TempCargoDeclarationModelImpl implements TempCargoDeclaration {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a temp cargo declaration model instance should use the {@link TempCargoDeclaration} interface instead.
	 */
	public void persist() throws SystemException {
		if (this.isNew()) {
			TempCargoDeclarationLocalServiceUtil.addTempCargoDeclaration(this);
		}
		else {
			TempCargoDeclarationLocalServiceUtil.updateTempCargoDeclaration(this);
		}
	}
}