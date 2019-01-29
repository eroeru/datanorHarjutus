package ee.datanor.vali.it.leiabugi.service;

import ee.datanor.vali.it.leiabugi.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


//Ülesanne:


//Palun lisada juurde uus kontrolleri meetod millega saaks olemasolevaid kasutajaid muuta, sisuliselt on tegu sarnase meetodiga nagu on kasutaja lisamine, kuid muutmiseks kasutatakse REST standardite järgi HTTP POST mitte PUT.
//        Kui muudetavat kasutajat listist ei leita siis tuleks visata viga, kui kasutaja on olemas siis muuta listi siis kasutaja ees või perenime, isikukoodi muuta ei saa.
//        Samuti täiendada ka praegust kasutaja lisamise funktsiooni nii, et kui sisestada isikut isikukoodiga mis juba on olemas siis visata viga.
//        Lisada juurde ka HTTP DELETE kontrolleri meetod millega saab isikukoodi alusel isikuid nimekirjast kustutada


@Slf4j
@Service
public class PersonService {



  List<Person> personsList = new ArrayList<>();

  @PostConstruct
  public void init(){
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
    log.info("init done");
  }


  public Person getPerson(Long socialSecurityId){
    log.info("personList size {} {}", personsList.size(), socialSecurityId);

    Optional<Person> person = personsList.stream().filter((p -> p.getSocialSecurityId() == socialSecurityId)).findAny();
    if (person.isPresent()){
      return  person.get();
    }
    return new Person();
  }





  public void addPerson(Person person){

    int controller = 0;

    for (int i = 0; i < personsList.size(); i++)
    if (personsList.get(i).getID() == person.getID()) {
      controller += 1;
    }

    if (controller == 0) {
      personsList.add(person);
    }



  }

  public List<Person> getPersons(){
    return personsList;
  }

}
