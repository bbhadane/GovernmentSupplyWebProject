package com.swt;
import org.apache.log4j.Logger;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class GovernmentSupplySwt extends Shell{
	
	public static void main(String[] args) {
		try{
			Display display =  Display.getDefault(); //Display listens to event and generates event loops
		
			GovernmentSupplySwt shell=new GovernmentSupplySwt(display); //Shell is th window that is displayed...It will listen from the event queue named display
		
		shell.layout();
		shell.open();
		while(!shell.isDisposed())
		{
			if(!display.readAndDispatch()) //Read an event from display and dispatch it to the shell
			{
				display.sleep();
			}
		}
		display.dispose();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	
	}

	public static final Logger logger= Logger.getRootLogger();
	public GovernmentSupplySwt(Display display) {
		super(display,SWT.SHELL_TRIM);
		createContents();
	}
	private void createContents() {
		// TODO Auto-generated method stub
		
	}
	
	}


