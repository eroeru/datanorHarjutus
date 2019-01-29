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


//
//
//  Esialgne:
//
//  public void addPerson(Person person){
//
//    int controller = 0;
//
//    for (int i = 0; i < personsList.size(); i++)
//      if (personsList.get(i).getSocialSecurityId() == person.getSocialSecurityId()) {
//        controller += 1;
//      }
//
//    if (controller == 0) {
//      personsList.add(person);
//    }
//


    public boolean addPerson(Person person) throws Exception {

        for (Person isik : personsList) {
            if (person.getSocialSecurityId() == isik.getSocialSecurityId()) {
                return false;
                throw new Exception("error");
            }
        }
//try, catch?

        personsList.add(person);
        return true;
    }


    public List<Person> getPersons() {
        return personsList;
    }

}
