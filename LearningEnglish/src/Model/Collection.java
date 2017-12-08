package Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 * represent for a collection
 *
 * @author Nguyễn Đức Thắng
 */
public class Collection {

    // id of collection
    private int id;
    // name of collection
    private String name;
    // list word id of this collection
    private ArrayList<Integer> listWord;

    /**
     * constructor of collection
     *
     * @param row a row of sheet in database
     */
    public Collection(Row row) {
        this.listWord = new ArrayList<>();
        Iterator<Cell> cellIterator = row.iterator();
        while (cellIterator.hasNext()) {
            Cell cell = cellIterator.next();
            switch (cell.getColumnIndex()) {
                case 0:
                    this.id = (int) cell.getNumericCellValue();
                    break;
                case 1:
                    this.name = cell.getStringCellValue();
                    break;
                default:
                    this.listWord.add((int) cell.getNumericCellValue());
            }
        }
    }

    /**
     * copy constructor
     *
     * @param col collection need to copy
     */
    public Collection(Collection col) {
        this.id = col.id;
        this.name = col.name;
        this.listWord = col.listWord;
    }

    /**
     * constructor of collection
     *
     * @param name name of collection
     * @param listWord list word id of collection
     */
    public Collection(String name, ArrayList<Integer> listWord) {
        this.name = name;
        this.listWord = listWord;
    }

    /**
     * get id of this collection
     *
     * @return id of collection
     */
    public int getId() {
        return id;
    }

    /**
     * set new id of this collection
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * get name of this collection
     *
     * @return name of collection
     */
    public String getName() {
        return name;
    }

    /**
     * set name of collection
     *
     * @param name new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get list word id of collection
     *
     * @return list word id of collection
     */
    public ArrayList<Integer> getListWord() {
        return listWord;
    }

    /**
     * set new list word id of collection
     *
     * @param listWord new list word id
     */
    public void setListWord(ArrayList<Integer> listWord) {
        this.listWord = listWord;
    }

    /**
     * get collection properties in string
     *
     * @return string of collection name
     */
    @Override
    public String toString() {
        return this.name;
    }

    /**
     * compare this collection to orther object
     *
     * @param obj object to compare
     * @return result after compare
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
        final Collection other = (Collection) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.listWord, other.listWord)) {
            return false;
        }
        return true;
    }
}
