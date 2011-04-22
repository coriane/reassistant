

/* First created by JCasGen Mon Mar 14 19:00:43 ART 2011 */
package edu.isistan.uima.unified.typesystems.srl;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.FSArray;
import org.apache.uima.jcas.cas.StringArray;
import edu.isistan.uima.unified.typesystems.IdentifiableAnnotation;


/** 
 * Updated by JCasGen Mon Mar 14 19:00:52 ART 2011
 * XML source: C:/Work/REAssistant/edu.isistan.uima.unified/desc/typesystems/srl/StructureTypeDescriptor.xml
 * @generated */
public class Role extends IdentifiableAnnotation {
  /** @generated
   * @ordered 
   */
  public final static int typeIndexID = JCasRegistry.register(Role.class);
  /** @generated
   * @ordered 
   */
  public final static int type = typeIndexID;
  /** @generated  */
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected Role() {}
    
  /** Internal - constructor used by generator 
   * @generated */
  public Role(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public Role(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public Role(JCas jcas, int begin, int end) {
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
  //* Feature: kind

  /** getter for kind - gets 
   * @generated */
  public String getKind() {
    if (Role_Type.featOkTst && ((Role_Type)jcasType).casFeat_kind == null)
      jcasType.jcas.throwFeatMissing("kind", "edu.isistan.uima.unified.typesystems.srl.Role");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Role_Type)jcasType).casFeatCode_kind);}
    
  /** setter for kind - sets  
   * @generated */
  public void setKind(String v) {
    if (Role_Type.featOkTst && ((Role_Type)jcasType).casFeat_kind == null)
      jcasType.jcas.throwFeatMissing("kind", "edu.isistan.uima.unified.typesystems.srl.Role");
    jcasType.ll_cas.ll_setStringValue(addr, ((Role_Type)jcasType).casFeatCode_kind, v);}    
   
    
  //*--------------*
  //* Feature: descriptions

  /** getter for descriptions - gets 
   * @generated */
  public StringArray getDescriptions() {
    if (Role_Type.featOkTst && ((Role_Type)jcasType).casFeat_descriptions == null)
      jcasType.jcas.throwFeatMissing("descriptions", "edu.isistan.uima.unified.typesystems.srl.Role");
    return (StringArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Role_Type)jcasType).casFeatCode_descriptions)));}
    
  /** setter for descriptions - sets  
   * @generated */
  public void setDescriptions(StringArray v) {
    if (Role_Type.featOkTst && ((Role_Type)jcasType).casFeat_descriptions == null)
      jcasType.jcas.throwFeatMissing("descriptions", "edu.isistan.uima.unified.typesystems.srl.Role");
    jcasType.ll_cas.ll_setRefValue(addr, ((Role_Type)jcasType).casFeatCode_descriptions, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for descriptions - gets an indexed value - 
   * @generated */
  public String getDescriptions(int i) {
    if (Role_Type.featOkTst && ((Role_Type)jcasType).casFeat_descriptions == null)
      jcasType.jcas.throwFeatMissing("descriptions", "edu.isistan.uima.unified.typesystems.srl.Role");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((Role_Type)jcasType).casFeatCode_descriptions), i);
    return jcasType.ll_cas.ll_getStringArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((Role_Type)jcasType).casFeatCode_descriptions), i);}

  /** indexed setter for descriptions - sets an indexed value - 
   * @generated */
  public void setDescriptions(int i, String v) { 
    if (Role_Type.featOkTst && ((Role_Type)jcasType).casFeat_descriptions == null)
      jcasType.jcas.throwFeatMissing("descriptions", "edu.isistan.uima.unified.typesystems.srl.Role");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((Role_Type)jcasType).casFeatCode_descriptions), i);
    jcasType.ll_cas.ll_setStringArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((Role_Type)jcasType).casFeatCode_descriptions), i, v);}
   
    
  //*--------------*
  //* Feature: ocurrencies

  /** getter for ocurrencies - gets 
   * @generated */
  public FSArray getOcurrencies() {
    if (Role_Type.featOkTst && ((Role_Type)jcasType).casFeat_ocurrencies == null)
      jcasType.jcas.throwFeatMissing("ocurrencies", "edu.isistan.uima.unified.typesystems.srl.Role");
    return (FSArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Role_Type)jcasType).casFeatCode_ocurrencies)));}
    
  /** setter for ocurrencies - sets  
   * @generated */
  public void setOcurrencies(FSArray v) {
    if (Role_Type.featOkTst && ((Role_Type)jcasType).casFeat_ocurrencies == null)
      jcasType.jcas.throwFeatMissing("ocurrencies", "edu.isistan.uima.unified.typesystems.srl.Role");
    jcasType.ll_cas.ll_setRefValue(addr, ((Role_Type)jcasType).casFeatCode_ocurrencies, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for ocurrencies - gets an indexed value - 
   * @generated */
  public FSArray getOcurrencies(int i) {
    if (Role_Type.featOkTst && ((Role_Type)jcasType).casFeat_ocurrencies == null)
      jcasType.jcas.throwFeatMissing("ocurrencies", "edu.isistan.uima.unified.typesystems.srl.Role");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((Role_Type)jcasType).casFeatCode_ocurrencies), i);
    return (FSArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((Role_Type)jcasType).casFeatCode_ocurrencies), i)));}

  /** indexed setter for ocurrencies - sets an indexed value - 
   * @generated */
  public void setOcurrencies(int i, FSArray v) { 
    if (Role_Type.featOkTst && ((Role_Type)jcasType).casFeat_ocurrencies == null)
      jcasType.jcas.throwFeatMissing("ocurrencies", "edu.isistan.uima.unified.typesystems.srl.Role");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((Role_Type)jcasType).casFeatCode_ocurrencies), i);
    jcasType.ll_cas.ll_setRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((Role_Type)jcasType).casFeatCode_ocurrencies), i, jcasType.ll_cas.ll_getFSRef(v));}
  }

    