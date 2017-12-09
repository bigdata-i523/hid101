

// part of code for job recommendation system
//read file content as an event.
//this is not real code, it is just pseudocode。

LogResult result = logParser.parseLog(line); //convert to LogResult
if (result == null){
return null;
}

Map<String, String> headers = new HashMap<String, String>();

headers.put(header, result.getLogTypeMappring());// set the header

//convert result to be json format and ,combine header to Event
return EventBuilder.withBody(result.getLogJson(),outputCharset,headers);


//analyze log and convert it to json.
ApacheLog log = ApacheLog.getApacheLog(logStr);//Apache log format data
log.setData(strs[IP_INDEX]，DateUtil.parseTimeToLong(strs[LOG_TIME_INDEX]),
strs[USER_AGENT_INDEX]，strs[VISIT_STATUS_INDEX],strs[REQUEST_INDEX]);
String json = JsonUtil.toJson(log); //parse json format
boolean isCorrectLog = log.cleanLog();
if (isCorrectLog){
return new LogResult(jason, log.getLogType());
}


//realtime to read data to Channel

while (true){
//read batchSize data
List<Event> events = reader.readEvents(batchSize);
if (events.isEmptry()){
if(sleepTime>0)
Thread.sleep(sleepTime);

continue;
}
sourceCounter.addToEventReceivedCount(events.size());
sourceCounter.incrementAppendBatchReceivedCount();
//transport data to channel
getChannelProcessor().processEventBatch(events);
reader.commit();
sourceCounter.addToEventAcceptedCount(evetns.size());
sourceCounter.incrementAppendBatchAcceptedCount();

}

//how to analyze calculate the frequences of feature word and staying time.
for (int i= 0; i < len; i++){
Object feature = keyOutPutTypeOI.copyObject(list.get(i));
featureVal = featureMap.get(i);
timeLenVal = timeLenMap.get(i);
if (null == featureVal){
featureVal = new HashMap<Object,Object>();
timeLenVal = new HashMap<Object,Object>();
featureVal.put(feature,1);
timeLenVal.put(feature, timeLen);
}
else{
Object.count = featureVal.get(feature);
Object.lens = timeLenVal.get(feature);
if (null == count) {
featureVal.put(feature,1);
timeLenVal.put(feature, timeLen);
}
else{
featureVal.put(feature, Integer.parseInt(count.toString())+1);
timeLenVal.put(feature, Integer.parseInt(lens.toString() + timeLen);

}
}
feature.Map.put(i, featureVal);
timeLenMap.put(i,timeLenVal);
}
