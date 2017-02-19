package myakinen.icw2.htw_berlin.de.ProvitroDriver.EncryptionMedicalData;
import myakinen.icw2.htw_berlin.de.ProvitroAPI.*;


public class EncryptionDCPathos implements EncryptionMedicalDataInterface  {

	//Original Kirstein-Algorithm encrypt root patient Data
		public String EncryptData(String patientData, String key) throws Exception{
			patientData=patientData.replace("-", "");
			char [] charArr = patientData.toCharArray();
			int[] intArr= new int[charArr.length];
			String str="";
			for (int i=0; i<charArr.length; i++)
			{
				if (((int)charArr[i]>=65&&(int)charArr[i]<=90)||((int)charArr[i]>=97&&(int)charArr[i]<=122))
						intArr[i]=(int)charArr[i];	
				else
						intArr[i]=Character.getNumericValue(charArr[i]);
				str=str+Integer.toString(intArr[i]);
			}
			return Integer.toString(Integer.parseInt(str)+Integer.parseInt(key));
		}
		
		
		
		//Original Kirstein-Algorithm decrypt root patient Data
		public String DecryptData(String patientData, String key) throws Exception{
			// TODO Auto-generated method stub
			String parseData=Integer.toString(Integer.parseInt(patientData)-Integer.parseInt(key));
			String numLetter=parseData.substring(0, 3);
			if (Integer.parseInt(numLetter)>127)
			{
				numLetter=parseData.substring(0, 2);
			}
			String str=(char)Integer.parseInt(numLetter)+ parseData.substring(numLetter.length(), parseData.length());
			StringBuilder result = new StringBuilder(str);
			return result.insert(str.length()-2, '-').toString();
			
		}

}
