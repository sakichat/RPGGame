package demo.file;

/**
 * Created by Zhaozhe on 26/02/2017.
 */
public class User {

    private String name;
    private int age;

    // 声明为 transient 不会被对象持久化时存储
    private transient int temp;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", temp=" + temp +
                '}';
    }
}
