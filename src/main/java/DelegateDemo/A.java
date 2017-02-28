package DelegateDemo;

/**
 * Created by thereaghostflash on 2017-02-27.
 */
public class A implements ZDelegate {

    public void run(){
    }

    @Override
    public void message() {
        run();

    }
}
