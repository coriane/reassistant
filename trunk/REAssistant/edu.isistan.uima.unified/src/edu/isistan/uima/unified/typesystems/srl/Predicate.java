

/* First created by JCasGen Fri Mar 11 15:22:52 ART 2011 */
package edu.isistan.uima.unified.typesystems.srl;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.FSArray;
import edu.isistan.uima.unified.typesystems.nlp.Token;
import edu.isistan.uima.unified.typesystems.IdentifiableAnnotation;


/** 
 * Updated by JCasGen Fri Aug 12 18:17:39 ART 2011
 * XML source: C:/Work/REAssistant/edu.isistan.uima.unified/desc/typesystems/srl/PredicateTypeDescriptor.xml
 * @generated */
public class Predicate extends IdentifiableAnnotation {
  /** @generated
   * @ordered 
   */
  public final static int typeIndexID = JCasRegistry.register(Predicate.class);
  /** @generated
   * @ordered 
   */
  public final static int type = typeIndexID;
  /** @generated  */
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected Predicate() {}
    
  /** Internal - constructor used by generator 
   * @generated */
  public Predicate(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public Predicate(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public Predicate(JCas jcas, int begin, int end) {
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
  //* Feature: label

  /** getter for label - gets 
   * @generated */
  public String getLabel() {
    if (Predicate_Type.featOkTst && ((Predicate_Type)jcasType).casFeat_label == null)
      jcasType.jcas.throwFeatMissing("label", "edu.isistan.uima.unified.typesystems.srl.Predicate");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Predicate_Type)jcasType).casFeatCode_label);}
    
  /** setter for label - sets  
   * @generated */
  public void setLabel(String v) {
    if (Predicate_Type.featOkTst && ((Predicate_Type)jcasType).casFeat_label == null)
      jcasType.jcas.throwFeatMissing("label", "edu.isistan.uima.unified.typesystems.srl.Predicate");
    jcasType.ll_cas.ll_setStringValue(addr, ((Predicate_Type)jcasType).casFeatCode_label, v);}    
   
    
  //*--------------*
  //* Feature: description

  /** getter for description - gets 
   * @generated */
  public String getDescription() {
    if (Predicate_Type.featOkTst && ((Predicate_Type)jcasType).casFeat_description == null)
      jcasType.jcas.throwFeatMissing("description", "edu.isistan.uima.unified.typesystems.srl.Predicate");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Predicate_Type)jcasType).casFeatCode_description);}
    
  /** setter for description - sets  
   * @generated */
  public void setDescription(String v) {
    if (Predicate_Type.featOkTst && ((Predicate_Type)jcasType).casFeat_description == null)
      jcasType.jcas.throwFeatMissing("description", "edu.isistan.uima.unified.typesystems.srl.Predicate");
    jcasType.ll_cas.ll_setStringValue(addr, ((Predicate_Type)jcasType).casFeatCode_description, v);}    
   
    
  //*--------------*
  //* Feature: root

  /** getter for root - gets 
   * @generated */
  public Token getRoot() {
    if (Predicate_Type.featOkTst && ((Predicate_Type)jcasType).casFeat_root == null)
      jcasType.jcas.throwFeatMissing("root", "edu.isistan.uima.unified.typesystems.srl.Predicate");
    return (Token)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Predicate_Type)jcasType).casFeatCode_root)));}
    
  /** setter for root - sets  
   * @generated */
  public void setRoot(Token v) {
    if (Predicate_Type.featOkTst && ((Predicate_Type)jcasType).casFeat_root == null)
      jcasType.jcas.throwFeatMissing("root", "edu.isistan.uima.unified.typesystems.srl.Predicate");
    jcasType.ll_cas.ll_setRefValue(addr, ((Predicate_Type)jcasType).casFeatCode_root, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: kind

  /** getter for kind - gets 
   * @generated */
  public String getKind() {
    if (Predicate_Type.featOkTst && ((Predicate_Type)jcasType).casFeat_kind == null)
      jcasType.jcas.throwFeatMissing("kind", "edu.isistan.uima.unified.typesystems.srl.Predicate");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Predicate_Type)jcasType).casFeatCode_kind);}
    
  /** setter for kind - sets  
   * @generated */
  public void setKind(String v) {
    if (Predicate_Type.featOkTst && ((Predicate_Type)jcasType).casFeat_kind == null)
      jcasType.jcas.throwFeatMissing("kind", "edu.isistan.uima.unified.typesystems.srl.Predicate");
    jcasType.ll_cas.ll_setStringValue(addr, ((Predicate_Type)jcasType).casFeatCode_kind, v);}    
   
    
  //*--------------*
  //* Feature: passiveVoice

  /** getter for passiveVoice - gets 
   * @generated */
  public boolean getPassiveVoice() {
    if (Predicate_Type.featOkTst && ((Predicate_Type)jcasType).casFeat_passiveVoice == null)
      jcasType.jcas.throwFeatMissing("passiveVoice", "edu.isistan.uima.unified.typesystems.srl.Predicate");
    return jcasType.ll_cas.ll_getBooleanValue(addr, ((Predicate_Type)jcasType).casFeatCode_passiveVoice);}
    
  /** setter for passiveVoice - sets  
   * @generated */
  public void setPassiveVoice(boolean v) {
    if (Predicate_Type.featOkTst && ((Predicate_Type)jcasType).casFeat_passiveVoice == null)
      jcasType.jcas.throwFeatMissing("passiveVoice", "edu.isistan.uima.unified.typesystems.srl.Predicate");
    jcasType.ll_cas.ll_setBooleanValue(addr, ((Predicate_Type)jcasType).casFeatCode_passiveVoice, v);}    
   
    
  //*--------------*
  //* Feature: arguments

  /** getter for arguments - gets 
   * @generated */
  public FSArray getArguments() {
    if (Predicate_Type.featOkTst && ((Predicate_Type)jcasType).casFeat_arguments == null)
      jcasType.jcas.throwFeatMissing("arguments", "edu.isistan.uima.unified.typesystems.srl.Predicate");
    return (FSArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Predicate_Type)jcasType).casFeatCode_arguments)));}
    
  /** setter for arguments - sets  
   * @generated */
  public void setArguments(FSArray v) {
    if (Predicate_Type.featOkTst && ((Predicate_Type)jcasType).casFeat_arguments == null)
      jcasType.jcas.throwFeatMissing("arguments", "edu.isistan.uima.unified.typesystems.srl.Predicate");
    jcasType.ll_cas.ll_setRefValue(addr, ((Predicate_Type)jcasType).casFeatCode_arguments, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for arguments - gets an indexed value - 
   * @generated */
  public Argument getArguments(int i) {
    if (Predicate_Type.featOkTst && ((Predicate_Type)jcasType).casFeat_arguments == null)
      jcasType.jcas.throwFeatMissing("arguments", "edu.isistan.uima.unified.typesystems.srl.Predicate");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((Predicate_Type)jcasType).casFeatCode_arguments), i);
    return (Argument)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((Predicate_Type)jcasType).casFeatCode_arguments), i)));}

  /** indexed setter for arguments - sets an indexed value - 
   * @generated */
  public void setArguments(int i, Argument v) { 
    if (Predicate_Type.featOkTst && ((Predicate_Type)jcasType).casFeat_arguments == null)
      jcasType.jcas.throwFeatMissing("arguments", "edu.isistan.uima.unified.typesystems.srl.Predicate");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((Predicate_Type)jcasType).casFeatCode_arguments), i);
    jcasType.ll_cas.ll_setRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((Predicate_Type)jcasType).casFeatCode_arguments), i, jcasType.ll_cas.ll_getFSRef(v));}
  }

    