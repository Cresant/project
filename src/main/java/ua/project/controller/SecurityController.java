package ua.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ua.project.model.user.Role;
import ua.project.model.user.User;
import ua.project.service.RoleService;
import ua.project.service.UserService;
import ua.project.validation.UserFormValidation;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@Controller
public class SecurityController {

    private String loginView = "/login";
    private String registrationView = "/registration";
    private String error403View = "/403";

    private final UserService userService;
    private final RoleService roleService;
    private final UserFormValidation userFormValidation;

    @Autowired
    public SecurityController(UserService userService,
                              RoleService roleService,
                              UserFormValidation userFormValidation) {
        this.userService = userService;
        this.roleService = roleService;
        this.userFormValidation = userFormValidation;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout) {
        ModelAndView model = new ModelAndView(loginView);
        if (error != null) {
            model.addObject("error", "Invalid Login Or Password!");
        }
        return model;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView registration(User user, @RequestParam(value = "error", required = false) String error) {
        ModelAndView model = new ModelAndView(registrationView);
        return model;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView registration(@Valid @ModelAttribute User user,
                                     final BindingResult result,
                                     final ModelAndView modelAndView,
                                     RedirectAttributes redirectAttrs) {
        userFormValidation.validate(user, result);
        if (user.getLogin() == null &&
                userService.getUserByLogin(user.getLogin()) != null) {
            result.rejectValue("login", "exist.user.login");
        }
        if (result.hasErrors()) {
            return modelAndView;
        }
        Set<Role> role = new HashSet<>();
        role.add(roleService.getRoleByName("ROLE_USER"));
        user.setRoles(role);
        user.setActive(true);
        userService.addUser(user);
        redirectAttrs.addFlashAttribute("success", "You are registered! Please log in! Your login: " + user.getLogin());
        return new ModelAndView("redirect:" + loginView);
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public ModelAndView accessDenied() {
        ModelAndView model = new ModelAndView(error403View);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();
            model.addObject("username", userDetail.getUsername());
        }
        return model;
    }
}
