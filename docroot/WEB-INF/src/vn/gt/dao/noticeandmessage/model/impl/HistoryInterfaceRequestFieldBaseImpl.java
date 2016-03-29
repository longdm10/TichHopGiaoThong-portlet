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

import vn.gt.dao.noticeandmessage.model.HistoryInterfaceRequestField;
import vn.gt.dao.noticeandmessage.service.HistoryInterfaceRequestFieldLocalServiceUtil;

/**
 * The extended model base implementation for the HistoryInterfaceRequestField service. Represents a row in the &quot;HISTORY_INTERFACE_REQUEST&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link HistoryInterfaceRequestFieldImpl}.
 * </p>
 *
 * @author win_64
 * @see HistoryInterfaceRequestFieldImpl
 * @see vn.gt.dao.noticeandmessage.model.HistoryInterfaceRequestField
 * @generated
 */
public abstract class HistoryInterfaceRequestFieldBaseImpl
	extends HistoryInterfaceRequestFieldModelImpl
	implements HistoryInterfaceRequestField {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a history interface request field model instance should use the {@link HistoryInterfaceRequestField} interface instead.
	 */
	public void persist() throws SystemException {
		if (this.isNew()) {
			HistoryInterfaceRequestFieldLocalServiceUtil.addHistoryInterfaceRequestField(this);
		}
		else {
			HistoryInterfaceRequestFieldLocalServiceUtil.updateHistoryInterfaceRequestField(this);
		}
	}
}