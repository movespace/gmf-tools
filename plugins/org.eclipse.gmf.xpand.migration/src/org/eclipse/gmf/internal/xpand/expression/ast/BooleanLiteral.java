/*
 * <copyright>
 *
 * Copyright (c) 2005-2006 Sven Efftinge and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Sven Efftinge - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.gmf.internal.xpand.expression.ast;

import java.util.Set;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gmf.internal.xpand.expression.AnalysationIssue;
import org.eclipse.gmf.internal.xpand.expression.ExecutionContext;

/**
 * @author Sven Efftinge
 * @author Arno Haase
 */
public class BooleanLiteral extends Literal {

    public BooleanLiteral(final int start, final int end, final int line, final int startOffset, final int endOffset, final String literalValue) {
        super(start, end, line, startOffset, endOffset, literalValue);
    }

    @Override
    public Object evaluateInternal(final ExecutionContext ctx) {
        return Boolean.valueOf(getLiteralValue());
    }

    public EClassifier analyze(final ExecutionContext ctx, final Set<AnalysationIssue> issues) {
        return EcorePackage.eINSTANCE.getEBoolean();
    }
}
