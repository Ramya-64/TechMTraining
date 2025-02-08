package Warehouse;
import java.util.Arrays;
public class WarehouseSystem {
	 public static void main(String[] args) {
	        InventoryManager inventory = new InventoryManager();

	        // Add Products
	        inventory.addProduct(new Product("P1", "Laptop", 5, new Location(1, 2, 5)));
	        inventory.addProduct(new Product("P2", "Mouse", 3, new Location(2, 1, 9)));

	        // Display Initial Inventory
	        System.out.println("\nInitial Inventory:");
	        inventory.displayInventory();

	        // Place Orders
	        inventory.placeOrder(new Order("O1", Arrays.asList("P1", "P2","P3"), 3));
	        inventory.placeOrder(new Order("O2", Arrays.asList("P1","P1","P2"), 1));

	        // Process Orders
	        inventory.processOrders();

	        // Display Updated Inventory
	        System.out.println("\nUpdated Inventory:");
	        inventory.displayInventory();
	    }
	}

