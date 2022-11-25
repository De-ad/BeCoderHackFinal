package spokers.hack.controller;

import org.springframework.web.bind.annotation.*;
import java.io.*;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/hello")
public class Controller {
    File file = new File("C:\\Users\\erikr\\Desktop\\backend\\hack\\backend\\hack\\file.json");

    @GetMapping
    public String getCommits(@RequestParam(value = "url", defaultValue = "") String value) throws IOException {
//        python here
        System.out.println(value);
        try {
            BufferedReader breader = new BufferedReader(new FileReader(file));
            String res = "";
            String st = "";
            while ((st = breader.readLine()) != null)
                res += st + "\n";
            return res;
        }
        catch (Exception e){
            throw e;
        }
    }

}
