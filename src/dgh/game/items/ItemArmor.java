package dgh.game.items;

import dgh.game.Game;

public class ItemArmor extends Item {

	public ItemArmor(String name, int xSprite, int ySprite, int color) {
		super(name, xSprite, ySprite, color);
	}
	
	@Override
	public void use() {
		Game.player.armorSlot.equip(this);
	}

}
