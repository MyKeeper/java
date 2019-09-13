package src.org.ccunix.record_manager.view.dept;

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

import src.org.ccunix.record_manager.service.DeptService;
import src.org.ccunix.record_manager.util.DataParseUtil;
import src.org.ccunix.record_manager.vo.DeptVO;

public class QueryJpanel extends JPanel {
	public JTable table;
	DeptService deptService = new DeptService();
	public JTextField dnoTextField;
	public JTextField deptNameTextField;

	public QueryJpanel() {
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

		JLabel label = new JLabel("部门名称");
		label.setBounds(257, 21, 69, 28);
		add(label);

		deptNameTextField = new JTextField();
		deptNameTextField.setColumns(10);
		deptNameTextField.setBounds(336, 20, 158, 31);
		add(deptNameTextField);

		table = new JTable();
		table.setBackground(new Color(240, 240, 240));
		table.setBounds(0, 0, 730, 277);
		String[] tableTittle = { "Dno-部门编号", "DeptName-部门名称" };
		List<DeptVO> taleInfo = deptService.getTableInfoList();
		DataParseUtil.makeDataFromList(table, taleInfo, tableTittle);
		
		table.setPreferredScrollableViewportSize(new Dimension(730, 277));
		JScrollPane jScrollPane = new JScrollPane(table);
		jScrollPane.setBounds(0, 72, 730, 205);
		add(jScrollPane);
		
		
		JButton button = new JButton("确定");
		button.setBounds(504, 21, 93, 31);
		add(button);
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String dno=dnoTextField.getText();
				String deptName=deptNameTextField.getText();
				String[] tableTittle = { "Dno-部门编号", "DeptName-部门名称" };
				List<DeptVO> taleInfo = deptService.getTableInfoListBy(dno,deptName);
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
