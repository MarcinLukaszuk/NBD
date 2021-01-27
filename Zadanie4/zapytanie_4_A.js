printjson(db.people.
    aggregate([
        {
            $addFields: {
                bmi: {
                    $divide: [
                        {
                            $toDouble: "$weight"
                        },
                        {
                            $pow: [{ $divide: [{ $toDouble: "$height" }, 100] }, 2]
                        }]
                }
            }
        },
        {
            $group: {
                _id: "$nationality",
                avg: { $avg: "$bmi" },
                min: { $min: "$bmi" },
                max: { $max: "$bmi" }
            }
        }
    ]).toArray())