package src.org.ccunix.record_manager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import src.org.ccunix.record_manager.util.DataBaseConnectionManager;
import src.org.ccunix.record_manager.vo.DeptVO;

public class RecordDAO {

	public List<DeptVO> getAllDeptList() {
		List<DeptVO> tableInfo =new ArrayList<DeptVO>();
		Connection connection= null;
		PreparedStatement statement = null;
		try {
			connection =DataBaseConnectionManager.getConnection();
			String sql="select dno,deptName from dept";
			statement= connection.prepareStatement(sql);
			ResultSet set = statement.executeQuery();
			while(set.next()){
				DeptVO deptVO = new DeptVO(set.getString("dno"), set.getString("deptName"),0);
				tableInfo.add(deptVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tableInfo;
	}

	public int insertNewDept(String dno, String deptName) {
		Connection connection= null;
		PreparedStatement statement = null;
		try {
			connection =DataBaseConnectionManager.getConnection();
			String sql="insert into dept (dno,deptName,isDelete) values (?,?,?)";
			statement= connection.prepareStatement(sql);
			statement.setString(1, dno);
			statement.setString(2, deptName);
			statement.setInt(3, 0);
			int row = statement.executeUpdate();
			if(row>0){
				return 1;
			}else{
				return 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int deleteDept(String dno) {
		Connection connection= null;
		PreparedStatement statement = null;
		try {
			connection =DataBaseConnectionManager.getConnection();
			String sql="update dept set isDelete='1' where dno=?";
			statement= connection.prepareStatement(sql);
			statement.setString(1, dno);
			int row = statement.executeUpdate();
			if(row>0){
				return 1;
			}else{
				return 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int updateNewDept(String dno, String deptName) {
		Connection connection= null;
		PreparedStatement statement = null;
		try {
			connection =DataBaseConnectionManager.getConnection();
			String sql="update dept set deptName=? where dno=? and isDelete='0'";
			statement= connection.prepareStatement(sql);
			statement.setString(1, deptName);
			statement.setString(2, dno);
			int row = statement.executeUpdate();
			if(row>0){
				return 1;
			}else{
				return 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<DeptVO> getAllDeptListBy(String dno, String deptName) {
		List<DeptVO> tableInfo =new ArrayList<DeptVO>();
		Connection connection= null;
		PreparedStatement statement = null;
		try {
			connection =DataBaseConnectionManager.getConnection();
			String sql="select dno,deptName from dept where isDelete='0' ";
			if(!"".equals(dno)){
				sql=sql+"and dno='"+dno+"' ";
			}
			if(!"".equals(deptName)){
				sql=sql+"and deptName like '%"+deptName+"%' ";
			}
			statement= connection.prepareStatement(sql);
			ResultSet set = statement.executeQuery();
			while(set.next()){
				DeptVO deptVO = new DeptVO(set.getString("dno"), set.getString("deptName"),0);
				tableInfo.add(deptVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tableInfo;
	}

}
