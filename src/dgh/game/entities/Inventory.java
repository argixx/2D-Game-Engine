package dgh.game.entities;

import java.util.LinkedList;

import dgh.game.gfx.Screen;
import dgh.game.items.Item;

public class Inventory {

	public LinkedList<Item> itemList = new LinkedList<Item>();
	private int max;
	private boolean isFull = false;
	private boolean isEmpty = false;
	
	public Inventory(int max) {
		this.max = max;
	}
	
	public void add(Item item) {
		if(!isFull) {
			itemList.add(item);
		}
	}
	
	public void remove(Item item) {
		if(item != null) {
			itemList.remove(itemList.indexOf(item));
		}
	}
	
	public boolean isFull() {
		return isFull;
	}
	
	public boolean isEmpty() {
		return isEmpty;
	}
	
	public void render(Screen screen) {
		
	}
	
	public void tick() {
		if(itemList.size() == max) {
			isFull = true;
		} else {
			isFull = false;
		}
		
		if(itemList.size() == 0) {
			isEmpty = true;
		} else {
			isEmpty = false;
		}
	}
	
	public int getIndexOfItem(Item item) {
		return itemList.indexOf(item);
	}
	
	public void getItem(int index) {
		itemList.get(index);
	}
}
