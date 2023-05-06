package ru.matushov.springcourse.FirstSecurityApp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.matushov.springcourse.FirstSecurityApp.models.Person;
import ru.matushov.springcourse.FirstSecurityApp.repositories.PeopleRepository;

@Service
public class RegistrationServices {
    private final PeopleRepository peopleRepository;

    @Autowired
    public RegistrationServices(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Transactional
    public void register(Person person) {
        peopleRepository.save(person);
    }
}
