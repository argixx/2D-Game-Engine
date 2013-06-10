package dgh.game.items;

public class ItemIronSword extends ItemSword {

	public ItemIronSword(String name, int xSprite, int ySprite, int color) {
		super(name, xSprite, ySprite, color);
		strength = 3;
		agility = 2;
	}
}
