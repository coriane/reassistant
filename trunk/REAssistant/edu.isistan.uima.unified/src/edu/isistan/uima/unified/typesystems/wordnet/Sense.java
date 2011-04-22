

/* First created by JCasGen Fri Mar 11 15:23:15 ART 2011 */
package edu.isistan.uima.unified.typesystems.wordnet;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.StringArray;
import edu.isistan.uima.unified.typesystems.IdentifiableAnnotation;


/** 
 * Updated by JCasGen Fri Mar 11 15:23:15 ART 2011
 * XML source: C:/Work/REAssistant/edu.isistan.uima.unified/desc/typesystems/wordnet/SenseTypeDescriptor.xml
 * @generated */
public class Sense extends IdentifiableAnnotation {
  /** @generated
   * @ordered 
   */
  public final static int typeIndexID = JCasRegistry.register(Sense.class);
  /** @generated
   * @ordered 
   */
  public final static int type = typeIndexID;
  /** @generated  */
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected Sense() {}
    
  /** Internal - constructor used by generator 
   * @generated */
  public Sense(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public Sense(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public Sense(JCas jcas, int begin, int end) {
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
  //* Feature: pos

  /** getter for pos - gets 
   * @generated */
  public String getPos() {
    if (Sense_Type.featOkTst && ((Sense_Type)jcasType).casFeat_pos == null)
      jcasType.jcas.throwFeatMissing("pos", "edu.isistan.uima.unified.typesystems.wordnet.Sense");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Sense_Type)jcasType).casFeatCode_pos);}
    
  /** setter for pos - sets  
   * @generated */
  public void setPos(String v) {
    if (Sense_Type.featOkTst && ((Sense_Type)jcasType).casFeat_pos == null)
      jcasType.jcas.throwFeatMissing("pos", "edu.isistan.uima.unified.typesystems.wordnet.Sense");
    jcasType.ll_cas.ll_setStringValue(addr, ((Sense_Type)jcasType).casFeatCode_pos, v);}    
   
    
  //*--------------*
  //* Feature: sense

  /** getter for sense - gets 
   * @generated */
  public String getSense() {
    if (Sense_Type.featOkTst && ((Sense_Type)jcasType).casFeat_sense == null)
      jcasType.jcas.throwFeatMissing("sense", "edu.isistan.uima.unified.typesystems.wordnet.Sense");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Sense_Type)jcasType).casFeatCode_sense);}
    
  /** setter for sense - sets  
   * @generated */
  public void setSense(String v) {
    if (Sense_Type.featOkTst && ((Sense_Type)jcasType).casFeat_sense == null)
      jcasType.jcas.throwFeatMissing("sense", "edu.isistan.uima.unified.typesystems.wordnet.Sense");
    jcasType.ll_cas.ll_setStringValue(addr, ((Sense_Type)jcasType).casFeatCode_sense, v);}    
   
    
  //*--------------*
  //* Feature: gloss

  /** getter for gloss - gets 
   * @generated */
  public String getGloss() {
    if (Sense_Type.featOkTst && ((Sense_Type)jcasType).casFeat_gloss == null)
      jcasType.jcas.throwFeatMissing("gloss", "edu.isistan.uima.unified.typesystems.wordnet.Sense");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Sense_Type)jcasType).casFeatCode_gloss);}
    
  /** setter for gloss - sets  
   * @generated */
  public void setGloss(String v) {
    if (Sense_Type.featOkTst && ((Sense_Type)jcasType).casFeat_gloss == null)
      jcasType.jcas.throwFeatMissing("gloss", "edu.isistan.uima.unified.typesystems.wordnet.Sense");
    jcasType.ll_cas.ll_setStringValue(addr, ((Sense_Type)jcasType).casFeatCode_gloss, v);}    
   
    
  //*--------------*
  //* Feature: senses

  /** getter for senses - gets 
   * @generated */
  public StringArray getSenses() {
    if (Sense_Type.featOkTst && ((Sense_Type)jcasType).casFeat_senses == null)
      jcasType.jcas.throwFeatMissing("senses", "edu.isistan.uima.unified.typesystems.wordnet.Sense");
    return (StringArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Sense_Type)jcasType).casFeatCode_senses)));}
    
  /** setter for senses - sets  
   * @generated */
  public void setSenses(StringArray v) {
    if (Sense_Type.featOkTst && ((Sense_Type)jcasType).casFeat_senses == null)
      jcasType.jcas.throwFeatMissing("senses", "edu.isistan.uima.unified.typesystems.wordnet.Sense");
    jcasType.ll_cas.ll_setRefValue(addr, ((Sense_Type)jcasType).casFeatCode_senses, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for senses - gets an indexed value - 
   * @generated */
  public String getSenses(int i) {
    if (Sense_Type.featOkTst && ((Sense_Type)jcasType).casFeat_senses == null)
      jcasType.jcas.throwFeatMissing("senses", "edu.isistan.uima.unified.typesystems.wordnet.Sense");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((Sense_Type)jcasType).casFeatCode_senses), i);
    return jcasType.ll_cas.ll_getStringArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((Sense_Type)jcasType).casFeatCode_senses), i);}

  /** indexed setter for senses - sets an indexed value - 
   * @generated */
  public void setSenses(int i, String v) { 
    if (Sense_Type.featOkTst && ((Sense_Type)jcasType).casFeat_senses == null)
      jcasType.jcas.throwFeatMissing("senses", "edu.isistan.uima.unified.typesystems.wordnet.Sense");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((Sense_Type)jcasType).casFeatCode_senses), i);
    jcasType.ll_cas.ll_setStringArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((Sense_Type)jcasType).casFeatCode_senses), i, v);}
  }

    