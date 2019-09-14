package src.org.ccunix.record_manager.service;

import java.util.List;

import src.org.ccunix.record_manager.dao.RecordDAO;
import src.org.ccunix.record_manager.vo.RecordVO;

public class RecordService {
	RecordDAO dao= new RecordDAO();
	public List<RecordVO> getTableInfoList() {
		return dao.getAllInfo();
	}
	public int addRecordInfo(String rno, String recordName, String endTime, String dno) {
		return dao.insertRecordInfo(rno,recordName,endTime,dno);
	}
	public int deleteRecordInfo(String rno) {
		return dao.deleteRecordByRno(rno);
	}
	public List<RecordVO> getRecordTableInfoListBy(String dno, String endTime) {
		return dao.getRecordTableInfoBy(dno,endTime);
	}
	public int updateRecordInfo(String rno, String recordName, String endTime, String dno) {
		return dao.updateRecordByRno(rno,recordName,endTime,dno);
	}

}
