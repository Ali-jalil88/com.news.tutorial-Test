package com.zyadeh.kamel.entities;

import org.graalvm.compiler.lir.CompositeValue;
import org.springframework.stereotype.Component;

import java.util.Objects;
@Component
public class Entity {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return id == entity.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
    public String entity(){
        return "Hello entity Bean";
    }
    @Override
    public String toString() {
        return "Entity{" +
                "id=" + id +
                '}';
    }
}
