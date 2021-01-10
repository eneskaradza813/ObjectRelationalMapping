package app;

import app.first.dao.DaoException;
import app.first.dao.DataAccessObject;
import app.first.dao.PersistenceStrategy;
import app.first.dao.json.JSONDataAccesObject;
import app.first.dao.serializable.SerializableDataAccessObject;
import app.first.dao.txt.FileDataAccessObject;
import app.first.dao.xml.XMLDataAccessObject;
import app.first.model.Person;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ApplicationStarter {

    public static void main(String[] args) throws DaoException {

        DataAccessObject dao = new JSONDataAccesObject();
                //new XMLDataAccessObject();
                //new SerializableDataAccessObject();
                //new FileDataAccessObject();
        PersistenceStrategy persistenceStrategy = new PersistenceStrategy(dao);
       // persistenceStrategy.setDao(new SerializableDataAccessObject());
        List<Person> transientpersonList = new ArrayList<>(Arrays.asList(
                new Person("123", "Sadeta", "Sadovic", 30),
                new Person("1234", "Amar", "Orucevic", 25),
                new Person("12345", "Samira", "Karovic", 37),
                new Person("123456", "Selma", "Bajic", 47),
                new Person("1234567", "Emsada", "Karic", 26),
                new Person("12345678", "Samir", "Alic", 29),
                new Person("123456789", "Emir", "Kalas", 18),
                new Person("123456790", "Ramiz", "Kamdzic", 56)
                ));
        persistenceStrategy.writePersons(transientpersonList);
        for(Person person : persistenceStrategy.readPersons()){
            System.out.println(person);
        }
    }
      
}
