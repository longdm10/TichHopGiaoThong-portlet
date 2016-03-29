package vn.gt.utils;

import org.tempuri.IMTService;
import org.tempuri.MTService;
import org.tempuri.MTServiceLocator;

public class CallWs2HaiQuan {
	
	public static IMTService getIMTSercice() {
		try {
			// MTServiceLocator mtServiceLocator = new MTServiceLocator();
			MTService mtService = new MTServiceLocator();
			IMTService imtService = mtService.getBasicHttpBinding_IMTService();
			return imtService;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
