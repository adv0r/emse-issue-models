collectData<-function(bugsFile){
frame<-read.table(bugsFile,
header=TRUE, sep=",", na.strings="NA", dec=".", strip.white=TRUE)
return(frame)
}