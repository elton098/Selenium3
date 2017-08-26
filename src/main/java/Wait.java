/**
 * Created by SteamRolan on 8/20/2017.
 */
public class Wait {

    public static void sleep(int milliseconds){
        try {
            Thread.sleep(milliseconds);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
