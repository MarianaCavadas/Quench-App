package org.academiadecodigo.charliesangels.controllers.web;

import org.academiadecodigo.charliesangels.models.Poll;
import org.academiadecodigo.charliesangels.models.User;
import org.academiadecodigo.charliesangels.services.LogginService;
import org.academiadecodigo.charliesangels.services.PollService;
import org.academiadecodigo.charliesangels.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class UserController {

    private UserService userService;
    private PollService pollService;
    private LogginService logginService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setPollService(PollService pollService) {
        this.pollService = pollService;
    }

    @Autowired
    public void setLogginService(LogginService logginService) {
        this.logginService = logginService;
    }

    @RequestMapping(method = RequestMethod.GET, path = {"", "/", "/home"})
    public String showHome() {
        return "home";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/newpoll")
    public String showFormPoll(Model model) {
        model.addAttribute("poll", new Poll());
        return "pollform";
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/", ""}, params = "action=save")
    public String savePoll(@Valid @ModelAttribute("poll") Poll poll, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return "pollform";
        }

        Poll savedPoll = pollService.savePoll(poll);

        redirectAttributes.addFlashAttribute("lastAction", "Saved new poll!!");

        return "redirect:/poll/" + savedPoll.getId();
    }

    @RequestMapping (method = RequestMethod.POST, path = {"/", ""}, params = "action=cancel")
    public String cancelSavePoll() {
        return "redirect:/home";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/poll/{id}")
    public String showPoll(@PathVariable Integer id, Model model){
        Poll poll = pollService.getPoll(id);

        if (poll == null) {
            return "redirect:/poll/" + id + "/next";
        }

        model.addAttribute("poll", poll);
        return "poll";
    }


    /*

      if it all goes to shit it's this method right here
        ||
        VV

    */

    @RequestMapping(method = RequestMethod.GET, path = "/poll/{id}/next")
    public String nextPoll(@PathVariable Integer id) {
        Integer newId = id++;

        if (pollService.getPoll(newId) == null) {
            return "redirect:/home";
        }

        return "redirect:/poll/" + newId;
    }


    @RequestMapping(method = RequestMethod.GET, path = "/user/{id}")
    public String showUser(@PathVariable Integer id, Model model) {

        User user = userService.getUser(id);
        model.addAttribute("user", user);

        return "showuser";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/signup")
    public String addUser(Model model) {

        model.addAttribute("user", new User());

        return "adduser";
    }

    @RequestMapping(method = RequestMethod.POST, path ={"/", ""}, params = "action=save")
    public String saveUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "adduser";
        }

        User savedUser = userService.saveUser(user);

        redirectAttributes.addFlashAttribute("lastAction", "Thank you, " + savedUser.getUsername() + "!!");

        return "redirect:/user/" + savedUser.getId();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/login")
    public String login() {

        return "login";
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/", ""}, params = "acation=save")
    public String authenticate(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "login";
        }

        User savedUser = userService.getUserByUsername(user.getUsername());

        if (savedUser == null) {
            return "login";
        }

        String password = savedUser.getPassword();
        String username = savedUser.getUsername();

        if (!logginService.authenticate(username, password)) {
            return "login";
        }

        return "redirect:/user/" + savedUser.getId();

    }

    


}
