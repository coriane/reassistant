
/* First created by JCasGen Mon Dec 29 18:34:55 ART 2014 */
package edu.isistan.uima.unified.typesystems.nlp;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import edu.isistan.uima.unified.typesystems.IdentifiableAnnotation_Type;

/** 
 * Updated by JCasGen Tue Dec 30 11:22:03 ART 2014
 * @generated */
public class Chunk_Type extends IdentifiableAnnotation_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Chunk_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Chunk_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Chunk(addr, Chunk_Type.this);
  			   Chunk_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Chunk(addr, Chunk_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Chunk.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.isistan.uima.unified.typesystems.nlp.Chunk");
 
  /** @generated */
  final Feature casFeat_chunk;
  /** @generated */
  final int     casFeatCode_chunk;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getChunk(int addr) {
        if (featOkTst && casFeat_chunk == null)
      jcas.throwFeatMissing("chunk", "edu.isistan.uima.unified.typesystems.nlp.Chunk");
    return ll_cas.ll_getStringValue(addr, casFeatCode_chunk);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setChunk(int addr, String v) {
        if (featOkTst && casFeat_chunk == null)
      jcas.throwFeatMissing("chunk", "edu.isistan.uima.unified.typesystems.nlp.Chunk");
    ll_cas.ll_setStringValue(addr, casFeatCode_chunk, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public Chunk_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_chunk = jcas.getRequiredFeatureDE(casType, "chunk", "uima.cas.String", featOkTst);
    casFeatCode_chunk  = (null == casFeat_chunk) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_chunk).getCode();

  }
}



    