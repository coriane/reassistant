
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
public class Predicate_Type extends IdentifiableAnnotation_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Predicate_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Predicate_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Predicate(addr, Predicate_Type.this);
  			   Predicate_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Predicate(addr, Predicate_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Predicate.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.isistan.uima.unified.typesystems.srl.Predicate");
 
  /** @generated */
  final Feature casFeat_label;
  /** @generated */
  final int     casFeatCode_label;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getLabel(int addr) {
        if (featOkTst && casFeat_label == null)
      jcas.throwFeatMissing("label", "edu.isistan.uima.unified.typesystems.srl.Predicate");
    return ll_cas.ll_getStringValue(addr, casFeatCode_label);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setLabel(int addr, String v) {
        if (featOkTst && casFeat_label == null)
      jcas.throwFeatMissing("label", "edu.isistan.uima.unified.typesystems.srl.Predicate");
    ll_cas.ll_setStringValue(addr, casFeatCode_label, v);}
    
  
 
  /** @generated */
  final Feature casFeat_description;
  /** @generated */
  final int     casFeatCode_description;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getDescription(int addr) {
        if (featOkTst && casFeat_description == null)
      jcas.throwFeatMissing("description", "edu.isistan.uima.unified.typesystems.srl.Predicate");
    return ll_cas.ll_getStringValue(addr, casFeatCode_description);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setDescription(int addr, String v) {
        if (featOkTst && casFeat_description == null)
      jcas.throwFeatMissing("description", "edu.isistan.uima.unified.typesystems.srl.Predicate");
    ll_cas.ll_setStringValue(addr, casFeatCode_description, v);}
    
  
 
  /** @generated */
  final Feature casFeat_root;
  /** @generated */
  final int     casFeatCode_root;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getRoot(int addr) {
        if (featOkTst && casFeat_root == null)
      jcas.throwFeatMissing("root", "edu.isistan.uima.unified.typesystems.srl.Predicate");
    return ll_cas.ll_getRefValue(addr, casFeatCode_root);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setRoot(int addr, int v) {
        if (featOkTst && casFeat_root == null)
      jcas.throwFeatMissing("root", "edu.isistan.uima.unified.typesystems.srl.Predicate");
    ll_cas.ll_setRefValue(addr, casFeatCode_root, v);}
    
  
 
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
      jcas.throwFeatMissing("kind", "edu.isistan.uima.unified.typesystems.srl.Predicate");
    return ll_cas.ll_getStringValue(addr, casFeatCode_kind);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setKind(int addr, String v) {
        if (featOkTst && casFeat_kind == null)
      jcas.throwFeatMissing("kind", "edu.isistan.uima.unified.typesystems.srl.Predicate");
    ll_cas.ll_setStringValue(addr, casFeatCode_kind, v);}
    
  
 
  /** @generated */
  final Feature casFeat_passiveVoice;
  /** @generated */
  final int     casFeatCode_passiveVoice;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public boolean getPassiveVoice(int addr) {
        if (featOkTst && casFeat_passiveVoice == null)
      jcas.throwFeatMissing("passiveVoice", "edu.isistan.uima.unified.typesystems.srl.Predicate");
    return ll_cas.ll_getBooleanValue(addr, casFeatCode_passiveVoice);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setPassiveVoice(int addr, boolean v) {
        if (featOkTst && casFeat_passiveVoice == null)
      jcas.throwFeatMissing("passiveVoice", "edu.isistan.uima.unified.typesystems.srl.Predicate");
    ll_cas.ll_setBooleanValue(addr, casFeatCode_passiveVoice, v);}
    
  
 
  /** @generated */
  final Feature casFeat_arguments;
  /** @generated */
  final int     casFeatCode_arguments;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getArguments(int addr) {
        if (featOkTst && casFeat_arguments == null)
      jcas.throwFeatMissing("arguments", "edu.isistan.uima.unified.typesystems.srl.Predicate");
    return ll_cas.ll_getRefValue(addr, casFeatCode_arguments);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setArguments(int addr, int v) {
        if (featOkTst && casFeat_arguments == null)
      jcas.throwFeatMissing("arguments", "edu.isistan.uima.unified.typesystems.srl.Predicate");
    ll_cas.ll_setRefValue(addr, casFeatCode_arguments, v);}
    
   /** @generated
   * @param addr low level Feature Structure reference
   * @param i index of item in the array
   * @return value at index i in the array 
   */
  public int getArguments(int addr, int i) {
        if (featOkTst && casFeat_arguments == null)
      jcas.throwFeatMissing("arguments", "edu.isistan.uima.unified.typesystems.srl.Predicate");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_arguments), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_arguments), i);
  return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_arguments), i);
  }
   
  /** @generated
   * @param addr low level Feature Structure reference
   * @param i index of item in the array
   * @param v value to set
   */ 
  public void setArguments(int addr, int i, int v) {
        if (featOkTst && casFeat_arguments == null)
      jcas.throwFeatMissing("arguments", "edu.isistan.uima.unified.typesystems.srl.Predicate");
    if (lowLevelTypeChecks)
      ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_arguments), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_arguments), i);
    ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_arguments), i, v);
  }
 



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public Predicate_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_label = jcas.getRequiredFeatureDE(casType, "label", "uima.cas.String", featOkTst);
    casFeatCode_label  = (null == casFeat_label) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_label).getCode();

 
    casFeat_description = jcas.getRequiredFeatureDE(casType, "description", "uima.cas.String", featOkTst);
    casFeatCode_description  = (null == casFeat_description) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_description).getCode();

 
    casFeat_root = jcas.getRequiredFeatureDE(casType, "root", "edu.isistan.uima.unified.typesystems.nlp.Token", featOkTst);
    casFeatCode_root  = (null == casFeat_root) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_root).getCode();

 
    casFeat_kind = jcas.getRequiredFeatureDE(casType, "kind", "uima.cas.String", featOkTst);
    casFeatCode_kind  = (null == casFeat_kind) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_kind).getCode();

 
    casFeat_passiveVoice = jcas.getRequiredFeatureDE(casType, "passiveVoice", "uima.cas.Boolean", featOkTst);
    casFeatCode_passiveVoice  = (null == casFeat_passiveVoice) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_passiveVoice).getCode();

 
    casFeat_arguments = jcas.getRequiredFeatureDE(casType, "arguments", "uima.cas.FSArray", featOkTst);
    casFeatCode_arguments  = (null == casFeat_arguments) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_arguments).getCode();

  }
}



    