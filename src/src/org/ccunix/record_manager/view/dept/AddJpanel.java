package src.org.ccunix.record_manager.view.dept;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import src.org.ccunix.record_manager.controller.DeptJpanelListenerController;
import src.org.ccunix.record_manager.service.DeptService;

public class AddJpanel extends JPanel{
	DeptService deptService = new DeptService();
	public JTextField dnoTextField;
	public JTextField deptNameTextField;
	public AddJpanel() {
		setLayout(null);
		setBackground(new Color(240,240,240));
		setBounds(0, 0, 730,277);
		
		JLabel lblNewLabel = new JLabel("部门编号");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel.setBounds(59, 45, 73, 37);
		add(lblNewLabel);
		
		JLabel label = new JLabel("部门名称");
		label.setFont(new Font("宋体", Font.PLAIN, 15));
		label.setBounds(59, 109, 73, 37);
		add(label);
		
		dnoTextField = new JTextField();
		dnoTextField.setBounds(130, 45, 298, 37);
		add(dnoTextField);
		dnoTextField.setColumns(10);
		
		deptNameTextField = new JTextField();
		deptNameTextField.setColumns(10);
		deptNameTextField.setBounds(130, 109, 298, 37);
		add(deptNameTextField);
		
		JButton sureButton = new JButton("确定");
		sureButton.setFont(new Font("宋体", Font.PLAIN, 15));
		sureButton.setBounds(59, 196, 135, 37);
		add(sureButton);
		DeptJpanelListenerController controller_sure = new DeptJpanelListenerController(this,"sure");
		sureButton.addActionListener(controller_sure);
		
		
		JButton resetButton = new JButton("重置");
		resetButton.setFont(new Font("宋体", Font.PLAIN, 15));
		resetButton.setBounds(293, 196, 135, 37);
		add(resetButton);
		resetButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dnoTextField.setText("");
				deptNameTextField.setText("");

			}
		});
		
	}
}
