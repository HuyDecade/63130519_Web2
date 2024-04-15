package hiepvd.QLBH_ABC.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import hiepvd.QLBH_ABC.services.CustomerService;
import hiepvd.QLBH_ABC.models.Customer;

@Controller
public class CustomerController {
	@Autowired CustomerService customerService;
	@GetMapping("/customer/all")
	public String getAll(Model model) {
		List<Customer> dsKH = customerService.findAllCustomer();
		model.addAttribute("dsKhachHang", dsKH);
		return "danhsachKH";
	}
}
