/*
    'TongItz' - it's just a temporary name for now.

    Teams that worked on this program:
Design: Christian Joy T. Relato, Jobea Delicano of BSCS 3-2 CGV
Animation:
Just add more team here!

#################
Version: 0.2 ALPHA 
 */
package tongitz;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TongItz extends Application {
    
    @Override
    public void start(Stage Mmenu) throws Exception {
        //  Loads main menu to where AI's are loaded.
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        Mmenu.setScene(scene);
        Mmenu.setResizable(false);
        Mmenu.setTitle("TongItz - Three AI Battle");
        Mmenu.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
