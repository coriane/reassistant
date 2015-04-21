# What is REAssistant? #

REAssistant is an Eclipse toolset that supports the identification of software concerns in textual requirements specifications, mainly use cases.

<p align='center'><img src='http://users.exa.unicen.edu.ar/~arago/img/Splash.png' width='100%' /></p>

To achieve its work, REAssistant is based on three pillars:
  1. an annotation-based representation of textual use cases,
  1. a pipeline of Natural Language Processing (NLP) techniques and domain knowledge (about use cases),
  1. concern-specific rules that, when executed on the use case representation, can extract concern-related information.

In this way, REAssistant aims at exposing both candidate concerns and contextual information (typically, crosscutting relations) that might be overlooked by the analyst.


# How does it works? #

  * Our tool was built as a set of Eclipse plugins. REAssistant is integrated to the Eclipse IDE and reduces the learning curve for new users.

  * The core of REAssistant relies on the [Unstructured Information Management Architecture](http://uima.apache.org/) (UIMA) to implement the linguistic analyses of the use cases. In particular, we build on the capabilities of UIMA for composing and configuring different NLP components, mostly provided by third parties. In particular, we have developed a NLP pipeline that applies techniques such as: dependency parsing, semantic role labeling, and domain actions, so as to enrich use cases with semantic information.

  * The project adopts a data-centric approach, in which the communication among different plugins is carried out through [Eclipse Modeling Framework (EMF)](http://www.eclipse.org/modeling/emf/) models (UIMA annotations are also EMF-compatible).

  * Finally, the tool relies on the [EMF/Query2](http://wiki.eclipse.org/EMF/Query2) technology to support the semi-automated search of crosscutting concerns.


# Which tools/plugins does it include? #

REAssistant provides several extensions to the Eclipse IDE:

  * **_Use Case Specification Editor_**: An editor to support the input of textual use cases, following templates from the literature.

<p align='center'><img src='http://users.exa.unicen.edu.ar/~arago/img/UCSEditor-Overview.png' width='75%' /></p>

  * **_UIMA Creation Wizard_**: A wizard that allows users to easily create an UIMA annotation file from an existing use case specification file.

<p align='center'><img src='http://users.exa.unicen.edu.ar/~arago/img/UIMAWizard.png' width='50%' /></p>

  * **_Crosscutting Concern Editor_**: An editor to support the detection of crosscutting concerns in requirements specifications. It takes both the use case specification and the UIMA annotation files.

<p align='center'><img src='http://users.exa.unicen.edu.ar/~arago/img/REAEditor-Edition.png' width='75%' /></p>

  * **_Crosscutting Concern Detector View_**: A view that allows to manage different rules for querying concerns in textual requirements.

<p align='center'><img src='http://users.exa.unicen.edu.ar/~arago/img/CCDetectorView.png' width='65%' /></p>

  * **_Croscutting Concern Evaluator View_**: A view that simplifies the evaluation of the concern detection using Information Retrieval metrics such as Precision and Recall. The outputs can be exported to a "comma-separated values" (CSV) file for further analysis.

<p align='center'><img src='http://users.exa.unicen.edu.ar/~arago/img/CCEvaluatorView-Evaluation.png' width='65%' /></p>

# How well does it perform? #

We have currently evaluated REAssistant with a number of case-studies and the results so far are encouraging, when compared to the manual identification of concerns by humans or the assistance provided by a third-party concern mining tool.

# How to contact us #

Below you will find links to the authors webpages.

  1. [Alejandro Rago](http://users.exa.unicen.edu.ar/~arago/)
  1. [Claudia Marcos](http://users.exa.unicen.edu.ar/~cmarcos/)
  1. [Andrés Diaz-Pace](http://users.exa.unicen.edu.ar/~adiaz/)