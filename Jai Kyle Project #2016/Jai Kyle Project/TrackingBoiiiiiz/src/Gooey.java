import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

//SplitPaneDemo itself is not a visible component.
public class Gooey extends JPanel implements ListSelectionListener {
	private JList list;
	private JSplitPane splitPane;
	private JSplitPane splitPane2;
	private JSplitPane productSplitPane;
	private JSplitPane productSplitPane2;
	private JTabbedPane tabbedpane;
	private ArrayList<CustomerOrder> orderList = new ArrayList<CustomerOrder>();
	private JButton control1, control2, control3;
	private JButton pControl1, pControl2, pControl3;
	String[] orderIDArray;
	String[] columnNames = { "Date", "CustomerID", "Shipping Address",
			"Total Cost", "ProductID", "Order Status", "Porusware" };
	String[] prodColumnNames = { "ID", "Product Name", "Product Type", "Quantity Owned", "Weight", "Location"};

	// Create the list of images and put it in a scroll pane.
	public Gooey() {
		Inventory in = new Inventory();
		Warehouse w = new Warehouse(in);
		w.loadOrders();
		in.loadStock();
		orderList = w.getOrderList();
		orderIDArray = new String[orderList.size()];
		for (int i = 0; i < orderList.size(); i++) {
			orderIDArray[i] = orderList.get(i).getOrderID();
		}

		list = new JList(orderIDArray);
		// Provide minimum sizes for the two components in the split pane.
				Dimension minimumSize = new Dimension(100, 50);
		
		tabbedpane = new JTabbedPane(JTabbedPane.TOP);
		tabbedpane.setMinimumSize(minimumSize);
		
		Object[][] data = new Object[orderList.size()][7];
		for (int i = 0; i < orderList.size(); i++) {

			CustomerOrder current = orderList.get(i);

			data[i][0] = current.getDate();
			data[i][1] = current.getCustomerID();
			data[i][2] = current.getShippingAddress();
			data[i][3] = current.getTotalCost();
			data[i][4] = current.getProductID();
			data[i][5] = current.getEy();
			data[i][6] = current.getRequiresPW();

		}

		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setSelectedIndex(0);
		list.addListSelectionListener(this);
		TableModel orderData = new DefaultTableModel(data, columnNames);
		JScrollPane listScrollPane = new JScrollPane(list);
		JTable table = new JTable(orderData);

		// JScrollPane tableScrollPane = new JScrollPane(table);

		JScrollPane orderScrollPane = new JScrollPane(table);
		control1 = new JButton("Update Stock");
		control2 = new JButton("Checkout Order");
		control3 = new JButton("Inform Accounts");
		
		JPanel ey = new JPanel();
		ey.setLayout(new BoxLayout(ey, BoxLayout.PAGE_AXIS));
		ey.add("Update Stock", control1);
		ey.add("Checkout Order", control2);
		ey.add("Inform Accounts", control3);
		
		JScrollPane orderControlPane = new JScrollPane(ey);
		

		// Create a split pane with the two scroll panes in it.
		splitPane2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, orderScrollPane, orderControlPane);
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, listScrollPane,
				splitPane2);
		tabbedpane.addTab("Stock", splitPane);
		tabbedpane.setSelectedIndex(0);
		tabbedpane.addTab("Orders", productSplitPane2);
		splitPane.setOneTouchExpandable(true);
		splitPane.setDividerLocation(150);

		
		listScrollPane.setMinimumSize(minimumSize);
		orderScrollPane.setMinimumSize(minimumSize);

		// Provide a preferred size for the split pane.
		splitPane.setPreferredSize(new Dimension(400, 200));
		// updateLabel(orderList.toArray()[list.getSelectedIndex()]);
		String[] BJoJo = new String[in.getProducts().size()];
	
		
		for (int i = 0; i < in.getProducts().size(); i++) {
			BJoJo[i] = in.getProducts().get(i).getId();
		}
		
		JList Blist = new JList(BJoJo);
		
		// Provide minimum sizes for the two components in the split pane.
		
		tabbedpane = new JTabbedPane(JTabbedPane.TOP);
		tabbedpane.setMinimumSize(minimumSize);
		
		Object[][] pData = new Object[in.getProducts().size()][6];
		for (int i = 0; i < in.getProducts().size(); i++) {

			Product current = in.getProducts().get(i);

			pData[i][0] = current.getId();
			pData[i][1] = current.getProductName();
			pData[i][2] = current.getProductType();
			pData[i][3] = current.getQuantityOwned();
			pData[i][4] = current.getWeight();
			pData[i][5] = current.getWarehouseLocation();

		}

		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setSelectedIndex(0);
		list.addListSelectionListener(this);
		TableModel productData = new DefaultTableModel(pData, prodColumnNames);
		JScrollPane listScrollPane2 = new JScrollPane(Blist);
		JTable pTable = new JTable(productData);

		// JScrollPane tableScrollPane = new JScrollPane(table);

		JScrollPane productScrollPane = new JScrollPane(pTable);
		pControl1 = new JButton("Update Stock");
		pControl2 = new JButton("update Product");
		pControl3 = new JButton("Update Something");
		
		JPanel eyy = new JPanel();
		eyy.setLayout(new BoxLayout(eyy, BoxLayout.PAGE_AXIS));
		eyy.add("Update Stock", pControl1);
		eyy.add("update Product", pControl2);
		eyy.add("update Something", pControl3);
		
		JScrollPane productControlPane = new JScrollPane(eyy);
		

		// Create a split pane with the two scroll panes in it.
		productSplitPane2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, productScrollPane, productControlPane);
		productSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, listScrollPane2,
				productSplitPane2);
		tabbedpane.addTab("Orders", splitPane);
		tabbedpane.addTab("Products", productSplitPane);
		productSplitPane.setOneTouchExpandable(true);
		productSplitPane.setDividerLocation(150);
	}

	// Listens to the list
	public void valueChanged(ListSelectionEvent e) {
		JList list = (JList) e.getSource();
		updateLabel(orderList.toArray()[list.getSelectedIndex()]);
		orderList.get(list.getSelectedIndex());
	}

	// Renders the selected image
	protected void updateLabel(Object object) {

	}

	public JTabbedPane getSplitPane() {
		return tabbedpane;
	}

	/**
	 * Create the GUI and show it. For thread safety, this method should be
	 * invoked from the event-dispatching thread.
	 */
	private static void createAndShowGUI() {

		// Create and set up the window.
		JFrame frame = new JFrame("Warehouse Order Fulfilment");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Gooey stuff = new Gooey();
		frame.getContentPane().add(stuff.getSplitPane());

		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

	// overloaded cons

}
