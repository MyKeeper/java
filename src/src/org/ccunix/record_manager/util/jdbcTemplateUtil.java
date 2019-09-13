package src.org.ccunix.record_manager.util;
/*
 * 数据库 增删改查  
 * 通用方法--反射
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
	 * 更新 
	 * 需要按照MySQl表中的表头依次传递参数
	 * 
	 * */
	Connection conn=null;
	PreparedStatement sql=null;
	
	public void getsql(String s,Object ... objects) {//Object ... objects传入不同数量的变量
		try {
			//DAO里面已经对数据库进行连接
			conn = DataBaseConnectionManager.getConnection();
			sql=conn.prepareStatement(s);
			
			//判断是否存在？
			if(objects!=null&&objects.length>0){
				//存在？ 
				//遍历objects
				for(int i=0;i<objects.length;i++){
					//依次获取传入的属性值
					Object obj=objects[i];
					//利用反射获取传入信息的数据类型
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
			
			//System.out.println("sql 语句:"+s);
			int x=sql.executeUpdate();
			
			//System.out.println("影响行"+x);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DataBaseConnectionManager.close(sql, conn);
		}
		
	}
	
	
	/*
	 * 查询
	 * 
	 * 1-表中所有字段必须都要存在
	 * 2-查询结果的列别名 必须与Class中的字段一样一样的
	 *
	 * */
	//返回list
	public List getquery(String s,Class className,Object ...objects){//因为要获取成员变量 所有需要传入className
		//建立list存储查询到的数据信息
		List  list=new ArrayList();
		try {
			//DAO里面已经对数据库进行连接
			conn = DataBaseConnectionManager.getConnection();
			System.out.println("sql 语句:"+s);
			sql=conn.prepareStatement(s);
			//判断是否存在？
			if(objects!=null&&objects.length>0){
				//存在？ 
				//遍历objects
				for(int i=0;i<objects.length;i++){
					//依次获取传入的属性值
					Object obj=objects[i];
					//利用反射获取传入信息的数据类型
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
			
			//运行
			ResultSet set=sql.executeQuery();//执行查询语句 输出查询结果
			
			//获取成员变量集合
			Field [] fc=className.getDeclaredFields();
			//Method获取对象方法 
			Method [] me=className.getMethods();
			
			while(set.next()){
				//获取对象
				Object obj = className.newInstance();
				
				//遍历me
				for(Method m:me){
					String getMethodName=m.getName();
					//获取带有get的方法名
					if(getMethodName.startsWith("get")){
						//截取方法名 获得属性名
						String setName=getMethodName.substring(3);
						//创建setMethod方法
						String setMethod="set"+setName;
						
						//获取从数据库中查询到的值
						if(m.getReturnType()==String.class){//字符串
							//获取数据库中的内容
							String str = set.getString(setName);
							//通过set方法将值传给属性名
							Method setMotheds=className.getMethod(setMethod,String.class);
							//执行set方法
							setMotheds.invoke(obj, str);
							
						}else if(m.getReturnType()==int.class){
							//获取数据库中的内容
							int str = set.getInt(setName);
							//通过set方法将值传给属性名
							Method setMotheds=className.getMethod(setMethod,int.class);
							//执行set方法
							setMotheds.invoke(obj, str);
							
						}else if(m.getReturnType()==double.class){
							//获取信息内容
							double str=set.getDouble(setName);
							//通过set方法将值传给属性名
							Method setMotheds=className.getMethod(setMethod,double.class);
							//执行set方法
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
