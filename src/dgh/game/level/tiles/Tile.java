package dgh.game.level.tiles;

import dgh.game.gfx.Colors;
import dgh.game.gfx.Screen;
import dgh.game.level.Level;

public abstract class Tile {

    public static final Tile[] tiles = new Tile[256];
    public static final Tile VOID = new BasicSolidTile(0, 0, 0, Colors.get(000, -1, -1, -1), 0xFF000000);
    public static final Tile FLOORTILE = new BasicTile(1, 1, 0, Colors.get(001, 003, 000, 134), 0xFFFFFFFF);
    public static final Tile WALLTILE = new BasicSolidTile(2, 2, 0, Colors.get(001, 003, 000, 023), 0xFF0000FF);
    public static final Tile WATER = new AnimatedTile(3, new int[][] { { 0, 5 }, { 1, 5 }, { 2, 5 }, { 1, 5 } },
            Colors.get(-1, 004, 115, -1), 0xFFFFFF00, 1000);
    
    protected byte id;
    protected boolean solid;
    protected boolean emitter;
    protected boolean item;
    private int levelColour;

    public Tile(int id, boolean isSolid, boolean isEmitter, boolean isItem, int levelColour) {
        this.id = (byte) id;
        if (tiles[id] != null)
            throw new RuntimeException("Duplicate tile id on " + id);
        this.solid = isSolid;
        this.emitter = isEmitter;
        this.item = isItem;
        this.levelColour = levelColour;
        tiles[id] = this;
    }

    public byte getId() {
        return id;
    }

    public boolean isSolid() {
        return solid;
    }

    public boolean isEmitter() {
        return emitter;
    }
    
    public boolean hasItem() {
    	return item;
    }
    
    public void setHasItem(boolean hasItem) {
    	this.item = hasItem;
    }

    public int getLevelColour() {
        return levelColour;
    }

    public abstract void tick();

    public abstract void render(Screen screen, Level level, int x, int y);
}
