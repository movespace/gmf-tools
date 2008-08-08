/*
 * Copyright (c) 2008 Borland Software Corp.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.xpand.xtend.ast;

import java.util.List;

import org.eclipse.gmf.internal.xpand.ResourceMarker;
import org.eclipse.gmf.internal.xpand.model.XpandAnalyzable;
import org.eclipse.m2m.internal.qvt.oml.common.MDAConstants;

public interface QvtResource extends XpandAnalyzable, ResourceMarker {

	public static final String FILE_EXTENSION = MDAConstants.QVTO_FILE_EXTENSION;

	List<GenericExtension> getExtensions();
}