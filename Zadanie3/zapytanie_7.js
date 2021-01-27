printjson(db.getCollection("people").count({"height": { "$gt": "190"} })) 
printjson(db.getCollection("people").deleteMany({"height": { "$gt": "190"} }))
printjson(db.getCollection("people").count({"height": { "$gt": "190"} })) 
 
 