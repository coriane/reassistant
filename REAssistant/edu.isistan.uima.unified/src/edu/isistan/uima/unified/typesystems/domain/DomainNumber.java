

/* First created by JCasGen Wed Jun 01 16:54:23 ART 2011 */
package edu.isistan.uima.unified.typesystems.domain;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import edu.isistan.uima.unified.typesystems.IdentifiableAnnotation;


/** 
 * Updated by JCasGen Wed Jun 01 16:56:12 ART 2011
 * XML source: C:/Work/REAssistant/edu.isistan.uima.unified/desc/typesystems/domain/DomainNumberTypeDescriptor.xml
 * @generated */
public class DomainNumber extends IdentifiableAnnotation {
  /** @generated
   * @ordered 
   */
  public final static int typeIndexID = JCasRegistry.register(DomainNumber.class);
  /** @generated
   * @ordered 
   */
  public final static int type = typeIndexID;
  /** @generated  */
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected DomainNumber() {}
    
  /** Internal - constructor used by generator 
   * @generated */
  public DomainNumber(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public DomainNumber(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public DomainNumber(JCas jcas, int begin, int end) {
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
     
 
    
}

    