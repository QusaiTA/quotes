package quotes;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Hello");


            String URL = "http://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en";
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(URL).openConnection();
            httpURLConnection.setRequestMethod("GET");
//            httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");



            int response = 0;
            try {
               response= httpURLConnection.getResponseCode();
            } catch (IOException exception){
                httpURLConnection.disconnect();
            }
            if(response == HttpURLConnection.HTTP_OK) {
                InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String data = bufferedReader.readLine();
                bufferedReader.close();
                Gson gson = new Gson();
                ApiQuotes apiQuotes = gson.fromJson(data, ApiQuotes.class);
                String getAuther = apiQuotes.getAuthor();
                String getQuote = apiQuotes.getText();
                System.out.println("Api Author => " + getAuther);
                System.out.println("Api Quote =>" + getQuote);

                Book quotesFromAPI = new Book(getAuther,getQuote);
                Writer writer = new FileWriter("recentquotes.json",true);

                gson.toJson(quotesFromAPI+",",writer);
                System.out.println(quotesFromAPI);
                writer.close();

            }

            else {

                Gson gson = new Gson();
                JsonReader reader = new JsonReader(new FileReader("recentquotes.json"));
                // credit to stack over flow <3;
                Type listType = new TypeToken<ArrayList<Book>>(){}.getType();
                List<Book> bookList =  gson.fromJson(reader,listType);
                Random random = new Random();
                int books = random.nextInt(bookList.size());
                System.out.println("Local Author file => " +bookList.get(books).getAuthor());
                System.out.println("Local Quotes file => " +bookList.get(books).getText());

            }


    return;

    }
}

