package dgh.game.items;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import dgh.game.Game;
import dgh.game.entities.Entity;
import dgh.game.entities.Mob;
import dgh.game.entities.Player;
import dgh.game.gfx.Colors;
import dgh.game.gfx.Font;
import dgh.game.gfx.Screen;
import dgh.game.level.Level;

public class Item {
	
	protected int xSprite, ySprite;
	protected String name;
	protected int color;
	
	public static int bronzeColor = Colors.get(-1, 000, 430, -1);
	public static int ironColor = Colors.get(-1, 000, 111, -1);
	
	protected int strength = 0;
	protected int intelligence = 0;
	protected int agility = 0;
	protected int endurance = 0;
	
	public static final Item BronzeSword = new ItemBronzeSword("Bronze Sword", 0, 2, bronzeColor);
	public static final Item BronzeAxe = new ItemBronzeAxe("Bronze Axe", 0, 3, bronzeColor);
	public static final Item BronzeArmor = new ItemBronzeArmor("Bronze Armor", 8, 27, bronzeColor);
	public static final Item BronzeShield = new ItemBronzeShield("Bronze Shield", 7, 27, bronzeColor);
	
	public static final Item IronSword = new ItemIronSword("Iron Sword", 0, 2, ironColor);
	public static final Item IronAxe = new ItemBronzeAxe("Iron Axe", 0, 3, ironColor);
	public static final Item IronArmor = new ItemBronzeArmor("Iron Armor", 8, 27, ironColor);
	public static final Item IronShield = new ItemBronzeShield("Iron Shield", 7, 27, ironColor);

	public Item(String name, int xSprite, int ySprite, int color) {
		this.xSprite = xSprite;
		this.ySprite = ySprite;
		this.color = color;
		this.name = name;
	}
	
	public void renderToolTip(Screen screen) {
		int numRenders = 0;
		int startX = screen.xOffset + 165;
		int startY = screen.yOffset + 10;
		
		Font.render(name, screen, startX, startY, Colors.get(-1, -1, -1, 555), 1);
		if(strength != 0) {
			numRenders++;
			Font.render("Strength:" + strength, screen, startX, startY + 25*numRenders, Colors.get(-1, -1, -1, 555), 1);
		}
		if(endurance != 0) {
			numRenders++;
			Font.render("Endurance:" + endurance, screen, startX, startY + 25*numRenders, Colors.get(-1, -1, -1, 555), 1);
		}
		if(agility != 0) {
			numRenders++;
			Font.render("Agility:" + agility, screen, startX, startY + 25*numRenders, Colors.get(-1, -1, -1, 555), 1);
		}
		if(intelligence != 0) {
			numRenders++;
			Font.render("Intell:" + intelligence, screen, startX, startY + 25*numRenders, Colors.get(-1, -1, -1, 555), 1);
		}
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
	
	public void use() {
		
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
