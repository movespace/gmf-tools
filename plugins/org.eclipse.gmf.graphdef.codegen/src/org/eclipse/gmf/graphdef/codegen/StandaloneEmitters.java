/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Michael Golubev (Borland) - initial API and implementation
 *    Artem Tikhomirov (Borland) - migrating JET-Xpand
 */
package org.eclipse.gmf.graphdef.codegen;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.common.UnexpectedBehaviourException;
import org.eclipse.gmf.graphdef.codegen.StandaloneGenerator.Config;
import org.eclipse.gmf.internal.common.codegen.TextEmitter;
import org.eclipse.gmf.internal.graphdef.codegen.Activator;
import org.eclipse.gmf.internal.xpand.BufferOutput;
import org.eclipse.gmf.internal.xpand.XpandFacade;
import org.eclipse.gmf.internal.xpand.expression.Variable;

class StandaloneEmitters {
	private final MapModeCodeGenStrategy myMapModeStrategy;

	StandaloneEmitters(MapModeCodeGenStrategy mapModeStrategy) {
		myMapModeStrategy = mapModeStrategy;
	}
	
	public TextEmitter getBuildPropertiesEmitter() throws UnexpectedBehaviourException {
		return new XpandTextEmitter(myMapModeStrategy) {
			public String generate(IProgressMonitor monitor, Object[] arguments) throws InterruptedException, InvocationTargetException, UnexpectedBehaviourException {
				StringBuilder result = new StringBuilder();
				createEngine(result).evaluate("plugin::BuildProperties::Init", new Object(), null);
				return result.toString();
			}
		};
	}
	
	public TextEmitter getPluginPropertiesEmitter() throws UnexpectedBehaviourException {
		return new XpandTextEmitter(myMapModeStrategy) {
			public String generate(IProgressMonitor monitor, Object[] arguments) throws InterruptedException, InvocationTargetException, UnexpectedBehaviourException {
				assert arguments != null && arguments.length > 0 && arguments[0] instanceof Config;
				Config config = (Config) arguments[0];
				StringBuilder result = new StringBuilder();
				Object[] params = new Object[] {
					config.getPluginFriendlyName(),
					config.getPluginProviderName()
				};
				createEngine(result).evaluate("plugin::PluginProperties::Init", new Object(), params);
				return result.toString();
			}
		};
	}
	
	public TextEmitter getManifestMFEmitter() throws UnexpectedBehaviourException {
		return new XpandTextEmitter(myMapModeStrategy) {
			public String generate(IProgressMonitor monitor, Object[] arguments) throws InterruptedException, InvocationTargetException, UnexpectedBehaviourException {
				assert arguments != null && arguments.length > 0 && arguments[0] instanceof Object[];
				Object[] actualArgs = (Object[]) arguments[0];
				assert actualArgs.length > 1 && actualArgs[0] instanceof Config && actualArgs[1] instanceof String[];
				Config config = (Config) actualArgs[0];
				List<String> requiredBundles = new LinkedList<String>();
				if (config.needsMapMode()) {
					requiredBundles.add("org.eclipse.gmf.runtime.draw2d.ui");
				}
				requiredBundles.addAll(Arrays.asList((String[]) actualArgs[1]));
				List<String> exportedPackages = (config.getMainPackageName() == null || config.getMainPackageName().trim().length() == 0) ? Collections.singletonList(config.getPluginActivatorPackageName()) : Arrays.asList(config.getPluginActivatorPackageName(), config.getMainPackageName());
				StringBuilder result = new StringBuilder();
				Object[] params = new Object[] {
					config.getPluginID(),
					config.getPluginActivatorPackageName() + '.' + config.getPluginActivatorClassName(),
					exportedPackages,
					requiredBundles,
				};
				createEngine(result).evaluate("plugin::Manifest::Init", new Object(), params);
				return result.toString();
			}
		};
	}
	
	public TextEmitter getPluginActivatorEmitter() throws UnexpectedBehaviourException {
		return new XpandTextEmitter(myMapModeStrategy) {
			public String generate(IProgressMonitor monitor, Object[] arguments) throws InterruptedException, InvocationTargetException, UnexpectedBehaviourException {
				// we do not use ImportAssistant argument
				assert arguments != null && arguments.length > 0 && arguments[0] instanceof Object[];
				Config config = (Config) ((Object[]) arguments[0])[0];
				StringBuilder result = new StringBuilder();
				Object[] params = new Object[] {
					config.getPluginActivatorPackageName(),
					config.getPluginActivatorClassName(),
					config.getPluginID(),
				};
				createEngine(result).evaluate("plugin::Activator::Init", new Object(), params);
				return result.toString();
			}
		};
	}

	private static abstract class XpandTextEmitter implements TextEmitter {
		protected final MapModeCodeGenStrategy myMapModeStrategy;

		protected XpandTextEmitter(MapModeCodeGenStrategy mapModeStrategy) {
			myMapModeStrategy = mapModeStrategy;
		}

		protected XpandFacade createEngine(StringBuilder result) {
			final Map<String, StringBuilder> slots = Collections.emptyMap();
			final List<Variable> globals = Collections.emptyList();
			return Activator.createTemplateEngine(myMapModeStrategy, new BufferOutput(result, slots), globals);
		}
	}
}
