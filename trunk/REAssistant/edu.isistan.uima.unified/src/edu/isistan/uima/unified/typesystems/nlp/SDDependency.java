

/* First created by JCasGen Fri Mar 11 15:22:43 ART 2011 */
package edu.isistan.uima.unified.typesystems.nlp;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import edu.isistan.uima.unified.typesystems.IdentifiableAnnotation;


/** 
 * Updated by JCasGen Fri Mar 11 15:22:43 ART 2011
 * XML source: C:/Work/REAssistant/edu.isistan.uima.unified/desc/typesystems/nlp/SDDependencyTypeDescriptor.xml
 * @generated */
public class SDDependency extends IdentifiableAnnotation {
  /** @generated
   * @ordered 
   */
  public final static int typeIndexID = JCasRegistry.register(SDDependency.class);
  /** @generated
   * @ordered 
   */
  public final static int type = typeIndexID;
  /** @generated  */
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected SDDependency() {}
    
  /** Internal - constructor used by generator 
   * @generated */
  public SDDependency(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public SDDependency(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public SDDependency(JCas jcas, int begin, int end) {
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
    if (SDDependency_Type.featOkTst && ((SDDependency_Type)jcasType).casFeat_relation == null)
      jcasType.jcas.throwFeatMissing("relation", "edu.isistan.uima.unified.typesystems.nlp.SDDependency");
    return jcasType.ll_cas.ll_getStringValue(addr, ((SDDependency_Type)jcasType).casFeatCode_relation);}
    
  /** setter for relation - sets  
   * @generated */
  public void setRelation(String v) {
    if (SDDependency_Type.featOkTst && ((SDDependency_Type)jcasType).casFeat_relation == null)
      jcasType.jcas.throwFeatMissing("relation", "edu.isistan.uima.unified.typesystems.nlp.SDDependency");
    jcasType.ll_cas.ll_setStringValue(addr, ((SDDependency_Type)jcasType).casFeatCode_relation, v);}    
   
    
  //*--------------*
  //* Feature: gov

  /** getter for gov - gets 
   * @generated */
  public Token getGov() {
    if (SDDependency_Type.featOkTst && ((SDDependency_Type)jcasType).casFeat_gov == null)
      jcasType.jcas.throwFeatMissing("gov", "edu.isistan.uima.unified.typesystems.nlp.SDDependency");
    return (Token)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((SDDependency_Type)jcasType).casFeatCode_gov)));}
    
  /** setter for gov - sets  
   * @generated */
  public void setGov(Token v) {
    if (SDDependency_Type.featOkTst && ((SDDependency_Type)jcasType).casFeat_gov == null)
      jcasType.jcas.throwFeatMissing("gov", "edu.isistan.uima.unified.typesystems.nlp.SDDependency");
    jcasType.ll_cas.ll_setRefValue(addr, ((SDDependency_Type)jcasType).casFeatCode_gov, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: dep

  /** getter for dep - gets 
   * @generated */
  public Token getDep() {
    if (SDDependency_Type.featOkTst && ((SDDependency_Type)jcasType).casFeat_dep == null)
      jcasType.jcas.throwFeatMissing("dep", "edu.isistan.uima.unified.typesystems.nlp.SDDependency");
    return (Token)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((SDDependency_Type)jcasType).casFeatCode_dep)));}
    
  /** setter for dep - sets  
   * @generated */
  public void setDep(Token v) {
    if (SDDependency_Type.featOkTst && ((SDDependency_Type)jcasType).casFeat_dep == null)
      jcasType.jcas.throwFeatMissing("dep", "edu.isistan.uima.unified.typesystems.nlp.SDDependency");
    jcasType.ll_cas.ll_setRefValue(addr, ((SDDependency_Type)jcasType).casFeatCode_dep, jcasType.ll_cas.ll_getFSRef(v));}    
  }

    