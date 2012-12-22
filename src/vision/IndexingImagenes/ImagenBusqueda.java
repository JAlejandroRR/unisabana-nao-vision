/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vision.IndexingImagenes;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import net.semanticmetadata.lire.DocumentBuilder;
import net.semanticmetadata.lire.ImageSearchHits;
import net.semanticmetadata.lire.ImageSearcher;
import net.semanticmetadata.lire.ImageSearcherFactory;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.store.FSDirectory;

/**
 *
 * @author juanagva
 */
public class ImagenBusqueda 
{

     public ArrayList<File> testFiles = new ArrayList();
    public File[] dos;
    private String testFilesPath = "./src/images/";
    private String indexPath = "test-index";//cambie el nombre del indixe para tener otro indice PROVISIONAL
    private String testExtensive = "../Caliph/testdaten";

    public void setIndexPath(String indexPath) {
        this.indexPath = indexPath;
    }    
    
    
    
    public ArrayList testSearchAutoColorCorrelogram(BufferedImage bimg) throws IOException {
        ArrayList listaImagenesConcidencias = new ArrayList();
        // Opening an IndexReader (Lucene v3.0+)
        IndexReader reader = IndexReader.open(FSDirectory.open(new File(indexPath)));
        // Creating an ImageSearcher
        ImageSearcher searcher = ImageSearcherFactory.createAutoColorCorrelogramImageSearcher(5);//createDefaultSearcher(); //createColorHistogramImageSearcher(10);//
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
    
    
    
     public ArrayList testSearchCEDD(BufferedImage bimg) throws IOException {
        ArrayList listaImagenesConcidencias = new ArrayList();
        // Opening an IndexReader (Lucene v3.0+)
        IndexReader reader = IndexReader.open(FSDirectory.open(new File(indexPath)));
        // Creating an ImageSearcher
        ImageSearcher searcher = ImageSearcherFactory.createCEDDImageSearcher(5);//createDefaultSearcher(); //createColorHistogramImageSearcher(10);//
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
     
     
      public ArrayList testSearchColorHistogram(BufferedImage bimg) throws IOException {
        ArrayList listaImagenesConcidencias = new ArrayList();
        // Opening an IndexReader (Lucene v3.0+)
        IndexReader reader = IndexReader.open(FSDirectory.open(new File(indexPath)));
        // Creating an ImageSearcher
        ImageSearcher searcher = ImageSearcherFactory.createColorHistogramImageSearcher(5);//createDefaultSearcher(); //createColorHistogramImageSearcher(10);//
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
      
      
       public ArrayList testSearchColorLayout(BufferedImage bimg) throws IOException {
        ArrayList listaImagenesConcidencias = new ArrayList();
        // Opening an IndexReader (Lucene v3.0+)
        IndexReader reader = IndexReader.open(FSDirectory.open(new File(indexPath)));
        // Creating an ImageSearcher
        ImageSearcher searcher = ImageSearcherFactory.createColorLayoutImageSearcher(5);//createDefaultSearcher(); //createColorHistogramImageSearcher(10);//
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
     
     
         public Hashtable testSearchDefault(BufferedImage bimg) throws IOException {
             
        Hashtable listaImagenesPesos  = new Hashtable();                 
       
        // Opening an IndexReader (Lucene v3.0+)
        IndexReader reader = IndexReader.open(FSDirectory.open(new File(indexPath)));
        // Creating an ImageSearcher
        ImageSearcher searcher = ImageSearcherFactory.createDefaultSearcher();//createDefaultSearcher(); //createColorHistogramImageSearcher(10);//
        //createWeightedSearcher(10, 0.2f, 0.8f, 1.0f);
        // ImageSearcher searcher = ImageSearcherFactory.createWeightedSearcher(10, 0.8f, 0.0f, 1.0f);
        // ImageSearcher searcher = ImageSearcherFactory.createWeightedSearcher(10, 0.0f, 1.0f, 0.0f);
        // Reading the sample image, which is our "query"
        // Search for similar images
        ImageSearchHits hits = searcher.search(bimg, reader);
        System.out.println(Integer.toString(hits.length()));        
        Document document = hits.doc(0);
        // Search for similar Documents based on the image  features
        hits = searcher.search(document, reader);

        for (int i = 0; i < 4; i++) {
            System.out.println(hits.score(i) + ": "
                    + hits.doc(i).getFieldable(DocumentBuilder.FIELD_NAME_IDENTIFIER).stringValue());            
            listaImagenesPesos.put((hits.doc(i).getFieldable(DocumentBuilder.FIELD_NAME_IDENTIFIER).stringValue()), hits.score(i));
        }
        return listaImagenesPesos;
    }
         
         
          public ArrayList testSearchEdgeHistogram(BufferedImage bimg) throws IOException {
        ArrayList listaImagenesConcidencias = new ArrayList();
        // Opening an IndexReader (Lucene v3.0+)
        IndexReader reader = IndexReader.open(FSDirectory.open(new File(indexPath)));
        // Creating an ImageSearcher
        ImageSearcher searcher = ImageSearcherFactory.createEdgeHistogramImageSearcher(5);//createDefaultSearcher(); //createColorHistogramImageSearcher(10);//
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
         
     public ArrayList testSearchGabor(BufferedImage bimg) throws IOException {
        ArrayList listaImagenesConcidencias = new ArrayList();
        // Opening an IndexReader (Lucene v3.0+)
        IndexReader reader = IndexReader.open(FSDirectory.open(new File(indexPath)));
        // Creating an ImageSearcher
        ImageSearcher searcher = ImageSearcherFactory.createGaborImageSearcher(5);//createDefaultSearcher(); //createColorHistogramImageSearcher(10);//
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
         
     
      public ArrayList testSearchFCTH(BufferedImage bimg) throws IOException {
        ArrayList listaImagenesConcidencias = new ArrayList();
        // Opening an IndexReader (Lucene v3.0+)
        IndexReader reader = IndexReader.open(FSDirectory.open(new File(indexPath)));
        // Creating an ImageSearcher
        ImageSearcher searcher = ImageSearcherFactory.createFCTHImageSearcher(5);//createDefaultSearcher(); //createColorHistogramImageSearcher(10);//
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
         
      
       public ArrayList testSearchJCD(BufferedImage bimg) throws IOException {
        ArrayList listaImagenesConcidencias = new ArrayList();
        // Opening an IndexReader (Lucene v3.0+)
        IndexReader reader = IndexReader.open(FSDirectory.open(new File(indexPath)));
        // Creating an ImageSearcher
        ImageSearcher searcher = ImageSearcherFactory.createJCDImageSearcher(5);
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
       
       
       public ArrayList testSearchCoefficientHistogram(BufferedImage bimg) throws IOException {
        ArrayList listaImagenesConcidencias = new ArrayList();
        // Opening an IndexReader (Lucene v3.0+)
        IndexReader reader = IndexReader.open(FSDirectory.open(new File(indexPath)));
        // Creating an ImageSearcher
        ImageSearcher searcher = ImageSearcherFactory.createJpegCoefficientHistogramImageSearcher(5);
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
       
       
       public ArrayList testSearchScalableColor(BufferedImage bimg) throws IOException {
        ArrayList listaImagenesConcidencias = new ArrayList();
        // Opening an IndexReader (Lucene v3.0+)
        IndexReader reader = IndexReader.open(FSDirectory.open(new File(indexPath)));
        // Creating an ImageSearcher
        ImageSearcher searcher = ImageSearcherFactory.createScalableColorImageSearcher(5);
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
       
       
        
       public ArrayList testSearchTamura(BufferedImage bimg) throws IOException {
        ArrayList listaImagenesConcidencias = new ArrayList();
        // Opening an IndexReader (Lucene v3.0+)
        IndexReader reader = IndexReader.open(FSDirectory.open(new File(indexPath)));
        // Creating an ImageSearcher
        ImageSearcher searcher = ImageSearcherFactory.createTamuraImageSearcher(5);
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
