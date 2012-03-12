
/* First created by JCasGen Fri Mar 11 15:22:16 ART 2011 */
package edu.isistan.uima.unified.typesystems;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.tcas.Annotation_Type;

/** 
 * Updated by JCasGen Sat Dec 10 16:39:00 ART 2011
 * @generated */
public class IdentifiableAnnotation_Type extends Annotation_Type {
  /** @generated */
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (IdentifiableAnnotation_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = IdentifiableAnnotation_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new IdentifiableAnnotation(addr, IdentifiableAnnotation_Type.this);
  			   IdentifiableAnnotation_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new IdentifiableAnnotation(addr, IdentifiableAnnotation_Type.this);
  	  }
    };
  /** @generated */
  public final static int typeIndexID = IdentifiableAnnotation.typeIndexID;
  /** @generated 
     @modifiable */
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.isistan.uima.unified.typesystems.IdentifiableAnnotation");
 
  /** @generated */
  final Feature casFeat_identification;
  /** @generated */
  final int     casFeatCode_identification;
  /** @generated */ 
  public String getIdentification(int addr) {
        if (featOkTst && casFeat_identification == null)
      jcas.throwFeatMissing("identification", "edu.isistan.uima.unified.typesystems.IdentifiableAnnotation");
    return ll_cas.ll_getStringValue(addr, casFeatCode_identification);
  }
  /** @generated */    
  public void setIdentification(int addr, String v) {
        if (featOkTst && casFeat_identification == null)
      jcas.throwFeatMissing("identification", "edu.isistan.uima.unified.typesystems.IdentifiableAnnotation");
    ll_cas.ll_setStringValue(addr, casFeatCode_identification, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public IdentifiableAnnotation_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_identification = jcas.getRequiredFeatureDE(casType, "identification", "uima.cas.String", featOkTst);
    casFeatCode_identification  = (null == casFeat_identification) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_identification).getCode();

  }
}



    