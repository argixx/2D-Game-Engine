package dgh.game.items;
//asdf
import dgh.game.Game;

public class EquipmentSlot {
	
	private Item equipedItem;
	
	private int slotStrength;
	private int slotEndurance;
	private int slotAgility;
	private int slotIntelligence;

	public EquipmentSlot() {
		
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
		
		equipedItem = null;
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
