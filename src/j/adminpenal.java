package j;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import main.MainControl;

public class adminpenal extends JPanel implements ActionListener
{
	/**
	 *  
	 */
	private static final long serialVersionUID = -2835957135373636255L;
	final static int w = 800;
	final static int h = 800;
	Image admin = new ImageIcon("admin.png").getImage();
	static Bframe f;
	JMenuBar mb;
	
	public static ArrayList<String> inputword = new ArrayList<>();  
	JMenu jop1,jop2,jop3,jop4;
	JMenuItem[] dialog1,dialog2,dialog3,dialog4;
	String[] s = {	"添加課程", "刪除課程","設置課程教師","顯示課程列表","按人數排序",
					"添加教師", "刪除教師","查看教師所授課程", "顯示教師列表", "教師密碼恢復",
					"添加學生", "刪除學生","查看學生列表", "學生密碼恢復",
					"修改管理員密碼","修改管理員名稱","退出"};
	public void s() {
		inputword.add("管理員系統");
		inputword.add("管理課程:");
		inputword.add("讓你能新增或刪除課程，查看課程列表。");
		inputword.add("");
		
		inputword.add("管理教師:");
		inputword.add("讓你能新增、刪除課程，和看當學期");
		inputword.add("開那些課。");
		inputword.add("");
		inputword.add("管理學生:");
		inputword.add("可以增加或減少，查看所選課程。");
		inputword.add("");
		inputword.add("管理員設定:");
		inputword.add("可以修改名稱和密碼或退出。");
	}
	
	public void open() {	
		
		s();
		f = new Bframe();
		this.setPreferredSize(new Dimension(w,h));
		f.add(this);
		mb=new JMenuBar();
		
		jop1=new JMenu("管理課程");
	    dialog1=new JMenuItem[5];
	    for (int i=0; i<dialog1.length; i++) {
	    	dialog1[i]=new JMenuItem(s[i]);
	    	jop1.add(dialog1[i]);
	        dialog1[i].addActionListener(this);
	    }
	    mb.add(jop1);
	    
	    jop2=new JMenu("管理教師");
	    dialog2=new JMenuItem[5];
	    for (int i=0; i<dialog2.length; i++) {
	    	dialog2[i]=new JMenuItem(s[i+5]);
	    	jop2.add(dialog2[i]);
	        dialog2[i].addActionListener(this);
	    }
	    mb.add(jop2);
	    
	    jop3=new JMenu("管理學生");
	    dialog3=new JMenuItem[4];
	    for (int i=0; i<dialog3.length; i++) {
	    	dialog3[i]=new JMenuItem(s[i+10]);
	    	jop3.add(dialog3[i]);
	        dialog3[i].addActionListener(this);
	    }
	    mb.add(jop3);

	    jop4=new JMenu("管理員設定");
	    dialog4=new JMenuItem[3];
	    for (int i=0; i<dialog4.length; i++) {
	    	dialog4[i]=new JMenuItem(s[i+14]);
	    	jop4.add(dialog4[i]);
	        dialog4[i].addActionListener(this);
	    }
	    mb.add(jop4);
	    
	    f.setJMenuBar(mb);
	    
	    
	    
	    f.pack();
		f.setLocationRelativeTo(null);
	}
	
	public static void close(){
		f.dispose();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e)
	{		
		int i = 0;
		while(e.getActionCommand()!=s[i]) i++;
		if(i==16) {				
			adminpenal.close();
			MainControl.menu();
		}
		user.User.funcDistribute(i);
		repaint();
	}
	@Override
    protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		Graphics2D g = (Graphics2D)graphics;
			
		g.setFont(new Font("Meet Tenorite",Font.LAYOUT_LEFT_TO_RIGHT,16));
		for(int i =0;i<inputword.size();i++)
			g.drawString(inputword.get(i),480,16+i*16);
			g.setPaint(Color.BLUE);
		
		
        g.drawImage(admin,-55,0,w,h, this); // see javadoc for more info on the parameters            
    }
	
}

	
