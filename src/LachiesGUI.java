import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.CheckboxMenuItem;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.SocketException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *
 *
 * @author STEVLACH
 */
public class LachiesGUI extends javax.swing.JFrame implements ConnectionListener{
    /**
     * Creates new form LachiesGUI
     */
    public LachiesGUI() {
        initComponents();
        
    }
    
    public static void TrayIcon(){
    	if (!SystemTray.isSupported()) {
            System.out.println("SystemTray is not supported");
            return;
        }
        final PopupMenu popup = new PopupMenu();
        final TrayIcon trayIcon =
        		new TrayIcon(createImage("trayicon.png", "tray icon"));
        final SystemTray tray = SystemTray.getSystemTray();
        trayIcon.setImageAutoSize(true);
        trayIcon.setToolTip("Lan Messenger :D");
        // Create a popup menu components
        MenuItem showGUI = new MenuItem("Lan Messenger");
        MenuItem aboutItem = new MenuItem("About");
        CheckboxMenuItem cb1 = new CheckboxMenuItem("Set auto size");
        CheckboxMenuItem cb2 = new CheckboxMenuItem("Set tooltip");
        Menu displayMenu = new Menu("Display");
        MenuItem errorItem = new MenuItem("Error");
        MenuItem warningItem = new MenuItem("Warning");
        MenuItem infoItem = new MenuItem("Info");
        MenuItem noneItem = new MenuItem("None");
        MenuItem exitItem = new MenuItem("Exit");
         
        //Add components to popup menu
        //popup.addSeparator();
        popup.add(showGUI);
        popup.addSeparator();
        popup.add(aboutItem);
        popup.addSeparator();
        popup.add(exitItem);
        //popup.add(cb1);
        //popup.add(cb2);
        //popup.add(displayMenu);
        //displayMenu.add(errorItem);
        //displayMenu.add(warningItem);
        //displayMenu.add(infoItem);
        //displayMenu.add(noneItem);
        
         
        trayIcon.setPopupMenu(popup);
         
        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            System.out.println("TrayIcon could not be added.");
            return;
        }
         
        trayIcon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	// Do nothing
                        
            }
        });
         
        aboutItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,
                        "By Lachlan Stevens © 2014 ©");
            }
        });
         
        cb1.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                int cb1Id = e.getStateChange();
                if (cb1Id == ItemEvent.SELECTED){
                    trayIcon.setImageAutoSize(true);
                } else {
                    trayIcon.setImageAutoSize(false);
                }
            }
        });
         
        cb2.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                int cb2Id = e.getStateChange();
                if (cb2Id == ItemEvent.SELECTED){
                    trayIcon.setToolTip("Sun TrayIcon");
                } else {
                    trayIcon.setToolTip(null);
                }
            }
        });
         
        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MenuItem item = (MenuItem)e.getSource();
                //TrayIcon.MessageType type = null;
                System.out.println(item.getLabel());
                if ("Error".equals(item.getLabel())) {
                    //type = TrayIcon.MessageType.ERROR;
                    trayIcon.displayMessage("Sun TrayIcon Demo",
                            "This is an error message", TrayIcon.MessageType.ERROR);
                     
                } else if ("Warning".equals(item.getLabel())) {
                    //type = TrayIcon.MessageType.WARNING;
                    trayIcon.displayMessage("Sun TrayIcon Demo",
                            "This is a warning message", TrayIcon.MessageType.WARNING);
                     
                } else if ("Info".equals(item.getLabel())) {
                    //type = TrayIcon.MessageType.INFO;
                    trayIcon.displayMessage("Sun TrayIcon Demo",
                            "This is an info message", TrayIcon.MessageType.INFO);
                     
                } else if ("None".equals(item.getLabel())) {
                    //type = TrayIcon.MessageType.NONE;
                    trayIcon.displayMessage("Sun TrayIcon Demo",
                            "This is an ordinary message", TrayIcon.MessageType.NONE);
                }
            }
        };
         
        errorItem.addActionListener(listener);
        warningItem.addActionListener(listener);
        infoItem.addActionListener(listener);
        noneItem.addActionListener(listener);
         
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tray.remove(trayIcon);
                //System.exit(0);
            }
        });
    }
    protected static Image createImage(String path, String description) {
        URL imageURL = LachiesGUI.class.getResource(path);
         
        if (imageURL == null) {
            System.err.println("Resource not found: " + path);
            return null;
        } else {
            return (new ImageIcon(imageURL, description)).getImage();
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    DefaultListModel<String> model;
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
    	
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        
        model = new DefaultListModel<>();
        jList1 = new javax.swing.JList(model);
        jScrollPane3 = new javax.swing.JScrollPane(jList1);
        jSeparator3 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        jComboBox1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Available", "Busy", "Away", "Invisible" }));

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        String UserName = System.getProperty("user.name");
        UserName = UserName.toUpperCase();
        //jLabel12.setColumns(20);
        jLabel12.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        //jLabel12.setRows(1);
        jLabel12.setToolTipText("");
        jScrollPane2.setViewportView(jLabel12);
        jScrollPane2.setBorder(null);
        jLabel12.getAccessibleContext().setAccessibleName("NickName");
        //jLabel12.setText(UserName);
        try {
    		Properties prop = new Properties();
			//load a properties file
    		prop.load(new FileInputStream("c:\\users\\" + System.getProperty("user.name") + "\\config.properties"));
 
               //get the property value and print it out
                System.out.println(prop.getProperty("currentnickname"));
                String jlabeltext = prop.getProperty("currentnickname");
                jLabel12.setText(jlabeltext);
    	} catch (IOException ex) {
    		Properties prop = new Properties();
        	 
        	try {
        		//set the properties value
        		prop.setProperty("currentnickname", System.getProperty("user.name"));
     
        		//save properties to project root folder
        		prop.store(new FileOutputStream("c:\\users\\" + System.getProperty("user.name") + "\\config.properties"), null);
     
        	} catch (IOException ex1) {
        		ex1.printStackTrace();
            }
    	}
        jLabel12.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                //JList list = (JList)evt.getSource();
                if (evt.getClickCount() >= 2) {
                	String[] buttons = { "Ok" }; 
            		URL URL = MessengerAdmin.class.getResource("iron_man.png");
                	ImageIcon icon = new ImageIcon(URL, "MessageBox Icon");
                	
                	Object outputline = JOptionPane.showInputDialog (null, "Please enter new Nickname: ", "Nickname", JOptionPane.PLAIN_MESSAGE, icon, null, null);
                	
                	String username = (String)outputline;
                	if(username.length() > 15){
                	username = username.substring(0, 15);
                	}
                	if (username.equals(null) || username.equals("")){
                		username = System.getProperty("user.name");
                		username = username.toUpperCase();
                	}
                	Properties prop = new Properties();
                	 
                	try {
                		//set the properties value
                		prop.setProperty("currentnickname", username);
             
                		//save properties to project root folder
                		prop.store(new FileOutputStream("c:\\users\\" + System.getProperty("user.name") + "\\config.properties"), null);
             
                	} catch (IOException ex) {
                		ex.printStackTrace();
                    }
                	jLabel12.setText(username);
                }
            }
        });
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        InetAddress ip = null;
		try {
			ip = InetAddress.getLocalHost();
		} catch (UnknownHostException e2) {
			e2.printStackTrace();
		}
		String stringip = ip.toString();
		String backslash = "\\";
		String[] finalip = stringip.split("/");
        //jLabel13.setColumns(20);
        jLabel13.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        //jLabel13.setRows(1);
        jLabel13.setToolTipText("");
        jLabel13.setText(finalip[1]);
        jScrollPane1.setViewportView(jLabel13);
        jScrollPane1.setBorder(null);
        jLabel13.getAccessibleContext().setAccessibleName("Status");

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Contacts");
        jLabel1.setToolTipText("");

        jList1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
      
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList1.setToolTipText("");
        jList1.setAlignmentX(2.0F);
        jList1.setAlignmentY(2.0F);
        jList1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jList1.setFixedCellHeight(100);
        jList1.setFixedCellWidth(100);
        jList1.setVisibleRowCount(5);
        EventPane eventPane = new EventPane();
        eventPane.addConnectionListener(this);
        add(eventPane, BorderLayout.SOUTH);
        //model.addElement("test123");
        
        jList1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList)evt.getSource();
                if (evt.getClickCount() >= 2) {
                	MessengerAdmin msgadmin = new MessengerAdmin();
                	String currentselection = (String) list.getSelectedValue();
                	
						try {
							//currentselection = currentselection.substring(59);
							String args[] = currentselection.split("<p>&#32|</p>|12px>|\\(|\\n");
							args[2] = args[2].replace(")", "");
							
							/*Nickame = args[1]
							UserName = args[2]
							Computername = args[4]*/
							String localhost = InetAddress.getLocalHost().toString();
							localhost = localhost.substring(0, 14);
							Properties prop = new Properties();
							//load a properties file
				    		prop.load(new FileInputStream("c:\\users\\" + System.getProperty("user.name") + "\\config.properties"));
				 
				               //get the property value and print it out
				                System.out.println(prop.getProperty("currentnickname"));
				                String currentnickname1 = prop.getProperty("currentnickname");
							String usernickname = currentnickname1 + "( " + System.getProperty("user.name") + " )";
							
							MessengerAdmin.reply(args[4], usernickname);
						} catch (UnknownHostException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
                    System.out.println(list.getSelectedValue());
                //} else if (evt.getClickCount() == 3) {   // Triple-click
                    //int index = list.locationToIndex(evt.getPoint());
                    
                    try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                    
                }
            }
        });
        
        //((DefaultComboBoxModel) jList1).addElement("test123");
        //jList1.setCellRenderer(new BookCellRenderer());
        jScrollPane3.setViewportView(jList1);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("© Lachlan Stevens 2014 © || ® Stark Industries ®");

        jMenuBar1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jMenu4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenu4.setLabel("Availability");

        jMenuItem1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem1.setText("Available");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem1);

        jMenuItem2.setText("Busy");
        jMenu4.add(jMenuItem2);

        jMenuItem3.setText("Away");
        jMenu4.add(jMenuItem3);

        jMenuItem4.setText("Invisible");
        jMenu4.add(jMenuItem4);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Settings");
        jMenuBar1.add(jMenu5);

        jMenu1.setText("About");

        jMenuItem5.setText("Messenger Info");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	JOptionPane.showMessageDialog(null,
                        "By Lachlan Stevens © 2014 ©");
            			//jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator3)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane3))
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addGap(30, 30, 30))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                            .addComponent(jLabel1))
                        .addGap(10, 10, 10)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap())
        );

        jLabel2.getAccessibleContext().setAccessibleName("ProfilePicture");


        pack();
    }// </editor-fold>        
    public static String returnnickname(String j){
		return j;
    	//return jLabel12.getText();
    }
    public void add(String computer, String person){
    	//person = person.toUpperCase();
    	String[] nicknames = person.split(":");
    	String username = nicknames[0];
    	username = username.toUpperCase();
    	String nickname = nicknames[1];
    	if (model.contains("<html><body><p style=font-size:12px>" + nickname + " (" + username + ") " + "</p><br><p>&#32" + computer + "</p></body></html>")){
			System.out.println("Duplicate not adding");
		} else {
		System.out.println("in run");
		model.addElement("<html><body><p style=font-size:12px>" + nickname + " (" + username + ") " + "</p><br><p>&#32" + computer + "</p></body></html>");
		System.out.println("out of run");
		
		
		}
    }
    public void remove(){
    	System.out.println("removing everything");
    	model.removeAllElements();
    }
    private void textUsernameActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    private void textIp3ActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

    private void textSearchActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void textStatusActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    //javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            		
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LachiesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LachiesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LachiesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LachiesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        InetAddress HostName = null;
        Socket Socket = null;
		try {
			HostName = InetAddress.getLocalHost();
			int PortNumber = 44455;
			Socket = new Socket(HostName, PortNumber);
			PrintWriter out = new PrintWriter(Socket.getOutputStream(), true);
			out.println("New Process Spawned");
			out.println("New Process Spawned");
	        out.println("New Process Spawned");
		} catch (IOException e) {
			// Do nothing
	
		
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LachiesGUI().setVisible(true);
            }
        });
        new Thread("Client"){
        	public void run(){
        		MessageClient msgclient = new MessageClient();
        	}
        }.start();
        new Thread("TrayIcon"){
        	public void run(){
        		TrayIcon();
        	}
        }.start();
        new Thread("BroadcastTimer"){
	        public void run(){
	        	while(true){
					try{
						DatagramSocket c = new DatagramSocket();
						c.setBroadcast(true);
						String currentnickname = " ";
						 
				    	try {
				    		Properties prop = new Properties();
							//load a properties file
				    		prop.load(new FileInputStream("c:\\users\\" + System.getProperty("user.name") + "\\config.properties"));
				 
				               //get the property value and print it out
				                System.out.println(prop.getProperty("currentnickname"));
				                currentnickname = prop.getProperty("currentnickname");
				 
				    	} catch (IOException ex) {
				    		Properties prop = new Properties();
		                	 
		                	try {
		                		//set the properties value
		                		prop.setProperty("currentnickname", System.getProperty("user.name"));
		             
		                		//save properties to project root folder
		                		prop.store(new FileOutputStream("c:\\users\\" + System.getProperty("user.name") + "\\config.properties"), null);
		             
		                	} catch (IOException ex1) {
		                		ex1.printStackTrace();
		                    }
				        }
						String currentuser = System.getProperty("user.name") + ":" + currentnickname;
						byte[] sendData = currentuser.getBytes();
						DatagramPacket sendPacket = new DatagramPacket (sendData,sendData.length, InetAddress.getByName("255.255.255.255"), 8888);
						c.send(sendPacket);
						System.out.println("Send Packet to " + sendPacket.getAddress().getHostName());
						System.out.println("Broadcasting to entire network");
						Enumeration interfaces = NetworkInterface.getNetworkInterfaces();
						while(interfaces.hasMoreElements()){
							NetworkInterface networkInterface = (NetworkInterface) interfaces.nextElement();
							if(networkInterface.isLoopback() || !networkInterface.isUp()){
								continue;
							}
							for (InterfaceAddress interfaceAddress : networkInterface.getInterfaceAddresses()){
								InetAddress broadcast = interfaceAddress.getBroadcast();
								if(broadcast == null){
									continue;
								}
								
								System.out.println("Sending broadcast Packet");
								try {
									
									c.send(sendPacket);
								} catch (Exception e){
									System.out.println(e);
								}
								System.out.println("Request packet send to: " + broadcast.getHostAddress() + "; Interface: " + networkInterface.getDisplayName());
							}
							System.out.println("Done looping over all network interfaces");
							//return;
						}
						
					} catch (IOException e){
						e.printStackTrace();
					}
					try {
						System.out.println("Waiting for five Seconds");
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
	        }
		}.start();
    }
    }
		protected ImageIcon createImageIcon(String path, String description) {
			URL imgURL = getClass().getResource(path);
			if (imgURL != null) {
				return new ImageIcon(imgURL, description);
			} else {
				System.err.println("Couldn't find file: " + path);
				return null;
			}
			
		}
    

    // Variables declaration - do not modify                     
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JList jList1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel jLabel13;
    private static javax.swing.JLabel jLabel12;
    // End of variables declaration     
    
    
    
    public class EventPane extends JPanel{
    	
    	HashSet currentlyconnectedusers = new HashSet();
    	private List<ConnectionListener> listeners;
    	public EventPane() {
    		System.out.println("In eventpane");
            listeners = new ArrayList<>(5);
            setLayout(new GridBagLayout());
            new Thread("BroadcastClient"){
    			public void run(){
    				DatagramSocket socket = null;
    				try {
    					System.out.println("Creating Socket");
    					socket = new DatagramSocket(8888, InetAddress.getByName("0.0.0.0"));
    					socket.setBroadcast(true);
    				} catch (SocketException | UnknownHostException e) {
    					e.printStackTrace();
    				}
    				while(true){
    					
    					System.out.println("Ready to recieve status");
    					byte[] recvBuf = new byte[15000];
    					final DatagramPacket packet = new DatagramPacket(recvBuf, recvBuf.length);
    					try {
    						socket.receive(packet);
    							new Thread("BroadcastClientThread"){
    								public void run(){
    									
    									final String HostName = packet.getAddress().getHostName();
    		    						String[] test = HostName.split("\\.");
    		    						String hostname = test[0];
    		    						String currentperson = null;
										try {
											currentperson = InetAddress.getLocalHost().getHostName();
										} catch (UnknownHostException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
    		    						System.out.println(currentperson);
    		    						System.out.println(hostname);
    		    						System.out.println("recieved Packet from: " + HostName);
    		    						String message = new String(packet.getData()).trim();
    		    						System.out.println("Message: " + message);
    		    						hostname = hostname.toUpperCase();
    		    						if(/*hostname == currentperson || hostname.equals(currentperson) ||*/ hostname == "127" || hostname.equals("127")){
    		    							System.out.println("Equal");
    		    						} else {
    		    							currentlyconnectedusers.add(hostname);
    		    							System.out.println("Added to array");
    		    							fireConnectionEstablished(hostname, message);
    		    							System.out.println("Added to model");
    		    						}
    								}
    							}.start();
    					} catch (IOException e) {
    						e.printStackTrace();
    					}
    					
    				}
    			}
    		}.start();
    		new Thread("BroadcastWait"){
				public void run(){
					while(true){
						try {
							fireConnectionRemove();
							Thread.sleep(20000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}.start();
    	}
    	
    	public void addConnectionListener(ConnectionListener listener) {
            listeners.add(listener);
        }

        public void removeConnectionListener(ConnectionListener listener) {
            listeners.remove(listener);
        }

        protected ConnectionListener[] getConnectionListeners() {
            return listeners.toArray(new ConnectionListener[listeners.size()]);
        }
    	
    	protected void fireConnectionEstablished(String computer, String person) {
    		ConnectionListener[] listeners = getConnectionListeners();
            if (listeners != null && listeners.length > 0) {
                for (ConnectionListener listener : listeners) {
                    listener.add(computer, person);
                }
            }
    			      
    	}
    	protected void fireConnectionRemove(){
    		ConnectionListener[] listeners = getConnectionListeners();
            if (listeners != null && listeners.length > 0) {
                for (ConnectionListener listener : listeners) {
                    listener.remove();
                }
            }
    	}
    }
}