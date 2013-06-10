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
	private int num;
	
	private int xPos, yPos;

	public EquipmentSlot(int num, int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.num = num;
	}
	
	public void tick() {
		
	}
	
	public void render(Screen screen) {
		if(Game.playerHud.showInventory) {
			switch(num) {
				case 1:
					screen.render(screen.xOffset + xPos, screen.yOffset + yPos, 0 + 8 * 32, Colors.get(-1, 111, 555, -1), 0x00, 1);
					screen.render(screen.xOffset + xPos + 8, screen.yOffset + yPos, 1 + 8 * 32, Colors.get(-1, 111, 555, -1), 0x00, 1);
					screen.render(screen.xOffset + xPos, screen.yOffset + yPos + 8, 0 + 9 * 32, Colors.get(-1, 111, 555, -1), 0x00, 1);
					screen.render(screen.xOffset + xPos + 8, screen.yOffset + yPos + 8, 1 + 9 * 32, Colors.get(-1, 111, 555, -1), 0x00, 1);
				break;
				
				case 2:
					screen.render(screen.xOffset + xPos, screen.yOffset + yPos, 2 + 8 * 32, Colors.get(-1, 111, 555, -1), 0x00, 1);
					screen.render(screen.xOffset + xPos + 8, screen.yOffset + yPos, 3 + 8 * 32, Colors.get(-1, 111, 555, -1), 0x00, 1);
					screen.render(screen.xOffset + xPos, screen.yOffset + yPos + 8, 2 + 9 * 32, Colors.get(-1, 111, 555, -1), 0x00, 1);
					screen.render(screen.xOffset + xPos + 8, screen.yOffset + yPos + 8, 3 + 9 * 32, Colors.get(-1, 111, 555, -1), 0x00, 1);
				break;
				
				case 3:
					screen.render(screen.xOffset + xPos, screen.yOffset + yPos, 0 + 12 * 32, Colors.get(-1, 111, 555, -1), 0x00, 1);
					screen.render(screen.xOffset + xPos + 8, screen.yOffset + yPos, 1 + 12 * 32, Colors.get(-1, 111, 555, -1), 0x00, 1);
					screen.render(screen.xOffset + xPos, screen.yOffset + yPos + 8, 0 + 13 * 32, Colors.get(-1, 111, 555, -1), 0x00, 1);
					screen.render(screen.xOffset + xPos + 8, screen.yOffset + yPos + 8, 1 + 13 * 32, Colors.get(-1, 111, 555, -1), 0x00, 1);
				break;
				
				case 4:
					screen.render(screen.xOffset + xPos, screen.yOffset + yPos, 2 + 12 * 32, Colors.get(-1, 111, 555, -1), 0x00, 1);
					screen.render(screen.xOffset + xPos + 8, screen.yOffset + yPos, 3 + 12 * 32, Colors.get(-1, 111, 555, -1), 0x00, 1);
					screen.render(screen.xOffset + xPos, screen.yOffset + yPos + 8, 2 + 13 * 32, Colors.get(-1, 111, 555, -1), 0x00, 1);
					screen.render(screen.xOffset + xPos + 8, screen.yOffset + yPos + 8, 3 + 13 * 32, Colors.get(-1, 111, 555, -1), 0x00, 1);
				break;
	
			}
			
			if(equipedItem != null) {
				screen.render(screen.xOffset + xPos + 4, screen.yOffset + yPos + 4, equipedItem.xSprite() + equipedItem.ySprite() * 32, equipedItem.color(), 0x00, 1);
			}
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
