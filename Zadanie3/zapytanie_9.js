printjson(db.getCollection("people").find({"hobby":"pingpong"}).limit(1).toArray())
printjson(db.getCollection("people").updateMany({"first_name":"Antonio"},{$set:{"hobby":"pingpong"}} ) )
printjson(db.getCollection("people").find({"hobby":"pingpong"}).limit(1).toArray())