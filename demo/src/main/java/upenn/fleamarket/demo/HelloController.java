package upenn.fleamarket.demo;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import upenn.fleamarket.demo.data.Item;
import upenn.fleamarket.demo.data.ItemRepository;

@Controller
public class HelloController {
  public final ItemRepository repo;

  HelloController(ItemRepository repo) {
    this.repo = repo;
  }

  @RequestMapping("/")
  public String index(Model model) {
    model.addAttribute("items", repo.findAll());
    return "index";
  }

  @RequestMapping(value = "/search")
  public String search(@RequestParam(name = "a") String a, Model model) {
    model.addAttribute("a", a);
    return "abc";
  }

}