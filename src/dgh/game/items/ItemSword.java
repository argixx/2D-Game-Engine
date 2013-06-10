package dgh.game.items;

import dgh.game.Game;
import dgh.game.gfx.Colors;

public class ItemSword extends ItemTool {
	
	public ItemSword(String name, int xSprite, int ySprite, int color) {
		super(name, xSprite, ySprite, color);
	}
	
	@Override
	public void use() {
		Game.player.weaponSlot.equip(this);
	}
}