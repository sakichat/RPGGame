package demo.file;

import com.google.gson.Gson;
import persistence.FileManager;

import java.io.File;

public class GsonDemo {
    public static void main(String[] args) {

        File file = new File("file/gson.txt");

        //  Write
        //  +   Object
        User user = new User();
        user.setName("hehe");
        user.setAge(20);
        user.setTemp(12);

        //  +   Memory[Object] -> Memory[String]
        Gson gson = new Gson();
        String content = gson.toJson(user);

        //  +   Memory[String] -> File[Binary]
        FileManager.stringToFile(content, file);

        System.out.println(content);



        //  Read
        //  +   File[Binary] -> Memory[String]
        String contentIn = FileManager.fileToString(file);

        //  +   Memory[String] -> Memory[Object]
        User userIn = new Gson().fromJson(contentIn, User.class);

        System.out.println(userIn);
    }
}
