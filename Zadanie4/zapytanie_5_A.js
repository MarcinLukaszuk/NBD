printjson(db.people.
    aggregate([
        { $unwind: "$credit" },
        { $match: { sex: "Female", nationality: "Poland" } },
        {
            $group: {
                _id: "$credit.currency",
                avg: { $avg: { $toDouble: "$credit.balance" } }
                , sum: { $sum: { $toDouble: "$credit.balance" } }
            }
        }
    ]).toArray())