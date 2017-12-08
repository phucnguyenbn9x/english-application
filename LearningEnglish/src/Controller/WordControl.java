package Controller;

import Model.IDatabase;
import Model.Word;
import Model.XlsxDatabase;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * this class represent for control of words
 *
 * @author Nguyen Duc Thang
 */
public class WordControl {

    // variable to store instance of database
    private IDatabase xlsxDatabase;

    /**
     * constructor without parameter of this controller
     */
    public WordControl() {
        this.xlsxDatabase = XlsxDatabase.getInstance();
    }

    /**
     * function to get all words store in database
     *
     * @return list words in database
     */
    public ArrayList<Word> getListWord() {
        return sortListWord(xlsxDatabase.getAllWord());
    }

    /**
     * function to add new word to data base
     *
     * @param newWord new word want to append to database
     * @return boolean to check if append to database is successful
     */
    public boolean addNewWord(Word newWord) {
        return xlsxDatabase.createWordRecord(newWord);
    }

    /**
     * read word from database
     *
     * @param id id of word
     * @return word read form database
     */
    public Word getWord(int id) {
        return xlsxDatabase.readWordRecord(id);
    }

    /**
     * update words with new properties
     *
     * @param listWord list of word need to update
     */
    public void updateWord(ArrayList<Word> listWord) {
        xlsxDatabase.updateWordList(listWord);
    }

    /**
     * update word with new properties
     *
     * @param word new properties of the word
     */
    public void updateWord(Word word) {
        xlsxDatabase.updateWordRecord(word.getId(), word);
    }

    /**
     * find word with given name
     *
     * @param word name of the word
     * @return word found in database
     */
    public Word findWordByName(String word) {
        return xlsxDatabase.readWordRecord(word);
    }

    /**
     * delete word with given name
     *
     * @param word name of word want to delete
     * @return status of delete process (successful or failed)
     */
    public boolean deleteWord(String word) {
        return xlsxDatabase.deleteWordRecord(word);
    }

    /**
     * get list word that learned
     *
     * @return list word learned
     */
    public ArrayList<Word> getLearnedWord() {
        ArrayList<Word> allWord = xlsxDatabase.getAllWord();
        allWord.removeIf(s -> s.getLearnProgress() == 0);
        return this.sortListWord(allWord);
    }

    /**
     * sort by name given word list
     *
     * @param listWord list word need to sort
     * @return sorted word list
     */
    public ArrayList<Word> sortListWord(ArrayList<Word> listWord) {
        Collections.sort(listWord, new Comparator<Word>() {
            @Override
            public int compare(Word word1, Word word2) {
                return word1.getName().compareToIgnoreCase(word2.getName());
            }
        });
        return listWord;
    }

    /**
     * create image to User interface
     *
     * @param imagePath image path
     * @param dest destination to create image into
     */
    public void createImage(String imagePath, JLabel dest) {
        String path = imagePath.replaceAll("\\\\", "/");
        BufferedImage myImage = null;
        try {
            myImage = ImageIO.read(new File(path));
        } catch (IOException ex) {
            System.out.println("read file failed");
            try {
                myImage = ImageIO.read(new File("src/Dictionary/Images/default-image.jpg"));
            } catch (IOException ex1) {
                Logger.getLogger(WordControl.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        if (myImage != null) {
            dest.setIcon(new ImageIcon(myImage.getScaledInstance(dest.getWidth(), dest.getHeight(), Image.SCALE_SMOOTH)));
        } else {
        }
    }
    
    /**
     * create list model of word to append to scroll panel
     *
     * @param listWords list word need to append to scroll panel
     * @return list word model
     */
    public DefaultListModel<Word> createListModel(ArrayList<Word> listWords) {
        DefaultListModel<Word> listModel;
        listModel = new DefaultListModel<>();
        for (Word word : listWords) {
            listModel.addElement(word);
        }
        return listModel;
    }
}
