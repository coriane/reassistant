

/* First created by JCasGen Mon Mar 14 19:00:52 ART 2011 */
package edu.isistan.uima.unified.typesystems.srl;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import edu.isistan.uima.unified.typesystems.IdentifiableAnnotation;


/** 
 * Updated by JCasGen Mon Mar 14 19:00:52 ART 2011
 * XML source: C:/Work/REAssistant/edu.isistan.uima.unified/desc/typesystems/srl/StructureTypeDescriptor.xml
 * @generated */
public class Structure extends IdentifiableAnnotation {
  /** @generated
   * @ordered 
   */
  public final static int typeIndexID = JCasRegistry.register(Structure.class);
  /** @generated
   * @ordered 
   */
  public final static int type = typeIndexID;
  /** @generated  */
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected Structure() {}
    
  /** Internal - constructor used by generator 
   * @generated */
  public Structure(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public Structure(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public Structure(JCas jcas, int begin, int end) {
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
  //* Feature: subject

  /** getter for subject - gets 
   * @generated */
  public Role getSubject() {
    if (Structure_Type.featOkTst && ((Structure_Type)jcasType).casFeat_subject == null)
      jcasType.jcas.throwFeatMissing("subject", "edu.isistan.uima.unified.typesystems.srl.Structure");
    return (Role)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Structure_Type)jcasType).casFeatCode_subject)));}
    
  /** setter for subject - sets  
   * @generated */
  public void setSubject(Role v) {
    if (Structure_Type.featOkTst && ((Structure_Type)jcasType).casFeat_subject == null)
      jcasType.jcas.throwFeatMissing("subject", "edu.isistan.uima.unified.typesystems.srl.Structure");
    jcasType.ll_cas.ll_setRefValue(addr, ((Structure_Type)jcasType).casFeatCode_subject, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: verb

  /** getter for verb - gets 
   * @generated */
  public Role getVerb() {
    if (Structure_Type.featOkTst && ((Structure_Type)jcasType).casFeat_verb == null)
      jcasType.jcas.throwFeatMissing("verb", "edu.isistan.uima.unified.typesystems.srl.Structure");
    return (Role)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Structure_Type)jcasType).casFeatCode_verb)));}
    
  /** setter for verb - sets  
   * @generated */
  public void setVerb(Role v) {
    if (Structure_Type.featOkTst && ((Structure_Type)jcasType).casFeat_verb == null)
      jcasType.jcas.throwFeatMissing("verb", "edu.isistan.uima.unified.typesystems.srl.Structure");
    jcasType.ll_cas.ll_setRefValue(addr, ((Structure_Type)jcasType).casFeatCode_verb, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: directObject

  /** getter for directObject - gets 
   * @generated */
  public Role getDirectObject() {
    if (Structure_Type.featOkTst && ((Structure_Type)jcasType).casFeat_directObject == null)
      jcasType.jcas.throwFeatMissing("directObject", "edu.isistan.uima.unified.typesystems.srl.Structure");
    return (Role)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Structure_Type)jcasType).casFeatCode_directObject)));}
    
  /** setter for directObject - sets  
   * @generated */
  public void setDirectObject(Role v) {
    if (Structure_Type.featOkTst && ((Structure_Type)jcasType).casFeat_directObject == null)
      jcasType.jcas.throwFeatMissing("directObject", "edu.isistan.uima.unified.typesystems.srl.Structure");
    jcasType.ll_cas.ll_setRefValue(addr, ((Structure_Type)jcasType).casFeatCode_directObject, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: indirectObject

  /** getter for indirectObject - gets 
   * @generated */
  public Role getIndirectObject() {
    if (Structure_Type.featOkTst && ((Structure_Type)jcasType).casFeat_indirectObject == null)
      jcasType.jcas.throwFeatMissing("indirectObject", "edu.isistan.uima.unified.typesystems.srl.Structure");
    return (Role)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Structure_Type)jcasType).casFeatCode_indirectObject)));}
    
  /** setter for indirectObject - sets  
   * @generated */
  public void setIndirectObject(Role v) {
    if (Structure_Type.featOkTst && ((Structure_Type)jcasType).casFeat_indirectObject == null)
      jcasType.jcas.throwFeatMissing("indirectObject", "edu.isistan.uima.unified.typesystems.srl.Structure");
    jcasType.ll_cas.ll_setRefValue(addr, ((Structure_Type)jcasType).casFeatCode_indirectObject, jcasType.ll_cas.ll_getFSRef(v));}    
  }

    