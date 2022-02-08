/****************************************************************/
/*                      Source	                            */
/*                                                              */
/****************************************************************/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.net.*;
/**
 * Summary description for Source
 *
 */
public class Source extends JFrame
{
	// Variables declaration
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JTextField jTextField1;
	private JComboBox jComboBox1;
	private JTextArea jTextArea1;
	private JScrollPane jScrollPane1;
	private JButton jButton1;
	private JButton jButton2;
	private JButton jButton3;
	private JPanel contentPane;
	String msg="";
	int flag=1;
	int flag1=1;
	Socket n1_client;
	String destination;
	int limit;
	String a[]={"Select","R-101","R-102","R-103","I-104"};
	int len;
	int packets;
	int rem;
	// End of variables declaration


	public Source()
	{
		super();
		initializeComponent();
		//
		// TODO: Add any constructor code after initializeComponent call
		//

		this.setVisible(true);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always regenerated
	 * by the Windows Form Designer. Otherwise, retrieving design might not work properly.
	 * Tip: If you must revise this method, please backup this GUI file for JFrameBuilder
	 * to retrieve your design properly in future, before revising this method.
	 */
	private void initializeComponent()
	{
		jLabel1 = new JLabel();
		jLabel2 = new JLabel();
		jLabel3 = new JLabel();
		jTextField1 = new JTextField();
		jComboBox1 = new JComboBox(a);
		jTextArea1 = new JTextArea();
		jScrollPane1 = new JScrollPane();
		jButton1 = new JButton();
		jButton2 = new JButton();
		jButton3 = new JButton();
		contentPane = (JPanel)this.getContentPane();

		//
		// jLabel1
		//
		jLabel1.setText("INTRUSION DETECTION");
		//
		// jLabel2
		//
		jLabel2.setText("Port No");
		//
		// jLabel3
		//
		jLabel3.setText("Status Information");
		//
		// jTextField1
		//
		jTextField1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jTextField1_actionPerformed(e);
			}

		});
		//
		// jComboBox1
		//
		jComboBox1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jComboBox1_actionPerformed(e);
			}

		});
		//
		// jTextArea1
		//
		//
		// jScrollPane1
		//
		jScrollPane1.setViewportView(jTextArea1);
		//
		// jButton1
		//
		jButton1.setBackground(new Color(255, 255, 255));
		jButton1.setText("Browse");
		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jButton1_actionPerformed(e);
			}

		});
		//
		// jButton2
		//
		jButton2.setBackground(new Color(255, 255, 255));
		jButton2.setText("Send");
		jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jButton2_actionPerformed(e);
			}

		});
		//
		// jButton3
		//
		jButton3.setBackground(new Color(255, 255, 255));
		jButton3.setText("Exit");
		jButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jButton3_actionPerformed(e);
			}

		});
		//
		// contentPane
		//
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(153, 204,255));
		addComponent(contentPane, jLabel1, 158,14,136,28);
		addComponent(contentPane, jLabel2, 21,149,60,18);
		addComponent(contentPane, jLabel3, 294,97,118,23);
		addComponent(contentPane, jTextField1, 41,60,252,22);
		addComponent(contentPane, jComboBox1, 103,147,100,22);
		addComponent(contentPane, jScrollPane1, 246,115,195,246);
		addComponent(contentPane, jButton1, 317,58,83,28);
		addComponent(contentPane, jButton2, 7,293,83,28);
		addComponent(contentPane, jButton3, 141,292,83,28);
		//
		// Source
		//
		this.setTitle("Source - extends JFrame");
		this.setLocation(new Point(66, 48));
		this.setSize(new Dimension(483, 435));
	}

	/** Add Component Without a Layout Manager (Absolute Positioning) */
	private void addComponent(Container container,Component c,int x,int y,int width,int height)
	{
		c.setBounds(x,y,width,height);
		container.add(c);
	}

	//
	// TODO: Add any appropriate code in the following Event Handling Methods
	//
	private void jTextField1_actionPerformed(ActionEvent e)
	{
		System.out.println("\njTextField1_actionPerformed(ActionEvent e) called.");
		// TODO: Add any handling code here

	}

	private void jComboBox1_actionPerformed(ActionEvent e)
	{
		System.out.println("\njComboBox1_actionPerformed(ActionEvent e) called.");
		Object o = jComboBox1.getSelectedItem();
		destination=""+o;
		flag=0;
		
	}

	private void jButton1_actionPerformed(ActionEvent e)
	{
		System.out.println("\njButton1_actionPerformed(ActionEvent e) called.");
		// TODO: Add any handling code here
		try
		{
			int b;
			msg="";
				FileDialog fd=new FileDialog(this,"Open",FileDialog.LOAD);
				fd.show();
				FileInputStream fos=new FileInputStream(fd.getDirectory()+fd.getFile());
				jTextField1.setText(fd.getDirectory()+fd.getFile());
				while((b=fos.read())!=-1)
				{
					msg+=(char)b;
				}
			
			flag1=0;
			int len=msg.length();
			int packets=len/48;
			int rem=len%48;
			packets++;
        String source=jTextField1.getText();
        jTextArea1.append("\n\nSource Address::"+source+"\n\n");
        jTextArea1.append("Selected File Path "+fd.getDirectory()+fd.getFile()+"\n\n");
        jTextArea1.append("Total Length::"+len+"\n\n");
        
      	}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}

	}

	private void jButton2_actionPerformed(ActionEvent e)
	{
		System.out.println("\njButton2_actionPerformed(ActionEvent e) called.");
		// TODO: Add any handling code here
		String dest;
		if(flag==0)
		{
			if(destination.equalsIgnoreCase(a[0]))
			{
				JOptionPane.showMessageDialog(null,"Select the Destination!..");
			}
			else if(destination.equalsIgnoreCase(a[1]))
			{
				JOptionPane.showMessageDialog(null,"This Is From R-101");
				dest=setDest(a[1]);
				sendData("localhost",111,dest);

			}
			else if(destination.equalsIgnoreCase(a[2]))
			{
				JOptionPane.showMessageDialog(null,"This Is From R-102");
				dest=setDest(a[2]);
				sendData("localhost",111,dest);
			}
			else if(destination.equalsIgnoreCase(a[3]))
			{
				JOptionPane.showMessageDialog(null,"This Is From R-103");
				dest=setDest(a[3]);
				sendData("localhost",111,dest);

			}
			else if(destination.equalsIgnoreCase(a[4]))
			{
				JOptionPane.showMessageDialog(null,"This Is From I-104");
				dest=setDest(a[4]);
				sendData("localhost",111,dest);
			}
		}
		else
		JOptionPane.showMessageDialog(null,"Load the File OR Select the Destination!..");
		

	}

	private void jButton3_actionPerformed(ActionEvent e)
	{
		System.out.println("\njButton3_actionPerformed(ActionEvent e) called.");
		// TODO: Add any handling code here

	}

	//
	// TODO: Add any method code to meet your needs in the following area
	//

public void sendData(String name,int port,String dest)
	{
		try
		{

			n1_client=new Socket(name,port);
			DataOutputStream out=new DataOutputStream(n1_client.getOutputStream());
			
			if(out!=null)
			{
					out.flush();
			}
					int outgoing=0;
					byte buffer[]=msg.getBytes();
					int len=buffer.length;
					int tlength=buffer.length/48;
					int length11=buffer.length%48;
					int len1=len;
				if(length11!=0)
				{
					tlength++;
				}
				out.writeInt(tlength);
				out.writeUTF(destination);
				int st=0;
				int end=48;
           		jTextArea1.append("Packet Length:    "+len+"\n");
								
			if(len<=48)
			 {

					
					 out.writeUTF(dest+msg);
					 jTextArea1.append("Packet: "+"\t"+(++outgoing)+"\t"+msg+"\n");		

			 }
			 else
			  {
				
					jTextArea1.append("Packet: "+"\t"+(++outgoing)+"\t"+msg.substring(st,end)+"\n");
					out.writeUTF(dest+msg.substring(st,end));
							
						
				  while(len1>48)
				  {
					 len1-=48;
					 if(len1<=48)
					  {
					
					 jTextArea1.append("Packet: "+"\t"+(++outgoing)+"\t"+msg.substring(end,len)+"\n");
					 out.writeUTF(dest+msg.substring(end,len));
					 		
  					 	
					  }
					  else
					  {
							
							int sp=end+48;
							jTextArea1.append("Packet: "+"\t"+(++outgoing)+"\t"+msg.substring(end,sp)+"\n");
							out.writeUTF(dest+msg.substring(end,sp));
							end=sp;
						
					  }
				  }
			   }
		}
		catch (Exception exp)
		{
			exp.printStackTrace();
		}
	
	
	
	}
	public String setDest(String Destname)
	{
		String Destinationname="";
		if(Destname.equalsIgnoreCase(a[1]))
		{
			Destinationname="Source-->D1";
		}
		else if(Destname.equalsIgnoreCase(a[2]))
		{
			Destinationname="Source-->D2";
		}
		else if(Destname.equalsIgnoreCase(a[3]))
		{
			Destinationname="Source-->D3";
		}
		else if (Destname.equalsIgnoreCase(a[4]))
		{
			Destinationname="Source-->D4";
		}
		return Destinationname;
		
	}




























 

//============================= Testing ================================//
//=                                                                    =//
//= The following main method is just for testing this class you built.=//
//= After testing,you may simply delete it.                            =//
//======================================================================//
	public static void main(String[] args)
	{
		
		new Source();
	}
//= End of Testing =


}
