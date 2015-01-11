package UAS;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import net.proteanit.sql.DbUtils;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.SwingConstants;

public class Penjualan extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected static final String Hasil_stock = null;
	private Connection konek = null;
	private JPanel contentPane;
	private JTable table;
	private JTextField txtIDPenjualan;
	private JTextField txtIDProduct;
	private JTextField txtNProduct;
	private JTextField txtJumlah;
	private JTextField txtHarga;
	private JTextField txtTgl;
	private JTextField txtTotal;
	private JTextField txtStock;
	private JTextField txtSisaStock;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Penjualan frame = new Penjualan();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void refresh()
	{
		try {
			 Class.forName(koneksi.DATABASE_DRIVER);
			 konek=DriverManager.getConnection(koneksi.URL, koneksi.USERNAME, koneksi.PASSWORD);
			String query="select * from transaksi";
			PreparedStatement pst=konek.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public Penjualan() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 748, 683);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIdTranskasi = new JLabel("ID Transaksi");
		lblIdTranskasi.setBounds(13, 61, 93, 14);
		contentPane.add(lblIdTranskasi);
		
		JLabel lblTgl = new JLabel("Tanggal");
		lblTgl.setBounds(387, 64, 46, 14);
		contentPane.add(lblTgl);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 461, 688, 131);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		txtIDPenjualan = new JTextField();
		txtIDPenjualan.setBounds(131, 61, 211, 20);
		contentPane.add(txtIDPenjualan);
		txtIDPenjualan.setColumns(10);
		
		JLabel lblIdProduk = new JLabel("ID Produk");
		lblIdProduk.setBounds(13, 103, 71, 14);
		contentPane.add(lblIdProduk);
		
		txtIDProduct = new JTextField();
		txtIDProduct.setColumns(10);
		txtIDProduct.setBounds(131, 100, 138, 20);
		contentPane.add(txtIDProduct);
		
		JButton btnCari = new JButton("Cari");
		btnCari.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try
				{
					Class.forName(koneksi.DATABASE_DRIVER);
					konek=DriverManager.getConnection(koneksi.URL, koneksi.USERNAME, koneksi.PASSWORD);
					String query="select id, nama, harga, stock from product where id=?";
					PreparedStatement pst=konek.prepareStatement(query);
					pst.setString(1, txtIDProduct.getText());
					ResultSet rs=pst.executeQuery();
					
					while(rs.next())
					{
						txtIDProduct.setText(rs.getString("id"));
						txtNProduct.setText(rs.getString("nama"));
						txtHarga.setText(rs.getString("harga"));
						txtStock.setText(rs.getString("stock"));
					}
					
					pst.close();

				}
				catch (Exception ex)
				{
					ex.printStackTrace();

				}
			}
		});
		btnCari.setBounds(279, 99, 66, 23);
		contentPane.add(btnCari);
		
		JLabel lblNamaProduk = new JLabel("Nama Produk");
		lblNamaProduk.setBounds(13, 136, 93, 14);
		contentPane.add(lblNamaProduk);
		
		txtNProduct = new JTextField();
		txtNProduct.setColumns(10);
		txtNProduct.setBounds(131, 133, 211, 20);
		contentPane.add(txtNProduct);
		
		JLabel lblJumlah = new JLabel("Jumlah");
		lblJumlah.setBounds(13, 173, 71, 14);
		contentPane.add(lblJumlah);
		
		txtJumlah = new JTextField();
		txtJumlah.setColumns(10);
		txtJumlah.setBounds(131, 170, 211, 20);
		contentPane.add(txtJumlah);
		
		JLabel lblTotal = new JLabel("Harga");
		lblTotal.setBounds(387, 174, 71, 14);
		contentPane.add(lblTotal);
		
		txtHarga = new JTextField();
		txtHarga.setColumns(10);
		txtHarga.setBounds(508, 170, 180, 20);
		contentPane.add(txtHarga);
		
		JLabel lblTransaksi = new JLabel("TRANSAKSI PENJUALAN");
		lblTransaksi.setHorizontalAlignment(SwingConstants.CENTER);
		lblTransaksi.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 20));
		lblTransaksi.setBounds(258, 11, 206, 39);
		contentPane.add(lblTransaksi);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try 
				{
					Class.forName(koneksi.DATABASE_DRIVER);
					konek=DriverManager.getConnection(koneksi.URL, koneksi.USERNAME, koneksi.PASSWORD);
				 	String query="insert into Transaksi(idTrans,tglTrans,id,nama,jumlah,total) values (?,?,?,?,?,?)";
				 	String query1="Update Product set stock='"+txtSisaStock.getText()+"' where id='"+txtIDProduct.getText()+"' ";
					PreparedStatement pst=konek.prepareStatement(query);
					PreparedStatement pst1=konek.prepareStatement(query1);
					pst.setString(1, txtIDPenjualan.getText());
					pst.setString(2, txtTgl.getText());
					pst.setString(3, txtIDProduct.getText());
					pst.setString(4, txtNProduct.getText());
					pst.setString(5, txtJumlah.getText());
					pst.setString(6, txtTotal.getText());
					
					
					pst.execute();
					pst1.execute();


					JOptionPane.showMessageDialog(null, "data saved");
					pst.close();
					refresh();
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
	
				refresh();
			}
		});
		btnSave.setBounds(30, 603, 138, 30);
		contentPane.add(btnSave);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setBounds(588, 603, 130, 30);
		contentPane.add(btnExit);
		
		txtTgl = new JTextField();
		txtTgl.setColumns(10);
		txtTgl.setBounds(505, 61, 182, 20);
		contentPane.add(txtTgl);
		
		JLabel lblTotal_1 = new JLabel("Total");
		
		lblTotal_1.setBounds(226, 267, 71, 14);
		contentPane.add(lblTotal_1);
		
		txtTotal = new JTextField();
		txtTotal.setColumns(10);
		txtTotal.setBounds(322, 264, 180, 20);
		contentPane.add(txtTotal);
		
		JButton btnTotal = new JButton("Total");
		btnTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String Jumlah = txtJumlah.getText();
				String Harga = txtHarga.getText();
				String Stock = txtStock.getText();
				
				 int Jumlah_J = Integer.parseInt(Jumlah);
				 int Harga_H = Integer.parseInt(Harga);
				 int S_Stock = Integer.parseInt(Stock);
				 int Total = Jumlah_J * Harga_H;
				 int sStock = S_Stock - Jumlah_J;
				 
				 String Hasil = String.valueOf(Total);
				 txtTotal.setText(Hasil);
				 String Hasil_Stock = String.valueOf(sStock);
				 txtSisaStock.setText(Hasil_Stock);
				 
			}
		});
		btnTotal.setBounds(228, 209, 274, 44);
		contentPane.add(btnTotal);
		
		txtStock = new JTextField();
		txtStock.setColumns(10);
		txtStock.setBounds(508, 100, 180, 20);
		contentPane.add(txtStock);
		
		txtSisaStock = new JTextField();
		txtSisaStock.setColumns(10);
		txtSisaStock.setBounds(508, 133, 180, 20);
		contentPane.add(txtSisaStock);
		
		JLabel lblStock = new JLabel("Stock");
		lblStock.setBounds(388, 103, 71, 14);
		contentPane.add(lblStock);
		
		JLabel lblSisaStock = new JLabel("Sisa Stock");
		lblSisaStock.setBounds(387, 136, 71, 14);
		contentPane.add(lblSisaStock);
		
		JButton btnLoadData = new JButton("Load Data Transaksi");
		btnLoadData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try 
				{
					 Class.forName(koneksi.DATABASE_DRIVER);
					 konek=DriverManager.getConnection(koneksi.URL, koneksi.USERNAME, koneksi.PASSWORD);
					 String query="select * from Transaksi order by idTrans";
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
		btnLoadData.setBounds(178, 603, 164, 30);
		contentPane.add(btnLoadData);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(30, 317, 688, 108);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JLabel lblNewLabel = new JLabel("Record Transaksi");
		lblNewLabel.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		lblNewLabel.setBounds(30, 436, 99, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblInformasiProduct = new JLabel("Data Product");
		lblInformasiProduct.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 13));
		lblInformasiProduct.setBounds(30, 292, 99, 14);
		contentPane.add(lblInformasiProduct);
		
		JButton btnLoadDataProduct = new JButton("Load Data Product");
		btnLoadDataProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg1) {
				try 
				{
					 Class.forName(koneksi.DATABASE_DRIVER);
					 konek=DriverManager.getConnection(koneksi.URL, koneksi.USERNAME, koneksi.PASSWORD);
					 String query="select id,nama,idSupp,harga from product order by id asc";
					 PreparedStatement pst=konek.prepareStatement(query);
					 ResultSet rs=pst.executeQuery();
					 table_1.setModel(DbUtils.resultSetToTableModel(rs));
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
		btnLoadDataProduct.setBounds(352, 603, 167, 30);
		contentPane.add(btnLoadDataProduct);
		
		refresh();
	}
}
