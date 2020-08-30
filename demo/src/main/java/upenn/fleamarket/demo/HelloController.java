package upenn.fleamarket.demo;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import upenn.fleamarket.demo.data.Email;
import upenn.fleamarket.demo.data.Item;
import upenn.fleamarket.demo.data.ItemRepository;

@Controller
public class HelloController {
  public final ItemRepository repo;
  @Autowired
  private JavaMailSender mailSender;

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

  /**
   * Get item's id by @PathVariable Repo.findById returns optional<Item>, add this
   * to model, then return "details" this page if all successfull
   * 
   * @param id
   * @param model
   * @return
   */
  @RequestMapping(value = "/item/{id}")
  public String displayOneItem(@PathVariable("id") String id, Model model) {
    return repo.findById(id).map(item -> model.addAttribute("item", item))
        .map(m -> m.addAttribute("email", new Email())).map(m -> "details").orElse("aboutus");
  }

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

  @PostMapping(value = "/item/{id}")
  public ModelAndView sendEmail(@PathVariable("id") String id, @ModelAttribute("email") Email email, Model model,
      RedirectAttributes redirectAttributes) {
    model.addAttribute("email", new Email());
    String senderAddress = email.getSenderAddress();
    String senderName = email.getSenderName();
    String subject = email.getSubject();
    String text = email.getBody();
    SimpleMailMessage msg = new SimpleMailMessage();
    msg.setText("Hi there," + System.lineSeparator() + senderName
        + " would like to purchase your item, if you'd like you can respond to this Email address: " + senderAddress
        + System.lineSeparator() + "Here's the message: " + System.lineSeparator() + text);
    msg.setSubject(subject);
    Item item = repo.findById(id).get();
    String toAddress = item.getEmail();
    msg.setTo(toAddress);
    mailSender.send(msg);
    System.out.println("sent!");

    redirectAttributes.addFlashAttribute("notification", "Email successfully sent");
    return new ModelAndView("redirect:/");
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