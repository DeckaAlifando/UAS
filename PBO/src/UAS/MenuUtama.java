package UAS;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuUtama extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JFrame jframe;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuUtama frame = new MenuUtama();
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
	
	
	public MenuUtama() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 616, 320);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnFormProduct = new JButton("Product Maintenance");
		btnFormProduct.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnFormProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Product().setVisible (true);
				jframe.dispose();
			}
		});
		btnFormProduct.setBounds(28, 96, 258, 48);
		contentPane.add(btnFormProduct);
		
		JButton btnFormSupplier = new JButton("Supplier Maintenance");
		btnFormSupplier.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnFormSupplier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Supplier().setVisible (true);
				jframe.dispose();
			}
		});
		btnFormSupplier.setBounds(28, 156, 258, 48);
		contentPane.add(btnFormSupplier);
		
		JButton btnFormStockBarang = new JButton("Stock Maintenance");
		btnFormStockBarang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnFormStockBarang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new StockBarang().setVisible (true);
				jframe.dispose();
			}
		});
		btnFormStockBarang.setBounds(316, 96, 258, 48);
		contentPane.add(btnFormStockBarang);
		
		JLabel lblMenuUtama = new JLabel("ADMIN MENU");
		lblMenuUtama.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuUtama.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 23));
		lblMenuUtama.setBounds(181, 11, 240, 74);
		contentPane.add(lblMenuUtama);
		
		JButton btnFormMenuUser = new JButton("User Maintenance");
		btnFormMenuUser.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnFormMenuUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new MenuUser().setVisible (true);
				jframe.dispose();
			}
		});
		btnFormMenuUser.setBounds(316, 155, 258, 48);
		contentPane.add(btnFormMenuUser);
		
		JButton btnTransaksi = new JButton("Laporan Transaksi");
		btnTransaksi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTransaksi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Laporan().setVisible (true);
				jframe.dispose();
			}
		});
		btnTransaksi.setBounds(28, 215, 258, 48);
		contentPane.add(btnTransaksi);
		
		JButton btnKeluar = new JButton("Keluar");
		btnKeluar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnKeluar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnKeluar.setBounds(316, 214, 258, 45);
		contentPane.add(btnKeluar);
		
	}
}
