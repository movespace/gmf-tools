/*
 * Copyright (c) 2005 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitri Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.examples.taipan.gmf.editor.providers;

import java.text.FieldPosition;
import java.text.MessageFormat;
import java.util.Collections;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeModelCommand;

/**
 * @generated
 */
public class TaiPanStructuralFeatureParser extends TaiPanAbstractParser {

	/**
	 * @generated
	 */
	private static final MessageFormat DEFAULT_PROCESSOR = new MessageFormat("{0}");

	/**
	 * @generated
	 */
	private EStructuralFeature feature;

	/**
	 * @generated
	 */
	public TaiPanStructuralFeatureParser(EStructuralFeature feature) {
		this.feature = feature;
	}

	/**
	 * @generated
	 */
	protected MessageFormat getViewProcessor() {
		MessageFormat processor = super.getViewProcessor();
		return processor == null ? DEFAULT_PROCESSOR : processor;
	}

	/**
	 * @generated
	 */
	protected MessageFormat getEditProcessor() {
		MessageFormat processor = super.getEditProcessor();
		return processor == null ? DEFAULT_PROCESSOR : processor;
	}

	/**
	 * @generated
	 */
	protected String getStringByPattern(IAdaptable adapter, int flags, String pattern, MessageFormat processor) {
		EObject element = (EObject) adapter.getAdapter(EObject.class);
		Object value = element.eGet(feature);
		return processor.format(new Object[] { value }, new StringBuffer(), new FieldPosition(0)).toString();
	}

	/**
	 * @generated
	 */
	protected IParserEditStatus validateNewValues(Object[] values) {
		return values.length == 1 ? ParserEditStatus.EDITABLE_STATUS : ParserEditStatus.UNEDITABLE_STATUS;
	}

	/**
	 * @generated
	 */
	public ICommand getParseCommand(IAdaptable adapter, Object[] newValues) {
		EObject element = (EObject) adapter.getAdapter(EObject.class);
		ICommand command = getModificationCommand(element, feature, newValues[0]);
		return new CompositeModelCommand(command.getLabel(), Collections.singletonList(command));
	}

	/**
	 * @generated
	 */
	public boolean isAffectingEvent(Object event, int flags) {
		if (event instanceof Notification) {
			if (feature == ((Notification) event).getFeature()) {
				return true;
			}
		}
		return false;
	}
}
