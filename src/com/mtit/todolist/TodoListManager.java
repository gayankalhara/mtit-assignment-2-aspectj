package com.mtit.todolist;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;

import com.mtit.dataaccess.TodoListItem;
import com.mtit.service.ServiceManager;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class TodoListManager extends JFrame {

	private JPanel contentPane;
	private JTable todoListTable;
	private JTextField txtTodoItemName;
	private JButton btnRemoveSelected_1;
	private JButton btnRemoveSelected;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TodoListManager frame = new TodoListManager();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TodoListManager() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 629, 601);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtTodoItemName = new JTextField();
		txtTodoItemName.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		txtTodoItemName.setBounds(10, 11, 519, 53);
		contentPane.add(txtTodoItemName);
		txtTodoItemName.setColumns(10);
		
		JComboBox cmbPriority = new JComboBox();
		cmbPriority.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		cmbPriority.setBounds(437, 75, 92, 39);
		contentPane.add(cmbPriority);
		
		JDateChooser dcDueDate = new JDateChooser();
		dcDueDate.setBounds(10, 75, 417, 39);
		contentPane.add(dcDueDate);
		
		TodoListTableModel model = new TodoListTableModel(ServiceManager.getTodoListItemsService().getTodoListItems());
		todoListTable = new JTable(model);
		
		JButton btnAdd = new JButton("+");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String todoListItemName = txtTodoItemName.getText();
				int priority = Integer.parseInt(String.valueOf(cmbPriority.getSelectedItem()));
				java.util.Date time = new java.util.Date((long)dcDueDate.getDate().getTime());
				SimpleDateFormat timeFormat = new SimpleDateFormat("MMM d, yyyy");
				String dueDate = timeFormat.format(time);
				
				TodoListItem todoListItem = new TodoListItem(0, 1, todoListItemName, priority, dueDate, "Pending");
				
				ServiceManager.getTodoListItemsService().addTodoListItem(todoListItem);
				refreshTable();
			}
		});
		btnAdd.setBounds(539, 11, 64, 107);
		contentPane.add(btnAdd);
		
		btnRemoveSelected_1 = new JButton("Remove Selected");
		btnRemoveSelected_1.setBounds(10, 508, 289, 43);
		contentPane.add(btnRemoveSelected_1);
		
		btnRemoveSelected = new JButton("Mark as Done");
		btnRemoveSelected.setBounds(309, 508, 294, 43);
		contentPane.add(btnRemoveSelected);
							
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 125, 593, 372);
		contentPane.add(scrollPane);

		
		scrollPane.setViewportView(todoListTable);
		todoListTable.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		todoListTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}
	
	private void refreshTable(){
		TodoListTableModel model = new TodoListTableModel(ServiceManager.getTodoListItemsService().getTodoListItems());
		todoListTable.setModel(model);
		model.fireTableDataChanged();
	}
}
