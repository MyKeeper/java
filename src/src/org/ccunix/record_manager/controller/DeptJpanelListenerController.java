package src.org.ccunix.record_manager.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import src.org.ccunix.record_manager.service.DeptService;
import src.org.ccunix.record_manager.view.dept.AddJpanel;
import src.org.ccunix.record_manager.view.dept.DeleteJpanel;
import src.org.ccunix.record_manager.view.dept.UpdateJpanel;

public class DeptJpanelListenerController implements ActionListener{
	DeptService deptService = new DeptService();
	AddJpanel addJpanel;
	DeleteJpanel deleteJpanel;
	UpdateJpanel updateJpanel;
	String method;
	public DeptJpanelListenerController(AddJpanel addJpanel, String method) {
		this.addJpanel=addJpanel;
		this.method=method;
	} 
	public DeptJpanelListenerController(DeleteJpanel deleteJpanel, String method) {
		this.deleteJpanel=deleteJpanel;
		this.method=method;
	}
	public DeptJpanelListenerController(UpdateJpanel updateJpanel, String method) {
		this.updateJpanel=updateJpanel;
		this.method=method;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String key= method;
		switch (key) {
		case "sure":
			sure();
			break;
		case "delete":
			delete();
			break;
		case "update":
			update();
			break;

		default:
			break;
		}
	}
	private void update() {
		String dno = updateJpanel.dnoTextField.getText();
		String deptName = updateJpanel.deptNameTextField.getText();
		int row = deptService.updateDept(dno,deptName);
		if(row>0){
			JOptionPane.showMessageDialog(addJpanel, "部门修改成功");
			return ;
		}else {
			JOptionPane.showMessageDialog(addJpanel, "部门修改失败");
			return;
		}
	}
	private void delete() {
		String dno = deleteJpanel.dnoTextField.getText();
		int row = deptService.deleteDept(dno);
		if(row>0){
			JOptionPane.showMessageDialog(addJpanel, "部门删除成功");
			return ;
		}else {
			JOptionPane.showMessageDialog(addJpanel, "部门删除失败");
			return;
		}
	}
	private void sure() {
		String dno = addJpanel.dnoTextField.getText();
		String deptName = addJpanel.deptNameTextField.getText();
		int row = deptService.insertDept(dno,deptName);
		if(row>0){
			JOptionPane.showMessageDialog(addJpanel, "部门添加成功");
			return ;
		}else {
			JOptionPane.showMessageDialog(addJpanel, "部门添加失败");
			return;
		}
	}
}
