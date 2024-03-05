

@RequestMapping("/home/")
public class HomeController {
	@RequestMapping("/index/")
	public String index() {
		return "home/index";
		
	}
	@RequestMapping("/about/")
	public String about() {
		return "home/about";
		
	}
	@RequestMapping("/contact/")
	public String contact() {
		return "home/contact";
		
	}
	@RequestMapping("/feedback/")
	public String feedback() {
		return "home/feedback";
		
	}
	@RequestMapping("/fag/")
	public String fag() {
		return "home/fag";
		
	}
	

}
@RequestMapping(value = "login", method = RequestMethod.GET)
public String login() {
	return "user/login";
}@RequestMapping(value = "login", method = RequestMethod.POST)

public String login(ModelMap model, HttpServetRequest request) {
	String id = request.getParameter("id");
	String pw = request.getParameter("password");
	if (id.equals("fpt")&&pw.equals("Polytechnic")) {model.addAttribute("message","sai thong tin dang nhap");}
	
	else {
		model.addAttribute("message","sai thong tin dang nhap");
	}
	}
return "user/login";
}



