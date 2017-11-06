package com.ramos.gestion.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ramos.gestion.exception.DAOException;
import com.ramos.gestion.exception.LoginException;
import com.ramos.gestion.model.Employee;
import com.ramos.gestion.services.EmployeeService;
import com.ramos.gestion.services.SecurityService;

@Controller
public class EmployeeController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	/*
	@Autowired
	private SecurityService securityService;*/
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/admin/menu")
	public String menu() {

		return "/admin/menu";
	}
	
	
	@GetMapping("/admin/emp/list")
	public String list(@ModelAttribute("SpringWeb") Employee employee, ModelMap model) {

		try {
			model.addAttribute("employees", employeeService.findAll());
		} catch (Exception e) {
			logger.info(e.getMessage());
			model.addAttribute("message", e.getMessage());
		}

		return "admin/emp/list";
	}
	/*
	@PostMapping("/admin/emp/list")
	public ModelAndView login(@ModelAttribute("SpringWeb") Employee employee, ModelMap model) {

			logger.info("login()");
			logger.info(employee.toString());
			
			ModelAndView modelAndView = null;
			
			try {
				Employee emp = securityService.validate(employee.getLogin(), employee.getPassword());
				logger.info(emp.toString());
				modelAndView = new ModelAndView("redirect:/admin/menu", "command", emp);
			} catch (LoginException e) {
				// TODO Auto-generated catch block
				model.addAttribute("message", "Usuario y/o clave incorrectos");
				modelAndView = new ModelAndView("login", "command", new Employee());
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				model.addAttribute("message", e.getMessage());
				modelAndView = new ModelAndView("login", "command", new Employee());
			}

			return modelAndView;
			}*/
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@GetMapping("/{employee_id}")
	public ModelAndView home(@PathVariable int employee_id, ModelMap model) {

		ModelAndView modelAndView = null;
		Employee emp = new Employee();
		try {
			emp = employeeService.find(employee_id);
			logger.info(emp.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		modelAndView = new ModelAndView("home", "command", emp);

		return modelAndView;
	}
	
}


