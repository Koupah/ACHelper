package aaaaa;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Main extends JFrame {
	public static int mstime = (int) System.currentTimeMillis();
	public static int difference = (int) (System.currentTimeMillis() - mstime);
	private JPanel contentPane;
	static List<String> Amounts = new ArrayList<String>();
	List<Double> list = new ArrayList<>();
	static JLabel avgcps = new JLabel("Average CPS: 0");
	/**
	 * Launch the application.
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	
	public static void main(String[] args) throws IOException, InterruptedException {
		if (args.length < 1) {
			File thisfile = new File("ACHelper.jar");
			if (!thisfile.exists()) {
				JOptionPane.showMessageDialog(null, "Rename the Jar File back to ACHelper.jar! Thanks.");
				System.exit(0);
			}
			Runtime.getRuntime().exec("cmd /c start Java -jar ACHelper.jar Rederpz is genuinely cool");
			System.exit(0);
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		addMouseListener(new MouseListener());
		setTitle("CLICK IN THIS WINDOW");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton mean = new JButton("Calculate Mean");
		mean.setBounds(57, 162, 305, 23);
		contentPane.add(mean);
		
		JButton range = new JButton("Calculate Range");
		range.setBounds(57, 136, 305, 23);
		contentPane.add(range);
		
		JButton standev = new JButton("Calculate Standard Deviation");
		standev.setBounds(57, 188, 305, 23);
		contentPane.add(standev);
		
		JButton reset = new JButton("Reset");
		reset.setBounds(57, 214, 305, 23);
		contentPane.add(reset);
		
		JButton mode = new JButton("Calculate Mode");
		mode.setBounds(57, 110, 304, 23);
		contentPane.add(mode);
		
		
		avgcps.setHorizontalAlignment(SwingConstants.CENTER);
		avgcps.setFont(new Font("Tahoma", Font.PLAIN, 16));
		avgcps.setBounds(0, 11, 434, 32);
		contentPane.add(avgcps);
		mstime = (int) System.currentTimeMillis();
		mean.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				double total = 0;
				for (int i = 1; i < Amounts.size(); i++) {
				total = total + Double.parseDouble(Amounts.get(i));
				if (i == Amounts.size()) {
					i = 0;
					break;
				}
			}
				
				double mean = total / Amounts.size();
				System.out.println("Mean: " + mean + "ms");
				total = 0;
				
				}});
		reset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
	
				Amounts.clear();
				list.clear();
				System.out.println("Information RESET!");
	}});
		range.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Double min;
				Double max;
				
				for (int i = 1; i < Amounts.size(); i++) {
				list.add(Double.parseDouble(Amounts.get(i)));
				} 			
				min = list.get(0);
		        for (Double i : list){
		            min = min < i ? min : i;
		        }
		        
		       max = Collections.max(list);
		       
		      
			System.out.println("Range: " + (max - min) + "ms");
		
			
				list.clear();
				}
			
			
		});
		mode.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
					double s;
					List<Integer> intar = new ArrayList<>();
				for (int i = 1; i < Amounts.size(); i++) {
				
					intar.add((int) Double.parseDouble(Amounts.get(i)));
					
					} 
				int[] arr = new int[intar.size()];

				for(int i = 0; i < intar.size(); i++) {
				    if (intar.get(i) != null) {
				        arr[i] = intar.get(i);
				    }
				}
			
				System.out.println("Mode: " + Mode(arr) + "ms");
				
				intar.clear();
				arr = null;
				}});
		standev.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				double s;
				List<Integer> intar = new ArrayList<>();
				for (int i = 1; i < Amounts.size(); i++) {
					
					intar.add((int) Double.parseDouble(Amounts.get(i)));
					
					}
				int[] arr = new int[intar.size()];

				for(int i = 0; i < intar.size(); i++) {
				    if (intar.get(i) != null) {
				        arr[i] = intar.get(i);
				    }
				}
				STD(arr);
				intar.clear();
				arr = null;
				}});
		
	}
	static int Mode(int[] n){
	    int t = 0;
	    for(int i=0; i<n.length; i++){
	        for(int j=1; j<n.length-i; j++){
	            if(n[j-1] > n[j]){
	                t = n[j-1];
	                n[j-1] = n[j];
	                n[j] = t;
	            }
	        }
	    }

	    int mode = n[0];
	    int temp = 1;
	    int temp2 = 1;
	    for(int i=1;i<n.length;i++){
	        if(n[i-1] == n[i]){
	            temp++;
	        }
	        else {
	            temp = 1;
	        }
	        if(temp >= temp2){
	            mode = n[i];
	            temp2 = temp;
	        }
	    }
	    return mode;
	}
	public void STD(int[] values) {
		double total = 0;
		for (int i = 1; i < Amounts.size(); i++) {
		total = total + Double.parseDouble(Amounts.get(i));
		if (i == Amounts.size()) {
			i = 0;
			break;
		}
	}
		
		double average = total / Amounts.size();
		double sumX=0;
        double finalsumX=0;
        double[] x1_average = new double[2000];
        for (int i = 0; i<values.length; i++){
            double fvalue = (Math.pow((values[i] - average), 2));
            x1_average[i]= fvalue;
           
        }

        for(double i : x1_average) {
            finalsumX = (sumX += i);
        }

        Double AverageX = finalsumX/(values.length);
       
        double SquareRoot = Math.sqrt(AverageX);
        System.out.println("Standard Deviation: "+ SquareRoot + "ms");
    }
	
}

