package src.org.ccunix.record_manager.view.dept;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import src.org.ccunix.record_manager.controller.DeptJpanelListenerController;
import src.org.ccunix.record_manager.service.DeptService;

public class DeleteJpanel extends JPanel{
	public JTable table;
	public JTextField dnoTextField;
	DeptService deptService = new DeptService();
	public DeleteJpanel() {
		setLayout(null);
		setBackground(new Color(240,240,240));
		setBounds(0, 0, 730,277);
		JLabel lblNewLabel = new JLabel("部门编号");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel.setBounds(59, 92, 73, 37);
		add(lblNewLabel);
		dnoTextField = new JTextField();
		dnoTextField.setBounds(128, 92, 298, 37);
		add(dnoTextField);
		dnoTextField.setColumns(10);
		JButton sureButton = new JButton("确定");
		sureButton.setFont(new Font("宋体", Font.PLAIN, 15));
		sureButton.setBounds(59, 174, 135, 37);
		add(sureButton);
		DeptJpanelListenerController controller_sure = new DeptJpanelListenerController(this,"delete");
		sureButton.addActionListener(controller_sure);
		
		
		JButton resetButton = new JButton("重置");
		resetButton.setFont(new Font("宋体", Font.PLAIN, 15));
		resetButton.setBounds(291, 174, 135, 37);
		add(resetButton);
		resetButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dnoTextField.setText("");
			}
		});
	}
}
