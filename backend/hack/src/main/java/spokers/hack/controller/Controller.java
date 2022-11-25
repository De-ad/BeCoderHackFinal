package spokers.hack.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.web.bind.annotation.*;
import spokers.hack.controller.calculations.RetList;
import spokers.hack.controller.calculations.Runner;

import java.io.*;
import java.util.ArrayList;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/hello")
public class Controller {
    File file = new File("/Users/dead./VisualStudioCodeProjects/hack/backend/hack/file.json");

    @GetMapping
    public String getCommits(@RequestParam(value = "url", defaultValue = "") String value) throws IOException {

//        value это юрл котрый принимает парсер
//        он парсит данные. проверяет по критериям коммиты. результат пишет в файл.цсв этот файл принимается на фронте и
//        и выводится в таблицу пример файла есть в телеге. нужно поменять путь сверху на относительный чтбы работало норм
        System.out.println(value);
        ArrayList<RetList> ret = Runner.run(value);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(ret);
        System.out.println(json);
        return json;
//        try {
//            BufferedReader breader = new BufferedReader(new FileReader(file));
//            String res = "";
//            String st = "";
//            while ((st = breader.readLine()) != null)
//                res += st + "\n";
//            return ret;
//        }
//        catch (Exception e){
//            throw e;
//        }
    }

}
