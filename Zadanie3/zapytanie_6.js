printjson(db.getCollection("people").insert({  
    "sex" : "Male",
    "first_name" : "Marcin",
    "last_name" : "Łukaszuk",
    "job" : "CRM Developer",
    "email" : "s22009@pjwstk.edu.pl",
    "location" : {
        "city" : "Oyo",
        "address" : {
            "streetname" : "Beilfuss",
            "streetnumber" : "860"
        }
    },
    "description" : "Jakis opis",
    "height" : "176.38",
    "weight" : "75.81",
    "birth_date" : "1996-08-02T02:55:03Z",
    "nationality" : "Poland",
    "credit" : [
        {
            "type" : "switch",
            "number" : "6759888939100098669",
            "currency" : "COP",
            "balance" : "5117.06"
        }
    ]
}))
printjson(db.getCollection("people").find({first_name:"Marcin",last_name:"Łukaszuk"}).toArray())
 
 