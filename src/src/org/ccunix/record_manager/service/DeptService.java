package src.org.ccunix.record_manager.service;

import java.util.List;

import src.org.ccunix.record_manager.dao.DeptDAO;
import src.org.ccunix.record_manager.vo.DeptVO;

public class DeptService {
	DeptDAO deptdao = new DeptDAO();
	public List<DeptVO> getTableInfoList() {
		return deptdao.getAllDeptList();
	}
	public int insertDept(String dno, String deptName) {
		return deptdao.insertNewDept(dno,deptName);
	}
	public int deleteDept(String dno) {
		return deptdao.deleteDept(dno);
	}
	public int updateDept(String dno, String deptName) {
		return deptdao.updateNewDept(dno,deptName);
	}
	public List<DeptVO> getTableInfoListBy(String dno, String deptName) {
		return deptdao.getAllDeptListBy(dno,deptName);
	}

}
