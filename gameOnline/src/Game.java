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
	//������ϷUI����
	@SuppressWarnings("deprecation")
	public void show()
	{
	    JFrame frame = new JFrame();
	    frame.setSize(800,920);
	    frame.setLocation(480, 220);
	    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    frame.setTitle("������Ϸ");
	    frame.getContentPane().setLayout(null);
		frame.setResizable(false);	
		String path="image\\tim.jpg";
		ImageIcon background=new ImageIcon(path);
		JLabel ground=new JLabel(background);
		ground.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		JPanel panel=(JPanel)frame.getContentPane();
		panel.setOpaque(false);
		frame.getLayeredPane().add(ground,new Integer(Integer.MIN_VALUE));		
		JButton player=new JButton("���ﲩ��");
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
		JButton player1=new JButton("�󼪴���");
		player1.setSize(100, 50);
		player1.setLocation(335, 244);
		frame.getContentPane().add(player1);
		JButton res=new JButton("�������");
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
		start = new JButton("ҡ����");
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
	    JButton help=new JButton("����");
		help.setSize(90,60); 
		help.setLocation(396, 586);
	    frame.getContentPane().add(help);
	    JDialog dialog=new JDialog();
	    help.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		dialog.setModal(true);		
	    		JOptionPane.showMessageDialog(frame, "������̨�������еĲ�����Ŀ���й��Ŵ��Ŀƾٿ�������һ�£���ӳ��������ʱ�ڿƾٵ���������ո����ƾ��ƶȵ�ͷ�Σ�����״Ԫ1�������ã����ۡ�̽����2�������죨�����4�����Ľ�����ʿ��8�������٣����ˣ�16����һ�㣨��ţ�32����\r\n"
	    				+ "\r\n"
	    				+ "һ�㣺������������һ�������ǡ�4��\r\n"
	    				+ "\r\n"
	    				+ "���٣����������������������ǡ�4��\r\n"
	    				+ "\r\n"
	    				+ "�Ľ����������������ĸ���������ͬ�ģ�����������������Ϊ��4������ɶ��һ�����٣���һ��Ϊ��4����ɶ��һ��һ�㣻\r\n"
	    				+ "\r\n"
	    				+ "���죺����ɫ�����������������ǡ�4��\r\n"
	    				+ "\r\n"
	    				+ "���ۣ����ã����������ӵĵ����պ���˳�ӡ�123456��\r\n"
	    				+ "\r\n"
	    				+ "״Ԫ���������������ĸ������ǡ�4���������ǡ�1��Ϊ��߼�������״Ԫ��𻨣����Ի��״Ԫ��δ����ȡ���������ý�Ʒ��\r\n"
	    				+ "\r\n"
	    				+ " ��������ȫ���ĵ�����Ϊ��4�������������죬�Ϳ����������еĽ�Ʒ������һ��Ϊ�˴���Ѻ��ദ������һ��ֻ��״Ԫ���������õĽ�Ʒ���ɱ�׷�ɣ�\r\n"
	    				+ "\r\n"
	    				+ "   ��������ȫ���ĵ�������һ���ģ�������ؽ����ɱ�׷�ɣ�\r\n"
	    				+ "\r\n"
	    				+ "   ��������������������ǡ�4����������죬�ɱ�׷�ɣ�\r\n"
	    				+ "\r\n"
	    				+ "   ���������������������һ���ģ��������ǡ�4�����������ӵǿƣ��ɱ�׷�ɣ�\r\n"
	    				+ "\r\n"
	    				+ "   �������������ĸ������ǡ�4�����������ĵ�족���ɱ�׷�ɡ�\r\n"
	    				+ "","����" ,JOptionPane.INFORMATION_MESSAGE);
	    	}
	    });
		frame.setVisible(true);
		//�����ӵ�����������ӵ�photo��λ��
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
		         int count = 10; //����ÿ������ת��10��
		         while (count > 0) {
		             int dianshu = random.nextInt(6); //��ȡһ�������[0~6)	            
		             lab.setIcon(photo.get(dianshu)); //��photo������ȡ��ӦͼƬ����lab��
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
	//���������ĵ���
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
	//���������ĵ���
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
    //���������ӵõ��Ľ���������򣬷�������������
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
    	//���ú�����ø�ͼƬ����
    	int x=playerResult(j1);
    	int y=playerResult(j2);
    	int z=playerResult(j3);
    	int u=computerResult(k1);
    	int v=computerResult(k2);
    	int w=computerResult(k3);

    	//���������Ӹ���һ��һ���������ֵ
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
        
 
