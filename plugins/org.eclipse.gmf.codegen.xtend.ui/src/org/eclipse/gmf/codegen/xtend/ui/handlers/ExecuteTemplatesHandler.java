package org.eclipse.gmf.codegen.xtend.ui.handlers;

import java.io.IOException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.codegen.util.MergeFileSystemAccess;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class ExecuteTemplatesHandler extends AbstractHandler implements IHandler {

	@Inject
	private IGenerator generator;

	@Inject
	private Provider<MergeFileSystemAccess> fileAccessProvider;

	@Inject
	IResourceDescriptions resourceDescriptions;

	@Inject
	IResourceSetProvider resourceSetProvider;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		if (selection instanceof IStructuredSelection) {
			Object firstElement = ((IStructuredSelection) selection).getFirstElement();
			if (firstElement instanceof IFile) {
				IFile file = (IFile) firstElement;
				IProject project = file.getProject();
//				IFolder srcGenFolder = project.getFolder("src-gen");
//
//				if (!srcGenFolder.exists()) {
//					try {
//						srcGenFolder.create(true, true, new NullProgressMonitor());
//					} catch (CoreException e) {
//						return null;
//					}
//				}

				final MergeFileSystemAccess fsa = fileAccessProvider.get();
				
				URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), false);
				Resource resource =  resourceSetProvider.get(project).createResource(uri);			

				try {
					resource.load(null);
				} catch (IOException e) {
					e.printStackTrace();
				}

				if (resource.isLoaded()) {					
					generator.doGenerate(resource, fsa);
				}
			}
		}

		return null;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}