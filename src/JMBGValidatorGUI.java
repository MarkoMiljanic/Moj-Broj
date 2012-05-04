import jMBGVerifikator.MetodeZaGUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;


public class JMBGValidatorGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldUnosJMBGa;
	private JTextField textFieldProba;
	private JLabel lblNewLabelDan;
	private JTextField textFieldDanRodjenja;
	private JLabel lblMesec;
	private JTextField textFieldMesecRodjenja;
	private JLabel lblGodina;
	private JTextField textFieldGodinaRodjenja;
	private JTextField textFieldRegion;
	private JTextField textFieldDrzava;
	private JTextField textFieldPol;
	private JTextField textFieldPokrajina;
	private JLabel lblPokrajina;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JMBGValidatorGUI frame = new JMBGValidatorGUI();
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
	public JMBGValidatorGUI() {
		setTitle("JMBG Validator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 587, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUnesiteJMBG = new JLabel("Unesite JMBG");
		lblUnesiteJMBG.setBounds(41, 30, 81, 14);
		contentPane.add(lblUnesiteJMBG);
		
		textFieldUnosJMBGa = new JTextField();
//		textFieldUnosJMBGa.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
////				Ovde mora da se uradi za enter
//				}
//			}
//		});
		textFieldUnosJMBGa.setBounds(132, 27, 106, 20);
		contentPane.add(textFieldUnosJMBGa);
		textFieldUnosJMBGa.setColumns(10);
		
		JButton btnProveriJmbg = new JButton("Proveri JMBG");
		btnProveriJmbg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				uradi();
			}
		});
		btnProveriJmbg.setBounds(132, 58, 113, 23);
		contentPane.add(btnProveriJmbg);
		
		textFieldProba = new JTextField();
		textFieldProba.setEditable(false);
		textFieldProba.setBounds(23, 132, 222, 20);
		contentPane.add(textFieldProba);
		textFieldProba.setColumns(10);
		
		lblNewLabelDan = new JLabel("Dan");
		lblNewLabelDan.setBounds(283, 30, 59, 14);
		contentPane.add(lblNewLabelDan);
		
		textFieldDanRodjenja = new JTextField();
		textFieldDanRodjenja.setForeground(Color.BLACK);
		textFieldDanRodjenja.setEditable(false);
		textFieldDanRodjenja.setBounds(352, 27, 129, 20);
		contentPane.add(textFieldDanRodjenja);
		textFieldDanRodjenja.setColumns(10);
		
		lblMesec = new JLabel("Mesec");
		lblMesec.setBounds(283, 62, 46, 14);
		contentPane.add(lblMesec);
		
		textFieldMesecRodjenja = new JTextField();
		textFieldMesecRodjenja.setEditable(false);
		textFieldMesecRodjenja.setBounds(352, 59, 129, 20);
		contentPane.add(textFieldMesecRodjenja);
		textFieldMesecRodjenja.setColumns(10);
		
		lblGodina = new JLabel("Godina");
		lblGodina.setBounds(283, 97, 46, 14);
		contentPane.add(lblGodina);
		
		textFieldGodinaRodjenja = new JTextField();
		textFieldGodinaRodjenja.setEditable(false);
		textFieldGodinaRodjenja.setBounds(352, 94, 129, 20);
		contentPane.add(textFieldGodinaRodjenja);
		textFieldGodinaRodjenja.setColumns(10);
		
		textFieldRegion = new JTextField();
		textFieldRegion.setEditable(false);
		textFieldRegion.setBounds(352, 163, 204, 20);
		contentPane.add(textFieldRegion);
		textFieldRegion.setColumns(10);
		
		JLabel lblRegion = new JLabel("Region");
		lblRegion.setBounds(283, 166, 46, 14);
		contentPane.add(lblRegion);
		
		JButton btnOcisti = new JButton("Ocisti");
		btnOcisti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ciscenjeRezultata();
			}
		});
		btnOcisti.setBounds(10, 232, 89, 23);
		contentPane.add(btnOcisti);
		
		textFieldDrzava = new JTextField();
		textFieldDrzava.setEditable(false);
		textFieldDrzava.setBounds(352, 132, 129, 20);
		contentPane.add(textFieldDrzava);
		textFieldDrzava.setColumns(10);
		
		JLabel lblDrzava = new JLabel("Drzava");
		lblDrzava.setBounds(283, 135, 46, 14);
		contentPane.add(lblDrzava);
		
		JLabel lblPol = new JLabel("Pol");
		lblPol.setBounds(283, 198, 46, 14);
		contentPane.add(lblPol);
		
		textFieldPol = new JTextField();
		textFieldPol.setEditable(false);
		textFieldPol.setBounds(352, 194, 86, 20);
		contentPane.add(textFieldPol);
		textFieldPol.setColumns(10);
		
		textFieldPokrajina = new JTextField();
		textFieldPokrajina.setEditable(false);
		textFieldPokrajina.setBounds(352, 225, 159, 20);
		contentPane.add(textFieldPokrajina);
		textFieldPokrajina.setColumns(10);
		
		lblPokrajina = new JLabel("Pokrajina");
		lblPokrajina.setBounds(283, 228, 59, 14);
		contentPane.add(lblPokrajina);
	}
	
	public void postavljanjeDatuma (MetodeZaGUI metode){
		metode.PostaviDatumRodjenja();
		textFieldDanRodjenja.setText(""+metode.vratiDan());
		textFieldMesecRodjenja.setText(""+metode.vratiMesecString());
		textFieldGodinaRodjenja.setText(""+metode.vratiGodinu());
	}
	
	public void postavljanjeLokacije (MetodeZaGUI metode){
		metode.nadjiLokaciju();
		textFieldRegion.setText(metode.vratiRegion());
		textFieldDrzava.setText(metode.vratiDrzavu());
		textFieldPokrajina.setText(metode.vratiPokarajinu());
	}
	
	public void postavljanjePola (MetodeZaGUI metode){
		metode.postaviPol();
		textFieldPol.setText(metode.vratiPol());
	}
	
	public void ciscenjeRezultata (){
		textFieldDanRodjenja.setText("");
		textFieldRegion.setText("");
		textFieldGodinaRodjenja.setText("");
		textFieldMesecRodjenja.setText("");
		textFieldProba.setText("");
		textFieldUnosJMBGa.setText("");
		textFieldDrzava.setText("");
		textFieldPol.setText("");
		textFieldPokrajina.setText("");
	}
	
	public void uradi (){

		boolean validnost;
		String JMBG = textFieldUnosJMBGa.getText();
		MetodeZaGUI m = new MetodeZaGUI();
		m.unosJMBGa(JMBG);
		if (m.proveraJMBGa()){
//			textFieldProba.setText("Uneti JMBG je ispravan.");
			validnost = true;
		} else {
			ciscenjeRezultata();
			JOptionPane.showMessageDialog(null, "Uneti JMBG je neispravan.");
			
//			textFieldProba.setText("Uneti JMBG je neispravan.");
			validnost = false;
		}
		if (validnost){
			postavljanjeDatuma(m);
			postavljanjePola(m);
			postavljanjeLokacije(m);		
		}
	}
}
