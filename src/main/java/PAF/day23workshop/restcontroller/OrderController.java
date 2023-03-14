package PAF.day23workshop.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import PAF.day23workshop.payload.SearchRequest;
import PAF.day23workshop.service.OrderRestTemplateService;

@Controller
@RequestMapping("/orders")
public class OrderController {
    
    @Autowired
    OrderRestTemplateService orts;

    @GetMapping
    public String searchOrder(Model model) {
        SearchRequest sr = new SearchRequest();
        model.addAttribute("searchObject", sr);

        return "searchorder";
    }
  

  

}
