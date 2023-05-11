package springnews.controller;

import springnews.model.News;
import springnews.service.NewsService;
import springnews.model.User;
import springnews.service.SecurityService;
import springnews.service.UserService;
import springnews.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private NewsService newsService;


    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getConfirmPassword());

        return "redirect:/welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Username or password is incorrect.");
        }

        if (logout != null) {
            model.addAttribute("message", "Logged out successfully.");
        }

        return "login";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome";
    }


    @RequestMapping(value = "/newsadmin", method = RequestMethod.GET)
    public String newsadmin(Model model) {
        model.addAttribute("allNews", newsService.allNews());
        return "newsadmin";
    }

    @GetMapping("/news")
    public String newsList(Model model) {
        model.addAttribute("allNews", newsService.allNews());
        return "news";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteNews(@PathVariable("id") long id, Model model) {
        newsService.delete(id);
        return "redirect:/newsadmin";
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addnews(Model model) {
        model.addAttribute("newsForm", new News());

        return "addPage";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addnews(@ModelAttribute("newsForm") News newsForm, Model model) {
        newsService.save(newsForm);

        return "redirect:/newsadmin";
    }

}

