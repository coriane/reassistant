
/* First created by JCasGen Fri Mar 11 15:22:30 ART 2011 */
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
 * Updated by JCasGen Fri Mar 11 15:22:30 ART 2011
 * @generated */
public class CoNLLDependency_Type extends IdentifiableAnnotation_Type {
  /** @generated */
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (CoNLLDependency_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = CoNLLDependency_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new CoNLLDependency(addr, CoNLLDependency_Type.this);
  			   CoNLLDependency_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new CoNLLDependency(addr, CoNLLDependency_Type.this);
  	  }
    };
  /** @generated */
  public final static int typeIndexID = CoNLLDependency.typeIndexID;
  /** @generated 
     @modifiable */
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.isistan.uima.unified.typesystems.nlp.CoNLLDependency");
 
  /** @generated */
  final Feature casFeat_relation;
  /** @generated */
  final int     casFeatCode_relation;
  /** @generated */ 
  public String getRelation(int addr) {
        if (featOkTst && casFeat_relation == null)
      jcas.throwFeatMissing("relation", "edu.isistan.uima.unified.typesystems.nlp.CoNLLDependency");
    return ll_cas.ll_getStringValue(addr, casFeatCode_relation);
  }
  /** @generated */    
  public void setRelation(int addr, String v) {
        if (featOkTst && casFeat_relation == null)
      jcas.throwFeatMissing("relation", "edu.isistan.uima.unified.typesystems.nlp.CoNLLDependency");
    ll_cas.ll_setStringValue(addr, casFeatCode_relation, v);}
    
  
 
  /** @generated */
  final Feature casFeat_source;
  /** @generated */
  final int     casFeatCode_source;
  /** @generated */ 
  public int getSource(int addr) {
        if (featOkTst && casFeat_source == null)
      jcas.throwFeatMissing("source", "edu.isistan.uima.unified.typesystems.nlp.CoNLLDependency");
    return ll_cas.ll_getRefValue(addr, casFeatCode_source);
  }
  /** @generated */    
  public void setSource(int addr, int v) {
        if (featOkTst && casFeat_source == null)
      jcas.throwFeatMissing("source", "edu.isistan.uima.unified.typesystems.nlp.CoNLLDependency");
    ll_cas.ll_setRefValue(addr, casFeatCode_source, v);}
    
  
 
  /** @generated */
  final Feature casFeat_target;
  /** @generated */
  final int     casFeatCode_target;
  /** @generated */ 
  public int getTarget(int addr) {
        if (featOkTst && casFeat_target == null)
      jcas.throwFeatMissing("target", "edu.isistan.uima.unified.typesystems.nlp.CoNLLDependency");
    return ll_cas.ll_getRefValue(addr, casFeatCode_target);
  }
  /** @generated */    
  public void setTarget(int addr, int v) {
        if (featOkTst && casFeat_target == null)
      jcas.throwFeatMissing("target", "edu.isistan.uima.unified.typesystems.nlp.CoNLLDependency");
    ll_cas.ll_setRefValue(addr, casFeatCode_target, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public CoNLLDependency_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_relation = jcas.getRequiredFeatureDE(casType, "relation", "uima.cas.String", featOkTst);
    casFeatCode_relation  = (null == casFeat_relation) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_relation).getCode();

 
    casFeat_source = jcas.getRequiredFeatureDE(casType, "source", "edu.isistan.uima.unified.typesystems.nlp.Token", featOkTst);
    casFeatCode_source  = (null == casFeat_source) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_source).getCode();

 
    casFeat_target = jcas.getRequiredFeatureDE(casType, "target", "edu.isistan.uima.unified.typesystems.nlp.Token", featOkTst);
    casFeatCode_target  = (null == casFeat_target) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_target).getCode();

  }
}



    