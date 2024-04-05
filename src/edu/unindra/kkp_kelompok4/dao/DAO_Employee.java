/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unindra.kkp_kelompok4.dao;

import java.sql.*;
import edu.unindra.kkp_kelompok4.model.modelEmployee;
import edu.unindra.kkp_kelompok4.resource.koneksi;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import javax.swing.JOptionPane;
import edu.unindra.kkp_kelompok4.Services.serviceEmployee;
import edu.unindra.kkp_kelompok4.home.homeApp;
import edu.unindra.kkp_kelompok4.login.encryptLogin;
import edu.unindra.kkp_kelompok4.master.employeeForm;

/**
 *
 * @author ripal
 */
public class DAO_Employee implements serviceEmployee{
	
	private Connection conn;
	
	public DAO_Employee(){
		conn = new koneksi().connect();
	}


	@Override
	public modelEmployee getById(String id) {
		PreparedStatement stat = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM employeeTable WHERE idEmployee = ?";

		try {
		    stat = conn.prepareStatement(sql);
		    stat.setString(1, id);
		    rs = stat.executeQuery();

		    if (rs.next()) {
			modelEmployee employee = new modelEmployee();

			employee.setIdEmployee(rs.getString("idEmployee"));
			employee.setEmployeeName(rs.getString("employeeName"));
			employee.setGender(rs.getString("gender"));
			employee.setPlaceOfBirth(rs.getString("placeOfBirth"));
			employee.setDateOfBirth(rs.getDate("dateOfBirth"));
			employee.setPhoneNumber(rs.getString("phoneNumber"));
			employee.setAddress(rs.getString("address"));
			employee.setEmail(rs.getString("email"));
			employee.setUsername(rs.getString("username"));
			employee.setRole(rs.getString("role"));

			return employee;
		    }
		    } catch (Exception e) {
			Logger.getLogger(DAO_Employee.class.getName()).log(Level.SEVERE, null, e);
		    } finally {
			if (stat != null) {
			    try {
				stat.close();
			    } catch (Exception e) {
				Logger.getLogger(DAO_Employee.class.getName()).log(Level.SEVERE, null, e);
			    }
			}
			if (rs != null) {
			    try {
				rs.close();
			    } catch (Exception e) {
				Logger.getLogger(DAO_Employee.class.getName()).log(Level.SEVERE, null, e);
			    }
			}
		    }

		    return null;
}
	

	@Override
	public List<modelEmployee> getData() {
          
		PreparedStatement stat=null;
		List list = new ArrayList();
		ResultSet rs = null;
		String sql ="Select * from employeeTable ";
		
		try {
		stat = conn.prepareStatement(sql);
		rs = stat.executeQuery();
			while (rs.next()) {				
				modelEmployee employee = new modelEmployee();
				
				employee.setIdEmployee(rs.getString("idEmployee"));
				employee.setEmployeeName(rs.getString("employeeName"));
				employee.setGender(rs.getString("gender"));
				employee.setPlaceOfBirth(rs.getString("placeOfBirth"));
				// Mengambil tanggal sebagai string
    String dateOfBirthStr = rs.getString("dateOfBirth");

    // Konversi tanggal menjadi objek java.sql.Date secara manual
    if (dateOfBirthStr != null) {
        long dateOfBirthMillis = Long.parseLong(dateOfBirthStr);
        Date dateOfBirth = new Date(dateOfBirthMillis);
        employee.setDateOfBirth(dateOfBirth);
    }

				employee.setPhoneNumber(rs.getString("phoneNumber"));
				employee.setAddress(rs.getString("address"));
				employee.setEmail(rs.getString("email"));
				employee.setUsername(rs.getString("username"));
				employee.setRole(rs.getString("role"));
			
				list.add(employee);
			}
			return list;
		} catch (Exception e) {
			Logger.getLogger(DAO_Employee.class.getName()).log(Level.SEVERE,null,e);
			return null;
		}finally{
			if (stat!=null) {
				try {
					stat.close();
				} catch (Exception e) {
					Logger.getLogger(DAO_Employee.class.getName()).log(Level.SEVERE,null,e);
				}
			}
			if (rs!=null) {
				try {
					rs.close();
				} catch (Exception e) {
					Logger.getLogger(DAO_Employee.class.getName()).log(Level.SEVERE,null,e);
				}
			}
		}
	}

	@Override
	public String number() {
		PreparedStatement stat = null;
		ResultSet rs = null;
		String listing = null;
		LocalDate now = LocalDate.now();
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
//		DateTimeFormatter noFormat = DateTimeFormatter.ofPattern("yyMM");

		String tgl = now.format(dateFormatter);
//		String no = now.format(noFormat);
		
		String sql = "SELECT SUBSTR(idEmployee, -3) AS Number " +
				"FROM employeeTable " +
				"WHERE idEmployee LIKE 'XYZ" + tgl + "%' " +
				"ORDER BY idEmployee DESC " +
				"LIMIT 1";
			;
		try {
			stat=conn.prepareStatement(sql);
			rs = stat.executeQuery();
			
			if (rs.next()) {
				int number =Integer.parseInt(rs.getString("number"));
				number++;
				listing="XYZ"+tgl+String.format("%03d",number);
				
			}else{
				listing="XYZ"+tgl+"001";
			}
		} catch (Exception e) {
			Logger.getLogger(DAO_Employee.class.getName()).log(Level.SEVERE,null,e);
		}finally{
			if (stat!=null) {
				try {
					stat.close();
				} catch (Exception e) {
					Logger.getLogger(DAO_Employee.class.getName()).log(Level.SEVERE,null,e);
				}
			}
		}
		return listing;
		
	}


    @Override
    public void addItem(modelEmployee employee) {
        PreparedStatement stat=null;
		String sql = "INSERT INTO employeeTable (idEmployee,"
							+ "employeeName,"
							+ "gender,"
							+ "placeOfBirth,"
							+ "dateOfBirth,"
							+ "address,"
							+ "email,"
							+"username,"
							+ "password_hash,"
							+ "phoneNumber,"
							+ "pin,"
							+ "role)VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			stat=(PreparedStatement) conn.prepareStatement(sql);
			stat.setString(1, employee.getIdEmployee());
			stat.setString(2, employee.getEmployeeName());
			stat.setString(3,employee.getGender());
			stat.setString(4, employee.getPlaceOfBirth());	
			stat.setDate(5, employee.getDateOfBirth());
			stat.setString(6, employee.getAddress());
                        stat.setString(7, employee.getEmail());
			stat.setString(8, employee.getUsername());
                        stat.setString(9, employee.getPassword_Hash());
                        stat.setString(10, employee.getPhoneNumber());
			stat.setString(11, employee.getPin());
                        stat.setString(12, employee.getRole());
			
			stat.executeUpdate();
		} catch (Exception e) {
			Logger.getLogger(DAO_Employee.class.getName()).log(Level.SEVERE,null,e);
		}finally{
			if (stat!=null) {
				try {
					stat.close();
				} catch (Exception e) {
					Logger.getLogger(DAO_Employee.class.getName()).log(Level.SEVERE,null,e);
				}
			}
		}
    }

    @Override
    public void renewItem(modelEmployee employee) {
        PreparedStatement stat=null;
	PreparedStatement stat2 = null;
		ResultSet rs = null;
		String sql = "UPDATE employeeTable SET employeeName=? , gender=?, placeOfBirth=? ,dateOfBirth=?, address=?,email=?,username=?,password_hash=?,phoneNumber=?, role=?, pin=? where idEmployee=?";
		try {
			stat=(PreparedStatement) conn.prepareStatement(sql);
			stat.setString(1, employee.getEmployeeName());
			stat.setString(2, employee.getGender());
			stat.setString(3,employee.getPlaceOfBirth());
			stat.setDate(4,employee.getDateOfBirth());
                        stat.setString(5,employee.getAddress());
                        stat.setString(6,employee.getEmail());
			stat.setString(7,employee.getUsername());
                        stat.setString(8,employee.getPassword_Hash());
                        stat.setString(9,employee.getPhoneNumber());
                        stat.setString(10,employee.getRole());
			stat.setString(11,employee.getPin());
                        stat.setString(12,employee.getIdEmployee());
                       
			
			stat.executeUpdate();
			
					} catch (Exception e) {
			
			Logger.getLogger(DAO_Employee.class.getName()).log(Level.SEVERE,null,e);
			
			
		}finally{
			if (stat!=null) {
				try {
					stat.close();
				} catch (Exception e) {
					Logger.getLogger(DAO_Employee.class.getName()).log(Level.SEVERE,null,e);
				}
			}
		}
    }

    @Override
    public void deleteItem(modelEmployee employee) {
        PreparedStatement stat=null;
		String sql = "DELETE From employeeTable where idEmployee=?";
		try {
			stat=(PreparedStatement) conn.prepareStatement(sql);
			stat.setString(1,employee.getIdEmployee());
			stat.executeUpdate();
		} catch (Exception e) {
			Logger.getLogger(DAO_Employee.class.getName()).log(Level.SEVERE,null,e);
		}finally{
			if (stat!=null) {
				try {
					stat.close();
				} catch (Exception e) {
					Logger.getLogger(DAO_Employee.class.getName()).log(Level.SEVERE,null,e);
				}
			}
		}
    }

	@Override
	public void checkUsername(modelEmployee employee) {
    PreparedStatement stat = null;
    ResultSet rs = null;
    String sql = "SELECT COUNT(*) AS count FROM employeeTable WHERE username = ?;";
    try {
        stat = conn.prepareStatement(sql);
        stat.setString(1, employee.getUsername()); // Menggunakan setString(1, ...) untuk mengisi parameter
        rs = stat.executeQuery();
        employeeForm formEmployee = new employeeForm();
        if (rs.next()) {
            int count = rs.getInt("count");
            
	    
            if (count > 0) {
                formEmployee.checkUser=false;
            } else {
                 formEmployee.checkUser=true;
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        // Menutup ResultSet, PreparedStatement, dan koneksi
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        if (stat != null) {
            try {
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

	@Override
	public modelEmployee pinSetting(String employee) {
		PreparedStatement stat = null;
    ResultSet rs = null;
    String sql = "SELECT pin FROM employeeTable WHERE idEmployee = ?";

    try {
        stat = conn.prepareStatement(sql);
        stat.setString(1, employee);
        rs = stat.executeQuery();
        
        if (rs.next()) {
            modelEmployee lockApp = new modelEmployee();

            lockApp.setPin(rs.getString("pin"));

            return lockApp;
        }
	} catch (Exception e) {
	    Logger.getLogger(DAO_Employee.class.getName()).log(Level.SEVERE, null, e);
	} finally {
	    if (stat != null) {
		try {
		    stat.close();
		} catch (Exception e) {
		    Logger.getLogger(DAO_Employee.class.getName()).log(Level.SEVERE, null, e);
		}
	    }
	    if (rs != null) {
		try {
		    rs.close();
		} catch (Exception e) {
		    Logger.getLogger(DAO_Employee.class.getName()).log(Level.SEVERE, null, e);
		}
	    }
	}

	return null;

	}

	@Override
	public List<modelEmployee> getCarts() {
	PreparedStatement stat = null;
		List<modelEmployee> list = new ArrayList<>();
		ResultSet rs = null;
		String sql = "SELECT * FROM employeeTable WHERE role = 'CASHIER';";
		try {
			stat = conn.prepareStatement(sql);
			rs = stat.executeQuery();
			while (rs.next()) {
				modelEmployee employee = new modelEmployee();
				
				employee.setEmployeeName(rs.getString("employeeName"));

				list.add(employee);
			}
			return list;
		} catch (Exception e) {
			Logger.getLogger(DAO_CheckIn.class.getName()).log(Level.SEVERE,null,e);
			return null;
		}finally{
			if (stat!=null) {
				try {
					stat.close();
				} catch (Exception e) {
					Logger.getLogger(DAO_CheckIn.class.getName()).log(Level.SEVERE,null,e);
				}
			}
	}
	}


	@Override
	public List<modelEmployee> getEmployeesWarehouse() {
	PreparedStatement stat = null;
		List<modelEmployee> list = new ArrayList<>();
		ResultSet rs = null;
		String sql = "SELECT * FROM employeeTable WHERE role = 'WAREHOUSE';";
		try {
			stat = conn.prepareStatement(sql);
			rs = stat.executeQuery();
			while (rs.next()) {
				modelEmployee employee = new modelEmployee();
				
				employee.setEmployeeName(rs.getString("employeeName"));

				list.add(employee);
			}
			return list;
		} catch (Exception e) {
			Logger.getLogger(DAO_CheckIn.class.getName()).log(Level.SEVERE,null,e);
			return null;
		}finally{
			if (stat!=null) {
				try {
					stat.close();
				} catch (Exception e) {
					Logger.getLogger(DAO_CheckIn.class.getName()).log(Level.SEVERE,null,e);
				}
			}
	}
	}
}
