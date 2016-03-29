package vn.gt.tichhop.report.CrewEffectsDeclaration;

import java.util.List;

import vn.gt.dao.noticeandmessage.model.TempCrewEffectsDeclaration;
import vn.gt.dao.noticeandmessage.model.TempCrewEffectsItems;

public class CrewEffectsDeclarationModel {
	
	private List<TempCrewEffectsDeclaration> tempCrewEffectsDeclarations;
	private List<TempCrewEffectsItems> tempCrewEffectsItems;
	private String signDate;
	private String signPlace;
	
	public CrewEffectsDeclarationModel(List<TempCrewEffectsDeclaration> tempCrewEffectsDeclarations,
			List<TempCrewEffectsItems> tempCrewEffectsItems, String signDate, String signPlace) {
		super();
		this.tempCrewEffectsDeclarations = tempCrewEffectsDeclarations;
		this.tempCrewEffectsItems = tempCrewEffectsItems;
		this.signDate = signDate;
		this.signPlace = signPlace;
	}
	
	public CrewEffectsDeclarationModel() {
	}
	
	public List<TempCrewEffectsDeclaration> getTempCrewEffectsDeclarations() {
		return tempCrewEffectsDeclarations;
	}
	
	public void setTempCrewEffectsDeclarations(List<TempCrewEffectsDeclaration> tempCrewEffectsDeclarations) {
		this.tempCrewEffectsDeclarations = tempCrewEffectsDeclarations;
	}
	
	public List<TempCrewEffectsItems> getTempCrewEffectsItems() {
		return tempCrewEffectsItems;
	}
	
	public void setTempCrewEffectsItems(List<TempCrewEffectsItems> tempCrewEffectsItems) {
		this.tempCrewEffectsItems = tempCrewEffectsItems;
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
