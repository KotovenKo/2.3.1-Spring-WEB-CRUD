package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.Service.UserService;
import web.model.User;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public String lisOfUsers(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "users/listofusers";
    }

    @GetMapping("/usersbycounter")
    public String usersByCounter(@RequestParam(value = "counter") int counter, Model model) {
        model.addAttribute("users", userService.getNumberOfUsers(counter));
        return "users/usersbycounter";
    }

    @GetMapping("/new")
    public String createUserPage(Model model) {
        model.addAttribute("user", new User());
        return "users/new";
    }

    @PostMapping("")
    public String createCar(@Valid @ModelAttribute(value = "user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "users/new";
        } else {
            userService.addUser(user);
            return "redirect:/users";
        }
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "users/edit";
    }

    @PatchMapping("{id}")
    public String update( @PathVariable("id") long id, @ModelAttribute(value = "user") @Valid User user, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "users/edit";
        } else {
            userService.update(id, user);
            return "redirect:/users";
        }
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable("id") long id) {
        userService.delete(id);
        return "redirect:/users";
    }

}
