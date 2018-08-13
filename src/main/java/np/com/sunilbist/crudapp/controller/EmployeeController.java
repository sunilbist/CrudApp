package np.com.sunilbist.crudapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import np.com.sunilbist.crudapp.entity.Employee;

import np.com.sunilbist.crudapp.repositary.EmployeeRepository;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;
	@GetMapping("/list")
	public String liSt(Model model){
		model.addAttribute("employeelist", employeeRepository.findAll());
		return "employeelist";

	}
	@GetMapping("/add")
	public String add(Model model){
		model.addAttribute("title", "New Employee");
		model.addAttribute("employee", new Employee());
		return "employee";
	}

	@PostMapping("/add")
	public String add(@ModelAttribute("employee") Employee employee){
		employeeRepository.save(employee);
		return "redirect:/employee/list";
	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, Model model){
		model.addAttribute("employee", employeeRepository.findById(id));
		return "editemployee";
	}

	@PostMapping("/edit")
	public String edit(@ModelAttribute("employee") Employee employee){
		employeeRepository.save(employee);
		return "redirect:/employee/list";
	}

	@GetMapping("/delete/{id}")
	public String delete(Model model, @PathVariable("id") Integer id){
		model.addAttribute("employee", employeeRepository.findById(id));
		return "deleteemployee";
	}

	@PostMapping("/delete")
	public String delete(@ModelAttribute("employee") Employee employee){
		employeeRepository.delete(employee);
		return "redirect:/employee/list";
	}
}
