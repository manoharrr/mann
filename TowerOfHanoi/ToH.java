import java.awt.*;
import java.awt.event.*;


public class ToH extends Frame implements ActionListener
{ 
	     Button b[] = new Button[100];
	     Button s = new Button("Solve");
		 TextField t = new TextField(5);
		 Label l = new Label("Enter Number Of Disks(<10):",Label.CENTER);
	     int h[] = new int[4];
	     int pos[] = new int[4];
	     int i,k[] = new int[50];
	     int x[] = new int[4];
	     int yc;
	     int n,xc[]=new int[50];
    public ToH() 
    {    	  	 
    	  	 n = 5;
        	 yc = 100;
       		 xc[0] = 100;
       		 for(int f=1;f<50;f++)
       		 	xc[f] = xc[f-1] - 20;
       
	    	try
	    	{
		    	setLayout(null);
		        k[1]=500;
		                  
		         t.setBounds(400,400,100,25);
		         s.setBounds(510,400,50,25);
		         l.setBounds(100,400,290,25);
		         add(l);
		         add(s);
		         add(t);
		         
		         s.addActionListener(this);
		                     
		         b[0] = new Button(""+0);
		         b[0].setBounds(xc[0], yc, 50, 20);
	         
	        }
	        catch(Exception e)
	        {
	            
	        }
	        setSize(1000,500);
	        setTitle("Tower Of Hanoi");
	        setVisible(true);
        
	          addWindowListener(   
	      new java.awt.event.WindowAdapter()   
	      {  
	        public void windowClosing( java.awt.event.WindowEvent e )   
	        {  
	          System.exit( 0 );  
	        }  
	      }  
	    );  
    }
    
    public void create()
    {
    	for(i=1;i<=n;i++)
        {
            k[i] = k[i-1] - 10;
            xc[i] = (300+20+2*k[i])/2;
            b[i] = new Button(""+i);
            b[i].setBackground(Color.red);
            //b[i].setBounds((300+20+2*k[i])/2, b[i-1].getY()+20, 20-2*k[i], 20);
            b[i].setBounds(xc[i], b[i-1].getY()+20, 50-2*k[i], 20);
            add(b[i]);
        }
    }
    
    
    public void actionPerformed(ActionEvent e) 
    {
    	try{
		    	if(e.getActionCommand().equals("Solve"))
		    	{
		    	
		    		  n = Integer.parseInt(t.getText());
		    		 x[1] = 000;
		         	 x[2] = 300;
		        	 x[3] = 600;
			    	 h[1] = 0;
			         h[2] = h[3] = (n)*20;
		    		
		    	     create();
		    		 tower(n,1,2,3);
		    		 Thread.sleep(5000);
		    		 for(i=0;i<=n;i++)
		    		 	this.remove(b[i]);
		    	}
    		
    	}
    	catch(Exception f){   	}
    }
    
   
    
    public static void main(String[] args) 
    {
    	ToH a = new ToH();
    }
    public void tower(int top,int source,int inter,int destin) throws InterruptedException
    {
         if (top == 1)
         {
     		// System.out.println("Disk 1 source " + source + " to " + destin);
     		
    	Thread.sleep(1000);

     		b[top].setLocation(xc[top]+x[destin],yc+h[destin]);
     		h[destin]-=20;
     		h[source]+=20;
    	}
    else
     {
      tower(top - 1, source, destin, inter);
      
    	Thread.sleep(1000);

      	b[top].setLocation(xc[top]+x[destin],yc+h[destin]);
      	h[destin]-=20;
     	h[source]+=20;
      tower(top - 1, inter, source, destin);
    }
  
    }
    
   
}
