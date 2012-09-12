/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vision;

/**
 *
 * @author juanagva
 */
/*
 * Copyright (c) 2012 Aldebaran Robotics. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be
 * found in the COPYING file.
 */

import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.applet.Applet;
import java.awt.image.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.imageio.ImageIO.*;
import javax.imageio.*;
import java.awt.image.MemoryImageSource;
import java.awt.image.MemoryImageSource.*;
import java.awt.image.BufferedImage;
import java.awt.color.ColorSpace;
import java.awt.image.ColorModel;
import java.awt.image.ComponentColorModel;
import java.awt.image.DataBuffer;
import java.awt.image.Raster;
import java.util.Hashtable;
import java.awt.Color;

public class AwtImage extends Frame{
  BufferedImage img;
  public static void main(String[] args){
  }

    public BufferedImage getImg() {
        return img;
    }



  public AwtImage(byte[] buff)
  {
  	super("Image Frame");
	MediaTracker mt = new MediaTracker(this);
	int[] intArray;
	intArray = new int[320*240];

	for(int i = 0; i < 320*240; i++)
	{
		byte rValue = buff[i*3];
		byte gValue = buff[(i*3)+1];
		byte bValue = buff[(i*3)+2];

		intArray[i] = ((255 & 0xFF) << 24) | //alpha
            ((buff[i*3+0] & 0xFF) << 16) | //red
            ((buff[i*3+1] & 0xFF) << 8)  | //green
            ((buff[i*3+2] & 0xFF) << 0); //blue



	}



	MemoryImageSource mis;
	mis = new MemoryImageSource (320, 240, intArray, 0, 320);
	img = new BufferedImage(320, 240, BufferedImage.TYPE_INT_RGB);
	img.setRGB(0, 0, 320, 240, intArray, 0, 320);
	mt.addImage(img,0);
	setSize(320,240);
	setVisible(true);
	addWindowListener(new WindowAdapter(){
	public void windowClosing(WindowEvent we){
		  dispose();
	  }
	});
	}
  public void update(Graphics g){
  paint(g);
  }
  
  public void paint(Graphics g){
  if(img != null){
  g.drawImage(img, 0, 0, this);

  }
  else
 {
	System.out.println("null image");
 }
  }
}
