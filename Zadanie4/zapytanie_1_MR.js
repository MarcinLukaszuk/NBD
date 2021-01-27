var mapFunction =  function  () {
    emit(this.sex, {
        avgHeight: parseFloat(this.height),
        avgWeight: parseFloat(this.weight)
    });
}

var reduceFunction = function  (key, value) {
    return {
        avgHeight: Array.avg(value.map(x => x.avgHeight)),
        avgWeight: Array.avg(value.map(x => x.avgWeight))
    };
}
db.people.mapReduce(mapFunction, reduceFunction, { out: 'zapytanie_1_MR' })

printjson(db.zapytanie_1_MR.find().toArray());