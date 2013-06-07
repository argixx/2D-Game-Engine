package dgh.game.spells;

import dgh.game.Game;
import dgh.game.entities.Entity;
import dgh.game.entities.EntityFireBall;
import dgh.game.gfx.Screen;
import dgh.game.level.Level;

public class SpellFireball extends Spell{

	private Entity FireBall = new EntityFireBall(Game.level, "FireBall", Game.player.x, Game.player.y);
	
	public SpellFireball() {
		
	}
	
	public void activate(Level level) {
		Game.level.addEntity(FireBall);
		FireBall.tick();
		FireBall.render(Game.screen);
	}

	public void render(Screen screen) {
	
	}

	public void tick() {
		
	}

}
