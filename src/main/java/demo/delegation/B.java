package demo.delegation;

/**
 * Created by thereaghostflash on 2017-02-27.
 */
public class B implements ZDelegate {

    public void run(){
    }

    @Override
    public void message() {
        run();

    }
}
