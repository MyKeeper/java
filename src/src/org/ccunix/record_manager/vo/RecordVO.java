package src.org.ccunix.record_manager.vo;

import src.org.ccunix.record_manager.po.RecordPO;

public class RecordVO extends RecordPO{
	DeptVO deptVO;

	public RecordVO(String rno, String recordName, String endTime, String dno, int isDelete, DeptVO deptVO) {
		super(rno, recordName, endTime, dno, isDelete);
		this.deptVO = deptVO;
	}

	public DeptVO getDeptVO() {
		return deptVO;
	}

	public void setDeptVO(DeptVO deptVO) {
		this.deptVO = deptVO;
	}
	
	
}
