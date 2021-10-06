package uo.ri.cws.application.business.mechanic.crud.commands;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import alb.util.jdbc.Jdbc;
import uo.ri.cws.application.business.mechanic.MechanicDto;

public class AddMechanic {
	
	private static String SQL = "insert into TMechanics(id, dni, name, surname) values (?, ?, ?, ?)";

	private MechanicDto mechanic;
	
	public AddMechanic(MechanicDto mechanic) {
		this.mechanic = mechanic;
	}
	
	public MechanicDto execute() {
		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
	
		try {
			c = Jdbc.getConnection();
			
			pst = c.prepareStatement(SQL);
			mechanic.id = UUID.randomUUID().toString();
			
			pst.setString(1, mechanic.id);
			pst.setString(2, mechanic.dni);
			pst.setString(3, mechanic.name);
			pst.setString(4, mechanic.surname);
			
			pst.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		finally {
			Jdbc.close(rs, pst, c);
		}
		return mechanic;
	}

}
