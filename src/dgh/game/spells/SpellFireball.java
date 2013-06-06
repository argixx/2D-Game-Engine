package dgh.game.spells;

import dgh.game.Game;
import dgh.game.entities.EntityFireBall;
import dgh.game.gfx.Screen;
import dgh.game.level.Level;

public class SpellFireball extends Spell{

	public SpellFireball() {
		
	}
	
	public void activate(Level level) {
		level.addEntity(new EntityFireBall(level, "FireBall", Game.player.x, Game.player.y));
	}

	public void render(Screen screen) {
	
	}

	public void tick() {
		
	}

}
