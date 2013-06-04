package dgh.game.gfx;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import dgh.game.Game;
import dgh.game.items.Item;

public class PlayerHUD {
	
	private Gui InventoryGui = new Gui("res/Gui/PlayerInventory.png", 25, 25);
	private Gui EquipmentGui = new Gui("res/Gui/EquipmentGui.png", 25, 25);
	
	public boolean showInventory = false;
	public boolean showEquip = false;

	public PlayerHUD() {
	}
	
	public void render(Graphics g, Screen screen) {
		if (showInventory) {
			
		}
		
		if(showEquip) {
			
		}
	}
	
	public void tick() {
		
	}
}
