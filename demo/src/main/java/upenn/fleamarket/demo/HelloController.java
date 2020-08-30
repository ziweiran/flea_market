package upenn.fleamarket.demo;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
    List<Item> all = repo.findAll();
    reverseList(all);
    System.out.println("found with findAll():");
    System.out.println();
    for (Item item : all) {
      System.out.println(item);
    }
    model.addAttribute("items", all);
    return "index";
  }

  @RequestMapping(value = "/products")
  public String displayAll(Model model) {
    model.addAttribute("items", repo.findAll());
    return "products";
  }

  @RequestMapping(value = "/aboutus")
  public String aboutus() {
    return "aboutus";
  }

  @RequestMapping(value = "/item/{id}")
  public String displayOneItem(@PathVariable("id") String id, Model model) {
    return repo.findById(id).map(item -> model.addAttribute("item", item)).map(m -> "details").orElse("aboutus");
  }

  // TODO
  @PostMapping(value = "/sell")
  public ModelAndView submit(@ModelAttribute Item item, Model model) {
    Random randomPic = new Random();
    String pic = "assets/images/default_" + (randomPic.nextInt(2) + 1) + "." + "jpg";
    System.out.println(pic);
    item.setImage(pic);
    repo.save(item);
    return new ModelAndView("redirect:/");
  }

  @RequestMapping(value = "/sell")
  public String form(@ModelAttribute Item item, Model model) {
    return "sell";
  }

  /**
   * reverse the list so that index.html displays the lastest items in database
   * 
   * @param list
   */
  private void reverseList(List<Item> list) {
    if (list == null || list.size() <= 1) {
      return;
    }
    Item item = list.remove(0);
    reverseList(list);
    list.add(item);
  }

}