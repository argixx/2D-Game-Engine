package dgh.game.gfx;

import java.awt.Graphics;

import dgh.game.Game;
import dgh.game.entities.Player;
import dgh.game.items.Item;
import dgh.game.level.tiles.Tile;

public class PlayerHUD {
	
	private Gui InventoryGui = new Gui("res/Gui/PlayerInventory.png", 25, 25);
	private Gui EquipmentGui = new Gui("res/Gui/EquipmentGui.png", 25, 25);
	
	public boolean showInventory = false;
	public boolean showEquip = false;

	public PlayerHUD() {
		
	}
	
	public void render(Graphics g, Screen screen) {
		if (showInventory) {
			InventoryGui.render(g);
			for(Item item: Game.player.inventory.itemList) {
				item.renderInInventory(screen, 115, 115);
			}
		}
		
		if(showEquip) {
			EquipmentGui.render(g);
		}
	}
	
	public void tick() {
		
	}
}
