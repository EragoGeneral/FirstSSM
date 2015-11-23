package com.demo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.mybatis.inter.IMenuOperation;
import com.demo.mybatis.model.Attribute;
import com.demo.mybatis.model.SystemMenus;
import com.demo.mybatis.model.TreeNode;

@Controller
@RequestMapping("/system")
public class SystemController {
	
	@Autowired
	IMenuOperation menuMapper;
			
	@RequestMapping(value = "/menus")
	public ModelAndView menus(){		
//		List<SystemMenus> menus = new ArrayList<SystemMenus>();
//		mv.addObject(menus);
				
		ModelAndView mv = new ModelAndView();
//		Map<String, Object> map = new HashMap<String, Object>();
		List<SystemMenus> menus = menuMapper.querySystemMenus();
		
		SystemMenus tn = buildMenuTree(menus);
		List<SystemMenus> tnlist = new ArrayList<SystemMenus>();
		tnlist.add(tn);
		mv.addObject(tnlist);
		
		return mv;
	}
	
	public static SystemMenus buildMenuTree(List<SystemMenus> menus){
		SystemMenus root = new SystemMenus(-1, "系统菜单", "/", 0, -99, 0, "0", "0", 1, new Date(), 1, new Date());
		
		List<SystemMenus> firstLevel = new ArrayList<SystemMenus>();
		Map<Integer, SystemMenus> levelMap = new HashMap<Integer, SystemMenus>();
		for(SystemMenus menu : menus){
			if(menu.getLevel() == 1){
				firstLevel.add(menu);
				levelMap.put(menu.getID(), menu);
			}else{
				SystemMenus firstLevelMenu = levelMap.get(menu.getParentID());
				if(firstLevelMenu !=null){
					List<SystemMenus> secondLevel = firstLevelMenu.getChildren();
					if(secondLevel == null) {
						secondLevel = new ArrayList<SystemMenus>();
					}
					secondLevel.add(menu);
					firstLevelMenu.setChildren(secondLevel);
				}
			}
		}
		root.setChildren(firstLevel);
		
		return root;
	}
	
	public static SystemMenus buildMenuTree(){
		SystemMenus root = new SystemMenus(-1, "系统菜单", "/", 0, -99, 0, "0", "0", 1, new Date(), 1, new Date());
		
		SystemMenus sms1 = new SystemMenus(1, "会员管理", "/member/main", 1, -1, 1, "1", "0", 1, new Date(), 1, new Date());
		SystemMenus sms2 = new SystemMenus(2, "客户管理", "/customer/main", 2, -1, 1, "2", "0", 1, new Date(), 1, new Date());
		SystemMenus sms3 = new SystemMenus(3, "租车管理", "/renting/main", 3, -1, 1, "3", "0", 1, new Date(), 1, new Date());
		SystemMenus sms4 = new SystemMenus(4, "系统管理", "/system/main", 4, -1, 1, "4", "0", 1, new Date(), 1, new Date());
		
		SystemMenus sms41 = new SystemMenus(5, "菜单管理", "/system/menu", 1, 4, 2, "4.5", "0", 1, new Date(), 1, new Date());
		SystemMenus sms42 = new SystemMenus(6, "用户管理", "/system/user", 2, 4, 2, "4.6", "0", 1, new Date(), 1, new Date());
		SystemMenus sms43 = new SystemMenus(7, "权限管理", "/system/rights", 3, 4, 2, "4.7", "0", 1, new Date(), 1, new Date());
		SystemMenus sms44 = new SystemMenus(8, "数据字典", "/system/dic", 4, 4, 2, "4.8", "0", 1, new Date(), 1, new Date());
		
		List<SystemMenus> sms4List = new ArrayList<SystemMenus>();
		sms4List.add(sms41);
		sms4List.add(sms42);
		sms4List.add(sms43);
		sms4List.add(sms44);
		sms4.setChildren(sms4List);
		
		List<SystemMenus> firstMenus = new ArrayList<SystemMenus>();
		firstMenus.add(sms1);
		firstMenus.add(sms2);
		firstMenus.add(sms3);
		firstMenus.add(sms4);
		root.setChildren(firstMenus);
		
		return root;
	}
	
	public static TreeNode buildTreeData(){
		List<TreeNode> secondLevel = new ArrayList<TreeNode>();
		TreeNode t11 = new TreeNode(11, "Photos11");
		t11.setState("closed");
		TreeNode t111 = new TreeNode(111, "Wife11");
		TreeNode t112 = new TreeNode(112, "Parents11");
		TreeNode t113 = new TreeNode(113, "Daughter11");
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
}
