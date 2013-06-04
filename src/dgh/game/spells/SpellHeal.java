package dgh.game.spells;

import dgh.game.Game;
import dgh.game.gfx.Screen;
import dgh.game.level.Level;

public class SpellHeal extends Spell {

	public SpellHeal() {
		power = 50;
		intelligenceRatio = .4;
	}

	public void activate(Level level) {
		if(Game.player.hp != Game.player.maxhp) {
			Game.player.hp += power += finalIntelligence;
		}
	}
	
	public void render(Screen screen) {
	
	}

	public void tick() {

	}

}