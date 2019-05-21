package swing.police;

import swing.police.gui.AlarmHandler;
import swing.police.gui.PoliceMainFrame;

import javax.swing.*;
import java.util.Random;

public class Main {

	public static void main(String[] args) {

		VolantiManager vm = new VolantiManager();

		Random random = new Random();
		random.ints(0,6)
				.distinct()
				.limit(random.nextInt(6))
				.forEach(i -> vm.addVolante(new Volante(i)));

		System.out.println(vm.toString());

		PoliceMainFrame pf = new PoliceMainFrame();
		AlarmHandler h = new AlarmHandler(vm,pf);
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				pf.initGUI(h);
			}
		});

	}

}
