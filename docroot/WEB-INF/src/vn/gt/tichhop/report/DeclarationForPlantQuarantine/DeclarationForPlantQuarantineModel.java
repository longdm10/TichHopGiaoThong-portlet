package vn.gt.tichhop.report.DeclarationForPlantQuarantine;

import java.util.List;

import vn.gt.dao.noticeandmessage.model.TempPlantQuarantine;

public class DeclarationForPlantQuarantineModel {

	List<TempPlantQuarantine> tempPlantQuarantines;

	public List<TempPlantQuarantine> getTempPlantQuarantines() {
		return tempPlantQuarantines;
	}

	public void setTempPlantQuarantines(
			List<TempPlantQuarantine> tempPlantQuarantines) {
		this.tempPlantQuarantines = tempPlantQuarantines;
	}

	/**
	 * @param tempPlantQuarantines
	 */
	public DeclarationForPlantQuarantineModel(
			List<TempPlantQuarantine> tempPlantQuarantines) {
		super();
		this.tempPlantQuarantines = tempPlantQuarantines;
	}

	public DeclarationForPlantQuarantineModel(){
		
	}
}
