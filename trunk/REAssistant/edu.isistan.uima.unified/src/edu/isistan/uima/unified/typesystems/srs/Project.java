

/* First created by JCasGen Fri Mar 11 15:23:09 ART 2011 */
package edu.isistan.uima.unified.typesystems.srs;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import edu.isistan.uima.unified.typesystems.IdentifiableAnnotation;


/** 
 * Updated by JCasGen Fri Mar 11 15:23:09 ART 2011
 * XML source: C:/Work/REAssistant/edu.isistan.uima.unified/desc/typesystems/srs/ProjectTypeDescriptor.xml
 * @generated */
public class Project extends IdentifiableAnnotation {
  /** @generated
   * @ordered 
   */
  public final static int typeIndexID = JCasRegistry.register(Project.class);
  /** @generated
   * @ordered 
   */
  public final static int type = typeIndexID;
  /** @generated  */
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected Project() {}
    
  /** Internal - constructor used by generator 
   * @generated */
  public Project(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public Project(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public Project(JCas jcas, int begin, int end) {
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
  //* Feature: id

  /** getter for id - gets 
   * @generated */
  public String getId() {
    if (Project_Type.featOkTst && ((Project_Type)jcasType).casFeat_id == null)
      jcasType.jcas.throwFeatMissing("id", "edu.isistan.uima.unified.typesystems.srs.Project");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Project_Type)jcasType).casFeatCode_id);}
    
  /** setter for id - sets  
   * @generated */
  public void setId(String v) {
    if (Project_Type.featOkTst && ((Project_Type)jcasType).casFeat_id == null)
      jcasType.jcas.throwFeatMissing("id", "edu.isistan.uima.unified.typesystems.srs.Project");
    jcasType.ll_cas.ll_setStringValue(addr, ((Project_Type)jcasType).casFeatCode_id, v);}    
   
    
  //*--------------*
  //* Feature: name

  /** getter for name - gets 
   * @generated */
  public String getName() {
    if (Project_Type.featOkTst && ((Project_Type)jcasType).casFeat_name == null)
      jcasType.jcas.throwFeatMissing("name", "edu.isistan.uima.unified.typesystems.srs.Project");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Project_Type)jcasType).casFeatCode_name);}
    
  /** setter for name - sets  
   * @generated */
  public void setName(String v) {
    if (Project_Type.featOkTst && ((Project_Type)jcasType).casFeat_name == null)
      jcasType.jcas.throwFeatMissing("name", "edu.isistan.uima.unified.typesystems.srs.Project");
    jcasType.ll_cas.ll_setStringValue(addr, ((Project_Type)jcasType).casFeatCode_name, v);}    
   
    
  //*--------------*
  //* Feature: content

  /** getter for content - gets 
   * @generated */
  public String getContent() {
    if (Project_Type.featOkTst && ((Project_Type)jcasType).casFeat_content == null)
      jcasType.jcas.throwFeatMissing("content", "edu.isistan.uima.unified.typesystems.srs.Project");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Project_Type)jcasType).casFeatCode_content);}
    
  /** setter for content - sets  
   * @generated */
  public void setContent(String v) {
    if (Project_Type.featOkTst && ((Project_Type)jcasType).casFeat_content == null)
      jcasType.jcas.throwFeatMissing("content", "edu.isistan.uima.unified.typesystems.srs.Project");
    jcasType.ll_cas.ll_setStringValue(addr, ((Project_Type)jcasType).casFeatCode_content, v);}    
   
    
  //*--------------*
  //* Feature: kind

  /** getter for kind - gets 
   * @generated */
  public String getKind() {
    if (Project_Type.featOkTst && ((Project_Type)jcasType).casFeat_kind == null)
      jcasType.jcas.throwFeatMissing("kind", "edu.isistan.uima.unified.typesystems.srs.Project");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Project_Type)jcasType).casFeatCode_kind);}
    
  /** setter for kind - sets  
   * @generated */
  public void setKind(String v) {
    if (Project_Type.featOkTst && ((Project_Type)jcasType).casFeat_kind == null)
      jcasType.jcas.throwFeatMissing("kind", "edu.isistan.uima.unified.typesystems.srs.Project");
    jcasType.ll_cas.ll_setStringValue(addr, ((Project_Type)jcasType).casFeatCode_kind, v);}    
   
    
  //*--------------*
  //* Feature: URI

  /** getter for URI - gets 
   * @generated */
  public String getURI() {
    if (Project_Type.featOkTst && ((Project_Type)jcasType).casFeat_URI == null)
      jcasType.jcas.throwFeatMissing("URI", "edu.isistan.uima.unified.typesystems.srs.Project");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Project_Type)jcasType).casFeatCode_URI);}
    
  /** setter for URI - sets  
   * @generated */
  public void setURI(String v) {
    if (Project_Type.featOkTst && ((Project_Type)jcasType).casFeat_URI == null)
      jcasType.jcas.throwFeatMissing("URI", "edu.isistan.uima.unified.typesystems.srs.Project");
    jcasType.ll_cas.ll_setStringValue(addr, ((Project_Type)jcasType).casFeatCode_URI, v);}    
  }

    