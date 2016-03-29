package vn.gt.tichhop.report.ShipSecurityNotification;

import java.util.List;

import vn.gt.dao.noticeandmessage.model.TempShipSecurityMessage;
import vn.gt.dao.noticeandmessage.model.TempShipSecurityPortItems;

public class ShipSecurityNotificationModel {
	
	private List<TempShipSecurityMessage> tempShipSecurityMessages;
	private List<TempShipSecurityPortItems> tempCrewLists;
	
	public ShipSecurityNotificationModel(List<TempShipSecurityMessage> tempShipSecurityMessages, List<TempShipSecurityPortItems> tempCrewLists) {
		this.tempShipSecurityMessages = tempShipSecurityMessages;
		this.tempCrewLists = tempCrewLists;
	}
	
	public ShipSecurityNotificationModel() {
		
	}
	
	public List<TempShipSecurityMessage> getTempShipSecurityMessages() {
		return tempShipSecurityMessages;
	}
	
	public void setTempShipSecurityMessages(List<TempShipSecurityMessage> tempShipSecurityMessages) {
		this.tempShipSecurityMessages = tempShipSecurityMessages;
	}
	
	public List<TempShipSecurityPortItems> getTempCrewLists() {
		return tempCrewLists;
	}
	
	public void setTempCrewLists(List<TempShipSecurityPortItems> tempCrewLists) {
		this.tempCrewLists = tempCrewLists;
	}
	
}
