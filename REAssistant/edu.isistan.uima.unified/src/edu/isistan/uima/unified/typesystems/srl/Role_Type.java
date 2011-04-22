
/* First created by JCasGen Mon Mar 14 19:00:43 ART 2011 */
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
 * Updated by JCasGen Mon Mar 14 19:00:52 ART 2011
 * @generated */
public class Role_Type extends IdentifiableAnnotation_Type {
  /** @generated */
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
  public final static int typeIndexID = Role.typeIndexID;
  /** @generated 
     @modifiable */
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.isistan.uima.unified.typesystems.srl.Role");
 
  /** @generated */
  final Feature casFeat_kind;
  /** @generated */
  final int     casFeatCode_kind;
  /** @generated */ 
  public String getKind(int addr) {
        if (featOkTst && casFeat_kind == null)
      jcas.throwFeatMissing("kind", "edu.isistan.uima.unified.typesystems.srl.Role");
    return ll_cas.ll_getStringValue(addr, casFeatCode_kind);
  }
  /** @generated */    
  public void setKind(int addr, String v) {
        if (featOkTst && casFeat_kind == null)
      jcas.throwFeatMissing("kind", "edu.isistan.uima.unified.typesystems.srl.Role");
    ll_cas.ll_setStringValue(addr, casFeatCode_kind, v);}
    
  
 
  /** @generated */
  final Feature casFeat_descriptions;
  /** @generated */
  final int     casFeatCode_descriptions;
  /** @generated */ 
  public int getDescriptions(int addr) {
        if (featOkTst && casFeat_descriptions == null)
      jcas.throwFeatMissing("descriptions", "edu.isistan.uima.unified.typesystems.srl.Role");
    return ll_cas.ll_getRefValue(addr, casFeatCode_descriptions);
  }
  /** @generated */    
  public void setDescriptions(int addr, int v) {
        if (featOkTst && casFeat_descriptions == null)
      jcas.throwFeatMissing("descriptions", "edu.isistan.uima.unified.typesystems.srl.Role");
    ll_cas.ll_setRefValue(addr, casFeatCode_descriptions, v);}
    
   /** @generated */
  public String getDescriptions(int addr, int i) {
        if (featOkTst && casFeat_descriptions == null)
      jcas.throwFeatMissing("descriptions", "edu.isistan.uima.unified.typesystems.srl.Role");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_descriptions), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_descriptions), i);
  return ll_cas.ll_getStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_descriptions), i);
  }
   
  /** @generated */ 
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
  /** @generated */ 
  public int getOcurrencies(int addr) {
        if (featOkTst && casFeat_ocurrencies == null)
      jcas.throwFeatMissing("ocurrencies", "edu.isistan.uima.unified.typesystems.srl.Role");
    return ll_cas.ll_getRefValue(addr, casFeatCode_ocurrencies);
  }
  /** @generated */    
  public void setOcurrencies(int addr, int v) {
        if (featOkTst && casFeat_ocurrencies == null)
      jcas.throwFeatMissing("ocurrencies", "edu.isistan.uima.unified.typesystems.srl.Role");
    ll_cas.ll_setRefValue(addr, casFeatCode_ocurrencies, v);}
    
   /** @generated */
  public int getOcurrencies(int addr, int i) {
        if (featOkTst && casFeat_ocurrencies == null)
      jcas.throwFeatMissing("ocurrencies", "edu.isistan.uima.unified.typesystems.srl.Role");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_ocurrencies), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_ocurrencies), i);
  return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_ocurrencies), i);
  }
   
  /** @generated */ 
  public void setOcurrencies(int addr, int i, int v) {
        if (featOkTst && casFeat_ocurrencies == null)
      jcas.throwFeatMissing("ocurrencies", "edu.isistan.uima.unified.typesystems.srl.Role");
    if (lowLevelTypeChecks)
      ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_ocurrencies), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_ocurrencies), i);
    ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_ocurrencies), i, v);
  }
 



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
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



    