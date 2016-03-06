package Principal;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Login.InSesion;
import Sqls.IniSesion;


public class Principal {
	int min=0;
	int seg=0;
	public static String hora="";
	public static void main(String[] args) {
		llamar();
	}
	 static InSesion k=new InSesion();
	 static String mini="";
	
	public static void llamar(){
		
		k.setVisible(true);
		k.setLocationRelativeTo(null);
	}
	public void cerrar(){
		k.dispose();
	}
 public String bloqueo(){
	 for(min=0;min<3;min++){
			for(seg=0;seg<60;seg++){
				delaySeg();
				if(seg<10){
				 hora=("0"+min+":0"+seg);
				System.out.println(hora);
				
				
				}
				if(seg>=10&&seg<60){
					hora=("0"+min+":"+seg);
					System.out.println(hora);
				}				
				k.enable();	
			}
		}
	 return hora; 
 }	
 private static void delaySeg(){
	 try{
		 Thread.sleep(1000);
	 }catch(Exception e){
		 JOptionPane.showMessageDialog(null, e.getMessage());
	 }
 }
}