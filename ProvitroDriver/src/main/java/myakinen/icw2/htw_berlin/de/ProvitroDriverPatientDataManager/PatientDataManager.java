package myakinen.icw2.htw_berlin.de.ProvitroDriverPatientDataManager;

import myakinen.icw2.htw_berlin.de.ProvitroAPI.PatientDataManagerInterface;

public class PatientDataManager implements PatientDataManagerInterface {
	

	public boolean isDCPathosOriginalData(String patientData) {
		// TODO Auto-generated method stub
		if (patientData.length()==9)
			return true;
		return false;
	}

	public boolean isDCPathosEncryptedData(String patientData) {
		// TODO Auto-generated method stub
		if (patientData.length()==10)
			return true;
		return false;
	}

}
