package spokers.hack.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/hello")
public class Controller {

    File file = new File("/Users/dead./VisualStudioCodeProjects/hack/backend/hack/file.json");
    StringBuilder stringBuilder = new StringBuilder();


    @GetMapping
    public String sayHello() throws IOException {
//        return file.toString();
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
