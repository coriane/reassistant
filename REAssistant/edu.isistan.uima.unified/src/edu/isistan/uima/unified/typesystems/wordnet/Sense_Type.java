
/* First created by JCasGen Fri Mar 11 15:23:15 ART 2011 */
package edu.isistan.uima.unified.typesystems.wordnet;

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
 * Updated by JCasGen Fri Mar 11 15:23:15 ART 2011
 * @generated */
public class Sense_Type extends IdentifiableAnnotation_Type {
  /** @generated */
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Sense_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Sense_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Sense(addr, Sense_Type.this);
  			   Sense_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Sense(addr, Sense_Type.this);
  	  }
    };
  /** @generated */
  public final static int typeIndexID = Sense.typeIndexID;
  /** @generated 
     @modifiable */
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.isistan.uima.unified.typesystems.wordnet.Sense");
 
  /** @generated */
  final Feature casFeat_pos;
  /** @generated */
  final int     casFeatCode_pos;
  /** @generated */ 
  public String getPos(int addr) {
        if (featOkTst && casFeat_pos == null)
      jcas.throwFeatMissing("pos", "edu.isistan.uima.unified.typesystems.wordnet.Sense");
    return ll_cas.ll_getStringValue(addr, casFeatCode_pos);
  }
  /** @generated */    
  public void setPos(int addr, String v) {
        if (featOkTst && casFeat_pos == null)
      jcas.throwFeatMissing("pos", "edu.isistan.uima.unified.typesystems.wordnet.Sense");
    ll_cas.ll_setStringValue(addr, casFeatCode_pos, v);}
    
  
 
  /** @generated */
  final Feature casFeat_sense;
  /** @generated */
  final int     casFeatCode_sense;
  /** @generated */ 
  public String getSense(int addr) {
        if (featOkTst && casFeat_sense == null)
      jcas.throwFeatMissing("sense", "edu.isistan.uima.unified.typesystems.wordnet.Sense");
    return ll_cas.ll_getStringValue(addr, casFeatCode_sense);
  }
  /** @generated */    
  public void setSense(int addr, String v) {
        if (featOkTst && casFeat_sense == null)
      jcas.throwFeatMissing("sense", "edu.isistan.uima.unified.typesystems.wordnet.Sense");
    ll_cas.ll_setStringValue(addr, casFeatCode_sense, v);}
    
  
 
  /** @generated */
  final Feature casFeat_gloss;
  /** @generated */
  final int     casFeatCode_gloss;
  /** @generated */ 
  public String getGloss(int addr) {
        if (featOkTst && casFeat_gloss == null)
      jcas.throwFeatMissing("gloss", "edu.isistan.uima.unified.typesystems.wordnet.Sense");
    return ll_cas.ll_getStringValue(addr, casFeatCode_gloss);
  }
  /** @generated */    
  public void setGloss(int addr, String v) {
        if (featOkTst && casFeat_gloss == null)
      jcas.throwFeatMissing("gloss", "edu.isistan.uima.unified.typesystems.wordnet.Sense");
    ll_cas.ll_setStringValue(addr, casFeatCode_gloss, v);}
    
  
 
  /** @generated */
  final Feature casFeat_senses;
  /** @generated */
  final int     casFeatCode_senses;
  /** @generated */ 
  public int getSenses(int addr) {
        if (featOkTst && casFeat_senses == null)
      jcas.throwFeatMissing("senses", "edu.isistan.uima.unified.typesystems.wordnet.Sense");
    return ll_cas.ll_getRefValue(addr, casFeatCode_senses);
  }
  /** @generated */    
  public void setSenses(int addr, int v) {
        if (featOkTst && casFeat_senses == null)
      jcas.throwFeatMissing("senses", "edu.isistan.uima.unified.typesystems.wordnet.Sense");
    ll_cas.ll_setRefValue(addr, casFeatCode_senses, v);}
    
   /** @generated */
  public String getSenses(int addr, int i) {
        if (featOkTst && casFeat_senses == null)
      jcas.throwFeatMissing("senses", "edu.isistan.uima.unified.typesystems.wordnet.Sense");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_senses), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_senses), i);
	return ll_cas.ll_getStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_senses), i);
  }
   
  /** @generated */ 
  public void setSenses(int addr, int i, String v) {
        if (featOkTst && casFeat_senses == null)
      jcas.throwFeatMissing("senses", "edu.isistan.uima.unified.typesystems.wordnet.Sense");
    if (lowLevelTypeChecks)
      ll_cas.ll_setStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_senses), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_senses), i);
    ll_cas.ll_setStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_senses), i, v);
  }
 



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public Sense_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_pos = jcas.getRequiredFeatureDE(casType, "pos", "uima.cas.String", featOkTst);
    casFeatCode_pos  = (null == casFeat_pos) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_pos).getCode();

 
    casFeat_sense = jcas.getRequiredFeatureDE(casType, "sense", "uima.cas.String", featOkTst);
    casFeatCode_sense  = (null == casFeat_sense) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_sense).getCode();

 
    casFeat_gloss = jcas.getRequiredFeatureDE(casType, "gloss", "uima.cas.String", featOkTst);
    casFeatCode_gloss  = (null == casFeat_gloss) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_gloss).getCode();

 
    casFeat_senses = jcas.getRequiredFeatureDE(casType, "senses", "uima.cas.StringArray", featOkTst);
    casFeatCode_senses  = (null == casFeat_senses) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_senses).getCode();

  }
}



    