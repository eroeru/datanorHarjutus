package ee.datanor.vali.it.leiabugi.service;

import ee.datanor.vali.it.leiabugi.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class PersonService {

    List<Person> personsList = new ArrayList<>();

    @PostConstruct
    public void init() {
        Person firstP = new Person();
        firstP.setFirstName("Miki");
        firstP.setLastName("Hiir");
        firstP.setSocialSecurityId(31012340001L);

        Person secondP = new Person();
        secondP.setFirstName("Hagar");
        secondP.setLastName("Hirmus");
        secondP.setSocialSecurityId(34012340002L);

        Person thridP = new Person();
        thridP.setFirstName("Pipi");
        thridP.setLastName("Pikksukk");
        thridP.setSocialSecurityId(48012340003L);

        personsList.add(firstP);
        personsList.add(secondP);
        personsList.add(thridP);
//    log.info("init done"); - log.info-d kommenteerisin Peetri eeskujul välja, kuna hetkel on IntelliJ seadistatud nii, et kuvab veana
    }


    public Person getPerson(Long socialSecurityId) {
//    log.info("personList size {} {}", personsList.size(), socialSecurityId);

        Optional<Person> person = personsList.stream().filter((p -> p.getSocialSecurityId() == socialSecurityId)).findAny();
        if (person.isPresent()) {
            return person.get();
        }
        return new Person();
    }


    public void addPerson(Person person) throws Exception {

        for (Person isik : personsList) {
            if (person.getSocialSecurityId() == isik.getSocialSecurityId()) {

                throw new Exception("error");
            }
        }


        personsList.add(person);

    }


    public void changePerson(Person person) throws Exception {
        for (Person i : personsList) {

            int controller = 0;

            if (person.getSocialSecurityId() == i.getSocialSecurityId()) {

                person.setFirstName(i.getFirstName());
                person.setLastName(i.getLastName());
                controller += 1;
            } else if (controller > 0) {
                throw new Exception("error");
            }
        }

    }


    public void deletePerson(Long socialSecurityId) {

        Optional<Person> person = personsList.stream().filter((p -> p.getSocialSecurityId() == socialSecurityId)).findAny();
        if (person.isPresent()) {
            personsList.remove(person);
        }

    }


    public List<Person> getPersons() {
        return personsList;
    }

}
