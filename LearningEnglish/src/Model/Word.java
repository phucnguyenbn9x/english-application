package Model;

import java.util.Objects;
import org.apache.poi.ss.usermodel.Row;

/**
 * represent for a word
 *
 * @author Nguyen Duc Thang
 */
public class Word {
    
    private final String defaultImagePath = "src\\Dictionary\\Images\\default-image.jpg";
    // id of word
    private int id;
    // name of the word
    private String name;
    // meaning of the word
    private String meaning;
    // how to pronunce it
    private String pronounciation;
    // user learning progress
    private int learnProgress;
    // word image path
    private String wordImage = defaultImagePath;

    /**
     * Word's constructor without parameter
     */
    public Word() {
    }

    /**
     * Word's constructor with parameters
     *
     * @param name name of word
     * @param meaning meaning of word
     * @param pronounciation pronounce of word
     */
    public Word(String name, String meaning, String pronounciation, String image) {
        this.name = name;
        this.meaning = meaning;
        this.pronounciation = pronounciation;
        this.wordImage = image.equals("") ? defaultImagePath:image;
    }

    /**
     * Word's constructor with parameters
     *
     * @param id id of word
     * @param name name of word
     * @param meaning meaning of word
     * @param pronounciation pronounce of word
     * @param learnProgress learn progress of word
     */
    public Word(int id, String name, String meaning, String pronounciation, int learnProgress, String image) {
        this.id = id;
        this.name = name;
        this.meaning = meaning;
        this.pronounciation = pronounciation;
        this.learnProgress = learnProgress;
        this.wordImage = image;
    }

    /**
     * word's constructor with row of the word sheet
     *
     * @param row a row of word sheet
     */
    public Word(Row row) {
        this.id = (int) row.getCell(0).getNumericCellValue();
        this.name = row.getCell(1).getStringCellValue();
        this.meaning = row.getCell(2).getStringCellValue();
        this.pronounciation = row.getCell(3).getStringCellValue();
        this.learnProgress = (int) row.getCell(4).getNumericCellValue();
        String image;
        if(row.getCell(5) == null) {
            image = defaultImagePath;
        } else {
            image = row.getCell(5).getStringCellValue();
        }
        this.wordImage = image.equals("") ? defaultImagePath:image;
    }

    /**
     * get name of word
     *
     * @return name of word
     */
    public String getName() {
        return name;
    }

    /**
     * set name of word
     *
     * @param name name of word
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get meaning of word
     *
     * @return meaning of word
     */
    public String getMeaning() {
        return meaning;
    }

    /**
     * set new meaning of word
     *
     * @param meaning new meaning
     */
    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    /**
     * get pronounce of word
     *
     * @return
     */
    public String getPronounciation() {
        return pronounciation;
    }

    /**
     * set new pronounce of word
     *
     * @param pronounciation new pronounce of word
     */
    public void setPronounciation(String pronounciation) {
        this.pronounciation = pronounciation;
    }

    /**
     * get progress of learning this word
     *
     * @return progress of learning of this word
     */
    public int getLearnProgress() {
        return learnProgress;
    }

    /**
     * increase learning progress of this word
     */
    public void increaseProgress() {
        this.learnProgress++;
        if (this.learnProgress > 5) {
            this.learnProgress = 5;
        }
    }

    /**
     * get id of this word
     *
     * @return id of this word
     */
    public int getId() {
        return id;
    }

    /**
     * set new id of word
     *
     * @param id new id of word
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * get word image path
     * @return word image path
     */
    public String getWordImage() {
        return wordImage;
    }
    
    /**
     * setup new word Image path
     * @param wordImage 
     */
    public void setWordImage(String wordImage) {
        this.wordImage = wordImage;
    }

    /**
     * get word's information by string
     *
     * @return string contain word's information
     */
    @Override
    public String toString() {
        return "Word{" + "id=" + id + ", name=" + name + ", meaning=" + meaning + ", pronunciation=" + pronounciation + ", learnProgress=" + learnProgress + '}';
    }

    /**
     * function check if 2 words are equal
     *
     * @param obj object to compare
     * @return result of function
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Word other = (Word) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.meaning, other.meaning)) {
            return false;
        }
        if (!Objects.equals(this.pronounciation, other.pronounciation)) {
            return false;
        }
        return true;
    }

}
