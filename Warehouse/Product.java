package Warehouse;

class Product {
	String id, name;
	int quantity;
	Location location;

	// constructor
	public Product(String id, String name, int quantity, Location location) {
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.location = location;
	}

	public synchronized boolean reduceStock(int amount) {
		if (quantity >= amount) {
			quantity -= amount;
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Product id=" + id + ", name=" + name + ", quantity=" + quantity;
	}
}
