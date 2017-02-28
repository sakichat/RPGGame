package DelegateDemo;

/**
 * Created by thereaghostflash on 2017-02-27.
 */
public class A implements ZDelegate {
    private Z z = new Z();

    public void run(){
        z.setzDelegate(this);
        z.run();
    }

    @Override
    public void message() {
        System.out.println("A");

    }
}
