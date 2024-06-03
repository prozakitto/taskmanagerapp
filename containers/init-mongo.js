db.createUser(
    {
        user: "root",
        pwd: "toor",
        roles: [
            {
                role: "readWrite",
                db: "fintonic"
            }
        ]
    }
);
db.createCollection("tasks");
db.createCollection("labels");