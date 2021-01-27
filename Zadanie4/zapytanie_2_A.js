printjson(db.people.
    aggregate([
        { $unwind: "$credit" },
        {
            $addFields: {
                doubleBalance: { $toDouble: "$credit.balance" }
            }
        },
        {
            $group: {
                _id: "$credit.currency",
                sum: { $sum: "$doubleBalance" }
            }
        }
    ]).toArray())