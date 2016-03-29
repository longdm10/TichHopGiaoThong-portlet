package vn.gt.tichhop.report.DeclarationForAnimalQuarantine;

import java.util.List;

import vn.gt.dao.noticeandmessage.model.TempDeclarationForAnimalQuarantine;

public class DeclarationForAnimalQuarantineModel {
	
	private List<TempDeclarationForAnimalQuarantine> tempAnimalQuarantines;
	
	public List<TempDeclarationForAnimalQuarantine> getTempAnimalQuarantines() {
		return tempAnimalQuarantines;
	}
	
	public void setTempAnimalQuarantines(List<TempDeclarationForAnimalQuarantine> tempAnimalQuarantines) {
		this.tempAnimalQuarantines = tempAnimalQuarantines;
	}
	
	public DeclarationForAnimalQuarantineModel() {
	}

	public DeclarationForAnimalQuarantineModel(List<TempDeclarationForAnimalQuarantine> tempAnimalQuarantines) {
		super();
		this.tempAnimalQuarantines = tempAnimalQuarantines;
	}
}
