package dgh.game.spells;

import dgh.game.Game;
import dgh.game.gfx.Screen;
import dgh.game.level.Level;

public abstract class Spell {

	protected int xSprite, ySprite;
	protected String name;
	protected int color;
	protected int power = 0;

	protected double intelligenceRatio = 0;
	protected double intelligence = 0;
	protected double finalIntelligence = 0;
	
	public Spell() {
		
	}
	
	public abstract void activate(Level level);
	public abstract void render(Screen screen);
	public void tick() {
		finalIntelligence = Game.player.intelligence*intelligenceRatio;
	}
	
}