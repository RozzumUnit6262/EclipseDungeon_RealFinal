package math130.eclipsedungeon_realfinal;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

public class GameController
{


    @FXML // gui elements
    public ImageView EnemyDisplay;
    public Label displayHP;
    public TextField getInput;
    public Label displayDialogue;


    // enemy portraits
    public Image enemyDefault = new Image(Objects.requireNonNull(getClass().getResourceAsStream("ed_default.png")));
    public Image enemyBat = new Image(Objects.requireNonNull(getClass().getResourceAsStream("ed_bytebat.png")));
    public Image enemySlime = new Image(Objects.requireNonNull(getClass().getResourceAsStream("ed_scannerslime.png")));
    public Image enemyViper = new Image(Objects.requireNonNull(getClass().getResourceAsStream("ed_virusviper.png")));
    public Image enemyBoss = new Image(Objects.requireNonNull(getClass().getResourceAsStream("ed_gigabytegolem.png")));

    @FXML
    protected void onHelloButtonClick()
    {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    protected void updateHP(int i)
    {
        displayHP.setText("HP - " + i);
    }
    protected void setEnemyDisplay(Image e)
    {
        EnemyDisplay.setImage(e);
    }
    protected void setDisplayDialogue(String s)
    {
        displayDialogue.setText(s);
    }
}
