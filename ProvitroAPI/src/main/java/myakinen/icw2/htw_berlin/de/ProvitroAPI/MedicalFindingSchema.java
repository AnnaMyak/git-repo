package myakinen.icw2.htw_berlin.de.ProvitroAPI;

public class MedicalFindingSchema {
	public String MedCase;
	public String RootPatient;
	public String LastName;
	public String FirstName;
	public String DateOfBirth;
	public String BefText;
	
	public String getMedCase() {
		return MedCase;
	}
	public void setMedCase(String medCase) {
		MedCase = medCase;
	}
	public String getRootPatient() {
		return RootPatient;
	}
	public void setRootPatient(String rootPatient) {
		RootPatient = rootPatient;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getFirstname() {
		return FirstName;
	}
	public void setFirstname(String firstname) {
		FirstName = firstname;
	}
	public String getDateOfBirth() {
		return DateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}
	public String getBefText() {
		return BefText;
	}
	public void setBefText(String befText) {
		BefText = befText;
	}

}
