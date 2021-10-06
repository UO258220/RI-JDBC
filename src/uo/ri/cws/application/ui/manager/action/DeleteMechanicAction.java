package uo.ri.cws.application.ui.manager.action;

import alb.util.console.Console;
import alb.util.menu.Action;
import uo.ri.cws.application.business.BusinessException;
import uo.ri.cws.application.business.BusinessFactory;
import uo.ri.cws.application.business.mechanic.MechanicCrudService;

public class DeleteMechanicAction implements Action {

	@Override
	public void execute() throws BusinessException {
		
		// Get id
		String idMechanic = Console.readString("Type mechanic id "); 
		
		// Delegate to business layer
		MechanicCrudService service = BusinessFactory.forMechanicCrudService();
		service.deleteMechanic(idMechanic);
		
		// Print result
		Console.println("Mechanic deleted");
	}

}
