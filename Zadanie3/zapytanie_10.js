printjson(db.getCollection("people").find({"job":"Editor"}).limit(1).toArray())
printjson(db.getCollection("people").updateMany({"job":"Editor"},{$unset:{"email":"" }} ) ) 
printjson(db.getCollection("people").find({"job":"Editor"}).limit(2).toArray())
