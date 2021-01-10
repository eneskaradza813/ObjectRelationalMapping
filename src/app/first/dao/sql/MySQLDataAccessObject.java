package app.first.dao.sql;

import app.first.dao.DaoException;
import app.first.dao.DataAccessObject;
import app.first.model.Person;
import java.util.List;

public class MySQLDataAccessObject implements DataAccessObject{

    @Override
    public List<Person> readPersons() throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void writePersons(List<Person> persons) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
