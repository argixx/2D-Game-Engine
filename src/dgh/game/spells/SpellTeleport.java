package dgh.game.spells;

import dgh.game.Game;
import dgh.game.entities.Player;
import dgh.game.gfx.Screen;
import dgh.game.level.Level;
import dgh.game.level.tiles.Tile;

public class SpellTeleport extends Spell {

	private int spellDirection;
	private int teleportRange = 5;
	
	public SpellTeleport() {
		
	}
	
	public void render(Screen screen) {
		
	}

	public void tick() {
		spellDirection = Game.player.getMovingDir();
	}
	
	public void activate(Level level) {
		if(spellDirection == 0) {
			if(level.getTile(Game.player.x, Game.player.y - teleportRange).getId() == Tile.FLOORTILE.getId()){
				Game.player.y -= teleportRange << 3;
			}
		}
		if(spellDirection == 1) {
			if(level.getTile(Game.player.x, Game.player.y + teleportRange).getId() == Tile.FLOORTILE.getId()){
				Game.player.y += teleportRange << 3;
			}
		}
		if(spellDirection == 2) {
			if(level.getTile(Game.player.x - teleportRange, Game.player.y).getId() == Tile.FLOORTILE.getId()){
				Game.player.x -= teleportRange << 5;
			}
		}
		if(spellDirection == 3) {
			if(level.getTile(Game.player.x + teleportRange, Game.player.y).getId() == Tile.FLOORTILE.getId()){
				Game.player.x += teleportRange << 5;
			}
		}
	}
}
