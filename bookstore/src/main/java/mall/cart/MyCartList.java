package mall.cart;

import java.util.HashMap;
import java.util.Map;

public class MyCartList {

	private Map<String,Integer> orderlists = null; 

	public MyCartList() {
		orderlists = new HashMap<String,Integer>();
	}

	public void addOrder(String isbn,int oqty) {
		if(orderlists.containsKey(isbn)==false) {
			orderlists.put(isbn, oqty);
		}
		else {
			oqty = orderlists.get(isbn) + oqty;
			orderlists.put(isbn, oqty);
		}
	}
	public void removeOrder(String isbn) {	
		orderlists.remove(isbn);
	}


	public Map<String, Integer> getAllOrderLists() {
		return orderlists;
	}

}
