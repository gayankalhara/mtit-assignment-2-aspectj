package com.mtit.todolist;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;

import com.mtit.service.ServiceManager;
import com.mtit.service.TodoListService;
import com.mtit.service.TodoListServiceImpl;
import com.mtit.service.UserService;
import com.mtit.service.UserServiceImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class MainApp {
	
	private static UserService userService = null;
	private static TodoListService todoListService = null;

	private JFrame frame;
	private JTextField txtUserName;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainApp window = new MainApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		initializeDatabase();
		initializeServices();
	}
	
	private static void initializeDatabase(){
		DatabaseConnection.openDatabaseConnection();
	}
	
	private static void initializeServices(){
		userService = new UserServiceImpl();
		todoListService = new TodoListServiceImpl();
	}

	/**
	 * Create the application.
	 */
	public MainApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 298, 303);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName = txtUserName.getText();
				String password = String.valueOf(txtPassword.getPassword());
				
				if((userName == null || userName.equals("")) || (password == null || password.equals(""))){
					JOptionPane.showMessageDialog(frame, "User name or Password cannot be empty!");
				} else{
					if(ServiceManager.getUserService().loginUser(userName, password)) {
						new TodoListManager().setVisible(true);
						frame.dispose();
					} else {
						JOptionPane.showMessageDialog(frame, "Login Failed!");
					}
					
				}
			}
		});
		btnLogin.setBounds(25, 208, 119, 23);
		frame.getContentPane().add(btnLogin);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setBounds(154, 208, 99, 23);
		frame.getContentPane().add(btnExit);
		
		txtUserName = new JTextField();
		txtUserName.setText("gayan");
		txtUserName.setHorizontalAlignment(SwingConstants.CENTER);
		txtUserName.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtUserName.setBounds(25, 56, 228, 35);
		frame.getContentPane().add(txtUserName);
		txtUserName.setColumns(10);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserName.setBounds(104, 31, 70, 14);
		frame.getContentPane().add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(104, 118, 70, 14);
		frame.getContentPane().add(lblPassword);
		
		txtPassword = new JPasswordField();
		txtPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtPassword.setBounds(25, 143, 228, 35);
		frame.getContentPane().add(txtPassword);
	}
}
