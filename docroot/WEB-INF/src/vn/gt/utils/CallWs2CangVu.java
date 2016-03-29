package vn.gt.utils;

import vn.com.elcom.www.VNMWSSoap;
import vn.com.elcom.www.VNMWSSoapProxy;

public class CallWs2CangVu {
	public static VNMWSSoap getVNMWS() {
		try {
			VNMWSSoapProxy proxy = new VNMWSSoapProxy();
			VNMWSSoap vnmwsSoap = proxy.getVNMWSSoap();
			return vnmwsSoap;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static void main(String[] abc) {
		try {
			VNMWSSoap soap = CallWs2CangVu.getVNMWS();
			System.out.println("  anhnt ");
			String test = soap.sendMessage("anht");
			System.out.println("test  " + test);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
