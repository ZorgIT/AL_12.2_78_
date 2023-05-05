package ru.matushov.springcourse.FirstSecurityApp.security;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.matushov.springcourse.FirstSecurityApp.models.Person;

import java.util.Collection;

public class PersonDetails implements UserDetails {
    private final Person person;

    public PersonDetails(Person person) {
        this.person = person;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null; //todo realize get roles and set law
    }

    @Override
    public String getPassword() {
        return this.person.getPassword(); //must return password
    }

    @Override
    public String getUsername() {
        return this.person.getUsername();//must return username
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; //fake true
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; //fake true
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; //fake true
    }

    @Override
    public boolean isEnabled() {
        return true; //fake true
    }

    //needed to get data to authenticated user
    public  Person getPerson() {
        return this.person;
    }
}
