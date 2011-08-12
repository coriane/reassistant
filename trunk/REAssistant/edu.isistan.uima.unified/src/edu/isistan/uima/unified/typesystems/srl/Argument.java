

/* First created by JCasGen Fri Mar 11 15:22:48 ART 2011 */
package edu.isistan.uima.unified.typesystems.srl;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.FSArray;
import edu.isistan.uima.unified.typesystems.nlp.Token;
import edu.isistan.uima.unified.typesystems.IdentifiableAnnotation;


/** 
 * Updated by JCasGen Fri Aug 12 18:17:38 ART 2011
 * XML source: C:/Work/REAssistant/edu.isistan.uima.unified/desc/typesystems/srl/PredicateTypeDescriptor.xml
 * @generated */
public class Argument extends IdentifiableAnnotation {
  /** @generated
   * @ordered 
   */
  public final static int typeIndexID = JCasRegistry.register(Argument.class);
  /** @generated
   * @ordered 
   */
  public final static int type = typeIndexID;
  /** @generated  */
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected Argument() {}
    
  /** Internal - constructor used by generator 
   * @generated */
  public Argument(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public Argument(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public Argument(JCas jcas, int begin, int end) {
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
    if (Argument_Type.featOkTst && ((Argument_Type)jcasType).casFeat_label == null)
      jcasType.jcas.throwFeatMissing("label", "edu.isistan.uima.unified.typesystems.srl.Argument");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Argument_Type)jcasType).casFeatCode_label);}
    
  /** setter for label - sets  
   * @generated */
  public void setLabel(String v) {
    if (Argument_Type.featOkTst && ((Argument_Type)jcasType).casFeat_label == null)
      jcasType.jcas.throwFeatMissing("label", "edu.isistan.uima.unified.typesystems.srl.Argument");
    jcasType.ll_cas.ll_setStringValue(addr, ((Argument_Type)jcasType).casFeatCode_label, v);}    
   
    
  //*--------------*
  //* Feature: description

  /** getter for description - gets 
   * @generated */
  public String getDescription() {
    if (Argument_Type.featOkTst && ((Argument_Type)jcasType).casFeat_description == null)
      jcasType.jcas.throwFeatMissing("description", "edu.isistan.uima.unified.typesystems.srl.Argument");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Argument_Type)jcasType).casFeatCode_description);}
    
  /** setter for description - sets  
   * @generated */
  public void setDescription(String v) {
    if (Argument_Type.featOkTst && ((Argument_Type)jcasType).casFeat_description == null)
      jcasType.jcas.throwFeatMissing("description", "edu.isistan.uima.unified.typesystems.srl.Argument");
    jcasType.ll_cas.ll_setStringValue(addr, ((Argument_Type)jcasType).casFeatCode_description, v);}    
   
    
  //*--------------*
  //* Feature: root

  /** getter for root - gets 
   * @generated */
  public Token getRoot() {
    if (Argument_Type.featOkTst && ((Argument_Type)jcasType).casFeat_root == null)
      jcasType.jcas.throwFeatMissing("root", "edu.isistan.uima.unified.typesystems.srl.Argument");
    return (Token)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Argument_Type)jcasType).casFeatCode_root)));}
    
  /** setter for root - sets  
   * @generated */
  public void setRoot(Token v) {
    if (Argument_Type.featOkTst && ((Argument_Type)jcasType).casFeat_root == null)
      jcasType.jcas.throwFeatMissing("root", "edu.isistan.uima.unified.typesystems.srl.Argument");
    jcasType.ll_cas.ll_setRefValue(addr, ((Argument_Type)jcasType).casFeatCode_root, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: yield

  /** getter for yield - gets 
   * @generated */
  public FSArray getYield() {
    if (Argument_Type.featOkTst && ((Argument_Type)jcasType).casFeat_yield == null)
      jcasType.jcas.throwFeatMissing("yield", "edu.isistan.uima.unified.typesystems.srl.Argument");
    return (FSArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Argument_Type)jcasType).casFeatCode_yield)));}
    
  /** setter for yield - sets  
   * @generated */
  public void setYield(FSArray v) {
    if (Argument_Type.featOkTst && ((Argument_Type)jcasType).casFeat_yield == null)
      jcasType.jcas.throwFeatMissing("yield", "edu.isistan.uima.unified.typesystems.srl.Argument");
    jcasType.ll_cas.ll_setRefValue(addr, ((Argument_Type)jcasType).casFeatCode_yield, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for yield - gets an indexed value - 
   * @generated */
  public Token getYield(int i) {
    if (Argument_Type.featOkTst && ((Argument_Type)jcasType).casFeat_yield == null)
      jcasType.jcas.throwFeatMissing("yield", "edu.isistan.uima.unified.typesystems.srl.Argument");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((Argument_Type)jcasType).casFeatCode_yield), i);
    return (Token)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((Argument_Type)jcasType).casFeatCode_yield), i)));}

  /** indexed setter for yield - sets an indexed value - 
   * @generated */
  public void setYield(int i, Token v) { 
    if (Argument_Type.featOkTst && ((Argument_Type)jcasType).casFeat_yield == null)
      jcasType.jcas.throwFeatMissing("yield", "edu.isistan.uima.unified.typesystems.srl.Argument");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((Argument_Type)jcasType).casFeatCode_yield), i);
    jcasType.ll_cas.ll_setRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((Argument_Type)jcasType).casFeatCode_yield), i, jcasType.ll_cas.ll_getFSRef(v));}
  }

    