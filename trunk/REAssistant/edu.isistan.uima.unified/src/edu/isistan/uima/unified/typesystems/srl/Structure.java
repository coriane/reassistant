

/* First created by JCasGen Mon Dec 29 18:34:55 ART 2014 */
package edu.isistan.uima.unified.typesystems.srl;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import edu.isistan.uima.unified.typesystems.IdentifiableAnnotation;


/** 
 * Updated by JCasGen Tue Dec 30 11:22:03 ART 2014
 * XML source: /Users/alejandrorago/Documents/Implementacion/Proyectos/REAssistant-SVN/REAssistant/edu.isistan.uima.unified/desc/typesystems/ECoreTypeDescriptor.xml
 * @generated */
public class Structure extends IdentifiableAnnotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Structure.class);
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
  protected Structure() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public Structure(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public Structure(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public Structure(JCas jcas, int begin, int end) {
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
  //* Feature: subject

  /** getter for subject - gets 
   * @generated
   * @return value of the feature 
   */
  public Role getSubject() {
    if (Structure_Type.featOkTst && ((Structure_Type)jcasType).casFeat_subject == null)
      jcasType.jcas.throwFeatMissing("subject", "edu.isistan.uima.unified.typesystems.srl.Structure");
    return (Role)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Structure_Type)jcasType).casFeatCode_subject)));}
    
  /** setter for subject - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setSubject(Role v) {
    if (Structure_Type.featOkTst && ((Structure_Type)jcasType).casFeat_subject == null)
      jcasType.jcas.throwFeatMissing("subject", "edu.isistan.uima.unified.typesystems.srl.Structure");
    jcasType.ll_cas.ll_setRefValue(addr, ((Structure_Type)jcasType).casFeatCode_subject, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: verb

  /** getter for verb - gets 
   * @generated
   * @return value of the feature 
   */
  public Role getVerb() {
    if (Structure_Type.featOkTst && ((Structure_Type)jcasType).casFeat_verb == null)
      jcasType.jcas.throwFeatMissing("verb", "edu.isistan.uima.unified.typesystems.srl.Structure");
    return (Role)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Structure_Type)jcasType).casFeatCode_verb)));}
    
  /** setter for verb - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setVerb(Role v) {
    if (Structure_Type.featOkTst && ((Structure_Type)jcasType).casFeat_verb == null)
      jcasType.jcas.throwFeatMissing("verb", "edu.isistan.uima.unified.typesystems.srl.Structure");
    jcasType.ll_cas.ll_setRefValue(addr, ((Structure_Type)jcasType).casFeatCode_verb, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: directObject

  /** getter for directObject - gets 
   * @generated
   * @return value of the feature 
   */
  public Role getDirectObject() {
    if (Structure_Type.featOkTst && ((Structure_Type)jcasType).casFeat_directObject == null)
      jcasType.jcas.throwFeatMissing("directObject", "edu.isistan.uima.unified.typesystems.srl.Structure");
    return (Role)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Structure_Type)jcasType).casFeatCode_directObject)));}
    
  /** setter for directObject - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setDirectObject(Role v) {
    if (Structure_Type.featOkTst && ((Structure_Type)jcasType).casFeat_directObject == null)
      jcasType.jcas.throwFeatMissing("directObject", "edu.isistan.uima.unified.typesystems.srl.Structure");
    jcasType.ll_cas.ll_setRefValue(addr, ((Structure_Type)jcasType).casFeatCode_directObject, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: indirectObject

  /** getter for indirectObject - gets 
   * @generated
   * @return value of the feature 
   */
  public Role getIndirectObject() {
    if (Structure_Type.featOkTst && ((Structure_Type)jcasType).casFeat_indirectObject == null)
      jcasType.jcas.throwFeatMissing("indirectObject", "edu.isistan.uima.unified.typesystems.srl.Structure");
    return (Role)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Structure_Type)jcasType).casFeatCode_indirectObject)));}
    
  /** setter for indirectObject - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setIndirectObject(Role v) {
    if (Structure_Type.featOkTst && ((Structure_Type)jcasType).casFeat_indirectObject == null)
      jcasType.jcas.throwFeatMissing("indirectObject", "edu.isistan.uima.unified.typesystems.srl.Structure");
    jcasType.ll_cas.ll_setRefValue(addr, ((Structure_Type)jcasType).casFeatCode_indirectObject, jcasType.ll_cas.ll_getFSRef(v));}    
  }

    