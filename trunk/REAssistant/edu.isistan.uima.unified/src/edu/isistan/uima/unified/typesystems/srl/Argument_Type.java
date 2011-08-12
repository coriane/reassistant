
/* First created by JCasGen Fri Mar 11 15:22:48 ART 2011 */
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
 * Updated by JCasGen Fri Aug 12 18:17:39 ART 2011
 * @generated */
public class Argument_Type extends IdentifiableAnnotation_Type {
  /** @generated */
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Argument_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Argument_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Argument(addr, Argument_Type.this);
  			   Argument_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Argument(addr, Argument_Type.this);
  	  }
    };
  /** @generated */
  public final static int typeIndexID = Argument.typeIndexID;
  /** @generated 
     @modifiable */
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.isistan.uima.unified.typesystems.srl.Argument");
 
  /** @generated */
  final Feature casFeat_label;
  /** @generated */
  final int     casFeatCode_label;
  /** @generated */ 
  public String getLabel(int addr) {
        if (featOkTst && casFeat_label == null)
      jcas.throwFeatMissing("label", "edu.isistan.uima.unified.typesystems.srl.Argument");
    return ll_cas.ll_getStringValue(addr, casFeatCode_label);
  }
  /** @generated */    
  public void setLabel(int addr, String v) {
        if (featOkTst && casFeat_label == null)
      jcas.throwFeatMissing("label", "edu.isistan.uima.unified.typesystems.srl.Argument");
    ll_cas.ll_setStringValue(addr, casFeatCode_label, v);}
    
  
 
  /** @generated */
  final Feature casFeat_description;
  /** @generated */
  final int     casFeatCode_description;
  /** @generated */ 
  public String getDescription(int addr) {
        if (featOkTst && casFeat_description == null)
      jcas.throwFeatMissing("description", "edu.isistan.uima.unified.typesystems.srl.Argument");
    return ll_cas.ll_getStringValue(addr, casFeatCode_description);
  }
  /** @generated */    
  public void setDescription(int addr, String v) {
        if (featOkTst && casFeat_description == null)
      jcas.throwFeatMissing("description", "edu.isistan.uima.unified.typesystems.srl.Argument");
    ll_cas.ll_setStringValue(addr, casFeatCode_description, v);}
    
  
 
  /** @generated */
  final Feature casFeat_root;
  /** @generated */
  final int     casFeatCode_root;
  /** @generated */ 
  public int getRoot(int addr) {
        if (featOkTst && casFeat_root == null)
      jcas.throwFeatMissing("root", "edu.isistan.uima.unified.typesystems.srl.Argument");
    return ll_cas.ll_getRefValue(addr, casFeatCode_root);
  }
  /** @generated */    
  public void setRoot(int addr, int v) {
        if (featOkTst && casFeat_root == null)
      jcas.throwFeatMissing("root", "edu.isistan.uima.unified.typesystems.srl.Argument");
    ll_cas.ll_setRefValue(addr, casFeatCode_root, v);}
    
  
 
  /** @generated */
  final Feature casFeat_yield;
  /** @generated */
  final int     casFeatCode_yield;
  /** @generated */ 
  public int getYield(int addr) {
        if (featOkTst && casFeat_yield == null)
      jcas.throwFeatMissing("yield", "edu.isistan.uima.unified.typesystems.srl.Argument");
    return ll_cas.ll_getRefValue(addr, casFeatCode_yield);
  }
  /** @generated */    
  public void setYield(int addr, int v) {
        if (featOkTst && casFeat_yield == null)
      jcas.throwFeatMissing("yield", "edu.isistan.uima.unified.typesystems.srl.Argument");
    ll_cas.ll_setRefValue(addr, casFeatCode_yield, v);}
    
   /** @generated */
  public int getYield(int addr, int i) {
        if (featOkTst && casFeat_yield == null)
      jcas.throwFeatMissing("yield", "edu.isistan.uima.unified.typesystems.srl.Argument");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_yield), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_yield), i);
  return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_yield), i);
  }
   
  /** @generated */ 
  public void setYield(int addr, int i, int v) {
        if (featOkTst && casFeat_yield == null)
      jcas.throwFeatMissing("yield", "edu.isistan.uima.unified.typesystems.srl.Argument");
    if (lowLevelTypeChecks)
      ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_yield), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_yield), i);
    ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_yield), i, v);
  }
 



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public Argument_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_label = jcas.getRequiredFeatureDE(casType, "label", "uima.cas.String", featOkTst);
    casFeatCode_label  = (null == casFeat_label) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_label).getCode();

 
    casFeat_description = jcas.getRequiredFeatureDE(casType, "description", "uima.cas.String", featOkTst);
    casFeatCode_description  = (null == casFeat_description) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_description).getCode();

 
    casFeat_root = jcas.getRequiredFeatureDE(casType, "root", "edu.isistan.uima.unified.typesystems.nlp.Token", featOkTst);
    casFeatCode_root  = (null == casFeat_root) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_root).getCode();

 
    casFeat_yield = jcas.getRequiredFeatureDE(casType, "yield", "uima.cas.FSArray", featOkTst);
    casFeatCode_yield  = (null == casFeat_yield) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_yield).getCode();

  }
}



    