package com.basic.bustation.util;

import com.basic.bustation.model.Roadsection;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Component("jsonUtil")
public class JsonUtil {
	
	public List<Map<String,Object>> roadsectionList(List<Roadsection> roadsectionList){
		List<Map<String,Object>> mapList=new ArrayList<>();
		for(Roadsection roadsection:roadsectionList){
			Map<String,Object> map=new HashMap<>();
			map.put("id",roadsection.getId());
			map.put("name", roadsection.getName());
			map.put("statrtstation", roadsection.getRoadstationByStartid().getName());
			map.put("endstation", roadsection.getRoadstationByEndid().getName());
			map.put("elapsedtime", roadsection.getElapsedtime()+"分钟");
			mapList.add(map);
		}
		return mapList;
	}
	
}
