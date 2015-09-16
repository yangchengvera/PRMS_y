/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.presenter.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import sg.edu.nus.iss.phoenix.core.dao.DBConstants;
import sg.edu.nus.iss.phoenix.core.exceptions.NotFoundException;
import sg.edu.nus.iss.phoenix.presenter.dao.PresenterDAO;
import sg.edu.nus.iss.phoenix.presenter.entity.Presenter;

/**
 *
 * @author angxiaolu
 */
public class PresenterDAOImpl implements PresenterDAO{
	Connection connection;

    @Override
    public Presenter createValueObject() {
        return new Presenter();
    }

    @Override
    public Presenter getObject(String name) throws NotFoundException, SQLException {
        Presenter valueObject = createValueObject();
        valueObject.setName(name);
        load(valueObject);
        return valueObject;
    }

    @Override
    public void load(Presenter valueObject) throws NotFoundException, SQLException {
        if (valueObject.getName() == null) {
                // System.out.println("Can not select without Primary-Key!");
                throw new NotFoundException("Can not select without Primary-Key!");
        }

        String sql = "SELECT * FROM `presenter` WHERE (`name` = ? ); ";
        PreparedStatement stmt = null;
        openConnection();
        try {
                stmt = connection.prepareStatement(sql);
                stmt.setString(1, valueObject.getName());
                singleQuery(stmt, valueObject);

        } finally {
                if (stmt != null)
                        stmt.close();
                closeConnection();
        }
    }

    @Override
    public List<Presenter> loadAll() throws SQLException {
        openConnection();
        String sql = "SELECT * FROM `presenter` ORDER BY `name` ASC; ";
        List<Presenter> searchResults = listQuery(connection
                        .prepareStatement(sql));
        closeConnection();
        System.out.println("record size"+searchResults.size());
        return searchResults;
    }
    
    @Override
    public List<Presenter> loadPresenter(String presenterName) throws SQLException {
        openConnection();
        String sql = "SELECT * FROM presenter WHERE (name ='"+ presenterName+"'); ";
        List<Presenter> searchResults = listQuery(connection
                        .prepareStatement(sql));
        closeConnection();
        System.out.println("record size"+searchResults.size());
        return searchResults;
    }

    @Override
    public void create(Presenter valueObject) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(Presenter valueObject) throws NotFoundException, SQLException {

        String sql = "UPDATE `presenter` SET `address` = ?, `joinDate` = ? WHERE (`name` = ? ); ";
        PreparedStatement stmt = null;
        openConnection();
        try {
                stmt = connection.prepareStatement(sql);
                stmt.setString(1, valueObject.getAddress());
                stmt.setDate(2, valueObject.getJoinDate());

                stmt.setString(3, valueObject.getName());

                int rowcount = databaseUpdate(stmt);
                if (rowcount == 0) {
                        // System.out.println("Object could not be saved! (PrimaryKey not found)");
                        throw new NotFoundException(
                                        "Object could not be saved! (PrimaryKey not found)");
                }
                if (rowcount > 1) {
                        // System.out.println("PrimaryKey Error when updating DB! (Many objects were affected!)");
                        throw new SQLException(
                                        "PrimaryKey Error when updating DB! (Many objects were affected!)");
                }
        } finally {
                if (stmt != null)
                        stmt.close();
                closeConnection();
        }
	}


    @Override
    public void delete(Presenter valueObject) throws NotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAll(Connection conn) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int countAll() throws SQLException {
            String sql = "SELECT count(*) FROM `presenter`";
            PreparedStatement stmt = null;
            ResultSet result = null;
            int allRows = 0;
            openConnection();
            try {
                    stmt = connection.prepareStatement(sql);
                    result = stmt.executeQuery();

                    if (result.next())
                            allRows = result.getInt(1);
            } finally {
                    if (result != null)
                            result.close();
                    if (stmt != null)
                            stmt.close();
                    closeConnection();
            }
            return allRows;
    }

    @Override
    public List<Presenter> searchMatching(Presenter valueObject) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    protected int databaseUpdate(PreparedStatement stmt) throws SQLException {

            int result = stmt.executeUpdate();

            return result;
    }

    
	/**
	 * databaseQuery-method. This method is a helper method for internal use. It
	 * will execute all database queries that will return only one row. The
	 * resultset will be converted to valueObject. If no rows were found,
	 * NotFoundException will be thrown.
	 * 
	 * @param conn
	 *            This method requires working database connection.
	 * @param stmt
	 *            This parameter contains the SQL statement to be excuted.
	 * @param valueObject
	 *            Class-instance where resulting data will be stored.
	 */
	protected void singleQuery(PreparedStatement stmt, Presenter valueObject)
			throws NotFoundException, SQLException {

		ResultSet result = null;
		openConnection();
		try {
			result = stmt.executeQuery();

			if (result.next()) {

				valueObject.setName(result.getString("name"));
				valueObject.setAddress(result.getString("address"));
				valueObject.setJoinDate(result
						.getDate("joinDate"));

			} else {
				// System.out.println("RadioProgram Object Not Found!");
				throw new NotFoundException("Presenter Object Not Found!");
			}
		} finally {
			if (result != null)
				result.close();
			if (stmt != null)
				stmt.close();
			closeConnection();
		}
	}
	/**
	 * databaseQuery-method. This method is a helper method for internal use. It
	 * will execute all database queries that will return multiple rows. The
	 * resultset will be converted to the List of valueObjects. If no rows were
	 * found, an empty List will be returned.
	 * 
	 * @param conn
	 *            This method requires working database connection.
	 * @param stmt
	 *            This parameter contains the SQL statement to be excuted.
	 */
	protected List<Presenter> listQuery(PreparedStatement stmt) throws SQLException {

		ArrayList<Presenter> searchResults = new ArrayList<Presenter>();
		ResultSet result = null;
		openConnection();
		try {
			result = stmt.executeQuery();

			while (result.next()) {
				Presenter temp = createValueObject();

				temp.setName(result.getString("name"));
				temp.setAddress(result.getString("address"));
				temp.setJoinDate(result.getDate("joinDate"));
				searchResults.add(temp);
			}

		} finally {
			if (result != null)
				result.close();
			if (stmt != null)
				stmt.close();
			closeConnection();
		}

		return (List<Presenter>) searchResults;
	}
	
    
    private void openConnection() {
            try {
                    Class.forName(DBConstants.COM_MYSQL_JDBC_DRIVER);
            } catch (ClassNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
            }

            try {
                    this.connection = DriverManager.getConnection(DBConstants.dbUrl,
                                    DBConstants.dbUserName, DBConstants.dbPassword);
            } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
            }

    }

    private void closeConnection() {
            try {
                    this.connection.close();
            } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
            }
    }


//    
//        String sql = "SELECT * FROM `presenter` WHERE (`name` = ? ); ";
//        PreparedStatement stmt = null;
//        openConnection();
//        try {
//                stmt = connection.prepareStatement(sql);
//                stmt.setString(1, valueObject.getName());
//                singleQuery(stmt, valueObject);
//
//        } finally {
//                if (stmt != null)
//                        stmt.close();
//                closeConnection();
//        }
}
