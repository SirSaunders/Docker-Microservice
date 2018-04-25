package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.List;

@RestController
public class SorterController {

    @RequestMapping("/sort")
    public String sort(@RequestParam(value="words") String words) {

        List<String> wordList = Arrays.asList(words.split(","));

        wordList.sort((o1, o2) -> {
            try {
                return networkRequest(o1.toLowerCase(), o2.toLowerCase());
            } catch (IOException e) {
                e.printStackTrace();
                return 0;
            }
        });


        String result = "";
        for (String item : wordList) {
            result += item + ",";
        }
        result = result.substring(0, result.length() - 1);

        return result;
    }

    private int networkRequest(String val1, String val2) throws IOException {
        URL url = new URL("comparator:8080?val1=" + val1 + "&val2=" + val2);
        URLConnection connection = url.openConnection();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));
        String inputLine;

        int result = 0;

        while ((inputLine = in.readLine()) != null)
            result = Integer.parseInt(inputLine);
        in.close();

        return result;
    }

    @RequestMapping("/")
    public String hello()  {
        return "hello, I am sorter";
    }
}
