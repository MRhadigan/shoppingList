import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class shoppingList {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		HashMap<String, Double> inventory = new HashMap<String, Double>();
		// create a shoppingCart ArrayList
		ArrayList<String> shoppingCart = new ArrayList<String>();
		String cont;
		//String format = "%s\t\t%s";
		
		// filling the inventory
		inventory = fillInventory(inventory);
		
		// displays the inventory
		displayInventory(inventory);
			

		
		do {
			//scanner, inventory, prompt
			// "Enter item name: "
			String prompt = "What item would you like to order? ";
			String newItem = enterItem(scan, inventory, prompt);
			// add that item to the shoppingCart
			shoppingCart.add(newItem);
			
			// "Add another item? (y/n)"
			System.out.println("Add another item? (y/n) ");
			cont = scan.nextLine().toLowerCase();
			
		} while (cont.startsWith("y"));
		
		
		System.out.println("Thanks for your order! ");
		System.out.println("Here's what you got: ");
		System.out.println("====================");
	
		
		
		average(shoppingCart, inventory);
		
		
		highest(shoppingCart, inventory);
		
		
		//lowest(shoppingCart, inventory);
		
	}

//	private static void lowest(ArrayList<String> shoppingCart, HashMap<String, Double> inventory) {
//		double lowest = 0.0;
//		//String fruit; 
//		
//		for ( String fruit : shoppingCart) {
//			
//			lowest += inventory.get(fruit);
//					lowest = inventory.get(fruit);
//				
//		System.out.println("The lowest priced item is the "+ fruit + "s" + " at " + lowest);
//		}
//	}

	private static void highest(ArrayList<String> shoppingCart, HashMap<String, Double> inventory) {
		double highest = 0.0;
		
		String format2 = "%-12s : %s";
		
		for ( String fruit : shoppingCart) {
			
			highest += inventory.get(fruit);
				highest = inventory.get(fruit);
			
		System.out.printf(format2, fruit, inventory.get(fruit));
		System.out.println();
		}
	}

	private static void average(ArrayList<String> shoppingCart, HashMap<String, Double> inventory) {
		double sum = 0; // the total price added together
		int count = 0; // the number of individual items
		for ( String fruit : shoppingCart) {
			
			sum += inventory.get(fruit);
			count++;
		}
		System.out.println("Average price: " + sum/count);
	}

	private static String enterItem(Scanner scan, HashMap<String, Double> inventory, String prompt) {
		String userInput;
		
		
		System.out.println(prompt);
		userInput = scan.nextLine();
		
		// if user input is in our inventory, then return user input
		if (inventory.containsKey(userInput) == true) {
			System.out.println("Confirmation! " + userInput + " added to cart!");
			
			// else, repeat the method
		} else {
			System.out.println("Sorry, we cannot help you find your " + userInput + "!");
			enterItem(scan, inventory, prompt);
		}
		
		return userInput;
	}

	private static HashMap<String, Double> fillInventory(HashMap<String, Double> inventory) {
		
		inventory.put("grapefruit", 1.99);
		inventory.put("apple", 0.99);
		inventory.put("banana", 0.59);
		inventory.put("cauliflower", 1.59);
		inventory.put("dragonfruit", 2.19);
		inventory.put("Elderberry", 1.79);
		inventory.put("figs", 2.09);
		inventory.put("grapefruit", 1.99);
		inventory.put("honeydew", 3.49);
		
		
		
		return inventory;
	}

	private static void displayInventory(HashMap<String, Double> inventory) {
		
		// we want to use a for loop.
		
		String format = "%s\t\t%s";
		String format2 = "%-12s : %s";
		System.out.printf(format2, "Item", "Price");
		System.out.println();
		System.out.println("====================");
		
		// loop through our inventory by key (which is the list of fruits)
		for (String food : inventory.keySet()) {
			
			// this line prints out for each individual food
			System.out.printf(format2, food, inventory.get(food));
			System.out.println();
		}
	}

}