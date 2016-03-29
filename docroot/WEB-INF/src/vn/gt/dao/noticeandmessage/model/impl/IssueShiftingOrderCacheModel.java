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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import vn.gt.dao.noticeandmessage.model.IssueShiftingOrder;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing IssueShiftingOrder in entity cache.
 *
 * @author win_64
 * @see IssueShiftingOrder
 * @generated
 */
public class IssueShiftingOrderCacheModel implements CacheModel<IssueShiftingOrder>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(71);

		sb.append("{id=");
		sb.append(id);
		sb.append(", requestCode=");
		sb.append(requestCode);
		sb.append(", numberShiftingOrder=");
		sb.append(numberShiftingOrder);
		sb.append(", documentName=");
		sb.append(documentName);
		sb.append(", documentYear=");
		sb.append(documentYear);
		sb.append(", portofAuthority=");
		sb.append(portofAuthority);
		sb.append(", nameOfShip=");
		sb.append(nameOfShip);
		sb.append(", flagStateOfShip=");
		sb.append(flagStateOfShip);
		sb.append(", anchoringPortCode=");
		sb.append(anchoringPortCode);
		sb.append(", anchoringPortWharfCode=");
		sb.append(anchoringPortWharfCode);
		sb.append(", portHarbourCode=");
		sb.append(portHarbourCode);
		sb.append(", shiftingPortWharfCode=");
		sb.append(shiftingPortWharfCode);
		sb.append(", shiftingDate=");
		sb.append(shiftingDate);
		sb.append(", reasonToShift=");
		sb.append(reasonToShift);
		sb.append(", issueDate=");
		sb.append(issueDate);
		sb.append(", directorOfMaritime=");
		sb.append(directorOfMaritime);
		sb.append(", certificateNo=");
		sb.append(certificateNo);
		sb.append(", requestState=");
		sb.append(requestState);
		sb.append(", versionNo=");
		sb.append(versionNo);
		sb.append(", isApproval=");
		sb.append(isApproval);
		sb.append(", approvalDate=");
		sb.append(approvalDate);
		sb.append(", approvalName=");
		sb.append(approvalName);
		sb.append(", remarks=");
		sb.append(remarks);
		sb.append(", isCancel=");
		sb.append(isCancel);
		sb.append(", cancelDate=");
		sb.append(cancelDate);
		sb.append(", cancelName=");
		sb.append(cancelName);
		sb.append(", cancelNote=");
		sb.append(cancelNote);
		sb.append(", representative=");
		sb.append(representative);
		sb.append(", digitalAttachedFile=");
		sb.append(digitalAttachedFile);
		sb.append(", signDate=");
		sb.append(signDate);
		sb.append(", signName=");
		sb.append(signName);
		sb.append(", signTitle=");
		sb.append(signTitle);
		sb.append(", signPlace=");
		sb.append(signPlace);
		sb.append(", stampStatus=");
		sb.append(stampStatus);
		sb.append(", attachedFile=");
		sb.append(attachedFile);
		sb.append("}");

		return sb.toString();
	}

	public IssueShiftingOrder toEntityModel() {
		IssueShiftingOrderImpl issueShiftingOrderImpl = new IssueShiftingOrderImpl();

		issueShiftingOrderImpl.setId(id);

		if (requestCode == null) {
			issueShiftingOrderImpl.setRequestCode(StringPool.BLANK);
		}
		else {
			issueShiftingOrderImpl.setRequestCode(requestCode);
		}

		if (numberShiftingOrder == null) {
			issueShiftingOrderImpl.setNumberShiftingOrder(StringPool.BLANK);
		}
		else {
			issueShiftingOrderImpl.setNumberShiftingOrder(numberShiftingOrder);
		}

		issueShiftingOrderImpl.setDocumentName(documentName);
		issueShiftingOrderImpl.setDocumentYear(documentYear);

		if (portofAuthority == null) {
			issueShiftingOrderImpl.setPortofAuthority(StringPool.BLANK);
		}
		else {
			issueShiftingOrderImpl.setPortofAuthority(portofAuthority);
		}

		if (nameOfShip == null) {
			issueShiftingOrderImpl.setNameOfShip(StringPool.BLANK);
		}
		else {
			issueShiftingOrderImpl.setNameOfShip(nameOfShip);
		}

		if (flagStateOfShip == null) {
			issueShiftingOrderImpl.setFlagStateOfShip(StringPool.BLANK);
		}
		else {
			issueShiftingOrderImpl.setFlagStateOfShip(flagStateOfShip);
		}

		if (anchoringPortCode == null) {
			issueShiftingOrderImpl.setAnchoringPortCode(StringPool.BLANK);
		}
		else {
			issueShiftingOrderImpl.setAnchoringPortCode(anchoringPortCode);
		}

		if (anchoringPortWharfCode == null) {
			issueShiftingOrderImpl.setAnchoringPortWharfCode(StringPool.BLANK);
		}
		else {
			issueShiftingOrderImpl.setAnchoringPortWharfCode(anchoringPortWharfCode);
		}

		if (portHarbourCode == null) {
			issueShiftingOrderImpl.setPortHarbourCode(StringPool.BLANK);
		}
		else {
			issueShiftingOrderImpl.setPortHarbourCode(portHarbourCode);
		}

		if (shiftingPortWharfCode == null) {
			issueShiftingOrderImpl.setShiftingPortWharfCode(StringPool.BLANK);
		}
		else {
			issueShiftingOrderImpl.setShiftingPortWharfCode(shiftingPortWharfCode);
		}

		if (shiftingDate == Long.MIN_VALUE) {
			issueShiftingOrderImpl.setShiftingDate(null);
		}
		else {
			issueShiftingOrderImpl.setShiftingDate(new Date(shiftingDate));
		}

		if (reasonToShift == null) {
			issueShiftingOrderImpl.setReasonToShift(StringPool.BLANK);
		}
		else {
			issueShiftingOrderImpl.setReasonToShift(reasonToShift);
		}

		if (issueDate == Long.MIN_VALUE) {
			issueShiftingOrderImpl.setIssueDate(null);
		}
		else {
			issueShiftingOrderImpl.setIssueDate(new Date(issueDate));
		}

		if (directorOfMaritime == null) {
			issueShiftingOrderImpl.setDirectorOfMaritime(StringPool.BLANK);
		}
		else {
			issueShiftingOrderImpl.setDirectorOfMaritime(directorOfMaritime);
		}

		if (certificateNo == null) {
			issueShiftingOrderImpl.setCertificateNo(StringPool.BLANK);
		}
		else {
			issueShiftingOrderImpl.setCertificateNo(certificateNo);
		}

		issueShiftingOrderImpl.setRequestState(requestState);

		if (versionNo == null) {
			issueShiftingOrderImpl.setVersionNo(StringPool.BLANK);
		}
		else {
			issueShiftingOrderImpl.setVersionNo(versionNo);
		}

		issueShiftingOrderImpl.setIsApproval(isApproval);

		if (approvalDate == Long.MIN_VALUE) {
			issueShiftingOrderImpl.setApprovalDate(null);
		}
		else {
			issueShiftingOrderImpl.setApprovalDate(new Date(approvalDate));
		}

		if (approvalName == null) {
			issueShiftingOrderImpl.setApprovalName(StringPool.BLANK);
		}
		else {
			issueShiftingOrderImpl.setApprovalName(approvalName);
		}

		if (remarks == null) {
			issueShiftingOrderImpl.setRemarks(StringPool.BLANK);
		}
		else {
			issueShiftingOrderImpl.setRemarks(remarks);
		}

		issueShiftingOrderImpl.setIsCancel(isCancel);

		if (cancelDate == Long.MIN_VALUE) {
			issueShiftingOrderImpl.setCancelDate(null);
		}
		else {
			issueShiftingOrderImpl.setCancelDate(new Date(cancelDate));
		}

		if (cancelName == null) {
			issueShiftingOrderImpl.setCancelName(StringPool.BLANK);
		}
		else {
			issueShiftingOrderImpl.setCancelName(cancelName);
		}

		if (cancelNote == null) {
			issueShiftingOrderImpl.setCancelNote(StringPool.BLANK);
		}
		else {
			issueShiftingOrderImpl.setCancelNote(cancelNote);
		}

		if (representative == null) {
			issueShiftingOrderImpl.setRepresentative(StringPool.BLANK);
		}
		else {
			issueShiftingOrderImpl.setRepresentative(representative);
		}

		issueShiftingOrderImpl.setDigitalAttachedFile(digitalAttachedFile);

		if (signDate == Long.MIN_VALUE) {
			issueShiftingOrderImpl.setSignDate(null);
		}
		else {
			issueShiftingOrderImpl.setSignDate(new Date(signDate));
		}

		if (signName == null) {
			issueShiftingOrderImpl.setSignName(StringPool.BLANK);
		}
		else {
			issueShiftingOrderImpl.setSignName(signName);
		}

		if (signTitle == null) {
			issueShiftingOrderImpl.setSignTitle(StringPool.BLANK);
		}
		else {
			issueShiftingOrderImpl.setSignTitle(signTitle);
		}

		if (signPlace == null) {
			issueShiftingOrderImpl.setSignPlace(StringPool.BLANK);
		}
		else {
			issueShiftingOrderImpl.setSignPlace(signPlace);
		}

		issueShiftingOrderImpl.setStampStatus(stampStatus);
		issueShiftingOrderImpl.setAttachedFile(attachedFile);

		issueShiftingOrderImpl.resetOriginalValues();

		return issueShiftingOrderImpl;
	}

	public long id;
	public String requestCode;
	public String numberShiftingOrder;
	public long documentName;
	public int documentYear;
	public String portofAuthority;
	public String nameOfShip;
	public String flagStateOfShip;
	public String anchoringPortCode;
	public String anchoringPortWharfCode;
	public String portHarbourCode;
	public String shiftingPortWharfCode;
	public long shiftingDate;
	public String reasonToShift;
	public long issueDate;
	public String directorOfMaritime;
	public String certificateNo;
	public int requestState;
	public String versionNo;
	public int isApproval;
	public long approvalDate;
	public String approvalName;
	public String remarks;
	public int isCancel;
	public long cancelDate;
	public String cancelName;
	public String cancelNote;
	public String representative;
	public long digitalAttachedFile;
	public long signDate;
	public String signName;
	public String signTitle;
	public String signPlace;
	public int stampStatus;
	public long attachedFile;
}