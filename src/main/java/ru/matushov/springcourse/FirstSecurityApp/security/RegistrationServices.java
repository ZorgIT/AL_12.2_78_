package ru.matushov.springcourse.FirstSecurityApp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.matushov.springcourse.FirstSecurityApp.models.Person;
import ru.matushov.springcourse.FirstSecurityApp.repositories.PeopleRepository;

@Service
public class RegistrationServices {
    private final PeopleRepository peopleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationServices(PeopleRepository peopleRepository, PasswordEncoder passwordEncoder) {
        this.peopleRepository = peopleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void register(Person person) {
        String encodedPassword = passwordEncoder.encode(person.getPassword());
        person.setPassword(encodedPassword);//
        peopleRepository.save(person);
    }
}
