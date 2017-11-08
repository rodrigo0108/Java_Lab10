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
import com.ramos.gestion.model.Department;
import com.ramos.gestion.model.Employee;
import com.ramos.gestion.services.DepartmentService;


@Controller
public class DepartmentController {
	
	private static final Logger logger = LoggerFactory.getLogger(DepartmentController.class);
	
	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping("/admin/dpto/list")
	public String list(@ModelAttribute("SpringWeb") Employee employee, ModelMap model) {

		try {
			model.addAttribute("departments", departmentService.findAll());
		} catch (Exception e) {
			logger.info(e.getMessage());
			model.addAttribute("message", e.getMessage());
		}

		return "admin/dpto/list";
	}
	
	@GetMapping("/admin/dpto/{action}/{department_id}")
	public ModelAndView form(@PathVariable String action, @PathVariable int department_id, ModelMap model) {

		// action = {"editform","deleteform"}
		logger.info("action = " + action);
		ModelAndView modelAndView = null;

		try {
			Department dep = departmentService.find(department_id);
			logger.info(dep.toString());
			modelAndView = new ModelAndView("admin/dpto/" + action, "command", dep);
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			modelAndView = new ModelAndView("admin/dpto/" + action, "command", new Department());
		}

		return modelAndView;
	}
	
	@PostMapping("/admin/dpto/editsave")
	public ModelAndView editsave(@ModelAttribute("SpringWeb") Department dep, ModelMap model) {

		
		logger.info("dep = " + dep);
		
		ModelAndView modelAndView = null;

		try {
			departmentService.update(dep.getName(), dep.getDesc(), dep.getCity());

			modelAndView = new ModelAndView("redirect:/admin/dpto/list");
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			modelAndView = new ModelAndView("redirect:/admin/dpto/list");
		}

		return modelAndView;
	}
	
	@PostMapping("/admin/dpto/delete")
	public ModelAndView delete(@ModelAttribute("SpringWeb")  Department dep, ModelMap model) {

		ModelAndView modelAndView = null;

		try {
			departmentService.delete(dep.getName());
			modelAndView = new ModelAndView("redirect:/admin/dpto/list");
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			modelAndView = new ModelAndView("redirect:/admin/dpto/list");
		}

		return modelAndView;
	}
	
	@GetMapping("/admin/dpto/createform")
	public ModelAndView createform() {

		Department dep = new Department();

		ModelAndView modelAndView = new ModelAndView("admin/dpto/createform", "command", dep);

		return modelAndView;
	}
	
	@PostMapping("/admin/dpto/create")
	public ModelAndView create(@ModelAttribute("SpringWeb") Department dep, ModelMap model) {

		
		ModelAndView modelAndView = null;
		
		try {
			departmentService.create(dep.getName(), dep.getDesc(), dep.getCity());
			logger.info("new Department login = " + dep.getName());
			modelAndView = new ModelAndView("redirect:/admin/dpto/list");
		} catch (DAOException e) {
			logger.error(e.getMessage());
			model.addAttribute("message", e.getMessage());
			modelAndView = new ModelAndView("admin/dpto/createform","command", dep);
		}

		return modelAndView;
	}
	

}
