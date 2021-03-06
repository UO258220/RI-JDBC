package uo.ri.cws.application.ui.manager.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import alb.util.console.Console;
import alb.util.jdbc.Jdbc;
import alb.util.menu.Action;
import uo.ri.cws.application.business.BusinessException;

public class FindAllMechanicsAction implements Action {

	private static String SQL = "select id, dni, name, surname from TMechanics";
	
	@Override
	public void execute() throws BusinessException {

		Console.println("\nList of mechanics \n");  

		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			c = Jdbc.getConnection();
			
			pst = c.prepareStatement(SQL);
			
			rs = pst.executeQuery();
			while(rs.next()) {
				Console.printf("\t%s %s %s %s\n",  
					rs.getString(1)
					,  rs.getString(2) 
					,  rs.getString(3)
					,  rs.getString(4)
				);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		finally {
			Jdbc.close(rs, pst, c);
		}
	}
}
