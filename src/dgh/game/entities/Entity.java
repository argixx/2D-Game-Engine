package dgh.game.entities;

import dgh.game.gfx.Screen;
import dgh.game.level.Level;

public abstract class Entity {
	
	public int x, y;
	protected Level level;

	public Entity(Level level) {
		init(level);
	}

	public final void init(Level level) {
		this.level = level;
	}

	public abstract void tick();

	public abstract void render(Screen screen);
	
	public abstract boolean touchesPlayer(Player player, Level level);
	
	public abstract boolean touchesEntity(Entity entity, Level level);
}
