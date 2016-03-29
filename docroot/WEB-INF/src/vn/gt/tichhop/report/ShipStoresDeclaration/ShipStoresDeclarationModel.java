package vn.gt.tichhop.report.ShipStoresDeclaration;

import java.util.List;

import vn.gt.dao.noticeandmessage.model.TempShipStoresDeclaration;
import vn.gt.dao.noticeandmessage.model.TempShipStoresItems;


public class ShipStoresDeclarationModel {
	
	private List<TempShipStoresDeclaration> tempShipStoresDeclarationes;
	private List<TempShipStoresItems> tempShipStoresItems;
	private String signDate;
	private String signPlace;
	
	public ShipStoresDeclarationModel() {};

	public ShipStoresDeclarationModel(List<TempShipStoresDeclaration> tempShipStoresDeclarationes,
			List<TempShipStoresItems> tempShipStoresItems, String signDate, String signPlace) {
		super();
		this.tempShipStoresDeclarationes = tempShipStoresDeclarationes;
		this.tempShipStoresItems = tempShipStoresItems;
		this.signDate = signDate;
		this.signPlace = signPlace;
	}

	public List<TempShipStoresDeclaration> getTempShipStoresDeclarationes() {
		return tempShipStoresDeclarationes;
	}
	
	public void setTempShipStoresDeclarationes(List<TempShipStoresDeclaration> tempShipStoresDeclarationes) {
		this.tempShipStoresDeclarationes = tempShipStoresDeclarationes;
	}
	
	public List<TempShipStoresItems> getTempShipStoresItems() {
		return tempShipStoresItems;
	}
	
	public void setTempShipStoresItems(List<TempShipStoresItems> tempShipStoresItems) {
		this.tempShipStoresItems = tempShipStoresItems;
	}

	public String getSignDate() {
		return signDate;
	}

	public void setSignDate(String signDate) {
		this.signDate = signDate;
	}

	public String getSignPlace() {
		return signPlace;
	}

	public void setSignPlace(String signPlace) {
		this.signPlace = signPlace;
	}
}
