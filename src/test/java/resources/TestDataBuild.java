package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;

public class TestDataBuild {
	
	public AddPlace addPlacePayload(String name, String language, String address)
	{
		
		AddPlace p = new AddPlace();
		p.setAccuracy(50);
		p.setAddress(address);
		p.setLanguage(language);
		p.setPhone_number("(+27) 123 345345");
		p.setName(name);
		
		List<String> mylist= new ArrayList<String>();
		mylist.add("Foot Park");
		mylist.add("shop");
		p.setTypes(mylist);
		
		Location l = new Location();
		l.setLat(-38.345345);
		l.setLng(3.657567);
		p.setLocation(l);
		
		return p;
		
	}

}
