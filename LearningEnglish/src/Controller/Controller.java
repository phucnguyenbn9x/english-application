package Controller;

import View.GUI.HomeScreen;

/**
 * represent for main controller of this application
 *
 * @author Nguyễn Đức Thắng
 */
public class Controller {
    
    // variable to control words of this application
    private WordControl wordController;
    // variable to control collections of this application
    private CollectionControl collectionController;
    // main User Interface of this application
    private HomeScreen GUI;
    
    /**
     * constructor without parameter of main controller
     */
    public Controller() {
        this.wordController = new WordControl();
        this.collectionController = new CollectionControl(wordController);
        this.GUI = new HomeScreen(this);
    }
    
    /**
     * getter: get control of words
     * 
     * @return word controller
     */
    public WordControl getWordController() {
        return wordController;
    }

    /**
     * setter: set control of words
     * 
     * @param wordController control of words
     */
    public void setWordController(WordControl wordController) {
        this.wordController = wordController;
    }
    
    /**
     * getter: get control of collections
     * 
     * @return controller of collections
     */
    public CollectionControl getCollectionController() {
        return collectionController;
    }
    
    /**
     * setter: set control of collections
     * 
     * @param collectionController control of collections 
     */
    public void setCollectionController(CollectionControl collectionController) {
        this.collectionController = collectionController;
    }
    
    /**
     * getter: get main user interface of this application
     * 
     * @return user interface of this application
     */
    public HomeScreen getGUI() {
        return this.GUI;
    }
    
    /**
     * function to update user interface
     */
    public void updateView() {
        GUI.updateFrame();
    }
}
