

/* First created by JCasGen Fri Mar 11 15:22:16 ART 2011 */
package edu.isistan.uima.unified.typesystems;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Sat Dec 10 16:39:00 ART 2011
 * XML source: C:/Work/REAssistant/edu.isistan.uima.unified/desc/typesystems/nlp/TokenTypeDescriptor.xml
 * @generated */
public class IdentifiableAnnotation extends Annotation {
  /** @generated
   * @ordered 
   */
  public final static int typeIndexID = JCasRegistry.register(IdentifiableAnnotation.class);
  /** @generated
   * @ordered 
   */
  public final static int type = typeIndexID;
  /** @generated  */
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected IdentifiableAnnotation() {}
    
  /** Internal - constructor used by generator 
   * @generated */
  public IdentifiableAnnotation(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public IdentifiableAnnotation(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public IdentifiableAnnotation(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {}
     
 
    
  //*--------------*
  //* Feature: identification

  /** getter for identification - gets 
   * @generated */
  public String getIdentification() {
    if (IdentifiableAnnotation_Type.featOkTst && ((IdentifiableAnnotation_Type)jcasType).casFeat_identification == null)
      jcasType.jcas.throwFeatMissing("identification", "edu.isistan.uima.unified.typesystems.IdentifiableAnnotation");
    return jcasType.ll_cas.ll_getStringValue(addr, ((IdentifiableAnnotation_Type)jcasType).casFeatCode_identification);}
    
  /** setter for identification - sets  
   * @generated */
  public void setIdentification(String v) {
    if (IdentifiableAnnotation_Type.featOkTst && ((IdentifiableAnnotation_Type)jcasType).casFeat_identification == null)
      jcasType.jcas.throwFeatMissing("identification", "edu.isistan.uima.unified.typesystems.IdentifiableAnnotation");
    jcasType.ll_cas.ll_setStringValue(addr, ((IdentifiableAnnotation_Type)jcasType).casFeatCode_identification, v);}    
  }

    