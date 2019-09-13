package src.org.ccunix.record_manager.po;

public class DeptPO {
	private String dno;
	private String deptName;
	private int isDelete;
	public DeptPO(){}
	
	public DeptPO(String dno, String deptName, int isDelete) {
		this.dno = dno;
		this.deptName = deptName;
		this.isDelete = isDelete;
	}
	public String getDno() {
		return dno;
	}
	public void setDno(String dno) {
		this.dno = dno;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	
}
