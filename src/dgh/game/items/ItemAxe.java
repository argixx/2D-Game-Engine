package dgh.game.items;

import dgh.game.Game;
import dgh.game.gfx.Colors;

public class ItemAxe extends ItemTool {
	
	public ItemAxe(String name, int xSprite, int ySprite, int color) {
		super(name, xSprite, ySprite, color);
		strength = 5;
		agility = 3;
		intelligence = 1;
		endurance = 3;
	}
	
	@Override
	public void use() {
		Game.player.weaponSlot.equip(this);
	}
}
