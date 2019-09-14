package src.org.ccunix.record_manager.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import src.org.ccunix.record_manager.dao.RecordDAO;
import src.org.ccunix.record_manager.service.RecordService;
import src.org.ccunix.record_manager.view.record.RecordAddJpanel;
import src.org.ccunix.record_manager.view.record.RecordDeleteJpanel;
import src.org.ccunix.record_manager.view.record.RecordUpdateJpanel;
import src.org.ccunix.record_manager.vo.RecordVO;

public class RecordJpanelListenerController implements ActionListener{
	RecordService recordService = new RecordService();
	RecordAddJpanel recordAddJpanel;
	RecordDeleteJpanel recordDeleteJpanel;
	RecordUpdateJpanel recordUpdateJpanel;
	String method;
	public RecordJpanelListenerController(RecordAddJpanel recordAddJpanel, String method) {
		this.recordAddJpanel=recordAddJpanel;
		this.method=method;
	}

	public RecordJpanelListenerController(RecordDeleteJpanel recordDeleteJpanel, String method) {
		this.recordDeleteJpanel=recordDeleteJpanel;
		this.method=method;
	}

	public RecordJpanelListenerController(RecordUpdateJpanel recordUpdateJpanel, String method) {
		this.recordUpdateJpanel=recordUpdateJpanel;
		this.method=method;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String key =method;
		switch (key) {
		case "add":
			add();
			break;
		case "recordDelete":
			recordDelete();
			break;
		case "recordQueryByrno":
			recordQueryByrno();
			break;
		case "recordUpdate":
			recordUpdate();
			break;

		default:
			break;
		}
	}

	private void recordUpdate() {
		String rno = recordUpdateJpanel.rnoTextField.getText();
		String endTime= recordUpdateJpanel.endTimeTextField.getText();
		String recordName = recordUpdateJpanel.recordNameTextField.getText();
		String dno =recordUpdateJpanel.dnoTextField.getText();
		int row = recordService.updateRecordInfo(rno,recordName,endTime,dno);
		if(row>0){
			JOptionPane.showMessageDialog(recordAddJpanel, "添加修改成功");
			return;
		}else{
			JOptionPane.showMessageDialog(recordAddJpanel, "添加修改失败");
			return;
		}
	}

	private void recordQueryByrno() {
		String rno = recordUpdateJpanel.rnoTextField.getText();
		for(RecordVO l:RecordDAO.recordSelectedList){
			if(l.getRno().equals(rno)){
				recordUpdateJpanel.endTimeTextField.setText(l.getEndTime());
				recordUpdateJpanel.recordNameTextField.setText(l.getRecordName());
				recordUpdateJpanel.dnoTextField.setText(l.getDno());
				return;
			}
		}
		JOptionPane.showMessageDialog(recordAddJpanel, "档案号不存在");
	}

	private void recordDelete() {
		String rno = recordDeleteJpanel.rnoTextField.getText();
		int row = recordService.deleteRecordInfo(rno);
		if(row>0){
			JOptionPane.showMessageDialog(recordAddJpanel, "删除档案成功");
			return;
		}else{
			JOptionPane.showMessageDialog(recordAddJpanel, "删除档案失败");
			return;
		}
	}

	private void add() {
		String rno = recordAddJpanel.rnoTextField.getText();
		String recordName = recordAddJpanel.recordNameTextField.getText();
		String endTime = recordAddJpanel.endTimeTextField.getText();
		String dno = recordAddJpanel.dnoTextField.getText();
		int row = recordService.addRecordInfo(rno,recordName,endTime,dno);
		if(row>0){
			JOptionPane.showMessageDialog(recordAddJpanel, "添加档案成功");
			return;
		}else{
			JOptionPane.showMessageDialog(recordAddJpanel, "添加档案失败");
			return;
		}
	}

}
