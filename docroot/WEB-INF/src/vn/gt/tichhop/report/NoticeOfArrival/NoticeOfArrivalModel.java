package vn.gt.tichhop.report.NoticeOfArrival;

import java.util.List;

import vn.gt.dao.noticeandmessage.model.TempNoTiceShipMessage;

public class NoticeOfArrivalModel {

	private List<TempNoTiceShipMessage> tempNoTiceShipMessage;
	private String message;
	private String signPlace;
	private String signDate;
	private Integer id;
	
	public String getSignPlace() {
		return signPlace;
	}

	public void setSignPlace(String signPlace) {
		this.signPlace = signPlace;
	}

	public String getSignDate() {
		return signDate;
	}

	public void setSignDate(String signDate) {
		this.signDate = signDate;
	}

	public NoticeOfArrivalModel() {};
	
	public NoticeOfArrivalModel(List<TempNoTiceShipMessage> tempNoTiceShipMessage, String message) {
		super();
		this.tempNoTiceShipMessage = tempNoTiceShipMessage;
		this.message = message;
	}
	
	public List<TempNoTiceShipMessage> getTempNoTiceShipMessage() {
		return tempNoTiceShipMessage;
	}
	
	public void setTempNoTiceShipMessage(List<TempNoTiceShipMessage> tempNoTiceShipMessage) {
		this.tempNoTiceShipMessage = tempNoTiceShipMessage;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
