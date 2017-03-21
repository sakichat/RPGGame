package demo.delegation;

/**
 * Created by thereaghostflash on 2017-02-27.
 */
public class Z {
    private ZDelegate zDelegate;

    public ZDelegate getzDelegate() {
        return zDelegate;
    }

    public void setzDelegate(ZDelegate zDelegate) {
        this.zDelegate = zDelegate;
    }

    public void run(){
        zDelegate.message();
    }
}
