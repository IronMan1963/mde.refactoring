package mde.refactoring.suite;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.eclipse.epsilon.egl.EgxModule;
import org.eclipse.epsilon.eol.IEolModule;
import org.eclipse.epsilon.eol.models.IModel;

import mde.refactoring.epsilon.EpsilonStandalone;


public class EGXStandalone extends EpsilonStandalone{
	
	private static final String inputPath = "input/";
	private static final String enginePath = "engine/binder.egx";
	private static final String sourceAlias = "source";
	private static final String ecoreMM = "resources/Ecore.ecore";
	private static String inputModel = "example1_Domain.ecore";

	public static void main(String[] args) throws Exception {
		System.out.print("Domain Metamodel name: ");
		inputModel = new Scanner(System.in).nextLine();
		new EGXStandalone().execute();
	}
	
	@Override
	public IEolModule createModule() {		
		return new EgxModule();
	}

	@Override
	public List<IModel> getModels() throws Exception {
		List<IModel> models = new ArrayList<IModel>();
		models.add(createEmfModel(sourceAlias, inputPath + inputModel, ecoreMM, true, false));
		return models;
	}

	@Override
	public String getSource() throws Exception {
		return enginePath;
	}

	@Override
	public void postProcess() {
	}
}

// TODO: ConsoleUserInput.chooseMany() is not implemented in Epsilon Java Engine!!