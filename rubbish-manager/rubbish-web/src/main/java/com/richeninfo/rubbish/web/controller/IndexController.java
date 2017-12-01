package com.richeninfo.rubbish.web.controller;

//import cn.hylexus.jt808.server.TCPServer;
import com.itcloudinfo.commons.json.bean.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

	@RequestMapping(value="/index",method = RequestMethod.GET)
	public String index(HttpServletRequest request) {
		return "/index";
	}

	@RequestMapping(value="/outdex")
	public String outdex(HttpServletRequest request) {
		return "/outdex";
	}

	@RequestMapping(value="/indexTest")
	@ResponseBody
	public JsonResult indexTest(HttpServletRequest request, String comm) {
		if(comm!=null){
			System.out.println(comm);
		}
		return JsonResult.newSuccess("22");
	}


}

