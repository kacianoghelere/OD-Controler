
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kaciano
 */
public class Test {

    public Test() {
        try {
            AdvancedPlayer ap = new AdvancedPlayer(new FileInputStream("/home/kaciano/mp3/test.mp3"));
            ap.play();
//            ap.
            
        } catch (JavaLayerException | IOException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        new Test();
    }
}
