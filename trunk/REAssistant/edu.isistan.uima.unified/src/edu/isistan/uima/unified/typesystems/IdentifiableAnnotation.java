

/* First created by JCasGen Mon Dec 29 18:34:55 ART 2014 */
package edu.isistan.uima.unified.typesystems;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Tue Dec 30 11:22:03 ART 2014
 * XML source: /Users/alejandrorago/Documents/Implementacion/Proyectos/REAssistant-SVN/REAssistant/edu.isistan.uima.unified/desc/typesystems/ECoreTypeDescriptor.xml
 * @generated */
public class IdentifiableAnnotation extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(IdentifiableAnnotation.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated
   * @return index of the type  
   */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected IdentifiableAnnotation() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public IdentifiableAnnotation(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public IdentifiableAnnotation(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public IdentifiableAnnotation(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** 
   * <!-- begin-user-doc -->
   * Write your own initialization here
   * <!-- end-user-doc -->
   *
   * @generated modifiable 
   */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: identification

  /** getter for identification - gets 
   * @generated
   * @return value of the feature 
   */
  public String getIdentification() {
    if (IdentifiableAnnotation_Type.featOkTst && ((IdentifiableAnnotation_Type)jcasType).casFeat_identification == null)
      jcasType.jcas.throwFeatMissing("identification", "edu.isistan.uima.unified.typesystems.IdentifiableAnnotation");
    return jcasType.ll_cas.ll_getStringValue(addr, ((IdentifiableAnnotation_Type)jcasType).casFeatCode_identification);}
    
  /** setter for identification - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setIdentification(String v) {
    if (IdentifiableAnnotation_Type.featOkTst && ((IdentifiableAnnotation_Type)jcasType).casFeat_identification == null)
      jcasType.jcas.throwFeatMissing("identification", "edu.isistan.uima.unified.typesystems.IdentifiableAnnotation");
    jcasType.ll_cas.ll_setStringValue(addr, ((IdentifiableAnnotation_Type)jcasType).casFeatCode_identification, v);}    
  }

    