

/* First created by JCasGen Mon Dec 29 18:34:55 ART 2014 */
package edu.isistan.uima.unified.typesystems.srl;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.FSArray;
import org.apache.uima.jcas.cas.StringArray;
import edu.isistan.uima.unified.typesystems.IdentifiableAnnotation;


/** 
 * Updated by JCasGen Tue Dec 30 11:22:03 ART 2014
 * XML source: /Users/alejandrorago/Documents/Implementacion/Proyectos/REAssistant-SVN/REAssistant/edu.isistan.uima.unified/desc/typesystems/ECoreTypeDescriptor.xml
 * @generated */
public class Role extends IdentifiableAnnotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Role.class);
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
  protected Role() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public Role(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public Role(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public Role(JCas jcas, int begin, int end) {
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
    if (Role_Type.featOkTst && ((Role_Type)jcasType).casFeat_kind == null)
      jcasType.jcas.throwFeatMissing("kind", "edu.isistan.uima.unified.typesystems.srl.Role");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Role_Type)jcasType).casFeatCode_kind);}
    
  /** setter for kind - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setKind(String v) {
    if (Role_Type.featOkTst && ((Role_Type)jcasType).casFeat_kind == null)
      jcasType.jcas.throwFeatMissing("kind", "edu.isistan.uima.unified.typesystems.srl.Role");
    jcasType.ll_cas.ll_setStringValue(addr, ((Role_Type)jcasType).casFeatCode_kind, v);}    
   
    
  //*--------------*
  //* Feature: descriptions

  /** getter for descriptions - gets 
   * @generated
   * @return value of the feature 
   */
  public StringArray getDescriptions() {
    if (Role_Type.featOkTst && ((Role_Type)jcasType).casFeat_descriptions == null)
      jcasType.jcas.throwFeatMissing("descriptions", "edu.isistan.uima.unified.typesystems.srl.Role");
    return (StringArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Role_Type)jcasType).casFeatCode_descriptions)));}
    
  /** setter for descriptions - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setDescriptions(StringArray v) {
    if (Role_Type.featOkTst && ((Role_Type)jcasType).casFeat_descriptions == null)
      jcasType.jcas.throwFeatMissing("descriptions", "edu.isistan.uima.unified.typesystems.srl.Role");
    jcasType.ll_cas.ll_setRefValue(addr, ((Role_Type)jcasType).casFeatCode_descriptions, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for descriptions - gets an indexed value - 
   * @generated
   * @param i index in the array to get
   * @return value of the element at index i 
   */
  public String getDescriptions(int i) {
    if (Role_Type.featOkTst && ((Role_Type)jcasType).casFeat_descriptions == null)
      jcasType.jcas.throwFeatMissing("descriptions", "edu.isistan.uima.unified.typesystems.srl.Role");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((Role_Type)jcasType).casFeatCode_descriptions), i);
    return jcasType.ll_cas.ll_getStringArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((Role_Type)jcasType).casFeatCode_descriptions), i);}

  /** indexed setter for descriptions - sets an indexed value - 
   * @generated
   * @param i index in the array to set
   * @param v value to set into the array 
   */
  public void setDescriptions(int i, String v) { 
    if (Role_Type.featOkTst && ((Role_Type)jcasType).casFeat_descriptions == null)
      jcasType.jcas.throwFeatMissing("descriptions", "edu.isistan.uima.unified.typesystems.srl.Role");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((Role_Type)jcasType).casFeatCode_descriptions), i);
    jcasType.ll_cas.ll_setStringArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((Role_Type)jcasType).casFeatCode_descriptions), i, v);}
   
    
  //*--------------*
  //* Feature: ocurrencies

  /** getter for ocurrencies - gets 
   * @generated
   * @return value of the feature 
   */
  public FSArray getOcurrencies() {
    if (Role_Type.featOkTst && ((Role_Type)jcasType).casFeat_ocurrencies == null)
      jcasType.jcas.throwFeatMissing("ocurrencies", "edu.isistan.uima.unified.typesystems.srl.Role");
    return (FSArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Role_Type)jcasType).casFeatCode_ocurrencies)));}
    
  /** setter for ocurrencies - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setOcurrencies(FSArray v) {
    if (Role_Type.featOkTst && ((Role_Type)jcasType).casFeat_ocurrencies == null)
      jcasType.jcas.throwFeatMissing("ocurrencies", "edu.isistan.uima.unified.typesystems.srl.Role");
    jcasType.ll_cas.ll_setRefValue(addr, ((Role_Type)jcasType).casFeatCode_ocurrencies, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for ocurrencies - gets an indexed value - 
   * @generated
   * @param i index in the array to get
   * @return value of the element at index i 
   */
  public FSArray getOcurrencies(int i) {
    if (Role_Type.featOkTst && ((Role_Type)jcasType).casFeat_ocurrencies == null)
      jcasType.jcas.throwFeatMissing("ocurrencies", "edu.isistan.uima.unified.typesystems.srl.Role");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((Role_Type)jcasType).casFeatCode_ocurrencies), i);
    return (FSArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((Role_Type)jcasType).casFeatCode_ocurrencies), i)));}

  /** indexed setter for ocurrencies - sets an indexed value - 
   * @generated
   * @param i index in the array to set
   * @param v value to set into the array 
   */
  public void setOcurrencies(int i, FSArray v) { 
    if (Role_Type.featOkTst && ((Role_Type)jcasType).casFeat_ocurrencies == null)
      jcasType.jcas.throwFeatMissing("ocurrencies", "edu.isistan.uima.unified.typesystems.srl.Role");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((Role_Type)jcasType).casFeatCode_ocurrencies), i);
    jcasType.ll_cas.ll_setRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((Role_Type)jcasType).casFeatCode_ocurrencies), i, jcasType.ll_cas.ll_getFSRef(v));}
  }

    