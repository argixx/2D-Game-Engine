package dgh.game.level.tiles;

import java.util.Random;

import dgh.game.Game;
import dgh.game.entities.Inventory;
import dgh.game.gfx.Colors;
import dgh.game.gfx.Font;
import dgh.game.gfx.Screen;
import dgh.game.items.Item;
import dgh.game.items.ItemAxe;
import dgh.game.level.Level;

public class ActivatedChestTile extends ActivatedTile {
	
	private Random random = new Random();
	public boolean isShowingInventory;
	private Inventory inventory;
	
	public ActivatedChestTile(int id, int x, int y, int tileColour, int levelColour) {
		super(id, x, y, tileColour, levelColour);
		inventory = new Inventory(30);
		randomizeLoot();
	}

	public void tick() {
		
	}
	
	public void render(Screen screen, Level level, int x, int y) {
		screen.render(x, y, tileId, tileColour, 0x00, 1);
		if(isShowingInventory) {
			for(int i = 0; i < 10; i++) {
				for(int j = 0; j < 3; j++) {
					screen.render(screen.xOffset + 25 + (i * 12), screen.yOffset + 60 + (j * 12), 30 + 0 * 32, Colors.get(-1, 111, 222, -1), 0x00, 1);
					screen.render(screen.xOffset + 33 + (i * 12), screen.yOffset + 60 + (j * 12), 31 + 0 * 32, Colors.get(-1, 111, 222, -1), 0x00, 1);
					screen.render(screen.xOffset + 25 + (i * 12), screen.yOffset + 68 + (j * 12), 30 + 1 * 32, Colors.get(-1, 111, 222, -1), 0x00, 1);
					screen.render(screen.xOffset + 33 + (i * 12), screen.yOffset + 68 + (j * 12), 31 + 1 * 32, Colors.get(-1, 111, 222, -1), 0x00, 1);
					Font.render("Chest Inventory", screen, 28, 80, Colors.get(-1, -1, -1, 555), 1);
				}
			}
			
			int itemCount = 0;
			int itemX = 0;
			int itemY = 0;
			
			for(Item item : inventory.itemList) {
				itemCount++;
				screen.render(screen.xOffset + 30 + (itemX * 12), screen.yOffset + 62 + (itemY * 12), item.xSprite() + item.ySprite() * 32, item.color(), 0x00, 1);
				itemX++;
				if(itemCount == 10 || itemCount == 20 || itemCount == 30) {
					itemY++;
					itemX = 0;
				}
			}
		}
	}
	
	@Override
	public void activate() {
		isShowingInventory = isShowingInventory ? false:true;
	}
	
	public void randomizeLoot() {
		for(int j = 0; j < 25; j++) {
			inventory.add(new ItemAxe("Axe", 0, 3, Colors.get(-1, 234, 432, -1)));
		}
	}
}
