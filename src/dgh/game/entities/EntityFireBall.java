package dgh.game.entities;

import dgh.game.Game;
import dgh.game.gfx.Colors;
import dgh.game.gfx.Screen;
import dgh.game.level.Level;

public class EntityFireBall extends Mob {

	private int colour = Colors.get(-1, 500, 000, 000);
	

	public EntityFireBall(Level level, String name, int x, int y) {
		super(level, "Fireball", x, y, 1);
	}

	@Override
	public void tick() {
		int xa = 0;
		int ya = 0;
		switch(this.movingDir) {
			case 0: 
				ya--;
			break;
			
			case 1:
				ya++;
			break;
				
			case 2:
				xa--;
			break;
			
			case 3: 
				xa++;
			break;
		}
		
		move(xa, ya);
	}
	@Override
	public void render(Screen screen) {
		this.movingDir = Game.player.movingDir;
		int xTile = 0;
        int yTile = 28;
        int walkingSpeed = 4;
        int flipTop = (numSteps >> walkingSpeed) & 1;
        int flipBottom = (numSteps >> walkingSpeed) & 1;

        if (movingDir == 1) {
            xTile += 2;
        } else if (movingDir > 1) {
            xTile += 4 + ((numSteps >> walkingSpeed) & 1) * 2;
            flipTop = (movingDir - 1) % 2;
        }

        int modifier = 8 * scale;
        int xOffset = x - modifier / 2;
        int yOffset = y - modifier / 2 - 4;
        
         
        screen.render(xOffset + (modifier * flipTop), yOffset, xTile + yTile * 32, colour, flipTop, scale);
        screen.render(xOffset + modifier - (modifier * flipTop), yOffset, (xTile + 1) + yTile * 32, colour, flipTop, scale);
        screen.render(xOffset + (modifier * flipBottom), yOffset + modifier, xTile + (yTile + 1) * 32, colour, flipBottom, scale);
        screen.render(xOffset + modifier - (modifier * flipBottom), yOffset + modifier, (xTile + 1) + (yTile + 1) * 32, colour, flipBottom, scale);

        
	}

	@Override
	public boolean touchesPlayer(Player player, Level level) {
		return false;
	}

	@Override
	public boolean touchesEntity(Entity entity, Level level) {
		return false;
	}

	@Override
	public boolean hasCollided(int xa, int ya) {
		return false;
	}

}
