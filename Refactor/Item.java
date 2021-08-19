package com.moncept.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Item{

	// I'm using a HashMap to store key value pairs
	
	private HashMap<String, String> itemInfoHM;
	private String itemName = "";
	
	// Will store children of this Item in a tree
	
	private ArrayList<Item> children = new ArrayList<Item>();
	
	public String getItemName() { return itemName; }

	public void setItemName(String itemName) { this.itemName = itemName; }

	public Item(String itemName) {
		super();
		
		setItemName(itemName);
		
		// Create Item HashMap that stores Item info
		
		itemInfoHM = new HashMap<String, String>(20);
	}
	
	// Used to add children nodes
	
	public void add(Item childNode) { children.add(childNode); }
	
	public void addItemInformation(String infoName, String info){
		
		itemInfoHM.put(infoName, info);
		
	}

	public String getItemInformation(String infoName){
		
		return itemInfoHM.get(infoName);
		
	}
	
	public String toString() {
		
		String itemInformation = "\n" + itemName + " ";
		
		// If Item info is available get it
		
		if (!itemInfoHM.isEmpty()){
			
			itemInformation += displayProductInfo();
			
		}
		
		Iterator<Item> it = children.iterator();
		
		// Attach all children for this Item
		
		while (it.hasNext()) {
			
			Item node = (Item)it.next();
			itemInformation += node.toString();
			
		}
		
		return itemInformation;
		
	}

	public String displayProductInfo() {
		
		String productInfo = "";
		
		// Cycle through every key, value pair and return them
		// entrySet() returns a Set that contains the Map entries
		
		for (Map.Entry<String, String> entry : itemInfoHM.entrySet()) {
		    
			productInfo += entry.getKey() + ": " + entry.getValue() + " ";
			
		}
		
		return productInfo;
		
	}
	
	public static void main(String[] args){
		
		// Create an Item that stores all others, or the Root
		
		ItemBuilder products = new ItemBuilder("Products");
		
		// Add children and their info
		
		products.addChild("Produce");
		products.addChild("Orange");
		products.addItemInformation("Price", "$1.00");
		products.addItemInformation("In Stock", "100");
		
		// Add siblings
		
		products.addSibling("Apple");
		products.addSibling("Grapes");
		
		// Change the current Item to the Root of the tree
		
		products.editThisItem("Products");
		
		products.addChild("Cereal");
		products.addChild("Special K");
		products.addItemInformation("Price", "$3.68");
		products.addSibling("Raisin Bran");
		products.addItemInformation("Price", "$3.78");
		
		products.editThisItem("Apple");
		
		products.addItemInformation("Price", "$.25");
		
		products.addSibling("Peach");
		
		products.editThisItem("Cereal");
		
		products.addChild("Fiber One");
		products.addItemInformation("Price", "$4.00");

		products.displayAllItems();
		
		// Print information on just the Cereal Item and its children
		
		System.out.println("\n" + products.getItemByName("Cereal"));
		
	}
		
}

class ItemBuilder {
	
	// Holds all of the Items created
	
	ArrayList<Item> items = new ArrayList<Item>();
	
	// Stores the root and parent Item objects for the
	// current Item you are working with so you can
	// add siblings and children based on location in
	// the tree structure
	
	private Item root;
	private Item current;
	private Item parent;
	
	public ItemBuilder(String rootName) {
		
		root = new Item(rootName);
		
		addItemToArrayList(root);
		
		current = root;
		parent = root;
		
		// Store the parent for the Item object
		
		root.addItemInformation("Parent", parent.getItemName());
		
	}
	
	// Allows me to store Item information
	
	public void addItemInformation(String name, String value) {
		
		current.addItemInformation(name, value);
		
	}
	
	// Adds a Child Item to the current parent Item
	
	public void addChild(String child) {
		
		Item childNode = new Item(child);
		
		addItemToArrayList(childNode);
		
		current.add(childNode);
		parent = current;
		current = childNode;
		
		// Store the parent for the Item object
		
		childNode.addItemInformation("Parent", parent.getItemName());
		
	}
	
	// Adds a sibling Item to the current Item stored in current
	
	public void addSibling(String sibling) {
		
		Item siblingNode = new Item(sibling); 
		
		addItemToArrayList(siblingNode);
		
		// Adding a child node to the parent Item
		
		parent.add(siblingNode);
		current = siblingNode;
		
		// Store the parent for the Item object
		
		siblingNode.addItemInformation("Parent", parent.getItemName());
		
	}
	
	// Adds Item objects to ArrayList
	
	public void addItemToArrayList(Item newItem){
		
		items.add(newItem);
		
	}
	
	public String toString() {
		return root.toString();
		
	}
	
	public void displayAllItems(){
		
		for(Item item : items){
			
			System.out.println(item.getItemName() + ": " + item.displayProductInfo());
			
		}
		
	}
	
	// Changes the Current Item object that is being used
	
	public void editThisItem(String itemName){
		
		for(Item item : items){
			
			if(item.getItemName().equals(itemName)){
				
				current =  item;
				
				// Gets the name of the stored parent object
				// and passes it so that parent can be set
				// as the parent in the ItemBuilder
				
				setItemsParent(current.getItemInformation("Parent"));
				
			}
			
		}
		
	}
	
	// Sets the Parent Item for ItemBuilder
	
	public void setItemsParent(String parentItem){
		
		for(Item item : items){
			
			if(item.getItemName().equals(parentItem)){
				
				parent =  item;
				
			}
			
		}
		
	}
	
	// Returns the Item based on the name passed into the method
	
	public Item getItemByName(String itemToGet){
		
		Item itemToReturn = null;
		
		for(Item item : items){
			
			if(item.getItemName().equals(itemToGet)){
				
				itemToReturn =  item;
				
			}
			
		}
		
		return itemToReturn;
		
	}
	
}