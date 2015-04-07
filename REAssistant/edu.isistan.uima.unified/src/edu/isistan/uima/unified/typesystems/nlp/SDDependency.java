

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
public class SDDependency extends IdentifiableAnnotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(SDDependency.class);
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
  protected SDDependency() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public SDDependency(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public SDDependency(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public SDDependency(JCas jcas, int begin, int end) {
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
    if (SDDependency_Type.featOkTst && ((SDDependency_Type)jcasType).casFeat_relation == null)
      jcasType.jcas.throwFeatMissing("relation", "edu.isistan.uima.unified.typesystems.nlp.SDDependency");
    return jcasType.ll_cas.ll_getStringValue(addr, ((SDDependency_Type)jcasType).casFeatCode_relation);}
    
  /** setter for relation - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setRelation(String v) {
    if (SDDependency_Type.featOkTst && ((SDDependency_Type)jcasType).casFeat_relation == null)
      jcasType.jcas.throwFeatMissing("relation", "edu.isistan.uima.unified.typesystems.nlp.SDDependency");
    jcasType.ll_cas.ll_setStringValue(addr, ((SDDependency_Type)jcasType).casFeatCode_relation, v);}    
   
    
  //*--------------*
  //* Feature: gov

  /** getter for gov - gets 
   * @generated
   * @return value of the feature 
   */
  public Token getGov() {
    if (SDDependency_Type.featOkTst && ((SDDependency_Type)jcasType).casFeat_gov == null)
      jcasType.jcas.throwFeatMissing("gov", "edu.isistan.uima.unified.typesystems.nlp.SDDependency");
    return (Token)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((SDDependency_Type)jcasType).casFeatCode_gov)));}
    
  /** setter for gov - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setGov(Token v) {
    if (SDDependency_Type.featOkTst && ((SDDependency_Type)jcasType).casFeat_gov == null)
      jcasType.jcas.throwFeatMissing("gov", "edu.isistan.uima.unified.typesystems.nlp.SDDependency");
    jcasType.ll_cas.ll_setRefValue(addr, ((SDDependency_Type)jcasType).casFeatCode_gov, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: dep

  /** getter for dep - gets 
   * @generated
   * @return value of the feature 
   */
  public Token getDep() {
    if (SDDependency_Type.featOkTst && ((SDDependency_Type)jcasType).casFeat_dep == null)
      jcasType.jcas.throwFeatMissing("dep", "edu.isistan.uima.unified.typesystems.nlp.SDDependency");
    return (Token)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((SDDependency_Type)jcasType).casFeatCode_dep)));}
    
  /** setter for dep - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setDep(Token v) {
    if (SDDependency_Type.featOkTst && ((SDDependency_Type)jcasType).casFeat_dep == null)
      jcasType.jcas.throwFeatMissing("dep", "edu.isistan.uima.unified.typesystems.nlp.SDDependency");
    jcasType.ll_cas.ll_setRefValue(addr, ((SDDependency_Type)jcasType).casFeatCode_dep, jcasType.ll_cas.ll_getFSRef(v));}    
  }

    