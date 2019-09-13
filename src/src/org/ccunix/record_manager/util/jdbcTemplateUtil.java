package src.org.ccunix.record_manager.util;
/*
 * ���ݿ� ��ɾ�Ĳ�  
 * ͨ�÷���--����
 * 
 * */

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class jdbcTemplateUtil {
	/*
	 * ���� 
	 * ��Ҫ����MySQl���еı�ͷ���δ��ݲ���
	 * 
	 * */
	Connection conn=null;
	PreparedStatement sql=null;
	
	public void getsql(String s,Object ... objects) {//Object ... objects���벻ͬ�����ı���
		try {
			//DAO�����Ѿ������ݿ��������
			conn = DataBaseConnectionManager.getConnection();
			sql=conn.prepareStatement(s);
			
			//�ж��Ƿ���ڣ�
			if(objects!=null&&objects.length>0){
				//���ڣ� 
				//����objects
				for(int i=0;i<objects.length;i++){
					//���λ�ȡ���������ֵ
					Object obj=objects[i];
					//���÷����ȡ������Ϣ����������
					Class c=obj.getClass();
					if("String".equals(c.getSimpleName())){
						sql.setString(i+1, obj.toString());
					}else if("int".equals(c.getSimpleName())||"Integer".equals(c.getSimpleName())){
						sql.setInt(i+1, Integer.parseInt(obj.toString()));
					}else if("double".equals(c.getSimpleName())||"Double".equals(c.getSimpleName())){
						sql.setDouble(i+1, Double.parseDouble(obj.toString()));
					}
				}
			}
			
			//System.out.println("sql ���:"+s);
			int x=sql.executeUpdate();
			
			//System.out.println("Ӱ����"+x);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DataBaseConnectionManager.close(sql, conn);
		}
		
	}
	
	
	/*
	 * ��ѯ
	 * 
	 * 1-���������ֶα��붼Ҫ����
	 * 2-��ѯ������б��� ������Class�е��ֶ�һ��һ����
	 *
	 * */
	//����list
	public List getquery(String s,Class className,Object ...objects){//��ΪҪ��ȡ��Ա���� ������Ҫ����className
		//����list�洢��ѯ����������Ϣ
		List  list=new ArrayList();
		try {
			//DAO�����Ѿ������ݿ��������
			conn = DataBaseConnectionManager.getConnection();
			System.out.println("sql ���:"+s);
			sql=conn.prepareStatement(s);
			//�ж��Ƿ���ڣ�
			if(objects!=null&&objects.length>0){
				//���ڣ� 
				//����objects
				for(int i=0;i<objects.length;i++){
					//���λ�ȡ���������ֵ
					Object obj=objects[i];
					//���÷����ȡ������Ϣ����������
					Class c=obj.getClass();
					if("String".equals(c.getSimpleName())){
						sql.setString(i+1, obj.toString());
					}else if("int".equals(c.getSimpleName())||"Integer".equals(c.getSimpleName())){
						sql.setInt(i+1, Integer.parseInt(obj.toString()));
					}else if("double".equals(c.getSimpleName())||"Double".equals(c.getSimpleName())){
						sql.setDouble(i+1, Double.parseDouble(obj.toString()));
					}
				}
			}
			
			//����
			ResultSet set=sql.executeQuery();//ִ�в�ѯ��� �����ѯ���
			
			//��ȡ��Ա��������
			Field [] fc=className.getDeclaredFields();
			//Method��ȡ���󷽷� 
			Method [] me=className.getMethods();
			
			while(set.next()){
				//��ȡ����
				Object obj = className.newInstance();
				
				//����me
				for(Method m:me){
					String getMethodName=m.getName();
					//��ȡ����get�ķ�����
					if(getMethodName.startsWith("get")){
						//��ȡ������ ���������
						String setName=getMethodName.substring(3);
						//����setMethod����
						String setMethod="set"+setName;
						
						//��ȡ�����ݿ��в�ѯ����ֵ
						if(m.getReturnType()==String.class){//�ַ���
							//��ȡ���ݿ��е�����
							String str = set.getString(setName);
							//ͨ��set������ֵ����������
							Method setMotheds=className.getMethod(setMethod,String.class);
							//ִ��set����
							setMotheds.invoke(obj, str);
							
						}else if(m.getReturnType()==int.class){
							//��ȡ���ݿ��е�����
							int str = set.getInt(setName);
							//ͨ��set������ֵ����������
							Method setMotheds=className.getMethod(setMethod,int.class);
							//ִ��set����
							setMotheds.invoke(obj, str);
							
						}else if(m.getReturnType()==double.class){
							//��ȡ��Ϣ����
							double str=set.getDouble(setName);
							//ͨ��set������ֵ����������
							Method setMotheds=className.getMethod(setMethod,double.class);
							//ִ��set����
							setMotheds.invoke(obj, str);
							
						}
					}
				}
				list.add(obj);
			}
		
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DataBaseConnectionManager.close(sql, conn);
		}
		return list;
		
	}
	
}
