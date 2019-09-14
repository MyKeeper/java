package src.org.ccunix.record_manager.view.record;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import src.org.ccunix.record_manager.service.RecordService;
import src.org.ccunix.record_manager.util.DataParseUtil;
import src.org.ccunix.record_manager.util.SwitchMenuItemUtil;
import src.org.ccunix.record_manager.vo.RecordVO;

public class RecordManagerJframeView extends JFrame {
	
	RecordAddJpanel addJpanel= new RecordAddJpanel();
	RecordService recordService = new RecordService();
	RecordDeleteJpanel deleteJpanel = new RecordDeleteJpanel();
	QueryRecordJpanel queryRecordJpanel = new QueryRecordJpanel();
	RecordUpdateJpanel recordUpdateJpanel = new RecordUpdateJpanel();
	public JTextField textField;
	public JTable table;
	public JPanel panel;
	public RecordManagerJframeView() {
		getContentPane().setLayout(null);

		textField = new JTextField("档案信息管理—→档案管理");
		textField.setFont(new Font("宋体", Font.PLAIN, 14));
		textField.setBounds(566, 22, 190, 43);
		getContentPane().add(textField);
		textField.setColumns(10);

		JButton button = new JButton("增加");
		button.setFont(new Font("宋体", Font.PLAIN, 14));
		button.setBounds(663, 86, 93, 36);
		getContentPane().add(button);
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SwitchMenuItemUtil.switchJpane(RecordManagerJframeView.this, panel, addJpanel);
			}
		});

		JButton button_1 = new JButton("删除");
		button_1.setFont(new Font("宋体", Font.PLAIN, 14));
		button_1.setBounds(551, 86, 93, 36);
		getContentPane().add(button_1);
		button_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SwitchMenuItemUtil.switchJpane(RecordManagerJframeView.this, panel, deleteJpanel);
			}
		});

		JButton button_2 = new JButton("修改");
		button_2.setFont(new Font("宋体", Font.PLAIN, 14));
		button_2.setBounds(435, 86, 93, 36);
		getContentPane().add(button_2);
		button_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SwitchMenuItemUtil.switchJpane(RecordManagerJframeView.this, panel, recordUpdateJpanel);
			}
		});

		JButton button_3 = new JButton("查询");
		button_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwitchMenuItemUtil.switchJpane(RecordManagerJframeView.this, panel, queryRecordJpanel);
			}
		});

		button_3.setFont(new Font("宋体", Font.PLAIN, 14));
		button_3.setBounds(319, 86, 93, 36);
		getContentPane().add(button_3);

		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(26, 138, 730, 277);

		table = new JTable();
		table.setBackground(new Color(240, 240, 240));
		table.setBounds(0, 0, 730, 277);
		String[] tableTittle = {"Rno-档案编号","RecordName-档案名字","EndTime-合同期限","Dno-部门编号","DeptVO.DeptName-部门名字"};
		List<RecordVO> taleInfo = recordService.getTableInfoList();
		DataParseUtil.makeDataFromList(table, taleInfo, tableTittle);
		
		table.setPreferredScrollableViewportSize(new Dimension(730, 277));
		JScrollPane jScrollPane = new JScrollPane(table);
		jScrollPane.setBounds(0, 0, 730, 277);
		panel.add(jScrollPane);

		getContentPane().add(panel);
		panel.setVisible(true);

		setBounds(0, 0, 790, 490);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
	}

	public static void main(String[] args) {
		new RecordManagerJframeView();
	}
}
