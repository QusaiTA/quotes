package quotes;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Hello");


        Gson gson = new Gson();
        Reader reader = new FileReader("../quotes/recentquotes.json");


        // credit to stack over flow <3;
        Type listType = new TypeToken<ArrayList<Book>>(){}.getType();


        List<Book> bookList = gson.fromJson(reader,listType);



        Random random = new Random();
        int books = random.nextInt(bookList.size());

        System.out.println(bookList.get(books).toString());






    }



}

