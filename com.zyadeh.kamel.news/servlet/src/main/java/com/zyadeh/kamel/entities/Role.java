package com.zyadeh.kamel.entities;

import org.springframework.stereotype.Component;

import java.util.Objects;
@Component
public class Role extends Entity{
    private String role;
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Role role1 = (Role) o;
        return Objects.equals(role, role1.role);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), role);
    }
    public String role(){
        return "Hello role Bean";
    }
    @Override
    public String toString() {
        return "Role{" +
                "role='" + role + '\'' +
                '}';
    }
}
