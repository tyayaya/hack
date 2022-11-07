package hack;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.nio.file.Paths;
import java.nio.file.Files;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
	public static void main(String[] args) {
		String filePath = "src/sample_students.json";
		//String filePath = "src/sample_teachers.json";
		try {
			String inJson = getJson(filePath);
			List<Object> List = jsonToMap(inJson);
			System.out.println(List);
			//List<String> subject = getTeacherSubject(List);
			//List<String> day = getTeacherDay(List);
			List<String> subject = getStudentSubject(List);
			List<String> day = getStudentDay(List);
			//System.out.println("教科:"+subject);
			//System.out.println("日:"+day);
			String outJson = mapToJson(List);
			outputJson(outJson, "src/output.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static String getJson(String filePath) throws IOException {
		ObjectMapper  objectMapper = new ObjectMapper();
        String json = Files.readString(Paths.get(filePath));	
		return json;
	}

	public static List<Object> jsonToMap(String json) {
		ObjectMapper mapper = new ObjectMapper();
		List<Object> list = new ArrayList<Object>();
		list = null;
		try {
			list = mapper.readValue(json, new TypeReference<List<Object>>(){});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static String mapToJson(Object ob) {
		ObjectMapper mapper = new ObjectMapper();
		String json = "";
		try {
            //JSON文字列に変換
            json = mapper.writeValueAsString(ob);
        } catch (Exception e) {
            e.printStackTrace();
        }
		return json;
	}
	
	public static void outputJson(String json, String filePath) {
		try{
				File file = new File(filePath);
				FileWriter filewriter = new FileWriter(file);
				filewriter.write(json);
				filewriter.close();
			}catch(IOException e){
				System.out.println(e);
			}
	}
	
	public static List<String> getTeacherSubject(List<Object> list) {
		List<String> can = new ArrayList<String>();
		List<Map<String, Object>> nlist = (List<Map<String, Object>>)(List<?>)list;
		for(Map<String, Object> map : nlist) {
			String name = (String)map.get("name");
			List<String> subjects = (List<String>)map.get("subject");
			for(String subject : subjects) {
				can.add(name + " can " + subject);
			}
		}
		return can;
	}
	
	public static List<String> getTeacherDay(List<Object> list) {
		List<String> vacant = new ArrayList<String>();
		List<Map<String, Object>> nlist = (List<Map<String, Object>>)(List<?>)list;
		for(Map<String, Object> map : nlist) {
			String name = (String)map.get("name");
			Map<String, Object> timetable = (Map<String, Object>)map.get("timetable");
			for(String day : timetable.keySet()) {
				List<String> timeset = (List<String>)timetable.get(day);
				for(String time : timeset) {
					vacant.add(name + " vacant " + day + "|" + time);
				}
			}
		}
		return vacant;
	}
	
	public static List<String> getStudentSubject(List<Object> list) {
		List<String> can = new ArrayList<String>();
		List<Map<String, Object>> nlist = (List<Map<String, Object>>)(List<?>)list;
		for(Map<String, Object> map : nlist) {
			String name = (String)map.get("name");
			List<String> subjects = (List<String>)map.get("subject");
			for(String subject : subjects) {
				can.add(name + " take " + subject);
			}
		}
		return can;
	}
	
	public static List<String> getStudentDay(List<Object> list) {
		List<String> vacant = new ArrayList<String>();
		List<Map<String, Object>> nlist = (List<Map<String, Object>>)(List<?>)list;
		for(Map<String, Object> map : nlist) {
			String name = (String)map.get("name");
			Map<String, Object> timetable = (Map<String, Object>)map.get("timetable");
			for(String day : timetable.keySet()) {
				List<String> timeset = (List<String>)timetable.get(day);
				for(String time : timeset) {
					vacant.add(name + " convenient " + day + "|" + time);
				}
			}
		}
		return vacant;
	}
}
