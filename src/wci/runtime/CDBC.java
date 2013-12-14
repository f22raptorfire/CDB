package wci.runtime;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class CDBC {

	static File DIR;
	
	public CDBC(String directory) {
		DIR = new File(directory);
	}
	
	public CDBC(File directory) {
		DIR = directory;
	}
	
	public static void main(String[] args) {
		CDBC conn = new CDBC("C:\\Users\\Jason\\Documents\\GitHub\\CDB");
		conn.addToCSV("test");
		conn.viewCSV("test");
	}
	
	public static void viewCSV(String tableName) {
		
		File file = DIR.listFiles(csvFilter(tableName))[0];
		try {
			viewFrame(readCSV(file));
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			new Thread().sleep(250);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void addToCSV(String tableName) {
		
		File file = DIR.listFiles(csvFilter(tableName))[0];
		try {
			inputPrompt(readCSV(file), file.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			new Thread().sleep(250);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void viewFrame(JTable table) {
		final JFrame frame = new JFrame();
		frame.setLayout(new BorderLayout());
		final CloseButton closeButton = (new CDBC(DIR)).new CloseButton();
		closeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				closeButton.setReady();
			}
		});
		frame.add(BorderLayout.NORTH, new JScrollPane(table));
		frame.add(BorderLayout.SOUTH, closeButton);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setVisible(true);
		while (!closeButton.ready) {
			System.out.print("");
		}
	}
	
	public static JTable readCSV(File file) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line = reader.readLine();
		String[] columns;
		if (line != null) {
			columns = line.split(",");
		} else {
			reader.close();
			return null;
		}
		ArrayList<String> values = new ArrayList<String>();
		while ((line = reader.readLine()) != null) {
		   values.add(line);
		}
		reader.close();
		String[][] result = new String[values.size()][columns.length];
		for (int i = 0; i < values.size(); i++) {
			result[i] = values.get(i).split(",");
		}
		return new JTable(result, columns);
	}
	
	public static void inputPrompt(JTable table, String title) {
		int columnCount = table.getColumnCount();
		final ArrayList<JTextField> list = new ArrayList<JTextField>();
		final JFrame frame = new JFrame("Insert Entry");
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(0, 1));
		mainPanel.add(new JLabel(title));
		for (int i = 0; i < columnCount; i++) {
			JPanel inputPanel = new JPanel();
			JTextField inputField = new JTextField(30);
			inputPanel.setLayout(new BorderLayout());
			inputPanel.add(BorderLayout.WEST, new JLabel(table.getColumnName(i)));
			inputPanel.add(BorderLayout.EAST, inputField);
			list.add(inputField);
			mainPanel.add(inputPanel);
		}
		CloseButton closeButton = (new CDBC(DIR)).new CloseButton(list, frame, title, table);
		mainPanel.add(closeButton);
		frame.add(mainPanel);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		while (!closeButton.ready) {
			System.out.print("");
		}
	}
	
	public static FilenameFilter csvFilter(final String table) {
		return new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				name = name.toLowerCase();
				return name.contains(".csv") && name.contains(table.toLowerCase());
			}
		};
	}
	
	public class CloseButton extends JButton {
		boolean ready = false;
		
		public CloseButton() {
			super("Close");
		}
		
		public CloseButton(final ArrayList<JTextField> fields, 
	    				   final JFrame frame,
	    				   final String title,
	    				   final JTable table) {
			super("Submit");
	    	addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String result = "", comma = "";
					for (JTextField field : fields) {
						result += comma + field.getText();
						comma = ",";
					}
					result += "\n";
					ready = true;
					File file = DIR.listFiles(csvFilter(title))[0];
					try {
						BufferedWriter writer = new BufferedWriter(new FileWriter(file));
						writer.append(convert(table) + result);
						writer.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					frame.dispose();
				}
	    	});
		}
		
		public void setReady() {
			ready = true;
		}
	}
	
	public static String convert(JTable table) {
		int rowCount = table.getRowCount();
		int columnCount = table.getColumnCount();
		String result = "", comma = "";
		for (int i = 0; i < columnCount; i++) {
			result += comma + table.getColumnName(i);
			comma = ",";
		}
		result += "\n";
		for (int i = 0; i < rowCount; i++) {
			comma = "";
			for (int j = 0; j < columnCount; j++) {
				try {
					result += comma + table.getValueAt(i, j);
				} catch (Exception e) {
					
				}
				comma = ",";
			}
			result += "\n";
		}
		return result;
	}
}
