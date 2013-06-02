package dgh.game.items;

import dgh.game.gfx.Colors;
import dgh.game.gfx.Screen;

public class ItemTool extends Item {
	
	public ItemTool(String name, int xSprite, int ySprite, int color) {
		super(name, xSprite, ySprite, color);
		this.name = name;
		this.xSprite = xSprite;
		this.ySprite = ySprite;
		this.color = color;
	}
	
	public int xSprite() {
		return xSprite;
	}
	
	public int ySprite() {
		return ySprite;
	}
	
	public int color() {
		return color;
	}
	
	public void render(Screen screen, int xPos, int yPos) {
		screen.render(xPos << 3, yPos << 3, this.xSprite + this.ySprite * 32, this.color, 0x00, 1);
	}

	public void tick() {

	}
}
