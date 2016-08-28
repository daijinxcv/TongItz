// This file contains event handlers for main menu.
// HIGHLY SUGGESTS TO PUT EVERYTHING THAT IS SCENE / WINDOW-DEPENDENT HERE.
package tongitz;

import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;
import javafx.util.Duration;
import java.util.ResourceBundle;
import javax.swing.Timer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class FXMLDocumentController implements Initializable {

    @FXML
    // variables? declarations. Yes.
    public AnchorPane mainPane;
    public TextField Player1FileLocationString, Player2FileLocationString, Player3FileLocationString, player1namestringfield, player2namestringfield, player3namestringfield;
    public Pane player1container, player2container, player3container, PlayerSelectionPane, Mainboard;
    public Label player1filelocationtext, player2filelocationtext, player3filelocationtext;
    public Label player1text, player2text, player3text;
    public Text MainMessage, GameTitle, ReflectedGameTitle;
    public Button player1lockinbutton, player2lockinbutton, player3lockinbutton;
    public ProgressIndicator player1progress, player2progress, player3progress, mainProgressLoader, PreparingIndicator;
    public Timeline waitingText, progress1animation, progress2animation, progress3animation, allSetAnimation, FadeOut, FadeIn;
    public Stage stage;
    public Timer PlayerSelectFadeOutTimer;
    public int counterFO = 0;
    public Pagination Player1Page, Player2Page, Player3Page, DealerPage;

    // Action Handlers
    @FXML
    public void player1lockInButtonAction(ActionEvent event) throws Exception {
        // Locks in Player 1 for Battle!
        if (new File(Player1FileLocationString.getText()).exists()) {
            System.out.println("Player 1 has locked in!");
            player1lockinbutton.setDisable(true);
            player1progress.setVisible(true);
            Player1FileLocationString.setDisable(true);
            player1text.setTextFill(Color.GREEN);
            player1lockinbutton.setText("Player 1 ready");
            player1container.setStyle("-fx-background-color: #454545; -fx-border-color: GREEN; -fx-border-radius: 5%; -fx-background-radius: 5%; -fx-border-width: 5;");
            String[] fileLocToken = Player1FileLocationString.getText().split("[\\\\\\.]");
            player1namestringfield.setText(fileLocToken[fileLocToken.length - 2]);
            player1namestringfield.setDisable(true);
            // Player 1 Progressbar Animation
            progress1animation = new Timeline();
            progress1animation.setCycleCount(1);
            KeyValue animate1progbarKV;
            KeyFrame animate1progbarKF;
            animate1progbarKV = new KeyValue(player1progress.progressProperty(), 1.0);
            animate1progbarKF = new KeyFrame(Duration.millis(250), animate1progbarKV);
            progress1animation.getKeyFrames().add(animate1progbarKF);
            progress1animation.play();
            SoundEffects("src//tongitz//Resources//beep.mp3");
            PlayersChecker();

        } else {
            JOptionPane.showMessageDialog(null, "File doesn't exist!");
        }
    }

    public void player2lockInButtonAction(ActionEvent event) throws Exception {
        // Locks in Player 2 for Battle!
        if (new File(Player2FileLocationString.getText()).exists()) {
            System.out.println("Player 2 has locked in!");
            player2lockinbutton.setDisable(true);
            player2progress.setVisible(true);
            Player2FileLocationString.setDisable(true);
            player2text.setTextFill(Color.GREEN);
            player2lockinbutton.setText("Player 2 ready");
            player2container.setStyle("-fx-background-color: #454545; -fx-border-color: GREEN; -fx-border-radius: 5%; -fx-background-radius: 5%; -fx-border-width: 5;");
            String[] fileLocToken = Player2FileLocationString.getText().split("[\\\\\\.]");
            player2namestringfield.setText(fileLocToken[fileLocToken.length - 2]);
            player2namestringfield.setDisable(true);
            // Player 2 Progressbar Animation
            progress2animation = new Timeline();
            progress2animation.setCycleCount(1);
            KeyValue animate2progbarKV;
            KeyFrame animate2progbarKF;
            animate2progbarKV = new KeyValue(player2progress.progressProperty(), 1.0);
            animate2progbarKF = new KeyFrame(Duration.millis(250), animate2progbarKV);
            progress2animation.getKeyFrames().add(animate2progbarKF);
            progress2animation.play();
            SoundEffects("src//tongitz//Resources//beep.mp3");
            PlayersChecker();

        } else {
            JOptionPane.showMessageDialog(null, "File doesn't exist!");
        }
    }

    public void player3lockInButtonAction(ActionEvent event) throws Exception {
        // Locks in Player 3 for Battle!
        if (new File(Player2FileLocationString.getText()).exists()) {
            System.out.println("Player 3 has locked in!");
            player3lockinbutton.setDisable(true);
            player3progress.setVisible(true);
            Player3FileLocationString.setDisable(true);
            player3text.setTextFill(Color.GREEN);
            player3lockinbutton.setText("Player 3 ready");
            player3container.setStyle("-fx-background-color: #454545; -fx-border-color: GREEN; -fx-border-radius: 5%; -fx-background-radius: 5%; -fx-border-width: 5;");
            String[] fileLocToken = Player3FileLocationString.getText().split("[\\\\\\.]");
            player3namestringfield.setText(fileLocToken[fileLocToken.length - 2]);
            player3namestringfield.setDisable(true);
            // Player 3 Progressbar Animation
            progress3animation = new Timeline();
            progress3animation.setCycleCount(1);
            KeyValue animate3progbarKV;
            KeyFrame animate3progbarKF;
            animate3progbarKV = new KeyValue(player3progress.progressProperty(), 1.0);
            animate3progbarKF = new KeyFrame(Duration.millis(250), animate3progbarKV);
            progress3animation.getKeyFrames().add(animate3progbarKF);
            progress3animation.play();
            SoundEffects("src//tongitz//Resources//beep.mp3");
            PlayersChecker();

        } else {
            JOptionPane.showMessageDialog(null, "File doesn't exist!");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // START UP PROCEDURES
        mainPane.setStyle("-fx-background-image: url(\"file:src//tongitz//Resources//bgimg.jpg\");");
        WaitForPlayersAnimation();
        BackgroundMusicPlayback("src//tongitz//Resources//Musics//bgm.mp3");
        Mainboard.setVisible(false);
        PlayerSelectionPane.setVisible(true);
        Mainboard.setOpacity(0);
        PlayerSelectionPane.setOpacity(1);
    }

    public void BackgroundMusicPlayback(String bgmFile) {
        // Main Menu BGM
        Media bgm = new Media(new File(bgmFile).toURI().toString());
        MediaPlayer player = new MediaPlayer(bgm);
        player.setAutoPlay(true);
        player.setVolume(0.1);
        player.setCycleCount(MediaPlayer.INDEFINITE);
        player.play();
    }

    public void WaitForPlayersAnimation() {
        //Makes "waiting for players" text appear blinking!
        waitingText = new Timeline();
        waitingText.setCycleCount(Timeline.INDEFINITE);
        KeyValue wtKV;
        KeyFrame wtKF;
        wtKV = new KeyValue(MainMessage.opacityProperty(), 0.0);
        wtKF = new KeyFrame(Duration.millis(2500), wtKV);
        waitingText.getKeyFrames().add(wtKF);
        waitingText.play();
    }

    public void SoundEffects(String srcFile) {
        String sfxFile = srcFile;
        Media sfx = new Media(new File(sfxFile).toURI().toString());
        MediaPlayer player = new MediaPlayer(sfx);
        player.setAutoPlay(true);
        player.setVolume(80);
        player.setCycleCount(1);
        player.play();
    }

    public void PlayersChecker() throws Exception {
        // This functions is checked everytime a lock-in event occurs, this is to check if all players are present.
        if (player1text.getTextFill() == Color.GREEN && player2text.getTextFill() == Color.GREEN && player3text.getTextFill() == Color.GREEN) {
            // All players detected -> Start loading mainboard.
            System.out.println("Game is now starting...");
            MainMessage.setText("Game is starting up...");
            waitingText.stop();
            MainMessage.setOpacity(1);
            mainProgressLoader.setVisible(false);
            allSetAnim();
        }
    }

    public void allSetAnim() {
        //Makes main menu go smaller in scale then pause for 4 seconds then loads mainboard
        allSetAnimation = new Timeline();
        allSetAnimation.setCycleCount(1);
        KeyValue as1KV, as2KV, as3KV, mainMessKV, titleKV, titlerefKV;
        KeyFrame as1KF, as2KF, as3KF, mainMessKF, titleKF, titlerefKF;
        as1KV = new KeyValue(player1container.layoutYProperty(), 205);
        as2KV = new KeyValue(player2container.layoutYProperty(), 205);
        as3KV = new KeyValue(player3container.layoutYProperty(), 205);
        titleKV = new KeyValue(GameTitle.fillProperty(), Color.BLUE);
        titlerefKV = new KeyValue(ReflectedGameTitle.fillProperty(), Color.BLUE);
        mainMessKV = new KeyValue(MainMessage.layoutYProperty(), 150);
        as1KF = new KeyFrame(Duration.millis(250), as1KV);
        as2KF = new KeyFrame(Duration.millis(250), as2KV);
        as3KF = new KeyFrame(Duration.millis(250), as3KV);
        titleKF = new KeyFrame(Duration.millis(500), titleKV);
        titlerefKF = new KeyFrame(Duration.millis(500), titlerefKV);
        mainMessKF = new KeyFrame(Duration.millis(250), mainMessKV);
        allSetAnimation.getKeyFrames().add(as1KF);
        allSetAnimation.getKeyFrames().add(as2KF);
        allSetAnimation.getKeyFrames().add(as3KF);
        allSetAnimation.getKeyFrames().add(titleKF);
        allSetAnimation.getKeyFrames().add(titlerefKF);
        allSetAnimation.getKeyFrames().add(mainMessKF);
        allSetAnimation.play();
        SoundEffects("src//tongitz//Resources//whoosh.mp3");
        
        LoadMainboard();
    }
    
    public void LoadMainboard(){
        PlayerSelectFadeOutTimer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                while (counterFO < 3) {
                    System.out.println(counterFO);
                    counterFO++;
                }
                if (counterFO == 3) {

                    FadeOut = new Timeline();
                    FadeOut.setCycleCount(1);
                    KeyValue FOKV;
                    KeyFrame FOKF;
                    FOKV = new KeyValue(PlayerSelectionPane.opacityProperty(), 0);
                    FOKF = new KeyFrame(Duration.millis(1000), FOKV);
                    FadeOut.getKeyFrames().add(FOKF);
                    FadeOut.play();
                    System.out.println("Fading out Player Selection Screen");

                    Mainboard.setVisible(true);
                    FadeIn = new Timeline();
                    FadeIn.setCycleCount(1);
                    KeyValue FIKV;
                    KeyFrame FIKF;
                    FIKV = new KeyValue(Mainboard.opacityProperty(), 1.0);
                    FIKF = new KeyFrame(Duration.millis(1000), FIKV);
                    FadeIn.getKeyFrames().add(FIKF);
                    FadeIn.play();
                    System.out.println("Fading in Mainboard");
                    PlayerSelectFadeOutTimer.stop();
                    if (PlayerSelectFadeOutTimer.isRunning() == false) {
                        PlayerSelectionPane.setVisible(false);
                        System.out.println("Selection faded out");
                        BackgroundMusicPlayback("src//tongitz//Resources//Musics//bgm2.mp3");
                        StartGame();
                    }
                }
            }
        });
        PlayerSelectFadeOutTimer.start();
    }
    
    public void DealerPaginationControl(){
        // SOMETHING IS BROKEN HERE
        
        DealerPage.setPageCount(5);
       DealerPage.setMaxPageIndicatorCount(5);
//       DealerPage.setVisible(false);
  
    }
    
    public void StartGame(){
        DealerPaginationControl();
    }
}

// TEST FILE LOCATION FOR ME
// C:\Users\daijinxcv\Downloads\ArceusNameTest.tgt
