#path
path <- "/Users/alejandrorago/Documents/Implementacion/Proyectos/REAssistant-SVN/runtime-EclipseApplication/Test/src/UCRefactoring-PhD/"
caseStudies <- c("CRS", "HWS", "MSLite")
caseStudy <- caseStudies[1]
caseStudyLC <- tolower(caseStudy)

#import
loadResults <- function(path, caseStudy, refactored) {
	path <- paste(path, caseStudy, refactored, "/", sep="")
	setwd(path)
	data <- read.csv("matchings.csv", header=TRUE, sep =";", dec=",")
	return(data)
}

#check distributions
library(reshape)

computeDistribution <- function(data, experiment) {
	if(experiment == "both")
		filteredData <- subset(data, InputID == "reassistant-both.rea")
	if(experiment == "direct")
		filteredData <- subset(data, InputID == "reassistant-direct.rea")
	if(experiment == "impact")
		filteredData <- subset(data, InputID == "reassistant-impact.rea")
	filteredData <- subset(filteredData, Perspective == "Golden")
	filteredData <- subset(filteredData, Measure.Name == "TruePositive" | Measure.Name == "FalsePositive" | Measure.Name == "FalseNegative" | Measure.Name == "TrueNegative")

	reshapedData <- melt(filteredData, id=c("InputID", "NameCC","Perspective", "Measure.Name"))
	
	reshapedData$value <- sub(",", ".", reshapedData$value)
	reshapedData$value <- as.numeric(reshapedData$value)
	
	castedData <- cast(reshapedData, NameCC ~  Measure.Name)
	castedData[c("True")] <- castedData[c("TruePositive")] + castedData[c("FalseNegative")]
	castedData[c("False")] <- castedData[c("FalsePositive")] + castedData[c("TrueNegative")]
	
	df <- data.frame(castedData[,-1], row.names= castedData[,1])
	
	return(df)
}

computeReshapedDistribution <- function(dataWithoutRefactoring, dataWithRefactoring, experiment) {
	distributionWithoutRefactoring <- computeDistribution(dataWithoutRefactoring, experiment)
	distributionWithRefactoring <- computeDistribution(dataWithRefactoring, experiment)

	originalTrueDistribution <- distributionWithoutRefactoring["True"]
	refactoredTrueDistribution <- distributionWithRefactoring["True"]
	distributionCombination <- cbind(originalTrueDistribution, refactoredTrueDistribution)
	colnames(distributionCombination) <- c("Original", "Refactored")

	#displaying the data
	distributionCombination
	t(distributionCombination)
	
	return(distributionCombination)
}

#for a single file
dataWithoutRefactoring <- loadResults(path, caseStudy, "")
dataWithRefactoring <- loadResults(path, caseStudy, "-refactored")

distributionCombination <- computeReshapedDistribution(dataWithoutRefactoring, dataWithRefactoring, "both")

#check results per concern
computeMeasures <- function(distributionFrame) {
	distribution <- distributionFrame
	#distribution["Total" ,] <- colSums(distribution)
	distribution[c("Precision")] <- distribution[c("TruePositive")] / ( distribution[c("TruePositive")] + distribution[c("FalsePositive")] )
	distribution[c("Recall")] <- distribution[c("TruePositive")] / ( distribution[c("TruePositive")] + distribution[c("FalseNegative")] )
	distribution <- distribution[5:8]
	return(distribution)
}

computeSubstract <- function() {
	completeSubstract <- data.frame()
	experiments <- c("both", "direct", "impact")
	for(experiment in experiments) {
		for(caseStudy in caseStudies) {
			dataWithoutRefactoring <- loadResults(path, caseStudy, "")
			dataWithRefactoring <- loadResults(path, caseStudy, "-refactored")
			distributionWithoutRefactoring <- computeDistribution(dataWithoutRefactoring, experiment)
			distributionWithRefactoring <- computeDistribution(dataWithRefactoring, experiment)
			validationWithoutRefactoring <- computeMeasures(distributionWithoutRefactoring)
			validationWithRefactoring <- computeMeasures(distributionWithRefactoring)
			
			substract <- validationWithRefactoring - validationWithoutRefactoring
			substract$TruePercentage <- substract$True / validationWithoutRefactoring$True
			substract$FalsePercentage <- substract$False / validationWithoutRefactoring$False
			
			rownames(substract) <- paste(experiment, "-", caseStudy, "-", rownames(substract))
			substract$Experiment <- experiment
			substract$CaseStudy <- caseStudy
			completeSubstract <- rbind(completeSubstract, substract)
		}
	}
    return(completeSubstract)
}

substract <- computeSubstract()

#test for normality
library(nortest)
testNormalitySingle <-function(x) {
	shapiro.test(x)
	ad.test(x)
	qqnorm(x)
}

testNormality <-function(substract) {
	testNormalitySingle(substract$True)
	testNormalitySingle(substract$False)
	testNormalitySingle(substract$Precision)
	testNormalitySingle(substract$Recall)
}

testNormality(substract)

#test for homoscedasticity
testHomoscedasticitySingle <-function(sample1, sample2) {
	y <- c(sample1, sample2)
	group <- as.factor(c(rep(1, length(sample1)), rep(2, length(sample2))))
	leveneTest(value ~ variable, dataset)
	bartlett.test(y, group)
	#fligner.test(y, group)
}

testHomoscedasticity <-function(substract) {
	testHomoscedasticitySingle(substract$True, substract$Precision)
	testHomoscedasticitySingle(substract$True, substract$Recall)
	testHomoscedasticitySingle(substract$False, substract$Precision)
	testHomoscedasticitySingle(substract$False, substract$Recall)
}

testHomoscedasticity(substract)

#compute subsets
allSubstract <- subset(substract, Experiment == "both" | Experiment == "impact" | Experiment == "direct")
bothImpactSubstract <- subset(substract, Experiment == "both" | Experiment == "impact")
bothDirectSubstract <- subset(substract, Experiment == "both" | Experiment == "direct")
bothSubstract <- subset(substract, Experiment == "both")
impactSubstract <- subset(substract, Experiment == "impact")
directSubstract <- subset(substract, Experiment == "direct")

#remove outliers
bothSubstract <- bothSubstract[-12,]
impactSubstract <- impactSubstract[-12,]
bothImpactSubstract <- bothImpactSubstract[-33,]
bothImpactSubstract <- bothImpactSubstract[-12,]
directSubstract<-directSubstract[-15,]
directSubstract<-directSubstract[-9,]

#run pearson statistics correlation tests
library(Deducer)
runtest <- function(substract, combination) {
	writeLines(paste("Statistical tests on", combination))
	#cor.matrix(variables=d(True,False,TruePercentage,FalsePercentage,Precision,Recall), , data=substract, test=cor.test, method='spearman', alternative="two.sided",exact=T)
	cor.matrix(variables=d(True,False,TruePercentage,FalsePercentage,Precision,Recall), , data=substract, test=cor.test, method='kendall', alternative="two.sided",exact=T)
	#cor.matrix(variables=d(True,False,TruePercentage,FalsePercentage,Precision,Recall), , data=substract, test=cor.test, method='pearson', alternative="two.sided",exact=T)
}

runtest(allSubstract, "all experiments")
runtest(bothImpactSubstract, "both & impact experiments")
runtest(bothDirectSubstract, "both & direct experiments")
runtest(bothSubstract, "both experiment")
runtest(impactSubstract, "impact experiment")
runtest(directSubstract, "direct experiment")

#plot the relation
library(ggplot2)
ggplot(bothDirectSubstract, aes(x = True, y = Recall, xmin=0, ymin=0))+geom_point(aes(colour = Experiment))

plotSingle <- function(plotDataX, plotDataY) {
	plot(plotDataX, plotDataY)
	plot(plotDataX, plotDataY, pch=16)
	abline(lm(plotDataY ~ plotDataX))
}
plotLines <- function(plotData) {
	par(mfrow=c(2,2))
	plotSingle(plotData$True, plotData$Precision)
	plotSingle(plotData$True, plotData$Recall)
	plotSingle(plotData$False, plotData$Precision)
	plotSingle(plotData$False, plotData$Recall)
}



