package com.moncept.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Items {

	private HashMap<String, String> itemInfoHM;
	private String itemName = "";

	private ArrayList<Items> children = new ArrayList<Items>();

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Items(String itemName) {

		super();
		setItemName(itemName);
		itemInfoHM = new HashMap<String, String>(20);

	}

	public void add(Items childNode) {

		children.add(childNode);

	}

	public void addItemInformation(String infoName, String info) {

		itemInfoHM.put(infoName, info);

	}

	public String getItemInformation(String infoName) {

		return itemInfoHM.get(infoName);

	}

	public String toString() {

		StringBuffer itemInfo = new StringBuffer();

		addItemInfoAndChildren(itemInfo);

		return itemInfo.toString();

	}

	private void addItemInfoAndChildren(StringBuffer itemInfo) {

		addItemInformation(itemInfo);

		addChildrenInformation(itemInfo);

	}

	private void addItemInformation(StringBuffer itemInfo) {

		itemInfo.append("\n" + itemName + " ");

		// If Item info is available get it

		if (!itemInfoHM.isEmpty()) {

			itemInfo.append(displayProductInfo());

		}

	}

	private void addChildrenInformation(StringBuffer itemInfo) {

		Iterator<Items> it = children.iterator();

		// Attach all children for this Item

		while (it.hasNext()) {

			Items node = (Items) it.next();
			itemInfo.append(node.toString());

		}

	}

	public String displayProductInfo() {

		String productInfo = "";

		for (Map.Entry<String, String> entry : itemInfoHM.entrySet()) {

			productInfo += entry.getKey() + ": " + entry.getValue() + " ";

		}

		return productInfo;

	}

	public static void main(String[] args) {

		ItemBuilders products = new ItemBuilders("Products");

		products.addChild("Produce");
		products.addChild("Orange");
		products.addItemInformation("Price", "$1.00");
		products.addItemInformation("Stock", "100");

		products.addSibling("Apple");
		products.addSibling("Grape");

		products.editThisItem("Products");
		products.addChild("Cereal");
		products.addChild("Special K");
		products.addItemInformation("Price", "$4.00");
		products.addSibling("Raisin Bran");
		products.addItemInformation("Price", "$4.00");
		products.addSibling("Fiber One");

		products.addItemInformation("Price", "$4.00");

		products.displayAllItems();

		System.out.println("\n" + products.getItemByName("Cereal"));

	}

}

class ItemBuilders {


	ArrayList<Items> items = new ArrayList<Items>();

	private Items root;
	private Items current;
	private Items parent;

	public ItemBuilders(String rootName) {

		root = new Items(rootName);

		addItemToArrayList(root);

		current = root;
		parent = root;

		root.addItemInformation("Parent", parent.getItemName());

	}

	public void addItemInformation(String name, String value) {

		current.addItemInformation(name, value);

	}

	public void addChild(String child) {

		Items childNode = new Items(child);

		addItemToArrayList(childNode);

		current.add(childNode);
		parent = current;
		current = childNode;

		childNode.addItemInformation("Parent", parent.getItemName());

	}

	public void addSibling(String sibling) {

		Items siblingNode = new Items(sibling);

		addItemToArrayList(siblingNode);

		parent.add(siblingNode);
		current = siblingNode;

		siblingNode.addItemInformation("Parent", parent.getItemName());

	}

	public void addItemToArrayList(Items childNode) {

		items.add(childNode);

	}

	public String toString() {

		return root.toString();

	}

	public void displayAllItems() {

		for (Items item : items) {

			System.out.println(item.getItemName() + ": " + item.displayProductInfo());

		}

	}

	public void editThisItem(String itemName) {

		for (Items item : items) {

			if (item.getItemName().equals(itemName)) {

				current = item;

				setItemsParent(current.getItemInformation("Parent"));

			}

		}

	}

	public void setItemsParent(String parentItem) {

		for (Items item : items) {

			if (item.getItemName().equals(parentItem)) {

				parent = item;

			}

		}

	}

	public Items getItemByName(String itemToGet) {

		Items itemToReturn = null;

		for (Items item : items) {

			if (item.getItemName().equals(itemToGet)) {

				itemToReturn = item;

			}

		}

		return itemToReturn;

	}

}