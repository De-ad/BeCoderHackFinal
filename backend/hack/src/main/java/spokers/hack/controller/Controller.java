package spokers.hack.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.web.bind.annotation.*;
import spokers.hack.controller.calculations.RetList;
import spokers.hack.controller.calculations.Runner;

import java.io.*;
import java.util.ArrayList;

@CrossOrigin(origins = "http://localhost:3001/")
@RestController
@RequestMapping("/hello")
public class Controller {

    File file = new File(System.getProperty("user.dir") + "/hack/file.json");
    File error = new File(System.getProperty("user.dir") + "/hack/error.json");

    @GetMapping
    public String getCommits(@RequestParam(value = "url", defaultValue = "") String value) throws IOException {

        System.out.println(value);
        ArrayList<RetList> ret = Runner.run(value);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(ret);
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
//        if (json.equals("[]")){
//            try {
//                BufferedReader breader = new BufferedReader(new FileReader(error));
//                String res = "";
//                String st = "";
//                while ((st = breader.readLine()) != null)
//                    res += st + "\n";
//                return res;
//            }
//            catch (Exception e){
//                throw e;
//            }
        

//        return json;

    }

}
