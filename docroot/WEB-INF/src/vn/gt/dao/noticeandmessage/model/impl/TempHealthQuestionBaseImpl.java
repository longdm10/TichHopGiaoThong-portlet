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

import vn.gt.dao.noticeandmessage.model.TempHealthQuestion;
import vn.gt.dao.noticeandmessage.service.TempHealthQuestionLocalServiceUtil;

/**
 * The extended model base implementation for the TempHealthQuestion service. Represents a row in the &quot;TEMP_HEALTH_QUESTION&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TempHealthQuestionImpl}.
 * </p>
 *
 * @author win_64
 * @see TempHealthQuestionImpl
 * @see vn.gt.dao.noticeandmessage.model.TempHealthQuestion
 * @generated
 */
public abstract class TempHealthQuestionBaseImpl
	extends TempHealthQuestionModelImpl implements TempHealthQuestion {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a temp health question model instance should use the {@link TempHealthQuestion} interface instead.
	 */
	public void persist() throws SystemException {
		if (this.isNew()) {
			TempHealthQuestionLocalServiceUtil.addTempHealthQuestion(this);
		}
		else {
			TempHealthQuestionLocalServiceUtil.updateTempHealthQuestion(this);
		}
	}
}