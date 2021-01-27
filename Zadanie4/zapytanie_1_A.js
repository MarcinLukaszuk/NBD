printjson(db.people.
    aggregate([
        {
            $addFields: {
                doubleHeight: { $toDouble: "$height" },
                doubleWeight: { $toDouble: "$weight" },
            }
        }, 
        {
            $group: {
                _id: "$sex",
                avgHeight: { $avg: "$doubleHeight" },
                avgWeight: { $avg: "$doubleWeight" }
            }
        }
    ]).toArray())