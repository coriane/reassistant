

/* First created by JCasGen Mon Dec 29 18:34:55 ART 2014 */
package edu.isistan.uima.unified.typesystems.domain;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import edu.isistan.uima.unified.typesystems.srs.Section;
import edu.isistan.uima.unified.typesystems.srs.Document;
import edu.isistan.uima.unified.typesystems.nlp.Sentence;
import edu.isistan.uima.unified.typesystems.IdentifiableAnnotation;


/** 
 * Updated by JCasGen Tue Dec 30 11:22:03 ART 2014
 * XML source: /Users/alejandrorago/Documents/Implementacion/Proyectos/REAssistant-SVN/REAssistant/edu.isistan.uima.unified/desc/typesystems/ECoreTypeDescriptor.xml
 * @generated */
public class CrosscuttingConcern extends IdentifiableAnnotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(CrosscuttingConcern.class);
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
  protected CrosscuttingConcern() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public CrosscuttingConcern(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public CrosscuttingConcern(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public CrosscuttingConcern(JCas jcas, int begin, int end) {
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
  //* Feature: name

  /** getter for name - gets 
   * @generated
   * @return value of the feature 
   */
  public String getName() {
    if (CrosscuttingConcern_Type.featOkTst && ((CrosscuttingConcern_Type)jcasType).casFeat_name == null)
      jcasType.jcas.throwFeatMissing("name", "edu.isistan.uima.unified.typesystems.domain.CrosscuttingConcern");
    return jcasType.ll_cas.ll_getStringValue(addr, ((CrosscuttingConcern_Type)jcasType).casFeatCode_name);}
    
  /** setter for name - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setName(String v) {
    if (CrosscuttingConcern_Type.featOkTst && ((CrosscuttingConcern_Type)jcasType).casFeat_name == null)
      jcasType.jcas.throwFeatMissing("name", "edu.isistan.uima.unified.typesystems.domain.CrosscuttingConcern");
    jcasType.ll_cas.ll_setStringValue(addr, ((CrosscuttingConcern_Type)jcasType).casFeatCode_name, v);}    
   
    
  //*--------------*
  //* Feature: kind

  /** getter for kind - gets 
   * @generated
   * @return value of the feature 
   */
  public String getKind() {
    if (CrosscuttingConcern_Type.featOkTst && ((CrosscuttingConcern_Type)jcasType).casFeat_kind == null)
      jcasType.jcas.throwFeatMissing("kind", "edu.isistan.uima.unified.typesystems.domain.CrosscuttingConcern");
    return jcasType.ll_cas.ll_getStringValue(addr, ((CrosscuttingConcern_Type)jcasType).casFeatCode_kind);}
    
  /** setter for kind - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setKind(String v) {
    if (CrosscuttingConcern_Type.featOkTst && ((CrosscuttingConcern_Type)jcasType).casFeat_kind == null)
      jcasType.jcas.throwFeatMissing("kind", "edu.isistan.uima.unified.typesystems.domain.CrosscuttingConcern");
    jcasType.ll_cas.ll_setStringValue(addr, ((CrosscuttingConcern_Type)jcasType).casFeatCode_kind, v);}    
   
    
  //*--------------*
  //* Feature: sentence

  /** getter for sentence - gets 
   * @generated
   * @return value of the feature 
   */
  public Sentence getSentence() {
    if (CrosscuttingConcern_Type.featOkTst && ((CrosscuttingConcern_Type)jcasType).casFeat_sentence == null)
      jcasType.jcas.throwFeatMissing("sentence", "edu.isistan.uima.unified.typesystems.domain.CrosscuttingConcern");
    return (Sentence)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((CrosscuttingConcern_Type)jcasType).casFeatCode_sentence)));}
    
  /** setter for sentence - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setSentence(Sentence v) {
    if (CrosscuttingConcern_Type.featOkTst && ((CrosscuttingConcern_Type)jcasType).casFeat_sentence == null)
      jcasType.jcas.throwFeatMissing("sentence", "edu.isistan.uima.unified.typesystems.domain.CrosscuttingConcern");
    jcasType.ll_cas.ll_setRefValue(addr, ((CrosscuttingConcern_Type)jcasType).casFeatCode_sentence, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: section

  /** getter for section - gets 
   * @generated
   * @return value of the feature 
   */
  public Section getSection() {
    if (CrosscuttingConcern_Type.featOkTst && ((CrosscuttingConcern_Type)jcasType).casFeat_section == null)
      jcasType.jcas.throwFeatMissing("section", "edu.isistan.uima.unified.typesystems.domain.CrosscuttingConcern");
    return (Section)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((CrosscuttingConcern_Type)jcasType).casFeatCode_section)));}
    
  /** setter for section - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setSection(Section v) {
    if (CrosscuttingConcern_Type.featOkTst && ((CrosscuttingConcern_Type)jcasType).casFeat_section == null)
      jcasType.jcas.throwFeatMissing("section", "edu.isistan.uima.unified.typesystems.domain.CrosscuttingConcern");
    jcasType.ll_cas.ll_setRefValue(addr, ((CrosscuttingConcern_Type)jcasType).casFeatCode_section, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: document

  /** getter for document - gets 
   * @generated
   * @return value of the feature 
   */
  public Document getDocument() {
    if (CrosscuttingConcern_Type.featOkTst && ((CrosscuttingConcern_Type)jcasType).casFeat_document == null)
      jcasType.jcas.throwFeatMissing("document", "edu.isistan.uima.unified.typesystems.domain.CrosscuttingConcern");
    return (Document)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((CrosscuttingConcern_Type)jcasType).casFeatCode_document)));}
    
  /** setter for document - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setDocument(Document v) {
    if (CrosscuttingConcern_Type.featOkTst && ((CrosscuttingConcern_Type)jcasType).casFeat_document == null)
      jcasType.jcas.throwFeatMissing("document", "edu.isistan.uima.unified.typesystems.domain.CrosscuttingConcern");
    jcasType.ll_cas.ll_setRefValue(addr, ((CrosscuttingConcern_Type)jcasType).casFeatCode_document, jcasType.ll_cas.ll_getFSRef(v));}    
  }

    