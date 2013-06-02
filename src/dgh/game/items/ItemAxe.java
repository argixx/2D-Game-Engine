package dgh.game.items;

import dgh.game.gfx.Colors;

public class ItemAxe extends ItemTool {
	
	public ItemAxe(String name, int xSprite, int ySprite, int color) {
		super("Axe", xSprite, ySprite, color);
		xSprite = 0;
		ySprite = 3;
	}
}
