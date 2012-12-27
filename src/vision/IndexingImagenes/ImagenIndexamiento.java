/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vision.IndexingImagenes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import net.semanticmetadata.lire.DocumentBuilder;
import net.semanticmetadata.lire.DocumentBuilderFactory;
import org.apache.lucene.analysis.SimpleAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.store.FSDirectory;
import vision.ImageIndexing;

/**
 *
 * @author juanagva
 */
public class ImagenIndexamiento 
{
   
   
    
    public ArrayList<File> testFiles = new ArrayList();
    public File[] dos;
    private String testFilesPath = "./src/images/";
    private String indexPath = "test-index";//cambie el nombre del indixe para tener otro indice PROVISIONAL
    private String testExtensive = "../Caliph/testdaten";

    public void setIndexPath(String indexPath) {
        this.indexPath = indexPath;
    }

    
    
    
    public void dirlist(String dirBaseImagenes) { //throws IOException
        dos = null;
        
        File f;
        f=new File("Diccionario.txt");
        if(!f.exists())
        {
            try 
            {
                f.createNewFile();
            } catch (IOException ex) 
            {
                Logger.getLogger(ImageIndexing.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        FileWriter fstream;
        try {
            fstream = new FileWriter("Diccionario.txt");
      
            BufferedWriter out = new BufferedWriter(fstream);
                          
        
                File dir = new File(dirBaseImagenes);
                int i = 0;
                if (dir.isDirectory())
                {
                    dos = dir.listFiles();
                    for (File file : dos) 
                    {
                        File valor[] = file.listFiles();
                        for (File de : valor) 
                        {
                            // de.renameTo(new File(de.getParent() + "\\".concat(Integer.toString(i))+de.getName()));
                             out.write(de.getName()+ ","+ file.getName()+System.getProperty("line.separator"));
                             
                            testFiles.add(de);
                            System.out.println(de.getName());
                            i++;
                        }
                    }
                }
          out.close();
         } catch (IOException ex) {
            Logger.getLogger(ImageIndexing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
     public void DefaultImplementacion(String caracteristica) throws IOException
    {
      DocumentBuilder builder = null;
        switch (caracteristica) 
        {
            case "Auto Color Correlogram":
                builder = testCreateIndexAutoColorCorrelogram();
                break;
            case "CEDD Document":
                builder = testCreateIndexCEDDDocument();
                break;
            case "Default Document":
                builder = testCreateIndexDefaultDocument();
                break;
            case "Color Histogram":
                builder = testCreateIndexColorHistogram();
                break;                
            case "Color Layout":
                builder = testCreateIndexColorLayout();
                break;
            case "Edge Histogram":
                builder = testCreateIndexEdgeHistogram();
                break;
            case "FCTHD":
                builder = testCreateIndexFCTHDocument();
                break;
            case "GaborDocument":
                builder = testCreateIndexGaborDocument();
                break;
            case "JCDDocument":
                builder = testCreateIndexJCDDocument();
                break;
            case "JpegCoefficientHistogramDocument":
                builder = testCreateIndexJpegCoefficientHistogram();
                break;
            case "ScalableColor":
                builder = testCreateIndexScalableColor();
                break;
            case "TamuraDocument":
                builder = testCreateIndexTamuraDocument();
                break;                                      
          
        }        
        try (IndexWriter iw = new IndexWriter(FSDirectory.open(new File(indexPath)), new SimpleAnalyzer(), true, IndexWriter.MaxFieldLength.UNLIMITED)) {
            for (File identifier : testFiles) {
                // Build the Lucene Documents
                Document doc = builder.createDocument(new FileInputStream(identifier.getPath()), identifier.getName());
                // Add the Documents to the index
                iw.addDocument(doc);
                System.out.println(identifier.getName());
            }
            iw.optimize();
        }      
       
    }
    
    
    public DocumentBuilder testCreateIndexAutoColorCorrelogram() throws IOException {
        // Create an appropriate DocumentBuilder
        System.out.println("entro index");
        DocumentBuilder builder = DocumentBuilderFactory.getAutoColorCorrelogramDocumentBuilder();        
        return builder;
    }
    
     public DocumentBuilder testCreateIndexCEDDDocument() throws IOException {
        // Create an appropriate DocumentBuilder
        System.out.println("entro index");
        DocumentBuilder builder = DocumentBuilderFactory.getCEDDDocumentBuilder();
        return builder;
    }
     
      public DocumentBuilder testCreateIndexColorHistogram() throws IOException {
        // Create an appropriate DocumentBuilder
        System.out.println("entro index");
        DocumentBuilder builder = DocumentBuilderFactory.getColorHistogramDocumentBuilder();        
        return builder;
    }
      
       public DocumentBuilder testCreateIndexColorLayout() throws IOException {
        // Create an appropriate DocumentBuilder
        System.out.println("entro index");
        DocumentBuilder builder = DocumentBuilderFactory.getColorLayoutBuilder();
        return builder;
    }
       
       public DocumentBuilder testCreateIndexDefaultDocument() throws IOException {
        // Create an appropriate DocumentBuilder
        System.out.println("entro index");
        DocumentBuilder builder = DocumentBuilderFactory.getDefaultDocumentBuilder();  
        return builder;
    }
   
    public DocumentBuilder testCreateIndexEdgeHistogram() throws IOException {
        // Create an appropriate DocumentBuilder
        System.out.println("entro index");
        DocumentBuilder builder = DocumentBuilderFactory.getEdgeHistogramBuilder();
        return builder;
    }
    
    public DocumentBuilder testCreateIndexFCTHDocument() throws IOException {
        // Create an appropriate DocumentBuilder
        System.out.println("entro index");
        DocumentBuilder builder = DocumentBuilderFactory.getFCTHDocumentBuilder();
        return builder;
    }
    
     public DocumentBuilder testCreateIndexFullDocument() throws IOException {
        // Create an appropriate DocumentBuilder
        System.out.println("entro index");
        DocumentBuilder builder = DocumentBuilderFactory.getFullDocumentBuilder();
        return builder;
    }
   
     public DocumentBuilder testCreateIndexGaborDocument() throws IOException {
        // Create an appropriate DocumentBuilder
        System.out.println("entro index");
        DocumentBuilder builder = DocumentBuilderFactory.getGaborDocumentBuilder();
       return builder;
    }
    
     public DocumentBuilder testCreateIndexJCDDocument() throws IOException {
        // Create an appropriate DocumentBuilder
        System.out.println("entro index");
        DocumentBuilder builder = DocumentBuilderFactory.getJCDDocumentBuilder();
        return builder;
    }

        public DocumentBuilder testCreateIndexJpegCoefficientHistogram() throws IOException {
        // Create an appropriate DocumentBuilder
        System.out.println("entro index");
        DocumentBuilder builder = DocumentBuilderFactory.getJpegCoefficientHistogramDocumentBuilder();   
        return builder;
    }
     
        
         public DocumentBuilder testCreateIndexScalableColor() throws IOException {
        // Create an appropriate DocumentBuilder
        System.out.println("entro index");
        DocumentBuilder builder = DocumentBuilderFactory.getScalableColorBuilder();
        return builder;
    }

        public DocumentBuilder testCreateIndexTamuraDocument() throws IOException {
        // Create an appropriate DocumentBuilder
        System.out.println("entro index");
        DocumentBuilder builder = DocumentBuilderFactory.getTamuraDocumentBuilder();
        return builder;
    }
         
}
