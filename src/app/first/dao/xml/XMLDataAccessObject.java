package app.first.dao.xml;

import app.first.dao.DaoException;
import app.first.dao.DataAccessObject;
import app.first.model.Person;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

public class XMLDataAccessObject implements DataAccessObject{

    private final String FILE_NAME = "persons.xml";
    @Override
    public List<Person> readPersons() throws DaoException {
        try(XMLDecoder xmlDecoder = new XMLDecoder(new FileInputStream(FILE_NAME))){
            List<Person> persons = (List<Person>)xmlDecoder.readObject();
            return persons;
        }catch(Exception exception){
            throw new DaoException(exception.getMessage());
        }
    }

    @Override
    public void writePersons(List<Person> persons) throws DaoException {
        if(persons ==null){
            return;
        }
        try(XMLEncoder xmlEncoder = new XMLEncoder(new FileOutputStream(FILE_NAME))){
            xmlEncoder.writeObject(persons);
        }catch(Exception exception){
            throw new DaoException(exception.getMessage());
        }
    }

}
