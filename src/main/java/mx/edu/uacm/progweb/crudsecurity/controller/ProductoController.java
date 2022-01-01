package mx.edu.uacm.progweb.crudsecurity.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import mx.edu.uacm.progweb.crudsecurity.dominio.Producto;
import mx.edu.uacm.progweb.crudsecurity.service.ProductoService;


@Controller
public class ProductoController {

	@Autowired
	private ProductoService productoService;
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
	    List<Producto> listaProductos = productoService.listAll();
	    model.addAttribute("listaProductos", listaProductos);
	     
	    return "index";
	}
	
	@RequestMapping("/new")
	public String showNewProductPage(Model model) {
		Producto producto = new Producto();
		model.addAttribute("producto", producto);
		
		return "new_product";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product") Producto producto) {
		productoService.save(producto);
		
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_product");
		Producto producto = productoService.get(id);
		mav.addObject("producto", producto);
		
		return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") int id) {
		productoService.delete(id);
		return "redirect:/";		
	}
}
