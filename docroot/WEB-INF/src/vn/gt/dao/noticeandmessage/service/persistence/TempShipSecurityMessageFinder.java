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

/**
 * @author win_64
 */
public interface TempShipSecurityMessageFinder {
	public java.util.List<vn.gt.dao.noticeandmessage.model.TempShipSecurityMessage> findBydocumentNameAnddocumentYear(
		long documentName, int documentYear);

	public vn.gt.dao.noticeandmessage.model.TempShipSecurityMessage getLastByDocumentNameAndDocumentYear(
		long documentName, int documentYear);

	public vn.gt.dao.noticeandmessage.model.TempShipSecurityMessage getByRequestCode(
		java.lang.String requestCode);

	public java.util.List<vn.gt.dao.noticeandmessage.model.TempShipSecurityMessage> findByDocumentNameAndDocumentYearOrderByDescRequestDate(
		long documentName, int documentYear);
}