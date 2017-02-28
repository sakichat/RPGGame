package DelegateDemo;

/**
 * Created by thereaghostflash on 2017-02-27.
 */
public class Z {
    private ZDelegate zDelegate;

    public Z(ZDelegate zDelegate) {
        this.zDelegate = zDelegate;
    }
    public void run(){
        zDelegate.message();
    }
}
