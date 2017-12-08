package View.GUI;

import Controller.Controller;
import Controller.WordControl;
import Model.Word;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * represent for test dialog
 *
 * @author Nguyễn Phúc
 */
public class TestDialog extends javax.swing.JFrame {

    // controller of this application
    private Controller mainController;
    // controller of words
    private WordControl Controller;
    // Biến đếm số câu
    private int count;
    // Biến sinh ngẫu nhiên
    Random random = new Random();
    // Số câu trả lời đúng
    private int trueSum = 0;
    // current word's used to test
    private Word currentWord = null;
    // list word learned word to test
    private ArrayList<Word> learnedWord;

    /**
     * Creates new form TestDialog
     */
    public TestDialog(Controller controller) {
        this.mainController = controller;
        this.Controller = controller.getWordController();
        initComponents();
        setIcon();
        this.learnedWord = Controller.getLearnedWord();

        if (canMakeATest()) {
            setupQuesttion(generateQuestion());
        }
    }

    /**
     * generate question to test
     *
     * @return word to test
     */
    private Word generateQuestion() {
        this.currentWord = learnedWord.get(random.nextInt(learnedWord.size()));
        return this.currentWord;
    }

    /**
     * function to check we can make a test or not depend on list learned word
     *
     * @return result of function( cant make a test or not)
     */
    public boolean canMakeATest() {
        return !this.learnedWord.isEmpty();
    }

    /**
     * setup question for dialog
     *
     * @param answer dap an
     */
    private void setupQuesttion(Word answer) {
        if (answer == null) {
            return;
        }
        this.count++;
        jWord.setText(answer.getName());
        jPronunce.setText(answer.getPronounciation());
        
        Controller.createImage(answer.getWordImage(), jImage);
        
        jQuestionCount.setText("Question " + (this.count));
        setupAnswer(answer);
    }

    /**
     * set up answer for dialog
     *
     * @param answer dap an
     */
    private void setupAnswer(Word answer) {
        int numOfWords = Controller.getListWord().size();
        ArrayList<Word> answers = new ArrayList<Word>();
        answers.add(answer);
        // get 3 word random
        answers.add(Controller.getWord(random.nextInt(numOfWords)));
        answers.add(Controller.getWord(random.nextInt(numOfWords)));
        answers.add(Controller.getWord(random.nextInt(numOfWords)));
        setupSelector(answers);
    }

    /**
     * set up answer selector
     *
     * @param listAnswer list of answers to select
     */
    private void setupSelector(ArrayList<Word> listAnswer) {
        Collections.shuffle(listAnswer);
        janswerA.setText(listAnswer.get(0).getMeaning());
        janswerB.setText(listAnswer.get(1).getMeaning());
        janswerC.setText(listAnswer.get(2).getMeaning());
        janswerD.setText(listAnswer.get(3).getMeaning());
    }

    /**
     * check if correct answer
     *
     * @return is correct answer of incorrect answer
     */
    private boolean checkAnswer() {
        boolean isTrue = false;
        if (janswerA.isSelected()) {
            if (janswerA.getText().equalsIgnoreCase(this.currentWord.getMeaning())) {
                isTrue = true;
            }
        } else if (janswerB.isSelected()) {
            if (janswerB.getText().equalsIgnoreCase(this.currentWord.getMeaning())) {
                isTrue = true;
            }
        } else if (janswerC.isSelected()) {
            if (janswerC.getText().equalsIgnoreCase(this.currentWord.getMeaning())) {
                isTrue = true;
            }
        } else if (janswerD.isSelected()) {
            if (janswerD.getText().equalsIgnoreCase(this.currentWord.getMeaning())) {
                isTrue = true;
            }
        }
        return isTrue;
    }

    /**
     * function to setup new word set to test
     *
     * @param testList new set word set to test
     */
    public void setupTest(ArrayList<Word> testList) {
        this.learnedWord.clear();
        this.count = 0;
        for (Word w : testList) {
            learnedWord.add(w);
        }
        if (canMakeATest()) {
            setupQuesttion(generateQuestion());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        janswerB = new javax.swing.JRadioButton();
        janswerC = new javax.swing.JRadioButton();
        janswerD = new javax.swing.JRadioButton();
        jbOK = new javax.swing.JButton();
        jQuestionCount = new javax.swing.JLabel();
        janswerA = new javax.swing.JRadioButton();
        jWord = new javax.swing.JLabel();
        jPronunce = new javax.swing.JLabel();
        jImage = new javax.swing.JLabel();

        setTitle("Test");
        setResizable(false);

        buttonGroup1.add(janswerB);

        buttonGroup1.add(janswerC);

        buttonGroup1.add(janswerD);

        jbOK.setText("OK");
        jbOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbOKActionPerformed(evt);
            }
        });

        jQuestionCount.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        jQuestionCount.setText("jLabel6");

        buttonGroup1.add(janswerA);

        jWord.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jWord.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jWord.setText("jLabel1");

        jPronunce.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        jPronunce.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPronunce.setText("jLabel1");

        jImage.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(janswerC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(janswerB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(janswerD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(janswerA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPronunce, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jWord, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jQuestionCount, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(113, 113, 113)
                        .addComponent(jbOK, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 232, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jWord, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPronunce, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jImage, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(janswerA, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(janswerB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(janswerC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(janswerD, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jQuestionCount, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbOK, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Tạo sự kiện cho jbOK
     *
     * @param evt Sự kiện
     */
    private void jbOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbOKActionPerformed
        if (checkAnswer()) {
            trueSum++;
        }
        if (count < 9 && learnedWord.size() > 0) {
            // not finished the test
            setupQuesttion(generateQuestion());
        } else {
            // finished the test
            this.setVisible(false);
            count = 0;
            JOptionPane.showMessageDialog(null, "Số câu đúng: " + String.valueOf(trueSum), "Information", JOptionPane.INFORMATION_MESSAGE);
            trueSum = 0;
        }
    }//GEN-LAST:event_jbOKActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jImage;
    private javax.swing.JLabel jPronunce;
    private javax.swing.JLabel jQuestionCount;
    private javax.swing.JLabel jWord;
    private javax.swing.JRadioButton janswerA;
    private javax.swing.JRadioButton janswerB;
    private javax.swing.JRadioButton janswerC;
    private javax.swing.JRadioButton janswerD;
    private javax.swing.JButton jbOK;
    // End of variables declaration//GEN-END:variables

    /**
     * Cài đặt icon
     */
    private void setIcon() {
        ImageIcon icon = new ImageIcon("src/View/TitleIcons/IconTest.png");
        setIconImage(icon.getImage());
    }
}
