

/* First created by JCasGen Mon Dec 29 18:34:55 ART 2014 */
package edu.isistan.uima.unified.typesystems.wordnet;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.StringArray;
import edu.isistan.uima.unified.typesystems.IdentifiableAnnotation;


/** 
 * Updated by JCasGen Tue Dec 30 11:22:03 ART 2014
 * XML source: /Users/alejandrorago/Documents/Implementacion/Proyectos/REAssistant-SVN/REAssistant/edu.isistan.uima.unified/desc/typesystems/ECoreTypeDescriptor.xml
 * @generated */
public class Sense extends IdentifiableAnnotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Sense.class);
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
  protected Sense() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public Sense(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public Sense(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public Sense(JCas jcas, int begin, int end) {
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
  //* Feature: pos

  /** getter for pos - gets 
   * @generated
   * @return value of the feature 
   */
  public String getPos() {
    if (Sense_Type.featOkTst && ((Sense_Type)jcasType).casFeat_pos == null)
      jcasType.jcas.throwFeatMissing("pos", "edu.isistan.uima.unified.typesystems.wordnet.Sense");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Sense_Type)jcasType).casFeatCode_pos);}
    
  /** setter for pos - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setPos(String v) {
    if (Sense_Type.featOkTst && ((Sense_Type)jcasType).casFeat_pos == null)
      jcasType.jcas.throwFeatMissing("pos", "edu.isistan.uima.unified.typesystems.wordnet.Sense");
    jcasType.ll_cas.ll_setStringValue(addr, ((Sense_Type)jcasType).casFeatCode_pos, v);}    
   
    
  //*--------------*
  //* Feature: sense

  /** getter for sense - gets 
   * @generated
   * @return value of the feature 
   */
  public String getSense() {
    if (Sense_Type.featOkTst && ((Sense_Type)jcasType).casFeat_sense == null)
      jcasType.jcas.throwFeatMissing("sense", "edu.isistan.uima.unified.typesystems.wordnet.Sense");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Sense_Type)jcasType).casFeatCode_sense);}
    
  /** setter for sense - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setSense(String v) {
    if (Sense_Type.featOkTst && ((Sense_Type)jcasType).casFeat_sense == null)
      jcasType.jcas.throwFeatMissing("sense", "edu.isistan.uima.unified.typesystems.wordnet.Sense");
    jcasType.ll_cas.ll_setStringValue(addr, ((Sense_Type)jcasType).casFeatCode_sense, v);}    
   
    
  //*--------------*
  //* Feature: gloss

  /** getter for gloss - gets 
   * @generated
   * @return value of the feature 
   */
  public String getGloss() {
    if (Sense_Type.featOkTst && ((Sense_Type)jcasType).casFeat_gloss == null)
      jcasType.jcas.throwFeatMissing("gloss", "edu.isistan.uima.unified.typesystems.wordnet.Sense");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Sense_Type)jcasType).casFeatCode_gloss);}
    
  /** setter for gloss - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setGloss(String v) {
    if (Sense_Type.featOkTst && ((Sense_Type)jcasType).casFeat_gloss == null)
      jcasType.jcas.throwFeatMissing("gloss", "edu.isistan.uima.unified.typesystems.wordnet.Sense");
    jcasType.ll_cas.ll_setStringValue(addr, ((Sense_Type)jcasType).casFeatCode_gloss, v);}    
   
    
  //*--------------*
  //* Feature: senses

  /** getter for senses - gets 
   * @generated
   * @return value of the feature 
   */
  public StringArray getSenses() {
    if (Sense_Type.featOkTst && ((Sense_Type)jcasType).casFeat_senses == null)
      jcasType.jcas.throwFeatMissing("senses", "edu.isistan.uima.unified.typesystems.wordnet.Sense");
    return (StringArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Sense_Type)jcasType).casFeatCode_senses)));}
    
  /** setter for senses - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setSenses(StringArray v) {
    if (Sense_Type.featOkTst && ((Sense_Type)jcasType).casFeat_senses == null)
      jcasType.jcas.throwFeatMissing("senses", "edu.isistan.uima.unified.typesystems.wordnet.Sense");
    jcasType.ll_cas.ll_setRefValue(addr, ((Sense_Type)jcasType).casFeatCode_senses, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for senses - gets an indexed value - 
   * @generated
   * @param i index in the array to get
   * @return value of the element at index i 
   */
  public String getSenses(int i) {
    if (Sense_Type.featOkTst && ((Sense_Type)jcasType).casFeat_senses == null)
      jcasType.jcas.throwFeatMissing("senses", "edu.isistan.uima.unified.typesystems.wordnet.Sense");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((Sense_Type)jcasType).casFeatCode_senses), i);
    return jcasType.ll_cas.ll_getStringArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((Sense_Type)jcasType).casFeatCode_senses), i);}

  /** indexed setter for senses - sets an indexed value - 
   * @generated
   * @param i index in the array to set
   * @param v value to set into the array 
   */
  public void setSenses(int i, String v) { 
    if (Sense_Type.featOkTst && ((Sense_Type)jcasType).casFeat_senses == null)
      jcasType.jcas.throwFeatMissing("senses", "edu.isistan.uima.unified.typesystems.wordnet.Sense");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((Sense_Type)jcasType).casFeatCode_senses), i);
    jcasType.ll_cas.ll_setStringArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((Sense_Type)jcasType).casFeatCode_senses), i, v);}
  }

    