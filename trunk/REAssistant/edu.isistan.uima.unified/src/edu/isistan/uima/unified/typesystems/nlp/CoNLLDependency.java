

/* First created by JCasGen Fri Mar 11 15:22:30 ART 2011 */
package edu.isistan.uima.unified.typesystems.nlp;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import edu.isistan.uima.unified.typesystems.IdentifiableAnnotation;


/** 
 * Updated by JCasGen Fri Mar 11 15:22:30 ART 2011
 * XML source: C:/Work/REAssistant/edu.isistan.uima.unified/desc/typesystems/nlp/CoNLLDependencyTypeDescriptor.xml
 * @generated */
public class CoNLLDependency extends IdentifiableAnnotation {
  /** @generated
   * @ordered 
   */
  public final static int typeIndexID = JCasRegistry.register(CoNLLDependency.class);
  /** @generated
   * @ordered 
   */
  public final static int type = typeIndexID;
  /** @generated  */
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected CoNLLDependency() {}
    
  /** Internal - constructor used by generator 
   * @generated */
  public CoNLLDependency(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public CoNLLDependency(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public CoNLLDependency(JCas jcas, int begin, int end) {
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
  //* Feature: relation

  /** getter for relation - gets 
   * @generated */
  public String getRelation() {
    if (CoNLLDependency_Type.featOkTst && ((CoNLLDependency_Type)jcasType).casFeat_relation == null)
      jcasType.jcas.throwFeatMissing("relation", "edu.isistan.uima.unified.typesystems.nlp.CoNLLDependency");
    return jcasType.ll_cas.ll_getStringValue(addr, ((CoNLLDependency_Type)jcasType).casFeatCode_relation);}
    
  /** setter for relation - sets  
   * @generated */
  public void setRelation(String v) {
    if (CoNLLDependency_Type.featOkTst && ((CoNLLDependency_Type)jcasType).casFeat_relation == null)
      jcasType.jcas.throwFeatMissing("relation", "edu.isistan.uima.unified.typesystems.nlp.CoNLLDependency");
    jcasType.ll_cas.ll_setStringValue(addr, ((CoNLLDependency_Type)jcasType).casFeatCode_relation, v);}    
   
    
  //*--------------*
  //* Feature: source

  /** getter for source - gets 
   * @generated */
  public Token getSource() {
    if (CoNLLDependency_Type.featOkTst && ((CoNLLDependency_Type)jcasType).casFeat_source == null)
      jcasType.jcas.throwFeatMissing("source", "edu.isistan.uima.unified.typesystems.nlp.CoNLLDependency");
    return (Token)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((CoNLLDependency_Type)jcasType).casFeatCode_source)));}
    
  /** setter for source - sets  
   * @generated */
  public void setSource(Token v) {
    if (CoNLLDependency_Type.featOkTst && ((CoNLLDependency_Type)jcasType).casFeat_source == null)
      jcasType.jcas.throwFeatMissing("source", "edu.isistan.uima.unified.typesystems.nlp.CoNLLDependency");
    jcasType.ll_cas.ll_setRefValue(addr, ((CoNLLDependency_Type)jcasType).casFeatCode_source, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: target

  /** getter for target - gets 
   * @generated */
  public Token getTarget() {
    if (CoNLLDependency_Type.featOkTst && ((CoNLLDependency_Type)jcasType).casFeat_target == null)
      jcasType.jcas.throwFeatMissing("target", "edu.isistan.uima.unified.typesystems.nlp.CoNLLDependency");
    return (Token)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((CoNLLDependency_Type)jcasType).casFeatCode_target)));}
    
  /** setter for target - sets  
   * @generated */
  public void setTarget(Token v) {
    if (CoNLLDependency_Type.featOkTst && ((CoNLLDependency_Type)jcasType).casFeat_target == null)
      jcasType.jcas.throwFeatMissing("target", "edu.isistan.uima.unified.typesystems.nlp.CoNLLDependency");
    jcasType.ll_cas.ll_setRefValue(addr, ((CoNLLDependency_Type)jcasType).casFeatCode_target, jcasType.ll_cas.ll_getFSRef(v));}    
  }

    