package comparator;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComparatorController {

    @RequestMapping("/comparator")
    public int compare(@RequestParam(value="val1", defaultValue="World") String val1, @RequestParam(value="val2", defaultValue="World") String val2) {
        return val1.compareTo(val2);
    }
}
