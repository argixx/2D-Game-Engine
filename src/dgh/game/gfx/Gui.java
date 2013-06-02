package dgh.game.gfx;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Gui {
	
	private String filePath;
	private int renderX, renderY;
	private BufferedImage gui;

	public Gui(String filePath, int renderX, int renderY) {
		this.filePath = filePath;
		this.renderX = renderX;
		this.renderY = renderY;
		try {
			gui = ImageIO.read(new File(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void render(Graphics g) {
		g.drawImage(gui, renderX, renderY, null);
	}
	
	public void tick() {
		
	}
}
