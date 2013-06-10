package dgh.game.items;

public class ItemBronzeSword extends ItemSword {

	public ItemBronzeSword(String name, int xSprite, int ySprite, int color) {
		super(name, xSprite, ySprite, color);
		strength = 2;
		agility = 1;
	}
}
