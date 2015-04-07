

/* First created by JCasGen Mon Dec 29 18:34:55 ART 2014 */
package edu.isistan.uima.unified.typesystems.nlp;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import edu.isistan.uima.unified.typesystems.IdentifiableAnnotation;


/** 
 * Updated by JCasGen Tue Dec 30 11:22:03 ART 2014
 * XML source: /Users/alejandrorago/Documents/Implementacion/Proyectos/REAssistant-SVN/REAssistant/edu.isistan.uima.unified/desc/typesystems/ECoreTypeDescriptor.xml
 * @generated */
public class CoNLLDependency extends IdentifiableAnnotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(CoNLLDependency.class);
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
  protected CoNLLDependency() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public CoNLLDependency(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public CoNLLDependency(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public CoNLLDependency(JCas jcas, int begin, int end) {
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
  //* Feature: relation

  /** getter for relation - gets 
   * @generated
   * @return value of the feature 
   */
  public String getRelation() {
    if (CoNLLDependency_Type.featOkTst && ((CoNLLDependency_Type)jcasType).casFeat_relation == null)
      jcasType.jcas.throwFeatMissing("relation", "edu.isistan.uima.unified.typesystems.nlp.CoNLLDependency");
    return jcasType.ll_cas.ll_getStringValue(addr, ((CoNLLDependency_Type)jcasType).casFeatCode_relation);}
    
  /** setter for relation - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setRelation(String v) {
    if (CoNLLDependency_Type.featOkTst && ((CoNLLDependency_Type)jcasType).casFeat_relation == null)
      jcasType.jcas.throwFeatMissing("relation", "edu.isistan.uima.unified.typesystems.nlp.CoNLLDependency");
    jcasType.ll_cas.ll_setStringValue(addr, ((CoNLLDependency_Type)jcasType).casFeatCode_relation, v);}    
   
    
  //*--------------*
  //* Feature: source

  /** getter for source - gets 
   * @generated
   * @return value of the feature 
   */
  public Token getSource() {
    if (CoNLLDependency_Type.featOkTst && ((CoNLLDependency_Type)jcasType).casFeat_source == null)
      jcasType.jcas.throwFeatMissing("source", "edu.isistan.uima.unified.typesystems.nlp.CoNLLDependency");
    return (Token)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((CoNLLDependency_Type)jcasType).casFeatCode_source)));}
    
  /** setter for source - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setSource(Token v) {
    if (CoNLLDependency_Type.featOkTst && ((CoNLLDependency_Type)jcasType).casFeat_source == null)
      jcasType.jcas.throwFeatMissing("source", "edu.isistan.uima.unified.typesystems.nlp.CoNLLDependency");
    jcasType.ll_cas.ll_setRefValue(addr, ((CoNLLDependency_Type)jcasType).casFeatCode_source, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: target

  /** getter for target - gets 
   * @generated
   * @return value of the feature 
   */
  public Token getTarget() {
    if (CoNLLDependency_Type.featOkTst && ((CoNLLDependency_Type)jcasType).casFeat_target == null)
      jcasType.jcas.throwFeatMissing("target", "edu.isistan.uima.unified.typesystems.nlp.CoNLLDependency");
    return (Token)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((CoNLLDependency_Type)jcasType).casFeatCode_target)));}
    
  /** setter for target - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setTarget(Token v) {
    if (CoNLLDependency_Type.featOkTst && ((CoNLLDependency_Type)jcasType).casFeat_target == null)
      jcasType.jcas.throwFeatMissing("target", "edu.isistan.uima.unified.typesystems.nlp.CoNLLDependency");
    jcasType.ll_cas.ll_setRefValue(addr, ((CoNLLDependency_Type)jcasType).casFeatCode_target, jcasType.ll_cas.ll_getFSRef(v));}    
  }

    