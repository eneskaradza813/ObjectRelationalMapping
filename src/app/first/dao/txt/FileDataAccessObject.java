package app.first.dao.txt;

import app.first.dao.DaoException;
import app.first.dao.DataAccessObject;
import app.first.model.Person;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class FileDataAccessObject implements DataAccessObject{

    private static final String FILE_NAME = "persons.txt";
    @Override
    public List<Person> readPersons() throws DaoException {
        try(BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))){
            List<Person> persons = new ArrayList<>();
            String line;
            while((line = br.readLine())!=null){
                StringTokenizer stringTokenizer = new StringTokenizer(line, ";");
                String nin = stringTokenizer.nextToken();
                String name = stringTokenizer.nextToken();
                String surname = stringTokenizer.nextToken();
                int age = Integer.parseInt(stringTokenizer.nextToken());
                Person person = new Person(nin, name, surname, age);
                persons.add(person);
            }
            return persons;
        }catch(Exception exception){
            throw new DaoException(exception.getMessage());
        }
        
    }

    @Override
    public void writePersons(List<Person> persons) throws DaoException {
        if(persons == null ){
            return;
        }
        try(PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))){
            for(Person person: persons){
                pw.println(person.getNationalIdentificationNumber()
                + ";" + person.getName()
                + ";" + person.getSurname()
                + ";" + person.getAge());
            }
        }catch(Exception exception){
            throw new DaoException(exception.getMessage());
        }
    }

    
}
