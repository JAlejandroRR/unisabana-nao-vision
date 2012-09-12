/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vision;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import junit.framework.TestCase;
import net.semanticmetadata.lire.*;
import org.apache.lucene.analysis.SimpleAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.store.FSDirectory;

import com.aldebaran.proxy.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author juanagva
 */
public class ImageIndexing extends TestCase {

    public ArrayList<File> testFiles = new ArrayList();
    public File[] dos;
    private String testFilesPath = "./src/images/";
    private String indexPath = "test-index";
    private String testExtensive = "../Caliph/testdaten";

    public void dirlist(String fname) { //throws IOException
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
                          
        
                File dir = new File(fname);
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

    public void testCreateIndex() throws IOException {
        // Create an appropriate DocumentBuilder
        System.out.println("entro index");
        DocumentBuilder builder = DocumentBuilderFactory.getDefaultDocumentBuilder();//
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

    public ArrayList testSearch(BufferedImage bimg) throws IOException {
        ArrayList listaImagenesConcidencias = new ArrayList();
        // Opening an IndexReader (Lucene v3.0+)
        IndexReader reader = IndexReader.open(FSDirectory.open(new File(indexPath)));
        // Creating an ImageSearcher
        ImageSearcher searcher = ImageSearcherFactory.createDefaultSearcher(); //createColorHistogramImageSearcher(10);//
        //createWeightedSearcher(10, 0.2f, 0.8f, 1.0f);
        // ImageSearcher searcher = ImageSearcherFactory.createWeightedSearcher(10, 0.8f, 0.0f, 1.0f);
        // ImageSearcher searcher = ImageSearcherFactory.createWeightedSearcher(10, 0.0f, 1.0f, 0.0f);
        // Reading the sample image, which is our "query"
        // Search for similar images
        ImageSearchHits hits = searcher.search(bimg, reader);
        System.out.println(Integer.toString(hits.length()));
        // print out results
        for (int i = 0; i < 4; i++) {
            System.out.println(hits.score(i) + ": "
                    + hits.doc(i).getFieldable(DocumentBuilder.FIELD_NAME_IDENTIFIER).stringValue());
            // System.out.println(hits.score(i) + ": " + hits.doc(i).toString());
        }
        // Get a document from the results
        Document document = hits.doc(0);
        // Search for similar Documents based on the image  features
        hits = searcher.search(document, reader);

        for (int i = 0; i < 4; i++) {
            System.out.println(hits.score(i) + ": "
                    + hits.doc(i).getFieldable(DocumentBuilder.FIELD_NAME_IDENTIFIER).stringValue());
            listaImagenesConcidencias.add(hits.doc(i).getFieldable(DocumentBuilder.FIELD_NAME_IDENTIFIER).stringValue());
        }
        return listaImagenesConcidencias;
    }
}
