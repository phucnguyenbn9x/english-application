package Model;

import java.util.ArrayList;

/**
 * interface of database
 *
 * @author Nguyen Duc Thang
 */
public interface IDatabase {

    // get all word from database
    public ArrayList<Word> getAllWord();

    // get all collection from database
    public ArrayList<Collection> getAllCollection();

    // get list word in range from startId to endId
    public ArrayList<Word> getWordInRange(int startId, int endId);

    // write to database list word
    public void writeToDatabase(ArrayList<Word> listWord);

    // write to database all data
    public void writeToDatabase();

    // word sheet
    // create word record in database
    public boolean createWordRecord(Word newWord);

    // read a word record in database with name
    public Word readWordRecord(String word);

    //read a word record in database with id
    public Word readWordRecord(int id);

    // update word list
    public void updateWordList(ArrayList<Word> listWord);

    // update a word record with id and new properties
    public void updateWordRecord(int id, Word newWord);

    // delete a word record by name
    public boolean deleteWordRecord(String word);

    // delete a word record by id
    public boolean deleteWordRecord(int id);

    // Collection sheet
    // create a new collection
    public boolean createCollection(Collection newCollection);

    // read collection by name
    public Collection readCollection(String nameCollection);

    // read collection by id
    public Collection readCollection(int id);

    // update collection with id and new properties
    public void updateCollection(int id, Collection newCollection);

    // delete collection by name
    public boolean deleteCollection(String nameCollection);

    // delete collection by id
    public boolean deleteCollection(int id);
}
