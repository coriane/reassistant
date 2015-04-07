
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
public class DomainActor_Type extends IdentifiableAnnotation_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (DomainActor_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = DomainActor_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new DomainActor(addr, DomainActor_Type.this);
  			   DomainActor_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new DomainActor(addr, DomainActor_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = DomainActor.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.isistan.uima.unified.typesystems.domain.DomainActor");
 
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
      jcas.throwFeatMissing("kind", "edu.isistan.uima.unified.typesystems.domain.DomainActor");
    return ll_cas.ll_getStringValue(addr, casFeatCode_kind);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setKind(int addr, String v) {
        if (featOkTst && casFeat_kind == null)
      jcas.throwFeatMissing("kind", "edu.isistan.uima.unified.typesystems.domain.DomainActor");
    ll_cas.ll_setStringValue(addr, casFeatCode_kind, v);}
    
  
 
  /** @generated */
  final Feature casFeat_role;
  /** @generated */
  final int     casFeatCode_role;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getRole(int addr) {
        if (featOkTst && casFeat_role == null)
      jcas.throwFeatMissing("role", "edu.isistan.uima.unified.typesystems.domain.DomainActor");
    return ll_cas.ll_getStringValue(addr, casFeatCode_role);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setRole(int addr, String v) {
        if (featOkTst && casFeat_role == null)
      jcas.throwFeatMissing("role", "edu.isistan.uima.unified.typesystems.domain.DomainActor");
    ll_cas.ll_setStringValue(addr, casFeatCode_role, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public DomainActor_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_kind = jcas.getRequiredFeatureDE(casType, "kind", "uima.cas.String", featOkTst);
    casFeatCode_kind  = (null == casFeat_kind) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_kind).getCode();

 
    casFeat_role = jcas.getRequiredFeatureDE(casType, "role", "uima.cas.String", featOkTst);
    casFeatCode_role  = (null == casFeat_role) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_role).getCode();

  }
}



    