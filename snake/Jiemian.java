import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Jiemian extends Thread implements KeyListener
{
  private JFrame frame;
  private JPanel panel;
  private JButton but1;//ÉßÍ·
  private Vector vc;
  private xiancheng xc;
  private int index;
  private int size;
  private JButton temp;
  private JButton food;
  public void chuangjian()
  {
	  frame=new JFrame();
	  panel=new JPanel();
	  vc=new Vector();
	  but1=new JButton();
	  food=new JButton();
	  vc.addElement(but1);
	  for (int i = 1; i <3; i++) 
	  {
		temp=new JButton();
		panel.add(temp);
		vc.addElement(temp);
	  }
	  

	  frame.setDefaultCloseOperation(3);
  }
  public void zuzhuang()
  {
	  panel.setLayout(null);
	  Random ran=new Random();
	  int y=ran.nextInt(400)+100;
	  int x=0;
	 
	  but1.setBounds(40,y,20,20);
	  panel.add(but1);
	  
	  for (int i = 2; i >=1; i--) 
	  {
		Object o=vc.get(i);
		JButton b=(JButton)o;
		b.setBounds(x,y,20,20);
		x=x+20;
	  }
	  frame.add(panel);
  }
  public void zhuce()
  {
	  
	  but1.addKeyListener(this);
	  
  }
  public void xianshi()
  {
	  frame.setVisible(true);
	  frame.setSize(600, 600);
  }
  public void move()
  {
	  xc=new xiancheng();
	  
	  xc.start();
	  xc.set(vc,index,but1,food,panel);
	 
  }
  public void run()
  {
	  while(true)
	  {
		  
		  
		  int x=(int)((Math.random()*400)+100)/20*20;
		  int y=(int)((Math.random()*400)+100)/20*20;
		  food.setBounds(x, y, 20, 20);
		  panel.add(food);
		  try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		  
	  }
  }
	 
	  
		  
  
  
  public Jiemian()
  {
	  chuangjian();
	  zuzhuang();
	  zhuce();
	  xianshi();
	  move();
	  start();
	  
  }

public void keyTyped(KeyEvent e) {
	
	
}

public void keyPressed(KeyEvent e) {
	int k=e.getKeyCode();
	if(k==KeyEvent.VK_RIGHT&&index!=1)
	{
		
		index=0;
		xc.set(vc,index,but1,food,panel);
		
	}
	if(k==KeyEvent.VK_LEFT&&index!=0)
	{
		
		index=1;
		
		xc.set(vc,index,but1,food,panel);
	}
	if(k==KeyEvent.VK_DOWN&&index!=3)
	{
	
		index=2;
		
     	xc.set(vc,index,but1,food,panel);
	}
	if(k==KeyEvent.VK_UP&&index!=2)
	{
		
		index=3;
		
		xc.set(vc,index,but1,food,panel);
	}
	
}

public void keyReleased(KeyEvent e) {
	
}
}
class Main
{
	public static void main(String[] args) {
		new Jiemian();
	}
}