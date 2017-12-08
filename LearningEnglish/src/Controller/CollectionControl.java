package Controller;

import Model.Collection;
import Model.IDatabase;
import Model.Word;
import Model.XlsxDatabase;
import java.util.ArrayList;

/**
 * represent for collection controller
 *
 * @author Nguyễn Đức Thắng
 */
public class CollectionControl {

    // variable to store instance of database
    private IDatabase xlsxDatabase;
    // variable to store control of words
    private WordControl wordControl;

    /**
     * constructor of collection controller
     *
     * @param wordController control of words
     */
    public CollectionControl(WordControl wordController) {
        this.xlsxDatabase = XlsxDatabase.getInstance();
        this.wordControl = wordController;
    }

    /**
     * function to get all collections in database
     *
     * @return all collections from database
     */
    public ArrayList<Collection> getAllCollection() {
        return xlsxDatabase.getAllCollection();
    }

    /**
     * function to get all word in collection with given collecionID
     *
     * @param collectionID id of collection
     * @return list word in collection
     */
    public ArrayList<Word> getAllWordOfCollection(int collectionID) {
        Collection collection = xlsxDatabase.readCollection(collectionID);
        ArrayList<Word> returnedListWord = new ArrayList<>();
        for (Integer wordId : collection.getListWord()) {
            returnedListWord.add(xlsxDatabase.readWordRecord(wordId));
        }
        return wordControl.sortListWord(returnedListWord);
    }

    /**
     * delete collection with given properties
     *
     * @param collection properties of collection want to delete
     * @return status of process (success or fail)
     */
    public boolean deleteCollection(Collection collection) {
        return xlsxDatabase.deleteCollection(collection.getName());
    }

    /**
     * update new properties of collection
     *
     * @param collection new properties of collection
     */
    public void updateCollection(Collection collection) {
        if (collection == null) {
            return;
        }
        xlsxDatabase.updateCollection(collection.getId(), collection);
    }

    /**
     * get word controller of this collection
     *
     * @return word controller
     */
    public WordControl getWordControl() {
        return wordControl;
    }

    /**
     * create new collection with given properties
     *
     * @param collection collection need to create
     * @return status of the process
     */
    public boolean createCollection(Collection collection) {
        return this.xlsxDatabase.createCollection(collection);
    }
}
