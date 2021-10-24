package com.ts.resident.model;

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
