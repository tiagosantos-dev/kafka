package com.ts.visitor.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Localization implements Serializable {

    private String latitude;
    private String longitude;

}
