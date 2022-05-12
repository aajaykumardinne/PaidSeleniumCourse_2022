package HashMapConcepts;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class UserData {

	public static void main(String[] args) {
		
	//	HashMap<String, String> userMap = new HashMap<String, String>();
		
		//top-casting
		// child class object can be referred by parent interface reference variable
		
		// Elements are not stored in a order in the HashMap
		
		Map<String,String> userMap1 = new HashMap<String, String>();
		
		userMap1.put("id", "1");
		userMap1.put("city", "Hyderbad");
		userMap1.put("name", "Hari");
//		userMap1.put(null, "Yellow");
		userMap1.put(null, "Green");
		userMap1.put("companyName", null);
		userMap1.put("address", null);
				
		System.out.println(userMap1.get("id"));
		System.out.println(userMap1.size());
		
		// print all the elments
		for(Map.Entry m : userMap1.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());
		}
		
		System.out.println("==================");
		userMap1.forEach((k, v) -> System.out.println(k + " :" + v));;
		
		
		//hashtable
		Hashtable<String, String> productsTable = new Hashtable<String,String>();
		productsTable.put("Apple Macbook", "2000");
		productsTable.put("Windows Dell Laptop", "1500");
		productsTable.put("Apple iPhone 12", "1200");
//		productsTable.put(null, "1500"); Nullpointer Exception
		productsTable.put("Apple watch", null); // Nullpointer Exception
		
		for(Map.Entry m : productsTable.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());
		}
		
		
		// diff between hashmap and hashtable
		// HashMap is not sychronized and not sychronized
		// contain one null key and many multiple values
		
		
		// Hashtable is sychronized , thread safe
		// can not contain null key and values.
		
	}

}
