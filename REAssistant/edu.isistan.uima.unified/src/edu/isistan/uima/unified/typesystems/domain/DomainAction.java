

/* First created by JCasGen Tue May 03 10:45:54 ART 2011 */
package edu.isistan.uima.unified.typesystems.domain;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.FSArray;
import edu.isistan.uima.unified.typesystems.nlp.Token;
import edu.isistan.uima.unified.typesystems.IdentifiableAnnotation;


/** 
 * Updated by JCasGen Mon Jun 13 12:00:10 ART 2011
 * XML source: C:/Work/REAssistant/edu.isistan.uima.unified/desc/typesystems/domain/DomainActionTypeDescriptor.xml
 * @generated */
public class DomainAction extends IdentifiableAnnotation {
  /** @generated
   * @ordered 
   */
  public final static int typeIndexID = JCasRegistry.register(DomainAction.class);
  /** @generated
   * @ordered 
   */
  public final static int type = typeIndexID;
  /** @generated  */
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected DomainAction() {}
    
  /** Internal - constructor used by generator 
   * @generated */
  public DomainAction(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public DomainAction(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public DomainAction(JCas jcas, int begin, int end) {
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
  //* Feature: action

  /** getter for action - gets 
   * @generated */
  public Token getAction() {
    if (DomainAction_Type.featOkTst && ((DomainAction_Type)jcasType).casFeat_action == null)
      jcasType.jcas.throwFeatMissing("action", "edu.isistan.uima.unified.typesystems.domain.DomainAction");
    return (Token)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((DomainAction_Type)jcasType).casFeatCode_action)));}
    
  /** setter for action - sets  
   * @generated */
  public void setAction(Token v) {
    if (DomainAction_Type.featOkTst && ((DomainAction_Type)jcasType).casFeat_action == null)
      jcasType.jcas.throwFeatMissing("action", "edu.isistan.uima.unified.typesystems.domain.DomainAction");
    jcasType.ll_cas.ll_setRefValue(addr, ((DomainAction_Type)jcasType).casFeatCode_action, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: label

  /** getter for label - gets 
   * @generated */
  public String getLabel() {
    if (DomainAction_Type.featOkTst && ((DomainAction_Type)jcasType).casFeat_label == null)
      jcasType.jcas.throwFeatMissing("label", "edu.isistan.uima.unified.typesystems.domain.DomainAction");
    return jcasType.ll_cas.ll_getStringValue(addr, ((DomainAction_Type)jcasType).casFeatCode_label);}
    
  /** setter for label - sets  
   * @generated */
  public void setLabel(String v) {
    if (DomainAction_Type.featOkTst && ((DomainAction_Type)jcasType).casFeat_label == null)
      jcasType.jcas.throwFeatMissing("label", "edu.isistan.uima.unified.typesystems.domain.DomainAction");
    jcasType.ll_cas.ll_setStringValue(addr, ((DomainAction_Type)jcasType).casFeatCode_label, v);}    
   
    
  //*--------------*
  //* Feature: confidence

  /** getter for confidence - gets 
   * @generated */
  public double getConfidence() {
    if (DomainAction_Type.featOkTst && ((DomainAction_Type)jcasType).casFeat_confidence == null)
      jcasType.jcas.throwFeatMissing("confidence", "edu.isistan.uima.unified.typesystems.domain.DomainAction");
    return jcasType.ll_cas.ll_getDoubleValue(addr, ((DomainAction_Type)jcasType).casFeatCode_confidence);}
    
  /** setter for confidence - sets  
   * @generated */
  public void setConfidence(double v) {
    if (DomainAction_Type.featOkTst && ((DomainAction_Type)jcasType).casFeat_confidence == null)
      jcasType.jcas.throwFeatMissing("confidence", "edu.isistan.uima.unified.typesystems.domain.DomainAction");
    jcasType.ll_cas.ll_setDoubleValue(addr, ((DomainAction_Type)jcasType).casFeatCode_confidence, v);}    
   
    
  //*--------------*
  //* Feature: ranking

  /** getter for ranking - gets 
   * @generated */
  public int getRanking() {
    if (DomainAction_Type.featOkTst && ((DomainAction_Type)jcasType).casFeat_ranking == null)
      jcasType.jcas.throwFeatMissing("ranking", "edu.isistan.uima.unified.typesystems.domain.DomainAction");
    return jcasType.ll_cas.ll_getIntValue(addr, ((DomainAction_Type)jcasType).casFeatCode_ranking);}
    
  /** setter for ranking - sets  
   * @generated */
  public void setRanking(int v) {
    if (DomainAction_Type.featOkTst && ((DomainAction_Type)jcasType).casFeat_ranking == null)
      jcasType.jcas.throwFeatMissing("ranking", "edu.isistan.uima.unified.typesystems.domain.DomainAction");
    jcasType.ll_cas.ll_setIntValue(addr, ((DomainAction_Type)jcasType).casFeatCode_ranking, v);}    
   
    
  //*--------------*
  //* Feature: parent

  /** getter for parent - gets 
   * @generated */
  public DomainAction getParent() {
    if (DomainAction_Type.featOkTst && ((DomainAction_Type)jcasType).casFeat_parent == null)
      jcasType.jcas.throwFeatMissing("parent", "edu.isistan.uima.unified.typesystems.domain.DomainAction");
    return (DomainAction)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((DomainAction_Type)jcasType).casFeatCode_parent)));}
    
  /** setter for parent - sets  
   * @generated */
  public void setParent(DomainAction v) {
    if (DomainAction_Type.featOkTst && ((DomainAction_Type)jcasType).casFeat_parent == null)
      jcasType.jcas.throwFeatMissing("parent", "edu.isistan.uima.unified.typesystems.domain.DomainAction");
    jcasType.ll_cas.ll_setRefValue(addr, ((DomainAction_Type)jcasType).casFeatCode_parent, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: childs

  /** getter for childs - gets 
   * @generated */
  public FSArray getChilds() {
    if (DomainAction_Type.featOkTst && ((DomainAction_Type)jcasType).casFeat_childs == null)
      jcasType.jcas.throwFeatMissing("childs", "edu.isistan.uima.unified.typesystems.domain.DomainAction");
    return (FSArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((DomainAction_Type)jcasType).casFeatCode_childs)));}
    
  /** setter for childs - sets  
   * @generated */
  public void setChilds(FSArray v) {
    if (DomainAction_Type.featOkTst && ((DomainAction_Type)jcasType).casFeat_childs == null)
      jcasType.jcas.throwFeatMissing("childs", "edu.isistan.uima.unified.typesystems.domain.DomainAction");
    jcasType.ll_cas.ll_setRefValue(addr, ((DomainAction_Type)jcasType).casFeatCode_childs, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for childs - gets an indexed value - 
   * @generated */
  public DomainAction getChilds(int i) {
    if (DomainAction_Type.featOkTst && ((DomainAction_Type)jcasType).casFeat_childs == null)
      jcasType.jcas.throwFeatMissing("childs", "edu.isistan.uima.unified.typesystems.domain.DomainAction");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((DomainAction_Type)jcasType).casFeatCode_childs), i);
    return (DomainAction)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((DomainAction_Type)jcasType).casFeatCode_childs), i)));}

  /** indexed setter for childs - sets an indexed value - 
   * @generated */
  public void setChilds(int i, DomainAction v) { 
    if (DomainAction_Type.featOkTst && ((DomainAction_Type)jcasType).casFeat_childs == null)
      jcasType.jcas.throwFeatMissing("childs", "edu.isistan.uima.unified.typesystems.domain.DomainAction");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((DomainAction_Type)jcasType).casFeatCode_childs), i);
    jcasType.ll_cas.ll_setRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((DomainAction_Type)jcasType).casFeatCode_childs), i, jcasType.ll_cas.ll_getFSRef(v));}
  }

    