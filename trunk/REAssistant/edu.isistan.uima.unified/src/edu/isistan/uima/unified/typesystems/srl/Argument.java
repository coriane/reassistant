

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
public class Argument extends IdentifiableAnnotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Argument.class);
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
  protected Argument() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public Argument(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public Argument(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public Argument(JCas jcas, int begin, int end) {
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
    if (Argument_Type.featOkTst && ((Argument_Type)jcasType).casFeat_label == null)
      jcasType.jcas.throwFeatMissing("label", "edu.isistan.uima.unified.typesystems.srl.Argument");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Argument_Type)jcasType).casFeatCode_label);}
    
  /** setter for label - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setLabel(String v) {
    if (Argument_Type.featOkTst && ((Argument_Type)jcasType).casFeat_label == null)
      jcasType.jcas.throwFeatMissing("label", "edu.isistan.uima.unified.typesystems.srl.Argument");
    jcasType.ll_cas.ll_setStringValue(addr, ((Argument_Type)jcasType).casFeatCode_label, v);}    
   
    
  //*--------------*
  //* Feature: description

  /** getter for description - gets 
   * @generated
   * @return value of the feature 
   */
  public String getDescription() {
    if (Argument_Type.featOkTst && ((Argument_Type)jcasType).casFeat_description == null)
      jcasType.jcas.throwFeatMissing("description", "edu.isistan.uima.unified.typesystems.srl.Argument");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Argument_Type)jcasType).casFeatCode_description);}
    
  /** setter for description - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setDescription(String v) {
    if (Argument_Type.featOkTst && ((Argument_Type)jcasType).casFeat_description == null)
      jcasType.jcas.throwFeatMissing("description", "edu.isistan.uima.unified.typesystems.srl.Argument");
    jcasType.ll_cas.ll_setStringValue(addr, ((Argument_Type)jcasType).casFeatCode_description, v);}    
   
    
  //*--------------*
  //* Feature: root

  /** getter for root - gets 
   * @generated
   * @return value of the feature 
   */
  public Token getRoot() {
    if (Argument_Type.featOkTst && ((Argument_Type)jcasType).casFeat_root == null)
      jcasType.jcas.throwFeatMissing("root", "edu.isistan.uima.unified.typesystems.srl.Argument");
    return (Token)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Argument_Type)jcasType).casFeatCode_root)));}
    
  /** setter for root - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setRoot(Token v) {
    if (Argument_Type.featOkTst && ((Argument_Type)jcasType).casFeat_root == null)
      jcasType.jcas.throwFeatMissing("root", "edu.isistan.uima.unified.typesystems.srl.Argument");
    jcasType.ll_cas.ll_setRefValue(addr, ((Argument_Type)jcasType).casFeatCode_root, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: yield

  /** getter for yield - gets 
   * @generated
   * @return value of the feature 
   */
  public FSArray getYield() {
    if (Argument_Type.featOkTst && ((Argument_Type)jcasType).casFeat_yield == null)
      jcasType.jcas.throwFeatMissing("yield", "edu.isistan.uima.unified.typesystems.srl.Argument");
    return (FSArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Argument_Type)jcasType).casFeatCode_yield)));}
    
  /** setter for yield - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setYield(FSArray v) {
    if (Argument_Type.featOkTst && ((Argument_Type)jcasType).casFeat_yield == null)
      jcasType.jcas.throwFeatMissing("yield", "edu.isistan.uima.unified.typesystems.srl.Argument");
    jcasType.ll_cas.ll_setRefValue(addr, ((Argument_Type)jcasType).casFeatCode_yield, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for yield - gets an indexed value - 
   * @generated
   * @param i index in the array to get
   * @return value of the element at index i 
   */
  public Token getYield(int i) {
    if (Argument_Type.featOkTst && ((Argument_Type)jcasType).casFeat_yield == null)
      jcasType.jcas.throwFeatMissing("yield", "edu.isistan.uima.unified.typesystems.srl.Argument");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((Argument_Type)jcasType).casFeatCode_yield), i);
    return (Token)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((Argument_Type)jcasType).casFeatCode_yield), i)));}

  /** indexed setter for yield - sets an indexed value - 
   * @generated
   * @param i index in the array to set
   * @param v value to set into the array 
   */
  public void setYield(int i, Token v) { 
    if (Argument_Type.featOkTst && ((Argument_Type)jcasType).casFeat_yield == null)
      jcasType.jcas.throwFeatMissing("yield", "edu.isistan.uima.unified.typesystems.srl.Argument");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((Argument_Type)jcasType).casFeatCode_yield), i);
    jcasType.ll_cas.ll_setRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((Argument_Type)jcasType).casFeatCode_yield), i, jcasType.ll_cas.ll_getFSRef(v));}
  }

    