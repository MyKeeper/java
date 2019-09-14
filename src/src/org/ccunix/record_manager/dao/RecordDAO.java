package src.org.ccunix.record_manager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import src.org.ccunix.record_manager.util.DataBaseConnectionManager;
import src.org.ccunix.record_manager.vo.DeptVO;
import src.org.ccunix.record_manager.vo.RecordVO;

public class RecordDAO {
	public static List<RecordVO> recordSelectedList=new ArrayList<RecordVO>();
	public List<RecordVO> getAllInfo() {
		List<RecordVO> tableInfo =new ArrayList<RecordVO>();
		Connection connection= null;
		PreparedStatement statement = null;
		try {
			connection =DataBaseConnectionManager.getConnection();
			String sql="select rno,recordName,endTime,dept.dno,deptName from dept,record where dept.dno=record.dno and record.isDelete='0'";
			statement= connection.prepareStatement(sql);
			ResultSet set = statement.executeQuery();
			while(set.next()){
				DeptVO deptVO = new DeptVO(set.getString("dno"), set.getString("deptName"),0);
				RecordVO recordVO = new RecordVO(set.getString("rno"), set.getString("recordName"), set.getString("endTime"), set.getString("dno"), 0, deptVO);
				tableInfo.add(recordVO);
				recordSelectedList.add(recordVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tableInfo;
	}

	public int insertRecordInfo(String rno, String recordName, String endTime, String dno) {
		Connection connection= null;
		PreparedStatement statement = null;
		try {
			connection =DataBaseConnectionManager.getConnection();
			String sql="insert into record (rno,recordName,endTime,isDelete,dno) values (?,?,?,?,?)";
			statement= connection.prepareStatement(sql);
			statement.setString(1, dno);
			statement.setString(2, recordName);
			statement.setString(3, endTime);
			statement.setInt(4, 0);
			statement.setString(5, dno);
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

	public int deleteRecordByRno(String rno) {
		Connection connection= null;
		PreparedStatement statement = null;
		try {
			connection =DataBaseConnectionManager.getConnection();
			String sql="update record set isDelete='1' where rno=?";
			statement= connection.prepareStatement(sql);
			statement.setString(1, rno);
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

	public List<RecordVO> getRecordTableInfoBy(String dno, String endTime) {
		List<RecordVO> tableInfo =new ArrayList<RecordVO>();
		Connection connection= null;
		PreparedStatement statement = null;
		try {
			connection =DataBaseConnectionManager.getConnection();
			String sql="select rno,recordName,endTime,dept.dno,deptName from dept,record where dept.dno=record.dno and record.isDelete='0' ";
			if(!"".equals(dno)){
				sql=sql+"and Record.dno='"+dno+"' ";
			}
			if(!"".equals(endTime)){
				sql=sql+"and endTime like '%"+endTime+"%' ";
			}
			statement= connection.prepareStatement(sql);
			ResultSet set = statement.executeQuery();
			while(set.next()){
				DeptVO deptVO = new DeptVO(null, set.getString("deptName"),0);
				RecordVO recordVO = new RecordVO(set.getString("rno"), set.getString("recordName"), set.getString("endTime"),set.getString("dno"), 0, deptVO);
				tableInfo.add(recordVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tableInfo;
	}


	public int updateRecordByRno(String rno, String recordName, String endTime, String dno) {
		Connection connection= null;
		PreparedStatement statement = null;
		try {
			connection =DataBaseConnectionManager.getConnection();
			String sql="update record set recordName=? , endTime=? , dno=?  where rno=?";
			statement= connection.prepareStatement(sql);
			statement.setString(1, recordName);
			statement.setString(2, endTime);
			statement.setString(3, dno);
			statement.setString(4, rno);
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


}
