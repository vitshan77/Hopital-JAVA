package Vue;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Manager.Manager;
import Model.Chambres;
import Model.Patient;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class chambrepati {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {


		EventQueue.invokeLater(new Runnable() {


			public void run() {


				try {
					chambrepati window = new chambrepati();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public chambrepati() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(550, 300, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(200, 48, 468, 388);
		frame.getContentPane().add(scrollPane);
		DefaultTableModel tblModel = new DefaultTableModel(

				new String[] {
						"Nom", "Prenom", "numéro de chambre", "Choix"
				},0
				);
		table = new JTable(tblModel);

		table.getColumnModel().getColumn(0).setPreferredWidth(135);
		table.getColumnModel().getColumn(1).setPreferredWidth(164);
		table.getColumnModel().getColumn(2).setPreferredWidth(300);
		table.getColumnModel().getColumn(3).setPreferredWidth(201);
		Manager m = new Manager();
		ArrayList<Object[]> o = m.hospitalisation();
		for(int i = 0 ; i < o.size(); i ++) {
			tblModel.addRow(o.get(i));
		}
		scrollPane.setViewportView(table);


		//ArrayList<String>liste= m.recupatient();
		ArrayList<Patient>liste = 	m.recupatients();

		JComboBox<Patient> comboBox = new JComboBox(liste.toArray());
		comboBox.setBounds(17, 83, 171, 53);
		frame.getContentPane().add(comboBox);

		ArrayList<Chambres>liste1 = m.recuchambres();

		JComboBox<Chambres> comboBox_1 = new JComboBox(liste1.toArray());
		comboBox_1.setBounds(17, 238, 171, 36);
		frame.getContentPane().add(comboBox_1);

		JLabel lblNewLabel = new JLabel("Nom");
		lblNewLabel.setBounds(31, 68, 113, 23);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Numéo de chambre");
		lblNewLabel_1.setBounds(31, 212, 155, 24);
		frame.getContentPane().add(lblNewLabel_1);

		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(69, 340, 117, 29);
		frame.getContentPane().add(btnNewButton);
	}
}
