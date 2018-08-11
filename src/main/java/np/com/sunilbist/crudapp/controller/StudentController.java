package np.com.sunilbist.crudapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import np.com.sunilbist.crudapp.entity.Student;
import np.com.sunilbist.crudapp.repositary.StudentRepositary;


@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentRepositary studentRepo;

	@GetMapping("/list")
	public String list(Model model){
		model.addAttribute("studentList",studentRepo.findAll());
		return "index";
	}

	@GetMapping("/add")
	public String add(Model model){
		model.addAttribute("title", "New Student");
		model.addAttribute("student", new Student());
		return "student";
	}

	@PostMapping("/add")
	public String add(@ModelAttribute("student") Student student){
		studentRepo.save(student);
		return "redirect:/student/list";
	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, Model model){
		model.addAttribute("student", studentRepo.findById(id));
		return "edit";
	}

	@PostMapping("/edit")
	public String edit(@ModelAttribute("student") Student student){
		studentRepo.save(student);
		return "redirect:/student/list";
	}

	@GetMapping("/delete/{id}")
	public String delete(Model model, @PathVariable("id") Integer id){
		model.addAttribute("student", studentRepo.findById(id));
		return "delete";
	}

	@PostMapping("/delete")
	public String delete(@ModelAttribute("student") Student student){
		studentRepo.delete(student);
		return "redirect:/student/list";
	}	
}
