package Warehouse;

import java.util.List;

class Order {
	String id;
	List<String> productIDs;
	int priority;

	// constructor
	public Order(String id, List<String> productIDs, int priority) {
		this.id = id;
		this.productIDs = productIDs;
		this.priority = priority;
	}
}
