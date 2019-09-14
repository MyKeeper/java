package src.org.ccunix.record_manager.view.record;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import src.org.ccunix.record_manager.controller.RecordJpanelListenerController;
import src.org.ccunix.record_manager.service.RecordService;

public class RecordDeleteJpanel extends JPanel{
	public JTable table;
	public JTextField rnoTextField;
	RecordService deptService = new RecordService();
	public RecordDeleteJpanel() {
		setLayout(null);
		setBackground(new Color(240,240,240));
		setBounds(0, 0, 730,277);
		JLabel lblNewLabel = new JLabel("档案编号");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel.setBounds(59, 92, 73, 37);
		add(lblNewLabel);
		rnoTextField = new JTextField();
		rnoTextField.setBounds(128, 92, 298, 37);
		add(rnoTextField);
		rnoTextField.setColumns(10);
		JButton sureButton = new JButton("确定");
		sureButton.setFont(new Font("宋体", Font.PLAIN, 15));
		sureButton.setBounds(59, 174, 135, 37);
		add(sureButton);
		RecordJpanelListenerController controller_sure = new RecordJpanelListenerController(this,"recordDelete");
		sureButton.addActionListener(controller_sure);
		
		
		JButton resetButton = new JButton("重置");
		resetButton.setFont(new Font("宋体", Font.PLAIN, 15));
		resetButton.setBounds(291, 174, 135, 37);
		add(resetButton);
		resetButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				rnoTextField.setText("");
			}
		});
	}
}
