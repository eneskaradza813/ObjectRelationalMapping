package app.first.dao;

public class DaoException extends Exception{

    public DaoException(String message){
        super("Dao exception : " + message);
    }
}
