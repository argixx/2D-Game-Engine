package dgh.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import dgh.game.level.tiles.Tile;

public class InputHandler implements KeyListener {

    public InputHandler(Game game) {
        game.addKeyListener(this);
    }

    public class Key {
        private int numTimesPressed = 0;
        private boolean pressed = false;

        public int getNumTimesPressed() {
            return numTimesPressed;
        }

        public boolean isPressed() {
            return pressed;
        }

        public void toggle(boolean isPressed) {
            pressed = isPressed;
            if (isPressed) numTimesPressed++;
        }
    }

    public Key up = new Key();
    public Key down = new Key();
    public Key left = new Key();
    public Key right = new Key();
    public Key space = new Key();
    public Key i = new Key();
    public Key c = new Key();
    public Key esc = new Key();
    public Key one = new Key();
    public Key two = new Key();
    public Key three = new Key();
    public Key four = new Key();
    public Key five = new Key();

    public void keyPressed(KeyEvent e) {
        toggleKey(e.getKeyCode(), true);
        
        if(e.getKeyCode() == KeyEvent.VK_I) {
        	Game.playerHud.showInventory = Game.playerHud.showInventory ? false:true;
        }
        if(e.getKeyCode() == KeyEvent.VK_E) {
        	if(!Game.playerHud.showInventory) {
        		if(Game.player.curTile.isActivateable()) {
            		Game.player.curTile.activate();
            	}
        	}
        }
        
        playerInventoryNavigation(e);
    }

    public void keyReleased(KeyEvent e) {
        toggleKey(e.getKeyCode(), false);
    }

    public void keyTyped(KeyEvent e) {
    }
    
    public void playerInventoryNavigation(KeyEvent e) {
    	if(Game.playerHud.showInventory) {
    		if(e.getKeyCode() == KeyEvent.VK_F) {
        		Game.player.inventory.itemList.get(Game.player.inventory.selectedItem).use();
        		Game.player.inventory.itemList.remove(Game.player.inventory.selectedItem);
        	}
        	
        	if(e.getKeyCode() == KeyEvent.VK_LEFT) {
        		if(Game.player.inventory.selectedItem == 0) {
        			Game.player.inventory.inventoryY = 2;
        			Game.player.inventory.inventoryX = 10;
        		}
        		if(Game.player.inventory.selectedItem == 10) {
        			Game.player.inventory.inventoryY = 0;
        			Game.player.inventory.inventoryX = 10;
        		}
        		if(Game.player.inventory.selectedItem == 20) {
        			Game.player.inventory.inventoryY = 1;
        			Game.player.inventory.inventoryX = 10;
        		}
        		
        		Game.player.inventory.inventoryX--;
        		if(Game.player.inventory.selectedItem == 0) {
        			Game.player.inventory.selectedItem = 29;
        		} else {
        			Game.player.inventory.selectedItem--;
        		}
        	}
        	
        	if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
        		if(Game.player.inventory.selectedItem == 9) {
        			Game.player.inventory.inventoryY = 1;
        			Game.player.inventory.inventoryX = -1;
        		}
        		if(Game.player.inventory.selectedItem == 19) {
        			Game.player.inventory.inventoryY = 2;
        			Game.player.inventory.inventoryX = -1;
        		}
        		if(Game.player.inventory.selectedItem == 29) {
        			Game.player.inventory.inventoryY = 0;
        			Game.player.inventory.inventoryX = -1;
        		}
        		
        		Game.player.inventory.inventoryX++;
        		if(Game.player.inventory.selectedItem == 29) {
        			Game.player.inventory.selectedItem = 0;
        		} else {
        			Game.player.inventory.selectedItem++;
        		}
        	}
    	}
    	
    }

    public void toggleKey(int keyCode, boolean isPressed) {
        if (keyCode == KeyEvent.VK_W) {
            up.toggle(isPressed);
        }
        if (keyCode == KeyEvent.VK_S) {
            down.toggle(isPressed);
        }
        if (keyCode == KeyEvent.VK_A) {
            left.toggle(isPressed);
        }
        if (keyCode == KeyEvent.VK_D) {
            right.toggle(isPressed);
        }
        if(keyCode == KeyEvent.VK_SPACE) {
        	space.toggle(isPressed);
        }
        if(keyCode == KeyEvent.VK_I) {
        	i.toggle(isPressed);
        }
        if(keyCode == KeyEvent.VK_C) {
        	c.toggle(isPressed);
        }
        if(keyCode == KeyEvent.VK_ESCAPE) {
        	esc.toggle(isPressed);
        }
        if(keyCode == KeyEvent.VK_1) {
        	one.toggle(isPressed);
        }
        if(keyCode == KeyEvent.VK_2) {
        	two.toggle(isPressed);
        }
        if(keyCode == KeyEvent.VK_3) {
        	three.toggle(isPressed);
        }
        if(keyCode == KeyEvent.VK_4) {
        	four.toggle(isPressed);
        }
        if(keyCode == KeyEvent.VK_5) {
        	five.toggle(isPressed);
        }
    }
}
