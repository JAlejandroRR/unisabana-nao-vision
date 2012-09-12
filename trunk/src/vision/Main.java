/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vision;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.*;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageOutputStream;
import javax.swing.ImageIcon;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author juanagva
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList listaImagenes = new ArrayList();
        ImageIndexing ej = new ImageIndexing();
      // crea el array para hacer el indice y crea el archivo Diccionario.txt   
      //   ej.dirlist("C:\\Users\\juanagva\\Pictures\\101_ObjectCategories");
      Hashtable dicCategoria  = new Hashtable(); 
        try
        {
            // Open the file that is the first 
            // command line parameter
            FileInputStream fstream = new FileInputStream("Diccionario.txt");
            // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            //Read File Line By Line
            while ((strLine = br.readLine()) != null)  
            {
                int indexComa = strLine.indexOf(",");
                String llave = strLine.substring(0, indexComa);
                String Categoria = strLine.substring(indexComa+1,strLine.length());
                dicCategoria.put(llave, Categoria);
            // Print the content on the console
            //   System.out.println (strLine);
            }
            //Close the input stream
            in.close();
         }
        catch (Exception e)
            {//Catch exception if any
                System.err.println("Error: " + e.getMessage());
            }
        
        
        
        NaoRobot nao = new NaoRobot("169.254.9.110");
         

        FrameView vista = new FrameView();
        vista.setSize(600, 600);
        JPanel panel = new JPanel();
        try {
            
            /*
          //SOLO SE EJECUTA CUANDO DEBO CREAR EL INDECE DE NUEVO  
          //   ej.testCreateIndex();
            
           FileInputStream imageStream = new FileInputStream("C:\\Users\\juanagva\\Documents\\NetBeansProjects\\JavaApplication1\\src\\images\\03_00_02.jpg");
            BufferedImage bimg = ImageIO.read(imageStream);
           
            ej.testSearch(bimg);
            */
          
            
           AwtImage imagenNao = nao.getImage();
           listaImagenes = ej.testSearch(imagenNao.getImg());
           
          String CategoriaDeLaImagen = dicCategoria.get(listaImagenes.get(0)).toString();
          nao.speak("La imagen que vi es  " +CategoriaDeLaImagen );
          System.out.print(CategoriaDeLaImagen);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
