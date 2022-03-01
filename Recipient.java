package functional;

import java.util.*;

public class Recipient {

	private ArrayList<String> fields, entries;
	
	public Recipient(ArrayList<String> f, ArrayList<String> e) {
		// basic constructor
		fields = f;
		entries = e;
	}
	
	public String yoink(String key) {
		if(fields.contains(key)) return entries.get(fields.indexOf(key));
		new ErrorMessage("Field \"" + key + "\" does not exist");
		return "";
	}
	
	public ArrayList<String> getFields(){
		return fields;
	}
	
	public String getField(int index){
		return fields.get(index);
	}
	
	public ArrayList<String> getEntries(){
		return entries;
	}
	
	public String getEntry(int index){
		return entries.get(index);
	}

}
