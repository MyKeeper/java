package src.org.ccunix.record_manager.po;

public class RecordPO {
	private String rno;
	private String recordName;
	private String endTime;
	private String dno;
	private int isDelete;
	public RecordPO(){}
	public RecordPO(String rno, String recordName, String endTime, String dno,int isDelete) {
		this.rno = rno;
		this.recordName = recordName;
		this.endTime = endTime;
		this.dno = dno;
		this.isDelete=isDelete;
	}
	public String getRno() {
		return rno;
	}
	public void setRno(String rno) {
		this.rno = rno;
	}
	public String getRecordName() {
		return recordName;
	}
	public void setRecordName(String recordName) {
		this.recordName = recordName;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getDno() {
		return dno;
	}
	public void setDno(String dno) {
		this.dno = dno;
	}
	public int getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	
	
}
