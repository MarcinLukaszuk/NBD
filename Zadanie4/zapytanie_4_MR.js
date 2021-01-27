var mapFunction =  function  () {
    var heightMapped= this.height/100;

    var bmi = parseFloat(this.weight) / ((parseFloat(heightMapped)  * parseFloat(heightMapped)));
    if (bmi < 1) return;
    emit(this.nationality, { max: bmi, min: bmi, avg: bmi });
}

var reduceFunction = function  (key, value) {
    var min = Math.min(...value.map(x => x.min))
    var max = Math.max(...value.map(x => x.max))
    var avg = value.map(x => x.avg).reduce((a, b) => a + b, 0) / value.length;
    return { max: max, min: min, avg: avg };
}

 
 
db.people.mapReduce(mapFunction, reduceFunction, { out: 'zapytanie_4_MR' })

printjson(db.zapytanie_4_MR.find().toArray()); 