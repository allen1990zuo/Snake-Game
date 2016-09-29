import java.util.Random;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class xiancheng extends Thread
{
  
  private Vector vc;
  private int index;
  private JButton but;
  private JButton food;
  private JButton temp;
  private int a=0;//判断是否相撞
  private int score=0;//计分数
  private JPanel p;
  private JLabel fenshu=new JLabel("0");
  public void set(Vector vc1,int in,JButton butx,JButton food1,JPanel p1)
  {
	  vc=vc1;
	  index=in;
	  but=butx;
	  food=food1;
	  
	  p=p1;
  }
  
	public void run()
  {
      while(true)
      {
    	  for (int i = vc.size()-1; i >0; i--) 
          {
   		  Object o1=vc.get(i);
   		  JButton but1=(JButton)o1;
   		  Object o2=vc.get(i-1);
   		  JButton but2=(JButton)o2;
   		  but1.setLocation(but2.getX(), but2.getY());
   	      }
              
    	    but.requestFocus();
   	      if(index==0)
   	      {
   	    	but.setLocation(but.getX()+20, but.getY());
   	      }
   	      if(index==1)
	      {
   	    	but.setLocation(but.getX()-20, but.getY());
	      }
   	      if(index==2)
	      {
   	    	but.setLocation(but.getX(), but.getY()+20);
	      }
   	      if(index==3)
	      {
   	    	but.setLocation(but.getX(), but.getY()-20);
	      }

	     
   	   if((food.getX()>=but.getX()-15&&food.getX()<=but.getX()+15)&&(food.getY()>=but.getY()-15&&food.getY()<=but.getY()+15))
		{

   		  int x=(int)((Math.random()*400)+100)/20*20;
		  int y=(int)((Math.random()*400)+100)/20*20;
		  food.setLocation(x, y);
		  temp=new JButton();
		  vc.addElement(temp);
		  Object o1=vc.get(vc.size()-1);
   		  JButton but1=(JButton)o1;
		  temp.setBounds(but1.getX(), but1.getY(), 20, 20);
		  p.add(temp); 
		  score=score+100;
		  fenshu.setText(score+"");
		  fenshu.setBounds(0,0,50,20);
		  p.add(fenshu);
			
		}
   	   if(but.getX()<=0||but.getY()<=0||but.getX()>=560||but.getY()>=540)
   	   {
   		   JOptionPane.showMessageDialog(null, "Game Over!!!");
   		   break;
   	   }
   	   for (int i = 3; i < vc.size()-1; i++) 
   	   {
   		  Object o1=vc.get(i);
 		  JButton but1=(JButton)o1;
 		  if(but1.getX()==but.getX()&&but1.getY()==but.getY())
 		  {
 			  a=1;
 			  break;
 		  }
	   }
   	   if(a==1)
   	   {
   		   JOptionPane.showMessageDialog(null, "Game Over!!!");
   		   break;
   	   }
   	      
   	      try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      }
		
	  
  }
}
