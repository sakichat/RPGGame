package logic;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Li ZHEN
 * @version 0.3
 * The class is used to be the log.
 * The Singleton pattern is used here.
 */
public class Logger {

    /**
     * The declaration of the property shareInstance, also the single object.
     */
    private static Logger shareInstance;

    /**
     * The private constructor ensures that the object of the Logger cannot be created.
     */
    private Logger(){

    }

    /**
     * Getter for the shareInstance object.
     * @return Logger
     */
    public static Logger getInstance(){
        if (shareInstance == null) {
            shareInstance = new Logger();
        }
        return shareInstance;
    }


    /**
     * The method is used to show the message along with the date.
     * @param message String
     */
    public void log(String message){
        Date date = new Date();
        String pattern = "hh:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String dateText = simpleDateFormat.format(date);
        System.out.println("LOG " + dateText + ": " + message);
    }


}
