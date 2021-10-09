//package gameOnline;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.Random;
import java.util.List;
 
public class Game extends JFrame implements ActionListener{
    private static List<Icon> photo=new ArrayList<Icon>(); 
    Thread t1,t2,t3,t4,t5,t6;
    IconThread p1,p2,p3,p4,p5,p6;
    private JLabel j1,j2,j3;
    private JLabel k1,k2,k3;
    private JButton start;
    private JLabel result;
    static int playerSum;
    static int computerSum;
	public static void main(String[] args) {
		Game game=new Game(); 
		game.show();
}	
	//布置游戏UI界面
	@SuppressWarnings("deprecation")
	public void show()
	{
	    JFrame frame = new JFrame();
	    frame.setSize(800,920);
	    frame.setLocation(480, 220);
	    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    frame.setTitle("博饼游戏");
	    frame.getContentPane().setLayout(null);
		frame.setResizable(false);	
		String path="image\\tim.jpg";
		ImageIcon background=new ImageIcon(path);
		JLabel ground=new JLabel(background);
		ground.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		JPanel panel=(JPanel)frame.getContentPane();
		panel.setOpaque(false);
		frame.getLayeredPane().add(ground,new Integer(Integer.MIN_VALUE));		
		JButton player=new JButton("中秋博饼");
		player.setSize(100, 50);
		player.setLocation(335, 0);
		
		frame.getContentPane().add(player);			
        j1=new JLabel();
		j1.setIcon(new ImageIcon(("image\\1.jpg")));
		j1.setSize(196, 196);
		j1.setLocation(40, 45);
		frame.getContentPane().add(j1);				
		j2=new JLabel();
		j2.setIcon(new ImageIcon(("image\\1.jpg")));
		j2.setSize(196, 196);
		j2.setLocation(246, 45);
		frame.getContentPane().add(j2);		
		j3=new JLabel();
		j3.setIcon(new ImageIcon(("image\\1.jpg")));
		j3.setSize(196, 196);
		j3.setLocation(452, 45);
		frame.getContentPane().add(j3);		
		JButton player1=new JButton("大吉大利");
		player1.setSize(100, 50);
		player1.setLocation(335, 244);
		frame.getContentPane().add(player1);
		JButton res=new JButton("结果如下");
		res.setSize(100,50);
		res.setLocation(100,500);
		frame.getContentPane().add(res);		
		k1=new JLabel();
		k1.setIcon(new ImageIcon(("image\\6.jpg")));
		k1.setSize(196, 196);
		k1.setLocation(40, 300);
		frame.getContentPane().add(k1);		
		k2=new JLabel();
		k2.setIcon(new ImageIcon(("image\\6.jpg")));
		k2.setSize(196, 196);
		k2.setLocation(246, 300);
		frame.getContentPane().add(k2);		
		k3=new JLabel();
		k3.setIcon(new ImageIcon(("image\\6.jpg")));
		k3.setSize(196, 196);
		k3.setLocation(452, 300);
		frame.getContentPane().add(k3);		
		start = new JButton("摇骰子");
		start.setSize(90, 60);
		start.setLocation(305, 586);
	    start.addActionListener(this);
	    frame.getContentPane().add(start);	    
	    //
	    result = new JLabel();
		result.setSize(200, 100);
		result.setLocation(48, 555);
		//
	    frame.getContentPane().add(result); 	    
	    JButton help=new JButton("规则");
		help.setSize(90,60); 
		help.setLocation(396, 586);
	    frame.getContentPane().add(help);
	    JDialog dialog=new JDialog();
	    help.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		dialog.setModal(true);		
	    		JOptionPane.showMessageDialog(frame, "现在闽台地区流行的博饼名目与中国古代的科举科名基本一致，反映的是明清时期科举的情况。按照各级科举制度的头衔，设有状元1个，对堂（榜眼、探花）2个，三红（会魁）4个，四进（进士）8个，二举（举人）16个，一秀（秀才）32个。\r\n"
	    				+ "\r\n"
	    				+ "一秀：六个骰子中有一个点数是“4”\r\n"
	    				+ "\r\n"
	    				+ "二举：六个骰子中有两个点数是“4”\r\n"
	    				+ "\r\n"
	    				+ "四进：六个骰子中有四个点数是相同的，其余两个点数若都为“4”，则可多得一个二举，若一个为“4”则可多得一个一秀；\r\n"
	    				+ "\r\n"
	    				+ "三红：六个色子里面有三个点数是“4”\r\n"
	    				+ "\r\n"
	    				+ "榜眼（对堂）：六个骰子的点数刚好是顺子“123456”\r\n"
	    				+ "\r\n"
	    				+ "状元：六个骰子中有四个点数是“4”，两个是“1”为最高级，称作状元插金花，可以获得状元和未被博取的两个对堂奖品；\r\n"
	    				+ "\r\n"
	    				+ " 六个骰子全部的点数都为“4”，称作六杯红，就可以拿走所有的奖品，但是一般为了大家友好相处，得主一般只拿状元和两个对堂的奖品，可被追缴；\r\n"
	    				+ "\r\n"
	    				+ "   六个骰子全部的点数都是一样的，称作遍地锦，可被追缴；\r\n"
	    				+ "\r\n"
	    				+ "   六个骰子中有五个点数是“4”，称作五红，可被追缴；\r\n"
	    				+ "\r\n"
	    				+ "   六个骰子中有五个点数是一样的，除点数是“4”，称作五子登科，可被追缴；\r\n"
	    				+ "\r\n"
	    				+ "   六个骰子中有四个点数是“4”，称作“四点红”，可被追缴。\r\n"
	    				+ "","规则" ,JOptionPane.INFORMATION_MESSAGE);
	    	}
	    });
		frame.setVisible(true);
		//将骰子的六个点数添加到photo的位置
        photo.add(new ImageIcon(("image\\1.jpg")));
        photo.add(new ImageIcon(("image\\2.jpg")));
        photo.add(new ImageIcon(("image\\3.jpg")));
        photo.add(new ImageIcon(("image\\4.jpg")));
        photo.add(new ImageIcon(("image\\5.jpg")));
        photo.add(new ImageIcon(("image\\6.jpg")));
        thread();
	}
 
	@SuppressWarnings("deprecation")
	public class IconThread extends Observable implements Runnable {
		     JLabel lab;
		     Random random = new Random();
		     List<Icon> photo;
		     public IconThread(JLabel lab, List<Icon> photo) {
		         this.lab = lab;
		         this.photo = photo;		 
		     }		 	   
		     public void run() {         
		         int count = 10; //设置每颗骰子转动10次
		         while (count > 0) {
		             int dianshu = random.nextInt(6); //获取一个随机数[0~6)	            
		             lab.setIcon(photo.get(dianshu)); //从photo集合中取相应图片放入lab中
		             count--;
		             try {
		                 Thread.sleep(10);
		             } catch (InterruptedException e) {
		            	 e.printStackTrace();
		             }
		         }
		         this.setChanged();
		         this.notifyObservers();
		     }
		 }
	public void thread(){
        p1 = new IconThread(j1, photo);           
        p2 = new IconThread(j2, photo);         
        p3 = new IconThread(j3, photo); 
        p4 = new IconThread(k1, photo);
        p5 = new IconThread(k2, photo);
        p6 = new IconThread(k3, photo);     
       
	}
	//上面三个的点数
	public int playerResult(JLabel JL) {
    	Icon icon=JL.getIcon();
    	int playerSum=0;
    	for(int i=0;i<photo.size();i++) {
    		if(icon.equals(photo.get(i))) {
    			playerSum+=(i+1);
    			break;
    		}
    	}
    	return playerSum;
    }   
	//下面三个的点数
    public int computerResult(JLabel JL) {
    	Icon icon=JL.getIcon();
    	int computerSum=0;
    	for(int i=0;i<photo.size();i++) {
    		if(icon.equals(photo.get(i))) {
    			computerSum+=(i+1);
    			break;
    		}
    	}
    	return computerSum;
    }
    //对六个骰子得到的结果进行排序，方便后序分类讨论
public static void bubbleSort(int[] arr) {
		for(int i=0;i<arr.length-1;i++) {
			for(int j=0;j<arr.length-i-1;j++) {
				if(arr[j]>arr[j+1]) {
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
	}
   public void actionPerformed(ActionEvent ae) {
    	
	    thread();
	    t1 = new Thread(p1);              
        t2 = new Thread(p2);   
        t3 = new Thread(p3); 
        t4 = new Thread(p4);
        t5 = new Thread(p5);
        t6 = new Thread(p6);
    	t1.start();  
    	t2.start();
    	t3.start();
    	t4.start();
    	t5.start();
    	t6.start();
    	try {
    		t1.join();
    		t2.join();
    		t3.join();
    		t4.join();
    		t5.join();
    		t6.join();
    	}catch(InterruptedException e) {
    		e.printStackTrace();
    	}
    	//调用函数获得各图片点数
    	int x=playerResult(j1);
    	int y=playerResult(j2);
    	int z=playerResult(j3);
    	int u=computerResult(k1);
    	int v=computerResult(k2);
    	int w=computerResult(k3);

    	//给六个骰子赋予一个一到六的随机值
		/*
		 * 
		 * 
		 */
    	
    	int[] playerArr= {x,y,z,u,v,w};
		bubbleSort(playerArr);
		
    	try {
    		Thread.sleep(1000);
    	}catch(InterruptedException e) {
    		e.printStackTrace();
    	}
    	
    	if(x==1&&y==1&&z==1&&u==1&&v==1&&w==1) {
    		result.setIcon(new ImageIcon(("image\\zhuangyuan.jpg"))); 
    	}
    	else if(x==4&&y==4&&z==4&&u==4&&v==4&&w==4) {
    		result.setIcon(new ImageIcon(("image\\zhuangyuan.jpg"))); 
    	}
    	else if(x==2&&y==2&&z==2&&u==2&&v==2&&w==2) {
    		result.setIcon(new ImageIcon(("image\\zhuangyuan.jpg"))); 
    	}
    	
    	else if(playerArr[0]==1&&playerArr[1]==2&&playerArr[2]==3&&playerArr[3]==4&&playerArr[4]==5&&playerArr[5]==6) {
    		 result.setIcon(new ImageIcon(("image\\bangyan.jpg"))); 
    	}
    	
    	else if(playerArr[0]==1&&playerArr[1]==4&&playerArr[2]==4&&playerArr[3]==4&&playerArr[4]==4&&playerArr[5]==4) {
    		result.setIcon(new ImageIcon(("image\\zhuangyuan.jpg")));
    	}
    	else if(playerArr[0]==1&&playerArr[1]==1&&playerArr[2]==4&&playerArr[3]==4&&playerArr[4]==4&&playerArr[5]==4) {
    		result.setIcon(new ImageIcon(("image\\zhuangyuan.jpg")));
    	}
    	else if(playerArr[0]==2&&playerArr[1]==2&&playerArr[2]==2&&playerArr[3]==2&&playerArr[4]==2&&playerArr[5]!=2) {
    		result.setIcon(new ImageIcon(("image\\tanhua.jpg")));
    	}
    	else if(playerArr[0]!=2&&playerArr[1]==2&&playerArr[2]==2&&playerArr[3]==2&&playerArr[4]==2&&playerArr[5]==2) {
    		result.setIcon(new ImageIcon(("image\\tanhua.jpg")));
    	}
    	else if(playerArr[0]==2&&playerArr[1]==2&&playerArr[2]==2&&playerArr[3]==2&&playerArr[4]!=2&&playerArr[5]!=2) {
    		result.setIcon(new ImageIcon(("image\\tanhua.jpg")));
    	}
    	
    	else if(playerArr[0]==4&&playerArr[1]==4&&playerArr[2]==4&&playerArr[3]!=4&&playerArr[4]!=4&&playerArr[5]!=4) {
    		result.setIcon(new ImageIcon(("image\\jinshi.jpg")));
    	}
    	else if(playerArr[0]!=4&&playerArr[1]==4&&playerArr[2]!=4&&playerArr[3]==4&&playerArr[4]!=4&&playerArr[5]!=4) {
    		result.setIcon(new ImageIcon(("image\\jinshi.jpg")));
    	}
    	else if(playerArr[0]!=4&&playerArr[1]!=4&&playerArr[2]!=4&&playerArr[3]==4&&playerArr[4]==4&&playerArr[5]!=4) {
    		result.setIcon(new ImageIcon(("image\\jinshi.jpg")));
    	}
    	else if(playerArr[0]!=4&&playerArr[1]!=4&&playerArr[2]!=4&&playerArr[3]==4&&playerArr[4]==4&&playerArr[5]==4) {
    		result.setIcon(new ImageIcon(("image\\jinshi.jpg")));
    	}
    	
    	else if(playerArr[0]!=4&&playerArr[1]!=4&&playerArr[2]!=4&&playerArr[3]!=4&&playerArr[4]==4&&playerArr[5]==4) {
    		result.setIcon(new ImageIcon(("image\\juren.jpg")));
    	}
    	else if(playerArr[0]!=4&&playerArr[1]!=4&&playerArr[2]!=4&&playerArr[3]==4&&playerArr[4]==4&&playerArr[5]!=4) {
    		result.setIcon(new ImageIcon(("image\\juren.jpg")));
    	}
    	else if(playerArr[0]==4&&playerArr[1]==4&&playerArr[2]!=4&&playerArr[3]!=4&&playerArr[4]!=4&&playerArr[5]!=4) {
    		result.setIcon(new ImageIcon(("image\\juren.jpg")));
    	}
    	else if(playerArr[0]!=4&&playerArr[1]==4&&playerArr[2]==4&&playerArr[3]!=4&&playerArr[4]!=4&&playerArr[5]!=4) {
    		result.setIcon(new ImageIcon(("image\\juren.jpg")));
    	}
    	else if(playerArr[0]!=4&&playerArr[1]!=4&&playerArr[2]==4&&playerArr[3]==4&&playerArr[4]!=4&&playerArr[5]!=4) {
    		result.setIcon(new ImageIcon(("image\\juren.jpg")));
    	}
    	
    	else if(x==4||y==4||z==4||u==4||v==4||w==4) {
    		result.setIcon(new ImageIcon(("image\\xiucai.jpg"))); 
    	}
    	
    	
    }
    
}	
        
 
