package PAF.day23workshop.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import PAF.day23workshop.model.Order;
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
  

    @PostMapping("/search")
    public String processSearch(@ModelAttribute("searchObject") SearchRequest searchObj, Model model, BindingResult result) {
        List<Order> orders = orts.findOrderById(searchObj.getOrderId());
        model.addAttribute("orders", orders);

        return "orderlist";
    }


  

}
