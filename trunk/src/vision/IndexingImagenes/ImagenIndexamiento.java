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

    public void testCreateIndexAutoColorCorrelogram() throws IOException {
        // Create an appropriate DocumentBuilder
        System.out.println("entro index");
        DocumentBuilder builder = DocumentBuilderFactory.getAutoColorCorrelogramDocumentBuilder();
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
    
     public void testCreateIndexCEDDDocument() throws IOException {
        // Create an appropriate DocumentBuilder
        System.out.println("entro index");
        DocumentBuilder builder = DocumentBuilderFactory.getCEDDDocumentBuilder();
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
     
      public void testCreateIndexColorHistogram() throws IOException {
        // Create an appropriate DocumentBuilder
        System.out.println("entro index");
        DocumentBuilder builder = DocumentBuilderFactory.getColorHistogramDocumentBuilder();
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
      
       public void testCreateIndexColorLayout() throws IOException {
        // Create an appropriate DocumentBuilder
        System.out.println("entro index");
        DocumentBuilder builder = DocumentBuilderFactory.getColorLayoutBuilder();
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
       
         public void testCreateIndexDefaultDocument() throws IOException {
        // Create an appropriate DocumentBuilder
        System.out.println("entro index");
        DocumentBuilder builder = DocumentBuilderFactory.getDefaultDocumentBuilder();
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
   
    public void testCreateIndexEdgeHistogram() throws IOException {
        // Create an appropriate DocumentBuilder
        System.out.println("entro index");
        DocumentBuilder builder = DocumentBuilderFactory.getEdgeHistogramBuilder();
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
    
    public void testCreateIndexFCTHDocument() throws IOException {
        // Create an appropriate DocumentBuilder
        System.out.println("entro index");
        DocumentBuilder builder = DocumentBuilderFactory.getFCTHDocumentBuilder();
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
    
     public void testCreateIndexFullDocument() throws IOException {
        // Create an appropriate DocumentBuilder
        System.out.println("entro index");
        DocumentBuilder builder = DocumentBuilderFactory.getFullDocumentBuilder();
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
   
     public void testCreateIndexGaborDocument() throws IOException {
        // Create an appropriate DocumentBuilder
        System.out.println("entro index");
        DocumentBuilder builder = DocumentBuilderFactory.getGaborDocumentBuilder();
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
    
     public void testCreateIndexJCDDocument() throws IOException {
        // Create an appropriate DocumentBuilder
        System.out.println("entro index");
        DocumentBuilder builder = DocumentBuilderFactory.getJCDDocumentBuilder();
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

        public void testCreateIndexJpegCoefficientHistogram() throws IOException {
        // Create an appropriate DocumentBuilder
        System.out.println("entro index");
        DocumentBuilder builder = DocumentBuilderFactory.getJpegCoefficientHistogramDocumentBuilder();
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
     
        
         public void testCreateIndexScalableColor() throws IOException {
        // Create an appropriate DocumentBuilder
        System.out.println("entro index");
        DocumentBuilder builder = DocumentBuilderFactory.getScalableColorBuilder();
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

        public void testCreateIndexTamuraDocument() throws IOException {
        // Create an appropriate DocumentBuilder
        System.out.println("entro index");
        DocumentBuilder builder = DocumentBuilderFactory.getTamuraDocumentBuilder();
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
         
}
