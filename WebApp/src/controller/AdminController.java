package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import model.Users;
import service.UsersService;

@Controller
public class AdminController {

	@Autowired
	private UsersService userService;

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String showAdminPage(Model model) {

		List<Users> usersList = userService.readUsers();

		model.addAttribute("usersList", usersList);

		return "admin";
	}

	@RequestMapping(value = "/newaccount", method = RequestMethod.GET)
	public String showNewAccount(Model model) {

		Users users = new Users();

		model.addAttribute("users", users);
		return "newaccount";

	}

	@ModelAttribute("type")
	private List typeList() {

		List list = new ArrayList();

		list.add("admin");
		list.add("user");
		return list;

	}

	@RequestMapping(value = "/newaccount", method = RequestMethod.POST)
	public String createAccount(@Valid Users users, BindingResult bindingResult,
			final RedirectAttributes redirectAttributes) {

		if (bindingResult.hasErrors()) {

			System.out.println("Form does not validate!!");
			return "newaccount";
		}

		if (userService.exsist(users.getUsername())) {

			bindingResult.rejectValue("username", "DuplicateKey.users.username");

			return "newaccount";

		}

		else {

			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "User added successfully!"); // add
																						// messeges
																						// to
																						// bootstrap
																						// alert

		}

		userService.saveSe(users);
		return "redirect:/admin";

	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String showSditAccount(HttpServletRequest request, Model model) {

		int id = Integer.parseInt(request.getParameter("id"));

		Users users = userService.getUsers(id);

		model.addAttribute("users", users);

		return "edit";

	}

	@RequestMapping(value = "/updateaccount", method = RequestMethod.POST)
	public String updateAccount(@Valid Users users, BindingResult bindingResult,
			final RedirectAttributes redirectAttributes) {

		if (bindingResult.hasErrors()) {

			System.out.println("Form does not validate!!");
			return "edit";
		}

		else {

			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "User updated successfully!"); // add
																						// messeges
																						// to
																						// bootstrap
																						// alert

		}

		userService.update(users);
		return "redirect:/admin";

	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteAccount(@RequestParam int id, final RedirectAttributes redirectAttributes) {

		redirectAttributes.addFlashAttribute("css", "danger");
		redirectAttributes.addFlashAttribute("msg", "User deleted successfully!"); // add
																					// messeges
																					// to
																					// bootstrap
																					// alert

		userService.delete(id);

		userService.resetAutoIncrement(); // this method reset the id column in
											// database table
											// when we delete user

		return "redirect:/admin";

	}
}
