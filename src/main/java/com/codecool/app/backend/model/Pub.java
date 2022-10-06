package com.codecool.app.backend.model;

import java.math.BigDecimal;
import java.util.Map;
import java.util.UUID;

public class Pub {

    private UUID id;
    private String name;
    private Map <String, BigDecimal> menu;

    public Pub(String name, Map<String, BigDecimal> menu) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.menu = menu;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Map<String, BigDecimal> getMenu() {
        return menu;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMenu(Map<String, BigDecimal> menu) {
        this.menu = menu;
    }

}
