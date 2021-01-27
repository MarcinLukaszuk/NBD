var mapFunction =  function  () {
    emit('allJobs', { job: this.job });
}

var reduceFunction = function  (key, value) {
    return { job:   value.map(x => (x.job))  };
}
var finalizeFunction = function  (key, reducedValue) {
    return [...new Set(reducedValue.job)];
}

 
db.people.mapReduce(mapFunction, reduceFunction, { out: 'zapytanie_3_MR', finalize: finalizeFunction })

printjson(db.zapytanie_3_MR.find().toArray());