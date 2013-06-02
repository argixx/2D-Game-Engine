package dgh.game.entities;


import java.awt.Graphics;

import dgh.game.Game;
import dgh.game.InputHandler;
import dgh.game.gfx.Colors;
import dgh.game.gfx.Font;
import dgh.game.gfx.Screen;
import dgh.game.level.Level;
import dgh.game.level.tiles.Tile;
import dgh.game.net.packets.Packet02Move;

public class Player extends Mob {

    private InputHandler input;
    private int colour = Colors.get(-1, 111, 145, 543);
    private int scale = 1;
    protected boolean isSwimming = false;
    private int tickCount = 0;
    private String username;
    public Inventory inventory;
    public int hp = 100;
    private Graphics g = null;
    private int floorDepth = 1;

    public Player(Level level, int x, int y, InputHandler input, String username) {
        super(level, "Player", x, y, 1);
        this.input = input;
        this.username = username;
        inventory = new Inventory(30);
    }
    
    public int getDepth() {
    	return floorDepth;
    }

    public void tick() {
        int xa = 0;
        int ya = 0;
        
        //System.out.println("Health Points: " + hp);
        
        Tile curTile = level.getTile(this.x >> 3, this.y >> 3);
        if (input != null) {
            if (input.up.isPressed()) {
                ya--;
            }
            if (input.down.isPressed()) {
                ya++;
            }
            if (input.left.isPressed()) {
                xa--;
            }
            if (input.right.isPressed()) {
                xa++;
            }
            if(input.space.isPressed()) {
            	
            }
            if(input.i.isPressed()) {
            	Game.playerHud.showInventory = true;
            	Game.playerHud.showEquip = false;
            }
            if(input.c.isPressed()) {
            	Game.playerHud.showEquip = true;
            	Game.playerHud.showInventory = false;
            }
            if(input.esc.isPressed()) {
            	Game.playerHud.showEquip = false;
            	Game.playerHud.showInventory = false;
            }
        }
        
        
        if (xa != 0 || ya != 0) {
            move(xa, ya);
            isMoving = true;

            Packet02Move packet = new Packet02Move(this.getUsername(), this.x, this.y, this.numSteps, this.isMoving,
                    this.movingDir);
            packet.writeData(Game.game.socketClient);
        } else {
            isMoving = false;
        }
        if (level.getTile(this.x >> 3, this.y >> 3).getId() == 3) {
            isSwimming = true;
        }
        if (isSwimming && level.getTile(this.x >> 3, this.y >> 3).getId() != 3) {
            isSwimming = false;
        }
        
        for(Entity e :level.getEntities()) {
        	if(e instanceof ItemEntity) {
        		if(e.touchesPlayer(this, level)) {
        			if(!((ItemEntity) e).isPickedUp) {
        				inventory.add(((ItemEntity) e).item);
        			}
        		}
        	}
        }
        
        tickCount++;
    }

    public void render(Screen screen) {
        int xTile = 0;
        int yTile = 28;
        int armorXTile = 8;
        int walkingSpeed = 4;
        int flipTop = (numSteps >> walkingSpeed) & 1;
        int flipBottom = (numSteps >> walkingSpeed) & 1;

        if (movingDir == 1) {
            xTile += 2;
            armorXTile += 2;
        } else if (movingDir > 1) {
            xTile += 4 + ((numSteps >> walkingSpeed) & 1) * 2;
            armorXTile += 4 + ((numSteps >> walkingSpeed) & 1) * 2;
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
        //armor
        screen.render(xOffset + (modifier * flipTop), yOffset, armorXTile + yTile * 32, colour, flipTop, scale);
        screen.render(xOffset + modifier - (modifier * flipTop), yOffset, (armorXTile + 1) + yTile * 32, colour, flipTop,
                scale);

        if (!isSwimming) {
            screen.render(xOffset + (modifier * flipBottom), yOffset + modifier, xTile + (yTile + 1) * 32, colour,
                    flipBottom, scale);
            screen.render(xOffset + modifier - (modifier * flipBottom), yOffset + modifier, (xTile + 1) + (yTile + 1)
                    * 32, colour, flipBottom, scale);
            //armor
            screen.render(xOffset + (modifier * flipBottom), yOffset + modifier, armorXTile + (yTile + 1) * 32, colour,
                    flipBottom, scale);
            screen.render(xOffset + modifier - (modifier * flipBottom), yOffset + modifier, (armorXTile + 1) + (yTile + 1)
                    * 32, colour, flipBottom, scale);
        }
        if (username != null) {
            Font.render(username, screen, xOffset - ((username.length() - 1) / 2 * 8), yOffset - 10,
                    Colors.get(-1, -1, -1, 555), 1);
        }
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

    public String getUsername() {
        return this.username;
    }

	public boolean touchesPlayer(Player player, Level level) {
		return false;
	}
}
