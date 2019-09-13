package src.org.ccunix.record_manager.util;

import java.lang.reflect.Method;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("all")
public class DataParseUtil {

	//columnNames ["Cno-�γ̺�","CourseVO.Name-�γ���", "CourseVO.Tearm-ѧ��", "CourseVO.Tearm-ѧʱ", 
	//"CourseVO.Credit-ѧ��", "CourseVO.Type-����","TeacherVO.Name-��ʦ����","TeacherVO.DeptName-ϵ��"]
	public static void makeDataFromList(JTable table,List list,String[] columnNames){
		Object[][] objs = new Object[list.size()][columnNames.length];
		//��װ����
		try{
			for(int i=0;i<list.size();i++){
				Object obj = list.get(i);//�����д�Ķ���
				Class c = obj.getClass();
				for(int j=0;j<columnNames.length;j++){
					String methodNames = columnNames[j].split("-")[0];//Cno����CourseVO.Name
					if(methodNames.contains(".")){
						//���.ǰ������
						String className = methodNames.split("\\.")[0];
						String className_methodName = methodNames.split("\\.")[1];
						className = "get"+className;//getCourseVO
						Method classNameMethod = c.getMethod(className, null);
						//��÷��ص�getCourseVO����
						Object obj2 = classNameMethod.invoke(obj, null);//ȡ������Ϣ
						//��÷���ֵ����  Ҳ��Class����  CourseVO
						Class  c2 = classNameMethod.getReturnType();
						//���c2��������еķ�������
						className_methodName = "get"+className_methodName;//getName
						Method className_methodName_Method = c2.getMethod(className_methodName, null);
						Object className_methodName_value = className_methodName_Method.invoke(obj2, null);
						objs[i][j] = className_methodName_value.toString();
					}else{
						//ֱ�ӻ�÷������Ƽ���
						methodNames = "get"+ methodNames;//getCno
						Method getNameMethod = c.getMethod(methodNames, null);//getCno()
						objs[i][j] = getNameMethod.invoke(obj, null).toString();//obj.getCno()
					}
					
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		//�������
		String names[] = new String[columnNames.length];
		for(int i=0;i<columnNames.length;i++){
			names[i] = columnNames[i].split("-")[1];
		}
		table.setModel(new DefaultTableModel(objs, names));
	} 
	
	public static void main(String[] args) {
		
	}
}
