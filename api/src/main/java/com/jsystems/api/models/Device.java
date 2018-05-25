package com.jsystems.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Device {
    public String type;
    @JsonProperty(value="device.model", required = true) //zamienia nazwe z kropka na akceptowalna dla Javy nazwe
    public List<Comp> deviceModel;
}
