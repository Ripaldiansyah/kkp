/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unindra.kkp_kelompok4.dao;

import edu.unindra.kkp_kelompok4.Services.serviceReport;
import java.util.HashMap;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import edu.unindra.kkp_kelompok4.resource.koneksi;
import java.awt.BorderLayout;
import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import net.sf.jasperreports.view.JRViewer;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author ripal
 */
public class DAO_Report implements serviceReport{
	
	private Connection conn;

	public DAO_Report(){
		conn = new koneksi().connect();
	}
	@Override
	public void reportItem() {
		 try {
                        String file = "src/edu/unindra/kkp_kelompok4/report/reportItem.jasper";
                        Connection conn =  new koneksi().connect();

                        HashMap<String,Object> parameter = new HashMap<>();

                        JasperPrint print = JasperFillManager.fillReport(file,parameter,conn);
                        JasperViewer view = new JasperViewer(print,false);
                        view.setVisible(true);
                } catch (Exception e) {
                        JOptionPane.showConfirmDialog(null, e.getMessage());
                }
		
	}

	@Override
	public void reportStruk(String no) {
	try {
			String file = "src/edu/unindra/kkp_kelompok4/report/reportStruckCashier.jasper";
			HashMap<String, Object> parameters = new HashMap<>();
			parameters.put("orderId", no);
			
			JasperPrint print = JasperFillManager.fillReport(file,parameters,conn);
			JasperViewer.viewReport(print,false);
		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, e.getMessage());
		}
	}

	@Override
	public void orderItem(String no) {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public void deliveryOrder(String no) {
	try {
			String file = "src/edu/unindra/kkp_kelompok4/report/deliveryOrder.jasper";
			HashMap<String, Object> parameters = new HashMap<>();
			parameters.put("invoiceNumber", no);
			
			JasperPrint print = JasperFillManager.fillReport(file,parameters,conn);
			JasperViewer.viewReport(print,false);
		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, e.getMessage());
		}
	}

	@Override
	public void reportItemPanel(JPanel jp) {
		try {
			String file = "src/edu/unindra/kkp_kelompok4/report/reportItem.jasper";
			HashMap<String, Object> parameters = new HashMap<>();
			
			JasperPrint print = JasperFillManager.fillReport(file,parameters,conn);
			jp.setLayout(new BorderLayout());
			jp.repaint();
			jp.add(new JRViewer (print));
			jp.revalidate();
		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, e.getMessage());
		}
	}

	@Override
	public void reportTransactionItem(JPanel jp) {
	try {
			String file = "src/edu/unindra/kkp_kelompok4/report/transactionReport.jasper";
			HashMap<String, Object> parameters = new HashMap<>();
			
			JasperPrint print = JasperFillManager.fillReport(file,parameters,conn);
			jp.setLayout(new BorderLayout());
			jp.repaint();
			jp.add(new JRViewer (print));
			jp.revalidate();
		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, e.getMessage());
		}
	}

	@Override
	public void reportItemFilterUnit(String no, JPanel jp) {
	try {
			String file = "src/edu/unindra/kkp_kelompok4/report/reportItemFilterUnit.jasper";
			HashMap<String, Object> parameters = new HashMap<>();
			parameters.put("itemUnit", no);
			
			JasperPrint print = JasperFillManager.fillReport(file,parameters,conn);
			jp.setLayout(new BorderLayout());
			jp.repaint();
			jp.add(new JRViewer (print));
			jp.revalidate();
		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, e.getMessage());
		}
	}

	@Override
	public void reportItemFilterStock(int stock1, int stock2, JPanel jp) {
	try {
			String file = "src/edu/unindra/kkp_kelompok4/report/reportItemFilterStock.jasper";
			HashMap<String, Object> parameters = new HashMap<>();
			parameters.put("stock1", stock1);
			parameters.put("stock2", stock2);
			
			JasperPrint print = JasperFillManager.fillReport(file,parameters,conn);
			jp.setLayout(new BorderLayout());
			jp.repaint();
			jp.add(new JRViewer (print));
			jp.revalidate();
		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, e.getMessage());
		}
	}

	@Override
	public void reportItemFilterType(String type, JPanel jp) {
		try {
			String file = "src/edu/unindra/kkp_kelompok4/report/reportItemFilterType.jasper";
			HashMap<String, Object> parameters = new HashMap<>();
			parameters.put("typeItem", type);
			
			JasperPrint print = JasperFillManager.fillReport(file,parameters,conn);
			jp.setLayout(new BorderLayout());
			jp.repaint();
			jp.add(new JRViewer (print));
			jp.revalidate();
		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, e.getMessage());
		}
	}

	@Override
	public void reportItemFilterPrice(int price1, int price2, JPanel jp) {
	try {
			String file = "src/edu/unindra/kkp_kelompok4/report/reportItemFilterPrice.jasper";
			HashMap<String, Object> parameters = new HashMap<>();
			parameters.put("price1", price1);
			parameters.put("price2", price2);
			
			JasperPrint print = JasperFillManager.fillReport(file,parameters,conn);
			jp.setLayout(new BorderLayout());
			jp.repaint();
			jp.add(new JRViewer (print));
			jp.revalidate();
		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, e.getMessage());
		}
	}

	@Override
	public void reportTransactionItemByPeriode(String dateOrder1, String dateOrder2, JPanel jp) {
		try {
			String file = "src/edu/unindra/kkp_kelompok4/report/transactionReportFilterDate.jasper";
			HashMap<String, Object> parameters = new HashMap<>();
			parameters.put("dateOrder1", dateOrder1);
			parameters.put("dateOrder2", dateOrder2);
			
			JasperPrint print = JasperFillManager.fillReport(file,parameters,conn);
			jp.setLayout(new BorderLayout());
			jp.repaint();
			jp.add(new JRViewer (print));
			jp.revalidate();
		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, e.getMessage());
		}
	}

	@Override
	public void reportTransactionItemByPayment(String payment, JPanel jp) {
	try {
			String file = "src/edu/unindra/kkp_kelompok4/report/transactionReportFilterPaymentMethod.jasper";
			HashMap<String, Object> parameters = new HashMap<>();
			parameters.put("payment", payment);
			JasperPrint print = JasperFillManager.fillReport(file,parameters,conn);
			jp.setLayout(new BorderLayout());
			jp.repaint();
			jp.add(new JRViewer (print));
			jp.revalidate();
		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, e.getMessage());
		}
	}

	@Override
	public void reportTransactionItemByCashier(String cashier, JPanel jp) {
	try {
			String file = "src/edu/unindra/kkp_kelompok4/report/transactionReportFilterCashier.jasper";
			HashMap<String, Object> parameters = new HashMap<>();
			parameters.put("cashier", cashier);
			JasperPrint print = JasperFillManager.fillReport(file,parameters,conn);
			jp.setLayout(new BorderLayout());
			jp.repaint();
			jp.add(new JRViewer (print));
			jp.revalidate();
		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, e.getMessage());
		}
	}

	@Override
	public void reportTransactionItemByTotalShoping(int totalShoping1, int totalShoping2, JPanel jp) {
	try {
			String file = "src/edu/unindra/kkp_kelompok4/report/transactionReportFilterTotalShoping.jasper";
			HashMap<String, Object> parameters = new HashMap<>();
			parameters.put("totalShoping1", totalShoping1);
			parameters.put("totalShoping2", totalShoping2);
			
			JasperPrint print = JasperFillManager.fillReport(file,parameters,conn);
			jp.setLayout(new BorderLayout());
			jp.repaint();
			jp.add(new JRViewer (print));
			jp.revalidate();
		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, e.getMessage());
		}
	}

	@Override
	public void reportDetailOrder(JPanel jp) {
		try {
			String file = "src/edu/unindra/kkp_kelompok4/report/reportOrderItem.jasper";
			HashMap<String, Object> parameters = new HashMap<>();
			
			JasperPrint print = JasperFillManager.fillReport(file,parameters,conn);
			jp.setLayout(new BorderLayout());
			jp.repaint();
			jp.add(new JRViewer (print));
			jp.revalidate();
		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, e.getMessage());
		}
	}

	@Override
	public void reportDetailOrderFilterStatus(String status, JPanel jp) {
	try {
			String file = "src/edu/unindra/kkp_kelompok4/report/reportOrderItemFilterStatus.jasper";
			HashMap<String, Object> parameters = new HashMap<>();
			parameters.put("status", status);
			JasperPrint print = JasperFillManager.fillReport(file,parameters,conn);
			jp.setLayout(new BorderLayout());
			jp.repaint();
			jp.add(new JRViewer (print));
			jp.revalidate();
		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, e.getMessage());
		}
	}

	@Override
	public void reportDetailOrderByPeriode(String dateOrder1, String dateOrder2, JPanel jp) {
	try {
			String file = "src/edu/unindra/kkp_kelompok4/report/reportOrderItemFilterPeriod.jasper";
			HashMap<String, Object> parameters = new HashMap<>();
			parameters.put("date1", dateOrder1);
			parameters.put("date2", dateOrder2);
			
			JasperPrint print = JasperFillManager.fillReport(file,parameters,conn);
			jp.setLayout(new BorderLayout());
			jp.repaint();
			jp.add(new JRViewer (print));
			jp.revalidate();
		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, e.getMessage());
		}
	}

	@Override
	public void reportDetailOrderFilterEmployee(String employee, JPanel jp) {
	try {
			String file = "src/edu/unindra/kkp_kelompok4/report/reportOrderItemFilterEmployee.jasper";
			HashMap<String, Object> parameters = new HashMap<>();
			parameters.put("employee", employee);
			JasperPrint print = JasperFillManager.fillReport(file,parameters,conn);
			jp.setLayout(new BorderLayout());
			jp.repaint();
			jp.add(new JRViewer (print));
			jp.revalidate();
		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, e.getMessage());
		}
	}

	@Override
	public void reportDetailOrderFilterTotal(int totalShoping1, int totalShoping2, JPanel jp) {
	try {
			String file = "src/edu/unindra/kkp_kelompok4/report/reportOrderItemFilterTotalShopping.jasper";
			HashMap<String, Object> parameters = new HashMap<>();
			parameters.put("totalShoping1", totalShoping1);
			parameters.put("totalShoping2", totalShoping2);
			
			JasperPrint print = JasperFillManager.fillReport(file,parameters,conn);
			jp.setLayout(new BorderLayout());
			jp.repaint();
			jp.add(new JRViewer (print));
			jp.revalidate();
		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, e.getMessage());
		}
	}

	@Override
	public void reportOrder(JPanel jp) {
		try {
			String file = "src/edu/unindra/kkp_kelompok4/report/reportOrderWareHouse.jasper";
			HashMap<String, Object> parameters = new HashMap<>();
			
			JasperPrint print = JasperFillManager.fillReport(file,parameters,conn);
			jp.setLayout(new BorderLayout());
			jp.repaint();
			jp.add(new JRViewer (print));
			jp.revalidate();
		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, e.getMessage());
		}
	}

	@Override
	public void reportOrderByPeriode(String dateOrder1, String dateOrder2, JPanel jp) {
	try {
			String file = "src/edu/unindra/kkp_kelompok4/report/reportOrderWareHouseFilterPeriode.jasper";
			HashMap<String, Object> parameters = new HashMap<>();
			parameters.put("date1", dateOrder1);
			parameters.put("date2", dateOrder2);
			
			JasperPrint print = JasperFillManager.fillReport(file,parameters,conn);
			jp.setLayout(new BorderLayout());
			jp.repaint();
			jp.add(new JRViewer (print));
			jp.revalidate();
		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, e.getMessage());
		}
	}

	@Override
	public void reportOrderFilterStatus(String status, JPanel jp) {
		try {
			String file = "src/edu/unindra/kkp_kelompok4/report/reportOrderWareHouseFilterStatus.jasper";
			HashMap<String, Object> parameters = new HashMap<>();
			parameters.put("status", status);
			JasperPrint print = JasperFillManager.fillReport(file,parameters,conn);
			jp.setLayout(new BorderLayout());
			jp.repaint();
			jp.add(new JRViewer (print));
			jp.revalidate();
		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, e.getMessage());
		}
	}
	

	@Override
	public void reportOrderFilterEmployee(String employee, JPanel jp) {
	try {
			String file = "src/edu/unindra/kkp_kelompok4/report/reportOrderWareHouseFilterEmployee.jasper";
			HashMap<String, Object> parameters = new HashMap<>();
			parameters.put("employee", employee);
			JasperPrint print = JasperFillManager.fillReport(file,parameters,conn);
			jp.setLayout(new BorderLayout());
			jp.repaint();
			jp.add(new JRViewer (print));
			jp.revalidate();
		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, e.getMessage());
		}
	}

	@Override
	public void reportOrderFilterTotal(int totalShoping1, int totalShoping2, JPanel jp) {
	try {
			String file = "src/edu/unindra/kkp_kelompok4/report/reportOrderWareHouseFilterTotalShoping.jasper";
			HashMap<String, Object> parameters = new HashMap<>();
			parameters.put("totalShoping1", totalShoping1);
			parameters.put("totalShoping2", totalShoping2);
			
			JasperPrint print = JasperFillManager.fillReport(file,parameters,conn);
			jp.setLayout(new BorderLayout());
			jp.repaint();
			jp.add(new JRViewer (print));
			jp.revalidate();
		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, e.getMessage());
		}
	}

	@Override
	public void reportPerformanceCashier(String name, String date, JPanel jp) {
	try {
			String file = "src/edu/unindra/kkp_kelompok4/report/reportPerformanceCashier.jasper";
			HashMap<String, Object> parameters = new HashMap<>();
			parameters.put("name", name);
			parameters.put("date", date);
			
			JasperPrint print = JasperFillManager.fillReport(file,parameters,conn);
			jp.setLayout(new BorderLayout());
			jp.repaint();
			jp.add(new JRViewer (print));
			jp.revalidate();
		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, e.getMessage());
		}
	}
	}
	
