package hello.person;

import hello.schema.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public List<Person> getAllPersons() {
        return this.personRepository.findAll();
    }

    public Person getPerson(Long id) {
        Optional<Person> person = this.personRepository.findById(id);
        if (person.isPresent()) {
            return person.get();
        }
        throw new EntityNotFoundException("Person with id: ( " + id + " ), was not found!");
    }
}
