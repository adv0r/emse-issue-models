library(stringr)
library(grid)
library(calibrate)
main<-function(path,bugsFile){
source(file.path(str_c(path,"../r/collectData.R")))
frame<-collectData(str_c(str_c(path,""),bugsFile))
##frameM<-data.frame(DateM=str_c(substr(frame$Date,1,4),substr(frame$Date,6,7)),StageM=frame$Stage,OpenBugsM=frame$OpenBugs)
##frameM<- aggregate(frameM["OpenBugsM"], by=list(DateM=frameM$DateM,StageM=frameM$StageM),sum, na.rm=TRUE)
##attach(frameM)

attach(frame)

##MAIN FACTOR
dev.new()
boxplot(OpenBugs~Stage,names=c('Early Stage','Late Stage'))
print(str_c("ESM_QUARTILE_E ",bugsFile))
print(quantile(OpenBugs[Stage=='e']))
print(str_c("ESM_QUARTILE_L ",bugsFile))
print(quantile(OpenBugs[Stage=='l']))

print(str_c(str_c(str_c("HTMLOUT ",bugsFile)," p.value= "),wilcox.test(OpenBugs~Stage)$p.value))

len<-c()
len<-rep(1:length(OpenBugs[Stage=='e']))
dev.new()

plot(len, OpenBugs[Stage=='e'],col="green",xlab="Days",ylab="OpenBugs")
me<-lm(OpenBugs[Stage=='e']~len)
abline(me,col='green')
points(len, OpenBugs[Stage=='l'],col="blue")
ml<-lm(OpenBugs[Stage=='l']~len)
abline(ml,col='blue')

g_range <- range(0,OpenBugs[Stage=='e'], OpenBugs[Stage=='l'])
legend(1, g_range[2], c("Early","Late"), cex=0.8, 
col=c("green","blue"),lty=1) 

##COFACTOR
pr<-OpenBugs[Stage=='e']
pr1<-OpenBugs[Stage=='l']
Ince<-pr[2:length(pr)]-pr[1:length(pr)-1]
Incl<-pr1[2:length(pr1)]-pr1[1:length(pr1)-1]
frame$Increment[Stage == "e"][1]<-0
frame$Increment[Stage == "e"][2:length(Date[Stage=='e'])]<-Ince
frame$Increment[Stage == "l"][1]<-0
frame$Increment[Stage == "l"][2:length(Date[Stage=='l'])]<-Incl
attach(frame)
dev.new()
##RESULTS
print(str_c("ESM_REGRESSION_E ",bugsFile))
print(summary(me))
print(str_c("ESM_REGRESSION_L ",bugsFile))
print(summary(ml))
print(str_c("ESM_VARIANCE ",bugsFile))
print(summary(aov(OpenBugs~Stage*Increment)))
interaction.plot(Increment,Stage,OpenBugs)
   }