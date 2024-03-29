package com.martontailor.incalc.domain;

import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "USERS")
public class User {

    @Id
    public ObjectId id;
    private String username;
    private String email;
    private String password;
    @DBRef
    private Summary summary;

}
