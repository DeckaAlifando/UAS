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

public class StockBarang extends JFrame {

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
	private JLabel lblStock;
	private JTextField txtStock;
	private JButton btnUpdate;
	private JLabel lblNamaProduct;
	private JLabel lblFormMenuStockBarang;
	private JTextField txtCari;
	private JComboBox cmbSelect;
	private JLabel lblCari;
	private JButton btnKeluar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StockBarang frame = new StockBarang();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public int coba() 
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
			 String query="select id,nama,idSupp,stock from product order by id asc";
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
			 String query="select id,nama,idSupp,stock from product order by id asc";
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
	public StockBarang() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 380, 507);
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
					 String query="select id,nama,idSupp,stock from product order by id asc";
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
		btnLoadDataProduct.setBounds(125, 418, 107, 40);
		contentPane.add(btnLoadDataProduct);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 52, 345, 169);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
				try
				{	
					Class.forName(koneksi.DATABASE_DRIVER);
					konek=DriverManager.getConnection(koneksi.URL, koneksi.USERNAME, koneksi.PASSWORD);
					
					

				}
				catch (Exception ex)
				{
					ex.printStackTrace();
				}
			}
		});
		scrollPane.setViewportView(table);
		
		lblIdProduct = new JLabel("ID Product");
		lblIdProduct.setBounds(32, 266, 73, 14);
		contentPane.add(lblIdProduct);
		
		txtProduct = new JTextField();
		txtProduct.setBounds(125, 263, 207, 21);
		contentPane.add(txtProduct);
		txtProduct.setColumns(10);
		
		txtNamaProduct = new JTextField();
		txtNamaProduct.setBounds(125, 295, 207, 23);
		contentPane.add(txtNamaProduct);
		txtNamaProduct.setColumns(10);
		
		lblIdSupplier = new JLabel("ID Supplier");
		lblIdSupplier.setBounds(32, 333, 73, 14);
		contentPane.add(lblIdSupplier);
		
		txtSupplier = new JTextField();
		txtSupplier.setBounds(125, 329, 207, 23);
		contentPane.add(txtSupplier);
		txtSupplier.setColumns(10);
		
		lblStock = new JLabel("Stock");
		lblStock.setBounds(32, 370, 73, 14);
		contentPane.add(lblStock);
		
		txtStock = new JTextField();
		txtStock.setBounds(125, 366, 207, 23);
		contentPane.add(txtStock);
		txtStock.setColumns(10);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					Class.forName(koneksi.DATABASE_DRIVER);
					konek=DriverManager.getConnection(koneksi.URL, koneksi.USERNAME, koneksi.PASSWORD);
					String query="Update product set id='"+txtProduct.getText()+"',nama='"+txtNamaProduct.getText()+"',idSupp='"+txtSupplier.getText()+"',stock='"+txtStock.getText()+"' where id='"+txtProduct.getText()+"' ";    
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
		btnUpdate.setBounds(10, 418, 107, 40);
		contentPane.add(btnUpdate);
		
		lblNamaProduct = new JLabel("Nama Product");
		lblNamaProduct.setBounds(32, 299, 83, 14);
		contentPane.add(lblNamaProduct);
		
		lblFormMenuStockBarang = new JLabel("STOCK MAINTENANCE");
		lblFormMenuStockBarang.setHorizontalAlignment(SwingConstants.CENTER);
		lblFormMenuStockBarang.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 20));
		lblFormMenuStockBarang.setBounds(55, 11, 269, 32);
		contentPane.add(lblFormMenuStockBarang);
		
		txtCari = new JTextField();
		txtCari.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				try
				{
					Class.forName(koneksi.DATABASE_DRIVER);
					konek=DriverManager.getConnection(koneksi.URL, koneksi.USERNAME, koneksi.PASSWORD);
					
					String selection=(String)cmbSelect.getSelectedItem();
					String query="select id,nama,idSupp,stock from product where "+selection+"=?";
					System.out.println(query);
					PreparedStatement pst=konek.prepareStatement(query);
					pst.setString(coba(),txtCari.getText() );
					
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
		txtCari.setBounds(192, 232, 140, 23);
		contentPane.add(txtCari);
		txtCari.setColumns(10);
		
		cmbSelect = new JComboBox();
		cmbSelect.setModel(new DefaultComboBoxModel(new String[] {"id", "nama", "idSupp"}));
		cmbSelect.setBounds(125, 233, 57, 20);
		contentPane.add(cmbSelect);
		
		lblCari = new JLabel("Cari");
		lblCari.setBounds(32, 233, 46, 14);
		contentPane.add(lblCari);
		
		btnKeluar = new JButton("Exit");
		btnKeluar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnKeluar.setBounds(242, 418, 107, 40);
		contentPane.add(btnKeluar);
	
		refresh();
		Combobox();
	}
}
