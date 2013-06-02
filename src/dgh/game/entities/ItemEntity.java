package dgh.game.entities;

import java.awt.Rectangle;

import dgh.game.Game;
import dgh.game.gfx.Screen;
import dgh.game.items.Item;
import dgh.game.level.Level;

public class ItemEntity extends Entity {
	
	protected String name;
	protected int x, y;
	protected Item item;
	protected int scale = 1;
	public boolean isPickedUp = false;

	public ItemEntity(Level level, Item item, int x, int y) {
		super(level);
		this.item = item;
		this.x = x;
		this.y = y;
	}

	public void tick() {
		if(touchesPlayer(Game.player, level)) {
			if(!isPickedUp) {
				Game.player.inventory.add(item);
				Game.player.inventory.remove(item);
			}
			isPickedUp = true;
		}
	}

	public void render(Screen screen) {
		if(!isPickedUp) {
			screen.render(x << 3, y << 3, item.xSprite() + item.ySprite() * 32, item.color(), 0x00, 1);
		}
	}

	@Override
	public boolean touchesPlayer(Player player, Level level) {
		for(int xx = 0; xx < 8; xx++) {
			for(int yy = 0; yy < 8; yy++) {
				if((x*8) + xx == Game.player.x && (y*8) + yy == Game.player.y) {
					return true;
				}
			}
		}
		return false;
	}
}
