package app.first.dao.serializable;

import app.first.dao.DaoException;
import app.first.dao.DataAccessObject;
import app.first.model.Person;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class SerializableDataAccessObject implements DataAccessObject{

    private static final String FILE_NAME = "persons.dat";
    
    @Override
    public List<Person> readPersons() throws DaoException {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))){
            List<Person> persons = (List<Person>)ois.readObject();
            return persons;
        }catch(Exception exception){
            throw new DaoException(exception.getMessage());
        }
    }

    @Override
    public void writePersons(List<Person> persons) throws DaoException {
        try(ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(FILE_NAME))){
            if(persons == null){
                return;
            }
            ous.writeObject(persons);
        }catch(Exception exception){
            throw new DaoException(exception.getMessage());
        }
    }

}
