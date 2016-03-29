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

package vn.dao.gt.asw.service.impl;

import java.util.List;

import vn.dao.gt.asw.model.AswmsgMessageQueue;
import vn.dao.gt.asw.service.base.AswmsgMessageQueueLocalServiceBaseImpl;

/**
 * The implementation of the aswmsg message queue local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link vn.dao.gt.asw.service.AswmsgMessageQueueLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author win 64
 * @see vn.dao.gt.asw.service.base.AswmsgMessageQueueLocalServiceBaseImpl
 * @see vn.dao.gt.asw.service.AswmsgMessageQueueLocalServiceUtil
 */
public class AswmsgMessageQueueLocalServiceImpl
	extends AswmsgMessageQueueLocalServiceBaseImpl {
	public List<AswmsgMessageQueue> getListMessage2Queue(int count){
		try{
			return aswmsgMessageQueueFinder.getListMessage2Queue(count);
		}catch (Exception e) {
//			e.printStackTrace();
		} 
		return null;
	}
	
	public boolean updatePriorityAswmsgMessageQueue(long priority, long id) {
		try{
			
			return aswmsgMessageQueueFinder.updatePriorityAswmsgMessageQueue(priority,id);
		}catch (Exception e) {
//			e.printStackTrace();
		}
		return false;
	}
}