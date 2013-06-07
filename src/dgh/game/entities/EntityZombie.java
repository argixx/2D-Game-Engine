package dgh.game.entities;

import java.util.Random;

import dgh.game.Game;
import dgh.game.gfx.Colors;
import dgh.game.gfx.Screen;
import dgh.game.level.Level;
import dgh.game.level.tiles.Tile;

public class EntityZombie extends Mob {

	private Random random = new Random();
	private int colour = Colors.get(-1, 111, 145, 050);
    private int scale = 1;
    protected boolean isSwimming = false;
    private int tickCount = 0;
    private int aggroRange;
    private int attackTimer = 20;
    private int randomWalkTimer = random.nextInt(240);
    private int damage = 5;
    public int hp = 5;
    private double xy;
    private int rand2;
    private boolean dead = false;

    public EntityZombie(Level level, int x, int y, int aggroRadius) {
        super(level, "Zombie", x, y, 1);
        this.aggroRange = aggroRadius;
    }

    public void tick() {
    	if(!dead) {
	        int xa = 0;
	        int ya = 0;
	        tickTime++;
	        
	        Tile curTile = level.getTile(this.x >> 3, this.y >> 3);
	        if(isInAggroRange(Game.player)) {
	        	if(Game.player.x > x) {
	            	xa++;
	            } else if (Game.player.x < x){
	            	xa--;
	            }
	            
	            if(Game.player.y > y) {
	            	ya++;
	            } else if (Game.player.y < y){
	            	ya--;
	            }
	        }
	        
	        if(!isInAggroRange(Game.player)) {
	        	if(randomWalkTimer > 0 && randomWalkTimer < 60) {
	            	
	            	if(rand2 <= 3) {
	            		xa++;
	            	}
	            	if(rand2 <= 6 && rand2 >= 3) {
	            		ya++;
	            	}
	            	if(rand2 <= 9 && rand2 >= 6) {
	            		xa--;
	            	}
	            	if(rand2 <= 12 && rand2 >= 9) {
	            		ya--;
	            	}
	            }
	        }
	        
	        if(randomWalkTimer > 0) {
	        	randomWalkTimer--;
	        	
	        }
	        
	        if(randomWalkTimer == 0) {
	        	randomWalkTimer = 240;
	        	rand2 = random.nextInt(12);
	        }
	        
	        
	        if(touchesPlayer(Game.player, level)) {
	        	if(attackTimer == 0) {
	        		Game.player.hp-= damage;
	        		attackTimer = 60;
	        	}
	        	
	        	if(attackTimer > 0) {
	        		attackTimer--;
	        	}
	        }
	        
	        int zSpeed = tickTime & 1;
	        if (xa != 0 || ya != 0) {
	            move(xa * zSpeed, ya * zSpeed);
	            isMoving = true;
	        } else {
	        	isMoving = false;
	        }
	        
	        if (level.getTile(this.x >> 3, this.y >> 3).getId() == 3) {
	            isSwimming = true;
	        }
	        if (isSwimming && level.getTile(this.x >> 3, this.y >> 3).getId() != 3) {
	            isSwimming = false;
	        }
	        
	        if(hp <= 0) {
	        	dead = true;
	        }
	        
	        tickCount++;
	    }
    }

    public void render(Screen screen) {
    	if(!dead){
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
	        if (isSwimming) {
	            int waterColour = 0;
	            yOffset += 4;
	            if (tickCount % 60 < 15) {
	                waterColour = Colors.get(-1, -1, 225, -1);
	            } else if (15 <= tickCount % 60 && tickCount % 60 < 30) {
	                yOffset -= 1;
	                waterColour = Colors.get(-1, 225, 115, -1);
	            } else if (30 <= tickCount % 60 && tickCount % 60 < 45) {
	                waterColour = Colors.get(-1, 115, -1, 225);
	            } else {
	                yOffset -= 1;
	                waterColour = Colors.get(-1, 225, 115, -1);
	            }
	            screen.render(xOffset, yOffset + 3, 0 + 27 * 32, waterColour, 0x00, 1);
	            screen.render(xOffset + 8, yOffset + 3, 0 + 27 * 32, waterColour, 0x01, 1);
	        }
	        screen.render(xOffset + (modifier * flipTop), yOffset, xTile + yTile * 32, colour, flipTop, scale);
	        screen.render(xOffset + modifier - (modifier * flipTop), yOffset, (xTile + 1) + yTile * 32, colour, flipTop,
	                scale);
	
	        if (!isSwimming) {
	            screen.render(xOffset + (modifier * flipBottom), yOffset + modifier, xTile + (yTile + 1) * 32, colour,
	                    flipBottom, scale);
	            screen.render(xOffset + modifier - (modifier * flipBottom), yOffset + modifier, (xTile + 1) + (yTile + 1)
	                    * 32, colour, flipBottom, scale);
	        }
    	}
    }
    
    public boolean isInAggroRange(Player player) {
    	int xd = player.x - x;
    	int yd = player.y - y;
    	
    	xy = Math.sqrt(((player.x-x)*(player.x-x)) + ((player.y-y)*(player.y-y)));
    	
    	if(xy < aggroRange) {
    		return true;
    	}
    	
    	return false;
    }

    public boolean hasCollided(int xa, int ya) {
        int xMin = 0;
        int xMax = 7;
        int yMin = 3;
        int yMax = 7;
        for (int x = xMin; x < xMax; x++) {
            if (isSolidTile(xa, ya, x, yMin)) {
                return true;
            }
        }
        for (int x = xMin; x < xMax; x++) {
            if (isSolidTile(xa, ya, x, yMax)) {
                return true;
            }
        }
        for (int y = yMin; y < yMax; y++) {
            if (isSolidTile(xa, ya, xMin, y)) {
                return true;
            }
        }
        for (int y = yMin; y < yMax; y++) {
            if (isSolidTile(xa, ya, xMax, y)) {
                return true;
            }
        }
        return false;
    }
    
	public boolean touchesPlayer(Player player, Level level) {
		if(x + 8 == player.x + 8 && y + 8 == player.y + 8) {
			return true;
		}
		return false;
	}

	public boolean touchesEntity(Entity entity, Level level) {
		return false;
	}
}
