package dgh.game.level.tiles;

import dgh.game.gfx.Screen;
import dgh.game.level.Level;

public class ActivatedTile extends Tile {
	
	protected int tileId;
    protected int tileColour;

	public ActivatedTile(int id, int x, int y, int tileColour, int levelColour) {
		super(id, false, false, false, true, levelColour);
		this.activateable = true;
		this.tileId = x + y * 32;
        this.tileColour = tileColour;
	}

	public void tick() {
		
	}

	public void render(Screen screen, Level level, int x, int y) {
       screen.render(x, y, tileId, tileColour, 0x00, 1);
	}
	
	@Override
	public void activate() {
		
	}
}
