

/* First created by JCasGen Mon Dec 29 18:34:55 ART 2014 */
package edu.isistan.uima.unified.typesystems.srs;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import edu.isistan.uima.unified.typesystems.IdentifiableAnnotation;


/** 
 * Updated by JCasGen Tue Dec 30 11:22:03 ART 2014
 * XML source: /Users/alejandrorago/Documents/Implementacion/Proyectos/REAssistant-SVN/REAssistant/edu.isistan.uima.unified/desc/typesystems/ECoreTypeDescriptor.xml
 * @generated */
public class Project extends IdentifiableAnnotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Project.class);
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
  protected Project() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public Project(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public Project(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public Project(JCas jcas, int begin, int end) {
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
  //* Feature: id

  /** getter for id - gets 
   * @generated
   * @return value of the feature 
   */
  public String getId() {
    if (Project_Type.featOkTst && ((Project_Type)jcasType).casFeat_id == null)
      jcasType.jcas.throwFeatMissing("id", "edu.isistan.uima.unified.typesystems.srs.Project");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Project_Type)jcasType).casFeatCode_id);}
    
  /** setter for id - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setId(String v) {
    if (Project_Type.featOkTst && ((Project_Type)jcasType).casFeat_id == null)
      jcasType.jcas.throwFeatMissing("id", "edu.isistan.uima.unified.typesystems.srs.Project");
    jcasType.ll_cas.ll_setStringValue(addr, ((Project_Type)jcasType).casFeatCode_id, v);}    
   
    
  //*--------------*
  //* Feature: name

  /** getter for name - gets 
   * @generated
   * @return value of the feature 
   */
  public String getName() {
    if (Project_Type.featOkTst && ((Project_Type)jcasType).casFeat_name == null)
      jcasType.jcas.throwFeatMissing("name", "edu.isistan.uima.unified.typesystems.srs.Project");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Project_Type)jcasType).casFeatCode_name);}
    
  /** setter for name - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setName(String v) {
    if (Project_Type.featOkTst && ((Project_Type)jcasType).casFeat_name == null)
      jcasType.jcas.throwFeatMissing("name", "edu.isistan.uima.unified.typesystems.srs.Project");
    jcasType.ll_cas.ll_setStringValue(addr, ((Project_Type)jcasType).casFeatCode_name, v);}    
   
    
  //*--------------*
  //* Feature: content

  /** getter for content - gets 
   * @generated
   * @return value of the feature 
   */
  public String getContent() {
    if (Project_Type.featOkTst && ((Project_Type)jcasType).casFeat_content == null)
      jcasType.jcas.throwFeatMissing("content", "edu.isistan.uima.unified.typesystems.srs.Project");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Project_Type)jcasType).casFeatCode_content);}
    
  /** setter for content - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setContent(String v) {
    if (Project_Type.featOkTst && ((Project_Type)jcasType).casFeat_content == null)
      jcasType.jcas.throwFeatMissing("content", "edu.isistan.uima.unified.typesystems.srs.Project");
    jcasType.ll_cas.ll_setStringValue(addr, ((Project_Type)jcasType).casFeatCode_content, v);}    
   
    
  //*--------------*
  //* Feature: kind

  /** getter for kind - gets 
   * @generated
   * @return value of the feature 
   */
  public String getKind() {
    if (Project_Type.featOkTst && ((Project_Type)jcasType).casFeat_kind == null)
      jcasType.jcas.throwFeatMissing("kind", "edu.isistan.uima.unified.typesystems.srs.Project");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Project_Type)jcasType).casFeatCode_kind);}
    
  /** setter for kind - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setKind(String v) {
    if (Project_Type.featOkTst && ((Project_Type)jcasType).casFeat_kind == null)
      jcasType.jcas.throwFeatMissing("kind", "edu.isistan.uima.unified.typesystems.srs.Project");
    jcasType.ll_cas.ll_setStringValue(addr, ((Project_Type)jcasType).casFeatCode_kind, v);}    
   
    
  //*--------------*
  //* Feature: URI

  /** getter for URI - gets 
   * @generated
   * @return value of the feature 
   */
  public String getURI() {
    if (Project_Type.featOkTst && ((Project_Type)jcasType).casFeat_URI == null)
      jcasType.jcas.throwFeatMissing("URI", "edu.isistan.uima.unified.typesystems.srs.Project");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Project_Type)jcasType).casFeatCode_URI);}
    
  /** setter for URI - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setURI(String v) {
    if (Project_Type.featOkTst && ((Project_Type)jcasType).casFeat_URI == null)
      jcasType.jcas.throwFeatMissing("URI", "edu.isistan.uima.unified.typesystems.srs.Project");
    jcasType.ll_cas.ll_setStringValue(addr, ((Project_Type)jcasType).casFeatCode_URI, v);}    
  }

    