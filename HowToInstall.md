# Setup #

REAssistant is composed of several Eclipse plugins. These plugins have been implemented using the latest version of Eclipse, and for this reason, a few steps are necessary to setup the REAssistant environment.

## First Step ##

Download a clean version of Eclipse 3.7 SR2, and install the following "dependant" plugins. To do that, in Eclipse, click Help > Install New Software.

First, install the following plugins:

  * EMF (Eclipse Modeling Framework)
  * EMF Query

The plugins above can be found at the _Eclipse Indigo Update Site_, included with eclipse.

Then, add the following _Update Sites_ and install them.

  * UIMA - http://www.apache.org/dist/uima/eclipse-update-site/
  * EMF Query2 - https://hudson.eclipse.org/hudson/job/tycho-query2-nightly/lastSuccessfulBuild/artifact/targetPlatform/
  * AJDT - http://download.eclipse.org/tools/ajdt/37/update
  * WindowBuilder Pro - http://dl.google.com/eclipse/inst/d2wbpro/latest/3.7

## Second Step ##

Copy **REAssistant plugin** jars (downloaded from the **Downloads** page) to the _plugins_ folder of Eclipse.

## Third Step ##

Download the _REAssistant models_. One part of the models are available in the SVN, and the other is available separately (due to its size) from the following link in dropbox: **_[REAssistant-models\_1.0.0.201203131454.zip](https://www.dropbox.com/s/j44e10gl8x24j6r/REAssistant-models_1.0.0.201203131454.zip)_**. Uncompress the zip into a folder, merge the contents with the SVN models and modify the **_eclipse.ini_** file adding the following environment variable:

  * MODELS\_PATH=C:/Your/Path/REAssistant-models/ at _eclipse.ini_

This way, we link the variable to the models folder.

That's all!, you can now execute and use REAssistant in your computer.