package dgh.game.items;

import dgh.game.Game;

public class ItemShield extends Item {

	public ItemShield(String name, int xSprite, int ySprite, int color) {
		super(name, xSprite, ySprite, color);
	}
	
	public void use() {
		Game.player.shieldSlot.equip(this);
	}
}
