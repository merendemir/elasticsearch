package com.web.elasticsearch.dto;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDtoRequest {

    private String name;

    private String lastname;

    private String city;
}
