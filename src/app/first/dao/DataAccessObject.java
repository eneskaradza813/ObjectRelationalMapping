package app.first.dao;

import app.first.model.Person;
import java.util.List;

public interface DataAccessObject {

    public List<Person> readPersons()throws DaoException;
    
    public void writePersons(List<Person> persons)throws DaoException;
    
}
