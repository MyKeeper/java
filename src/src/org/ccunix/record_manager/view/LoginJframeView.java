package src.org.ccunix.record_manager.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import src.org.ccunix.record_manager.view.dept.DeptManagerJframeView;
import src.org.ccunix.record_manager.view.record.RecordManagerJframeView;

public class LoginJframeView extends JFrame{
	public LoginJframeView() {
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("部门管理");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							DeptManagerJframeView frame = new DeptManagerJframeView();
							frame.setVisible(true);
							setVisible(false);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 24));
		btnNewButton.setBounds(179, 45, 156, 94);
		getContentPane().add(btnNewButton);
		
		JButton button = new JButton("档案管理");
		button.setFont(new Font("微软雅黑", Font.PLAIN, 24));
		button.setBounds(179, 202, 156, 94);
		getContentPane().add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							RecordManagerJframeView frame = new RecordManagerJframeView();
							frame.setVisible(true);
							setVisible(false);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		setBounds(0, 0, 550, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
	}
	public static void main(String[] args) {
		new LoginJframeView();
	}
}
