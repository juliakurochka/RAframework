package com.sqa.ra.dbunit;

import java.io.FileOutputStream;

import org.apache.log4j.Logger;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.database.search.TablesDependencyHelper;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;

import java.sql.Connection;
import java.sql.DriverManager;

import com.sqa.ra.db.adapters.RideAuctionConnectionManager;
import com.sqa.ra.framework.RAPropertyManager;

public class DatabaseExportSample
{
	static Logger logger = Logger.getLogger(DatabaseExportSample.class);
	
	public static Connection getConnection() {
	
	try {
		//Properties raProperties=RAPropertyManager.getProprties();
		
	   // Initiating MySQL driver
		Class.forName(RAPropertyManager.getProperty("DBDriver")).newInstance();		
				
		
			// Create and return a connection
		return DriverManager.getConnection(
				RAPropertyManager.getProperty("DBUrl"), 
				RAPropertyManager.getProperty("DBUserId"), 
				RAPropertyManager.getProperty("DBPassword"));
		
	} catch (Exception e) {
		e.printStackTrace();
		logger.error(e.getMessage());
	}

	return null;

}

    public static void main(String[] args) throws Exception
    {
    	 // database connection 
//        Class driverClass = Class.forName("com.mysql.jdbc.Driver");
//        Connection jdbcConnection = DriverManager.getConnection(
//                "jdbc:hsqldb:sample", "sa", "");
        
        
        Connection mysqlConnection = DatabaseExportSample.getConnection();

        
        IDatabaseConnection connection = new DatabaseConnection(mysqlConnection);

        // partial database export
        QueryDataSet partialDataSet = new QueryDataSet(connection);
        partialDataSet.addTable("tblCoupons", "SELECT * FROM TABLE WHERE COL='VALUE'");
        FlatXmlDataSet.write(partialDataSet, new FileOutputStream("partial.xml"));

        // full database export
        IDataSet fullDataSet = connection.createDataSet();
        FlatXmlDataSet.write(fullDataSet, new FileOutputStream("full.xml"));
        
        // dependent tables database export: export table X and all tables that
        // have a PK which is a FK on X, in the right order for insertion
        String[] depTableNames = 
          TablesDependencyHelper.getAllDependentTables( connection, "X" );
        IDataSet depDataset = connection.createDataSet( depTableNames );
        FlatXmlDataSet.write(depDataset, new FileOutputStream("dependents.xml"));          
        
    }
}