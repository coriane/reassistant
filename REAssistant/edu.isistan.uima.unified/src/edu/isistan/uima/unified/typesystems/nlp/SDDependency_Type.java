
/* First created by JCasGen Fri Mar 11 15:22:43 ART 2011 */
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
 * Updated by JCasGen Fri Mar 11 15:22:43 ART 2011
 * @generated */
public class SDDependency_Type extends IdentifiableAnnotation_Type {
  /** @generated */
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (SDDependency_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = SDDependency_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new SDDependency(addr, SDDependency_Type.this);
  			   SDDependency_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new SDDependency(addr, SDDependency_Type.this);
  	  }
    };
  /** @generated */
  public final static int typeIndexID = SDDependency.typeIndexID;
  /** @generated 
     @modifiable */
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.isistan.uima.unified.typesystems.nlp.SDDependency");
 
  /** @generated */
  final Feature casFeat_relation;
  /** @generated */
  final int     casFeatCode_relation;
  /** @generated */ 
  public String getRelation(int addr) {
        if (featOkTst && casFeat_relation == null)
      jcas.throwFeatMissing("relation", "edu.isistan.uima.unified.typesystems.nlp.SDDependency");
    return ll_cas.ll_getStringValue(addr, casFeatCode_relation);
  }
  /** @generated */    
  public void setRelation(int addr, String v) {
        if (featOkTst && casFeat_relation == null)
      jcas.throwFeatMissing("relation", "edu.isistan.uima.unified.typesystems.nlp.SDDependency");
    ll_cas.ll_setStringValue(addr, casFeatCode_relation, v);}
    
  
 
  /** @generated */
  final Feature casFeat_gov;
  /** @generated */
  final int     casFeatCode_gov;
  /** @generated */ 
  public int getGov(int addr) {
        if (featOkTst && casFeat_gov == null)
      jcas.throwFeatMissing("gov", "edu.isistan.uima.unified.typesystems.nlp.SDDependency");
    return ll_cas.ll_getRefValue(addr, casFeatCode_gov);
  }
  /** @generated */    
  public void setGov(int addr, int v) {
        if (featOkTst && casFeat_gov == null)
      jcas.throwFeatMissing("gov", "edu.isistan.uima.unified.typesystems.nlp.SDDependency");
    ll_cas.ll_setRefValue(addr, casFeatCode_gov, v);}
    
  
 
  /** @generated */
  final Feature casFeat_dep;
  /** @generated */
  final int     casFeatCode_dep;
  /** @generated */ 
  public int getDep(int addr) {
        if (featOkTst && casFeat_dep == null)
      jcas.throwFeatMissing("dep", "edu.isistan.uima.unified.typesystems.nlp.SDDependency");
    return ll_cas.ll_getRefValue(addr, casFeatCode_dep);
  }
  /** @generated */    
  public void setDep(int addr, int v) {
        if (featOkTst && casFeat_dep == null)
      jcas.throwFeatMissing("dep", "edu.isistan.uima.unified.typesystems.nlp.SDDependency");
    ll_cas.ll_setRefValue(addr, casFeatCode_dep, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public SDDependency_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_relation = jcas.getRequiredFeatureDE(casType, "relation", "uima.cas.String", featOkTst);
    casFeatCode_relation  = (null == casFeat_relation) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_relation).getCode();

 
    casFeat_gov = jcas.getRequiredFeatureDE(casType, "gov", "edu.isistan.uima.unified.typesystems.nlp.Token", featOkTst);
    casFeatCode_gov  = (null == casFeat_gov) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_gov).getCode();

 
    casFeat_dep = jcas.getRequiredFeatureDE(casType, "dep", "edu.isistan.uima.unified.typesystems.nlp.Token", featOkTst);
    casFeatCode_dep  = (null == casFeat_dep) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_dep).getCode();

  }
}



    