
/* First created by JCasGen Fri Mar 11 15:22:20 ART 2011 */
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
 * Updated by JCasGen Sat Dec 10 16:39:00 ART 2011
 * @generated */
public class Token_Type extends IdentifiableAnnotation_Type {
  /** @generated */
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Token_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Token_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Token(addr, Token_Type.this);
  			   Token_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Token(addr, Token_Type.this);
  	  }
    };
  /** @generated */
  public final static int typeIndexID = Token.typeIndexID;
  /** @generated 
     @modifiable */
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.isistan.uima.unified.typesystems.nlp.Token");
 
  /** @generated */
  final Feature casFeat_lemma;
  /** @generated */
  final int     casFeatCode_lemma;
  /** @generated */ 
  public String getLemma(int addr) {
        if (featOkTst && casFeat_lemma == null)
      jcas.throwFeatMissing("lemma", "edu.isistan.uima.unified.typesystems.nlp.Token");
    return ll_cas.ll_getStringValue(addr, casFeatCode_lemma);
  }
  /** @generated */    
  public void setLemma(int addr, String v) {
        if (featOkTst && casFeat_lemma == null)
      jcas.throwFeatMissing("lemma", "edu.isistan.uima.unified.typesystems.nlp.Token");
    ll_cas.ll_setStringValue(addr, casFeatCode_lemma, v);}
    
  
 
  /** @generated */
  final Feature casFeat_morph;
  /** @generated */
  final int     casFeatCode_morph;
  /** @generated */ 
  public String getMorph(int addr) {
        if (featOkTst && casFeat_morph == null)
      jcas.throwFeatMissing("morph", "edu.isistan.uima.unified.typesystems.nlp.Token");
    return ll_cas.ll_getStringValue(addr, casFeatCode_morph);
  }
  /** @generated */    
  public void setMorph(int addr, String v) {
        if (featOkTst && casFeat_morph == null)
      jcas.throwFeatMissing("morph", "edu.isistan.uima.unified.typesystems.nlp.Token");
    ll_cas.ll_setStringValue(addr, casFeatCode_morph, v);}
    
  
 
  /** @generated */
  final Feature casFeat_pos;
  /** @generated */
  final int     casFeatCode_pos;
  /** @generated */ 
  public String getPos(int addr) {
        if (featOkTst && casFeat_pos == null)
      jcas.throwFeatMissing("pos", "edu.isistan.uima.unified.typesystems.nlp.Token");
    return ll_cas.ll_getStringValue(addr, casFeatCode_pos);
  }
  /** @generated */    
  public void setPos(int addr, String v) {
        if (featOkTst && casFeat_pos == null)
      jcas.throwFeatMissing("pos", "edu.isistan.uima.unified.typesystems.nlp.Token");
    ll_cas.ll_setStringValue(addr, casFeatCode_pos, v);}
    
  
 
  /** @generated */
  final Feature casFeat_probability;
  /** @generated */
  final int     casFeatCode_probability;
  /** @generated */ 
  public double getProbability(int addr) {
        if (featOkTst && casFeat_probability == null)
      jcas.throwFeatMissing("probability", "edu.isistan.uima.unified.typesystems.nlp.Token");
    return ll_cas.ll_getDoubleValue(addr, casFeatCode_probability);
  }
  /** @generated */    
  public void setProbability(int addr, double v) {
        if (featOkTst && casFeat_probability == null)
      jcas.throwFeatMissing("probability", "edu.isistan.uima.unified.typesystems.nlp.Token");
    ll_cas.ll_setDoubleValue(addr, casFeatCode_probability, v);}
    
  
 
  /** @generated */
  final Feature casFeat_stopword;
  /** @generated */
  final int     casFeatCode_stopword;
  /** @generated */ 
  public boolean getStopword(int addr) {
        if (featOkTst && casFeat_stopword == null)
      jcas.throwFeatMissing("stopword", "edu.isistan.uima.unified.typesystems.nlp.Token");
    return ll_cas.ll_getBooleanValue(addr, casFeatCode_stopword);
  }
  /** @generated */    
  public void setStopword(int addr, boolean v) {
        if (featOkTst && casFeat_stopword == null)
      jcas.throwFeatMissing("stopword", "edu.isistan.uima.unified.typesystems.nlp.Token");
    ll_cas.ll_setBooleanValue(addr, casFeatCode_stopword, v);}
    
  
 
  /** @generated */
  final Feature casFeat_stem;
  /** @generated */
  final int     casFeatCode_stem;
  /** @generated */ 
  public String getStem(int addr) {
        if (featOkTst && casFeat_stem == null)
      jcas.throwFeatMissing("stem", "edu.isistan.uima.unified.typesystems.nlp.Token");
    return ll_cas.ll_getStringValue(addr, casFeatCode_stem);
  }
  /** @generated */    
  public void setStem(int addr, String v) {
        if (featOkTst && casFeat_stem == null)
      jcas.throwFeatMissing("stem", "edu.isistan.uima.unified.typesystems.nlp.Token");
    ll_cas.ll_setStringValue(addr, casFeatCode_stem, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public Token_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_lemma = jcas.getRequiredFeatureDE(casType, "lemma", "uima.cas.String", featOkTst);
    casFeatCode_lemma  = (null == casFeat_lemma) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_lemma).getCode();

 
    casFeat_morph = jcas.getRequiredFeatureDE(casType, "morph", "uima.cas.String", featOkTst);
    casFeatCode_morph  = (null == casFeat_morph) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_morph).getCode();

 
    casFeat_pos = jcas.getRequiredFeatureDE(casType, "pos", "uima.cas.String", featOkTst);
    casFeatCode_pos  = (null == casFeat_pos) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_pos).getCode();

 
    casFeat_probability = jcas.getRequiredFeatureDE(casType, "probability", "uima.cas.Double", featOkTst);
    casFeatCode_probability  = (null == casFeat_probability) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_probability).getCode();

 
    casFeat_stopword = jcas.getRequiredFeatureDE(casType, "stopword", "uima.cas.Boolean", featOkTst);
    casFeatCode_stopword  = (null == casFeat_stopword) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_stopword).getCode();

 
    casFeat_stem = jcas.getRequiredFeatureDE(casType, "stem", "uima.cas.String", featOkTst);
    casFeatCode_stem  = (null == casFeat_stem) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_stem).getCode();

  }
}



    