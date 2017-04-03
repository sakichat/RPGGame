package logic;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by thereaghostflash on 2017-04-03.
 */
public class Logger {
    private static Logger shareInstance;

    private Logger(){

    }

    public static Logger getInstance(){
        if (shareInstance == null) {
            shareInstance = new Logger();
        }
        return shareInstance;
    }

    public void showMesaage(String message){
        Date date = new Date();
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String dateText = simpleDateFormat.format(date);
        System.out.println(message + dateText);
    }
}
