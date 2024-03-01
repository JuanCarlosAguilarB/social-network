package com.example.socialnetwork.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class StatusDTO {
    private Integer id;
    private String name;

}