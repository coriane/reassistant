
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
public class Role_Type extends IdentifiableAnnotation_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Role_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Role_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Role(addr, Role_Type.this);
  			   Role_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Role(addr, Role_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Role.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.isistan.uima.unified.typesystems.srl.Role");
 
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
      jcas.throwFeatMissing("kind", "edu.isistan.uima.unified.typesystems.srl.Role");
    return ll_cas.ll_getStringValue(addr, casFeatCode_kind);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setKind(int addr, String v) {
        if (featOkTst && casFeat_kind == null)
      jcas.throwFeatMissing("kind", "edu.isistan.uima.unified.typesystems.srl.Role");
    ll_cas.ll_setStringValue(addr, casFeatCode_kind, v);}
    
  
 
  /** @generated */
  final Feature casFeat_descriptions;
  /** @generated */
  final int     casFeatCode_descriptions;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getDescriptions(int addr) {
        if (featOkTst && casFeat_descriptions == null)
      jcas.throwFeatMissing("descriptions", "edu.isistan.uima.unified.typesystems.srl.Role");
    return ll_cas.ll_getRefValue(addr, casFeatCode_descriptions);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setDescriptions(int addr, int v) {
        if (featOkTst && casFeat_descriptions == null)
      jcas.throwFeatMissing("descriptions", "edu.isistan.uima.unified.typesystems.srl.Role");
    ll_cas.ll_setRefValue(addr, casFeatCode_descriptions, v);}
    
   /** @generated
   * @param addr low level Feature Structure reference
   * @param i index of item in the array
   * @return value at index i in the array 
   */
  public String getDescriptions(int addr, int i) {
        if (featOkTst && casFeat_descriptions == null)
      jcas.throwFeatMissing("descriptions", "edu.isistan.uima.unified.typesystems.srl.Role");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_descriptions), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_descriptions), i);
  return ll_cas.ll_getStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_descriptions), i);
  }
   
  /** @generated
   * @param addr low level Feature Structure reference
   * @param i index of item in the array
   * @param v value to set
   */ 
  public void setDescriptions(int addr, int i, String v) {
        if (featOkTst && casFeat_descriptions == null)
      jcas.throwFeatMissing("descriptions", "edu.isistan.uima.unified.typesystems.srl.Role");
    if (lowLevelTypeChecks)
      ll_cas.ll_setStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_descriptions), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_descriptions), i);
    ll_cas.ll_setStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_descriptions), i, v);
  }
 
 
  /** @generated */
  final Feature casFeat_ocurrencies;
  /** @generated */
  final int     casFeatCode_ocurrencies;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getOcurrencies(int addr) {
        if (featOkTst && casFeat_ocurrencies == null)
      jcas.throwFeatMissing("ocurrencies", "edu.isistan.uima.unified.typesystems.srl.Role");
    return ll_cas.ll_getRefValue(addr, casFeatCode_ocurrencies);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setOcurrencies(int addr, int v) {
        if (featOkTst && casFeat_ocurrencies == null)
      jcas.throwFeatMissing("ocurrencies", "edu.isistan.uima.unified.typesystems.srl.Role");
    ll_cas.ll_setRefValue(addr, casFeatCode_ocurrencies, v);}
    
   /** @generated
   * @param addr low level Feature Structure reference
   * @param i index of item in the array
   * @return value at index i in the array 
   */
  public int getOcurrencies(int addr, int i) {
        if (featOkTst && casFeat_ocurrencies == null)
      jcas.throwFeatMissing("ocurrencies", "edu.isistan.uima.unified.typesystems.srl.Role");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_ocurrencies), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_ocurrencies), i);
  return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_ocurrencies), i);
  }
   
  /** @generated
   * @param addr low level Feature Structure reference
   * @param i index of item in the array
   * @param v value to set
   */ 
  public void setOcurrencies(int addr, int i, int v) {
        if (featOkTst && casFeat_ocurrencies == null)
      jcas.throwFeatMissing("ocurrencies", "edu.isistan.uima.unified.typesystems.srl.Role");
    if (lowLevelTypeChecks)
      ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_ocurrencies), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_ocurrencies), i);
    ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_ocurrencies), i, v);
  }
 



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public Role_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_kind = jcas.getRequiredFeatureDE(casType, "kind", "uima.cas.String", featOkTst);
    casFeatCode_kind  = (null == casFeat_kind) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_kind).getCode();

 
    casFeat_descriptions = jcas.getRequiredFeatureDE(casType, "descriptions", "uima.cas.StringArray", featOkTst);
    casFeatCode_descriptions  = (null == casFeat_descriptions) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_descriptions).getCode();

 
    casFeat_ocurrencies = jcas.getRequiredFeatureDE(casType, "ocurrencies", "uima.cas.FSArray", featOkTst);
    casFeatCode_ocurrencies  = (null == casFeat_ocurrencies) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_ocurrencies).getCode();

  }
}



    