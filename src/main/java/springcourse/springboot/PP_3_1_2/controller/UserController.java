package springcourse.springboot.PP_3_1_2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springcourse.springboot.PP_3_1_2.model.User;
import springcourse.springboot.PP_3_1_2.service.UserService;


@Controller
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getAllUser());
        return "users";
    }

    @GetMapping("/new")
    public String addNewUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping
    public String saveUser(@ModelAttribute("user") User user) {
        if (user.getId() == null) {
            userService.add(user);
        } else {
            userService.update(user);
        }
        return "redirect:/users";
    }

    @GetMapping("/update/")
    public String updateUser(@RequestParam(value = "id", defaultValue = "") Long id,
                                            Model model) {
        User user = userService.getById(id);
        model.addAttribute("user", user);
        return "new";
    }

    @GetMapping("/delete/")
    public String deleteNewUser(@RequestParam(value = "id", defaultValue = "") Long id) {

        User user = userService.getById(id);
        userService.delete(user);

        return "redirect:/users";
    }

}
