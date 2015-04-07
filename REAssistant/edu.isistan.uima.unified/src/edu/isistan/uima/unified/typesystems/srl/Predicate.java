

/* First created by JCasGen Mon Dec 29 18:34:55 ART 2014 */
package edu.isistan.uima.unified.typesystems.srl;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.FSArray;
import edu.isistan.uima.unified.typesystems.nlp.Token;
import edu.isistan.uima.unified.typesystems.IdentifiableAnnotation;


/** 
 * Updated by JCasGen Tue Dec 30 11:22:03 ART 2014
 * XML source: /Users/alejandrorago/Documents/Implementacion/Proyectos/REAssistant-SVN/REAssistant/edu.isistan.uima.unified/desc/typesystems/ECoreTypeDescriptor.xml
 * @generated */
public class Predicate extends IdentifiableAnnotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Predicate.class);
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
  protected Predicate() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public Predicate(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public Predicate(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public Predicate(JCas jcas, int begin, int end) {
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
  //* Feature: label

  /** getter for label - gets 
   * @generated
   * @return value of the feature 
   */
  public String getLabel() {
    if (Predicate_Type.featOkTst && ((Predicate_Type)jcasType).casFeat_label == null)
      jcasType.jcas.throwFeatMissing("label", "edu.isistan.uima.unified.typesystems.srl.Predicate");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Predicate_Type)jcasType).casFeatCode_label);}
    
  /** setter for label - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setLabel(String v) {
    if (Predicate_Type.featOkTst && ((Predicate_Type)jcasType).casFeat_label == null)
      jcasType.jcas.throwFeatMissing("label", "edu.isistan.uima.unified.typesystems.srl.Predicate");
    jcasType.ll_cas.ll_setStringValue(addr, ((Predicate_Type)jcasType).casFeatCode_label, v);}    
   
    
  //*--------------*
  //* Feature: description

  /** getter for description - gets 
   * @generated
   * @return value of the feature 
   */
  public String getDescription() {
    if (Predicate_Type.featOkTst && ((Predicate_Type)jcasType).casFeat_description == null)
      jcasType.jcas.throwFeatMissing("description", "edu.isistan.uima.unified.typesystems.srl.Predicate");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Predicate_Type)jcasType).casFeatCode_description);}
    
  /** setter for description - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setDescription(String v) {
    if (Predicate_Type.featOkTst && ((Predicate_Type)jcasType).casFeat_description == null)
      jcasType.jcas.throwFeatMissing("description", "edu.isistan.uima.unified.typesystems.srl.Predicate");
    jcasType.ll_cas.ll_setStringValue(addr, ((Predicate_Type)jcasType).casFeatCode_description, v);}    
   
    
  //*--------------*
  //* Feature: root

  /** getter for root - gets 
   * @generated
   * @return value of the feature 
   */
  public Token getRoot() {
    if (Predicate_Type.featOkTst && ((Predicate_Type)jcasType).casFeat_root == null)
      jcasType.jcas.throwFeatMissing("root", "edu.isistan.uima.unified.typesystems.srl.Predicate");
    return (Token)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Predicate_Type)jcasType).casFeatCode_root)));}
    
  /** setter for root - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setRoot(Token v) {
    if (Predicate_Type.featOkTst && ((Predicate_Type)jcasType).casFeat_root == null)
      jcasType.jcas.throwFeatMissing("root", "edu.isistan.uima.unified.typesystems.srl.Predicate");
    jcasType.ll_cas.ll_setRefValue(addr, ((Predicate_Type)jcasType).casFeatCode_root, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: kind

  /** getter for kind - gets 
   * @generated
   * @return value of the feature 
   */
  public String getKind() {
    if (Predicate_Type.featOkTst && ((Predicate_Type)jcasType).casFeat_kind == null)
      jcasType.jcas.throwFeatMissing("kind", "edu.isistan.uima.unified.typesystems.srl.Predicate");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Predicate_Type)jcasType).casFeatCode_kind);}
    
  /** setter for kind - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setKind(String v) {
    if (Predicate_Type.featOkTst && ((Predicate_Type)jcasType).casFeat_kind == null)
      jcasType.jcas.throwFeatMissing("kind", "edu.isistan.uima.unified.typesystems.srl.Predicate");
    jcasType.ll_cas.ll_setStringValue(addr, ((Predicate_Type)jcasType).casFeatCode_kind, v);}    
   
    
  //*--------------*
  //* Feature: passiveVoice

  /** getter for passiveVoice - gets 
   * @generated
   * @return value of the feature 
   */
  public boolean getPassiveVoice() {
    if (Predicate_Type.featOkTst && ((Predicate_Type)jcasType).casFeat_passiveVoice == null)
      jcasType.jcas.throwFeatMissing("passiveVoice", "edu.isistan.uima.unified.typesystems.srl.Predicate");
    return jcasType.ll_cas.ll_getBooleanValue(addr, ((Predicate_Type)jcasType).casFeatCode_passiveVoice);}
    
  /** setter for passiveVoice - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setPassiveVoice(boolean v) {
    if (Predicate_Type.featOkTst && ((Predicate_Type)jcasType).casFeat_passiveVoice == null)
      jcasType.jcas.throwFeatMissing("passiveVoice", "edu.isistan.uima.unified.typesystems.srl.Predicate");
    jcasType.ll_cas.ll_setBooleanValue(addr, ((Predicate_Type)jcasType).casFeatCode_passiveVoice, v);}    
   
    
  //*--------------*
  //* Feature: arguments

  /** getter for arguments - gets 
   * @generated
   * @return value of the feature 
   */
  public FSArray getArguments() {
    if (Predicate_Type.featOkTst && ((Predicate_Type)jcasType).casFeat_arguments == null)
      jcasType.jcas.throwFeatMissing("arguments", "edu.isistan.uima.unified.typesystems.srl.Predicate");
    return (FSArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Predicate_Type)jcasType).casFeatCode_arguments)));}
    
  /** setter for arguments - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setArguments(FSArray v) {
    if (Predicate_Type.featOkTst && ((Predicate_Type)jcasType).casFeat_arguments == null)
      jcasType.jcas.throwFeatMissing("arguments", "edu.isistan.uima.unified.typesystems.srl.Predicate");
    jcasType.ll_cas.ll_setRefValue(addr, ((Predicate_Type)jcasType).casFeatCode_arguments, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for arguments - gets an indexed value - 
   * @generated
   * @param i index in the array to get
   * @return value of the element at index i 
   */
  public Argument getArguments(int i) {
    if (Predicate_Type.featOkTst && ((Predicate_Type)jcasType).casFeat_arguments == null)
      jcasType.jcas.throwFeatMissing("arguments", "edu.isistan.uima.unified.typesystems.srl.Predicate");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((Predicate_Type)jcasType).casFeatCode_arguments), i);
    return (Argument)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((Predicate_Type)jcasType).casFeatCode_arguments), i)));}

  /** indexed setter for arguments - sets an indexed value - 
   * @generated
   * @param i index in the array to set
   * @param v value to set into the array 
   */
  public void setArguments(int i, Argument v) { 
    if (Predicate_Type.featOkTst && ((Predicate_Type)jcasType).casFeat_arguments == null)
      jcasType.jcas.throwFeatMissing("arguments", "edu.isistan.uima.unified.typesystems.srl.Predicate");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((Predicate_Type)jcasType).casFeatCode_arguments), i);
    jcasType.ll_cas.ll_setRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((Predicate_Type)jcasType).casFeatCode_arguments), i, jcasType.ll_cas.ll_getFSRef(v));}
  }

    