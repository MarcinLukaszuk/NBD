var mapFunction = function () {
    for (i = 0; i < this.credit.length; i++) {
        emit(this.credit[i].currency, parseFloat(this.credit[i].balance));
    }
}

var reduceFunction = function (key, value) {
    return Array.sum(value.filter(x => !isNaN(x)))
}


db.people.mapReduce(mapFunction, reduceFunction, { out: 'zapytanie_2_MR' })

printjson(db.zapytanie_2_MR.find().toArray());