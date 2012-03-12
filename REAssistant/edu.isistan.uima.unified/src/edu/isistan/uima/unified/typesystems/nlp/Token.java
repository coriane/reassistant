

/* First created by JCasGen Fri Mar 11 15:22:20 ART 2011 */
package edu.isistan.uima.unified.typesystems.nlp;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import edu.isistan.uima.unified.typesystems.IdentifiableAnnotation;


/** 
 * Updated by JCasGen Sat Dec 10 16:39:00 ART 2011
 * XML source: C:/Work/REAssistant/edu.isistan.uima.unified/desc/typesystems/nlp/TokenTypeDescriptor.xml
 * @generated */
public class Token extends IdentifiableAnnotation {
  /** @generated
   * @ordered 
   */
  public final static int typeIndexID = JCasRegistry.register(Token.class);
  /** @generated
   * @ordered 
   */
  public final static int type = typeIndexID;
  /** @generated  */
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected Token() {}
    
  /** Internal - constructor used by generator 
   * @generated */
  public Token(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public Token(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public Token(JCas jcas, int begin, int end) {
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
  //* Feature: lemma

  /** getter for lemma - gets 
   * @generated */
  public String getLemma() {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_lemma == null)
      jcasType.jcas.throwFeatMissing("lemma", "edu.isistan.uima.unified.typesystems.nlp.Token");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Token_Type)jcasType).casFeatCode_lemma);}
    
  /** setter for lemma - sets  
   * @generated */
  public void setLemma(String v) {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_lemma == null)
      jcasType.jcas.throwFeatMissing("lemma", "edu.isistan.uima.unified.typesystems.nlp.Token");
    jcasType.ll_cas.ll_setStringValue(addr, ((Token_Type)jcasType).casFeatCode_lemma, v);}    
   
    
  //*--------------*
  //* Feature: morph

  /** getter for morph - gets 
   * @generated */
  public String getMorph() {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_morph == null)
      jcasType.jcas.throwFeatMissing("morph", "edu.isistan.uima.unified.typesystems.nlp.Token");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Token_Type)jcasType).casFeatCode_morph);}
    
  /** setter for morph - sets  
   * @generated */
  public void setMorph(String v) {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_morph == null)
      jcasType.jcas.throwFeatMissing("morph", "edu.isistan.uima.unified.typesystems.nlp.Token");
    jcasType.ll_cas.ll_setStringValue(addr, ((Token_Type)jcasType).casFeatCode_morph, v);}    
   
    
  //*--------------*
  //* Feature: pos

  /** getter for pos - gets 
   * @generated */
  public String getPos() {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_pos == null)
      jcasType.jcas.throwFeatMissing("pos", "edu.isistan.uima.unified.typesystems.nlp.Token");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Token_Type)jcasType).casFeatCode_pos);}
    
  /** setter for pos - sets  
   * @generated */
  public void setPos(String v) {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_pos == null)
      jcasType.jcas.throwFeatMissing("pos", "edu.isistan.uima.unified.typesystems.nlp.Token");
    jcasType.ll_cas.ll_setStringValue(addr, ((Token_Type)jcasType).casFeatCode_pos, v);}    
   
    
  //*--------------*
  //* Feature: probability

  /** getter for probability - gets 
   * @generated */
  public double getProbability() {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_probability == null)
      jcasType.jcas.throwFeatMissing("probability", "edu.isistan.uima.unified.typesystems.nlp.Token");
    return jcasType.ll_cas.ll_getDoubleValue(addr, ((Token_Type)jcasType).casFeatCode_probability);}
    
  /** setter for probability - sets  
   * @generated */
  public void setProbability(double v) {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_probability == null)
      jcasType.jcas.throwFeatMissing("probability", "edu.isistan.uima.unified.typesystems.nlp.Token");
    jcasType.ll_cas.ll_setDoubleValue(addr, ((Token_Type)jcasType).casFeatCode_probability, v);}    
   
    
  //*--------------*
  //* Feature: stopword

  /** getter for stopword - gets 
   * @generated */
  public boolean getStopword() {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_stopword == null)
      jcasType.jcas.throwFeatMissing("stopword", "edu.isistan.uima.unified.typesystems.nlp.Token");
    return jcasType.ll_cas.ll_getBooleanValue(addr, ((Token_Type)jcasType).casFeatCode_stopword);}
    
  /** setter for stopword - sets  
   * @generated */
  public void setStopword(boolean v) {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_stopword == null)
      jcasType.jcas.throwFeatMissing("stopword", "edu.isistan.uima.unified.typesystems.nlp.Token");
    jcasType.ll_cas.ll_setBooleanValue(addr, ((Token_Type)jcasType).casFeatCode_stopword, v);}    
   
    
  //*--------------*
  //* Feature: stem

  /** getter for stem - gets 
   * @generated */
  public String getStem() {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_stem == null)
      jcasType.jcas.throwFeatMissing("stem", "edu.isistan.uima.unified.typesystems.nlp.Token");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Token_Type)jcasType).casFeatCode_stem);}
    
  /** setter for stem - sets  
   * @generated */
  public void setStem(String v) {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_stem == null)
      jcasType.jcas.throwFeatMissing("stem", "edu.isistan.uima.unified.typesystems.nlp.Token");
    jcasType.ll_cas.ll_setStringValue(addr, ((Token_Type)jcasType).casFeatCode_stem, v);}    
  }

    