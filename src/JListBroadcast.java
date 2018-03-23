import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class JListBroadcast{
	public static void main(String args[]) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{		
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		new Thread("JListBroadcast"){
			public void run(){
				System.out.println("building gui");
				new JListBroadcast();
			}
		}.start();
		
		new Thread("BroadcastTimer"){
	        public void run(){
	        	while(true){
					try{
						DatagramSocket c = new DatagramSocket();
						c.setBroadcast(true);
						byte[] sendData = "test123".getBytes();
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
	public JListBroadcast(){
		
		JFrame frame = new JFrame(":D");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(new TestPane(0));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
		
	
	}
	public interface ConnectionListener {

		public void test123();

		void remove(String person);

		public void remove();

		
    }

    public class TestPane extends JPanel implements ConnectionListener {
    	
    	private JList list;
        private DefaultListModel<String> model;
        
        
        public TestPane(int i) {
        	
        		System.out.println("i < 0");
            setLayout(new BorderLayout());
            model = new DefaultListModel<>();
            list = new JList(model);
            add(new JScrollPane(list));
            //private List<ConnectionListener> listeners;
            EventPane eventPane = new EventPane();
            eventPane.addConnectionListener(this);
            add(eventPane, BorderLayout.SOUTH);
            list.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    JList list = (JList)evt.getSource();
                    if (evt.getClickCount() == 2) {
                    	MessengerAdmin msgadmin = new MessengerAdmin();
                    	String currentselection = (String) list.getSelectedValue();
                    	try {
							msgadmin.reply(currentselection, currentselection);
						} catch (UnknownHostException e) {
							e.printStackTrace();
						}
                        System.out.println(list.getSelectedValue());
                    //} else if (evt.getClickCount() == 3) {   // Triple-click
                        //int index = list.locationToIndex(evt.getPoint());

                    }
                }
            });
        		System.out.println("i > 0");
        		// Do nothing
        	
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }
		public void test123() {
			Random ran = new Random();
        	int x = ran.nextInt(6) + 5;
        	String random = Integer.toString(x);
        	model.addElement(random);
			
		}

		@Override
		public void remove(String person) {
			if (model.contains(person)){
				System.out.println("Duplicate not adding");
			} else {
			System.out.println("in run");
			model.addElement(person);
			System.out.println("out of run");
			}
		}

		@Override
		public void remove() {
			// Do nothing
			
		}

		
		
		
    }
    
    public class EventPane extends JPanel {
    	
    	HashSet currentlyconnectedusers = new HashSet();
    	private List<ConnectionListener> listeners;
    	public EventPane() {
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
    		    						final String hostname = test[0];
    		    						String currentcomputer = null;
										try {
											currentcomputer = InetAddress.getLocalHost().getHostName();
										} catch (UnknownHostException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
    		    						System.out.println(currentcomputer);
    		    						System.out.println(hostname);
    		    						System.out.println("recieved Packet from: " + HostName);
    		    						String message = new String(packet.getData()).trim();
    		    						System.out.println("Message: " + message);
    		    						if(/*hostname == currentcomputer || hostname.equals(currentcomputer) ||*/ hostname == "127" || hostname.equals("127")){
    		    							System.out.println("Equal");
    		    						} else {
    		    							currentlyconnectedusers.add(hostname);
    		    							System.out.println("Added to array");
    		    							fireConnectionEstablished(hostname);
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
    	
    	protected void fireConnectionEstablished(String person) {
    		ConnectionListener[] listeners = getConnectionListeners();
            if (listeners != null && listeners.length > 0) {
                for (ConnectionListener listener : listeners) {
                    listener.remove(person);
                }
            }
    			      
        }
    }
}