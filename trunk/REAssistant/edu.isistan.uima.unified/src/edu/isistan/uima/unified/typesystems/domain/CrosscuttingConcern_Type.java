
/* First created by JCasGen Mon Dec 29 18:34:55 ART 2014 */
package edu.isistan.uima.unified.typesystems.domain;

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
public class CrosscuttingConcern_Type extends IdentifiableAnnotation_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (CrosscuttingConcern_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = CrosscuttingConcern_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new CrosscuttingConcern(addr, CrosscuttingConcern_Type.this);
  			   CrosscuttingConcern_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new CrosscuttingConcern(addr, CrosscuttingConcern_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = CrosscuttingConcern.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.isistan.uima.unified.typesystems.domain.CrosscuttingConcern");
 
  /** @generated */
  final Feature casFeat_name;
  /** @generated */
  final int     casFeatCode_name;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getName(int addr) {
        if (featOkTst && casFeat_name == null)
      jcas.throwFeatMissing("name", "edu.isistan.uima.unified.typesystems.domain.CrosscuttingConcern");
    return ll_cas.ll_getStringValue(addr, casFeatCode_name);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setName(int addr, String v) {
        if (featOkTst && casFeat_name == null)
      jcas.throwFeatMissing("name", "edu.isistan.uima.unified.typesystems.domain.CrosscuttingConcern");
    ll_cas.ll_setStringValue(addr, casFeatCode_name, v);}
    
  
 
  /** @generated */
  final Feature casFeat_kind;
  /** @generated */
  final int     casFeatCode_kind;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getKind(int addr) {
        if (featOkTst && casFeat_kind == null)
      jcas.throwFeatMissing("kind", "edu.isistan.uima.unified.typesystems.domain.CrosscuttingConcern");
    return ll_cas.ll_getStringValue(addr, casFeatCode_kind);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setKind(int addr, String v) {
        if (featOkTst && casFeat_kind == null)
      jcas.throwFeatMissing("kind", "edu.isistan.uima.unified.typesystems.domain.CrosscuttingConcern");
    ll_cas.ll_setStringValue(addr, casFeatCode_kind, v);}
    
  
 
  /** @generated */
  final Feature casFeat_sentence;
  /** @generated */
  final int     casFeatCode_sentence;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getSentence(int addr) {
        if (featOkTst && casFeat_sentence == null)
      jcas.throwFeatMissing("sentence", "edu.isistan.uima.unified.typesystems.domain.CrosscuttingConcern");
    return ll_cas.ll_getRefValue(addr, casFeatCode_sentence);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setSentence(int addr, int v) {
        if (featOkTst && casFeat_sentence == null)
      jcas.throwFeatMissing("sentence", "edu.isistan.uima.unified.typesystems.domain.CrosscuttingConcern");
    ll_cas.ll_setRefValue(addr, casFeatCode_sentence, v);}
    
  
 
  /** @generated */
  final Feature casFeat_section;
  /** @generated */
  final int     casFeatCode_section;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getSection(int addr) {
        if (featOkTst && casFeat_section == null)
      jcas.throwFeatMissing("section", "edu.isistan.uima.unified.typesystems.domain.CrosscuttingConcern");
    return ll_cas.ll_getRefValue(addr, casFeatCode_section);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setSection(int addr, int v) {
        if (featOkTst && casFeat_section == null)
      jcas.throwFeatMissing("section", "edu.isistan.uima.unified.typesystems.domain.CrosscuttingConcern");
    ll_cas.ll_setRefValue(addr, casFeatCode_section, v);}
    
  
 
  /** @generated */
  final Feature casFeat_document;
  /** @generated */
  final int     casFeatCode_document;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getDocument(int addr) {
        if (featOkTst && casFeat_document == null)
      jcas.throwFeatMissing("document", "edu.isistan.uima.unified.typesystems.domain.CrosscuttingConcern");
    return ll_cas.ll_getRefValue(addr, casFeatCode_document);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setDocument(int addr, int v) {
        if (featOkTst && casFeat_document == null)
      jcas.throwFeatMissing("document", "edu.isistan.uima.unified.typesystems.domain.CrosscuttingConcern");
    ll_cas.ll_setRefValue(addr, casFeatCode_document, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public CrosscuttingConcern_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_name = jcas.getRequiredFeatureDE(casType, "name", "uima.cas.String", featOkTst);
    casFeatCode_name  = (null == casFeat_name) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_name).getCode();

 
    casFeat_kind = jcas.getRequiredFeatureDE(casType, "kind", "uima.cas.String", featOkTst);
    casFeatCode_kind  = (null == casFeat_kind) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_kind).getCode();

 
    casFeat_sentence = jcas.getRequiredFeatureDE(casType, "sentence", "edu.isistan.uima.unified.typesystems.nlp.Sentence", featOkTst);
    casFeatCode_sentence  = (null == casFeat_sentence) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_sentence).getCode();

 
    casFeat_section = jcas.getRequiredFeatureDE(casType, "section", "edu.isistan.uima.unified.typesystems.srs.Section", featOkTst);
    casFeatCode_section  = (null == casFeat_section) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_section).getCode();

 
    casFeat_document = jcas.getRequiredFeatureDE(casType, "document", "edu.isistan.uima.unified.typesystems.srs.Document", featOkTst);
    casFeatCode_document  = (null == casFeat_document) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_document).getCode();

  }
}



    