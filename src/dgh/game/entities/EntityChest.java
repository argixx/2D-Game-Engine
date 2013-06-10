package dgh.game.entities;

import dgh.game.gfx.Colors;
import dgh.game.gfx.Screen;
import dgh.game.level.Level;
import dgh.game.level.tiles.Tile;

public class EntityChest extends Mob {

	public EntityChest(Level level, String name, int x, int y, int speed) {
		super(level, name, x, y, speed);
	}

	@Override
	public boolean hasCollided(int xa, int ya) {
		return false;
	}

	@Override
	public void tick() {
				
	}

	@Override
	public void render(Screen screen) {
		int yT = 15;
		int xT = 0;
		
		screen.render(x, y, xT + yT * 32, Colors.get(-1, 000, 210, -1), 0x00, 1);
		screen.render(x + 8, y, (xT + 1) + yT * 32, Colors.get(-1, 000, 210, -1), 0x00, 1);
		screen.render(x, y + 8, xT + (yT + 1) * 32, Colors.get(-1, 000, 210, -1), 0x00, 1);
		screen.render(x + 8, y + 8, (xT + 1) + (yT + 1) * 32, Colors.get(-1, 000, 210, -1), 0x00, 1);
	}

	@Override
	public boolean touchesPlayer(Player player, Level level) {
		return false;
	}

	@Override
	public boolean touchesEntity(Entity entity, Level level) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
