package com.example.shdemo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
        @NamedQuery(name = "type.all", query = "Select g from Type g")
})

public class Type {

    private Long id;
    private String Name = "";

    public Type() {
    }

    public Type(String Name) {
        super();
        this.Name = Name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getGenre() {
        return Name;
    }
    public void setGenre(String Name) {
        this.Name = Name;
    }
}
