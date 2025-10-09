package object;

import javax.imageio.ImageIO;
import java.io.IOException;

import static java.lang.Thread.sleep;

/**
 * Esta clase define el objeto COIN (moneda)
 */
public class OBJ_Coin extends SuperObject {
    public OBJ_Coin(){
        name = "Coin";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/coin/coin1.png"));
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
