/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vision.IndexingImagenes;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author juanagva
 */
public class KnnAnalisis 
{
    public Hashtable CargarTablaDiccionario()
    {
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
        
        return dicCategoria;
    }
    
    public String analizarKnn( ArrayList listaImagenes)
    {
        Hashtable listaImagenesFinal  = new Hashtable(); 
         Hashtable dicCategoria  = CargarTablaDiccionario(); 
         
        String TextoArea = "";
               
               
        for (Object texto : listaImagenes)
        {
           String CategoriaDeLaImagen = dicCategoria.get(texto).toString();
           TextoArea += CategoriaDeLaImagen + "  " +  texto.toString() + " \n\r";
           
           if(listaImagenesFinal.containsKey(CategoriaDeLaImagen))
           {
               listaImagenesFinal.put(CategoriaDeLaImagen, (int)listaImagenesFinal.get(CategoriaDeLaImagen) + 1);
                //crear otro hashtable<string,int> conteos 
                //conteos.put("gato",1);
                //conteos.put("gato", conteos.get("gato")+1);
           }
           else
           {
                listaImagenesFinal.put(CategoriaDeLaImagen,1);
           }           
         }                    
    
        return TextoArea;        
    }
    
}
