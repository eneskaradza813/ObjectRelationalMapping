package app.first.dao;

import app.first.model.Person;
import java.util.List;

public class PersistenceStrategy {

    private DataAccessObject dao;

    public PersistenceStrategy(DataAccessObject dao) {
        this.dao = dao;
    }

    public void setDao(DataAccessObject dao) {
        this.dao = dao;
    }
    
    public void writePersons(List<Person> persons) throws DaoException{
        dao.writePersons(persons);
    }
    public List<Person> readPersons() throws DaoException{
        return dao.readPersons();
    }
}
