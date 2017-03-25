package com.mtit.todolist;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import com.mtit.dataaccess.TodoListItem;

public class TodoListTableModel extends AbstractTableModel{
	
	/**
	 * The serializable class TodoListTableModel does not declare
	 * a static final serialVersionUID field of type long
	 */
	private static final long serialVersionUID = 1L;
	
	private String[] mColumnNames = {"Task Name", "Priority", "Due Date", "Status"};
	private List<TodoListItem> mTodoItems = null;
	
	public TodoListTableModel(List<TodoListItem> todoItems){
		super();
		mTodoItems = todoItems;
	}
	
	@Override
	public int getColumnCount() {
		return mColumnNames.length;
	}

	@Override
	public int getRowCount() {
		if(mTodoItems == null) {
			return 0;
		} else {
			return mTodoItems.size();
		}
	}
	
	public void setData(List<TodoListItem> todoItems) {
		mTodoItems = todoItems;
	}

	@Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Object value = "??";
        TodoListItem item = mTodoItems.get(rowIndex);
        
        	switch (columnIndex) {
            case 0:
                value = item.getItemName();
                break;
            case 1:
            	value = item.getPriority();
                break;
            case 2:
            	value = item.getDueDate();
                break;
            case 3:
            	value = item.getStatus();
            	break;
        }

        return value;
    }
	
	@Override
	public Class<?> getColumnClass(int columnIndex){
	          switch (columnIndex){
	             case 0:
	               return String.class;
	             case 1:
	               return Integer.class;
	             case 2:
	               return String.class;
	             case 3:
		           return String.class;
	             }
	             return null;
	}
	
	@Override
	public String getColumnName(int col) {
        return mColumnNames[col];
    }
	
	@Override
	public void setValueAt(Object value, int row, int col) {
	  
	  System.out.println("Setting value");
	  fireTableCellUpdated(row, col);
	  // return true;
	}

}
