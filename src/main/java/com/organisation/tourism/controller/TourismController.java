package com.organisation.tourism.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.organisation.tourism.entity.Search;
import com.organisation.tourism.entity.TourPackage;
import com.organisation.tourism.entity.UserManage;
import com.organisation.tourism.service.TourismService;

@Controller
@RequestMapping("/tourPackage")
public class TourismController {
	
	@Autowired
	TourismService tourismService;
	
	@InitBinder
	public void doPreProcessing(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor=new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@GetMapping("/login")
	public String displayWelcomePage(Model theModel,HttpServletRequest request) {
		request.getSession(false);
		if(request.getSession().getAttribute("username")!=null) {
			request.getSession().invalidate();
			return "redirect:/";
		
		}
		else {
			UserManage user=new UserManage();
			theModel.addAttribute("user", user);
			return "welcome";
		}
	}

	
	@PostMapping("/validate")
	public String validateUser(@ModelAttribute("user") UserManage user,Model theModel,HttpServletRequest request) {
		request.getSession(false);
		List<UserManage> userList=tourismService.getAllUsers();
		int flag=0;
		for(UserManage u:userList) {
			if((u.getUserName().equalsIgnoreCase(user.getUserName()))&&(u.getPassword().equals(user.getPassword()))) {
				flag=1;
				
			}
		}
		if(flag==1) {
			request.getSession().setAttribute("username", user.getUserName());
			return "redirect:/tourPackage/list";
		}
		else {
			String msg="User Name or Password doesn't match";
			theModel.addAttribute("errorMsg", msg);
			return "welcome";
		}
	}
	
	
	@GetMapping("/list")
	public String listTourPackages(Model theModel,HttpServletRequest request) {
		if(request.getSession().getAttribute("username")!=null) {
		List<TourPackage> tourPackage=tourismService.getAllTourPackage();
		theModel.addAttribute("tourPackage", tourPackage);
		return "package-list";
		}
		else {
			return "redirect:/tourPackage/login";
		}
		
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel,HttpServletRequest request) {
		if(request.getSession().getAttribute("username")!=null) {
		TourPackage tourPackage=new TourPackage();
		theModel.addAttribute("tourPackage",tourPackage);
		return "package-form";
		}
		else {
			return "redirect:/tourPackage/login";
		}
	}
	
	@PostMapping("/savePackageDetails")
	public String saveTourPackage(@Valid @ModelAttribute("tourPackage") TourPackage tourPackage,BindingResult result) {
		if(result.hasErrors()) {
			return "package-form";
		}
		tourismService.savePackageDetails(tourPackage);
		return "redirect:/tourPackage/list";

	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("id") int id,Model theModel,HttpServletRequest request) {
		if(request.getSession().getAttribute("username")!=null) {
		TourPackage tourPackage=tourismService.getPackageDetail(id);
		theModel.addAttribute("tourPackage", tourPackage);
		return "package-form";
		}
		else {
			return "redirect:/tourPackage/login";
		}
	}
	
	@GetMapping("/showFormForDelete")
	public String showFormForDelete(@RequestParam("id") int id,HttpServletRequest request) {
		if(request.getSession().getAttribute("username")!=null) {
		tourismService.deletePackage(id);
		return "redirect:/tourPackage/list";
		}
		else {
			return "redirect:/tourPackage/login";
		}
	}

	@GetMapping("/showFormForSearch")
	public String showSearch(Model themodel,HttpServletRequest request) {
		if(request.getSession().getAttribute("username") != null){
		Search search = new Search();
		themodel.addAttribute("formData", search);
		return "search";
		}
		else
			return "redirect:/tourism/login";
	}
	
	@PostMapping("/processSearch")
	public String processSearch(@ModelAttribute("formData") Search data,Model themodel) {
		List<TourPackage> result = tourismService.getResultList(data.getLocationA(), data.getLocationB());
		themodel.addAttribute("resultList",result);
		return "display-search";
	}
}
