package dgh.game.items;

import dgh.game.Game;
import dgh.game.gfx.Colors;
import dgh.game.gfx.Screen;

public class EquipmentSlot {
	
	private Item equipedItem;
	
	private int slotStrength = 0;
	private int slotEndurance = 0;
	private int slotAgility = 0;
	private int slotIntelligence = 0;
	
	private int xPos, yPos;

	public EquipmentSlot(int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
	}
	
	public void tick() {
		
	}
	
	public void render(Screen screen) {
		if(equipedItem != null) {
			screen.render(screen.xOffset + xPos, screen.yOffset + yPos, equipedItem.xSprite() + equipedItem.ySprite() * 32, equipedItem.color(), 0x00, 1);
		}
	}
	
	public void equip(Item item) {
		unequip(equipedItem);
		this.equipedItem = item;
		setStats();
	}
	
	public void unequip(Item item) {
		Game.player.endurance -= slotEndurance;
		Game.player.intelligence -= slotIntelligence;
		Game.player.agility -= slotAgility;
		Game.player.strength -= slotStrength;
		
		this.slotAgility = 0;
		this.slotEndurance = 0;
		this.slotIntelligence = 0;
		this.slotStrength = 0;
		
		if(equipedItem != null) {
			Game.player.inventory.add(equipedItem);
		}
		
		equipedItem = null;
	}
	
	public int getSlotStrength() {
		return slotStrength;
	}

	public void setSlotStrength(int slotStrength) {
		this.slotStrength = slotStrength;
	}

	public int getSlotEndurance() {
		return slotEndurance;
	}

	public void setSlotEndurance(int slotEndurance) {
		this.slotEndurance = slotEndurance;
	}

	public int getSlotAgility() {
		return slotAgility;
	}

	public void setSlotAgility(int slotAgility) {
		this.slotAgility = slotAgility;
	}

	public int getSlotIntelligence() {
		return slotIntelligence;
	}

	public void setSlotIntelligence(int slotIntelligence) {
		this.slotIntelligence = slotIntelligence;
	}

	public void setStats() {
		this.slotAgility = equipedItem.getAgility();
		this.slotEndurance = equipedItem.getEndurance();
		this.slotIntelligence = equipedItem.getIntelligence();
		this.slotStrength = equipedItem.getStrength();
		
		Game.player.endurance += slotEndurance;
		Game.player.intelligence += slotIntelligence;
		Game.player.agility += slotAgility;
		Game.player.strength += slotStrength;
	}
}
