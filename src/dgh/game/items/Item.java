package dgh.game.items;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import dgh.game.Game;
import dgh.game.entities.Entity;
import dgh.game.entities.Mob;
import dgh.game.entities.Player;
import dgh.game.gfx.Screen;
import dgh.game.level.Level;

public class Item {
	
	protected int xSprite, ySprite;
	protected String name;
	protected int color;
	
	protected int strength = 0;
	protected int intelligence = 0;
	protected int agility = 0;
	protected int endurance = 0;

	public Item(String name, int xSprite, int ySprite, int color) {
		this.xSprite = xSprite;
		this.ySprite = ySprite;
		this.color = color;
		this.name = name;
	}
	
	public int xSprite() {
		return xSprite;
	}
	
	public int ySprite() {
		return ySprite;
	}
	
	public int color() {
		return color;
	}
	
	public void pickUp(Player player) {
		player.inventory.add(this);
	}
	
	public String getName() {
		return name;
	}
	
	public void tick() {
		
	}
	
	public int getStrength() {
		return strength;
	}
	
	public int getIntelligence() {
		return intelligence;
	}
	
	public int getEndurance() {
		return endurance;
	}
	
	public int getAgility() {
		return agility;
	}
}
