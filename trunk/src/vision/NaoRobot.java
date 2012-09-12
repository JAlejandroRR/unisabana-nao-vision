/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vision;

import com.aldebaran.proxy.ALTextToSpeechProxy;
import com.aldebaran.proxy.ALVideoDeviceProxy;
import com.aldebaran.proxy.Variant;
import com.aldebaran.proxy.*;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.image.*;

/**
 *
 * @author juanagva
 */
public class NaoRobot {

    static {
        System.loadLibrary("JNaoQi");
    }
    String ipAddress;

    public NaoRobot(String ip) {
        ipAddress = ip;
    }

    public AwtImage getImage() {
        ALVideoDeviceProxy video;
        video = new ALVideoDeviceProxy(ipAddress, 9559);
        // subscribe only once
        video.subscribe("java", 1, 11, 250);
        // get Image in Variant (also named ALValue)
        Variant ret = video.getImageRemote("java");
        // unsubscribe only once
        video.unsubscribe("java");
        // Video device documentation explain that image is element 6
        Variant imageV = ret.getElement(6);
        // display image from byte array
        AwtImage image;
        
        //InputStream is = con1.getInputStream();
        System.out.println(imageV.getType().toString());
        byte[] binaryImage = imageV.toBinary();       
        image = new AwtImage(binaryImage);
        image.setVisible(true);
        
        
        
      
        return image;

    }
    
    public ImageIcon getImageIcon() {
        ALVideoDeviceProxy video;
        video = new ALVideoDeviceProxy(ipAddress, 9559);
        // subscribe only once
        video.subscribe("java", 1, 11, 250);
        // get Image in Variant (also named ALValue)
        Variant ret = video.getImageRemote("java");
        // unsubscribe only once
        video.unsubscribe("java");
        // Video device documentation explain that image is element 6
        Variant imageV = ret.getElement(6);
        // display image from byte array
        ImageIcon image;
        //InputStream is = con1.getInputStream();
        System.out.println(imageV.getType().toString());
        byte[] binaryImage = imageV.toBinary();       
        
       
         image = new ImageIcon(binaryImage);
        
        
       
        return image;

    }

    public void speak(String words) {
        ALTextToSpeechProxy ttsProxy = new ALTextToSpeechProxy(ipAddress, 9559);
        // Talk
        ttsProxy.setLanguage("Spanish");
       
        ttsProxy.setVolume((float)1);
        ttsProxy.say(words);
        
    }
}
