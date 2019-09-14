package src.org.ccunix.record_manager.view.record;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import src.org.ccunix.record_manager.service.RecordService;
import src.org.ccunix.record_manager.util.DataParseUtil;
import src.org.ccunix.record_manager.vo.RecordVO;

public class QueryRecordJpanel extends JPanel {
	public JTable table;
	RecordService recordService = new RecordService();
	public JTextField dnoTextField;
	public JTextField deptNameTextField;

	public QueryRecordJpanel() {
		setLayout(null);
		setBackground(new Color(240, 240, 240));
		setBounds(0, 0, 730, 277);

		JLabel lblNewLabel = new JLabel("部门编号");
		lblNewLabel.setBounds(10, 21, 69, 28);
		add(lblNewLabel);

		dnoTextField = new JTextField();
		dnoTextField.setBounds(89, 18, 158, 31);
		add(dnoTextField);
		dnoTextField.setColumns(10);

		JLabel label = new JLabel("合同期限");
		label.setBounds(257, 21, 69, 28);
		add(label);

		deptNameTextField = new JTextField();
		deptNameTextField.setColumns(10);
		deptNameTextField.setBounds(336, 20, 158, 31);
		add(deptNameTextField);

		table = new JTable();
		table.setBackground(new Color(240, 240, 240));
		table.setBounds(0, 0, 730, 277);
		String[] tableTittle = {"Rno-档案编号","RecordName-档案名字","EndTime-合同期限","Dno-部门编号","DeptVO.DeptName-部门名字"};
		List<RecordVO> taleInfo = recordService.getTableInfoList();
		DataParseUtil.makeDataFromList(table, taleInfo, tableTittle);
		
		table.setPreferredScrollableViewportSize(new Dimension(730, 277));
		JScrollPane jScrollPane = new JScrollPane(table);
		jScrollPane.setBounds(0, 74, 730, 203);
		add(jScrollPane);
		
		
		JButton button = new JButton("确定");
		button.setBounds(504, 21, 93, 31);
		add(button);
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String dno=dnoTextField.getText();
				String endTime=deptNameTextField.getText();
				String[] tableTittle = {"Rno-档案编号","RecordName-档案名字","EndTime-合同期限","Dno-部门编号","DeptVO.DeptName-部门名字"};
				List<RecordVO> taleInfo = recordService.getRecordTableInfoListBy(dno,endTime);
				DataParseUtil.makeDataFromList(table, taleInfo, tableTittle);
			}
		});
		

		JButton button_1 = new JButton("重置");
		button_1.setBounds(607, 21, 93, 30);
		add(button_1);
		button_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dnoTextField.setText("");
				deptNameTextField.setText("");
			}
		});
	}
}
