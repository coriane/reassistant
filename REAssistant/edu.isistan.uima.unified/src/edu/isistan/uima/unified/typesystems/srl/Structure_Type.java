
/* First created by JCasGen Mon Dec 29 18:34:55 ART 2014 */
package edu.isistan.uima.unified.typesystems.srl;

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
public class Structure_Type extends IdentifiableAnnotation_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Structure_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Structure_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Structure(addr, Structure_Type.this);
  			   Structure_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Structure(addr, Structure_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Structure.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.isistan.uima.unified.typesystems.srl.Structure");
 
  /** @generated */
  final Feature casFeat_subject;
  /** @generated */
  final int     casFeatCode_subject;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getSubject(int addr) {
        if (featOkTst && casFeat_subject == null)
      jcas.throwFeatMissing("subject", "edu.isistan.uima.unified.typesystems.srl.Structure");
    return ll_cas.ll_getRefValue(addr, casFeatCode_subject);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setSubject(int addr, int v) {
        if (featOkTst && casFeat_subject == null)
      jcas.throwFeatMissing("subject", "edu.isistan.uima.unified.typesystems.srl.Structure");
    ll_cas.ll_setRefValue(addr, casFeatCode_subject, v);}
    
  
 
  /** @generated */
  final Feature casFeat_verb;
  /** @generated */
  final int     casFeatCode_verb;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getVerb(int addr) {
        if (featOkTst && casFeat_verb == null)
      jcas.throwFeatMissing("verb", "edu.isistan.uima.unified.typesystems.srl.Structure");
    return ll_cas.ll_getRefValue(addr, casFeatCode_verb);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setVerb(int addr, int v) {
        if (featOkTst && casFeat_verb == null)
      jcas.throwFeatMissing("verb", "edu.isistan.uima.unified.typesystems.srl.Structure");
    ll_cas.ll_setRefValue(addr, casFeatCode_verb, v);}
    
  
 
  /** @generated */
  final Feature casFeat_directObject;
  /** @generated */
  final int     casFeatCode_directObject;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getDirectObject(int addr) {
        if (featOkTst && casFeat_directObject == null)
      jcas.throwFeatMissing("directObject", "edu.isistan.uima.unified.typesystems.srl.Structure");
    return ll_cas.ll_getRefValue(addr, casFeatCode_directObject);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setDirectObject(int addr, int v) {
        if (featOkTst && casFeat_directObject == null)
      jcas.throwFeatMissing("directObject", "edu.isistan.uima.unified.typesystems.srl.Structure");
    ll_cas.ll_setRefValue(addr, casFeatCode_directObject, v);}
    
  
 
  /** @generated */
  final Feature casFeat_indirectObject;
  /** @generated */
  final int     casFeatCode_indirectObject;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getIndirectObject(int addr) {
        if (featOkTst && casFeat_indirectObject == null)
      jcas.throwFeatMissing("indirectObject", "edu.isistan.uima.unified.typesystems.srl.Structure");
    return ll_cas.ll_getRefValue(addr, casFeatCode_indirectObject);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setIndirectObject(int addr, int v) {
        if (featOkTst && casFeat_indirectObject == null)
      jcas.throwFeatMissing("indirectObject", "edu.isistan.uima.unified.typesystems.srl.Structure");
    ll_cas.ll_setRefValue(addr, casFeatCode_indirectObject, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public Structure_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_subject = jcas.getRequiredFeatureDE(casType, "subject", "edu.isistan.uima.unified.typesystems.srl.Role", featOkTst);
    casFeatCode_subject  = (null == casFeat_subject) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_subject).getCode();

 
    casFeat_verb = jcas.getRequiredFeatureDE(casType, "verb", "edu.isistan.uima.unified.typesystems.srl.Role", featOkTst);
    casFeatCode_verb  = (null == casFeat_verb) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_verb).getCode();

 
    casFeat_directObject = jcas.getRequiredFeatureDE(casType, "directObject", "edu.isistan.uima.unified.typesystems.srl.Role", featOkTst);
    casFeatCode_directObject  = (null == casFeat_directObject) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_directObject).getCode();

 
    casFeat_indirectObject = jcas.getRequiredFeatureDE(casType, "indirectObject", "edu.isistan.uima.unified.typesystems.srl.Role", featOkTst);
    casFeatCode_indirectObject  = (null == casFeat_indirectObject) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_indirectObject).getCode();

  }
}



    