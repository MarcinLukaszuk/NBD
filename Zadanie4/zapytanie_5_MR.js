var mapFunction = function () {
    this.credit.forEach(function (item) {
        var balance = parseFloat(item.balance);
        if (!isNaN(balance))
            emit(item.currency, { sum: balance, avg: balance })
    });
}

var reduceFunction = function (key, value) {
    var sum = value.map(x => x.sum).reduce((a, b) => a + b, 0)
    var avg = sum / value.length;
    return { sum: sum, avg: avg };
}

db.people.mapReduce(mapFunction, reduceFunction, {
    out: 'zapytanie_5_MR',
    query: {
        sex: 'Female',
        nationality: 'Poland'
    }
})

printjson(db.zapytanie_5_MR.find().toArray()); 