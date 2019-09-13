package src.org.ccunix.record_manager.util;

import java.lang.reflect.Method;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("all")
public class DataParseUtil {

	//columnNames ["Cno-课程号","CourseVO.Name-课程名", "CourseVO.Tearm-学期", "CourseVO.Tearm-学时", 
	//"CourseVO.Credit-学分", "CourseVO.Type-类型","TeacherVO.Name-教师姓名","TeacherVO.DeptName-系别"]
	public static void makeDataFromList(JTable table,List list,String[] columnNames){
		Object[][] objs = new Object[list.size()][columnNames.length];
		//组装数据
		try{
			for(int i=0;i<list.size();i++){
				Object obj = list.get(i);//集合中存的对象
				Class c = obj.getClass();
				for(int j=0;j<columnNames.length;j++){
					String methodNames = columnNames[j].split("-")[0];//Cno或者CourseVO.Name
					if(methodNames.contains(".")){
						//获得.前的名称
						String className = methodNames.split("\\.")[0];
						String className_methodName = methodNames.split("\\.")[1];
						className = "get"+className;//getCourseVO
						Method classNameMethod = c.getMethod(className, null);
						//获得返回的getCourseVO对象
						Object obj2 = classNameMethod.invoke(obj, null);//取对象信息
						//获得返回值类型  也是Class对象  CourseVO
						Class  c2 = classNameMethod.getReturnType();
						//获得c2反射对象中的方法名称
						className_methodName = "get"+className_methodName;//getName
						Method className_methodName_Method = c2.getMethod(className_methodName, null);
						Object className_methodName_value = className_methodName_Method.invoke(obj2, null);
						objs[i][j] = className_methodName_value.toString();
					}else{
						//直接获得方法名称即可
						methodNames = "get"+ methodNames;//getCno
						Method getNameMethod = c.getMethod(methodNames, null);//getCno()
						objs[i][j] = getNameMethod.invoke(obj, null).toString();//obj.getCno()
					}
					
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		//拆分列名
		String names[] = new String[columnNames.length];
		for(int i=0;i<columnNames.length;i++){
			names[i] = columnNames[i].split("-")[1];
		}
		table.setModel(new DefaultTableModel(objs, names));
	} 
	
	public static void main(String[] args) {
		
	}
}
