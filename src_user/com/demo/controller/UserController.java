package com.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.mybatis.inter.IUserOperation;
import com.demo.mybatis.model.Article;
import com.demo.mybatis.model.Attribute;
import com.demo.mybatis.model.Item;
import com.demo.mybatis.model.Product;
import com.demo.mybatis.model.TreeNode;
import com.demo.mybatis.model.User;

@Controller
@RequestMapping("/article")
public class UserController {
	@Autowired
	IUserOperation userMapper;

	// @Autowired
	// UserDAO userDAO;

	@RequestMapping("/list")
	public ModelAndView listall(HttpServletRequest request,
			HttpServletResponse response) {
		List<Article> articles = userMapper.getUserArticles(1);

		List<User> users = userMapper.getUserArticlesTest();
		//List<Article> articles = userDAO.getUserArticles(1);
		ModelAndView mav = new ModelAndView("list");
		mav.addObject("articles", articles);
		mav.addObject("users", users);
		return mav;
	}

	@RequestMapping("/hello")
	public ModelAndView helloWorld(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("hello");
		mav.addObject("hello", "Hello World!");
		return mav;
	}
	
	@RequestMapping(value="/info/{proId}",method=RequestMethod.GET)
    public String getProductInfo(@PathVariable String proId, HttpServletRequest request,HttpServletResponse response) throws Exception {
          request.setAttribute("name", proId);           
          return "/test/info";         
    }
	
	@RequestMapping(value="/info/{itemCode}/{itemName}",method=RequestMethod.GET)
    public String getProductInfo(Item item, HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setAttribute("product", item.getItemCode()+"___"+item.getItemName());
		   
		return "test/list";         
    }
	
	@RequestMapping("/index")
	public ModelAndView GotoIndex(HttpServletRequest request,
			HttpServletResponse response) {
		List<Article> articles = userMapper.getUserArticles(1);
		// List<Article> articles = userDAO.getUserArticles(1);
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("articles", articles);
		return mav;
	}

	@RequestMapping(value = "/register")
	public ModelAndView register(@RequestParam("username") String username,
			@RequestParam("password") String password) {
		ModelAndView modelView = new ModelAndView();
		Map<String, Object> modelMap = new HashMap<String, Object>();
		
		modelMap.put("username", username);
		modelMap.put("password", password);
		modelView.addAllObjects(modelMap);
		return modelView;
	}
	
	@RequestMapping(value = "/loadTable")
	public ModelAndView loadTable() {
		ModelAndView modelView = new ModelAndView();
		Map<String, Object> modelMap = new HashMap<String, Object>();
		
		Product p1 = new Product("FI-SW-01", "Koi", 10.00f, "P", 36.50f, "Large", "EST-1");
		Product p2 = new Product("K9-DL-01", "Dalmation", 12.00f, "P", 18.50f, "Spotted Adult Female", "EST-10");
		Product p3 = new Product("RP-SN-01", "Rattlesnake", 11.00f, "P", 38.50f, "Venomless", "EST-11");
		List<Product> products = new ArrayList<Product>();
		products.add(p1);
		products.add(p2);
		products.add(p3);
		modelMap.put("total", 28);
		modelMap.put("rows", products);
		modelView.addAllObjects(modelMap);
		return modelView;
	}
	
	@RequestMapping(value = "/loadTree")
	public ModelAndView loadTree(){
		ModelAndView mv = new ModelAndView();
//		Map<String, Object> map = new HashMap<String, Object>();
		TreeNode tn = buildTreeData();
		List<TreeNode> tnlist = new ArrayList<TreeNode>();
		tnlist.add(tn);
		mv.addObject(tnlist);
		
		return mv;
	}
	
	public static TreeNode buildTreeData(){
		List<TreeNode> secondLevel = new ArrayList<TreeNode>();
		TreeNode t11 = new TreeNode(11, "Photos");
		t11.setState("closed");
		TreeNode t111 = new TreeNode(111, "Wife");
		TreeNode t112 = new TreeNode(112, "Parents");
		TreeNode t113 = new TreeNode(113, "Daughter");
		List<TreeNode> thirdLevel1 = new ArrayList<TreeNode>();
		thirdLevel1.add(t111);
		thirdLevel1.add(t112);
		thirdLevel1.add(t113);
		t11.setChildren(thirdLevel1);
		
		TreeNode t12 = new TreeNode(12, "Program Files");
		List<TreeNode> thirdLevel2 = new ArrayList<TreeNode>();
		TreeNode t121 = new TreeNode(121, "Intel");
		TreeNode t122 = new TreeNode(122, "Java");
		Attribute a1 = new Attribute("p1", "Custom Attribute1");
		Attribute a2 = new Attribute("p2", "Custom Attribute2");
		List<Attribute> attributes = new ArrayList<Attribute>();
		attributes.add(a1);
		attributes.add(a2);
		t122.setAttributes(attributes);
		TreeNode t123 = new TreeNode(123, "Microsoft Office");
		TreeNode t124 = new TreeNode(124, "Games");
		t124.setChecked(true);
		thirdLevel2.add(t121);
		thirdLevel2.add(t122);
		thirdLevel2.add(t123);
		thirdLevel2.add(t124);
		t12.setChildren(thirdLevel2);
		
		TreeNode t13 = new TreeNode(13, "index.html");
		TreeNode t14 = new TreeNode(14, "about.html");
		TreeNode t15 = new TreeNode(15, "welcome.html");
		
		secondLevel.add(t11);
		secondLevel.add(t12);
		secondLevel.add(t13);
		secondLevel.add(t14);
		secondLevel.add(t15);
		
		TreeNode root = new TreeNode(1, "My Documents");
		root.setChildren(secondLevel);
		
		return root;
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
    public String login(Item item, HttpServletRequest request,HttpServletResponse response) throws Exception {
        request.setAttribute("name",item.getItemCode()+"___"+item.getItemName());
        return "test/main2";
    }

}