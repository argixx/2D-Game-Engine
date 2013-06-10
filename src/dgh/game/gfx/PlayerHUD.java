package dgh.game.gfx;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import dgh.game.Game;
import dgh.game.items.Item;
import dgh.game.level.Level;

public class PlayerHUD {
	
	public boolean showInventory = false;
	public boolean showEquip = false;

	public PlayerHUD() {
	}
	
	public void render(Screen screen) {
		if (showInventory) {
			for(int i = 0; i < 10; i++) {
				for(int j = 0; j < 3; j++) {
					screen.render(screen.xOffset + 25 + (i * 12), screen.yOffset + 10 + (j * 12), 30 + 0 * 32, Colors.get(-1, 111, 222, -1), 0x00, 1);
					screen.render(screen.xOffset + 33 + (i * 12), screen.yOffset + 10 + (j * 12), 31 + 0 * 32, Colors.get(-1, 111, 222, -1), 0x00, 1);
					screen.render(screen.xOffset + 25 + (i * 12), screen.yOffset + 18 + (j * 12), 30 + 1 * 32, Colors.get(-1, 111, 222, -1), 0x00, 1);
					screen.render(screen.xOffset + 33 + (i * 12), screen.yOffset + 18 + (j * 12), 31 + 1 * 32, Colors.get(-1, 111, 222, -1), 0x00, 1);
					Font.render("Inventory", screen, screen.xOffset + 28, screen.yOffset + 0, Colors.get(-1, -1, -1, 555), 1);
				}
			}
			
			screen.render(screen.xOffset + 25 + (Game.player.inventory.inventoryX * 12), screen.yOffset + 10 + (Game.player.inventory.inventoryY * 12), 30 + 0 * 32, Colors.get(-1, 555, 222, -1), 0x00, 1);
			screen.render(screen.xOffset + 33 + (Game.player.inventory.inventoryX * 12), screen.yOffset + 10 + (Game.player.inventory.inventoryY * 12), 31 + 0 * 32, Colors.get(-1, 555, 222, -1), 0x00, 1);
			screen.render(screen.xOffset + 25 + (Game.player.inventory.inventoryX * 12), screen.yOffset + 18 + (Game.player.inventory.inventoryY * 12), 30 + 1 * 32, Colors.get(-1, 555, 222, -1), 0x00, 1);
			screen.render(screen.xOffset + 33 + (Game.player.inventory.inventoryX * 12), screen.yOffset + 18 + (Game.player.inventory.inventoryY * 12), 31 + 1 * 32, Colors.get(-1, 555, 222, -1), 0x00, 1);
			
			int itemX = 0;
			int itemY = 0;
			int itemCount = 0;
			
			for(Item item : Game.player.inventory.itemList) {
				itemCount++;
				screen.render(screen.xOffset + 30 + (itemX * 12), screen.yOffset + 12 + (itemY * 12), item.xSprite() + item.ySprite() * 32, item.color(), 0x00, 1);
				itemX++;
				if(itemCount == 10 || itemCount == 20 || itemCount == 30) {
					itemY++;
					itemX = 0;
				}
			}
			
			if(Game.player.inventory.itemList.size() != 0) {
				for(Item item : Game.player.inventory.itemList) {
					if(Game.player.inventory.itemList.indexOf(item) == Game.player.inventory.selectedItem) {
						item.renderToolTip(screen);
					}
				}
			}
		}
		
		if(showEquip) {
			
		}
	}
	
	public void tick() {
		
	}
}
