package com.jsystems.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Comp {

    public String produce;

//    @Size()
//    @NotNull
    @JsonProperty(value="screen.size")
    public double screenSize;
}
