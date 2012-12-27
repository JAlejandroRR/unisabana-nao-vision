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
    
    public ArrayList DefaultImplementacion(BufferedImage bimg,String caracteristica) throws IOException
    {
       ArrayList listaImagenesConcidencias = new ArrayList();
        // Opening an IndexReader (Lucene v3.0+)
       IndexReader reader = IndexReader.open(FSDirectory.open(new File(indexPath)));
       ImageSearchHits hits = null;
        switch (caracteristica) 
        {
            case "Auto Color Correlogram":
                hits = testSearchAutoColorCorrelogram(bimg,reader);
                break;
            case "CEDD Document":
                hits = testSearchCEDD(bimg,reader);
                break;
            case "Default Document":
                hits = testSearchDefault(bimg,reader);
                break;
            case "Color Histogram":
                hits = testSearchColorHistogram(bimg,reader);
                break;                
            case "Color Layout":
                hits = testSearchColorLayout(bimg,reader);
                break;
            case "Edge Histogram":
                hits = testSearchEdgeHistogram(bimg,reader);
                break;
            case "FCTHD":
                hits = testSearchFCTH(bimg,reader);
                break;
            case "GaborDocument":
                hits = testSearchGabor(bimg,reader);
                break;
            case "JCDDocument":
                hits = testSearchJCD(bimg,reader);
                break;
            case "JpegCoefficientHistogramDocument":
                hits = testSearchCoefficientHistogram(bimg,reader);
                break;
            case "ScalableColor":
                hits = testSearchScalableColor(bimg,reader);
                break;
            case "TamuraDocument":
                hits = testSearchTamura(bimg,reader);
                break;                                 
                
          
        }
       
        for (int i = 0; i < 4; i++) {
            System.out.println(hits.score(i) + ": "
                    + hits.doc(i).getFieldable(DocumentBuilder.FIELD_NAME_IDENTIFIER).stringValue());
            listaImagenesConcidencias.add(hits.doc(i).getFieldable(DocumentBuilder.FIELD_NAME_IDENTIFIER).stringValue());
        }
        
        
        
       return listaImagenesConcidencias;
    }
    
    
    
    public ImageSearchHits testSearchAutoColorCorrelogram(BufferedImage bimg,IndexReader reader) throws IOException {
        
        ImageSearcher searcher = ImageSearcherFactory.createAutoColorCorrelogramImageSearcher(5);//createDefaultSearcher(); //createColorHistogramImageSearcher(10);//      
        ImageSearchHits hits = searcher.search(bimg, reader);                 
        // Get a document from the results
        Document document = hits.doc(0);
        // Search for similar Documents based on the image  features
        hits = searcher.search(document, reader);        
        return hits;
    }
    
    
    
     public ImageSearchHits testSearchCEDD(BufferedImage bimg,IndexReader reader) throws IOException {
        
        ImageSearcher searcher = ImageSearcherFactory.createCEDDImageSearcher(5);//createDefaultSearcher(); //createColorHistogramImageSearcher(10);//        
        ImageSearchHits hits = searcher.search(bimg, reader);            
        Document document = hits.doc(0);       
        hits = searcher.search(document, reader);      
        return hits;
    }
    
     public ImageSearchHits testSearchDefault(BufferedImage bimg,IndexReader reader) throws IOException {       
       
        ImageSearcher searcher = ImageSearcherFactory.createDefaultSearcher();//createDefaultSearcher(); //createColorHistogramImageSearcher(10);//        
        ImageSearchHits hits = searcher.search(bimg, reader);       
        Document document = hits.doc(0);
        // Search for similar Documents based on the image  features
        hits = searcher.search(document, reader);       
        return hits;       
    }
         
     
      public ImageSearchHits testSearchColorHistogram(BufferedImage bimg,IndexReader reader) throws IOException {
        
        ImageSearcher searcher = ImageSearcherFactory.createColorHistogramImageSearcher(5);//createDefaultSearcher(); //createColorHistogramImageSearcher(10);//       
        ImageSearchHits hits = searcher.search(bimg, reader);        
        Document document = hits.doc(0);
        // Search for similar Documents based on the image  features
        hits = searcher.search(document, reader);        
        return hits;
    }
      
      
       public ImageSearchHits testSearchColorLayout(BufferedImage bimg,IndexReader reader) throws IOException {
       
        ImageSearcher searcher = ImageSearcherFactory.createColorLayoutImageSearcher(5);//createDefaultSearcher(); //createColorHistogramImageSearcher(10);//
        
        ImageSearchHits hits = searcher.search(bimg, reader);        
        Document document = hits.doc(0);
        // Search for similar Documents based on the image  features
        hits = searcher.search(document, reader);       
        return hits;
    }      
         
       public ImageSearchHits testSearchEdgeHistogram(BufferedImage bimg,IndexReader reader) throws IOException {       
        ImageSearcher searcher = ImageSearcherFactory.createEdgeHistogramImageSearcher(5);//createDefaultSearcher(); //createColorHistogramImageSearcher(10);//
       
        ImageSearchHits hits = searcher.search(bimg, reader);        
        Document document = hits.doc(0);
        // Search for similar Documents based on the image  features
        hits = searcher.search(document, reader);        
        return hits;
    }
       
    public ImageSearchHits testSearchFCTH(BufferedImage bimg,IndexReader reader) throws IOException {
        
        // Creating an ImageSearcher
        ImageSearcher searcher = ImageSearcherFactory.createFCTHImageSearcher(5);//createDefaultSearcher(); //createColorHistogramImageSearcher(10);//        
        ImageSearchHits hits = searcher.search(bimg, reader);        
        Document document = hits.doc(0);
        // Search for similar Documents based on the image  features
        hits = searcher.search(document, reader);       
        return hits;
    }
       
         
     public ImageSearchHits testSearchGabor(BufferedImage bimg,IndexReader reader) throws IOException {
        
        ImageSearcher searcher = ImageSearcherFactory.createGaborImageSearcher(5);//createDefaultSearcher(); //createColorHistogramImageSearcher(10);//       
        ImageSearchHits hits = searcher.search(bimg, reader);       
        Document document = hits.doc(0);
        // Search for similar Documents based on the image  features
        hits = searcher.search(document, reader);        
        return hits;
    } 
         
      
       public ImageSearchHits testSearchJCD(BufferedImage bimg,IndexReader reader) throws IOException {       
        ImageSearcher searcher = ImageSearcherFactory.createJCDImageSearcher(5);        
        ImageSearchHits hits = searcher.search(bimg, reader);        
        Document document = hits.doc(0);
        // Search for similar Documents based on the image  features
        hits = searcher.search(document, reader);       
        return hits;
    }
       
       
       public ImageSearchHits testSearchCoefficientHistogram(BufferedImage bimg,IndexReader reader) throws IOException {       
        ImageSearcher searcher = ImageSearcherFactory.createJpegCoefficientHistogramImageSearcher(5);       
        ImageSearchHits hits = searcher.search(bimg, reader);       
        Document document = hits.doc(0);
        // Search for similar Documents based on the image  features
        hits = searcher.search(document, reader);
        return hits;
    }
       
       
       public ImageSearchHits testSearchScalableColor(BufferedImage bimg,IndexReader reader) throws IOException {        
        ImageSearcher searcher = ImageSearcherFactory.createScalableColorImageSearcher(5);        
        ImageSearchHits hits = searcher.search(bimg, reader);        
        Document document = hits.doc(0);
        // Search for similar Documents based on the image  features
        hits = searcher.search(document, reader);       
        return hits;
    }
       
       
        
       public ImageSearchHits testSearchTamura(BufferedImage bimg,IndexReader reader) throws IOException {        
        ImageSearcher searcher = ImageSearcherFactory.createTamuraImageSearcher(5);       
        ImageSearchHits hits = searcher.search(bimg, reader);       
        Document document = hits.doc(0);
        // Search for similar Documents based on the image  features
        hits = searcher.search(document, reader);       
        return hits;
    }
      
      
}
