package com.web.elasticsearch.model;

import com.web.elasticsearch.dto.UserDtoRequest;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "user")
public class User {

    @Id
    private String id;

    private String name;

    private String lastname;

    private String city;

    public User(UserDtoRequest userDtoRequest) {
        this.name = userDtoRequest.getName();
        this.lastname = userDtoRequest.getLastname();
        this.city = userDtoRequest.getCity();
    }
}
