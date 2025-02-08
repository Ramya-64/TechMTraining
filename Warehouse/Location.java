package Warehouse;

class Location {
	// constructor
	public Location(int aisle, int shelf, int bin) {
		this.aisle = aisle;
		this.shelf = shelf;
		this.bin = bin;
	}

	int aisle, shelf, bin;

	@Override
	public String toString() {
		return "Location [aisle=" + aisle + ", shelf=" + shelf + ", bin=" + bin + "]";
	}
}
