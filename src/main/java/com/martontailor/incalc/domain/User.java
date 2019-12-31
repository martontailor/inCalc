package com.martontailor.incalc.domain;

import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Data
@Builder
public class User {

    @Id
    public ObjectId _id;

    private String username;
    private String email;
    private String password;
}
