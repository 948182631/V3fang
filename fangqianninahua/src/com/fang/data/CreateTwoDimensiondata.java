package com.fang.data;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fang.util.CreateOneDimension;
import com.fang.util.CreateTwoDimension;

@Controller
@RequestMapping("/create")
public class CreateTwoDimensiondata {

	@RequestMapping("/create.json")
	public @ResponseBody
	String login(HttpServletRequest request, HttpServletResponse reponse) {

		JSONArray jsonArray = new JSONArray();
		for (int i = 0; i < 8; i++) {
			String two = "";
			String one = "";
			Map<String, Object> map = new HashMap<String, Object>();
			String text ="1-1-1-11111" + i ;
			try {
				two = CreateTwoDimension.create(200, 200, text);
				one = CreateOneDimension.encode(200, 50, text);
				map.put("two", two);
				map.put("one", one);
				map.put("text", text);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JSONObject jsonObject = JSONObject.fromObject(map);
			jsonArray.put(jsonObject);

		}
		System.out.println(jsonArray.toString());
		return jsonArray.toString();
	}
}
