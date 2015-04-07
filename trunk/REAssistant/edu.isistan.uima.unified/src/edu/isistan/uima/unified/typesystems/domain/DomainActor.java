

/* First created by JCasGen Mon Dec 29 18:34:55 ART 2014 */
package edu.isistan.uima.unified.typesystems.domain;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import edu.isistan.uima.unified.typesystems.IdentifiableAnnotation;


/** 
 * Updated by JCasGen Tue Dec 30 11:22:03 ART 2014
 * XML source: /Users/alejandrorago/Documents/Implementacion/Proyectos/REAssistant-SVN/REAssistant/edu.isistan.uima.unified/desc/typesystems/ECoreTypeDescriptor.xml
 * @generated */
public class DomainActor extends IdentifiableAnnotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(DomainActor.class);
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
  protected DomainActor() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public DomainActor(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public DomainActor(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public DomainActor(JCas jcas, int begin, int end) {
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
  //* Feature: kind

  /** getter for kind - gets 
   * @generated
   * @return value of the feature 
   */
  public String getKind() {
    if (DomainActor_Type.featOkTst && ((DomainActor_Type)jcasType).casFeat_kind == null)
      jcasType.jcas.throwFeatMissing("kind", "edu.isistan.uima.unified.typesystems.domain.DomainActor");
    return jcasType.ll_cas.ll_getStringValue(addr, ((DomainActor_Type)jcasType).casFeatCode_kind);}
    
  /** setter for kind - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setKind(String v) {
    if (DomainActor_Type.featOkTst && ((DomainActor_Type)jcasType).casFeat_kind == null)
      jcasType.jcas.throwFeatMissing("kind", "edu.isistan.uima.unified.typesystems.domain.DomainActor");
    jcasType.ll_cas.ll_setStringValue(addr, ((DomainActor_Type)jcasType).casFeatCode_kind, v);}    
   
    
  //*--------------*
  //* Feature: role

  /** getter for role - gets 
   * @generated
   * @return value of the feature 
   */
  public String getRole() {
    if (DomainActor_Type.featOkTst && ((DomainActor_Type)jcasType).casFeat_role == null)
      jcasType.jcas.throwFeatMissing("role", "edu.isistan.uima.unified.typesystems.domain.DomainActor");
    return jcasType.ll_cas.ll_getStringValue(addr, ((DomainActor_Type)jcasType).casFeatCode_role);}
    
  /** setter for role - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setRole(String v) {
    if (DomainActor_Type.featOkTst && ((DomainActor_Type)jcasType).casFeat_role == null)
      jcasType.jcas.throwFeatMissing("role", "edu.isistan.uima.unified.typesystems.domain.DomainActor");
    jcasType.ll_cas.ll_setStringValue(addr, ((DomainActor_Type)jcasType).casFeatCode_role, v);}    
  }

    