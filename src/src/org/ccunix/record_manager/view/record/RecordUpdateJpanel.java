package src.org.ccunix.record_manager.view.record;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import src.org.ccunix.record_manager.controller.RecordJpanelListenerController;
import src.org.ccunix.record_manager.service.RecordService;

public class RecordUpdateJpanel extends JPanel{
	RecordService RecordService = new RecordService();
	public JTextField rnoTextField;
	public JTextField recordNameTextField;
	public JTextField endTimeTextField;
	public JTextField dnoTextField;
	public RecordUpdateJpanel() {
		setLayout(null);
		setBackground(new Color(240,240,240));
		setBounds(0, 0, 730,277);
		
		JLabel rnoLabel = new JLabel("档案编号");
		rnoLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		rnoLabel.setBounds(29, 45, 73, 37);
		add(rnoLabel);
		
		JLabel recordNamelabel = new JLabel("档案名称");
		recordNamelabel.setFont(new Font("宋体", Font.PLAIN, 15));
		recordNamelabel.setBounds(29, 109, 73, 37);
		add(recordNamelabel);
		
		JLabel endTimelabel = new JLabel("合同期限");
		endTimelabel.setFont(new Font("宋体", Font.PLAIN, 15));
		endTimelabel.setBounds(403, 45, 286, 37);
		add(endTimelabel);
		
		JLabel dnolabel = new JLabel("部门编号");
		dnolabel.setFont(new Font("宋体", Font.PLAIN, 15));
		dnolabel.setBounds(403, 109, 286, 37);
		add(dnolabel);
	
		
		dnoTextField = new JTextField();
		dnoTextField.setColumns(10);
		dnoTextField.setBounds(474, 109, 215, 37);
		add(dnoTextField);
		
		
		rnoTextField = new JTextField();
		rnoTextField.setBounds(100, 45, 135, 37);
		add(rnoTextField);
		rnoTextField.setColumns(10);
		
		recordNameTextField = new JTextField();
		recordNameTextField.setColumns(10);
		recordNameTextField.setBounds(100, 109, 233, 37);
		add(recordNameTextField);
		
		endTimeTextField = new JTextField();
		endTimeTextField.setColumns(10);
		endTimeTextField.setBounds(474, 45, 215, 37);
		add(endTimeTextField);
		
		JButton sureButton = new JButton("确定");
		sureButton.setFont(new Font("宋体", Font.PLAIN, 15));
		sureButton.setBounds(215, 195, 135, 37);
		add(sureButton);
		RecordJpanelListenerController controller_sure = new RecordJpanelListenerController(this,"recordUpdate");
		sureButton.addActionListener(controller_sure);
		
		
		JButton resetButton = new JButton("重置");
		resetButton.setFont(new Font("宋体", Font.PLAIN, 15));
		resetButton.setBounds(438, 196, 135, 37);
		add(resetButton);
		
		JButton btnNewButton = new JButton("查找");
		btnNewButton.setBounds(245, 45, 88, 37);
		add(btnNewButton);
		RecordJpanelListenerController controller_query = new RecordJpanelListenerController(this,"recordQueryByrno");
		btnNewButton.addActionListener(controller_query);
		
		resetButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dnoTextField.setText("");
				rnoTextField.setText("");
				recordNameTextField.setText("");
				endTimeTextField.setText("");
			}
		});
		
	}
}
