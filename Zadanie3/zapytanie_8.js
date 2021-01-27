printjson(db.getCollection("people").count({"location.city":"Moscow"}))
printjson(db.getCollection("people").updateMany({"location.city":"Moscow"},{$set:{"location.city":"Moskwa"}} ) )
printjson(db.getCollection("people").count({"location.city":"Moskwa"}))