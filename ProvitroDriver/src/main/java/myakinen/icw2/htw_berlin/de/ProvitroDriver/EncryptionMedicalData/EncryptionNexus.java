package myakinen.icw2.htw_berlin.de.ProvitroDriver.EncryptionMedicalData;
import java.util.List;
import java.util.ArrayList;

import myakinen.icw2.htw_berlin.de.ProvitroAPI.EncryptionMedicalDataInterface;

//Modification of Kirstein original Algorithm 
public class EncryptionNexus implements EncryptionMedicalDataInterface {
	
	//Second Key 
	public static final int SECONDKEY = 100;
	
	public String EncryptData(String patientData, String key) throws Exception{
		// TODO Auto-generated method stub
		String result="";
		char[] charArr= patientData.toCharArray();
		char[] firstKeyToString= key.toCharArray(); 
		int[] intArr= new int[firstKeyToString.length];
		List<Integer> intArray = new ArrayList<Integer>();
		for (int i=0; i<charArr.length; i++)		
			intArray.add((int)charArr[i]+SECONDKEY);
		for (int i=0; i<firstKeyToString.length; i++)
			intArr[i]= Character.getNumericValue(firstKeyToString[i]);	
		int div= intArray.size()/intArr.length;
		int rest= intArray.size()%intArr.length;
		int langKey= (intArray.size()/intArr.length)*intArr.length+intArray.size()%intArr.length;
		List<Integer>ringKey = new ArrayList<Integer>();
		for(int i=0; i<div; i++)
			for(int j=0; j<intArr.length; j++)
				ringKey.add(new Integer(intArr[j]));
		for (int i=0; i<=rest; i++)
			ringKey.add(new Integer(intArr[i]));
		List<String> resultArrayString= new ArrayList<String>();
		for (int i=0; i<intArray.size(); i++)
			resultArrayString.add(Integer.toString(intArray.get(i)+ringKey.get(i)));	
		for (String s:resultArrayString)
			result=result+s;
		return result;
	}

	public String DecryptData(String patientData, String key) throws Exception{
		// TODO Auto-generated method stub
		int iterator = patientData.length()/3;
		List<String> stringArray= new ArrayList<String>();
		int n=0;
		int m=3;
		for (int i=0; i<iterator; i++)
			{
				stringArray.add(patientData.substring(n,m));
				n=n+3;
				m=m+3;
			}
		//System.out.println("stringarr "+ stringArray.size());
		List<Integer> intArray = new ArrayList<Integer>();
		for(String s: stringArray)
		{
			intArray.add(Integer.parseInt(s));
		}
		char[] firstKeyToString= key.toCharArray();
		int[] intArr= new int[firstKeyToString.length];
		for (int i=0; i<firstKeyToString.length; i++)
		{
			intArr[i]= Character.getNumericValue(firstKeyToString[i]);
		}
		int div= intArray.size()/intArr.length;
		int rest= intArray.size()%intArr.length;
		//System.out.println("intArry "+ intArray.size());
		int langKey= (intArray.size()/intArr.length)*intArr.length+intArray.size()%intArr.length;
		List<Integer>ringKey = new ArrayList<Integer>();
		for(int i=0; i<div; i++)
			for(int j=0; j<intArr.length; j++)
				ringKey.add(new Integer(intArr[j]));
		for (int i=0; i<rest; i++)
			ringKey.add(new Integer(intArr[i]));
		//System.out.println("Ring "+ ringKey.size());
		List<Integer> resultInt= new ArrayList<Integer>();
		for (int i=0; i<intArray.size(); i++)
			resultInt.add(intArray.get(i)-ringKey.get(i)-SECONDKEY);
		//System.out.println("ResultInt "+ resultInt.size());
		String result="";
		for (int i=0; i<resultInt.size(); i++)
			result= result+(char)resultInt.get(i).byteValue();
		return result;
	}

}
