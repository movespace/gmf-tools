package org.eclipse.gmf.examples.mindmap.lite.rcp.edit.policies;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.lite.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.lite.commands.RemoveNotationalEdgeCommand;
import org.eclipse.gmf.runtime.lite.commands.WrappingCommand;
import org.eclipse.gmf.runtime.notation.Edge;

/**
 * @generated
 */
public class RelationshipComponentEditPolicy extends ComponentEditPolicy {
	/**
	 * @generated
	 */
	protected Command createDeleteCommand(GroupRequest deleteRequest) {
		TransactionalEditingDomain editingDomain = TransactionUtil
				.getEditingDomain(getDiagramEdge().getDiagram().getElement());
		CompoundCommand cc = new CompoundCommand();
		cc.append(createDomainModelRemoveCommand(editingDomain));
		cc.append(new RemoveNotationalEdgeCommand(
				getDiagramEdge().getDiagram(), getDiagramEdge()));
		return new WrappingCommand(editingDomain, cc);
	}

	/**
	 * @generated
	 */
	private org.eclipse.emf.common.command.Command createDomainModelRemoveCommand(
			TransactionalEditingDomain editingDomain) {
		return DestroyElementCommand.create(editingDomain, getDiagramEdge()
				.getElement());
	}

	/**
	 * @generated
	 */
	protected Edge getDiagramEdge() {
		return (Edge) getHost().getModel();
	}
}
