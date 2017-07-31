package aaaaa;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseListener extends MouseAdapter{
	int a  = 1;
        public void mousePressed(MouseEvent e){
          	Main.difference = (int) (System.currentTimeMillis() - Main.mstime);
        	System.out.println(Main.difference +"ms");
        	Main.mstime = (int) System.currentTimeMillis();
	    	Main.Amounts.add(String.valueOf(Main.difference));
	    	double total = 0;
			for (int i = 1; i < Main.Amounts.size(); i++) {
			total = total + Double.parseDouble(Main.Amounts.get(i));
			if (i == Main.Amounts.size()) {
				i = 0;
				break;
			}
		}
			
			double mean = total / Main.Amounts.size();
			Main.avgcps.setText("Average CPS: " + (1000 / mean));
			mean = 0;
			total = 0;
        }
        public void mouseClicked(MouseEvent e) {
      
        }
        public void mouseEntered(MouseEvent e) {

        }
        public void mouseExited(MouseEvent e) {

        }
       
        public void mouseReleased(MouseEvent e) {

        }
    }
