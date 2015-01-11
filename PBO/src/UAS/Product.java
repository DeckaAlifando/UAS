package UAS;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JComboBox;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.SwingConstants;

public class Product extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Connection konek = null;
	private JPanel contentPane;
	private JTable table;
	private JLabel lblIdProduct;
	private JTextField txtProduct;
	private JTextField txtNamaProduct;
	private JLabel lblIdSupplier;
	private JTextField txtSupplier;
	private JLabel lblHarga;
	private JTextField txtHarga;
	private JButton btnInsert;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JLabel lblNamaProduct;
	private JLabel lblFormMenuProduct;
	private JTextField txtCari;
	private JComboBox cmbSelect;
	private JLabel lblCari;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Product frame = new Product();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public int test() 
	{
		int a=1;
		do
		{
			int b= a+1;
		}
		while(a==100);
		return a;
	}
	
	public void refresh()
	{
		try 
		{
			 Class.forName(koneksi.DATABASE_DRIVER);
			 konek=DriverManager.getConnection(koneksi.URL, koneksi.USERNAME, koneksi.PASSWORD);
			 String query="select id,nama,idSupp,harga from product order by id asc";
			 PreparedStatement pst=konek.prepareStatement(query);
			 ResultSet rs=pst.executeQuery();
			 table.setModel(DbUtils.resultSetToTableModel(rs));
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public void Combobox()
	{
		try 
		{
			 Class.forName(koneksi.DATABASE_DRIVER);
			 konek=DriverManager.getConnection(koneksi.URL, koneksi.USERNAME, koneksi.PASSWORD);
			 String query="select id,nama,idSupp,harga from product order by id asc";
			 PreparedStatement pst=konek.prepareStatement(query);
			 ResultSet rs=pst.executeQuery();
			 
			 
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	

	/**
	 * Create the frame.
	 */
	public Product() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 715, 615);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLoadDataProduct = new JButton("Load Data");
		btnLoadDataProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try 
				{
					 Class.forName(koneksi.DATABASE_DRIVER);
					 konek=DriverManager.getConnection(koneksi.URL, koneksi.USERNAME, koneksi.PASSWORD);
					 String query="select id,nama,idSupp,harga from product order by id asc";
					 PreparedStatement pst=konek.prepareStatement(query);
					 ResultSet rs=pst.executeQuery();
					 table.setModel(DbUtils.resultSetToTableModel(rs));
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
		btnLoadDataProduct.setBounds(196, 473, 300, 40);
		contentPane.add(btnLoadDataProduct);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 54, 649, 256);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
				try
				{	
					Class.forName(koneksi.DATABASE_DRIVER);
					konek=DriverManager.getConnection(koneksi.URL, koneksi.USERNAME, koneksi.PASSWORD);
					int row=table.getSelectedRow();
					String idP_=(table.getModel().getValueAt(row, 0).toString());
					

				}
				catch (Exception ex)
				{
					ex.printStackTrace();

				}

				
			}
		});
		scrollPane.setViewportView(table);
		
		lblIdProduct = new JLabel("ID Product");
		lblIdProduct.setBounds(28, 360, 73, 14);
		contentPane.add(lblIdProduct);
		
		txtProduct = new JTextField();
		txtProduct.setBounds(117, 352, 207, 21);
		contentPane.add(txtProduct);
		txtProduct.setColumns(10);
		
		txtNamaProduct = new JTextField();
		txtNamaProduct.setBounds(470, 352, 207, 23);
		contentPane.add(txtNamaProduct);
		txtNamaProduct.setColumns(10);
		
		lblIdSupplier = new JLabel("ID Supplier");
		lblIdSupplier.setBounds(28, 389, 73, 14);
		contentPane.add(lblIdSupplier);
		
		txtSupplier = new JTextField();
		txtSupplier.setBounds(117, 380, 207, 23);
		contentPane.add(txtSupplier);
		txtSupplier.setColumns(10);
		
		lblHarga = new JLabel("Harga");
		lblHarga.setBounds(377, 384, 73, 14);
		contentPane.add(lblHarga);
		
		txtHarga = new JTextField();
		txtHarga.setBounds(470, 380, 207, 23);
		contentPane.add(txtHarga);
		txtHarga.setColumns(10);
		
		btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try 
				{
					Class.forName(koneksi.DATABASE_DRIVER);
					konek=DriverManager.getConnection(koneksi.URL, koneksi.USERNAME, koneksi.PASSWORD);
					String query="insert into product(id,nama,idSupp,harga) values (?,?,?,?)";
					PreparedStatement pst=konek.prepareStatement(query);
					pst.setString(1,txtProduct.getText());
					pst.setString(2,txtNamaProduct.getText());
					pst.setString(3,txtSupplier.getText());
					pst.setString(4,txtHarga.getText());
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "data saved");
					pst.close();

				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
				refresh();
			}
		});
		btnInsert.setBounds(166, 439, 109, 23);
		contentPane.add(btnInsert);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					Class.forName(koneksi.DATABASE_DRIVER);
					konek=DriverManager.getConnection(koneksi.URL, koneksi.USERNAME, koneksi.PASSWORD);
					String query="Update product set id='"+txtProduct.getText()+"',nama='"+txtNamaProduct.getText()+"',idSupp='"+txtSupplier.getText()+"',harga='"+txtHarga.getText()+"' where id='"+txtProduct.getText()+"' ";    
					PreparedStatement pst=konek.prepareStatement(query);
					pst.execute();
					JOptionPane.showMessageDialog(null, "data Updated");
					pst.close();
					
				}
				catch (Exception ex)
				{
					ex.printStackTrace();

				}
				refresh();
			}	
		});
		btnUpdate.setBounds(291, 439, 109, 23);
		contentPane.add(btnUpdate);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int action=JOptionPane.showConfirmDialog(null,"Apakah anda yakin mau menghapus data tersebut","delete",JOptionPane.YES_NO_OPTION);
				if(action==0)
				{
					try
					{
						Class.forName(koneksi.DATABASE_DRIVER);
						konek=DriverManager.getConnection(koneksi.URL, koneksi.USERNAME, koneksi.PASSWORD);
						String query="delete from product where id='"+txtProduct.getText()+"' ";
						PreparedStatement pst=konek.prepareStatement(query);
						pst.execute();
						JOptionPane.showMessageDialog(null, "data deleted");
						pst.close();
	
					}
					catch (Exception ex)
					{
						ex.printStackTrace();
	
					}
				}	
				refresh();
			}
		});
		btnDelete.setBounds(418, 439, 109, 23);
		contentPane.add(btnDelete);
		
		lblNamaProduct = new JLabel("Nama Product");
		lblNamaProduct.setBounds(377, 356, 83, 14);
		contentPane.add(lblNamaProduct);
		
		lblFormMenuProduct = new JLabel("PRODUCT MAINTENANCE");
		lblFormMenuProduct.setHorizontalAlignment(SwingConstants.CENTER);
		lblFormMenuProduct.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 20));
		lblFormMenuProduct.setBounds(235, 11, 227, 32);
		contentPane.add(lblFormMenuProduct);
		
		txtCari = new JTextField();
		txtCari.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				try
				{
					Class.forName(koneksi.DATABASE_DRIVER);
					konek=DriverManager.getConnection(koneksi.URL, koneksi.USERNAME, koneksi.PASSWORD);
					
					String selection=(String)cmbSelect.getSelectedItem();
					String query="select id,nama,idSupp,harga from product where "+selection+"=?";
					System.out.println(query);
					PreparedStatement pst=konek.prepareStatement(query);
					pst.setString(test(),txtCari.getText() );
					
					ResultSet rs=pst.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					pst.close();

				}
				catch (Exception ex)
				{
					ex.printStackTrace();

				}
				
			}
		});
		txtCari.setBounds(194, 321, 130, 23);
		contentPane.add(txtCari);
		txtCari.setColumns(10);
		
		cmbSelect = new JComboBox();
		cmbSelect.setModel(new DefaultComboBoxModel(new String[] {"id", "nama", "idSupp"}));
		cmbSelect.setBounds(117, 321, 63, 20);
		contentPane.add(cmbSelect);
		
		lblCari = new JLabel("Cari");
		lblCari.setBounds(28, 330, 46, 14);
		contentPane.add(lblCari);
		
		JButton btnKeluar = new JButton("Exit");
		btnKeluar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnKeluar.setBounds(196, 524, 300, 40);
		contentPane.add(btnKeluar);
	
		refresh();
		Combobox();
	}
}
