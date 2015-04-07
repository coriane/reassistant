
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
public class DomainAction_Type extends IdentifiableAnnotation_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (DomainAction_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = DomainAction_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new DomainAction(addr, DomainAction_Type.this);
  			   DomainAction_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new DomainAction(addr, DomainAction_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = DomainAction.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.isistan.uima.unified.typesystems.domain.DomainAction");
 
  /** @generated */
  final Feature casFeat_action;
  /** @generated */
  final int     casFeatCode_action;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getAction(int addr) {
        if (featOkTst && casFeat_action == null)
      jcas.throwFeatMissing("action", "edu.isistan.uima.unified.typesystems.domain.DomainAction");
    return ll_cas.ll_getRefValue(addr, casFeatCode_action);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setAction(int addr, int v) {
        if (featOkTst && casFeat_action == null)
      jcas.throwFeatMissing("action", "edu.isistan.uima.unified.typesystems.domain.DomainAction");
    ll_cas.ll_setRefValue(addr, casFeatCode_action, v);}
    
  
 
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
      jcas.throwFeatMissing("label", "edu.isistan.uima.unified.typesystems.domain.DomainAction");
    return ll_cas.ll_getStringValue(addr, casFeatCode_label);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setLabel(int addr, String v) {
        if (featOkTst && casFeat_label == null)
      jcas.throwFeatMissing("label", "edu.isistan.uima.unified.typesystems.domain.DomainAction");
    ll_cas.ll_setStringValue(addr, casFeatCode_label, v);}
    
  
 
  /** @generated */
  final Feature casFeat_confidence;
  /** @generated */
  final int     casFeatCode_confidence;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public double getConfidence(int addr) {
        if (featOkTst && casFeat_confidence == null)
      jcas.throwFeatMissing("confidence", "edu.isistan.uima.unified.typesystems.domain.DomainAction");
    return ll_cas.ll_getDoubleValue(addr, casFeatCode_confidence);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setConfidence(int addr, double v) {
        if (featOkTst && casFeat_confidence == null)
      jcas.throwFeatMissing("confidence", "edu.isistan.uima.unified.typesystems.domain.DomainAction");
    ll_cas.ll_setDoubleValue(addr, casFeatCode_confidence, v);}
    
  
 
  /** @generated */
  final Feature casFeat_ranking;
  /** @generated */
  final int     casFeatCode_ranking;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getRanking(int addr) {
        if (featOkTst && casFeat_ranking == null)
      jcas.throwFeatMissing("ranking", "edu.isistan.uima.unified.typesystems.domain.DomainAction");
    return ll_cas.ll_getIntValue(addr, casFeatCode_ranking);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setRanking(int addr, int v) {
        if (featOkTst && casFeat_ranking == null)
      jcas.throwFeatMissing("ranking", "edu.isistan.uima.unified.typesystems.domain.DomainAction");
    ll_cas.ll_setIntValue(addr, casFeatCode_ranking, v);}
    
  
 
  /** @generated */
  final Feature casFeat_parent;
  /** @generated */
  final int     casFeatCode_parent;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getParent(int addr) {
        if (featOkTst && casFeat_parent == null)
      jcas.throwFeatMissing("parent", "edu.isistan.uima.unified.typesystems.domain.DomainAction");
    return ll_cas.ll_getRefValue(addr, casFeatCode_parent);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setParent(int addr, int v) {
        if (featOkTst && casFeat_parent == null)
      jcas.throwFeatMissing("parent", "edu.isistan.uima.unified.typesystems.domain.DomainAction");
    ll_cas.ll_setRefValue(addr, casFeatCode_parent, v);}
    
  
 
  /** @generated */
  final Feature casFeat_childs;
  /** @generated */
  final int     casFeatCode_childs;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getChilds(int addr) {
        if (featOkTst && casFeat_childs == null)
      jcas.throwFeatMissing("childs", "edu.isistan.uima.unified.typesystems.domain.DomainAction");
    return ll_cas.ll_getRefValue(addr, casFeatCode_childs);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setChilds(int addr, int v) {
        if (featOkTst && casFeat_childs == null)
      jcas.throwFeatMissing("childs", "edu.isistan.uima.unified.typesystems.domain.DomainAction");
    ll_cas.ll_setRefValue(addr, casFeatCode_childs, v);}
    
   /** @generated
   * @param addr low level Feature Structure reference
   * @param i index of item in the array
   * @return value at index i in the array 
   */
  public int getChilds(int addr, int i) {
        if (featOkTst && casFeat_childs == null)
      jcas.throwFeatMissing("childs", "edu.isistan.uima.unified.typesystems.domain.DomainAction");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_childs), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_childs), i);
  return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_childs), i);
  }
   
  /** @generated
   * @param addr low level Feature Structure reference
   * @param i index of item in the array
   * @param v value to set
   */ 
  public void setChilds(int addr, int i, int v) {
        if (featOkTst && casFeat_childs == null)
      jcas.throwFeatMissing("childs", "edu.isistan.uima.unified.typesystems.domain.DomainAction");
    if (lowLevelTypeChecks)
      ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_childs), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_childs), i);
    ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_childs), i, v);
  }
 



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public DomainAction_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_action = jcas.getRequiredFeatureDE(casType, "action", "edu.isistan.uima.unified.typesystems.nlp.Token", featOkTst);
    casFeatCode_action  = (null == casFeat_action) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_action).getCode();

 
    casFeat_label = jcas.getRequiredFeatureDE(casType, "label", "uima.cas.String", featOkTst);
    casFeatCode_label  = (null == casFeat_label) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_label).getCode();

 
    casFeat_confidence = jcas.getRequiredFeatureDE(casType, "confidence", "uima.cas.Double", featOkTst);
    casFeatCode_confidence  = (null == casFeat_confidence) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_confidence).getCode();

 
    casFeat_ranking = jcas.getRequiredFeatureDE(casType, "ranking", "uima.cas.Integer", featOkTst);
    casFeatCode_ranking  = (null == casFeat_ranking) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_ranking).getCode();

 
    casFeat_parent = jcas.getRequiredFeatureDE(casType, "parent", "edu.isistan.uima.unified.typesystems.domain.DomainAction", featOkTst);
    casFeatCode_parent  = (null == casFeat_parent) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_parent).getCode();

 
    casFeat_childs = jcas.getRequiredFeatureDE(casType, "childs", "uima.cas.FSArray", featOkTst);
    casFeatCode_childs  = (null == casFeat_childs) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_childs).getCode();

  }
}



    